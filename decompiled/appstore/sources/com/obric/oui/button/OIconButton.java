package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import bg.h;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yf.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\bm\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 à\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ä\u0001B;\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001d\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001a2\u0006\u0010\u001c\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\u001f\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001a2\u0006\u0010\u001c\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ \u0010\"\u001a\u00020\u00122\u000e\u0010!\u001a\n \u0016*\u0004\u0018\u00010 0 H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b'\u0010\u0014J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0014J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b+\u0010\u0014J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b-\u0010\u0014J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b1\u00102J4\u00106\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010404 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010404\u0018\u00010503H\u0096\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020:H\u0096\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b=\u00109J\u0010\u0010>\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b>\u00109J\u0010\u0010?\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b?\u00102J\u0010\u0010@\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b@\u00102J\u0010\u0010A\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bA\u00102J\u0010\u0010B\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bB\u00102J\u0010\u0010C\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bC\u00102J\u0010\u0010D\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bD\u00102J\u0010\u0010E\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bE\u00102J0\u0010J\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bJ\u0010KJ0\u0010P\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bP\u0010KJ0\u0010U\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bU\u0010KJ0\u0010Z\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bZ\u0010KJ\u001a\u0010\\\u001a\u00020\u00122\b\b\u0001\u0010[\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\\\u00100J\u0018\u0010^\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b^\u00100J\u0018\u0010`\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b`\u00100J\u0018\u0010b\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bb\u0010\u0014J\u0018\u0010d\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bd\u0010eJ\u0018\u0010f\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bf\u00100J\u0018\u0010g\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bg\u00100J\u0018\u0010i\u001a\u00020\u00122\u0006\u0010h\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\bi\u0010\u0014J0\u0010n\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bn\u0010KJ\u0018\u0010p\u001a\u00020\u00122\u0006\u0010o\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bp\u00100J0\u0010p\u001a\u00020\u00122\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bp\u0010KJ(\u0010w\u001a\u00020\u00122\u0006\u0010o\u001a\u00020\t2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020:H\u0096\u0001¢\u0006\u0004\bw\u0010xJ0\u0010w\u001a\u00020\u00122\u0006\u0010o\u001a\u00020\t2\u0006\u0010u\u001a\u00020\t2\u0006\u0010y\u001a\u00020\t2\u0006\u0010v\u001a\u00020:H\u0096\u0001¢\u0006\u0004\bw\u0010zJ\u0018\u0010{\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b{\u00100J1\u0010\u007f\u001a\u00020\u00122\n\b\u0001\u0010|\u001a\u0004\u0018\u0001042\n\b\u0001\u0010}\u001a\u0004\u0018\u0001042\u0006\u0010~\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u001b\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010v\u001a\u00020:H\u0096\u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0083\u0001\u00100J\u001a\u0010\u0084\u0001\u001a\u00020\u00122\u0006\u0010o\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0084\u0001\u00100J\u001b\u0010\u0086\u0001\u001a\u00020\u00122\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0086\u0001\u00100J%\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001d\u0010\u008c\u0001\u001a\u00020\u00122\t\b\u0001\u0010\u008b\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u008c\u0001\u00100J$\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u008d\u0001\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0091\u0001\u001a\u00020\u00122\u0007\u0010\u0090\u0001\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0005\b\u0091\u0001\u0010\u0014J\u001a\u0010\u0092\u0001\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0092\u0001\u00100J\u0012\u0010\u0093\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0005\b\u0093\u0001\u0010%J\u001b\u0010\u0095\u0001\u001a\u00020\u00102\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0095\u0001\u0010eJ\u001b\u0010\u0097\u0001\u001a\u00020\u00122\u0007\u0010\u0096\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0097\u0001\u00100J\u0012\u0010\u0098\u0001\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0005\b\u0098\u0001\u00102J2\u0010\u0099\u0001\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0099\u0001\u0010KJ\u001a\u0010\u009a\u0001\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009a\u0001\u00100J\u001c\u0010\u009c\u0001\u001a\u00020\u00122\u0007\u0010\u009b\u0001\u001a\u00020:H\u0096\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u0082\u0001J2\u0010\u009d\u0001\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009d\u0001\u0010KJ\u001a\u0010\u009e\u0001\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009e\u0001\u00100J2\u0010\u009f\u0001\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009f\u0001\u0010KJ\u001a\u0010 \u0001\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b \u0001\u00100JD\u0010¢\u0001\u001a\u00020\u00122/\b\u0001\u0010¡\u0001\u001a(\u0012\f\u0012\n \u0016*\u0004\u0018\u00010404\u0018\u0001 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010404\u0018\u00010503H\u0096\u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J2\u0010¤\u0001\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¤\u0001\u0010KJ\u001a\u0010¥\u0001\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¥\u0001\u00100J\u0013\u0010¦\u0001\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0014\u0010©\u0001\u001a\u00030¨\u0001H\u0096\u0001¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0013\u0010«\u0001\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0019\u0010®\u0001\u001a\u00020\u00122\u0007\u0010\u00ad\u0001\u001a\u00020:¢\u0006\u0006\b®\u0001\u0010\u0082\u0001J\u0018\u0010°\u0001\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u00020\t¢\u0006\u0005\b°\u0001\u00100J\u001c\u0010³\u0001\u001a\u00020\u00122\b\u0010²\u0001\u001a\u00030±\u0001H\u0014¢\u0006\u0006\b³\u0001\u0010´\u0001J\u0019\u0010µ\u0001\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\tH\u0016¢\u0006\u0005\bµ\u0001\u00100J\u0019\u0010¶\u0001\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0005\b¶\u0001\u0010\u0014J\u001a\u0010¸\u0001\u001a\u00020\u00122\u0007\u0010·\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0005\b¸\u0001\u0010\u0014J\u001a\u0010º\u0001\u001a\u00020\u00122\u0007\u0010¹\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0005\bº\u0001\u0010\u0014J\u001c\u0010»\u0001\u001a\u00020\u00122\b\u0010²\u0001\u001a\u00030±\u0001H\u0017¢\u0006\u0006\b»\u0001\u0010´\u0001J\u001c\u0010¼\u0001\u001a\u00020\u00122\b\u0010²\u0001\u001a\u00030±\u0001H\u0016¢\u0006\u0006\b¼\u0001\u0010´\u0001J\u001a\u0010¾\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020\tH\u0017¢\u0006\u0005\b¾\u0001\u00100J\u0019\u0010¿\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020:¢\u0006\u0006\b¿\u0001\u0010\u0082\u0001J\u0019\u0010À\u0001\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0014J\u001a\u0010Á\u0001\u001a\u00020\u00122\u0007\u0010·\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\bÁ\u0001\u0010\u0014J\u001b\u0010Ã\u0001\u001a\u00020\u00122\u0007\u0010Â\u0001\u001a\u00020:H\u0002¢\u0006\u0006\bÃ\u0001\u0010\u0082\u0001J\u001b\u0010Ä\u0001\u001a\u00020:2\u0007\u0010Â\u0001\u001a\u00020:H\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001c\u0010Í\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ó\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ò\u0001R\u0019\u0010Ø\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Û\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Ý\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ú\u0001R\u0019\u0010ß\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010×\u0001¨\u0006á\u0001"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lcom/obric/oui/common/style/OUIStyleProvider;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/obric/oui/common/style/OUIStyleProvider;)V", "", "disable", "", "disablePressReleaseAnim", "(Z)V", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "event", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "Landroid/view/View;", PerfConsts.KEY_CURRENT_GALVANIC, "pressed", "onPressedChanged", "(Landroid/view/View;Z)V", "onSelectedChanged", "", "scene", "refreshColors", "(Ljava/lang/String;)V", "resetAlphaAnim", "()V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "color", "setOverridePressColor", "(I)V", "decideIsNeedUpdatePressedForegroundBySelf", "()Z", "", "Lcom/obric/oui/common/style/Shadow;", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "(IIII)V", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "heightLimit", "setHeightLimit", "(I)Z", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "(IIF)V", "shadowColor", "(IIIF)V", "setRightDividerAlpha", "firstShadow", "secondShadow", "animate", "setShadow", "(Lcom/obric/oui/common/style/Shadow;Lcom/obric/oui/common/style/Shadow;Z)V", "setShadowAlpha", "(F)V", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "(II)V", "styleResId", "setShadowStyle", "visible", "setShadowVisible", "(ZZ)V", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "widthLimit", "setWidthLimit", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "shadows", "updateShadows", "(Ljava/util/List;)V", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "()Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getEffectHelper", "()Lcom/obric/oui/common/style/OUIEffectHelper;", "getLayoutHelper", "()Lcom/obric/oui/common/style/IOUILayout;", "progress", "setAlignmentProgress", Style.KEY_PADDING, "setTargetLeftPadding", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "setBackgroundColor", "setPressed", "enabled", "setEnabled", "selected", "setSelected", "draw", "dispatchDraw", "alpha", "onPressAlphaChange", "setDisabledAlpha", "setPressState", "c", "fraction", "b", "a", "(F)F", "Lcom/obric/oui/common/style/OUILayoutHelper;", "d", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "e", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mAlphaHelper", "f", "Lcom/obric/oui/common/style/OUIEffectHelper;", "mOUIEffectHelper", "g", "Z", "internalPressState", "h", "changeAlphaWhenPressed", "i", "I", "originIconAlpha", "j", "F", "disabledAlpha", "k", "alignmentProgress", "l", "targetLeftPadding", "m", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButton extends AppCompatImageView implements IOUIAlpha, IOUILayout, IOUIStyleProvider {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f12498m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOUIAlpha f12499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IOUILayout f12500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OUIStyleProvider f12501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OUILayoutHelper f12502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OUIAlphaHelper f12503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OUIEffectHelper f12504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12510l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12498m = new a(null);
    }

    @JvmOverloads
    public OIconButton(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        OUIStyleProvider r14 = null;
        this(r10, r11, r12, r13, r14, 30, null);
    }

    private final void c(boolean r10) {
        if (r10 == true) goto L8;
        Drawable r11 = getDrawable();
        if (r11 == null) goto L14;
        r11.setAlpha((int) (this.f12508j * PrivateKeyType.INVALID));
        return;
    L14:
        return;
    L8:
        Drawable r12 = getDrawable();
        if (r12 == null) goto L15;
        r12.setAlpha(PrivateKeyType.INVALID);
        return;
    }

    private final void setPressState(boolean r10) {
        if (this.f12505g != r10) goto L5;
        return;
    L5:
        this.f12505g = r10;
        OUIEffectHelper r11 = this.f12504f;
        if (r11 == null) goto L9;
        r11.s(r10);
    L9:
        OUIAlphaHelper r12 = this.f12503e;
        if (r12 == null) goto L14;
        r12.onPressedChanged(this, r10);
        return;
    }

    public final float a(float r10) {
        return 1 - (r10 * 0.7f);
    }

    public final void b(float r10) {
        if (this.f12507i != 0) goto L5;
        this.f12507i = getImageAlpha();
    L5:
        int r11 = this.f12507i;
        if (r11 != 0) goto L8;
        return;
    L8:
        setImageAlpha(h.k((int) (r11 * a(r10)), 0, PrivateKeyType.INVALID));
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f12500b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f12499a.disablePressReleaseAnim(r10);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.dispatchDraw(r10);
        OUILayoutHelper r11 = this.f12502d;
        if (r11 == null) goto L6;
        r11.s(r10, getWidth(), getHeight());
    L6:
        OUILayoutHelper r12 = this.f12502d;
        if (r12 == null) goto L11;
        r12.q(r10);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        OUILayoutHelper r11 = this.f12502d;
        if (r11 == null) goto L6;
        r11.r(r10);
    L6:
        super.draw(r10);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.f12501c.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.f12500b.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.f12501c.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.f12501c.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.f12500b.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.f12500b.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.f12500b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.f12500b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        this.f12499a.handleTouchEvent(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.f12500b.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.f12500b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.f12500b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.f12500b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.f12500b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.f12500b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.f12500b.isShadowVisible();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        if (this.f12509k != 0.0f) goto L6;
        super.onDraw(r10);
        return;
    L6:
        Drawable r11 = getDrawable();
        if (r11 != null) goto L10;
        super.onDraw(r10);
        return;
    L10:
        int r12 = r11.getIntrinsicWidth();
        if (r12 > 0) goto L14;
        super.onDraw(r10);
        return;
    L14:
        float r13 = (this.f12510l - (getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r12) / 2.0f))) * this.f12509k;
        int r14 = r10.save();
        r10.translate(r13, 0.0f);
        super.onDraw(r10);
        r10.restoreToCount(r14);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
        if (this.f12506h == true) goto L5;
        return;
    L5:
        b(h.j(r10 / 255.0f, 0.0f, 1.0f));
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        this.f12499a.onPressedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        this.f12499a.onSelectedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        this.f12499a.refreshColors(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.f12499a.resetAlphaAnim();
    }

    public final void setAlignmentProgress(float r10) {
        if (this.f12509k == r10) goto L7;
        this.f12509k = r10;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(getRadius());
        r11.setColor(r10);
        setBackground(r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(@ColorInt int r10) {
        this.f12500b.setBorderColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.f12500b.setBorderWidth(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.f12500b.setBottomDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f12499a.setChangeAlphaWhenDisable(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f12499a.setChangeAlphaWhenPress(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f12499a.setChangeAlphaWhenSelected(r10);
    }

    public final void setDisabledAlpha(float r10) {
        this.f12508j = r10;
        if (isEnabled() == true) goto L6;
        c(false);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.f12500b.setEnableShadowWidthRadius(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        OUIAlphaHelper r11 = this.f12503e;
        if (r11 == null) goto L6;
        r11.o(this, r10);
    L6:
        c(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        return this.f12500b.setHeightLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r10) {
        this.f12499a.setKeepPressAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.f12500b.setLeftDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.f12500b.setOuterNormalColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        this.f12500b.setOutlineExcludePadding(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f12500b.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        this.f12499a.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        OUIEffectHelper r11 = this.f12504f;
        if (r11 == null) goto L6;
        r11.s(r10);
    L6:
        OUIAlphaHelper r12 = this.f12503e;
        if (r12 == null) goto L11;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        this.f12500b.setRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f12500b.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.f12500b.setRightDividerAlpha(r10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        OUIAlphaHelper r11 = this.f12503e;
        if (r11 == null) goto L7;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11, boolean r12) {
        this.f12500b.setShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        this.f12500b.setShadowAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        this.f12500b.setShadowColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.f12500b.setShadowCornerRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        this.f12500b.setShadowElevation(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.f12500b.setShadowInsets(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(@StyleRes int r10) {
        this.f12500b.setShadowStyle(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        this.f12500b.setShadowVisible(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f12500b.setShowBorderOnlyBeforeL(r10);
    }

    public final void setTargetLeftPadding(int r10) {
        this.f12510l = r10;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.f12500b.setTopDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.f12500b.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        return this.f12500b.setWidthLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.f12500b.setWidthMin(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f12500b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        this.f12500b.updateBottomSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        this.f12500b.updateDividerColorStrength(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        this.f12500b.updateLeftSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        this.f12500b.updateRightSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List r10) {
        this.f12500b.updateShadows(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f12500b.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        this.f12500b.updateTopSeparatorColor(r10);
    }

    @JvmOverloads
    public OIconButton(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        OUIStyleProvider r14 = null;
        this(r10, r11, r12, r13, r14, 28, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f12500b.setRadius(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f12500b.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @JvmOverloads
    public OIconButton(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        OUIStyleProvider r14 = null;
        this(r10, r11, r12, r13, r14, 24, null);
    }

    public /* synthetic */ OIconButton(Context r10, AttributeSet r11, int r12, int r13, OUIStyleProvider r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r17 = r11;
        if ((r15 & 4) == 0) goto L8;
        int r18 = 0;
    L10:
        if ((r15 & 8) == 0) goto L12;
        int r19 = 0;
    L14:
        if ((r15 & 16) == 0) goto L16;
        r14 = new OUIStyleProvider(r10, r17, r18, r19);
    L16:
        this(r10, r17, r18, r19, r14);
        return;
    L12:
        r19 = r13;
        goto L14
    L8:
        r18 = r12;
        goto L10
    }

    public OIconButton(Context r10, AttributeSet r11, int r12, int r13, OUIStyleProvider r14) {
        q.g(r10, "context");
        q.g(r14, "provider");
        super(r10, r11, r12);
        this.f12499a = r14.getAlphaHelper();
        this.f12500b = r14.getLayoutHelper();
        this.f12501c = r14;
        this.f12508j = 1.0f;
        r14.a(this);
        setEnableShadowWidthRadius(true);
        this.f12502d = (OUILayoutHelper) getLayoutHelper();
        OUIAlphaHelper r15 = (OUIAlphaHelper) getAlphaHelper();
        this.f12503e = r15;
        if (r15 == null) goto L6;
        r15.r(getRadius());
    L6:
        this.f12504f = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r16 = r10.obtainStyledAttributes(r11, R$styleable.OButton);
        q.f(r16, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f12506h = r16.getBoolean(R$styleable.OButton_oui_buttonChangeAlphaWhenPressed, false);
        this.f12508j = r16.getFloat(R$styleable.OButton_oui_widgetDisableAlpha, 1.0f);
        r16.recycle();
        c(isEnabled());
        this.f12510l = b.b(16 * r10.getResources().getDisplayMetrics().density);
        if ((getBackground() instanceof ColorDrawable) == false) goto L13;
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(0);
        r17.setCornerRadius(getRadius());
        Drawable r18 = getBackground();
        if (r18 == null) goto L12;
        r17.setColor(((ColorDrawable) r18).getColor());
        setBackground(r17);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }
}
