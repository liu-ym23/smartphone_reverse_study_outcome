package com.obric.oui.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Ints;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import jb.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import td.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\b\u0016\u0018\u0000 Ü\u00012\u00020\u0001:\u0004Ý\u0001Þ\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u0017J\u001b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\fJ#\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b3\u0010%J\u000f\u00104\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u0010\u0011J\u000f\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u0011J\u0017\u00106\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u0010%J\u0017\u00107\u001a\u00020,2\u0006\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020,H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0003¢\u0006\u0004\b=\u0010'J\u000f\u0010>\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010\fJ\u0017\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010AJ\u0013\u0010B\u001a\u00020\u000f*\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u001d\u0010E\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\n2\u0006\u0010G\u001a\u00020,¢\u0006\u0004\bH\u0010IJ\r\u0010J\u001a\u00020,¢\u0006\u0004\bJ\u0010:J\u0019\u0010M\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010KH\u0014¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\bO\u0010\u0017J\u0019\u0010P\u001a\u00020,2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\n2\u0006\u0010R\u001a\u00020,¢\u0006\u0004\bS\u0010IJ\u001f\u0010V\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006H\u0014¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u000f¢\u0006\u0004\b\\\u00101J\u0017\u0010^\u001a\u00020\n2\b\b\u0001\u0010]\u001a\u00020\u0006¢\u0006\u0004\b^\u0010ZJ\u0017\u0010`\u001a\u00020\n2\b\b\u0001\u0010_\u001a\u00020\u0006¢\u0006\u0004\b`\u0010ZJ\u0017\u0010b\u001a\u00020\n2\b\b\u0001\u0010a\u001a\u00020\u0006¢\u0006\u0004\bb\u0010ZJ\u0017\u0010d\u001a\u00020\n2\b\b\u0001\u0010c\u001a\u00020\u0006¢\u0006\u0004\bd\u0010ZJ\u0017\u0010f\u001a\u00020\n2\b\b\u0001\u0010e\u001a\u00020\u0006¢\u0006\u0004\bf\u0010ZJ\u0017\u0010g\u001a\u00020\n2\b\b\u0001\u0010e\u001a\u00020\u0006¢\u0006\u0004\bg\u0010ZJ\u0015\u0010i\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u0006¢\u0006\u0004\bi\u0010ZJ\u0015\u0010k\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u0006¢\u0006\u0004\bk\u0010ZJ\u0017\u0010m\u001a\u00020\n2\b\b\u0001\u0010l\u001a\u00020\u0006¢\u0006\u0004\bm\u0010ZJ\u0017\u0010o\u001a\u00020\n2\b\b\u0001\u0010n\u001a\u00020\u0006¢\u0006\u0004\bo\u0010ZJ)\u0010r\u001a\u00020\n2\u0006\u0010p\u001a\u00020,2\b\b\u0002\u0010X\u001a\u00020\u00062\b\b\u0002\u0010q\u001a\u00020\u0006¢\u0006\u0004\br\u0010sJ\u0017\u0010u\u001a\u00020\n2\u0006\u0010t\u001a\u00020\u0019H\u0016¢\u0006\u0004\bu\u0010vJ\u0017\u0010x\u001a\u00020\n2\u0006\u0010w\u001a\u00020\u0006H\u0016¢\u0006\u0004\bx\u0010ZJ\u001f\u0010x\u001a\u00020\n2\u0006\u0010w\u001a\u00020\u00062\u0006\u0010y\u001a\u00020,H\u0016¢\u0006\u0004\bx\u0010zJ\u0017\u0010}\u001a\u00020\n2\b\u0010|\u001a\u0004\u0018\u00010{¢\u0006\u0004\b}\u0010~R\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010ER\u0017\u0010[\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u000eR\u0015\u0010\u0081\u0001\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0016\u0010\u0083\u0001\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u000eR\u0016\u0010\u0085\u0001\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u000eR\u0016\u0010\u0087\u0001\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u000eR\u0018\u0010\u0089\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\u000eR\u0018\u0010\u008b\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010\u000eR\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0017\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010ER\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010ER/\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0091\u0001\u001a\u00020\u000f8B@BX\u0082\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010\u000e\u001a\u0005\b\u0093\u0001\u0010\u0011\"\u0005\b\u0094\u0001\u00101R\u0018\u0010\u0097\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010\u000eR\u0018\u0010\u0099\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\u000eR\u001b\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010\u008e\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010\u000eR\u0017\u0010\u009d\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010ER\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010ER\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010ER\u0017\u0010\u009e\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010ER\u0017\u0010\u009f\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010ER\u0017\u0010¢\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010¡\u0001R\u0017\u0010¥\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010¤\u0001R\u0017\u0010¨\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0018\u0010§\u0001R\u0017\u0010©\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001d\u0010§\u0001R\u0017\u0010ª\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bJ\u0010¤\u0001R\u0017\u0010p\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b9\u0010«\u0001R\u0017\u0010¬\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010ER\u0017\u0010¯\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010®\u0001R\u0019\u0010²\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010±\u0001R\u0018\u0010³\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010«\u0001R\u0018\u0010´\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010«\u0001R\u0018\u0010µ\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010«\u0001R\u0018\u0010¶\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bE\u0010«\u0001R\u0019\u0010¸\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010«\u0001R\u0018\u0010¹\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\br\u0010«\u0001R\u0015\u0010º\u0001\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010\u000eR\u001e\u0010½\u0001\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bB\u0010»\u0001\u001a\u0005\b¼\u0001\u0010<R\u0017\u0010¾\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u000eR\u0018\u0010À\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¿\u0001\u0010\u000eR\u0018\u0010Á\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bS\u0010«\u0001R\u0019\u0010Ã\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010«\u0001R\u0017\u0010Ä\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010ER\u0018\u0010Æ\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÅ\u0001\u0010\u000eR\u001b\u0010É\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0017\u0010Ì\u0001\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Î\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010«\u0001R\u0019\u0010Ð\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010«\u0001R0\u0010Ô\u0001\u001a\u00020,2\u0007\u0010\u0091\u0001\u001a\u00020,8F@FX\u0086\u000e¢\u0006\u0016\n\u0006\bÑ\u0001\u0010«\u0001\u001a\u0005\bÒ\u0001\u0010:\"\u0005\bÓ\u0001\u0010IR&\u0010Ø\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\u000e\u001a\u0005\bÖ\u0001\u0010\u0011\"\u0005\b×\u0001\u00101R\u001b\u0010Û\u0001\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001¨\u0006ß\u0001"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "E", "()V", "t", "F", "", "u", "()F", "w", "v", "Landroid/graphics/Canvas;", "canvas", "drawBackground", "(Landroid/graphics/Canvas;)V", FixCard.FixStyle.KEY_Y, "Landroid/graphics/drawable/Drawable;", "d", FixCard.FixStyle.KEY_X, "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;)V", "z", "drawThumb", "Landroid/view/MotionEvent;", "event", "D", "(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;", "scale", "s", "(F)F", "cancelTouchByInternalUpdate", "(Landroid/view/MotionEvent;)V", "G", "newProgress", "Ljava/lang/Runnable;", "endAction", "", "N", "(FLjava/lang/Runnable;)Z", "downX", "R", "(F)V", "rawX", "r", "getTrackStartX", "getTrackEndX", "L", "C", "(F)Z", "B", "()Z", "getCompatMinValue", "()I", "trackTouchEvent", "p", SlideCard.KEY_INDEX, "H", "(I)I", "M", "(I)F", "decimals", "I", "(FI)F", "enabled", "setDebugLogEnabled", "(Z)V", "A", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDraw", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "toPress", "P", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "tickMarkCount", "setDefaultTickMarkCount", "(I)V", "backgroundHeight", "setBackgroundHeight", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "color", "setTickColorInt", "setTickColor", "minVisibleProgress", "setMinVisibleProgress", "maxVisibleProgress", "setMaxVisibleProgress", "thumbColor", "setThumbColorInt", "thumbColorResId", "setThumbColor", "isStyleSegmented", "initTickPosition", "K", "(ZII)V", "dr", "invalidateDrawable", "(Landroid/graphics/drawable/Drawable;)V", "progress", "setProgress", "animate", "(IZ)V", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "l", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;)V", "b", "c", "centerY", "e", "thumbNormalScale", "f", "thumbPressScale", "g", "thumbSize", "h", "thumbScale", "i", "thumbScaleVelocity", "Ljb/d;", "j", "Ljb/d;", "thumbAnimator", "k", CommonKey.KEY_VALUE, "m", "getCurrentProgress", "setCurrentProgress", "currentProgress", "n", "currentTargetProgress", "o", "currentProgressVelocity", "progressAnimator", "q", "tickRadius", "mBackgroundColor", "thumbStrokeColor", "tickColor", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "thumbStrokeRectF", "path", "Z", "mCurrentTickIndex", "Lcom/obric/oui/slider/a;", "Lcom/obric/oui/slider/a;", "seekBarVibrateHelper", "Lcom/obric/oui/common/style/Shadow;", "Lcom/obric/oui/common/style/Shadow;", "thumbShadow", "isPress", "isPressThumb", "isThumbOnTouchDown", "isThumbOnTouchEvent", "J", "isInternalUpdating", "isFirstFrame", "paddingHorizontal", "Lkotlin/Lazy;", "getTouchSlop", "touchSlop", "touchDownX", "O", "touchDownY", "hasDirectionLocked", "Q", "isDraggingHorizontally", "measureHeightPx", "S", "thumbStrokeWidth", "T", "Landroid/view/MotionEvent;", "pendingDownTrackEvent", "U", "Ljava/lang/Runnable;", "trackDownIfNoMoveRunnable", "V", "mirrorForRtl", "W", "debugLogEnabled", "a0", "getEnableMoveThumbOnDownOutside", "setEnableMoveThumbOnDownOutside", "enableMoveThumbOnDownOutside", "b0", "getMTouchProgressOffset", "setMTouchProgressOffset", "mTouchProgressOffset", "c0", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "onSeekBarChangeListenerExt", "d0", "a", "OnSeekBarChangeListenerExt", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TickMarkSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f16960d0 = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static volatile boolean f16961e0;
    public final Path A;
    public boolean B;
    public int C;
    public final com.obric.oui.slider.a D;
    public Shadow E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f16962J;
    public boolean K;
    public final float L;
    public final Lazy M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public int R;
    public float S;
    public MotionEvent T;
    public final Runnable U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f16963a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16964b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f16965b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16966c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public OnSeekBarChangeListenerExt f16967c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f16968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f16969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f16970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f16971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f16974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f16977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f16978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f16979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f16980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f16981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16982r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16983s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16984t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16985u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f16987w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f16988x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f16989y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f16990z;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onSegmentedPositionChanged", SlideCard.KEY_INDEX, "", "onStartTrackingTouch", "onStopTrackingTouch", "onTouchDown", "onTouchUp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnSeekBarChangeListenerExt {
        void onProgressChanged(@Nullable SeekBar r10, float r11, boolean r12);

        void onSegmentedPositionChanged(int r10);

        void onStartTrackingTouch(@Nullable SeekBar r10);

        void onStopTrackingTouch(@Nullable SeekBar r10);

        void onTouchDown(@Nullable SeekBar r10);

        void onTouchUp(@Nullable SeekBar r10, float r11);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10, int r11) {
            return r10.b(r11);
        }

        public final String b(int r10) {
            if (r10 != 0) goto L4;
            return "DOWN";
        L4:
            if (r10 != 1) goto L6;
            return "UP";
        L6:
            if (r10 != 2) goto L8;
            return "MOVE";
        L8:
            if (r10 != 3) goto L10;
            return "CANCEL";
        L10:
            if (r10 != 5) goto L12;
            return "POINTER_DOWN";
        L12:
            if (r10 != 6) goto L21;
            return "POINTER_UP";
        L21:
            return String.valueOf(r10);
        }

        public a() {
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TickMarkSeekBar f16991a;

        public b(TickMarkSeekBar r10) {
            this.f16991a = r10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
            q.g(r10, "seekBar");
            if (this.f16991a.isHapticFeedbackEnabled() == false) goto L5;
            com.obric.oui.slider.a r13 = TickMarkSeekBar.f(this.f16991a);
            Context r14 = this.f16991a.getContext();
            q.f(r14, "context");
            r13.a(r14, r10, r11, r12, TickMarkSeekBar.h(this.f16991a), TickMarkSeekBar.i(this.f16991a));
        L5:
            TickMarkSeekBar r15 = this.f16991a;
            if (r15.A() == false) goto L9;
            StringBuilder r16 = new StringBuilder();
            r16.append('[');
            r16.append("listener-progress");
            r16.append("][");
            r16.append(Integer.toHexString(System.identityHashCode(r15)));
            r16.append("] ");
            r16.append("progress=" + r11 + ", fromUser=" + r12 + ", currentProgress=" + TickMarkSeekBar.c(r15) + ", currentTargetProgress=" + TickMarkSeekBar.d(r15) + ", tickMarkCount=" + TickMarkSeekBar.h(r15));
            L.a("TickSeekBar", r16.toString());
        L9:
            OnSeekBarChangeListenerExt r17 = TickMarkSeekBar.e(this.f16991a);
            if (r17 == null) goto L14;
            r17.onProgressChanged(r10, TickMarkSeekBar.o(this.f16991a, r11), r12);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r10) {
            TickMarkSeekBar.l(this.f16991a, -1);
            OnSeekBarChangeListenerExt r11 = TickMarkSeekBar.e(this.f16991a);
            if (r11 == null) goto L7;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r10) {
            OnSeekBarChangeListenerExt r11 = TickMarkSeekBar.e(this.f16991a);
            if (r11 == null) goto L7;
            r11.onStopTrackingTouch(this.f16991a);
            return;
        }
    }

    static {
        f16960d0 = new a(null);
    }

    @JvmOverloads
    public TickMarkSeekBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final float I(float r10, int r11) {
        String r12 = String.format(Locale.CHINA, "%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        q.f(r12, "format(locale, this, *args)");
        return Float.parseFloat(r12);
    }

    public static /* synthetic */ float J(TickMarkSeekBar r10, float r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = 2;
    L7:
        return r10.I(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float M(int r10) {
        return J(this, r10 / 100, 0, 1, null);
    }

    public static /* synthetic */ boolean O(TickMarkSeekBar r10, float r11, Runnable r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.N(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleProgressChangedAnim");
    }

    public static final void Q(TickMarkSeekBar r10) {
        q.g(r10, "this$0");
        r10.E();
    }

    public static /* synthetic */ void a(TickMarkSeekBar r10) {
        Q(r10);
    }

    public static /* synthetic */ void b(TickMarkSeekBar r10, int r11) {
        q(r10, r11);
    }

    public static final /* synthetic */ float c(TickMarkSeekBar r10) {
        return r10.getCurrentProgress();
    }

    private final void cancelTouchByInternalUpdate(MotionEvent r10) {
        if (A() == false) goto L10;
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        r11.append("internal-update-cancel");
        r11.append("][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        StringBuilder r12 = new StringBuilder();
        r12.append("action=");
        a r13 = f16960d0;
        if (r10 != null) goto L8;
        int r14 = -1;
    L9:
        r12.append(a.a(r13, r14));
        r12.append(", progress=");
        r12.append(getProgress());
        r12.append(", currentProgress=");
        r12.append(getCurrentProgress());
        r12.append(", touchOffset=");
        r12.append(getMTouchProgressOffset());
        r11.append(r12.toString());
        L.a("TickSeekBar", r11.toString());
        goto L10
    L8:
        r14 = r10.getActionMasked();
    L10:
        this.F = false;
        G();
        if (r10 == null) goto L14;
        MotionEvent r15 = MotionEvent.obtain(r10);
        r15.setAction(3);
        super.onTouchEvent(r15);
        r15.recycle();
    L14:
        this.f16962J = false;
    }

    public static final /* synthetic */ float d(TickMarkSeekBar r10) {
        return r10.f16978n;
    }

    private final void drawThumb(Canvas r10) {
        if (this.f16984t != 0) goto L5;
        return;
    L5:
        r10.save();
        float r11 = w();
        float r12 = u();
        this.f16987w.setColor(this.f16984t);
        float r13 = r11 / 2.0f;
        float r14 = this.f16968d;
        this.f16989y.set(r12 - r13, r14 - r13, r12 + r13, r14 + r13);
        r10.drawRoundRect(this.f16989y, r13, r13, this.f16987w);
        r10.restore();
        r10.save();
        h.f24801a.c(r10, this.E, this.f16989y, r13);
        r10.restore();
        float r15 = this.S / 2.0f;
        this.f16990z.set(this.f16989y);
        float r16 = -r15;
        this.f16990z.inset(r16, r16);
        Paint.Style r17 = this.f16987w.getStyle();
        float r18 = this.f16987w.getStrokeWidth();
        this.f16987w.setStyle(Paint.Style.STROKE);
        this.f16987w.setStrokeWidth(this.S);
        this.f16987w.setColor(this.f16985u);
        float r19 = r13 + r15;
        r10.drawRoundRect(this.f16990z, r19, r19, this.f16987w);
        this.f16987w.setStrokeWidth(r18);
        this.f16987w.setStyle(r17);
    }

    public static final /* synthetic */ OnSeekBarChangeListenerExt e(TickMarkSeekBar r10) {
        return r10.f16967c0;
    }

    public static final /* synthetic */ com.obric.oui.slider.a f(TickMarkSeekBar r10) {
        return r10.D;
    }

    public static final /* synthetic */ float g(TickMarkSeekBar r10) {
        return r10.f16972h;
    }

    private final int getCompatMinValue() {
        return getMin();
    }

    private final float getCurrentProgress() {
        return this.f16977m;
    }

    private final int getTouchSlop() {
        return ((Number) this.M.getValue()).intValue();
    }

    private final float getTrackEndX() {
        return (getWidth() - this.L) - (this.f16971g / 2.0f);
    }

    private final float getTrackStartX() {
        return this.L + (this.f16971g / 2.0f);
    }

    public static final /* synthetic */ int h(TickMarkSeekBar r10) {
        return r10.f16964b;
    }

    public static final /* synthetic */ boolean i(TickMarkSeekBar r10) {
        return r10.B;
    }

    public static final /* synthetic */ void j(TickMarkSeekBar r10, float r11) {
        r10.setCurrentProgress(r11);
    }

    public static final /* synthetic */ void k(TickMarkSeekBar r10, float r11) {
        r10.f16979o = r11;
    }

    public static final /* synthetic */ void l(TickMarkSeekBar r10, int r11) {
        r10.C = r11;
    }

    public static final /* synthetic */ void m(TickMarkSeekBar r10, float r11) {
        r10.f16972h = r11;
    }

    public static final /* synthetic */ void n(TickMarkSeekBar r10, float r11) {
        r10.f16973i = r11;
    }

    public static final /* synthetic */ float o(TickMarkSeekBar r10, int r11) {
        return r10.M(r11);
    }

    public static final void q(TickMarkSeekBar r10, int r11) {
        q.g(r10, "this$0");
        r10.C = r11;
        OnSeekBarChangeListenerExt r12 = r10.f16967c0;
        if (r12 == null) goto L6;
        r12.onSegmentedPositionChanged(r11);
    L6:
        r10.invalidate();
    }

    private final void setCurrentProgress(float r10) {
        this.f16977m = r10;
    }

    @SuppressLint({"RestrictedApi"})
    private final void trackTouchEvent(MotionEvent r10) {
        int r11 = getCompatMinValue();
        int r12 = getMax() - r11;
        if (r12 > 0) goto L6;
        return;
    L6:
        if (C(r10.getX()) == false) goto L11;
        if (L(r10.getX()) > getTrackStartX()) goto L11;
        float r13 = r11;
    L17:
        if (A() == false) goto L20;
        StringBuilder r14 = new StringBuilder();
        r14.append('[');
        r14.append("track-touch");
        r14.append("][");
        r14.append(Integer.toHexString(System.identityHashCode(this)));
        r14.append("] ");
        r14.append("x=" + r10.getX() + ", logicalX=" + L(r10.getX()) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", newProgress=" + r13 + ", minValue=" + r11 + ", max=" + getMax() + ", touchOffset=" + getMTouchProgressOffset());
        L.a("TickSeekBar", r14.toString());
    L20:
        O(this, r13, null, 2, null);
        return;
    L11:
        if (C(r10.getX()) == true) goto L13;
    L15:
        float r15 = this.f16965b0 + (r(r10.getX()) * r12);
        float r16 = r11;
        r13 = bg.h.j(r15 + r16, r16, getMax());
        goto L17
    L13:
        if (L(r10.getX()) < getTrackEndX()) goto L15;
        r13 = getMax();
        goto L17
    }

    public final boolean A() {
        if (this.W == false) goto L5;
    L8:
        return true;
    L5:
        if (f16961e0 == true) goto L8;
        return false;
    }

    public final boolean B() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean C(float r10) {
        float r11 = L(r10);
        boolean r12 = false;
        if (r11 > getTrackStartX()) goto L5;
        boolean r13 = true;
    L7:
        if (r11 < getTrackEndX()) goto L9;
        boolean r14 = true;
    L10:
        if (r13 == true) goto L12;
        if (r14 == true) goto L12;
    L13:
        if (r12 == true) goto L15;
    L18:
        return r12;
    L15:
        if (A() == false) goto L18;
        StringBuilder r15 = new StringBuilder();
        r15.append('[');
        r15.append("track-edge-hit");
        r15.append("][");
        r15.append(Integer.toHexString(System.identityHashCode(this)));
        r15.append("] ");
        r15.append("rawX=" + r10 + ", logicalX=" + r11 + ", hitStart=" + r13 + ", hitEnd=" + r14 + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX());
        L.a("TickSeekBar", r15.toString());
    L12:
        r12 = true;
        goto L13
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public final MotionEvent D(MotionEvent r13) {
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r13.getAction() == 0) goto L11;
        if (r13.getAction() == 2) goto L11;
        return null;
    L11:
        if (this.H == true) goto L15;
        if (this.I == true) goto L15;
    L16:
        return null;
    L15:
        if (this.f16965b0 == 0.0f) goto L16;
        if (C(r13.getX()) == true) goto L20;
        int r10 = getMax() - getCompatMinValue();
        if (r10 > 0) goto L27;
        return null;
    L27:
        float r11 = r(r13.getX());
        float r12 = bg.h.j((this.f16965b0 / r10) + r11, 0.0f, 1.0f);
        float r14 = s(r12);
        if (r14 != r13.getX()) goto L31;
        return null;
    L31:
        if (A() == false) goto L34;
        StringBuilder r15 = new StringBuilder();
        r15.append('[');
        r15.append("native-event-correct");
        r15.append("][");
        r15.append(Integer.toHexString(System.identityHashCode(this)));
        r15.append("] ");
        r15.append("rawX=" + r13.getX() + ", scale=" + r11 + ", nativeScale=" + r12 + ", nativeX=" + r14 + ", offset=" + getMTouchProgressOffset() + ", range=" + r10);
        L.a("TickSeekBar", r15.toString());
    L34:
        MotionEvent r16 = MotionEvent.obtain(r13);
        r16.offsetLocation(r14 - r13.getX(), 0.0f);
        return r16;
    L20:
        if (A() == false) goto L23;
        StringBuilder r17 = new StringBuilder();
        r17.append('[');
        r17.append("native-event-skip-edge");
        r17.append("][");
        r17.append(Integer.toHexString(System.identityHashCode(this)));
        r17.append("] ");
        r17.append("x=" + r13.getX() + ", logicalX=" + L(r13.getX()) + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX() + ", offset=" + getMTouchProgressOffset());
        L.a("TickSeekBar", r17.toString());
    L23:
        return null;
    }

    public final void E() {
        if (this.F == false) goto L23;
        if (this.f16962J == true) goto L23;
        if (this.P == true) goto L23;
        if (this.Q == true) goto L23;
        if (this.H == true) goto L23;
        MotionEvent r10 = this.T;
        this.T = null;
        removeCallbacks(this.U);
        if (r10 != null) goto L17;
        return;
    L17:
        if (A() == false) goto L20;
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        r11.append("delayed-track-run");
        r11.append("][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        r11.append("action=" + a.a(f16960d0, r10.getAction()) + ", x=" + r10.getX() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress());
        L.a("TickSeekBar", r11.toString());
    L20:
        trackTouchEvent(r10);
        r10.recycle();
        return;
    L23:
        if (A() == false) goto L26;
        StringBuilder r12 = new StringBuilder();
        r12.append('[');
        r12.append("delayed-track-skip");
        r12.append("][");
        r12.append(Integer.toHexString(System.identityHashCode(this)));
        r12.append("] ");
        r12.append("isPress=" + this.F + ", isInternalUpdating=" + this.f16962J + ", hasDirectionLocked=" + this.P + ", isDraggingHorizontally=" + this.Q + ", isThumbOnTouchDown=" + this.H);
        L.a("TickSeekBar", r12.toString());
    L26:
        t();
    }

    public final void F() {
        this.R = f.r(this, 32);
        this.S = f.s(this, 0.5d);
    }

    public final void G() {
        if (A() == false) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append('[');
        r10.append("reset-touch-state");
        r10.append("][");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("] ");
        r10.append("isThumbOnTouchDown=" + this.H + ", isThumbOnTouchEvent=" + this.I + ", hasDirectionLocked=" + this.P + ", isDraggingHorizontally=" + this.Q);
        L.a("TickSeekBar", r10.toString());
    L6:
        this.H = false;
        this.I = false;
        this.P = false;
        this.Q = false;
        t();
        P(false);
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    public final int H(int r10) {
        int r11 = this.f16964b;
        if (r11 > 1) goto L6;
        return 0;
    L6:
        if (r10 > 0) goto L10;
        return getCompatMinValue();
    L10:
        if (r10 >= (r11 - 1)) goto L12;
        int r12 = getCompatMinValue();
        return yf.b.b(r12 + ((getMax() - r12) * (r10 / (this.f16964b - 1))));
    L12:
        return getMax();
    }

    public final void K(boolean r10, int r11, int r12) {
        this.B = r10;
        if (r10 == false) goto L5;
        setProgressDrawable(null);
        this.C = r12;
        this.f16964b = r11;
        setProgress(H(r12));
    L6:
        p();
        invalidate();
        return;
    L5:
        this.f16964b = -1;
        this.C = -1;
        goto L6
    }

    public final float L(float r10) {
        float r11 = getTrackStartX();
        float r12 = getTrackEndX();
        if (B() == true) goto L5;
        return r10;
    L5:
        if (this.V == true) goto L7;
        return r10;
    L7:
        return (r11 + r12) - r10;
    }

    public final boolean N(float r10, final Runnable r11) {
        if (getCurrentProgress() != r10) goto L6;
        return false;
    L6:
        if (this.H == false) goto L8;
    L22:
        d r12 = this.f16980p;
        if (r12 == null) goto L26;
        d.c(r12, false, 1, null);
    L26:
        setCurrentProgress(r10);
        this.f16978n = getCurrentProgress();
        invalidate();
        if (r11 == null) goto L30;
        r11.run();
    L30:
        return true;
    L8:
        if (this.I == true) goto L22;
        if (this.f16978n != r10) goto L16;
        setCurrentProgress(r10);
        this.f16978n = r10;
        invalidate();
        if (r11 == null) goto L21;
        r11.run();
    L21:
        return true;
    L16:
        d r13 = this.f16980p;
        if (r13 == null) goto L20;
        d.c(r13, false, 1, null);
    L20:
        this.f16978n = r10;
        com.obric.common.oea.foundation.animation.builder.d.a r14 = new com.obric.common.oea.foundation.animation.builder.d.a();
        float r15 = getCurrentProgress();
        float r16 = this.f16978n;
        com.obric.common.oea.foundation.animation.spec.spring.b r17 = kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null);
        r17.e(0.1f);
        Unit r18 = Unit.f21064a;
        this.f16980p = r14.d(r15, r16, r17, Float.valueOf(this.f16979o)).g(new TickMarkSeekBar$toggleProgressChangedAnim$2(this)).f(new TickMarkSeekBar$toggleProgressChangedAnim$3(r11)).c().a();
        invalidate();
        goto L21
    }

    public final void P(boolean r10) {
        if (this.G != r10) goto L5;
        return;
    L5:
        this.G = r10;
        d r11 = this.f16974j;
        if (r11 == null) goto L9;
        d.c(r11, false, 1, null);
    L9:
        com.obric.common.oea.foundation.animation.builder.d.a r12 = new com.obric.common.oea.foundation.animation.builder.d.a();
        float r13 = this.f16972h;
        if (r10 == false) goto L12;
        float r14 = this.f16970f;
    L13:
        this.f16974j = r12.d(r13, r14, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), Float.valueOf(this.f16973i)).g(new TickMarkSeekBar$toggleThumbScaleAnim$1(this)).c().a();
        return;
    L12:
        r14 = this.f16969e;
        goto L13
    }

    public final void R(float r10) {
        int r11 = getCompatMinValue();
        int r12 = getMax() - r11;
        if (r12 > 0) goto L6;
        this.f16965b0 = 0.0f;
        return;
    L6:
        float r13 = r(r10);
        this.f16965b0 = getCurrentProgress() - ((r12 * r13) + r11);
        if (A() == false) goto L11;
        StringBuilder r14 = new StringBuilder();
        r14.append('[');
        r14.append("touch-offset-update");
        r14.append("][");
        r14.append(Integer.toHexString(System.identityHashCode(this)));
        r14.append("] ");
        r14.append("downX=" + r10 + ", scale=" + r13 + ", minValue=" + r11 + ", range=" + r12 + ", currentProgress=" + getCurrentProgress() + ", touchOffset=" + getMTouchProgressOffset());
        L.a("TickSeekBar", r14.toString());
        return;
    }

    public final void drawBackground(Canvas r10) {
        r10.save();
        float r11 = this.f16966c / 2;
        this.f16989y.set(this.L, this.f16968d - r11, getWidth() - this.L, this.f16968d + r11);
        this.f16988x.reset();
        this.f16988x.addRoundRect(this.f16989y, r11, r11, Path.Direction.CW);
        this.f16987w.setColor(this.f16982r);
        r10.drawPath(this.f16988x, this.f16987w);
        r10.restore();
        if (this.B == false) goto L6;
        z(r10);
        return;
    }

    public final boolean getEnableMoveThumbOnDownOutside() {
        return this.f16963a0;
    }

    public final float getMTouchProgressOffset() {
        return this.f16965b0;
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r10) {
        q.g(r10, "dr");
        super.invalidateDrawable(r10);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        F();
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r10) {
        monitor-enter(this);
        q.g(r10, "canvas");     // Catch: Throwable -> L6
        if (this.K == false) goto L8;
        this.K = false;     // Catch: Throwable -> L6
        setCurrentProgress(getProgress());     // Catch: Throwable -> L6
    L8:
        drawBackground(r10);     // Catch: Throwable -> L6
        z(r10);     // Catch: Throwable -> L6
        y(r10);     // Catch: Throwable -> L6
        drawThumb(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(this.R, Ints.MAX_POWER_OF_TWO));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent r24) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        String r10 = "action=";
        if (A() == false) goto L22;
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        r11.append("touch-enter");
        r11.append("][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        StringBuilder r12 = new StringBuilder();
        r12.append("action=");
        a r13 = f16960d0;
        if (r24 != null) goto L11;
        int r14 = -1;
    L12:
        r12.append(a.a(r13, r14));
        r12.append(", x=");
        if (r24 != null) goto L15;
        Float r15 = null;
    L16:
        r12.append(r15);
        r12.append(", y=");
        if (r24 != null) goto L19;
        Float r16 = null;
    L20:
        r12.append(r16);
        r12.append(", progress=");
        r12.append(getProgress());
        r12.append(", currentProgress=");
        r12.append(getCurrentProgress());
        r12.append(", isPress=");
        r12.append(this.F);
        r12.append(", isInternalUpdating=");
        r12.append(this.f16962J);
        r12.append(", touchOffset=");
        r12.append(getMTouchProgressOffset());
        r11.append(r12.toString());
        L.a("TickSeekBar", r11.toString());
        goto L22
    L19:
        r16 = Float.valueOf(r24.getY());
        goto L20
    L15:
        r15 = Float.valueOf(r24.getX());
        goto L16
    L11:
        r14 = r24.getActionMasked();
    L22:
        if (this.f16962J == true) goto L24;
        int r17 = (int) (((int) this.L) + (this.f16971g / 2));
        setPadding(r17, 0, r17, 0);
        if (r24 != null) goto L36;
        Integer r18 = null;
    L37:
        if (r24 != null) goto L39;
        Integer r19 = null;
    L41:
        if (r19 != null) goto L44;
    L50:
        if (r18 != null) goto L53;
    L54:
        if (r18 != null) goto L57;
    L59:
        this.F = false;
        this.H = false;
        this.I = false;
        t();
        invalidate();
        r19 = r19;
        r10 = "action=";
        boolean r20 = false;
    L144:
        MotionEvent r21 = D(r24);
        if (r21 != null) goto L147;
        MotionEvent r22 = r24;
    L148:
        boolean r23 = super.onTouchEvent(r22);
        if (A() == true) goto L151;
        String r25 = r10;
    L164:
        if (r21 == null) goto L168;
        r21.recycle();
        Unit r26 = Unit.f21064a;
    L168:
        if (this.f16962J == false) goto L170;
        cancelTouchByInternalUpdate(r24);
        r20 = true;
    L170:
        if (r24 == null) goto L205;
        int r27 = r24.getAction();
        if (this.f16962J == true) goto L204;
        if (r27 == 0) goto L184;
        if (r27 == 2) goto L179;
    L186:
        if (r27 == 1) goto L191;
        if (r27 != 3) goto L204;
    L191:
        if (A() == false) goto L194;
        StringBuilder r28 = new StringBuilder();
        r28.append('[');
        r28.append("touch-finish");
        r28.append("][");
        r28.append(Integer.toHexString(System.identityHashCode(this)));
        r28.append("] ");
        r28.append(r25 + a.a(f16960d0, r27) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", isStyleSegmented=" + this.B + ", touchOffset=" + getMTouchProgressOffset());
        L.a("TickSeekBar", r28.toString());
    L194:
        if (r27 == 1) goto L196;
    L203:
        G();
        goto L204
    L196:
        if (this.B == false) goto L198;
        p();
    L199:
        OnSeekBarChangeListenerExt r29 = this.f16967c0;
        if (r29 == null) goto L203;
        r29.onTouchUp(this, M(getProgress()));
        Unit r30 = Unit.f21064a;
        goto L203
    L198:
        O(this, getProgress(), null, 2, null);
        goto L199
    L179:
        if (this.H == false) goto L181;
    L182:
        trackTouchEvent(r24);
        goto L186
    L181:
        if (this.Q == false) goto L186;
    L184:
        if (this.H == false) goto L186;
        trackTouchEvent(r24);
    L204:
        Unit r31 = Unit.f21064a;
    L205:
        this.f16962J = false;
        setPadding(0, 0, 0, 0);
        if (A() == false) goto L213;
        StringBuilder r32 = new StringBuilder();
        r32.append('[');
        r32.append("touch-exit");
        r32.append("][");
        r32.append(Integer.toHexString(System.identityHashCode(this)));
        r32.append("] ");
        StringBuilder r33 = new StringBuilder();
        r33.append(r25);
        a r34 = f16960d0;
        if (r19 != null) goto L211;
        int r35 = -1;
    L212:
        r33.append(a.a(r34, r35));
        r33.append(", progress=");
        r33.append(getProgress());
        r33.append(", currentProgress=");
        r33.append(getCurrentProgress());
        r33.append(", forceBreakTouch=");
        r33.append(r20);
        r32.append(r33.toString());
        L.a("TickSeekBar", r32.toString());
        goto L213
    L211:
        r35 = r19.intValue();
    L213:
        if (r20 == false) goto L216;
        return false;
    L216:
        return r23;
    L151:
        StringBuilder r36 = new StringBuilder();
        r36.append('[');
        r36.append("touch-super-result");
        r36.append("][");
        r36.append(Integer.toHexString(System.identityHashCode(this)));
        r36.append("] ");
        if (r21 != null) goto L154;
        MotionEvent r37 = r24;
    L155:
        StringBuilder r38 = new StringBuilder();
        r25 = r10;
        r38.append(r25);
        a r39 = f16960d0;
        if (r37 != null) goto L158;
        int r40 = -1;
    L159:
        r38.append(a.a(r39, r40));
        r38.append(", usedCorrectedEvent=");
        if (r21 == null) goto L162;
        boolean r41 = true;
    L163:
        r38.append(r41);
        r38.append(", progress=");
        r38.append(getProgress());
        r38.append(", currentProgress=");
        r38.append(getCurrentProgress());
        r38.append(", result=");
        r38.append(r23);
        r36.append(r38.toString());
        L.a("TickSeekBar", r36.toString());
        goto L164
    L162:
        r41 = false;
        goto L163
    L158:
        r40 = r37.getActionMasked();
        goto L159
    L154:
        r37 = r21;
        goto L155
    L147:
        r22 = r21;
        goto L148
    L57:
        if (r18.intValue() != 2) goto L59;
    L60:
        this.F = true;
        float r42 = u();
        float r43 = this.f16971g;
        float r44 = (r42 - (r43 / 2.0f)) - 30.0f;
        float r45 = (r42 + (r43 / 2.0f)) + 30.0f;
        if (getEnableMoveThumbOnDownOutside() == false) goto L68;
        float r46 = r24.getX();
        if (r44 > r46) goto L68;
        if (r46 > r45) goto L68;
        this.I = true;
        if (A() == false) goto L68;
        StringBuilder r47 = new StringBuilder();
        r47.append('[');
        r47.append("thumb-hit-area");
        r47.append("][");
        r47.append(Integer.toHexString(System.identityHashCode(this)));
        r47.append("] ");
        StringBuilder r48 = new StringBuilder();
        r48.append("action=");
        a r49 = f16960d0;
        if (r19 != null) goto L72;
        int r50 = -1;
    L73:
        r48.append(a.a(r49, r50));
        r48.append(", x=");
        r48.append(r24.getX());
        r48.append(", thumbLeft=");
        r48.append(r44);
        r48.append(", thumbRight=");
        r48.append(r45);
        r47.append(r48.toString());
        L.a("TickSeekBar", r47.toString());
    L74:
        if (r18 != null) goto L77;
    L111:
        r20 = false;
    L112:
        if (r19 == null) goto L137;
        if (r19.intValue() != 2) goto L137;
        if (this.P == true) goto L137;
        float r51 = Math.abs(r24.getX() - this.N);
        float r52 = Math.abs(r24.getY() - this.O);
        if (r51 <= getTouchSlop()) goto L121;
    L122:
        this.P = true;
        if (r51 <= r52) goto L125;
        boolean r53 = true;
    L126:
        this.Q = r53;
        t();
        if (A() == false) goto L131;
        StringBuilder r54 = new StringBuilder();
        r54.append('[');
        r54.append("direction-lock");
        r54.append("][");
        r54.append(Integer.toHexString(System.identityHashCode(this)));
        r54.append("] ");
        r54.append("dx=" + r51 + ", dy=" + r52 + ", touchSlop=" + getTouchSlop() + ", isDraggingHorizontally=" + this.Q + ", isThumbOnTouchDown=" + this.H);
        L.a("TickSeekBar", r54.toString());
    L131:
        if (this.Q == false) goto L134;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L137
    L134:
        if (this.H == true) goto L137;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L137
    L125:
        r53 = false;
        goto L126
    L121:
        if (r52 > getTouchSlop()) goto L122;
    L137:
        if (this.H == false) goto L139;
    L142:
        boolean r55 = true;
    L143:
        P(r55);
        invalidate();
        goto L144
    L139:
        if (this.I == true) goto L142;
        r55 = false;
        goto L143
    L77:
        if (r18.intValue() != 0) goto L111;
        float r56 = r24.getX();
        if (r44 > r56) goto L91;
        if (r56 > r45) goto L91;
        this.H = true;
        R(r24.getX());
        getParent().requestDisallowInterceptTouchEvent(true);
        OnSeekBarChangeListenerExt r57 = this.f16967c0;
        if (r57 == null) goto L87;
        r57.onTouchDown(this);
        Unit r58 = Unit.f21064a;
    L87:
        if (A() == false) goto L97;
        StringBuilder r59 = new StringBuilder();
        r59.append('[');
        r59.append("touch-down-thumb");
        r59.append("][");
        r59.append(Integer.toHexString(System.identityHashCode(this)));
        r59.append("] ");
        r59.append("x=" + r24.getX() + ", offset=" + getMTouchProgressOffset() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress());
        L.a("TickSeekBar", r59.toString());
    L97:
        r20 = false;
    L98:
        if (r20 == true) goto L112;
        if (getEnableMoveThumbOnDownOutside() == false) goto L112;
        if (this.H == true) goto L112;
        this.f16965b0 = 0.0f;
        OnSeekBarChangeListenerExt r60 = this.f16967c0;
        if (r60 == null) goto L107;
        r60.onTouchDown(this);
        Unit r61 = Unit.f21064a;
    L107:
        this.T = MotionEvent.obtain(r24);
        postDelayed(this.U, 150);
        if (A() == false) goto L112;
        StringBuilder r62 = new StringBuilder();
        r62.append('[');
        r62.append("delayed-track-schedule");
        r62.append("][");
        r62.append(Integer.toHexString(System.identityHashCode(this)));
        r62.append("] ");
        r62.append("x=" + r24.getX() + ", y=" + r24.getY() + ", delayMs=150");
        L.a("TickSeekBar", r62.toString());
    L91:
        if (getEnableMoveThumbOnDownOutside() == true) goto L97;
        this.F = false;
        this.H = false;
        this.I = false;
        r24.setAction(1);
        if (A() == false) goto L96;
        StringBuilder r63 = new StringBuilder();
        r63.append('[');
        r63.append("touch-down-outside-break");
        r63.append("][");
        r63.append(Integer.toHexString(System.identityHashCode(this)));
        r63.append("] ");
        r63.append("x=" + r24.getX() + ", enableMoveThumbOnDownOutside=" + getEnableMoveThumbOnDownOutside());
        L.a("TickSeekBar", r63.toString());
    L96:
        r20 = true;
        goto L98
    L72:
        r50 = r19.intValue();
    L68:
        r19 = r19;
        goto L74
    L53:
        if (r18.intValue() == 0) goto L60;
    L44:
        if (r19.intValue() != 0) goto L50;
        t();
        this.f16965b0 = 0.0f;
        this.N = r24.getX();
        this.O = r24.getY();
        this.P = false;
        this.Q = false;
        if (A() == false) goto L50;
        StringBuilder r64 = new StringBuilder();
        r64.append('[');
        r64.append("touch-down-init");
        r64.append("][");
        r64.append(Integer.toHexString(System.identityHashCode(this)));
        r64.append("] ");
        r64.append("x=" + r24.getX() + ", y=" + r24.getY() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", thumbCenter=" + u());
        L.a("TickSeekBar", r64.toString());
        goto L50
    L39:
        r19 = Integer.valueOf(r24.getActionMasked());
        goto L41
    L36:
        r18 = Integer.valueOf(r24.getAction());
        goto L37
    L24:
        if (A() == false) goto L31;
        StringBuilder r65 = new StringBuilder();
        r65.append('[');
        r65.append("touch-break-internal-update");
        r65.append("][");
        r65.append(Integer.toHexString(System.identityHashCode(this)));
        r65.append("] ");
        StringBuilder r66 = new StringBuilder();
        r66.append("action=");
        a r67 = f16960d0;
        if (r24 != null) goto L29;
        int r68 = -1;
    L30:
        r66.append(a.a(r67, r68));
        r66.append(", progress=");
        r66.append(getProgress());
        r66.append(", currentProgress=");
        r66.append(getCurrentProgress());
        r65.append(r66.toString());
        L.a("TickSeekBar", r65.toString());
        goto L31
    L29:
        r68 = r24.getActionMasked();
    L31:
        cancelTouchByInternalUpdate(r24);
        return false;
    }

    public final void p() {
        if (this.B == false) goto L35;
        final int r10 = 0;
        bg.c r11 = bg.h.p(0, this.f16964b);
        ArrayList r12 = new ArrayList(u.r(r11, 10));
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12.add(Integer.valueOf(H(((g0) r13).nextInt())));
        goto L6
    L8:
        Iterator r14 = t.j(r12).iterator();
        if (r14.hasNext() == true) goto L11;
        Object r15 = null;
    L21:
        Integer r16 = (Integer) r15;
        if (r16 == null) goto L25;
        r10 = r16.intValue();
    L25:
        int r17 = ((Number) r12.get(r10)).intValue();
        Runnable r18 = new com.obric.oui.slider.b(this, r10);
        boolean r19 = N(r17, r18);
        if (A() == false) goto L29;
        StringBuilder r20 = new StringBuilder();
        r20.append('[');
        r20.append("anchor-point");
        r20.append("][");
        r20.append(Integer.toHexString(System.identityHashCode(this)));
        r20.append("] ");
        r20.append("closestTickIndex=" + r10 + ", closestProgress=" + r17 + ", currentProgress=" + getCurrentProgress() + ", result=" + r19);
        L.a("TickSeekBar", r20.toString());
    L29:
        if (r19 == true) goto L36;
        r18.run();
        return;
    L36:
        return;
    L11:
        Object r21 = r14.next();
        if (r14.hasNext() == true) goto L14;
    L13:
        r15 = r21;
        goto L21
    L14:
        int r22 = Math.abs(((Number) r12.get(((Number) r21).intValue())).intValue() - getProgress());
    L15:
        Object r23 = r14.next();
        int r24 = Math.abs(((Number) r12.get(((Number) r23).intValue())).intValue() - getProgress());
        if (r22 <= r24) goto L19;
        r21 = r23;
        r22 = r24;
    L19:
        if (r14.hasNext() == true) goto L15;
    }

    public final float r(float r10) {
        float r11 = getTrackStartX();
        float r12 = getTrackEndX() - r11;
        if (r12 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return bg.h.j((L(r10) - r11) / r12, 0.0f, 1.0f);
    }

    public final float s(float r10) {
        float r11 = this.L + (this.f16971g / 2.0f);
        float r12 = (getWidth() - this.L) - (this.f16971g / 2.0f);
        float r13 = ((r12 - r11) * bg.h.j(r10, 0.0f, 1.0f)) + r11;
        if (B() == true) goto L5;
        return r13;
    L5:
        if (this.V == true) goto L7;
        return r13;
    L7:
        return (r11 + r12) - r13;
    }

    public final void setBackgroundHeight(float r10) {
        this.f16966c = r10;
        invalidate();
    }

    public final void setDebugLogEnabled(boolean r10) {
        this.W = r10;
        if (A() == false) goto L7;
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        r11.append("config");
        r11.append("][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        r11.append("instanceDebug=" + r10 + ", globalDebug=" + f16961e0);
        L.a("TickSeekBar", r11.toString());
        return;
    }

    public void setDefaultTickMarkCount(int r10) {
        this.f16964b = r10;
        this.C = -1;
        invalidate();
    }

    public final void setEnableMoveThumbOnDownOutside(boolean r10) {
        this.f16963a0 = r10;
    }

    public final void setMTouchProgressOffset(float r10) {
        this.f16965b0 = r10;
    }

    public final void setMaxVisibleProgress(int r10) {
        this.f16976l = r10;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setMinVisibleProgress(int r10) {
        this.f16975k = r10;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(@Nullable OnSeekBarChangeListenerExt r10) {
        this.f16967c0 = r10;
        super.setOnSeekBarChangeListener(new b(this));
    }

    public final void setProcessBackgroundColor(@ColorRes int r10) {
        this.f16982r = ContextCompat.b(getContext(), r10);
        invalidate();
    }

    public final void setProcessBackgroundColorInt(@ColorInt int r10) {
        this.f16982r = r10;
        invalidate();
    }

    public final void setProcessProgressColor(@ColorRes int r10) {
        this.f16983s = ContextCompat.b(getContext(), r10);
        invalidate();
    }

    public final void setProcessProgressColorInt(@ColorInt int r10) {
        this.f16983s = r10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r10) {
        super.setProgress(r10);
        if (A() == false) goto L6;
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        r11.append("setProgress");
        r11.append("][");
        r11.append(Integer.toHexString(System.identityHashCode(this)));
        r11.append("] ");
        r11.append("progress=" + r10 + ", isPress=" + this.F + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f16978n);
        L.a("TickSeekBar", r11.toString());
    L6:
        this.H = true;
        if (this.F == false) goto L9;
        this.f16962J = true;
    L9:
        O(this, r10, null, 2, null);
        this.H = false;
    }

    public final void setThumbColor(@ColorRes int r10) {
        this.f16984t = ContextCompat.b(getContext(), r10);
        invalidate();
    }

    public final void setThumbColorInt(@ColorInt int r10) {
        this.f16984t = r10;
        invalidate();
    }

    public final void setTickColor(@ColorRes int r10) {
        this.f16986v = ContextCompat.b(getContext(), r10);
        invalidate();
    }

    public final void setTickColorInt(@ColorInt int r10) {
        this.f16986v = r10;
        invalidate();
    }

    public final void t() {
        MotionEvent r10 = this.T;
        if (r10 == null) goto L6;
        r10.recycle();
    L6:
        this.T = null;
        removeCallbacks(this.U);
    }

    public final float u() {
        float r10 = getWidth();
        float r11 = this.L;
        float r12 = this.f16971g;
        return (r11 + (r12 / 2.0f)) + ((getCurrentProgress() / getMax()) * (((r10 - r11) - r11) - r12));
    }

    public final float v() {
        return (this.f16971g * this.f16972h) / 2.0f;
    }

    public final float w() {
        return this.f16971g * this.f16972h;
    }

    public final void x(Drawable r10, Canvas r11) {
        r11.translate(0.0f, getPaddingTop());
        r10.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r10.getIntrinsicHeight() / 2), getMeasuredWidth(), (getMeasuredHeight() / 2) + (r10.getIntrinsicHeight() / 2)));
        r10.draw(r11);
    }

    public final void y(Canvas r11) {
        int r10 = r11.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r12 = getProgressDrawable();
        q.f(r12, "progressDrawable");
        x(r12, r11);
    L6:
        r11.restoreToCount(r10);
        return;
    L5:
        float r13 = this.f16966c / 2;
        float r14 = u();
        float r15 = v();
        RectF r16 = this.f16989y;
        float r17 = this.L;
        float r18 = this.f16968d;
        r16.set(r17, r18 - r13, r14, r18 + r13);
        this.A.reset();
        Path.Direction r19 = Path.Direction.CW;
        this.A.addRoundRect(this.f16989y, new float[]{r13, r13, 0.0f, 0.0f, 0.0f, 0.0f, r13, r13}, r19);
        this.f16987w.setColor(this.f16983s);
        this.f16988x.reset();
        this.f16988x.addCircle(r14, this.f16968d, r15, r19);
        r11.clipOutPath(this.f16988x);
        r11.drawPath(this.A, this.f16987w);
        goto L6
    }

    public final void z(Canvas r10) {
        if (this.f16964b > 0) goto L5;
        return;
    L5:
        if (this.B == false) goto L11;
        float r11 = getWidth();
        float r12 = this.L;
        float r13 = ((r11 - r12) - r12) - this.f16971g;
        int r14 = this.f16964b;
        float r15 = r13 / (r14 - 1);
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L12;
        int r17 = r16 + 1;
        float r18 = this.L;
        float r19 = this.f16971g;
        float r20 = (r18 + (r19 / 2.0f)) + (r16 * r15);
        float r21 = (this.f16968d + (r19 / 2.0f)) - this.f16981q;
        this.f16987w.setColor(this.f16986v);
        r10.drawCircle(r20, r21, this.f16981q, this.f16987w);
        r16 = r17;
        goto L7
    L12:
        return;
    }

    @JvmOverloads
    public TickMarkSeekBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ TickMarkSeekBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public TickMarkSeekBar(@NotNull final Context r16, @Nullable AttributeSet r17, int r18) {
        q.g(r16, "context");
        super(r16, r17, r18);
        this.f16964b = -1;
        this.f16966c = f.r(this, 6);
        this.f16968d = f.r(this, 16);
        this.f16969e = 1.0f;
        this.f16970f = 1.22f;
        this.f16971g = f.r(this, 18);
        this.f16972h = 1.0f;
        this.f16975k = -1;
        this.f16976l = -1;
        this.f16981q = f.r(this, 2);
        Paint r10 = new Paint();
        this.f16987w = r10;
        this.f16988x = new Path();
        this.f16989y = new RectF();
        this.f16990z = new RectF();
        this.A = new Path();
        this.C = -1;
        this.D = new com.obric.oui.slider.a();
        this.E = new Shadow(Color.parseColor(Style.DEFAULT_BG_COLOR), 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
        this.K = true;
        this.L = f.r(this, 12);
        this.M = kotlin.b.b(new TickMarkSeekBar$touchSlop$2(r16));
        this.U = new c(this);
        this.f16963a0 = true;
        F();
        TypedArray r11 = r16.getTheme().obtainStyledAttributes(r17, R$styleable.TickMarkSeekBar, r18, 0);
        this.f16966c = r11.getDimensionPixelSize(R$styleable.TickMarkSeekBar_seekbarHeight, f.r(this, 6));
        int r12 = R$styleable.TickMarkSeekBar_seekbarBackgroundColor;
        int r13 = R$color.oui_basic_line_2;
        this.f16982r = r11.getColor(r12, ContextCompat.b(r16, r13));
        this.f16983s = r11.getColor(R$styleable.TickMarkSeekBar_seekbarProgressColor, ContextCompat.b(r16, R$color.oui_functional_blue_6));
        this.f16984t = r11.getColor(R$styleable.TickMarkSeekBar_seekbarThumbColor, ContextCompat.b(r16, R$color.oui_on_accent_default));
        this.f16985u = r11.getColor(R$styleable.TickMarkSeekBar_seekbarThumbStrokeColor, ContextCompat.b(r16, R$color.oui_basic_line_1));
        this.f16986v = r11.getColor(R$styleable.TickMarkSeekBar_seekbarTickColor, ContextCompat.b(r16, r13));
        setEnableMoveThumbOnDownOutside(r11.getBoolean(R$styleable.TickMarkSeekBar_seekbarEnableMoveThumbOnDownOutside, true));
        this.V = r11.getBoolean(R$styleable.TickMarkSeekBar_seekbarMirrorForRtl, false);
        r11.recycle();
        setOnSeekBarChangeListenerExt(null);
        r10.setStyle(Paint.Style.FILL);
        h.f24801a.b(r16, R$style.OUIShadow_1, this.E);
        setCurrentProgress(getProgress());
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r10, boolean r11) {
        super.setProgress(r10, r11);
        if (A() == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        r12.append('[');
        r12.append("setProgressWithAnimate");
        r12.append("][");
        r12.append(Integer.toHexString(System.identityHashCode(this)));
        r12.append("] ");
        r12.append("progress=" + r10 + ", animate=" + r11 + ", isPress=" + this.F + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f16978n);
        L.a("TickSeekBar", r12.toString());
    L7:
        if (r11 == true) goto L10;
        this.H = true;
    L10:
        if (this.F == false) goto L12;
        this.f16962J = true;
    L12:
        O(this, r10, null, 2, null);
        this.H = false;
    }
}
