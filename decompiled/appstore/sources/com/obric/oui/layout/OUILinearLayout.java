package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.bytedance.apm.constant.PerfConsts;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u001c\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00190\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00190\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ \u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n \u0015*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b&\u0010\u0013J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b,\u0010\u0013J\u0018\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b0\u00101J4\u00105\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010303 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010303\u0018\u00010402H\u0096\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b7\u00108J\u0010\u0010:\u001a\u000209H\u0096\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b<\u00108J\u0010\u0010=\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b=\u00108J\u0010\u0010>\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b>\u00101J\u0010\u0010?\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b?\u00101J\u0010\u0010@\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b@\u00101J\u0010\u0010A\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bA\u00101J\u0010\u0010B\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bB\u00101J\u0010\u0010C\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bC\u00101J\u0010\u0010D\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bD\u00101J\u0018\u0010F\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bF\u0010/J0\u0010K\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bK\u0010LJ0\u0010Q\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bQ\u0010LJ0\u0010V\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bV\u0010LJ0\u0010[\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b[\u0010LJ\u001a\u0010]\u001a\u00020\u00112\b\b\u0001\u0010\\\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b]\u0010/J\u0018\u0010_\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b_\u0010/J\u0018\u0010a\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\ba\u0010/J\u0018\u0010c\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bc\u0010\u0013J\u0018\u0010d\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bd\u0010/J\u0018\u0010e\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\be\u0010/J\u0018\u0010g\u001a\u00020\u00112\u0006\u0010f\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bg\u0010\u0013J0\u0010l\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bl\u0010LJ\u0018\u0010n\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bn\u0010/J0\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020\t2\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\bn\u0010LJ(\u0010u\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u000209H\u0096\u0001¢\u0006\u0004\bu\u0010vJ0\u0010u\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010t\u001a\u000209H\u0096\u0001¢\u0006\u0004\bu\u0010xJ\u0018\u0010y\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\by\u0010/J0\u0010}\u001a\u00020\u00112\n\b\u0001\u0010z\u001a\u0004\u0018\u0001032\n\b\u0001\u0010{\u001a\u0004\u0018\u0001032\u0006\u0010|\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b}\u0010~J\u0019\u0010\u007f\u001a\u00020\u00112\u0006\u0010t\u001a\u000209H\u0096\u0001¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u001a\u0010\u0081\u0001\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0081\u0001\u0010/J\u001a\u0010\u0082\u0001\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0082\u0001\u0010/J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0083\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0084\u0001\u0010/J%\u0010\u0087\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001d\u0010\u008a\u0001\u001a\u00020\u00112\t\b\u0001\u0010\u0089\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u008a\u0001\u0010/J$\u0010\u008c\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001b\u0010\u008f\u0001\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0005\b\u008f\u0001\u0010\u0013J\u001a\u0010\u0090\u0001\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0090\u0001\u0010/J\u0012\u0010\u0091\u0001\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0005\b\u0091\u0001\u0010$J\u001b\u0010\u0093\u0001\u001a\u00020\u00112\u0007\u0010\u0092\u0001\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0093\u0001\u0010/J\u0012\u0010\u0094\u0001\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0005\b\u0094\u0001\u00101J2\u0010\u0095\u0001\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0095\u0001\u0010LJ\u001a\u0010\u0096\u0001\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0096\u0001\u0010/J\u001c\u0010\u0098\u0001\u001a\u00020\u00112\u0007\u0010\u0097\u0001\u001a\u000209H\u0096\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u0080\u0001J2\u0010\u0099\u0001\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u0099\u0001\u0010LJ\u001a\u0010\u009a\u0001\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009a\u0001\u0010/J2\u0010\u009b\u0001\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009b\u0001\u0010LJ\u001a\u0010\u009c\u0001\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b\u009c\u0001\u0010/JD\u0010\u009e\u0001\u001a\u00020\u00112/\b\u0001\u0010\u009d\u0001\u001a(\u0012\f\u0012\n \u0015*\u0004\u0018\u00010303\u0018\u0001 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010303\u0018\u00010402H\u0096\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J2\u0010 \u0001\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b \u0001\u0010LJ\u001a\u0010¡\u0001\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\tH\u0096\u0001¢\u0006\u0005\b¡\u0001\u0010/J\u0013\u0010¢\u0001\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0014\u0010¥\u0001\u001a\u00030¤\u0001H\u0096\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0013\u0010§\u0001\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001J*\u0010©\u0001\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0006\b©\u0001\u0010ª\u0001J$\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010«\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\tH\u0014¢\u0006\u0006\b\u00ad\u0001\u0010\u0088\u0001J\u001b\u0010¯\u0001\u001a\u00020\u000f2\u0007\u0010®\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001b\u0010²\u0001\u001a\u00020\u000f2\u0007\u0010±\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b²\u0001\u0010°\u0001J\u001c\u0010µ\u0001\u001a\u00020\u00112\b\u0010´\u0001\u001a\u00030³\u0001H\u0017¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001c\u0010·\u0001\u001a\u00020\u00112\b\u0010´\u0001\u001a\u00030³\u0001H\u0016¢\u0006\u0006\b·\u0001\u0010¶\u0001J\u0019\u0010¸\u0001\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0005\b¸\u0001\u0010\u0013J\u001a\u0010º\u0001\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bº\u0001\u0010\u0013J\u001a\u0010¼\u0001\u001a\u00020\u00112\u0007\u0010»\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\b¼\u0001\u0010\u0013J\u001a\u0010½\u0001\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u001a\u0010¿\u0001\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¢\u0006\u0006\b¿\u0001\u0010¾\u0001J\u0018\u0010À\u0001\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\u000f¢\u0006\u0005\bÀ\u0001\u0010\u0013J\u0018\u0010Á\u0001\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\u000f¢\u0006\u0005\bÁ\u0001\u0010\u0013J\u001a\u0010Ã\u0001\u001a\u00020\u00112\u0007\u0010Â\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÃ\u0001\u0010\u0013J\u0011\u0010Ä\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÄ\u0001\u00101J\u0011\u0010Å\u0001\u001a\u00020\u0011H\u0014¢\u0006\u0005\bÅ\u0001\u0010$J\u0011\u0010Æ\u0001\u001a\u00020\u0011H\u0014¢\u0006\u0005\bÆ\u0001\u0010$J\u001a\u0010È\u0001\u001a\u00020\u00112\u0007\u0010Ç\u0001\u001a\u00020\tH\u0014¢\u0006\u0005\bÈ\u0001\u0010/J\u001a\u0010Ê\u0001\u001a\u00020\u00112\u0007\u0010É\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÊ\u0001\u0010\u0013J\u001a\u0010Ì\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020\tH\u0016¢\u0006\u0005\bÌ\u0001\u0010/R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001¨\u0006Û\u0001"}, d2 = {"Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "Lcom/obric/oui/common/style/OUIStyleProvider;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", "", "disable", "", "disablePressReleaseAnim", "(Z)V", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "event", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "Landroid/view/View;", PerfConsts.KEY_CURRENT_GALVANIC, "pressed", "onPressedChanged", "(Landroid/view/View;Z)V", "onSelectedChanged", "", "scene", "refreshColors", "(Ljava/lang/String;)V", "resetAlphaAnim", "()V", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "color", "setOverridePressColor", "(I)V", "decideIsNeedUpdatePressedForegroundBySelf", "()Z", "", "Lcom/obric/oui/common/style/Shadow;", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "alpha", "onPressAlphaChange", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "(IIII)V", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "(IIF)V", "shadowColor", "(IIIF)V", "setRightDividerAlpha", "firstShadow", "secondShadow", "animate", "setShadow", "(Lcom/obric/oui/common/style/Shadow;Lcom/obric/oui/common/style/Shadow;Z)V", "setShadowAlpha", "(F)V", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "(II)V", "styleResId", "setShadowStyle", "visible", "setShadowVisible", "(ZZ)V", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "shadows", "updateShadows", "(Ljava/util/List;)V", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "()Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getEffectHelper", "()Lcom/obric/oui/common/style/OUIEffectHelper;", "getLayoutHelper", "()Lcom/obric/oui/common/style/IOUILayout;", "a", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "widthLimit", "setWidthLimit", "(I)Z", "heightLimit", "setHeightLimit", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "setPressed", "enabled", "setEnabled", "hovered", "onHoverChanged", "dispatchGenericMotionEvent", "(Landroid/view/MotionEvent;)Z", "dispatchTouchEvent", "setVibrateEnabled", "setSoundEffectEnabled", "fakePressed", "setFakePressed", "isFakePressed", "onAttachedToWindow", "onDetachedFromWindow", "visibility", "onWindowVisibilityChanged", "selected", "setSelected", "minHeight", "setMinimumHeight", "Lcom/obric/oui/common/style/OUILayoutHelper;", "d", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "e", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mAlphaHelper", "f", "Lcom/obric/oui/common/style/OUIEffectHelper;", "mOUIEffectHelper", "g", "Z", "mIsFakePressed", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUILinearLayout extends LinearLayout implements IOUIAlpha, IOUILayout, IOUIStyleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOUIAlpha f15087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IOUILayout f15088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OUIStyleProvider f15089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OUILayoutHelper f15090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OUIAlphaHelper f15091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OUIEffectHelper f15092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15093g;

    @JvmOverloads
    public OUILinearLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 14, null);
    }

    public final void a(Context r10, AttributeSet r11, int r12) {
        q.g(r10, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f15088b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f15087a.disablePressReleaseAnim(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.dispatchDraw(r10);
        OUILayoutHelper r11 = this.f15090d;
        if (r11 == null) goto L6;
        r11.s(r10, getWidth(), getHeight());
    L6:
        OUILayoutHelper r12 = this.f15090d;
        if (r12 == null) goto L11;
        r12.q(r10);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        q.g(r10, "event");
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L7;
        r11.dispatchGenericMotionEvent(r10);
    L7:
        return super.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L6;
        r11.dispatchTouchEvent(r10);
    L6:
        OUIAlphaHelper r12 = this.f15091e;
        if (r12 == null) goto L11;
        r12.handleTouchEvent(r10);
    L11:
        return super.dispatchTouchEvent(r10);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        OUILayoutHelper r11 = this.f15090d;
        if (r11 == null) goto L6;
        r11.r(r10);
    L6:
        super.draw(r10);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.f15089c.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.f15088b.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.f15089c.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.f15089c.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.f15088b.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.f15088b.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.f15088b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.f15088b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r10) {
        this.f15087a.handleTouchEvent(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.f15088b.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.f15088b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.f15088b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.f15088b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.f15088b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.f15088b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isFakePressed() {
        return this.f15093g;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.f15088b.isShadowVisible();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OUIEffectHelper r10 = this.f15092f;
        if (r10 == null) goto L7;
        r10.k();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OUIEffectHelper r10 = this.f15092f;
        if (r10 == null) goto L7;
        r10.l();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r10) {
        super.onHoverChanged(r10);
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L7;
        r11.m(r10);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        OUILayoutHelper r12 = this.f15090d;
        if (r12 == null) goto L8;
        q.d(r12);
        int r13 = r12.A(r10);
        OUILayoutHelper r14 = this.f15090d;
        q.d(r14);
        int r15 = r14.z(r11);
        super.onMeasure(r13, r15);
        OUILayoutHelper r16 = this.f15090d;
        q.d(r16);
        int r17 = r16.D(r13, getMeasuredWidth());
        OUILayoutHelper r18 = this.f15090d;
        q.d(r18);
        int r19 = r18.C(r15, getMeasuredHeight());
        if (r13 != r17) goto L7;
        if (r15 != r19) goto L7;
        return;
    L7:
        super.onMeasure(r17, r19);
        return;
    L8:
        super.onMeasure(r10, r11);
    }

    public void onPressAlphaChange(int r10) {
        this.f15088b.onPressAlphaChange(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r10, boolean r11) {
        this.f15087a.onPressedChanged(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r10, boolean r11) {
        this.f15087a.onSelectedChanged(r10, r11);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L7;
        r11.q(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        this.f15087a.refreshColors(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.f15087a.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(@ColorInt int r10) {
        this.f15088b.setBorderColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.f15088b.setBorderWidth(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.f15088b.setBottomDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f15087a.setChangeAlphaWhenDisable(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f15087a.setChangeAlphaWhenPress(r10);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f15087a.setChangeAlphaWhenSelected(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.f15088b.setEnableShadowWidthRadius(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        OUIAlphaHelper r11 = this.f15091e;
        if (r11 == null) goto L7;
        r11.o(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setFakePressed(boolean r10) {
        if (this.f15093g == r10) goto L13;
        this.f15093g = r10;
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L8;
        r11.s(r10);
    L8:
        OUIAlphaHelper r12 = this.f15091e;
        if (r12 == null) goto L14;
        r12.onPressedChanged(this, this.f15093g);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        OUILayoutHelper r11 = this.f15090d;
        if (r11 == null) goto L8;
        q.d(r11);
        if (r11.setHeightLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r10) {
        this.f15087a.setKeepPressAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.f15088b.setLeftDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r10) {
        OUILayoutHelper r11 = this.f15090d;
        if (r11 == null) goto L6;
        r11.K(r10);
    L6:
        super.setMinimumHeight(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.f15088b.setOuterNormalColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        this.f15088b.setOutlineExcludePadding(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f15088b.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        this.f15087a.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L6;
        r11.s(r10);
    L6:
        super.setPressed(r10);
        OUIAlphaHelper r12 = this.f15091e;
        if (r12 == null) goto L11;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        this.f15088b.setRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f15088b.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.f15088b.setRightDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        OUIAlphaHelper r11 = this.f15091e;
        if (r11 == null) goto L7;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11, boolean r12) {
        this.f15088b.setShadow(r10, r11, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        this.f15088b.setShadowAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        this.f15088b.setShadowColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.f15088b.setShadowCornerRadius(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        this.f15088b.setShadowElevation(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.f15088b.setShadowInsets(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(@StyleRes int r10) {
        this.f15088b.setShadowStyle(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        this.f15088b.setShadowVisible(r10, r11);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f15088b.setShowBorderOnlyBeforeL(r10);
    }

    public final void setSoundEffectEnabled(boolean r10) {
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L7;
        r11.t(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.f15088b.setTopDividerAlpha(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.f15088b.setUseThemeGeneralShadowElevation();
    }

    public final void setVibrateEnabled(boolean r10) {
        OUIEffectHelper r11 = this.f15092f;
        if (r11 == null) goto L7;
        r11.u(r10);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        OUILayoutHelper r11 = this.f15090d;
        if (r11 == null) goto L8;
        q.d(r11);
        if (r11.setWidthLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.f15088b.setWidthMin(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f15088b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        this.f15088b.updateBottomSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        this.f15088b.updateDividerColorStrength(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        this.f15088b.updateLeftSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        this.f15088b.updateRightSeparatorColor(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List r10) {
        this.f15088b.updateShadows(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f15088b.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        this.f15088b.updateTopSeparatorColor(r10);
    }

    @JvmOverloads
    public OUILinearLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 12, null);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f15088b.setRadius(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f15088b.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @JvmOverloads
    public OUILinearLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        OUIStyleProvider r13 = null;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OUILinearLayout(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13, int r14, DefaultConstructorMarker r15) {
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

    public OUILinearLayout(Context r10, AttributeSet r11, int r12, OUIStyleProvider r13) {
        q.g(r10, "context");
        q.g(r13, "provider");
        super(r10, r11);
        this.f15087a = r13.getAlphaHelper();
        this.f15088b = r13.getLayoutHelper();
        this.f15089c = r13;
        r13.a(this);
        this.f15090d = (OUILayoutHelper) getLayoutHelper();
        this.f15091e = (OUIAlphaHelper) getAlphaHelper();
        this.f15092f = getEffectHelper();
        a(r10, r11, r12);
    }
}
