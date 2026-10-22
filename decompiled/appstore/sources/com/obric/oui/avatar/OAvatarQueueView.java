package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/obric/oui/avatar/OAvatar;", "getAvatars", "()Ljava/util/List;", "Landroid/graphics/drawable/Drawable;", "drawables", "", "setAvatars", "(Ljava/util/List;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueView extends ConstraintLayout {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatarQueueView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<OAvatar> getAvatars() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = ViewGroupKt.a(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        View r12 = (View) r11.next();
        if ((r12 instanceof OAvatar) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    public final void setAvatars(@NotNull List<? extends Drawable> r10) {
        q.g(r10, "drawables");
        int r11 = 0;
        Iterator<T> r12 = r10.subList(0, 5).iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L8;
        t.q();
    L8:
        Drawable r15 = (Drawable) r13;
        View r16 = getChildAt(r11);
        if (r16 == null) goto L12;
        ((OAvatar) r16).getContentImageView().setImageDrawable(r15);
        r11 = r14;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
    }

    public /* synthetic */ OAvatarQueueView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OAvatarQueueView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_widget_avatar_queue, this);
    }
}
