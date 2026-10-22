package com.stepos.agentframework.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "", "text", "chooserTitle", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class F {
    public static final void a(Context context, String text, String chooserTitle) {
        kotlin.jvm.internal.p.i(context, "<this>");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(chooserTitle, "chooserTitle");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", text);
            intent.setType(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B);
            Intent intentCreateChooser = Intent.createChooser(intent, chooserTitle);
            intentCreateChooser.addFlags(402653184);
            context.startActivity(intentCreateChooser);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "没有找到可以分享的应用", 0).show();
        }
    }

    public static /* synthetic */ void b(Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "分享到";
        }
        a(context, str, str2);
    }
}
