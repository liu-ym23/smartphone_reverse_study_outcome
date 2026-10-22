package com.obric.oui.push;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.gyf.barlibrary.ImmersionBar;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUILogger;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.window.bean.WindowSizeClass;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPush.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 42\u00020\u0001:\u000234B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001bJ\u001f\u0010\"\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$2\b\b\u0001\u0010%\u001a\u00020\u0015¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001bH\u0002J\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020$J\u0010\u0010+\u001a\u00020$2\b\b\u0001\u0010-\u001a\u00020\u0015J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\rJ\b\u00100\u001a\u00020\u0006H\u0002J\u0006\u00101\u001a\u00020\u001bJ\b\u00102\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/oui/push/OPush;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoDismiss", "", "autoDismissAndShowStatusBar", "getContext", "()Landroid/content/Context;", "setContext", "hiddenStatusBar", "onClickListener", "Landroid/view/View$OnClickListener;", "onDismissListeners", "Ljava/util/ArrayList;", "Landroid/widget/PopupWindow$OnDismissListener;", "Lkotlin/collections/ArrayList;", "popupWindow", "Landroid/widget/PopupWindow;", "privilege", "", "pushCard", "Lcom/obric/oui/push/NotificationLabel;", "rootView", "Landroid/widget/FrameLayout;", "addOnDismissListener", "", "dismissListener", "addOnDragGestureListener", "gestureListener", "Lcom/obric/oui/push/NotificationLabel$GestureListener;", "dismiss", "dismissWindow", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "id", "(I)Landroid/view/View;", "hideStatusBar", "isShowing", "removeOnDismissListener", "removeOnDragGestureListener", "setContentView", "view", "resId", "setOnClickListener", "listener", "shouldShow", "show", "showStatusBar", "Builder", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPush {
    public static final Companion Companion = null;
    private static final int DUX_PUSH_LARGE_WINDOW_WIDTH_DP = 556;
    private static final int DUX_PUSH_SMALL_WINDOW_WIDTH_DP = 460;
    public static final int MAX_WIDTH_IN_DP = 556;
    public static final int PUSH_ACTION_TYPE_CHEVRON = 1;
    public static final int PUSH_ACTION_TYPE_NONE = 0;
    public static final int PUSH_ACTION_TYPE_TEXT = 2;
    private boolean autoDismiss;
    private boolean autoDismissAndShowStatusBar;
    private Context context;
    private boolean hiddenStatusBar;
    private View.OnClickListener onClickListener;
    private final ArrayList<PopupWindow.OnDismissListener> onDismissListeners;
    private final PopupWindow popupWindow;
    private int privilege;
    private NotificationLabel pushCard;
    private FrameLayout rootView;

    /* JADX INFO: compiled from: OPush.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0001AB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\rJ\b\u0010\"\u001a\u00020\rH\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0010J\u0010\u0010,\u001a\u00020\u00002\b\b\u0001\u0010.\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0013J\u0010\u0010/\u001a\u00020\u00002\b\b\u0001\u00101\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0010J\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\u000bJ)\u00105\u001a\u00020(2!\u00106\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(07J)\u0010;\u001a\u00020(2!\u00106\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(07J\u000e\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0017J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u001a\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u001a2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010>\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020\u000b2\b\b\u0003\u0010@\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/push/OPush$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mActionText", "", "mActionType", "", "mAutoDismiss", "", "mAutoDismissAndShowStatusBar", "mContentView", "Landroid/view/View;", "mContentViewId", "mIcon", "Landroid/graphics/drawable/Drawable;", "mLeftCustomView", "mLeftCustomViewId", "mOnActionClickListener", "Landroid/view/View$OnClickListener;", "mOnClickListener", "mSubTitle", "", "mTitle", "privilege", "build", "Lcom/obric/oui/push/OPush;", "buildLayout", "wrapWithCardView", "getAutoDismissAndShowStatusBar", "isSingleLine", "setActionText", "actionText", "setActionType", "actionType", "setAutoDismiss", "", "value", "setAutoDismissAndShowStatusBar", "autoDismissAndShowStatusBar", "setContentView", "contentView", "contentViewId", "setIcon", "drawable", "icon", "setLeftCustomView", "customView", "customViewId", "setOnActionClickListener", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "setOnClickListener", "listener", "setPrivilege", "setTitle", "title", "subTitle", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        private static final int LARGE_ICON_SIZE = 0;
        private static final int LEFT_MARGIN = 0;
        private static final int SMALL_ICON_SIZE = 0;
        private Context context;
        private String mActionText;
        private int mActionType;
        private boolean mAutoDismiss;
        private boolean mAutoDismissAndShowStatusBar;
        private View mContentView;
        private int mContentViewId;
        private Drawable mIcon;
        private View mLeftCustomView;
        private int mLeftCustomViewId;
        private View.OnClickListener mOnActionClickListener;
        private View.OnClickListener mOnClickListener;
        private CharSequence mSubTitle;
        private CharSequence mTitle;
        private int privilege;

        /* JADX INFO: compiled from: OPush.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/push/OPush$Builder$Companion;", "", "()V", "LARGE_ICON_SIZE", "", "LEFT_MARGIN", "SMALL_ICON_SIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$1D-KuO7kqtOtBVDtu6dHKgwhiIs, reason: not valid java name */
        public static /* synthetic */ void m638$r8$lambda$1DKuO7kqtOtBVDtu6dHKgwhiIs(Builder r0, int r1, Guideline r2) {
            m643buildLayout$lambda3(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$BSJJPfYwFR3zvcEMbTBVBYuBc1w(Builder r0, int r1, Guideline r2) {
            m645buildLayout$lambda5(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$Dz7E9b_MlSPs5khEr-sXAIaGn5w, reason: not valid java name */
        public static /* synthetic */ void m639$r8$lambda$Dz7E9b_MlSPs5khErsXAIaGn5w(Function1 r0, View r1) {
            m648setOnActionClickListener$lambda1(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$LkyWjSGROrBc2Jubu8J8-CfbZA8, reason: not valid java name */
        public static /* synthetic */ void m640$r8$lambda$LkyWjSGROrBc2Jubu8J8CfbZA8(Builder r0, int r1, Guideline r2) {
            m646buildLayout$lambda5$lambda4(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$XLqdGDUqWp1PYMNhkAy-z9Irn5k, reason: not valid java name */
        public static /* synthetic */ void m641$r8$lambda$XLqdGDUqWp1PYMNhkAyz9Irn5k(Builder r0, int r1, Guideline r2) {
            m644buildLayout$lambda3$lambda2(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$eBj1P87pTH5c5j7TXUjzvxvupDo(Function1 r0, View r1) {
            m649setOnClickListener$lambda0(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$ymn5WAb-TvPqTHVwbyLxxpOeULc, reason: not valid java name */
        public static /* synthetic */ void m642$r8$lambda$ymn5WAbTvPqTHVwbyLxxpOeULc(Guideline r0, int r1, int r2) {
            m647buildLayout$lambda6(r0, r1, r2);
        }

        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            this.mActionText = "";
            this.mAutoDismiss = true;
            this.privilege = 1;
            this.mAutoDismissAndShowStatusBar = true;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.context = r2;
        }

        static {
            Companion = new Companion(null);
            LEFT_MARGIN = 16;
            SMALL_ICON_SIZE = 24;
            LARGE_ICON_SIZE = 48;
        }

        public final Builder setAutoDismissAndShowStatusBar(boolean r1) {
            this.mAutoDismissAndShowStatusBar = r1;
            return this;
        }

        public final boolean getAutoDismissAndShowStatusBar() {
            return this.mAutoDismissAndShowStatusBar;
        }

        public final Builder setPrivilege(int r1) {
            this.privilege = r1;
            return this;
        }

        public static /* synthetic */ Builder setTitle$default(Builder r0, CharSequence r1, CharSequence r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            return r0.setTitle(r1, r2);
        }

        public final Builder setTitle(CharSequence r2, CharSequence r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.mTitle = r2;
            this.mSubTitle = r3;
            return this;
        }

        public static /* synthetic */ Builder setTitle$default(Builder r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = 0;
        L6:
            return r0.setTitle(r1, r2);
        }

        public final Builder setTitle(int r2, int r3) {
            this.mTitle = this.context.getString(r2);
            this.mSubTitle = this.context.getString(r3);
            return this;
        }

        public final Builder setIcon(int r2) {
            this.mIcon = ContextCompat.getDrawable(this.context, r2);
            return this;
        }

        public final Builder setIcon(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            this.mIcon = r2;
            return this;
        }

        public final Builder setContentView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "contentView");
            this.mContentView = r2;
            return this;
        }

        public final Builder setContentView(int r1) {
            this.mContentViewId = r1;
            return this;
        }

        public final Builder setLeftCustomView(int r1) {
            this.mLeftCustomViewId = r1;
            return this;
        }

        public final Builder setLeftCustomView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "customView");
            this.mLeftCustomView = r2;
            return this;
        }

        public final Builder setActionType(int r1) {
            this.mActionType = r1;
            return this;
        }

        public final Builder setActionText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "actionText");
            this.mActionText = r2;
            return this;
        }

        public final void setOnClickListener(View.OnClickListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mOnClickListener = r2;
        }

        /* JADX INFO: renamed from: setOnClickListener$lambda-0, reason: not valid java name */
        private static final void m649setOnClickListener$lambda0(Function1 r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "$block");
            Intrinsics.checkNotNullExpressionValue(r2, BaseSwitches.V);
            r1.invoke(r2);
        }

        public final void setOnClickListener(final Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "block");
            this.mOnClickListener = new OPush$Builder$$ExternalSyntheticLambda4(r2);
        }

        public final void setAutoDismiss(boolean r1) {
            this.mAutoDismiss = r1;
        }

        public final void setOnActionClickListener(final Function1<? super View, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "block");
            this.mOnActionClickListener = new OPush$Builder$$ExternalSyntheticLambda3(r2);
        }

        /* JADX INFO: renamed from: setOnActionClickListener$lambda-1, reason: not valid java name */
        private static final void m648setOnActionClickListener$lambda1(Function1 r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "$block");
            Intrinsics.checkNotNullExpressionValue(r2, BaseSwitches.V);
            r1.invoke(r2);
        }

        private final boolean isSingleLine() {
            CharSequence r0 = this.mTitle;
            boolean r2 = true;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            CharSequence r3 = this.mSubTitle;
            if (r3 != null) goto L12;
        L15:
            boolean r4 = true;
        L17:
            if ((r1 ^ r4) == true) goto L34;
            CharSequence r5 = this.mTitle;
            if (r5 != null) goto L22;
        L25:
            boolean r6 = true;
        L26:
            if (r6 == true) goto L36;
            CharSequence r7 = this.mSubTitle;
            if (r7 != null) goto L30;
        L33:
            if (r2 == true) goto L36;
            return false;
        L30:
            if (r7.length() == 0) goto L33;
            r2 = false;
        L36:
            throw new IllegalArgumentException("Push标题为null");
        L22:
            if (r5.length() == 0) goto L25;
            r6 = false;
            goto L26
        L34:
            return true;
        L12:
            if (r3.length() == 0) goto L15;
            r4 = false;
            goto L17
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public static /* synthetic */ View buildLayout$default(Builder r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = false;
        L6:
            return r0.buildLayout(r1);
        }

        public final View buildLayout(boolean r17) {
            final CardView r1 = LayoutInflater.from(this.context).inflate(R.layout.o_layout_push_view, null);
            FrameLayout r2 = (FrameLayout) r1.findViewById(R.id.custom_view_container);
            TextView r4 = (TextView) r1.findViewById(R.id.push_title);
            TextView r5 = (TextView) r1.findViewById(R.id.push_subTitle);
            final TextView r6 = (TextView) r1.findViewById(R.id.tv_action);
            final ImageView r7 = (ImageView) r1.findViewById(R.id.iv_action);
            final Guideline r8 = (Guideline) r1.findViewById(R.id.o_guideline);
            Context r9 = this.context;
            int r10 = LEFT_MARGIN;
            final int r11 = OUnitExtensionKt.cdp(r9, r10);
            View r12 = this.mLeftCustomView;
            if (r12 == null) goto L9;
            r2.addView(r12, new ViewGroup.LayoutParams(-2, -1));
            View r3 = this.mLeftCustomView;
            if (r3 == null) goto L25;
            r3.post(new OPush$Builder$$ExternalSyntheticLambda0(this, r11, r8));
        L25:
            CharSequence r13 = this.mTitle;
            if (r13 == null) goto L28;
            r4.setText(r13);
        L28:
            CharSequence r14 = this.mSubTitle;
            if (r14 == null) goto L31;
            r5.setText(r14);
        L34:
            int r15 = this.mActionType;
            if (r15 != 1) goto L37;
            r6.setVisibility(8);
            View.OnClickListener r16 = this.mOnActionClickListener;
            if (r16 == null) goto L57;
            r7.setOnClickListener(r16);
        L57:
            r1.addOnAttachStateChangeListener(new OPush$Builder$buildLayout$8(r1, this, r6, r7));
            if (r17 == false) goto L60;
            CardView r0 = (CardView) LayoutInflater.from(this.context).inflate(R.layout.o_layout_push_layout, null).findViewById(R.id.push_card);
            r0.setCardBackgroundColor(-1);
            r0.addView(r1);
            r1 = r0;
        L60:
            Intrinsics.checkNotNullExpressionValue(r1, "resultView");
            return r1;
        L37:
            if (r15 == 2) goto L43;
            r6.setVisibility(8);
            r7.setVisibility(8);
            ViewGroup.LayoutParams r18 = r4.getLayoutParams();
            if (r18 == null) goto L42;
            ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
            r19.rightMargin = r10;
            r4.setLayoutParams(r19);
            goto L57
        L42:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L43:
            r7.setVisibility(8);
            ViewGroup.LayoutParams r20 = r4.getLayoutParams();
            if (r20 == null) goto L53;
            ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
            r21.endToStart = R.id.tv_action;
            r4.setLayoutParams(r21);
            ViewGroup.LayoutParams r22 = r5.getLayoutParams();
            if (r22 == null) goto L51;
            ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
            r23.endToStart = R.id.tv_action;
            r5.setLayoutParams(r23);
            r6.setText(this.mActionText);
            View.OnClickListener r24 = this.mOnActionClickListener;
            if (r24 == null) goto L57;
            r6.setOnClickListener(r24);
            goto L57
        L51:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L53:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L31:
            r5.setVisibility(8);
            ViewGroup.LayoutParams r25 = r4.getLayoutParams();
            if (r25 == null) goto L63;
            ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
            r26.bottomToBottom = 0;
            r26.bottomMargin = OUnitExtensionKt.cdp(getContext(), 18);
            r4.setLayoutParams(r26);
            goto L34
        L63:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        L9:
            if (this.mLeftCustomViewId == 0) goto L15;
            View r27 = LayoutInflater.from(this.context).inflate(this.mLeftCustomViewId, r2);
            this.mLeftCustomView = r27;
            if (r27 == null) goto L25;
            r27.post(new OPush$Builder$$ExternalSyntheticLambda1(this, r11, r8));
            goto L25
        L15:
            if (this.mIcon != null) goto L17;
            r8.setGuidelineBegin(r11);
            goto L25
        L17:
            if (isSingleLine() == false) goto L19;
            Context r110 = this.context;
            int r111 = SMALL_ICON_SIZE;
        L20:
            final int r112 = OUnitExtensionKt.cdp(r110, r111);
            AppCompatImageView r113 = new AppCompatImageView(this.context);
            r113.setImageDrawable(this.mIcon);
            r113.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r2.addView(r113, new FrameLayout.LayoutParams(r112, r112, 17));
            View r28 = this.mLeftCustomView;
            if (r28 == null) goto L25;
            r28.post(new OPush$Builder$$ExternalSyntheticLambda2(r8, r11, r112));
            goto L25
        L19:
            r110 = this.context;
            r111 = LARGE_ICON_SIZE;
            goto L20
        }

        /* JADX INFO: renamed from: buildLayout$lambda-3, reason: not valid java name */
        private static final void m643buildLayout$lambda3(final Builder r2, final int r3, final Guideline r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            View r0 = r2.mLeftCustomView;
            if (r0 != null) goto L5;
            int r1 = r3;
        L6:
            if (r1 != 0) goto L15;
            View r5 = r2.mLeftCustomView;
            if (r5 == null) goto L11;
            r5.requestLayout();
        L11:
            View r6 = r2.mLeftCustomView;
            if (r6 == null) goto L18;
            r6.post(new OPush$Builder$$ExternalSyntheticLambda6(r2, r3, r4));
            return;
        L18:
            return;
        L15:
            r4.setGuidelineBegin(r1);
            return;
        L5:
            r1 = r0.getWidth();
            goto L6
        }

        /* JADX INFO: renamed from: buildLayout$lambda-3$lambda-2, reason: not valid java name */
        private static final void m644buildLayout$lambda3$lambda2(Builder r1, int r2, Guideline r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            View r4 = r1.mLeftCustomView;
            if (r4 == null) goto L6;
            r2 = r4.getWidth();
        L6:
            r3.setGuidelineBegin(r2);
        }

        /* JADX INFO: renamed from: buildLayout$lambda-5, reason: not valid java name */
        private static final void m645buildLayout$lambda5(final Builder r2, final int r3, final Guideline r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            View r0 = r2.mLeftCustomView;
            if (r0 != null) goto L5;
            int r1 = r3;
        L6:
            if (r1 != 0) goto L15;
            View r5 = r2.mLeftCustomView;
            if (r5 == null) goto L11;
            r5.requestLayout();
        L11:
            View r6 = r2.mLeftCustomView;
            if (r6 == null) goto L18;
            r6.post(new OPush$Builder$$ExternalSyntheticLambda5(r2, r3, r4));
            return;
        L18:
            return;
        L15:
            r4.setGuidelineBegin(r1);
            return;
        L5:
            r1 = r0.getWidth();
            goto L6
        }

        /* JADX INFO: renamed from: buildLayout$lambda-5$lambda-4, reason: not valid java name */
        private static final void m646buildLayout$lambda5$lambda4(Builder r1, int r2, Guideline r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            View r4 = r1.mLeftCustomView;
            if (r4 == null) goto L6;
            r2 = r4.getWidth();
        L6:
            r3.setGuidelineBegin(r2);
        }

        /* JADX INFO: renamed from: buildLayout$lambda-6, reason: not valid java name */
        private static final void m647buildLayout$lambda6(Guideline r0, int r1, int r2) {
            r0.setGuidelineBegin(r1 + (r2 * 2));
        }

        public final OPush build() {
            OPush r0 = new OPush(this.context);
            View r1 = this.mContentView;
            if (r1 == null) goto L5;
            Intrinsics.checkNotNull(r1);
            r0.setContentView(r1);
        L9:
            OPush.access$setOnClickListener$p(r0, this.mOnClickListener);
            OPush.access$setAutoDismiss$p(r0, this.mAutoDismiss);
            OPush.access$setPrivilege$p(r0, this.privilege);
            OPush.access$setAutoDismissAndShowStatusBar$p(r0, this.mAutoDismissAndShowStatusBar);
            return r0;
        L5:
            int r2 = this.mContentViewId;
            if (r2 == 0) goto L8;
            r0.setContentView(r2);
            goto L9
        L8:
            r0.setContentView(buildLayout$default(this, false, 1, null));
            goto L9
        }
    }

    /* JADX INFO: compiled from: OPush.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012H\u0086\bø\u0001\u0000J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/push/OPush$Companion;", "", "()V", "DUX_PUSH_LARGE_WINDOW_WIDTH_DP", "", "DUX_PUSH_SMALL_WINDOW_WIDTH_DP", "MAX_WIDTH_IN_DP", "PUSH_ACTION_TYPE_CHEVRON", "PUSH_ACTION_TYPE_NONE", "PUSH_ACTION_TYPE_TEXT", "build", "Lcom/obric/oui/push/OPush;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/obric/oui/push/OPush$Builder;", "", "Lkotlin/ExtensionFunctionType;", "getPushContentWidth", "originWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OPush.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[WindowSizeClass.values().length];
                r0[WindowSizeClass.MINUS_ERROR_SIZE.ordinal()] = 1;
                r0[WindowSizeClass.FLOATING_WINDOW.ordinal()] = 2;
                r0[WindowSizeClass.SMALL_SPLIT_SCREEN.ordinal()] = 3;
                r0[WindowSizeClass.SMALLER_ANDROID_SCREEN.ordinal()] = 4;
                r0[WindowSizeClass.SMALL.ordinal()] = 5;
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final int getPushContentWidth(int r1, Context r2) {
            return r1;
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$getPushContentWidth(Companion r0, int r1, Context r2) {
            return r0.getPushContentWidth(r1, r2);
        }

        public final OPush build(Context r1, Function1<? super Builder, Unit> r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "block");
            Builder r0 = new Builder(r1);
            r2.invoke(r0);
            return r0.build();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-VX4z5rxLidc8fvd1VnrsFJsy9A, reason: not valid java name */
    public static /* synthetic */ void m633$r8$lambda$VX4z5rxLidc8fvd1VnrsFJsy9A(OPush r0, ValueAnimator r1) {
        m636dismiss$lambda8$lambda7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$H2O0kjpbhS5dWQ_BtyQq_baVVrI(OPush r0) {
        m635_init_$lambda2(r0);
    }

    public static /* synthetic */ void $r8$lambda$h8tCepZcwrO64bg6yDNM2RU9aIE(OPush r0, ValueAnimator r1) {
        m637show$lambda5$lambda4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$vej6XSveCT5SrDgOf0SkeOEJ8Kk(OPush r0, View r1) {
        m634_init_$lambda0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OPush(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.context = r6;
        View r7 = LayoutInflater.from(r6).inflate(R.layout.o_layout_push, null);
        if (r7 == null) goto L7;
        this.rootView = (FrameLayout) r7;
        this.onDismissListeners = new ArrayList();
        this.autoDismiss = true;
        this.privilege = 1;
        this.autoDismissAndShowStatusBar = true;
        View r8 = this.rootView.findViewById(R.id.push_card);
        Intrinsics.checkNotNullExpressionValue(r8, "rootView.findViewById(R.id.push_card)");
        NotificationLabel r9 = (NotificationLabel) r8;
        this.pushCard = r9;
        r9.setParent(this.rootView);
        int r10 = OUnitExtensionKt.cdp(this.context, 556);
        int r0 = OUnitExtensionKt.cdp(this.context, 130);
        PopupWindow r1 = new PopupWindow(this.rootView, Companion.access$getPushContentWidth(Companion, Math.min(OUnitExtensionKt.getScreenWidth(this.context), r10), this.context), r0);
        this.popupWindow = r1;
        this.pushCard.addOnDragDismissListener(new AnonymousClass1(this));
        this.pushCard.setOnClickListener(new OPush$$ExternalSyntheticLambda1(this));
        r1.setOnDismissListener(new OPush$$ExternalSyntheticLambda2(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public static final /* synthetic */ boolean access$getAutoDismiss$p(OPush r0) {
        return r0.autoDismiss;
    }

    public static final /* synthetic */ View.OnClickListener access$getOnClickListener$p(OPush r0) {
        return r0.onClickListener;
    }

    public static final /* synthetic */ NotificationLabel access$getPushCard$p(OPush r0) {
        return r0.pushCard;
    }

    public static final /* synthetic */ void access$setAutoDismiss$p(OPush r0, boolean r1) {
        r0.autoDismiss = r1;
    }

    public static final /* synthetic */ void access$setAutoDismissAndShowStatusBar$p(OPush r0, boolean r1) {
        r0.autoDismissAndShowStatusBar = r1;
    }

    public static final /* synthetic */ void access$setOnClickListener$p(OPush r0, View.OnClickListener r1) {
        r0.onClickListener = r1;
    }

    public static final /* synthetic */ void access$setPrivilege$p(OPush r0, int r1) {
        r0.privilege = r1;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m634_init_$lambda0(OPush r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        View.OnClickListener r3 = r1.onClickListener;
        if (r3 == null) goto L7;
        r3.onClick(r1.pushCard);
    L7:
        if (r1.autoDismiss == false) goto L10;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final void m635_init_$lambda2(OPush r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.showStatusBar();
        Iterator<T> r2 = r1.onDismissListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((PopupWindow.OnDismissListener) r2.next()).onDismiss();
        goto L4
    }

    private final void hideStatusBar() {
        if (this.autoDismissAndShowStatusBar == true) goto L5;
        return;
    L5:
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L14;
        ImmersionBar.hideStatusBar(((Activity) r0).getWindow());     // Catch: Exception -> L9
        this.hiddenStatusBar = true;     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        OUILogger.e$default(OUILogger.INSTANCE, "OPush", Intrinsics.stringPlus("hideStatusBar:", e), null, 4, null);
        return;
    }

    private final void showStatusBar() {
        if (this.autoDismissAndShowStatusBar == true) goto L5;
        return;
    L5:
        Context r0 = this.context;
        if ((r0 instanceof Activity) == true) goto L8;
        return;
    L8:
        if (this.hiddenStatusBar == false) goto L17;
        ((Activity) r0).getWindow().clearFlags(1024);     // Catch: Exception -> L11
        this.hiddenStatusBar = false;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        OUILogger.e$default(OUILogger.INSTANCE, "OPush", Intrinsics.stringPlus("showStatusBar:", e), null, 4, null);
        return;
    }

    public final View setContentView(int r2) {
        View r1 = LayoutInflater.from(this.context).inflate(r2, this.pushCard);
        Intrinsics.checkNotNullExpressionValue(r1, "from(context).inflate(resId, pushCard)");
        return r1;
    }

    public final void setContentView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.pushCard.addView(r4, new FrameLayout.LayoutParams(-1, -2));
    }

    public final void addOnDragGestureListener(NotificationLabel.GestureListener r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureListener");
        this.pushCard.addOnDragDismissListener(r2);
    }

    public final void removeOnDragGestureListener(NotificationLabel.GestureListener r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureListener");
        this.pushCard.removeOnDragDismissListener(r2);
    }

    public final void addOnDismissListener(PopupWindow.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "dismissListener");
        this.onDismissListeners.add(r2);
    }

    public final void removeOnDismissListener(PopupWindow.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "dismissListener");
        this.onDismissListeners.remove(r2);
    }

    public final void setOnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onClickListener = r2;
    }

    public final <T extends View> T findViewById(int r1) {
        T r0 = (T) this.rootView.findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "rootView.findViewById(id)");
        return r0;
    }

    public final void show() {
        if (shouldShow() == true) goto L5;
        return;
    L5:
        OPush r0 = PushQueue.Companion.getInstance().getShowingPush();
        if (r0 == null) goto L9;
        r0.dismiss();
    L9:
        PushQueue.Companion.getInstance().setShowingPush(this);
        Context r1 = this.context;
        if ((r1 instanceof Activity) == false) goto L12;
        FrameLayout r2 = ((Activity) r1).getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(r2, "context as Activity).window.decorView");
    L13:
        hideStatusBar();
        this.popupWindow.showAtLocation(r2, 48, 0, -200);
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{OUnitExtensionKt.cdp(this.context, -100), 0});
        r3.addUpdateListener(new OPush$$ExternalSyntheticLambda3(this));
        ViewCompat.setFitsSystemWindows(this.popupWindow.getContentView(), false);
        r3.start();
        return;
    L12:
        r2 = new FrameLayout(this.context);
        goto L13
    }

    /* JADX INFO: renamed from: show$lambda-5$lambda-4, reason: not valid java name */
    private static final void m637show$lambda5$lambda4(OPush r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        NotificationLabel r3 = r1.pushCard;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = null;
    L8:
        r3.setLayoutParams(r0);
        return;
    L5:
        Object r4 = r2.getAnimatedValue();
        if (r4 == null) goto L11;
        r0.topMargin = ((Integer) r4).intValue();
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean shouldShow() {
        OPush r1 = PushQueue.Companion.getInstance().getShowingPush();
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r1.privilege == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    public final void dismiss() {
        if (isShowing() == false) goto L5;
        PushQueue.Companion.getInstance().setShowingPush(null);
    L5:
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, OUnitExtensionKt.cdp(this.context, -100)});
        r0.addUpdateListener(new OPush$$ExternalSyntheticLambda0(this));
        r0.addListener(new OPush$dismiss$1$2(this));
        r0.start();
    }

    /* JADX INFO: renamed from: dismiss$lambda-8$lambda-7, reason: not valid java name */
    private static final void m636dismiss$lambda8$lambda7(OPush r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        NotificationLabel r3 = r1.pushCard;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = null;
    L8:
        r3.setLayoutParams(r0);
        return;
    L5:
        Object r4 = r2.getAnimatedValue();
        if (r4 == null) goto L11;
        r0.topMargin = ((Integer) r4).intValue();
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void dismissWindow() {
        this.popupWindow.dismiss();
    }
}
