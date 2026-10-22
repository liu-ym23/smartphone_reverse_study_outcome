package com.android.contacts.recyclebin;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.detail.item.AbsContactItemCard;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.widget.AvatarImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RecycleListItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010%\u001a\u00020&H\u0016J\f\u0010'\u001a\u00020\u0003*\u00020\u0003H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u0006)"}, d2 = {"Lcom/android/contacts/recyclebin/RecycleListItemView;", "Lcom/android/contacts/detail/item/AbsContactItemCard;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarFrame", "Landroid/widget/RelativeLayout;", "getAvatarFrame", "()Landroid/widget/RelativeLayout;", "setAvatarFrame", "(Landroid/widget/RelativeLayout;)V", "callingApplicationLabel", "Landroid/widget/TextView;", "getCallingApplicationLabel", "()Landroid/widget/TextView;", "setCallingApplicationLabel", "(Landroid/widget/TextView;)V", "checkBoxFrame", "getCheckBoxFrame", "setCheckBoxFrame", "name", "getName", "setName", BlackListQueryHandler.KEY_PHOTO, "Lcom/android/contacts/widget/AvatarImageView;", "getPhoto", "()Lcom/android/contacts/widget/AvatarImageView;", "setPhoto", "(Lcom/android/contacts/widget/AvatarImageView;)V", "primaryData", "getPrimaryData", "setPrimaryData", "recycleDate", "getRecycleDate", "setRecycleDate", "initData", "", "withRecycleItemScaleLimit", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecycleListItemView extends AbsContactItemCard {
    public static final Companion Companion = null;
    private static final float MAX_DENSITY = 3.5f;
    private static final float MAX_FONT_SCALE = 1.125f;
    private RelativeLayout avatarFrame;
    private TextView callingApplicationLabel;
    private RelativeLayout checkBoxFrame;
    private TextView name;
    private AvatarImageView photo;
    private TextView primaryData;
    private TextView recycleDate;

    /* JADX INFO: compiled from: RecycleListItemView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/recyclebin/RecycleListItemView$Companion;", "", "()V", "MAX_DENSITY", "", "MAX_FONT_SCALE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecycleListItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.avatarFrame = (RelativeLayout) findViewById(R.id.photo_frame);
        this.checkBoxFrame = (RelativeLayout) findViewById(R.id.checkBoxFrame);
        this.name = (TextView) findViewById(R.id.name);
        this.primaryData = (TextView) findViewById(R.id.primary_data);
        this.recycleDate = (TextView) findViewById(R.id.recycle_date);
        this.callingApplicationLabel = (TextView) findViewById(R.id.calling_application_label);
        this.photo = getAvatarPhoto();
        setShowAvatarContainer(true);
        showDivider(true);
        setShowCardBg(false);
    }

    public /* synthetic */ RecycleListItemView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final RelativeLayout getAvatarFrame() {
        return this.avatarFrame;
    }

    public final void setAvatarFrame(RelativeLayout r1) {
        this.avatarFrame = r1;
    }

    public final RelativeLayout getCheckBoxFrame() {
        return this.checkBoxFrame;
    }

    public final void setCheckBoxFrame(RelativeLayout r1) {
        this.checkBoxFrame = r1;
    }

    public final TextView getName() {
        return this.name;
    }

    public final void setName(TextView r1) {
        this.name = r1;
    }

    public final TextView getPrimaryData() {
        return this.primaryData;
    }

    public final void setPrimaryData(TextView r1) {
        this.primaryData = r1;
    }

    public final TextView getRecycleDate() {
        return this.recycleDate;
    }

    public final void setRecycleDate(TextView r1) {
        this.recycleDate = r1;
    }

    public final TextView getCallingApplicationLabel() {
        return this.callingApplicationLabel;
    }

    public final void setCallingApplicationLabel(TextView r1) {
        this.callingApplicationLabel = r1;
    }

    public final AvatarImageView getPhoto() {
        return this.photo;
    }

    public final void setPhoto(AvatarImageView r1) {
        this.photo = r1;
    }

    @Override // com.android.contacts.detail.item.AbsContactItemCard
    public void initData() {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        View r1 = LayoutInflater.from(withRecycleItemScaleLimit(r0)).inflate(R.layout.contact_recycle_list_item, this, false);
        if (r1 == null) goto L5;
        setCenterContainer(r1);
    L5:
        ViewGroup r2 = getItemTitleContainer();
        if (r2 == null) goto L8;
        r2.setPadding(r2.getPaddingLeft(), 0, r2.getPaddingRight(), 0);
    L8:
        setCardType(0);
    }

    private final Context withRecycleItemScaleLimit(Context r3) {
        Configuration r2 = new Configuration(r3.getResources().getConfiguration());
        r2.fontScale = RangesKt.coerceAtMost(r2.fontScale, MAX_FONT_SCALE);
        r2.densityDpi = (int) (RangesKt.coerceAtMost(r3.getResources().getDisplayMetrics().density, MAX_DENSITY) * 160);
        Context r4 = r3.createConfigurationContext(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "createConfigurationContext(configuration)");
        return r4;
    }
}
