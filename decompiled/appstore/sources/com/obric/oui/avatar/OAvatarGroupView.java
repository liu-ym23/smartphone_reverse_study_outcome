package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/avatar/OAvatar;", "getTopAvatar", "()Lcom/obric/oui/avatar/OAvatar;", "getUnderAvatar", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarGroupSize", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;)V", "avatar", "", "borderWidth", "g", "(Lcom/obric/oui/avatar/OAvatar;Lcom/obric/oui/avatar/OAvatar$AvatarSize;I)V", "a", "Lcom/obric/oui/avatar/OAvatar;", "underAvatar", "b", "topAvatar", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OAvatar f12360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OAvatar f12361b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12362a = null;

        static {
            int[] r10 = new int[OAvatar.AvatarSize.values().length];
            r10[OAvatar.AvatarSize.DP_24.ordinal()] = 1;
            r10[OAvatar.AvatarSize.DP_32.ordinal()] = 2;
            r10[OAvatar.AvatarSize.DP_40.ordinal()] = 3;
            r10[OAvatar.AvatarSize.DP_48.ordinal()] = 4;
            r10[OAvatar.AvatarSize.DP_56.ordinal()] = 5;
            r10[OAvatar.AvatarSize.DP_64.ordinal()] = 6;
            r10[OAvatar.AvatarSize.DP_72.ordinal()] = 7;
            f12362a = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatarGroupView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public final void g(OAvatar r10, OAvatar.AvatarSize r11, int r12) {
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L7;
        int r14 = r12 * 2;
        r13.width = f.r(this, r11.getDpValue()) + r14;
        r13.height = r14 + f.r(this, r11.getDpValue());
        r10.setLayoutParams(r13);
        r10.setAvatarInset(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final OAvatar getTopAvatar() {
        return this.f12361b;
    }

    @NotNull
    public final OAvatar getUnderAvatar() {
        return this.f12360a;
    }

    public final void setAvatarGroupSize(@NotNull OAvatar.AvatarSize r10) {
        q.g(r10, "size");
        switch(a.f12362a[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.AvatarSize r11 = OAvatar.AvatarSize.DP_48;
    L14:
        if (r10.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L17;
        int r12 = 3;
    L16:
        int r13 = f.r(this, r12);
        g(this.f12361b, r11, r13);
        g(this.f12360a, r11, r13);
        ViewGroup.LayoutParams r14 = getLayoutParams();
        if (r14 == null) goto L23;
        r14.height = f.r(this, r10.getDpValue());
        r14.width = f.r(this, r10.getDpValue());
        setLayoutParams(r14);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        r12 = 2;
        goto L16
    L7:
        r11 = OAvatar.AvatarSize.DP_40;
        goto L14
    L8:
        r11 = OAvatar.AvatarSize.DP_40;
        goto L14
    L9:
        r11 = OAvatar.AvatarSize.DP_32;
        goto L14
    L10:
        r11 = OAvatar.AvatarSize.DP_24;
        goto L14
    L11:
        r11 = OAvatar.AvatarSize.DP_20;
        goto L14
    L12:
        r11 = OAvatar.AvatarSize.DP_16;
        goto L14
    L5:
        throw new IllegalArgumentException(q.p("disallow the size: ", r10));
    }

    public /* synthetic */ OAvatarGroupView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OAvatarGroupView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_widget_avatar_group, this);
        View r12 = findViewById(R$id.under_avatar);
        q.f(r12, "findViewById(R.id.under_avatar)");
        this.f12360a = (OAvatar) r12;
        View r13 = findViewById(R$id.top_avatar);
        q.f(r13, "findViewById(R.id.top_avatar)");
        this.f12361b = (OAvatar) r13;
    }
}
