package com.stepos.ailauncher.oobe;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;
import o6.C5009a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/oobe/O;", "", "<init>", "()V", "", "text", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "e", "", "", "TRAILING_ASR_PUNCTUATION", "Ljava/util/Set;", "initNicknameVal", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "", "initStyleList", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Set;)V", "initUserCustom", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O {
    public static final O INSTANCE = new O();
    private static final Set<Character> TRAILING_ASR_PUNCTUATION = Z8.Y.j(12290, 65292, 12289, 65307, 65306, 65281, 65311, 8230, '.', ',', ';', ':', '!', '?');
    private static String initNicknameVal = "";
    private static Set<String> initStyleList = new LinkedHashSet();
    private static String initUserCustom = "";

    public final String a() {
        return initNicknameVal;
    }

    public final Set<String> b() {
        return initStyleList;
    }

    public final String c() {
        return initUserCustom;
    }

    public final void d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Intent intent = new Intent();
            intent.setPackage("com.stepos.setup");
            intent.setComponent(new ComponentName("com.stepos.setup", "com.stepos.setup.activity.SetupServiceActivity"));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
            Toast.makeText(context, "未找到指定应用", 0).show();
        }
    }

    public final void e(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (C5009a.g(C5009a.INSTANCE, AuthManager.KEY_VOICE_TRAINING, false, false, 6, null)) {
            context.startActivity(new Intent(context, (Class<?>) RecordWakeWordActivity.class));
        } else {
            context.startActivity(new Intent(context, (Class<?>) SdkInitNameActivity.class));
        }
    }

    public final void f(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        initNicknameVal = str;
    }

    public final void g(Set<String> set) {
        kotlin.jvm.internal.p.i(set, "<set-?>");
        initStyleList = set;
    }

    public final void h(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        initUserCustom = str;
    }

    public final String i(String text) {
        String strSubstring;
        kotlin.jvm.internal.p.i(text, "text");
        int iN0 = La.H.n0(text);
        while (true) {
            if (-1 >= iN0) {
                strSubstring = "";
                break;
            }
            if (!TRAILING_ASR_PUNCTUATION.contains(Character.valueOf(text.charAt(iN0)))) {
                strSubstring = text.substring(0, iN0 + 1);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                break;
            }
            iN0--;
        }
        return La.H.F1(strSubstring).toString();
    }
}
