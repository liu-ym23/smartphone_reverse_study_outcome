package com.stepos.agentframework.chatui.appui;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.widget.AppCompatTextView;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/h;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, null);
        p.i(context, "context");
        setBackgroundColor(Color.parseColor("#F5F5F5"));
        setTextColor(-65536);
        setTextSize(17.0f);
        int iA = O6.d.INSTANCE.a(ChatCoreSdk.INSTANCE.c(), 16.0f);
        setPadding(iA, iA, iA, iA);
    }
}
