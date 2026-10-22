package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\bo\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001e\u001a\u00020\u000f2\u000e\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u001b0\u001b2\u0006\u0010\u001d\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010 \u001a\u00020\u000f2\u000e\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u001b0\u001b2\u0006\u0010\u001d\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b \u0010\u001fJ \u0010#\u001a\u00020\u000f2\u000e\u0010\"\u001a\n \u0017*\u0004\u0018\u00010!0!H\u0096\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b%\u0010\u0011J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b'\u0010\u0015J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b)\u0010\u0015J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b+\u0010\u0015J\u0018\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b-\u0010\u0015J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b1\u00102J4\u00106\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010404 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010404\u0018\u00010503H\u0096\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020:H\u0096\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b=\u00109J\u0010\u0010>\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b>\u00109J\u0010\u0010?\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b?\u00102J\u0010\u0010@\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b@\u00102J\u0010\u0010A\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bA\u00102J\u0010\u0010B\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bB\u00102J\u0010\u0010C\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bC\u00102J\u0010\u0010D\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bD\u00102J\u0010\u0010E\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bE\u00102J\u0018\u0010G\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bG\u00100J0\u0010L\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bL\u0010MJ0\u0010R\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bR\u0010MJ0\u0010W\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bW\u0010MJ0\u0010\\\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\\\u0010MJ\u001a\u0010^\u001a\u00020\u000f2\b\b\u0001\u0010]\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b^\u00100J\u0018\u0010`\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b`\u00100J\u0018\u0010b\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bb\u00100J\u0018\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bd\u0010\u0015J\u0018\u0010f\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bf\u0010gJ\u0018\u0010h\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bh\u00100J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bi\u00100J\u0018\u0010k\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bk\u0010\u0015J0\u0010p\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bp\u0010MJ\u0018\u0010r\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\br\u00100J0\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\br\u0010MJ(\u0010y\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020:H\u0096\u0001¢\u0006\u0004\by\u0010zJ0\u0010y\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010{\u001a\u00020\t2\u0006\u0010x\u001a\u00020:H\u0096\u0001¢\u0006\u0004\by\u0010|J\u0018\u0010}\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b}\u00100J4\u0010\u0081\u0001\u001a\u00020\u000f2\n\b\u0001\u0010~\u001a\u0004\u0018\u0001042\n\b\u0001\u0010\u007f\u001a\u0004\u0018\u0001042\u0007\u0010\u0080\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0083\u0001\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020:H\u0096\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0085\u0001\u00100J\u001a\u0010\u0086\u0001\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0086\u0001\u00100J\u001b\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0087\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0088\u0001\u00100J%\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u0089\u0001\u001a\u00020\t2\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001d\u0010\u008e\u0001\u001a\u00020\u000f2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u008e\u0001\u00100J%\u0010\u0090\u0001\u001a\u00020\u000f2\u0007\u0010\u008f\u0001\u001a\u00020\u00122\u0007\u0010\u0080\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001b\u0010\u0093\u0001\u001a\u00020\u000f2\u0007\u0010\u0092\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0005\b\u0093\u0001\u0010\u0015J\u001a\u0010\u0094\u0001\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0094\u0001\u00100J\u0012\u0010\u0095\u0001\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0005\b\u0095\u0001\u0010\u0011J\u001b\u0010\u0097\u0001\u001a\u00020\u00122\u0007\u0010\u0096\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0097\u0001\u0010gJ\u001b\u0010\u0099\u0001\u001a\u00020\u000f2\u0007\u0010\u0098\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0099\u0001\u00100J\u0012\u0010\u009a\u0001\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0005\b\u009a\u0001\u00102J2\u0010\u009b\u0001\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009b\u0001\u0010MJ\u001a\u0010\u009c\u0001\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009c\u0001\u00100J\u001c\u0010\u009e\u0001\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020:H\u0096\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u0084\u0001J2\u0010\u009f\u0001\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009f\u0001\u0010MJ\u001a\u0010 \u0001\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b \u0001\u00100J2\u0010¡\u0001\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¡\u0001\u0010MJ\u001a\u0010¢\u0001\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¢\u0001\u00100JD\u0010¤\u0001\u001a\u00020\u000f2/\b\u0001\u0010£\u0001\u001a(\u0012\f\u0012\n \u0017*\u0004\u0018\u00010404\u0018\u0001 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010404\u0018\u00010503H\u0096\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001J2\u0010¦\u0001\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¦\u0001\u0010MJ\u001a\u0010§\u0001\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b§\u0001\u00100J\u0013\u0010¨\u0001\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0014\u0010«\u0001\u001a\u00030ª\u0001H\u0096\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0013\u0010\u00ad\u0001\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0019\u0010¯\u0001\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0005\b¯\u0001\u0010\u0015J\u001c\u0010²\u0001\u001a\u00020\u000f2\b\u0010±\u0001\u001a\u00030°\u0001H\u0017¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001c\u0010´\u0001\u001a\u00020\u000f2\b\u0010±\u0001\u001a\u00030°\u0001H\u0016¢\u0006\u0006\b´\u0001\u0010³\u0001J$\u0010·\u0001\u001a\u00020\u000f2\u0007\u0010µ\u0001\u001a\u00020\t2\u0007\u0010¶\u0001\u001a\u00020\tH\u0014¢\u0006\u0006\b·\u0001\u0010\u008c\u0001J;\u0010¹\u0001\u001a\u00020\u000f2\u0007\u0010¸\u0001\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\tH\u0014¢\u0006\u0006\b¹\u0001\u0010º\u0001R\u001c\u0010¾\u0001\u001a\u0005\u0018\u00010»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0017\u0010È\u0001\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R0\u0010Î\u0001\u001a\u00020\u00122\u0007\u0010É\u0001\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0005\bÌ\u0001\u00102\"\u0005\bÍ\u0001\u0010\u0015¨\u0006Ï\u0001"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "Lcom/obric/oui/common/style/OUIStyleProvider;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", "", "a", "()V", "", "disable", "disablePressReleaseAnim", "(Z)V", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "event", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "Landroid/view/View;", PerfConsts.KEY_CURRENT_GALVANIC, "pressed", "onPressedChanged", "(Landroid/view/View;Z)V", "onSelectedChanged", "", "scene", "refreshColors", "(Ljava/lang/String;)V", "resetAlphaAnim", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "color", "setOverridePressColor", "(I)V", "decideIsNeedUpdatePressedForegroundBySelf", "()Z", "", "Lcom/obric/oui/common/style/Shadow;", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "alpha", "onPressAlphaChange", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "(IIII)V", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "heightLimit", "setHeightLimit", "(I)Z", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "(IIF)V", "shadowColor", "(IIIF)V", "setRightDividerAlpha", "firstShadow", "secondShadow", "animate", "setShadow", "(Lcom/obric/oui/common/style/Shadow;Lcom/obric/oui/common/style/Shadow;Z)V", "setShadowAlpha", "(F)V", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "(II)V", "styleResId", "setShadowStyle", "visible", "setShadowVisible", "(ZZ)V", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "widthLimit", "setWidthLimit", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "shadows", "updateShadows", "(Ljava/util/List;)V", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "()Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getEffectHelper", "()Lcom/obric/oui/common/style/OUIEffectHelper;", "getLayoutHelper", "()Lcom/obric/oui/common/style/IOUILayout;", "setPressed", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "onLayout", "(ZIIII)V", "Lcom/obric/oui/common/style/OUILayoutHelper;", "d", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "e", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mAlphaHelper", "f", "Lcom/obric/oui/common/style/OUIEffectHelper;", "mOUIEffectHelper", "g", "I", "originalGravity", CommonKey.KEY_VALUE, "h", "Z", "getEnableAutoAlignLeft", "setEnableAutoAlignLeft", "enableAutoAlignLeft", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements IOUIAlpha, IOUILayout, IOUIStyleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOUIAlpha f17252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IOUILayout f17253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OUIStyleProvider f17254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OUILayoutHelper f17255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OUIAlphaHelper f17256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OUIEffectHelper f17257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17259h;

    @JvmOverloads
    public OTextView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 14, null);
    }

    public final void a() {
        int r10 = 1;
        if (getLineCount() > 1) goto L5;
        boolean r11 = true;
    L6:
        int r12 = this.f17258g & 112;
        if (r11 == true) goto L10;
        r10 = 3;
    L10:
        int r13 = r12 | r10;
        if (getGravity() == r13) goto L14;
        setGravity(r13);
        return;
    L14:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f17253b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f17252a.disablePressReleaseAnim(r10);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.dispatchDraw(r10);
        OUILayoutHelper r11 = this.f17255d;
        if (r11 == null) goto L6;
        r11.s(r10, getWidth(), getHeight());
    L6:
        OUILayoutHelper r12 = this.f17255d;
        if (r12 == null) goto L11;
        r12.q(r10);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        OUILayoutHelper r11 = this.f17255d;
        if (r11 == null) goto L6;
        r11.r(r10);
    L6:
        super.draw(r10);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.f17254c.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.f17253b.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.f17254c.getEffectHelper();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f17259h;
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.f17254c.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.f17253b.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.f17253b.getShadowAlpha();
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.f17253b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.f17253b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        this.f17252a.handleTouchEvent(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.f17253b.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.f17253b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.f17253b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.f17253b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.f17253b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.f17253b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.f17253b.isShadowVisible();
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (this.f17259h == false) goto L6;
        a();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
        this.f17253b.onPressAlphaChange(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        this.f17252a.onPressedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        this.f17252a.onSelectedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        this.f17252a.refreshColors(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.f17252a.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(@ColorInt int r10) {
        this.f17253b.setBorderColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.f17253b.setBorderWidth(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.f17253b.setBottomDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f17252a.setChangeAlphaWhenDisable(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f17252a.setChangeAlphaWhenPress(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f17252a.setChangeAlphaWhenSelected(r10);
    }

    public final void setEnableAutoAlignLeft(boolean r10) {
        if (this.f17259h == r10) goto L6;
        this.f17259h = r10;
        requestLayout();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.f17253b.setEnableShadowWidthRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        return this.f17253b.setHeightLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r10) {
        this.f17252a.setKeepPressAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.f17253b.setLeftDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.f17253b.setOuterNormalColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        this.f17253b.setOutlineExcludePadding(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f17253b.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        this.f17252a.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        OUIEffectHelper r11 = this.f17257f;
        if (r11 == null) goto L6;
        r11.s(r10);
    L6:
        super.setPressed(r10);
        OUIAlphaHelper r12 = this.f17256e;
        if (r12 == null) goto L11;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        this.f17253b.setRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f17253b.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.f17253b.setRightDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11, boolean r12) {
        this.f17253b.setShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        this.f17253b.setShadowAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        this.f17253b.setShadowColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.f17253b.setShadowCornerRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        this.f17253b.setShadowElevation(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.f17253b.setShadowInsets(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(@StyleRes int r10) {
        this.f17253b.setShadowStyle(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        this.f17253b.setShadowVisible(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f17253b.setShowBorderOnlyBeforeL(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.f17253b.setTopDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.f17253b.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        return this.f17253b.setWidthLimit(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.f17253b.setWidthMin(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f17253b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        this.f17253b.updateBottomSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        this.f17253b.updateDividerColorStrength(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        this.f17253b.updateLeftSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        this.f17253b.updateRightSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List r10) {
        this.f17253b.updateShadows(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f17253b.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        this.f17253b.updateTopSeparatorColor(r10);
    }

    @JvmOverloads
    public OTextView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 12, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f17253b.setRadius(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f17253b.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @JvmOverloads
    public OTextView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OTextView(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = new OUIStyleProvider(r10, r11, r12, 0);
    L11:
        this(r10, r11, r12, r13);
    }

    public OTextView(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13) {
        q.g(r10, "context");
        q.g(r13, "provider");
        super(r10, r11, r12);
        this.f17252a = r13.getAlphaHelper();
        this.f17253b = r13.getLayoutHelper();
        this.f17254c = r13;
        this.f17258g = getGravity();
        r13.a(this);
        this.f17255d = (OUILayoutHelper) getLayoutHelper();
        this.f17256e = (OUIAlphaHelper) getAlphaHelper();
        this.f17257f = getEffectHelper();
        OUIAlphaHelper r14 = this.f17256e;
        if (r14 == null) goto L6;
        r14.setChangeAlphaWhenPress(false);
    L6:
        OUIAlphaHelper r15 = this.f17256e;
        if (r15 == null) goto L10;
        r15.setChangeAlphaWhenDisable(false);
    L10:
        setHighlightColor(r10.getColor(R$color.oui_text_highlight_color));
        setIncludeFontPadding(false);
    }
}
