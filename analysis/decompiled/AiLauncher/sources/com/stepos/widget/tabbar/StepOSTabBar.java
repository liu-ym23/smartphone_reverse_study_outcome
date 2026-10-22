package com.stepos.widget.tabbar;

import C0.c;
import Y8.t;
import Z8.F;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import androidx.customview.view.AbsSavedState;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.internal.StepOSTrace;
import com.stepos.widget.internal.TabIndicatorMover;
import com.stepos.widget.tabbar.StepOSTabBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import n9.C4946a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.B;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 ¿\u00022\u00020\u0001:\bÀ\u0002Á\u0002Â\u0002¿\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010\"J\u001f\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)J+\u0010.\u001a\u00020\r2\b\b\u0001\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\rH\u0002¢\u0006\u0004\b0\u0010\"J!\u00101\u001a\u00020\r2\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\r2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0010H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u00020\r2\b\b\u0001\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0017J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010@J\u001b\u0010A\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010@J#\u0010D\u001a\u00020\r2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0BH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010\"J\u0017\u0010H\u001a\u00020\r2\b\b\u0001\u0010G\u001a\u00020\u0006¢\u0006\u0004\bH\u0010\u0017J\u0015\u0010K\u001a\u00020\r2\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020\r¢\u0006\u0004\bM\u0010\"J\u0017\u0010O\u001a\u00020\r2\b\b\u0001\u0010N\u001a\u00020\u0006¢\u0006\u0004\bO\u0010\u0017J\r\u0010P\u001a\u00020\u001d¢\u0006\u0004\bP\u0010QJ+\u0010S\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u00109\u001a\u00020\u00062\b\b\u0002\u0010R\u001a\u00020+H\u0007¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bU\u0010VJ\u0015\u0010W\u001a\u00020\r2\u0006\u00109\u001a\u00020\u0006¢\u0006\u0004\bW\u0010\u0017J\r\u0010X\u001a\u00020\r¢\u0006\u0004\bX\u0010\"J\u0017\u0010Y\u001a\u0004\u0018\u00010\u001d2\u0006\u00109\u001a\u00020\u0006¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u0004\u0018\u00010\u001d2\b\b\u0001\u0010*\u001a\u00020\u0006¢\u0006\u0004\b[\u0010ZJ\u001f\u0010\\\u001a\u00020\r2\b\b\u0001\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b\\\u0010]J)\u0010\\\u001a\u00020\r2\b\b\u0001\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0001¢\u0006\u0004\b^\u0010/J!\u0010`\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00062\b\b\u0001\u0010:\u001a\u00020\u0010H\u0001¢\u0006\u0004\b_\u0010<J\u000f\u0010b\u001a\u00020\rH\u0001¢\u0006\u0004\ba\u0010\"J\u000f\u0010c\u001a\u00020\rH\u0014¢\u0006\u0004\bc\u0010\"J\u000f\u0010d\u001a\u00020\rH\u0014¢\u0006\u0004\bd\u0010\"J\u0019\u0010g\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010eH\u0016¢\u0006\u0004\bg\u0010hJ)\u0010m\u001a\u00020\r2\u0006\u0010j\u001a\u00020i2\u0006\u0010?\u001a\u00020\u00062\b\u0010l\u001a\u0004\u0018\u00010kH\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001a\u00020+2\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020+H\u0014¢\u0006\u0004\bs\u0010tJ\u0019\u0010u\u001a\u00020\r2\b\b\u0001\u0010*\u001a\u00020\u0006H\u0014¢\u0006\u0004\bu\u0010\u0017J\u001f\u0010x\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u00062\u0006\u0010w\u001a\u00020\u0006H\u0014¢\u0006\u0004\bx\u0010yJ\u001f\u0010|\u001a\u00020\r2\u0006\u0010z\u001a\u00020\u00062\u0006\u0010{\u001a\u00020\u0006H\u0014¢\u0006\u0004\b|\u0010}J=\u0010\u0083\u0001\u001a\u00020\r2\u0006\u0010~\u001a\u00020+2\u0006\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001c\u0010\u0087\u0001\u001a\u00020\r2\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0013\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0014¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001e\u0010\u008d\u0001\u001a\u00020\r2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0014¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J#\u0010\u0091\u0001\u001a\u00020\r2\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u008f\u0001H\u0014¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J#\u0010\u0093\u0001\u001a\u00020\r2\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u008f\u0001H\u0014¢\u0006\u0006\b\u0093\u0001\u0010\u0092\u0001J\u001a\u0010\u0096\u0001\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0005\b\u0097\u0001\u0010VJ#\u0010\u009c\u0001\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009d\u0001\u001a\u00020\rH\u0014¢\u0006\u0005\b\u009d\u0001\u0010\"J\u001a\u0010\u009e\u0001\u001a\u00020\u00062\u0006\u0010z\u001a\u00020\u0006H\u0015¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001c\u0010¢\u0001\u001a\u00020\r2\b\u0010¡\u0001\u001a\u00030 \u0001H\u0014¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010¨\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010«\u0001\u001a\u00030ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0019\u0010°\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0019\u0010²\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0019\u0010´\u0001\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0017\u0010¶\u0001\u001a\u0002058\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0017\u0010¸\u0001\u001a\u0002058\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010·\u0001R\u0019\u0010¹\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010±\u0001R)\u0010¼\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001d0º\u0001j\t\u0012\u0004\u0012\u00020\u001d`»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010±\u0001R'\u0010Á\u0001\u001a\u00020+8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÁ\u0001\u0010±\u0001\u001a\u0005\bÂ\u0001\u0010t\"\u0005\bÃ\u0001\u00104R\u0019\u0010Ä\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010±\u0001R\u0019\u0010Å\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010±\u0001R\u0019\u0010Æ\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010±\u0001R\u0019\u0010Ç\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010±\u0001R\u0019\u0010È\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010³\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Ë\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010±\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010±\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010³\u0001R3\u0010Ñ\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\bÑ\u0001\u0010³\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0005\bÔ\u0001\u0010\u0017R3\u0010Õ\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\bÕ\u0001\u0010³\u0001\u001a\u0006\bÖ\u0001\u0010Ó\u0001\"\u0005\b×\u0001\u0010\u0017R3\u0010Ø\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bØ\u0001\u0010³\u0001\u001a\u0006\bÙ\u0001\u0010Ó\u0001\"\u0005\bÚ\u0001\u0010\u0017R3\u0010Û\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bÛ\u0001\u0010³\u0001\u001a\u0006\bÜ\u0001\u0010Ó\u0001\"\u0005\bÝ\u0001\u0010\u0017R4\u0010Þ\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0001\u0010µ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R4\u0010ã\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010µ\u0001\u001a\u0006\bä\u0001\u0010à\u0001\"\u0006\bå\u0001\u0010â\u0001R4\u0010æ\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bæ\u0001\u0010µ\u0001\u001a\u0006\bç\u0001\u0010à\u0001\"\u0006\bè\u0001\u0010â\u0001R4\u0010é\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010µ\u0001\u001a\u0006\bê\u0001\u0010à\u0001\"\u0006\bë\u0001\u0010â\u0001R4\u0010ì\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bì\u0001\u0010µ\u0001\u001a\u0006\bí\u0001\u0010à\u0001\"\u0006\bî\u0001\u0010â\u0001R4\u0010ï\u0001\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010µ\u0001\u001a\u0006\bð\u0001\u0010à\u0001\"\u0006\bñ\u0001\u0010â\u0001R3\u0010ò\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bò\u0001\u0010³\u0001\u001a\u0006\bó\u0001\u0010Ó\u0001\"\u0005\bô\u0001\u0010\u0017R3\u0010õ\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bõ\u0001\u0010³\u0001\u001a\u0006\bö\u0001\u0010Ó\u0001\"\u0005\b÷\u0001\u0010\u0017R'\u0010ø\u0001\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bø\u0001\u0010±\u0001\u001a\u0005\bø\u0001\u0010t\"\u0005\bù\u0001\u00104R1\u0010ú\u0001\u001a\u00020\u00062\u0007\u0010Ð\u0001\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bú\u0001\u0010³\u0001\u001a\u0006\bû\u0001\u0010Ó\u0001\"\u0005\bü\u0001\u0010\u0017R3\u0010ý\u0001\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bý\u0001\u0010³\u0001\u001a\u0006\bþ\u0001\u0010Ó\u0001\"\u0005\bÿ\u0001\u0010\u0017R8\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u00022\n\u0010Ð\u0001\u001a\u0005\u0018\u00010\u0080\u00028\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R8\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0080\u00022\n\u0010Ð\u0001\u001a\u0005\u0018\u00010\u0080\u00028\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0082\u0002\u001a\u0006\b\u0088\u0002\u0010\u0084\u0002\"\u0006\b\u0089\u0002\u0010\u0086\u0002R0\u0010\u008a\u0002\u001a\u00020+2\u0007\u0010Ð\u0001\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u008a\u0002\u0010±\u0001\u001a\u0005\b\u008a\u0002\u0010t\"\u0005\b\u008b\u0002\u00104R\u0019\u0010\u008c\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010±\u0001R\u0019\u0010\u008d\u0002\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010±\u0001R8\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008e\u00022\n\u0010Ð\u0001\u001a\u0005\u0018\u00010\u008e\u00028\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008f\u0002\u0010\u0090\u0002\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001b\u0010\u0095\u0002\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R0\u0010\u0097\u0002\u001a\u00020+2\u0007\u0010Ð\u0001\u001a\u00020+8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u0097\u0002\u0010±\u0001\u001a\u0005\b\u0097\u0002\u0010t\"\u0005\b\u0098\u0002\u00104R2\u0010\u0099\u0002\u001a\u00020\u00102\u0007\u0010Ð\u0001\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010µ\u0001\u001a\u0006\b\u009a\u0002\u0010à\u0001\"\u0006\b\u009b\u0002\u0010â\u0001R4\u0010\u009c\u0002\u001a\u00020\u00102\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0002\u0010µ\u0001\u001a\u0006\b\u009d\u0002\u0010à\u0001\"\u0006\b\u009e\u0002\u0010â\u0001R,\u0010 \u0002\u001a\u0005\u0018\u00010\u009f\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b \u0002\u0010¡\u0002\u001a\u0006\b¢\u0002\u0010£\u0002\"\u0006\b¤\u0002\u0010¥\u0002R,\u0010§\u0002\u001a\u0005\u0018\u00010¦\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0002\u0010¨\u0002\u001a\u0006\b©\u0002\u0010ª\u0002\"\u0006\b«\u0002\u0010¬\u0002RM\u0010\u00ad\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010B2\u0015\u0010Ð\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010B8A@AX\u0080\u000e¢\u0006\u0017\n\u0006\b\u00ad\u0002\u0010®\u0002\u001a\u0006\b¯\u0002\u0010°\u0002\"\u0005\b±\u0002\u0010ER\u0017\u0010³\u0002\u001a\u00020\u00068UX\u0094\u0004¢\u0006\b\u001a\u0006\b²\u0002\u0010Ó\u0001R(\u0010´\u0002\u001a\u00020+2\u0007\u0010Ð\u0001\u001a\u00020+8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b´\u0002\u0010t\"\u0005\bµ\u0002\u00104R(\u0010¶\u0002\u001a\u00020+2\u0007\u0010Ð\u0001\u001a\u00020+8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¶\u0002\u0010t\"\u0005\b·\u0002\u00104R\u0014\u0010¹\u0002\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b¸\u0002\u0010Ó\u0001R*\u0010»\u0002\u001a\u00020\u00062\t\b\u0001\u0010Ð\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0006\bº\u0002\u0010Ó\u0001\"\u0004\b\\\u0010\u0017R\u0014\u0010½\u0002\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b¼\u0002\u0010Ó\u0001R\u0013\u0010¾\u0002\u001a\u00020+8F¢\u0006\u0007\u001a\u0005\b¾\u0002\u0010t¨\u0006Ã\u0002"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/stepos/widget/tabbar/StepOSTabItemView;", "itemView", "LY8/t;", "onItemPressed", "(Lcom/stepos/widget/tabbar/StepOSTabItemView;)V", "", "x", "y", "itemViewAt", "(FF)Lcom/stepos/widget/tabbar/StepOSTabItemView;", "savedItemId", "restoreSelection", "(I)V", "", "itemIds", "counts", "restoreBadges", "([I[I)V", "Lcom/stepos/widget/tabbar/StepOSTab;", "tab", "createItemView", "(Lcom/stepos/widget/tabbar/StepOSTab;)Lcom/stepos/widget/tabbar/StepOSTabItemView;", "refreshItemStyle", "()V", "Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "currentItemStyle", "()Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "buildItemStyle", "syncDerivedStateListsFromSelectedColor", "onItemViewClicked", "(Lcom/stepos/widget/tabbar/StepOSTabItemView;Lcom/stepos/widget/tabbar/StepOSTab;)V", "itemId", "", "animate", "updateIndicator", "applySelection", "(IZZ)V", "reselectFallback", "syncSelectionToViews", "(ZZ)V", "moveIndicator", "(Z)V", "Landroid/graphics/Rect;", "bounds", "layoutIndicator", "(Landroid/graphics/Rect;)V", "position", "offset", "layoutIndicatorFromPage", "(IF)V", "itemW", "warnIfTouchTargetTooSmall", "index", "(I)Lcom/stepos/widget/tabbar/StepOSTabItemView;", "findItemView", "Lkotlin/Function1;", "action", "forEachItemView", "(Lp9/l;)V", "refreshGlass", "resId", "setItemSelectedColorResource", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "menuRes", "inflateMenu", "newTab", "()Lcom/stepos/widget/tabbar/StepOSTab;", "selectNow", "addTab", "(Lcom/stepos/widget/tabbar/StepOSTab;IZ)V", "removeTab", "(Lcom/stepos/widget/tabbar/StepOSTab;)V", "removeTabAt", "removeAllTabs", "getTabAt", "(I)Lcom/stepos/widget/tabbar/StepOSTab;", "findTabById", "setSelectedItemId", "(IZ)V", "setSelectedItemId$StepOSWidget_release", "setIndicatorPositionFromPage$StepOSWidget_release", "setIndicatorPositionFromPage", "endPagerIndicatorTracking$StepOSWidget_release", "endPagerIndicatorTracking", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View;", "child", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "shouldSelectOnPressDown", "()Z", "onSelectionCommitted", "childCount", "drawingPosition", "getChildDrawingOrder", "(II)I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Landroid/util/SparseArray;", "container", "dispatchSaveInstanceState", "(Landroid/util/SparseArray;)V", "dispatchRestoreInstanceState", "indexOfTab$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSTab;)I", "indexOfTab", "onTabChanged$StepOSWidget_release", "onTabChanged", "oldItemId", "onTabItemIdChanged$StepOSWidget_release", "(Lcom/stepos/widget/tabbar/StepOSTab;I)V", "onTabItemIdChanged", "refreshItemLayout", "measureItemWidth", "(I)I", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Landroid/view/ViewOutlineProvider;", "glassOutlineProvider", "Landroid/view/ViewOutlineProvider;", "Lcom/stepos/widget/tabbar/StepOSTabIndicatorView;", "indicator", "Lcom/stepos/widget/tabbar/StepOSTabIndicatorView;", "Lcom/stepos/widget/internal/TabIndicatorMover;", "indicatorMover", "Lcom/stepos/widget/internal/TabIndicatorMover;", "pagerDrivenIndicator", "Z", "pagerIndicatorPosition", "I", "pagerIndicatorOffset", "F", "indicatorTo", "Landroid/graphics/Rect;", "indicatorCurrent", "addingIndicator", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tabs", "Ljava/util/ArrayList;", "fallbackBackground", "Landroid/graphics/drawable/Drawable;", "internalWrite", "constructed", "getConstructed", "setConstructed", "trackColorOverrides", "labelTextColorExplicit", "iconTintExplicit", "indicatorColorExplicit", "visibleTabCount", "itemStyleSnapshot", "Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "touchTargetWarned", "latestPressedItemView", "Lcom/stepos/widget/tabbar/StepOSTabItemView;", "latestPressChangedSelection", "selectedItemIdValue", UxipConstants.f30680s, "itemMaxWidth", "getItemMaxWidth", "()I", "setItemMaxWidth", "itemSpacing", "getItemSpacing", "setItemSpacing", "itemLabelTextAppearance", "getItemLabelTextAppearance", "setItemLabelTextAppearance", "itemPaddingHorizontal", "getItemPaddingHorizontal", "setItemPaddingHorizontal", "itemCornerRadius", "getItemCornerRadius", "()F", "setItemCornerRadius", "(F)V", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "itemBlurRadius", "getItemBlurRadius", "setItemBlurRadius", "indicatorBlurRadius", "getIndicatorBlurRadius", "setIndicatorBlurRadius", "itemAlpha", "getItemAlpha", "setItemAlpha", "itemAlphaSelected", "getItemAlphaSelected", "setItemAlphaSelected", "itemFillColor", "getItemFillColor", "setItemFillColor", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "isIndicatorAnimationEnabled", "setIndicatorAnimationEnabled", "indicatorAnimationDuration", "getIndicatorAnimationDuration", "setIndicatorAnimationDuration", "itemSelectedColor", "getItemSelectedColor", "setItemSelectedColor", "Landroid/content/res/ColorStateList;", "itemLabelTextColor", "Landroid/content/res/ColorStateList;", "getItemLabelTextColor", "()Landroid/content/res/ColorStateList;", "setItemLabelTextColor", "(Landroid/content/res/ColorStateList;)V", "itemIconTint", "getItemIconTint", "setItemIconTint", "isGlassEnabled", "setGlassEnabled", "pressScaleEnabledValue", "pressLightEnabledValue", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "isGradientGlassEnabled", "setGradientGlassEnabled", "gradientBlurRadius", "getGradientBlurRadius", "setGradientBlurRadius", "glassCornerRadius", "getGlassCornerRadius", "setGlassCornerRadius", "Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemSelectedListener;", "onItemSelectedListener", "Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemSelectedListener;", "getOnItemSelectedListener", "()Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemSelectedListener;", "setOnItemSelectedListener", "(Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemSelectedListener;)V", "Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemReselectedListener;", "onItemReselectedListener", "Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemReselectedListener;", "getOnItemReselectedListener", "()Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemReselectedListener;", "setOnItemReselectedListener", "(Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemReselectedListener;)V", "selectionCommittedHook", "Lp9/l;", "getSelectionCommittedHook$StepOSWidget_release", "()Lp9/l;", "setSelectionCommittedHook$StepOSWidget_release", "getItemHeightPx", "itemHeightPx", "isPressScaleEnabled", "setPressScaleEnabled", "isPressLightEnabled", "setPressLightEnabled", "getTabCount", "tabCount", "getSelectedItemId", "selectedItemId", "getSelectedPosition", "selectedPosition", "isGlassActive", "Companion", "OnItemSelectedListener", "OnItemReselectedListener", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSTabBar extends LinearLayout {
    private static final String ATTR_STEPOS_THEME_COLOR = "steposThemeColor";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int INVALID_POSITION = -1;
    public static final int NO_ID = 0;
    private static final String TAG = "StepOSTabBar";
    private boolean addingIndicator;
    private boolean constructed;
    private Drawable fallbackBackground;
    private float glassCornerRadius;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private y7.o glassEffect;
    private final ViewOutlineProvider glassOutlineProvider;
    private float gradientBlurRadius;
    private boolean iconTintExplicit;
    private final StepOSTabIndicatorView indicator;
    private int indicatorAnimationDuration;
    private float indicatorBlurRadius;
    private int indicatorColor;
    private boolean indicatorColorExplicit;
    private float indicatorCornerRadius;
    private final Rect indicatorCurrent;
    private final TabIndicatorMover indicatorMover;
    private final Rect indicatorTo;
    private boolean internalWrite;
    private boolean isGlassEnabled;
    private boolean isGradientGlassEnabled;
    private boolean isIndicatorAnimationEnabled;
    private float itemAlpha;
    private float itemAlphaSelected;
    private float itemBlurRadius;
    private float itemCornerRadius;
    private int itemFillColor;
    private ColorStateList itemIconTint;
    private int itemLabelTextAppearance;
    private ColorStateList itemLabelTextColor;
    private int itemMaxWidth;
    private int itemPaddingHorizontal;
    private int itemSelectedColor;
    private int itemSpacing;
    private StepOSTabItemStyle itemStyleSnapshot;
    private boolean labelTextColorExplicit;
    private boolean latestPressChangedSelection;
    private StepOSTabItemView latestPressedItemView;
    private OnItemReselectedListener onItemReselectedListener;
    private OnItemSelectedListener onItemSelectedListener;
    private boolean pagerDrivenIndicator;
    private float pagerIndicatorOffset;
    private int pagerIndicatorPosition;
    private boolean pressLightEnabledValue;
    private boolean pressScaleEnabledValue;
    private int selectedItemIdValue;
    private InterfaceC5074l<? super StepOSTab, t> selectionCommittedHook;
    private final ArrayList<StepOSTab> tabs;
    private boolean touchTargetWarned;
    private boolean trackColorOverrides;
    private int visibleTabCount;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBar$Companion;", "", "<init>", "()V", "NO_ID", "", "INVALID_POSITION", "TAG", "", "selectedColorStateList", "Landroid/content/res/ColorStateList;", "selected", "unselected", "resolveAppThemeColor", "context", "Landroid/content/Context;", "ATTR_STEPOS_THEME_COLOR", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int resolveAppThemeColor(Context context) throws Exception {
            int identifier = context.getResources().getIdentifier(StepOSTabBar.ATTR_STEPOS_THEME_COLOR, "attr", context.getPackageName());
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(identifier != 0 ? new int[]{identifier, R$attr.colorPrimary} : new int[]{R$attr.colorPrimary});
            if (identifier != 0) {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
                        C4946a.a(typedArrayObtainStyledAttributes, null);
                        return color;
                    }
                } finally {
                }
            }
            int i10 = identifier == 0 ? 0 : 1;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                int color2 = typedArrayObtainStyledAttributes.getColor(i10, 0);
                C4946a.a(typedArrayObtainStyledAttributes, null);
                return color2;
            }
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            return androidx.core.content.a.c(context, R.color.stepos_system_blue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ColorStateList selectedColorStateList(int selected, int unselected) {
            return new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{android.R.attr.state_activated}, new int[0]}, new int[]{selected, selected, unselected});
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemReselectedListener;", "", "Lcom/stepos/widget/tabbar/StepOSTab;", "tab", "LY8/t;", "onItemReselected", "(Lcom/stepos/widget/tabbar/StepOSTab;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemReselectedListener {
        void onItemReselected(StepOSTab tab);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBar$OnItemSelectedListener;", "", "onItemSelected", "", "tab", "Lcom/stepos/widget/tabbar/StepOSTab;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnItemSelectedListener {
        boolean onItemSelected(StepOSTab tab);
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.widget.tabbar.StepOSTabBar$moveIndicator$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<Rect, t> {
        public AnonymousClass1(Object obj) {
            super(1, obj, StepOSTabBar.class, "layoutIndicator", "layoutIndicator(Landroid/graphics/Rect;)V", 0);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Rect rect) {
            invoke2(rect);
            return t.f7040a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Rect p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            ((StepOSTabBar) this.receiver).layoutIndicator(p02);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static /* synthetic */ void addTab$default(StepOSTabBar stepOSTabBar, StepOSTab stepOSTab, int i10, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addTab");
        }
        if ((i11 & 2) != 0) {
            i10 = stepOSTabBar.getTabCount();
        }
        if ((i11 & 4) != 0) {
            z10 = stepOSTabBar.getTabCount() == 0;
        }
        stepOSTabBar.addTab(stepOSTab, i10, z10);
    }

    private final void applySelection(int itemId, boolean animate, boolean updateIndicator) {
        StepOSTab stepOSTabFindTabById;
        if (this.selectedItemIdValue == itemId) {
            return;
        }
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:TabBar.applySelection");
        try {
            this.selectedItemIdValue = itemId;
            syncSelectionToViews(animate, updateIndicator);
            if (itemId != 0) {
                StepOSTabItemView stepOSTabItemViewFindItemView = findItemView(itemId);
                if (stepOSTabItemViewFindItemView != null) {
                    stepOSTabItemViewFindItemView.sendAccessibilityEvent(4);
                }
                InterfaceC5074l<? super StepOSTab, t> interfaceC5074l = this.selectionCommittedHook;
                if (interfaceC5074l != null && (stepOSTabFindTabById = findTabById(itemId)) != null) {
                    interfaceC5074l.invoke(stepOSTabFindTabById);
                }
                onSelectionCommitted(itemId);
            }
            t tVar = t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public static /* synthetic */ void applySelection$default(StepOSTabBar stepOSTabBar, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applySelection");
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        stepOSTabBar.applySelection(i10, z10, z11);
    }

    private final StepOSTabItemStyle buildItemStyle() {
        return new StepOSTabItemStyle(this.itemCornerRadius, this.itemBlurRadius, this.itemAlpha, this.itemAlphaSelected, this.itemFillColor, this.itemLabelTextColor, this.itemIconTint, this.itemLabelTextAppearance, this.itemPaddingHorizontal, this.isGlassEnabled, this.pressLightEnabledValue);
    }

    private final StepOSTabItemView createItemView(final StepOSTab tab) throws Resources.NotFoundException {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final StepOSTabItemView stepOSTabItemView = new StepOSTabItemView(context);
        stepOSTabItemView.applyStyle$StepOSWidget_release(currentItemStyle());
        stepOSTabItemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.tabbar.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31367a.onItemViewClicked(stepOSTabItemView, tab);
            }
        });
        boolean z10 = false;
        stepOSTabItemView.bind$StepOSWidget_release(tab, tab.getItemId() == this.selectedItemIdValue);
        int itemId = tab.getItemId();
        int i10 = this.selectedItemIdValue;
        if (itemId == i10 && i10 != 0) {
            z10 = true;
        }
        stepOSTabItemView.setTabSelected$StepOSWidget_release(z10);
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(stepOSTabItemView, this.pressScaleEnabledValue);
        return stepOSTabItemView;
    }

    private final StepOSTabItemStyle currentItemStyle() {
        StepOSTabItemStyle stepOSTabItemStyle = this.itemStyleSnapshot;
        if (stepOSTabItemStyle != null) {
            return stepOSTabItemStyle;
        }
        StepOSTabItemStyle stepOSTabItemStyleBuildItemStyle = buildItemStyle();
        this.itemStyleSnapshot = stepOSTabItemStyleBuildItemStyle;
        return stepOSTabItemStyleBuildItemStyle;
    }

    private final StepOSTabItemView findItemView(int itemId) {
        Iterator<StepOSTab> it = this.tabs.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (it.next().getItemId() == itemId) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return null;
        }
        return itemViewAt(i10);
    }

    private final void forEachItemView(InterfaceC5074l<? super StepOSTabItemView, t> action) {
        int size = this.tabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.invoke(itemViewAt(i10));
        }
    }

    private final StepOSTabItemView itemViewAt(float x10, float y10) {
        int size = this.tabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            StepOSTabItemView stepOSTabItemViewItemViewAt = itemViewAt(i10);
            if (stepOSTabItemViewItemViewAt.getVisibility() == 0 && stepOSTabItemViewItemViewAt.isEnabled() && x10 >= stepOSTabItemViewItemViewAt.getLeft() && x10 < stepOSTabItemViewItemViewAt.getRight() && y10 >= stepOSTabItemViewItemViewAt.getTop() && y10 < stepOSTabItemViewItemViewAt.getBottom()) {
                return stepOSTabItemViewItemViewAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void layoutIndicator(Rect bounds) {
        this.indicator.measure(View.MeasureSpec.makeMeasureSpec(bounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(bounds.height(), 1073741824));
        this.indicator.layout(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    private final void layoutIndicatorFromPage(int position, float offset) {
        if (position < 0 || position >= this.tabs.size()) {
            return;
        }
        StepOSTabItemView stepOSTabItemViewItemViewAt = itemViewAt(position);
        StepOSTabItemView stepOSTabItemView = null;
        if (stepOSTabItemViewItemViewAt.getWidth() <= 0 || stepOSTabItemViewItemViewAt.getVisibility() == 8) {
            stepOSTabItemViewItemViewAt = null;
        }
        if (stepOSTabItemViewItemViewAt == null) {
            return;
        }
        float fM = C5685n.m(offset, 0.0f, 1.0f);
        int i10 = position + 1;
        if (fM > 0.0f && i10 >= 0 && i10 < this.tabs.size()) {
            StepOSTabItemView stepOSTabItemViewItemViewAt2 = itemViewAt(i10);
            if (stepOSTabItemViewItemViewAt2.getWidth() > 0 && stepOSTabItemViewItemViewAt2.getVisibility() != 8) {
                stepOSTabItemView = stepOSTabItemViewItemViewAt2;
            }
        }
        if (stepOSTabItemView == null || fM == 0.0f) {
            this.indicatorCurrent.set(stepOSTabItemViewItemViewAt.getLeft(), stepOSTabItemViewItemViewAt.getTop(), stepOSTabItemViewItemViewAt.getRight(), stepOSTabItemViewItemViewAt.getBottom());
        } else {
            Rect rect = this.indicatorCurrent;
            TabIndicatorMover.Companion companion = TabIndicatorMover.INSTANCE;
            rect.set(companion.lerp$StepOSWidget_release(stepOSTabItemViewItemViewAt.getLeft(), stepOSTabItemView.getLeft(), fM), companion.lerp$StepOSWidget_release(stepOSTabItemViewItemViewAt.getTop(), stepOSTabItemView.getTop(), fM), companion.lerp$StepOSWidget_release(stepOSTabItemViewItemViewAt.getRight(), stepOSTabItemView.getRight(), fM), companion.lerp$StepOSWidget_release(stepOSTabItemViewItemViewAt.getBottom(), stepOSTabItemView.getBottom(), fM));
        }
        this.indicator.setVisibility(0);
        layoutIndicator(this.indicatorCurrent);
    }

    private final void moveIndicator(boolean animate) {
        this.pagerDrivenIndicator = false;
        int selectedPosition = getSelectedPosition();
        StepOSTabItemView stepOSTabItemView = null;
        if (selectedPosition >= 0) {
            StepOSTabItemView stepOSTabItemViewItemViewAt = itemViewAt(selectedPosition);
            if (stepOSTabItemViewItemViewAt.getWidth() > 0) {
                stepOSTabItemView = stepOSTabItemViewItemViewAt;
            }
        }
        if (stepOSTabItemView == null || stepOSTabItemView.getVisibility() == 8) {
            this.indicatorMover.cancel$StepOSWidget_release();
            this.indicator.setVisibility(8);
            this.indicator.releaseGlass$StepOSWidget_release();
        } else {
            this.indicatorTo.set(stepOSTabItemView.getLeft(), stepOSTabItemView.getTop(), stepOSTabItemView.getRight(), stepOSTabItemView.getBottom());
            boolean z10 = this.indicator.getVisibility() == 0 && this.indicator.getWidth() > 0;
            this.indicatorCurrent.set(this.indicator.getLeft(), this.indicator.getTop(), this.indicator.getRight(), this.indicator.getBottom());
            this.indicator.setVisibility(0);
            this.indicatorMover.move$StepOSWidget_release(this.indicatorCurrent, this.indicatorTo, z10, animate && this.isIndicatorAnimationEnabled, this.indicatorAnimationDuration, new AnonymousClass1(this));
        }
    }

    private final void onItemPressed(StepOSTabItemView itemView) {
        this.latestPressedItemView = itemView;
        this.latestPressChangedSelection = false;
        if (itemView == null) {
            return;
        }
        StepOSTab stepOSTab = (StepOSTab) F.t0(this.tabs, indexOfChild(itemView));
        if (stepOSTab != null && stepOSTab.getVisible() && stepOSTab.getEnabled() && stepOSTab.getItemId() != this.selectedItemIdValue && shouldSelectOnPressDown()) {
            OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
            if (onItemSelectedListener != null ? onItemSelectedListener.onItemSelected(stepOSTab) : true) {
                this.latestPressChangedSelection = true;
                applySelection$default(this, stepOSTab.getItemId(), true, false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemViewClicked(StepOSTabItemView itemView, StepOSTab tab) {
        StepOSTabItemView stepOSTabItemView = this.latestPressedItemView;
        if (stepOSTabItemView == null || stepOSTabItemView == itemView) {
            if (!(stepOSTabItemView == itemView && this.latestPressChangedSelection) && tab.getVisible() && tab.getEnabled()) {
                if (tab.getItemId() == this.selectedItemIdValue) {
                    OnItemReselectedListener onItemReselectedListener = this.onItemReselectedListener;
                    if (onItemReselectedListener != null) {
                        onItemReselectedListener.onItemReselected(tab);
                        return;
                    }
                    return;
                }
                OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
                if (onItemSelectedListener != null ? onItemSelectedListener.onItemSelected(tab) : true) {
                    applySelection$default(this, tab.getItemId(), true, false, 4, null);
                }
            }
        }
    }

    private final void refreshGlass() {
        boolean zApplyCustom$StepOSWidget_release;
        if (this.constructed && isAttachedToWindow()) {
            StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
            Trace.beginSection("StepOS:TabBar.refreshGlass");
            try {
                this.internalWrite = true;
                try {
                    super.setBackground(null);
                    if (!this.isGlassEnabled) {
                        this.glassDelegate.release$StepOSWidget_release();
                        zApplyCustom$StepOSWidget_release = false;
                    } else if (this.isGradientGlassEnabled) {
                        zApplyCustom$StepOSWidget_release = this.glassDelegate.applyGradientBlur$StepOSWidget_release(0, this.glassCornerRadius, this.gradientBlurRadius, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 8) != 0 ? BlurGradient.TOP_TO_BOTTOM : BlurGradient.TOP_TO_BOTTOM, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 16) != 0 ? null : null, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 32) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 64) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 128) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 256) != 0 ? 0.5f : 0.0f, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 512) != 0 ? BlurGradient.TOP_TO_BOTTOM : null);
                    } else {
                        final GlassCustomizer glassCustomizer = this.glassCustomizer;
                        y7.o oVar = this.glassEffect;
                        if (glassCustomizer != null) {
                            zApplyCustom$StepOSWidget_release = this.glassDelegate.applyCustom$StepOSWidget_release(0, this.glassCornerRadius, new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.f
                                @Override // p9.InterfaceC5074l
                                public final Object invoke(Object obj) {
                                    return StepOSTabBar.refreshGlass$lambda$48$lambda$46(glassCustomizer, (B) obj);
                                }
                            });
                        } else if (oVar != null) {
                            zApplyCustom$StepOSWidget_release = this.glassDelegate.apply$StepOSWidget_release(0, this.glassCornerRadius, oVar);
                        } else {
                            final GlassCustomizer glassCustomizerTAB_BAR_LIGHT_TUNED = getResources().getBoolean(R.bool.stepos_tabbar_glass_light) ? StepOSGlassPresets.INSTANCE.TAB_BAR_LIGHT_TUNED(getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.TAB_BAR_DARK_TUNED(getResources().getDisplayMetrics().density);
                            zApplyCustom$StepOSWidget_release = this.glassDelegate.applyCustom$StepOSWidget_release(0, this.glassCornerRadius, new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.g
                                @Override // p9.InterfaceC5074l
                                public final Object invoke(Object obj) {
                                    return StepOSTabBar.refreshGlass$lambda$48$lambda$47(glassCustomizerTAB_BAR_LIGHT_TUNED, (B) obj);
                                }
                            });
                        }
                    }
                    this.internalWrite = false;
                    if (!zApplyCustom$StepOSWidget_release && !this.isGradientGlassEnabled) {
                        super.setBackground(this.fallbackBackground);
                    }
                    invalidate();
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    this.internalWrite = false;
                    throw th;
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B refreshGlass$lambda$48$lambda$46(GlassCustomizer glassCustomizer, B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B refreshGlass$lambda$48$lambda$47(GlassCustomizer glassCustomizer, B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    private final void refreshItemStyle() {
        if (this.constructed) {
            StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
            Trace.beginSection("StepOS:TabBar.refreshItemStyle");
            try {
                final StepOSTabItemStyle stepOSTabItemStyleBuildItemStyle = buildItemStyle();
                this.itemStyleSnapshot = stepOSTabItemStyleBuildItemStyle;
                forEachItemView(new InterfaceC5074l() { // from class: com.stepos.widget.tabbar.h
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return StepOSTabBar.refreshItemStyle$lambda$34$lambda$33(stepOSTabItemStyleBuildItemStyle, (StepOSTabItemView) obj);
                    }
                });
                this.indicator.applyStyle$StepOSWidget_release(this.indicatorCornerRadius, this.indicatorBlurRadius, this.indicatorColor, this.itemSelectedColor, this.isGlassEnabled, this.pressLightEnabledValue);
                t tVar = t.f7040a;
            } finally {
                Trace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t refreshItemStyle$lambda$34$lambda$33(StepOSTabItemStyle stepOSTabItemStyle, StepOSTabItemView it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.applyStyle$StepOSWidget_release(stepOSTabItemStyle);
        return t.f7040a;
    }

    private final void reselectFallback() {
        Object next;
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            StepOSTab stepOSTab = (StepOSTab) next;
            if (stepOSTab.getVisible() && stepOSTab.getEnabled()) {
                break;
            }
        }
        StepOSTab stepOSTab2 = (StepOSTab) next;
        this.selectedItemIdValue = stepOSTab2 != null ? stepOSTab2.getItemId() : 0;
        syncSelectionToViews$default(this, false, false, 2, null);
    }

    private final void restoreBadges(int[] itemIds, int[] counts) {
        int iMin = Math.min(itemIds.length, counts.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            StepOSTab stepOSTabFindTabById = findTabById(itemIds[i10]);
            if (stepOSTabFindTabById != null) {
                stepOSTabFindTabById.setBadgeCount(counts[i10]);
            }
        }
    }

    private final void restoreSelection(int savedItemId) {
        if (savedItemId == 0) {
            applySelection$default(this, 0, false, false, 4, null);
            return;
        }
        StepOSTab stepOSTabFindTabById = findTabById(savedItemId);
        String str = stepOSTabFindTabById == null ? "已不存在（menu 变了 / 该项被移除）" : !stepOSTabFindTabById.getVisible() ? "已被隐藏" : !stepOSTabFindTabById.getEnabled() ? "已被禁用" : null;
        if (str == null) {
            this.selectedItemIdValue = savedItemId;
            syncSelectionToViews$default(this, false, false, 2, null);
            return;
        }
        Log.i(TAG, "状态恢复：itemId=0x" + Integer.toHexString(savedItemId) + " " + str + "，回落到第一个可见且可用的页签");
        reselectFallback();
    }

    private final void syncDerivedStateListsFromSelectedColor() {
        boolean z10 = this.trackColorOverrides;
        this.trackColorOverrides = false;
        try {
            if (!this.labelTextColorExplicit) {
                setItemLabelTextColor(INSTANCE.selectedColorStateList(this.itemSelectedColor, androidx.core.content.a.c(getContext(), R.color.stepos_tabbar_item_label_unselected)));
            }
            if (!this.iconTintExplicit) {
                setItemIconTint(INSTANCE.selectedColorStateList(this.itemSelectedColor, androidx.core.content.a.c(getContext(), R.color.stepos_tabbar_item_icon_unselected)));
            }
            this.trackColorOverrides = z10;
        } catch (Throwable th) {
            this.trackColorOverrides = z10;
            throw th;
        }
    }

    private final void syncSelectionToViews(boolean animate, boolean updateIndicator) {
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:TabBar.syncSelectionToViews");
        try {
            int size = this.tabs.size();
            for (int i10 = 0; i10 < size; i10++) {
                itemViewAt(i10).setTabSelected$StepOSWidget_release(this.selectedItemIdValue != 0 && this.tabs.get(i10).getItemId() == this.selectedItemIdValue);
            }
            if (updateIndicator) {
                moveIndicator(animate);
            }
            invalidate();
            t tVar = t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public static /* synthetic */ void syncSelectionToViews$default(StepOSTabBar stepOSTabBar, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncSelectionToViews");
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        stepOSTabBar.syncSelectionToViews(z10, z11);
    }

    private final void warnIfTouchTargetTooSmall(int itemW) throws Resources.NotFoundException {
        if (itemW <= 0) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_min_touch_target);
        boolean z10 = itemW < dimensionPixelSize;
        if (z10 == this.touchTargetWarned) {
            return;
        }
        this.touchTargetWarned = z10;
        if (z10) {
            Log.w(TAG, "页签项宽等分后只有 " + itemW + "px，低于无障碍触达区下限 " + dimensionPixelSize + "px：可见 " + this.visibleTabCount + " 项、itemMaxWidth=" + getItemMaxWidth() + "px、itemSpacing=" + getItemSpacing() + "px、可用宽度=" + getMeasuredWidth() + "px。项宽随项数等分是设计稿要求（TABBAR_DESIGN.md §2），控件不做滚动降级 —— 请减少项数，或给容器更大的宽度。");
        }
    }

    public final void addTab(StepOSTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        addTab$default(this, tab, 0, false, 6, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        kotlin.jvm.internal.p.i(child, "child");
        if (this.addingIndicator || (child instanceof StepOSTabItemView)) {
            super.addView(child, index, params);
            return;
        }
        throw new IllegalStateException(("StepOSTabBar 不接受外部子 View（收到 " + child.getClass().getName() + "）：页签项只能由 app:steposTabBarMenu / inflateMenu() / newTab()+addTab() 生成。要在页签旁边放别的 View 请用外层容器").toString());
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        kotlin.jvm.internal.p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        refreshGlass();
    }

    public final void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = null;
        refreshGlass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        kotlin.jvm.internal.p.i(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        kotlin.jvm.internal.p.i(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.p.i(r5, r0)
            int r0 = r5.getActionMasked()
            r1 = 0
            if (r0 == 0) goto L26
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L16
            r2 = 5
            if (r0 == r2) goto L26
            goto L40
        L16:
            boolean r0 = super.dispatchTouchEvent(r5)
            int r5 = r5.getPointerCount()
            if (r5 != r2) goto L25
            r5 = 0
            r4.latestPressedItemView = r5
            r4.latestPressChangedSelection = r1
        L25:
            return r0
        L26:
            int r0 = r5.getActionMasked()
            if (r0 != 0) goto L2d
            goto L31
        L2d:
            int r1 = r5.getActionIndex()
        L31:
            float r0 = r5.getX(r1)
            float r1 = r5.getY(r1)
            com.stepos.widget.tabbar.StepOSTabItemView r0 = r4.itemViewAt(r0, r1)
            r4.onItemPressed(r0)
        L40:
            boolean r4 = super.dispatchTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.tabbar.StepOSTabBar.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void endPagerIndicatorTracking$StepOSWidget_release() {
        if (this.pagerDrivenIndicator) {
            this.pagerDrivenIndicator = false;
            moveIndicator(false);
        }
    }

    public final StepOSTab findTabById(int itemId) {
        Object obj = null;
        if (itemId == 0) {
            return null;
        }
        Iterator<T> it = this.tabs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StepOSTab) next).getItemId() == itemId) {
                obj = next;
                break;
            }
        }
        return (StepOSTab) obj;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int childCount, int drawingPosition) {
        int selectedPosition = getSelectedPosition();
        if (selectedPosition >= 0 && selectedPosition < childCount) {
            int i10 = childCount - 1;
            if (drawingPosition == 0) {
                return i10;
            }
            if (drawingPosition == i10) {
                return selectedPosition;
            }
            int i11 = drawingPosition - 1;
            if (i11 < selectedPosition) {
                return i11;
            }
        }
        return drawingPosition;
    }

    public final boolean getConstructed() {
        return this.constructed;
    }

    public final float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public final y7.o getGlassEffect() {
        return this.glassEffect;
    }

    public final float getGradientBlurRadius() {
        return this.gradientBlurRadius;
    }

    public final int getIndicatorAnimationDuration() {
        return this.indicatorAnimationDuration;
    }

    public final float getIndicatorBlurRadius() {
        return this.indicatorBlurRadius;
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final float getIndicatorCornerRadius() {
        return this.indicatorCornerRadius;
    }

    public final float getItemAlpha() {
        return this.itemAlpha;
    }

    public final float getItemAlphaSelected() {
        return this.itemAlphaSelected;
    }

    public final float getItemBlurRadius() {
        return this.itemBlurRadius;
    }

    public final float getItemCornerRadius() {
        return this.itemCornerRadius;
    }

    public final int getItemFillColor() {
        return this.itemFillColor;
    }

    public int getItemHeightPx() {
        return getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_height);
    }

    public final ColorStateList getItemIconTint() {
        return this.itemIconTint;
    }

    public final int getItemLabelTextAppearance() {
        return this.itemLabelTextAppearance;
    }

    public final ColorStateList getItemLabelTextColor() {
        return this.itemLabelTextColor;
    }

    public int getItemMaxWidth() {
        return this.itemMaxWidth;
    }

    public final int getItemPaddingHorizontal() {
        return this.itemPaddingHorizontal;
    }

    public final int getItemSelectedColor() {
        return this.itemSelectedColor;
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public final OnItemReselectedListener getOnItemReselectedListener() {
        return this.onItemReselectedListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    /* renamed from: getSelectedItemId, reason: from getter */
    public final int getSelectedItemIdValue() {
        return this.selectedItemIdValue;
    }

    public final int getSelectedPosition() {
        if (this.selectedItemIdValue == 0) {
            return -1;
        }
        Iterator<StepOSTab> it = this.tabs.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (it.next().getItemId() == this.selectedItemIdValue) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return -1;
        }
        return i10;
    }

    public final InterfaceC5074l<StepOSTab, t> getSelectionCommittedHook$StepOSWidget_release() {
        return this.selectionCommittedHook;
    }

    public final StepOSTab getTabAt(int position) {
        return (StepOSTab) F.t0(this.tabs, position);
    }

    public final int getTabCount() {
        return this.tabs.size();
    }

    public final int indexOfTab$StepOSWidget_release(StepOSTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        return this.tabs.indexOf(tab);
    }

    public final void inflateMenu(int menuRes) throws Exception {
        StepOSTabMenuParser stepOSTabMenuParser = StepOSTabMenuParser.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        List<ParsedTabMenuItem> list = stepOSTabMenuParser.parse$StepOSWidget_release(context, menuRes);
        removeAllTabs();
        for (ParsedTabMenuItem parsedTabMenuItem : list) {
            StepOSTab itemId = newTab().setItemId(parsedTabMenuItem.getItemId());
            itemId.setTitle(parsedTabMenuItem.getTitle());
            if (parsedTabMenuItem.getIconResId() != 0) {
                itemId.setIcon(parsedTabMenuItem.getIconResId());
            }
            itemId.setContentDescription(parsedTabMenuItem.getContentDescription()).setVisible(parsedTabMenuItem.getVisible()).setEnabled(parsedTabMenuItem.getEnabled());
            addTab(itemId, getTabCount(), false);
        }
        reselectFallback();
    }

    public final boolean isGlassActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isGradientGlassEnabled, reason: from getter */
    public final boolean getIsGradientGlassEnabled() {
        return this.isGradientGlassEnabled;
    }

    /* renamed from: isIndicatorAnimationEnabled, reason: from getter */
    public final boolean getIsIndicatorAnimationEnabled() {
        return this.isIndicatorAnimationEnabled;
    }

    /* renamed from: isPressLightEnabled, reason: from getter */
    public final boolean getPressLightEnabledValue() {
        return this.pressLightEnabledValue;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    public int measureItemWidth(int widthMeasureSpec) {
        int itemSpacing;
        int i10 = this.visibleTabCount;
        if (i10 == 0) {
            return 0;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingStart()) - getPaddingEnd();
        boolean z10 = mode != 0 && size > 0 && (getItemMaxWidth() * i10) + (getItemSpacing() * (i10 + (-1))) > size;
        int itemSpacing2 = z10 ? (size - (getItemSpacing() * (i10 - 1))) / i10 : getItemMaxWidth();
        if (itemSpacing2 > 0) {
            int iMin = (!z10 || (itemSpacing = (i10 * itemSpacing2) + (getItemSpacing() * (i10 + (-1)))) >= size) ? 0 : Math.min(size - itemSpacing, i10);
            int size2 = this.tabs.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size2; i12++) {
                StepOSTabItemView stepOSTabItemViewItemViewAt = itemViewAt(i12);
                if (stepOSTabItemViewItemViewAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = stepOSTabItemViewItemViewAt.getLayoutParams();
                    kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    ((LinearLayout.LayoutParams) layoutParams).width = (i11 < iMin ? 1 : 0) + itemSpacing2;
                    i11++;
                }
            }
            return itemSpacing2;
        }
        throw new IllegalStateException(("算出的页签项宽是 " + itemSpacing2 + "px（≤ 0），画不出来。当前 itemMaxWidth=" + getItemMaxWidth() + "px、itemSpacing=" + getItemSpacing() + "px、可见 " + i10 + " 项、可用宽度=" + View.MeasureSpec.getSize(widthMeasureSpec) + "px、内边距=" + (getPaddingStart() + getPaddingEnd()) + "px。请检查这几项的取值").toString());
    }

    public final StepOSTab newTab() {
        return new StepOSTab(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshGlass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.indicatorMover.cancel$StepOSWidget_release();
        this.internalWrite = true;
        try {
            this.glassDelegate.release$StepOSWidget_release();
            this.internalWrite = false;
            super.setBackground(this.fallbackBackground);
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            this.internalWrite = false;
            throw th;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        C0.c.S0(info).o0(c.f.b(1, this.visibleTabCount, false, 1));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        super.onLayout(changed, l10, t10, r10, b10);
        if (this.pagerDrivenIndicator) {
            layoutIndicatorFromPage(this.pagerIndicatorPosition, this.pagerIndicatorOffset);
        } else {
            moveIndicator(false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Resources.NotFoundException {
        int iMeasureItemWidth = measureItemWidth(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        warnIfTouchTargetTooSmall(iMeasureItemWidth);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        restoreSelection(savedState.getSelectedItemId());
        restoreBadges(savedState.getBadgeItemIds(), savedState.getBadgeCounts());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        kotlin.jvm.internal.p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setSelectedItemId$StepOSWidget_release(this.selectedItemIdValue);
        ArrayList<StepOSTab> arrayList = this.tabs;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((StepOSTab) obj).getBadgeCount() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((StepOSTab) arrayList2.get(i10)).getItemId();
        }
        savedState.setBadgeItemIds$StepOSWidget_release(iArr);
        int size2 = arrayList2.size();
        int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            iArr2[i11] = ((StepOSTab) arrayList2.get(i11)).getBadgeCount();
        }
        savedState.setBadgeCounts$StepOSWidget_release(iArr2);
        return savedState;
    }

    public void onSelectionCommitted(int itemId) {
    }

    public final void onTabChanged$StepOSWidget_release(StepOSTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        int iIndexOf = this.tabs.indexOf(tab);
        if (iIndexOf < 0) {
            return;
        }
        itemViewAt(iIndexOf).bind$StepOSWidget_release(tab, tab.getItemId() == this.selectedItemIdValue);
        refreshItemLayout();
        if (tab.getItemId() == this.selectedItemIdValue) {
            if (tab.getVisible() && tab.getEnabled()) {
                return;
            }
            Log.i(TAG, "当前选中的页签 " + tab + " 变成不可见 / 不可用，选中态回落到第一个可见且可用的页签");
            reselectFallback();
        }
    }

    public final void onTabItemIdChanged$StepOSWidget_release(StepOSTab tab, int oldItemId) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (oldItemId == 0 || oldItemId != this.selectedItemIdValue) {
            return;
        }
        this.selectedItemIdValue = tab.getItemId();
    }

    public void refreshItemLayout() {
        StepOSTrace stepOSTrace = StepOSTrace.INSTANCE;
        Trace.beginSection("StepOS:TabBar.refreshItemLayout");
        try {
            int size = this.tabs.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                StepOSTab stepOSTab = this.tabs.get(i11);
                kotlin.jvm.internal.p.h(stepOSTab, "get(...)");
                StepOSTab stepOSTab2 = stepOSTab;
                StepOSTabItemView stepOSTabItemViewItemViewAt = itemViewAt(i11);
                ViewGroup.LayoutParams layoutParams = stepOSTabItemViewItemViewAt.getLayoutParams();
                kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.height = getItemHeightPx();
                layoutParams2.setMarginStart((!stepOSTab2.getVisible() || i10 <= 0) ? 0 : getItemSpacing());
                layoutParams2.setMarginEnd(0);
                stepOSTabItemViewItemViewAt.setLayoutParams(layoutParams2);
                if (stepOSTab2.getVisible()) {
                    stepOSTabItemViewItemViewAt.setVisibleIndex$StepOSWidget_release(i10);
                    i10++;
                }
            }
            this.visibleTabCount = i10;
            this.touchTargetWarned = false;
            requestLayout();
            t tVar = t.f7040a;
        } finally {
            Trace.endSection();
        }
    }

    public final void removeAllTabs() {
        Iterator<T> it = this.tabs.iterator();
        while (it.hasNext()) {
            ((StepOSTab) it.next()).setTabBar$StepOSWidget_release(null);
        }
        int size = this.tabs.size();
        this.tabs.clear();
        for (int i10 = 0; i10 < size; i10++) {
            itemViewAt(i10).releaseGlass$StepOSWidget_release();
        }
        this.latestPressedItemView = null;
        this.latestPressChangedSelection = false;
        if (size > 0) {
            removeViews(0, size);
        }
        this.visibleTabCount = 0;
        this.selectedItemIdValue = 0;
        this.touchTargetWarned = false;
        moveIndicator(false);
    }

    public final void removeTab(StepOSTab tab) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (tab.getTabBar() != this) {
            throw new IllegalArgumentException("tab 不属于本 StepOSTabBar，无法 removeTab");
        }
        int iIndexOf = this.tabs.indexOf(tab);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("tab 不在本 StepOSTabBar 里：可能从未 addTab，或已经被 removeTab 摘掉过");
        }
        removeTabAt(iIndexOf);
    }

    public final void removeTabAt(int position) {
        if (position < 0 || position >= this.tabs.size()) {
            throw new IllegalArgumentException(("position must be in 0.." + (this.tabs.size() - 1) + " but was " + position).toString());
        }
        StepOSTab stepOSTabRemove = this.tabs.remove(position);
        kotlin.jvm.internal.p.h(stepOSTabRemove, "removeAt(...)");
        StepOSTab stepOSTab = stepOSTabRemove;
        int itemId = stepOSTab.getItemId();
        int i10 = this.selectedItemIdValue;
        boolean z10 = itemId == i10 && i10 != 0;
        itemViewAt(position).releaseGlass$StepOSWidget_release();
        removeViewAt(position);
        this.latestPressedItemView = null;
        this.latestPressChangedSelection = false;
        stepOSTab.setTabBar$StepOSWidget_release(null);
        refreshItemLayout();
        if (z10) {
            reselectFallback();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (!this.constructed || this.internalWrite) {
            super.setBackground(background);
            return;
        }
        this.fallbackBackground = background;
        if (this.glassDelegate.getIsActive()) {
            Log.w(TAG, "setBackground() 被忽略：玻璃正生效，background 由 MotionKit 独占，挂上去会把模糊冲掉。已记为降级兜底背景，玻璃降级时自动生效。");
        } else {
            super.setBackground(background);
        }
    }

    public final void setConstructed(boolean z10) {
        this.constructed = z10;
    }

    public final void setGlassCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassCornerRadius == f10) {
            return;
        }
        this.glassCornerRadius = f10;
        invalidateOutline();
        if (this.constructed && isAttachedToWindow()) {
            if (!this.glassDelegate.getIsActive()) {
                refreshGlass();
                return;
            }
            this.internalWrite = true;
            try {
                this.glassDelegate.updateCornerRadius$StepOSWidget_release(f10);
            } finally {
                this.internalWrite = false;
            }
        }
    }

    public final void setGlassEffect(y7.o oVar) {
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        if (!kotlin.jvm.internal.p.d(this.glassEffect, oVar) || z10) {
            this.glassEffect = oVar;
            refreshGlass();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        refreshGlass();
        refreshItemStyle();
    }

    public final void setGradientBlurRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("gradientBlurRadius must be >= 0 but was " + f10).toString());
        }
        if (this.gradientBlurRadius == f10) {
            return;
        }
        this.gradientBlurRadius = f10;
        if (this.isGradientGlassEnabled) {
            refreshGlass();
        }
    }

    public final void setGradientGlassEnabled(boolean z10) {
        if (this.isGradientGlassEnabled == z10) {
            return;
        }
        this.isGradientGlassEnabled = z10;
        refreshGlass();
    }

    public final void setIndicatorAnimationDuration(int i10) {
        if (i10 >= 0) {
            this.indicatorAnimationDuration = i10;
            return;
        }
        throw new IllegalArgumentException(("indicatorAnimationDuration must be >= 0 ms but was " + i10).toString());
    }

    public final void setIndicatorAnimationEnabled(boolean z10) {
        this.isIndicatorAnimationEnabled = z10;
    }

    public final void setIndicatorBlurRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("indicatorBlurRadius must be >= 0 but was " + f10).toString());
        }
        if (this.indicatorBlurRadius == f10) {
            return;
        }
        this.indicatorBlurRadius = f10;
        refreshItemStyle();
    }

    public final void setIndicatorColor(int i10) {
        if (this.indicatorColor == i10) {
            return;
        }
        this.indicatorColor = i10;
        if (this.trackColorOverrides) {
            this.indicatorColorExplicit = true;
        }
        refreshItemStyle();
    }

    public final void setIndicatorCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("indicatorCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.indicatorCornerRadius == f10) {
            return;
        }
        this.indicatorCornerRadius = f10;
        refreshItemStyle();
    }

    public final void setIndicatorPositionFromPage$StepOSWidget_release(int position, float offset) {
        this.pagerDrivenIndicator = true;
        this.pagerIndicatorPosition = position;
        this.pagerIndicatorOffset = C5685n.m(offset, 0.0f, 1.0f);
        this.indicatorMover.cancel$StepOSWidget_release();
        layoutIndicatorFromPage(this.pagerIndicatorPosition, this.pagerIndicatorOffset);
    }

    public final void setItemAlpha(float f10) {
        if (0.0f > f10 || f10 > 1.0f) {
            throw new IllegalArgumentException(("itemAlpha must be in 0..1 but was " + f10).toString());
        }
        if (this.itemAlpha == f10) {
            return;
        }
        this.itemAlpha = f10;
        refreshItemStyle();
    }

    public final void setItemAlphaSelected(float f10) {
        if (0.0f > f10 || f10 > 1.0f) {
            throw new IllegalArgumentException(("itemAlphaSelected must be in 0..1 but was " + f10).toString());
        }
        if (this.itemAlphaSelected == f10) {
            return;
        }
        this.itemAlphaSelected = f10;
        refreshItemStyle();
    }

    public final void setItemBlurRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("itemBlurRadius must be >= 0 but was " + f10).toString());
        }
        if (this.itemBlurRadius == f10) {
            return;
        }
        this.itemBlurRadius = f10;
        refreshItemStyle();
    }

    public final void setItemCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("itemCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.itemCornerRadius == f10) {
            return;
        }
        this.itemCornerRadius = f10;
        refreshItemStyle();
    }

    public final void setItemFillColor(int i10) {
        if (this.itemFillColor == i10) {
            return;
        }
        this.itemFillColor = i10;
        refreshItemStyle();
    }

    public final void setItemIconTint(ColorStateList colorStateList) {
        if (this.itemIconTint == colorStateList) {
            return;
        }
        this.itemIconTint = colorStateList;
        if (this.trackColorOverrides) {
            this.iconTintExplicit = true;
        }
        refreshItemStyle();
    }

    public final void setItemLabelTextAppearance(int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("itemLabelTextAppearance 不能为 0，请传一个 @style 资源；恢复默认请传 R.style.StepOSTextAppearance_TabBar_Label");
        }
        if (this.itemLabelTextAppearance == i10) {
            return;
        }
        this.itemLabelTextAppearance = i10;
        refreshItemStyle();
    }

    public final void setItemLabelTextColor(ColorStateList colorStateList) {
        if (this.itemLabelTextColor == colorStateList) {
            return;
        }
        this.itemLabelTextColor = colorStateList;
        if (this.trackColorOverrides) {
            this.labelTextColorExplicit = true;
        }
        refreshItemStyle();
    }

    public void setItemMaxWidth(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("itemMaxWidth must be > 0 px but was " + i10).toString());
        }
        if (this.itemMaxWidth == i10) {
            return;
        }
        this.itemMaxWidth = i10;
        if (this.constructed) {
            refreshItemLayout();
        }
    }

    public final void setItemPaddingHorizontal(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemPaddingHorizontal must be >= 0 px but was " + i10).toString());
        }
        if (this.itemPaddingHorizontal == i10) {
            return;
        }
        this.itemPaddingHorizontal = i10;
        refreshItemStyle();
    }

    public final void setItemSelectedColor(int i10) {
        if (this.itemSelectedColor == i10) {
            return;
        }
        this.itemSelectedColor = i10;
        if (this.trackColorOverrides) {
            syncDerivedStateListsFromSelectedColor();
        }
        refreshItemStyle();
    }

    public final void setItemSelectedColorResource(int resId) {
        setItemSelectedColor(androidx.core.content.a.c(getContext(), resId));
    }

    public void setItemSpacing(int i10) {
        if (this.itemSpacing == i10) {
            return;
        }
        this.itemSpacing = i10;
        if (this.constructed) {
            refreshItemLayout();
        }
    }

    public final void setOnItemReselectedListener(OnItemReselectedListener onItemReselectedListener) {
        this.onItemReselectedListener = onItemReselectedListener;
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setPressLightEnabled(boolean z10) {
        if (this.pressLightEnabledValue == z10) {
            return;
        }
        this.pressLightEnabledValue = z10;
        if (!this.indicatorColorExplicit) {
            boolean z11 = this.trackColorOverrides;
            this.trackColorOverrides = false;
            try {
                setIndicatorColor(androidx.core.content.a.c(getContext(), z10 ? R.color.stepos_comp_background_selected_plus : R.color.stepos_comp_background_bar_selected));
                this.trackColorOverrides = z11;
            } catch (Throwable th) {
                this.trackColorOverrides = z11;
                throw th;
            }
        }
        refreshItemStyle();
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, z10);
    }

    public final void setSelectedItemId(int i10) {
        setSelectedItemId(i10, true);
    }

    public final void setSelectedItemId$StepOSWidget_release(int itemId, boolean animate, boolean updateIndicator) {
        if (itemId == 0) {
            applySelection(0, animate, updateIndicator);
            return;
        }
        StepOSTab stepOSTabFindTabById = findTabById(itemId);
        if (stepOSTabFindTabById == null) {
            throw new IllegalArgumentException(("本 StepOSTabBar 里没有 itemId=0x" + Integer.toHexString(itemId) + " 的页签（当前 tabCount=" + getTabCount() + "）。选中以 itemId 为身份，请确认已 addTab / inflateMenu").toString());
        }
        if (!stepOSTabFindTabById.getVisible()) {
            throw new IllegalArgumentException(("页签 " + stepOSTabFindTabById + " 当前不可见，无法选中它。请先 setVisible(true)，或改选别的页签").toString());
        }
        if (stepOSTabFindTabById.getEnabled()) {
            applySelection(itemId, animate, updateIndicator);
            return;
        }
        throw new IllegalArgumentException(("页签 " + stepOSTabFindTabById + " 当前不可用，无法选中它。请先 setEnabled(true)，或改选别的页签").toString());
    }

    public final void setSelectionCommittedHook$StepOSWidget_release(InterfaceC5074l<? super StepOSTab, t> interfaceC5074l) {
        this.selectionCommittedHook = interfaceC5074l;
    }

    public boolean shouldSelectOnPressDown() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void addTab(StepOSTab tab, int i10) {
        kotlin.jvm.internal.p.i(tab, "tab");
        addTab$default(this, tab, i10, false, 4, null);
    }

    public final void setSelectedItemId(int itemId, boolean animate) {
        setSelectedItemId$StepOSWidget_release(itemId, animate, true);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006\""}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabBar$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "selectedItemId", "I", "getSelectedItemId$StepOSWidget_release", "()I", "setSelectedItemId$StepOSWidget_release", "(I)V", "", "badgeItemIds", "[I", "getBadgeItemIds$StepOSWidget_release", "()[I", "setBadgeItemIds$StepOSWidget_release", "([I)V", "badgeCounts", "getBadgeCounts$StepOSWidget_release", "setBadgeCounts$StepOSWidget_release", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private int[] badgeCounts;
        private int[] badgeItemIds;
        private int selectedItemId;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.tabbar.StepOSTabBar$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSTabBar.SavedState[] newArray(int size) {
                return new StepOSTabBar.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSTabBar.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSTabBar.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSTabBar.SavedState createFromParcel(Parcel source) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSTabBar.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            kotlin.jvm.internal.p.i(superState, "superState");
            this.badgeItemIds = new int[0];
            this.badgeCounts = new int[0];
        }

        /* renamed from: getBadgeCounts$StepOSWidget_release, reason: from getter */
        public final int[] getBadgeCounts() {
            return this.badgeCounts;
        }

        /* renamed from: getBadgeItemIds$StepOSWidget_release, reason: from getter */
        public final int[] getBadgeItemIds() {
            return this.badgeItemIds;
        }

        /* renamed from: getSelectedItemId$StepOSWidget_release, reason: from getter */
        public final int getSelectedItemId() {
            return this.selectedItemId;
        }

        public final void setBadgeCounts$StepOSWidget_release(int[] iArr) {
            kotlin.jvm.internal.p.i(iArr, "<set-?>");
            this.badgeCounts = iArr;
        }

        public final void setBadgeItemIds$StepOSWidget_release(int[] iArr) {
            kotlin.jvm.internal.p.i(iArr, "<set-?>");
            this.badgeItemIds = iArr;
        }

        public final void setSelectedItemId$StepOSWidget_release(int i10) {
            this.selectedItemId = i10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            kotlin.jvm.internal.p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.selectedItemId);
            out.writeInt(this.badgeItemIds.length);
            for (int i10 : this.badgeItemIds) {
                out.writeInt(i10);
            }
            for (int i11 : this.badgeCounts) {
                out.writeInt(i11);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            int i10;
            super(source, classLoader);
            kotlin.jvm.internal.p.i(source, "source");
            this.badgeItemIds = new int[0];
            this.badgeCounts = new int[0];
            this.selectedItemId = source.readInt();
            if (source.dataAvail() >= 4 && (i10 = source.readInt()) > 0 && source.dataAvail() >= i10 * 8) {
                int[] iArr = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr[i11] = source.readInt();
                }
                this.badgeItemIds = iArr;
                int[] iArr2 = new int[i10];
                for (int i12 = 0; i12 < i10; i12++) {
                    iArr2[i12] = source.readInt();
                }
                this.badgeCounts = iArr2;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void addTab(StepOSTab tab, int position, boolean selectNow) {
        kotlin.jvm.internal.p.i(tab, "tab");
        if (tab.getTabBar() == this) {
            if (!this.tabs.contains(tab)) {
                if (tab.getItemId() != 0) {
                    if (findTabById(tab.getItemId()) == null) {
                        if (position >= 0 && position <= this.tabs.size()) {
                            if (selectNow && (!tab.getVisible() || !tab.getEnabled())) {
                                throw new IllegalArgumentException(("selectNow=true 但该页签当前不可见 / 不可用（visible=" + tab.getVisible() + ", enabled=" + tab.getEnabled() + "），无法选中它。请显式传 selectNow = false，或先 setVisible(true) / setEnabled(true)").toString());
                            }
                            this.tabs.add(position, tab);
                            addView(createItemView(tab), position, new LinearLayout.LayoutParams(getItemMaxWidth(), getItemHeightPx()));
                            refreshItemLayout();
                            if (selectNow) {
                                applySelection$default(this, tab.getItemId(), false, false, 4, null);
                                return;
                            }
                            return;
                        }
                        throw new IllegalArgumentException(("position must be in 0.." + this.tabs.size() + " but was " + position).toString());
                    }
                    throw new IllegalArgumentException("itemId 重复：本 StepOSTabBar 里已经有一个页签用了这个 id。同一个 TabBar 内 itemId 必须唯一");
                }
                throw new IllegalArgumentException("addTab 之前必须先 setItemId(...)：itemId 是页签的身份依据（选中、转屏恢复、与 ViewPager2 对齐都靠它），没有它这个页签永远无法被选中");
            }
            throw new IllegalArgumentException(("tab 已经在本 StepOSTabBar 里（position=" + this.tabs.indexOf(tab) + "），不能重复 addTab").toString());
        }
        throw new IllegalArgumentException("tab 不属于本 StepOSTabBar：请用本控件的 newTab() 创建句柄，不要把别的 TabBar 的 tab（或已被 removeTab 摘除的 tab）直接 addTab 过来");
    }

    public /* synthetic */ StepOSTabBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposTabBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_TabBar : i11);
    }

    private final StepOSTabItemView itemViewAt(int index) {
        View childAt = getChildAt(index);
        kotlin.jvm.internal.p.g(childAt, "null cannot be cast to non-null type com.stepos.widget.tabbar.StepOSTabItemView");
        return (StepOSTabItemView) childAt;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        int i12;
        int iResolveAppThemeColor;
        ColorStateList colorStateListSelectedColorStateList;
        ColorStateList colorStateListSelectedColorStateList2;
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: com.stepos.widget.tabbar.StepOSTabBar$glassOutlineProvider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.this$0.getGlassCornerRadius());
            }
        };
        this.glassOutlineProvider = viewOutlineProvider;
        StepOSTabIndicatorView stepOSTabIndicatorView = new StepOSTabIndicatorView(context);
        this.indicator = stepOSTabIndicatorView;
        this.indicatorMover = new TabIndicatorMover();
        this.indicatorTo = new Rect();
        this.indicatorCurrent = new Rect();
        this.tabs = new ArrayList<>();
        this.itemAlpha = 1.0f;
        this.itemAlphaSelected = 1.0f;
        this.isIndicatorAnimationEnabled = true;
        this.isGlassEnabled = true;
        this.pressScaleEnabledValue = true;
        setOrientation(0);
        Drawable background = getBackground();
        this.fallbackBackground = background == null ? androidx.core.content.a.e(context, R.drawable.stepos_bg_tabbar_container) : background;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSTabBar, i10, i11);
        try {
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabBar_steposGlassEnabled, true));
            GlassEffectResolver glassEffectResolver = GlassEffectResolver.INSTANCE;
            kotlin.jvm.internal.p.f(typedArrayObtainStyledAttributes);
            setGlassEffect(glassEffectResolver.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSTabBar_steposGlassEffect));
            setGlassCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSTabBar_steposGlassCornerRadius, getResources().getDimension(R.dimen.stepos_tabbar_glass_corner_radius)));
            setGradientBlurRadius(s0.h.g(getResources(), R.dimen.stepos_tabbar_gradient_blur_radius));
            setItemMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTabBar_steposTabBarItemMaxWidth, getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_max_width)));
            setItemSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTabBar_steposTabBarItemSpacing, getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_spacing)));
            setItemLabelTextAppearance(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabBar_steposTabBarItemLabelTextAppearance, R.style.StepOSTextAppearance_TabBar_Label));
            setItemPaddingHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTabBar_steposTabBarItemPaddingHorizontal, getResources().getDimensionPixelSize(R.dimen.stepos_tabbar_item_padding_horizontal)));
            setItemCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSTabBar_steposTabBarItemCornerRadius, getResources().getDimension(R.dimen.stepos_tabbar_item_corner_radius)));
            setIndicatorCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSTabBar_steposTabBarIndicatorCornerRadius, getResources().getDimension(R.dimen.stepos_tabbar_indicator_corner_radius)));
            setItemBlurRadius(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSTabBar_steposTabBarItemBlurRadius, s0.h.g(getResources(), R.dimen.stepos_tabbar_item_blur_radius)));
            setIndicatorBlurRadius(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSTabBar_steposTabBarIndicatorBlurRadius, s0.h.g(getResources(), R.dimen.stepos_tabbar_indicator_blur_radius)));
            setItemAlpha(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSTabBar_steposTabBarItemAlpha, s0.h.g(getResources(), R.dimen.stepos_tabbar_item_alpha)));
            setItemAlphaSelected(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSTabBar_steposTabBarItemAlphaSelected, s0.h.g(getResources(), R.dimen.stepos_tabbar_item_alpha_selected)));
            this.pressLightEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabBar_steposTabBarPressLightEnabled, false);
            setItemFillColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSTabBar_steposTabBarItemFillColor, androidx.core.content.a.c(context, R.color.stepos_tabbar_item_background)));
            int i13 = R.styleable.StepOSTabBar_steposTabBarIndicatorColor;
            this.indicatorColorExplicit = typedArrayObtainStyledAttributes.hasValue(i13);
            if (this.pressLightEnabledValue) {
                i12 = R.color.stepos_comp_background_selected_plus;
            } else {
                i12 = R.color.stepos_comp_background_bar_selected;
            }
            setIndicatorColor(typedArrayObtainStyledAttributes.getColor(i13, androidx.core.content.a.c(context, i12)));
            this.isIndicatorAnimationEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabBar_steposTabBarIndicatorAnimated, true);
            setIndicatorAnimationDuration(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSTabBar_steposTabBarIndicatorAnimationDuration, getResources().getInteger(R.integer.stepos_tabbar_indicator_animation_duration)));
            int i14 = R.styleable.StepOSTabBar_steposTabBarItemSelectedColor;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i14);
            int i15 = R.styleable.StepOSTabBar_steposTabBarItemLabelTextColor;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i15);
            int i16 = R.styleable.StepOSTabBar_steposTabBarItemIconTint;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i16);
            if (zHasValue) {
                iResolveAppThemeColor = typedArrayObtainStyledAttributes.getColor(i14, 0);
            } else {
                iResolveAppThemeColor = INSTANCE.resolveAppThemeColor(context);
            }
            setItemSelectedColor(iResolveAppThemeColor);
            if (zHasValue2) {
                colorStateListSelectedColorStateList = typedArrayObtainStyledAttributes.getColorStateList(i15);
            } else {
                colorStateListSelectedColorStateList = INSTANCE.selectedColorStateList(this.itemSelectedColor, androidx.core.content.a.c(context, R.color.stepos_tabbar_item_label_unselected));
            }
            setItemLabelTextColor(colorStateListSelectedColorStateList);
            if (zHasValue3) {
                colorStateListSelectedColorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(i16);
            } else {
                colorStateListSelectedColorStateList2 = INSTANCE.selectedColorStateList(this.itemSelectedColor, androidx.core.content.a.c(context, R.color.stepos_tabbar_item_icon_unselected));
            }
            setItemIconTint(colorStateListSelectedColorStateList2);
            this.labelTextColorExplicit = zHasValue2;
            this.iconTintExplicit = zHasValue3;
            this.trackColorOverrides = true;
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabBar_steposTabBarMenu, 0);
            this.pressScaleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabBar_steposPressScaleEnabled, true);
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            super.setBackground(null);
            this.addingIndicator = true;
            try {
                addView(stepOSTabIndicatorView, new LinearLayout.LayoutParams(0, 0));
                this.addingIndicator = false;
                setChildrenDrawingOrderEnabled(true);
                stepOSTabIndicatorView.setVisibility(8);
                setClipToOutline(true);
                setClipChildren(false);
                setOutlineProvider(viewOutlineProvider);
                setElevation(getResources().getDimension(R.dimen.stepos_tabbar_shadow_elevation));
                this.constructed = true;
                refreshItemStyle();
                if (resourceId != 0) {
                    inflateMenu(resourceId);
                }
            } catch (Throwable th) {
                this.addingIndicator = false;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                C4946a.a(typedArrayObtainStyledAttributes, th2);
                throw th3;
            }
        }
    }
}
