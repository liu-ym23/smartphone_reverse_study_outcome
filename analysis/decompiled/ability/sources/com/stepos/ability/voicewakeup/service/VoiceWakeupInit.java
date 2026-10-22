package com.stepos.ability.voicewakeup.service;

import D7.N;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\f"}, d2 = {"Lcom/stepos/ability/voicewakeup/service/VoiceWakeupInit;", "Lcom/stepos/ability/api/init/IInit;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "LC7/r;", "migrateLegacyLayoutIfNeeded", "init", "Landroid/content/Context;", "Companion", "com/stepos/ability/voicewakeup/service/m", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceWakeupInit implements IInit {
    public static final m Companion = new m();
    private static final String TAG = "VoiceWakeupInit";
    private final Context context;

    @Inject
    public VoiceWakeupInit(@ApplicationContext Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        this.context = context;
    }

    private final void migrateLegacyLayoutIfNeeded(Context context) {
        Object objA;
        Object objA2;
        String string;
        kotlin.jvm.internal.k.f(context, "context");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0);
        String str = null;
        if (!sharedPreferences.contains("trained_ids") && (string = sharedPreferences.getString("active_word_id", null)) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                String string2 = sharedPreferences.getString("active_word_keyphrase", "");
                String str2 = string2 != null ? string2 : "";
                Log.i("WakeupWordStorage", "migrateLegacyIfNeeded id=" + string + " keyphraseLen=" + str2.length());
                sharedPreferences.edit().putStringSet("trained_ids", N.Q(string)).putString("keyphrase_".concat(string), str2).apply();
                str = string;
            }
        }
        if (str == null) {
            return;
        }
        File file = new File(context.getFilesDir(), "user_wakeup.udm");
        File file2 = new File(context.getFilesDir(), B7.a.m("user_wakeup_", str, ".udm"));
        if (!file.exists() || file.length() == 0) {
            Log.w(TAG, "migrateLegacyLayout: legacy UDM missing, only SP migrated");
            return;
        }
        if (file2.exists() && file2.length() > 0) {
            try {
                file.delete();
                return;
            } catch (Throwable th) {
                kotlin.b.a(th);
                return;
            }
        }
        try {
            objA = Boolean.valueOf(file.renameTo(file2));
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        if (((Boolean) objA).booleanValue()) {
            Log.i(TAG, "migrateLegacyLayout: renamed to " + file2.getName());
            return;
        }
        try {
            O7.i.S(file, file2);
            objA2 = file2;
        } catch (Throwable th3) {
            objA2 = kotlin.b.a(th3);
        }
        if (objA2 instanceof Result.Failure) {
            Log.e(TAG, "migrateLegacyLayout: rename/copy failed for wordId=".concat(str));
            return;
        }
        try {
            file.delete();
        } catch (Throwable th4) {
            kotlin.b.a(th4);
        }
        Log.i(TAG, "migrateLegacyLayout: copied to " + file2.getName());
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        Log.i(TAG, "init: preparing ListenModelTrainer Loader");
        C7.f fVar = C4.h.f297a;
        kotlin.jvm.internal.k.e(context.getApplicationContext(), "getApplicationContext(...)");
        E4.a.f472a.a(context);
        migrateLegacyLayoutIfNeeded(context);
        l lVar = l.f3333a;
        l.o(true, new F6.c(context, 1));
        l.t();
    }
}
