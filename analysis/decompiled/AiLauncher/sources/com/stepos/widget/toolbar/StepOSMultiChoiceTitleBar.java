package com.stepos.widget.toolbar;

import Z8.C1168p;
import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.customview.view.AbsSavedState;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.StepOSGlassImageButton;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.toolbar.StepOSMultiChoiceTitleBar;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 r2\u00020\u0001:\u0004rstuB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ%\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020!H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020!H\u0016¢\u0006\u0004\b-\u0010+J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00104\u001a\u00020\u000b2\b\b\u0001\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u00107J\u0017\u00109\u001a\u00020\u000b2\b\b\u0001\u00108\u001a\u00020\u0006¢\u0006\u0004\b9\u00107J1\u0010?\u001a\u00020\u00002\b\b\u0001\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010@J3\u0010?\u001a\u00020\u00002\b\b\u0001\u0010:\u001a\u00020\u00062\b\b\u0001\u0010A\u001a\u00020\u00062\u0006\u0010<\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010BJ\r\u0010C\u001a\u00020\u000b¢\u0006\u0004\bC\u0010\rJ7\u0010I\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0014¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u000bH\u0016¢\u0006\u0004\bO\u0010\rJ\u000f\u0010Q\u001a\u00020PH\u0014¢\u0006\u0004\bQ\u0010RJ\u0019\u0010T\u001a\u00020\u000b2\b\u0010S\u001a\u0004\u0018\u00010PH\u0014¢\u0006\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000e0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR$\u0010l\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010j\"\u0004\bk\u00107R(\u0010o\u001a\u0004\u0018\u0001022\b\u0010h\u001a\u0004\u0018\u0001028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\b9\u00105R\u0011\u0010q\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\bp\u0010j¨\u0006v"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar;", "Lcom/stepos/widget/toolbar/StepOSTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "applyContentMode", "()V", "Lcom/stepos/widget/glass/StepOSGlassImageButton;", "createCenterAction", "()Lcom/stepos/widget/glass/StepOSGlassImageButton;", "applyCenterColors", "refreshTouchDelegates", "Landroid/view/ViewGroup;", "parent", "", "Landroid/view/TouchDelegate;", "delegates", "collectActionViews", "(Landroid/view/ViewGroup;Ljava/util/List;)V", "Landroid/view/View;", "target", "Landroid/graphics/Rect;", "expandedTouchBounds", "(Landroid/view/View;)Landroid/graphics/Rect;", "rect", "parentSize", "", "horizontal", "expandAxis", "(Landroid/graphics/Rect;IZ)V", "Landroid/graphics/drawable/Drawable;", "drawable", "copyDrawable", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", x5.d.EXTRA_ENABLED, "setGlassEnabled", "(Z)V", "crossWindow", "setGlassCrossWindow", "Ly7/o;", "effect", "setGlassEffect", "(Ly7/o;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "titleResId", "(I)V", "textRes", "setSelectionSummary", "index", "icon", "contentDescription", "Landroid/view/View$OnClickListener;", "listener", "setSelectionAction", "(ILandroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar;", "iconRes", "(IILjava/lang/CharSequence;Landroid/view/View$OnClickListener;)Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar;", "clearSelectionActions", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDetachedFromWindow", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Lcom/stepos/widget/toolbar/StepOSGlassLayout;", "centerGlassLayout", "Lcom/stepos/widget/toolbar/StepOSGlassLayout;", "", "centerActionConfigured", "[Z", "", "centerActions", "[Lcom/stepos/widget/glass/StepOSGlassImageButton;", "selectionSummaryValue", "Ljava/lang/CharSequence;", "contentModeValue", "I", "centerReady", "Z", "Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$CompositeTouchDelegate;", "touchDelegates", "Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$CompositeTouchDelegate;", UxipConstants.f30680s, "getContentMode", "()I", "setContentMode", "contentMode", "getSelectionSummary", "()Ljava/lang/CharSequence;", "selectionSummary", "getSelectionActionCount", "selectionActionCount", "Companion", "ContentMode", "SavedState", "CompositeTouchDelegate", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMultiChoiceTitleBar extends StepOSTitleBar {
    public static final int ACTION_COUNT = 3;
    public static final int CONTENT_ACTIONS = 1;
    public static final int CONTENT_SUMMARY = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean[] centerActionConfigured;
    private final StepOSGlassImageButton[] centerActions;
    private final StepOSGlassLayout centerGlassLayout;
    private boolean centerReady;
    private int contentModeValue;
    private CharSequence selectionSummaryValue;
    private final CompositeTouchDelegate touchDelegates;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$Companion;", "", "<init>", "()V", "CONTENT_SUMMARY", "", "CONTENT_ACTIONS", "ACTION_COUNT", "wrap", "Landroid/content/Context;", "context", "styleRes", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context wrap(Context context, int styleRes) {
            return styleRes == 0 ? context : new ContextThemeWrapper(context, styleRes);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010j\b\u0012\u0004\u0012\u00020\u0001`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$CompositeTouchDelegate;", "Landroid/view/TouchDelegate;", "Landroid/view/View;", "owner", "<init>", "(Landroid/view/View;)V", "", "list", "LY8/t;", "setDelegates", "(Ljava/util/List;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "delegates", "Ljava/util/ArrayList;", "captured", "Landroid/view/TouchDelegate;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CompositeTouchDelegate extends TouchDelegate {
        private TouchDelegate captured;
        private final ArrayList<TouchDelegate> delegates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompositeTouchDelegate(View owner) {
            super(new Rect(), owner);
            kotlin.jvm.internal.p.i(owner, "owner");
            this.delegates = new ArrayList<>(5);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent event) {
            List listE;
            boolean z10;
            kotlin.jvm.internal.p.i(event, "event");
            float x10 = event.getX();
            float y10 = event.getY();
            TouchDelegate touchDelegate = this.captured;
            if (touchDelegate == null || (listE = C1172u.e(touchDelegate)) == null) {
                listE = this.delegates;
            }
            Iterator it = listE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                TouchDelegate touchDelegate2 = (TouchDelegate) it.next();
                event.setLocation(x10, y10);
                if (touchDelegate2.onTouchEvent(event)) {
                    this.captured = touchDelegate2;
                    z10 = true;
                    break;
                }
            }
            int actionMasked = event.getActionMasked();
            if (actionMasked != 1 && actionMasked != 3) {
                return z10;
            }
            this.captured = null;
            return z10;
        }

        public final void setDelegates(List<? extends TouchDelegate> list) {
            kotlin.jvm.internal.p.i(list, "list");
            this.delegates.clear();
            this.delegates.addAll(list);
            this.captured = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$ContentMode;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface ContentMode {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\b\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSMultiChoiceTitleBar$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "contentMode", "I", "getContentMode$StepOSWidget_release", "()I", "setContentMode$StepOSWidget_release", "(I)V", "", "selectionSummary", "Ljava/lang/CharSequence;", "getSelectionSummary$StepOSWidget_release", "()Ljava/lang/CharSequence;", "setSelectionSummary$StepOSWidget_release", "(Ljava/lang/CharSequence;)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private int contentMode;
        private CharSequence selectionSummary;
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.toolbar.StepOSMultiChoiceTitleBar$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSMultiChoiceTitleBar.SavedState[] newArray(int size) {
                return new StepOSMultiChoiceTitleBar.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSMultiChoiceTitleBar.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSMultiChoiceTitleBar.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSMultiChoiceTitleBar.SavedState createFromParcel(Parcel source) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSMultiChoiceTitleBar.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            kotlin.jvm.internal.p.i(superState, "superState");
        }

        /* renamed from: getContentMode$StepOSWidget_release, reason: from getter */
        public final int getContentMode() {
            return this.contentMode;
        }

        /* renamed from: getSelectionSummary$StepOSWidget_release, reason: from getter */
        public final CharSequence getSelectionSummary() {
            return this.selectionSummary;
        }

        public final void setContentMode$StepOSWidget_release(int i10) {
            this.contentMode = i10;
        }

        public final void setSelectionSummary$StepOSWidget_release(CharSequence charSequence) {
            this.selectionSummary = charSequence;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            kotlin.jvm.internal.p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.contentMode);
            TextUtils.writeToParcel(this.selectionSummary, out, flags);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            kotlin.jvm.internal.p.i(source, "source");
            this.contentMode = source.readInt();
            this.selectionSummary = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMultiChoiceTitleBar(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void applyCenterColors() {
        this.centerGlassLayout.setSurfaceColor(getContext().getColor(R.color.stepos_multi_choice_titlebar_glass_surface));
        for (StepOSGlassImageButton stepOSGlassImageButton : this.centerActions) {
            androidx.core.widget.e.c(stepOSGlassImageButton, ColorStateList.valueOf(getContext().getColor(R.color.stepos_multi_choice_titlebar_action_icon)));
            HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, stepOSGlassImageButton, getContext().getColor(R.color.stepos_multi_choice_titlebar_action_ripple), 0.0f, false, getPressScaleEnabledValue(), 0.0f, 44, null);
        }
    }

    private final void applyContentMode() {
        int i10 = this.contentModeValue;
        if (i10 == 0) {
            clearCenterView();
            super.setTitle(this.selectionSummaryValue);
        } else {
            if (i10 != 1) {
                return;
            }
            setCenterView(this.centerGlassLayout);
        }
    }

    private final void collectActionViews(ViewGroup parent, List<TouchDelegate> delegates) {
        CharSequence contentDescription;
        int childCount = parent.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = parent.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                if (childAt instanceof ViewGroup) {
                    collectActionViews((ViewGroup) childAt, delegates);
                } else if (childAt.isClickable() && (contentDescription = childAt.getContentDescription()) != null && contentDescription.length() != 0) {
                    kotlin.jvm.internal.p.f(childAt);
                    delegates.add(new TouchDelegate(expandedTouchBounds(childAt), childAt));
                }
            }
        }
    }

    private final Drawable copyDrawable(Drawable drawable) {
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        kotlin.jvm.internal.p.h(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    private final StepOSGlassImageButton createCenterAction() throws Resources.NotFoundException {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        StepOSGlassImageButton stepOSGlassImageButton = new StepOSGlassImageButton(context, null, 0, 0, 14, null);
        stepOSGlassImageButton.setId(View.generateViewId());
        stepOSGlassImageButton.setGlassEnabled(false);
        stepOSGlassImageButton.setGlassCrossWindow(false);
        stepOSGlassImageButton.setPressScaleEnabled(false);
        stepOSGlassImageButton.setSurfaceDrawable(null);
        stepOSGlassImageButton.setBackground(null);
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, stepOSGlassImageButton, stepOSGlassImageButton.getContext().getColor(R.color.stepos_multi_choice_titlebar_action_ripple), 0.0f, false, stepOSGlassImageButton.getIsPressScaleEnabled(), 0.0f, 44, null);
        stepOSGlassImageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        androidx.core.widget.e.c(stepOSGlassImageButton, ColorStateList.valueOf(stepOSGlassImageButton.getContext().getColor(R.color.stepos_multi_choice_titlebar_action_icon)));
        Resources resources = stepOSGlassImageButton.getResources();
        int i10 = R.dimen.stepos_multi_choice_titlebar_center_icon_padding_horizontal;
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        Resources resources2 = stepOSGlassImageButton.getResources();
        int i11 = R.dimen.stepos_multi_choice_titlebar_center_icon_padding_vertical;
        stepOSGlassImageButton.setPaddingRelative(dimensionPixelSize, resources2.getDimensionPixelSize(i11), stepOSGlassImageButton.getResources().getDimensionPixelSize(i10), stepOSGlassImageButton.getResources().getDimensionPixelSize(i11));
        stepOSGlassImageButton.setVisibility(4);
        stepOSGlassImageButton.setContentDescription(null);
        return stepOSGlassImageButton;
    }

    private final void expandAxis(Rect rect, int parentSize, boolean horizontal) {
        int i10 = horizontal ? rect.left : rect.top;
        int i11 = horizontal ? rect.right : rect.bottom;
        int i12 = i11 - i10;
        int iMin = Math.min(getResources().getDimensionPixelSize(R.dimen.stepos_size_touch_target_min), parentSize);
        if (i12 >= iMin) {
            return;
        }
        int i13 = iMin - i12;
        int i14 = i13 / 2;
        int iMax = i10 - i14;
        int i15 = (i11 + i13) - i14;
        if (iMax < 0) {
            i15 -= iMax;
            iMax = 0;
        }
        if (i15 > parentSize) {
            iMax = Math.max(0, iMax - (i15 - parentSize));
        } else {
            parentSize = i15;
        }
        if (horizontal) {
            rect.left = iMax;
            rect.right = parentSize;
        } else {
            rect.top = iMax;
            rect.bottom = parentSize;
        }
    }

    private final Rect expandedTouchBounds(View target) {
        Rect rect = new Rect();
        target.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(target, rect);
        expandAxis(rect, getWidth(), true);
        expandAxis(rect, getHeight(), false);
        return rect;
    }

    private final void refreshTouchDelegates() {
        if (!isLaidOut() || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(5);
        collectActionViews(getStartActionContainer(), arrayList);
        collectActionViews(getEndActions(), arrayList);
        if (this.contentModeValue == 1) {
            for (StepOSGlassImageButton stepOSGlassImageButton : this.centerActions) {
                if (stepOSGlassImageButton.getVisibility() == 0 && stepOSGlassImageButton.isClickable()) {
                    arrayList.add(new TouchDelegate(expandedTouchBounds(stepOSGlassImageButton), stepOSGlassImageButton));
                }
            }
        }
        this.touchDelegates.setDelegates(arrayList);
    }

    public final void clearSelectionActions() {
        C1168p.C(this.centerActionConfigured, false, 0, 0, 6, null);
        for (StepOSGlassImageButton stepOSGlassImageButton : this.centerActions) {
            stepOSGlassImageButton.setImageDrawable(null);
            stepOSGlassImageButton.setContentDescription(null);
            stepOSGlassImageButton.setOnClickListener(null);
            stepOSGlassImageButton.setClickable(false);
            stepOSGlassImageButton.setFocusable(false);
            stepOSGlassImageButton.setVisibility(4);
        }
        setContentMode(0);
        refreshTouchDelegates();
    }

    /* renamed from: getContentMode, reason: from getter */
    public final int getContentModeValue() {
        return this.contentModeValue;
    }

    public final int getSelectionActionCount() {
        int i10 = 0;
        for (boolean z10 : this.centerActionConfigured) {
            if (z10) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: getSelectionSummary, reason: from getter */
    public final CharSequence getSelectionSummaryValue() {
        return this.selectionSummaryValue;
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        applyCenterColors();
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        for (StepOSGlassImageButton stepOSGlassImageButton : this.centerActions) {
            stepOSGlassImageButton.setOnClickListener(null);
            stepOSGlassImageButton.setClickable(false);
            stepOSGlassImageButton.setFocusable(false);
        }
        this.touchDelegates.setDelegates(C1173v.m());
        super.onDetachedFromWindow();
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        refreshTouchDelegates();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.getContentMode() != 0 && savedState.getContentMode() != 1) {
            throw new IllegalArgumentException("Saved contentMode must be CONTENT_SUMMARY or CONTENT_ACTIONS");
        }
        this.selectionSummaryValue = savedState.getSelectionSummary();
        this.contentModeValue = savedState.getContentMode();
        if (this.centerReady) {
            applyContentMode();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        kotlin.jvm.internal.p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setContentMode$StepOSWidget_release(this.contentModeValue);
        savedState.setSelectionSummary$StepOSWidget_release(this.selectionSummaryValue);
        return savedState;
    }

    public final void setContentMode(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(("contentMode must be CONTENT_SUMMARY or CONTENT_ACTIONS, but was " + i10).toString());
        }
        if (this.contentModeValue == i10 && this.centerReady) {
            return;
        }
        this.contentModeValue = i10;
        if (this.centerReady) {
            applyContentMode();
            refreshTouchDelegates();
        }
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar
    public void setGlassCrossWindow(boolean crossWindow) {
        super.setGlassCrossWindow(crossWindow);
        if (this.centerReady) {
            this.centerGlassLayout.setGlassCrossWindow(crossWindow);
        }
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar
    public void setGlassEffect(y7.o effect) {
        kotlin.jvm.internal.p.i(effect, "effect");
        super.setGlassEffect(effect);
        if (this.centerReady) {
            this.centerGlassLayout.setGlassEffect(effect);
        }
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar
    public void setGlassEnabled(boolean enabled) {
        super.setGlassEnabled(enabled);
        if (this.centerReady) {
            this.centerGlassLayout.setGlassEnabled(enabled);
        }
    }

    public final StepOSMultiChoiceTitleBar setSelectionAction(int index, Drawable icon, CharSequence contentDescription, View.OnClickListener listener) {
        kotlin.jvm.internal.p.i(icon, "icon");
        kotlin.jvm.internal.p.i(contentDescription, "contentDescription");
        if (index < 0 || index >= 3) {
            throw new IllegalArgumentException(("selection action index must be in 0..2, but was " + index).toString());
        }
        if (contentDescription.length() <= 0) {
            throw new IllegalArgumentException("selection action contentDescription must not be empty");
        }
        StepOSGlassImageButton stepOSGlassImageButton = this.centerActions[index];
        this.centerActionConfigured[index] = true;
        stepOSGlassImageButton.setVisibility(0);
        stepOSGlassImageButton.setImageDrawable(copyDrawable(icon));
        stepOSGlassImageButton.setContentDescription(contentDescription);
        stepOSGlassImageButton.setClickable(listener != null);
        stepOSGlassImageButton.setFocusable(listener != null);
        stepOSGlassImageButton.setOnClickListener(listener);
        if (this.centerReady) {
            refreshTouchDelegates();
        }
        return this;
    }

    public final void setSelectionSummary(CharSequence charSequence) {
        this.selectionSummaryValue = charSequence;
        if (this.centerReady && this.contentModeValue == 0) {
            super.setTitle(charSequence);
        }
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        this.selectionSummaryValue = title;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMultiChoiceTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMultiChoiceTitleBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // com.stepos.widget.toolbar.StepOSTitleBar
    public void setTitle(int titleResId) {
        if (titleResId != 0) {
            setSelectionSummary(getResources().getText(titleResId));
            return;
        }
        throw new IllegalArgumentException("titleResId must be a valid @StringRes id, but was 0");
    }

    public /* synthetic */ StepOSMultiChoiceTitleBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposMultiChoiceTitleBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_MultiChoiceTitleBar : i11);
    }

    public final void setSelectionSummary(int textRes) {
        if (textRes != 0) {
            setSelectionSummary(getResources().getText(textRes));
            return;
        }
        throw new IllegalArgumentException("textRes must be a valid @StringRes id, but was 0");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSMultiChoiceTitleBar(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(INSTANCE.wrap(context, i11), attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        StepOSGlassLayout stepOSGlassLayout = new StepOSGlassLayout(context2, null, 0, 6, null);
        stepOSGlassLayout.setOrientation(0);
        stepOSGlassLayout.setGravity(16);
        Resources resources = stepOSGlassLayout.getResources();
        int i12 = R.dimen.stepos_multi_choice_titlebar_center_padding_horizontal;
        stepOSGlassLayout.setPaddingRelative(resources.getDimensionPixelSize(i12), 0, stepOSGlassLayout.getResources().getDimensionPixelSize(i12), 0);
        stepOSGlassLayout.setCornerRadius(0.0f);
        stepOSGlassLayout.setLayoutParams(new FrameLayout.LayoutParams(stepOSGlassLayout.getResources().getDimensionPixelSize(R.dimen.stepos_multi_choice_titlebar_center_width), stepOSGlassLayout.getResources().getDimensionPixelSize(R.dimen.stepos_multi_choice_titlebar_center_height), 17));
        this.centerGlassLayout = stepOSGlassLayout;
        this.centerActionConfigured = new boolean[3];
        StepOSGlassImageButton[] stepOSGlassImageButtonArr = new StepOSGlassImageButton[3];
        for (int i13 = 0; i13 < 3; i13++) {
            StepOSGlassImageButton stepOSGlassImageButtonCreateCenterAction = createCenterAction();
            this.centerGlassLayout.addView(stepOSGlassImageButtonCreateCenterAction, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.stepos_multi_choice_titlebar_center_slot_width), getResources().getDimensionPixelSize(R.dimen.stepos_multi_choice_titlebar_center_slot_height)));
            Y8.t tVar = Y8.t.f7040a;
            stepOSGlassImageButtonArr[i13] = stepOSGlassImageButtonCreateCenterAction;
        }
        this.centerActions = stepOSGlassImageButtonArr;
        CompositeTouchDelegate compositeTouchDelegate = new CompositeTouchDelegate(this);
        this.touchDelegates = compositeTouchDelegate;
        this.selectionSummaryValue = super.getTitle();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StepOSMultiChoiceTitleBar, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSMultiChoiceTitleBar_steposMultiChoiceMode, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (i14 != 0 && i14 != 1) {
            throw new IllegalArgumentException(("steposMultiChoiceMode must be summary or actions, but was " + i14).toString());
        }
        this.contentModeValue = i14;
        this.centerGlassLayout.setGlassEnabled(getGlassEnabled());
        this.centerGlassLayout.setGlassCrossWindow(getGlassCrossWindow());
        this.centerGlassLayout.setGlassEffect(getGlassEffect());
        applyCenterColors();
        this.centerReady = true;
        applyContentMode();
        setTouchDelegate(compositeTouchDelegate);
    }

    public final StepOSMultiChoiceTitleBar setSelectionAction(int index, int iconRes, CharSequence contentDescription, View.OnClickListener listener) {
        kotlin.jvm.internal.p.i(contentDescription, "contentDescription");
        if (iconRes != 0) {
            Drawable drawableB = C4027a.b(getContext(), iconRes);
            if (drawableB != null) {
                return setSelectionAction(index, drawableB, contentDescription, listener);
            }
            throw new IllegalArgumentException(("Drawable resource 0x" + Integer.toHexString(iconRes) + " could not be loaded").toString());
        }
        throw new IllegalArgumentException("iconRes must be a valid @DrawableRes id, but was 0");
    }
}
