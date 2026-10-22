package com.obric.oui.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.contacts.obricsync.SyncContractKt;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAvatarGroupView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "topAvatar", "Lcom/obric/oui/avatar/OAvatar;", "underAvatar", "configAvatar", "", SyncContractKt.COLUMN_AVATAR, PerfConsts.PERF_DISK_FILE_SIZE, "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "borderWidth", "", "getTopAvatar", "getUnderAvatar", "setAvatarGroupSize", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarGroupView extends ConstraintLayout {
    private final OAvatar topAvatar;
    private final OAvatar underAvatar;

    /* JADX INFO: compiled from: OAvatarGroupView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OAvatar.AvatarSize.values().length];
            r0[OAvatar.AvatarSize.DP_24.ordinal()] = 1;
            r0[OAvatar.AvatarSize.DP_32.ordinal()] = 2;
            r0[OAvatar.AvatarSize.DP_40.ordinal()] = 3;
            r0[OAvatar.AvatarSize.DP_48.ordinal()] = 4;
            r0[OAvatar.AvatarSize.DP_56.ordinal()] = 5;
            r0[OAvatar.AvatarSize.DP_64.ordinal()] = 6;
            r0[OAvatar.AvatarSize.DP_72.ordinal()] = 7;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarGroupView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatarGroupView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OAvatarGroupView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ConstraintLayout.inflate(r2, R.layout.o_widget_avatar_group, this);
        View r4 = findViewById(R.id.under_avatar);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.under_avatar)");
        this.underAvatar = (OAvatar) r4;
        View r5 = findViewById(R.id.top_avatar);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.top_avatar)");
        this.topAvatar = (OAvatar) r5;
    }

    public final OAvatar getTopAvatar() {
        return this.topAvatar;
    }

    public final OAvatar getUnderAvatar() {
        return this.underAvatar;
    }

    public final void setAvatarGroupSize(OAvatar.AvatarSize r4) {
        Intrinsics.checkNotNullParameter(r4, PerfConsts.PERF_DISK_FILE_SIZE);
        switch(WhenMappings.$EnumSwitchMapping$0[r4.ordinal()]) {
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
        OAvatar.AvatarSize r0 = OAvatar.AvatarSize.DP_48;
    L14:
        if (r4.getDpValue() < OAvatar.AvatarSize.DP_56.getDpValue()) goto L16;
        OAvatarGroupView r1 = this;
        int r2 = 3;
    L17:
        int r3 = OUnitExtensionKt.vdp(r1, r2);
        configAvatar(this.topAvatar, r0, r3);
        configAvatar(this.underAvatar, r0, r3);
        OAvatarGroupView r5 = this;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L22;
        r6.height = OUnitExtensionKt.vdp(r5, r4.getDpValue());
        r6.width = OUnitExtensionKt.vdp(r5, r4.getDpValue());
        r5.setLayoutParams(r6);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        r1 = this;
        r2 = 2;
        goto L17
    L7:
        r0 = OAvatar.AvatarSize.DP_40;
        goto L14
    L8:
        r0 = OAvatar.AvatarSize.DP_40;
        goto L14
    L9:
        r0 = OAvatar.AvatarSize.DP_32;
        goto L14
    L10:
        r0 = OAvatar.AvatarSize.DP_24;
        goto L14
    L11:
        r0 = OAvatar.AvatarSize.DP_20;
        goto L14
    L12:
        r0 = OAvatar.AvatarSize.DP_16;
        goto L14
    L5:
        throw new IllegalArgumentException(Intrinsics.stringPlus("disallow the size: ", r4));
    }

    private final void configAvatar(OAvatar r5, OAvatar.AvatarSize r6, int r7) {
        OAvatar r0 = r5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        int r2 = r7 * 2;
        OAvatarGroupView r4 = this;
        r1.width = OUnitExtensionKt.vdp(r4, r6.getDpValue()) + r2;
        r1.height = r2 + OUnitExtensionKt.vdp(r4, r6.getDpValue());
        r0.setLayoutParams(r1);
        r5.setAvatarInset(r7);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
