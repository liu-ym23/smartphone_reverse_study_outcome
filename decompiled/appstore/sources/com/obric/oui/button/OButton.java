package com.obric.oui.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\bp\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0017\u0018\u0000 ú\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001aB9\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b#\u0010\u0016J \u0010'\u001a\u00020\u00102\u000e\u0010&\u001a\n %*\u0004\u0018\u00010$0$H\u0096\u0001¢\u0006\u0004\b'\u0010(J(\u0010+\u001a\u00020\u00102\u000e\u0010*\u001a\n %*\u0004\u0018\u00010)0)2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b+\u0010,J(\u0010-\u001a\u00020\u00102\u000e\u0010*\u001a\n %*\u0004\u0018\u00010)0)2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b-\u0010,J \u00100\u001a\u00020\u00102\u000e\u0010/\u001a\n %*\u0004\u0018\u00010.0.H\u0096\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b2\u00103J\u0018\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b5\u0010\u0016J\u0018\u00107\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b7\u0010\u0016J\u0018\u00109\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b9\u0010\u0016J\u0018\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b;\u0010\u0016J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b?\u0010@J4\u0010D\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010B0B %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010B0B\u0018\u00010C0AH\u0096\u0001¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bJ\u0010GJ\u0010\u0010K\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bK\u0010GJ\u0010\u0010L\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bL\u0010@J\u0010\u0010M\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bM\u0010@J\u0010\u0010N\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bN\u0010@J\u0010\u0010O\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bO\u0010@J\u0010\u0010P\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bP\u0010@J\u0010\u0010Q\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bQ\u0010@J\u0010\u0010R\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bR\u0010@J0\u0010W\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bW\u0010XJ0\u0010]\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b]\u0010XJ0\u0010b\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bb\u0010XJ0\u0010g\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bg\u0010XJ\u001a\u0010i\u001a\u00020\u00102\b\b\u0001\u0010h\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bi\u0010>J\u0018\u0010k\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bk\u0010>J\u0018\u0010m\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bm\u0010>J\u0018\u0010o\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bo\u0010\u0016J\u0018\u0010q\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bq\u0010rJ\u0018\u0010s\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bs\u0010>J\u0018\u0010t\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bt\u0010>J\u0018\u0010v\u001a\u00020\u00102\u0006\u0010u\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\bv\u0010\u0016J0\u0010{\u001a\u00020\u00102\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b{\u0010XJ\u0018\u0010}\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b}\u0010>J2\u0010}\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b}\u0010XJ-\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J6\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0087\u0001J\u001a\u0010\u0088\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0088\u0001\u0010>J6\u0010\u008c\u0001\u001a\u00020\u00102\u000b\b\u0001\u0010\u0089\u0001\u001a\u0004\u0018\u00010B2\u000b\b\u0001\u0010\u008a\u0001\u001a\u0004\u0018\u00010B2\u0007\u0010\u008b\u0001\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u0083\u0001\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0005\b\u008e\u0001\u0010\u001eJ\u001b\u0010\u008f\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u008f\u0001\u0010>J\u001a\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0090\u0001\u0010>J\u001b\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0091\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0092\u0001\u0010>J%\u0010\u0095\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u001d\u0010\u0098\u0001\u001a\u00020\u00102\t\b\u0001\u0010\u0097\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0098\u0001\u0010>J%\u0010\u009a\u0001\u001a\u00020\u00102\u0007\u0010\u0099\u0001\u001a\u00020\u00132\u0007\u0010\u008b\u0001\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001b\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010\u009c\u0001\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0005\b\u009d\u0001\u0010\u0016J\u001a\u0010\u009e\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009e\u0001\u0010>J\u0012\u0010\u009f\u0001\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0005\b\u009f\u0001\u00103J\u001b\u0010¡\u0001\u001a\u00020\u00132\u0007\u0010 \u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¡\u0001\u0010rJ\u001b\u0010£\u0001\u001a\u00020\u00102\u0007\u0010¢\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b£\u0001\u0010>J\u0012\u0010¤\u0001\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0005\b¤\u0001\u0010@J2\u0010¥\u0001\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¥\u0001\u0010XJ\u001a\u0010¦\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¦\u0001\u0010>J\u001b\u0010¨\u0001\u001a\u00020\u00102\u0007\u0010§\u0001\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0005\b¨\u0001\u0010\u001eJ2\u0010©\u0001\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b©\u0001\u0010XJ\u001a\u0010ª\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\bª\u0001\u0010>J2\u0010«\u0001\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b«\u0001\u0010XJ\u001a\u0010¬\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¬\u0001\u0010>JD\u0010®\u0001\u001a\u00020\u00102/\b\u0001\u0010\u00ad\u0001\u001a(\u0012\f\u0012\n %*\u0004\u0018\u00010B0B\u0018\u0001 %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010B0B\u0018\u00010C0AH\u0096\u0001¢\u0006\u0006\b®\u0001\u0010¯\u0001J2\u0010°\u0001\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b°\u0001\u0010XJ\u001a\u0010±\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b±\u0001\u0010>J\u0013\u0010²\u0001\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0014\u0010µ\u0001\u001a\u00030´\u0001H\u0096\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u0013\u0010·\u0001\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0018\u0010º\u0001\u001a\u00020\u00102\u0007\u0010¹\u0001\u001a\u00020\t¢\u0006\u0005\bº\u0001\u0010>J\u001c\u0010½\u0001\u001a\u00020\u00102\b\u0010¼\u0001\u001a\u00030»\u0001H\u0014¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u001c\u0010¿\u0001\u001a\u00020\u00102\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001¢\u0006\u0006\b¿\u0001\u0010¾\u0001J$\u0010Â\u0001\u001a\u00020\u00102\u0007\u0010À\u0001\u001a\u00020\t2\u0007\u0010Á\u0001\u001a\u00020\tH\u0014¢\u0006\u0006\bÂ\u0001\u0010\u0096\u0001J;\u0010Ä\u0001\u001a\u00020\u00102\u0007\u0010Ã\u0001\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020\tH\u0014¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001a\u0010Ç\u0001\u001a\u00020\u00102\u0007\u0010Æ\u0001\u001a\u00020\u0013H\u0016¢\u0006\u0005\bÇ\u0001\u0010\u0016J\u0019\u0010È\u0001\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0005\bÈ\u0001\u0010\u0016J\u0019\u0010É\u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0005\bÉ\u0001\u0010\u0016J\u001a\u0010Ë\u0001\u001a\u00020\u00102\u0007\u0010Ê\u0001\u001a\u00020\tH\u0017¢\u0006\u0005\bË\u0001\u0010>J>\u0010Í\u0001\u001a\u00020\u00102\t\u0010w\u001a\u0005\u0018\u00010Ì\u00012\t\u0010x\u001a\u0005\u0018\u00010Ì\u00012\t\u0010y\u001a\u0005\u0018\u00010Ì\u00012\t\u0010z\u001a\u0005\u0018\u00010Ì\u0001H\u0016¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J@\u0010Ñ\u0001\u001a\u00020\u00102\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\u0010x\u001a\u0005\u0018\u00010Ì\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\u0010z\u001a\u0005\u0018\u00010Ì\u0001H\u0016¢\u0006\u0006\bÑ\u0001\u0010Î\u0001J\u0018\u0010Ò\u0001\u001a\u00020\u00102\u0007\u0010Ê\u0001\u001a\u00020\u001b¢\u0006\u0005\bÒ\u0001\u0010\u001eJ\u0019\u0010Ó\u0001\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\tH\u0016¢\u0006\u0005\bÓ\u0001\u0010>R\u001b\u0010Ö\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010Õ\u0001R\u001b\u0010Ù\u0001\u001a\u0005\u0018\u00010×\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010Ø\u0001R\u001b\u0010Û\u0001\u001a\u0005\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010Ú\u0001R7\u0010â\u0001\u001a\u0005\u0018\u00010Ì\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u001d\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u0019\u0010å\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R0\u0010é\u0001\u001a\u00020\t2\u0007\u0010Ü\u0001\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\bæ\u0001\u0010ä\u0001\u001a\u0005\bç\u0001\u0010G\"\u0005\bè\u0001\u0010>R\u0019\u0010ì\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u0019\u0010î\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010ä\u0001R\u0019\u0010ð\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ä\u0001R\u0019\u0010ò\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ë\u0001R\u0019\u0010ô\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ä\u0001R\u0019\u0010÷\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ë\u0001¨\u0006û\u0001"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lcom/obric/oui/common/style/OUIStyleProvider;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/obric/oui/common/style/OUIStyleProvider;)V", "", "d", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "pressed", "setPressState", "(Z)V", "enabled", "e", "hasLeftDrawable", "a", "", "fraction", "g", "(F)V", "f", "c", "(F)F", "disable", "disablePressReleaseAnim", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "event", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "Landroid/view/View;", PerfConsts.KEY_CURRENT_GALVANIC, "onPressedChanged", "(Landroid/view/View;Z)V", "onSelectedChanged", "", "scene", "refreshColors", "(Ljava/lang/String;)V", "resetAlphaAnim", "()V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "color", "setOverridePressColor", "(I)V", "decideIsNeedUpdatePressedForegroundBySelf", "()Z", "", "Lcom/obric/oui/common/style/Shadow;", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "(IIII)V", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "heightLimit", "setHeightLimit", "(I)Z", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "(IIF)V", "shadowColor", "(IIIF)V", "setRightDividerAlpha", "firstShadow", "secondShadow", "animate", "setShadow", "(Lcom/obric/oui/common/style/Shadow;Lcom/obric/oui/common/style/Shadow;Z)V", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "(II)V", "styleResId", "setShadowStyle", "visible", "setShadowVisible", "(ZZ)V", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "widthLimit", "setWidthLimit", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "shadows", "updateShadows", "(Ljava/util/List;)V", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "()Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getEffectHelper", "()Lcom/obric/oui/common/style/OUIEffectHelper;", "getLayoutHelper", "()Lcom/obric/oui/common/style/IOUILayout;", "resId", "setButtonSourceBitmap", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "b", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "onLayout", "(ZIIII)V", "selected", "setSelected", "setEnabled", "setPressed", "alpha", "onPressAlphaChange", "Landroid/graphics/drawable/Drawable;", "setCompoundDrawables", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "start", "end", "setCompoundDrawablesRelative", "setDisabledTextAlpha", "setTextColor", "Lcom/obric/oui/common/style/OUILayoutHelper;", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "mOUIEffectHelper", CommonKey.KEY_VALUE, "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "h", "I", "mImageSourceId", "i", "getMImageTintColorId", "setMImageTintColorId", "mImageTintColorId", "j", "Z", "internalPressState", "k", "originTextColor", "l", "originIconAlpha", "m", "changeAlphaWhenPressed", "n", "customPaddingOffset", "o", "F", "disabledAlpha", "p", "isInternalTextColorChange", "q", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements IOUIAlpha, IOUILayout, IOUIStyleProvider {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f12472q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOUIAlpha f12473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IOUILayout f12474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OUIStyleProvider f12475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OUILayoutHelper f12476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OUIAlphaHelper f12477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OUIEffectHelper f12478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f12479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12485m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12486n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12487o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12488p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12472q = new a(null);
    }

    @JvmOverloads
    public OButton(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        OUIStyleProvider r14 = null;
        this(r10, r11, r12, r13, r14, 28, null);
    }

    private final float c(float r10) {
        return 1 - (r10 * 0.7f);
    }

    private final void f(float r10) {
        int r11 = this.f12484l;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = h.k((int) (r11 * c(r10)), 0, PrivateKeyType.INVALID);
        Drawable r13 = this.f12479g;
        if (r13 == null) goto L9;
        r13.setAlpha(r12);
    L9:
        L.a("OButton", "updateIconAlphaOnPress, fraction: " + r10 + ", alpha: " + r12 + ", originIconAlpha: " + this.f12484l);
    }

    private final void setPressState(boolean r10) {
        if (this.f12482j != r10) goto L6;
        L.j("OButton", q.p("setPressState, already set, skip! pressed: ", Boolean.valueOf(r10)));
        return;
    L6:
        this.f12482j = r10;
        OUIEffectHelper r11 = this.f12478f;
        if (r11 == null) goto L10;
        r11.s(r10);
    L10:
        OUIAlphaHelper r12 = this.f12477e;
        if (r12 == null) goto L15;
        r12.onPressedChanged(this, r10);
        return;
    }

    public final void a(boolean r10) {
        int r11 = getPaddingTop();
        int r12 = getPaddingRight();
        int r13 = getPaddingBottom();
        if (r10 == false) goto L5;
        int r14 = getPaddingRight() - this.f12486n;
    L7:
        if (r14 == getPaddingLeft()) goto L10;
        setPadding(r14, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r14 = getPaddingRight();
        goto L7
    }

    public final void b(Canvas r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Drawable r11 = this.f12479g;
        if (r11 != null) goto L7;
        return;
    L7:
        int r12 = (getWidth() - r11.getIntrinsicWidth()) / 2;
        int r13 = (getHeight() - r11.getIntrinsicHeight()) / 2;
        r11.setBounds(r12, r13, r11.getIntrinsicWidth() + r12, r11.getIntrinsicHeight() + r13);
        if (this.f12481i == 0) goto L10;
        r11.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f12481i), PorterDuff.Mode.SRC_IN));
    L10:
        r11.draw(r10);
    }

    public final void d(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OButton);
        q.f(r12, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f12480h = r12.getResourceId(R$styleable.OButton_icon, 0);
        setMImageTintColorId(r12.getResourceId(R$styleable.OButton_iconTint, 0));
        int r13 = this.f12480h;
        if (r13 == 0) goto L5;
        setButtonSourceBitmap(r13);
    L5:
        setTextAppearance(r12.getResourceId(R$styleable.OButton_oui_buttonTextStyle, R$style.Title_Title_M_Thick));
        this.f12485m = r12.getBoolean(R$styleable.OButton_oui_buttonChangeAlphaWhenPressed, false);
        int r14 = getCurrentTextColor();
        this.f12483k = r14;
        ColorStateList r15 = ColorStateList.valueOf(r14);
        q.f(r15, "valueOf(textColor)");
        setCompoundDrawableTintList(r15);
        this.f12486n = r12.getDimensionPixelSize(R$styleable.OButton_oui_widgetPaddingOffset, 0);
        Drawable[] r16 = getCompoundDrawables();
        q.f(r16, "getCompoundDrawables()");
        if (((Drawable) n.u(r16, 0)) == null) goto L8;
        a(true);
    L8:
        this.f12487o = r12.getFloat(R$styleable.OButton_oui_widgetDisableAlpha, 1.0f);
        r12.recycle();
        e(isEnabled());
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f12474b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f12473a.disablePressReleaseAnim(r10);
    }

    public final void e(boolean r10) {
        int r11 = this.f12483k;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = 0;
        if (r10 == true) goto L14;
        int r13 = td.h.a(r11, this.f12487o);
        this.f12488p = true;
        super.setTextColor(r13);
        this.f12488p = false;
        Drawable[] r14 = getCompoundDrawables();
        q.f(r14, "compoundDrawables");
        int r15 = r14.length;
    L8:
        if (r12 >= r15) goto L21;
        Drawable r16 = r14[r12];
        if (r16 == null) goto L13;
        r16.setAlpha((int) (this.f12487o * PrivateKeyType.INVALID));
    L13:
        r12 = r12 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.f12488p = true;
        super.setTextColor(r11);
        this.f12488p = false;
        Drawable[] r17 = getCompoundDrawables();
        q.f(r17, "compoundDrawables");
        int r18 = r17.length;
    L15:
        if (r12 >= r18) goto L21;
        Drawable r19 = r17[r12];
        if (r19 == null) goto L20;
        r19.setAlpha(PrivateKeyType.INVALID);
    L20:
        r12 = r12 + 1;
        goto L15
    }

    public final void g(float r10) {
        int r11 = this.f12483k;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = (r11 >> 24) & PrivateKeyType.INVALID;
        int r13 = (r11 >> 16) & PrivateKeyType.INVALID;
        int r14 = (r11 >> 8) & PrivateKeyType.INVALID;
        int r15 = r11 & PrivateKeyType.INVALID;
        int r16 = h.k((int) (r12 * c(r10)), 0, PrivateKeyType.INVALID);
        setTextColor(r15 | (((r13 << 16) | (r16 << 24)) | (r14 << 8)));
        L.a("OButton", "updateTextColorOnPress, fraction: " + r10 + ", newTextAlpha: " + r16 + ", originTextAlpha: " + r12);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.f12475c.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.f12474b.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.f12475c.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.f12475c.getLayoutHelper();
    }

    @Nullable
    public final Drawable getMIcon() {
        return this.f12479g;
    }

    public final int getMImageTintColorId() {
        return this.f12481i;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.f12474b.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.f12474b.getShadowAlpha();
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.f12474b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.f12474b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        this.f12473a.handleTouchEvent(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.f12474b.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.f12474b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.f12474b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.f12474b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.f12474b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.f12474b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.f12474b.isShadowVisible();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
        b(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        Drawable r14 = this.f12479g;
        if (r14 == null) goto L6;
        r12 = Math.max(r12, (r14.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r13 = Math.max(r13, (r14.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
        if (this.f12485m == true) goto L5;
        return;
    L5:
        float r11 = h.j(r10 / 255.0f, 0.0f, 1.0f);
        g(r11);
        f(r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        this.f12473a.onPressedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        this.f12473a.onSelectedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        this.f12473a.refreshColors(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.f12473a.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(@ColorInt int r10) {
        this.f12474b.setBorderColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.f12474b.setBorderWidth(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.f12474b.setBottomDividerAlpha(r10);
    }

    public final void setButtonSourceBitmap(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.d(getContext(), r10));
        Drawable r11 = this.f12479g;
        if (r11 != null) goto L7;
        int r12 = 0;
    L8:
        this.f12484l = r12;
        invalidate();
        return;
    L7:
        r12 = r11.getAlpha();
        goto L8
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f12473a.setChangeAlphaWhenDisable(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f12473a.setChangeAlphaWhenPress(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f12473a.setChangeAlphaWhenSelected(r10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        a(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        a(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r10) {
        this.f12487o = r10;
        if (isEnabled() == true) goto L6;
        e(false);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.f12474b.setEnableShadowWidthRadius(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        OUIAlphaHelper r11 = this.f12477e;
        if (r11 == null) goto L6;
        r11.o(this, r10);
    L6:
        e(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        return this.f12474b.setHeightLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r10) {
        this.f12473a.setKeepPressAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.f12474b.setLeftDividerAlpha(r10);
    }

    public final void setMIcon(@Nullable Drawable r10) {
        this.f12479g = r10;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r10) {
        this.f12481i = r10;
        invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.f12474b.setOuterNormalColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        this.f12474b.setOutlineExcludePadding(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f12474b.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        this.f12473a.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        OUIEffectHelper r11 = this.f12478f;
        if (r11 == null) goto L6;
        r11.s(r10);
    L6:
        OUIAlphaHelper r12 = this.f12477e;
        if (r12 == null) goto L11;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        this.f12474b.setRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f12474b.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.f12474b.setRightDividerAlpha(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        OUIAlphaHelper r11 = this.f12477e;
        if (r11 == null) goto L7;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11, boolean r12) {
        this.f12474b.setShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        this.f12474b.setShadowAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        this.f12474b.setShadowColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.f12474b.setShadowCornerRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        this.f12474b.setShadowElevation(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.f12474b.setShadowInsets(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(@StyleRes int r10) {
        this.f12474b.setShadowStyle(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        this.f12474b.setShadowVisible(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f12474b.setShowBorderOnlyBeforeL(r10);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r10) {
        if (this.f12488p == true) goto L5;
        this.f12483k = r10;
    L5:
        super.setTextColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.f12474b.setTopDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.f12474b.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        return this.f12474b.setWidthLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.f12474b.setWidthMin(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f12474b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        this.f12474b.updateBottomSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        this.f12474b.updateDividerColorStrength(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        this.f12474b.updateLeftSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        this.f12474b.updateRightSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List r10) {
        this.f12474b.updateShadows(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f12474b.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        this.f12474b.updateTopSeparatorColor(r10);
    }

    @JvmOverloads
    public OButton(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        OUIStyleProvider r14 = null;
        this(r10, r11, r12, r13, r14, 24, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f12474b.setRadius(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f12474b.setRadiusAndShadow(r10, r11, r12, r13);
    }

    public /* synthetic */ OButton(Context r10, AttributeSet r11, int r12, int r13, OUIStyleProvider r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((r15 & 8) == 0) goto L9;
        int r18 = 0;
    L11:
        if ((r15 & 16) == 0) goto L13;
        r14 = new OUIStyleProvider(r10, r11, r17, r18);
    L13:
        this(r10, r11, r17, r18, r14);
        return;
    L9:
        r18 = r13;
        goto L11
    L5:
        r17 = r12;
        goto L7
    }

    public OButton(Context r10, AttributeSet r11, int r12, int r13, OUIStyleProvider r14) {
        q.g(r10, "context");
        q.g(r14, "provider");
        super(r10, r11, r12);
        this.f12473a = r14.getAlphaHelper();
        this.f12474b = r14.getLayoutHelper();
        this.f12475c = r14;
        this.f12487o = 1.0f;
        ((OUILayoutHelper) r14.getLayoutHelper()).J(true);
        r14.a(this);
        this.f12476d = (OUILayoutHelper) getLayoutHelper();
        this.f12477e = (OUIAlphaHelper) getAlphaHelper();
        this.f12478f = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        d(r10, r11);
    }
}
