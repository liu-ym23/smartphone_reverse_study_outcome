package com.stepos.agentframework.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/util/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "text", "label", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.util.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2155d {
    public static final C2155d INSTANCE = new C2155d();

    public static /* synthetic */ void b(C2155d c2155d, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "agent";
        }
        c2155d.a(context, str, str2);
    }

    public final void a(Context context, String text, String label) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(label, "label");
        Object systemService = context.getSystemService("clipboard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(label, text));
    }
}
