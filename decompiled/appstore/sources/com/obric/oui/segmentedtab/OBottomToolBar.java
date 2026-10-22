package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bg.h;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.l;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\u0018\u0000 \u008b\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0005_\u001e\u0018\u008c\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u000e*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b(\u0010&J\u0015\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b*\u0010\u0015J\u000f\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b/\u0010\u0019J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0016H\u0016¢\u0006\u0004\b1\u0010\u0019J\u0019\u00104\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0016H\u0016¢\u0006\u0004\b7\u0010\u0019J\u0017\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\u0015J\u0017\u0010<\u001a\u00020\u00162\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020\u000e2\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\bD\u0010EJ\u0011\u0010G\u001a\u0004\u0018\u00010FH\u0014¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020FH\u0014¢\u0006\u0004\bJ\u0010KJ\u0019\u0010N\u001a\u00020\u000e2\b\u0010M\u001a\u0004\u0018\u00010LH\u0014¢\u0006\u0004\bN\u0010OJ\u001f\u0010R\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0014¢\u0006\u0004\bR\u0010SJ7\u0010Y\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\bH\u0014¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010cR\u0016\u0010f\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010eR\u0016\u0010h\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010gR\u0016\u0010i\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010gR\u0016\u0010j\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010gR$\u0010o\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bl\u0010g\u001a\u0004\bm\u0010nR\u0014\u0010r\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010qR\u0016\u0010t\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010sR\u0016\u0010v\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010uR\u0016\u0010w\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010sR\u0016\u0010x\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010gR\u0016\u0010z\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010sR\u0016\u0010|\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010sR\u0016\u0010~\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010sR\u0017\u0010\u0080\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010gR\u0018\u0010\u0082\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010gR\u0018\u0010\u0084\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010gR\u0018\u0010\u0086\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010uR\u0018\u0010\u0088\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010gR\u0018\u0010\u008a\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010gR\u0018\u0010\u008c\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010sR\u0018\u0010\u008e\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010gR\u0018\u0010\u0090\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010uR\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R/\u0010\u0099\u0001\u001a\u0018\u0012\u0004\u0012\u00020+\u0018\u00010\u0095\u0001j\u000b\u0012\u0004\u0012\u00020+\u0018\u0001`\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u009c\u0001\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010 \u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¤\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R#\u0010©\u0001\u001a\f\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R#\u0010«\u0001\u001a\f\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010¨\u0001R\u0015\u0010¬\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010qR\u0016\u0010®\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010qR\u0018\u0010²\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0017\u0010³\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010±\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¶\u0001R\u0018\u0010»\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0001\u0010sR\u0018\u0010½\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u0010sR\u0018\u0010¿\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¾\u0001\u0010sR\u0018\u0010Á\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÀ\u0001\u0010sR\u0018\u0010Ã\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÂ\u0001\u0010uR\u0018\u0010Å\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÄ\u0001\u0010uR\u0017\u00106\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÆ\u0001\u0010uR\u0018\u0010È\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÇ\u0001\u0010gR\u0018\u0010Ê\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÉ\u0001\u0010sR0\u0010Ñ\u0001\u001a\t\u0012\u0004\u0012\u0002020Ë\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010¨\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\u0018\u0010Ó\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÒ\u0001\u0010uR\u0016\u0010Õ\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÔ\u0001\u0010qR \u0010Ù\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00160Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u001b\u0010Ü\u0001\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001c\u0010à\u0001\u001a\u00070Ý\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u001c\u0010â\u0001\u001a\u00070Ý\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0001\u0010ß\u0001R(\u0010ã\u0001\u001a\u00020\b2\u0007\u0010ã\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bä\u0001\u0010n\"\u0005\bå\u0001\u0010\u0015R*\u0010æ\u0001\u001a\u00020#2\u0007\u0010æ\u0001\u001a\u00020#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R)\u0010ì\u0001\u001a\u00020\u00162\u0007\u0010ë\u0001\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bì\u0001\u0010í\u0001\"\u0005\bî\u0001\u0010\u0019R*\u0010ï\u0001\u001a\u00020#2\u0007\u0010ï\u0001\u001a\u00020#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bð\u0001\u0010è\u0001\"\u0006\bñ\u0001\u0010ê\u0001R(\u0010ò\u0001\u001a\u00020\b2\u0007\u0010ò\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bó\u0001\u0010n\"\u0005\bô\u0001\u0010\u0015R*\u0010õ\u0001\u001a\u00020#2\u0007\u0010õ\u0001\u001a\u00020#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bö\u0001\u0010è\u0001\"\u0006\b÷\u0001\u0010ê\u0001R*\u0010ø\u0001\u001a\u00020#2\u0007\u0010ø\u0001\u001a\u00020#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bù\u0001\u0010è\u0001\"\u0006\bú\u0001\u0010ê\u0001R*\u0010þ\u0001\u001a\u00020#2\u0007\u0010û\u0001\u001a\u00020#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bü\u0001\u0010è\u0001\"\u0006\bý\u0001\u0010ê\u0001R(\u0010ÿ\u0001\u001a\u00020\b2\u0007\u0010ÿ\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0002\u0010n\"\u0005\b\u0081\u0002\u0010\u0015R(\u0010\u0082\u0002\u001a\u00020\b2\u0007\u0010\u0082\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0002\u0010n\"\u0005\b\u0084\u0002\u0010\u0015R(\u0010\u0085\u0002\u001a\u00020\b2\u0007\u0010\u0085\u0002\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0002\u0010n\"\u0005\b\u0087\u0002\u0010\u0015R)\u0010\u0089\u0002\u001a\u00020\u00162\u0007\u0010\u0088\u0002\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0089\u0002\u0010í\u0001\"\u0005\b\u008a\u0002\u0010\u0019¨\u0006\u008d\u0002"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/content/res/TypedArray;", "typedArray", "", "e", "(Landroid/content/Context;Landroid/content/res/TypedArray;)V", "f", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", SlideCard.KEY_INDEX, "setFragments", "(I)V", "", "pressed", "c", "(Z)V", "l", "()V", "Landroid/text/TextPaint;", "bold", "b", "(Landroid/text/TextPaint;Z)V", "position", "k", "h", "", "dp", "d", "(F)I", CloudControlInf.SP, "i", "insetBottom", "j", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "enabled", "setEnabled", "apply", "applyContentMaterial", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;", "listener", "setOnTabSelectListener", "(Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", WsConstants.KEY_CONNECTION_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/animation/ValueAnimator;", "p0", "onAnimationUpdate", "(Landroid/animation/ValueAnimator;)V", "a", "Landroid/content/Context;", "mContext", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mTabsContainer", "Lcom/obric/oui/layout/OUIFrameLayout;", "mContentRoot", "I", "mCurrentTab", "mPressedTab", "mLastTab", "<set-?>", "g", "getTabCount", "()I", "tabCount", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mDividerPaint", "F", "mTabPadding", "Z", "mTabSpaceEqual", "mTabWidth", "mDividerColor", "m", "mDividerWidth", "n", "mDividerPadding", "o", "mTextsize", "p", "mTextSelectColor", "q", "mTextUnselectColor", "r", "mTextBold", "s", "mTextAllCaps", "t", "mBarColor", "u", "mBarStrokeColor", "v", "mBarStrokeWidth", "w", "mHeight", FixCard.FixStyle.KEY_X, "mVibrateOnTabSelected", "Landroidx/fragment/app/FragmentManager;", FixCard.FixStyle.KEY_Y, "Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "z", "Ljava/util/ArrayList;", "mFragments", "A", "Landroid/animation/ValueAnimator;", "mValueAnimator", "Landroid/view/animation/PathInterpolator;", "B", "Landroid/view/animation/PathInterpolator;", "mInterpolator", "", "C", "[F", "mRadiusArr", "", "Lcom/obric/oui/common/style/Shadow;", "D", "Ljava/util/List;", "shadowsNormal", "E", "shadowsPressed", "barPaint", "G", "barStrokePaint", "Landroid/graphics/RectF;", "H", "Landroid/graphics/RectF;", "barRectF", "barStrokeRectF", "Ljb/d;", "J", "Ljb/d;", "pressAnim", "K", "releaseAnim", "L", "pressScale", "M", "animAccuracy", "N", "initScale", "O", "mIndicatorMinHeightScale", "P", "enableMaterial", "Q", "materialApplied", "R", "S", "materialSrcType", "T", "barCornerRadiusPx", "", "U", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "V", "mIsFirstDraw", "W", "mTextPaint", "Landroid/util/SparseArray;", "a0", "Landroid/util/SparseArray;", "mInitSetMap", "b0", "Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;", "mListener", "Lcom/obric/oui/segmentedtab/OBottomToolBar$b;", "c0", "Lcom/obric/oui/segmentedtab/OBottomToolBar$b;", "mCurrentP", "d0", "mLastP", "currentTab", "getCurrentTab", "setCurrentTab", "tabPadding", "getTabPadding", "()F", "setTabPadding", "(F)V", "tabSpaceEqual", "isTabSpaceEqual", "()Z", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextsize", "setTextsize", "textsize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textBold", "getTextBold", "setTextBold", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "e0", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomToolBar extends OUIFrameLayout implements MaterialOwner, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final a f16593e0 = null;
    public final ValueAnimator A;
    public final PathInterpolator B;
    public final float[] C;
    public List D;
    public List E;
    public final Paint F;
    public final Paint G;
    public final RectF H;
    public final RectF I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public jb.d f16594J;
    public jb.d K;
    public float L;
    public float M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public float T;
    public List U;
    public boolean V;
    public final Paint W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16595a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final SparseArray f16596a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f16597b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public TabSelectListener f16598b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OUIFrameLayout f16599c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final b f16600c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16601d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final b f16602d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f16606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f16611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f16612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f16613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16615q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16616r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16617s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16618t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f16619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f16620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f16622x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FragmentManager f16623y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList f16624z;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public float f16625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OBottomToolBar f16627c;

        public b(OBottomToolBar r10) {
            q.g(r10, "this$0");
            this.f16627c = r10;
        }

        public final float a() {
            return this.f16625a;
        }

        public final float b() {
            return this.f16626b;
        }

        public final void c(float r10) {
            this.f16625a = r10;
        }

        public final void d(float r10) {
            this.f16626b = r10;
        }

        public String toString() {
            return "(left = " + this.f16625a + ", right = " + this.f16626b + ')';
        }
    }

    public final class c implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomToolBar f16628a;

        public c(OBottomToolBar r10) {
            q.g(r10, "this$0");
            this.f16628a = r10;
        }

        public b a(float r10, b r11, b r12) {
            q.g(r11, "startValue");
            q.g(r12, "endValue");
            float r13 = r11.a() + ((r12.a() - r11.a()) * r10);
            float r14 = r11.b() + (r10 * (r12.b() - r11.b()));
            b r15 = new b(this.f16628a);
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
        f16593e0 = new a(null);
    }

    @JvmOverloads
    public OBottomToolBar(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ WindowInsets a(OBottomToolBar r10, View r11, WindowInsets r12) {
        return g(r10, r11, r12);
    }

    private final void c(boolean r10) {
        jb.d r11 = this.f16594J;
        if (r11 == null) goto L6;
        jb.d.c(r11, false, 1, null);
    L6:
        jb.d r12 = this.K;
        if (r12 == null) goto L10;
        jb.d.c(r12, false, 1, null);
    L10:
        if (r10 == false) goto L12;
        this.f16594J = ShadowAnimator.c(this, this.N, this.L, getCurrentShadows(), this.E);
        return;
    L12:
        this.K = ShadowAnimator.c(this, this.L, this.N, getCurrentShadows(), this.D);
    }

    private final int d(float r10) {
        return (int) ((r10 * this.f16595a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final void e(Context r10, TypedArray r11) {
        List r12 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_shadow_normal);
        if (r12 != null) goto L5;
        r12 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_oui_widgetShadowNormal);
    L5:
        if (r12 == null) goto L7;
        this.D = r12;
        q.d(r12);
        Shadow r13 = (Shadow) b0.a0(r12, 0);
        List r14 = this.D;
        q.d(r14);
        setShadow(r13, (Shadow) b0.a0(r14, 1));
    L7:
        List r15 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_shadow_pressed);
        if (r15 != null) goto L10;
        r15 = OUILayoutHelper.p(r10, r11, R$styleable.OTabLayout_oui_widgetShadowPressed);
    L10:
        if (r15 == null) goto L13;
        this.E = r15;
        return;
    }

    private final void f(Context r13, AttributeSet r14) {
        TypedArray r15 = r13.obtainStyledAttributes(r14, R$styleable.OTabLayout);
        q.f(r15, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.f16599c.addView(this.f16597b);
        this.f16611m = r15.getDimension(R$styleable.OTabLayout_divider_width, d(1.0f));
        this.f16612n = r15.getDimension(R$styleable.OTabLayout_divider_padding, 0.0f);
        this.f16613o = r15.getDimension(R$styleable.OTabLayout_tab_textSize, i(12.0f));
        this.f16614p = r15.getColor(R$styleable.OTabLayout_tab_textSelectColor, this.f16595a.getColor(R$color.oui_text_1));
        this.f16615q = r15.getColor(R$styleable.OTabLayout_tab_textUnselectColor, this.f16595a.getColor(R$color.oui_text_3b));
        boolean r10 = false;
        this.f16616r = r15.getInt(R$styleable.OTabLayout_tab_textBold, 0);
        this.f16617s = r15.getBoolean(R$styleable.OTabLayout_tab_textAllCaps, false);
        this.f16608j = r15.getBoolean(R$styleable.OTabLayout_tab_space_equal, true);
        float r11 = r15.getDimension(R$styleable.OTabLayout_tab_width, d(-1.0f));
        this.f16609k = r11;
        int r12 = R$styleable.OTabLayout_tab_padding;
        if (this.f16608j == false) goto L5;
    L8:
        int r16 = d(0.0f);
    L9:
        this.f16607i = r15.getDimension(r12, r16);
        int r17 = r15.getColor(R$styleable.OTabLayout_bar_color, -1);
        this.f16618t = r17;
        this.f16619u = r15.getColor(R$styleable.OTabLayout_bar_stroke_color, r17);
        this.f16620v = r15.getDimension(R$styleable.OTabLayout_bar_stroke_width, d(0.0f));
        this.f16622x = r15.getBoolean(R$styleable.OTabLayout_vibrate_on_tab_selected, false);
        e(r13, r15);
        if (r15.getBoolean(R$styleable.OTabLayout_oui_widgetFitInsetBottom, true) == false) goto L13;
        j(wd.a.i(this, null, true).f2559d);
        setOnApplyWindowInsetsListener(new com.obric.oui.segmentedtab.a(this));
    L13:
        if (this.P == false) goto L28;
        this.S = r15.getInt(R$styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        String r18 = r15.getString(R$styleable.OTabLayout_oui_widgetMaterial);
        if (r18 != null) goto L17;
        r18 = getResources().getString(R$string.oui_material_bg_floating);
    L17:
        com.obric.oui.material.b[] r19 = MaterialToken.parseSet(r18, !i.a(this));
        r15.recycle();
        if (r19 == null) goto L20;
        r10 = true;
    L20:
        this.P = r10;
        this.Q = r10;
        if (r10 == false) goto L28;
        if (r19 == null) goto L28;
        int r20 = this.S;
        if (r20 == (-1)) goto L27;
        o.j(this.f16599c, r19, false, r20, null, 10, null);
        goto L28
    L27:
        o.j(this.f16599c, r19, false, 0, null, 14, null);
    L28:
        setShadowCornerRadius(f.r(this, 99));
        return;
    L5:
        if (r11 > 0.0f) goto L8;
        r16 = d(10.0f);
        goto L9
    }

    public static final WindowInsets g(OBottomToolBar r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "$noName_0");
        q.g(r12, "insets");
        r10.j(wd.a.i(r10, r12, true).f2559d);
        return r12;
    }

    private final int i(float r10) {
        return (int) ((r10 * this.f16595a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void k(int r10) {
        int r11 = this.f16605g;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L29;
        int r13 = r12 + 1;
        View r14 = this.f16597b.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r15 = true;
    L8:
        View r16 = r14.findViewById(R$id.tv_tab_title_small);
        if (r16 == null) goto L28;
        TextView r17 = (TextView) r16;
        ImageView r18 = (ImageView) r14.findViewById(R$id.tv_tab_icon_small);
        if (r15 == false) goto L14;
        int r19 = this.f16614p;
    L15:
        r18.setImageTintList(ColorStateList.valueOf(r19));
        if (this.f16616r != 1) goto L18;
        TextPaint r20 = r17.getPaint();
        q.f(r20, "tabTitle.paint");
        b(r20, r15);
        r17.invalidate();
    L18:
        td.c r21 = td.c.f24796a;
        if ((r14 instanceof OSegmentTabMiniView) == true) goto L22;
        r14 = null;
    L22:
        OSegmentTabMiniView r22 = (OSegmentTabMiniView) r14;
        if (r22 == null) goto L26;
        r22.o(r15);
    L26:
        r12 = r13;
        goto L3
    L14:
        r19 = this.f16615q;
        goto L15
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        r15 = false;
        goto L8
    }

    private final void l() {
        int r10 = this.f16605g;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L31;
        int r12 = r11 + 1;
        View r13 = this.f16597b.getChildAt(r11);
        float r14 = this.f16607i;
        r13.setPadding((int) r14, 0, (int) r14, 0);
        View r15 = r13.findViewById(R$id.tv_tab_title_small);
        if (r15 == null) goto L30;
        TextView r16 = (TextView) r15;
        int r17 = this.f16601d;
        if (r11 != r17) goto L9;
        boolean r18 = true;
    L10:
        if (r11 != r17) goto L12;
        int r19 = this.f16614p;
    L13:
        r16.setTextColor(r19);
        r16.setTextSize(0, this.f16613o);
        ImageView r20 = (ImageView) r13.findViewById(R$id.tv_tab_icon_small);
        if (r11 != this.f16601d) goto L17;
        int r21 = this.f16614p;
    L18:
        r20.setImageTintList(ColorStateList.valueOf(r21));
        if (this.f16617s == false) goto L21;
        String r22 = r16.getText().toString();
        Locale r23 = Locale.ROOT;
        q.f(r23, "ROOT");
        String r24 = r22.toUpperCase(r23);
        q.f(r24, "this as java.lang.String).toUpperCase(locale)");
        r16.setText(r24);
    L21:
        int r25 = this.f16616r;
        if (r25 != 2) goto L24;
        TextPaint r26 = r16.getPaint();
        q.f(r26, "tvTabTitle.paint");
        b(r26, true);
    L28:
        r11 = r12;
        goto L3
    L24:
        if (r25 != 0) goto L26;
        TextPaint r27 = r16.getPaint();
        q.f(r27, "tvTabTitle.paint");
        b(r27, false);
        goto L28
    L26:
        if (r25 != 1) goto L28;
        TextPaint r28 = r16.getPaint();
        q.f(r28, "tvTabTitle.paint");
        b(r28, r18);
        goto L28
    L17:
        r21 = this.f16615q;
        goto L18
    L12:
        r19 = this.f16615q;
        goto L13
    L9:
        r18 = false;
        goto L10
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void setFragments(int r10) {
        ArrayList r11 = this.f16624z;
        if (r11 == null) goto L17;
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        int r14 = r13 + 1;
        FragmentManager r15 = this.f16623y;
        q.d(r15);
        FragmentTransaction r16 = r15.o();
        q.f(r16, "mFragmentManager!!.beginTransaction()");
        ArrayList r17 = this.f16624z;
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
        this.f16601d = r10;
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        this.Q = r10;
        com.obric.oui.material.f.b(this.f16599c, r10, this.R);
        invalidate();
    }

    public final void b(TextPaint r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 700;
    L5:
        r10.setTypeface(Typeface.create(null, r12, false));
        return;
    L4:
        r12 = 400;
        goto L5
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        int r11 = r10.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        c(false);
    L11:
        return super.dispatchTouchEvent(r10);
    L6:
        if (r11 == 3) goto L8;
    L9:
        c(true);
        goto L11
    }

    @Nullable
    public final Fragment getCurrentFragment() {
        ArrayList r10 = this.f16624z;
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Fragment) r10.get(this.f16601d);
    }

    public final int getCurrentTab() {
        return this.f16601d;
    }

    public final int getDividerColor() {
        return this.f16610l;
    }

    public final float getDividerPadding() {
        return this.f16612n;
    }

    public final float getDividerWidth() {
        return this.f16611m;
    }

    public final int getTabCount() {
        return this.f16605g;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.U;
    }

    public final float getTabPadding() {
        return this.f16607i;
    }

    public final float getTabWidth() {
        return this.f16609k;
    }

    public final int getTextBold() {
        return this.f16616r;
    }

    public final int getTextSelectColor() {
        return this.f16614p;
    }

    public final int getTextUnselectColor() {
        return this.f16615q;
    }

    public final float getTextsize() {
        return this.f16613o;
    }

    public final void h() {
        this.T = f.r(this, 99);
    }

    public final void j(int r10) {
        i.d(this, h.d(0, r10));
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        q.g(r10, "p0");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        h();
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        q.g(r13, "canvas");
        super.onDraw(r13);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f16605g <= 0) goto L21;
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        if (this.Q == true) goto L11;
        this.F.setColor(this.f16618t);
        this.H.set(0.0f, getPaddingTop(), getWidth(), r10 - getPaddingBottom());
        l.i(r13, this.H, this.T, this.F);
    L11:
        if (this.f16620v <= 0.0f) goto L13;
        this.G.setColor(this.f16619u);
        this.G.setStrokeWidth(this.f16620v);
        float r12 = 2;
        this.I.set(this.f16620v / r12, getPaddingTop() + (this.f16620v / r12), getWidth() - (this.f16620v / r12), (r10 - getPaddingBottom()) - (this.f16620v / r12));
    L13:
        float r14 = this.f16611m;
        if (r14 <= 0.0f) goto L20;
        this.f16606h.setStrokeWidth(r14);
        this.f16606h.setColor(this.f16610l);
        int r15 = this.f16605g - 1;
        int r16 = 0;
    L16:
        if (r16 >= r15) goto L22;
        int r17 = r16 + 1;
        View r18 = this.f16597b.getChildAt(r16);
        r13.drawLine(r18.getRight() + r11, this.f16612n, r18.getRight() + r11, r10 - this.f16612n, this.f16606h);
        r16 = r17;
        goto L16
    L22:
        return;
    L20:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        if ((r10 instanceof Bundle) == false) goto L9;
        Bundle r11 = (Bundle) r10;
        this.f16601d = r11.getInt("mCurrentTab");
        r10 = r11.getParcelable("instanceState");
        if (this.f16601d == 0) goto L9;
        if (this.f16597b.getChildCount() <= 0) goto L9;
        k(this.f16601d);
    L9:
        super.onRestoreInstanceState(r10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r10 = new Bundle();
        r10.putParcelable("instanceState", super.onSaveInstanceState());
        r10.putInt("mCurrentTab", this.f16601d);
        return r10;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        o.n(this.f16599c, r10);
    }

    public final void setCurrentTab(int r10) {
        int r11 = this.f16601d;
        if (r10 != r11) goto L5;
        return;
    L5:
        this.f16604f = r11;
        this.f16601d = r10;
        k(r10);
        setFragments(r10);
    }

    public final void setDividerColor(int r10) {
        this.f16610l = r10;
        invalidate();
    }

    public final void setDividerPadding(float r10) {
        this.f16612n = d(r10);
        invalidate();
    }

    public final void setDividerWidth(float r10) {
        this.f16611m = d(r10);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator r11 = this.U.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((View) r11.next()).setEnabled(r10);
        goto L4
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r10) {
        this.f16598b0 = r10;
    }

    public final void setTabList(@NotNull List<View> r10) {
        q.g(r10, "<set-?>");
        this.U = r10;
    }

    public final void setTabPadding(float r10) {
        this.f16607i = d(r10);
        l();
    }

    public final void setTabSpaceEqual(boolean r10) {
        this.f16608j = r10;
        l();
    }

    public final void setTabWidth(float r10) {
        this.f16609k = d(r10);
        l();
    }

    public final void setTextAllCaps(boolean r10) {
        this.f16617s = r10;
        l();
    }

    public final void setTextBold(int r10) {
        this.f16616r = r10;
        l();
    }

    public final void setTextSelectColor(int r10) {
        this.f16614p = r10;
        l();
    }

    public final void setTextUnselectColor(int r10) {
        this.f16615q = r10;
        l();
    }

    public final void setTextsize(float r10) {
        this.f16613o = i(r10);
        l();
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.S = r10;
        o.p(this.f16599c, r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.R == r10) goto L9;
        this.R = r10;
        if (this.S == (-1)) goto L7;
        return;
    L7:
        o.q(this.f16599c, r10);
        return;
    }

    @JvmOverloads
    public OBottomToolBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBottomToolBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBottomToolBar(@NotNull Context r11, @Nullable AttributeSet r12, int r13) {
        q.g(r11, "context");
        super(r11, r12, r13, null, 8, null);
        this.f16603e = -1;
        boolean r10 = true;
        this.f16606h = new Paint(1);
        this.B = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.C = new float[8];
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.FILL);
        this.F = r14;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.STROKE);
        this.G = r15;
        this.H = new RectF();
        this.I = new RectF();
        this.L = 0.988f;
        this.M = 0.01f;
        this.N = 1.0f;
        this.O = 0.85f;
        this.S = -1;
        this.U = new ArrayList();
        this.V = true;
        this.W = new Paint(1);
        this.f16596a0 = new SparseArray();
        b r16 = new b(this);
        this.f16600c0 = r16;
        b r17 = new b(this);
        this.f16602d0 = r17;
        h();
        setWillNotDraw(false);
        if (o.f(this) == true) goto L5;
    L7:
        r10 = false;
    L8:
        this.P = r10;
        this.Q = r10;
        setClipChildren(false);
        setClipToPadding(false);
        this.f16595a = r11;
        this.f16597b = new LinearLayout(r11);
        OUIFrameLayout r18 = new OUIFrameLayout(r11, null, 0, null, 14, null);
        this.f16599c = r18;
        r18.setRadius(f.r(this, 99));
        addView(this.f16599c);
        f(r11, r12);
        q.d(r12);
        String r19 = r12.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (q.b(r19, "-1") == false) goto L12;
    L15:
        ValueAnimator r110 = ValueAnimator.ofObject(new c(this), new Object[]{r17, r16});
        q.f(r110, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.A = r110;
        r110.addUpdateListener(this);
        return;
    L12:
        if (q.b(r19, "-2") == true) goto L15;
        TypedArray r111 = r11.obtainStyledAttributes(r12, new int[]{R.attr.layout_height});
        q.f(r111, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.f16621w = r111.getDimensionPixelSize(0, -2);
        r111.recycle();
        goto L15
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        goto L7
    }
}
