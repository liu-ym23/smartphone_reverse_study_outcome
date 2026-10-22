package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.l;
import com.tmall.wireless.tangram.structure.card.BannerCard;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b8\u0018\u0000  \u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0007ad\u0017¡\u0002¢\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u001b\u0010\u001d\u001a\u00020\f*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u0013J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020$H\u0002¢\u0006\u0004\b)\u0010'J-\u0010/\u001a\u00020\f2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010*¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u001bH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\f2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\f2\u0006\u00108\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\f2\u0006\u00108\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020\f2\u0006\u00108\u001a\u00020;H\u0016¢\u0006\u0004\b?\u0010=J\u0017\u0010@\u001a\u00020\f2\u0006\u00108\u001a\u00020;H\u0016¢\u0006\u0004\b@\u0010=J\u0017\u0010C\u001a\u00020\f2\u0006\u0010B\u001a\u00020AH\u0014¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\f2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\f2\b\u0010F\u001a\u0004\u0018\u00010I¢\u0006\u0004\bJ\u0010KJ\u0011\u0010M\u001a\u0004\u0018\u00010LH\u0014¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\f2\u0006\u0010O\u001a\u00020LH\u0014¢\u0006\u0004\bP\u0010QJ\u0019\u0010T\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010RH\u0014¢\u0006\u0004\bT\u0010UJ\u001f\u0010X\u001a\u00020\f2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\bH\u0014¢\u0006\u0004\bX\u0010YJ7\u0010_\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\bH\u0014¢\u0006\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010nR\u0016\u0010q\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010nR$\u0010u\u001a\u00020\b2\u0006\u0010r\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010n\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010wR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010wR\u0014\u0010|\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010{R\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010{R\u0016\u0010\u007f\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b/\u0010\u0080\u0001R\u0017\u0010\u0082\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010~R\u0017\u0010\u0083\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010nR\u0017\u0010\u0084\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010~R\u0018\u0010\u0086\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010~R(\u0010\u008a\u0001\u001a\u00020$2\u0006\u0010r\u001a\u00020$8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010~\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u0092\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R(\u0010\u0094\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0093\u0001\u0010\u0080\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0005\b\u0096\u0001\u00106R(\u0010\u0098\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0097\u0001\u0010\u0080\u0001\u001a\u0006\b\u0098\u0001\u0010\u0095\u0001\"\u0005\b\u0099\u0001\u00106R\u0018\u0010\u009b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010nR\u0018\u0010\u009d\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010~R\u0018\u0010\u009f\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010~R\u0018\u0010¡\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010~R\u0018\u0010£\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010nR\u0018\u0010¥\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010nR\u0018\u0010§\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010nR\u0019\u0010©\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u0080\u0001R\u0018\u0010«\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bª\u0001\u0010nR\u0017\u0010¬\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010nR\u0018\u0010®\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010~R\u0018\u0010°\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010nR\u0018\u0010±\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bn\u0010\u0080\u0001R\u0018\u0010²\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010~R\u0018\u0010´\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b³\u0001\u0010~R\u0018\u0010¶\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bµ\u0001\u0010~R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R/\u0010¿\u0001\u001a\u0018\u0012\u0004\u0012\u000201\u0018\u00010»\u0001j\u000b\u0012\u0004\u0012\u000201\u0018\u0001`¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0017\u0010Â\u0001\u001a\u0002078\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Æ\u0001\u001a\u00030Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0018\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u0016\u0010Ì\u0001\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bË\u0001\u0010{R\u0016\u0010Î\u0001\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÍ\u0001\u0010{R\u0018\u0010Ò\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ô\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ñ\u0001R0\u0010Ü\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150Õ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010\u0080\u0001R\u0016\u0010à\u0001\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bß\u0001\u0010{R \u0010ä\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001b\u0010ç\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001b\u0010ê\u0001\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001c\u0010î\u0001\u001a\u00070ë\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001c\u0010ð\u0001\u001a\u00070ë\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010í\u0001R(\u0010ñ\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u0010t\"\u0005\bó\u0001\u0010\u0011R*\u0010ô\u0001\u001a\u00020$2\u0007\u0010ô\u0001\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bõ\u0001\u0010\u0089\u0001\"\u0006\bö\u0001\u0010÷\u0001R)\u0010ù\u0001\u001a\u00020\u001b2\u0007\u0010ø\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bù\u0001\u0010\u0095\u0001\"\u0005\bú\u0001\u00106R*\u0010û\u0001\u001a\u00020$2\u0007\u0010û\u0001\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bü\u0001\u0010\u0089\u0001\"\u0006\bý\u0001\u0010÷\u0001R(\u0010þ\u0001\u001a\u00020\b2\u0007\u0010þ\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÿ\u0001\u0010t\"\u0005\b\u0080\u0002\u0010\u0011R*\u0010\u0081\u0002\u001a\u00020$2\u0007\u0010\u0081\u0002\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0002\u0010\u0089\u0001\"\u0006\b\u0083\u0002\u0010÷\u0001R*\u0010\u0084\u0002\u001a\u00020$2\u0007\u0010\u0084\u0002\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0002\u0010\u0089\u0001\"\u0006\b\u0086\u0002\u0010÷\u0001R(\u0010\u0087\u0002\u001a\u00020\b2\u0007\u0010\u0087\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0002\u0010t\"\u0005\b\u0089\u0002\u0010\u0011R*\u0010\u008a\u0002\u001a\u00020$2\u0007\u0010\u008a\u0002\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008b\u0002\u0010\u0089\u0001\"\u0006\b\u008c\u0002\u0010÷\u0001R*\u0010\u008d\u0002\u001a\u00020$2\u0007\u0010\u008d\u0002\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0002\u0010\u0089\u0001\"\u0006\b\u008f\u0002\u0010÷\u0001R*\u0010\u0093\u0002\u001a\u00020$2\u0007\u0010\u0090\u0002\u001a\u00020$8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0091\u0002\u0010\u0089\u0001\"\u0006\b\u0092\u0002\u0010÷\u0001R(\u0010\u0094\u0002\u001a\u00020\b2\u0007\u0010\u0094\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0002\u0010t\"\u0005\b\u0096\u0002\u0010\u0011R(\u0010\u0097\u0002\u001a\u00020\b2\u0007\u0010\u0097\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0098\u0002\u0010t\"\u0005\b\u0099\u0002\u0010\u0011R(\u0010\u009a\u0002\u001a\u00020\b2\u0007\u0010\u009a\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0002\u0010t\"\u0005\b\u009c\u0002\u0010\u0011R)\u0010\u009e\u0002\u001a\u00020\u001b2\u0007\u0010\u009d\u0002\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u009e\u0002\u0010\u0095\u0001\"\u0005\b\u009f\u0002\u00106¨\u0006£\u0002"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "l", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", SlideCard.KEY_INDEX, "setFragments", "(I)V", "k", "()V", "position", "Landroid/view/View;", "tabView", "c", "(ILandroid/view/View;)V", "q", "Landroid/text/TextPaint;", "", "bold", "f", "(Landroid/text/TextPaint;Z)V", "p", "i", "h", "g", "m", "", "dp", "j", "(F)I", CloudControlInf.SP, "o", "", "", "titles", "Landroid/graphics/drawable/Drawable;", "drawables", "n", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "enabled", "setEnabled", "(Z)V", "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "(Landroid/animation/ValueAnimator;)V", "Landroid/animation/Animator;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;)V", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "setOnTabSelectAnimListener", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", WsConstants.KEY_CONNECTION_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "a", "Landroid/content/Context;", "mContext", "b", "[Ljava/lang/String;", "mTitles", "[Landroid/graphics/drawable/Drawable;", "mTabDrawables", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mTabsContainer", "e", "I", "mCurrentTab", "mPressedTab", "mLastTab", "<set-?>", "getTabCount", "()I", "tabCount", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "mIndicatorRect", "mIndicatorPressedRect", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mIndicatorPaint", "mDividerPaint", "F", "mTabPadding", "Z", "mTabSpaceEqual", "mTabWidth", "mIndicatorColor", "mIndicatorHeight", "r", "mIndicatorCornerRadius", "s", "getIndicatorSpacing", "()F", "indicatorSpacing", "", "t", "J", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorAnimDuration", "u", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "v", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "w", "mDividerColor", FixCard.FixStyle.KEY_X, "mDividerWidth", FixCard.FixStyle.KEY_Y, "mDividerPadding", "z", "mTextsize", "A", "mTextSelectColor", "B", "mTextUnselectColor", "C", "mTextBold", "D", "mTextAllCaps", "E", "mBarColor", "mBarStrokeColor", "G", "mBarStrokeWidth", "H", "mHeight", "mVibrateOnTabSelected", "indicatorShadowRadiusPx", "K", "indicatorShadowDxPx", "L", "indicatorShadowDyPx", "Landroidx/fragment/app/FragmentManager;", "M", "Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "N", "Ljava/util/ArrayList;", "mFragments", "O", "Landroid/animation/ValueAnimator;", "mValueAnimator", "Landroid/view/animation/PathInterpolator;", "P", "Landroid/view/animation/PathInterpolator;", "mInterpolator", "", "Q", "[F", "mRadiusArr", "R", "barPaint", "S", "barStrokePaint", "Landroid/graphics/RectF;", "T", "Landroid/graphics/RectF;", "barRectF", "U", "barStrokeRectF", "", "V", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "W", "mIsFirstDraw", "a0", "mTextPaint", "Landroid/util/SparseArray;", "b0", "Landroid/util/SparseArray;", "mInitSetMap", "c0", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "mListener", "d0", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "mSelectAnimListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$b;", "e0", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$b;", "mCurrentP", "f0", "mLastP", "currentTab", "getCurrentTab", "setCurrentTab", "tabPadding", "getTabPadding", "setTabPadding", "(F)V", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", BannerCard.ATTR_INDICATOR_HEIGHT, "getIndicatorHeight", "setIndicatorHeight", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextsize", "setTextsize", "textsize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textBold", "getTextBold", "setTextBold", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "g0", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final a f16675g0 = null;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public float G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f16676J;
    public float K;
    public float L;
    public FragmentManager M;
    public ArrayList N;
    public final ValueAnimator O;
    public final PathInterpolator P;
    public final float[] Q;
    public final Paint R;
    public final Paint S;
    public final RectF T;
    public final RectF U;
    public List V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16677a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Paint f16678a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f16679b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final SparseArray f16680b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable[] f16681c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public TabSelectListener f16682c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f16683d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public TabSelectAnimListener f16684d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16685e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final b f16686e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16687f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final b f16688f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f16691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f16692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f16693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f16694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f16695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f16697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f16700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f16701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f16702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f16706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f16707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f16708z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectAnimListener {
        void onSelectAnimCancel();

        void onSelectAnimEnd();

        void onSelectAnimStart();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectListener {
        void onReselect(int r10);

        void onSelect(int r10);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OTabSegmentedLayout f16711c;

        public b(OTabSegmentedLayout r10) {
            q.g(r10, "this$0");
            this.f16711c = r10;
        }

        public final float a() {
            return this.f16709a;
        }

        public final float b() {
            return this.f16710b;
        }

        public final void c(float r10) {
            this.f16709a = r10;
        }

        public final void d(float r10) {
            this.f16710b = r10;
        }

        public String toString() {
            return "(left = " + this.f16709a + ", right = " + this.f16710b + ')';
        }
    }

    public final class c implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabSegmentedLayout f16712a;

        public c(OTabSegmentedLayout r10) {
            q.g(r10, "this$0");
            this.f16712a = r10;
        }

        public b a(float r10, b r11, b r12) {
            q.g(r11, "startValue");
            q.g(r12, "endValue");
            float r13 = r11.a() + ((r12.a() - r11.a()) * r10);
            float r14 = r11.b() + (r10 * (r12.b() - r11.b()));
            b r15 = new b(this.f16712a);
            r15.c(r13);
            r15.d(r14);
            return r15;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
            return a(r10, (b) r11, (b) r12);
        }
    }

    static {
        f16675g0 = new a(null);
    }

    @JvmOverloads
    public OTabSegmentedLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OTabSegmentedLayout r10, View r11) {
        e(r10, r11);
    }

    public static /* synthetic */ boolean b(OTabSegmentedLayout r10, View r11, MotionEvent r12) {
        return d(r10, r11, r12);
    }

    public static final boolean d(OTabSegmentedLayout r10, View r11, MotionEvent r12) {
        q.g(r10, "this$0");
        int r13 = r12.getAction();
        if (r13 != 0) goto L5;
        Object r14 = r11.getTag();
        if (r14 == null) goto L16;
        r10.f16687f = ((Integer) r14).intValue();
        r10.postInvalidate();
        return false;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L5:
        if (r13 != 1) goto L7;
    L9:
        r10.f16687f = -1;
        r10.postInvalidate();
        return false;
    L7:
        if (r13 == 3) goto L9;
        return false;
    }

    public static final void e(OTabSegmentedLayout r10, View r11) {
        q.g(r10, "this$0");
        if (r10.I == false) goto L5;
        dd.a.b(r10.getContext(), 1);
    L5:
        Object r12 = r11.getTag();
        if (r12 == null) goto L21;
        int r13 = ((Integer) r12).intValue();
        if (r10.f16685e == r13) goto L14;
        r10.setCurrentTab(r13);
        TabSelectListener r14 = r10.f16682c0;
        if (r14 == null) goto L22;
        if (r14 == null) goto L25;
        r14.onSelect(r13);
        return;
    L25:
        return;
    L22:
        return;
    L14:
        TabSelectListener r15 = r10.f16682c0;
        if (r15 == null) goto L24;
        if (r15 == null) goto L26;
        r15.onReselect(r13);
        return;
    L26:
        return;
    L24:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void setFragments(int r10) {
        ArrayList r11 = this.N;
        if (r11 == null) goto L17;
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        int r14 = r13 + 1;
        FragmentManager r15 = this.M;
        q.d(r15);
        FragmentTransaction r16 = r15.o();
        q.f(r16, "mFragmentManager!!.beginTransaction()");
        ArrayList r17 = this.N;
        q.d(r17);
        Object r18 = r17.get(r13);
        q.f(r18, "mFragments!![i]");
        Fragment r19 = (Fragment) r18;
        if (r13 != r10) goto L10;
        r16.A(r19);
    L11:
        r16.j();
        r13 = r14;
        goto L6
    L10:
        r16.r(r19);
        goto L11
    L12:
        this.f16685e = r10;
        return;
    }

    public final void c(int r10, View r11) {
        View r12 = r11.findViewById(R$id.tv_tab_title);
        if (r12 == null) goto L42;
        TextView r13 = (TextView) r12;
        ImageView r14 = (ImageView) r11.findViewById(R$id.tv_tab_icon);
        CharSequence[] r15 = this.f16679b;
        Unit r16 = null;
        Drawable r17 = null;
        if (r15 != null) goto L7;
        Unit r18 = null;
    L16:
        if (r18 != null) goto L18;
        r13.setVisibility(8);
    L18:
        Drawable[] r19 = this.f16681c;
        if (r19 == null) goto L26;
        if (r19 == null) goto L24;
        r17 = r19[r10];
    L24:
        r14.setImageDrawable(r17);
        r16 = Unit.f21064a;
    L26:
        if (r16 != null) goto L32;
        r14.setVisibility(8);
        ViewGroup.LayoutParams r20 = r13.getLayoutParams();
        if (r20 == null) goto L31;
        LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) r20;
        r21.setMargins(0, 0, 0, 0);
        r13.setLayoutParams(r21);
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L32:
        r11.setOnTouchListener(new com.obric.oui.segmentedtab.b(this));
        r11.setOnClickListener(new com.obric.oui.segmentedtab.c(this));
        this.V.add(r11);
        if (this.f16696n == false) goto L35;
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L37:
        if (this.f16697o <= 0.0f) goto L39;
        r22 = new LinearLayout.LayoutParams((int) this.f16697o, -1);
    L39:
        this.f16683d.addView(r11, r10, r22);
        return;
    L35:
        r22 = new LinearLayout.LayoutParams(-2, -1);
        goto L37
    L7:
        CharSequence r23 = "";
        if (r15 == null) goto L14;
        CharSequence r24 = r15[r10];
        if (r24 == null) goto L14;
        r23 = r24;
    L14:
        r13.setText(r23);
        r18 = Unit.f21064a;
        goto L16
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void f(TextPaint r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 700;
    L5:
        r10.setTypeface(Typeface.create(null, r12, false));
        return;
    L4:
        r12 = 400;
        goto L5
    }

    public final void g() {
        int r10 = this.f16687f;
        if (r10 == (-1)) goto L5;
        View r11 = this.f16683d.getChildAt(r10);
    L6:
        if (r11 == null) goto L10;
        Rect r12 = this.f16692j;
        r12.left = r11.getLeft();
        Rect r13 = this.f16692j;
        r13.right = r11.getRight();
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Nullable
    public final Fragment getCurrentFragment() {
        ArrayList r10 = this.N;
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Fragment) r10.get(this.f16685e);
    }

    public final int getCurrentTab() {
        return this.f16685e;
    }

    public final int getDividerColor() {
        return this.f16705w;
    }

    public final float getDividerPadding() {
        return this.f16707y;
    }

    public final float getDividerWidth() {
        return this.f16706x;
    }

    public final long getIndicatorAnimDuration() {
        return this.f16702t;
    }

    public final int getIndicatorColor() {
        return this.f16698p;
    }

    public final float getIndicatorCornerRadius() {
        return this.f16700r;
    }

    public final float getIndicatorHeight() {
        return this.f16699q;
    }

    public final float getIndicatorSpacing() {
        return this.f16701s;
    }

    public final int getTabCount() {
        return this.f16690h;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.V;
    }

    public final float getTabPadding() {
        return this.f16695m;
    }

    public final float getTabWidth() {
        return this.f16697o;
    }

    public final int getTextBold() {
        return this.C;
    }

    public final int getTextSelectColor() {
        return this.A;
    }

    public final int getTextUnselectColor() {
        return this.B;
    }

    public final float getTextsize() {
        return this.f16708z;
    }

    public final void h() {
        View r10 = this.f16683d.getChildAt(this.f16685e);
        float r11 = r10.getLeft();
        float r12 = r10.getRight();
        Rect r13 = this.f16691i;
        r13.left = (int) r11;
        r13.right = (int) r12;
        if (this.f16703u == true) goto L11;
        int r14 = this.f16685e;
        if (r14 != 0) goto L8;
        float[] r15 = this.Q;
        float r16 = this.f16700r;
        r15[0] = r16;
        r15[1] = r16;
        r15[2] = 0.0f;
        r15[3] = 0.0f;
        r15[4] = 0.0f;
        r15[5] = 0.0f;
        r15[6] = r16;
        r15[7] = r16;
        return;
    L8:
        if (r14 != (this.f16690h - 1)) goto L10;
        float[] r17 = this.Q;
        r17[0] = 0.0f;
        r17[1] = 0.0f;
        float r18 = this.f16700r;
        r17[2] = r18;
        r17[3] = r18;
        r17[4] = r18;
        r17[5] = r18;
        r17[6] = 0.0f;
        r17[7] = 0.0f;
        return;
    L10:
        float[] r19 = this.Q;
        r19[0] = 0.0f;
        r19[1] = 0.0f;
        r19[2] = 0.0f;
        r19[3] = 0.0f;
        r19[4] = 0.0f;
        r19[5] = 0.0f;
        r19[6] = 0.0f;
        r19[7] = 0.0f;
        return;
    L11:
        float[] r20 = this.Q;
        float r110 = this.f16700r;
        r20[0] = r110;
        r20[1] = r110;
        r20[2] = r110;
        r20[3] = r110;
        r20[4] = r110;
        r20[5] = r110;
        r20[6] = r110;
        r20[7] = r110;
    }

    public final void i() {
        View r10 = this.f16683d.getChildAt(this.f16685e);
        this.f16686e0.c(r10.getLeft());
        this.f16686e0.d(r10.getRight());
        View r11 = this.f16683d.getChildAt(this.f16689g);
        this.f16688f0.c(r11.getLeft());
        this.f16688f0.d(r11.getRight());
        if (this.f16688f0.a() == this.f16686e0.a()) goto L5;
    L7:
        this.O.setObjectValues(new Object[]{this.f16688f0, this.f16686e0});
        if (this.f16704v == false) goto L10;
        this.O.setInterpolator(this.P);
    L10:
        this.O.setDuration(350);
        this.O.start();
        return;
    L5:
        if (this.f16688f0.b() != this.f16686e0.b()) goto L7;
        invalidate();
    }

    public final int j(float r10) {
        return (int) ((r10 * this.f16677a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void k() {
        this.f16683d.removeAllViews();
        String[] r10 = this.f16679b;
        if (r10 != null) goto L5;
        Integer r11 = null;
    L6:
        int r12 = 0;
        if (r11 != null) goto L12;
        Drawable[] r13 = this.f16681c;
        if (r13 != null) goto L11;
        int r14 = 0;
    L13:
        this.f16690h = r14;
        this.V.clear();
        int r15 = this.f16690h;
    L14:
        if (r12 >= r15) goto L16;
        OSegmentTabView r16 = OSegmentTabView.f16664l.b(this.f16677a);
        r16.n(this.A, this.B);
        r16.setOriginIconAlpha(PrivateKeyType.INVALID);
        r16.setTag(Integer.valueOf(r12));
        c(r12, r16);
        r12 = r12 + 1;
        goto L14
    L16:
        q();
        return;
    L11:
        r14 = r13.length;
        goto L13
    L12:
        r14 = r11.intValue();
        goto L13
    L5:
        r11 = Integer.valueOf(r10.length);
        goto L6
    }

    public final void l(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OTabLayout);
        q.f(r12, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f16698p = r12.getColor(R$styleable.OTabLayout_indicator_color, getResources().getColor(R$color.oui_fill_seg_selected));
        this.f16699q = r12.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f);
        this.f16700r = r12.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f);
        this.f16701s = r12.getDimension(R$styleable.OTabLayout_indicator_spacing, j(4.0f));
        LinearLayout r13 = this.f16683d;
        int r14 = (int) (getIndicatorSpacing() / 2);
        r13.setPadding(r14, 0, r14, 0);
        this.f16703u = r12.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false);
        this.f16704v = r12.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);
        this.f16705w = r12.getColor(R$styleable.OTabLayout_divider_color, this.f16698p);
        this.f16706x = r12.getDimension(R$styleable.OTabLayout_divider_width, j(1.0f));
        this.f16707y = r12.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        this.f16708z = r12.getDimension(R$styleable.OTabLayout_tab_textSize, o(13.0f));
        this.A = r12.getColor(R$styleable.OTabLayout_tab_textSelectColor, Color.parseColor("#ffffff"));
        this.B = r12.getColor(R$styleable.OTabLayout_tab_textUnselectColor, this.f16698p);
        this.C = r12.getInt(R$styleable.OTabLayout_tab_textBold, 0);
        this.D = r12.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        this.f16696n = r12.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r15 = r12.getDimension(R$styleable.OTabLayout_tab_width, j(-1.0f));
        this.f16697o = r15;
        int r16 = R$styleable.OTabLayout_tab_padding;
        if (this.f16696n == false) goto L5;
    L8:
        int r17 = j(0.0f);
    L9:
        this.f16695m = r12.getDimension(r16, r17);
        int r18 = r12.getColor(R$styleable.OTabLayout_bar_color, 0);
        this.E = r18;
        this.F = r12.getColor(R$styleable.OTabLayout_bar_stroke_color, r18);
        this.G = r12.getDimension(R$styleable.OTabLayout_bar_stroke_width, j(0.0f));
        this.I = r12.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, true);
        r12.recycle();
        return;
    L5:
        if (r15 > 0.0f) goto L8;
        r17 = j(10.0f);
        goto L9
    }

    public final void m() {
        this.f16676J = f.u(this, 10);
        this.K = f.u(this, 0);
        this.L = f.u(this, 4);
    }

    public final void n(String[] r10, Drawable[] r11) {
        if (r10 != null) goto L4;
    L5:
        if (r11 == null) goto L11;
        if (r11.length == 0) goto L11;
    L8:
        this.f16679b = r10;
        this.f16681c = r11;
        k();
        return;
    L11:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !");
    L4:
        if (r10.length != 0) goto L8;
        goto L5
    }

    public final int o(float r10) {
        return (int) ((r10 * this.f16677a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r10) {
        q.g(r10, "animation");
        TabSelectAnimListener r11 = this.f16684d0;
        if (r11 == null) goto L7;
        r11.onSelectAnimCancel();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r10) {
        q.g(r10, "animation");
        TabSelectAnimListener r11 = this.f16684d0;
        if (r11 == null) goto L7;
        r11.onSelectAnimEnd();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r10) {
        q.g(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r10) {
        q.g(r10, "animation");
        TabSelectAnimListener r11 = this.f16684d0;
        if (r11 == null) goto L7;
        r11.onSelectAnimStart();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        q.g(r10, "animation");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L7;
        b r12 = (b) r11;
        Rect r13 = this.f16691i;
        r13.left = (int) r12.a();
        Rect r14 = this.f16691i;
        r14.right = (int) r12.b();
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        m();
    }

    @Override // android.view.View
    public void onDraw(Canvas r15) {
        q.g(r15, "canvas");
        super.onDraw(r15);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f16690h <= 0) goto L35;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        if (this.f16699q >= 0.0f) goto L10;
        this.f16699q = r10 - (this.f16701s * 2);
    L10:
        float r12 = this.f16700r;
        if (r12 >= 0.0f) goto L13;
    L14:
        this.f16700r = this.f16699q;
    L15:
        this.R.setColor(this.E);
        this.T.set(0.0f, getPaddingTop(), getWidth(), r10 - getPaddingBottom());
        float r13 = 2;
        float r14 = this.f16700r + (this.f16701s / r13);
        l.i(r15, this.T, r14, this.R);
        if (this.G <= 0.0f) goto L19;
        this.S.setColor(this.F);
        this.S.setStrokeWidth(this.G);
        this.U.set(this.G / r13, getPaddingTop() + (this.G / r13), getWidth() - (this.G / r13), (r10 - getPaddingBottom()) - (this.G / r13));
        l.i(r15, this.U, r14, this.S);
    L19:
        if (this.f16703u == true) goto L26;
        float r16 = this.f16706x;
        if (r16 <= 0.0f) goto L26;
        this.f16694l.setStrokeWidth(r16);
        this.f16694l.setColor(this.f16705w);
        int r17 = this.f16690h - 1;
        int r18 = 0;
    L23:
        if (r18 >= r17) goto L26;
        int r19 = r18 + 1;
        View r20 = this.f16683d.getChildAt(r18);
        r15.drawLine(r20.getRight() + r11, this.f16707y, r20.getRight() + r11, r10 - this.f16707y, this.f16694l);
        r18 = r19;
    L26:
        if (this.f16703u == true) goto L28;
        h();
    L31:
        g();
        float r21 = (this.f16701s / r13) + this.G;
        Paint r22 = this.f16693k;
        r22.setColor(this.f16698p);
        r22.setShadowLayer(this.f16676J, this.K, this.L, ContextCompat.b(getContext(), R$color.TabSegmentedShadowColor));
        Rect r23 = this.f16691i;
        float r24 = (r11 + r21) + r23.left;
        float r25 = this.f16701s;
        float r26 = this.G;
        l.h(r15, r24, r25 + r26, (r11 + r23.right) - r21, (r25 + this.f16699q) - r26, this.f16700r, this.f16693k);
        return;
    L28:
        if (this.W == false) goto L31;
        this.W = false;
        h();
        goto L31
    L13:
        if (r12 <= (this.f16699q / 2)) goto L15;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        if ((r10 instanceof Bundle) == false) goto L9;
        Bundle r11 = (Bundle) r10;
        this.f16685e = r11.getInt("mCurrentTab");
        r10 = r11.getParcelable("instanceState");
        if (this.f16685e == 0) goto L9;
        if (this.f16683d.getChildCount() <= 0) goto L9;
        p(this.f16685e);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        r10.putInt("mCurrentTab", this.f16685e);
        return r10;
    }

    public final void p(int r10) {
        int r11 = this.f16690h;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L29;
        int r13 = r12 + 1;
        View r14 = this.f16683d.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r15 = true;
    L8:
        View r16 = r14.findViewById(R$id.tv_tab_title);
        if (r16 == null) goto L28;
        TextView r17 = (TextView) r16;
        ImageView r18 = (ImageView) r14.findViewById(R$id.tv_tab_icon);
        if (r15 == false) goto L14;
        int r19 = this.A;
    L15:
        r18.setImageTintList(ColorStateList.valueOf(r19));
        if (this.C != 1) goto L18;
        TextPaint r20 = r17.getPaint();
        q.f(r20, "tabTitle.paint");
        f(r20, r15);
        r17.invalidate();
    L18:
        td.c r21 = td.c.f24796a;
        if ((r14 instanceof OSegmentTabView) == true) goto L22;
        r14 = null;
    L22:
        OSegmentTabView r22 = (OSegmentTabView) r14;
        if (r22 == null) goto L26;
        r22.q(r15);
    L26:
        r12 = r13;
        goto L3
    L14:
        r19 = this.B;
        goto L15
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        r15 = false;
        goto L8
    }

    public final void q() {
        int r10 = this.f16690h;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L31;
        int r12 = r11 + 1;
        View r13 = this.f16683d.getChildAt(r11);
        float r14 = this.f16695m;
        r13.setPadding((int) r14, 0, (int) r14, 0);
        View r15 = r13.findViewById(R$id.tv_tab_title);
        if (r15 == null) goto L30;
        TextView r16 = (TextView) r15;
        int r17 = this.f16685e;
        if (r11 != r17) goto L9;
        boolean r18 = true;
    L10:
        if (r11 != r17) goto L12;
        int r19 = this.A;
    L13:
        r16.setTextColor(r19);
        r16.setTextSize(0, this.f16708z);
        ImageView r20 = (ImageView) r13.findViewById(R$id.tv_tab_icon);
        if (r11 != this.f16685e) goto L17;
        int r21 = this.A;
    L18:
        r20.setImageTintList(ColorStateList.valueOf(r21));
        if (this.D == false) goto L21;
        String r22 = r16.getText().toString();
        Locale r23 = Locale.ROOT;
        q.f(r23, "ROOT");
        String r24 = r22.toUpperCase(r23);
        q.f(r24, "this as java.lang.String).toUpperCase(locale)");
        r16.setText(r24);
    L21:
        int r25 = this.C;
        if (r25 != 2) goto L24;
        TextPaint r26 = r16.getPaint();
        q.f(r26, "tvTabTitle.paint");
        f(r26, true);
    L28:
        r11 = r12;
        goto L3
    L24:
        if (r25 != 0) goto L26;
        TextPaint r27 = r16.getPaint();
        q.f(r27, "tvTabTitle.paint");
        f(r27, false);
        goto L28
    L26:
        if (r25 != 1) goto L28;
        TextPaint r28 = r16.getPaint();
        q.f(r28, "tvTabTitle.paint");
        f(r28, r18);
        goto L28
    L17:
        r21 = this.B;
        goto L18
    L12:
        r19 = this.B;
        goto L13
    L9:
        r18 = false;
        goto L10
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void setCurrentTab(int r10) {
        int r11 = this.f16685e;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.W = true;
        this.f16689g = r11;
        this.f16685e = r10;
        Log.d("OTabSegmentedLayout", "setCurrentTab, currentTab: " + r10 + ", lastTab: " + this.f16689g);
        p(r10);
        setFragments(r10);
        if (this.f16703u == false) goto L8;
        i();
        return;
    L8:
        invalidate();
    }

    public final void setDividerColor(int r10) {
        this.f16705w = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.f16707y = j(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.f16706x = j(r10);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator r11 = this.V.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setEnabled(r10);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r10) {
        this.f16702t = r10;
    }

    public final void setIndicatorAnimEnable(boolean r10) {
        this.f16703u = r10;
    }

    public final void setIndicatorBounceEnable(boolean r10) {
        this.f16704v = r10;
    }

    public final void setIndicatorColor(int r10) {
        this.f16698p = r10;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r10) {
        this.f16700r = j(r10);
        invalidate();
    }

    public final void setIndicatorHeight(float r10) {
        this.f16699q = j(r10);
        invalidate();
    }

    public final void setOnTabSelectAnimListener(@Nullable TabSelectAnimListener r10) {
        this.f16684d0 = r10;
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r10) {
        this.f16682c0 = r10;
    }

    public final void setTabList(@NotNull List<View> r10) {
        q.g(r10, "<set-?>");
        this.V = r10;
    }

    public final void setTabPadding(float r10) {
        this.f16695m = j(r10);
        q();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f16696n = r10;
        q();
    }

    public final void setTabWidth(float r10) {
        this.f16697o = j(r10);
        q();
    }

    public final void setTextAllCaps(boolean r10) {
        this.D = r10;
        q();
    }

    public final void setTextBold(int r10) {
        this.C = r10;
        q();
    }

    public final void setTextSelectColor(int r10) {
        this.A = r10;
        q();
    }

    public final void setTextUnselectColor(int r10) {
        this.B = r10;
        q();
    }

    public final void setTextsize(float r10) {
        this.f16708z = o(r10);
        q();
    }

    @JvmOverloads
    public OTabSegmentedLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OTabSegmentedLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OTabSegmentedLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16687f = -1;
        this.f16691i = new Rect();
        this.f16692j = new Rect();
        this.f16693k = new Paint();
        this.f16694l = new Paint(1);
        this.f16702t = 350;
        this.f16703u = true;
        this.I = true;
        this.P = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.Q = new float[8];
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        this.R = r13;
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.STROKE);
        this.S = r14;
        this.T = new RectF();
        this.U = new RectF();
        this.V = new ArrayList();
        this.W = true;
        this.f16678a0 = new Paint(1);
        this.f16680b0 = new SparseArray();
        b r15 = new b(this);
        this.f16686e0 = r15;
        b r16 = new b(this);
        this.f16688f0 = r16;
        m();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f16677a = r10;
        LinearLayout r17 = new LinearLayout(r10);
        this.f16683d = r17;
        addView(r17);
        l(r10, r11);
        q.d(r11);
        String r18 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (q.b(r18, "-1") == false) goto L6;
    L9:
        ValueAnimator r19 = ValueAnimator.ofObject(new c(this), new Object[]{r16, r15});
        q.f(r19, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.O = r19;
        r19.addUpdateListener(this);
        r19.addListener(this);
        return;
    L6:
        if (q.b(r18, "-2") == true) goto L9;
        TypedArray r20 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        q.f(r20, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.H = r20.getDimensionPixelSize(0, -2);
        r20.recycle();
        goto L9
    }
}
