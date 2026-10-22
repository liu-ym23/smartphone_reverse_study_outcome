package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.capabilitykit.common.UiType;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b%\b\u0017\u0018\u0000 ¨\u00022\u00020\u0001:\n¸\u0001©\u0002ª\u0002«\u0002¬\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u0019J/\u0010'\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b)\u0010(J'\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00101J'\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u000206H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u0002062\u0006\u0010<\u001a\u00020,H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010C\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\n2\b\u0010J\u001a\u0004\u0018\u00010I¢\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0006¢\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u0006¢\u0006\u0004\bQ\u0010OJ\r\u0010R\u001a\u00020\u0006¢\u0006\u0004\bR\u0010@J\u0015\u0010U\u001a\u00020\n2\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u0004\u0018\u00010S¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u0010H\u0016¢\u0006\u0004\bZ\u0010\u0019J\u0015\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u0010¢\u0006\u0004\b\\\u0010\u0019J\u0015\u0010^\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0010¢\u0006\u0004\b^\u0010\u0019J\u0017\u0010`\u001a\u00020\n2\b\u0010_\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b`\u0010\u001fJ\u0015\u0010b\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0004\bb\u0010\u0019J\u0015\u0010c\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0004\bc\u0010\u0019J\u0015\u0010d\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0004\bd\u0010\u0019J\u0015\u0010f\u001a\u00020\n2\u0006\u0010e\u001a\u00020\u0006¢\u0006\u0004\bf\u0010OJ\u0011\u0010g\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\n2\b\u0010i\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bj\u0010\u001fJ\u0017\u0010l\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bl\u0010\u001fJ\u0015\u0010n\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0010¢\u0006\u0004\bn\u0010\u0019J0\u0010u\u001a\u00020\n2!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110p¢\u0006\f\bq\u0012\b\br\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020\n0o¢\u0006\u0004\bu\u0010vJ0\u0010w\u001a\u00020\n2!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110p¢\u0006\f\bq\u0012\b\br\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020\n0o¢\u0006\u0004\bw\u0010vJ\u0015\u0010y\u001a\u00020\n2\u0006\u0010x\u001a\u00020\u0006¢\u0006\u0004\by\u0010OJ\u0017\u0010{\u001a\u00020\n2\b\u0010z\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b{\u0010|J\u000f\u0010}\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b}\u0010~J\u0017\u0010\u0080\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\u0006¢\u0006\u0005\b\u0080\u0001\u0010OJ\u0019\u0010\u0081\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0081\u0001\u0010OJ\u000f\u0010\u0082\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0082\u0001\u0010@J\u0017\u0010\u0083\u0001\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0005\b\u0083\u0001\u0010\u0019J\u0019\u0010\u0084\u0001\u001a\u00020\n2\b\u0010i\u001a\u0004\u0018\u00010\u001c¢\u0006\u0005\b\u0084\u0001\u0010\u001fJ\u001a\u0010\u0086\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0086\u0001\u0010OJ\u0017\u0010\u0087\u0001\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u0010¢\u0006\u0005\b\u0087\u0001\u0010\u0019J\u001c\u0010\u008a\u0001\u001a\u00020\n2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001c\u0010\u008d\u0001\u001a\u00020\n2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008c\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001c¢\u0006\u0005\b\u0090\u0001\u0010\u001fJ\u0017\u0010\u0091\u0001\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0005\b\u0091\u0001\u0010\u0019J\u001a\u0010\u0092\u0001\u001a\u00020\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001c¢\u0006\u0005\b\u0092\u0001\u0010\u001fJ\u0017\u0010\u0093\u0001\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0010¢\u0006\u0005\b\u0093\u0001\u0010\u0019J\u001a\u0010\u0096\u0001\u001a\u00020\n2\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001e\u0010\u009a\u0001\u001a\u00020\u00102\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001e\u0010\u009d\u0001\u001a\u00020\u00102\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009b\u0001J\u001e\u0010\u009e\u0001\u001a\u00020\u00102\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016¢\u0006\u0006\b\u009e\u0001\u0010\u009b\u0001J\u0015\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001e\u0010¢\u0001\u001a\u00020\n2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¦\u0001\u001a\u00020\n2\n\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u0001¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001e\u0010¨\u0001\u001a\u00020\n2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0006\b¨\u0001\u0010\u008b\u0001J\u0018\u0010ª\u0001\u001a\u00020\n2\u0007\u0010©\u0001\u001a\u00020\u0006¢\u0006\u0005\bª\u0001\u0010OJ\u0018\u0010¬\u0001\u001a\u00020\n2\u0007\u0010«\u0001\u001a\u00020\u0010¢\u0006\u0005\b¬\u0001\u0010\u0019J$\u0010¯\u0001\u001a\u00020\n2\u0007\u0010\u00ad\u0001\u001a\u00020\u00062\u0007\u0010®\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b¯\u0001\u0010°\u0001J?\u0010¶\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\u00102\u0007\u0010²\u0001\u001a\u00020\u00062\u0007\u0010³\u0001\u001a\u00020\u00062\u0007\u0010´\u0001\u001a\u00020\u00062\u0007\u0010µ\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¹\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¸\u0001\u0010\u000fR\u0019\u0010¼\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010¾\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b½\u0001\u0010\u000fR\u0019\u0010À\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010»\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010»\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010»\u0001R\u001b\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0018\u0010É\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÈ\u0001\u0010\u000fR\u0018\u0010Ë\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÊ\u0001\u0010\u000fR\u0019\u0010Î\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Ð\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Í\u0001R\u0017\u0010]\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u000fR\u0018\u0010Ò\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÑ\u0001\u0010\u000fR\u0018\u0010Ô\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÓ\u0001\u0010\u000fR\u0018\u0010Ö\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÕ\u0001\u0010\u000fR\u0019\u0010Ø\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010»\u0001R\u0018\u0010Ú\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÙ\u0001\u0010\u000fR\u0018\u0010Ü\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÛ\u0001\u0010\u000fR\u0017\u0010Ý\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010\u000fR\u001b\u0010à\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u0018\u0010â\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bá\u0001\u0010\u000fR\u0018\u0010ä\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bã\u0001\u0010\u000fR\u001b\u0010ç\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010k\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010ß\u0001R\u0019\u0010ê\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010»\u0001R\u001b\u0010ì\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ß\u0001R\u001b\u0010í\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010ß\u0001R\u001a\u0010î\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010ß\u0001R\u0017\u0010ï\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\u000fR\u001a\u0010ñ\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bG\u0010ð\u0001R\u0017\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010»\u0001R\u0018\u0010ô\u0001\u001a\u00030ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010ó\u0001R\u0018\u0010ø\u0001\u001a\u00030õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u0017\u0010û\u0001\u001a\u00030ù\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b'\u0010ú\u0001R\u0018\u0010þ\u0001\u001a\u00030ü\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010ý\u0001R\u001d\u0010\u0084\u0002\u001a\u00030ÿ\u00018\u0006¢\u0006\u0010\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0016\u0010\u0086\u0002\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bC\u0010\u0085\u0002R\u0016\u0010\u0087\u0002\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b=\u0010\u0085\u0002R\u0017\u0010\u008a\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\r\u0010\u0089\u0002R\u0017\u0010\u008b\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0089\u0002R\u0017\u0010\u008c\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0015\u0010\u0089\u0002R\u0017\u0010\u008d\u0002\u001a\u00030ü\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010ý\u0001R\u0018\u0010\u008e\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0089\u0002R\u0018\u0010\u008f\u0002\u001a\u00030ù\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010ú\u0001R\u0017\u0010\u0090\u0002\u001a\u00030ù\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b3\u0010ú\u0001R\u0017\u0010\u0091\u0002\u001a\u00030ù\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b0\u0010ú\u0001R\u001a\u0010\u0093\u0002\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b2\u0010\u0092\u0002R\u0017\u0010\u0094\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001b\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0095\u0002R\u001b\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010\u0097\u0002R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0099\u0002R&\u0010\u009e\u0002\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0002\u0010\u000f\u001a\u0005\b\u009c\u0002\u0010\u0012\"\u0005\b\u009d\u0002\u0010\u0019R\u0019\u0010 \u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010»\u0001R\u0018\u0010¢\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0002\u0010\u000fR\u001b\u0010¥\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010¤\u0002R\u001b\u0010§\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010¤\u0002¨\u0006\u00ad\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "V", "()V", "M", "Y", "Z", "", "N", "()Z", CommonKey.KEY_VALUE, "Landroid/text/TextUtils$TruncateAt;", "O", "(I)Landroid/text/TextUtils$TruncateAt;", "focus", "X", "(Z)V", "pressed", "W", "", "scene", "B", "(Ljava/lang/String;)V", "hasFocus", "P", "labelTextColor", "inputHintTextColor", "", "duration", "Landroid/animation/ValueAnimator;", "H", "(IIJ)Landroid/animation/ValueAnimator;", "E", "Lcom/obric/oui/forms/OInputView$LabelUIState;", WsConstants.KEY_CONNECTION_STATE, "Landroid/widget/TextView;", "fakeLabel", "a0", "(Lcom/obric/oui/forms/OInputView$LabelUIState;Landroid/widget/TextView;Ljava/lang/String;)V", "T", "(Landroid/widget/TextView;)V", "U", "S", "startColor", "endColor", "", "ratio", "C", "(IIF)I", "getFakeInputOffsetY", "()F", "vFakeInput", "L", "(Landroid/widget/TextView;)F", "getContentViewRes", "()I", "", "s", "K", "(Ljava/lang/CharSequence;)I", "Landroid/text/Editable;", "editable", "D", "(Landroid/text/Editable;)V", "Landroid/text/method/KeyListener;", "keyListener", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "radius", "setRadius", "(I)V", "type", "setInputType", "getInputType", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "commitCompletionListener", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$CommitCompletionListener;)V", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "enabled", "setEnabled", "error", "setErrorState", "inScrollableView", "setIsInScrollableView", ServerElements.LABEL, "setLabel", "show", "setShowLabel", "setShowLabelAnim", "setShowLabelIcon", Style.KEY_HEIGHT, "setInputHeight", "getText", "()Ljava/lang/String;", "text", "setText", "hint", "setHint", "single", "setSingleLine", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "Lkotlin/ParameterName;", "name", "parent", "creator", "setLeftView", "(Lkotlin/jvm/functions/Function1;)V", "setActionView", "max", "setMaxLines", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", CommonColumns.PARAMETER_LIMIT, "setLimitCountValue", "setLimitCount", "getLimitCount", "setShowLimitIndicator", "b0", "mode", "setInputMode", "setComboInputEnabled", "Landroid/view/View$OnClickListener;", "l", "setOnComboArrowClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "setOnTextExceedLengthListener", "(Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;)V", "tip", "setErrorTip", "R", "setCommonTip", "Q", "Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "listener", "setOnTextClearedListener", "(Lcom/obric/oui/forms/OInputView$OnTextClearedListener;)V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "dispatchTouchEvent", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/text/TextWatcher;", "watcher", "A", "(Landroid/text/TextWatcher;)V", "setOnClickListener", "resId", "setBgResId", "hide", "setAlwaysHideEye", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "a", "comboInputEnabled", "b", "I", "inputMode", "c", "singleLine", "d", "maxLines", "e", "orientation", "f", "gravity", "g", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "h", "transparentBorder", "i", "transparentBg", "j", "F", "lastScrollY", "k", "lastScrollX", "m", "autoShowClear", "n", "showResizer", "o", "showLimitIndicator", "p", "limitCount", "q", "showLabel", "r", "showLabelAnim", "showLabelIcon", "t", "Ljava/lang/String;", "insideLabel", "u", "isError", "v", "isEnable", "w", "Ljava/lang/Integer;", "inputHeight", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, "inputType", "z", "initText", "errorTip", "commonTip", "showCommonTip", "Ljava/lang/CharSequence;", "digits", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vBorderContainer", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "vTitleContainer", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "vTitle", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vTitleIcon", "Lcom/obric/oui/forms/OEditText;", "J", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "Landroid/widget/FrameLayout;", "vLeftViewContainer", "vCustomActionContainer", "Landroid/view/View;", "Landroid/view/View;", "vActionContainer", "vClear", "vComboArrow", "vEye", "vInputResizer", "vErrorTip", "vCommonTip", "vLimitIndicator", "Landroid/widget/TextView;", "vFakeLabel", "shouldDispatchToInput", "Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "onTextClearedListener", "Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "onTextExceedLengthListener", "Landroid/view/View$OnClickListener;", "onComboArrowClickListener", "c0", "getAutoHideSoftInputWhenLoseFocus", "setAutoHideSoftInputWhenLoseFocus", "autoHideSoftInputWhenLoseFocus", "d0", "bgResId", "e0", "alwaysHideEye", "f0", "Landroid/animation/ValueAnimator;", "labelShowAnimator", "g0", "labelHideAnimator", "h0", "InputMode", "LabelUIState", "OnTextClearedListener", "OnTextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final a f14681h0 = null;
    public String A;
    public String B;
    public boolean C;
    public CharSequence D;
    public int E;
    public final OUIConstraintLayout F;
    public final LinearLayout G;
    public final OTextView H;
    public final ImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final OEditText f14682J;
    public final FrameLayout K;
    public final FrameLayout L;
    public final View M;
    public final View N;
    public final View O;
    public final ImageView P;
    public final View Q;
    public final OTextView R;
    public final OTextView S;
    public final OTextView T;
    public TextView U;
    public boolean V;
    public OnTextClearedListener W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14683a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public OnTextExceedLengthListener f14684a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14685b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View.OnClickListener f14686b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14687c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f14688c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14689d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f14690d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14691e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f14692e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14693f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public ValueAnimator f14694f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextUtils.TruncateAt f14695g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ValueAnimator f14696g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f14708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f14709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f14712w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f14713x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14714y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f14715z;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputView$InputMode;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public @interface InputMode {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "(Ljava/lang/String;I)V", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LabelUIState extends Enum<LabelUIState> {
        private static final /* synthetic */ LabelUIState[] $VALUES = null;
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        private static final /* synthetic */ LabelUIState[] $values() {
            return new LabelUIState[]{REAL_LABEL_SHOW, FAKE_LABEL_SHOW, LABEL_NONE};
        }

        static {
            REAL_LABEL_SHOW = new LabelUIState("REAL_LABEL_SHOW", 0);
            FAKE_LABEL_SHOW = new LabelUIState("FAKE_LABEL_SHOW", 1);
            LABEL_NONE = new LabelUIState("LABEL_NONE", 2);
            $VALUES = $values();
        }

        private LabelUIState(String r10, int r11) {
            super(r10, r11);
        }

        public static LabelUIState valueOf(String r10) {
            return (LabelUIState) Enum.valueOf(LabelUIState.class, r10);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "", "afterClear", "", "beforeClear", "text", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTextClearedListener {
        void afterClear();

        void beforeClear(@Nullable String r10);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTextExceedLengthListener {
        void textExceedLength(@NotNull String r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14716a = null;

        static {
            int[] r10 = new int[LabelUIState.values().length];
            r10[LabelUIState.REAL_LABEL_SHOW.ordinal()] = 1;
            r10[LabelUIState.FAKE_LABEL_SHOW.ordinal()] = 2;
            r10[LabelUIState.LABEL_NONE.ordinal()] = 3;
            f14716a = r10;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OInputView f14717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f14718b;

        public c(OInputView r10, TextView r11) {
            this.f14717a = r10;
            this.f14718b = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            if (this.f14717a.getVInput().hasFocus() == false) goto L5;
            OInputView.z(this.f14717a, LabelUIState.REAL_LABEL_SHOW, this.f14718b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            OInputView.z(this.f14717a, LabelUIState.FAKE_LABEL_SHOW, this.f14718b, "LabelHideAnim, onAnimationCancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            if (this.f14717a.getVInput().hasFocus() == false) goto L5;
            OInputView.z(this.f14717a, LabelUIState.REAL_LABEL_SHOW, this.f14718b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            OInputView.z(this.f14717a, LabelUIState.FAKE_LABEL_SHOW, this.f14718b, "LabelHideAnim, onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10, boolean r11) {
            q.g(r10, "animation");
            OInputView.z(this.f14717a, LabelUIState.FAKE_LABEL_SHOW, this.f14718b, "LabelHideAnim, onAnimationStart");
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OInputView f14719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f14720b;

        public d(OInputView r10, TextView r11) {
            this.f14719a = r10;
            this.f14720b = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            if (this.f14719a.getVInput().hasFocus() == false) goto L5;
            OInputView.z(this.f14719a, LabelUIState.REAL_LABEL_SHOW, this.f14720b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            OInputView.z(this.f14719a, LabelUIState.FAKE_LABEL_SHOW, this.f14720b, "LabelShowAnim, onAnimationCancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            if (this.f14719a.getVInput().hasFocus() == false) goto L5;
            OInputView.z(this.f14719a, LabelUIState.REAL_LABEL_SHOW, this.f14720b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            OInputView.z(this.f14719a, LabelUIState.FAKE_LABEL_SHOW, this.f14720b, "LabelShowAnim, onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10, boolean r11) {
            q.g(r10, "animation");
            OInputView.z(this.f14719a, LabelUIState.FAKE_LABEL_SHOW, this.f14720b, "LabelShowAnim, onAnimationStart");
        }
    }

    static {
        f14681h0 = new a(null);
    }

    @JvmOverloads
    public OInputView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ ValueAnimator F(OInputView r10, int r11, int r12, long r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = ContextCompat.b(r10.getContext(), R$color.oui_text_3);
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = ContextCompat.b(r10.getContext(), R$color.oui_text_4);
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = 200;
    L13:
        return r10.E(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelHideAnim");
    }

    public static final void G(float r10, OInputView r11, int r12, int r13, float r14, TextView r15, ValueAnimator r16) {
        q.g(r11, "this$0");
        q.g(r15, "$vFakeInput");
        q.g(r16, "animation");
        Object r17 = r16.getAnimatedValue();
        if (r17 == null) goto L7;
        float r18 = ((Float) r17).floatValue();
        float r19 = r10 + ((0 - r10) * r18);
        float r20 = r14 + ((1.0f - r14) * r18);
        r15.setTextColor(r11.C(r12, r13, r18));
        r15.setScaleX(r20);
        r15.setScaleY(r20);
        r15.setTranslationY(r19);
        L.i("OInputView", "progress: " + r18 + ", transY: " + r19 + ", scale: " + r20);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public static /* synthetic */ ValueAnimator I(OInputView r10, int r11, int r12, long r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = ContextCompat.b(r10.getContext(), R$color.oui_text_3);
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = ContextCompat.b(r10.getContext(), R$color.oui_text_4);
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = 200;
    L13:
        return r10.H(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelShowAnim");
    }

    public static final void J(float r10, OInputView r11, int r12, int r13, float r14, TextView r15, ValueAnimator r16) {
        q.g(r11, "this$0");
        q.g(r15, "$vFakeInput");
        q.g(r16, "animation");
        Object r17 = r16.getAnimatedValue();
        if (r17 == null) goto L7;
        float r18 = ((Float) r17).floatValue();
        float r19 = 0;
        float r20 = r19 + ((r10 - r19) * r18);
        float r21 = ((r14 - 1.0f) * r18) + 1.0f;
        r15.setTextColor(r11.C(r12, r13, r18));
        r15.setScaleX(r21);
        r15.setScaleY(r21);
        r15.setTranslationY(r20);
        L.i("OInputView", "progress: " + r18 + ", transY: " + r20 + ", scale: " + r21);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void M() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.hideSoftInputFromWindow(this.f14682J.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final TextUtils.TruncateAt O(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    private final void V() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r11 = (InputMethodManager) r10;
    L6:
        if (r11 == null) goto L10;
        r11.showSoftInput(this.f14682J, 0);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ void g(OInputView r10, View r11) {
        m(r10, r11);
    }

    private final float getFakeInputOffsetY() {
        if (this.G.getHeight() > 0) goto L5;
    L7:
        L.j("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.G.getHeight() + ", height: " + getHeight());
        float r10 = tc.f.t(this, -11.0f);
    L8:
        L.a("OInputView", q.p("getFakeInputOffsetY, offsetY: ", Float.valueOf(r10)));
        return r10;
    L5:
        if (getHeight() <= 0) goto L7;
        r10 = (this.G.getY() + (this.G.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    public static /* synthetic */ void h(OInputView r10, View r11) {
        n(r10, r11);
    }

    public static /* synthetic */ void i(float r10, OInputView r11, int r12, int r13, float r14, TextView r15, ValueAnimator r16) {
        G(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void j(float r10, OInputView r11, int r12, int r13, float r14, TextView r15, ValueAnimator r16) {
        J(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void k(OInputView r10, View r11) {
        l(r10, r11);
    }

    public static final void l(OInputView r10, View r11) {
        q.g(r10, "this$0");
        OnTextClearedListener r12 = r10.W;
        if (r12 == null) goto L10;
        Editable r13 = r10.f14682J.getText();
        if (r13 != null) goto L8;
        String r14 = null;
    L9:
        r12.beforeClear(r14);
        goto L10
    L8:
        r14 = r13.toString();
    L10:
        r10.setText("");
        OnTextClearedListener r15 = r10.W;
        if (r15 == null) goto L14;
        r15.afterClear();
    L14:
        r10.Y();
    }

    public static final void m(OInputView r10, View r11) {
        q.g(r10, "this$0");
        if (r10.f14714y != r10.f14682J.getInputType()) goto L5;
        r10.P.setImageResource(R$drawable.o_input_view_eyes_open);
        OEditText r12 = r10.f14682J;
        r12.setInputType(r12.getInputType() | SearchChipsView.BROWN);
    L7:
        if (r10.f14682J.hasFocus() == false) goto L14;
        OEditText r13 = r10.f14682J;
        Editable r14 = r13.getText();
        if (r14 != null) goto L11;
        int r15 = 0;
    L12:
        r13.setSelection(r15);
        return;
    L11:
        r15 = r14.length();
        goto L12
    L14:
        return;
    L5:
        r10.P.setImageResource(R$drawable.o_input_view_eyes_close);
        r10.f14682J.setInputType(r10.f14714y);
        goto L7
    }

    public static final void n(OInputView r10, View r11) {
        q.g(r10, "this$0");
        r10.f14682J.requestFocus();
        if (r10.f14682J.hasFocus() == true) goto L5;
    L7:
        r10.V();
        return;
    L5:
        if (r10.f14682J.isCursorVisible() == true) goto L7;
        r10.f14682J.setCursorVisible(true);
        goto L7
    }

    public static final /* synthetic */ int o(OInputView r10) {
        return r10.f14705p;
    }

    public static final /* synthetic */ OnTextExceedLengthListener p(OInputView r10) {
        return r10.f14684a0;
    }

    public static final /* synthetic */ boolean q(OInputView r10) {
        return r10.C;
    }

    public static final /* synthetic */ void r(OInputView r10) {
        r10.M();
    }

    public static final /* synthetic */ boolean s(OInputView r10) {
        return r10.f14710u;
    }

    public static final /* synthetic */ void t(OInputView r10, boolean r11) {
        r10.P(r11);
    }

    public static final /* synthetic */ void u(OInputView r10) {
        r10.V();
    }

    public static final /* synthetic */ void v(OInputView r10, boolean r11) {
        r10.W(r11);
    }

    public static final /* synthetic */ void w(OInputView r10, boolean r11) {
        r10.X(r11);
    }

    public static final /* synthetic */ void x(OInputView r10) {
        r10.Y();
    }

    public static final /* synthetic */ void y(OInputView r10) {
        r10.Z();
    }

    public static final /* synthetic */ void z(OInputView r10, LabelUIState r11, TextView r12, String r13) {
        r10.a0(r11, r12, r13);
    }

    public final void A(TextWatcher r10) {
        this.f14682J.addTextChangedListener(r10);
    }

    public final void B(String r10) {
        if (this.f14707r == true) goto L5;
        return;
    L5:
        TextView r11 = this.U;
        if (r11 != null) goto L9;
        return;
    L9:
        if (this.f14706q == true) goto L12;
        this.f14682J.setHint(this.f14713x);
        a0(LabelUIState.LABEL_NONE, r11, "adjustInputViewAndLabel, " + r10 + ", no label");
        return;
    L12:
        if (this.f14687c == true) goto L14;
        this.f14682J.setHint(this.f14713x);
        a0(LabelUIState.REAL_LABEL_SHOW, r11, "adjustInputViewAndLabel, " + r10 + ", can not show label anim");
        return;
    L14:
        this.f14682J.setHint("");
        r11.setText(this.f14709t);
        Editable r12 = this.f14682J.getText();
        if (r12 == null) goto L21;
        if (r12.length() == 0) goto L21;
        a0(LabelUIState.REAL_LABEL_SHOW, r11, "adjustInputViewAndLabel, " + r10 + ", can show label anim, vInput.text not empty");
        return;
    L21:
        if (this.f14682J.hasFocus() == false) goto L23;
        a0(LabelUIState.REAL_LABEL_SHOW, r11, "adjustInputViewAndLabel, " + r10 + ", can show label anim, vInput.text empty, focused");
        return;
    L23:
        a0(LabelUIState.FAKE_LABEL_SHOW, r11, "adjustInputViewAndLabel, " + r10 + ", can show label anim, vInput.text empty, not focused");
    }

    public final int C(int r10, int r11, float r12) {
        return androidx.core.graphics.d.c(r10, r11, bg.h.j(r12, 0.0f, 1.0f));
    }

    public void D(Editable r10) {
    }

    public final ValueAnimator E(final int r10, final int r11, long r12) {
        final TextView r13 = this.U;
        if (r13 != null) goto L6;
        return null;
    L6:
        final float r14 = getFakeInputOffsetY();
        final float r15 = L(r13);
        r13.setPivotX(0.0f);
        r13.setPivotY(-r14);
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(r12);
        r16.setInterpolator(new DecelerateInterpolator());
        r16.addUpdateListener(new g(r14, this, r10, r11, r15, r13));
        r16.addListener(new c(this, r13));
        return r16;
    }

    public final ValueAnimator H(final int r10, final int r11, long r12) {
        final TextView r13 = this.U;
        if (r13 != null) goto L6;
        return null;
    L6:
        final float r14 = getFakeInputOffsetY();
        final float r15 = L(r13);
        r13.setPivotX(0.0f);
        r13.setPivotY(-r14);
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(r12);
        r16.setInterpolator(new DecelerateInterpolator());
        r16.addUpdateListener(new k(r14, this, r11, r10, r15, r13));
        r16.addListener(new d(this, r13));
        return r16;
    }

    public int K(CharSequence r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.length();
    }

    public final float L(TextView r10) {
        if (this.H.getTextSize() > 0.0f) goto L5;
    L7:
        L.j("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + this.H.getTextSize() + ", vFakeInput.textSize: " + r10.getTextSize());
        float r11 = 0.857143f;
    L8:
        L.a("OInputView", q.p("getScaleRatio, scale: ", Float.valueOf(r11)));
        return r11;
    L5:
        if (r10.getTextSize() <= 0.0f) goto L7;
        r11 = this.H.getTextSize() / r10.getTextSize();
        goto L8
    }

    public final boolean N() {
        int r10 = this.f14714y & 4095;
        if (r10 != 129) goto L5;
        boolean r11 = true;
    L7:
        if (r10 != 225) goto L9;
        boolean r12 = true;
    L11:
        if (r10 != 18) goto L13;
        boolean r13 = true;
    L14:
        if (r11 == true) goto L18;
        if (r12 == true) goto L18;
        if (r13 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L7
    }

    public final void P(boolean r10) {
        if (this.f14707r == true) goto L6;
        return;
    L6:
        if (this.f14706q == true) goto L9;
        return;
    L9:
        if (this.f14687c == true) goto L12;
        return;
    L12:
        if (this.U != null) goto L14;
        return;
    L14:
        Editable r11 = this.f14682J.getText();
        if (r11 == null) goto L22;
        if (r11.length() == 0) goto L22;
        LabelUIState r12 = LabelUIState.REAL_LABEL_SHOW;
        TextView r13 = this.U;
        q.d(r13);
        a0(r12, r13, q.p("playLabelAnim, hasFocus: ", Boolean.valueOf(r10)));
        return;
    L22:
        if (r10 == false) goto L46;
        ValueAnimator r14 = this.f14696g0;
        if (r14 == null) goto L27;
        r14.cancel();
    L27:
        ValueAnimator r15 = this.f14696g0;
        if (r15 == null) goto L31;
        r15.removeAllUpdateListeners();
    L31:
        ValueAnimator r16 = this.f14696g0;
        if (r16 == null) goto L35;
        r16.removeAllListeners();
    L35:
        ValueAnimator r17 = this.f14694f0;
        if (r17 != null) goto L39;
    L41:
        ValueAnimator r18 = I(this, 0, 0, 0, 7, null);
        this.f14694f0 = r18;
        if (r18 == null) goto L45;
        r18.start();
    L45:
        L.a("OInputView", "start label show anim");
        return;
    L39:
        if (r17.isRunning() != true) goto L41;
        L.j("OInputView", "label show anim is running, do nothing");
        return;
    L46:
        ValueAnimator r19 = this.f14694f0;
        if (r19 == null) goto L50;
        r19.cancel();
    L50:
        ValueAnimator r110 = this.f14694f0;
        if (r110 == null) goto L54;
        r110.removeAllUpdateListeners();
    L54:
        ValueAnimator r111 = this.f14694f0;
        if (r111 == null) goto L58;
        r111.removeAllListeners();
    L58:
        ValueAnimator r112 = this.f14696g0;
        if (r112 != null) goto L62;
    L64:
        ValueAnimator r113 = F(this, 0, 0, 0, 7, null);
        this.f14696g0 = r113;
        if (r113 == null) goto L68;
        r113.start();
    L68:
        L.a("OInputView", "start label hide anim");
        return;
    L62:
        if (r112.isRunning() != true) goto L64;
        L.j("OInputView", "label hide anim is running, do nothing");
    }

    public final void Q(boolean r10) {
        tc.l.p(this.S, r10);
    }

    public final void R(boolean r10) {
        tc.l.p(this.R, r10);
    }

    public final void S(TextView r10) {
        this.G.setVisibility(4);
        r10.setVisibility(0);
        this.f14682J.setAlpha(0.0f);
    }

    public final void T(TextView r10) {
        this.G.setVisibility(8);
        r10.setVisibility(8);
        this.f14682J.setAlpha(1.0f);
    }

    public final void U(TextView r10) {
        this.G.setVisibility(0);
        r10.setVisibility(8);
        this.f14682J.setAlpha(1.0f);
    }

    public final void W(boolean r10) {
        int r11 = this.f14690d0;
        if (r11 == 0) goto L7;
        this.F.setBackgroundResource(r11);
        return;
    L7:
        if (this.f14698i == false) goto L11;
        this.F.setBackgroundResource(R$color.Transparent);
        return;
    L11:
        if (this.f14711v == true) goto L13;
        int r12 = R$drawable.o_input_view_pressed_background;
    L19:
        this.F.setBackgroundResource(r12);
        return;
    L13:
        if (r10 == false) goto L16;
        r12 = R$drawable.o_input_view_pressed_background;
        goto L19
    L16:
        if (this.f14682J.hasFocus() == false) goto L18;
        r12 = R$drawable.o_input_view_focused_background;
        goto L19
    L18:
        r12 = R$drawable.o_input_view_normal_background;
        goto L19
    }

    public final void X(boolean r10) {
        int r11 = 0;
        if (this.f14697h == false) goto L7;
        this.F.setBorderWidth(0);
        this.F.setBorderColor(ContextCompat.b(getContext(), R$color.Transparent));
        return;
    L7:
        if (this.f14711v == true) goto L9;
    L8:
        int r12 = tc.f.r(this, 0);
    L14:
        this.F.setBorderWidth(r12);
        if (this.f14711v == true) goto L18;
        r11 = tc.f.r(this, 0);
    L22:
        if (r11 == 0) goto L25;
        this.F.setBorderColor(ContextCompat.b(getContext(), r11));
        return;
    L25:
        return;
    L18:
        if (this.f14710u == false) goto L20;
        r11 = R$color.oui_functional_red_7;
        goto L22
    L20:
        if (r10 == false) goto L22;
        r11 = R$color.oui_basic_line_3;
        goto L22
    L9:
        if (r10 == false) goto L12;
        r12 = tc.f.r(this, 2);
        goto L14
    L12:
        if (this.f14710u == false) goto L8;
        r12 = tc.f.p(this, 1.2d);
        goto L14
    }

    public final void Y() {
        if (this.f14702m == true) goto L5;
        return;
    L5:
        boolean r10 = true;
        if (N() == false) goto L8;
    L19:
        boolean r11 = false;
    L20:
        tc.l.p(this.N, r11);
        if (r11 == false) goto L23;
        tc.l.p(this.P, false);
    L23:
        View r12 = this.M;
        if (this.N.getVisibility() != 0) goto L27;
    L33:
        tc.l.p(r12, r10);
        return;
    L27:
        if (this.P.getVisibility() == 0) goto L33;
        if (this.O.getVisibility() == 0) goto L33;
        r10 = false;
        goto L33
    L8:
        if (this.f14685b != 0) goto L19;
        if (this.f14711v == false) goto L19;
        if (this.f14682J.hasFocus() == false) goto L19;
        Editable r13 = this.f14682J.getText();
        if (r13 == null) goto L19;
        if (r13.length() == 0) goto L19;
        r11 = true;
        goto L20
    }

    public final void Z() {
        boolean r10 = true;
        if (N() == true) goto L5;
    L14:
        boolean r11 = false;
    L15:
        tc.l.p(this.P, r11);
        if (r11 == false) goto L18;
        tc.l.p(this.N, false);
    L18:
        View r12 = this.M;
        if (this.N.getVisibility() != 0) goto L22;
    L28:
        tc.l.p(r12, r10);
        return;
    L22:
        if (this.P.getVisibility() == 0) goto L28;
        if (this.O.getVisibility() == 0) goto L28;
        r10 = false;
        goto L28
    L5:
        if (this.f14711v == false) goto L14;
        Editable r13 = this.f14682J.getText();
        if (r13 == null) goto L14;
        if (r13.length() == 0) goto L14;
        if (this.f14692e0 == true) goto L14;
        r11 = true;
        goto L15
    }

    public final void a0(LabelUIState r10, TextView r11, String r12) {
        L.a("OInputView", "updateLabelUIState, state: " + r10 + ", scene: [" + r12 + ']');
        int r13 = b.f14716a[r10.ordinal()];
        if (r13 != 1) goto L5;
        U(r11);
        return;
    L5:
        if (r13 != 2) goto L7;
        S(r11);
        return;
    L7:
        if (r13 != 3) goto L15;
        T(r11);
        return;
    }

    public final void b0(String r10) {
        OTextView r11 = this.T;
        if (this.f14704o == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        tc.l.p(r11, r12);
        if (this.f14704o == true) goto L11;
        return;
    L11:
        if (this.f14705p <= 0) goto L18;
        int r13 = K(r10);
        String r14 = getResources().getString(R$string.oui_form_counter, new Object[]{String.valueOf(r13), String.valueOf(this.f14705p)});
        q.f(r14, "resources.getString(\n   ….toString()\n            )");
        SpannableString r15 = new SpannableString(r14);
        if (r13 <= this.f14705p) goto L15;
        r15.setSpan(new ForegroundColorSpan(ContextCompat.b(getContext(), R$color.oui_functional_red_7)), 0, String.valueOf(r13).length(), 18);
    L15:
        this.T.setText(r15, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.f14705p <= 0) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.f14701l == false) goto L36;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r10.getAction();
        if (r13 != 0) goto L8;
        this.f14699j = r12;
        goto L36
    L8:
        if (r13 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r13 == 2) goto L16;
        if (r13 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L16:
        if (r11 <= this.f14700k) goto L20;
        if (this.f14682J.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f14700k = r11;
        this.f14699j = r12;
    L20:
        if (r11 >= this.f14700k) goto L24;
        if (this.f14682J.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r12 >= this.f14699j) goto L28;
        if (this.f14682J.canScrollVertically(1) == true) goto L31;
    L28:
        if (r12 <= this.f14699j) goto L32;
        if (this.f14682J.canScrollVertically(-1) == false) goto L32;
    L36:
        return super.dispatchTouchEvent(r10);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.f14688c0;
    }

    @Nullable
    public final OEditText.CommitCompletionListener getCommitCompletionListener() {
        return this.f14682J.getCommitCompletionListener();
    }

    public int getContentViewRes() {
        return R$layout.o_input_view_layout_vertical;
    }

    @Nullable
    public final TextUtils.TruncateAt getEllipsize() {
        return this.f14682J.getEllipsize();
    }

    public final int getInputType() {
        return this.f14714y;
    }

    public final int getLimitCount() {
        return this.f14705p;
    }

    @Override // android.view.View
    @Nullable
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.f14682J.getOnFocusChangeListener();
    }

    @Nullable
    public String getText() {
        Editable r10 = this.f14682J.getText();
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.toString();
    }

    @NotNull
    public final OEditText getVInput() {
        return this.f14682J;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L5;
    L13:
        if (r10 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r10);
    L15:
        if (r10.getAction() == 1) goto L19;
        if (r10.getAction() != 3) goto L22;
    L19:
        if (this.V == false) goto L22;
        this.V = false;
        goto L22
    L5:
        if (r10.getAction() != 0) goto L13;
        float r11 = r10.getX();
        int r12 = this.f14682J.getLeft();
        int r13 = this.f14682J.getRight();
        if (r11 >= r12) goto L9;
    L12:
        this.V = false;
        goto L22
    L9:
        if (r11 > r13) goto L12;
        this.V = true;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L12;
        if (this.V == false) goto L12;
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.offsetLocation(-this.f14682J.getLeft(), -this.f14682J.getTop());
        boolean r12 = this.f14682J.dispatchTouchEvent(r11);
        r11.recycle();
        if (r10.getAction() != 1) goto L8;
    L9:
        this.V = false;
    L10:
        return r12;
    L8:
        if (r10.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r10);
    }

    public final void setActionView(@NotNull Function1<? super FrameLayout, Unit> r10) {
        q.g(r10, "creator");
        this.L.removeAllViews();
        r10.invoke(this.L);
        FrameLayout r11 = this.L;
        if (r11.getChildCount() <= 0) goto L5;
        boolean r12 = true;
    L6:
        tc.l.p(r11, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r10) {
        this.f14692e0 = r10;
        if (r10 == false) goto L6;
        tc.l.p(this.P, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r10) {
        this.f14688c0 = r10;
    }

    public final void setBgResId(int r10) {
        this.f14690d0 = r10;
        W(true);
    }

    public final void setComboInputEnabled(boolean r10) {
        this.f14683a = r10;
        this.f14682J.setFocusable(r10);
        this.f14682J.setFocusableInTouchMode(r10);
        View.OnClickListener r11 = this.f14686b0;
        if (r11 == null) goto L7;
        getVInput().setOnClickListener(r11);
        return;
    }

    public final void setCommitCompletionListener(@NotNull OEditText.CommitCompletionListener r10) {
        q.g(r10, "commitCompletionListener");
        this.f14682J.setCommitCompletionListener(r10);
    }

    public final void setCommonTip(@Nullable String r10) {
        this.B = r10;
        this.S.setText(r10);
    }

    public final void setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.f14695g = r10;
        this.f14682J.setEllipsize(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.f14711v = r10;
        super.setEnabled(r10);
        Iterator r11 = ViewGroupKt.a(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setEnabled(r10);
        goto L4
    L6:
        this.f14682J.setEnabled(r10);
        X(this.f14682J.hasFocus());
        W(false);
    }

    public final void setErrorState(boolean r10) {
        this.f14710u = r10;
        X(this.f14682J.hasFocus());
        W(false);
    }

    public final void setErrorTip(@Nullable String r10) {
        this.A = r10;
        this.R.setText(r10);
    }

    public final void setHint(@Nullable String r10) {
        this.f14713x = r10;
        this.f14682J.setHint(r10);
        B("setHint");
    }

    public final void setInputHeight(int r10) {
        this.f14712w = Integer.valueOf(r10);
        OEditText r11 = this.f14682J;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L7;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        ((ViewGroup.MarginLayoutParams) r13).height = r10;
        r11.setLayoutParams(r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setInputMode(@InputMode int r10) {
        this.f14685b = r10;
        boolean r11 = false;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L28;
        setSingleLine(true);
        tc.l.p(this.O, true);
        View r12 = this.M;
        if (this.N.getVisibility() != 0) goto L10;
    L14:
        r11 = true;
    L15:
        tc.l.p(r12, r11);
        setComboInputEnabled(this.f14683a);
        return;
    L10:
        if (this.P.getVisibility() == 0) goto L14;
        if (this.O.getVisibility() != 0) goto L15;
    L28:
        return;
    L16:
        tc.l.p(this.O, false);
        View r13 = this.M;
        if (this.N.getVisibility() != 0) goto L20;
    L24:
        r11 = true;
    L25:
        tc.l.p(r13, r11);
        this.f14682J.setFocusable(true);
        this.f14682J.setFocusableInTouchMode(true);
        return;
    L20:
        if (this.P.getVisibility() == 0) goto L24;
        if (this.O.getVisibility() != 0) goto L25;
        goto L24
    }

    public final void setInputType(int r10) {
        if ((r10 & 1) == 0) goto L5;
    L11:
        this.f14714y = r10;
        if (r10 != this.f14682J.getInputType()) goto L15;
        D(this.f14682J.getText());
        return;
    L15:
        this.f14682J.setInputType(this.f14714y);
        Z();
        D(this.f14682J.getText());
        return;
    L5:
        if ((r10 & 2) != 0) goto L11;
        if ((r10 & 3) != 0) goto L11;
        if ((r10 & 4) != 0) goto L11;
        r10 = r10 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r10) {
        this.f14701l = r10;
    }

    public final void setKeyListener(@Nullable KeyListener r10) {
        this.f14682J.setKeyListener(r10);
    }

    public final void setLabel(@Nullable String r10) {
        this.f14709t = r10;
        this.H.setText(r10);
    }

    public final void setLeftView(@NotNull Function1<? super FrameLayout, Unit> r10) {
        q.g(r10, "creator");
        this.K.removeAllViews();
        r10.invoke(this.K);
        FrameLayout r11 = this.K;
        if (r11.getChildCount() <= 0) goto L5;
        boolean r12 = true;
    L6:
        tc.l.p(r11, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setLimitCount(int r10) {
        setLimitCountValue(r10);
        Editable r11 = this.f14682J.getText();
        if (r11 != null) goto L5;
        String r12 = null;
    L6:
        b0(r12);
        D(this.f14682J.getText());
        return;
    L5:
        r12 = r11.toString();
        goto L6
    }

    public final void setLimitCountValue(int r10) {
        this.f14705p = r10;
    }

    public final void setMaxLines(int r10) {
        int r11 = 1;
        if (r10 >= 1) goto L5;
        r10 = Channel.UNLIMITED;
    L5:
        this.f14689d = r10;
        OEditText r12 = this.f14682J;
        if (this.f14687c == true) goto L9;
        r11 = r10;
    L9:
        r12.setMaxLines(r11);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r10) {
        if (this.f14685b == 1) goto L5;
    L7:
        super.setOnClickListener(r10);
        return;
    L5:
        if (this.f14683a == true) goto L7;
        this.O.setOnClickListener(r10);
        this.f14682J.setOnClickListener(r10);
        goto L7
    }

    public final void setOnComboArrowClickListener(@Nullable View.OnClickListener r10) {
        this.f14686b0 = r10;
        this.O.setOnClickListener(r10);
        if (this.f14683a == true) goto L9;
        View.OnClickListener r11 = this.f14686b0;
        if (r11 == null) goto L10;
        getVInput().setOnClickListener(r11);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(@Nullable View.OnFocusChangeListener r10) {
        this.f14682J.setOnFocusChangeListener(r10);
    }

    public final void setOnTextClearedListener(@NotNull OnTextClearedListener r10) {
        q.g(r10, "listener");
        this.W = r10;
    }

    public final void setOnTextExceedLengthListener(@Nullable OnTextExceedLengthListener r10) {
        this.f14684a0 = r10;
    }

    public final void setRadius(int r10) {
        if (r10 != this.E) goto L5;
        return;
    L5:
        this.E = r10;
        this.F.setRadius(r10);
    }

    public final void setShowLabel(boolean r10) {
        this.f14706q = r10;
        tc.l.p(this.G, r10);
        OEditText r11 = this.f14682J;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L12;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        if (this.f14706q == false) goto L8;
        int r14 = 16;
    L7:
        int r15 = tc.f.r(this, r14);
        r13.f2231w = r15;
        r13.A = r15;
        r11.setLayoutParams(r13);
        B("setShowLabel");
        return;
    L8:
        r14 = 12;
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r10) {
        this.f14707r = r10;
        B("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r10) {
        this.f14708s = r10;
        tc.l.p(this.I, r10);
    }

    public final void setShowLimitIndicator(boolean r10) {
        this.f14704o = r10;
        Editable r11 = this.f14682J.getText();
        if (r11 != null) goto L5;
        String r12 = null;
    L6:
        b0(r12);
        return;
    L5:
        r12 = r11.toString();
        goto L6
    }

    public final void setSingleLine(boolean r12) {
        this.f14687c = r12;
        int r10 = getResources().getDimensionPixelSize(R$dimen.o_input_view_space_top_bottom);
        ViewGroup.LayoutParams r11 = null;
        if (r12 == false) goto L40;
        tc.l.p(this.Q, false);
        this.f14682J.setMaxLines(1);
        this.f14682J.setSingleLine(true);
        OEditText r13 = this.f14682J;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L39;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        ViewGroup.LayoutParams r16 = getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r16 = null;
    L9:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L12;
        int r18 = r17.leftMargin;
    L13:
        ViewGroup.LayoutParams r19 = getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r11 = r19;
    L17:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r11;
        if (r20 == null) goto L20;
        int r21 = r20.rightMargin;
    L21:
        r15.setMargins(r18, 0, r21, r10);
        r15.f2233x = r10;
        if (this.f14706q == false) goto L24;
        int r22 = tc.f.r(this, 16);
    L25:
        r15.f2231w = r22;
        r15.A = r22;
        r13.setLayoutParams(r15);
        View r110 = this.M;
        ViewGroup.LayoutParams r23 = r110.getLayoutParams();
        if (r23 == null) goto L37;
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        r24.f2203i = 0;
        r24.f2209l = 0;
        r110.setLayoutParams(r24);
        FrameLayout r111 = this.L;
        ViewGroup.LayoutParams r25 = r111.getLayoutParams();
        if (r25 == null) goto L35;
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
        r26.f2203i = 0;
        r26.f2209l = 0;
        r111.setLayoutParams(r26);
        FrameLayout r112 = this.K;
        ViewGroup.LayoutParams r27 = r112.getLayoutParams();
        if (r27 == null) goto L33;
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        r28.setMargins(tc.f.r(this, 4), tc.f.r(this, 4), 0, tc.f.r(this, 4));
        r28.f2203i = 0;
        r28.f2209l = 0;
        r112.setLayoutParams(r28);
    L89:
        B("setSingleLine");
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r22 = tc.f.r(this, 12);
        goto L25
    L20:
        r21 = 0;
        goto L21
    L12:
        r18 = 0;
        goto L13
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        tc.l.p(this.Q, this.f14703n);
        this.f14682J.setMaxLines(this.f14689d);
        this.f14682J.setSingleLine(false);
        this.f14682J.setPadding(getPaddingLeft(), tc.f.r(this, 2), getPaddingRight(), getPaddingBottom());
        this.f14682J.setGravity(48);
        OEditText r113 = this.f14682J;
        ViewGroup.LayoutParams r29 = r113.getLayoutParams();
        if (r29 == null) goto L98;
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        ViewGroup.LayoutParams r31 = getLayoutParams();
        if ((r31 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r31 = null;
    L45:
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
        if (r32 == null) goto L48;
        int r33 = r32.leftMargin;
    L49:
        ViewGroup.LayoutParams r34 = getLayoutParams();
        if ((r34 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r34 = null;
    L52:
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r34;
        if (r35 == null) goto L55;
        int r36 = r35.rightMargin;
    L56:
        r30.setMargins(r33, 0, r36, tc.f.r(this, 8));
        r30.f2233x = tc.f.r(this, 8);
        if (this.f14706q == false) goto L59;
        int r37 = tc.f.r(this, 16);
    L60:
        r30.f2231w = r37;
        r30.A = r37;
        r113.setLayoutParams(r30);
        View r114 = this.M;
        ViewGroup.LayoutParams r38 = r114.getLayoutParams();
        if (r38 == null) goto L96;
        ConstraintLayout.LayoutParams r39 = (ConstraintLayout.LayoutParams) r38;
        r39.f2203i = 0;
        ViewGroup.LayoutParams r40 = getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == true) goto L65;
        r40 = null;
    L65:
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        if (r41 == null) goto L68;
        int r42 = r41.leftMargin;
    L69:
        int r43 = tc.f.r(this, 4);
        ViewGroup.LayoutParams r44 = getLayoutParams();
        if ((r44 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r44 = null;
    L72:
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r45 == null) goto L75;
        int r46 = r45.rightMargin;
    L76:
        ViewGroup.LayoutParams r47 = getLayoutParams();
        if ((r47 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        r11 = r47;
    L80:
        ViewGroup.MarginLayoutParams r48 = (ViewGroup.MarginLayoutParams) r11;
        if (r48 == null) goto L83;
        int r49 = r48.bottomMargin;
    L84:
        r39.setMargins(r42, r43, r46, r49);
        r39.f2209l = -1;
        r114.setLayoutParams(r39);
        FrameLayout r115 = this.L;
        ViewGroup.LayoutParams r50 = r115.getLayoutParams();
        if (r50 == null) goto L94;
        ConstraintLayout.LayoutParams r51 = (ConstraintLayout.LayoutParams) r50;
        r51.f2203i = 0;
        r51.f2209l = 0;
        r115.setLayoutParams(r51);
        FrameLayout r116 = this.K;
        ViewGroup.LayoutParams r52 = r116.getLayoutParams();
        if (r52 == null) goto L92;
        ConstraintLayout.LayoutParams r53 = (ConstraintLayout.LayoutParams) r52;
        r53.setMargins(tc.f.r(this, 4), tc.f.r(this, 4), 0, 0);
        r53.f2203i = 0;
        r53.f2209l = -1;
        r116.setLayoutParams(r53);
        goto L89
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L83:
        r49 = 0;
        goto L84
    L75:
        r46 = 0;
        goto L76
    L68:
        r42 = 0;
        goto L69
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L59:
        r37 = tc.f.r(this, 12);
        goto L60
    L55:
        r36 = 0;
        goto L56
    L48:
        r33 = 0;
        goto L49
    L98:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setText(@Nullable String r10) {
        this.f14682J.setText(r10);
        B("setText");
        D(this.f14682J.getText());
    }

    @JvmOverloads
    public OInputView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OInputView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OInputView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        int r13 = 1;
        this.f14683a = true;
        this.f14687c = true;
        this.f14689d = Channel.UNLIMITED;
        this.f14693f = 16;
        this.f14702m = true;
        this.f14703n = true;
        this.f14705p = -1;
        this.f14706q = true;
        this.f14708s = true;
        this.f14711v = true;
        this.E = tc.f.r(this, 10);
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OInputView, r12, 0);
        this.f14701l = r14.getBoolean(R$styleable.OInputView_oui_inputInScrollableView, false);
        this.f14702m = r14.getBoolean(R$styleable.OInputView_oui_autoShowClear, true);
        this.f14703n = r14.getBoolean(R$styleable.OInputView_oui_showResizer, true);
        this.f14706q = r14.getBoolean(R$styleable.OInputView_oui_showLabel, true);
        this.f14707r = r14.getBoolean(R$styleable.OInputView_oui_showLabelAnim, false);
        this.f14708s = r14.getBoolean(R$styleable.OInputView_oui_showLabelIcon, true);
        this.f14709t = r14.getString(R$styleable.OInputView_oui_inputLabel);
        this.A = r14.getString(R$styleable.OInputView_oui_errorTip);
        this.B = r14.getString(R$styleable.OInputView_oui_commonTip);
        this.C = r14.getBoolean(R$styleable.OInputView_oui_showCommonTip, false);
        this.E = r14.getDimensionPixelSize(R$styleable.OInputView_oui_inputBorderRadius, this.E);
        this.f14683a = r14.getBoolean(R$styleable.OInputView_oui_comboInputEnabled, true);
        this.f14685b = r14.getInt(R$styleable.OInputView_oui_inputMode, 0);
        this.f14687c = r14.getBoolean(R$styleable.OInputView_oui_inputSingleLine, true);
        int r15 = r14.getDimensionPixelSize(R$styleable.OInputView_oui_inputHeight, 0);
        if (r15 <= 0) goto L5;
        this.f14712w = Integer.valueOf(r15);
    L5:
        this.f14705p = r14.getInt(R$styleable.OInputView_oui_limitCount, -1);
        this.f14704o = r14.getBoolean(R$styleable.OInputView_oui_showLimitIndicator, false);
        this.D = r14.getText(R$styleable.OInputView_android_digits);
        this.f14713x = r14.getString(R$styleable.OInputView_android_hint);
        this.f14714y = r14.getInt(R$styleable.OInputView_android_inputType, 0);
        this.f14715z = r14.getString(R$styleable.OInputView_android_text);
        this.f14711v = r14.getBoolean(R$styleable.OInputView_android_enabled, true);
        this.f14689d = r14.getInt(R$styleable.OInputView_android_maxLines, Channel.UNLIMITED);
        this.f14691e = r14.getInt(R$styleable.OInputView_android_orientation, 0);
        this.f14693f = r14.getInt(R$styleable.OInputView_android_gravity, 16);
        int r16 = R$styleable.OInputView_android_ellipsize;
        if (r14.hasValue(r16) == false) goto L8;
        this.f14695g = O(r14.getInt(r16, 0));
    L8:
        r14.recycle();
        LayoutInflater.from(r10).inflate(getContentViewRes(), this);
        View r17 = findViewById(R$id.o_input_border_container);
        q.f(r17, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r18 = (OUIConstraintLayout) r17;
        this.F = r18;
        r18.setRadius(this.E);
        View r19 = findViewById(R$id.o_input_title_container);
        q.f(r19, "findViewById(R.id.o_input_title_container)");
        this.G = (LinearLayout) r19;
        View r20 = findViewById(R$id.o_input_title);
        q.f(r20, "findViewById(R.id.o_input_title)");
        this.H = (OTextView) r20;
        View r21 = findViewById(R$id.o_input_title_icon);
        q.f(r21, "findViewById(R.id.o_input_title_icon)");
        this.I = (ImageView) r21;
        View r22 = findViewById(R$id.o_input);
        q.f(r22, "findViewById(R.id.o_input)");
        OEditText r23 = (OEditText) r22;
        this.f14682J = r23;
        r23.setVerticalScrollBarEnabled(false);
        View r110 = findViewById(R$id.o_input_left_view_container);
        q.f(r110, "findViewById(R.id.o_input_left_view_container)");
        this.K = (FrameLayout) r110;
        View r111 = findViewById(R$id.o_input_custom_action_container);
        q.f(r111, "findViewById(R.id.o_input_custom_action_container)");
        this.L = (FrameLayout) r111;
        View r112 = findViewById(R$id.o_input_action_container);
        q.f(r112, "findViewById(R.id.o_input_action_container)");
        this.M = r112;
        View r113 = findViewById(R$id.o_input_clear);
        q.f(r113, "findViewById(R.id.o_input_clear)");
        this.N = r113;
        View r24 = findViewById(R$id.o_input_combo_arrow);
        q.f(r24, "findViewById(R.id.o_input_combo_arrow)");
        this.O = r24;
        View r25 = findViewById(R$id.o_input_eyes_slash);
        q.f(r25, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r26 = (ImageView) r25;
        this.P = r26;
        View r27 = findViewById(R$id.o_input_resizer);
        q.f(r27, "findViewById(R.id.o_input_resizer)");
        this.Q = r27;
        View r28 = findViewById(R$id.o_input_error_tip);
        q.f(r28, "findViewById(R.id.o_input_error_tip)");
        this.R = (OTextView) r28;
        View r29 = findViewById(R$id.o_input_common_tip);
        q.f(r29, "findViewById(R.id.o_input_common_tip)");
        this.S = (OTextView) r29;
        View r30 = findViewById(R$id.o_input_limit_indicator);
        q.f(r30, "findViewById(R.id.o_input_limit_indicator)");
        this.T = (OTextView) r30;
        this.U = (TextView) findViewById(R$id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        CharSequence r31 = this.D;
        if (r31 == null) goto L14;
        r23.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r31)));
        int r32 = this.f14714y;
        if (r32 == 0) goto L13;
        r13 = r32;
    L13:
        this.f14714y = r13;
    L14:
        r23.setGravity(this.f14693f);
        Integer r33 = this.f14712w;
        if (r33 == null) goto L18;
        setInputHeight(r33.intValue());
    L18:
        r23.d(new AnonymousClass3(this));
        r23.e(new AnonymousClass4(this));
        r23.f(new AnonymousClass5(this));
        r23.a(new AnonymousClass6(this));
        r113.setOnClickListener(new h(this));
        setCommonTip(this.B);
        Q(this.C);
        setErrorTip(this.A);
        R(false);
        setComboInputEnabled(this.f14683a);
        setLabel(this.f14709t);
        setShowLabel(this.f14706q);
        setShowLabelIcon(this.f14708s);
        setLimitCount(this.f14705p);
        setShowLimitIndicator(this.f14704o);
        setSingleLine(this.f14687c);
        setMaxLines(this.f14689d);
        setEllipsize(this.f14695g);
        setHint(this.f14713x);
        setText(this.f14715z);
        setInputMode(this.f14685b);
        setEnabled(this.f14711v);
        Y();
        X(r23.hasFocus());
        int r34 = this.f14714y;
        if (r34 == 0) goto L21;
        setInputType(r34);
    L21:
        Z();
        r26.setOnClickListener(new i(this));
        r18.setOnClickListener(new j(this));
        B("init");
    }
}
