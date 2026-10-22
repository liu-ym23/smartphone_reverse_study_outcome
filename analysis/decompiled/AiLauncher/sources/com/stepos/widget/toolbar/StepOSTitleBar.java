package com.stepos.widget.toolbar;

import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassCustomizer;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.StepOSGlassImageButton;
import com.stepos.widget.glass.StepOSGlassLinearLayout;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.HotspotRipple;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;
import y7.B;
import y7.G;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 Ü\u00022\u00020\u0001:\bÝ\u0002Þ\u0002ß\u0002Ü\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J9\u0010 \u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J5\u0010+\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020*H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020*H\u0002¢\u0006\u0004\b0\u0010/J\u0017\u00102\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000bH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020*H\u0002¢\u0006\u0004\b4\u0010/J\u0017\u00105\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020*H\u0002¢\u0006\u0004\b5\u0010/J!\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u00103J\u0017\u0010:\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u00103J\u000f\u0010;\u001a\u00020\u001eH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001eH\u0002¢\u0006\u0004\b=\u0010<J\u0017\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\rJ\u0017\u0010@\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\"H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\"H\u0002¢\u0006\u0004\bH\u0010GJ\u001f\u0010K\u001a\u00020\"2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u001eH\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u001eH\u0002¢\u0006\u0004\bM\u0010NJ!\u0010R\u001a\u0004\u0018\u00010\"2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u0010SJ\u001b\u0010U\u001a\u0004\u0018\u00010\"2\b\u0010T\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0006H\u0002¢\u0006\u0004\bX\u0010YJ\u001f\u0010\\\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\\\u0010]J\u001f\u0010_\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u001eH\u0002¢\u0006\u0004\b_\u0010`J-\u0010d\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010b\u001a\u00020\u00062\b\b\u0001\u0010c\u001a\u00020\u0006H\u0002¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bf\u0010\u0010J\u000f\u0010g\u001a\u00020\u000eH\u0002¢\u0006\u0004\bg\u0010\u0010J\u0017\u0010i\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020(H\u0002¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\u000bH\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u000bH\u0016¢\u0006\u0004\bm\u0010lJ\u000f\u0010n\u001a\u00020\u000bH\u0016¢\u0006\u0004\bn\u0010lJ\u000f\u0010o\u001a\u00020\u000bH\u0016¢\u0006\u0004\bo\u0010lJ\u000f\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020BH\u0016¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u0013H\u0016¢\u0006\u0004\bu\u0010vJ\u0019\u0010w\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\bw\u0010\u0016J\u000f\u0010x\u001a\u00020\u000eH\u0016¢\u0006\u0004\bx\u0010\u0010J\u000f\u0010y\u001a\u00020$H\u0016¢\u0006\u0004\by\u0010zJ\u0019\u0010|\u001a\u00020\u000e2\b\u0010{\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b|\u0010}J\u0019\u0010|\u001a\u00020\u000e2\b\b\u0001\u0010~\u001a\u00020\u0006H\u0016¢\u0006\u0004\b|\u0010\u007fJ\u0011\u0010\u0080\u0001\u001a\u00020$H\u0016¢\u0006\u0005\b\u0080\u0001\u0010zJ\u001c\u0010\u0082\u0001\u001a\u00020\u000e2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0005\b\u0082\u0001\u0010}J\u0012\u0010\u0083\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u000e2\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u007fJ\u001a\u0010\u0088\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020(H\u0016¢\u0006\u0005\b\u0088\u0001\u0010jJ\u0012\u0010\u0089\u0001\u001a\u00020(H\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\u000e2\b\b\u0001\u0010I\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\u007fJ\u001b\u0010\u008c\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008c\u0001\u0010\u007fJ\u001b\u0010\u008d\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u008d\u0001\u0010\u007fJ\u0012\u0010\u008e\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u008e\u0001\u0010\u0084\u0001J\u001c\u0010\u0090\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0090\u0001\u0010\u007fJ\u0012\u0010\u0091\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u0091\u0001\u0010\u0084\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0092\u0001\u0010\u007fJ\u0012\u0010\u0093\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u0093\u0001\u0010\u0084\u0001J\u001c\u0010\u0094\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0094\u0001\u0010\u007fJ\u0012\u0010\u0095\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u0095\u0001\u0010\u0084\u0001J\u001c\u0010\u0097\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u007fJ\u0012\u0010\u0098\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u0098\u0001\u0010\u0084\u0001J\u001c\u0010\u0099\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0099\u0001\u0010\u007fJ\u0012\u0010\u009a\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u009a\u0001\u0010\u0084\u0001J\u001c\u0010\u009c\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u009c\u0001\u0010\u007fJ\u0012\u0010\u009d\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u009d\u0001\u0010\u0084\u0001J\u001c\u0010\u009e\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u009e\u0001\u0010\u007fJ\u0012\u0010\u009f\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b\u009f\u0001\u0010\u0084\u0001J\u001c\u0010¡\u0001\u001a\u00020\u000e2\t\b\u0001\u0010 \u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b¡\u0001\u0010\u007fJ\u0012\u0010¢\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b¢\u0001\u0010\u0084\u0001J\u001c\u0010£\u0001\u001a\u00020\u000e2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b£\u0001\u0010\u007fJ\u0012\u0010¤\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0006\b¤\u0001\u0010\u0084\u0001J\u001c\u0010¦\u0001\u001a\u00020\u000e2\t\b\u0001\u0010¥\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0005\b¦\u0001\u0010\u007fJ\u001d\u0010¨\u0001\u001a\u00020\u000e2\t\u0010§\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0013\u0010ª\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0005\bª\u0001\u0010GJ\u001d\u0010«\u0001\u001a\u00020\u000e2\t\u0010§\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0006\b«\u0001\u0010©\u0001J\u0013\u0010¬\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0005\b¬\u0001\u0010GJ\u0011\u0010\u00ad\u0001\u001a\u00020\u001eH\u0017¢\u0006\u0005\b\u00ad\u0001\u0010<J\u001c\u0010®\u0001\u001a\u00020\u000e2\b\b\u0001\u0010J\u001a\u00020\u001eH\u0016¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0011\u0010°\u0001\u001a\u00020\u001eH\u0017¢\u0006\u0005\b°\u0001\u0010<J\u001c\u0010±\u0001\u001a\u00020\u000e2\b\b\u0001\u0010J\u001a\u00020\u001eH\u0016¢\u0006\u0006\b±\u0001\u0010¯\u0001J\u0012\u0010²\u0001\u001a\u00020(H\u0016¢\u0006\u0006\b²\u0001\u0010\u008a\u0001J\u001a\u0010´\u0001\u001a\u00020\u000e2\u0007\u0010³\u0001\u001a\u00020(H\u0016¢\u0006\u0005\b´\u0001\u0010jJ\u0012\u0010µ\u0001\u001a\u00020(H\u0016¢\u0006\u0006\bµ\u0001\u0010\u008a\u0001J\u001a\u0010¶\u0001\u001a\u00020\u000e2\u0007\u0010³\u0001\u001a\u00020(H\u0016¢\u0006\u0005\b¶\u0001\u0010jJ\u0012\u0010·\u0001\u001a\u00020(H\u0016¢\u0006\u0006\b·\u0001\u0010\u008a\u0001J\u001a\u0010¹\u0001\u001a\u00020\u000e2\u0007\u0010¸\u0001\u001a\u00020(H\u0016¢\u0006\u0005\b¹\u0001\u0010jJ\u0013\u0010»\u0001\u001a\u00030º\u0001H\u0016¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u001c\u0010¾\u0001\u001a\u00020\u000e2\b\u0010½\u0001\u001a\u00030º\u0001H\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001b\u0010Á\u0001\u001a\u00020\u000e2\u0007\u0010À\u0001\u001a\u00020\u0017H\u0016¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u0011\u0010Ã\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bÃ\u0001\u0010\u0010J\u0012\u0010Ä\u0001\u001a\u00020(H\u0016¢\u0006\u0006\bÄ\u0001\u0010\u008a\u0001J\u001a\u0010Å\u0001\u001a\u00020\u000e2\u0007\u0010³\u0001\u001a\u00020(H\u0016¢\u0006\u0005\bÅ\u0001\u0010jJ\u001b\u0010Æ\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\bÆ\u0001\u0010\u007fJ\u001b\u0010Ç\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\bÇ\u0001\u0010\u007fJ\u001b\u0010È\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\bÈ\u0001\u0010\u007fJ\u001b\u0010É\u0001\u001a\u00020\u000e2\b\b\u0001\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0005\bÉ\u0001\u0010\u007fJ\u001d\u0010Ê\u0001\u001a\u00020\u000e2\t\u0010§\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0006\bÊ\u0001\u0010©\u0001J\u0013\u0010Ì\u0001\u001a\u00030Ë\u0001H\u0016¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001a\u0010Ð\u0001\u001a\n\u0012\u0005\u0012\u00030Ï\u00010Î\u0001H\u0016¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0006\bÒ\u0001\u0010\u0084\u0001J8\u0010Ó\u0001\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J7\u0010Ó\u0001\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00062\u0007\u0010Õ\u0001\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÓ\u0001\u0010Ö\u0001J0\u0010×\u0001\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\b×\u0001\u0010Ø\u0001J/\u0010×\u0001\u001a\u00020*2\u0007\u0010Õ\u0001\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\b×\u0001\u0010Ù\u0001J0\u0010Ú\u0001\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÚ\u0001\u0010Ø\u0001J/\u0010Ú\u0001\u001a\u00020*2\u0007\u0010Õ\u0001\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÚ\u0001\u0010Ù\u0001J-\u0010Ü\u0001\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00062\u0007\u0010Û\u0001\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J%\u0010Þ\u0001\u001a\u00020\u000b2\u0007\u0010Û\u0001\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J%\u0010à\u0001\u001a\u00020\u000b2\u0007\u0010Û\u0001\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bà\u0001\u0010ß\u0001J\u0019\u0010á\u0001\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0005\bá\u0001\u0010\rJ:\u0010â\u0001\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010B2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bâ\u0001\u0010ã\u0001J9\u0010â\u0001\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010B2\u0007\u0010Õ\u0001\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bâ\u0001\u0010ä\u0001J8\u0010å\u0001\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0006\bå\u0001\u0010Ô\u0001J\u001b\u0010æ\u0001\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0005\bæ\u0001\u0010\u0016J\u001b\u0010ç\u0001\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0005\bç\u0001\u0010\u0016J\u0019\u0010è\u0001\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0005\bè\u0001\u0010\u007fJ\u0011\u0010é\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bé\u0001\u0010\u0010J\u0011\u0010ê\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0005\bê\u0001\u0010\u0010J6\u0010ï\u0001\u001a\u00020\u000e2\u0007\u0010ë\u0001\u001a\u00020\u00062\u0007\u0010ì\u0001\u001a\u00020\u00062\u0007\u0010í\u0001\u001a\u00020\u00062\u0007\u0010î\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\bï\u0001\u0010ð\u0001J$\u0010ó\u0001\u001a\u00020\u000e2\u0007\u0010ñ\u0001\u001a\u00020\u00062\u0007\u0010ò\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\bó\u0001\u0010ô\u0001J?\u0010ú\u0001\u001a\u00020\u000e2\u0007\u0010õ\u0001\u001a\u00020(2\u0007\u0010ö\u0001\u001a\u00020\u00062\u0007\u0010÷\u0001\u001a\u00020\u00062\u0007\u0010ø\u0001\u001a\u00020\u00062\u0007\u0010ù\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\bú\u0001\u0010û\u0001J\u001c\u0010þ\u0001\u001a\u00020\u000e2\b\u0010ý\u0001\u001a\u00030ü\u0001H\u0016¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001R\u0017\u0010\u0080\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0017\u0010\u0082\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0081\u0002R\u0017\u0010\u0083\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0017\u0010\u0085\u0002\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0017\u0010\u0087\u0002\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0086\u0002R\u0017\u0010\u0088\u0002\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0081\u0002R)\u0010\u008b\u0002\u001a\u0014\u0012\u0004\u0012\u00020*0\u0089\u0002j\t\u0012\u0004\u0012\u00020*`\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R)\u0010\u008d\u0002\u001a\u0014\u0012\u0004\u0012\u00020*0\u0089\u0002j\t\u0012\u0004\u0012\u00020*`\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008c\u0002R)\u0010\u008e\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000b0\u0089\u0002j\t\u0012\u0004\u0012\u00020\u000b`\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008c\u0002R\u0019\u0010\u008f\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0019\u0010\u0091\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R\u0019\u0010\u0093\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010\u0092\u0002R\u0019\u0010\u0094\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0092\u0002R\u0019\u0010\u0095\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0092\u0002R\u0019\u0010\u0096\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0092\u0002R\u0019\u0010\u0097\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0092\u0002R\u0019\u0010\u0098\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0092\u0002R\u0019\u0010\u0099\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u0092\u0002R\u0019\u0010\u009a\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u0092\u0002R\u0019\u0010\u009b\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u0092\u0002R\u0019\u0010\u009c\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u0092\u0002R\u0019\u0010\u009d\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u0092\u0002R\u0019\u0010\u009e\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u0092\u0002R\u0019\u0010\u009f\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R\u0019\u0010¡\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010 \u0002R\u001b\u0010¢\u0002\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0002\u0010£\u0002R\u001b\u0010¤\u0002\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010£\u0002R\u0019\u0010¥\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010\u0090\u0002R\u0019\u0010¦\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010\u0090\u0002R\u001b\u0010§\u0002\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u0019\u0010©\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0002\u0010\u0090\u0002R\u0019\u0010ª\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010\u0090\u0002R\u001a\u0010«\u0002\u001a\u00030º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002R\u001b\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0019\u0010¯\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010\u0090\u0002R\u0019\u0010°\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010 \u0002R\u0019\u0010±\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010\u0090\u0002R\u0019\u0010²\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010\u0092\u0002R\u0019\u0010³\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010 \u0002R\u0019\u0010´\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010\u0090\u0002R\u0019\u0010µ\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010\u0090\u0002R\u0019\u0010¶\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010\u0090\u0002R\u001b\u0010·\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R\u001b\u0010¹\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010¸\u0002R\u001b\u0010º\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010¸\u0002R\u001b\u0010»\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¸\u0002R\u0018\u0010½\u0002\u001a\u00030¼\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001b\u0010¿\u0002\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0002\u0010£\u0002R\u0019\u0010À\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010\u0090\u0002R\u0019\u0010Á\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010\u0090\u0002R\u0019\u0010Â\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010\u0090\u0002R\u0018\u0010Ä\u0002\u001a\u00030Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R+\u0010É\u0002\u001a\u00020\u00062\t\b\u0001\u0010Æ\u0002\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\bÇ\u0002\u0010\u0084\u0001\"\u0005\bÈ\u0002\u0010\u007fR)\u0010Ê\u0002\u001a\u00020(2\u0007\u0010Æ\u0002\u001a\u00020(8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\bÊ\u0002\u0010\u008a\u0001\"\u0005\bË\u0002\u0010jR)\u0010Ì\u0002\u001a\u00020(2\u0007\u0010Æ\u0002\u001a\u00020(8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\bÌ\u0002\u0010\u008a\u0001\"\u0005\bÍ\u0002\u0010jR+\u0010Ð\u0002\u001a\u00020\u00062\t\b\u0001\u0010Æ\u0002\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\u000f\u001a\u0006\bÎ\u0002\u0010\u0084\u0001\"\u0005\bÏ\u0002\u0010\u007fR0\u0010Õ\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0001\u0010Æ\u0002\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÑ\u0002\u0010Ò\u0002\"\u0006\bÓ\u0002\u0010Ô\u0002R0\u0010Ø\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0001\u0010Æ\u0002\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÖ\u0002\u0010Ò\u0002\"\u0006\b×\u0002\u0010Ô\u0002R0\u0010Û\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0001\u0010Æ\u0002\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÙ\u0002\u0010Ò\u0002\"\u0006\bÚ\u0002\u0010Ô\u0002¨\u0006à\u0002"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewId", "Landroid/widget/LinearLayout;", "createActionContainer", "(I)Landroid/widget/LinearLayout;", "LY8/t;", "updateTitleGravity", "()V", "applyTitleTextSize", "applyActionsEnabledState", "Landroid/view/View;", "view", "applyActionsEnabledTo", "(Landroid/view/View;)V", "Lcom/stepos/widget/glass/GlassCustomizer;", "defaultGlassCustomizer", "()Lcom/stepos/widget/glass/GlassCustomizer;", "child", "childLeft", "childRight", "contentHeight", "", "axisY", "layoutAction", "(Landroid/view/View;IIILjava/lang/Float;)V", "Landroid/graphics/drawable/Drawable;", "icon", "", "description", "Landroid/view/View$OnClickListener;", "listener", "", "grouped", "Landroid/widget/ImageButton;", "createButton", "(Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;Z)Landroid/widget/ImageButton;", "button", "updateButtonPadding", "(Landroid/widget/ImageButton;)V", "updateActionVisual", "group", "updateGroupVisual", "(Landroid/widget/LinearLayout;)V", "updateButtonLayout", "updateGroupedButtonLayout", "container", "addToContainer", "(Landroid/widget/LinearLayout;Landroid/view/View;)V", "updateContainerSpacing", "updateGroupSpacing", "effectiveActionRadius", "()F", "effectiveGroupRadius", "side", "actionContainer", "visibleWidth", "(Landroid/view/View;)I", "Landroid/view/ViewGroup;", "ancestor", "isDescendant", "(Landroid/view/View;Landroid/view/ViewGroup;)Z", "createActionBackground", "()Landroid/graphics/drawable/Drawable;", "createGroupBackground", "color", "radius", "createRoundedColorDrawable", "(IF)Landroid/graphics/drawable/Drawable;", "applyHotspotRipple", "(Landroid/view/View;F)V", "Landroid/content/res/TypedArray;", "array", "index", "drawableOrColor", "(Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;", "drawable", ChatTracker.CLICK_COPY, "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "resId", "dimension", "(I)I", "attr", "fallback", "resolveColor", "(II)I", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "withAlpha", "(IF)I", "stopOverride", "scrimColor", "presetStop", "resolveBackdropStop", "(Ljava/lang/Integer;II)I", "requestBackdropBlurRefresh", "applyBackdropBlur", "restoreBg", "releaseBackdropBlur", "(Z)V", "getStartActionContainer", "()Landroid/widget/LinearLayout;", "getEndActionContainer", "getLeftActionContainer", "getRightActionContainer", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "getCenterContainer", "()Landroid/view/ViewGroup;", "getCenterView", "()Landroid/view/View;", "setCenterView", "clearCenterView", "getTitle", "()Ljava/lang/CharSequence;", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "titleResId", "(I)V", "getSubtitle", "subtitle", "setSubtitle", "getTitleGravity", "()I", "gravity", "setTitleGravity", "centered", "setTitleCentered", "isTitleCentered", "()Z", "setTitleTextColor", "setTitleTextAppearance", "setTitleTextSizeRes", "getTopPadding", "padding", "setTopPadding", "getBottomPadding", "setBottomPadding", "getSidePadding", "setSidePadding", "getActionSize", ContentDisposition.Parameters.Size, "setActionSize", "getIconSize", "setIconSize", "getActionSpacing", "spacing", "setActionSpacing", "getGroupSpacing", "setGroupSpacing", "getTitleActionGap", "gap", "setTitleActionGap", "getGroupPadding", "setGroupPadding", "getTitleMaxWidth", "maxWidth", "setTitleMaxWidth", "background", "setActionBackground", "(Landroid/graphics/drawable/Drawable;)V", "getActionBackground", "setGroupBackground", "getGroupBackground", "getActionCornerRadius", "setActionCornerRadius", "(F)V", "getGroupCornerRadius", "setGroupCornerRadius", "isGlassEnabled", x5.d.EXTRA_ENABLED, "setGlassEnabled", "isGlassCrossWindow", "setActionsEnabled", "isActionsEnabled", "crossWindow", "setGlassCrossWindow", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "effect", "setGlassEffect", "(Ly7/o;)V", "customizer", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "isIndividualActionGlassEnabled", "setIndividualActionGlassEnabled", "setBackdropScrimColorResource", "setBackdropGradientStartColorResource", "setBackdropGradientMiddleColorResource", "setBackdropGradientEndColorResource", "setBackground", "Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "getGlassRenderMode", "()Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "getGlassActiveCount", "addAction", "(ILandroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "iconResId", "(IILjava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "addStartAction", "(Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "(ILjava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "addEndAction", "text", "addTextAction", "(ILjava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/LinearLayout;", "addStartTextAction", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/LinearLayout;", "addEndTextAction", "addActionGroup", "addActionToGroup", "(Landroid/view/ViewGroup;Landroid/graphics/drawable/Drawable;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "(Landroid/view/ViewGroup;ILjava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/ImageButton;", "addGroupedAction", "addStartView", "addEndView", "clearActions", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "startActions", "Landroid/widget/LinearLayout;", "endActions", "centerContainer", "Landroid/widget/FrameLayout;", "titleView", "Landroid/widget/TextView;", "subtitleView", "titleAreaLayout", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "individualActions", "Ljava/util/ArrayList;", "groupedActions", "groups", "actionsEnabled", "Z", "titleGravity", "I", "sidePadding", "topPadding", "bottomPadding", "actionSize", "iconSize", "actionSpacing", "groupSpacing", "titleActionGap", "groupPadding", "titleMaxWidth", "minHeight", "titleTextColor", "actionCornerRadius", "F", "groupCornerRadius", "actionBackground", "Landroid/graphics/drawable/Drawable;", "groupBackground", "actionBackgroundExplicit", "groupBackgroundExplicit", "customCenterView", "Landroid/view/View;", "glassEnabled", "glassCrossWindow", "glassEffect", "Ly7/o;", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "usingDefaultGlass", "baseTitleTextSizePx", "titleTextSizeExplicit", "titleTextSizeValue", "subtitleTitleTextSizePx", "individualActionGlassEnabled", "pressScaleEnabledValue", "backdropBlurEnabled", "backdropScrimColorOverride", "Ljava/lang/Integer;", "backdropGradientStartColorOverride", "backdropGradientMiddleColorOverride", "backdropGradientEndColorOverride", "Lcom/stepos/widget/glass/GlassDelegate;", "backdropGlassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "backdropFallbackBg", "backdropInternalWrite", "backdropConstructed", "backdropBlurRefreshPosted", "Ljava/lang/Runnable;", "backdropBlurRefreshRunnable", "Ljava/lang/Runnable;", UxipConstants.f30680s, "getTitleTextSize", "setTitleTextSize", "titleTextSize", "isPressScaleEnabled", "setPressScaleEnabled", "isBackdropBlurEnabled", "setBackdropBlurEnabled", "getBackdropScrimColor", "setBackdropScrimColor", "backdropScrimColor", "getBackdropGradientStartColor", "()Ljava/lang/Integer;", "setBackdropGradientStartColor", "(Ljava/lang/Integer;)V", "backdropGradientStartColor", "getBackdropGradientMiddleColor", "setBackdropGradientMiddleColor", "backdropGradientMiddleColor", "getBackdropGradientEndColor", "setBackdropGradientEndColor", "backdropGradientEndColor", "Companion", "GlassRenderMode", "Side", "TitleGravity", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSTitleBar extends FrameLayout {
    private static final float DISABLED_CONTENT_ALPHA = 0.3f;
    public static final int SIDE_END = 1;
    public static final int SIDE_LEFT = 0;
    public static final int SIDE_RIGHT = 1;
    public static final int SIDE_START = 0;
    private static final String TAG = "StepOSTitleBar";
    public static final int TITLE_GRAVITY_CENTER = 1;
    public static final int TITLE_GRAVITY_START = 0;
    private Drawable actionBackground;
    private boolean actionBackgroundExplicit;
    private float actionCornerRadius;
    private int actionSize;
    private int actionSpacing;
    private boolean actionsEnabled;
    private boolean backdropBlurEnabled;
    private boolean backdropBlurRefreshPosted;
    private final Runnable backdropBlurRefreshRunnable;
    private boolean backdropConstructed;
    private Drawable backdropFallbackBg;
    private final GlassDelegate backdropGlassDelegate;
    private Integer backdropGradientEndColorOverride;
    private Integer backdropGradientMiddleColorOverride;
    private Integer backdropGradientStartColorOverride;
    private boolean backdropInternalWrite;
    private Integer backdropScrimColorOverride;
    private float baseTitleTextSizePx;
    private int bottomPadding;
    private final FrameLayout centerContainer;
    private View customCenterView;
    private final LinearLayout endActions;
    private boolean glassCrossWindow;
    private GlassCustomizer glassCustomizer;
    private y7.o glassEffect;
    private boolean glassEnabled;
    private Drawable groupBackground;
    private boolean groupBackgroundExplicit;
    private float groupCornerRadius;
    private int groupPadding;
    private int groupSpacing;
    private final ArrayList<ImageButton> groupedActions;
    private final ArrayList<LinearLayout> groups;
    private int iconSize;
    private boolean individualActionGlassEnabled;
    private final ArrayList<ImageButton> individualActions;
    private int minHeight;
    private boolean pressScaleEnabledValue;
    private int sidePadding;
    private final LinearLayout startActions;
    private float subtitleTitleTextSizePx;
    private final TextView subtitleView;
    private int titleActionGap;
    private final LinearLayout titleAreaLayout;
    private int titleGravity;
    private int titleMaxWidth;
    private int titleTextColor;
    private boolean titleTextSizeExplicit;
    private int titleTextSizeValue;
    private final TextView titleView;
    private int topPadding;
    private boolean usingDefaultGlass;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar$GlassRenderMode;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "PENDING", "MOTION_KIT", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GlassRenderMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GlassRenderMode[] $VALUES;
        public static final GlassRenderMode DISABLED = new GlassRenderMode("DISABLED", 0);
        public static final GlassRenderMode PENDING = new GlassRenderMode("PENDING", 1);
        public static final GlassRenderMode MOTION_KIT = new GlassRenderMode("MOTION_KIT", 2);

        private static final /* synthetic */ GlassRenderMode[] $values() {
            return new GlassRenderMode[]{DISABLED, PENDING, MOTION_KIT};
        }

        static {
            GlassRenderMode[] glassRenderModeArr$values = $values();
            $VALUES = glassRenderModeArr$values;
            $ENTRIES = kotlin.enums.a.a(glassRenderModeArr$values);
        }

        private GlassRenderMode(String str, int i10) {
        }

        public static InterfaceC4149a<GlassRenderMode> getEntries() {
            return $ENTRIES;
        }

        public static GlassRenderMode valueOf(String str) {
            return (GlassRenderMode) Enum.valueOf(GlassRenderMode.class, str);
        }

        public static GlassRenderMode[] values() {
            return (GlassRenderMode[]) $VALUES.clone();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar$Side;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface Side {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSTitleBar$TitleGravity;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface TitleGravity {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final LinearLayout actionContainer(int side) {
        if (side == 0) {
            return this.startActions;
        }
        if (side == 1) {
            return this.endActions;
        }
        throw new IllegalArgumentException("Unsupported side: " + side);
    }

    private final void addToContainer(LinearLayout container, View view) {
        LinearLayout.LayoutParams layoutParams;
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The action view already has a parent");
        }
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.setMarginStart(container.getChildCount() == 0 ? 0 : this.actionSpacing);
        container.addView(view, layoutParams);
        updateContainerSpacing(container);
        if (!this.actionsEnabled) {
            applyActionsEnabledTo(view);
        }
        requestLayout();
    }

    private final void applyActionsEnabledState() {
        applyActionsEnabledTo(this.startActions);
        applyActionsEnabledTo(this.endActions);
    }

    private final void applyActionsEnabledTo(View view) {
        view.setEnabled(this.actionsEnabled);
        if ((view instanceof TextView) && !(view instanceof Button) && !(view instanceof CompoundButton)) {
            ((TextView) view).setAlpha(this.actionsEnabled ? 1.0f : 0.3f);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                applyActionsEnabledTo(childAt);
            }
        }
    }

    private final void applyBackdropBlur() throws Resources.NotFoundException {
        if (!this.backdropBlurEnabled || getWidth() <= 0 || getHeight() <= 0) {
            releaseBackdropBlur(true);
            return;
        }
        final float dimension = getResources().getDimension(R.dimen.stepos_titlebar_backdrop_blur_radius);
        this.backdropInternalWrite = true;
        try {
            super.setBackground(null);
            this.backdropInternalWrite = false;
            final int backdropScrimColor = getBackdropScrimColor();
            if (!this.backdropGlassDelegate.applyCustom$StepOSWidget_release(0, 0.0f, new InterfaceC5074l() { // from class: com.stepos.widget.toolbar.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSTitleBar.applyBackdropBlur$lambda$63(dimension, this, backdropScrimColor, (B) obj);
                }
            })) {
                this.backdropInternalWrite = true;
                try {
                    super.setBackground(this.backdropFallbackBg);
                } finally {
                }
            }
            invalidate();
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final B applyBackdropBlur$lambda$63(final float f10, final StepOSTitleBar stepOSTitleBar, final int i10, B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return builder.j(G.a.f43886a.g(), new InterfaceC5074l() { // from class: com.stepos.widget.toolbar.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSTitleBar.applyBackdropBlur$lambda$63$lambda$62(f10, stepOSTitleBar, i10, (A7.B) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyBackdropBlur$lambda$63$lambda$62(float f10, StepOSTitleBar stepOSTitleBar, int i10, A7.B apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(f10);
        int startColor = apply.getStartColor();
        int middleColor = apply.getMiddleColor();
        int endColor = apply.getEndColor();
        apply.D(stepOSTitleBar.resolveBackdropStop(stepOSTitleBar.backdropGradientStartColorOverride, i10, startColor));
        apply.C(stepOSTitleBar.resolveBackdropStop(stepOSTitleBar.backdropGradientMiddleColorOverride, i10, middleColor));
        apply.A(stepOSTitleBar.resolveBackdropStop(stepOSTitleBar.backdropGradientEndColorOverride, i10, endColor));
        return Y8.t.f7040a;
    }

    private final void applyHotspotRipple(View view, float radius) {
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, view, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, radius), false, this.pressScaleEnabledValue, radius, 8, null);
    }

    private final void applyTitleTextSize() {
        TextView textView = this.titleView;
        int i10 = this.titleTextSizeValue;
        textView.setTextSize(0, i10 > 0 ? i10 : this.baseTitleTextSizePx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void backdropBlurRefreshRunnable$lambda$0(StepOSTitleBar stepOSTitleBar) throws Resources.NotFoundException {
        stepOSTitleBar.backdropBlurRefreshPosted = false;
        if (stepOSTitleBar.isAttachedToWindow()) {
            stepOSTitleBar.applyBackdropBlur();
        }
    }

    private final Drawable copy(Drawable drawable) {
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        if (drawable == null) {
            return null;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        kotlin.jvm.internal.p.h(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    private final Drawable createActionBackground() {
        Drawable drawableCopy = copy(this.actionBackground);
        if (drawableCopy instanceof ColorDrawable) {
            return createRoundedColorDrawable(((ColorDrawable) drawableCopy).getColor(), effectiveActionRadius());
        }
        if (drawableCopy != null) {
            return drawableCopy;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(effectiveActionRadius());
        return gradientDrawable;
    }

    private final LinearLayout createActionContainer(int viewId) {
        LinearLayout linearLayout = new LinearLayout(getContext()) { // from class: com.stepos.widget.toolbar.StepOSTitleBar.createActionContainer.1
            @Override // android.view.ViewGroup
            public void onViewRemoved(View child) {
                kotlin.jvm.internal.p.i(child, "child");
                super.onViewRemoved(child);
                z.a(StepOSTitleBar.this.individualActions).remove(child);
                z.a(StepOSTitleBar.this.groupedActions).remove(child);
                if (child instanceof LinearLayout) {
                    StepOSTitleBar.this.groups.remove(child);
                }
            }
        };
        linearLayout.setId(viewId);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        return linearLayout;
    }

    private final ImageButton createButton(Drawable icon, CharSequence description, View.OnClickListener listener, boolean grouped) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        StepOSGlassImageButton stepOSGlassImageButton = new StepOSGlassImageButton(context, null, 0, 0, 14, null);
        stepOSGlassImageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        stepOSGlassImageButton.setImageDrawable(copy(icon));
        stepOSGlassImageButton.setContentDescription(description);
        stepOSGlassImageButton.setClickable(true);
        stepOSGlassImageButton.setFocusable(true);
        stepOSGlassImageButton.setOnClickListener(listener);
        stepOSGlassImageButton.setGlassCrossWindow(this.glassCrossWindow);
        stepOSGlassImageButton.setGlassEffect(this.glassEffect);
        if (grouped) {
            stepOSGlassImageButton.setGlassEnabled(false);
            stepOSGlassImageButton.setPadding(0, 0, 0, 0);
            stepOSGlassImageButton.setSurfaceDrawable(null);
            stepOSGlassImageButton.setPressScaleEnabled(false);
            stepOSGlassImageButton.setForeground(null);
            stepOSGlassImageButton.setClipToOutline(false);
            return stepOSGlassImageButton;
        }
        stepOSGlassImageButton.setGlassEnabled(this.glassEnabled && this.individualActionGlassEnabled);
        stepOSGlassImageButton.setGlassCornerRadius(this.actionCornerRadius);
        GlassCustomizer glassCustomizer = this.glassCustomizer;
        if (glassCustomizer != null) {
            stepOSGlassImageButton.applyCustomGlass(glassCustomizer);
        }
        stepOSGlassImageButton.setPressScaleEnabled(this.pressScaleEnabledValue);
        updateButtonPadding(stepOSGlassImageButton);
        updateActionVisual(stepOSGlassImageButton);
        return stepOSGlassImageButton;
    }

    private final Drawable createGroupBackground() {
        Drawable drawableCopy = copy(this.groupBackground);
        boolean z10 = drawableCopy instanceof ColorDrawable;
        Drawable drawable = drawableCopy;
        if (z10) {
            return createRoundedColorDrawable(((ColorDrawable) drawableCopy).getColor(), effectiveGroupRadius());
        }
        if (drawableCopy == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor((!this.glassEnabled || this.groupBackgroundExplicit) ? R.color.stepos_titlebar_action_group_background : R.color.stepos_titlebar_glass_surface));
            gradientDrawable.setCornerRadius(effectiveGroupRadius());
            drawable = gradientDrawable;
        }
        return drawable;
    }

    private final Drawable createRoundedColorDrawable(int color, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(radius);
        return gradientDrawable;
    }

    private final GlassCustomizer defaultGlassCustomizer() {
        return (getResources().getConfiguration().uiMode & 48) == 32 ? StepOSGlassPresets.INSTANCE.TITLE_BAR_DARK_TUNED(getResources().getDisplayMetrics().density) : StepOSGlassPresets.INSTANCE.LIGHT_SMALL_TUNED(getResources().getDisplayMetrics().density);
    }

    private final int dimension(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    private final Drawable drawableOrColor(TypedArray array, int index) {
        if (!array.hasValue(index)) {
            return null;
        }
        Drawable drawable = array.getDrawable(index);
        return drawable == null ? new ColorDrawable(array.getColor(index, 0)) : drawable;
    }

    private final float effectiveActionRadius() {
        float f10 = this.actionCornerRadius;
        return f10 > 0.0f ? f10 : this.actionSize / 2.0f;
    }

    private final float effectiveGroupRadius() {
        float f10 = this.groupCornerRadius;
        return f10 > 0.0f ? f10 : this.actionSize / 2.0f;
    }

    private final boolean isDescendant(View child, ViewGroup ancestor) {
        while (child != null) {
            if (child == ancestor) {
                return true;
            }
            Object parent = child.getParent();
            child = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private final void layoutAction(View child, int childLeft, int childRight, int contentHeight, Float axisY) {
        int paddingTop = axisY == null ? getPaddingTop() + ((contentHeight - child.getMeasuredHeight()) / 2) : Math.round(axisY.floatValue() - (child.getMeasuredHeight() / 2.0f));
        child.layout(childLeft, paddingTop, childRight, child.getMeasuredHeight() + paddingTop);
    }

    private final void releaseBackdropBlur(boolean restoreBg) {
        this.backdropGlassDelegate.release$StepOSWidget_release();
        if (restoreBg) {
            this.backdropInternalWrite = true;
            try {
                super.setBackground(this.backdropFallbackBg);
            } finally {
                this.backdropInternalWrite = false;
            }
        }
    }

    private final void requestBackdropBlurRefresh() {
        if (this.backdropBlurEnabled && isAttachedToWindow() && !this.backdropBlurRefreshPosted) {
            this.backdropBlurRefreshPosted = true;
            post(this.backdropBlurRefreshRunnable);
        }
    }

    private final int resolveBackdropStop(Integer stopOverride, int scrimColor, int presetStop) {
        return stopOverride != null ? stopOverride.intValue() : withAlpha(scrimColor, ((presetStop >>> 24) & 255) / 255.0f);
    }

    private final int resolveColor(int attr, int fallback) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(attr, typedValue, true)) {
            int i10 = typedValue.type;
            if (28 <= i10 && i10 < 32) {
                return typedValue.data;
            }
            if (typedValue.resourceId != 0) {
                try {
                    return getResources().getColor(typedValue.resourceId);
                } catch (RuntimeException unused) {
                }
            }
        }
        return fallback;
    }

    private final void updateActionVisual(ImageButton button) {
        boolean z10 = button instanceof StepOSGlassImageButton;
        StepOSGlassImageButton stepOSGlassImageButton = z10 ? (StepOSGlassImageButton) button : null;
        if (stepOSGlassImageButton != null) {
            stepOSGlassImageButton.setSurfaceDrawable((this.glassEnabled && this.individualActionGlassEnabled) ? null : createActionBackground());
        }
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, button, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, effectiveActionRadius()), false, false, effectiveActionRadius(), 8, null);
        StepOSGlassImageButton stepOSGlassImageButton2 = z10 ? (StepOSGlassImageButton) button : null;
        if (stepOSGlassImageButton2 != null) {
            stepOSGlassImageButton2.setPressScaleEnabled(this.pressScaleEnabledValue);
        }
    }

    private final void updateButtonLayout(ImageButton button) {
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (layoutParams == null) {
            int i10 = this.actionSize;
            layoutParams = new LinearLayout.LayoutParams(i10, i10);
        }
        int i11 = this.actionSize;
        layoutParams.width = i11;
        layoutParams.height = i11;
        button.setLayoutParams(layoutParams);
        updateButtonPadding(button);
        updateActionVisual(button);
    }

    private final void updateButtonPadding(ImageButton button) {
        int iMax = Math.max(0, (this.actionSize - this.iconSize) / 2);
        button.setPadding(iMax, iMax, iMax, iMax);
        button.setMinimumWidth(this.actionSize);
        button.setMinimumHeight(this.actionSize);
    }

    private final void updateContainerSpacing(LinearLayout container) {
        int childCount = container.getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = container.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(i10 == 0 ? 0 : this.actionSpacing);
                childAt.setLayoutParams(layoutParams);
            }
            i10++;
        }
    }

    private final void updateGroupSpacing(LinearLayout group) {
        int childCount = group.getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = group.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(i10 == 0 ? 0 : this.groupSpacing);
                int i11 = this.iconSize;
                layoutParams2.width = i11;
                layoutParams2.height = i11;
                childAt.setLayoutParams(layoutParams);
            }
            i10++;
        }
    }

    private final void updateGroupVisual(LinearLayout group) {
        StepOSGlassLinearLayout stepOSGlassLinearLayout = group instanceof StepOSGlassLinearLayout ? (StepOSGlassLinearLayout) group : null;
        if (stepOSGlassLinearLayout != null) {
            stepOSGlassLinearLayout.setSurfaceDrawable(this.glassEnabled ? null : createGroupBackground());
        }
        if (kotlin.jvm.internal.p.d(group.getTag(R.id.stepos_titlebar_action_group), Boolean.TRUE)) {
            HotspotRipple.installOnComposite$StepOSWidget_release$default(HotspotRipple.INSTANCE, group, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, effectiveGroupRadius()), false, this.pressScaleEnabledValue, effectiveGroupRadius(), 8, null);
        } else {
            applyHotspotRipple(group, effectiveGroupRadius());
        }
    }

    private final void updateGroupedButtonLayout(ImageButton button) {
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (layoutParams == null) {
            int i10 = this.iconSize;
            layoutParams = new LinearLayout.LayoutParams(i10, i10);
        }
        int i11 = this.iconSize;
        layoutParams.width = i11;
        layoutParams.height = i11;
        button.setLayoutParams(layoutParams);
        button.setPadding(0, 0, 0, 0);
        button.setBackground(null);
        button.setForeground(null);
        button.setClipToOutline(false);
    }

    private final void updateTitleGravity() {
        int i10 = this.titleGravity == 1 ? 17 : 8388627;
        this.titleView.setGravity(i10);
        this.subtitleView.setGravity(i10);
    }

    private final int visibleWidth(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    private final int withAlpha(int color, float alpha) {
        return Color.argb(C5227b.b(C5685n.m(alpha, 0.0f, 1.0f) * 255.0f), Color.red(color), Color.green(color), Color.blue(color));
    }

    public ImageButton addAction(int side, Drawable icon, CharSequence description, View.OnClickListener listener) {
        ImageButton imageButtonCreateButton = createButton(icon, description, listener, false);
        addToContainer(actionContainer(side), imageButtonCreateButton);
        this.individualActions.add(imageButtonCreateButton);
        return imageButtonCreateButton;
    }

    public LinearLayout addActionGroup(int side) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        StepOSGlassLinearLayout stepOSGlassLinearLayout = new StepOSGlassLinearLayout(context, null, 0, 0, 14, null);
        stepOSGlassLinearLayout.setOrientation(0);
        stepOSGlassLinearLayout.setGravity(16);
        stepOSGlassLinearLayout.setClipChildren(false);
        stepOSGlassLinearLayout.setClipToPadding(false);
        stepOSGlassLinearLayout.setMinimumHeight(this.actionSize);
        int i10 = this.groupPadding;
        stepOSGlassLinearLayout.setPadding(i10, 0, i10, 0);
        stepOSGlassLinearLayout.setGlassEnabled(this.glassEnabled);
        stepOSGlassLinearLayout.setGlassCrossWindow(this.glassCrossWindow);
        stepOSGlassLinearLayout.setGlassEffect(this.glassEffect);
        stepOSGlassLinearLayout.setGlassCornerRadius(this.groupCornerRadius);
        GlassCustomizer glassCustomizer = this.glassCustomizer;
        if (glassCustomizer != null) {
            stepOSGlassLinearLayout.applyCustomGlass(glassCustomizer);
        }
        stepOSGlassLinearLayout.setSurfaceDrawable(this.glassEnabled ? null : createGroupBackground());
        stepOSGlassLinearLayout.setTag(R.id.stepos_titlebar_action_group, Boolean.TRUE);
        HotspotRipple.installOnComposite$StepOSWidget_release$default(HotspotRipple.INSTANCE, stepOSGlassLinearLayout, stepOSGlassLinearLayout.getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, effectiveGroupRadius()), false, this.pressScaleEnabledValue, effectiveGroupRadius(), 8, null);
        addToContainer(actionContainer(side), stepOSGlassLinearLayout);
        this.groups.add(stepOSGlassLinearLayout);
        return stepOSGlassLinearLayout;
    }

    public ImageButton addActionToGroup(ViewGroup group, Drawable icon, CharSequence description, View.OnClickListener listener) {
        if (group == null) {
            throw new IllegalArgumentException("group must not be null");
        }
        ImageButton imageButtonCreateButton = createButton(icon, description, listener, true);
        int i10 = this.iconSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
        layoutParams.setMarginStart(group.getChildCount() == 0 ? 0 : this.groupSpacing);
        group.addView(imageButtonCreateButton, layoutParams);
        this.groupedActions.add(imageButtonCreateButton);
        if (!this.actionsEnabled) {
            applyActionsEnabledTo(imageButtonCreateButton);
        }
        return imageButtonCreateButton;
    }

    public ImageButton addEndAction(Drawable icon, CharSequence description, View.OnClickListener listener) {
        return addAction(1, icon, description, listener);
    }

    public LinearLayout addEndTextAction(CharSequence text, View.OnClickListener listener) {
        kotlin.jvm.internal.p.i(text, "text");
        return addTextAction(1, text, listener);
    }

    public void addEndView(View view) {
        addToContainer(this.endActions, view);
    }

    public ImageButton addGroupedAction(int side, Drawable icon, CharSequence description, View.OnClickListener listener) {
        return addActionToGroup(addActionGroup(side), icon, description, listener);
    }

    public ImageButton addStartAction(Drawable icon, CharSequence description, View.OnClickListener listener) {
        return addAction(0, icon, description, listener);
    }

    public LinearLayout addStartTextAction(CharSequence text, View.OnClickListener listener) {
        kotlin.jvm.internal.p.i(text, "text");
        return addTextAction(0, text, listener);
    }

    public void addStartView(View view) {
        addToContainer(this.startActions, view);
    }

    public LinearLayout addTextAction(int side, CharSequence text, View.OnClickListener listener) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(text, "text");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_titlebar_text_action_padding);
        float dimension = getResources().getDimension(R.dimen.stepos_titlebar_text_action_text_size);
        float f10 = getResources().getDisplayMetrics().density;
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setTextSize(0, dimension);
        textView.setTypeface(Typeface.create(textView.getTypeface(), 600, false));
        textView.setTextColor(this.titleView.getTextColors());
        textView.setGravity(17);
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        StepOSGlassLinearLayout stepOSGlassLinearLayout = new StepOSGlassLinearLayout(context, null, 0, 0, 14, null);
        stepOSGlassLinearLayout.setOrientation(0);
        stepOSGlassLinearLayout.setGravity(17);
        stepOSGlassLinearLayout.setMinimumHeight(this.actionSize);
        stepOSGlassLinearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        stepOSGlassLinearLayout.setGlassEnabled(this.glassEnabled);
        stepOSGlassLinearLayout.setGlassCrossWindow(this.glassCrossWindow);
        stepOSGlassLinearLayout.setGlassEffect(this.glassEffect);
        stepOSGlassLinearLayout.setGlassCornerRadius(this.actionCornerRadius);
        GlassCustomizer glassCustomizer = this.glassCustomizer;
        if (glassCustomizer != null) {
            stepOSGlassLinearLayout.applyCustomGlass(glassCustomizer);
        }
        stepOSGlassLinearLayout.setSurfaceDrawable(this.glassEnabled ? null : createGroupBackground());
        stepOSGlassLinearLayout.setClickable(true);
        stepOSGlassLinearLayout.setFocusable(true);
        stepOSGlassLinearLayout.setOnClickListener(listener);
        applyHotspotRipple(stepOSGlassLinearLayout, effectiveActionRadius());
        stepOSGlassLinearLayout.addView(textView);
        addToContainer(actionContainer(side), stepOSGlassLinearLayout);
        this.groups.add(stepOSGlassLinearLayout);
        return stepOSGlassLinearLayout;
    }

    public void applyCustomGlass(GlassCustomizer customizer) {
        kotlin.jvm.internal.p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        this.usingDefaultGlass = false;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).applyCustomGlass(customizer);
        }
        ArrayList<LinearLayout> arrayList3 = this.groups;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (obj2 instanceof StepOSGlassLinearLayout) {
                arrayList4.add(obj2);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassLinearLayout) it2.next()).applyCustomGlass(customizer);
        }
    }

    public void clearActions(int side) {
        LinearLayout linearLayoutActionContainer = actionContainer(side);
        Iterator<ImageButton> it = this.individualActions.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            ImageButton next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            if (isDescendant(next, linearLayoutActionContainer)) {
                it.remove();
            }
        }
        Iterator<ImageButton> it2 = this.groupedActions.iterator();
        kotlin.jvm.internal.p.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            ImageButton next2 = it2.next();
            kotlin.jvm.internal.p.h(next2, "next(...)");
            if (isDescendant(next2, linearLayoutActionContainer)) {
                it2.remove();
            }
        }
        Iterator<LinearLayout> it3 = this.groups.iterator();
        kotlin.jvm.internal.p.h(it3, "iterator(...)");
        while (it3.hasNext()) {
            LinearLayout next3 = it3.next();
            kotlin.jvm.internal.p.h(next3, "next(...)");
            if (isDescendant(next3, linearLayoutActionContainer)) {
                it3.remove();
            }
        }
        linearLayoutActionContainer.removeAllViews();
        requestLayout();
    }

    public void clearCenterView() {
        View view = this.customCenterView;
        if (view != null) {
            this.centerContainer.removeView(view);
            this.customCenterView = null;
        }
        this.titleAreaLayout.setVisibility(0);
        requestLayout();
    }

    public void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = defaultGlassCustomizer();
        this.usingDefaultGlass = true;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).applyCustomGlass(defaultGlassCustomizer());
        }
        ArrayList<LinearLayout> arrayList3 = this.groups;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (obj2 instanceof StepOSGlassLinearLayout) {
                arrayList4.add(obj2);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassLinearLayout) it2.next()).applyCustomGlass(defaultGlassCustomizer());
        }
    }

    public Drawable getActionBackground() {
        return copy(this.actionBackground);
    }

    public float getActionCornerRadius() {
        return this.actionCornerRadius;
    }

    public int getActionSize() {
        return this.actionSize;
    }

    public int getActionSpacing() {
        return this.actionSpacing;
    }

    /* renamed from: getBackdropGradientEndColor, reason: from getter */
    public Integer getBackdropGradientEndColorOverride() {
        return this.backdropGradientEndColorOverride;
    }

    /* renamed from: getBackdropGradientMiddleColor, reason: from getter */
    public Integer getBackdropGradientMiddleColorOverride() {
        return this.backdropGradientMiddleColorOverride;
    }

    /* renamed from: getBackdropGradientStartColor, reason: from getter */
    public Integer getBackdropGradientStartColorOverride() {
        return this.backdropGradientStartColorOverride;
    }

    public int getBackdropScrimColor() {
        Integer num = this.backdropScrimColorOverride;
        return num != null ? num.intValue() : getResources().getColor(R.color.stepos_titlebar_backdrop_scrim_top);
    }

    public int getBottomPadding() {
        return this.bottomPadding;
    }

    public ViewGroup getCenterContainer() {
        return this.centerContainer;
    }

    public View getCenterView() {
        View view = this.customCenterView;
        return view == null ? this.titleAreaLayout : view;
    }

    /* renamed from: getEndActionContainer, reason: from getter */
    public LinearLayout getEndActions() {
        return this.endActions;
    }

    public int getGlassActiveCount() {
        return getGlassActiveIds().size();
    }

    public Set<String> getGlassActiveIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (View view : F.S0(this.individualActionGlassEnabled ? this.individualActions : C1173v.m(), this.groups)) {
            if (view instanceof StepOSGlassImageButton) {
                linkedHashSet.addAll(((StepOSGlassImageButton) view).getGlassActiveIds());
            } else if (view instanceof StepOSGlassLinearLayout) {
                linkedHashSet.addAll(((StepOSGlassLinearLayout) view).getGlassActiveIds());
            }
        }
        return linkedHashSet;
    }

    public y7.o getGlassEffect() {
        return this.glassEffect;
    }

    public GlassRenderMode getGlassRenderMode() {
        if (!this.glassEnabled) {
            return GlassRenderMode.DISABLED;
        }
        List listS0 = F.S0(this.individualActionGlassEnabled ? this.individualActions : C1173v.m(), this.groups);
        if (listS0.isEmpty()) {
            return GlassRenderMode.PENDING;
        }
        List list = listS0;
        boolean z10 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View view = (View) it.next();
                if (!(view instanceof StepOSGlassImageButton ? ((StepOSGlassImageButton) view).isGlassActive() : view instanceof StepOSGlassLinearLayout ? ((StepOSGlassLinearLayout) view).isGlassActive() : false)) {
                    z10 = false;
                    break;
                }
            }
        }
        return z10 ? GlassRenderMode.MOTION_KIT : GlassRenderMode.PENDING;
    }

    public Drawable getGroupBackground() {
        return copy(this.groupBackground);
    }

    public float getGroupCornerRadius() {
        return this.groupCornerRadius;
    }

    public int getGroupPadding() {
        return this.groupPadding;
    }

    public int getGroupSpacing() {
        return this.groupSpacing;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    /* renamed from: getLeftActionContainer, reason: from getter */
    public LinearLayout getStartActions() {
        return this.startActions;
    }

    public LinearLayout getRightActionContainer() {
        return this.endActions;
    }

    public int getSidePadding() {
        return this.sidePadding;
    }

    public LinearLayout getStartActionContainer() {
        return this.startActions;
    }

    public CharSequence getSubtitle() {
        CharSequence text = this.subtitleView.getText();
        kotlin.jvm.internal.p.h(text, "getText(...)");
        return text;
    }

    public CharSequence getTitle() {
        CharSequence text = this.titleView.getText();
        kotlin.jvm.internal.p.h(text, "getText(...)");
        return text;
    }

    public int getTitleActionGap() {
        return this.titleActionGap;
    }

    public int getTitleGravity() {
        return this.titleGravity;
    }

    public int getTitleMaxWidth() {
        return this.titleMaxWidth;
    }

    /* renamed from: getTitleTextSize, reason: from getter */
    public int getTitleTextSizeValue() {
        return this.titleTextSizeValue;
    }

    public TextView getTitleView() {
        return this.titleView;
    }

    public int getTopPadding() {
        return this.topPadding;
    }

    /* renamed from: isActionsEnabled, reason: from getter */
    public boolean getActionsEnabled() {
        return this.actionsEnabled;
    }

    /* renamed from: isBackdropBlurEnabled, reason: from getter */
    public boolean getBackdropBlurEnabled() {
        return this.backdropBlurEnabled;
    }

    /* renamed from: isGlassCrossWindow, reason: from getter */
    public boolean getGlassCrossWindow() {
        return this.glassCrossWindow;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public boolean getGlassEnabled() {
        return this.glassEnabled;
    }

    /* renamed from: isIndividualActionGlassEnabled, reason: from getter */
    public boolean getIndividualActionGlassEnabled() {
        return this.individualActionGlassEnabled;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    public boolean isTitleCentered() {
        return this.titleGravity == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.backdropBlurEnabled) {
            requestBackdropBlurRefresh();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.glassEnabled && this.usingDefaultGlass && this.glassCustomizer != null) {
            GlassCustomizer glassCustomizerDefaultGlassCustomizer = defaultGlassCustomizer();
            this.glassCustomizer = glassCustomizerDefaultGlassCustomizer;
            ArrayList<ImageButton> arrayList = this.individualActions;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof StepOSGlassImageButton) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((StepOSGlassImageButton) it.next()).applyCustomGlass(glassCustomizerDefaultGlassCustomizer);
            }
            ArrayList<LinearLayout> arrayList3 = this.groups;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (obj2 instanceof StepOSGlassLinearLayout) {
                    arrayList4.add(obj2);
                }
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                ((StepOSGlassLinearLayout) it2.next()).applyCustomGlass(glassCustomizerDefaultGlassCustomizer);
            }
        }
        Iterator<T> it3 = this.individualActions.iterator();
        while (it3.hasNext()) {
            updateActionVisual((ImageButton) it3.next());
        }
        Iterator<T> it4 = this.groups.iterator();
        while (it4.hasNext()) {
            updateGroupVisual((LinearLayout) it4.next());
        }
        if (this.backdropBlurEnabled) {
            requestBackdropBlurRefresh();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.backdropBlurRefreshRunnable);
        this.backdropBlurRefreshPosted = false;
        releaseBackdropBlur(false);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i10 = right - left;
        int i11 = bottom - top;
        int i12 = 0;
        boolean z10 = getLayoutDirection() == 1;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i10 - getPaddingRight();
        int iMax = Math.max(0, (i11 - getPaddingTop()) - getPaddingBottom());
        int iVisibleWidth = visibleWidth(this.startActions);
        int iVisibleWidth2 = visibleWidth(this.endActions);
        int measuredWidth = this.centerContainer.getMeasuredWidth();
        int i13 = z10 ? iVisibleWidth2 : iVisibleWidth;
        int i14 = z10 ? iVisibleWidth : iVisibleWidth2;
        int i15 = (measuredWidth <= 0 || i13 <= 0) ? 0 : this.titleActionGap;
        if (measuredWidth > 0 && i14 > 0) {
            i12 = this.titleActionGap;
        }
        int iMax2 = i13 + paddingLeft + i15;
        int i16 = (paddingRight - i14) - i12;
        if (this.titleGravity == 1 || this.customCenterView != null) {
            iMax2 = Math.max(iMax2, Math.min((i10 - measuredWidth) / 2, i16 - measuredWidth));
        } else if (z10) {
            iMax2 = i16 - measuredWidth;
        }
        int paddingTop = getPaddingTop() + ((iMax - this.centerContainer.getMeasuredHeight()) / 2);
        FrameLayout frameLayout = this.centerContainer;
        frameLayout.layout(iMax2, paddingTop, measuredWidth + iMax2, frameLayout.getMeasuredHeight() + paddingTop);
        Float fValueOf = (this.customCenterView == null && this.subtitleView.getVisibility() == 0 && this.titleView.getVisibility() == 0) ? Float.valueOf(this.centerContainer.getTop() + this.titleAreaLayout.getTop() + this.titleView.getTop() + (this.titleView.getMeasuredHeight() / 2.0f)) : null;
        if (z10) {
            layoutAction(this.startActions, paddingRight - iVisibleWidth, paddingRight, iMax, fValueOf);
            layoutAction(this.endActions, paddingLeft, paddingLeft + iVisibleWidth2, iMax, fValueOf);
        } else {
            layoutAction(this.startActions, paddingLeft, paddingLeft + iVisibleWidth, iMax, fValueOf);
            layoutAction(this.endActions, paddingRight - iVisibleWidth2, paddingRight, iMax, fValueOf);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iMax = mode == 0 ? 536870911 : Math.max(0, size - paddingLeft);
        int iMax2 = mode2 != 0 ? Math.max(0, size2 - paddingTop) : 536870911;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE);
        this.startActions.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.endActions.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        View centerView = getCenterView();
        boolean z10 = (centerView.getVisibility() == 8 || (this.customCenterView == null && TextUtils.isEmpty(this.titleView.getText()))) ? false : true;
        if (z10) {
            centerView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        int iVisibleWidth = visibleWidth(this.startActions);
        int iVisibleWidth2 = visibleWidth(this.endActions);
        int measuredWidth = z10 ? centerView.getMeasuredWidth() : 0;
        if (this.customCenterView == null && (i10 = this.titleMaxWidth) > 0) {
            measuredWidth = Math.min(measuredWidth, i10);
        }
        int i11 = (!z10 || iVisibleWidth <= 0) ? 0 : this.titleActionGap;
        int i12 = (!z10 || iVisibleWidth2 <= 0) ? 0 : this.titleActionGap;
        int iResolveSize = View.resolveSize(paddingLeft + iVisibleWidth + iVisibleWidth2 + i11 + i12 + measuredWidth, widthMeasureSpec);
        int iMin = !z10 ? 0 : Math.min(measuredWidth, Math.max(0, (((Math.max(0, iResolveSize - paddingLeft) - iVisibleWidth) - iVisibleWidth2) - i11) - i12));
        int iResolveSize2 = View.resolveSize(Math.max(this.minHeight, Math.max(this.startActions.getMeasuredHeight(), Math.max(this.endActions.getMeasuredHeight(), z10 ? centerView.getMeasuredHeight() : 0)) + paddingTop), heightMeasureSpec);
        int iMax3 = Math.max(0, iResolveSize2 - paddingTop);
        if (z10) {
            centerView.forceLayout();
        }
        this.centerContainer.forceLayout();
        this.centerContainer.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (this.backdropBlurEnabled) {
            requestBackdropBlurRefresh();
        }
    }

    public void setActionBackground(Drawable background) {
        this.actionBackground = copy(background);
        this.actionBackgroundExplicit = background != null;
        Iterator<T> it = this.individualActions.iterator();
        while (it.hasNext()) {
            updateActionVisual((ImageButton) it.next());
        }
    }

    public void setActionCornerRadius(float radius) {
        this.actionCornerRadius = Math.max(0.0f, radius);
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassCornerRadius(this.actionCornerRadius);
        }
        Iterator<T> it2 = this.individualActions.iterator();
        while (it2.hasNext()) {
            updateActionVisual((ImageButton) it2.next());
        }
    }

    public void setActionSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException(("actionSize must be >= 1 but was " + size).toString());
        }
        this.actionSize = size;
        Iterator<T> it = this.individualActions.iterator();
        while (it.hasNext()) {
            updateButtonLayout((ImageButton) it.next());
        }
        Iterator<T> it2 = this.groupedActions.iterator();
        while (it2.hasNext()) {
            updateGroupedButtonLayout((ImageButton) it2.next());
        }
        for (LinearLayout linearLayout : this.groups) {
            linearLayout.setMinimumHeight(this.actionSize);
            updateGroupVisual(linearLayout);
        }
        requestLayout();
    }

    public void setActionSpacing(int spacing) {
        if (spacing < 0) {
            throw new IllegalArgumentException(("actionSpacing must be >= 0 but was " + spacing).toString());
        }
        this.actionSpacing = spacing;
        updateContainerSpacing(this.startActions);
        updateContainerSpacing(this.endActions);
        requestLayout();
    }

    public void setActionsEnabled(boolean enabled) {
        if (this.actionsEnabled == enabled) {
            return;
        }
        this.actionsEnabled = enabled;
        applyActionsEnabledState();
    }

    public void setBackdropBlurEnabled(boolean z10) {
        if (this.backdropBlurEnabled == z10) {
            return;
        }
        this.backdropBlurEnabled = z10;
        if (z10) {
            requestBackdropBlurRefresh();
        } else {
            releaseBackdropBlur(true);
        }
    }

    public void setBackdropGradientEndColor(Integer num) {
        if (kotlin.jvm.internal.p.d(this.backdropGradientEndColorOverride, num)) {
            return;
        }
        this.backdropGradientEndColorOverride = num;
        requestBackdropBlurRefresh();
    }

    public void setBackdropGradientEndColorResource(int resId) {
        setBackdropGradientEndColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropGradientMiddleColor(Integer num) {
        if (kotlin.jvm.internal.p.d(this.backdropGradientMiddleColorOverride, num)) {
            return;
        }
        this.backdropGradientMiddleColorOverride = num;
        requestBackdropBlurRefresh();
    }

    public void setBackdropGradientMiddleColorResource(int resId) {
        setBackdropGradientMiddleColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropGradientStartColor(Integer num) {
        if (kotlin.jvm.internal.p.d(this.backdropGradientStartColorOverride, num)) {
            return;
        }
        this.backdropGradientStartColorOverride = num;
        requestBackdropBlurRefresh();
    }

    public void setBackdropGradientStartColorResource(int resId) {
        setBackdropGradientStartColor(Integer.valueOf(resId == 0 ? 0 : getContext().getColor(resId)));
    }

    public void setBackdropScrimColor(int i10) {
        Integer num = this.backdropScrimColorOverride;
        if (num != null && num.intValue() == i10) {
            return;
        }
        this.backdropScrimColorOverride = Integer.valueOf(i10);
        requestBackdropBlurRefresh();
    }

    public void setBackdropScrimColorResource(int resId) {
        setBackdropScrimColor(getContext().getColor(resId));
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (!this.backdropConstructed || this.backdropInternalWrite) {
            super.setBackground(background);
            return;
        }
        this.backdropFallbackBg = background;
        if (this.backdropGlassDelegate.getIsActive()) {
            return;
        }
        super.setBackground(background);
    }

    public void setBottomPadding(int padding) {
        int iMax = Math.max(0, padding);
        this.bottomPadding = iMax;
        int i10 = this.sidePadding;
        setPaddingRelative(i10, this.topPadding, i10, iMax);
        requestLayout();
    }

    public void setCenterView(View view) {
        if (view == null) {
            clearCenterView();
            return;
        }
        if (view == this.customCenterView) {
            return;
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The center view already has a parent");
        }
        View view2 = this.customCenterView;
        if (view2 != null) {
            this.centerContainer.removeView(view2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        if (layoutParams2.gravity == -1) {
            layoutParams2.gravity = 17;
        }
        this.customCenterView = view;
        this.titleAreaLayout.setVisibility(8);
        this.centerContainer.addView(view, layoutParams2);
        requestLayout();
    }

    public void setGlassCrossWindow(boolean crossWindow) {
        if (this.glassCrossWindow == crossWindow) {
            return;
        }
        this.glassCrossWindow = crossWindow;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassCrossWindow(crossWindow);
        }
        ArrayList<LinearLayout> arrayList3 = this.groups;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (obj2 instanceof StepOSGlassLinearLayout) {
                arrayList4.add(obj2);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassLinearLayout) it2.next()).setGlassCrossWindow(crossWindow);
        }
    }

    public void setGlassEffect(y7.o effect) {
        kotlin.jvm.internal.p.i(effect, "effect");
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        this.usingDefaultGlass = false;
        if (!kotlin.jvm.internal.p.d(this.glassEffect, effect) || z10) {
            this.glassEffect = effect;
            ArrayList<ImageButton> arrayList = this.individualActions;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof StepOSGlassImageButton) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((StepOSGlassImageButton) it.next()).setGlassEffect(effect);
            }
            ArrayList<LinearLayout> arrayList3 = this.groups;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (obj2 instanceof StepOSGlassLinearLayout) {
                    arrayList4.add(obj2);
                }
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                ((StepOSGlassLinearLayout) it2.next()).setGlassEffect(effect);
            }
        }
    }

    public void setGlassEnabled(boolean enabled) {
        if (this.glassEnabled == enabled) {
            return;
        }
        this.glassEnabled = enabled;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassEnabled(enabled && this.individualActionGlassEnabled);
        }
        ArrayList<LinearLayout> arrayList3 = this.groups;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (obj2 instanceof StepOSGlassLinearLayout) {
                arrayList4.add(obj2);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            ((StepOSGlassLinearLayout) it2.next()).setGlassEnabled(enabled);
        }
        Iterator<T> it3 = this.individualActions.iterator();
        while (it3.hasNext()) {
            updateActionVisual((ImageButton) it3.next());
        }
        Iterator<T> it4 = this.groups.iterator();
        while (it4.hasNext()) {
            updateGroupVisual((LinearLayout) it4.next());
        }
    }

    public void setGroupBackground(Drawable background) {
        this.groupBackground = copy(background);
        this.groupBackgroundExplicit = background != null;
        Iterator<T> it = this.groups.iterator();
        while (it.hasNext()) {
            updateGroupVisual((LinearLayout) it.next());
        }
    }

    public void setGroupCornerRadius(float radius) {
        this.groupCornerRadius = Math.max(0.0f, radius);
        ArrayList<LinearLayout> arrayList = this.groups;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassLinearLayout) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassLinearLayout) it.next()).setGlassCornerRadius(this.groupCornerRadius);
        }
        Iterator<T> it2 = this.groups.iterator();
        while (it2.hasNext()) {
            updateGroupVisual((LinearLayout) it2.next());
        }
    }

    public void setGroupPadding(int padding) {
        this.groupPadding = Math.max(0, padding);
        for (LinearLayout linearLayout : this.groups) {
            int i10 = this.groupPadding;
            linearLayout.setPadding(i10, 0, i10, 0);
        }
        requestLayout();
    }

    public void setGroupSpacing(int spacing) {
        this.groupSpacing = Math.max(0, spacing);
        Iterator<T> it = this.groups.iterator();
        while (it.hasNext()) {
            updateGroupSpacing((LinearLayout) it.next());
        }
        requestLayout();
    }

    public void setIconSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException(("iconSize must be >= 1 but was " + size).toString());
        }
        this.iconSize = size;
        Iterator<T> it = this.individualActions.iterator();
        while (it.hasNext()) {
            updateButtonPadding((ImageButton) it.next());
        }
        Iterator<T> it2 = this.groupedActions.iterator();
        while (it2.hasNext()) {
            updateGroupedButtonLayout((ImageButton) it2.next());
        }
        requestLayout();
    }

    public void setIndividualActionGlassEnabled(boolean enabled) {
        if (this.individualActionGlassEnabled == enabled) {
            return;
        }
        this.individualActionGlassEnabled = enabled;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setGlassEnabled(this.glassEnabled && enabled);
        }
        Iterator<T> it2 = this.individualActions.iterator();
        while (it2.hasNext()) {
            updateActionVisual((ImageButton) it2.next());
        }
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        ArrayList<ImageButton> arrayList = this.individualActions;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof StepOSGlassImageButton) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((StepOSGlassImageButton) it.next()).setPressScaleEnabled(z10);
        }
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, z10);
    }

    public void setSidePadding(int padding) {
        int iMax = Math.max(0, padding);
        this.sidePadding = iMax;
        setPaddingRelative(iMax, this.topPadding, iMax, this.bottomPadding);
        requestLayout();
    }

    public void setSubtitle(CharSequence subtitle) {
        boolean z10 = subtitle == null || subtitle.length() == 0;
        this.subtitleView.setText(subtitle);
        this.subtitleView.setVisibility(!z10 ? 0 : 8);
        this.titleView.setMinimumHeight(!z10 ? dimension(R.dimen.stepos_titlebar_subtitle_title_row_height) : 0);
        if (!this.titleTextSizeExplicit) {
            this.titleView.setTextSize(0, !z10 ? this.subtitleTitleTextSizePx : this.baseTitleTextSizePx);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        this.titleView.setText(title);
        this.titleView.forceLayout();
        this.titleAreaLayout.forceLayout();
        this.centerContainer.forceLayout();
        requestLayout();
    }

    public void setTitleActionGap(int gap) {
        this.titleActionGap = Math.max(0, gap);
        requestLayout();
    }

    public void setTitleCentered(boolean centered) {
        setTitleGravity(centered ? 1 : 0);
    }

    public void setTitleGravity(int gravity) {
        if (gravity != 0 && gravity != 1) {
            throw new IllegalArgumentException(("Unsupported title gravity: " + gravity).toString());
        }
        if (this.titleGravity != gravity) {
            this.titleGravity = gravity;
            updateTitleGravity();
            requestLayout();
        }
    }

    public void setTitleMaxWidth(int maxWidth) {
        int iMax = Math.max(0, maxWidth);
        this.titleMaxWidth = iMax;
        TextView textView = this.titleView;
        if (iMax <= 0) {
            iMax = Integer.MAX_VALUE;
        }
        textView.setMaxWidth(iMax);
        requestLayout();
    }

    public void setTitleTextAppearance(int resId) {
        this.titleView.setTextAppearance(getContext(), resId);
    }

    public void setTitleTextColor(int color) {
        this.titleTextColor = color;
        this.titleView.setTextColor(color);
    }

    public void setTitleTextSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("titleTextSize must be >= 0 but was " + i10).toString());
        }
        if (this.titleTextSizeValue == i10) {
            return;
        }
        this.titleTextSizeValue = i10;
        this.titleTextSizeExplicit = i10 > 0;
        applyTitleTextSize();
        requestLayout();
    }

    public void setTitleTextSizeRes(int resId) {
        setTitleTextSize(getResources().getDimensionPixelSize(resId));
    }

    public void setTopPadding(int padding) {
        int iMax = Math.max(0, padding);
        this.topPadding = iMax;
        int i10 = this.sidePadding;
        setPaddingRelative(i10, iMax, i10, this.bottomPadding);
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public ImageButton addEndAction(int iconResId, CharSequence description, View.OnClickListener listener) {
        return addAction(1, iconResId, description, listener);
    }

    public ImageButton addStartAction(int iconResId, CharSequence description, View.OnClickListener listener) {
        return addAction(0, iconResId, description, listener);
    }

    public /* synthetic */ StepOSTitleBar(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.steposTitleBarStyle : i10);
    }

    public ImageButton addAction(int side, int iconResId, CharSequence description, View.OnClickListener listener) {
        return addAction(side, iconResId == 0 ? null : s0.h.e(getResources(), iconResId, getContext().getTheme()), description, listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context, AttributeSet attributeSet, int i10) {
        int iResolveColor;
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.individualActions = new ArrayList<>();
        this.groupedActions = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.actionsEnabled = true;
        this.glassEnabled = true;
        this.glassEffect = y7.o.INSTANCE.i();
        this.glassCustomizer = defaultGlassCustomizer();
        this.usingDefaultGlass = true;
        this.individualActionGlassEnabled = true;
        this.pressScaleEnabledValue = true;
        this.backdropBlurEnabled = true;
        this.backdropGlassDelegate = new GlassDelegate(this);
        this.backdropBlurRefreshRunnable = new Runnable() { // from class: com.stepos.widget.toolbar.r
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                StepOSTitleBar.backdropBlurRefreshRunnable$lambda$0(this.f31418a);
            }
        };
        setClipChildren(false);
        setClipToPadding(false);
        int iDimension = dimension(R.dimen.stepos_titlebar_padding_horizontal);
        int iDimension2 = dimension(R.dimen.stepos_titlebar_padding_top);
        int iDimension3 = dimension(R.dimen.stepos_titlebar_padding_bottom);
        int iDimension4 = dimension(R.dimen.stepos_titlebar_action_size);
        int iDimension5 = dimension(R.dimen.stepos_titlebar_action_icon_size);
        int iDimension6 = dimension(R.dimen.stepos_titlebar_action_spacing);
        int iDimension7 = dimension(R.dimen.stepos_titlebar_action_group_spacing);
        int iDimension8 = dimension(R.dimen.stepos_titlebar_title_action_gap);
        int iDimension9 = dimension(R.dimen.stepos_titlebar_action_group_padding_horizontal);
        int iDimension10 = dimension(R.dimen.stepos_titlebar_title_max_width);
        int iDimension11 = dimension(R.dimen.stepos_titlebar_collapsed_height);
        float fDimension = dimension(R.dimen.stepos_titlebar_action_corner_radius);
        float fDimension2 = dimension(R.dimen.stepos_titlebar_action_group_corner_radius);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSTitleBar, i10, 0);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.titleGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSTitleBar_steposTitleGravity, 1);
        this.sidePadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposSidePadding, iDimension);
        this.topPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposTitleBarTopPadding, iDimension2);
        this.bottomPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposBottomPadding, iDimension3);
        this.actionSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposActionSize, iDimension4);
        this.iconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposIconSize, iDimension5);
        this.actionSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposActionSpacing, iDimension6);
        this.groupSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposGroupSpacing, iDimension7);
        this.titleActionGap = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposTitleActionGap, iDimension8);
        this.groupPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposGroupPadding, iDimension9);
        this.titleMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposTitleMaxWidth, iDimension10);
        this.minHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTitleBar_steposMinHeight, iDimension11);
        this.actionCornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSTitleBar_steposActionCornerRadius, fDimension);
        this.groupCornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSTitleBar_steposGroupCornerRadius, fDimension2);
        this.glassEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTitleBar_steposGlassEnabled, true);
        y7.o oVar = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSTitleBar_steposGlassEffect);
        if (oVar != null) {
            this.glassEffect = oVar;
            this.glassCustomizer = null;
        }
        this.glassCrossWindow = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTitleBar_steposGlassCrossWindow, false);
        this.individualActionGlassEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTitleBar_steposIndividualActionGlassEnabled, true);
        int i11 = R.styleable.StepOSTitleBar_steposActionBackground;
        this.actionBackgroundExplicit = typedArrayObtainStyledAttributes.hasValue(i11);
        int i12 = R.styleable.StepOSTitleBar_steposGroupBackground;
        this.groupBackgroundExplicit = typedArrayObtainStyledAttributes.hasValue(i12);
        this.backdropBlurEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTitleBar_steposBackdropBlurEnabled, true);
        int i13 = R.styleable.StepOSTitleBar_steposBackdropScrimColor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.backdropScrimColorOverride = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i13, 0));
        }
        int i14 = R.styleable.StepOSTitleBar_steposBackdropGradientStartColor;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.backdropGradientStartColorOverride = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i14, 0));
        }
        int i15 = R.styleable.StepOSTitleBar_steposBackdropGradientMiddleColor;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.backdropGradientMiddleColorOverride = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i15, 0));
        }
        int i16 = R.styleable.StepOSTitleBar_steposBackdropGradientEndColor;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            this.backdropGradientEndColorOverride = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i16, 0));
        }
        CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSTitleBar_steposTitle);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(R.styleable.StepOSTitleBar_steposSubtitle);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSTitleBar_steposTitleTextColor);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTitleBar_steposTitleBarTextAppearance, 0);
        int i17 = R.styleable.StepOSTitleBar_steposTitleBarTextSize;
        int dimensionPixelSize = typedArrayObtainStyledAttributes.hasValue(i17) ? typedArrayObtainStyledAttributes.getDimensionPixelSize(i17, 0) : 0;
        this.titleTextSizeExplicit = dimensionPixelSize > 0;
        this.actionBackground = drawableOrColor(typedArrayObtainStyledAttributes, i11);
        this.groupBackground = drawableOrColor(typedArrayObtainStyledAttributes, i12);
        this.pressScaleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTitleBar_steposPressScaleEnabled, true);
        typedArrayObtainStyledAttributes.recycle();
        if (colorStateList != null) {
            iResolveColor = colorStateList.getDefaultColor();
        } else {
            iResolveColor = resolveColor(android.R.attr.textColorPrimary, -16777216);
        }
        this.titleTextColor = iResolveColor;
        int i18 = this.sidePadding;
        setPaddingRelative(i18, this.topPadding, i18, this.bottomPadding);
        setMinimumHeight(this.minHeight);
        if (getBackground() == null) {
            setBackground(new ColorDrawable(getResources().getColor(R.color.stepos_titlebar_background)));
        }
        this.backdropFallbackBg = super.getBackground();
        LinearLayout linearLayoutCreateActionContainer = createActionContainer(R.id.stepos_titlebar_start_actions);
        this.startActions = linearLayoutCreateActionContainer;
        LinearLayout linearLayoutCreateActionContainer2 = createActionContainer(R.id.stepos_titlebar_end_actions);
        this.endActions = linearLayoutCreateActionContainer2;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R.id.stepos_titlebar_center_container);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        this.centerContainer = frameLayout;
        TextView textView = new TextView(context);
        textView.setId(R.id.stepos_titlebar_title);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(2, 18.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        if (resourceId != 0) {
            textView.setTextAppearance(context, resourceId);
        }
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        } else if (resourceId == 0) {
            textView.setTextColor(this.titleTextColor);
        }
        int i19 = this.titleMaxWidth;
        if (i19 > 0) {
            textView.setMaxWidth(i19);
        }
        textView.setText(text);
        this.titleView = textView;
        this.titleTextColor = textView.getCurrentTextColor();
        this.baseTitleTextSizePx = textView.getTextSize();
        if (this.titleTextSizeExplicit) {
            this.titleTextSizeValue = dimensionPixelSize;
            applyTitleTextSize();
        }
        this.subtitleTitleTextSizePx = getResources().getDimension(R.dimen.stepos_titlebar_title_text_size_expanded);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.stepos_titlebar_subtitle);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setIncludeFontPadding(false);
        textView2.setMinimumHeight(dimension(R.dimen.stepos_titlebar_subtitle_row_height));
        textView2.setTextAppearance(context, R.style.StepOSTextAppearance_TitleBar_Subtitle);
        textView2.setVisibility(8);
        this.subtitleView = textView2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        this.titleAreaLayout = linearLayout;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        updateTitleGravity();
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 16));
        addView(frameLayout, new FrameLayout.LayoutParams(-2, -2));
        addView(linearLayoutCreateActionContainer, new FrameLayout.LayoutParams(-2, -2));
        addView(linearLayoutCreateActionContainer2, new FrameLayout.LayoutParams(-2, -2));
        this.backdropConstructed = true;
        if (text2 == null || text2.length() == 0) {
            return;
        }
        setSubtitle(text2);
    }

    public void setTitle(int titleResId) {
        this.titleView.setText(titleResId);
        this.titleView.forceLayout();
        this.titleAreaLayout.forceLayout();
        this.centerContainer.forceLayout();
        requestLayout();
    }

    public ImageButton addActionToGroup(ViewGroup group, int iconResId, CharSequence description, View.OnClickListener listener) {
        return addActionToGroup(group, iconResId == 0 ? null : s0.h.e(getResources(), iconResId, getContext().getTheme()), description, listener);
    }
}
