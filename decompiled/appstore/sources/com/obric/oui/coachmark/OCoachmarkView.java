package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.core.widget.TextViewCompat;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f*\u0001t\u0018\u0000 Ù\u00012\u00020\u0001:\u0007Ú\u0001Û\u0001mÜ\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\rJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\rJ\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\rJ\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010\rJ\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\u0014H\u0002¢\u0006\u0004\b+\u0010\u0016J\u000f\u0010,\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010\u0016J\u000f\u0010-\u001a\u00020\u0014H\u0002¢\u0006\u0004\b-\u0010\u0016J\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0014H\u0002¢\u0006\u0004\b4\u0010\u0016J\u000f\u00105\u001a\u00020\u000bH\u0002¢\u0006\u0004\b5\u0010\rJ\u000f\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u0010\rJ\u0017\u00108\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u0004\u0018\u00010.¢\u0006\u0004\b:\u00100J\u0017\u0010;\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.¢\u0006\u0004\b;\u00109J1\u0010?\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=H\u0007¢\u0006\u0004\b?\u0010@J\u0015\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bI\u0010HJ\u0017\u0010L\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020\u000bH\u0014¢\u0006\u0004\bM\u0010\rJ\u0019\u0010O\u001a\u00020\u000b2\b\b\u0001\u0010N\u001a\u00020\u0006H\u0016¢\u0006\u0004\bO\u0010\u001eJ\u0017\u0010Q\u001a\u00020\u000b2\b\b\u0001\u0010P\u001a\u00020\u0006¢\u0006\u0004\bQ\u0010\u001eJ\u0017\u0010R\u001a\u00020\u000b2\b\b\u0001\u0010P\u001a\u00020\u0006¢\u0006\u0004\bR\u0010\u001eJ\u0015\u0010T\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u0006¢\u0006\u0004\bT\u0010\u001eJ\u0015\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\u001eJ\u0017\u0010W\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.¢\u0006\u0004\bW\u00109J\u0017\u0010X\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.¢\u0006\u0004\bX\u00109J\u0017\u0010Y\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010.¢\u0006\u0004\bY\u00109J\u0015\u0010[\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020Z¢\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u000101¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u000101¢\u0006\u0004\b`\u0010_J\u0017\u0010a\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u000101¢\u0006\u0004\ba\u0010_J\u0015\u0010c\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u0014¢\u0006\u0004\bc\u0010(J\u0015\u0010f\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020d¢\u0006\u0004\bf\u0010gJ\u0015\u0010i\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u0006¢\u0006\u0004\bi\u0010\u001eJ\u0017\u0010j\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u000101¢\u0006\u0004\bj\u0010_J\u0015\u0010k\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u0014¢\u0006\u0004\bk\u0010(J\u0015\u0010l\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u0014¢\u0006\u0004\bl\u0010(R\u0014\u0010o\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010v\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010uR\u0014\u0010x\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010wR\u0014\u0010y\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010rR\u0014\u0010|\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010{R\u0014\u0010}\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010nR\u0014\u0010~\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010rR\u0016\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010\u0080\u0001R\u0016\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001f\u0010\u0080\u0001R\u0015\u0010\u0083\u0001\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010wR\u0015\u0010\u0084\u0001\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010wR\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b+\u0010\u0086\u0001R\u0017\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b,\u0010\u0086\u0001R\u0017\u0010\u0089\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b4\u0010\u0086\u0001R\u0017\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b%\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b2\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b/\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b?\u0010\u0091\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b'\u0010\u0094\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010\u0097\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b5\u0010\u0099\u0001R\u001a\u0010\u009b\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010\u0099\u0001R\u001a\u0010\u009c\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0010\u0099\u0001R\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u0099\u0001R\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b*\u0010\u009e\u0001R\u001a\u0010 \u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010\u009e\u0001R\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010wR\u001b\u0010¥\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010¤\u0001R\u0019\u0010©\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u0097\u0001R\u0019\u0010«\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0097\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u0097\u0001R\u001c\u0010°\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010¯\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010¯\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010¯\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¯\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¯\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u001b\u0010¿\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010º\u0001R\u001b\u0010Á\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010º\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010\u0097\u0001R\u0019\u0010Å\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010\u0097\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010\u0097\u0001R\u0019\u0010É\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010\u0097\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010\u0097\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010\u0094\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0094\u0001R#\u0010Ô\u0001\u001a\f\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R0\u0010×\u0001\u001a\u00020\u00142\u0007\u0010Õ\u0001\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u0016\n\u0006\bÖ\u0001\u0010\u0094\u0001\u001a\u0005\b×\u0001\u0010\u0016\"\u0005\bØ\u0001\u0010(¨\u0006Ý\u0001"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "h", "()V", "e", "(Landroid/util/AttributeSet;II)V", "Landroid/content/res/TypedArray;", "array", "d", "(Landroid/content/res/TypedArray;)V", "", "isDarkTheme", "()Z", "B", "z", "i", "g", "c", "radiusPx", "f", "(I)V", "j", FixCard.FixStyle.KEY_Y, "Landroid/view/View;", "view", "k", "(Landroid/view/View;)Z", "p", "showIcon", "u", "(Z)V", "v", "A", "m", "n", "l", "", "r", "()Ljava/lang/CharSequence;", "Landroid/view/View$OnClickListener;", "q", "()Landroid/view/View$OnClickListener;", "o", "w", FixCard.FixStyle.KEY_X, "text", "setText", "(Ljava/lang/CharSequence;)V", "getText", "setTitle", "maxLines", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "s", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "style", "setContentStyle", "(Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "setHeroImage", "setCustomContentView$OUI_standardRelease", "(Landroid/view/View;)V", "setCustomContentView", "onDetachedFromWindow", "color", "setBackgroundColor", "resId", "setTitleTextAppearance", "setDescTextAppearance", "widthPx", "setMaxWidth", "paddingPx", "setContentPadding", "setActionText", "setPrimaryButtonText", "setSecondaryButtonText", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "setActionStyle", "(Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;)V", "listener", "setOnActionClickListener", "(Landroid/view/View$OnClickListener;)V", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "visible", "setArrowVisible", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "position", "setArrowPosition", "(Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;)V", "offsetPx", "setArrowOffset", "setOnCloseClickListener", "setShowCloseIcon", "setCloseVisible", "a", "Lcom/obric/oui/layout/OUIFrameLayout;", "containerView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "arrowView", "com/obric/oui/coachmark/OCoachmarkView$c", "Lcom/obric/oui/coachmark/OCoachmarkView$c;", "arrowTriangleOutlineProvider", "Landroid/view/View;", "heroContainer", "heroImage", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "contentContainer", "iconContainer", "iconView", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "titleView", "descriptionView", "textGroup", "actionTextContainer", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/button/OButton;", "actionTextButton", "actionTextPrimaryButton", "actionFilledButton", "Lcom/obric/oui/button/OIconButton;", "Lcom/obric/oui/button/OIconButton;", "closeButton", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "actionStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "arrowPosition", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "contentStyle", "t", "Z", "showArrow", "showCloseIcon", "I", "arrowOffsetPx", "Ljava/lang/CharSequence;", "titleText", "descriptionText", "primaryActionText", "secondaryActionText", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "heroDrawable", "C", "customContentView", "D", "Landroid/view/View$OnClickListener;", "primaryActionClickListener", "E", "secondaryActionClickListener", "F", Style.KEY_BG_COLOR, "G", "titleTextAppearance", "H", "descTextAppearance", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "titleTextColor", "J", "descTextColor", "K", "iconTint", "L", "closeIconTint", "M", "arrowColor", "N", "Ljava/lang/Integer;", "actionNeutralTextColor", "O", "actionPrimaryTextColor", "P", "filledActionTextColor", "Q", "filledActionBackgroundColor", "R", "maxWidthPx", "S", "contentPaddingStartPx", "T", "contentPaddingTopPx", "U", "contentPaddingEndPx", "V", "contentPaddingBottomPx", "W", "isContentPaddingCustomized", "a0", "enableMaterial", "", "Lcom/obric/oui/material/b;", "b0", "[Lcom/obric/oui/material/b;", "materials", CommonKey.KEY_VALUE, "c0", "isPopWindowMode", "setPopWindowMode", "d0", "ActionStyle", "ArrowPosition", "ContentStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkView extends OUIFrameLayout {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f12832d0 = null;
    public Drawable A;
    public Drawable B;
    public View C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public int F;
    public int G;
    public int H;
    public ColorStateList I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ColorStateList f12833J;
    public ColorStateList K;
    public ColorStateList L;
    public ColorStateList M;
    public Integer N;
    public Integer O;
    public Integer P;
    public Integer Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIFrameLayout f12834a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f12835a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f12836b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public com.obric.oui.material.b[] f12837b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f12838c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f12839c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f12840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f12841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f12842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OUIFrameLayout f12843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f12844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTextView f12845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f12846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f12847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f12848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OButton f12849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OButton f12850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OButton f12851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OIconButton f12852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ActionStyle f12853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrowPosition f12854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ContentStyle f12855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f12859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f12860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f12861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f12862z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "NONE", "TEXT_ONLY", "FILLED_BUTTON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionStyle extends Enum<ActionStyle> {
        private static final /* synthetic */ ActionStyle[] $VALUES = null;

        @NotNull
        public static final a Companion = null;
        public static final ActionStyle FILLED_BUTTON = null;
        public static final ActionStyle NONE = null;
        public static final ActionStyle TEXT_ONLY = null;
        private final int value;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final ActionStyle a(int r10) {
                ActionStyle[] r11 = ActionStyle.values();
                int r12 = r11.length;
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L8;
                ActionStyle r14 = r11[r13];
                if (r14.getValue() == r10) goto L9;
                r13 = r13 + 1;
            L9:
                if (r14 == null) goto L11;
                return r14;
            L11:
                return ActionStyle.NONE;
            L8:
                r14 = null;
                goto L9
            }

            public a() {
            }
        }

        private static final /* synthetic */ ActionStyle[] $values() {
            return new ActionStyle[]{NONE, TEXT_ONLY, FILLED_BUTTON};
        }

        static {
            NONE = new ActionStyle("NONE", 0, 0);
            TEXT_ONLY = new ActionStyle("TEXT_ONLY", 1, 1);
            FILLED_BUTTON = new ActionStyle("FILLED_BUTTON", 2, 2);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ActionStyle(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static ActionStyle valueOf(String r10) {
            return (ActionStyle) Enum.valueOf(ActionStyle.class, r10);
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "TOP", "BOTTOM", "LEFT", "RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ArrowPosition extends Enum<ArrowPosition> {
        private static final /* synthetic */ ArrowPosition[] $VALUES = null;
        public static final ArrowPosition BOTTOM = null;

        @NotNull
        public static final a Companion = null;
        public static final ArrowPosition LEFT = null;
        public static final ArrowPosition RIGHT = null;
        public static final ArrowPosition TOP = null;
        private final int value;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final ArrowPosition a(int r10) {
                ArrowPosition[] r11 = ArrowPosition.values();
                int r12 = r11.length;
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L8;
                ArrowPosition r14 = r11[r13];
                if (r14.getValue() == r10) goto L9;
                r13 = r13 + 1;
            L9:
                if (r14 == null) goto L11;
                return r14;
            L11:
                return ArrowPosition.TOP;
            L8:
                r14 = null;
                goto L9
            }

            public a() {
            }
        }

        private static final /* synthetic */ ArrowPosition[] $values() {
            return new ArrowPosition[]{TOP, BOTTOM, LEFT, RIGHT};
        }

        static {
            TOP = new ArrowPosition("TOP", 0, 0);
            BOTTOM = new ArrowPosition("BOTTOM", 1, 1);
            LEFT = new ArrowPosition("LEFT", 2, 2);
            RIGHT = new ArrowPosition("RIGHT", 3, 3);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ArrowPosition(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static ArrowPosition valueOf(String r10) {
            return (ArrowPosition) Enum.valueOf(ArrowPosition.class, r10);
        }

        public static ArrowPosition[] values() {
            return (ArrowPosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ContentStyle extends Enum<ContentStyle> {
        private static final /* synthetic */ ContentStyle[] $VALUES = null;
        public static final ContentStyle CARD = null;

        @NotNull
        public static final a Companion = null;
        public static final ContentStyle PILL = null;
        private final int value;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final ContentStyle a(int r10) {
                ContentStyle[] r11 = ContentStyle.values();
                int r12 = r11.length;
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L8;
                ContentStyle r14 = r11[r13];
                if (r14.getValue() == r10) goto L9;
                r13 = r13 + 1;
            L9:
                if (r14 == null) goto L11;
                return r14;
            L11:
                return ContentStyle.PILL;
            L8:
                r14 = null;
                goto L9
            }

            public a() {
            }
        }

        private static final /* synthetic */ ContentStyle[] $values() {
            return new ContentStyle[]{PILL, CARD};
        }

        static {
            PILL = new ContentStyle("PILL", 0, 0);
            CARD = new ContentStyle("CARD", 1, 1);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ContentStyle(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static ContentStyle valueOf(String r10) {
            return (ContentStyle) Enum.valueOf(ContentStyle.class, r10);
        }

        public static ContentStyle[] values() {
            return (ContentStyle[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
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
        public static final /* synthetic */ int[] f12863a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12864b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f12865c = null;

        static {
            int[] r10 = new int[ContentStyle.values().length];
            r10[ContentStyle.PILL.ordinal()] = 1;
            r10[ContentStyle.CARD.ordinal()] = 2;
            f12863a = r10;
            int[] r11 = new int[ActionStyle.values().length];
            r11[ActionStyle.TEXT_ONLY.ordinal()] = 1;
            r11[ActionStyle.FILLED_BUTTON.ordinal()] = 2;
            r11[ActionStyle.NONE.ordinal()] = 3;
            f12864b = r11;
            int[] r12 = new int[ArrowPosition.values().length];
            r12[ArrowPosition.TOP.ordinal()] = 1;
            r12[ArrowPosition.BOTTOM.ordinal()] = 2;
            r12[ArrowPosition.LEFT.ordinal()] = 3;
            r12[ArrowPosition.RIGHT.ordinal()] = 4;
            f12865c = r12;
        }
    }

    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCoachmarkView f12866a;

        public c(OCoachmarkView r10) {
            this.f12866a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r12, Outline r13) {
            q.g(r12, "view");
            q.g(r13, "outline");
            int r10 = r12.getWidth();
            int r14 = r12.getHeight();
            if (r10 <= 0) goto L15;
            if (r14 <= 0) goto L16;
            Path r11 = new Path();
            if (OCoachmarkView.b(this.f12866a) != ArrowPosition.TOP) goto L9;
        L12:
            float r15 = r10 / 20.0f;
            float r16 = r14 / 8.0f;
            float r17 = r16 * 1.41421f;
            r11.moveTo(8.58579f * r15, r17);
            r11.cubicTo(9.36684f * r15, 0.633164f * r16, 10.6332f * r15, 0.633165f * r16, 11.4142f * r15, r17);
            float r18 = r16 * 8.0f;
            r11.lineTo(18.0f * r15, r18);
            r11.lineTo(r15 * 2.0f, r18);
            r11.close();
        L13:
            r13.setPath(r11);
            return;
        L9:
            if (OCoachmarkView.b(this.f12866a) == ArrowPosition.BOTTOM) goto L12;
            float r19 = r10 / 10.0f;
            float r110 = r14 / 20.0f;
            float r20 = r19 * 1.95217f;
            float r21 = r19 * 0.951359f;
            r11.moveTo(r20, 8.43826f * r110);
            r11.cubicTo(r21, r110 * 9.23891f, r21, r110 * 10.7611f, r20, r110 * 11.5617f);
            float r111 = r19 * 10.0f;
            r11.lineTo(r111, 18.0f * r110);
            r11.lineTo(r111, r110 * 2.0f);
            r11.close();
            goto L13
        L16:
            return;
        }
    }

    static {
        f12832d0 = new a(null);
    }

    @JvmOverloads
    public OCoachmarkView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    public static final /* synthetic */ ActionStyle a(OCoachmarkView r10) {
        return r10.f12853q;
    }

    public static final /* synthetic */ ArrowPosition b(OCoachmarkView r10) {
        return r10.f12854r;
    }

    private final void d(TypedArray r10) {
        int r11 = R$styleable.OCoachmarkView_cmBackgroundColor;
        if (r10.hasValue(r11) == false) goto L5;
        this.F = r10.getColor(r11, this.F);
    L20:
        int r12 = R$styleable.OCoachmarkView_cmTitleTextColor;
        if (r10.hasValue(r12) == false) goto L23;
        this.I = r10.getColorStateList(r12);
    L23:
        int r13 = R$styleable.OCoachmarkView_cmDescTextColor;
        if (r10.hasValue(r13) == false) goto L26;
        this.f12833J = r10.getColorStateList(r13);
    L26:
        int r14 = R$styleable.OCoachmarkView_cmIconTint;
        if (r10.hasValue(r14) == false) goto L29;
        this.K = r10.getColorStateList(r14);
    L29:
        int r15 = R$styleable.OCoachmarkView_cmCloseIconTint;
        if (r10.hasValue(r15) == false) goto L32;
        this.L = r10.getColorStateList(r15);
    L32:
        int r16 = R$styleable.OCoachmarkView_cmArrowColor;
        if (r10.hasValue(r16) == false) goto L35;
        this.M = r10.getColorStateList(r16);
    L35:
        int r17 = R$styleable.OCoachmarkView_cmActionNeutralTextColor;
        if (r10.hasValue(r17) == false) goto L38;
        this.N = Integer.valueOf(r10.getColor(r17, 0));
    L38:
        int r18 = R$styleable.OCoachmarkView_cmActionPrimaryTextColor;
        if (r10.hasValue(r18) == false) goto L41;
        this.O = Integer.valueOf(r10.getColor(r18, 0));
    L41:
        int r19 = R$styleable.OCoachmarkView_cmFilledActionTextColor;
        if (r10.hasValue(r19) == false) goto L44;
        this.P = Integer.valueOf(r10.getColor(r19, 0));
    L44:
        int r20 = R$styleable.OCoachmarkView_cmFilledActionBackgroundColor;
        if (r10.hasValue(r20) == false) goto L47;
        this.Q = Integer.valueOf(r10.getColor(r20, 0));
    L47:
        int r21 = R$styleable.OCoachmarkView_cmTitleTextAppearance;
        if (r10.hasValue(r21) == false) goto L50;
        this.G = r10.getResourceId(r21, 0);
    L50:
        int r22 = R$styleable.OCoachmarkView_cmDescTextAppearance;
        if (r10.hasValue(r22) == false) goto L54;
        this.H = r10.getResourceId(r22, 0);
    L54:
        if (this.f12835a0 == false) goto L57;
        this.f12835a0 = r10.getBoolean(R$styleable.OCoachmarkView_oui_widgetEnableMaterial, true);
    L57:
        if (this.f12835a0 == false) goto L63;
        String r23 = r10.getString(R$styleable.OCoachmarkView_oui_widgetMaterial);
        if (r23 != null) goto L61;
        r23 = r10.getResources().getString(R$string.oui_material_bg_popup);
    L61:
        this.f12837b0 = MaterialToken.parseSet(r23, !isDarkTheme());
        return;
    L63:
        return;
    L5:
        int r24 = R$styleable.OCoachmarkView_android_background;
        if (r10.hasValue(r24) == false) goto L20;
        Drawable r25 = r10.getDrawable(r24);
        if ((r25 instanceof ColorDrawable) == false) goto L10;
        ColorDrawable r26 = (ColorDrawable) r25;
    L11:
        if (r26 != null) goto L13;
        Integer r27 = null;
    L14:
        if (r27 == null) goto L16;
        this.F = r27.intValue();
        goto L20
    L16:
        L r28 = L.f17615a;
        if (r28.f(8) == true) goto L20;
        r28.d().writeLog("OCoachmarkView", 8, "android:background is not a color; ignored. Use cmBackgroundColor for color.", null);
        goto L20
    L13:
        r27 = Integer.valueOf(r26.getColor());
        goto L14
    L10:
        r26 = null;
        goto L11
    }

    private final boolean isDarkTheme() {
        int r10 = this.F;
        if (r10 != 0) goto L7;
        return i.a(this);
    L7:
        return i0.c(r10);
    }

    public static /* synthetic */ void t(OCoachmarkView r10, CharSequence r11, Integer r12, TextUtils.TruncateAt r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.s(r11, r12, r13);
    }

    public final void A() {
        if (l() == false) goto L6;
        this.f12849m.setOnClickListener(this.E);
        this.f12850n.setOnClickListener(this.D);
        return;
    L6:
        View.OnClickListener r10 = q();
        this.f12849m.setOnClickListener(r10);
        this.f12850n.setOnClickListener(null);
        this.f12851o.setOnClickListener(r10);
    }

    public final void B() {
        z();
        y();
        if (this.f12837b0 == null) goto L6;
        this.f12834a.setEnableShadowWidthRadius(true);
    L6:
        c();
        i();
        x();
        w();
    }

    public final void c() {
        int r10 = b.f12863a[this.f12855s.ordinal()];
        if (r10 != 1) goto L5;
        int r11 = f.r(this, 28);
    L10:
        f(r11);
        if (this.f12835a0 == false) goto L20;
        com.obric.oui.material.b[] r12 = this.f12837b0;
        if (r12 == null) goto L20;
        if (this.f12856t == false) goto L17;
        OUIFrameLayout r13 = this.f12834a;
        q.d(r12);
        o.h(r13, r12[0], false, 0, 6, null);
        OMaterialHelper.T(this.f12834a, 0.0f, 0);
        this.f12834a.setOuterNormalColor(0);
        this.f12834a.setBorderWidth(0);
    L18:
        OUIFrameLayout r14 = this.f12834a;
        GradientDrawable r15 = new GradientDrawable();
        r15.setShape(0);
        r15.setCornerRadius(r11);
        r15.setColor(0);
        r14.setBackground(r15);
    L22:
        int r16 = this.G;
        if (r16 == 0) goto L25;
        TextViewCompat.n(this.f12845i, r16);
    L25:
        int r17 = this.H;
        if (r17 == 0) goto L28;
        TextViewCompat.n(this.f12846j, r17);
    L28:
        j();
        return;
    L17:
        OUIFrameLayout r18 = this.f12834a;
        q.d(r12);
        o.j(r18, r12, false, 0, null, 14, null);
    L20:
        if (this.F == 0) goto L22;
        OUIFrameLayout r19 = this.f12834a;
        GradientDrawable r20 = new GradientDrawable();
        r20.setCornerRadius(r11);
        r20.setColor(this.F);
        r19.setBackground(r20);
        this.f12834a.setOuterNormalColor(this.F);
        goto L22
    L5:
        if (r10 != 2) goto L8;
        r11 = f.r(this, 20);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(AttributeSet r10, int r11, int r12) {
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.OCoachmarkView, r11, r12);
        CharSequence r14 = r13.getText(R$styleable.OCoachmarkView_android_text);     // Catch: Throwable -> L10
        if (r14 == null) goto L7;
        this.f12860x = r14;     // Catch: Throwable -> L10
    L7:
        int r15 = R$styleable.OCoachmarkView_cmTitle;     // Catch: Throwable -> L10
        if (r13.hasValue(r15) == false) goto L12;
        this.f12859w = r13.getText(r15);     // Catch: Throwable -> L10
    L12:
        int r16 = R$styleable.OCoachmarkView_cmIcon;     // Catch: Throwable -> L10
        if (r13.hasValue(r16) == false) goto L15;
        this.A = r13.getDrawable(r16);     // Catch: Throwable -> L10
    L15:
        int r17 = R$styleable.OCoachmarkView_cmHeroImage;     // Catch: Throwable -> L10
        if (r13.hasValue(r17) == false) goto L18;
        Drawable r18 = r13.getDrawable(r17);     // Catch: Throwable -> L10
    L19:
        if (r18 == null) goto L21;
        this.B = r18;     // Catch: Throwable -> L10
    L21:
        int r19 = R$styleable.OCoachmarkView_cmContentStyle;     // Catch: Throwable -> L10
        if (r13.hasValue(r19) == false) goto L24;
        this.f12855s = ContentStyle.Companion.a(r13.getInt(r19, ContentStyle.PILL.getValue()));     // Catch: Throwable -> L10
    L24:
        int r20 = R$styleable.OCoachmarkView_cmShowCloseIcon;     // Catch: Throwable -> L10
        if (r13.hasValue(r20) == false) goto L27;
        this.f12857u = r13.getBoolean(r20, false);     // Catch: Throwable -> L10
    L27:
        i();     // Catch: Throwable -> L10
        int r21 = R$styleable.OCoachmarkView_cmActionText;     // Catch: Throwable -> L10
        if (r13.hasValue(r21) == false) goto L30;
        this.f12861y = r13.getText(r21);     // Catch: Throwable -> L10
        boolean r22 = true;
    L31:
        int r23 = R$styleable.OCoachmarkView_cmPrimaryButtonText;     // Catch: Throwable -> L10
        if (r13.hasValue(r23) == false) goto L34;
        this.f12861y = r13.getText(r23);     // Catch: Throwable -> L10
        r22 = true;
    L34:
        int r24 = R$styleable.OCoachmarkView_cmSecondaryButtonText;     // Catch: Throwable -> L10
        if (r13.hasValue(r24) == false) goto L37;
        this.f12862z = r13.getText(r24);     // Catch: Throwable -> L10
        r22 = true;
    L37:
        int r25 = R$styleable.OCoachmarkView_cmActionStyle;     // Catch: Throwable -> L10
        if (r13.hasValue(r25) == false) goto L40;
        this.f12853q = ActionStyle.Companion.a(r13.getInt(r25, ActionStyle.NONE.getValue()));     // Catch: Throwable -> L10
        boolean r26 = true;
    L41:
        q.f(r13, "this");     // Catch: Throwable -> L10
        d(r13);     // Catch: Throwable -> L10
        int r27 = R$styleable.OCoachmarkView_cmMaxWidth;     // Catch: Throwable -> L10
        if (r13.hasValue(r27) == false) goto L44;
        this.R = r13.getDimensionPixelSize(r27, this.R);     // Catch: Throwable -> L10
    L44:
        int r28 = R$styleable.OCoachmarkView_cmContentPadding;     // Catch: Throwable -> L10
        if (r13.hasValue(r28) == false) goto L47;
        int r29 = r13.getDimensionPixelSize(r28, this.S);     // Catch: Throwable -> L10
        this.S = r29;     // Catch: Throwable -> L10
        this.T = r29;     // Catch: Throwable -> L10
        this.U = r29;     // Catch: Throwable -> L10
        this.V = r29;     // Catch: Throwable -> L10
        boolean r30 = true;
    L48:
        int r31 = R$styleable.OCoachmarkView_cmContentPaddingStart;     // Catch: Throwable -> L10
        if (r13.hasValue(r31) == false) goto L51;
        this.S = r13.getDimensionPixelSize(r31, this.S);     // Catch: Throwable -> L10
        r30 = true;
    L51:
        int r32 = R$styleable.OCoachmarkView_cmContentPaddingTop;     // Catch: Throwable -> L10
        if (r13.hasValue(r32) == false) goto L54;
        this.T = r13.getDimensionPixelSize(r32, this.T);     // Catch: Throwable -> L10
        r30 = true;
    L54:
        int r33 = R$styleable.OCoachmarkView_cmContentPaddingEnd;     // Catch: Throwable -> L10
        if (r13.hasValue(r33) == false) goto L57;
        this.U = r13.getDimensionPixelSize(r33, this.U);     // Catch: Throwable -> L10
        r30 = true;
    L57:
        int r34 = R$styleable.OCoachmarkView_cmContentPaddingBottom;     // Catch: Throwable -> L10
        if (r13.hasValue(r34) == false) goto L60;
        this.V = r13.getDimensionPixelSize(r34, this.V);     // Catch: Throwable -> L10
        r30 = true;
    L60:
        if (r30 == false) goto L62;
        this.W = true;     // Catch: Throwable -> L10
    L62:
        boolean r35 = r13.getBoolean(R$styleable.OCoachmarkView_cmShowArrow, true);     // Catch: Throwable -> L10
        this.f12856t = r35;     // Catch: Throwable -> L10
        l.p(this.f12836b, r35);     // Catch: Throwable -> L10
        this.f12854r = ArrowPosition.Companion.a(r13.getInt(R$styleable.OCoachmarkView_cmArrowPosition, ArrowPosition.TOP.getValue()));     // Catch: Throwable -> L10
        int r36 = R$styleable.OCoachmarkView_cmArrowOffset;     // Catch: Throwable -> L10
        if (r13.hasValue(r36) == false) goto L65;
        this.f12858v = r13.getDimensionPixelSize(r36, 0);     // Catch: Throwable -> L10
    L65:
        r13.recycle();
        if (r26 == true) goto L77;
        if (r22 == false) goto L78;
        L r37 = L.f17615a;
        if (r37.f(8) == true) goto L79;
        r37.d().writeLog("OCoachmarkView", 8, "Action text is set without cmActionStyle; action will stay hidden.", null);
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L47:
        r30 = false;
        goto L48
    L40:
        r26 = false;
        goto L41
    L30:
        r22 = false;
        goto L31
    L18:
        r18 = r13.getDrawable(R$styleable.OCoachmarkView_android_src);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public final void f(int r10) {
        this.f12834a.setShadowCornerRadius(r10);
        if (this.f12834a.isEnableShadowWidthRadius() == false) goto L6;
        this.f12834a.setRadius(r10);
        return;
    }

    public final void g() {
        ContentStyle r10 = this.f12855s;
        int r11 = b.f12863a[r10.ordinal()];
        if (r11 != 1) goto L5;
        int r12 = f.r(this, 20);
        int r13 = f.r(this, 8);
        this.S = r12;
        this.T = r13;
        this.U = r12;
        this.V = r13;
        return;
    L5:
        if (r11 != 2) goto L11;
        int r14 = f.r(this, 20);
        int r15 = f.r(this, 16);
        this.S = r14;
        this.T = r15;
        this.U = r14;
        this.V = r15;
        return;
    }

    @Nullable
    public final CharSequence getText() {
        CharSequence r10 = this.f12860x;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return this.f12846j.getText();
    }

    public final void h() {
        this.F = getContext().getColor(R$color.oui_bg_base_3_high_elevation);
        this.f12834a.setMinimumHeight(f.r(this, 48));
        this.f12834a.setBackgroundColor(this.F);
        this.f12834a.setOuterNormalColor(this.F);
        w();
    }

    public final void i() {
        if (this.W == false) goto L6;
        return;
    L6:
        if (this.C == null) goto L9;
        g();
        return;
    L9:
        ContentStyle r10 = this.f12855s;
        int r11 = b.f12863a[r10.ordinal()];
        if (r11 != 1) goto L12;
        this.S = f.r(this, 20);
        this.T = f.r(this, 8);
        if (this.f12857u == false) goto L29;
        int r12 = 0;
    L30:
        this.U = r12;
        this.V = f.r(this, 8);
        return;
    L29:
        r12 = f.r(this, 20);
        goto L30
    L12:
        if (r11 != 2) goto L33;
        boolean r13 = o();
        if (this.A != null) goto L17;
    L20:
        int r14 = f.r(this, 20);
    L21:
        this.S = r14;
        this.T = f.r(this, 16);
        if (r13 == false) goto L24;
        int r15 = f.r(this, 16);
    L25:
        this.U = r15;
        this.V = f.r(this, 16);
        return;
    L24:
        r15 = f.r(this, 20);
        goto L25
    L17:
        if (this.B != null) goto L20;
        if (r13 == false) goto L20;
        r14 = f.r(this, 16);
        goto L21
    }

    public final void j() {
        ColorStateList r10 = this.I;
        if (r10 == null) goto L6;
        this.f12845i.setTextColor(r10);
    L6:
        ColorStateList r11 = this.f12833J;
        if (r11 == null) goto L10;
        this.f12846j.setTextColor(r11);
    L10:
        this.f12844h.setImageTintList(this.K);
        ColorStateList r12 = this.L;
        if (r12 == null) goto L14;
        this.f12852p.setImageTintList(r12);
    L14:
        Integer r13 = this.N;
        if (r13 == null) goto L18;
        int r14 = r13.intValue();
        this.f12849m.setTextColor(r14);
    L18:
        Integer r15 = this.O;
        if (r15 == null) goto L22;
        int r16 = r15.intValue();
        this.f12850n.setTextColor(r16);
    L22:
        Integer r17 = this.P;
        if (r17 == null) goto L26;
        int r18 = r17.intValue();
        this.f12851o.setTextColor(r18);
    L26:
        Integer r19 = this.Q;
        if (r19 == null) goto L31;
        int r20 = r19.intValue();
        this.f12851o.setBackgroundTintList(ColorStateList.valueOf(r20));
        this.f12851o.setOuterNormalColor(r20);
        return;
    }

    public final boolean k(View r10) {
        ViewParent r11 = r10.getParent();
        if (r11 != null) goto L6;
        return true;
    L6:
        if (r11 != this.f12842f) goto L9;
        return true;
    L9:
        if ((r11 instanceof ViewGroup) == true) goto L16;
        L r12 = L.f17615a;
        if (r12.f(8) == true) goto L22;
        r12.d().writeLog("OCoachmarkView", 8, q.p("custom content view has a non-ViewGroup parent: ", r11.getClass().getSimpleName()), null);
        return false;
    L22:
        return false;
    L16:
        L r13 = L.f17615a;
        if (r13.f(8) == true) goto L20;
        r13.d().writeLog("OCoachmarkView", 8, "custom content view already has a parent; it will be moved into coachmark content container.", null);
    L20:
        ((ViewGroup) r11).removeView(r10);
        return true;
    }

    public final boolean l() {
        if (this.f12853q == ActionStyle.TEXT_ONLY) goto L5;
    L9:
        return false;
    L5:
        if (m() == false) goto L9;
        if (n() == false) goto L9;
        return true;
    }

    public final boolean m() {
        CharSequence r10 = this.f12861y;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        return !r11;
    L5:
        if (kotlin.text.o.r(r10) == true) goto L8;
        r11 = false;
        goto L10
    }

    public final boolean n() {
        CharSequence r10 = this.f12862z;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        return !r11;
    L5:
        if (kotlin.text.o.r(r10) == true) goto L8;
        r11 = false;
        goto L10
    }

    public final boolean o() {
        if (this.f12853q != ActionStyle.NONE) goto L5;
    L7:
        return false;
    L5:
        if (r() == null) goto L7;
        return true;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p();
        super.onDetachedFromWindow();
    }

    public final void p() {
        View r10 = this.C;
        if (r10 != null) goto L5;
        return;
    L5:
        ViewParent r11 = r10.getParent();
        ViewGroup r12 = this.f12842f;
        if (r11 != r12) goto L8;
        r12.removeView(r10);
    L8:
        this.C = null;
    }

    public final View.OnClickListener q() {
        if (m() == true) goto L7;
        return null;
    L7:
        return this.D;
    }

    public final CharSequence r() {
        if (m() == true) goto L7;
        return null;
    L7:
        return this.f12861y;
    }

    public final void s(CharSequence r10, Integer r11, TextUtils.TruncateAt r12) {
        this.f12860x = r10;
        if (r11 == null) goto L6;
        int r13 = r11.intValue();
        this.f12846j.setMaxLines(r13);
    L6:
        if (r12 == null) goto L9;
        this.f12846j.setEllipsize(r12);
    L9:
        B();
    }

    public final void setActionStyle(@NotNull ActionStyle r10) {
        q.g(r10, "style");
        if (this.f12853q == r10) goto L6;
        this.f12853q = r10;
        B();
        return;
    }

    public final void setActionText(@Nullable CharSequence r10) {
        setPrimaryButtonText(r10);
    }

    public final void setArrowOffset(int r10) {
        if (this.f12858v != r10) goto L5;
        return;
    L5:
        this.f12858v = r10;
        w();
    }

    public final void setArrowPosition(@NotNull ArrowPosition r10) {
        q.g(r10, "position");
        if (this.f12854r != r10) goto L5;
        return;
    L5:
        this.f12854r = r10;
        w();
    }

    public final void setArrowVisible(boolean r10) {
        if (this.f12856t != r10) goto L5;
        return;
    L5:
        this.f12856t = r10;
        l.p(this.f12836b, r10);
        w();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        if (this.F == r10) goto L6;
        this.F = r10;
        c();
        return;
    }

    public final void setCloseVisible(boolean r10) {
        setShowCloseIcon(r10);
    }

    public final void setContentPadding(int r10) {
        this.W = true;
        this.S = r10;
        this.T = r10;
        this.U = r10;
        this.V = r10;
        B();
    }

    public final void setContentStyle(@NotNull ContentStyle r10) {
        q.g(r10, "style");
        if (this.f12855s == r10) goto L6;
        this.f12855s = r10;
        i();
        B();
        return;
    }

    public final void setCustomContentView$OUI_standardRelease(@NotNull View r10) {
        q.g(r10, "view");
        if (this.C != r10) goto L7;
        B();
        return;
    L7:
        if (k(r10) == true) goto L13;
        L r11 = L.f17615a;
        if (r11.f(8) == true) goto L15;
        r11.d().writeLog("OCoachmarkView", 8, "custom content view ignored because it cannot be moved into coachmark content container.", null);
        return;
    L15:
        return;
    L13:
        this.f12842f.removeAllViews();
        this.C = r10;
        this.f12842f.addView(r10);
        B();
    }

    public final void setDescTextAppearance(@StyleRes int r10) {
        if (this.H == r10) goto L6;
        this.H = r10;
        c();
        return;
    }

    @JvmOverloads
    public final void setDescription(@Nullable CharSequence r10) {
        t(this, r10, null, null, 6, null);
    }

    public final void setHeroImage(@Nullable Drawable r10) {
        this.B = r10;
        B();
    }

    public final void setIcon(@Nullable Drawable r10) {
        this.A = r10;
        B();
    }

    public final void setMaxWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        if (this.R == r10) goto L8;
        this.R = r10;
        B();
        return;
    }

    public final void setOnActionClickListener(@Nullable View.OnClickListener r10) {
        setOnPrimaryActionClickListener(r10);
    }

    public final void setOnCloseClickListener(@Nullable View.OnClickListener r10) {
        this.f12852p.setOnClickListener(r10);
    }

    public final void setOnPrimaryActionClickListener(@Nullable View.OnClickListener r10) {
        this.D = r10;
        A();
    }

    public final void setOnSecondaryActionClickListener(@Nullable View.OnClickListener r10) {
        this.E = r10;
        A();
    }

    public final void setPopWindowMode(boolean r10) {
        if (this.f12839c0 == r10) goto L12;
        this.f12839c0 = r10;
        if (this.f12835a0 == true) goto L7;
        return;
    L7:
        if (this.f12837b0 == null) goto L14;
        if (r10 == false) goto L10;
        OMaterialHelper.F(this.f12834a, 3);
        OMaterialHelper.F(this.f12836b, 3);
        return;
    L10:
        OMaterialHelper.F(this.f12834a, 2);
        OMaterialHelper.F(this.f12836b, 2);
        return;
    L14:
        return;
    }

    public final void setPrimaryButtonText(@Nullable CharSequence r10) {
        this.f12861y = r10;
        B();
    }

    public final void setSecondaryButtonText(@Nullable CharSequence r10) {
        this.f12862z = r10;
        B();
    }

    public final void setShowCloseIcon(boolean r10) {
        if (this.f12857u == r10) goto L6;
        this.f12857u = r10;
        i();
        B();
        return;
    }

    public final void setText(@Nullable CharSequence r10) {
        t(this, r10, null, null, 6, null);
    }

    public final void setTitle(@Nullable CharSequence r10) {
        this.f12859w = r10;
        B();
    }

    public final void setTitleTextAppearance(@StyleRes int r10) {
        if (this.G == r10) goto L6;
        this.G = r10;
        c();
        return;
    }

    public final void u(boolean r10) {
        View r11 = this.f12848l;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L11;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r10 == false) goto L7;
        int r14 = f.r(this, 8);
    L8:
        r13.topMargin = r14;
        r11.setLayoutParams(r13);
        return;
    L7:
        r14 = f.r(this, 12);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void v() {
        CharSequence r10 = r();
        boolean r11 = m();
        boolean r12 = n();
        boolean r13 = l();
        l.p(this.f12848l, false);
        l.p(this.f12849m, false);
        l.p(this.f12850n, false);
        l.p(this.f12851o, false);
        this.f12849m.setOnClickListener(null);
        this.f12850n.setOnClickListener(null);
        this.f12851o.setOnClickListener(null);
        if (this.D == null) goto L10;
        if (r11 == true) goto L10;
        L r14 = L.f17615a;
        if (r14.f(8) == true) goto L10;
        r14.d().writeLog("OCoachmarkView", 8, "Primary action listener is set without primary action text.", null);
    L10:
        if (this.E == null) goto L16;
        if (r12 == true) goto L16;
        L r15 = L.f17615a;
        if (r15.f(8) == true) goto L16;
        r15.d().writeLog("OCoachmarkView", 8, "Secondary action listener is set without secondary action text.", null);
    L16:
        if (r12 == false) goto L22;
        if (r11 == true) goto L22;
        L r16 = L.f17615a;
        if (r16.f(8) == true) goto L22;
        r16.d().writeLog("OCoachmarkView", 8, "Secondary action text is set without primary action text; secondary action will not render by itself.", null);
    L22:
        if (r12 == true) goto L24;
    L29:
        int r17 = b.f12864b[this.f12853q.ordinal()];
        if (r17 != 1) goto L32;
        if (r13 == false) goto L51;
        l.p(this.f12848l, true);
        l.p(this.f12849m, true);
        l.p(this.f12850n, true);
        this.f12849m.setText(this.f12862z);
        this.f12850n.setText(this.f12861y);
        this.f12849m.setOnClickListener(this.E);
        this.f12850n.setOnClickListener(this.D);
        return;
    L51:
        if (r10 != null) goto L57;
        L r18 = L.f17615a;
        if (r18.f(8) == true) goto L60;
        r18.d().writeLog("OCoachmarkView", 8, "ActionStyle " + a(this) + " is set without action text.", null);
        return;
    L60:
        return;
    L57:
        l.p(this.f12848l, true);
        l.p(this.f12849m, true);
        this.f12849m.setText(r10);
        A();
        return;
    L32:
        if (r17 != 2) goto L34;
        if (r10 != null) goto L47;
        L r19 = L.f17615a;
        if (r19.f(8) == true) goto L59;
        r19.d().writeLog("OCoachmarkView", 8, "ActionStyle " + a(this) + " is set without action text.", null);
        return;
    L59:
        return;
    L47:
        l.p(this.f12851o, true);
        this.f12851o.setText(r10);
        A();
        return;
    L34:
        if (r17 != 3) goto L64;
        if (r10 == null) goto L61;
        L r20 = L.f17615a;
        if (r20.f(8) == true) goto L65;
        r20.d().writeLog("OCoachmarkView", 8, "action text is set while ActionStyle.NONE; action will stay hidden.", null);
        return;
    L65:
        return;
    L61:
        return;
    L64:
        return;
    L24:
        if (this.f12853q != ActionStyle.FILLED_BUTTON) goto L29;
        L r21 = L.f17615a;
        if (r21.f(8) == true) goto L29;
        r21.d().writeLog("OCoachmarkView", 8, "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.", null);
        goto L29
    }

    public final void w() {
        ArrowPosition r10 = this.f12854r;
        if (r10 != ArrowPosition.TOP) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (this.f12856t == true) goto L12;
        int r12 = 0;
    L16:
        OUIFrameLayout r13 = this.f12834a;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L97;
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        r15.topMargin = 0;
        r15.bottomMargin = 0;
        r15.setMarginStart(0);
        r15.setMarginEnd(0);
        ArrowPosition r16 = this.f12854r;
        int[] r17 = b.f12865c;
        int r18 = r17[r16.ordinal()];
        int r19 = 81;
        if (r18 == 1) goto L28;
        if (r18 == 2) goto L27;
        if (r18 == 3) goto L26;
        if (r18 != 4) goto L25;
        int r20 = 8388629;
    L29:
        r15.gravity = r20;
        int r21 = r17[this.f12854r.ordinal()];
        if (r21 == 1) goto L38;
        if (r21 == 2) goto L37;
        if (r21 == 3) goto L36;
        if (r21 != 4) goto L39;
        r15.setMarginEnd(r12);
    L39:
        r13.setLayoutParams(r15);
        if (r11 == false) goto L42;
        int r22 = R$drawable.oui_coachmark_arrow;
    L43:
        int r23 = 20;
        if (r11 == false) goto L46;
        int r24 = f.r(this, 20);
    L47:
        if (r11 == false) goto L49;
        r23 = 9;
    L49:
        int r25 = f.r(this, r23);
        ImageView r26 = this.f12836b;
        ViewGroup.LayoutParams r110 = r26.getLayoutParams();
        if (r110 == null) goto L95;
        FrameLayout.LayoutParams r27 = (FrameLayout.LayoutParams) r110;
        r27.width = r24;
        r27.height = r25;
        int r28 = r17[this.f12854r.ordinal()];
        if (r28 == 1) goto L60;
        if (r28 == 2) goto L61;
        if (r28 == 3) goto L59;
        if (r28 != 4) goto L58;
        r19 = 8388629;
        goto L61
    L58:
        throw new NoWhenBranchMatchedException();
    L59:
        r19 = 8388627;
    L61:
        r27.gravity = r19;
        r26.setLayoutParams(r27);
        this.f12836b.setImageResource(r22);
        ColorStateList r29 = this.M;
        if (r29 == null) goto L65;
        this.f12836b.setImageTintList(r29);
    L65:
        ImageView r30 = this.f12836b;
        int r31 = r17[this.f12854r.ordinal()];
        float r32 = 0.0f;
        if (r31 == 1) goto L70;
        if (r31 == 2) goto L73;
        if (r31 == 3) goto L70;
        if (r31 == 4) goto L70;
        throw new NoWhenBranchMatchedException();
    L73:
        float r33 = 180.0f;
    L74:
        r30.setRotation(r33);
        ImageView r34 = this.f12836b;
        if (this.f12854r != ArrowPosition.RIGHT) goto L77;
        float r35 = -1.0f;
    L78:
        r34.setScaleX(r35);
        this.f12836b.setScaleY(1.0f);
        ImageView r36 = this.f12836b;
        if (r11 == false) goto L81;
        r32 = this.f12858v;
    L81:
        r36.setTranslationX(r32);
        this.f12836b.invalidateOutline();
        if (this.f12835a0 == false) goto L98;
        com.obric.oui.material.b[] r37 = this.f12837b0;
        if (r37 == null) goto L100;
        com.obric.oui.material.b r38 = r37[0];
        o.h(this.f12836b, r38, false, 0, 6, null);
        this.f12836b.setBackgroundColor(0);
        this.f12836b.setImageDrawable(null);
        j0 r39 = r38.j();
        if (r39 != null) goto L90;
        return;
    L90:
        if (this.f12836b.getVisibility() != 0) goto L92;
        this.f12834a.setBorderWidth(0);
        return;
    L92:
        this.f12834a.setBorderWidth(f.q(this, r39.c()));
        return;
    L100:
        return;
    L98:
        return;
    L77:
        r35 = 1.0f;
    L70:
        r33 = 0.0f;
        goto L74
    L60:
        r19 = 49;
        goto L61
    L95:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L46:
        r24 = f.r(this, 10);
        goto L47
    L42:
        r22 = R$drawable.oui_coachmark_arrow_left;
        goto L43
    L36:
        r15.setMarginStart(r12);
        goto L39
    L37:
        r15.bottomMargin = r12;
        goto L39
    L38:
        r15.topMargin = r12;
        goto L39
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r20 = 8388627;
        goto L29
    L27:
        r20 = 81;
        goto L29
    L28:
        r20 = 49;
        goto L29
    L97:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (r11 == false) goto L14;
        r12 = f.r(this, 8);
        goto L16
    L14:
        r12 = f.r(this, 8);
        goto L16
    L5:
        if (r10 == ArrowPosition.BOTTOM) goto L8;
        r11 = false;
        goto L10
    }

    public final void x() {
        this.f12842f.setPaddingRelative(this.S, this.T, this.U, this.V);
    }

    public final void y() {
        View r10 = this.C;
        boolean r11 = true;
        if (r10 == null) goto L9;
        if (r10 == null) goto L76;
        l.p(r10, true);
        return;
    L76:
        return;
    L9:
        if (this.B == null) goto L11;
        boolean r12 = true;
    L12:
        l.p(this.f12840d, r12);
        if (r12 == false) goto L15;
        this.f12841e.setImageDrawable(this.B);
    L17:
        if (r12 == true) goto L19;
    L24:
        if (r12 == false) goto L26;
    L28:
        boolean r13 = false;
    L29:
        l.p(this.f12843g, r13);
        if (r13 == false) goto L32;
        this.f12844h.setImageDrawable(this.A);
    L33:
        View r14 = this.f12847k;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L75;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r13 == false) goto L38;
        int r17 = f.r(this, 12);
    L39:
        r16.setMarginStart(r17);
        r14.setLayoutParams(r16);
        CharSequence r18 = this.f12859w;
        if (r18 != null) goto L42;
    L45:
        boolean r19 = true;
    L46:
        l.p(this.f12845i, !r19);
        this.f12845i.setText(this.f12859w);
        OTextView r20 = this.f12846j;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L73;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        if (r19 == true) goto L51;
        int r23 = f.r(this, 4);
    L52:
        r22.topMargin = r23;
        r20.setLayoutParams(r22);
        this.f12846j.setText(this.f12860x);
        this.f12846j.setMaxWidth(Math.min(this.R, wd.a.c(getContext()).getWidth()));
        CharSequence r24 = this.f12859w;
        if (r24 != null) goto L55;
    L56:
        CharSequence r25 = this.f12860x;
        if (r25 != null) goto L59;
    L60:
        L r26 = L.f17615a;
        if (r26.f(8) == true) goto L64;
        r26.d().writeLog("OCoachmarkView", 8, "Coachmark title and description are empty.", null);
    L64:
        v();
        u(r13);
        if (this.f12855s == ContentStyle.PILL) goto L67;
    L69:
        r11 = false;
    L70:
        l.p(this.f12852p, r11);
        return;
    L67:
        if (this.f12857u == false) goto L69;
    L59:
        if (kotlin.text.o.r(r25) == false) goto L64;
    L55:
        if (kotlin.text.o.r(r24) == false) goto L64;
    L51:
        r23 = 0;
        goto L52
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L42:
        if (kotlin.text.o.r(r18) == true) goto L45;
        r19 = false;
        goto L46
    L38:
        r17 = 0;
        goto L39
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L32:
        this.f12844h.setImageDrawable(null);
        goto L33
    L26:
        if (this.A == null) goto L28;
        r13 = true;
        goto L29
    L19:
        if (this.A == null) goto L24;
        L r27 = L.f17615a;
        if (r27.f(8) == true) goto L24;
        r27.d().writeLog("OCoachmarkView", 8, "Hero image is set; cmIcon will be ignored.", null);
        goto L24
    L15:
        this.f12841e.setImageDrawable(null);
        goto L17
    L11:
        r12 = false;
        goto L12
    }

    public final void z() {
        this.f12834a.setWidthLimit(this.R);
        OUIFrameLayout r10 = this.f12834a;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L17;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        ContentStyle r13 = this.f12855s;
        int r14 = b.f12863a[r13.ordinal()];
        if (r14 != 1) goto L7;
        int r15 = -2;
    L14:
        r12.width = r15;
        r10.setLayoutParams(r12);
        return;
    L7:
        if (r14 != 2) goto L12;
        int r16 = wd.a.c(getContext()).getWidth();
        r15 = f.r(this, 320);
        if (r15 <= r16) goto L14;
        r15 = -1;
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @JvmOverloads
    public OCoachmarkView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OCoachmarkView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OCoachmarkView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = R$attr.ocoachmarkViewStyle;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = R$style.OStyleV2_OCoachmarkView_DayNight;
    L11:
        this(r10, r11, r12, r13);
    }

    public OCoachmarkView(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12, new OUIStyleProvider(r10, r11, r12, r13));
        c r14 = new c(this);
        this.f12838c = r14;
        this.f12853q = ActionStyle.NONE;
        this.f12854r = ArrowPosition.TOP;
        this.f12855s = ContentStyle.PILL;
        this.f12856t = true;
        this.R = f.r(this, 320);
        this.S = f.r(this, 20);
        this.T = f.r(this, 8);
        this.U = f.r(this, 20);
        this.V = f.r(this, 8);
        if (o.f(this) == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        this.f12835a0 = r15;
        LayoutInflater.from(r10).inflate(R$layout.o_coachmark, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        View r16 = findViewById(R$id.coachmark_container);
        q.f(r16, "findViewById(R.id.coachmark_container)");
        OUIFrameLayout r17 = (OUIFrameLayout) r16;
        this.f12834a = r17;
        r17.setChangeAlphaWhenPress(false);
        View r18 = findViewById(R$id.iv_coachmark_arrow);
        q.f(r18, "findViewById(R.id.iv_coachmark_arrow)");
        ImageView r19 = (ImageView) r18;
        this.f12836b = r19;
        r19.setOutlineProvider(r14);
        View r20 = findViewById(R$id.coachmark_hero_container);
        q.f(r20, "findViewById(R.id.coachmark_hero_container)");
        this.f12840d = r20;
        View r21 = findViewById(R$id.coachmark_hero_image);
        q.f(r21, "findViewById(R.id.coachmark_hero_image)");
        this.f12841e = (ImageView) r21;
        View r22 = findViewById(R$id.coachmark_content_container);
        q.f(r22, "findViewById(R.id.coachmark_content_container)");
        this.f12842f = (ViewGroup) r22;
        View r23 = findViewById(R$id.coachmark_icon_container);
        q.f(r23, "findViewById(R.id.coachmark_icon_container)");
        this.f12843g = (OUIFrameLayout) r23;
        View r24 = findViewById(R$id.coachmark_icon);
        q.f(r24, "findViewById(R.id.coachmark_icon)");
        this.f12844h = (ImageView) r24;
        View r25 = findViewById(R$id.tv_coachmark_title);
        q.f(r25, "findViewById(R.id.tv_coachmark_title)");
        OTextView r26 = (OTextView) r25;
        this.f12845i = r26;
        r26.getPaint().setSubpixelText(true);
        r26.setIncludeFontPadding(true);
        View r27 = findViewById(R$id.tv_coachmark_description);
        q.f(r27, "findViewById(R.id.tv_coachmark_description)");
        OTextView r28 = (OTextView) r27;
        this.f12846j = r28;
        r28.getPaint().setSubpixelText(true);
        r28.setIncludeFontPadding(true);
        View r29 = findViewById(R$id.coachmark_text_group);
        q.f(r29, "findViewById(R.id.coachmark_text_group)");
        this.f12847k = r29;
        View r30 = findViewById(R$id.coachmark_action_text_container);
        q.f(r30, "findViewById(R.id.coachmark_action_text_container)");
        this.f12848l = r30;
        View r31 = findViewById(R$id.btn_coachmark_action_text);
        q.f(r31, "findViewById(R.id.btn_coachmark_action_text)");
        this.f12849m = (OButton) r31;
        View r32 = findViewById(R$id.btn_coachmark_action_text_primary);
        q.f(r32, "findViewById(R.id.btn_co…mark_action_text_primary)");
        this.f12850n = (OButton) r32;
        View r33 = findViewById(R$id.btn_coachmark_action_filled);
        q.f(r33, "findViewById(R.id.btn_coachmark_action_filled)");
        this.f12851o = (OButton) r33;
        View r34 = findViewById(R$id.btn_coachmark_close);
        q.f(r34, "findViewById(R.id.btn_coachmark_close)");
        this.f12852p = (OIconButton) r34;
        h();
        e(r11, r12, r13);
        B();
        return;
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        r15 = true;
        goto L8
    }
}
