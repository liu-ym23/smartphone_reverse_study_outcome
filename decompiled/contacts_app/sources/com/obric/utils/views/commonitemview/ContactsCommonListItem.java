package com.obric.utils.views.commonitemview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsCommonListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0002lmB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020-J\b\u00101\u001a\u0004\u0018\u00010\nJ\b\u00102\u001a\u0004\u0018\u00010\rJ\u0006\u00103\u001a\u00020\u0016J\b\u00104\u001a\u0004\u0018\u00010\u0011J\b\u00105\u001a\u0004\u0018\u00010\u0011J\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u0012\u00107\u001a\u00020/2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00108\u001a\u00020\u001bJ\u0010\u00109\u001a\u00020/2\b\u0010:\u001a\u0004\u0018\u00010;J\u0015\u00109\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010=J\u0015\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\u001bJ\u000e\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020/2\u0006\u00108\u001a\u00020\u001bJ\u0006\u0010H\u001a\u00020/J\u0006\u0010I\u001a\u00020/J\u0010\u0010J\u001a\u00020/2\b\u0010K\u001a\u0004\u0018\u00010FJ\u0010\u0010L\u001a\u00020/2\b\u0010M\u001a\u0004\u0018\u00010FJ\u0010\u0010N\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010OJ\u000e\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\u001bJ\u0016\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001bJ\u000e\u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020\u001bJ\u0015\u0010U\u001a\u00020/2\b\u0010V\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020/2\u0006\u0010X\u001a\u00020FJ\u0010\u0010Y\u001a\u00020/2\b\u0010Z\u001a\u0004\u0018\u00010[J,\u0010\\\u001a\u00020]2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_2\u0016\b\u0002\u0010a\u001a\u0010\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020/\u0018\u00010bJ\u0015\u0010c\u001a\u00020/2\b\u0010d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010=J\u000e\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020FJ\u0006\u0010g\u001a\u00020/J\u0012\u0010h\u001a\u00020/2\b\u0010i\u001a\u0004\u0018\u00010[H\u0016J\u000e\u0010j\u001a\u00020/2\u0006\u0010T\u001a\u00020\u001bJ\u000e\u0010k\u001a\u00020/2\u0006\u0010T\u001a\u00020\u001bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarPhoto", "Lcom/android/contacts/widget/AvatarImageView;", "kotlin.jvm.PlatformType", "blacklistPhoto", "Landroid/widget/ImageView;", "centerSubtitleContainer", "Landroid/view/ViewGroup;", "centerSubtitleText", "Landroid/widget/TextView;", "centerTitleContainer", "centerTitleText", "commonAvatarLayout", "commonCheckBox", "Lcom/obric/utils/views/commonitemview/ContactsOCheckBoxLayout;", "contentContainer", "defaultCenterContainer", "Landroid/widget/LinearLayout;", "value", "", "isInSwipeAction", "()Z", "setInSwipeAction", "(Z)V", "itemEndContainer", "itemHeaderContainer", "itemStartContainer", "itemSwipeContainer", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "itemTailIcon", "itemTitleContainer", "getItemTitleContainer", "()Landroid/view/ViewGroup;", "setItemTitleContainer", "(Landroid/view/ViewGroup;)V", "originSwipeEnabled", "swipeStatusListener", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$SwipeStatusListener;", "addSwipeListener", "", "listener", "getAvatarPhoto", "getBlacklistPhoto", "getCheckBox", "getDefaultSubtitleText", "getDefaultTitleText", "getItemEndContainer", "initTypedArray", "isChecked", "setAvatarPhoto", BlackListQueryHandler.KEY_PHOTO, "Landroid/graphics/Bitmap;", "icon", "(Ljava/lang/Integer;)V", "setAvatarPhotoId", "photoId", "", "(Ljava/lang/Long;)V", "setAvatarStrokeVisible", "visible", "setCenterContainer", "centerContainer", "Landroid/view/View;", "setChecked", "setDisableClick", "setEndContainerWidthWrap", "setItemEndContainer", "endView", "setItemStartContainer", "startView", "setOnClickListener", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$ContactsCommonListItemClickListener;", "setSelectedMode", "isSelectedMode", "hideIcon", "setShowAvatarContainer", "show", "setSubtitleColor", "subtitleColor", "setSubtitleContainer", "subtitleContainer", "setSubtitleText", "subtitleText", "", "setSwipeItemButtonView", "Lcom/obric/utils/views/commonitemview/SwipeItemView;", "swipeBtnList", "", "Lcom/obric/utils/views/commonitemview/bean/SwipeItemButtonType;", "swipeListener", "Lkotlin/Function1;", "setTitleColor", "titleColor", "setTitleContainer", "titleContainer", "setTitleContainerWidthSpread", "setTitleText", "titleText", "showSubtitleContainer", "showTitleContainer", "ContactsCommonListItemClickListener", "SwipeStatusListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ContactsCommonListItem extends OCardListItem {
    private final AvatarImageView avatarPhoto;
    private final ImageView blacklistPhoto;
    private final ViewGroup centerSubtitleContainer;
    private final TextView centerSubtitleText;
    private final ViewGroup centerTitleContainer;
    private final TextView centerTitleText;
    private final ViewGroup commonAvatarLayout;
    private final ContactsOCheckBoxLayout commonCheckBox;
    private ViewGroup contentContainer;
    private final LinearLayout defaultCenterContainer;
    private boolean isInSwipeAction;
    private ViewGroup itemEndContainer;
    private final ViewGroup itemHeaderContainer;
    private ViewGroup itemStartContainer;
    private OSwipeLayout itemSwipeContainer;
    private ImageView itemTailIcon;
    private ViewGroup itemTitleContainer;
    private boolean originSwipeEnabled;
    private SwipeStatusListener swipeStatusListener;

    /* JADX INFO: compiled from: ContactsCommonListItem.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$ContactsCommonListItemClickListener;", "", "()V", "onClick", "", "view", "Landroid/view/View;", "onLongClick", "", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "onTouch", "event", "Landroid/view/MotionEvent;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class ContactsCommonListItemClickListener {
        public void onClick(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        public boolean onLongClick(View r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            return false;
        }

        public boolean onTouch(View r1, MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "event");
            return false;
        }

        public ContactsCommonListItemClickListener() {
        }
    }

    /* JADX INFO: compiled from: ContactsCommonListItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/utils/views/commonitemview/ContactsCommonListItem$SwipeStatusListener;", "", "onSwipeStatusChange", "", "isInSwipeAction", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SwipeStatusListener {

        /* JADX INFO: compiled from: ContactsCommonListItem.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onSwipeStatusChange(SwipeStatusListener r0, boolean r1) {
            }
        }

        void onSwipeStatusChange(boolean r1);
    }

    public static /* synthetic */ boolean $r8$lambda$LRcxLPMcFhmT5FjPno1a8YnYfbI(ContactsCommonListItem r0, ContactsCommonListItemClickListener r1, View r2, MotionEvent r3) {
        return setOnClickListener$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$gbo7M5h0lWwA_lD32p61EzAgP9k(ContactsCommonListItem r0, ContactsCommonListItemClickListener r1, View r2) {
        return setOnClickListener$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$oz9JqyTfPYi8yiMzYJ8soXcmzlM(ContactsCommonListItem r0, ContactsCommonListItemClickListener r1, View r2) {
        setOnClickListener$lambda$1(r0, r1, r2);
    }

    public ContactsCommonListItem(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ContactsCommonListItem(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ContactsCommonListItem(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setInSwipeAction(ContactsCommonListItem r0, boolean r1) {
        r0.setInSwipeAction(r1);
    }

    public ContactsCommonListItem(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.originSwipeEnabled = true;
        TextView r1 = null;
        View r8 = LayoutInflater.from(r5).inflate(R.layout.layout_card_item_header_container, null, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        this.itemHeaderContainer = r9;
        ContactsOCheckBoxLayout r0 = (ContactsOCheckBoxLayout) r9.findViewById(R.id.common_check_box);
        r0.setClickable(false);
        r0.setFocusable(false);
        r0.getCheckBox().setClickable(false);
        r0.getCheckBox().setFocusable(false);
        r0.getCheckBox().setVisibility(0);
        this.commonCheckBox = r0;
        this.commonAvatarLayout = (ViewGroup) r9.findViewById(R.id.common_avatar_layout);
        this.avatarPhoto = (AvatarImageView) r9.findViewById(R.id.photo);
        this.blacklistPhoto = (ImageView) r9.findViewById(R.id.blacklist_photo);
        View r10 = LayoutInflater.from(r5).inflate(R.layout.obric_card_item_container, null, false);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r11 = (LinearLayout) r10;
        this.defaultCenterContainer = r11;
        ViewGroup r2 = (ViewGroup) r11.findViewById(R.id.item_center_title_container);
        this.centerTitleContainer = r2;
        if (r2 == null) goto L5;
        TextView r3 = (TextView) r2.findViewById(R.id.title);
    L6:
        this.centerTitleText = r3;
        ViewGroup r4 = (ViewGroup) r11.findViewById(R.id.item_center_subtitle_container);
        this.centerSubtitleContainer = r4;
        if (r4 == null) goto L9;
        r1 = (TextView) r4.findViewById(R.id.sub_title);
    L9:
        this.centerSubtitleText = r1;
        OUICardConstraintLayout r12 = getContentContainer();
        this.contentContainer = r12;
        if (r12 == null) goto L13;
        r12.setClipChildren(false);
    L13:
        ViewGroup r13 = this.contentContainer;
        if (r13 == null) goto L17;
        r13.setClipToPadding(false);
    L17:
        this.itemStartContainer = (ViewGroup) findViewById(R.id.custom_start_container);
        this.itemTitleContainer = (ViewGroup) findViewById(R.id.title_container);
        this.itemEndContainer = (ViewGroup) findViewById(R.id.custom_end_container);
        ViewGroup r14 = this.itemStartContainer;
        if (r14 == null) goto L21;
        r14.setClipChildren(false);
    L21:
        ViewGroup r15 = this.itemStartContainer;
        if (r15 == null) goto L25;
        r15.setClipToPadding(false);
    L25:
        ViewGroup r16 = this.itemTitleContainer;
        if (r16 == null) goto L29;
        r16.setClipChildren(false);
    L29:
        ViewGroup r17 = this.itemEndContainer;
        if (r17 == null) goto L33;
        r17.setClipChildren(false);
    L33:
        ViewGroup r18 = this.itemEndContainer;
        if (r18 == null) goto L37;
        r18.setClipToPadding(false);
    L37:
        this.itemSwipeContainer = getSwipeLayout();
        this.itemTailIcon = (ImageView) findViewById(R.id.tail_icon);
        ViewGroup r19 = this.itemStartContainer;
        if (r19 == null) goto L41;
        r19.setClickable(false);
    L41:
        ViewGroup r20 = this.itemTitleContainer;
        if (r20 == null) goto L45;
        r20.setClipToPadding(false);
    L45:
        setCustomStartView(r9);
        setCenterContainer(r11);
        showIcon(false);
        initTypedArray(r6);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final ViewGroup getItemTitleContainer() {
        return this.itemTitleContainer;
    }

    public final void setItemTitleContainer(ViewGroup r1) {
        this.itemTitleContainer = r1;
    }

    public final boolean isInSwipeAction() {
        return this.isInSwipeAction;
    }

    private final void setInSwipeAction(boolean r1) {
        this.isInSwipeAction = r1;
        SwipeStatusListener r0 = this.swipeStatusListener;
        if (r0 == null) goto L6;
        r0.onSwipeStatusChange(r1);
        return;
    }

    private final void initTypedArray(AttributeSet r6) {
        TypedArray r7 = getContext().obtainStyledAttributes(r6, R.styleable.OCardListItemContainer);
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr…e.OCardListItemContainer)");
        int r0 = r7.getInt(1, 2);
        boolean r2 = r7.getBoolean(12, false);
        r7.recycle();
        OCardListItem.setCardPosition$default(this, r0, false, 2, null);
        setShowCardBg(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SwipeItemView setSwipeItemButtonView$default(ContactsCommonListItem r0, List r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.setSwipeItemButtonView(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSwipeItemButtonView");
    }

    public final SwipeItemView setSwipeItemButtonView(List<? extends SwipeItemButtonType> r4, final Function1<? super SwipeItemButtonType, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "swipeBtnList");
        View r0 = getSwipeView();
        if ((r0 instanceof SwipeItemView) == false) goto L5;
        SwipeItemView r1 = (SwipeItemView) r0;
    L6:
        if (r1 != null) goto L14;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r1 = new SwipeItemView(r2);
        setSwipeView(r1);
        OSwipeLayout r3 = this.itemSwipeContainer;
        if (r3 == null) goto L11;
        r3.setClickToClose(true);
    L11:
        OSwipeLayout r6 = this.itemSwipeContainer;
        if (r6 == null) goto L14;
        r6.addSwipeListener(new AnonymousClass1(this));
    L14:
        r1.setSwipeItemButtonView(r4, new AnonymousClass2(r5));
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void addSwipeListener(SwipeStatusListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.swipeStatusListener = r2;
    }

    public final AvatarImageView getAvatarPhoto() {
        return this.avatarPhoto;
    }

    public final ImageView getBlacklistPhoto() {
        return this.blacklistPhoto;
    }

    public final TextView getDefaultSubtitleText() {
        return this.centerSubtitleText;
    }

    public final TextView getDefaultTitleText() {
        return this.centerTitleText;
    }

    public final void setOnClickListener(final ContactsCommonListItemClickListener r3) {
        setOnContentClickListener(new ContactsCommonListItem$$ExternalSyntheticLambda0(this, r3));
        ViewGroup r0 = this.contentContainer;
        if (r0 == null) goto L5;
        r0.setOnTouchListener(new ContactsCommonListItem$$ExternalSyntheticLambda1(this, r3));
    L5:
        ViewGroup r1 = this.contentContainer;
        if (r1 == null) goto L9;
        r1.setOnLongClickListener(new ContactsCommonListItem$$ExternalSyntheticLambda2(this, r3));
        return;
    }

    private static final void setOnClickListener$lambda$1(ContactsCommonListItem r1, ContactsCommonListItemClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isInSwipeAction() == true) goto L7;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r2.onClick(r3);
        return;
    L8:
        return;
    }

    private static final boolean setOnClickListener$lambda$2(ContactsCommonListItem r5, ContactsCommonListItemClickListener r6, View r7, MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.isInSwipeAction() == false) goto L6;
        return true;
    L6:
        if (r8.getAction() != 0) goto L15;
        int r0 = r8.getActionIndex();
        r7.setTag(R.id.item_touch_position, new int[]{(int) r8.getX(r0), (int) r8.getY(r0)});
        OSwipeLayout r1 = r5.itemSwipeContainer;
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        r5.originSwipeEnabled = r2;
        goto L15
    L10:
        if (r1.isSwipeEnabled() != true) goto L12;
        r2 = true;
    L15:
        if (r8.getAction() != 1) goto L17;
    L18:
        OSwipeLayout r3 = r5.itemSwipeContainer;
        if (r3 == null) goto L22;
        r3.setSwipeEnabled(r5.originSwipeEnabled);
    L22:
        if (r6 == null) goto L25;
        Intrinsics.checkNotNullExpressionValue(r7, "view");
        Intrinsics.checkNotNullExpressionValue(r8, "event");
        return r6.onTouch(r7, r8);
    L25:
        return false;
    L17:
        if (r8.getAction() != 3) goto L22;
        goto L18
    }

    private static final boolean setOnClickListener$lambda$3(ContactsCommonListItem r5, ContactsCommonListItemClickListener r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        boolean r1 = true;
        if (r5.isInSwipeAction() == false) goto L5;
        return true;
    L5:
        Object r0 = r7.getTag(R.id.item_touch_position);
        if ((r0 instanceof int[]) == false) goto L8;
        int[] r2 = (int[]) r0;
    L10:
        if (r2 == null) goto L14;
        Integer r3 = ArraysKt.getOrNull(r2, 0);
        if (r3 == null) goto L14;
        int r4 = r3.intValue();
    L15:
        if (r2 == null) goto L19;
        Integer r8 = ArraysKt.getOrNull(r2, 1);
        if (r8 == null) goto L19;
        int r9 = r8.intValue();
    L20:
        int r10 = r9 - ((int) r7.getY());
        if (r6 == null) goto L25;
        Intrinsics.checkNotNullExpressionValue(r7, "view");
        if (r6.onLongClick(r7, r4, r10) != true) goto L25;
    L26:
        OSwipeLayout r11 = r5.itemSwipeContainer;
        if (r11 == null) goto L30;
        r11.setSwipeEnabled(!r1);
    L30:
        return r1;
    L25:
        r1 = false;
    L19:
        r9 = 0;
    L14:
        r4 = 0;
        goto L15
    L8:
        r2 = null;
        goto L10
    }

    public final void setSelectedMode(boolean r6, boolean r7) {
        ContactsOCheckBoxLayout r0 = this.commonCheckBox;
        Intrinsics.checkNotNullExpressionValue(r0, "commonCheckBox");
        ContactsOCheckBoxLayout r1 = r0;
        int r2 = 8;
        if (r6 == false) goto L5;
        int r8 = 0;
    L6:
        r1.setVisibility(r8);
        ViewGroup r9 = this.commonAvatarLayout;
        Intrinsics.checkNotNullExpressionValue(r9, "commonAvatarLayout");
        ViewGroup r10 = r9;
        if ((!r7) == false) goto L9;
        r2 = 0;
    L9:
        r10.setVisibility(r2);
        ViewGroup r11 = this.commonAvatarLayout;
        Intrinsics.checkNotNullExpressionValue(r11, "commonAvatarLayout");
        if (r11.getVisibility() != 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == true) goto L20;
        ContactsOCheckBoxLayout r13 = this.commonCheckBox;
        Intrinsics.checkNotNullExpressionValue(r13, "commonCheckBox");
        if (r13.getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == true) goto L20;
        showCustomStart(false);
        return;
    L17:
        r14 = false;
    L20:
        showCustomStart(true);
        return;
    L12:
        r12 = false;
        goto L13
    L5:
        r8 = 8;
        goto L6
    }

    public final void setSelectedMode(boolean r4) {
        ContactsOCheckBoxLayout r0 = this.commonCheckBox;
        Intrinsics.checkNotNullExpressionValue(r0, "commonCheckBox");
        ContactsOCheckBoxLayout r1 = r0;
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        r1.setVisibility(r5);
        ViewGroup r6 = this.commonAvatarLayout;
        Intrinsics.checkNotNullExpressionValue(r6, "commonAvatarLayout");
        if (r6.getVisibility() != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L17;
        ContactsOCheckBoxLayout r8 = this.commonCheckBox;
        Intrinsics.checkNotNullExpressionValue(r8, "commonCheckBox");
        if (r8.getVisibility() != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L17;
        showCustomStart(false);
        return;
    L14:
        r9 = false;
    L17:
        showCustomStart(true);
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = 8;
        goto L6
    }

    public final void setChecked(boolean r1) {
        this.commonCheckBox.setChecked(r1);
    }

    public final boolean isChecked() {
        return this.commonCheckBox.isChecked();
    }

    public final ContactsOCheckBoxLayout getCheckBox() {
        ContactsOCheckBoxLayout r1 = this.commonCheckBox;
        Intrinsics.checkNotNullExpressionValue(r1, "commonCheckBox");
        return r1;
    }

    public final void setAvatarPhoto(Bitmap r2) {
        if (r2 == null) goto L8;
        AvatarImageView r0 = this.avatarPhoto;
        if (r0 == null) goto L6;
        r0.setAvatarBitmap(r2);
    L6:
        showCustomStart(true);
        return;
    }

    public final void setAvatarPhoto(Integer r2) {
        if (r2 == null) goto L8;
        r2.intValue();
        AvatarImageView r0 = this.avatarPhoto;
        if (r0 == null) goto L6;
        r0.setImageResource(r2.intValue());
    L6:
        showCustomStart(true);
        return;
    }

    public final void setAvatarPhotoId(Long r3) {
        if (r3 == null) goto L9;
        long r0 = r3.longValue();
        AvatarImageView r4 = this.avatarPhoto;
        if (r4 == null) goto L7;
        r4.setPhotoID(r0);
    L7:
        showCustomStart(true);
        return;
    }

    public final void setAvatarStrokeVisible(boolean r1) {
        AvatarImageView r0 = this.avatarPhoto;
        if (r0 == null) goto L7;
        r0.setStrokeVisible(r1);
        return;
    }

    public final void setShowAvatarContainer(boolean r1) {
        showCustomStart(r1);
        ViewGroup r0 = this.commonAvatarLayout;
        if (r0 == null) goto L11;
        ViewGroup r2 = r0;
        if (r1 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public final void showTitleContainer(boolean r1) {
        ViewGroup r0 = this.centerTitleContainer;
        if (r0 == null) goto L11;
        ViewGroup r2 = r0;
        if (r1 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public final void showSubtitleContainer(boolean r1) {
        ViewGroup r0 = this.centerSubtitleContainer;
        if (r0 == null) goto L11;
        ViewGroup r2 = r0;
        if (r1 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public void setTitleText(String r5) {
        TextView r0 = this.centerTitleText;
        if (r0 == null) goto L17;
        TextView r1 = r0;
        String r2 = r5;
        int r3 = 0;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if ((!r4) == true) goto L16;
        r3 = 8;
    L16:
        r1.setVisibility(r3);
        goto L17
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
    L17:
        TextView r6 = this.centerTitleText;
        if (r6 == null) goto L22;
        r6.setText(r5);
        return;
    }

    public final void setTitleColor(Integer r2) {
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
        TextView r0 = this.centerTitleText;
        if (r0 == null) goto L6;
        r0.setTextColor(r3);
    L6:
        showTitle(true);
        return;
    }

    public final void setSubtitleText(String r5) {
        TextView r0 = this.centerSubtitleText;
        boolean r1 = false;
        if (r0 == null) goto L17;
        TextView r2 = r0;
        String r3 = r5;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if ((!r4) == false) goto L15;
        int r6 = 0;
    L16:
        r2.setVisibility(r6);
        goto L17
    L15:
        r6 = 8;
        goto L16
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
    L17:
        TextView r7 = this.centerSubtitleText;
        if (r7 == null) goto L21;
        r7.setText(r5);
    L21:
        String r8 = r5;
        if (r8 != null) goto L24;
    L25:
        r1 = true;
    L26:
        showSubtitleContainer(!r1);
        return;
    L24:
        if (r8.length() != 0) goto L26;
        goto L25
    }

    public final void setSubtitleColor(Integer r1) {
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
        TextView r0 = this.centerSubtitleText;
        if (r0 == null) goto L8;
        r0.setTextColor(r2);
        return;
    L8:
        return;
    }

    public final void setTitleContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "titleContainer");
        ViewGroup r0 = this.centerTitleContainer;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.centerTitleContainer;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setSubtitleContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "subtitleContainer");
        ViewGroup r0 = this.centerSubtitleContainer;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.centerSubtitleContainer;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setCenterContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "centerContainer");
        ViewGroup r0 = this.itemTitleContainer;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.itemTitleContainer;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setItemStartContainer(View r2) {
        if (this.itemStartContainer != null) goto L5;
        return;
    L5:
        setCustomStartView(r2);
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        showCustomStart(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final ViewGroup getItemEndContainer() {
        return this.itemEndContainer;
    }

    public final void setEndContainerWidthWrap() {
        ViewGroup r2 = this.itemEndContainer;
        if (r2 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        r1.width = 0;
        r1.matchConstraintDefaultWidth = 1;
        r2.setLayoutParams(r1);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void setTitleContainerWidthSpread() {
        ViewGroup r2 = this.itemTitleContainer;
        if (r2 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        r1.width = 0;
        r1.matchConstraintDefaultWidth = 0;
        r2.setLayoutParams(r1);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void setItemEndContainer(View r2) {
        if (this.itemEndContainer != null) goto L5;
        return;
    L5:
        setCustomEndView(r2);
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        showCustomEnd(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void setDisableClick() {
        ViewGroup r1 = this.contentContainer;
        if (r1 == null) goto L7;
        r1.setClickable(false);
        return;
    }
}
