package com.stepos.widget.circlebutton;

import Y8.t;
import Z8.F;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.GlassRebuildScheduler;
import com.stepos.widget.glass.ManualSurfaceLayers;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.FluidPressMotion;
import com.stepos.widget.internal.HotspotRipple;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import x5.d;
import y7.B;
import y7.o;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 Ö\u00012\u00020\u0001:\u0004×\u0001Ö\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u001f\u0010!\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010\u0015J\u0011\u0010$\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0013H\u0002¢\u0006\u0004\b)\u0010\u0015J\u000f\u0010*\u001a\u00020\u0013H\u0002¢\u0006\u0004\b*\u0010\u0015J\u000f\u0010+\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010\u0015J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00132\u0006\u0010/\u001a\u00020&H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0013H\u0016¢\u0006\u0004\b2\u0010\u0015J#\u00106\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u000b2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0015\u0010@\u001a\u00020\u00132\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bB\u0010%J\u0017\u0010C\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bE\u00109J\u0017\u0010G\u001a\u00020\u00132\b\b\u0001\u0010F\u001a\u00020\u0006¢\u0006\u0004\bG\u00109J\u0017\u0010H\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bH\u00109J\u0017\u0010I\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bI\u00109J\u0017\u0010J\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bJ\u00109J\u0017\u0010K\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bK\u00109J\u0015\u0010L\u001a\u00020\u00132\u0006\u0010;\u001a\u00020:¢\u0006\u0004\bL\u0010=J\u0015\u0010M\u001a\u00020\u00132\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bM\u0010AJ\u0017\u0010N\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bN\u00109J\u0017\u0010O\u001a\u00020\u00132\b\b\u0001\u0010F\u001a\u00020\u0006¢\u0006\u0004\bO\u00109J\u0017\u0010P\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\bP\u00109J\u0017\u0010S\u001a\u00020\u00132\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0013H\u0014¢\u0006\u0004\bU\u0010\u0015J\u000f\u0010V\u001a\u00020\u0013H\u0014¢\u0006\u0004\bV\u0010\u0015J\u0017\u0010X\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u001bH\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J/\u0010b\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u0006H\u0014¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020\u00132\u0006\u0010e\u001a\u00020dH\u0014¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u0013H\u0014¢\u0006\u0004\bj\u0010\u0015J\u001f\u0010m\u001a\u00020\u00132\u0006\u0010k\u001a\u00020,2\u0006\u0010l\u001a\u00020,H\u0016¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\u0013H\u0016¢\u0006\u0004\bo\u0010\u0015J\u0017\u0010q\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\u0006H\u0016¢\u0006\u0004\bq\u00109J\u0017\u0010s\u001a\u00020\u001b2\u0006\u0010r\u001a\u00020\u000fH\u0014¢\u0006\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010|\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0082\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R\u0019\u0010?\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b?\u0010\u0088\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u007fR\u0018\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\u007fR\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R4\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0006\b\u0095\u0001\u0010\u0084\u0001\u001a\u0005\b\u0096\u0001\u0010\r\"\u0005\bJ\u0010\u0097\u0001R3\u0010\u0098\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0086\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0005\b\u009b\u0001\u00109R3\u0010\u009c\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b\u009c\u0001\u0010\u0086\u0001\u001a\u0006\b\u009d\u0001\u0010\u009a\u0001\"\u0005\b\u009e\u0001\u00109R3\u0010\u009f\u0001\u001a\u00020,2\t\b\u0001\u0010\u0094\u0001\u001a\u00020,8W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0005\b¡\u0001\u0010.\"\u0006\b¢\u0001\u0010£\u0001R4\u0010¤\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0006\b¤\u0001\u0010\u0088\u0001\u001a\u0005\b¥\u0001\u0010%\"\u0005\b¦\u0001\u0010DR3\u0010§\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b§\u0001\u0010\u0086\u0001\u001a\u0006\b¨\u0001\u0010\u009a\u0001\"\u0005\b©\u0001\u00109R8\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010ª\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R3\u0010±\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b±\u0001\u0010\u0086\u0001\u001a\u0006\b²\u0001\u0010\u009a\u0001\"\u0005\b³\u0001\u00109R8\u0010´\u0001\u001a\u0005\u0018\u00010ª\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010ª\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010¬\u0001\u001a\u0006\bµ\u0001\u0010®\u0001\"\u0006\b¶\u0001\u0010°\u0001R3\u0010·\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b·\u0001\u0010\u0086\u0001\u001a\u0006\b¸\u0001\u0010\u009a\u0001\"\u0005\b¹\u0001\u00109R0\u0010º\u0001\u001a\u00020\u001b2\u0007\u0010\u0094\u0001\u001a\u00020\u001b8\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\bº\u0001\u0010\u007f\u001a\u0006\bº\u0001\u0010»\u0001\"\u0005\b¼\u0001\u0010YR3\u0010½\u0001\u001a\u00020,2\t\b\u0001\u0010\u0094\u0001\u001a\u00020,8W@VX\u0096\u000e¢\u0006\u0017\n\u0006\b½\u0001\u0010 \u0001\u001a\u0005\b¾\u0001\u0010.\"\u0006\b¿\u0001\u0010£\u0001R0\u0010À\u0001\u001a\u00020\u001b2\u0007\u0010\u0094\u0001\u001a\u00020\u001b8\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\bÀ\u0001\u0010\u007f\u001a\u0006\bÀ\u0001\u0010»\u0001\"\u0005\bÁ\u0001\u0010YR4\u0010Ã\u0001\u001a\u00030Â\u00012\b\u0010\u0094\u0001\u001a\u00030Â\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R0\u0010É\u0001\u001a\u00020\u001b2\u0007\u0010\u0094\u0001\u001a\u00020\u001b8\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\bÉ\u0001\u0010\u007f\u001a\u0006\bÉ\u0001\u0010»\u0001\"\u0005\bÊ\u0001\u0010YR\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010\u0088\u0001R\u0017\u0010Ì\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010»\u0001R,\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÍ\u0001\u0010%\"\u0005\bÎ\u0001\u0010DR\u0017\u0010Ð\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010»\u0001R\u001f\u0010Õ\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010Ñ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/stepos/widget/circlebutton/StepOSCircleButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "composeText", "()Ljava/lang/CharSequence;", "main", "Landroid/graphics/drawable/Drawable;", "drawable", "composeSubDrawable", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)Ljava/lang/CharSequence;", "LY8/t;", "refreshComposedText", "()V", "Landroid/content/res/TypedArray;", Const.INTENT_KEY_APIKEY, "readSubContent", "(Landroid/content/res/TypedArray;)V", "resId", "", "isDrawableRes", "(I)Z", "applySubDrawableBounds", "Landroid/graphics/Canvas;", "canvas", "drawIcon", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;)V", "installRipple", "createFallbackSurface", "()Landroid/graphics/drawable/Drawable;", "Lcom/stepos/widget/glass/GlassCustomizer;", "defaultGlassCustomizer", "()Lcom/stepos/widget/glass/GlassCustomizer;", "requestGlassRefresh", "applyGlass", "releaseGlass", "", "effectiveRadius", "()F", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "text", "Landroid/widget/TextView$BufferType;", "type", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "setImageResource", "(I)V", "Landroid/graphics/Bitmap;", "bitmap", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Icon;", "icon", "setImageIcon", "(Landroid/graphics/drawable/Icon;)V", "getImageDrawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setIconSizeRes", "color", "setIconTint", "setIconTintResource", "setSubTextSizeRes", "setSubText", "setSubDrawableResource", "setSubBitmap", "setSubIcon", "setSubDrawableSizeRes", "setSubDrawableTint", "setSubDrawableTintResource", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "onAttachedToWindow", "onDetachedFromWindow", d.EXTRA_ENABLED, "setEnabled", "(Z)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDraw", "(Landroid/graphics/Canvas;)V", "drawableStateChanged", "x", "y", "drawableHotspotChanged", "(FF)V", "jumpDrawablesToCurrentState", "layoutDirection", "onRtlPropertiesChanged", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "manualLayers", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/circlebutton/StepOSCircleButton$GlassRequest;", "appliedRequest", "Lcom/stepos/widget/circlebutton/StepOSCircleButton$GlassRequest;", "refreshPosted", "Z", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "usingDefaultGlass", "mainText", "Ljava/lang/CharSequence;", "subLineHeightPx", "I", "mainLineHeightPx", "Landroid/graphics/drawable/Drawable;", "constructed", "Lcom/stepos/widget/internal/FluidPressMotion;", "fluidMotion", "Lcom/stepos/widget/internal/FluidPressMotion;", "updatingSub", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "glassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", UxipConstants.f30680s, "subText", "getSubText", "(Ljava/lang/CharSequence;)V", "subTextSize", "getSubTextSize", "()I", "setSubTextSize", "subTextColor", "getSubTextColor", "setSubTextColor", "subLetterSpacing", "F", "getSubLetterSpacing", "setSubLetterSpacing", "(F)V", "subDrawable", "getSubDrawable", "setSubDrawable", "subDrawableSize", "getSubDrawableSize", "setSubDrawableSize", "Landroid/content/res/ColorStateList;", "subDrawableTintList", "Landroid/content/res/ColorStateList;", "getSubDrawableTintList", "()Landroid/content/res/ColorStateList;", "setSubDrawableTintList", "(Landroid/content/res/ColorStateList;)V", "iconSize", "getIconSize", "setIconSize", "iconTintList", "getIconTintList", "setIconTintList", "rippleColor", "getRippleColor", "setRippleColor", "isGlassEnabled", "()Z", "setGlassEnabled", "glassCornerRadius", "getGlassCornerRadius", "setGlassCornerRadius", "isGlassCrossWindow", "setGlassCrossWindow", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "isPressScaleEnabled", "setPressScaleEnabled", "_surfaceDrawable", "isIconMode", "getSurfaceDrawable", "setSurfaceDrawable", "surfaceDrawable", "isGlassActive", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "glassActiveIds", "Companion", "GlassRequest", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public class StepOSCircleButton extends AppCompatTextView {
    private static final Companion Companion = new Companion(null);
    private Drawable _surfaceDrawable;
    private GlassRequest appliedRequest;
    private boolean constructed;
    private final FluidPressMotion fluidMotion;
    private float glassCornerRadius;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private o glassEffect;
    private final GlassRebuildScheduler glassRebuild;
    private Drawable icon;
    private int iconSize;
    private ColorStateList iconTintList;
    private boolean isGlassCrossWindow;
    private boolean isGlassEnabled;
    private boolean isPressScaleEnabled;
    private int mainLineHeightPx;
    private CharSequence mainText;
    private ManualSurfaceLayers manualLayers;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;
    private int rippleColor;
    private Drawable subDrawable;
    private int subDrawableSize;
    private ColorStateList subDrawableTintList;
    private float subLetterSpacing;
    private int subLineHeightPx;
    private CharSequence subText;
    private int subTextColor;
    private int subTextSize;
    private boolean updatingSub;
    private boolean usingDefaultGlass;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/stepos/widget/circlebutton/StepOSCircleButton$Companion;", "", "<init>", "()V", "wrap", "Landroid/content/Context;", "context", "defStyleRes", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context wrap(Context context, int defStyleRes) {
            return defStyleRes == 0 ? context : new ContextThemeWrapper(context, defStyleRes);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JN\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0015R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0019¨\u0006."}, d2 = {"Lcom/stepos/widget/circlebutton/StepOSCircleButton$GlassRequest;", "", "", "width", "height", "", "radius", "", "crossWindow", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Z", "component5", "()Ly7/o;", "component6", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/circlebutton/StepOSCircleButton$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getRadius", "Z", "getCrossWindow", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final boolean crossWindow;
        private final GlassCustomizer customizer;
        private final o effect;
        private final int height;
        private final float radius;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, boolean z10, o effect, GlassCustomizer glassCustomizer) {
            p.i(effect, "effect");
            this.width = i10;
            this.height = i11;
            this.radius = f10;
            this.crossWindow = z10;
            this.effect = effect;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, boolean z10, o oVar, GlassCustomizer glassCustomizer, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = glassRequest.width;
            }
            if ((i12 & 2) != 0) {
                i11 = glassRequest.height;
            }
            if ((i12 & 4) != 0) {
                f10 = glassRequest.radius;
            }
            if ((i12 & 8) != 0) {
                z10 = glassRequest.crossWindow;
            }
            if ((i12 & 16) != 0) {
                oVar = glassRequest.effect;
            }
            if ((i12 & 32) != 0) {
                glassCustomizer = glassRequest.customizer;
            }
            o oVar2 = oVar;
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
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        /* renamed from: component5, reason: from getter */
        public final o getEffect() {
            return this.effect;
        }

        /* renamed from: component6, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final GlassRequest copy(int width, int height, float radius, boolean crossWindow, o effect, GlassCustomizer customizer) {
            p.i(effect, "effect");
            return new GlassRequest(width, height, radius, crossWindow, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.radius, glassRequest.radius) == 0 && this.crossWindow == glassRequest.crossWindow && p.d(this.effect, glassRequest.effect) && p.d(this.customizer, glassRequest.customizer);
        }

        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final o getEffect() {
            return this.effect;
        }

        public final int getHeight() {
            return this.height;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.radius)) * 31) + Boolean.hashCode(this.crossWindow)) * 31) + this.effect.hashCode()) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode + (glassCustomizer == null ? 0 : glassCustomizer.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", crossWindow=" + this.crossWindow + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final void applyGlass() {
        if (!getIsGlassEnabled() || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            releaseGlass();
            return;
        }
        float fEffectiveRadius = effectiveRadius();
        final GlassCustomizer glassCustomizer = this.glassCustomizer;
        GlassRequest glassRequest = new GlassRequest(getWidth(), getHeight(), fEffectiveRadius, getIsGlassCrossWindow(), getGlassEffect(), glassCustomizer);
        if (p.d(this.appliedRequest, glassRequest)) {
            return;
        }
        boolean isGlassCrossWindow = getIsGlassCrossWindow();
        if (glassCustomizer != null) {
            this.glassDelegate.applyCustom$StepOSWidget_release(isGlassCrossWindow ? 1 : 0, fEffectiveRadius, new InterfaceC5074l() { // from class: com.stepos.widget.circlebutton.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSCircleButton.applyGlass$lambda$10(glassCustomizer, (B) obj);
                }
            });
        } else {
            this.glassDelegate.apply$StepOSWidget_release(isGlassCrossWindow ? 1 : 0, fEffectiveRadius, getGlassEffect());
        }
        this.appliedRequest = glassRequest;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyGlass$lambda$10(GlassCustomizer glassCustomizer, B it) {
        p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    private final void applySubDrawableBounds() {
        Drawable subDrawable = getSubDrawable();
        if (subDrawable == null) {
            return;
        }
        int subDrawableSize = getSubDrawableSize() > 0 ? getSubDrawableSize() : this.subLineHeightPx;
        int intrinsicWidth = subDrawable.getIntrinsicWidth();
        int intrinsicHeight = subDrawable.getIntrinsicHeight();
        if (subDrawableSize > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
            intrinsicWidth = C5685n.f((int) ((subDrawableSize * intrinsicWidth) / intrinsicHeight), 1);
        } else if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            subDrawableSize = C5685n.f(subDrawableSize, 1);
            intrinsicWidth = subDrawableSize;
        } else {
            subDrawableSize = intrinsicHeight;
        }
        subDrawable.setBounds(0, 0, intrinsicWidth, subDrawableSize);
        subDrawable.setTintList(getSubDrawableTintList());
        subDrawable.setState(getDrawableState());
    }

    private final CharSequence composeSubDrawable(CharSequence main, Drawable drawable) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (main.length() > 0) {
            spannableStringBuilder.append(main);
            int i10 = this.mainLineHeightPx;
            if (i10 > 0) {
                spannableStringBuilder.setSpan(new CenterLineHeightSpan(i10), 0, main.length(), 33);
            }
            spannableStringBuilder.append('\n');
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((char) 65532);
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 2), length, length2, 33);
        int iF = C5685n.f(this.subLineHeightPx, drawable.getBounds().height());
        if (iF > 0) {
            spannableStringBuilder.setSpan(new CenterLineHeightSpan(iF), length, length2, 33);
        }
        return spannableStringBuilder;
    }

    private final CharSequence composeText() {
        if (isIconMode()) {
            return "";
        }
        CharSequence charSequence = this.mainText;
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            applySubDrawableBounds();
            return composeSubDrawable(charSequence, subDrawable);
        }
        CharSequence subText = getSubText();
        if (subText == null || subText.length() == 0) {
            if (this.mainLineHeightPx <= 0 || charSequence.length() == 0) {
                return charSequence;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new CenterLineHeightSpan(this.mainLineHeightPx), 0, charSequence.length(), 33);
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(charSequence);
        if (this.mainLineHeightPx > 0 && charSequence.length() > 0) {
            spannableStringBuilder2.setSpan(new CenterLineHeightSpan(this.mainLineHeightPx), 0, charSequence.length(), 33);
        }
        spannableStringBuilder2.append('\n');
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append(subText);
        int length2 = spannableStringBuilder2.length();
        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(getSubTextSize(), false), length, length2, 33);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getSubTextColor()), length, length2, 33);
        int i10 = this.subLineHeightPx;
        if (i10 > 0) {
            spannableStringBuilder2.setSpan(new CenterLineHeightSpan(i10), length, length2, 33);
        }
        if (getSubLetterSpacing() == 0.0f) {
            return spannableStringBuilder2;
        }
        spannableStringBuilder2.setSpan(new LetterSpacingSpan(getSubLetterSpacing()), length, length2, 33);
        return spannableStringBuilder2;
    }

    private final Drawable createFallbackSurface() {
        Drawable drawableE = androidx.core.content.a.e(getContext(), R.drawable.stepos_bg_circlebutton);
        if (drawableE != null) {
            return drawableE.mutate();
        }
        return null;
    }

    private final GlassCustomizer defaultGlassCustomizer() {
        return (getResources().getConfiguration().uiMode & 48) == 32 ? StepOSGlassPresets.INSTANCE.CIRCLE_BUTTON_DARK_TUNED(getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.LIGHT_SMALL_TUNED(getResources().getDisplayMetrics().density);
    }

    private final void drawIcon(Drawable drawable, Canvas canvas) {
        float iconSize = (getIconSize() > 0 ? getIconSize() : Math.min(getWidth(), getHeight())) / 2.0f;
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        drawable.setBounds((int) (width - iconSize), (int) (height - iconSize), (int) (width + iconSize), (int) (height + iconSize));
        drawable.setState(getDrawableState());
        ColorStateList iconTintList = getIconTintList();
        if (iconTintList != null) {
            drawable.setTintList(iconTintList);
        }
        drawable.draw(canvas);
    }

    private final float effectiveRadius() {
        return getGlassCornerRadius() > 0.0f ? getGlassCornerRadius() : Math.min(getWidth(), getHeight()) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t glassRebuild$lambda$1(StepOSCircleButton stepOSCircleButton) {
        stepOSCircleButton.releaseGlass();
        stepOSCircleButton.requestGlassRefresh();
        return t.f7040a;
    }

    private final void installRipple() {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, this, getRippleColor(), fMin, false, false, fMin, 8, null);
        if (getIsPressScaleEnabled()) {
            this.fluidMotion.reapply$StepOSWidget_release();
        }
    }

    private final boolean isDrawableRes(int resId) throws Resources.NotFoundException {
        try {
            String resourceTypeName = getResources().getResourceTypeName(resId);
            if (p.d(resourceTypeName, "drawable")) {
                return true;
            }
            return p.d(resourceTypeName, "mipmap");
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    private final void readSubContent(TypedArray a10) {
        int i10 = R.styleable.StepOSCircleButton_steposCircleButtonSubText;
        if (a10.hasValue(i10)) {
            int resourceId = a10.getResourceId(i10, 0);
            if (resourceId == 0 || !isDrawableRes(resourceId)) {
                setSubText(a10.getText(i10));
            } else {
                setSubDrawable(androidx.core.content.a.e(getContext(), resourceId));
            }
        }
    }

    private final void refreshComposedText() {
        if (this.constructed) {
            super.setText(composeText(), TextView.BufferType.SPANNABLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(StepOSCircleButton stepOSCircleButton) {
        stepOSCircleButton.refreshPosted = false;
        if (stepOSCircleButton.isAttachedToWindow()) {
            stepOSCircleButton.applyGlass();
        }
    }

    private final void releaseGlass() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedRequest = null;
        invalidate();
    }

    private final void requestGlassRefresh() {
        if (getIsGlassEnabled() && isAttachedToWindow() && !this.refreshPosted) {
            this.refreshPosted = true;
            post(this.refreshRunnable);
        }
    }

    public void applyCustomGlass(GlassCustomizer customizer) {
        p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        this.usingDefaultGlass = false;
        releaseGlass();
        requestGlassRefresh();
    }

    public void clearCustomGlass() {
        if (this.usingDefaultGlass) {
            return;
        }
        this.glassCustomizer = defaultGlassCustomizer();
        this.usingDefaultGlass = true;
        releaseGlass();
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.hotspotChanged(x10, y10);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(x10, y10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        boolean z10 = false;
        if (manualSurfaceLayers != null && manualSurfaceLayers.stateChanged()) {
            z10 = true;
        }
        Drawable subDrawable = getSubDrawable();
        if ((subDrawable == null || !subDrawable.setState(getDrawableState())) ? z10 : true) {
            invalidate();
        }
    }

    public Set<String> getGlassActiveIds() {
        return F.r1(this.glassDelegate.getActiveIds$StepOSWidget_release());
    }

    public float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public o getGlassEffect() {
        return this.glassEffect;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTintList() {
        return this.iconTintList;
    }

    /* renamed from: getImageDrawable, reason: from getter */
    public Drawable getIcon() {
        return this.icon;
    }

    public int getRippleColor() {
        return this.rippleColor;
    }

    public Drawable getSubDrawable() {
        return this.subDrawable;
    }

    public int getSubDrawableSize() {
        return this.subDrawableSize;
    }

    public ColorStateList getSubDrawableTintList() {
        return this.subDrawableTintList;
    }

    public float getSubLetterSpacing() {
        return this.subLetterSpacing;
    }

    public CharSequence getSubText() {
        return this.subText;
    }

    public int getSubTextColor() {
        return this.subTextColor;
    }

    public int getSubTextSize() {
        return this.subTextSize;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public Drawable get_surfaceDrawable() {
        return this._surfaceDrawable;
    }

    public boolean isGlassActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassCrossWindow, reason: from getter */
    public boolean getIsGlassCrossWindow() {
        return this.isGlassCrossWindow;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    public boolean isIconMode() {
        return this.icon != null;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public boolean getIsPressScaleEnabled() {
        return this.isPressScaleEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.jumpToCurrentState();
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(this);
        }
        if (getIsPressScaleEnabled()) {
            this.fluidMotion.allowOverflow$StepOSWidget_release();
        }
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (getIsGlassEnabled() && this.usingDefaultGlass) {
            this.glassCustomizer = defaultGlassCustomizer();
        }
        this.glassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        this.glassRebuild.cancel$StepOSWidget_release();
        this.fluidMotion.reset$StepOSWidget_release();
        releaseGlass();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(null);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ManualSurfaceLayers manualSurfaceLayers;
        p.i(canvas, "canvas");
        if (!this.glassDelegate.getIsActive() && (manualSurfaceLayers = this.manualLayers) != null) {
            manualSurfaceLayers.draw(canvas);
        }
        super.onDraw(canvas);
        Drawable drawable = this.icon;
        if (drawable != null) {
            drawIcon(drawable, canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.updateLayoutDirection(layoutDirection);
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        installRipple();
        requestGlassRefresh();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (this.constructed && getIsPressScaleEnabled() && isEnabled()) {
            this.fluidMotion.onTouchEvent$StepOSWidget_release(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!this.constructed || enabled) {
            return;
        }
        this.fluidMotion.reset$StepOSWidget_release();
    }

    public void setGlassCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassCornerRadius == f10) {
            return;
        }
        this.glassCornerRadius = f10;
        releaseGlass();
        requestGlassRefresh();
    }

    public void setGlassCrossWindow(boolean z10) {
        if (this.isGlassCrossWindow == z10) {
            return;
        }
        this.isGlassCrossWindow = z10;
        releaseGlass();
        requestGlassRefresh();
    }

    public void setGlassEffect(o value) {
        p.i(value, "value");
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        this.usingDefaultGlass = false;
        if (!p.d(this.glassEffect, value) || z10) {
            this.glassEffect = value;
            releaseGlass();
            requestGlassRefresh();
        }
    }

    public void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            requestGlassRefresh();
        } else {
            releaseGlass();
        }
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("iconSize must be >= 0 but was " + i10).toString());
        }
        if (this.iconSize == i10) {
            return;
        }
        this.iconSize = i10;
        invalidate();
    }

    public final void setIconSizeRes(int resId) {
        setIconSize(getResources().getDimensionPixelSize(resId));
    }

    public final void setIconTint(int color) {
        setIconTintList(ColorStateList.valueOf(color));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        invalidate();
    }

    public final void setIconTintResource(int resId) {
        setIconTintList(androidx.core.content.a.d(getContext(), resId));
    }

    public final void setImageBitmap(Bitmap bitmap) {
        p.i(bitmap, "bitmap");
        setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public final void setImageDrawable(Drawable drawable) {
        this.icon = drawable;
        refreshComposedText();
        invalidate();
    }

    public final void setImageIcon(Icon icon) {
        p.i(icon, "icon");
        setImageDrawable(icon.loadDrawable(getContext()));
    }

    public final void setImageResource(int resId) {
        setImageDrawable(androidx.core.content.a.e(getContext(), resId));
    }

    public void setPressScaleEnabled(boolean z10) {
        if (this.isPressScaleEnabled == z10) {
            return;
        }
        this.isPressScaleEnabled = z10;
        if (!z10) {
            this.fluidMotion.reset$StepOSWidget_release();
        }
        installRipple();
        if (z10 && isAttachedToWindow()) {
            this.fluidMotion.allowOverflow$StepOSWidget_release();
        }
    }

    public void setRippleColor(int i10) {
        if (this.rippleColor == i10) {
            return;
        }
        this.rippleColor = i10;
        installRipple();
    }

    public final void setSubBitmap(Bitmap bitmap) {
        p.i(bitmap, "bitmap");
        setSubDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public void setSubDrawable(Drawable drawable) {
        CharSequence subText;
        if (drawable == null) {
            Drawable drawable2 = this.subDrawable;
            if (drawable2 == null) {
                return;
            }
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.subDrawable = null;
            if (this.updatingSub) {
                return;
            }
            refreshComposedText();
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        p.h(drawableMutate, "mutate(...)");
        Drawable drawable3 = this.subDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        drawableMutate.setCallback(this);
        this.subDrawable = drawableMutate;
        applySubDrawableBounds();
        if (!this.updatingSub && (subText = getSubText()) != null && subText.length() != 0) {
            this.updatingSub = true;
            try {
                setSubText((CharSequence) null);
            } finally {
                this.updatingSub = false;
            }
        }
        if (this.updatingSub) {
            return;
        }
        refreshComposedText();
    }

    public final void setSubDrawableResource(int resId) {
        Drawable drawableE = androidx.core.content.a.e(getContext(), resId);
        if (drawableE != null) {
            setSubDrawable(drawableE);
            return;
        }
        throw new Resources.NotFoundException("Drawable resource #" + resId + " not found");
    }

    public void setSubDrawableSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("subDrawableSize must be >= 0 but was " + i10).toString());
        }
        if (this.subDrawableSize == i10) {
            return;
        }
        this.subDrawableSize = i10;
        if (getSubDrawable() != null) {
            applySubDrawableBounds();
            refreshComposedText();
        }
    }

    public final void setSubDrawableSizeRes(int resId) {
        setSubDrawableSize(getResources().getDimensionPixelSize(resId));
    }

    public final void setSubDrawableTint(int color) {
        setSubDrawableTintList(ColorStateList.valueOf(color));
    }

    public void setSubDrawableTintList(ColorStateList colorStateList) {
        if (p.d(this.subDrawableTintList, colorStateList)) {
            return;
        }
        this.subDrawableTintList = colorStateList;
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setTintList(colorStateList);
        }
        if (getSubDrawable() != null) {
            invalidate();
        }
    }

    public final void setSubDrawableTintResource(int resId) {
        setSubDrawableTintList(androidx.core.content.a.d(getContext(), resId));
    }

    public final void setSubIcon(Icon icon) {
        p.i(icon, "icon");
        setSubDrawable(icon.loadDrawable(getContext()));
    }

    public void setSubLetterSpacing(float f10) {
        if (this.subLetterSpacing == f10) {
            return;
        }
        this.subLetterSpacing = f10;
        refreshComposedText();
    }

    public void setSubText(CharSequence charSequence) {
        boolean z10 = (this.updatingSub || getSubDrawable() == null) ? false : true;
        if (!p.d(this.subText, charSequence) || z10) {
            this.subText = charSequence;
            if (z10) {
                this.updatingSub = true;
                try {
                    setSubDrawable(null);
                } finally {
                    this.updatingSub = false;
                }
            }
            if (this.updatingSub) {
                return;
            }
            refreshComposedText();
        }
    }

    public void setSubTextColor(int i10) {
        if (this.subTextColor == i10) {
            return;
        }
        this.subTextColor = i10;
        refreshComposedText();
    }

    public void setSubTextSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("subTextSize must be >= 0 but was " + i10).toString());
        }
        if (this.subTextSize == i10) {
            return;
        }
        this.subTextSize = i10;
        refreshComposedText();
    }

    public final void setSubTextSizeRes(int resId) {
        setSubTextSize(getResources().getDimensionPixelSize(resId));
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this._surfaceDrawable = drawable;
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.setSurface(drawable);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        if (!this.constructed) {
            super.setText(text, type);
            return;
        }
        if (text == null) {
            text = "";
        }
        this.mainText = text;
        super.setText(composeText(), TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable who) {
        ManualSurfaceLayers manualSurfaceLayers;
        p.i(who, "who");
        return who == getSubDrawable() || ((manualSurfaceLayers = this.manualLayers) != null && manualSurfaceLayers.verify(who)) || super.verifyDrawable(who);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSCircleButton(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposCircleButtonStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_CircleButton : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(Companion.wrap(context, i11), attributeSet, i10);
        p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.glassCustomizer = defaultGlassCustomizer();
        this.usingDefaultGlass = true;
        this.mainText = "";
        this.fluidMotion = new FluidPressMotion(this);
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.circlebutton.a
            @Override // java.lang.Runnable
            public final void run() {
                StepOSCircleButton.refreshRunnable$lambda$0(this.f31154a);
            }
        };
        this.glassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.circlebutton.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSCircleButton.glassRebuild$lambda$1(this.f31155a);
            }
        });
        this.isGlassEnabled = true;
        this.glassEffect = o.INSTANCE.i();
        this.isPressScaleEnabled = true;
        this.manualLayers = new ManualSurfaceLayers(this);
        setClickable(true);
        setFocusable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSCircleButton, i10, i11);
        try {
            setSubTextSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSCircleButton_steposCircleButtonSubTextSize, getResources().getDimensionPixelSize(R.dimen.stepos_circlebutton_sub_text_size)));
            setSubTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSCircleButton_steposCircleButtonSubTextColor, androidx.core.content.a.c(context, R.color.stepos_circlebutton_sub_text)));
            setSubLetterSpacing(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSCircleButton_steposCircleButtonSubLetterSpacing, 0.0f));
            setSubDrawableSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSCircleButton_steposCircleButtonSubIconSize, 0));
            setSubDrawableTintList(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSCircleButton_steposCircleButtonSubIconTint));
            this.subLineHeightPx = getResources().getDimensionPixelSize(R.dimen.stepos_circlebutton_sub_text_line_height);
            this.mainLineHeightPx = getResources().getDimensionPixelSize(R.dimen.stepos_circlebutton_text_line_height);
            setIconSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSCircleButton_steposCircleButtonIconSize, getResources().getDimensionPixelSize(R.dimen.stepos_circlebutton_icon_size)));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSCircleButton_steposCircleButtonIconTint);
            setIconTintList(colorStateList == null ? androidx.core.content.a.d(context, R.color.stepos_circlebutton_icon_color) : colorStateList);
            setRippleColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSCircleButton_steposCircleButtonRippleColor, androidx.core.content.a.c(context, R.color.stepos_circlebutton_ripple)));
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCircleButton_steposGlassEnabled, true));
            setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCircleButton_steposGlassCrossWindow, false));
            GlassEffectResolver glassEffectResolver = GlassEffectResolver.INSTANCE;
            p.f(typedArrayObtainStyledAttributes);
            o oVar = glassEffectResolver.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSCircleButton_steposGlassEffect);
            if (oVar != null) {
                setGlassEffect(oVar);
            }
            setPressScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSCircleButton_steposPressScaleEnabled, true));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSCircleButton_steposCircleButtonIcon, 0);
            if (resourceId != 0) {
                setImageResource(resourceId);
            }
            readSubContent(typedArrayObtainStyledAttributes);
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            Drawable background = getBackground();
            setBackground(null);
            setSurfaceDrawable(background == null ? createFallbackSurface() : background);
            installRipple();
            CharSequence text = getText();
            this.mainText = text != null ? text : "";
            this.constructed = true;
            refreshComposedText();
        } finally {
        }
    }

    public final void setSubText(int resId) {
        setSubText(getResources().getText(resId));
    }
}
