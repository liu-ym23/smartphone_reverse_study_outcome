package com.stepos.agentframework.chatui.history;

import android.R;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/history/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/agentframework/chatui/history/g;", "item", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/history/g;)V", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "", "mData", "Ljava/lang/Object;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e extends RecyclerView.ViewHolder {
    private Object mData;
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View itemView) {
        super(itemView);
        p.i(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.text1);
        p.h(viewFindViewById, "findViewById(...)");
        this.textView = (TextView) viewFindViewById;
    }

    public static final void c(DrawerTitleItem drawerTitleItem, e eVar, View view) {
        p9.p pVarA = drawerTitleItem.a();
        p.f(pVarA);
        pVarA.invoke("normal", eVar.mData);
    }

    public final <T> void b(final DrawerTitleItem<T> item) {
        p.i(item, "item");
        Log.i("DrawerNormalTitleHolder", "bind sessionKind: " + item.getSessionKind());
        String str = item.getSessionKind() == ConversationSessionKind.MAIN.getCode() ? "[主会话]" : item.getSessionKind() == ConversationSessionKind.CHANNEL.getCode() ? "[渠道]" : "";
        this.textView.setText(str + item.getTitle());
        this.mData = item.b();
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.history.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.c(item, this, view);
            }
        });
    }
}
