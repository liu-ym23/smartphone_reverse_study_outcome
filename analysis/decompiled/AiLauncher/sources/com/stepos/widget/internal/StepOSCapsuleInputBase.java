package com.stepos.widget.internal;

import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassRebuildScheduler;
import com.stepos.widget.glass.GlassThemeKt;
import com.stepos.widget.glass.StepOSGlassPresets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.B;
import y7.o;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\b'\u0018\u0000 §\u00022\u00020\u0001:\b¨\u0002©\u0002ª\u0002§\u0002BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u0011\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020%H\u0002¢\u0006\u0004\b4\u0010'J\u000f\u00105\u001a\u00020%H\u0002¢\u0006\u0004\b5\u0010'J\u0011\u00106\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u0004\u0018\u000108*\u00020\u0002H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020%H\u0002¢\u0006\u0004\b;\u0010'J\u0017\u0010=\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001a0?H$¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001a0?H$¢\u0006\u0004\bB\u0010AJ\u000f\u0010C\u001a\u00020%H$¢\u0006\u0004\bC\u0010'J\u000f\u0010D\u001a\u00020\u0017H$¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020%H$¢\u0006\u0004\bF\u0010'J\u0017\u0010I\u001a\u00020%2\u0006\u0010H\u001a\u00020GH\u0014¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020%H\u0014¢\u0006\u0004\bK\u0010'J\u000f\u0010L\u001a\u00020%H\u0014¢\u0006\u0004\bL\u0010'J\u000f\u0010M\u001a\u00020%H\u0014¢\u0006\u0004\bM\u0010'J\u000f\u0010N\u001a\u00020%H\u0014¢\u0006\u0004\bN\u0010'J\u0017\u0010P\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u001aH\u0014¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0006H\u0004¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0011H\u0004¢\u0006\u0004\bT\u0010UJ\u001f\u0010Y\u001a\u00020%2\u0006\u0010V\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020WH\u0004¢\u0006\u0004\bY\u0010ZJ\u001b\u0010[\u001a\u0004\u0018\u0001012\b\u0010\u0010\u001a\u0004\u0018\u000101H\u0004¢\u0006\u0004\b[\u0010\\J)\u0010_\u001a\u00020%2\u0006\u0010O\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b_\u0010`J\u0019\u0010a\u001a\u00020%2\b\u0010V\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\ba\u0010bJ'\u0010c\u001a\u00020%2\u0006\u0010O\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0011H\u0004¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020%H\u0004¢\u0006\u0004\be\u0010'J\u0017\u0010f\u001a\u00020%2\u0006\u0010O\u001a\u00020\u001aH\u0014¢\u0006\u0004\bf\u0010bJ\u0019\u0010h\u001a\u00020%2\b\u0010g\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\bh\u0010iJ\u0011\u0010j\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\bj\u00103J/\u0010o\u001a\u00020%2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u0006H\u0016¢\u0006\u0004\bo\u0010pJ/\u0010s\u001a\u00020%2\u0006\u0010q\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u0006H\u0016¢\u0006\u0004\bs\u0010pJ\u000f\u0010t\u001a\u00020%H\u0004¢\u0006\u0004\bt\u0010'J\u0019\u0010v\u001a\u00020%2\b\b\u0001\u0010u\u001a\u00020\u0006H\u0005¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020%2\u0006\u0010x\u001a\u00020\u0017H\u0004¢\u0006\u0004\by\u0010zJ\u0017\u0010|\u001a\u00020%2\b\b\u0001\u0010{\u001a\u00020\u0006¢\u0006\u0004\b|\u0010wJ\u0017\u0010}\u001a\u00020%2\b\b\u0001\u0010{\u001a\u00020\u0006¢\u0006\u0004\b}\u0010wJ\u0017\u0010~\u001a\u00020%2\b\b\u0001\u0010{\u001a\u00020\u0006¢\u0006\u0004\b~\u0010wJ\u000f\u0010\u007f\u001a\u00020%H\u0004¢\u0006\u0004\b\u007f\u0010'J\u001c\u0010\u0082\u0001\u001a\u00020\u00172\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020%H\u0004¢\u0006\u0005\b\u0084\u0001\u0010'J?\u0010\u008a\u0001\u001a\u00020%2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00020%H\u0014¢\u0006\u0005\b\u008c\u0001\u0010'J\u0011\u0010\u008d\u0001\u001a\u00020%H\u0014¢\u0006\u0005\b\u008d\u0001\u0010'J\u0019\u0010\u008e\u0001\u001a\u00020%2\u0006\u0010H\u001a\u00020GH\u0014¢\u0006\u0005\b\u008e\u0001\u0010JJ\u0011\u0010\u008f\u0001\u001a\u00020\u0017H\u0004¢\u0006\u0005\b\u008f\u0001\u0010EJ\u0011\u0010\u0090\u0001\u001a\u00020%H\u0004¢\u0006\u0005\b\u0090\u0001\u0010'J\u0011\u0010\u0091\u0001\u001a\u00020%H\u0004¢\u0006\u0005\b\u0091\u0001\u0010'J\u0011\u0010\u0092\u0001\u001a\u00020\u0017H\u0014¢\u0006\u0005\b\u0092\u0001\u0010EJ\u0011\u0010\u0093\u0001\u001a\u00020%H\u0004¢\u0006\u0005\b\u0093\u0001\u0010'R%\u0010\t\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\t\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010S\"\u0005\b\u0096\u0001\u0010wR\u001c\u0010\n\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\u000e\n\u0005\b\n\u0010\u0094\u0001\u001a\u0005\b\u0097\u0001\u0010SR\u001c\u0010\u000b\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\u000e\n\u0005\b\u000b\u0010\u0094\u0001\u001a\u0005\b\u0098\u0001\u0010SR\u001c\u0010\f\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\u000e\n\u0005\b\f\u0010\u0094\u0001\u001a\u0005\b\u0099\u0001\u0010SR'\u0010\u009a\u0001\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0005\b\u009c\u0001\u0010E\"\u0005\b\u009d\u0001\u0010zR\u0017\u0010\u009e\u0001\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0094\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R$\u0010¥\u0001\u001a\u00070¤\u0001R\u00020\u00008\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010ª\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0019\u0010°\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u009b\u0001R\u0018\u0010±\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010£\u0001R\u0018\u0010³\u0001\u001a\u00030²\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R)\u0010µ\u0001\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bµ\u0001\u0010 \u0001\u001a\u0005\b¶\u0001\u00103\"\u0005\b·\u0001\u0010iR\u001f\u0010¸\u0001\u001a\u00020<8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001R\u001f\u0010¼\u0001\u001a\u00020<8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¼\u0001\u0010¹\u0001\u001a\u0006\b½\u0001\u0010»\u0001R\u001c\u0010¿\u0001\u001a\u00070¾\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R)\u0010Á\u0001\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÁ\u0001\u0010 \u0001\u001a\u0005\bÂ\u0001\u00103\"\u0005\bÃ\u0001\u0010iR)\u0010Ä\u0001\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÄ\u0001\u0010 \u0001\u001a\u0005\bÅ\u0001\u00103\"\u0005\bÆ\u0001\u0010iR)\u0010Ç\u0001\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÇ\u0001\u0010 \u0001\u001a\u0005\bÈ\u0001\u00103\"\u0005\bÉ\u0001\u0010iR,\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R,\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ó\u0001\u001a\u0006\bÙ\u0001\u0010Õ\u0001\"\u0006\bÚ\u0001\u0010×\u0001R'\u0010Û\u0001\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÛ\u0001\u0010\u009b\u0001\u001a\u0005\bÜ\u0001\u0010E\"\u0005\bÝ\u0001\u0010zR'\u0010Þ\u0001\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÞ\u0001\u0010\u009b\u0001\u001a\u0005\bß\u0001\u0010E\"\u0005\bà\u0001\u0010zR'\u0010á\u0001\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bá\u0001\u0010\u009b\u0001\u001a\u0005\bâ\u0001\u0010E\"\u0005\bã\u0001\u0010zR*\u0010ä\u0001\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\bä\u0001\u0010å\u0001\u001a\u0005\bæ\u0001\u0010*\"\u0006\bç\u0001\u0010è\u0001R*\u0010é\u0001\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0005\bë\u0001\u0010-\"\u0006\bì\u0001\u0010í\u0001R,\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R \u0010ö\u0001\u001a\u00030õ\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001R\u0017\u0010ú\u0001\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0018\u0010ý\u0001\u001a\u00030ü\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u0017\u0010\u0083\u0002\u001a\u00020W8$X¤\u0004¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0016\u0010\u0085\u0002\u001a\u00020\u001a8$X¤\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0002\u00107R\u0017\u0010\u0088\u0002\u001a\u00020\u00148eX¤\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0016\u0010\u008a\u0002\u001a\u00020\u00068eX¤\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0002\u0010SR\u0016\u0010\u008c\u0002\u001a\u00020\u00068EX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0002\u0010SR\u0017\u0010\u008e\u0002\u001a\u0005\u0018\u00010î\u00018G¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010ò\u0001R,\u0010\u0092\u0002\u001a\u0004\u0018\u0001012\t\u0010\u008f\u0002\u001a\u0004\u0018\u0001018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0002\u00103\"\u0005\b\u0091\u0002\u0010iR,\u0010\u0095\u0002\u001a\u0004\u0018\u0001012\t\u0010\u008f\u0002\u001a\u0004\u0018\u0001018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0002\u00103\"\u0005\b\u0094\u0002\u0010iR,\u0010\u0098\u0002\u001a\u0004\u0018\u0001012\t\u0010\u008f\u0002\u001a\u0004\u0018\u0001018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0002\u00103\"\u0005\b\u0097\u0002\u0010iR(\u0010\u0099\u0002\u001a\u00020\u00172\u0007\u0010\u008f\u0002\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0002\u0010E\"\u0005\b\u0097\u0002\u0010zR(\u0010\u009a\u0002\u001a\u00020\u00172\u0007\u0010\u008f\u0002\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0002\u0010E\"\u0005\b\u009b\u0002\u0010zR0\u0010\u009e\u0002\u001a\u0005\u0018\u00010Ê\u00012\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010Ê\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0002\u0010Î\u0001\"\u0006\b\u009d\u0002\u0010Ð\u0001R0\u0010¡\u0002\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010Ñ\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009f\u0002\u0010Õ\u0001\"\u0006\b \u0002\u0010×\u0001R0\u0010¤\u0002\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010Ñ\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¢\u0002\u0010Õ\u0001\"\u0006\b£\u0002\u0010×\u0001R(\u0010¥\u0002\u001a\u00020\u00172\u0007\u0010\u008f\u0002\u001a\u00020\u00178G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¥\u0002\u0010E\"\u0005\b¦\u0002\u0010z¨\u0006«\u0002"}, d2 = {"Lcom/stepos/widget/internal/StepOSCapsuleInputBase;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "inputHeight", "slotSize", "iconSize", "iconTextSpacing", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IIIIII)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "Landroid/widget/LinearLayout$LayoutParams;", "editTextLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/LinearLayout$LayoutParams;", "", "x", "y", "", "isPointInCapsule", "(FF)Z", "Landroid/view/View;", "target", "Landroid/graphics/Rect;", "expandedTouchBounds", "(Landroid/view/View;)Landroid/graphics/Rect;", "currentStart", "currentEnd", "parentSize", "Lkotlin/Pair;", "expandAxisWithinParent", "(III)Lkotlin/Pair;", "LY8/t;", "applyCapsuleGlass", "()V", "Ly7/o;", "defaultLocalGlassEffect", "()Ly7/o;", "Lcom/stepos/widget/glass/GlassCustomizer;", "defaultTunedGlassCustomizer", "()Lcom/stepos/widget/glass/GlassCustomizer;", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$AppliedGlassRequest;", "glassMaterialRequest", "()Lcom/stepos/widget/internal/StepOSCapsuleInputBase$AppliedGlassRequest;", "Landroid/graphics/drawable/Drawable;", "createCapsuleGlassCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "showCapsuleCover", "cancelCapsuleCover", "activityContentView", "()Landroid/view/View;", "Landroid/app/Activity;", "getActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "scheduleCapsuleCoverReveal", "Landroid/widget/ImageView;", "createIconSlot", "(Landroid/content/Context;)Landroid/widget/ImageView;", "", "touchDelegateSlots", "()Ljava/util/List;", "pressScaleTargets", "applyCapsuleSurface", "shouldApplyLocalGlass", "()Z", "applyIcons", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChangedExtra", "(Landroid/content/res/Configuration;)V", "onAttachedToWindowExtra", "onDetachedFromWindowExtra", "onLayoutExtra", "onEditTextRemoved", "child", "isExtraSlot", "(Landroid/view/View;)Z", "slotInset", "()I", "slotLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "view", "", "attrName", "warnIfUnlabeled", "(Landroid/view/View;Ljava/lang/String;)V", "copyDrawable", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "index", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "removeView", "(Landroid/view/View;)V", "addStructuralView", "(Landroid/view/View;ILandroid/widget/LinearLayout$LayoutParams;)V", "syncClearButton", "handleCapsuleChildRemoved", "background", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "getBackground", "left", "top", "right", "bottom", "setPadding", "(IIII)V", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "setPaddingRelative", "applyCapsuleFlatSurface", "color", "setCapsuleFlatSurfaceOverride", "(I)V", "enable", "applyCapsuleFlatElevation", "(Z)V", "resId", "setStartIconResource", "setEndIconResource", "setEndIconActivatedResource", "applyPressScale", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "refreshTouchDelegates", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", "onAttachedToWindow", "onDetachedFromWindow", "onConfigurationChanged", "isDarkMode", "releaseCapsuleGlass", "requestCapsuleGlassRefresh", "deferCapsuleCoverRevealToHost", "revealCapsuleCoverNow", "I", "getInputHeight", "setInputHeight", "getSlotSize", "getIconSize", "getIconTextSpacing", "constructed", "Z", "getConstructed", "setConstructed", "minTouchTarget", "coverCapsuleSurface", "Landroid/graphics/drawable/Drawable;", "Ljava/lang/Runnable;", "revealCapsuleCoverRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CapsuleLayout;", "capsuleLayout", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CapsuleLayout;", "getCapsuleLayout", "()Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CapsuleLayout;", "Lcom/stepos/widget/glass/GlassDelegate;", "capsuleGlassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "appliedCapsuleGlassRequest", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$AppliedGlassRequest;", "appliedCapsuleCornerRadius", "F", "capsuleGlassRefreshPosted", "capsuleGlassRefreshRunnable", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "capsuleGlassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "capsuleFallbackBackground", "getCapsuleFallbackBackground", "setCapsuleFallbackBackground", "startIconView", "Landroid/widget/ImageView;", "getStartIconView", "()Landroid/widget/ImageView;", "endIconView", "getEndIconView", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CompositeTouchDelegate;", "touchDelegates", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CompositeTouchDelegate;", "startIconValue", "getStartIconValue", "setStartIconValue", "endIconValue", "getEndIconValue", "setEndIconValue", "endIconActivatedValue", "getEndIconActivatedValue", "setEndIconActivatedValue", "Landroid/content/res/ColorStateList;", "iconTintValue", "Landroid/content/res/ColorStateList;", "getIconTintValue", "()Landroid/content/res/ColorStateList;", "setIconTintValue", "(Landroid/content/res/ColorStateList;)V", "", "endIconContentDescriptionValue", "Ljava/lang/CharSequence;", "getEndIconContentDescriptionValue", "()Ljava/lang/CharSequence;", "setEndIconContentDescriptionValue", "(Ljava/lang/CharSequence;)V", "endIconActivatedContentDescriptionValue", "getEndIconActivatedContentDescriptionValue", "setEndIconActivatedContentDescriptionValue", "endIconActivatedFlag", "getEndIconActivatedFlag", "setEndIconActivatedFlag", "autoClearButtonEnabledValue", "getAutoClearButtonEnabledValue", "setAutoClearButtonEnabledValue", "pressScaleEnabledValue", "getPressScaleEnabledValue", "setPressScaleEnabledValue", "glassEffectOverride", "Ly7/o;", "getGlassEffectOverride", "setGlassEffectOverride", "(Ly7/o;)V", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "getGlassCustomizer", "setGlassCustomizer", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "Landroid/widget/EditText;", "editTextValue", "Landroid/widget/EditText;", "getEditTextValue", "()Landroid/widget/EditText;", "setEditTextValue", "(Landroid/widget/EditText;)V", "Landroid/text/TextWatcher;", "queryWatcher", "Landroid/text/TextWatcher;", "getQueryWatcher", "()Landroid/text/TextWatcher;", "capsuleHitRect", "Landroid/graphics/Rect;", "Landroid/view/ViewOutlineProvider;", "capsulePillOutlineProvider", "Landroid/view/ViewOutlineProvider;", "capsuleFlatSurfaceColorOverride", "Ljava/lang/Integer;", "getWidgetLogTag", "()Ljava/lang/String;", "widgetLogTag", "getEditTextInsertAnchor", "editTextInsertAnchor", "getCapsuleFlatElevationPx", "()F", "capsuleFlatElevationPx", "getCapsuleFlatSurfaceColor", "capsuleFlatSurfaceColor", "getEffectiveCapsuleFlatSurfaceColor", "effectiveCapsuleFlatSurfaceColor", "getEditText", "editText", UxipConstants.f30680s, "getStartIcon", "setStartIcon", "startIcon", "getEndIcon", "setEndIcon", "endIcon", "getEndIconActivated", "setEndIconActivated", "endIconActivated", "isEndIconActivated", "isAutoClearButtonEnabled", "setAutoClearButtonEnabled", "getIconTint", "setIconTint", "iconTint", "getEndIconContentDescription", "setEndIconContentDescription", "endIconContentDescription", "getEndIconActivatedContentDescription", "setEndIconActivatedContentDescription", "endIconActivatedContentDescription", "isPressScaleEnabled", "setPressScaleEnabled", "Companion", "CompositeTouchDelegate", "AppliedGlassRequest", "CapsuleLayout", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSCapsuleInputBase extends LinearLayout {
    protected static final Companion Companion = new Companion(null);
    private static final String FLASH_TAG = "StepOSGlassFlash";
    private static final float MIN_TOUCH_TARGET_DP = 48.0f;
    private float appliedCapsuleCornerRadius;
    private AppliedGlassRequest appliedCapsuleGlassRequest;
    private boolean autoClearButtonEnabledValue;
    private Drawable capsuleFallbackBackground;
    private Integer capsuleFlatSurfaceColorOverride;
    private final GlassDelegate capsuleGlassDelegate;
    private final GlassRebuildScheduler capsuleGlassRebuild;
    private boolean capsuleGlassRefreshPosted;
    private final Runnable capsuleGlassRefreshRunnable;
    private final Rect capsuleHitRect;
    private final CapsuleLayout capsuleLayout;
    private final ViewOutlineProvider capsulePillOutlineProvider;
    private boolean constructed;
    private Drawable coverCapsuleSurface;
    private EditText editTextValue;
    private CharSequence endIconActivatedContentDescriptionValue;
    private boolean endIconActivatedFlag;
    private Drawable endIconActivatedValue;
    private CharSequence endIconContentDescriptionValue;
    private Drawable endIconValue;
    private final ImageView endIconView;
    private GlassCustomizer glassCustomizer;
    private o glassEffectOverride;
    private final int iconSize;
    private final int iconTextSpacing;
    private ColorStateList iconTintValue;
    private int inputHeight;
    private final int minTouchTarget;
    private boolean pressScaleEnabledValue;
    private final TextWatcher queryWatcher;
    private final Runnable revealCapsuleCoverRunnable;
    private final int slotSize;
    private Drawable startIconValue;
    private final ImageView startIconView;
    private final CompositeTouchDelegate touchDelegates;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010\u000f¨\u0006!"}, d2 = {"Lcom/stepos/widget/internal/StepOSCapsuleInputBase$AppliedGlassRequest;", "", "", "darkMode", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(ZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()Z", "component2", "()Ly7/o;", "component3", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(ZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/internal/StepOSCapsuleInputBase$AppliedGlassRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDarkMode", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AppliedGlassRequest {
        private final GlassCustomizer customizer;
        private final boolean darkMode;
        private final o effect;

        public AppliedGlassRequest(boolean z10, o oVar, GlassCustomizer glassCustomizer) {
            this.darkMode = z10;
            this.effect = oVar;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ AppliedGlassRequest copy$default(AppliedGlassRequest appliedGlassRequest, boolean z10, o oVar, GlassCustomizer glassCustomizer, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = appliedGlassRequest.darkMode;
            }
            if ((i10 & 2) != 0) {
                oVar = appliedGlassRequest.effect;
            }
            if ((i10 & 4) != 0) {
                glassCustomizer = appliedGlassRequest.customizer;
            }
            return appliedGlassRequest.copy(z10, oVar, glassCustomizer);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* renamed from: component2, reason: from getter */
        public final o getEffect() {
            return this.effect;
        }

        /* renamed from: component3, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final AppliedGlassRequest copy(boolean darkMode, o effect, GlassCustomizer customizer) {
            return new AppliedGlassRequest(darkMode, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppliedGlassRequest)) {
                return false;
            }
            AppliedGlassRequest appliedGlassRequest = (AppliedGlassRequest) other;
            return this.darkMode == appliedGlassRequest.darkMode && p.d(this.effect, appliedGlassRequest.effect) && p.d(this.customizer, appliedGlassRequest.customizer);
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final o getEffect() {
            return this.effect;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.darkMode) * 31;
            o oVar = this.effect;
            int iHashCode2 = (iHashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode2 + (glassCustomizer != null ? glassCustomizer.hashCode() : 0);
        }

        public String toString() {
            return "AppliedGlassRequest(darkMode=" + this.darkMode + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CapsuleLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Lcom/stepos/widget/internal/StepOSCapsuleInputBase;Landroid/content/Context;)V", "Landroid/view/View;", "child", "LY8/t;", "onViewRemoved", "(Landroid/view/View;)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class CapsuleLayout extends LinearLayout {
        final /* synthetic */ StepOSCapsuleInputBase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CapsuleLayout(StepOSCapsuleInputBase stepOSCapsuleInputBase, Context context) {
            super(context);
            p.i(context, "context");
            this.this$0 = stepOSCapsuleInputBase;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            p.i(canvas, "canvas");
            Drawable drawable = this.this$0.coverCapsuleSurface;
            if (drawable != null) {
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.draw(canvas);
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.ViewGroup
        public void onViewRemoved(View child) {
            p.i(child, "child");
            super.onViewRemoved(child);
            this.this$0.handleCapsuleChildRemoved(child);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0084\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/widget/internal/StepOSCapsuleInputBase$Companion;", "", "<init>", "()V", "MIN_TOUCH_TARGET_DP", "", "FLASH_TAG", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/widget/internal/StepOSCapsuleInputBase$CompositeTouchDelegate;", "Landroid/view/TouchDelegate;", "<init>", "(Lcom/stepos/widget/internal/StepOSCapsuleInputBase;)V", "", "list", "LY8/t;", "setDelegates", "(Ljava/util/List;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "delegates", "Ljava/util/ArrayList;", "captured", "Landroid/view/TouchDelegate;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class CompositeTouchDelegate extends TouchDelegate {
        private TouchDelegate captured;
        private final ArrayList<TouchDelegate> delegates;

        public CompositeTouchDelegate() {
            super(new Rect(), StepOSCapsuleInputBase.this);
            this.delegates = new ArrayList<>(4);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent event) {
            List listE;
            p.i(event, "event");
            float x10 = event.getX();
            float y10 = event.getY();
            TouchDelegate touchDelegate = this.captured;
            if (touchDelegate == null || (listE = C1172u.e(touchDelegate)) == null) {
                listE = this.delegates;
            }
            Iterator it = listE.iterator();
            boolean z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TouchDelegate touchDelegate2 = (TouchDelegate) it.next();
                event.setLocation(x10, y10);
                boolean zOnTouchEvent = touchDelegate2.onTouchEvent(event);
                if (zOnTouchEvent) {
                    this.captured = touchDelegate2;
                    z10 = zOnTouchEvent;
                    break;
                }
                z10 = zOnTouchEvent;
            }
            int actionMasked = event.getActionMasked();
            if (actionMasked != 1 && actionMasked != 3) {
                return z10;
            }
            this.captured = null;
            return z10;
        }

        public final void setDelegates(List<? extends TouchDelegate> list) {
            p.i(list, "list");
            this.delegates.clear();
            this.delegates.addAll(list);
            this.captured = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCapsuleInputBase(Context context, AttributeSet attributeSet, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.inputHeight = i12;
        this.slotSize = i13;
        this.iconSize = i14;
        this.iconTextSpacing = i15;
        this.minTouchTarget = (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
        this.revealCapsuleCoverRunnable = new Runnable() { // from class: com.stepos.widget.internal.h
            @Override // java.lang.Runnable
            public final void run() {
                StepOSCapsuleInputBase.revealCapsuleCoverRunnable$lambda$0(this.f31255a);
            }
        };
        CapsuleLayout capsuleLayout = new CapsuleLayout(this, context);
        capsuleLayout.setOrientation(0);
        capsuleLayout.setGravity(16);
        this.capsuleLayout = capsuleLayout;
        this.capsuleGlassDelegate = new GlassDelegate(capsuleLayout);
        this.appliedCapsuleCornerRadius = Float.NaN;
        this.capsuleGlassRefreshRunnable = new Runnable() { // from class: com.stepos.widget.internal.i
            @Override // java.lang.Runnable
            public final void run() {
                StepOSCapsuleInputBase.capsuleGlassRefreshRunnable$lambda$2(this.f31256a);
            }
        };
        this.capsuleGlassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.internal.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSCapsuleInputBase.capsuleGlassRebuild$lambda$3(this.f31257a);
            }
        });
        ImageView imageViewCreateIconSlot = createIconSlot(context);
        this.startIconView = imageViewCreateIconSlot;
        ImageView imageViewCreateIconSlot2 = createIconSlot(context);
        this.endIconView = imageViewCreateIconSlot2;
        CompositeTouchDelegate compositeTouchDelegate = new CompositeTouchDelegate();
        this.touchDelegates = compositeTouchDelegate;
        this.autoClearButtonEnabledValue = true;
        this.pressScaleEnabledValue = true;
        this.queryWatcher = new TextWatcher() { // from class: com.stepos.widget.internal.StepOSCapsuleInputBase$queryWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s10) {
                this.this$0.syncClearButton();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s10, int start, int before, int count) {
            }
        };
        this.capsuleHitRect = new Rect();
        this.capsulePillOutlineProvider = new ViewOutlineProvider() { // from class: com.stepos.widget.internal.StepOSCapsuleInputBase$capsulePillOutlineProvider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                p.i(view, "view");
                p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2.0f);
            }
        };
        Drawable background = super.getBackground();
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        setOrientation(0);
        setGravity(16);
        super.setBackground(null);
        super.setPaddingRelative(0, 0, 0, 0);
        capsuleLayout.setBackground(background);
        this.capsuleFallbackBackground = background;
        capsuleLayout.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
        int iSlotInset = slotInset();
        imageViewCreateIconSlot.setPadding(iSlotInset, iSlotInset, iSlotInset, iSlotInset);
        imageViewCreateIconSlot2.setPadding(iSlotInset, iSlotInset, iSlotInset, iSlotInset);
        LinearLayout.LayoutParams layoutParamsSlotLayoutParams = slotLayoutParams();
        layoutParamsSlotLayoutParams.setMarginEnd(i15);
        t tVar = t.f7040a;
        capsuleLayout.addView(imageViewCreateIconSlot, 0, layoutParamsSlotLayoutParams);
        LinearLayout.LayoutParams layoutParamsSlotLayoutParams2 = slotLayoutParams();
        layoutParamsSlotLayoutParams2.setMarginStart(i15);
        capsuleLayout.addView(imageViewCreateIconSlot2, 1, layoutParamsSlotLayoutParams2);
        setClipChildren(false);
        setClipToPadding(false);
        capsuleLayout.setClipChildren(false);
        capsuleLayout.setClipToPadding(false);
        setTouchDelegate(compositeTouchDelegate);
        this.constructed = true;
    }

    private final View activityContentView() {
        Context context = getContext();
        p.h(context, "getContext(...)");
        Activity activity = getActivity(context);
        if (activity == null) {
            return null;
        }
        return activity.findViewById(R.id.content);
    }

    private final void applyCapsuleGlass() {
        boolean zApply$StepOSWidget_release;
        int width = this.capsuleLayout.getWidth();
        int height = this.capsuleLayout.getHeight();
        if (isAttachedToWindow()) {
            if (!shouldApplyLocalGlass() || width <= 0 || height <= 0) {
                releaseCapsuleGlass();
                return;
            }
            AppliedGlassRequest appliedGlassRequestGlassMaterialRequest = glassMaterialRequest();
            float f10 = height / 2.0f;
            if (p.d(appliedGlassRequestGlassMaterialRequest, this.appliedCapsuleGlassRequest)) {
                if (!this.capsuleGlassDelegate.getHasHandle$StepOSWidget_release() || f10 == this.appliedCapsuleCornerRadius) {
                    return;
                }
                this.capsuleGlassDelegate.updateCornerRadius$StepOSWidget_release(f10);
                this.appliedCapsuleCornerRadius = f10;
                return;
            }
            Log.i(FLASH_TAG, "capsule commit id=" + System.identityHashCode(this) + " " + width + "x" + height + " effect=" + appliedGlassRequestGlassMaterialRequest.getEffect() + " dark=" + appliedGlassRequestGlassMaterialRequest.getDarkMode());
            showCapsuleCover();
            this.capsuleLayout.setBackground(null);
            final GlassCustomizer glassCustomizerDefaultTunedGlassCustomizer = this.glassCustomizer;
            if (glassCustomizerDefaultTunedGlassCustomizer == null) {
                glassCustomizerDefaultTunedGlassCustomizer = defaultTunedGlassCustomizer();
            }
            if (glassCustomizerDefaultTunedGlassCustomizer != null) {
                zApply$StepOSWidget_release = this.capsuleGlassDelegate.applyCustom$StepOSWidget_release(0, f10, new InterfaceC5074l() { // from class: com.stepos.widget.internal.g
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return StepOSCapsuleInputBase.applyCapsuleGlass$lambda$15(glassCustomizerDefaultTunedGlassCustomizer, (B) obj);
                    }
                });
            } else {
                GlassDelegate glassDelegate = this.capsuleGlassDelegate;
                o oVarDefaultLocalGlassEffect = this.glassEffectOverride;
                if (oVarDefaultLocalGlassEffect == null) {
                    oVarDefaultLocalGlassEffect = defaultLocalGlassEffect();
                }
                zApply$StepOSWidget_release = glassDelegate.apply$StepOSWidget_release(0, f10, oVarDefaultLocalGlassEffect);
            }
            if (zApply$StepOSWidget_release) {
                scheduleCapsuleCoverReveal();
                this.appliedCapsuleCornerRadius = f10;
            } else {
                cancelCapsuleCover();
                applyCapsuleSurface();
                this.appliedCapsuleCornerRadius = Float.NaN;
            }
            this.appliedCapsuleGlassRequest = appliedGlassRequestGlassMaterialRequest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyCapsuleGlass$lambda$15(GlassCustomizer glassCustomizer, B it) {
        p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    private final void cancelCapsuleCover() {
        this.capsuleLayout.removeCallbacks(this.revealCapsuleCoverRunnable);
        Drawable drawable = this.coverCapsuleSurface;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.coverCapsuleSurface = null;
        this.capsuleLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t capsuleGlassRebuild$lambda$3(StepOSCapsuleInputBase stepOSCapsuleInputBase) {
        stepOSCapsuleInputBase.releaseCapsuleGlass();
        stepOSCapsuleInputBase.requestCapsuleGlassRefresh();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void capsuleGlassRefreshRunnable$lambda$2(StepOSCapsuleInputBase stepOSCapsuleInputBase) {
        stepOSCapsuleInputBase.capsuleGlassRefreshPosted = false;
        if (stepOSCapsuleInputBase.isAttachedToWindow()) {
            stepOSCapsuleInputBase.applyCapsuleGlass();
        }
    }

    private final Drawable createCapsuleGlassCoverDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(androidx.core.content.a.c(getContext(), com.stepos.widget.R.color.stepos_comp_background_primary));
        gradientDrawable.setCornerRadius(getResources().getDimension(com.stepos.widget.R.dimen.stepos_radius_full));
        return gradientDrawable;
    }

    private final o defaultLocalGlassEffect() {
        return isDarkMode() ? o.INSTANCE.i() : o.INSTANCE.k();
    }

    private final GlassCustomizer defaultTunedGlassCustomizer() {
        if (this.glassEffectOverride != null) {
            return null;
        }
        return isDarkMode() ? StepOSGlassPresets.INSTANCE.TITLE_BAR_DARK_TUNED(getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.TITLE_BAR_LIGHT_TUNED(getResources().getDisplayMetrics().density);
    }

    private final LinearLayout.LayoutParams editTextLayoutParams(ViewGroup.LayoutParams source) {
        LinearLayout.LayoutParams layoutParams = source instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) source : source == null ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(source);
        layoutParams.width = 0;
        layoutParams.weight = 1.0f;
        layoutParams.height = -1;
        return layoutParams;
    }

    private final Pair<Integer, Integer> expandAxisWithinParent(int currentStart, int currentEnd, int parentSize) {
        int iMin = Math.min(this.minTouchTarget, parentSize);
        int i10 = currentEnd - currentStart;
        if (i10 >= iMin) {
            return Y8.j.a(Integer.valueOf(currentStart), Integer.valueOf(currentEnd));
        }
        int i11 = iMin - i10;
        int i12 = i11 / 2;
        int iMax = currentStart - i12;
        int i13 = (currentEnd + i11) - i12;
        if (iMax < 0) {
            i13 -= iMax;
            iMax = 0;
        }
        if (i13 > parentSize) {
            iMax = Math.max(0, iMax - (i13 - parentSize));
        } else {
            parentSize = i13;
        }
        return Y8.j.a(Integer.valueOf(iMax), Integer.valueOf(parentSize));
    }

    private final Rect expandedTouchBounds(View target) {
        Rect rect = new Rect();
        target.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(target, rect);
        Pair<Integer, Integer> pairExpandAxisWithinParent = expandAxisWithinParent(rect.left, rect.right, getWidth());
        int iIntValue = pairExpandAxisWithinParent.a().intValue();
        int iIntValue2 = pairExpandAxisWithinParent.b().intValue();
        rect.left = iIntValue;
        rect.right = iIntValue2;
        Pair<Integer, Integer> pairExpandAxisWithinParent2 = expandAxisWithinParent(rect.top, rect.bottom, getHeight());
        int iIntValue3 = pairExpandAxisWithinParent2.a().intValue();
        int iIntValue4 = pairExpandAxisWithinParent2.b().intValue();
        rect.top = iIntValue3;
        rect.bottom = iIntValue4;
        return rect;
    }

    private final Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private final AppliedGlassRequest glassMaterialRequest() {
        GlassCustomizer glassCustomizer = this.glassCustomizer;
        o oVarDefaultLocalGlassEffect = this.glassEffectOverride;
        if (oVarDefaultLocalGlassEffect == null) {
            oVarDefaultLocalGlassEffect = defaultLocalGlassEffect();
        }
        return new AppliedGlassRequest(isDarkMode(), oVarDefaultLocalGlassEffect, glassCustomizer);
    }

    private final boolean isPointInCapsule(float x10, float y10) {
        this.capsuleLayout.getDrawingRect(this.capsuleHitRect);
        offsetDescendantRectToMyCoords(this.capsuleLayout, this.capsuleHitRect);
        return this.capsuleHitRect.contains((int) x10, (int) y10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revealCapsuleCoverRunnable$lambda$0(StepOSCapsuleInputBase stepOSCapsuleInputBase) {
        Drawable drawable = stepOSCapsuleInputBase.coverCapsuleSurface;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        stepOSCapsuleInputBase.coverCapsuleSurface = null;
        stepOSCapsuleInputBase.capsuleLayout.invalidate();
    }

    private final void scheduleCapsuleCoverReveal() {
        this.capsuleLayout.removeCallbacks(this.revealCapsuleCoverRunnable);
        if (deferCapsuleCoverRevealToHost()) {
            this.capsuleLayout.postDelayed(this.revealCapsuleCoverRunnable, 48L);
            return;
        }
        View viewActivityContentView = activityContentView();
        if (viewActivityContentView != null) {
            p.f(D.a(viewActivityContentView, new Runnable() { // from class: com.stepos.widget.internal.k
                @Override // java.lang.Runnable
                public final void run() {
                    StepOSCapsuleInputBase.scheduleCapsuleCoverReveal$lambda$17(this.f31258a);
                }
            }));
        } else {
            this.capsuleLayout.postOnAnimation(this.revealCapsuleCoverRunnable);
        }
        this.capsuleLayout.postDelayed(this.revealCapsuleCoverRunnable, 48L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleCapsuleCoverReveal$lambda$17(StepOSCapsuleInputBase stepOSCapsuleInputBase) {
        stepOSCapsuleInputBase.revealCapsuleCoverRunnable.run();
    }

    private final void showCapsuleCover() {
        Drawable drawableCreateCapsuleGlassCoverDrawable = createCapsuleGlassCoverDrawable();
        this.coverCapsuleSurface = drawableCreateCapsuleGlassCoverDrawable;
        drawableCreateCapsuleGlassCoverDrawable.setCallback(this.capsuleLayout);
        this.capsuleLayout.invalidate();
    }

    public final void addStructuralView(View child, int index, LinearLayout.LayoutParams params) {
        p.i(child, "child");
        p.i(params, "params");
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        p.i(child, "child");
        if (!(child instanceof EditText)) {
            throw new IllegalStateException((getWidgetLogTag() + " 只接受一个 EditText 子 View（收到 " + child.getClass().getName() + "）：两端的图标槽由控件自己维护，请用 startIcon / endIcon 属性配置；要在旁边放别的 View 请用外层容器").toString());
        }
        String str = null;
        if (this.editTextValue == null) {
            EditText editText = (EditText) child;
            this.editTextValue = editText;
            editText.setBackground(null);
            editText.setGravity((editText.getGravity() & Const.I_DEF_CGI_SIG) | 16);
            CapsuleLayout capsuleLayout = this.capsuleLayout;
            capsuleLayout.addView(child, capsuleLayout.indexOfChild(getEditTextInsertAnchor()), editTextLayoutParams(params));
            editText.addTextChangedListener(this.queryWatcher);
            syncClearButton();
            return;
        }
        String widgetLogTag = getWidgetLogTag();
        EditText editText2 = this.editTextValue;
        if (editText2 != null) {
            str = "0x" + Integer.toHexString(editText2.getId());
        }
        throw new IllegalStateException((widgetLogTag + " 只能有一个 EditText，已经有一个了（id=" + str + "）").toString());
    }

    public final void applyCapsuleFlatElevation(boolean enable) {
        if (enable) {
            this.capsuleLayout.setOutlineProvider(this.capsulePillOutlineProvider);
            this.capsuleLayout.setElevation(getCapsuleFlatElevationPx());
        } else {
            this.capsuleLayout.setElevation(0.0f);
            this.capsuleLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
    }

    public final void applyCapsuleFlatSurface() {
        applyCapsuleFlatElevation(true);
        CapsuleLayout capsuleLayout = this.capsuleLayout;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getEffectiveCapsuleFlatSurfaceColor());
        gradientDrawable.setCornerRadius(getResources().getDimension(com.stepos.widget.R.dimen.stepos_radius_full));
        capsuleLayout.setBackground(gradientDrawable);
    }

    public abstract void applyCapsuleSurface();

    public abstract void applyIcons();

    public final void applyPressScale() {
        List<View> listPressScaleTargets = pressScaleTargets();
        if (this.pressScaleEnabledValue) {
            HotspotRipple hotspotRipple = HotspotRipple.INSTANCE;
            Iterator<T> it = listPressScaleTargets.iterator();
            while (it.hasNext()) {
                hotspotRipple.applyPressScale$StepOSWidget_release((View) it.next());
            }
            return;
        }
        this.capsuleLayout.setPressed(false);
        HotspotRipple hotspotRipple2 = HotspotRipple.INSTANCE;
        Iterator<T> it2 = listPressScaleTargets.iterator();
        while (it2.hasNext()) {
            hotspotRipple2.clearPressScale$StepOSWidget_release((View) it2.next());
        }
    }

    public final Drawable copyDrawable(Drawable source) {
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        if (source != null && (constantState = source.getConstantState()) != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        if (source != null) {
            return source.mutate();
        }
        return null;
    }

    public ImageView createIconSlot(Context context) {
        p.i(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setPadding(0, 0, 0, 0);
        return imageView;
    }

    public boolean deferCapsuleCoverRevealToHost() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (this.pressScaleEnabledValue) {
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                this.capsuleLayout.setPressed(isPointInCapsule(event.getX(), event.getY()));
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.capsuleLayout.setPressed(false);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public final boolean getAutoClearButtonEnabledValue() {
        return this.autoClearButtonEnabledValue;
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.constructed ? this.capsuleLayout.getBackground() : super.getBackground();
    }

    public final Drawable getCapsuleFallbackBackground() {
        return this.capsuleFallbackBackground;
    }

    public abstract float getCapsuleFlatElevationPx();

    public abstract int getCapsuleFlatSurfaceColor();

    public final CapsuleLayout getCapsuleLayout() {
        return this.capsuleLayout;
    }

    public final boolean getConstructed() {
        return this.constructed;
    }

    /* renamed from: getEditText, reason: from getter */
    public final EditText getEditTextValue() {
        return this.editTextValue;
    }

    public abstract View getEditTextInsertAnchor();

    public final EditText getEditTextValue() {
        return this.editTextValue;
    }

    public final int getEffectiveCapsuleFlatSurfaceColor() {
        Integer num = this.capsuleFlatSurfaceColorOverride;
        return num != null ? num.intValue() : getCapsuleFlatSurfaceColor();
    }

    /* renamed from: getEndIcon, reason: from getter */
    public final Drawable getEndIconValue() {
        return this.endIconValue;
    }

    /* renamed from: getEndIconActivated, reason: from getter */
    public final Drawable getEndIconActivatedValue() {
        return this.endIconActivatedValue;
    }

    /* renamed from: getEndIconActivatedContentDescription, reason: from getter */
    public final CharSequence getEndIconActivatedContentDescriptionValue() {
        return this.endIconActivatedContentDescriptionValue;
    }

    public final CharSequence getEndIconActivatedContentDescriptionValue() {
        return this.endIconActivatedContentDescriptionValue;
    }

    public final boolean getEndIconActivatedFlag() {
        return this.endIconActivatedFlag;
    }

    public final Drawable getEndIconActivatedValue() {
        return this.endIconActivatedValue;
    }

    /* renamed from: getEndIconContentDescription, reason: from getter */
    public final CharSequence getEndIconContentDescriptionValue() {
        return this.endIconContentDescriptionValue;
    }

    public final CharSequence getEndIconContentDescriptionValue() {
        return this.endIconContentDescriptionValue;
    }

    public final Drawable getEndIconValue() {
        return this.endIconValue;
    }

    public final ImageView getEndIconView() {
        return this.endIconView;
    }

    public final GlassCustomizer getGlassCustomizer() {
        return this.glassCustomizer;
    }

    public final o getGlassEffectOverride() {
        return this.glassEffectOverride;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getIconTextSpacing() {
        return this.iconTextSpacing;
    }

    /* renamed from: getIconTint, reason: from getter */
    public final ColorStateList getIconTintValue() {
        return this.iconTintValue;
    }

    public final ColorStateList getIconTintValue() {
        return this.iconTintValue;
    }

    public final int getInputHeight() {
        return this.inputHeight;
    }

    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    public final TextWatcher getQueryWatcher() {
        return this.queryWatcher;
    }

    public final int getSlotSize() {
        return this.slotSize;
    }

    /* renamed from: getStartIcon, reason: from getter */
    public final Drawable getStartIconValue() {
        return this.startIconValue;
    }

    public final Drawable getStartIconValue() {
        return this.startIconValue;
    }

    public final ImageView getStartIconView() {
        return this.startIconView;
    }

    public abstract String getWidgetLogTag();

    public void handleCapsuleChildRemoved(View child) {
        p.i(child, "child");
        EditText editText = this.editTextValue;
        if (child == editText) {
            if (editText != null) {
                editText.removeTextChangedListener(this.queryWatcher);
            }
            this.editTextValue = null;
            onEditTextRemoved();
            return;
        }
        if (child == this.startIconView || child == this.endIconView || isExtraSlot(child)) {
            Log.w(getWidgetLogTag(), "内部图标槽被移出 " + getWidgetLogTag() + "（多半是误调了 removeAllViews() / removeViewAt()）：两端的槽是控件的内部结构，移掉之后 startIcon / endIcon 不再生效。要清空文本请操作自己的 EditText，要隐藏图标请把对应的 icon 设为 null");
        }
    }

    public final boolean isAutoClearButtonEnabled() {
        return this.autoClearButtonEnabledValue;
    }

    public final boolean isDarkMode() {
        Context context = getContext();
        p.h(context, "getContext(...)");
        return GlassThemeKt.isVisuallyDark(context);
    }

    public final boolean isEndIconActivated() {
        return this.endIconActivatedFlag;
    }

    public boolean isExtraSlot(View child) {
        p.i(child, "child");
        return false;
    }

    public final boolean isPressScaleEnabled() {
        return this.pressScaleEnabledValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onAttachedToWindowExtra();
        if (this.capsuleGlassDelegate.getIsActive()) {
            return;
        }
        requestCapsuleGlassRefresh();
    }

    public void onAttachedToWindowExtra() {
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.capsuleGlassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
        onConfigurationChangedExtra(newConfig);
    }

    public void onConfigurationChangedExtra(Configuration newConfig) {
        p.i(newConfig, "newConfig");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        onDetachedFromWindowExtra();
        this.touchDelegates.setDelegates(C1173v.m());
        removeCallbacks(this.capsuleGlassRefreshRunnable);
        this.capsuleGlassRefreshPosted = false;
        this.capsuleGlassRebuild.cancel$StepOSWidget_release();
        cancelCapsuleCover();
        releaseCapsuleGlass();
        super.onDetachedFromWindow();
    }

    public void onDetachedFromWindowExtra() {
    }

    public void onEditTextRemoved() {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        super.onLayout(changed, l10, t10, r10, b10);
        refreshTouchDelegates();
        requestCapsuleGlassRefresh();
        onLayoutExtra();
    }

    public void onLayoutExtra() {
    }

    public abstract List<View> pressScaleTargets();

    public final void refreshTouchDelegates() {
        List<View> list = touchDelegateSlots();
        ArrayList arrayList = new ArrayList(list.size());
        for (View view : list) {
            if (view.getVisibility() == 0) {
                arrayList.add(new TouchDelegate(expandedTouchBounds(view), view));
            }
        }
        this.touchDelegates.setDelegates(arrayList);
    }

    public final void releaseCapsuleGlass() {
        this.capsuleGlassDelegate.release$StepOSWidget_release();
        this.appliedCapsuleGlassRequest = null;
        this.appliedCapsuleCornerRadius = Float.NaN;
        cancelCapsuleCover();
        applyCapsuleSurface();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.editTextValue) {
            this.capsuleLayout.removeView(view);
        } else {
            super.removeView(view);
        }
    }

    public final void requestCapsuleGlassRefresh() {
        if (!isAttachedToWindow() || this.capsuleGlassRefreshPosted) {
            return;
        }
        if (shouldApplyLocalGlass()) {
            if (p.d(glassMaterialRequest(), this.appliedCapsuleGlassRequest) && (this.capsuleLayout.getHeight() <= 0 || this.capsuleLayout.getHeight() / 2.0f == this.appliedCapsuleCornerRadius || !this.capsuleGlassDelegate.getHasHandle$StepOSWidget_release())) {
                return;
            }
        } else if (this.appliedCapsuleGlassRequest == null && !this.capsuleGlassDelegate.getHasHandle$StepOSWidget_release() && this.coverCapsuleSurface == null) {
            return;
        }
        this.capsuleGlassRefreshPosted = true;
        post(this.capsuleGlassRefreshRunnable);
    }

    public final void revealCapsuleCoverNow() {
        this.revealCapsuleCoverRunnable.run();
    }

    public final void setAutoClearButtonEnabled(boolean z10) {
        if (this.autoClearButtonEnabledValue == z10) {
            return;
        }
        this.autoClearButtonEnabledValue = z10;
        if (z10) {
            syncClearButton();
        }
    }

    public final void setAutoClearButtonEnabledValue(boolean z10) {
        this.autoClearButtonEnabledValue = z10;
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (this.constructed) {
            this.capsuleLayout.setBackground(background);
        } else {
            super.setBackground(background);
        }
    }

    public final void setCapsuleFallbackBackground(Drawable drawable) {
        this.capsuleFallbackBackground = drawable;
    }

    public final void setCapsuleFlatSurfaceOverride(int color) {
        Integer num = this.capsuleFlatSurfaceColorOverride;
        if (num != null && num.intValue() == color) {
            return;
        }
        this.capsuleFlatSurfaceColorOverride = Integer.valueOf(color);
        applyCapsuleSurface();
    }

    public final void setConstructed(boolean z10) {
        this.constructed = z10;
    }

    public final void setEditTextValue(EditText editText) {
        this.editTextValue = editText;
    }

    public final void setEndIcon(Drawable drawable) {
        if (this.endIconValue == drawable) {
            return;
        }
        this.endIconValue = drawable;
        applyIcons();
    }

    public final void setEndIconActivated(Drawable drawable) {
        if (this.endIconActivatedValue == drawable) {
            return;
        }
        this.endIconActivatedValue = drawable;
        applyIcons();
    }

    public final void setEndIconActivatedContentDescription(CharSequence charSequence) {
        if (p.d(this.endIconActivatedContentDescriptionValue, charSequence)) {
            return;
        }
        this.endIconActivatedContentDescriptionValue = charSequence;
        applyIcons();
    }

    public final void setEndIconActivatedContentDescriptionValue(CharSequence charSequence) {
        this.endIconActivatedContentDescriptionValue = charSequence;
    }

    public final void setEndIconActivatedFlag(boolean z10) {
        this.endIconActivatedFlag = z10;
    }

    public final void setEndIconActivatedResource(int resId) {
        setEndIconActivated(resId == 0 ? null : androidx.core.content.a.e(getContext(), resId));
    }

    public final void setEndIconActivatedValue(Drawable drawable) {
        this.endIconActivatedValue = drawable;
    }

    public final void setEndIconContentDescription(CharSequence charSequence) {
        if (p.d(this.endIconContentDescriptionValue, charSequence)) {
            return;
        }
        this.endIconContentDescriptionValue = charSequence;
        applyIcons();
    }

    public final void setEndIconContentDescriptionValue(CharSequence charSequence) {
        this.endIconContentDescriptionValue = charSequence;
    }

    public final void setEndIconResource(int resId) {
        setEndIcon(resId == 0 ? null : androidx.core.content.a.e(getContext(), resId));
    }

    public final void setEndIconValue(Drawable drawable) {
        this.endIconValue = drawable;
    }

    public final void setGlassCustomizer(GlassCustomizer glassCustomizer) {
        this.glassCustomizer = glassCustomizer;
    }

    public final void setGlassEffectOverride(o oVar) {
        this.glassEffectOverride = oVar;
    }

    public final void setIconTint(ColorStateList colorStateList) {
        this.iconTintValue = colorStateList;
        applyIcons();
    }

    public final void setIconTintValue(ColorStateList colorStateList) {
        this.iconTintValue = colorStateList;
    }

    public final void setInputHeight(int i10) {
        this.inputHeight = i10;
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        if (this.constructed) {
            this.capsuleLayout.setPadding(left, top, right, bottom);
        } else {
            super.setPadding(left, top, right, bottom);
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        if (this.constructed) {
            this.capsuleLayout.setPaddingRelative(start, top, end, bottom);
        } else {
            super.setPaddingRelative(start, top, end, bottom);
        }
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        applyPressScale();
    }

    public final void setPressScaleEnabledValue(boolean z10) {
        this.pressScaleEnabledValue = z10;
    }

    public final void setStartIcon(Drawable drawable) {
        if (this.startIconValue == drawable) {
            return;
        }
        this.startIconValue = drawable;
        applyIcons();
    }

    public final void setStartIconResource(int resId) {
        setStartIcon(resId == 0 ? null : androidx.core.content.a.e(getContext(), resId));
    }

    public final void setStartIconValue(Drawable drawable) {
        this.startIconValue = drawable;
    }

    public abstract boolean shouldApplyLocalGlass();

    public final int slotInset() {
        return Math.max(0, (this.slotSize - this.iconSize) / 2);
    }

    public final LinearLayout.LayoutParams slotLayoutParams() {
        int i10 = this.slotSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public final void syncClearButton() {
        if (this.autoClearButtonEnabledValue) {
            EditText editText = this.editTextValue;
            Editable text = editText != null ? editText.getText() : null;
            setEndIconActivated(!(text == null || text.length() == 0));
        }
    }

    public abstract List<View> touchDelegateSlots();

    public final void warnIfUnlabeled(View view, String attrName) {
        p.i(view, "view");
        p.i(attrName, "attrName");
        if (view.getVisibility() != 0) {
            return;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null || contentDescription.length() == 0) {
            Log.w(getWidgetLogTag(), "图标可见可点击但没有 contentDescription，屏读用户听不出它是什么。请设 app:" + attrName + "（CLAUDE.md §4.10：图标类操作项必须有 contentDescription）");
        }
    }

    public final void setEndIconActivated(boolean z10) {
        if (this.endIconActivatedFlag == z10) {
            return;
        }
        this.endIconActivatedFlag = z10;
        applyIcons();
    }
}
