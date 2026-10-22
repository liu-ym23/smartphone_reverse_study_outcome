package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
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
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.r;
import androidx.core.widget.TextViewCompat;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bH\b\u0017\u0018\u0000 \u009d\u00022\u00020\u0001:\u0001\u0011B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u0010J\u001f\u0010(\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u001f\u0010-\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010*¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\b5\u00104J\u001f\u00108\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\u000eJ\u0019\u0010;\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u000109H\u0014¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bA\u0010BJ\u0015\u0010D\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u0018¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\fH\u0016¢\u0006\u0004\bF\u0010\u0010J\u000f\u0010G\u001a\u00020\u001bH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u001bH\u0016¢\u0006\u0004\bJ\u0010%J\u0017\u0010K\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u001bH\u0016¢\u0006\u0004\bK\u0010%J\u0017\u0010L\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u001bH\u0017¢\u0006\u0004\bL\u0010%J\r\u0010M\u001a\u00020\u001b¢\u0006\u0004\bM\u0010HJ7\u0010S\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006H\u0014¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\f2\u0006\u0010X\u001a\u00020UH\u0014¢\u0006\u0004\bY\u0010WJ\u000f\u0010Z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\\\u0010[J\u0017\u0010_\u001a\u00020^2\u0006\u0010]\u001a\u00020\u0006H\u0014¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0014¢\u0006\u0004\ba\u0010\u0010J\u001f\u0010b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020dH\u0014¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\fH\u0016¢\u0006\u0004\bh\u0010\u0010J\u0017\u0010i\u001a\u00020\f2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bi\u0010@J\u0017\u0010l\u001a\u00020\f2\u0006\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bl\u0010mJ\u0017\u0010p\u001a\u00020\f2\u0006\u0010o\u001a\u00020nH\u0016¢\u0006\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010xR\u0016\u0010{\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010zR\u0016\u0010|\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010zR\u0018\u0010}\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010rR\u0018\u0010~\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010uR\u0018\u0010\u007f\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010xR\u0017\u0010\u0080\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010zR\u0017\u0010\u0081\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010zR\u0018\u0010\u0083\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0082\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010zR\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008a\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010zR\u0019\u0010\u0091\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0082\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0082\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0095\u0001R\"\u0010\u009d\u0001\u001a\r \u009a\u0001*\u0005\u0018\u00010\u0099\u00010\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0082\u0001R'\u0010£\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0019\u0010\u0095\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010ER\u0018\u0010¤\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010\u0082\u0001R\u0019\u0010¦\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0082\u0001R\u0019\u0010¨\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0082\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0082\u0001R\u0019\u0010¬\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u0082\u0001R\u0019\u0010®\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010\u0082\u0001R\u0019\u0010°\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0082\u0001R\u0019\u0010±\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0082\u0001R\u0019\u0010³\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010\u0082\u0001R\u0018\u0010·\u0001\u001a\u00030´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010¸\u0001\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010uR\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R,\u0010É\u0001\u001a\u0005\u0018\u00010Â\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R\u0018\u0010Í\u0001\u001a\u00030Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0082\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u0082\u0001R&\u0010Õ\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010z\u001a\u0005\bÓ\u0001\u0010H\"\u0005\bÔ\u0001\u0010%R\u0018\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0019\u0010Û\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010\u0095\u0001R\u0016\u0010Ý\u0001\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010HR\u0016\u0010ß\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010[R\u0016\u0010á\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bà\u0001\u0010[R(\u0010å\u0001\u001a\u00020\u00062\u0007\u0010â\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bã\u0001\u0010[\"\u0005\bä\u0001\u00104R(\u0010è\u0001\u001a\u00020\u00062\u0007\u0010â\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bæ\u0001\u0010[\"\u0005\bç\u0001\u00104R(\u0010ì\u0001\u001a\u00020\u00062\u0007\u0010é\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bê\u0001\u0010[\"\u0005\bë\u0001\u00104R(\u0010ï\u0001\u001a\u00020\u00062\u0007\u0010é\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bí\u0001\u0010[\"\u0005\bî\u0001\u00104R(\u0010ò\u0001\u001a\u00020\u00062\u0007\u0010é\u0001\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bð\u0001\u0010[\"\u0005\bñ\u0001\u00104R.\u0010ø\u0001\u001a\u0004\u0018\u00010d2\t\u0010ó\u0001\u001a\u0004\u0018\u00010d8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R.\u0010þ\u0001\u001a\u0004\u0018\u00010t2\t\u0010ù\u0001\u001a\u0004\u0018\u00010t8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R.\u0010\u0084\u0002\u001a\u0004\u0018\u00010w2\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010w8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R.\u0010\u0088\u0002\u001a\u0004\u0018\u00010d2\t\u0010\u0085\u0002\u001a\u0004\u0018\u00010d8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0086\u0002\u0010õ\u0001\"\u0006\b\u0087\u0002\u0010÷\u0001R.\u0010\u008b\u0002\u001a\u0004\u0018\u00010t2\t\u0010ù\u0001\u001a\u0004\u0018\u00010t8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0089\u0002\u0010û\u0001\"\u0006\b\u008a\u0002\u0010ý\u0001R.\u0010\u008e\u0002\u001a\u0004\u0018\u00010w2\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010w8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008c\u0002\u0010\u0081\u0002\"\u0006\b\u008d\u0002\u0010\u0083\u0002R(\u0010\u008f\u0002\u001a\u00020\u001b2\u0007\u0010\u008f\u0002\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0002\u0010H\"\u0005\b\u0091\u0002\u0010%R.\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00132\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R.\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00132\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0098\u0002\u0010\u0094\u0002\"\u0006\b\u0099\u0002\u0010\u0096\u0002R(\u0010\u009a\u0002\u001a\u00020\u001b2\u0007\u0010\u009a\u0002\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0002\u0010H\"\u0005\b\u009c\u0002\u0010%¨\u0006\u009e\u0002"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "typefaceIndex", "styleIndex", "", "l", "(II)V", "c", "()V", "b", "i", "", "text", "Landroid/text/Layout;", "g", "(Ljava/lang/CharSequence;)Landroid/text/Layout;", "", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, "", "f", "(FF)Z", "Landroid/view/MotionEvent;", "ev", "cancelSuperTouch", "(Landroid/view/MotionEvent;)V", "stopDrag", "newCheckedState", "a", "(Z)V", "d", "resid", "j", "(Landroid/content/Context;I)V", "Landroid/graphics/Typeface;", "tf", "style", "k", "(Landroid/graphics/Typeface;I)V", "typeface", "setSwitchTypeface", "(Landroid/graphics/Typeface;)V", "resId", "setTrackResource", "(I)V", "setThumbResource", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/accessibility/AccessibilityEvent;", "event", "onPopulateAccessibilityEvent", "(Landroid/view/accessibility/AccessibilityEvent;)V", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "position", "setThumbPosition", "(F)V", "toggle", "performClick", "()Z", CommonConfirmDialog.ARGS_CHECKED, "h", "setChecked", "setCheckedNoAnim", "e", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "draw", "(Landroid/graphics/Canvas;)V", "canvas", "onDraw", "getCompoundPaddingLeft", "()I", "getCompoundPaddingRight", "extraSpace", "", "onCreateDrawableState", "(I)[I", "drawableStateChanged", "drawableHotspotChanged", "(FF)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "jumpDrawablesToCurrentState", "onInitializeAccessibilityEvent", "Landroid/view/accessibility/AccessibilityNodeInfo;", ServerElements.INFO, "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "Landroid/graphics/drawable/Drawable;", "mThumbDrawable", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "mThumbTintList", "Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/PorterDuff$Mode;", "mThumbTintMode", "Z", "mHasThumbTint", "mHasThumbTintMode", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mHasTrackTint", "mHasTrackTintMode", "I", "mThumbTextPadding", "mSwitchMinWidth", "m", "mSwitchPadding", "n", "mSplitTrack", "o", "Ljava/lang/CharSequence;", "mTextOn", "p", "mTextOff", "q", "mShowText", "r", "mTouchMode", "s", "mTouchSlop", "t", "F", "mTouchX", "u", "mTouchY", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "v", "Landroid/view/VelocityTracker;", "mVelocityTracker", "w", "mMinFlingVelocity", "getMThumbPosition", "()F", "setMThumbPosition", "mThumbPosition", "mSwitchWidth", "z", "switchWidthOffsetPx", "A", "mSwitchHeight", "B", "mThumbWidth", "C", "mThumbHeight", "D", "mSwitchLeft", "E", "mSwitchTop", "mSwitchRight", "G", "mSwitchBottom", "Landroid/text/TextPaint;", "H", "Landroid/text/TextPaint;", "mTextPaint", "mTextColors", "J", "Landroid/text/Layout;", "mOnLayout", "K", "mOffLayout", "Landroid/text/method/TransformationMethod;", "L", "Landroid/text/method/TransformationMethod;", "mSwitchTransformationMethod", "Landroid/animation/ObjectAnimator;", "M", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "Landroid/graphics/Rect;", "N", "Landroid/graphics/Rect;", "mTempRect", "O", "mThumbConstraintLeft", "P", "mThumbConstraintRight", "Q", "getAutoCheck", "setAutoCheck", "autoCheck", "Landroid/view/animation/PathInterpolator;", "R", "Landroid/view/animation/PathInterpolator;", "thumbAnimInterpolator", "S", "mThumbDragPosition", "getTargetCheckedState", "targetCheckedState", "getThumbOffset", "thumbOffset", "getThumbScrollRange", "thumbScrollRange", CommonKey.KEY_VALUE, "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintLeft", "getThumbConstraintRight", "setThumbConstraintRight", "thumbConstraintRight", "pixels", "getSwitchPadding", "setSwitchPadding", "switchPadding", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "track", "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "tint", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "tintMode", "getTrackTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTrackTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "trackTintMode", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "getThumbTintList", "setThumbTintList", "thumbTintList", "getThumbTintMode", "setThumbTintMode", "thumbTintMode", "splitTrack", "getSplitTrack", "setSplitTrack", "textOn", "getTextOn", "()Ljava/lang/CharSequence;", "setTextOn", "(Ljava/lang/CharSequence;)V", "textOff", "getTextOff", "setTextOff", "showText", "getShowText", "setShowText", "T", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
public class SwitchCompat extends CompoundButton {
    public static final b T = null;
    public static final Property U = null;
    public static final int[] V = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public final TextPaint H;
    public ColorStateList I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Layout f15714J;
    public Layout K;
    public TransformationMethod L;
    public ObjectAnimator M;
    public final Rect N;
    public int O;
    public int P;
    public boolean Q;
    public final PathInterpolator R;
    public float S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f15715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f15716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f15717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f15720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f15721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f15722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f15729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f15730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f15733s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f15734t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f15735u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final VelocityTracker f15736v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f15737w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f15738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f15739y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f15740z;

    public static final class a extends Property {
        public a(Class r10) {
            super(r10, "thumbPos");
        }

        public Float a(SwitchCompat r10) {
            q.g(r10, "object");
            return Float.valueOf(r10.getMThumbPosition());
        }

        public void b(SwitchCompat r10, float r11) {
            q.g(r10, "object");
            r10.setThumbPosition(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((SwitchCompat) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((SwitchCompat) r10, ((Number) r11).floatValue());
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ float a(b r10, float r11, float r12, float r13) {
            return r10.b(r11, r12, r13);
        }

        public final float b(float r10, float r11, float r12) {
            if (r10 >= r11) goto L6;
            return r11;
        L6:
            if (r10 > r12) goto L8;
            return r10;
        L8:
            return r12;
        }

        public b() {
        }
    }

    static {
        T = new b(null);
        U = new a(Float.TYPE);
        V = new int[]{R.attr.state_checked};
    }

    @JvmOverloads
    public SwitchCompat(@Nullable Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void cancelSuperTouch(MotionEvent r10) {
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.setAction(3);
        super.onTouchEvent(r11);
        r11.recycle();
    }

    private final boolean getTargetCheckedState() {
        if (this.S <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (i0.b(this) == false) goto L5;
        float r10 = 1 - this.f15738x;
    L7:
        return (int) ((r10 * getThumbScrollRange()) + 0.5f);
    L5:
        r10 = this.f15738x;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r10 = this.f15720f;
        if (r10 == null) goto L9;
        Rect r11 = this.N;
        q.d(r10);
        r10.getPadding(r11);
        Drawable r12 = this.f15715a;
        if (r12 == null) goto L7;
        Rect r13 = r.d(r12);
        q.f(r13, "{\n                Drawab…mbDrawable)\n            }");
    L11:
        return ((((((this.f15739y - this.B) - r11.left) - r11.right) - r13.left) - r13.right) - this.P) - this.O;
    L7:
        r13 = r.f1087c;
        q.f(r13, "{\n                Drawab…INSETS_NONE\n            }");
        goto L11
    L9:
        return 0;
    }

    private final void stopDrag(MotionEvent r10) {
        this.f15732r = 0;
        boolean r11 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        boolean r12 = false;
    L8:
        boolean r13 = isChecked();
        if (r12 == false) goto L22;
        this.f15736v.computeCurrentVelocity(1000);
        float r14 = this.f15736v.getXVelocity();
        if (Math.abs(r14) > this.f15737w) goto L13;
        r11 = getTargetCheckedState();
    L23:
        if (r11 == r13) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r11);
        cancelSuperTouch(r10);
        return;
    L13:
        if (i0.b(this) == false) goto L19;
        if (r14 < 0.0f) goto L23;
    L17:
        r11 = false;
        goto L23
    L19:
        if (r14 <= 0.0f) goto L17;
    L22:
        r11 = r13;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r12 = true;
        goto L8
    }

    public final void a(boolean r10) {
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this, U, new float[]{r11});
        this.M = r12;
        if (r12 == null) goto L10;
        r12.setDuration(443);
    L10:
        ObjectAnimator r13 = this.M;
        if (r13 == null) goto L14;
        r13.setAutoCancel(true);
    L14:
        ObjectAnimator r14 = this.M;
        if (r14 == null) goto L18;
        r14.setInterpolator(this.R);
    L18:
        ObjectAnimator r15 = this.M;
        if (r15 == null) goto L23;
        r15.start();
        return;
    L23:
        return;
    L5:
        r11 = 0.0f;
        goto L6
    }

    public final void b() {
        Drawable r10 = this.f15715a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f15718d == false) goto L7;
    L8:
        q.d(r10);
        Drawable r11 = r10.mutate();
        this.f15715a = r11;
        if (this.f15718d == false) goto L12;
        q.d(r11);
        o.a.i(r11, this.f15716b);
    L12:
        if (this.f15719e == false) goto L14;
        Drawable r12 = this.f15715a;
        q.d(r12);
        PorterDuff.Mode r13 = this.f15717c;
        q.d(r13);
        o.a.j(r12, r13);
    L14:
        Drawable r14 = this.f15715a;
        q.d(r14);
        if (r14.isStateful() == false) goto L20;
        Drawable r15 = this.f15715a;
        q.d(r15);
        r15.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f15719e == true) goto L8;
    }

    public final void c() {
        Drawable r10 = this.f15720f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f15723i == false) goto L7;
    L8:
        q.d(r10);
        Drawable r11 = r10.mutate();
        this.f15720f = r11;
        if (this.f15723i == false) goto L12;
        q.d(r11);
        o.a.i(r11, this.f15721g);
    L12:
        if (this.f15724j == false) goto L14;
        Drawable r12 = this.f15720f;
        q.d(r12);
        PorterDuff.Mode r13 = this.f15722h;
        q.d(r13);
        o.a.j(r12, r13);
    L14:
        Drawable r14 = this.f15720f;
        q.d(r14);
        if (r14.isStateful() == false) goto L20;
        Drawable r15 = this.f15720f;
        q.d(r15);
        r15.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f15724j == true) goto L8;
    }

    public final void d() {
        ObjectAnimator r10 = this.M;
        if (r10 == null) goto L6;
        q.d(r10);
        r10.cancel();
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        q.g(r11, "c");
        Rect r10 = this.N;
        int r12 = this.D;
        int r13 = this.E;
        int r14 = this.F;
        int r15 = this.G;
        int r16 = getThumbOffset() + r12;
        Drawable r17 = this.f15715a;
        if (r17 == null) goto L5;
        Rect r18 = r.d(r17);
    L6:
        Drawable r19 = this.f15720f;
        if (r19 == null) goto L26;
        q.d(r19);
        r19.getPadding(r10);
        int r20 = r10.left;
        r16 = r16 + r20;
        if (r18 == null) goto L24;
        int r21 = r18.left;
        if (r21 <= r20) goto L13;
        r12 = r12 + (r21 - r20);
    L13:
        int r22 = r18.top;
        int r23 = r10.top;
        if (r22 <= r23) goto L16;
        int r24 = (r22 - r23) + r13;
    L17:
        int r25 = r18.right;
        int r26 = r10.right;
        if (r25 <= r26) goto L20;
        r14 = r14 - (r25 - r26);
    L20:
        int r27 = r18.bottom;
        int r28 = r10.bottom;
        if (r27 <= r28) goto L23;
        int r29 = r15 - (r27 - r28);
    L25:
        Drawable r30 = this.f15720f;
        q.d(r30);
        r30.setBounds(r12, r24, r14, r29);
    L23:
        r29 = r15;
        goto L25
    L16:
        r24 = r13;
        goto L17
    L24:
        r24 = r13;
    L26:
        Drawable r31 = this.f15715a;
        if (r31 == null) goto L31;
        q.d(r31);
        r31.getPadding(r10);
        int r32 = r16 - r10.left;
        int r33 = this.O;
        int r34 = r32 + r33;
        int r35 = ((r16 + this.B) + r10.right) + r33;
        int r36 = ((r15 - r13) - this.C) / 2;
        Drawable r37 = this.f15715a;
        q.d(r37);
        r37.setBounds(r34, r36, r35, this.C + r36);
        Drawable r38 = getBackground();
        if (r38 == null) goto L31;
        o.a.f(r38, r34, r13, r35, r15);
    L31:
        super.draw(r11);
        return;
    L5:
        r18 = r.f1087c;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r10, float r11) {
        super.drawableHotspotChanged(r10, r11);
        Drawable r12 = this.f15715a;
        if (r12 == null) goto L5;
        q.d(r12);
        o.a.e(r12, r10, r11);
    L5:
        Drawable r13 = this.f15720f;
        if (r13 == null) goto L9;
        q.d(r13);
        o.a.e(r13, r10, r11);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.f15715a;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Drawable r13 = this.f15720f;
        if (r13 != null) goto L11;
    L13:
        if (r12 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r13.isStateful() == false) goto L13;
        r12 = r12 | r13.setState(r10);
        goto L13
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = r11.setState(r10);
        goto L8
    }

    public final boolean e() {
        if (getWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (getHeight() <= 0) goto L7;
        return true;
    }

    public final boolean f(float r10, float r11) {
        if (this.f15715a != null) goto L5;
        return false;
    L5:
        int r12 = getThumbOffset();
        Drawable r13 = this.f15715a;
        q.d(r13);
        r13.getPadding(this.N);
        int r14 = this.E;
        int r15 = this.f15733s;
        int r16 = r14 - r15;
        int r17 = (this.D + r12) - r15;
        int r18 = this.B + r17;
        Rect r19 = this.N;
        int r20 = ((r18 + r19.left) + r19.right) + r15;
        int r21 = this.G + r15;
        if (r10 > r17) goto L8;
        return false;
    L8:
        if (r10 < r20) goto L10;
        return false;
    L10:
        if (r11 > r16) goto L12;
        return false;
    L12:
        if (r11 >= r21) goto L18;
        return true;
    L18:
        return false;
    }

    public final Layout g(CharSequence r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        TransformationMethod r11 = this.L;
        if (r11 == null) goto L8;
        q.d(r11);
        r10 = r11.getTransformation(r10, this);
    L8:
        CharSequence r12 = r10;
        TextPaint r13 = this.H;
        if (r12 == null) goto L12;
        int r14 = (int) Math.ceil(Layout.getDesiredWidth(r12, r13));
    L14:
        return new StaticLayout(r12, r13, r14, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L12:
        r14 = 0;
        goto L14
    }

    public final boolean getAutoCheck() {
        return this.Q;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (i0.b(this) == false) goto L5;
        int r10 = super.getCompoundPaddingLeft() + this.f15739y;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.f15727m;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (i0.b(this) == true) goto L5;
        int r10 = super.getCompoundPaddingRight() + this.f15739y;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.f15727m;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Nullable
    public final ObjectAnimator getMPositionAnimator() {
        return this.M;
    }

    public final float getMThumbPosition() {
        return this.f15738x;
    }

    public final boolean getShowText() {
        return this.f15731q;
    }

    public final boolean getSplitTrack() {
        return this.f15728n;
    }

    public final int getSwitchMinWidth() {
        return this.f15726l;
    }

    public final int getSwitchPadding() {
        return this.f15727m;
    }

    @Nullable
    public final CharSequence getTextOff() {
        return this.f15730p;
    }

    @Nullable
    public final CharSequence getTextOn() {
        return this.f15729o;
    }

    public final int getThumbConstraintLeft() {
        return this.O;
    }

    public final int getThumbConstraintRight() {
        return this.P;
    }

    @Nullable
    public final Drawable getThumbDrawable() {
        return this.f15715a;
    }

    public final int getThumbTextPadding() {
        return this.f15725k;
    }

    @Nullable
    public final ColorStateList getThumbTintList() {
        return this.f15716b;
    }

    @Nullable
    public final PorterDuff.Mode getThumbTintMode() {
        return this.f15717c;
    }

    @Nullable
    public final Drawable getTrackDrawable() {
        return this.f15720f;
    }

    @Nullable
    public final ColorStateList getTrackTintList() {
        return this.f15721g;
    }

    @Nullable
    public final PorterDuff.Mode getTrackTintMode() {
        return this.f15722h;
    }

    public void h(boolean r10) {
        if (r10 == false) goto L4;
        dd.a.b(getContext(), 4);
        return;
    L4:
        dd.a.b(getContext(), 5);
    }

    public final void i() {
        this.f15740z = f.r(this, 4);
    }

    public final void j(Context r10, int r11) {
        b0 r12 = b0.t(r10, r11, R$styleable.TextAppearance);
        ColorStateList r13 = r12.c(R$styleable.TextAppearance_android_textColor);
        if (r13 != null) goto L5;
        r13 = getTextColors();
    L5:
        this.I = r13;
        int r14 = r12.f(R$styleable.TextAppearance_android_textSize, 0);
        if (r14 == 0) goto L11;
        float r15 = r14;
        if (r15 == this.H.getTextSize()) goto L11;
        this.H.setTextSize(r15);
        requestLayout();
    L11:
        l(r12.k(R$styleable.TextAppearance_android_typeface, -1), r12.k(R$styleable.TextAppearance_android_textStyle, -1));
        if (r12.a(R$styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        f.a r16 = new f.a(getContext());
    L15:
        this.L = r16;
        r12.w();
        return;
    L14:
        r16 = null;
        goto L15
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.f15715a;
        if (r10 == null) goto L5;
        q.d(r10);
        r10.jumpToCurrentState();
    L5:
        Drawable r11 = this.f15720f;
        if (r11 == null) goto L8;
        q.d(r11);
        r11.jumpToCurrentState();
    L8:
        ObjectAnimator r12 = this.M;
        if (r12 == null) goto L14;
        q.d(r12);
        if (r12.isStarted() == false) goto L15;
        ObjectAnimator r13 = this.M;
        q.d(r13);
        r13.end();
        this.M = null;
        return;
    L15:
        return;
    }

    public final void k(Typeface r10, int r11) {
        float r12 = 0.0f;
        boolean r13 = false;
        if (r11 <= 0) goto L18;
        if (r10 != null) goto L6;
        Typeface r14 = Typeface.defaultFromStyle(r11);
    L7:
        setSwitchTypeface(r14);
        if (r14 != null) goto L10;
        int r15 = 0;
    L11:
        int r16 = (~r15) & r11;
        TextPaint r17 = this.H;
        if ((r16 & 1) == 0) goto L14;
        r13 = true;
    L14:
        r17.setFakeBoldText(r13);
        TextPaint r18 = this.H;
        if ((r16 & 2) == 0) goto L17;
        r12 = -0.25f;
    L17:
        r18.setTextSkewX(r12);
        return;
    L10:
        r15 = r14.getStyle();
        goto L11
    L6:
        r14 = Typeface.create(r10, r11);
        goto L7
    L18:
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(r10);
    }

    public final void l(int r10, int r11) {
        if (r10 != 1) goto L5;
        Typeface r12 = Typeface.SANS_SERIF;
    L12:
        k(r12, r11);
        return;
    L5:
        if (r10 != 2) goto L7;
        r12 = Typeface.SERIF;
        goto L12
    L7:
        if (r10 == 3) goto L9;
        r12 = null;
        goto L12
    L9:
        r12 = Typeface.MONOSPACE;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        i();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r11, V);
    L5:
        q.f(r11, "drawableState");
        return r11;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
        Rect r11 = this.N;
        Drawable r12 = this.f15720f;
        if (r12 != null) goto L5;
        Boolean r13 = null;
    L6:
        if (r13 != null) goto L8;
        r11.setEmpty();
        Unit r14 = Unit.f21064a;
    L8:
        int r15 = this.E;
        int r16 = this.G;
        int r17 = r15 + r11.top;
        int r18 = r16 - r11.bottom;
        Drawable r19 = this.f15715a;
        if (r12 != null) goto L11;
    L15:
        int r20 = r10.save();
        if (r19 == null) goto L20;
        r19.draw(r10);
    L20:
        if (getTargetCheckedState() == false) goto L22;
        Layout r21 = this.f15714J;
    L23:
        if (r21 == null) goto L32;
        int[] r22 = getDrawableState();
        ColorStateList r23 = this.I;
        if (r23 == null) goto L27;
        TextPaint r24 = this.H;
        q.d(r23);
        r24.setColor(r23.getColorForState(r22, 0));
    L27:
        this.H.drawableState = r22;
        if (r19 == null) goto L30;
        Rect r25 = r19.getBounds();
        q.f(r25, "thumbDrawable.bounds");
        int r26 = r25.left + r25.right;
    L31:
        r10.translate((r26 / 2) - (r21.getWidth() / 2), ((r17 + r18) / 2) - (r21.getHeight() / 2));
        r21.draw(r10);
        goto L32
    L30:
        r26 = getWidth();
    L32:
        r10.restoreToCount(r20);
        return;
    L22:
        r21 = this.K;
        goto L23
    L11:
        if (this.f15728n == false) goto L14;
        if (r19 == null) goto L14;
        Rect r27 = r.d(r19);
        r19.copyBounds(r11);
        r11.left += r27.left;
        r11.right -= r27.right;
        int r28 = r10.save();
        r10.clipRect(r11, Region.Op.DIFFERENCE);
        r12.draw(r10);
        r10.restoreToCount(r28);
    L14:
        r12.draw(r10);
        goto L15
    L5:
        r13 = Boolean.valueOf(r12.getPadding(r11));
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NotNull AccessibilityEvent r10) {
        q.g(r10, "event");
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        q.g(r10, ServerElements.INFO);
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r11 = this.f15729o;
    L7:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        CharSequence r12 = r10.getText();
        if (TextUtils.isEmpty(r12) == false) goto L11;
        r10.setText(r11);
        return;
    L11:
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        r13.append(TokenParser.SP);
        r13.append(r11);
        r10.setText(r13);
        return;
    L13:
        return;
    L5:
        r11 = this.f15730p;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = 0;
        if (this.f15715a == null) goto L9;
        Rect r16 = this.N;
        Drawable r17 = this.f15720f;
        if (r17 == null) goto L7;
        q.d(r17);
        r17.getPadding(r16);
    L8:
        Rect r18 = r.d(this.f15715a);
        int r19 = Math.max(0, r18.left - r16.left);
        r15 = Math.max(0, r18.right - r16.right);
    L11:
        if (i0.b(this) == false) goto L13;
        int r20 = getPaddingLeft() + r19;
        int r21 = ((this.f15739y + r20) - r19) - r15;
    L14:
        int r22 = getGravity() & 112;
        if (r22 != 16) goto L17;
        int r23 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r24 = this.A;
        int r25 = r23 - (r24 / 2);
    L21:
        int r26 = r24 + r25;
    L25:
        this.D = r20;
        this.E = r25;
        this.G = r26;
        this.F = r21;
        return;
    L17:
        if (r22 != 48) goto L19;
        r25 = getPaddingTop();
        r24 = this.A;
        goto L21
    L19:
        if (r22 == 80) goto L22;
        r25 = getPaddingTop();
        r24 = this.A;
        goto L21
    L22:
        r26 = getHeight() - getPaddingBottom();
        r25 = r26 - this.A;
        goto L25
    L13:
        r21 = (getWidth() - getPaddingRight()) - r15;
        r20 = ((r21 - this.f15739y) + r19) + r15;
        goto L14
    L7:
        r16.setEmpty();
        goto L8
    L9:
        r19 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f15731q == true) goto L5;
    L10:
        Rect r12 = this.N;
        Drawable r13 = this.f15715a;
        int r14 = 0;
        if (r13 == null) goto L13;
        q.d(r13);
        r13.getPadding(r12);
        Drawable r15 = this.f15715a;
        q.d(r15);
        int r16 = (r15.getIntrinsicWidth() - r12.left) - r12.right;
        Drawable r17 = this.f15715a;
        q.d(r17);
        int r18 = r17.getIntrinsicHeight();
    L15:
        if (this.f15731q == false) goto L25;
        Layout r19 = this.f15714J;
        if (r19 != null) goto L19;
        int r20 = 0;
    L20:
        Layout r21 = this.K;
        if (r21 != null) goto L23;
        int r22 = 0;
    L24:
        int r23 = Math.max(r20, r22) + (this.f15725k * 2);
    L26:
        this.B = Math.max(r23, r16);
        this.C = r18;
        Drawable r24 = this.f15720f;
        if (r24 == null) goto L29;
        q.d(r24);
        r24.getPadding(r12);
        Drawable r25 = this.f15720f;
        q.d(r25);
        r14 = r25.getIntrinsicHeight();
    L30:
        int r26 = r12.left;
        int r27 = r12.right;
        Drawable r28 = this.f15715a;
        if (r28 == null) goto L33;
        Rect r29 = r.d(r28);
        r26 = Math.max(r26, r29.left);
        r27 = Math.max(r27, r29.right);
    L33:
        int r30 = Math.max(this.f15726l, ((this.B * 2) + r26) + r27);
        int r31 = Math.max(r14, r18);
        this.f15739y = r30 - this.f15740z;
        this.A = r31;
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() >= r31) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r31);
        return;
    L37:
        return;
    L29:
        r12.setEmpty();
        goto L30
    L23:
        r22 = r21.getWidth();
        goto L24
    L19:
        r20 = r19.getWidth();
        goto L20
    L25:
        r23 = 0;
        goto L26
    L13:
        r16 = 0;
        r18 = 0;
        goto L15
    L5:
        if (this.f15714J != null) goto L8;
        this.f15714J = g(this.f15729o);
    L8:
        if (this.K != null) goto L10;
        this.K = g(this.f15730p);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent r10) {
        q.g(r10, "event");
        super.onPopulateAccessibilityEvent(r10);
        if (isChecked() == false) goto L5;
        CharSequence r11 = this.f15729o;
    L6:
        if (r11 == null) goto L9;
        r10.getText().add(r11);
        return;
    L9:
        return;
    L5:
        r11 = this.f15730p;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "ev");
        this.f15736v.addMovement(r10);
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (isEnabled() == true) goto L43;
    L46:
        return super.onTouchEvent(r10);
    L43:
        if (f(r12, r13) == false) goto L46;
        this.f15732r = 1;
        this.f15734t = r12;
        this.f15735u = r13;
        goto L46
    L5:
        if (r11 == 1) goto L36;
        if (r11 != 2) goto L8;
        int r14 = this.f15732r;
        if (r14 == 1) goto L29;
        if (r14 != 2) goto L46;
        float r15 = r10.getX();
        int r16 = getThumbScrollRange();
        float r17 = r15 - this.f15734t;
        if (r16 == 0) goto L18;
        float r18 = r17 / r16;
    L22:
        if (i0.b(this) == false) goto L24;
        r18 = -r18;
    L24:
        float r19 = b.a(T, this.S + r18, 0.0f, 1.0f);
        if (r19 == this.S) goto L28;
        this.f15734t = r15;
        this.S = r19;
    L28:
        return true;
    L18:
        if (r17 <= 0.0f) goto L20;
        r18 = 1.0f;
        goto L22
    L20:
        r18 = -1.0f;
        goto L22
    L29:
        float r20 = r10.getX();
        float r21 = r10.getY();
        if (Math.abs(r20 - this.f15734t) <= this.f15733s) goto L32;
    L33:
        this.f15732r = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f15734t = r20;
        this.f15735u = r21;
        return true;
    L32:
        if (Math.abs(r21 - this.f15735u) <= this.f15733s) goto L46;
    L8:
        if (r11 != 3) goto L46;
    L36:
        if (this.f15732r != 2) goto L39;
        stopDrag(r10);
        super.onTouchEvent(r10);
        return true;
    L39:
        this.f15732r = 0;
        this.f15736v.clear();
        goto L46
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean r10 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L5;
        h(isChecked());
    L5:
        return r10;
    }

    public final void setAutoCheck(boolean r10) {
        this.Q = r10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        super.setChecked(r10);
        boolean r11 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        d();
        if (r11 == false) goto L10;
        float r12 = 1.0f;
    L11:
        setThumbPosition(r12);
        return;
    L10:
        r12 = 0.0f;
        goto L11
    L5:
        if (e() == false) goto L7;
        a(r11);
    }

    @CallSuper
    public void setCheckedNoAnim(boolean r10) {
        super.setChecked(r10);
        d();
        if (isChecked() == false) goto L5;
        float r11 = 1.0f;
    L6:
        setThumbPosition(r11);
        return;
    L5:
        r11 = 0.0f;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@NotNull ActionMode.Callback r10) {
        q.g(r10, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.q(this, r10));
    }

    public final void setMPositionAnimator(@Nullable ObjectAnimator r10) {
        this.M = r10;
    }

    public final void setMThumbPosition(float r10) {
        this.f15738x = r10;
    }

    public final void setShowText(boolean r10) {
    }

    public final void setSplitTrack(boolean r10) {
        this.f15728n = r10;
        invalidate();
    }

    public final void setSwitchMinWidth(int r10) {
        this.f15726l = r10;
        requestLayout();
    }

    public final void setSwitchPadding(int r10) {
        this.f15727m = r10;
        requestLayout();
    }

    public final void setSwitchTypeface(@Nullable Typeface r10) {
        if (this.H.getTypeface() == null) goto L7;
        if (q.b(this.H.getTypeface(), r10) == true) goto L7;
    L9:
        this.H.setTypeface(r10);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.H.getTypeface() != null) goto L11;
        if (r10 != null) goto L9;
        return;
    }

    public final void setTextOff(@Nullable CharSequence r10) {
        this.f15730p = r10;
        requestLayout();
    }

    public final void setTextOn(@Nullable CharSequence r10) {
        this.f15729o = r10;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r10) {
        this.O = r10;
    }

    public final void setThumbConstraintRight(int r10) {
        this.P = r10;
    }

    public final void setThumbDrawable(@Nullable Drawable r10) {
        Drawable r11 = this.f15715a;
        if (r11 == null) goto L5;
        q.d(r11);
        r11.setCallback(null);
    L5:
        this.f15715a = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r10) {
        this.f15738x = r10;
        invalidate();
    }

    public final void setThumbResource(int r10) {
        setThumbDrawable(c.a.b(getContext(), r10));
    }

    public final void setThumbTextPadding(int r10) {
        this.f15725k = r10;
        requestLayout();
    }

    public final void setThumbTintList(@Nullable ColorStateList r10) {
        this.f15716b = r10;
        this.f15718d = true;
        b();
    }

    public final void setThumbTintMode(@Nullable PorterDuff.Mode r10) {
        this.f15717c = r10;
        this.f15719e = true;
        b();
    }

    public final void setTrackDrawable(@Nullable Drawable r10) {
        Drawable r11 = this.f15720f;
        if (r11 == null) goto L5;
        q.d(r11);
        r11.setCallback(null);
    L5:
        this.f15720f = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r10) {
        setTrackDrawable(c.a.b(getContext(), r10));
    }

    public final void setTrackTintList(@Nullable ColorStateList r10) {
        this.f15721g = r10;
        this.f15723i = true;
        c();
    }

    public final void setTrackTintMode(@Nullable PorterDuff.Mode r10) {
        this.f15722h = r10;
        this.f15724j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.Q == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r10) {
        q.g(r10, "who");
        if (super.verifyDrawable(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (r10 == this.f15715a) goto L10;
        if (r10 == this.f15720f) goto L10;
        return false;
    }

    @JvmOverloads
    public SwitchCompat(@Nullable Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ SwitchCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = R$attr.switchStyle;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public SwitchCompat(@Nullable Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f15736v = VelocityTracker.obtain();
        this.N = new Rect();
        this.Q = true;
        this.R = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        i();
        TextPaint r13 = new TextPaint(1);
        this.H = r13;
        r13.density = getResources().getDisplayMetrics().density;
        b0 r14 = b0.v(r10, r11, R$styleable.SwitchCompat, r12, 0);
        Drawable r15 = r14.g(R$styleable.SwitchCompat_android_thumb);
        this.f15715a = r15;
        if (r15 == null) goto L5;
        q.d(r15);
        r15.setCallback(this);
    L5:
        Drawable r16 = r14.g(R$styleable.SwitchCompat_track);
        this.f15720f = r16;
        if (r16 == null) goto L8;
        q.d(r16);
        r16.setCallback(this);
    L8:
        this.f15729o = r14.p(R$styleable.SwitchCompat_android_textOn);
        this.f15730p = r14.p(R$styleable.SwitchCompat_android_textOff);
        this.f15731q = false;
        this.f15725k = r14.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f15726l = r14.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f15727m = r14.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.f15728n = r14.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList r17 = r14.c(R$styleable.SwitchCompat_thumbTint);
        if (r17 == null) goto L11;
        this.f15716b = r17;
        this.f15718d = true;
    L11:
        PorterDuff.Mode r18 = r.e(r14.k(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f15717c == r18) goto L15;
        this.f15717c = r18;
        this.f15719e = true;
    L15:
        if (this.f15718d == false) goto L17;
    L18:
        b();
    L19:
        ColorStateList r19 = r14.c(R$styleable.SwitchCompat_trackTint);
        if (r19 == null) goto L22;
        this.f15721g = r19;
        this.f15723i = true;
    L22:
        PorterDuff.Mode r20 = r.e(r14.k(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f15722h == r20) goto L26;
        this.f15722h = r20;
        this.f15724j = true;
    L26:
        if (this.f15723i == false) goto L28;
    L29:
        c();
    L30:
        int r21 = r14.n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (r21 == 0) goto L33;
        j(r10, r21);
    L33:
        r14.w();
        if (r10 == null) goto L36;
        ViewConfiguration r22 = ViewConfiguration.get(r10);
        this.f15733s = r22.getScaledTouchSlop();
        this.f15737w = r22.getScaledMinimumFlingVelocity();
    L37:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L36:
        this.f15733s = 0;
        this.f15737w = 0;
        goto L37
    L28:
        if (this.f15724j == false) goto L30;
    L17:
        if (this.f15719e == false) goto L19;
        goto L18
    }
}
