package com.bytedance.android.ui.ec.widget.switchbutton;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ml.process.bl.MLConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\nH\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0091\u0001H\u0002J\u0014\u0010\u0096\u0001\u001a\u00030\u0091\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010\u0099\u0001\u001a\u00030\u0091\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\u001c\u0010\u009c\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u009d\u0001\u001a\u0002052\u0007\u0010\u009e\u0001\u001a\u000205H\u0016J\n\u0010\u009f\u0001\u001a\u00030\u0091\u0001H\u0014J\t\u0010 \u0001\u001a\u00020\u0007H\u0016J\t\u0010¡\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010¢\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u0002052\u0007\u0010\u009e\u0001\u001a\u000205H\u0002J\n\u0010£\u0001\u001a\u00030\u0091\u0001H\u0016J\u0016\u0010¤\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010¥\u0001\u001a\u0004\u0018\u00010.H\u0002J\u0013\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u0007H\u0014J\u0014\u0010©\u0001\u001a\u00030\u0091\u00012\b\u0010ª\u0001\u001a\u00030\u009b\u0001H\u0014J\u0014\u0010«\u0001\u001a\u00030\u0091\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0014\u0010®\u0001\u001a\u00030\u0091\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J7\u0010±\u0001\u001a\u00030\u0091\u00012\u0007\u0010²\u0001\u001a\u00020\n2\u0007\u0010³\u0001\u001a\u00020\u00072\u0007\u0010´\u0001\u001a\u00020\u00072\u0007\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010·\u0001\u001a\u00030\u0091\u00012\u0007\u0010¸\u0001\u001a\u00020\u00072\u0007\u0010¹\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010º\u0001\u001a\u00030\u0091\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0013\u0010»\u0001\u001a\u00020\n2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\u0013\u0010¼\u0001\u001a\u00030\u0091\u00012\u0007\u0010½\u0001\u001a\u00020\nH\u0016J\u0014\u0010¾\u0001\u001a\u00030\u0091\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\u001b\u0010Á\u0001\u001a\u00030\u0091\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0007\u0010Â\u0001\u001a\u00020\u0007J\u0014\u0010Ã\u0001\u001a\u00030\u0091\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001J\u001d\u0010Ã\u0001\u001a\u00030\u0091\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00012\u0007\u0010Ç\u0001\u001a\u00020\u0007J\u001c\u0010È\u0001\u001a\u00030\u0091\u00012\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010Ë\u0001\u001a\u00030\u0091\u00012\u0007\u0010Ì\u0001\u001a\u000205J\u0011\u0010Í\u0001\u001a\u00030\u0091\u00012\u0007\u0010Î\u0001\u001a\u00020\u0007J\u0011\u0010Ï\u0001\u001a\u00030\u0091\u00012\u0007\u0010Î\u0001\u001a\u00020\u0007J\u0014\u0010Ð\u0001\u001a\u00030\u0091\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0091\u0001H\u0016J\u0012\u0010Ò\u0001\u001a\u00020\n2\u0007\u0010Ó\u0001\u001a\u000207H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n L*\u0004\u0018\u00010K0KX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010M\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR$\u0010P\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR$\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u0014\u0010\\\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\fR(\u0010^\u001a\u0004\u0018\u00010.2\b\u0010^\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010c\u001a\u0004\u0018\u00010.2\b\u0010c\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR$\u0010g\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010V\"\u0004\bi\u0010XR$\u0010j\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010V\"\u0004\bl\u0010XR(\u0010n\u001a\u0004\u0018\u0001072\b\u0010m\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010VR\u0014\u0010u\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010VR$\u0010w\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010V\"\u0004\by\u0010XR(\u0010{\u001a\u0004\u0018\u00010,2\b\u0010z\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR.\u0010\u0081\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0086\u0001\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010p\"\u0005\b\u0089\u0001\u0010rR+\u0010\u008a\u0001\u001a\u0004\u0018\u00010,2\b\u0010z\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010}\"\u0005\b\u008c\u0001\u0010\u007fR.\u0010\u008d\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u0083\u0001\"\u0006\b\u008f\u0001\u0010\u0085\u0001¨\u0006Õ\u0001"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", "Landroid/widget/CompoundButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCheck", "", "getAutoCheck", "()Z", "setAutoCheck", "(Z)V", "mHasThumbTint", "mHasThumbTintMode", "mHasTrackTint", "mHasTrackTintMode", "mMinFlingVelocity", "mOffLayout", "Landroid/text/Layout;", "mOnLayout", "mPositionAnimator", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mShowText", "mSplitTrack", "mSwitchBottom", "mSwitchHeight", "mSwitchLeft", "mSwitchMinWidth", "mSwitchPadding", "mSwitchRight", "mSwitchTop", "mSwitchTransformationMethod", "Landroid/text/method/TransformationMethod;", "mSwitchWidth", "mTempRect", "Landroid/graphics/Rect;", "mTextColors", "Landroid/content/res/ColorStateList;", "mTextOff", "", "mTextOn", "mTextPaint", "Landroid/text/TextPaint;", "mThumbConstraintLeft", "mThumbConstraintRight", "mThumbDragPosition", "", "mThumbDrawable", "Landroid/graphics/drawable/Drawable;", "mThumbHeight", "mThumbPosition", "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbTextPadding", "mThumbTintList", "mThumbTintMode", "Landroid/graphics/PorterDuff$Mode;", "mThumbWidth", "mTouchMode", "mTouchSlop", "mTouchX", "mTouchY", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "showText", "getShowText", "setShowText", "splitTrack", "getSplitTrack", "setSplitTrack", "pixels", "switchMinWidth", "getSwitchMinWidth", "()I", "setSwitchMinWidth", "(I)V", "switchPadding", "getSwitchPadding", "setSwitchPadding", "targetCheckedState", "getTargetCheckedState", "textOff", "getTextOff", "()Ljava/lang/CharSequence;", "setTextOff", "(Ljava/lang/CharSequence;)V", "textOn", "getTextOn", "setTextOn", "value", "thumbConstraintLeft", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintRight", "getThumbConstraintRight", "setThumbConstraintRight", "thumb", "thumbDrawable", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "thumbOffset", "getThumbOffset", "thumbScrollRange", "getThumbScrollRange", "thumbTextPadding", "getThumbTextPadding", "setThumbTextPadding", "tint", "thumbTintList", "getThumbTintList", "()Landroid/content/res/ColorStateList;", "setThumbTintList", "(Landroid/content/res/ColorStateList;)V", "tintMode", "thumbTintMode", "getThumbTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setThumbTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", GXTemplateKey.GAIAX_TRACK, "trackDrawable", "getTrackDrawable", "setTrackDrawable", "trackTintList", "getTrackTintList", "setTrackTintList", "trackTintMode", "getTrackTintMode", "setTrackTintMode", "animateThumbToCheckedState", "", "newCheckedState", "applyThumbTint", "applyTrackTint", "cancelPositionAnimator", "cancelSuperTouch", "ev", "Landroid/view/MotionEvent;", "draw", "c", "Landroid/graphics/Canvas;", "drawableHotspotChanged", "x", "y", "drawableStateChanged", "getCompoundPaddingLeft", "getCompoundPaddingRight", "hitThumb", "jumpDrawablesToCurrentState", "makeLayout", "text", "onCreateDrawableState", "", "extraSpace", "onDraw", "canvas", "onInitializeAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPopulateAccessibilityEvent", "onTouchEvent", "setChecked", "checked", "setCustomSelectionActionModeCallback", "actionModeCallback", "Landroid/view/ActionMode$Callback;", "setSwitchTextAppearance", "resid", "setSwitchTypeface", "typeface", "Landroid/graphics/Typeface;", MLConfigModel.MODEL_TYPE_TF, "style", "setSwitchTypefaceByIndex", "typefaceIndex", "styleIndex", "setThumbPosition", "position", "setThumbResource", "resId", "setTrackResource", "stopDrag", "toggle", "verifyDrawable", "who", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomSwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    public static final Companion Companion = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 260;
    private static final Property<CustomSwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean autoCheck;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private final int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private int mThumbConstraintLeft;
    private int mThumbConstraintRight;
    private float mThumbDragPosition;
    private Drawable mThumbDrawable;
    private int mThumbHeight;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private final int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private final VelocityTracker mVelocityTracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat$Companion;", "", "()V", "ACCESSIBILITY_EVENT_CLASS_NAME", "", "CHECKED_STATE_SET", "", "MONOSPACE", "", "SANS", "SERIF", "THUMB_ANIMATION_DURATION", "THUMB_POS", "Landroid/util/Property;", "Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", "", "TOUCH_MODE_DOWN", "TOUCH_MODE_DRAGGING", "TOUCH_MODE_IDLE", "constrain", "amount", "low", "high", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        private final float constrain(float r100, float r101, float r102) {
            if (r100 >= r101) goto L6;
            return r101;
        L6:
            if (r100 > r102) goto L8;
            return r100;
        L8:
            return r102;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ float access$constrain(Companion r100, float r101, float r102, float r103) {
            return r100.constrain(r101, r102, r103);
        }
    }

    public CustomSwitchCompat(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public CustomSwitchCompat(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    static {
        Companion = new Companion(null);
        final Class r100 = Float.TYPE;
        final String r101 = "thumbPos";
        THUMB_POS = new CustomSwitchCompat$Companion$THUMB_POS$1(r100, r101);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    private final void applyThumbTint() {
        Drawable r100 = this.mThumbDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        if (r100 == null) goto L10;
        Drawable r101 = r100.mutate();
    L11:
        this.mThumbDrawable = r101;
        if (this.mHasThumbTint == false) goto L16;
        if (r101 == null) goto L16;
        DrawableCompat.setTintList(r101, this.mThumbTintList);
    L16:
        if (this.mHasThumbTintMode == false) goto L21;
        Drawable r102 = this.mThumbDrawable;
        PorterDuff.Mode r103 = this.mThumbTintMode;
        if (r102 == null) goto L21;
        if (r103 == null) goto L21;
        DrawableCompat.setTintMode(r102, r103);
    L21:
        Drawable r104 = this.mThumbDrawable;
        if (r104 != null) goto L24;
        return;
    L24:
        if (r104.isStateful() != true) goto L32;
        Drawable r105 = this.mThumbDrawable;
        if (r105 == null) goto L33;
        r105.setState(getDrawableState());
        return;
    L33:
        return;
    L32:
        return;
    L10:
        r101 = null;
        goto L11
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    private final void applyTrackTint() {
        Drawable r100 = this.mTrackDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r101 = r100.mutate();
        this.mTrackDrawable = r101;
        if (this.mHasTrackTint == false) goto L13;
        if (r101 == null) goto L13;
        DrawableCompat.setTintList(r101, this.mTrackTintList);
    L13:
        if (this.mHasTrackTintMode == false) goto L18;
        Drawable r102 = this.mTrackDrawable;
        PorterDuff.Mode r103 = this.mTrackTintMode;
        if (r102 == null) goto L18;
        if (r103 == null) goto L18;
        DrawableCompat.setTintMode(r102, r103);
    L18:
        Drawable r104 = this.mTrackDrawable;
        if (r104 != null) goto L21;
        return;
    L21:
        if (r104.isStateful() != true) goto L29;
        Drawable r105 = this.mTrackDrawable;
        if (r105 == null) goto L30;
        r105.setState(getDrawableState());
        return;
    L30:
        return;
    L29:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    private final void cancelPositionAnimator() {
        ObjectAnimator r100 = this.mPositionAnimator;
        if (r100 == null) goto L7;
        if (r100 == null) goto L8;
        r100.cancel();
        return;
    L8:
        return;
    }

    private final boolean getTargetCheckedState() {
        if (this.mThumbDragPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r100 = this.mTrackDrawable;
        if (r100 == null) goto L12;
        Rect r101 = this.mTempRect;
        if (r100 == null) goto L7;
        r100.getPadding(r101);
    L7:
        Drawable r102 = this.mThumbDrawable;
        if (r102 == null) goto L10;
        Rect r103 = DrawableUtils.getOpticalBounds(r102);
    L14:
        return ((((((this.mSwitchWidth - this.mThumbWidth) - r101.left) - r101.right) - r103.left) - r103.right) - this.mThumbConstraintRight) - this.mThumbConstraintLeft;
    L10:
        r103 = DrawableUtils.INSETS_NONE;
        goto L14
    L12:
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.autoCheck == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r100 = 1 - this.mThumbPosition;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.mThumbPosition;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.mThumbDrawable;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.mTrackDrawable;
        if (r103 != null) goto L10;
    L12:
        if (r102 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r103.isStateful() == false) goto L12;
        r102 = r102 | r103.setState(r100);
        goto L12
    L5:
        if (r101.isStateful() == false) goto L7;
        r102 = false | r101.setState(r100);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r100 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r100 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.mThumbDrawable;
        if (r100 == null) goto L6;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
    L6:
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L10;
        if (r101 == null) goto L10;
        r101.jumpToCurrentState();
    L10:
        ObjectAnimator r102 = this.mPositionAnimator;
        if (r102 == null) goto L20;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isStarted() != true) goto L22;
        ObjectAnimator r103 = this.mPositionAnimator;
        if (r103 == null) goto L18;
        r103.end();
    L18:
        this.mPositionAnimator = null;
        return;
    L22:
        return;
    }

    public final boolean getAutoCheck() {
        return this.autoCheck;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.mPositionAnimator;
    }

    public final float getMThumbPosition() {
        return this.mThumbPosition;
    }

    public final boolean getShowText() {
        return this.mShowText;
    }

    public final boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public final int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public final int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public final CharSequence getTextOff() {
        return this.mTextOff;
    }

    public final CharSequence getTextOn() {
        return this.mTextOn;
    }

    public final int getThumbConstraintLeft() {
        return this.mThumbConstraintLeft;
    }

    public final int getThumbConstraintRight() {
        return this.mThumbConstraintRight;
    }

    public final Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public final int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public final ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public final Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public final ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_CustomSwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void animateThumbToCheckedState(boolean r100) {
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r101});
        this.mPositionAnimator = r102;
        if (r102 == null) goto L9;
        r102.setDuration(260);
    L9:
        ObjectAnimator r103 = this.mPositionAnimator;
        if (r103 == null) goto L12;
        r103.setAutoCancel(true);
    L12:
        ObjectAnimator r104 = this.mPositionAnimator;
        if (r104 == null) goto L15;
        r104.setInterpolator(PathInterpolatorCompat.create(0.46f, 0.81f));
    L15:
        ObjectAnimator r105 = this.mPositionAnimator;
        if (r105 == null) goto L19;
        r105.start();
        return;
    L19:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    private final void cancelSuperTouch(MotionEvent r100) {
        MotionEvent r101 = MotionEvent.obtain(r100);
        r101.setAction(3);
        super.onTouchEvent(r101);
        r101.recycle();
    }

    private final Layout makeLayout(CharSequence r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TransformationMethod r101 = this.mSwitchTransformationMethod;
        if (r101 == null) goto L10;
        if (r101 == null) goto L9;
        r100 = r101.getTransformation(r100, this);
        goto L10
    L9:
        CharSequence r102 = null;
    L11:
        TextPaint r103 = this.mTextPaint;
        if (r102 == null) goto L14;
        int r104 = (int) Math.ceil(Layout.getDesiredWidth(r102, r103));
    L16:
        return new StaticLayout(r102, r103, r104, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L14:
        r104 = 0;
    L10:
        r102 = r100;
        goto L11
    }

    private final void stopDrag(MotionEvent r100) {
        this.mTouchMode = 0;
        boolean r101 = true;
        if (r100.getAction() == 1) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = isChecked();
        if (r102 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r104 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r104) > this.mMinFlingVelocity) goto L13;
        r101 = getTargetCheckedState();
    L23:
        if (r101 == r103) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r101);
        cancelSuperTouch(r100);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L18;
        if (r104 < 0) goto L23;
    L20:
        r101 = false;
        goto L23
    L18:
        if (r104 <= 0) goto L20;
    L22:
        r101 = r103;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Rect r100 = this.mTempRect;
        int r101 = this.mSwitchLeft;
        int r102 = this.mSwitchTop;
        int r103 = this.mSwitchRight;
        int r104 = this.mSwitchBottom;
        int r105 = getThumbOffset() + r101;
        Drawable r106 = this.mThumbDrawable;
        if (r106 == null) goto L5;
        Rect r107 = DrawableUtils.getOpticalBounds(r106);
    L6:
        Drawable r108 = this.mTrackDrawable;
        if (r108 == null) goto L30;
        if (r108 == null) goto L10;
        r108.getPadding(r100);
    L10:
        int r109 = r100.left;
        r105 = r105 + r109;
        if (r107 == null) goto L25;
        int r111 = r107.left;
        if (r111 <= r109) goto L15;
        r101 = r101 + (r111 - r109);
    L15:
        int r112 = r107.top;
        int r113 = r100.top;
        if (r112 <= r113) goto L18;
        int r114 = (r112 - r113) + r102;
    L19:
        int r115 = r107.right;
        int r116 = r100.right;
        if (r115 <= r116) goto L22;
        r103 = r103 - (r115 - r116);
    L22:
        int r117 = r107.bottom;
        int r118 = r100.bottom;
        if (r117 <= r118) goto L26;
        int r119 = r104 - (r117 - r118);
    L27:
        Drawable r120 = this.mTrackDrawable;
        if (r120 == null) goto L30;
        r120.setBounds(r101, r114, r103, r119);
    L26:
        r119 = r104;
        goto L27
    L18:
        r114 = r102;
        goto L19
    L25:
        r114 = r102;
    L30:
        Drawable r121 = this.mThumbDrawable;
        if (r121 == null) goto L40;
        if (r121 == null) goto L34;
        r121.getPadding(r100);
    L34:
        int r122 = r105 - r100.left;
        int r123 = this.mThumbConstraintLeft;
        int r124 = r122 + r123;
        int r125 = ((r105 + this.mThumbWidth) + r100.right) + r123;
        int r126 = this.mThumbHeight;
        int r127 = ((r104 - r102) - r126) / 2;
        Drawable r128 = this.mThumbDrawable;
        if (r128 == null) goto L37;
        r128.setBounds(r124, r127, r125, r126 + r127);
    L37:
        Drawable r129 = getBackground();
        if (r129 == null) goto L40;
        DrawableCompat.setHotspotBounds(r129, r124, r102, r125, r104);
    L40:
        super.draw(r110);
        return;
    L5:
        r107 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        access$mergeDrawableStates$s2666181(r101, CHECKED_STATE_SET);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Rect r100 = this.mTempRect;
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L5;
        r101.getPadding(r100);
    L6:
        int r102 = this.mSwitchTop;
        int r103 = this.mSwitchBottom;
        int r104 = r102 + r100.top;
        int r105 = r103 - r100.bottom;
        Drawable r106 = this.mThumbDrawable;
        if (r101 != null) goto L9;
    L13:
        int r107 = r110.save();
        if (r106 == null) goto L17;
        r106.draw(r110);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r108 = this.mOnLayout;
    L20:
        if (r108 == null) goto L29;
        int[] r109 = getDrawableState();
        ColorStateList r111 = this.mTextColors;
        if (r111 == null) goto L24;
        this.mTextPaint.setColor(r111.getColorForState(r109, 0));
    L24:
        this.mTextPaint.drawableState = r109;
        if (r106 == null) goto L27;
        Rect r112 = r106.getBounds();
        int r113 = r112.left + r112.right;
    L28:
        r110.translate((r113 / 2) - (r108.getWidth() / 2), ((r104 + r105) / 2) - (r108.getHeight() / 2));
        r108.draw(r110);
        goto L29
    L27:
        r113 = getWidth();
    L29:
        r110.restoreToCount(r107);
        return;
    L19:
        r108 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r106 == null) goto L12;
        Rect r114 = DrawableUtils.getOpticalBounds(r106);
        r106.copyBounds(r100);
        r100.left += r114.left;
        r100.right -= r114.right;
        int r115 = r110.save();
        r110.clipRect(r100, Region.Op.DIFFERENCE);
        r101.draw(r110);
        r110.restoreToCount(r115);
    L12:
        r101.draw(r110);
        goto L13
    L5:
        r100.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.mTextOn;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        CharSequence r102 = r100.getText();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r100.setText(r101);
        return;
    L11:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        r103.append(' ');
        r103.append(r101);
        r100.setText(r103);
        return;
    L13:
        return;
    L5:
        r101 = this.mTextOff;
        goto L7
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onPopulateAccessibilityEvent(r100);
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.mTextOn;
    L6:
        if (r101 == null) goto L9;
        r100.getText().add(r101);
        return;
    L9:
        return;
    L5:
        r101 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.mVelocityTracker.addMovement(r100);
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r100);
    L42:
        if (hitThumb(r102, r103) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r102;
        this.mTouchY = r103;
        goto L45
    L5:
        if (r101 == 1) goto L35;
        if (r101 != 2) goto L8;
        int r104 = this.mTouchMode;
        if (r104 == 1) goto L28;
        if (r104 != 2) goto L45;
        float r105 = r100.getX();
        int r106 = getThumbScrollRange();
        float r107 = r105 - this.mTouchX;
        if (r106 == 0) goto L18;
        float r108 = r107 / r106;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r108 = -r108;
    L24:
        float r109 = Companion.access$constrain(Companion, this.mThumbDragPosition + r108, 0.0f, 1.0f);
        if (r109 == this.mThumbDragPosition) goto L27;
        this.mTouchX = r105;
        this.mThumbDragPosition = r109;
    L27:
        return true;
    L18:
        if (r107 <= 0) goto L20;
        r108 = 1.0f;
        goto L22
    L20:
        r108 = -1.0f;
        goto L22
    L28:
        float r110 = r100.getX();
        float r111 = r100.getY();
        if (Math.abs(r110 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r110;
        this.mTouchY = r111;
        return true;
    L31:
        if (Math.abs(r111 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r101 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r100);
        super.onTouchEvent(r100);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    public final void setAutoCheck(boolean r100) {
        this.autoCheck = r100;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        boolean r101 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        cancelPositionAnimator();
        if (r101 == false) goto L10;
        float r102 = 1.0f;
    L11:
        setThumbPosition(r102);
        return;
    L10:
        r102 = 0;
        goto L11
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L7;
        animateThumbToCheckedState(r101);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    public final void setMPositionAnimator(ObjectAnimator r100) {
        this.mPositionAnimator = r100;
    }

    public final void setMThumbPosition(float r100) {
        this.mThumbPosition = r100;
    }

    public final void setShowText(boolean r100) {
        if (this.mShowText == r100) goto L6;
        this.mShowText = r100;
        requestLayout();
        return;
    }

    public final void setSplitTrack(boolean r100) {
        this.mSplitTrack = r100;
        invalidate();
    }

    public final void setSwitchMinWidth(int r100) {
        this.mSwitchMinWidth = r100;
        requestLayout();
    }

    public final void setSwitchPadding(int r100) {
        this.mSwitchPadding = r100;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r100) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if ((!Intrinsics.areEqual(this.mTextPaint.getTypeface(), r100)) == false) goto L7;
    L9:
        this.mTextPaint.setTypeface(r100);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r100 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r100) {
        this.mTextOff = r100;
        requestLayout();
    }

    public final void setTextOn(CharSequence r100) {
        this.mTextOn = r100;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r100) {
        this.mThumbConstraintLeft = r100;
    }

    public final void setThumbConstraintRight(int r100) {
        this.mThumbConstraintRight = r100;
    }

    public final void setThumbDrawable(Drawable r100) {
        Drawable r101 = this.mThumbDrawable;
        if (r101 == null) goto L6;
        if (r101 == null) goto L6;
        r101.setCallback(null);
    L6:
        this.mThumbDrawable = r100;
        if (r100 == null) goto L9;
        r100.setCallback(this);
    L9:
        requestLayout();
    }

    public final void setThumbPosition(float r100) {
        this.mThumbPosition = r100;
        invalidate();
    }

    public final void setThumbResource(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setThumbTextPadding(int r100) {
        this.mThumbTextPadding = r100;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r100) {
        this.mThumbTintList = r100;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public final void setThumbTintMode(PorterDuff.Mode r100) {
        this.mThumbTintMode = r100;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public final void setTrackDrawable(Drawable r100) {
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L6;
        if (r101 == null) goto L6;
        r101.setCallback(null);
    L6:
        this.mTrackDrawable = r100;
        if (r100 == null) goto L9;
        r100.setCallback(this);
    L9:
        requestLayout();
    }

    public final void setTrackResource(int r100) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setTrackTintList(ColorStateList r100) {
        this.mTrackTintList = r100;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public final void setTrackTintMode(PorterDuff.Mode r100) {
        this.mTrackTintMode = r100;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.mThumbDrawable) goto L10;
        if (r100 == this.mTrackDrawable) goto L10;
        return false;
    }

    public static final /* synthetic */ int[] access$mergeDrawableStates$s2666181(int[] r100, int[] r101) {
        return View.mergeDrawableStates(r100, r101);
    }

    private final boolean hitThumb(float r100, float r101) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r102 = getThumbOffset();
        Drawable r103 = this.mThumbDrawable;
        if (r103 == null) goto L8;
        r103.getPadding(this.mTempRect);
    L8:
        int r104 = this.mSwitchTop;
        int r105 = this.mTouchSlop;
        int r106 = r104 - r105;
        int r107 = (this.mSwitchLeft + r102) - r105;
        int r108 = this.mThumbWidth + r107;
        Rect r109 = this.mTempRect;
        int r110 = ((r108 + r109.left) + r109.right) + r105;
        int r111 = this.mSwitchBottom + r105;
        if (r100 > r107) goto L11;
        return false;
    L11:
        if (r100 < r110) goto L13;
        return false;
    L13:
        if (r101 > r106) goto L15;
        return false;
    L15:
        if (r101 >= r111) goto L21;
        return true;
    L21:
        return false;
    }

    private final void setSwitchTypefaceByIndex(int r100, int r101) {
        if (r100 != 1) goto L5;
        Typeface r102 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r102, r101);
        return;
    L5:
        if (r100 != 2) goto L7;
        r102 = Typeface.SERIF;
        goto L12
    L7:
        if (r100 == 3) goto L9;
        r102 = null;
        goto L12
    L9:
        r102 = Typeface.MONOSPACE;
        goto L12
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.mThumbDrawable;
        if (r102 == null) goto L5;
        DrawableCompat.setHotspot(r102, r100, r101);
    L5:
        Drawable r103 = this.mTrackDrawable;
        if (r103 == null) goto L9;
        DrawableCompat.setHotspot(r103, r100, r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r102 = this.mTempRect;
        Drawable r103 = this.mThumbDrawable;
        int r104 = 0;
        if (r103 == null) goto L21;
        if (r103 == null) goto L14;
        r103.getPadding(r102);
    L14:
        Drawable r105 = this.mThumbDrawable;
        if (r105 == null) goto L17;
        int r106 = r105.getIntrinsicWidth();
    L18:
        Drawable r107 = this.mThumbDrawable;
        if (r107 == null) goto L22;
        int r108 = r107.getIntrinsicHeight();
    L24:
        if (this.mShowText == false) goto L34;
        Layout r109 = this.mOnLayout;
        if (r109 == null) goto L28;
        int r110 = r109.getWidth();
    L29:
        Layout r111 = this.mOffLayout;
        if (r111 == null) goto L32;
        int r112 = r111.getWidth();
    L33:
        int r113 = Math.max(r110, r112) + (this.mThumbTextPadding * 2);
    L35:
        this.mThumbWidth = Math.max(r113, r106);
        this.mThumbHeight = r108;
        Drawable r114 = this.mTrackDrawable;
        if (r114 == null) goto L42;
        if (r114 == null) goto L39;
        r114.getPadding(r102);
    L39:
        Drawable r115 = this.mTrackDrawable;
        if (r115 == null) goto L43;
        r104 = r115.getIntrinsicHeight();
    L43:
        int r116 = r102.left;
        int r117 = r102.right;
        Drawable r118 = this.mThumbDrawable;
        if (r118 == null) goto L46;
        Rect r119 = DrawableUtils.getOpticalBounds(r118);
        r116 = Math.max(r116, r119.left);
        r117 = Math.max(r117, r119.right);
    L46:
        int r120 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r116) + r117);
        int r121 = Math.max(r104, r108);
        this.mSwitchWidth = r120;
        this.mSwitchHeight = r121;
        super.onMeasure(r100, r101);
        if (getMeasuredHeight() >= r121) goto L50;
        setMeasuredDimension(getMeasuredWidthAndState(), r121);
        return;
    L50:
        return;
    L42:
        r102.setEmpty();
        goto L43
    L32:
        r112 = 0;
        goto L33
    L28:
        r110 = 0;
        goto L29
    L34:
        r113 = 0;
    L22:
        r108 = 0;
        goto L24
    L17:
        r106 = (0 - r102.left) - r102.right;
        goto L18
    L21:
        r106 = 0;
        goto L22
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOn);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOff);
        goto L10
    }

    public final void setSwitchTextAppearance(Context r100, int r101) {
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        ColorStateList r103 = r102.getColorStateList(3);
        if (r103 != null) goto L5;
        r103 = getTextColors();
    L5:
        this.mTextColors = r103;
        int r104 = r102.getDimensionPixelSize(0, 0);
        if (r104 == 0) goto L10;
        float r105 = r104;
        if (r105 == this.mTextPaint.getTextSize()) goto L10;
        this.mTextPaint.setTextSize(r105);
        requestLayout();
    L10:
        setSwitchTypefaceByIndex(r102.getInt(1, -1), r102.getInt(2, -1));
        if (r102.getBoolean(14, false) == false) goto L13;
        AllCapsTransformationMethod r106 = new AllCapsTransformationMethod(getContext());
    L14:
        this.mSwitchTransformationMethod = r106;
        r102.recycle();
        return;
    L13:
        r106 = null;
        goto L14
    }

    public final void setSwitchTypeface(Typeface r100, int r101) {
        float r102 = 0.0f;
        boolean r103 = false;
        if (r101 <= 0) goto L18;
        if (r100 != null) goto L6;
        Typeface r104 = Typeface.defaultFromStyle(r101);
    L7:
        setSwitchTypeface(r104);
        if (r104 == null) goto L10;
        int r105 = r104.getStyle();
    L11:
        int r106 = (~r105) & r101;
        TextPaint r107 = this.mTextPaint;
        if ((r106 & 1) == 0) goto L14;
        r103 = true;
    L14:
        r107.setFakeBoldText(r103);
        TextPaint r108 = this.mTextPaint;
        if ((r106 & 2) == 0) goto L17;
        r102 = -0.25f;
    L17:
        r108.setTextSkewX(r102);
        return;
    L10:
        r105 = 0;
        goto L11
    L6:
        r104 = Typeface.create(r100, r101);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r100);
    }

    public CustomSwitchCompat(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.autoCheck = true;
        TextPaint r103 = new TextPaint(1);
        this.mTextPaint = r103;
        r103.density = INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_CustomSwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density;
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, com.larus.nova.R.attr.showText, com.larus.nova.R.attr.splitTrack, com.larus.nova.R.attr.switchMinWidth, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchTextAppearance, com.larus.nova.R.attr.thumbTextPadding, com.larus.nova.R.attr.thumbTint, com.larus.nova.R.attr.thumbTintMode, com.larus.nova.R.attr.track, com.larus.nova.R.attr.trackTint, com.larus.nova.R.attr.trackTintMode}, r102, 0);
        Drawable r105 = r104.getDrawable(2);
        this.mThumbDrawable = r105;
        if (r105 == null) goto L6;
        if (r105 == null) goto L6;
        r105.setCallback(this);
    L6:
        Drawable r106 = r104.getDrawable(11);
        this.mTrackDrawable = r106;
        if (r106 == null) goto L10;
        if (r106 == null) goto L10;
        r106.setCallback(this);
    L10:
        this.mTextOn = r104.getText(0);
        this.mTextOff = r104.getText(1);
        this.mShowText = r104.getBoolean(3, true);
        this.mThumbTextPadding = r104.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = r104.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = r104.getDimensionPixelSize(6, 0);
        this.mSplitTrack = r104.getBoolean(4, false);
        ColorStateList r107 = r104.getColorStateList(9);
        if (r107 == null) goto L13;
        this.mThumbTintList = r107;
        this.mHasThumbTint = true;
    L13:
        PorterDuff.Mode r108 = DrawableUtils.parseTintMode(r104.getInt(10, -1), null);
        if (this.mThumbTintMode == r108) goto L17;
        this.mThumbTintMode = r108;
        this.mHasThumbTintMode = true;
    L17:
        if (this.mHasThumbTint == false) goto L19;
    L20:
        applyThumbTint();
    L21:
        ColorStateList r109 = r104.getColorStateList(12);
        if (r109 == null) goto L24;
        this.mTrackTintList = r109;
        this.mHasTrackTint = true;
    L24:
        PorterDuff.Mode r110 = DrawableUtils.parseTintMode(r104.getInt(13, -1), null);
        if (this.mTrackTintMode == r110) goto L28;
        this.mTrackTintMode = r110;
        this.mHasTrackTintMode = true;
    L28:
        if (this.mHasTrackTint == false) goto L30;
    L31:
        applyTrackTint();
    L32:
        int r111 = r104.getResourceId(7, 0);
        if (r111 == 0) goto L35;
        setSwitchTextAppearance(r100, r111);
    L35:
        r104.recycle();
        Intrinsics.checkNotNull(r100);
        ViewConfiguration r112 = ViewConfiguration.get(r100);
        this.mTouchSlop = r112.getScaledTouchSlop();
        this.mMinFlingVelocity = r112.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L30:
        if (this.mHasTrackTintMode == false) goto L32;
    L19:
        if (this.mHasThumbTintMode == false) goto L21;
        goto L20
    }

    public /* synthetic */ CustomSwitchCompat(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = com.larus.nova.R.attr.switchStyle;
    L8:
        this(r100, r101, r102);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        if (this.mThumbDrawable == null) goto L10;
        Rect r106 = this.mTempRect;
        Drawable r107 = this.mTrackDrawable;
        if (r107 == null) goto L8;
        if (r107 == null) goto L9;
        r107.getPadding(r106);
    L9:
        Rect r108 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        int r109 = Math.max(0, r108.left - r106.left);
        r105 = Math.max(0, r108.right - r106.right);
    L12:
        if (ViewUtils.isLayoutRtl(this) == false) goto L14;
        int r110 = getPaddingLeft() + r109;
        int r111 = ((this.mSwitchWidth + r110) - r109) - r105;
    L15:
        int r112 = getGravity() & 112;
        if (r112 != 16) goto L18;
        int r113 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r114 = this.mSwitchHeight;
        int r115 = r113 - (r114 / 2);
    L25:
        int r116 = r114 + r115;
    L26:
        this.mSwitchLeft = r110;
        this.mSwitchTop = r115;
        this.mSwitchBottom = r116;
        this.mSwitchRight = r111;
        return;
    L18:
        if (r112 != 48) goto L20;
        r115 = getPaddingTop();
        r114 = this.mSwitchHeight;
        goto L25
    L20:
        if (r112 == 80) goto L22;
        r115 = getPaddingTop();
        r114 = this.mSwitchHeight;
        goto L25
    L22:
        r116 = getHeight() - getPaddingBottom();
        r115 = r116 - this.mSwitchHeight;
        goto L26
    L14:
        r111 = (getWidth() - getPaddingRight()) - r105;
        r110 = ((r111 - this.mSwitchWidth) + r109) + r105;
        goto L15
    L8:
        r106.setEmpty();
        goto L9
    L10:
        r109 = 0;
        goto L12
    }
}
