package com.stepos.ailauncher.chat.view;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/a4;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "receive", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Z)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.a4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2760a4 {
    public static final C2760a4 INSTANCE = new C2760a4();

    public final boolean a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.windowIsTranslucent, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    public final int b(Context context, boolean receive) {
        kotlin.jvm.internal.p.i(context, "context");
        if (a(context)) {
            return androidx.core.content.a.c(context, R$color.chat_message_text_on_glass);
        }
        return androidx.core.content.a.c(context, receive ? R$color.chat_message_receive_text : R$color.chat_message_sent_text);
    }
}
