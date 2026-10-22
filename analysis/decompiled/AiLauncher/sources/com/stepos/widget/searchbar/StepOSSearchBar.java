package com.stepos.widget.searchbar;

import Z8.C1173v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.customview.view.AbsSavedState;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.GlassThemeKt;
import com.stepos.widget.glass.StepOSGlassPanel;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.StepOSCapsuleInputBase;
import com.stepos.widget.searchbar.StepOSSearchBar;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.B;

@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\bD\b\u0016\u0018\u0000 \u0080\u00022\u00020\u0001:\n\u0081\u0002\u0082\u0002\u0083\u0002\u0084\u0002\u0080\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0010J\u000f\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010\u0010J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0003¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u0010\u0010J\u000f\u00106\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u0010\u0010J\u000f\u00107\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u0010\u0010J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020,08H\u0014¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020,08H\u0014¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u000eH\u0014¢\u0006\u0004\b<\u0010\u0010J\u000f\u0010=\u001a\u00020\u000bH\u0014¢\u0006\u0004\b=\u0010\rJ\u000f\u0010>\u001a\u00020\u000bH\u0014¢\u0006\u0004\b>\u0010\rJ\u000f\u0010?\u001a\u00020\u000eH\u0014¢\u0006\u0004\b?\u0010\u0010J\u000f\u0010@\u001a\u00020\u000eH\u0007¢\u0006\u0004\b@\u0010\u0010J\u0015\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020 ¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u000e¢\u0006\u0004\bD\u0010\u0010J\u0017\u0010F\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bH\u0010GJ\u0017\u0010I\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bI\u0010GJ\u0017\u0010J\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010GJ\u0017\u0010K\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bK\u0010GJ\u000f\u0010L\u001a\u00020\u000eH\u0014¢\u0006\u0004\bL\u0010\u0010J\u0017\u0010P\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u000bH\u0001¢\u0006\u0004\bN\u0010OJ\u0017\u0010S\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0001¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u000e2\u0006\u00100\u001a\u00020,H\u0016¢\u0006\u0004\bT\u00102J\u000f\u0010U\u001a\u00020\u000eH\u0014¢\u0006\u0004\bU\u0010\u0010J\u000f\u0010V\u001a\u00020\u000eH\u0014¢\u0006\u0004\bV\u0010\u0010J\u000f\u0010W\u001a\u00020\u000eH\u0014¢\u0006\u0004\bW\u0010\u0010J\u0017\u0010Z\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020XH\u0014¢\u0006\u0004\bZ\u0010[J\u000f\u0010]\u001a\u00020\\H\u0014¢\u0006\u0004\b]\u0010^J\u0019\u0010`\u001a\u00020\u000e2\b\u0010_\u001a\u0004\u0018\u00010\\H\u0014¢\u0006\u0004\b`\u0010aR\u001a\u0010c\u001a\u00020b8\u0014X\u0094D¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bi\u0010hR\u0014\u0010j\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bj\u0010hR\u0014\u0010k\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bk\u0010hR\u0014\u0010l\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bl\u0010hR\u0014\u0010m\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bo\u0010hR\u0014\u0010p\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bp\u0010hR\u0014\u0010q\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bq\u0010hR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010vR\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010nR\u0018\u0010\u0097\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010vR\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010 \u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010vR\u0018\u0010¡\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010vR\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u009c\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009f\u0001R\u0018\u0010¤\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010vR\u0018\u0010¥\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010vR\u0018\u0010¦\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010vR\u0018\u0010§\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010vR\u0018\u0010¨\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010vR\u0018\u0010©\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010vR\u001e\u0010ª\u0001\u001a\u00020\u00168UX\u0094\u0004¢\u0006\u000f\n\u0005\bª\u0001\u0010n\u001a\u0006\b«\u0001\u0010¬\u0001R\u001d\u0010\u00ad\u0001\u001a\u00020\u00068UX\u0094\u0004¢\u0006\u000e\n\u0005\b\u00ad\u0001\u0010h\u001a\u0005\b®\u0001\u00104R\u0018\u0010¯\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010hR\u0018\u0010°\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010vR,\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010³\u0001\u001a\u0006\b¹\u0001\u0010µ\u0001\"\u0006\bº\u0001\u0010·\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010³\u0001\u001a\u0006\b¼\u0001\u0010µ\u0001\"\u0006\b½\u0001\u0010·\u0001R,\u0010¾\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010³\u0001\u001a\u0006\b¿\u0001\u0010µ\u0001\"\u0006\bÀ\u0001\u0010·\u0001R,\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R*\u0010Ë\u0001\u001a\u00020\u00062\t\b\u0001\u0010È\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÉ\u0001\u00104\"\u0005\bÊ\u0001\u0010GR\u0017\u0010Î\u0001\u001a\u00020,8TX\u0094\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R(\u0010Ï\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÏ\u0001\u0010\r\"\u0005\bÐ\u0001\u0010OR(\u0010Ñ\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÑ\u0001\u0010\r\"\u0005\bÒ\u0001\u0010OR(\u0010Ó\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÓ\u0001\u0010\r\"\u0005\bÔ\u0001\u0010OR(\u0010Õ\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0001\u0010\r\"\u0005\bÖ\u0001\u0010OR-\u0010Ú\u0001\u001a\u0004\u0018\u00010\u001d2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b×\u0001\u0010\u001f\"\u0006\bØ\u0001\u0010Ù\u0001R(\u0010Û\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÛ\u0001\u0010\r\"\u0005\bÜ\u0001\u0010OR-\u0010à\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010È\u0001\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bÝ\u0001\u0010\u0014\"\u0006\bÞ\u0001\u0010ß\u0001R0\u0010å\u0001\u001a\u0005\u0018\u00010\u009d\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010\u009d\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R,\u0010è\u0001\u001a\u00030\u009d\u00012\b\u0010È\u0001\u001a\u00030\u009d\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bæ\u0001\u0010â\u0001\"\u0006\bç\u0001\u0010ä\u0001R(\u0010é\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bé\u0001\u0010\r\"\u0005\bê\u0001\u0010OR(\u0010ë\u0001\u001a\u00020\u000b2\u0007\u0010È\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bë\u0001\u0010\r\"\u0005\bì\u0001\u0010OR-\u0010ï\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010È\u0001\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bí\u0001\u0010\u0014\"\u0006\bî\u0001\u0010ß\u0001R0\u0010ò\u0001\u001a\u0005\u0018\u00010\u009d\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010\u009d\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bð\u0001\u0010â\u0001\"\u0006\bñ\u0001\u0010ä\u0001R*\u0010õ\u0001\u001a\u00020\u00062\t\b\u0001\u0010È\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bó\u0001\u00104\"\u0005\bô\u0001\u0010GR*\u0010ø\u0001\u001a\u00020\u00062\t\b\u0001\u0010È\u0001\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bö\u0001\u00104\"\u0005\b÷\u0001\u0010GR0\u0010û\u0001\u001a\u0005\u0018\u00010\u009d\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010\u009d\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bù\u0001\u0010â\u0001\"\u0006\bú\u0001\u0010ä\u0001R\u0017\u0010ý\u0001\u001a\u00020,8@X\u0080\u0004¢\u0006\b\u001a\u0006\bü\u0001\u0010Í\u0001R\u0014\u0010ÿ\u0001\u001a\u00020,8G¢\u0006\b\u001a\u0006\bþ\u0001\u0010Í\u0001¨\u0006\u0085\u0002"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar;", "Lcom/stepos/widget/internal/StepOSCapsuleInputBase;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "shouldApplyNavigationGlass", "()Z", "LY8/t;", "refreshCapsuleGlassForCurrentMode", "()V", "applyCancelButtonTextColor", "Landroid/graphics/drawable/Drawable;", "createRowGlassFallbackDrawable", "()Landroid/graphics/drawable/Drawable;", "createNavigationSurfaceDrawable", "", "radius", "createNavigationRippleForeground", "(F)Landroid/graphics/drawable/Drawable;", "createTrailingButtonSurfaceDrawable", "createTrailingButtonRippleForeground", "createCapsuleGlassCoverDrawable", "Ly7/o;", "defaultLocalGlassEffect", "()Ly7/o;", "Lcom/stepos/widget/glass/GlassCustomizer;", "defaultTunedGlassCustomizer", "()Lcom/stepos/widget/glass/GlassCustomizer;", "applyNavigationButton", "applyRightSideButtons", "updateOuterLayout", "applyNavigationRowInsets", "applyTrailingButton", "onEndIconClicked", "forwardClickToCapsule", "Landroid/graphics/Canvas;", "canvas", "Landroid/view/View;", "target", "drawTransitionPiece", "(Landroid/graphics/Canvas;Landroid/view/View;)V", "child", "handleOuterChildRemoved", "(Landroid/view/View;)V", "defaultTransitionBackdropColor", "()I", "applyCancelGlass", "releaseCancelGlass", "requestCancelGlassRefresh", "", "touchDelegateSlots", "()Ljava/util/List;", "pressScaleTargets", "applyCapsuleSurface", "deferCapsuleCoverRevealToHost", "shouldApplyLocalGlass", "onEditTextRemoved", "refreshGlass", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "resId", "setNavigationButtonIconResource", "(I)V", "setCancelButtonTextResource", "setTrailingButtonResource", "setInputSurfaceResource", "setTransitionBackdropColorResource", "applyIcons", "holding", "setTransitionBackdropHolding$StepOSWidget_release", "(Z)V", "setTransitionBackdropHolding", "drawTransitionShapes$StepOSWidget_release", "(Landroid/graphics/Canvas;)V", "drawTransitionShapes", "onViewRemoved", "onAttachedToWindowExtra", "onDetachedFromWindowExtra", "onLayoutExtra", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChangedExtra", "(Landroid/content/res/Configuration;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "", "widgetLogTag", "Ljava/lang/String;", "getWidgetLogTag", "()Ljava/lang/String;", "defaultMinimumHeight", "I", "iconMarginStartSpacing", "cancelButtonSpacing", "navigationButtonSize", "navigationRowHeight", "navigationGlassCornerRadius", "F", "navigationButtonSpacing", "navigationButtonMarginStart", "navigationRowMarginEnd", "Landroid/content/res/ColorStateList;", "cancelButtonDefaultTextColors", "Landroid/content/res/ColorStateList;", "usesGlassCancelButtonTextColor", "Z", "Landroid/widget/LinearLayout;", "rowContentLayout", "Landroid/widget/LinearLayout;", "Lcom/stepos/widget/glass/StepOSGlassPanel;", "rowGlassPanel", "Lcom/stepos/widget/glass/StepOSGlassPanel;", "Landroid/graphics/Paint;", "transitionShapePaint", "Landroid/graphics/Paint;", "transitionBackdropHolding", "Landroid/graphics/RectF;", "transitionPieceRect", "Landroid/graphics/RectF;", "transitionBackdropView", "Landroid/view/View;", "Landroid/widget/FrameLayout;", "transitionHost", "Landroid/widget/FrameLayout;", "Lcom/stepos/widget/searchbar/SearchBarNavigationButton;", "navigationButtonView", "Lcom/stepos/widget/searchbar/SearchBarNavigationButton;", "trailingButtonView", "Landroid/widget/TextView;", "cancelButtonView", "Landroid/widget/TextView;", "Lcom/stepos/widget/glass/GlassDelegate;", "cancelGlassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/searchbar/StepOSSearchBar$GlassRequest;", "appliedCancelGlassRequest", "Lcom/stepos/widget/searchbar/StepOSSearchBar$GlassRequest;", "appliedCancelCornerRadius", "cancelGlassRefreshPosted", "Ljava/lang/Runnable;", "cancelGlassRefreshRunnable", "Ljava/lang/Runnable;", "navigationButtonIconValue", "Landroid/graphics/drawable/Drawable;", "", "navigationButtonIconContentDescriptionValue", "Ljava/lang/CharSequence;", "cancelButtonVisibleValue", "navigationButtonVisibleValue", "trailingButtonIconValue", "trailingButtonIconContentDescriptionValue", "trailingButtonVisibleValue", "navigationRowLayoutActive", "glassEnabledValue", "backdropBlurEnabledValue", "lightGlassEnabledValue", "darkGlassEnabledValue", "capsuleFlatElevationPx", "getCapsuleFlatElevationPx", "()F", "capsuleFlatSurfaceColor", "getCapsuleFlatSurfaceColor", "transitionBackdropColorValue", "transitionBackdropColorExplicit", "Lcom/stepos/widget/searchbar/StepOSSearchBar$OnIconClickListener;", "onStartIconClickListener", "Lcom/stepos/widget/searchbar/StepOSSearchBar$OnIconClickListener;", "getOnStartIconClickListener", "()Lcom/stepos/widget/searchbar/StepOSSearchBar$OnIconClickListener;", "setOnStartIconClickListener", "(Lcom/stepos/widget/searchbar/StepOSSearchBar$OnIconClickListener;)V", "onNavigationButtonClickListener", "getOnNavigationButtonClickListener", "setOnNavigationButtonClickListener", "onTrailingButtonClickListener", "getOnTrailingButtonClickListener", "setOnTrailingButtonClickListener", "onEndIconClickListener", "getOnEndIconClickListener", "setOnEndIconClickListener", "Lcom/stepos/widget/searchbar/StepOSSearchBar$OnCancelButtonClickListener;", "onCancelButtonClickListener", "Lcom/stepos/widget/searchbar/StepOSSearchBar$OnCancelButtonClickListener;", "getOnCancelButtonClickListener", "()Lcom/stepos/widget/searchbar/StepOSSearchBar$OnCancelButtonClickListener;", "setOnCancelButtonClickListener", "(Lcom/stepos/widget/searchbar/StepOSSearchBar$OnCancelButtonClickListener;)V", UxipConstants.f30680s, "getSearchBarInputHeight", "setSearchBarInputHeight", "searchBarInputHeight", "getEditTextInsertAnchor", "()Landroid/view/View;", "editTextInsertAnchor", "isGlassEnabled", "setGlassEnabled", "isBackdropBlurEnabled", "setBackdropBlurEnabled", "isLightGlassEnabled", "setLightGlassEnabled", "isDarkGlassEnabled", "setDarkGlassEnabled", "getGlassEffect", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "isNavigationButtonVisible", "setNavigationButtonVisible", "getNavigationButtonIcon", "setNavigationButtonIcon", "(Landroid/graphics/drawable/Drawable;)V", "navigationButtonIcon", "getNavigationButtonIconContentDescription", "()Ljava/lang/CharSequence;", "setNavigationButtonIconContentDescription", "(Ljava/lang/CharSequence;)V", "navigationButtonIconContentDescription", "getCancelButtonText", "setCancelButtonText", "cancelButtonText", "isCancelButtonVisible", "setCancelButtonVisible", "isTrailingButtonVisible", "setTrailingButtonVisible", "getTrailingButtonIcon", "setTrailingButtonIcon", "trailingButtonIcon", "getTrailingButtonIconContentDescription", "setTrailingButtonIconContentDescription", "trailingButtonIconContentDescription", "getInputSurfaceColor", "setInputSurfaceColor", "inputSurfaceColor", "getTransitionBackdropColor", "setTransitionBackdropColor", "transitionBackdropColor", "getStartIconContentDescription", "setStartIconContentDescription", "startIconContentDescription", "getTransitionSharedElement$StepOSWidget_release", "transitionSharedElement", "getSharedElementView", "sharedElementView", "Companion", "OnIconClickListener", "OnCancelButtonClickListener", "GlassRequest", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSSearchBar extends StepOSCapsuleInputBase {
    private static final Companion Companion = new Companion(null);
    private static final String FLASH_TAG = "StepOSGlassFlash";
    private float appliedCancelCornerRadius;
    private GlassRequest appliedCancelGlassRequest;
    private boolean backdropBlurEnabledValue;
    private ColorStateList cancelButtonDefaultTextColors;
    private final int cancelButtonSpacing;
    private final TextView cancelButtonView;
    private boolean cancelButtonVisibleValue;
    private final GlassDelegate cancelGlassDelegate;
    private boolean cancelGlassRefreshPosted;
    private final Runnable cancelGlassRefreshRunnable;
    private final float capsuleFlatElevationPx;
    private final int capsuleFlatSurfaceColor;
    private boolean darkGlassEnabledValue;
    private final int defaultMinimumHeight;
    private boolean glassEnabledValue;
    private final int iconMarginStartSpacing;
    private boolean lightGlassEnabledValue;
    private CharSequence navigationButtonIconContentDescriptionValue;
    private Drawable navigationButtonIconValue;
    private final int navigationButtonMarginStart;
    private final int navigationButtonSize;
    private final int navigationButtonSpacing;
    private final SearchBarNavigationButton navigationButtonView;
    private boolean navigationButtonVisibleValue;
    private final float navigationGlassCornerRadius;
    private final int navigationRowHeight;
    private boolean navigationRowLayoutActive;
    private final int navigationRowMarginEnd;
    private OnCancelButtonClickListener onCancelButtonClickListener;
    private OnIconClickListener onEndIconClickListener;
    private OnIconClickListener onNavigationButtonClickListener;
    private OnIconClickListener onStartIconClickListener;
    private OnIconClickListener onTrailingButtonClickListener;
    private final LinearLayout rowContentLayout;
    private final StepOSGlassPanel rowGlassPanel;
    private CharSequence trailingButtonIconContentDescriptionValue;
    private Drawable trailingButtonIconValue;
    private final SearchBarNavigationButton trailingButtonView;
    private boolean trailingButtonVisibleValue;
    private boolean transitionBackdropColorExplicit;
    private int transitionBackdropColorValue;
    private boolean transitionBackdropHolding;
    private final View transitionBackdropView;
    private final FrameLayout transitionHost;
    private final RectF transitionPieceRect;
    private final Paint transitionShapePaint;
    private boolean usesGlassCancelButtonTextColor;
    private final String widgetLogTag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar$Companion;", "", "<init>", "()V", "FLASH_TAG", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JP\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0019¨\u0006."}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar$GlassRequest;", "", "", "width", "height", "", "cornerRadius", "", "darkMode", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Z", "component5", "()Ly7/o;", "component6", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/searchbar/StepOSSearchBar$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getCornerRadius", "Z", "getDarkMode", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final float cornerRadius;
        private final GlassCustomizer customizer;
        private final boolean darkMode;
        private final y7.o effect;
        private final int height;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, boolean z10, y7.o oVar, GlassCustomizer glassCustomizer) {
            this.width = i10;
            this.height = i11;
            this.cornerRadius = f10;
            this.darkMode = z10;
            this.effect = oVar;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, boolean z10, y7.o oVar, GlassCustomizer glassCustomizer, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = glassRequest.width;
            }
            if ((i12 & 2) != 0) {
                i11 = glassRequest.height;
            }
            if ((i12 & 4) != 0) {
                f10 = glassRequest.cornerRadius;
            }
            if ((i12 & 8) != 0) {
                z10 = glassRequest.darkMode;
            }
            if ((i12 & 16) != 0) {
                oVar = glassRequest.effect;
            }
            if ((i12 & 32) != 0) {
                glassCustomizer = glassRequest.customizer;
            }
            y7.o oVar2 = oVar;
            GlassCustomizer glassCustomizer2 = glassCustomizer;
            return glassRequest.copy(i10, i11, f10, z10, oVar2, glassCustomizer2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component3, reason: from getter */
        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* renamed from: component5, reason: from getter */
        public final y7.o getEffect() {
            return this.effect;
        }

        /* renamed from: component6, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final GlassRequest copy(int width, int height, float cornerRadius, boolean darkMode, y7.o effect, GlassCustomizer customizer) {
            return new GlassRequest(width, height, cornerRadius, darkMode, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.cornerRadius, glassRequest.cornerRadius) == 0 && this.darkMode == glassRequest.darkMode && kotlin.jvm.internal.p.d(this.effect, glassRequest.effect) && kotlin.jvm.internal.p.d(this.customizer, glassRequest.customizer);
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final y7.o getEffect() {
            return this.effect;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            int iHashCode = ((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.cornerRadius)) * 31) + Boolean.hashCode(this.darkMode)) * 31;
            y7.o oVar = this.effect;
            int iHashCode2 = (iHashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode2 + (glassCustomizer != null ? glassCustomizer.hashCode() : 0);
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", cornerRadius=" + this.cornerRadius + ", darkMode=" + this.darkMode + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar$OnCancelButtonClickListener;", "", "LY8/t;", "onCancelButtonClick", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnCancelButtonClickListener {
        void onCancelButtonClick();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar$OnIconClickListener;", "", "LY8/t;", "onIconClick", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnIconClickListener {
        void onIconClick();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006\""}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchBar$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "endIconActivated", "Z", "getEndIconActivated$StepOSWidget_release", "()Z", "setEndIconActivated$StepOSWidget_release", "(Z)V", "cancelButtonVisible", "getCancelButtonVisible$StepOSWidget_release", "setCancelButtonVisible$StepOSWidget_release", "navigationButtonVisible", "getNavigationButtonVisible$StepOSWidget_release", "setNavigationButtonVisible$StepOSWidget_release", "trailingButtonVisible", "getTrailingButtonVisible$StepOSWidget_release", "setTrailingButtonVisible$StepOSWidget_release", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private boolean cancelButtonVisible;
        private boolean endIconActivated;
        private boolean navigationButtonVisible;
        private boolean trailingButtonVisible;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.searchbar.StepOSSearchBar$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSSearchBar.SavedState[] newArray(int size) {
                return new StepOSSearchBar.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSSearchBar.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSSearchBar.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSSearchBar.SavedState createFromParcel(Parcel source) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSSearchBar.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            kotlin.jvm.internal.p.i(superState, "superState");
        }

        /* renamed from: getCancelButtonVisible$StepOSWidget_release, reason: from getter */
        public final boolean getCancelButtonVisible() {
            return this.cancelButtonVisible;
        }

        /* renamed from: getEndIconActivated$StepOSWidget_release, reason: from getter */
        public final boolean getEndIconActivated() {
            return this.endIconActivated;
        }

        /* renamed from: getNavigationButtonVisible$StepOSWidget_release, reason: from getter */
        public final boolean getNavigationButtonVisible() {
            return this.navigationButtonVisible;
        }

        /* renamed from: getTrailingButtonVisible$StepOSWidget_release, reason: from getter */
        public final boolean getTrailingButtonVisible() {
            return this.trailingButtonVisible;
        }

        public final void setCancelButtonVisible$StepOSWidget_release(boolean z10) {
            this.cancelButtonVisible = z10;
        }

        public final void setEndIconActivated$StepOSWidget_release(boolean z10) {
            this.endIconActivated = z10;
        }

        public final void setNavigationButtonVisible$StepOSWidget_release(boolean z10) {
            this.navigationButtonVisible = z10;
        }

        public final void setTrailingButtonVisible$StepOSWidget_release(boolean z10) {
            this.trailingButtonVisible = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            kotlin.jvm.internal.p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.endIconActivated ? 1 : 0);
            out.writeInt(this.cancelButtonVisible ? 1 : 0);
            out.writeInt(this.navigationButtonVisible ? 1 : 0);
            out.writeInt(this.trailingButtonVisible ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            kotlin.jvm.internal.p.i(source, "source");
            this.endIconActivated = source.readInt() != 0;
            this.cancelButtonVisible = source.readInt() != 0;
            this.navigationButtonVisible = source.readInt() != 0;
            this.trailingButtonVisible = source.readInt() != 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$16(StepOSSearchBar stepOSSearchBar, View view) {
        OnIconClickListener onIconClickListener = stepOSSearchBar.onStartIconClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        } else {
            stepOSSearchBar.forwardClickToCapsule();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$18(StepOSSearchBar stepOSSearchBar, View view) {
        OnCancelButtonClickListener onCancelButtonClickListener = stepOSSearchBar.onCancelButtonClickListener;
        if (onCancelButtonClickListener != null) {
            onCancelButtonClickListener.onCancelButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$19(StepOSSearchBar stepOSSearchBar, View view) {
        OnIconClickListener onIconClickListener = stepOSSearchBar.onNavigationButtonClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$20(StepOSSearchBar stepOSSearchBar, View view) {
        OnIconClickListener onIconClickListener = stepOSSearchBar.onTrailingButtonClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        }
    }

    private final void applyCancelButtonTextColor() {
        if (this.usesGlassCancelButtonTextColor) {
            this.cancelButtonView.setTextColor(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_cancel_button_text_on_glass));
            return;
        }
        ColorStateList colorStateList = this.cancelButtonDefaultTextColors;
        if (colorStateList != null) {
            this.cancelButtonView.setTextColor(colorStateList);
        }
    }

    private final void applyCancelGlass() {
        int height = this.cancelButtonView.getHeight();
        if (isAttachedToWindow()) {
            if (!shouldApplyLocalGlass() || height <= 0 || this.cancelButtonView.getVisibility() != 0) {
                releaseCancelGlass();
                return;
            }
            int width = this.cancelButtonView.getWidth();
            float f10 = height / 2.0f;
            boolean zIsDarkMode = isDarkMode();
            y7.o glassEffectOverride = getGlassEffectOverride();
            if (glassEffectOverride == null) {
                glassEffectOverride = defaultLocalGlassEffect();
            }
            GlassRequest glassRequest = new GlassRequest(width, height, f10, zIsDarkMode, glassEffectOverride, getGlassCustomizer());
            if (kotlin.jvm.internal.p.d(glassRequest, this.appliedCancelGlassRequest)) {
                if (!this.cancelGlassDelegate.getHasHandle$StepOSWidget_release() || f10 == this.appliedCancelCornerRadius) {
                    return;
                }
                this.cancelGlassDelegate.updateCornerRadius$StepOSWidget_release(f10);
                this.appliedCancelCornerRadius = f10;
                return;
            }
            this.cancelButtonView.setBackground(null);
            final GlassCustomizer glassCustomizer = getGlassCustomizer();
            if (glassCustomizer == null) {
                glassCustomizer = defaultTunedGlassCustomizer();
            }
            if (glassCustomizer != null) {
                this.cancelGlassDelegate.applyCustom$StepOSWidget_release(0, f10, new InterfaceC5074l() { // from class: com.stepos.widget.searchbar.n
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return StepOSSearchBar.applyCancelGlass$lambda$36(glassCustomizer, (B) obj);
                    }
                });
            } else {
                y7.o glassEffectOverride2 = getGlassEffectOverride();
                if (glassEffectOverride2 == null) {
                    glassEffectOverride2 = defaultLocalGlassEffect();
                }
                this.cancelGlassDelegate.apply$StepOSWidget_release(0, f10, glassEffectOverride2);
            }
            this.appliedCancelCornerRadius = f10;
            this.appliedCancelGlassRequest = glassRequest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyCancelGlass$lambda$36(GlassCustomizer glassCustomizer, B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    private final void applyNavigationButton() {
        this.navigationButtonView.setImageDrawable(this.navigationButtonIconValue);
        this.navigationButtonView.setContentDescription(this.navigationButtonIconContentDescriptionValue);
        this.navigationButtonView.setVisibility((!this.navigationButtonVisibleValue || this.navigationButtonIconValue == null) ? 8 : 0);
        warnIfUnlabeled(this.navigationButtonView, "steposSearchBarNavigationButtonIconContentDescription");
    }

    private final void applyNavigationRowInsets() {
        boolean z10 = this.navigationRowLayoutActive;
        int i10 = z10 ? this.navigationButtonMarginStart : 0;
        int i11 = z10 ? this.navigationRowMarginEnd : 0;
        if (this.rowContentLayout.getPaddingStart() == i10 && this.rowContentLayout.getPaddingEnd() == i11) {
            return;
        }
        LinearLayout linearLayout = this.rowContentLayout;
        linearLayout.setPaddingRelative(i10, linearLayout.getPaddingTop(), i11, this.rowContentLayout.getPaddingBottom());
    }

    private final void applyRightSideButtons() {
        boolean z10 = this.trailingButtonVisibleValue && this.trailingButtonIconValue != null;
        this.cancelButtonView.setVisibility((!this.cancelButtonVisibleValue || z10) ? 8 : 0);
        this.trailingButtonView.setVisibility(z10 ? 0 : 8);
    }

    private final void applyTrailingButton() {
        this.trailingButtonView.setImageDrawable(copyDrawable(this.trailingButtonIconValue));
        this.trailingButtonView.setContentDescription(this.trailingButtonIconContentDescriptionValue);
        applyRightSideButtons();
        warnIfUnlabeled(this.trailingButtonView, "steposSearchBarTrailingButtonIconContentDescription");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelGlassRefreshRunnable$lambda$10(StepOSSearchBar stepOSSearchBar) {
        stepOSSearchBar.cancelGlassRefreshPosted = false;
        if (stepOSSearchBar.isAttachedToWindow()) {
            stepOSSearchBar.applyCancelGlass();
        }
    }

    private final Drawable createCapsuleGlassCoverDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(androidx.core.content.a.c(getContext(), R.color.stepos_comp_background_primary));
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.stepos_radius_full));
        return gradientDrawable;
    }

    private final Drawable createNavigationRippleForeground(float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(radius);
        return new RippleDrawable(ColorStateList.valueOf(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_navigation_ripple)), null, gradientDrawable);
    }

    private final Drawable createNavigationSurfaceDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_navigation_surface));
        return gradientDrawable;
    }

    private final Drawable createRowGlassFallbackDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_glass_surface));
        return gradientDrawable;
    }

    private final Drawable createTrailingButtonRippleForeground(float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(radius);
        return new RippleDrawable(ColorStateList.valueOf(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_trailing_ripple)), null, gradientDrawable);
    }

    private final Drawable createTrailingButtonSurfaceDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(androidx.core.content.a.c(getContext(), R.color.stepos_searchbar_trailing_surface));
        return gradientDrawable;
    }

    private final y7.o defaultLocalGlassEffect() {
        return isDarkMode() ? y7.o.INSTANCE.i() : y7.o.INSTANCE.k();
    }

    private final int defaultTransitionBackdropColor() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return GlassThemeKt.isVisuallyDark(context) ? -16777216 : -1;
    }

    private final GlassCustomizer defaultTunedGlassCustomizer() {
        if (getGlassEffect() != null) {
            return null;
        }
        return isDarkMode() ? StepOSGlassPresets.INSTANCE.TITLE_BAR_DARK_TUNED(getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.TITLE_BAR_LIGHT_TUNED(getResources().getDisplayMetrics().density);
    }

    private final void drawTransitionPiece(Canvas canvas, View target) {
        if (target.getWidth() <= 0 || target.getHeight() <= 0) {
            return;
        }
        float left = 0.0f;
        View view = target;
        float top = 0.0f;
        while (view != null && view != this.transitionHost) {
            left += view.getLeft();
            top += view.getTop();
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        float height = target.getHeight() / 2.0f;
        this.transitionPieceRect.set(left, top, target.getWidth() + left, target.getHeight() + top);
        canvas.drawRoundRect(this.transitionPieceRect, height, height, this.transitionShapePaint);
    }

    private final void forwardClickToCapsule() {
        if (getCapsuleLayout().performClick()) {
            return;
        }
        performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOuterChildRemoved(View child) {
        if (child == this.navigationButtonView || child == getCapsuleLayout() || child == this.cancelButtonView || child == this.trailingButtonView) {
            Log.w(getWidgetLogTag(), "内部结构被移出 StepOSSearchBar 的整行容器（多半是误调了 removeAllViews() / removeViewAt()）。调用方只应添加或移除自己的 EditText");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEndIconClicked() {
        EditText editTextValue = getEditTextValue();
        if (getAutoClearButtonEnabledValue() && getEndIconActivatedFlag() && editTextValue != null) {
            editTextValue.setText("");
            return;
        }
        OnIconClickListener onIconClickListener = this.onEndIconClickListener;
        if (onIconClickListener != null) {
            onIconClickListener.onIconClick();
        } else {
            forwardClickToCapsule();
        }
    }

    private final void refreshCapsuleGlassForCurrentMode() {
        this.navigationButtonView.refreshGlass();
        this.trailingButtonView.refreshGlass();
        if (shouldApplyLocalGlass()) {
            requestCapsuleGlassRefresh();
        } else {
            releaseCapsuleGlass();
        }
    }

    private final void releaseCancelGlass() {
        this.cancelGlassDelegate.release$StepOSWidget_release();
        this.appliedCancelGlassRequest = null;
        this.appliedCancelCornerRadius = Float.NaN;
    }

    private final void requestCancelGlassRefresh() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t rowGlassPanel$lambda$2$lambda$1(StepOSSearchBar stepOSSearchBar) {
        if (stepOSSearchBar.backdropBlurEnabledValue) {
            stepOSSearchBar.revealCapsuleCoverNow();
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldApplyNavigationGlass() {
        return !isDarkMode() || shouldApplyLocalGlass();
    }

    private final void updateOuterLayout() {
        boolean z10 = this.navigationButtonView.getVisibility() == 0;
        if (z10 || getHeight() >= this.navigationRowHeight) {
            this.navigationRowLayoutActive = true;
        }
        applyNavigationRowInsets();
        ViewGroup.LayoutParams layoutParams = this.navigationButtonView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.setMarginStart(0);
            layoutParams2.setMarginEnd(z10 ? this.navigationButtonSpacing : 0);
            this.navigationButtonView.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = getCapsuleLayout().getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.setMarginEnd(0);
            getCapsuleLayout().setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.cancelButtonView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams6 = layoutParams5 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.setMarginStart(this.cancelButtonView.getVisibility() == 0 ? this.cancelButtonSpacing : 0);
            layoutParams6.setMarginEnd(0);
            this.cancelButtonView.setLayoutParams(layoutParams6);
        }
        ViewGroup.LayoutParams layoutParams7 = this.trailingButtonView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams8 = layoutParams7 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams7 : null;
        if (layoutParams8 != null) {
            layoutParams8.setMarginStart(0);
            layoutParams8.setMarginEnd(0);
            this.trailingButtonView.setLayoutParams(layoutParams8);
        }
        setMinimumHeight(z10 ? Math.max(this.defaultMinimumHeight, this.navigationRowHeight) : this.defaultMinimumHeight);
        requestLayout();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void applyCapsuleSurface() {
        if (!shouldApplyLocalGlass()) {
            applyCapsuleFlatSurface();
            return;
        }
        applyCapsuleFlatElevation(false);
        StepOSCapsuleInputBase.CapsuleLayout capsuleLayout = getCapsuleLayout();
        Drawable drawableE = androidx.core.content.a.e(getContext(), R.drawable.stepos_bg_searchbar_input_glass);
        if (drawableE == null) {
            drawableE = getCapsuleFallbackBackground();
        }
        capsuleLayout.setBackground(drawableE);
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        kotlin.jvm.internal.p.i(customizer, "customizer");
        setGlassCustomizer(customizer);
        this.navigationButtonView.applyCustomGlass(customizer);
        this.trailingButtonView.applyCustomGlass(customizer);
        releaseCapsuleGlass();
        releaseCancelGlass();
        requestCapsuleGlassRefresh();
        requestCancelGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void applyIcons() {
        Drawable endIconValue;
        CharSequence endIconContentDescriptionValue;
        getStartIconView().setImageDrawable(getStartIconValue());
        getStartIconView().setVisibility(getStartIconValue() == null ? 8 : 0);
        androidx.core.widget.e.c(getStartIconView(), getIconTintValue());
        androidx.core.widget.e.c(this.navigationButtonView, getIconTintValue());
        androidx.core.widget.e.c(this.trailingButtonView, getIconTintValue());
        if (!getEndIconActivatedFlag() || (endIconValue = getEndIconActivatedValue()) == null) {
            endIconValue = getEndIconValue();
        }
        getEndIconView().setImageDrawable(endIconValue);
        getEndIconView().setVisibility(endIconValue == null ? 8 : 0);
        androidx.core.widget.e.c(getEndIconView(), getIconTintValue());
        ImageView endIconView = getEndIconView();
        if (!getEndIconActivatedFlag() || (endIconContentDescriptionValue = getEndIconActivatedContentDescriptionValue()) == null) {
            endIconContentDescriptionValue = getEndIconContentDescriptionValue();
        }
        endIconView.setContentDescription(endIconContentDescriptionValue);
        warnIfUnlabeled(getStartIconView(), "steposSearchBarStartIconContentDescription");
        warnIfUnlabeled(getEndIconView(), getEndIconActivatedFlag() ? "steposSearchBarEndIconActivatedContentDescription" : "steposSearchBarEndIconContentDescription");
    }

    public final void clearCustomGlass() {
        if (getGlassCustomizer() == null) {
            return;
        }
        setGlassCustomizer(null);
        this.navigationButtonView.clearCustomGlass();
        this.trailingButtonView.clearCustomGlass();
        releaseCapsuleGlass();
        releaseCancelGlass();
        requestCapsuleGlassRefresh();
        requestCancelGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public boolean deferCapsuleCoverRevealToHost() {
        return getBackdropBlurEnabledValue() && this.rowGlassPanel.isCoverPending$StepOSWidget_release();
    }

    public final void drawTransitionShapes$StepOSWidget_release(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        this.transitionShapePaint.setColor(this.transitionBackdropColorValue);
        drawTransitionPiece(canvas, getCapsuleLayout());
        if (this.navigationButtonView.getVisibility() == 0) {
            drawTransitionPiece(canvas, this.navigationButtonView);
        }
        if (this.trailingButtonView.getVisibility() == 0) {
            drawTransitionPiece(canvas, this.trailingButtonView);
        }
    }

    public final CharSequence getCancelButtonText() {
        CharSequence text = this.cancelButtonView.getText();
        kotlin.jvm.internal.p.h(text, "getText(...)");
        return text;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public float getCapsuleFlatElevationPx() {
        return this.capsuleFlatElevationPx;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public int getCapsuleFlatSurfaceColor() {
        return this.capsuleFlatSurfaceColor;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public View getEditTextInsertAnchor() {
        return getEndIconView();
    }

    public final y7.o getGlassEffect() {
        return getGlassEffectOverride();
    }

    public final int getInputSurfaceColor() {
        return getEffectiveCapsuleFlatSurfaceColor();
    }

    /* renamed from: getNavigationButtonIcon, reason: from getter */
    public final Drawable getNavigationButtonIconValue() {
        return this.navigationButtonIconValue;
    }

    /* renamed from: getNavigationButtonIconContentDescription, reason: from getter */
    public final CharSequence getNavigationButtonIconContentDescriptionValue() {
        return this.navigationButtonIconContentDescriptionValue;
    }

    public final OnCancelButtonClickListener getOnCancelButtonClickListener() {
        return this.onCancelButtonClickListener;
    }

    public final OnIconClickListener getOnEndIconClickListener() {
        return this.onEndIconClickListener;
    }

    public final OnIconClickListener getOnNavigationButtonClickListener() {
        return this.onNavigationButtonClickListener;
    }

    public final OnIconClickListener getOnStartIconClickListener() {
        return this.onStartIconClickListener;
    }

    public final OnIconClickListener getOnTrailingButtonClickListener() {
        return this.onTrailingButtonClickListener;
    }

    public final int getSearchBarInputHeight() {
        return getInputHeight();
    }

    public final View getSharedElementView() {
        return getCapsuleLayout();
    }

    public final CharSequence getStartIconContentDescription() {
        return getStartIconView().getContentDescription();
    }

    /* renamed from: getTrailingButtonIcon, reason: from getter */
    public final Drawable getTrailingButtonIconValue() {
        return this.trailingButtonIconValue;
    }

    /* renamed from: getTrailingButtonIconContentDescription, reason: from getter */
    public final CharSequence getTrailingButtonIconContentDescriptionValue() {
        return this.trailingButtonIconContentDescriptionValue;
    }

    /* renamed from: getTransitionBackdropColor, reason: from getter */
    public final int getTransitionBackdropColorValue() {
        return this.transitionBackdropColorValue;
    }

    public final View getTransitionSharedElement$StepOSWidget_release() {
        return this.transitionHost;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public String getWidgetLogTag() {
        return this.widgetLogTag;
    }

    /* renamed from: isBackdropBlurEnabled, reason: from getter */
    public final boolean getBackdropBlurEnabledValue() {
        return this.backdropBlurEnabledValue;
    }

    /* renamed from: isCancelButtonVisible, reason: from getter */
    public final boolean getCancelButtonVisibleValue() {
        return this.cancelButtonVisibleValue;
    }

    /* renamed from: isDarkGlassEnabled, reason: from getter */
    public final boolean getDarkGlassEnabledValue() {
        return this.darkGlassEnabledValue;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getGlassEnabledValue() {
        return this.glassEnabledValue;
    }

    /* renamed from: isLightGlassEnabled, reason: from getter */
    public final boolean getLightGlassEnabledValue() {
        return this.lightGlassEnabledValue;
    }

    /* renamed from: isNavigationButtonVisible, reason: from getter */
    public final boolean getNavigationButtonVisibleValue() {
        return this.navigationButtonVisibleValue;
    }

    /* renamed from: isTrailingButtonVisible, reason: from getter */
    public final boolean getTrailingButtonVisibleValue() {
        return this.trailingButtonVisibleValue;
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onAttachedToWindowExtra() {
        Log.i(FLASH_TAG, "searchBar attach id=" + System.identityHashCode(this) + " w=" + getWidth() + " h=" + getHeight() + " backdropBlur=" + getBackdropBlurEnabledValue());
        if (this.cancelGlassDelegate.getIsActive()) {
            return;
        }
        requestCancelGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onConfigurationChangedExtra(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        this.navigationButtonView.setSurfaceDrawable(createNavigationSurfaceDrawable());
        this.navigationButtonView.setForeground(createNavigationRippleForeground(this.navigationButtonSize / 2.0f));
        this.trailingButtonView.setSurfaceDrawable(createTrailingButtonSurfaceDrawable());
        this.trailingButtonView.setForeground(createTrailingButtonRippleForeground(getInputHeight() / 2.0f));
        this.cancelButtonDefaultTextColors = androidx.core.content.a.d(getContext(), R.color.stepos_searchbar_cancel_button_text);
        applyCancelButtonTextColor();
        if (!this.transitionBackdropColorExplicit) {
            this.transitionBackdropColorValue = defaultTransitionBackdropColor();
            if (this.transitionBackdropHolding) {
                this.transitionBackdropView.invalidate();
            }
        }
        if (getBackdropBlurEnabledValue()) {
            this.rowGlassPanel.setGlassEnabled(false);
            this.rowGlassPanel.setGlassEnabled(true);
        }
        releaseCancelGlass();
        requestCancelGlassRefresh();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onDetachedFromWindowExtra() {
        Log.i(FLASH_TAG, "searchBar detach id=" + System.identityHashCode(this) + " w=" + getWidth() + " h=" + getHeight());
        this.onCancelButtonClickListener = null;
        this.onNavigationButtonClickListener = null;
        this.onTrailingButtonClickListener = null;
        removeCallbacks(this.cancelGlassRefreshRunnable);
        this.cancelGlassRefreshPosted = false;
        releaseCancelGlass();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onEditTextRemoved() {
        syncClearButton();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public void onLayoutExtra() {
        if (getHeight() >= this.navigationRowHeight && !this.navigationRowLayoutActive) {
            this.navigationRowLayoutActive = true;
            updateOuterLayout();
        }
        requestCancelGlassRefresh();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setEndIconActivated(savedState.getEndIconActivated());
        setCancelButtonVisible(savedState.getCancelButtonVisible());
        setNavigationButtonVisible(savedState.getNavigationButtonVisible());
        setTrailingButtonVisible(savedState.getTrailingButtonVisible());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        kotlin.jvm.internal.p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setEndIconActivated$StepOSWidget_release(getEndIconActivatedFlag());
        savedState.setCancelButtonVisible$StepOSWidget_release(getCancelButtonVisibleValue());
        savedState.setNavigationButtonVisible$StepOSWidget_release(getNavigationButtonVisibleValue());
        savedState.setTrailingButtonVisible$StepOSWidget_release(getTrailingButtonVisibleValue());
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        kotlin.jvm.internal.p.i(child, "child");
        super.onViewRemoved(child);
        if (child == this.transitionHost) {
            Log.w(getWidgetLogTag(), "内部结构被移出 StepOSSearchBar（多半是误调了 removeAllViews() / removeViewAt()）。调用方只应添加或移除自己的 EditText；整行玻璃背板由控件自己维护");
        }
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public List<View> pressScaleTargets() {
        return C1173v.p(getCapsuleLayout(), this.navigationButtonView, this.cancelButtonView, this.trailingButtonView);
    }

    public final void refreshGlass() {
        this.navigationButtonView.refreshGlass();
        this.trailingButtonView.refreshGlass();
        releaseCapsuleGlass();
        requestCapsuleGlassRefresh();
        if (getBackdropBlurEnabledValue()) {
            this.rowGlassPanel.setGlassEnabled(false);
            this.rowGlassPanel.setGlassEnabled(true);
        }
    }

    public final void setBackdropBlurEnabled(boolean z10) {
        if (this.backdropBlurEnabledValue == z10) {
            return;
        }
        this.backdropBlurEnabledValue = z10;
        if (z10) {
            this.usesGlassCancelButtonTextColor = true;
        }
        this.rowGlassPanel.setGlassEnabled(z10);
        if (!z10) {
            this.rowGlassPanel.setBackground(null);
        }
        refreshCapsuleGlassForCurrentMode();
        applyCancelButtonTextColor();
    }

    public final void setCancelButtonText(CharSequence value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (kotlin.jvm.internal.p.d(this.cancelButtonView.getText(), value)) {
            return;
        }
        this.cancelButtonView.setText(value);
    }

    public final void setCancelButtonTextResource(int resId) {
        if (resId == 0) {
            throw new IllegalArgumentException("cancelButtonText resource id must not be 0");
        }
        setCancelButtonText(getContext().getText(resId));
    }

    public final void setCancelButtonVisible(boolean z10) {
        if (this.cancelButtonVisibleValue == z10) {
            return;
        }
        this.cancelButtonVisibleValue = z10;
        applyRightSideButtons();
        updateOuterLayout();
    }

    public final void setDarkGlassEnabled(boolean z10) {
        if (this.darkGlassEnabledValue == z10) {
            return;
        }
        this.darkGlassEnabledValue = z10;
        refreshCapsuleGlassForCurrentMode();
    }

    public final void setGlassEffect(y7.o oVar) {
        boolean z10 = getGlassCustomizer() != null;
        setGlassCustomizer(null);
        if (!kotlin.jvm.internal.p.d(getGlassEffectOverride(), oVar) || z10) {
            setGlassEffectOverride(oVar);
            this.navigationButtonView.setGlassEffect(oVar);
            this.navigationButtonView.clearCustomGlass();
            this.trailingButtonView.setGlassEffect(oVar);
            this.trailingButtonView.clearCustomGlass();
            releaseCapsuleGlass();
            releaseCancelGlass();
            requestCapsuleGlassRefresh();
            requestCancelGlassRefresh();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.glassEnabledValue == z10) {
            return;
        }
        this.glassEnabledValue = z10;
        refreshCapsuleGlassForCurrentMode();
    }

    public final void setInputSurfaceColor(int i10) {
        setCapsuleFlatSurfaceOverride(i10);
    }

    public final void setInputSurfaceResource(int resId) {
        setCapsuleFlatSurfaceOverride(androidx.core.content.a.c(getContext(), resId));
    }

    public final void setLightGlassEnabled(boolean z10) {
        if (this.lightGlassEnabledValue == z10) {
            return;
        }
        this.lightGlassEnabledValue = z10;
        refreshCapsuleGlassForCurrentMode();
    }

    public final void setNavigationButtonIcon(Drawable drawable) {
        if (this.navigationButtonIconValue == drawable) {
            return;
        }
        this.navigationButtonIconValue = drawable;
        applyNavigationButton();
        updateOuterLayout();
    }

    public final void setNavigationButtonIconContentDescription(CharSequence charSequence) {
        if (kotlin.jvm.internal.p.d(this.navigationButtonIconContentDescriptionValue, charSequence)) {
            return;
        }
        this.navigationButtonIconContentDescriptionValue = charSequence;
        this.navigationButtonView.setContentDescription(charSequence);
        warnIfUnlabeled(this.navigationButtonView, "steposSearchBarNavigationButtonIconContentDescription");
    }

    public final void setNavigationButtonIconResource(int resId) {
        setNavigationButtonIcon(resId == 0 ? null : androidx.core.content.a.e(getContext(), resId));
    }

    public final void setNavigationButtonVisible(boolean z10) {
        if (this.navigationButtonVisibleValue == z10) {
            return;
        }
        this.navigationButtonVisibleValue = z10;
        if (z10) {
            this.navigationRowLayoutActive = true;
        }
        applyNavigationButton();
        updateOuterLayout();
    }

    public final void setOnCancelButtonClickListener(OnCancelButtonClickListener onCancelButtonClickListener) {
        this.onCancelButtonClickListener = onCancelButtonClickListener;
    }

    public final void setOnEndIconClickListener(OnIconClickListener onIconClickListener) {
        this.onEndIconClickListener = onIconClickListener;
    }

    public final void setOnNavigationButtonClickListener(OnIconClickListener onIconClickListener) {
        this.onNavigationButtonClickListener = onIconClickListener;
    }

    public final void setOnStartIconClickListener(OnIconClickListener onIconClickListener) {
        this.onStartIconClickListener = onIconClickListener;
    }

    public final void setOnTrailingButtonClickListener(OnIconClickListener onIconClickListener) {
        this.onTrailingButtonClickListener = onIconClickListener;
    }

    public final void setSearchBarInputHeight(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("searchBarInputHeight must be > 0 but was " + i10).toString());
        }
        if (getInputHeight() == i10) {
            return;
        }
        setInputHeight(i10);
        ViewGroup.LayoutParams layoutParams = getCapsuleLayout().getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.height = i10;
            getCapsuleLayout().setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.cancelButtonView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.height = i10;
            this.cancelButtonView.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.trailingButtonView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams6 = layoutParams5 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.height = i10;
            this.trailingButtonView.setLayoutParams(layoutParams6);
        }
        applyTrailingButton();
        refreshCapsuleGlassForCurrentMode();
        refreshTouchDelegates();
        requestLayout();
    }

    public final void setStartIconContentDescription(CharSequence charSequence) {
        getStartIconView().setContentDescription(charSequence);
    }

    public final void setTrailingButtonIcon(Drawable drawable) {
        if (this.trailingButtonIconValue == drawable) {
            return;
        }
        this.trailingButtonIconValue = drawable;
        applyTrailingButton();
        updateOuterLayout();
    }

    public final void setTrailingButtonIconContentDescription(CharSequence charSequence) {
        if (kotlin.jvm.internal.p.d(this.trailingButtonIconContentDescriptionValue, charSequence)) {
            return;
        }
        this.trailingButtonIconContentDescriptionValue = charSequence;
        applyTrailingButton();
    }

    public final void setTrailingButtonResource(int resId) {
        setTrailingButtonIcon(resId == 0 ? null : androidx.core.content.a.e(getContext(), resId));
    }

    public final void setTrailingButtonVisible(boolean z10) {
        if (this.trailingButtonVisibleValue == z10) {
            return;
        }
        this.trailingButtonVisibleValue = z10;
        applyRightSideButtons();
        updateOuterLayout();
    }

    public final void setTransitionBackdropColor(int i10) {
        this.transitionBackdropColorExplicit = true;
        if (this.transitionBackdropColorValue == i10) {
            return;
        }
        this.transitionBackdropColorValue = i10;
        if (this.transitionBackdropHolding) {
            this.transitionBackdropView.invalidate();
        }
    }

    public final void setTransitionBackdropColorResource(int resId) {
        setTransitionBackdropColor(androidx.core.content.a.c(getContext(), resId));
    }

    public final void setTransitionBackdropHolding$StepOSWidget_release(boolean holding) {
        if (this.transitionBackdropHolding == holding) {
            return;
        }
        this.transitionBackdropHolding = holding;
        this.transitionBackdropView.invalidate();
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public boolean shouldApplyLocalGlass() {
        return getGlassEnabledValue() || getGlassCustomizer() != null || getGlassEffectOverride() != null || (isDarkMode() ? this.darkGlassEnabledValue : this.lightGlassEnabledValue);
    }

    @Override // com.stepos.widget.internal.StepOSCapsuleInputBase
    public List<View> touchDelegateSlots() {
        return C1173v.p(this.navigationButtonView, getStartIconView(), getEndIconView(), this.cancelButtonView, this.trailingButtonView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSSearchBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposSearchBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_SearchBar : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar(final Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11, StepOSSearchBarKt.resolveSearchBarInputHeight(context, attributeSet, i10, i11), context.getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_icon_slot_size), context.getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_icon_size), context.getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_icon_text_spacing));
        kotlin.jvm.internal.p.i(context, "context");
        this.widgetLogTag = "StepOSSearchBar";
        this.defaultMinimumHeight = getMinimumHeight();
        this.iconMarginStartSpacing = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_icon_start_spacing);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_cancel_button_spacing);
        this.cancelButtonSpacing = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_navigation_button_size);
        this.navigationButtonSize = dimensionPixelSize2;
        this.navigationRowHeight = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_navigation_row_height);
        float dimension = getResources().getDimension(R.dimen.stepos_searchbar_navigation_glass_corner_radius);
        this.navigationGlassCornerRadius = dimension;
        this.navigationButtonSpacing = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_navigation_button_spacing);
        this.navigationButtonMarginStart = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_navigation_button_margin_start);
        this.navigationRowMarginEnd = getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_navigation_row_margin_end);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: com.stepos.widget.searchbar.StepOSSearchBar$rowContentLayout$1
            @Override // android.view.ViewGroup
            public void onViewRemoved(View child) {
                kotlin.jvm.internal.p.i(child, "child");
                super.onViewRemoved(child);
                this.handleOuterChildRemoved(child);
            }
        };
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.rowContentLayout = linearLayout;
        StepOSGlassPanel stepOSGlassPanel = new StepOSGlassPanel(context, null, 0, 0, 14, null);
        stepOSGlassPanel.setScrimDrawable(null);
        stepOSGlassPanel.setScrimEnabled(false);
        stepOSGlassPanel.setGlassCornerRadius(0.0f);
        stepOSGlassPanel.setBlurUniform(true);
        stepOSGlassPanel.setGlassEnabled(false);
        stepOSGlassPanel.setOnCoverRevealedListener$StepOSWidget_release(new InterfaceC5063a() { // from class: com.stepos.widget.searchbar.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSSearchBar.rowGlassPanel$lambda$2$lambda$1(this.f31338a);
            }
        });
        this.rowGlassPanel = stepOSGlassPanel;
        this.transitionShapePaint = new Paint(1);
        this.transitionPieceRect = new RectF();
        View view = new View(context) { // from class: com.stepos.widget.searchbar.StepOSSearchBar$transitionBackdropView$1
            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                kotlin.jvm.internal.p.i(canvas, "canvas");
                if (this.transitionBackdropHolding) {
                    this.drawTransitionShapes$StepOSWidget_release(canvas);
                }
            }
        };
        view.setImportantForAccessibility(2);
        view.setClickable(false);
        view.setWillNotDraw(false);
        this.transitionBackdropView = view;
        FrameLayout frameLayout = new FrameLayout(context) { // from class: com.stepos.widget.searchbar.StepOSSearchBar$transitionHost$1
            @Override // android.widget.FrameLayout, android.view.View
            public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                measureChild(this.rowGlassPanel, widthMeasureSpec, heightMeasureSpec);
                int measuredWidth = this.rowGlassPanel.getMeasuredWidth();
                int measuredHeight = this.rowGlassPanel.getMeasuredHeight();
                this.transitionBackdropView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        };
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.transitionHost = frameLayout;
        SearchBarNavigationButton searchBarNavigationButton = new SearchBarNavigationButton(context, new InterfaceC5063a() { // from class: com.stepos.widget.searchbar.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(this.f31339a.shouldApplyNavigationGlass());
            }
        });
        searchBarNavigationButton.setId(R.id.stepos_searchbar_navigation_button);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        searchBarNavigationButton.setScaleType(scaleType);
        searchBarNavigationButton.setClickable(true);
        searchBarNavigationButton.setFocusable(true);
        searchBarNavigationButton.setGlassCornerRadius(dimension);
        searchBarNavigationButton.setSurfaceDrawable(createNavigationSurfaceDrawable());
        searchBarNavigationButton.setForeground(createNavigationRippleForeground(dimensionPixelSize2 / 2.0f));
        searchBarNavigationButton.setVisibility(8);
        this.navigationButtonView = searchBarNavigationButton;
        SearchBarNavigationButton searchBarNavigationButton2 = new SearchBarNavigationButton(context, new InterfaceC5063a() { // from class: com.stepos.widget.searchbar.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(this.f31340a.shouldApplyNavigationGlass());
            }
        });
        searchBarNavigationButton2.setId(R.id.stepos_searchbar_trailing_button);
        searchBarNavigationButton2.setScaleType(scaleType);
        searchBarNavigationButton2.setClickable(true);
        searchBarNavigationButton2.setFocusable(true);
        searchBarNavigationButton2.setSurfaceDrawable(createTrailingButtonSurfaceDrawable());
        searchBarNavigationButton2.setForeground(createTrailingButtonRippleForeground(getInputHeight() / 2.0f));
        searchBarNavigationButton2.setVisibility(8);
        this.trailingButtonView = searchBarNavigationButton2;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context) { // from class: com.stepos.widget.searchbar.StepOSSearchBar$cancelButtonView$1
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                String name = Button.class.getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                return name;
            }
        };
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextAppearance(R.style.StepOSTextAppearance_SearchBar_Cancel);
        appCompatTextView.setBackground(null);
        appCompatTextView.setClickable(true);
        appCompatTextView.setFocusable(true);
        appCompatTextView.setSingleLine(true);
        appCompatTextView.setMinimumWidth(0);
        appCompatTextView.setMinimumHeight(0);
        appCompatTextView.setPaddingRelative(appCompatTextView.getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_cancel_button_padding_start), 0, 0, 0);
        appCompatTextView.setVisibility(8);
        this.cancelButtonView = appCompatTextView;
        this.cancelGlassDelegate = new GlassDelegate(appCompatTextView);
        this.appliedCancelCornerRadius = Float.NaN;
        this.cancelGlassRefreshRunnable = new Runnable() { // from class: com.stepos.widget.searchbar.h
            @Override // java.lang.Runnable
            public final void run() {
                StepOSSearchBar.cancelGlassRefreshRunnable$lambda$10(this.f31341a);
            }
        };
        this.lightGlassEnabledValue = true;
        this.darkGlassEnabledValue = true;
        this.capsuleFlatElevationPx = getResources().getDimension(R.dimen.stepos_searchbar_input_elevation);
        this.capsuleFlatSurfaceColor = androidx.core.content.a.c(context, R.color.stepos_searchbar_input_surface);
        this.transitionBackdropColorValue = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        layoutParams.gravity = 16;
        Y8.t tVar = Y8.t.f7040a;
        linearLayout.addView(searchBarNavigationButton, 0, layoutParams);
        StepOSCapsuleInputBase.CapsuleLayout capsuleLayout = getCapsuleLayout();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getInputHeight(), 1.0f);
        layoutParams2.gravity = 16;
        linearLayout.addView(capsuleLayout, 1, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, getInputHeight());
        layoutParams3.gravity = 16;
        layoutParams3.setMarginStart(dimensionPixelSize);
        linearLayout.addView(appCompatTextView, 2, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getInputHeight(), getInputHeight());
        layoutParams4.gravity = 16;
        linearLayout.addView(searchBarNavigationButton2, 3, layoutParams4);
        stepOSGlassPanel.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(stepOSGlassPanel, new FrameLayout.LayoutParams(-1, -1));
        addStructuralView(frameLayout, 0, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSSearchBar, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setIconTintValue(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSSearchBar_steposSearchBarIconTint));
        setStartIconValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSearchBar_steposSearchBarStartIcon));
        setEndIconValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSearchBar_steposSearchBarEndIcon));
        setEndIconActivatedValue(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSearchBar_steposSearchBarEndIconActivated));
        this.navigationButtonIconValue = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSearchBar_steposSearchBarNavigationButtonIcon);
        this.navigationButtonIconContentDescriptionValue = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarNavigationButtonIconContentDescription);
        setAutoClearButtonEnabledValue(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarAutoClearButton, true));
        getStartIconView().setContentDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarStartIconContentDescription));
        setEndIconContentDescriptionValue(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarEndIconContentDescription));
        setEndIconActivatedContentDescriptionValue(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarEndIconActivatedContentDescription));
        CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarCancelButtonText);
        if (text == null) {
            text = context.getText(android.R.string.cancel);
            kotlin.jvm.internal.p.h(text, "getText(...)");
        }
        setCancelButtonText(text);
        setCancelButtonVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarCancelButtonVisible, false));
        this.navigationButtonVisibleValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarNavigationButtonVisible, false);
        this.trailingButtonIconValue = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSearchBar_steposSearchBarTrailingButtonIcon);
        this.trailingButtonIconContentDescriptionValue = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSearchBar_steposSearchBarTrailingButtonIconContentDescription);
        this.trailingButtonVisibleValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarTrailingButtonVisible, false);
        this.glassEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarGlassEnabled, false);
        this.lightGlassEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarGlassEnabledLight, true);
        this.darkGlassEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposSearchBarGlassEnabledDark, true);
        this.backdropBlurEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposBackdropBlurEnabled, false);
        y7.o oVar = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSSearchBar_steposGlassEffect);
        setPressScaleEnabledValue(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchBar_steposPressScaleEnabled, false));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSSearchBar_steposSearchBarInputSurface, 0);
        int i12 = R.styleable.StepOSSearchBar_steposSearchBarTransitionBackdropColor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.transitionBackdropColorExplicit = true;
            this.transitionBackdropColorValue = typedArrayObtainStyledAttributes.getColor(i12, defaultTransitionBackdropColor());
        } else {
            this.transitionBackdropColorValue = defaultTransitionBackdropColor();
        }
        typedArrayObtainStyledAttributes.recycle();
        setGlassEffectOverride(oVar);
        if (color != 0) {
            setCapsuleFlatSurfaceOverride(color);
        }
        searchBarNavigationButton.setGlassEffect(oVar);
        searchBarNavigationButton2.setGlassEffect(oVar);
        this.cancelButtonDefaultTextColors = appCompatTextView.getTextColors();
        this.usesGlassCancelButtonTextColor = this.backdropBlurEnabledValue;
        applyNavigationButton();
        applyTrailingButton();
        applyRightSideButtons();
        updateOuterLayout();
        if (this.backdropBlurEnabledValue) {
            stepOSGlassPanel.setGlassEnabled(true);
            if (shouldApplyLocalGlass()) {
                getCapsuleLayout().setBackground(createCapsuleGlassCoverDrawable());
            } else {
                applyCapsuleSurface();
            }
        } else {
            applyCapsuleSurface();
        }
        applyCancelButtonTextColor();
        getStartIconView().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.searchbar.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSSearchBar._init_$lambda$16(this.f31342a, view2);
            }
        });
        getEndIconView().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.searchbar.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f31343a.onEndIconClicked();
            }
        });
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.searchbar.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSSearchBar._init_$lambda$18(this.f31344a, view2);
            }
        });
        searchBarNavigationButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.searchbar.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSSearchBar._init_$lambda$19(this.f31345a, view2);
            }
        });
        searchBarNavigationButton2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.searchbar.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSSearchBar._init_$lambda$20(this.f31346a, view2);
            }
        });
        applyIcons();
        applyPressScale();
    }
}
