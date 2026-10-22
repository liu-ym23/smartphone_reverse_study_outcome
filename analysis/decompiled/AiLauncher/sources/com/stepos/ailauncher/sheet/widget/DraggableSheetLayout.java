package com.stepos.ailauncher.sheet.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1331t;
import androidx.core.view.InterfaceC1332u;
import androidx.core.view.InterfaceC1333v;
import androidx.core.view.InterfaceC1336y;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.C3437e;
import com.stepos.ailauncher.sheet.HandleBounds;
import com.stepos.ailauncher.sheet.InterfaceC3456j;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.RubberBandConfig;
import com.stepos.ailauncher.sheet.RubberBandState;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.stepos.ailauncher.sheet.SheetScaleMotion;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.sheet.X;
import com.stepos.ailauncher.sheet.Z;
import com.stepos.ailauncher.sheet.c0;
import com.stepos.ailauncher.sheet.h0;
import com.stepos.ailauncher.sheet.i0;
import com.stepos.ailauncher.sheet.internal.B;
import com.stepos.ailauncher.sheet.internal.C;
import com.stepos.ailauncher.sheet.internal.C3447f;
import com.stepos.ailauncher.sheet.internal.F;
import com.stepos.ailauncher.sheet.internal.L;
import com.stepos.ailauncher.sheet.internal.p;
import com.stepos.ailauncher.sheet.internal.z;
import com.stepos.ailauncher.sheet.v0;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 Ù\u00032\u00020\u00012\u00020\u0002:\u0006Ú\u0003Û\u0003Ü\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\rJ\u001f\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010'J)\u0010*\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010'J\u0017\u0010/\u001a\u00020%2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020%2\u0006\u0010.\u001a\u00020-2\u0006\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u00010(2\u0006\u00104\u001a\u00020(H\u0002¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020%2\u0006\u0010)\u001a\u00020(2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u0017J\u0017\u0010;\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0002¢\u0006\u0004\b;\u0010\u0017J\u0017\u0010<\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010\u0017J\u000f\u0010=\u001a\u00020%H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000eH\u0002¢\u0006\u0004\b?\u0010\u0010J\u0017\u0010@\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0002¢\u0006\u0004\b@\u0010\u0017J\u000f\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u000bH\u0002¢\u0006\u0004\bD\u0010\rJ\u000f\u0010E\u001a\u00020\u000bH\u0002¢\u0006\u0004\bE\u0010\rJ\u000f\u0010F\u001a\u00020\u000bH\u0002¢\u0006\u0004\bF\u0010\rJ\u000f\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010\rJ\u0017\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020(H\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020(H\u0002¢\u0006\u0004\bK\u0010JJ\u0017\u0010M\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000eH\u0002¢\u0006\u0004\bM\u0010\u0017J\u0017\u0010O\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u000eH\u0002¢\u0006\u0004\bO\u0010\u0017J\u000f\u0010P\u001a\u00020%H\u0002¢\u0006\u0004\bP\u0010>J\u0017\u0010Q\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020(H\u0002¢\u0006\u0004\bQ\u0010JJ\u001b\u0010T\u001a\u0004\u0018\u00010S2\b\b\u0002\u0010R\u001a\u00020%H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u000bH\u0002¢\u0006\u0004\bV\u0010\rJ\u000f\u0010W\u001a\u00020\u000bH\u0002¢\u0006\u0004\bW\u0010\rJ!\u0010Z\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000e2\b\b\u0002\u0010Y\u001a\u00020\u000eH\u0002¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\u000b2\b\b\u0002\u0010\\\u001a\u00020%H\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b_\u0010JJ\u000f\u0010`\u001a\u00020\u000bH\u0002¢\u0006\u0004\b`\u0010\rJ\u0017\u0010b\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u000eH\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020%H\u0002¢\u0006\u0004\bd\u0010>J\u0017\u0010f\u001a\u00020%2\u0006\u0010e\u001a\u00020%H\u0002¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020%H\u0002¢\u0006\u0004\bh\u0010>J\u000f\u0010i\u001a\u00020%H\u0002¢\u0006\u0004\bi\u0010>J\u000f\u0010j\u001a\u00020%H\u0002¢\u0006\u0004\bj\u0010>J\u000f\u0010k\u001a\u00020%H\u0002¢\u0006\u0004\bk\u0010>J\u000f\u0010l\u001a\u00020\u000eH\u0002¢\u0006\u0004\bl\u0010\u0010J\u0017\u0010n\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000eH\u0002¢\u0006\u0004\bn\u0010cJ\u001f\u0010p\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020%2\u0006\u0010e\u001a\u00020%H\u0002¢\u0006\u0004\bp\u0010qJO\u0010x\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000e2\b\b\u0002\u0010s\u001a\u00020\u000e2\b\b\u0002\u0010t\u001a\u00020\u000e2\u0010\b\u0002\u0010v\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010uH\u0002¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\u000bH\u0002¢\u0006\u0004\bz\u0010\rJ\u0015\u0010{\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b{\u0010!J\r\u0010|\u001a\u00020\u000b¢\u0006\u0004\b|\u0010\rJL\u0010\u0084\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000e2\u0006\u0010~\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u000e2\u0007\u0010\u0080\u0001\u001a\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020\u000e¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J(\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000e2\u0006\u0010~\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u000e¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0018\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020\u000e¢\u0006\u0005\b\u0089\u0001\u0010cJ\u0012\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u000f\u0010\u008c\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u008c\u0001\u0010\rJ\u0018\u0010\u008e\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020%¢\u0006\u0005\b\u008e\u0001\u0010^J3\u0010\u008f\u0001\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0007\u0010\u008d\u0001\u001a\u00020%2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\"\u0010\u0091\u0001\u001a\u00020\u000b2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J?\u0010\u0094\u0001\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u2\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J2\u0010\u0096\u0001\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J;\u0010\u0098\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001Jc\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000e2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010\u009b\u0001\u001a\u00020\u000e2\u0007\u0010\u009c\u0001\u001a\u00020\u000e2\u0007\u0010\u009d\u0001\u001a\u00020\u000e2\u0007\u0010\u009e\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u009f\u0001\u001a\u00020%2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001d\u0010¤\u0001\u001a\u00030¢\u00012\n\b\u0002\u0010£\u0001\u001a\u00030¢\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0011\u0010§\u0001\u001a\u00030¦\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001J¦\u0001\u0010¯\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000e2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010\u009b\u0001\u001a\u00020\u000e2\u0007\u0010\u009c\u0001\u001a\u00020\u000e2\u0007\u0010\u009d\u0001\u001a\u00020\u000e2\u0007\u0010\u009e\u0001\u001a\u00020\u000e2\t\b\u0002\u0010©\u0001\u001a\u00020\u000e2\t\b\u0002\u0010ª\u0001\u001a\u00020\u000e2\t\b\u0002\u0010«\u0001\u001a\u00020%2\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0011\b\u0002\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u009b\u0001\u0010±\u0001\u001a\u00020\u000b2\u0007\u0010\u009a\u0001\u001a\u00020\u000e2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010\u009b\u0001\u001a\u00020\u000e2\u0007\u0010\u009c\u0001\u001a\u00020\u000e2\u0007\u0010\u009d\u0001\u001a\u00020\u000e2\u0007\u0010\u009e\u0001\u001a\u00020\u000e2\t\b\u0002\u0010©\u0001\u001a\u00020\u000e2\t\b\u0002\u0010ª\u0001\u001a\u00020\u000e2\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0011\b\u0002\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b±\u0001\u0010²\u0001JZ\u0010´\u0001\u001a\u00020\u000b2\t\b\u0002\u0010«\u0001\u001a\u00020%2\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u2\u0011\b\u0002\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u000f\u0010¶\u0001\u001a\u00020\u000b¢\u0006\u0005\b¶\u0001\u0010\rJ\u001a\u0010¸\u0001\u001a\u00020\u000b2\t\b\u0002\u0010·\u0001\u001a\u00020%¢\u0006\u0005\b¸\u0001\u0010^J\u000f\u0010¹\u0001\u001a\u00020\u000b¢\u0006\u0005\b¹\u0001\u0010\rJ\u000f\u0010º\u0001\u001a\u00020\u000b¢\u0006\u0005\bº\u0001\u0010\rJ?\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00012\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b¼\u0001\u0010½\u0001JY\u0010¾\u0001\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000e2\u0006\u0010t\u001a\u00020\u000e2\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000e2\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\b¾\u0001\u0010¿\u0001J?\u0010À\u0001\u001a\u0005\u0018\u00010»\u00012\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\bÀ\u0001\u0010½\u0001JH\u0010Â\u0001\u001a\u0005\u0018\u00010»\u00012\u0007\u0010Á\u0001\u001a\u00020\u000e2\u0018\b\u0002\u0010\u00ad\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010¬\u00012\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0019\u0010Ä\u0001\u001a\u00020%2\u0006\u0010.\u001a\u00020-H\u0017¢\u0006\u0005\bÄ\u0001\u00100J\u001a\u0010Æ\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020-H\u0017¢\u0006\u0005\bÆ\u0001\u00100J5\u0010Ê\u0001\u001a\u00020%2\u0007\u0010Ç\u0001\u001a\u00020(2\u0006\u00104\u001a\u00020(2\u0007\u0010È\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J5\u0010Ì\u0001\u001a\u00020\u000b2\u0007\u0010Ç\u0001\u001a\u00020(2\u0006\u00104\u001a\u00020(2\u0007\u0010È\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J>\u0010Ñ\u0001\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(2\u0007\u0010Î\u0001\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\u0010Ð\u0001\u001a\u00030Ï\u00012\u0007\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001JQ\u0010×\u0001\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(2\u0007\u0010Ó\u0001\u001a\u00020\u00072\u0007\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020\u00072\u0007\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u00072\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0016¢\u0006\u0006\b×\u0001\u0010Ø\u0001JG\u0010×\u0001\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(2\u0007\u0010Ó\u0001\u001a\u00020\u00072\u0007\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020\u00072\u0007\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\b×\u0001\u0010Ù\u0001J\u000f\u0010Ú\u0001\u001a\u00020\u000b¢\u0006\u0005\bÚ\u0001\u0010\rJ+\u0010Ü\u0001\u001a\u00020%2\u0006\u00104\u001a\u00020(2\u0007\u0010Û\u0001\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020\u000eH\u0016¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J#\u0010Þ\u0001\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(2\u0007\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J6\u0010ä\u0001\u001a\u00020\u000b2\u0007\u0010à\u0001\u001a\u00020\u00072\u0007\u0010á\u0001\u001a\u00020\u00072\u0007\u0010â\u0001\u001a\u00020\u00072\u0007\u0010ã\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0006\bä\u0001\u0010å\u0001J#\u0010ç\u0001\u001a\u00020\u000b2\u0007\u0010æ\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014¢\u0006\u0006\bç\u0001\u0010è\u0001J?\u0010î\u0001\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020%2\u0007\u0010ê\u0001\u001a\u00020\u00072\u0007\u0010ë\u0001\u001a\u00020\u00072\u0007\u0010ì\u0001\u001a\u00020\u00072\u0007\u0010í\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0006\bî\u0001\u0010ï\u0001J\u0011\u0010ð\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\bð\u0001\u0010\rJ\u0011\u0010ñ\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\bñ\u0001\u0010\rR,\u0010ó\u0001\u001a\u0005\u0018\u00010ò\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R&\u0010ù\u0001\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bù\u0001\u0010<\u001a\u0005\bú\u0001\u0010>\"\u0005\bû\u0001\u0010^R*\u0010ý\u0001\u001a\u00030ü\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bý\u0001\u0010þ\u0001\u001a\u0006\bÿ\u0001\u0010\u0080\u0002\"\u0006\b\u0081\u0002\u0010\u0082\u0002R*\u0010\u0083\u0002\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0083\u0002\u0010\u0084\u0002\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0005\b\u0087\u0002\u0010JR*\u0010\u0088\u0002\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0088\u0002\u0010\u0084\u0002\u001a\u0006\b\u0089\u0002\u0010\u0086\u0002\"\u0005\b\u008a\u0002\u0010JR\u0018\u0010\u008b\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0002\u0010<R5\u0010\u008d\u0002\u001a\u0004\u0018\u00010(2\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010(8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u008d\u0002\u0010\u0084\u0002\u001a\u0006\b\u008e\u0002\u0010\u0086\u0002\"\u0005\b\u008f\u0002\u0010JR/\u0010\u0090\u0002\u001a\u00020%2\u0007\u0010\u008c\u0002\u001a\u00020%8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0002\u0010<\u001a\u0005\b\u0091\u0002\u0010>\"\u0005\b\u0092\u0002\u0010^R&\u0010\u0093\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0093\u0002\u0010<\u001a\u0005\b\u0094\u0002\u0010>\"\u0005\b\u0095\u0002\u0010^R&\u0010\u0096\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0002\u0010<\u001a\u0005\b\u0097\u0002\u0010>\"\u0005\b\u0098\u0002\u0010^R\u0018\u0010\u0099\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0002\u0010<R0\u0010\u009a\u0002\u001a\u00020\u000e2\u0007\u0010\u008c\u0002\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0005\b\u009c\u0002\u0010\u0010\"\u0005\b\u009d\u0002\u0010cR'\u0010\u009e\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009e\u0002\u0010\u009b\u0002\u001a\u0005\b\u009f\u0002\u0010\u0010\"\u0005\b \u0002\u0010cR\u0019\u0010¡\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010\u009b\u0002R4\u0010£\u0002\u001a\u00030¢\u00022\b\u0010\u008c\u0002\u001a\u00030¢\u00028\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R&\u0010©\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0002\u0010<\u001a\u0005\bª\u0002\u0010>\"\u0005\b«\u0002\u0010^R\u001b\u0010¬\u0002\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010\u00ad\u0002R'\u0010®\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b®\u0002\u0010\u009b\u0002\u001a\u0005\b¯\u0002\u0010\u0010\"\u0005\b°\u0002\u0010cR'\u0010±\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b±\u0002\u0010\u009b\u0002\u001a\u0005\b²\u0002\u0010\u0010\"\u0005\b³\u0002\u0010cR'\u0010´\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b´\u0002\u0010\u009b\u0002\u001a\u0005\bµ\u0002\u0010\u0010\"\u0005\b¶\u0002\u0010cR5\u0010·\u0002\u001a\u0004\u0018\u00010(2\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010(8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b·\u0002\u0010\u0084\u0002\u001a\u0006\b¸\u0002\u0010\u0086\u0002\"\u0005\b¹\u0002\u0010JR\u0018\u0010º\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0002\u0010<R\u0018\u0010»\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b»\u0002\u0010IR'\u0010¼\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¼\u0002\u0010\u009b\u0002\u001a\u0005\b½\u0002\u0010\u0010\"\u0005\b¾\u0002\u0010cR&\u0010¿\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¿\u0002\u0010<\u001a\u0005\bÀ\u0002\u0010>\"\u0005\bÁ\u0002\u0010^R1\u0010Â\u0002\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0002\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010\u0092\u0001R'\u0010Ç\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bÇ\u0002\u0010I\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0005\bÊ\u0002\u0010\u001aR'\u0010Ë\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bË\u0002\u0010I\u001a\u0006\bÌ\u0002\u0010É\u0002\"\u0005\bÍ\u0002\u0010\u001aR:\u0010Î\u0002\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010¬\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÎ\u0002\u0010Ï\u0002\u001a\u0006\bÐ\u0002\u0010Ñ\u0002\"\u0006\bÒ\u0002\u0010Ó\u0002R3\u0010Ô\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0002\u0010Ã\u0002\u001a\u0006\bÕ\u0002\u0010Å\u0002\"\u0006\bÖ\u0002\u0010\u0092\u0001R\u0018\u0010×\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b×\u0002\u0010<R1\u0010Ø\u0002\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0002\u0010Ã\u0002\u001a\u0006\bÙ\u0002\u0010Å\u0002\"\u0006\bÚ\u0002\u0010\u0092\u0001R&\u0010Û\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÛ\u0002\u0010<\u001a\u0005\bÜ\u0002\u0010>\"\u0005\bÝ\u0002\u0010^R'\u0010Þ\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÞ\u0002\u0010\u009b\u0002\u001a\u0005\bß\u0002\u0010\u0010\"\u0005\bà\u0002\u0010cR'\u0010á\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bá\u0002\u0010\u009b\u0002\u001a\u0005\bâ\u0002\u0010\u0010\"\u0005\bã\u0002\u0010cR&\u0010ä\u0002\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bä\u0002\u0010<\u001a\u0005\bå\u0002\u0010>\"\u0005\bæ\u0002\u0010^R\u0016\u0010ç\u0002\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bç\u0002\u0010IR\u0017\u0010è\u0002\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0002\u0010\u009b\u0002R\u0018\u0010é\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bé\u0002\u0010<R\u0018\u0010ê\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bê\u0002\u0010<R\u0019\u0010ë\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0002\u0010\u009b\u0002R\u0019\u0010ì\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0002\u0010\u009b\u0002R\u0018\u0010í\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bí\u0002\u0010IR\u0019\u0010î\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0002\u0010\u009b\u0002R\u0019\u0010ï\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0002\u0010\u009b\u0002R\u0019\u0010ð\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0002\u0010\u009b\u0002R\u0018\u0010ñ\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bñ\u0002\u0010<R\u0018\u0010ò\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bò\u0002\u0010<R\u0018\u0010ó\u0002\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bó\u0002\u0010ô\u0002R\u0019\u0010õ\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0002\u0010\u009b\u0002R\u0019\u0010ö\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0002\u0010\u009b\u0002R\u0019\u0010÷\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0002\u0010\u009b\u0002R\u001b\u0010ø\u0002\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0002\u0010ù\u0002R/\u0010ú\u0002\u001a\u00020%2\u0007\u0010\u008c\u0002\u001a\u00020%8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bú\u0002\u0010<\u001a\u0005\bû\u0002\u0010>\"\u0005\bü\u0002\u0010^R\u0019\u0010ý\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0002\u0010\u009b\u0002R\u0019\u0010þ\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0002\u0010\u009b\u0002R\u0018\u0010\u0080\u0003\u001a\u00030ÿ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0003\u0010\u0081\u0003R\u0018\u0010\u0083\u0003\u001a\u00030\u0082\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0003\u0010\u0084\u0003R/\u0010\u0085\u0003\u001a\u00020%2\u0007\u0010\u008c\u0002\u001a\u00020%8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0003\u0010<\u001a\u0005\b\u0086\u0003\u0010>\"\u0005\b\u0087\u0003\u0010^R/\u0010\u0088\u0003\u001a\u00020%2\u0007\u0010\u008c\u0002\u001a\u00020%8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0003\u0010<\u001a\u0005\b\u0089\u0003\u0010>\"\u0005\b\u008a\u0003\u0010^R\u001c\u0010\u008c\u0003\u001a\u0005\u0018\u00010\u008b\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010\u008d\u0003R\u001c\u0010\u008f\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010\u0090\u0003RD\u0010\u0094\u0003\u001a/\u0012\u000f\u0012\r \u0092\u0003*\u0005\u0018\u00010\u008e\u00030\u008e\u0003 \u0092\u0003*\u0016\u0012\u000f\u0012\r \u0092\u0003*\u0005\u0018\u00010\u008e\u00030\u008e\u0003\u0018\u00010\u0093\u00030\u0091\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0003\u0010\u0095\u0003R\u001c\u0010\u0096\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0003\u0010\u0090\u0003R\u001c\u0010\u0097\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0090\u0003R\u001c\u0010\u0098\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0003\u0010\u0090\u0003R\u001c\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0003\u0010\u0090\u0003R\u001c\u0010\u009b\u0003\u001a\u0005\u0018\u00010\u009a\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0003\u0010\u009c\u0003R\u001e\u0010\u009e\u0003\u001a\t\u0012\u0004\u0012\u00020%0\u009d\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u009f\u0003R#\u0010¡\u0003\u001a\t\u0012\u0004\u0012\u00020%0 \u00038\u0006¢\u0006\u0010\n\u0006\b¡\u0003\u0010¢\u0003\u001a\u0006\b£\u0003\u0010¤\u0003R\u001c\u0010¦\u0003\u001a\u0005\u0018\u00010¥\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0003\u0010§\u0003R\u001c\u0010©\u0003\u001a\u0005\u0018\u00010¨\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0003\u0010ª\u0003R\u0019\u0010«\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0003\u0010\u009b\u0002R\u0019\u0010¬\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0003\u0010\u009b\u0002R\u0018\u0010\u00ad\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0003\u0010<R\u001c\u0010¯\u0003\u001a\u0005\u0018\u00010®\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0003\u0010°\u0003R\u0019\u0010±\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0003\u0010\u009b\u0002R\u0018\u0010²\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0003\u0010<R\u0018\u0010³\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b³\u0003\u0010<R\u0018\u0010´\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0003\u0010IR\u0018\u0010µ\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bµ\u0003\u0010IR\u0019\u0010¶\u0003\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0003\u0010\u00ad\u0002R\u0018\u0010¸\u0003\u001a\u00030·\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0003\u0010¹\u0003R\u0018\u0010º\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0003\u0010<R\u0018\u0010»\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b»\u0003\u0010<R\u0018\u0010¼\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0003\u0010<R\u0018\u0010¾\u0003\u001a\u00030½\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0003\u0010¿\u0003R\u0019\u0010À\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0003\u0010\u009b\u0002R\u0018\u0010Á\u0003\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0003\u0010ô\u0002R!\u0010Â\u0003\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0003\u0010Ã\u0002R\u0018\u0010Ã\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÃ\u0003\u0010<R\u0019\u0010Å\u0003\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÄ\u0003\u0010\u0086\u0002R\u0017\u0010È\u0003\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÆ\u0003\u0010Ç\u0003R\u0013\u0010Ê\u0003\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bÉ\u0003\u0010>R\u0014\u0010Ì\u0003\u001a\u00020\u001e8F¢\u0006\b\u001a\u0006\bË\u0003\u0010Ç\u0003R\u0013\u0010Î\u0003\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\bÍ\u0003\u0010>R\u0014\u0010Ð\u0003\u001a\u00020\u001e8F¢\u0006\b\u001a\u0006\bÏ\u0003\u0010Ç\u0003R\u0013\u0010Ò\u0003\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bÑ\u0003\u0010\u0010R\u0013\u0010Ô\u0003\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bÓ\u0003\u0010\u0010R\u0013\u0010Ö\u0003\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bÕ\u0003\u0010\u0010R\u0013\u0010Ø\u0003\u001a\u00020%8F¢\u0006\u0007\u001a\u0005\b×\u0003\u0010>¨\u0006Ý\u0003"}, d2 = {"Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/y;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "J", "()V", "", "j0", "()F", "l0", "A0", "p0", "m0", "ratioY", "z", "(F)F", "heightMeasureSpec", "l1", "(I)V", "F0", "offset", "D0", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "L1", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)F", "p1", "rawX", "rawY", "", "A1", "(FF)Z", "Landroid/view/View;", "view", "v0", "(FFLandroid/view/View;)Z", "q0", "Landroid/view/MotionEvent;", "ev", "s1", "(Landroid/view/MotionEvent;)Z", "direction", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/view/MotionEvent;I)Z", "target", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)Landroid/view/View;", "n0", "(Landroid/view/View;FFI)Z", "dy", "Y", "X", "Z", "w0", "()Z", "t1", "a0", "Lcom/stepos/ailauncher/sheet/W;", "i0", "()Lcom/stepos/ailauncher/sheet/W;", "k1", "Q", "o1", "L", "panel", "I", "(Landroid/view/View;)V", "R", "baseTop", "o0", "restingTop", "U", "C1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "nineSplit", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$b;", ExifInterface.LATITUDE_SOUTH, "(Z)Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$b;", "N", "q1", "x", "y", "u1", "(FF)V", "forceDescendants", "y0", "(Z)V", "g0", "C0", "progress", ExifInterface.LONGITUDE_WEST, "(F)V", "E0", "flingDown", "B1", "(Z)Z", "K1", "e0", "s0", "u0", "k0", "velocityY", "settleOrDismiss", "flingUp", "w1", "(ZZ)V", "targetY", "stiffness", "dampingRatio", "Lkotlin/Function0;", "onFirstRebound", "onEnd", "E1", "(FFFLp9/a;Lp9/a;)V", "m1", "J1", "d0", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "peekExtraY", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "transformDamping", "transformStiffness", "alphaDamping", "alphaStiffness", "B", "(FFFFFFF)V", "K", "(FFF)V", "offsetY", "setHomeGroupExitOffsetY", "h0", "()Ljava/lang/Float;", "n1", "animate", "D1", "x1", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;ZLp9/a;)V", "M0", "(Lp9/a;)V", "travelDistancePx", "L0", "(FFLp9/a;Ljava/lang/Float;)V", "Q0", "(FFLp9/a;)V", "S0", "(FFFLp9/a;)V", "collapsedScale", "offsetStiffness", "offsetDampingRatio", "scaleStiffness", "scaleDampingRatio", "floatingBottom", "T0", "(FFFFFFZLp9/a;)V", "Lcom/stepos/ailauncher/sheet/f0;", "base", "r1", "(Lcom/stepos/ailauncher/sheet/f0;)Lcom/stepos/ailauncher/sheet/f0;", "", "f0", "()J", "collapsedScaleY", "bottomWidthPinchDp", "scaleContent", "Lkotlin/Function1;", "onProgress", "onCollapsedToBar", SdCardDbCreator.FIELD_LASTLOC_ID, "(FFFFFFFFZLp9/l;Lp9/a;Lp9/a;)V", "X0", "(FFFFFFFFLp9/l;Lp9/a;Lp9/a;)V", "onCancelled", "G0", "(ZLp9/l;Lp9/a;Lp9/a;)V", "b0", "suppressEndCallback", "O", "M", "c0", "Landroid/animation/Animator;", "c1", "(Lp9/l;Lp9/a;)Landroid/animation/Animator;", "f1", "(FFLjava/lang/Float;Lp9/l;Lp9/a;)V", "i1", "panelCornerPx", "Z0", "(FLp9/l;Lp9/a;)Landroid/animation/Animator;", "onInterceptTouchEvent", "event", "onTouchEvent", "child", "axes", "type", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;II)Z", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;II)V", "dx", "", "consumed", "onNestedPreScroll", "(Landroid/view/View;II[II)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "(Landroid/view/View;IIIII[I)V", "(Landroid/view/View;IIIII)V", "B0", "velocityX", "onNestedPreFling", "(Landroid/view/View;FF)Z", "onStopNestedScroll", "(Landroid/view/View;I)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "widthMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "callback", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "getCallback", "()Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "setCallback", "(Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;)V", "dismissEnabled", "getDismissEnabled", "setDismissEnabled", "Lcom/stepos/ailauncher/sheet/j;", "handleBoundsProvider", "Lcom/stepos/ailauncher/sheet/j;", "getHandleBoundsProvider", "()Lcom/stepos/ailauncher/sheet/j;", "setHandleBoundsProvider", "(Lcom/stepos/ailauncher/sheet/j;)V", "dragHandleView", "Landroid/view/View;", "getDragHandleView", "()Landroid/view/View;", "setDragHandleView", "dragPriorityView", "getDragPriorityView", "setDragPriorityView", "exitMorphing", UxipConstants.f30680s, "contentAnchorView", "getContentAnchorView", "setContentAnchorView", "bottomAnchorEnabled", "getBottomAnchorEnabled", "setBottomAnchorEnabled", "freezeContentHeightOnFullDrag", "getFreezeContentHeightOnFullDrag", "setFreezeContentHeightOnFullDrag", "useFullDragThreshold", "getUseFullDragThreshold", "setUseFullDragThreshold", "fullDragHeightFrozen", "imeInsetPx", "F", "getImeInsetPx", "setImeInsetPx", "minPanelTopForImePx", "getMinPanelTopForImePx", "setMinPanelTopForImePx", "lastImeLift", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "getHeightMode", "()Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "setHeightMode", "(Lcom/stepos/ailauncher/sheet/SheetHeightMode;)V", "allowCollapseToHalf", "getAllowCollapseToHalf", "setAllowCollapseToHalf", "anchorTargetState", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "fullTopRatio", "getFullTopRatio", "setFullTopRatio", "halfTopRatio", "getHalfTopRatio", "setHalfTopRatio", "minifyTopRatio", "getMinifyTopRatio", "setMinifyTopRatio", "minifyContentView", "getMinifyContentView", "setMinifyContentView", "reanchoringMinify", "cachedMinifyIntrinsic", "immersiveTopRatio", "getImmersiveTopRatio", "setImmersiveTopRatio", "dragEnabled", "getDragEnabled", "setDragEnabled", "userDragGate", "Lp9/a;", "getUserDragGate", "()Lp9/a;", "setUserDragGate", "topDragStripHeightPx", "getTopDragStripHeightPx", "()I", "setTopDragStripHeightPx", "fullTopDragStripHeightPx", "getFullTopDragStripHeightPx", "setFullTopDragStripHeightPx", "halfExpandContentAtBottom", "Lp9/l;", "getHalfExpandContentAtBottom", "()Lp9/l;", "setHalfExpandContentAtBottom", "(Lp9/l;)V", "touchScrollableContentProvider", "getTouchScrollableContentProvider", "setTouchScrollableContentProvider", "dragGateBlocked", "floatingPanelTouchTransparentGate", "getFloatingPanelTouchTransparentGate", "setFloatingPanelTouchTransparentGate", "chromeTransparent", "getChromeTransparent", "setChromeTransparent", "fastDismissVelocityPx", "getFastDismissVelocityPx", "setFastDismissVelocityPx", "touchAxisLockRatio", "getTouchAxisLockRatio", "setTouchAxisLockRatio", "sealHorizontalGesture", "getSealHorizontalGesture", "setSealHorizontalGesture", "touchSlop", "minFlingVelocity", "dragging", "dismissFromDragPending", "fullDragRawPull", "rubberBandScaleX", "touchAxis", "downX", "downY", "lastY", "allowDragGesture", "dragPriorityGesture", "tmpLocation", "[I", "sheetOffset", "stackPeekExtraY", "homeGroupExitOffsetY", "sharedExitStartY", "Ljava/lang/Float;", "stackPeekSuppressed", "getStackPeekSuppressed", "setStackPeekSuppressed", "stackScale", "stackAlpha", "Lcom/stepos/ailauncher/sheet/Z;", "panelBackgroundAlpha", "Lcom/stepos/ailauncher/sheet/Z;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "stackBackgroundPreDraw", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "stackBackgroundColorAlphaEnabled", "getStackBackgroundColorAlphaEnabled", "setStackBackgroundColorAlphaEnabled", "stackBackgroundPreserveOpacity", "getStackBackgroundPreserveOpacity", "setStackBackgroundPreserveOpacity", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/VelocityTracker;", "Landroidx/dynamicanimation/animation/i;", "settleAnim", "Landroidx/dynamicanimation/animation/i;", "", "kotlin.jvm.PlatformType", "", "suppressedSettleEndAnimations", "Ljava/util/Set;", "stackScaleAnimX", "stackScaleAnimY", "stackPeekAnim", "stackAlphaAnim", "Lcom/stepos/ailauncher/sheet/internal/f$a;", "bloomAnim", "Lcom/stepos/ailauncher/sheet/internal/f$a;", "LXa/k;", "_scaleEnterRunning", "LXa/k;", "LXa/t;", "scaleEnterRunning", "LXa/t;", "getScaleEnterRunning", "()LXa/t;", "Lcom/stepos/ailauncher/sheet/internal/p$a;", "collapseClipAnim", "Lcom/stepos/ailauncher/sheet/internal/p$a;", "Lcom/stepos/ailauncher/sheet/internal/z$a;", "contentScaleExitAnim", "Lcom/stepos/ailauncher/sheet/internal/z$a;", "transitionScaleX", "transitionScaleY", "transitionScaleActive", "Lcom/stepos/ailauncher/sheet/internal/L;", "scaleEnterBottomClip", "Lcom/stepos/ailauncher/sheet/internal/L;", "transitionPivotYFraction", "transitionPinScreenBottom", "clipEnterOvershootExtend", "sheetOvershootBaseH", "sheetOvershootSavedLpH", "settleState", "Landroidx/core/view/z;", "nestedScrollingHelper", "Landroidx/core/view/z;", "nestedScrollInProgress", "nestedSheetDragged", "nestedContentScrolled", "Lcom/stepos/ailauncher/sheet/widget/b;", "contentOverscroll", "Lcom/stepos/ailauncher/sheet/widget/b;", "nestedFlingVelocityY", "nestedConsumedScratch", "clipEnterCancelCleanup", "morphFreeze", "getSheet", ChatTracker.CONTENT_SHEET, "getEffectiveSettleState", "()Lcom/stepos/ailauncher/sheet/SheetSettleState;", "effectiveSettleState", "r0", "isDismissFromDragPending", "getCurrentState", "currentState", "x0", "isSheetMotionRunning", "getStateForExit", "stateForExit", "getPanelTopPx", "panelTopPx", "getImmersiveFraction", "immersiveFraction", "getHalfFullFraction", "halfFullFraction", "t0", "isFullDragContentHeightFrozen", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DraggableSheetLayout extends FrameLayout implements InterfaceC1336y {
    private static final int AXIS_CONTENT = -3;
    private static final int AXIS_HORIZONTAL = -1;
    private static final int AXIS_NESTED = -2;
    private static final int AXIS_UNDECIDED = 0;
    private static final int AXIS_VERTICAL = 1;
    private static final float DEFAULT_SPRING_DAMPING = 0.88f;
    private static final float DEFAULT_SPRING_STIFFNESS = 400.0f;
    private static final float DISMISS_VISIBLE_HEIGHT_RATIO = 0.5f;
    private static final long EXIT_SLIDE_DURATION_MS = 280;
    private static final long EXIT_SLIDE_MIN_DURATION_MS = 140;
    private static final float FULL_DRAG_FOLLOW_FRACTION = 0.25f;
    private static final float FULL_DRAG_RUBBER_FRACTION = 0.38f;
    private static final float FULL_DRAG_SIZE_X_END_FRACTION = 0.96f;
    private final Xa.k<Boolean> _scaleEnterRunning;
    private boolean allowCollapseToHalf;
    private boolean allowDragGesture;
    private SheetSettleState anchorTargetState;
    private C3447f.a bloomAnim;
    private boolean bottomAnchorEnabled;
    private int cachedMinifyIntrinsic;
    private a callback;
    private boolean chromeTransparent;
    private InterfaceC5063a<Y8.t> clipEnterCancelCleanup;
    private boolean clipEnterOvershootExtend;
    private p.a collapseClipAnim;
    private View contentAnchorView;
    private final b contentOverscroll;
    private z.a contentScaleExitAnim;
    private boolean dismissEnabled;
    private boolean dismissFromDragPending;
    private float downX;
    private float downY;
    private boolean dragEnabled;
    private boolean dragGateBlocked;
    private View dragHandleView;
    private boolean dragPriorityGesture;
    private View dragPriorityView;
    private boolean dragging;
    private boolean exitMorphing;
    private float fastDismissVelocityPx;
    private InterfaceC5063a<Boolean> floatingPanelTouchTransparentGate;
    private boolean freezeContentHeightOnFullDrag;
    private boolean fullDragHeightFrozen;
    private float fullDragRawPull;
    private int fullTopDragStripHeightPx;
    private float fullTopRatio;
    private InterfaceC5074l<? super View, Boolean> halfExpandContentAtBottom;
    private float halfTopRatio;
    private InterfaceC3456j handleBoundsProvider;
    private SheetHeightMode heightMode;
    private float homeGroupExitOffsetY;
    private float imeInsetPx;
    private float immersiveTopRatio;
    private float lastImeLift;
    private float lastY;
    private final float minFlingVelocity;
    private float minPanelTopForImePx;
    private View minifyContentView;
    private float minifyTopRatio;
    private boolean morphFreeze;
    private final int[] nestedConsumedScratch;
    private boolean nestedContentScrolled;
    private float nestedFlingVelocityY;
    private boolean nestedScrollInProgress;
    private final C1337z nestedScrollingHelper;
    private boolean nestedSheetDragged;
    private final Z panelBackgroundAlpha;
    private boolean reanchoringMinify;
    private float rubberBandScaleX;
    private L scaleEnterBottomClip;
    private final Xa.t<Boolean> scaleEnterRunning;
    private boolean sealHorizontalGesture;
    private androidx.dynamicanimation.animation.i settleAnim;
    private SheetSettleState settleState;
    private Float sharedExitStartY;
    private float sheetOffset;
    private int sheetOvershootBaseH;
    private int sheetOvershootSavedLpH;
    private float stackAlpha;
    private androidx.dynamicanimation.animation.i stackAlphaAnim;
    private boolean stackBackgroundColorAlphaEnabled;
    private final ViewTreeObserver.OnPreDrawListener stackBackgroundPreDraw;
    private boolean stackBackgroundPreserveOpacity;
    private androidx.dynamicanimation.animation.i stackPeekAnim;
    private float stackPeekExtraY;
    private boolean stackPeekSuppressed;
    private float stackScale;
    private androidx.dynamicanimation.animation.i stackScaleAnimX;
    private androidx.dynamicanimation.animation.i stackScaleAnimY;
    private final Set<androidx.dynamicanimation.animation.i> suppressedSettleEndAnimations;
    private final int[] tmpLocation;
    private int topDragStripHeightPx;
    private int touchAxis;
    private float touchAxisLockRatio;
    private InterfaceC5063a<? extends View> touchScrollableContentProvider;
    private final int touchSlop;
    private boolean transitionPinScreenBottom;
    private float transitionPivotYFraction;
    private boolean transitionScaleActive;
    private float transitionScaleX;
    private float transitionScaleY;
    private boolean useFullDragThreshold;
    private InterfaceC5063a<Boolean> userDragGate;
    private VelocityTracker velocityTracker;
    private static final PathInterpolator EXIT_SLIDE_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 0.8f, 0.15f);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\b¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(F)V", "c", "()V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", Const.INTENT_KEY_UMID, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(float progress);

        void b(SheetSettleState state);

        void c();

        default void d() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$b;", "", "", "startHeight", "endHeight", "centerX", "centerY", "endOffsetY", "<init>", "(FFFFF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "e", "()F", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.widget.DraggableSheetLayout$b, reason: from toString */
    public static final /* data */ class CollapseClipGeometry {
        private final float centerX;
        private final float centerY;
        private final float endHeight;
        private final float endOffsetY;
        private final float startHeight;

        public CollapseClipGeometry(float f10, float f11, float f12, float f13, float f14) {
            this.startHeight = f10;
            this.endHeight = f11;
            this.centerX = f12;
            this.centerY = f13;
            this.endOffsetY = f14;
        }

        /* renamed from: a, reason: from getter */
        public final float getCenterX() {
            return this.centerX;
        }

        /* renamed from: b, reason: from getter */
        public final float getCenterY() {
            return this.centerY;
        }

        /* renamed from: c, reason: from getter */
        public final float getEndHeight() {
            return this.endHeight;
        }

        /* renamed from: d, reason: from getter */
        public final float getEndOffsetY() {
            return this.endOffsetY;
        }

        /* renamed from: e, reason: from getter */
        public final float getStartHeight() {
            return this.startHeight;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CollapseClipGeometry)) {
                return false;
            }
            CollapseClipGeometry collapseClipGeometry = (CollapseClipGeometry) other;
            return Float.compare(this.startHeight, collapseClipGeometry.startHeight) == 0 && Float.compare(this.endHeight, collapseClipGeometry.endHeight) == 0 && Float.compare(this.centerX, collapseClipGeometry.centerX) == 0 && Float.compare(this.centerY, collapseClipGeometry.centerY) == 0 && Float.compare(this.endOffsetY, collapseClipGeometry.endOffsetY) == 0;
        }

        public int hashCode() {
            return (((((((Float.hashCode(this.startHeight) * 31) + Float.hashCode(this.endHeight)) * 31) + Float.hashCode(this.centerX)) * 31) + Float.hashCode(this.centerY)) * 31) + Float.hashCode(this.endOffsetY);
        }

        public String toString() {
            return "CollapseClipGeometry(startHeight=" + this.startHeight + ", endHeight=" + this.endHeight + ", centerX=" + this.centerX + ", centerY=" + this.centerY + ", endOffsetY=" + this.endOffsetY + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetSettleState.MINIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SheetSettleState.IMMERSIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SheetSettleState.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SheetHeightMode.values().length];
            try {
                iArr2[SheetHeightMode.FULL_9.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SheetHeightMode.HALF_EXPANDABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SheetHeightMode.MINIFY_EXPANDABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/sheet/widget/DraggableSheetLayout$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ float $endY;
        final /* synthetic */ Ref$BooleanRef $ended;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onEnd;
        final /* synthetic */ InterfaceC5074l<Float, Y8.t> $onProgress;
        final /* synthetic */ DraggableSheetLayout this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Ref$BooleanRef ref$BooleanRef, DraggableSheetLayout draggableSheetLayout, float f10, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$ended = ref$BooleanRef;
            this.this$0 = draggableSheetLayout;
            this.$endY = f10;
            this.$onProgress = interfaceC5074l;
            this.$onEnd = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            DraggableSheetLayout.d1(this.$ended, this.this$0, this.$endY, this.$onProgress, this.$onEnd);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            DraggableSheetLayout.d1(this.$ended, this.this$0, this.$endY, this.$onProgress, this.$onEnd);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DraggableSheetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void C(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        draggableSheetLayout.stackScale = f10;
        draggableSheetLayout.L();
    }

    public static final void D(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        draggableSheetLayout.stackScale = f10;
        draggableSheetLayout.L();
    }

    public static final void E(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        draggableSheetLayout.stackPeekExtraY = f10;
        draggableSheetLayout.L();
    }

    public static final void F(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        draggableSheetLayout.stackPeekExtraY = f10;
        draggableSheetLayout.L();
    }

    public static /* synthetic */ void F1(DraggableSheetLayout draggableSheetLayout, float f10, float f11, float f12, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = DEFAULT_SPRING_STIFFNESS;
        }
        float f13 = f11;
        if ((i10 & 4) != 0) {
            f12 = DEFAULT_SPRING_DAMPING;
        }
        draggableSheetLayout.E1(f10, f13, f12, (i10 & 8) != 0 ? null : interfaceC5063a, (i10 & 16) != 0 ? null : interfaceC5063a2);
    }

    public static final void G(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        draggableSheetLayout.stackAlpha = C5685n.m(f10, 0.0f, 1.0f);
        draggableSheetLayout.L();
    }

    public static final void G1(DraggableSheetLayout draggableSheetLayout, C c10, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        draggableSheetLayout.sheetOffset = f10;
        draggableSheetLayout.L();
        draggableSheetLayout.C0();
        if (c10 == null || !c10.a(f10, f11) || interfaceC5063a == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void H(DraggableSheetLayout draggableSheetLayout, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        draggableSheetLayout.stackAlpha = C5685n.m(f10, 0.0f, 1.0f);
        draggableSheetLayout.L();
    }

    public static final Y8.t H0(DraggableSheetLayout draggableSheetLayout, boolean z10, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.dismissEnabled = z10;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void H1(DraggableSheetLayout draggableSheetLayout, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        Set<androidx.dynamicanimation.animation.i> suppressedSettleEndAnimations = draggableSheetLayout.suppressedSettleEndAnimations;
        kotlin.jvm.internal.p.h(suppressedSettleEndAnimations, "suppressedSettleEndAnimations");
        if (kotlin.jvm.internal.z.a(suppressedSettleEndAnimations).remove(eVar)) {
            if (draggableSheetLayout.settleAnim == eVar) {
                draggableSheetLayout.settleAnim = null;
                return;
            }
            return;
        }
        if (draggableSheetLayout.settleAnim == eVar) {
            draggableSheetLayout.settleAnim = null;
        }
        draggableSheetLayout.sheetOffset = f10;
        draggableSheetLayout.L();
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void I0(DraggableSheetLayout draggableSheetLayout, InterfaceC5063a interfaceC5063a, boolean z10, SheetSettleState sheetSettleState, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a2, boolean z11, InterfaceC5063a interfaceC5063a3) throws Resources.NotFoundException {
        if (draggableSheetLayout.clipEnterCancelCleanup != interfaceC5063a) {
            return;
        }
        if (draggableSheetLayout.isLaidOut() && draggableSheetLayout.getSheet() != null && draggableSheetLayout.getWidth() > 0 && draggableSheetLayout.getHeight() > 0) {
            draggableSheetLayout.clipEnterCancelCleanup = null;
            draggableSheetLayout.dismissEnabled = z10;
            draggableSheetLayout.G0(z11, interfaceC5074l, interfaceC5063a2, interfaceC5063a3);
            return;
        }
        draggableSheetLayout.anchorTargetState = null;
        draggableSheetLayout.clipEnterCancelCleanup = null;
        draggableSheetLayout.dismissEnabled = z10;
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
    }

    public static final boolean I1(DraggableSheetLayout draggableSheetLayout) {
        draggableSheetLayout.J();
        return true;
    }

    public static final Y8.t J0(DraggableSheetLayout draggableSheetLayout, View view) {
        draggableSheetLayout.A(view);
        draggableSheetLayout.I(view);
        return Y8.t.f7040a;
    }

    public static final Y8.t K0(DraggableSheetLayout draggableSheetLayout, View view, boolean z10, SheetSettleState sheetSettleState, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.collapseClipAnim = null;
        draggableSheetLayout.exitMorphing = false;
        draggableSheetLayout.clipEnterOvershootExtend = false;
        draggableSheetLayout.R(view);
        draggableSheetLayout.clipEnterCancelCleanup = null;
        draggableSheetLayout.dismissEnabled = z10;
        draggableSheetLayout.settleState = sheetSettleState;
        draggableSheetLayout.sheetOffset = draggableSheetLayout.L1(sheetSettleState);
        draggableSheetLayout.anchorTargetState = null;
        draggableSheetLayout.L();
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N0(DraggableSheetLayout draggableSheetLayout, float f10, float f11, InterfaceC5063a interfaceC5063a, Float f12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        if ((i10 & 8) != 0) {
            f12 = null;
        }
        draggableSheetLayout.L0(f10, f11, interfaceC5063a, f12);
    }

    public static final Y8.t O0(DraggableSheetLayout draggableSheetLayout) {
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.d();
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void P(DraggableSheetLayout draggableSheetLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        draggableSheetLayout.O(z10);
    }

    public static final Y8.t P0(DraggableSheetLayout draggableSheetLayout, SheetSettleState sheetSettleState, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.settleState = sheetSettleState;
        draggableSheetLayout.sheetOffset = draggableSheetLayout.L1(sheetSettleState);
        draggableSheetLayout.anchorTargetState = null;
        draggableSheetLayout.L();
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        draggableSheetLayout.C0();
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void R0(DraggableSheetLayout draggableSheetLayout, float f10, float f11, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        draggableSheetLayout.Q0(f10, f11, interfaceC5063a);
    }

    public static final Y8.t V0(DraggableSheetLayout draggableSheetLayout, float f10, float f11, Ref$FloatRef ref$FloatRef, float f12, float f13) {
        draggableSheetLayout.sheetOffset = f12;
        v1(draggableSheetLayout, f13, 0.0f, 2, null);
        draggableSheetLayout.L();
        float fMin = Math.min(ref$FloatRef.f34817a, C5685n.m((f12 - f10) / f11, 0.0f, 1.0f));
        ref$FloatRef.f34817a = fMin;
        L l10 = draggableSheetLayout.scaleEnterBottomClip;
        if (l10 != null) {
            l10.d(fMin);
        }
        draggableSheetLayout.W(ref$FloatRef.f34817a);
        return Y8.t.f7040a;
    }

    public static final Y8.t W0(DraggableSheetLayout draggableSheetLayout, SheetSettleState sheetSettleState, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.bloomAnim = null;
        draggableSheetLayout.settleState = sheetSettleState;
        draggableSheetLayout.sheetOffset = draggableSheetLayout.L1(sheetSettleState);
        draggableSheetLayout.anchorTargetState = null;
        draggableSheetLayout.q1();
        draggableSheetLayout.L();
        draggableSheetLayout._scaleEnterRunning.setValue(Boolean.FALSE);
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        draggableSheetLayout.W(0.0f);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(DraggableSheetLayout draggableSheetLayout, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.contentScaleExitAnim = null;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t b1(InterfaceC5063a interfaceC5063a) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void d1(Ref$BooleanRef ref$BooleanRef, DraggableSheetLayout draggableSheetLayout, float f10, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        draggableSheetLayout.sheetOffset = f10;
        draggableSheetLayout.L();
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void e1(DraggableSheetLayout draggableSheetLayout, float f10, float f11, InterfaceC5074l interfaceC5074l, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        float animatedFraction = anim.getAnimatedFraction();
        draggableSheetLayout.sheetOffset = f10 + ((f11 - f10) * animatedFraction);
        draggableSheetLayout.L();
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(animatedFraction));
        }
    }

    public static final void g1(DraggableSheetLayout draggableSheetLayout, float f10, float f11, Ref$FloatRef ref$FloatRef, InterfaceC5074l interfaceC5074l, androidx.dynamicanimation.animation.e eVar, float f12, float f13) {
        draggableSheetLayout.sheetOffset = f12;
        draggableSheetLayout.L();
        float fMax = Math.max(ref$FloatRef.f34817a, C5685n.m((f12 - f10) / f11, 0.0f, 1.0f));
        ref$FloatRef.f34817a = fMax;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(fMax));
        }
    }

    private final SheetSettleState getEffectiveSettleState() {
        SheetSettleState sheetSettleState = this.anchorTargetState;
        return sheetSettleState == null ? this.settleState : sheetSettleState;
    }

    private final View getSheet() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public static final void h1(DraggableSheetLayout draggableSheetLayout, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (draggableSheetLayout.settleAnim == eVar) {
            draggableSheetLayout.settleAnim = null;
        }
        if (z10) {
            return;
        }
        draggableSheetLayout.sheetOffset = f10;
        draggableSheetLayout.L();
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(1.0f));
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t j1(DraggableSheetLayout draggableSheetLayout, InterfaceC5074l interfaceC5074l, float f10) {
        draggableSheetLayout.sheetOffset = draggableSheetLayout.j0() + ((draggableSheetLayout.m0() - draggableSheetLayout.j0()) * f10);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Float.valueOf(f10));
        }
        return Y8.t.f7040a;
    }

    private final void settleOrDismiss(float velocityY) {
        if (this.dismissFromDragPending || this.exitMorphing) {
            return;
        }
        float f10 = this.minFlingVelocity;
        float f11 = 2;
        boolean z10 = velocityY < (-f10) * f11;
        boolean z11 = velocityY > f10 * f11;
        if (this.heightMode == SheetHeightMode.MINIFY_EXPANDABLE) {
            w1(z10, z11);
            return;
        }
        int i10 = d.$EnumSwitchMapping$0[this.settleState.ordinal()];
        if (i10 == 1) {
            if (B1(z11)) {
                o1();
                return;
            } else {
                y1(this, SheetSettleState.FULL, true, null, 4, null);
                return;
            }
        }
        if (i10 != 2) {
            if (i10 != 3 && i10 != 4 && i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        if (!this.allowCollapseToHalf) {
            if (!E0()) {
                y1(this, SheetSettleState.FULL, true, null, 4, null);
                return;
            }
            a aVar = this.callback;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        if (z11 || this.fullDragRawPull >= i0().getCommitB() - 0.5f) {
            o1();
        } else if (z10 || this.sheetOffset < k0()) {
            y1(this, SheetSettleState.FULL, true, null, 4, null);
        } else {
            y1(this, SheetSettleState.HALF, true, null, 4, null);
        }
    }

    private final boolean v0(float rawX, float rawY, View view) {
        if (view != null && view.isAttachedToWindow() && view.getVisibility() == 0) {
            view.getLocationOnScreen(this.tmpLocation);
            float f10 = rawX - r3[0];
            float f11 = rawY - r3[1];
            if (f10 >= 0.0f && f11 >= 0.0f && f10 <= view.getWidth() && f11 <= view.getHeight()) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void v1(DraggableSheetLayout draggableSheetLayout, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = f10;
        }
        draggableSheetLayout.u1(f10, f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y1(DraggableSheetLayout draggableSheetLayout, SheetSettleState sheetSettleState, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        draggableSheetLayout.x1(sheetSettleState, z10, interfaceC5063a);
    }

    public static /* synthetic */ void z0(DraggableSheetLayout draggableSheetLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        draggableSheetLayout.y0(z10);
    }

    public static final Y8.t z1(DraggableSheetLayout draggableSheetLayout, float f10, SheetSettleState sheetSettleState, InterfaceC5063a interfaceC5063a) {
        draggableSheetLayout.sheetOffset = f10;
        draggableSheetLayout.L();
        draggableSheetLayout.C0();
        a aVar = draggableSheetLayout.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public final void A(View panel) {
        View view;
        if (this.bottomAnchorEnabled && (view = this.contentAnchorView) != null && getHeight() > 0 && view.getParent() != null) {
            SheetSettleState sheetSettleState = this.anchorTargetState;
            Float fValueOf = sheetSettleState != null ? Float.valueOf(D0(L1(sheetSettleState))) : null;
            int iN = C5685n.n(C5227b.b(C5685n.e(((getHeight() - (((this.transitionPinScreenBottom || this.clipEnterOvershootExtend) && fValueOf != null && panel.getTranslationY() < fValueOf.floatValue() - 0.5f) ? panel.getTranslationY() : fValueOf != null ? fValueOf.floatValue() : C1() ? D0(t1()) : panel.getTranslationY())) - view.getTop()) - this.imeInsetPx, 0.0f) / (this.clipEnterOvershootExtend ? C5685n.m(view.getScaleY(), 0.25f, 1.0f) : 1.0f)), 0, C5685n.f(getHeight() * 3, 1));
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            int i10 = layoutParams.height;
            if (i10 != iN) {
                if (this.stackPeekExtraY != 0.0f || this.stackScale != 1.0f) {
                    return;
                }
                boolean z10 = i10 <= 0 && iN > 0;
                layoutParams.height = iN;
                view.setLayoutParams(layoutParams);
                if (z10) {
                    view.forceLayout();
                }
                if (this.clipEnterOvershootExtend) {
                    z0(this, false, 1, null);
                }
            } else if (this.clipEnterOvershootExtend) {
                z0(this, false, 1, null);
            }
            if (this.imeInsetPx > 0.5f || this.dragging) {
                return;
            }
            androidx.dynamicanimation.animation.i iVar = this.settleAnim;
            if ((iVar == null || !iVar.i()) && !this.clipEnterOvershootExtend && !this.exitMorphing && !this.morphFreeze && this.stackPeekExtraY == 0.0f && this.stackScale == 1.0f && iN > view.getHeight() + 1) {
                y0(true);
            }
        }
    }

    public final float A0() {
        return z(getHeight() * this.minifyTopRatio);
    }

    public final boolean A1(float rawX, float rawY) {
        View view;
        if (q0(rawX, rawY) || (view = this.dragHandleView) == null) {
            return true;
        }
        return v0(rawX, rawY, view);
    }

    public final void B(float scale, float peekExtraY, float alpha, float transformDamping, float transformStiffness, float alphaDamping, float alphaStiffness) {
        View sheet;
        if (this.sharedExitStartY == null && (sheet = getSheet()) != null) {
            if (sheet.getWidth() > 0) {
                sheet.setPivotX(sheet.getWidth() / 2.0f);
            }
            sheet.setPivotY(0.0f);
            androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
            if (iVar != null) {
                iVar.d();
            }
            androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
            if (iVar2 != null) {
                iVar2.d();
            }
            androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
            if (iVar3 != null) {
                iVar3.d();
            }
            androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
            if (iVar4 != null) {
                iVar4.d();
            }
            float f10 = this.stackScale;
            if (f10 == 0.0f) {
                f10 = 1.0f;
            }
            float f11 = this.stackPeekExtraY;
            float f12 = this.stackAlpha;
            androidx.dynamicanimation.animation.i iVar5 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(f10));
            iVar5.o(0.002f);
            iVar5.B(new androidx.dynamicanimation.animation.j(scale).f(transformDamping).h(transformStiffness));
            iVar5.c(new e.r() { // from class: com.stepos.ailauncher.sheet.widget.u
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f13, float f14) {
                    DraggableSheetLayout.C(this.f28269a, eVar, f13, f14);
                }
            });
            iVar5.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.v
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f13, float f14) {
                    DraggableSheetLayout.D(this.f28270a, eVar, z10, f13, f14);
                }
            });
            iVar5.t();
            this.stackScaleAnimX = iVar5;
            this.stackScaleAnimY = null;
            androidx.dynamicanimation.animation.i iVar6 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(f11));
            iVar6.B(new androidx.dynamicanimation.animation.j(peekExtraY).f(transformDamping).h(transformStiffness));
            iVar6.c(new e.r() { // from class: com.stepos.ailauncher.sheet.widget.w
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f13, float f14) {
                    DraggableSheetLayout.E(this.f28271a, eVar, f13, f14);
                }
            });
            iVar6.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.x
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f13, float f14) {
                    DraggableSheetLayout.F(this.f28272a, eVar, z10, f13, f14);
                }
            });
            iVar6.t();
            this.stackPeekAnim = iVar6;
            androidx.dynamicanimation.animation.i iVar7 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(f12));
            iVar7.o(0.00390625f);
            iVar7.B(new androidx.dynamicanimation.animation.j(alpha).f(alphaDamping).h(alphaStiffness));
            iVar7.c(new e.r() { // from class: com.stepos.ailauncher.sheet.widget.y
                @Override // androidx.dynamicanimation.animation.e.r
                public final void b(androidx.dynamicanimation.animation.e eVar, float f13, float f14) {
                    DraggableSheetLayout.G(this.f28273a, eVar, f13, f14);
                }
            });
            iVar7.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.z
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f13, float f14) {
                    DraggableSheetLayout.H(this.f28274a, eVar, z10, f13, f14);
                }
            });
            iVar7.t();
            this.stackAlphaAnim = iVar7;
        }
    }

    public final void B0() {
        if (this.nestedScrollInProgress) {
            this.nestedContentScrolled = true;
        }
    }

    public final boolean B1(boolean flingDown) {
        if (flingDown || E0()) {
            return true;
        }
        return this.useFullDragThreshold && this.fullDragRawPull >= i0().getCommitB() - 0.5f;
    }

    public final void C0() {
        float f10 = C5685n.f(getHeight(), 1);
        float fP0 = d.$EnumSwitchMapping$0[this.settleState.ordinal()] == 4 ? p0() : j0();
        W(C5685n.m((this.sheetOffset - fP0) / C5685n.e(f10 - fP0, 1.0f), 0.0f, 1.0f));
    }

    public final boolean C1() {
        if (!this.freezeContentHeightOnFullDrag) {
            return false;
        }
        if (!w0()) {
            this.fullDragHeightFrozen = false;
            return false;
        }
        if (!this.fullDragHeightFrozen || this.anchorTargetState != null) {
            return false;
        }
        if (Math.abs(this.sheetOffset - t1()) > 0.5f) {
            return true;
        }
        this.fullDragHeightFrozen = false;
        return false;
    }

    public final float D0(float offset) {
        float f10 = offset + (this.stackPeekSuppressed ? 0.0f : this.stackPeekExtraY);
        return f10 - o0(f10);
    }

    public final void D1(boolean animate) {
        SheetSettleState sheetSettleState;
        int i10 = d.$EnumSwitchMapping$1[this.heightMode.ordinal()];
        if (i10 == 1) {
            sheetSettleState = SheetSettleState.FULL;
        } else if (i10 == 2) {
            sheetSettleState = SheetSettleState.HALF;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetSettleState = SheetSettleState.MINIFY;
        }
        y1(this, sheetSettleState, animate, null, 4, null);
    }

    public final boolean E0() {
        if (getHeight() <= 0) {
            return false;
        }
        return ((float) getHeight()) - C5685n.m(F0(), 0.0f, (float) getHeight()) < ((float) getHeight()) * 0.5f;
    }

    public final void E1(float targetY, float stiffness, float dampingRatio, final InterfaceC5063a<Y8.t> onFirstRebound, final InterfaceC5063a<Y8.t> onEnd) {
        if (getSheet() == null) {
            return;
        }
        N();
        androidx.dynamicanimation.animation.i iVar = this.settleAnim;
        if (iVar != null) {
            iVar.d();
        }
        final C c10 = onFirstRebound != null ? new C(this.sheetOffset, targetY) : null;
        androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(this.sheetOffset));
        iVar2.B(new androidx.dynamicanimation.animation.j(targetY).f(dampingRatio).h(stiffness));
        iVar2.c(new e.r() { // from class: com.stepos.ailauncher.sheet.widget.s
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                DraggableSheetLayout.G1(this.f28264a, c10, onFirstRebound, eVar, f10, f11);
            }
        });
        iVar2.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.t
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                DraggableSheetLayout.H1(this.f28267a, onEnd, eVar, z10, f10, f11);
            }
        });
        iVar2.t();
        this.settleAnim = iVar2;
    }

    public final float F0() {
        View sheet = getSheet();
        return sheet != null ? sheet.getTranslationY() : this.sheetOffset;
    }

    public final void G0(final boolean scaleContent, final InterfaceC5074l<? super Float, Y8.t> onProgress, final InterfaceC5063a<Y8.t> onEnd, final InterfaceC5063a<Y8.t> onCancelled) throws Resources.NotFoundException {
        SheetSettleState sheetSettleState;
        final View sheet = getSheet();
        if (sheet == null) {
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        O(true);
        final boolean z10 = this.dismissEnabled;
        this.dismissEnabled = false;
        this.clipEnterCancelCleanup = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.H0(this.f28231a, z10, onCancelled);
            }
        };
        setBottomAnchorEnabled(true);
        int i10 = d.$EnumSwitchMapping$1[this.heightMode.ordinal()];
        if (i10 == 1) {
            sheetSettleState = SheetSettleState.FULL;
        } else if (i10 == 2) {
            sheetSettleState = SheetSettleState.HALF;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetSettleState = SheetSettleState.MINIFY;
        }
        this.settleState = sheetSettleState;
        this.sheetOffset = L1(sheetSettleState);
        this.anchorTargetState = sheetSettleState;
        L();
        y0(true);
        if (!isLaidOut() || sheet.getWidth() <= 0 || getHeight() <= 0) {
            final SheetSettleState sheetSettleState2 = sheetSettleState;
            final InterfaceC5063a<Y8.t> interfaceC5063a = this.clipEnterCancelCleanup;
            post(new Runnable() { // from class: com.stepos.ailauncher.sheet.widget.k
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    DraggableSheetLayout.I0(this.f28234a, interfaceC5063a, z10, sheetSettleState2, onProgress, onEnd, scaleContent, onCancelled);
                }
            });
            return;
        }
        q1();
        sheet.setScaleX(1.0f);
        sheet.setScaleY(1.0f);
        float translationY = sheet.getTranslationY();
        float fE = C5685n.e(getWidth(), 1.0f);
        float fE2 = C5685n.e(getHeight() - translationY, 1.0f);
        float dimension = getResources().getDimension(R$dimen.ail_nav_handle_width);
        float dimension2 = getResources().getDimension(R$dimen.ail_nav_handle_height);
        float dimension3 = getResources().getDimension(R$dimen.ail_nav_handle_margin_bottom);
        float dimension4 = getResources().getDimension(R$dimen.ail_nav_handle_radius);
        float dimension5 = getResources().getDimension(R$dimen.ail_sheet_corner);
        getLocationOnScreen(new int[2]);
        float f10 = getResources().getDisplayMetrics().heightPixels - dimension3;
        float f11 = fE * 0.5f;
        float f12 = translationY + (0.5f * fE2);
        float f13 = (f10 - r6[1]) - f12;
        boolean z11 = sheetSettleState == SheetSettleState.FULL;
        SheetSpring sheetSpringI = z11 ? i0.INSTANCE.i() : i0.INSTANCE.l();
        SheetSpring sheetSpringF = z11 ? i0.INSTANCE.f() : i0.INSTANCE.j();
        SheetSpring sheetSpringG = z11 ? i0.INSTANCE.g() : i0.INSTANCE.k();
        SheetSpring sheetSpringH = z11 ? i0.INSTANCE.h() : i0.INSTANCE.m();
        float f14 = 2.5f * getResources().getDisplayMetrics().density;
        this.exitMorphing = true;
        this.clipEnterOvershootExtend = true;
        com.stepos.ailauncher.sheet.internal.p pVar = com.stepos.ailauncher.sheet.internal.p.INSTANCE;
        float stiffness = sheetSpringI.getStiffness();
        float dampingRatio = sheetSpringI.getDampingRatio();
        SheetSpring sheetSpring = sheetSpringF;
        float stiffness2 = sheetSpring.getStiffness();
        float dampingRatio2 = sheetSpring.getDampingRatio();
        SheetSpring sheetSpring2 = sheetSpringH;
        float stiffness3 = sheetSpring2.getStiffness();
        float dampingRatio3 = sheetSpring2.getDampingRatio();
        float stiffness4 = sheetSpringG.getStiffness();
        float dampingRatio4 = z11 ? sheetSpringG.getDampingRatio() : 0.78f;
        View view = this.contentAnchorView;
        if (!scaleContent) {
            view = null;
        }
        final SheetSettleState sheetSettleState3 = sheetSettleState;
        this.collapseClipAnim = pVar.m(this, sheet, dimension, fE, dimension2, fE2, f11, f12, (295698432 & 256) != 0 ? 0.0f : f13, 0.0f, dimension4, dimension5, stiffness, dampingRatio, stiffness2, dampingRatio2, stiffness3, dampingRatio3, (262144 & 295698432) != 0 ? stiffness2 : stiffness4, (524288 & 295698432) != 0 ? dampingRatio2 : dampingRatio4, (1048576 & 295698432) != 0 ? 0.0f : f14, (2097152 & 295698432) != 0 ? 0.0f : 0.0f, (4194304 & 295698432) != 0 ? false : true, (8388608 & 295698432) != 0 ? 0.0f : 0.0f, (16777216 & 295698432) != 0 ? 0.0f : 0.0f, (33554432 & 295698432) != 0 ? null : view, (67108864 & 295698432) != 0 ? null : new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.J0(this.f28242a, sheet);
            }
        }, (134217728 & 295698432) != 0 ? null : onProgress, (295698432 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.K0(this.f28244a, sheet, z10, sheetSettleState3, onEnd);
            }
        });
    }

    public final void I(View panel) {
        ViewGroup.LayoutParams layoutParams;
        if ((!this.transitionPinScreenBottom && !this.clipEnterOvershootExtend) || getHeight() <= 0) {
            R(panel);
            return;
        }
        SheetSettleState sheetSettleState = this.anchorTargetState;
        float fE = C5685n.e((sheetSettleState != null ? D0(L1(sheetSettleState)) : panel.getTranslationY()) - panel.getTranslationY(), 0.0f);
        View view = this.contentAnchorView;
        int top = 0;
        int i10 = (view == null || (layoutParams = view.getLayoutParams()) == null) ? 0 : layoutParams.height;
        if (view != null && i10 > 0) {
            top = view.getTop() + i10;
        }
        if (top <= getHeight() && (!this.transitionPinScreenBottom ? fE >= 0.5f : panel.getTranslationY() < 0.0f)) {
            R(panel);
            return;
        }
        if (this.sheetOvershootBaseH < 0) {
            ViewGroup.LayoutParams layoutParams2 = panel.getLayoutParams();
            this.sheetOvershootSavedLpH = layoutParams2 != null ? layoutParams2.height : -1;
            this.sheetOvershootBaseH = C5685n.f(panel.getHeight(), getHeight());
        }
        int iMax = Math.max(this.sheetOvershootBaseH + ((int) Math.ceil(fE / C5685n.e(this.stackScale * this.transitionScaleY, 0.01f))), top);
        ViewGroup.LayoutParams layoutParams3 = panel.getLayoutParams();
        if (layoutParams3 == null) {
            return;
        }
        if (layoutParams3.height != iMax) {
            layoutParams3.height = iMax;
            panel.setLayoutParams(layoutParams3);
        }
        if (panel.getHeight() != iMax && iMax > 0) {
            panel.measure(View.MeasureSpec.makeMeasureSpec(C5685n.f(panel.getWidth(), 1), 1073741824), View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
            panel.layout(panel.getLeft(), panel.getTop(), panel.getLeft() + panel.getMeasuredWidth(), panel.getTop() + panel.getMeasuredHeight());
        }
        panel.invalidateOutline();
    }

    public final void J() {
        if (!this.stackBackgroundColorAlphaEnabled || this.exitMorphing || this.morphFreeze) {
            return;
        }
        float fC = h0.c(this.stackScale);
        Z z10 = this.panelBackgroundAlpha;
        View sheet = getSheet();
        z10.a(sheet != null ? sheet.getBackground() : null, fC, this.stackBackgroundPreserveOpacity);
    }

    public final float J1(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        return L1(state);
    }

    public final void K(float scale, float peekExtraY, float alpha) {
        View sheet;
        if (this.sharedExitStartY == null && (sheet = getSheet()) != null) {
            if (sheet.getWidth() > 0) {
                sheet.setPivotX(sheet.getWidth() / 2.0f);
            }
            sheet.setPivotY(0.0f);
            androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
            if (iVar != null) {
                iVar.d();
            }
            androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
            if (iVar2 != null) {
                iVar2.d();
            }
            androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
            if (iVar3 != null) {
                iVar3.d();
            }
            androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
            if (iVar4 != null) {
                iVar4.d();
            }
            this.stackScale = scale;
            this.stackPeekExtraY = peekExtraY;
            this.stackAlpha = C5685n.m(alpha, 0.0f, 1.0f);
            L();
        }
    }

    public final boolean K1() {
        return this.chromeTransparent && this.settleState == SheetSettleState.MINIFY;
    }

    public final void L() {
        View sheet;
        Float f10 = this.sharedExitStartY;
        if (f10 != null) {
            float fFloatValue = f10.floatValue();
            View sheet2 = getSheet();
            if (sheet2 != null) {
                sheet2.setTranslationY(fFloatValue + this.homeGroupExitOffsetY);
                return;
            }
            return;
        }
        if (this.exitMorphing || (sheet = getSheet()) == null || this.morphFreeze) {
            return;
        }
        sheet.setTranslationY(D0(this.sheetOffset) + this.homeGroupExitOffsetY);
        sheet.setScaleX(this.stackScale * this.transitionScaleX * this.rubberBandScaleX);
        sheet.setScaleY(this.stackScale * this.transitionScaleY);
        sheet.setAlpha(this.stackAlpha);
        J();
        I(sheet);
        if (sheet.getWidth() > 0) {
            sheet.setPivotX(sheet.getWidth() / 2.0f);
        }
        sheet.setPivotY((!this.transitionScaleActive || sheet.getHeight() <= 0) ? 0.0f : this.transitionPinScreenBottom ? C5685n.m(getHeight() - sheet.getTranslationY(), 0.0f, sheet.getHeight()) : sheet.getHeight() * this.transitionPivotYFraction);
        A(sheet);
        if (this.transitionPinScreenBottom || this.clipEnterOvershootExtend) {
            I(sheet);
            if (!this.transitionPinScreenBottom || sheet.getHeight() <= 0) {
                return;
            }
            sheet.setPivotY(C5685n.m(getHeight() - sheet.getTranslationY(), 0.0f, sheet.getHeight()));
        }
    }

    public final void L0(float stiffness, float dampingRatio, final InterfaceC5063a<Y8.t> onEnd, Float travelDistancePx) {
        final SheetSettleState sheetSettleState;
        int i10 = d.$EnumSwitchMapping$1[this.heightMode.ordinal()];
        if (i10 == 1) {
            sheetSettleState = SheetSettleState.FULL;
        } else if (i10 == 2) {
            sheetSettleState = SheetSettleState.HALF;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetSettleState = SheetSettleState.MINIFY;
        }
        float fL1 = L1(sheetSettleState);
        float fFloatValue = travelDistancePx != null ? travelDistancePx.floatValue() + fL1 : m0();
        setBottomAnchorEnabled(true);
        this.anchorTargetState = sheetSettleState;
        this.sheetOffset = fFloatValue;
        L();
        y0(true);
        this.settleState = SheetSettleState.HIDDEN;
        E1(fL1, stiffness, dampingRatio, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.O0(this.f28253a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.P0(this.f28254a, sheetSettleState, onEnd);
            }
        });
    }

    public final float L1(SheetSettleState state) {
        int i10 = d.$EnumSwitchMapping$0[state.ordinal()];
        if (i10 == 1) {
            return j0();
        }
        if (i10 == 2) {
            return l0();
        }
        if (i10 == 3) {
            return A0();
        }
        if (i10 == 4) {
            return p0();
        }
        if (i10 == 5) {
            return m0();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void M() {
        this.morphFreeze = true;
    }

    public final void M0(InterfaceC5063a<Y8.t> onEnd) {
        N0(this, DEFAULT_SPRING_STIFFNESS, DEFAULT_SPRING_DAMPING, onEnd, null, 8, null);
    }

    public final void N() {
        C3447f.a aVar = this.bloomAnim;
        this.bloomAnim = null;
        if (aVar != null) {
            aVar.a();
        }
        p.a aVar2 = this.collapseClipAnim;
        this.collapseClipAnim = null;
        if (aVar2 != null) {
            aVar2.a();
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.clipEnterCancelCleanup;
        this.clipEnterCancelCleanup = null;
        if (interfaceC5063a != null) {
            this.anchorTargetState = null;
            interfaceC5063a.invoke();
        }
        z.a aVar3 = this.contentScaleExitAnim;
        this.contentScaleExitAnim = null;
        if (aVar3 != null) {
            aVar3.a();
        }
        this.exitMorphing = false;
        c0();
        q1();
        if (isLaidOut()) {
            L();
        }
        this._scaleEnterRunning.setValue(Boolean.FALSE);
    }

    public final void O(boolean suppressEndCallback) {
        androidx.dynamicanimation.animation.i iVar = this.settleAnim;
        if (suppressEndCallback && iVar != null) {
            Set<androidx.dynamicanimation.animation.i> suppressedSettleEndAnimations = this.suppressedSettleEndAnimations;
            kotlin.jvm.internal.p.h(suppressedSettleEndAnimations, "suppressedSettleEndAnimations");
            suppressedSettleEndAnimations.add(iVar);
        }
        if (iVar != null) {
            iVar.d();
        }
        if (this.settleAnim == iVar) {
            this.settleAnim = null;
        }
        N();
    }

    public final void Q() {
        this.fullDragRawPull = 0.0f;
        this.rubberBandScaleX = 1.0f;
    }

    public final void Q0(float stiffness, float dampingRatio, InterfaceC5063a<Y8.t> onEnd) {
        N0(this, stiffness, dampingRatio, onEnd, null, 8, null);
    }

    public final void R(View panel) {
        if (this.sheetOvershootBaseH < 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = panel.getLayoutParams();
        if (layoutParams != null) {
            int i10 = layoutParams.height;
            int i11 = this.sheetOvershootSavedLpH;
            if (i10 != i11) {
                layoutParams.height = i11;
                panel.setLayoutParams(layoutParams);
            }
        }
        this.sheetOvershootBaseH = -1;
        this.sheetOvershootSavedLpH = -1;
    }

    public final CollapseClipGeometry S(boolean nineSplit) throws Resources.NotFoundException {
        float fA;
        View sheet = getSheet();
        if (sheet == null || !isLaidOut() || sheet.getWidth() <= 0 || getHeight() <= 0) {
            return null;
        }
        float translationY = sheet.getTranslationY();
        float fE = C5685n.e(getHeight() - translationY, 1.0f);
        float dimension = getResources().getDimension(R$dimen.ail_nav_handle_height);
        if (nineSplit) {
            Resources resources = getResources();
            kotlin.jvm.internal.p.h(resources, "getResources(...)");
            fA = h0.a(resources, 0.3f);
        } else {
            fA = dimension;
        }
        float dimension2 = getResources().getDimension(R$dimen.ail_nav_handle_margin_bottom);
        getLocationOnScreen(new int[2]);
        float f10 = translationY + (0.5f * fE);
        return new CollapseClipGeometry(fE, fA, getWidth() * 0.5f, f10, (((getResources().getDisplayMetrics().heightPixels - dimension2) - ((fA - dimension) * 0.5f)) - r2[1]) - f10);
    }

    public final void S0(float travelDistancePx, float stiffness, float dampingRatio, InterfaceC5063a<Y8.t> onEnd) {
        L0(stiffness, dampingRatio, onEnd, Float.valueOf(travelDistancePx));
    }

    public final boolean T(MotionEvent ev, int direction) {
        View viewInvoke;
        InterfaceC5063a<? extends View> interfaceC5063a = this.touchScrollableContentProvider;
        if (interfaceC5063a != null && (viewInvoke = interfaceC5063a.invoke()) != null && v0(ev.getRawX(), ev.getRawY(), viewInvoke) && viewInvoke.canScrollVertically(direction)) {
            return true;
        }
        View sheet = getSheet();
        if (sheet == null) {
            return false;
        }
        return n0(sheet, ev.getRawX(), ev.getRawY(), direction);
    }

    public final void T0(float collapsedScale, float travelDistancePx, float offsetStiffness, float offsetDampingRatio, float scaleStiffness, float scaleDampingRatio, boolean floatingBottom, final InterfaceC5063a<Y8.t> onEnd) {
        final SheetSettleState sheetSettleState;
        View sheet = getSheet();
        if (sheet == null) {
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        P(this, false, 1, null);
        this._scaleEnterRunning.setValue(Boolean.TRUE);
        setBottomAnchorEnabled(true);
        int i10 = d.$EnumSwitchMapping$1[this.heightMode.ordinal()];
        if (i10 == 1) {
            sheetSettleState = SheetSettleState.FULL;
        } else if (i10 == 2) {
            sheetSettleState = SheetSettleState.HALF;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetSettleState = SheetSettleState.MINIFY;
        }
        final float fL1 = L1(sheetSettleState);
        float f10 = fL1 + travelDistancePx;
        this.anchorTargetState = sheetSettleState;
        this.settleState = SheetSettleState.HIDDEN;
        this.sheetOffset = f10;
        this.transitionScaleActive = true;
        this.transitionPivotYFraction = 0.5f;
        this.transitionPinScreenBottom = true;
        v1(this, 1.0f, 0.0f, 2, null);
        L();
        y0(true);
        v1(this, collapsedScale, 0.0f, 2, null);
        L();
        W(1.0f);
        if (isLaidOut() && sheet.getWidth() > 0 && sheet.getHeight() > 0) {
            if (floatingBottom) {
                L l10 = new L(this, sheet);
                l10.d(1.0f);
                this.scaleEnterBottomClip = l10;
            }
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            ref$FloatRef.f34817a = 1.0f;
            final float fE = C5685n.e(f10 - fL1, 1.0f);
            this.bloomAnim = C3447f.INSTANCE.e(f10, fL1, offsetStiffness, offsetDampingRatio, collapsedScale, 1.0f, scaleStiffness, scaleDampingRatio, false, new p9.p() { // from class: com.stepos.ailauncher.sheet.widget.q
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return DraggableSheetLayout.V0(this.f28257a, fL1, fE, ref$FloatRef, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.r
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DraggableSheetLayout.W0(this.f28261a, sheetSettleState, onEnd);
                }
            });
            return;
        }
        this.settleState = sheetSettleState;
        this.sheetOffset = fL1;
        this.anchorTargetState = null;
        q1();
        L();
        this._scaleEnterRunning.setValue(Boolean.FALSE);
        a aVar = this.callback;
        if (aVar != null) {
            aVar.b(sheetSettleState);
        }
        C0();
        if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final float U(float restingTop) {
        View view;
        int paddingBottom;
        if (getHeight() <= 0 || (view = this.contentAnchorView) == null) {
            return 0.0f;
        }
        if (this.minifyContentView == null) {
            paddingBottom = 0;
        } else {
            int i10 = this.cachedMinifyIntrinsic;
            if (i10 <= 0) {
                return 0.0f;
            }
            paddingBottom = i10 + view.getPaddingBottom();
        }
        return C5685n.e(((getHeight() - restingTop) - view.getTop()) - paddingBottom, 0.0f);
    }

    public final View V(View target) {
        View viewInvoke;
        InterfaceC5063a<? extends View> interfaceC5063a = this.touchScrollableContentProvider;
        if (interfaceC5063a != null && (viewInvoke = interfaceC5063a.invoke()) != null) {
            while (target != null && target != this) {
                if (target == viewInvoke) {
                    return viewInvoke;
                }
                Object parent = target.getParent();
                target = parent instanceof View ? (View) parent : null;
            }
        }
        return null;
    }

    public final void W(float progress) {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(C5685n.m(progress, 0.0f, 1.0f));
        }
    }

    public final float X(float dy) {
        Q();
        this.fullDragHeightFrozen = false;
        float f10 = this.sheetOffset;
        float fM = C5685n.m(dy + f10, j0(), l0());
        this.sheetOffset = fM;
        float f11 = fM - f10;
        if (f11 == 0.0f) {
            return f11;
        }
        L();
        C0();
        return f11;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X0(float r23, float r24, float r25, float r26, float r27, float r28, float r29, float r30, p9.InterfaceC5074l<? super java.lang.Float, Y8.t> r31, p9.InterfaceC5063a<Y8.t> r32, final p9.InterfaceC5063a<Y8.t> r33) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.X0(float, float, float, float, float, float, float, float, p9.l, p9.a, p9.a):void");
    }

    public final float Y(float dy) {
        if (dy == 0.0f || this.dismissFromDragPending || this.exitMorphing || !this.dismissEnabled || e0()) {
            return 0.0f;
        }
        if (w0()) {
            return (this.settleState != SheetSettleState.HALF || this.sheetOffset > l0() + 0.5f || (dy >= 0.0f && this.sheetOffset >= l0() - 0.5f)) ? this.useFullDragThreshold ? Z(dy) : a0(dy) : X(dy);
        }
        float f10 = this.sheetOffset;
        float fM = C5685n.m(dy + f10, j0(), m0());
        this.sheetOffset = fM;
        float f11 = fM - f10;
        if (f11 == 0.0f) {
            return f11;
        }
        L();
        C0();
        return f11;
    }

    public final float Z(float dy) {
        float fT1 = t1();
        RubberBandConfig rubberBandConfigI0 = i0();
        float f10 = this.fullDragRawPull;
        this.fullDragRawPull = C5685n.m(f10 + dy, 0.0f, rubberBandConfigI0.getCommitB());
        VelocityTracker velocityTracker = this.velocityTracker;
        RubberBandState rubberBandStateA = X.a(this.fullDragRawPull, velocityTracker != null ? velocityTracker.getYVelocity() : this.nestedFlingVelocityY, rubberBandConfigI0);
        float f11 = this.sheetOffset;
        this.sheetOffset = rubberBandStateA.getVisualPull() + fT1;
        float sizeX = rubberBandConfigI0.getWidthA() > 0.0f ? rubberBandStateA.getSizeX() / rubberBandConfigI0.getWidthA() : 1.0f;
        this.rubberBandScaleX = sizeX;
        float f12 = this.sheetOffset;
        if (f12 != f11 || sizeX != 1.0f || this.fullDragRawPull != f10) {
            if (this.freezeContentHeightOnFullDrag && f12 > fT1 + 0.5f) {
                this.fullDragHeightFrozen = true;
            }
            L();
            C0();
        }
        if (!rubberBandStateA.getReachedB()) {
            return this.fullDragRawPull - f10;
        }
        if (this.settleState == SheetSettleState.FULL && f10 < rubberBandConfigI0.getCommitB() - 0.5f) {
            performHapticFeedback(23, 1);
        }
        o1();
        return dy;
    }

    public final Animator Z0(float panelCornerPx, InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onEnd) {
        this.dismissEnabled = false;
        this.settleState = SheetSettleState.HIDDEN;
        P(this, false, 1, null);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackPeekAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackAlphaAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        this.stackScale = 1.0f;
        this.stackAlpha = 1.0f;
        L();
        View sheet = getSheet();
        if (sheet == null) {
            if (onEnd != null) {
                onEnd.invoke();
            }
            return null;
        }
        float translationY = sheet.getTranslationY();
        this.exitMorphing = true;
        RectF rectF = new RectF(0.0f, translationY, getWidth(), getHeight());
        HandleBounds handleBoundsA = this.handleBoundsProvider.a(this);
        getLocationOnScreen(new int[2]);
        return F.INSTANCE.e(this, sheet, rectF, new RectF(handleBoundsA.getLeft() - r6[0], handleBoundsA.getTop() - r6[1], handleBoundsA.getRight() - r6[0], handleBoundsA.getBottom() - r6[1]), panelCornerPx, (32 & 32) != 0 ? 400L : 0L, (32 & 64) != 0 ? null : onProgress, (32 & 128) != 0 ? null : onEnd);
    }

    public final float a0(float dy) {
        float f10 = this.sheetOffset;
        float fM = C5685n.m(dy + f10, j0(), m0());
        this.sheetOffset = fM;
        float f11 = fM - f10;
        if (f11 == 0.0f) {
            return f11;
        }
        if (this.freezeContentHeightOnFullDrag && fM > t1() + 0.5f) {
            this.fullDragHeightFrozen = true;
        }
        L();
        C0();
        return f11;
    }

    public final void a1(float collapsedScale, float travelDistancePx, float offsetStiffness, float offsetDampingRatio, float scaleStiffness, float scaleDampingRatio, float collapsedScaleY, float bottomWidthPinchDp, boolean scaleContent, InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onCollapsedToBar, final InterfaceC5063a<Y8.t> onEnd) throws Resources.NotFoundException {
        Float fValueOf = Float.valueOf(1.0f);
        View sheet = getSheet();
        float fE = sheet != null ? C5685n.e(sheet.getScaleX(), 0.01f) : 1.0f;
        this.dismissEnabled = false;
        this.dismissFromDragPending = false;
        this.settleState = SheetSettleState.HIDDEN;
        P(this, false, 1, null);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
        if (iVar4 != null) {
            iVar4.d();
        }
        setBottomAnchorEnabled(false);
        View sheet2 = getSheet();
        if (sheet2 == null || !isLaidOut() || sheet2.getWidth() <= 0 || getHeight() <= 0) {
            if (onProgress != null) {
                onProgress.invoke(fValueOf);
            }
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        boolean z10 = bottomWidthPinchDp > 0.0f;
        q1();
        sheet2.setScaleX(z10 ? fE : 1.0f);
        sheet2.setScaleY(1.0f);
        CollapseClipGeometry collapseClipGeometryS = S(z10);
        if (collapseClipGeometryS == null) {
            if (onProgress != null) {
                onProgress.invoke(fValueOf);
            }
            if (onEnd != null) {
                onEnd.invoke();
                return;
            }
            return;
        }
        float fE2 = z10 ? C5685n.e(sheet2.getWidth() * fE, 1.0f) : C5685n.e(getWidth(), 1.0f);
        boolean z11 = z10;
        float startHeight = collapseClipGeometryS.getStartHeight();
        float dimension = getResources().getDimension(R$dimen.ail_nav_handle_width);
        float endHeight = collapseClipGeometryS.getEndHeight();
        float centerX = collapseClipGeometryS.getCenterX();
        float centerY = collapseClipGeometryS.getCenterY();
        float endOffsetY = collapseClipGeometryS.getEndOffsetY();
        float dimension2 = getResources().getDimension(R$dimen.ail_nav_handle_radius);
        float dimension3 = getResources().getDimension(R$dimen.ail_sheet_corner);
        SheetSpring sheetSpringQ = i0.INSTANCE.q();
        if (z11) {
            dimension2 = dimension3;
        }
        this.exitMorphing = true;
        float f10 = dimension2;
        this.collapseClipAnim = com.stepos.ailauncher.sheet.internal.p.INSTANCE.m(this, sheet2, fE2, dimension, startHeight, endHeight, centerX, centerY, (295698432 & 256) != 0 ? 0.0f : 0.0f, endOffsetY, f10, f10, scaleStiffness, scaleDampingRatio, offsetStiffness, offsetDampingRatio, sheetSpringQ.getStiffness(), sheetSpringQ.getDampingRatio(), (262144 & 295698432) != 0 ? offsetStiffness : 0.0f, (524288 & 295698432) != 0 ? offsetDampingRatio : 0.0f, (1048576 & 295698432) != 0 ? 0.0f : 0.0f, (2097152 & 295698432) != 0 ? 0.0f : 0.0f, (4194304 & 295698432) != 0 ? false : false, (8388608 & 295698432) != 0 ? 0.0f : bottomWidthPinchDp > 0.0f ? getResources().getDisplayMetrics().density * bottomWidthPinchDp : 0.0f, (16777216 & 295698432) != 0 ? 0.0f : z11 ? fE2 / 256.0f : 0.0f, (33554432 & 295698432) != 0 ? null : scaleContent ? this.contentAnchorView : null, (67108864 & 295698432) != 0 ? null : null, (134217728 & 295698432) != 0 ? null : onProgress, (295698432 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : onCollapsedToBar, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DraggableSheetLayout.b1(onEnd);
            }
        });
    }

    public final void b0() {
        p.a aVar = this.collapseClipAnim;
        this.collapseClipAnim = null;
        if (aVar != null) {
            aVar.a();
        }
        C3447f.a aVar2 = this.bloomAnim;
        this.bloomAnim = null;
        if (aVar2 != null) {
            aVar2.a();
        }
        this._scaleEnterRunning.setValue(Boolean.FALSE);
        this.exitMorphing = false;
        setBottomAnchorEnabled(true);
        q1();
        View sheet = getSheet();
        if (sheet == null) {
            return;
        }
        sheet.setScaleX(this.stackScale);
        sheet.setScaleY(this.stackScale);
        if (isLaidOut()) {
            L();
        }
    }

    public final void c0() {
        if (this.morphFreeze) {
            this.morphFreeze = false;
            if (isLaidOut()) {
                L();
            }
        }
    }

    public final Animator c1(final InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onEnd) {
        this.dismissEnabled = false;
        this.settleState = SheetSettleState.HIDDEN;
        P(this, false, 1, null);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        final float f10 = this.sheetOffset;
        final float fM0 = m0() + this.lastImeLift;
        if (getSheet() != null) {
            float f11 = fM0 - f10;
            if (f11 > 1.0f) {
                long jO = C5685n.o((long) (280 * (f11 / C5685n.e(m0() - j0(), 1.0f))), EXIT_SLIDE_MIN_DURATION_MS, 280L);
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setDuration(jO);
                valueAnimatorOfFloat.setInterpolator(EXIT_SLIDE_INTERPOLATOR);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.sheet.widget.h
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DraggableSheetLayout.e1(this.f28226a, f10, fM0, onProgress, valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new e(ref$BooleanRef, this, fM0, onProgress, onEnd));
                valueAnimatorOfFloat.start();
                return valueAnimatorOfFloat;
            }
        }
        this.sheetOffset = fM0;
        L();
        if (onProgress != null) {
            onProgress.invoke(Float.valueOf(1.0f));
        }
        if (onEnd != null) {
            onEnd.invoke();
        }
        return null;
    }

    public final void d0() {
        View sheet;
        if (this.bottomAnchorEnabled && isLaidOut() && (sheet = getSheet()) != null) {
            A(sheet);
        }
    }

    public final boolean e0() {
        return this.bloomAnim != null;
    }

    public final long f0() throws Resources.NotFoundException {
        CollapseClipGeometry collapseClipGeometryS = S(true);
        if (collapseClipGeometryS == null) {
            return 0L;
        }
        i0 i0Var = i0.INSTANCE;
        float stiffness = i0Var.o().getStiffness();
        float dampingRatio = i0Var.o().getDampingRatio();
        return Math.max(v0.b(stiffness, dampingRatio, collapseClipGeometryS.getStartHeight(), collapseClipGeometryS.getEndHeight(), 0.0f, 16, null), v0.b(stiffness, dampingRatio, 0.0f, collapseClipGeometryS.getEndOffsetY(), 0.0f, 16, null));
    }

    public final void f1(float stiffness, float dampingRatio, Float travelDistancePx, final InterfaceC5074l<? super Float, Y8.t> onProgress, final InterfaceC5063a<Y8.t> onEnd) {
        this.dismissEnabled = false;
        this.settleState = SheetSettleState.HIDDEN;
        P(this, false, 1, null);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
        if (iVar4 != null) {
            iVar4.d();
        }
        final float f10 = this.sheetOffset;
        float fFloatValue = travelDistancePx != null ? travelDistancePx.floatValue() + f10 : m0() + this.lastImeLift;
        if (getSheet() != null) {
            final float f11 = fFloatValue - f10;
            if (f11 > 1.0f) {
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                androidx.dynamicanimation.animation.i iVar5 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(f10));
                iVar5.B(new androidx.dynamicanimation.animation.j(fFloatValue).h(stiffness).f(dampingRatio));
                iVar5.c(new e.r() { // from class: com.stepos.ailauncher.sheet.widget.e
                    @Override // androidx.dynamicanimation.animation.e.r
                    public final void b(androidx.dynamicanimation.animation.e eVar, float f12, float f13) {
                        DraggableSheetLayout.g1(this.f28216a, f10, f11, ref$FloatRef, onProgress, eVar, f12, f13);
                    }
                });
                iVar5.b(new e.q() { // from class: com.stepos.ailauncher.sheet.widget.f
                    @Override // androidx.dynamicanimation.animation.e.q
                    public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f12, float f13) {
                        DraggableSheetLayout.h1(this.f28221a, onProgress, onEnd, eVar, z10, f12, f13);
                    }
                });
                iVar5.t();
                this.settleAnim = iVar5;
                return;
            }
        }
        this.sheetOffset = fFloatValue;
        L();
        if (onProgress != null) {
            onProgress.invoke(Float.valueOf(1.0f));
        }
        if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void g0(View view) {
        view.forceLayout();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                g0(childAt);
            }
        }
    }

    public final boolean getAllowCollapseToHalf() {
        return this.allowCollapseToHalf;
    }

    public final boolean getBottomAnchorEnabled() {
        return this.bottomAnchorEnabled;
    }

    public final a getCallback() {
        return this.callback;
    }

    public final boolean getChromeTransparent() {
        return this.chromeTransparent;
    }

    public final View getContentAnchorView() {
        return this.contentAnchorView;
    }

    /* renamed from: getCurrentState, reason: from getter */
    public final SheetSettleState getSettleState() {
        return this.settleState;
    }

    public final boolean getDismissEnabled() {
        return this.dismissEnabled;
    }

    public final boolean getDragEnabled() {
        return this.dragEnabled;
    }

    public final View getDragHandleView() {
        return this.dragHandleView;
    }

    public final View getDragPriorityView() {
        return this.dragPriorityView;
    }

    public final float getFastDismissVelocityPx() {
        return this.fastDismissVelocityPx;
    }

    public final InterfaceC5063a<Boolean> getFloatingPanelTouchTransparentGate() {
        return this.floatingPanelTouchTransparentGate;
    }

    public final boolean getFreezeContentHeightOnFullDrag() {
        return this.freezeContentHeightOnFullDrag;
    }

    public final int getFullTopDragStripHeightPx() {
        return this.fullTopDragStripHeightPx;
    }

    public final float getFullTopRatio() {
        return this.fullTopRatio;
    }

    public final InterfaceC5074l<View, Boolean> getHalfExpandContentAtBottom() {
        return this.halfExpandContentAtBottom;
    }

    public final float getHalfFullFraction() {
        float fL0 = l0() - j0();
        if (fL0 <= 0.0f) {
            return 1.0f;
        }
        return C5685n.m((l0() - F0()) / fL0, 0.0f, 1.0f);
    }

    public final float getHalfTopRatio() {
        return this.halfTopRatio;
    }

    public final InterfaceC3456j getHandleBoundsProvider() {
        return this.handleBoundsProvider;
    }

    public final SheetHeightMode getHeightMode() {
        return this.heightMode;
    }

    public final float getImeInsetPx() {
        return this.imeInsetPx;
    }

    public final float getImmersiveFraction() {
        float fJ0 = j0() - p0();
        if (fJ0 <= 0.0f) {
            return 0.0f;
        }
        return C5685n.m(1.0f - ((F0() - p0()) / fJ0), 0.0f, 1.0f);
    }

    public final float getImmersiveTopRatio() {
        return this.immersiveTopRatio;
    }

    public final float getMinPanelTopForImePx() {
        return this.minPanelTopForImePx;
    }

    public final View getMinifyContentView() {
        return this.minifyContentView;
    }

    public final float getMinifyTopRatio() {
        return this.minifyTopRatio;
    }

    public final float getPanelTopPx() {
        return F0();
    }

    public final Xa.t<Boolean> getScaleEnterRunning() {
        return this.scaleEnterRunning;
    }

    public final boolean getSealHorizontalGesture() {
        return this.sealHorizontalGesture;
    }

    public final boolean getStackBackgroundColorAlphaEnabled() {
        return this.stackBackgroundColorAlphaEnabled;
    }

    public final boolean getStackBackgroundPreserveOpacity() {
        return this.stackBackgroundPreserveOpacity;
    }

    public final boolean getStackPeekSuppressed() {
        return this.stackPeekSuppressed;
    }

    public final SheetSettleState getStateForExit() {
        return c0.a(this.settleState, this._scaleEnterRunning.getValue().booleanValue(), this.anchorTargetState);
    }

    public final int getTopDragStripHeightPx() {
        return this.topDragStripHeightPx;
    }

    public final float getTouchAxisLockRatio() {
        return this.touchAxisLockRatio;
    }

    public final InterfaceC5063a<View> getTouchScrollableContentProvider() {
        return this.touchScrollableContentProvider;
    }

    public final boolean getUseFullDragThreshold() {
        return this.useFullDragThreshold;
    }

    public final InterfaceC5063a<Boolean> getUserDragGate() {
        return this.userDragGate;
    }

    public final Float h0() {
        View sheet = getSheet();
        if (sheet == null || !isLaidOut() || getHeight() <= 0 || this.sharedExitStartY != null) {
            return null;
        }
        float translationY = sheet.getTranslationY();
        float scaleX = sheet.getScaleX();
        float scaleY = sheet.getScaleY();
        float alpha = sheet.getAlpha();
        float pivotX = sheet.getPivotX();
        float pivotY = sheet.getPivotY();
        this.sharedExitStartY = Float.valueOf(translationY);
        O(true);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimY;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
        if (iVar4 != null) {
            iVar4.d();
        }
        sheet.setScaleX(scaleX);
        sheet.setScaleY(scaleY);
        sheet.setAlpha(alpha);
        sheet.setPivotX(pivotX);
        sheet.setPivotY(pivotY);
        sheet.setTranslationY(translationY);
        return Float.valueOf(C5685n.e(getHeight() - ((sheet.getTop() + translationY) + (pivotY * (1.0f - scaleY))), 0.0f) + (getResources().getDisplayMetrics().density * 2.0f));
    }

    public final RubberBandConfig i0() {
        float fE = C5685n.e(getWidth(), 1.0f);
        float fE2 = C5685n.e(l0() - j0(), 1.0f);
        if (this.settleState != SheetSettleState.FULL) {
            return new RubberBandConfig(0.0f, fE2, fE, fE, 0.0f, 0.0f, 48, null);
        }
        float fE3 = C5685n.e(getHeight() - j0(), 1.0f);
        float f10 = fE3 * 0.25f;
        return new RubberBandConfig(f10, C5685n.e((fE3 * FULL_DRAG_RUBBER_FRACTION) + f10, 1.0f + f10), fE, fE * FULL_DRAG_SIZE_X_END_FRACTION, 0.0f, 0.0f, 48, null);
    }

    public final Animator i1(final InterfaceC5074l<? super Float, Y8.t> onProgress, InterfaceC5063a<Y8.t> onEnd) {
        this.dismissEnabled = false;
        this.settleState = SheetSettleState.HIDDEN;
        P(this, false, 1, null);
        androidx.dynamicanimation.animation.i iVar = this.stackScaleAnimX;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.stackPeekAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackAlphaAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        this.stackScale = 1.0f;
        this.stackAlpha = 1.0f;
        L();
        View sheet = getSheet();
        if (sheet != null) {
            return B.f(B.INSTANCE, sheet, this.handleBoundsProvider, 0L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.widget.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DraggableSheetLayout.j1(this.f28214a, onProgress, ((Float) obj).floatValue());
                }
            }, onEnd, 4, null);
        }
        if (onEnd != null) {
            onEnd.invoke();
        }
        return null;
    }

    public final float j0() {
        return getHeight() * this.fullTopRatio;
    }

    public final float k0() {
        return l0() - (this.touchSlop * 2.0f);
    }

    public final void k1() {
        if (!w0() || !this.useFullDragThreshold) {
            Q();
            return;
        }
        float fE = C5685n.e(this.sheetOffset - t1(), 0.0f);
        RubberBandConfig rubberBandConfigI0 = i0();
        float fM = C5685n.m(X.b(fE, rubberBandConfigI0), 0.0f, rubberBandConfigI0.getCommitB());
        this.fullDragRawPull = fM;
        this.rubberBandScaleX = rubberBandConfigI0.getWidthA() > 0.0f ? X.a(fM, 0.0f, rubberBandConfigI0).getSizeX() / rubberBandConfigI0.getWidthA() : 1.0f;
    }

    public final float l0() {
        return getHeight() * this.halfTopRatio;
    }

    public final void l1(int heightMeasureSpec) {
        int width;
        View view = this.minifyContentView;
        if (view != null && this.bottomAnchorEnabled) {
            int size = 0;
            if (view.getWidth() > 0) {
                width = view.getWidth();
            } else {
                View view2 = this.contentAnchorView;
                if ((view2 != null ? view2.getWidth() : 0) > 0) {
                    View view3 = this.contentAnchorView;
                    kotlin.jvm.internal.p.f(view3);
                    width = view3.getWidth();
                } else {
                    width = 0;
                }
            }
            if (width <= 0) {
                return;
            }
            if (getHeight() > 0) {
                size = getHeight();
            } else if (View.MeasureSpec.getMode(heightMeasureSpec) != 0) {
                size = View.MeasureSpec.getSize(heightMeasureSpec);
            }
            if (size <= 0) {
                return;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE));
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight > 0) {
                this.cachedMinifyIntrinsic = measuredHeight;
            }
        }
    }

    public final float m0() {
        return getHeight();
    }

    public final void m1() {
        if (!this.reanchoringMinify && this.minifyContentView != null && this.bottomAnchorEnabled && getHeight() > 0 && this.settleState == SheetSettleState.MINIFY && !this.dragging) {
            androidx.dynamicanimation.animation.i iVar = this.settleAnim;
            if (iVar == null || !iVar.i()) {
                float fA0 = A0();
                if (Math.abs(fA0 - this.sheetOffset) <= 1.0f) {
                    return;
                }
                this.reanchoringMinify = true;
                this.sheetOffset = fA0;
                L();
                C0();
                this.reanchoringMinify = false;
            }
        }
    }

    public final boolean n0(View view, float rawX, float rawY, int direction) {
        if (view.getVisibility() != 0) {
            return false;
        }
        view.getLocationOnScreen(this.tmpLocation);
        float f10 = rawX - r0[0];
        float f11 = rawY - r0[1];
        if (f10 >= 0.0f && f11 >= 0.0f && f10 <= view.getWidth() && f11 <= view.getHeight()) {
            if (!(view instanceof InterfaceC1333v) && !(view instanceof InterfaceC1331t) && !(view instanceof InterfaceC1332u) && view.canScrollVertically(direction)) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                    if (n0(childAt, rawX, rawY, direction)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void n1() {
        if (this.sharedExitStartY == null) {
            return;
        }
        this.sharedExitStartY = null;
        this.homeGroupExitOffsetY = 0.0f;
        L();
    }

    public final float o0(float baseTop) {
        if (!this.bottomAnchorEnabled) {
            return this.lastImeLift;
        }
        if (this.imeInsetPx <= 0.0f) {
            this.lastImeLift = 0.0f;
            return 0.0f;
        }
        SheetSettleState effectiveSettleState = getEffectiveSettleState();
        float fU = (effectiveSettleState == SheetSettleState.FULL || effectiveSettleState == SheetSettleState.IMMERSIVE) ? U(L1(effectiveSettleState)) : 0.0f;
        float fE = C5685n.e(baseTop - this.minPanelTopForImePx, 0.0f);
        float f10 = this.imeInsetPx;
        float fM = C5685n.m(f10 - fU, 0.0f, Math.min(f10, fE));
        this.lastImeLift = fM;
        return fM;
    }

    public final void o1() {
        if (this.dismissFromDragPending || !this.dismissEnabled) {
            return;
        }
        this.dismissFromDragPending = true;
        a aVar = this.callback;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.stackBackgroundColorAlphaEnabled) {
            getViewTreeObserver().addOnPreDrawListener(this.stackBackgroundPreDraw);
        }
        J();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getViewTreeObserver().removeOnPreDrawListener(this.stackBackgroundPreDraw);
        androidx.dynamicanimation.animation.i iVar = this.settleAnim;
        if (iVar != null) {
            iVar.d();
        }
        N();
        androidx.dynamicanimation.animation.i iVar2 = this.stackScaleAnimX;
        if (iVar2 != null) {
            iVar2.d();
        }
        androidx.dynamicanimation.animation.i iVar3 = this.stackPeekAnim;
        if (iVar3 != null) {
            iVar3.d();
        }
        androidx.dynamicanimation.animation.i iVar4 = this.stackAlphaAnim;
        if (iVar4 != null) {
            iVar4.d();
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        this.nestedScrollInProgress = false;
        this.nestedSheetDragged = false;
        this.nestedContentScrolled = false;
        this.nestedFlingVelocityY = 0.0f;
        this.contentOverscroll.j();
        this.panelBackgroundAlpha.c();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    @Override // android.view.ViewGroup
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r6, r0)
            boolean r0 = r5.dismissEnabled
            r1 = 0
            if (r0 == 0) goto Lac
            boolean r0 = r5.dragEnabled
            if (r0 != 0) goto L10
            goto Lac
        L10:
            boolean r0 = r5.K1()
            if (r0 == 0) goto L17
            return r1
        L17:
            int r0 = r6.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L4b
            if (r0 == r2) goto L3b
            r3 = 2
            if (r0 == r3) goto L28
            r6 = 3
            if (r0 == r6) goto L3b
            goto La3
        L28:
            boolean r0 = r5.allowDragGesture
            if (r0 != 0) goto L2d
            return r1
        L2d:
            android.view.VelocityTracker r0 = r5.velocityTracker
            if (r0 == 0) goto L34
            r0.addMovement(r6)
        L34:
            boolean r6 = r5.s1(r6)
            if (r6 == 0) goto La3
            return r2
        L3b:
            r5.allowDragGesture = r1
            android.view.VelocityTracker r6 = r5.velocityTracker
            if (r6 == 0) goto L44
            r6.recycle()
        L44:
            r6 = 0
            r5.velocityTracker = r6
            r5.p1()
            goto La3
        L4b:
            androidx.dynamicanimation.animation.i r0 = r5.settleAnim
            if (r0 == 0) goto L52
            r0.d()
        L52:
            r5.k1()
            float r0 = r6.getRawX()
            r5.downX = r0
            float r0 = r6.getRawY()
            r5.downY = r0
            float r0 = r6.getRawY()
            r5.lastY = r0
            r5.p1()
            float r0 = r6.getRawX()
            float r3 = r6.getRawY()
            boolean r0 = r5.A1(r0, r3)
            if (r0 == 0) goto L80
            boolean r0 = r5.e0()
            if (r0 != 0) goto L80
            r0 = r2
            goto L81
        L80:
            r0 = r1
        L81:
            r5.allowDragGesture = r0
            float r0 = r6.getRawX()
            float r3 = r6.getRawY()
            android.view.View r4 = r5.dragPriorityView
            boolean r0 = r5.v0(r0, r3, r4)
            r5.dragPriorityGesture = r0
            android.view.VelocityTracker r0 = r5.velocityTracker
            if (r0 == 0) goto L9a
            r0.recycle()
        L9a:
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r0.addMovement(r6)
            r5.velocityTracker = r0
        La3:
            boolean r6 = r5.dragging
            if (r6 == 0) goto Lac
            int r5 = r5.touchAxis
            if (r5 != r2) goto Lac
            return r2
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        m1();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        l1(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        kotlin.jvm.internal.p.i(target, "target");
        this.nestedFlingVelocityY = -velocityY;
        return this.nestedSheetDragged || this.contentOverscroll.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    @Override // androidx.core.view.InterfaceC1335x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onNestedPreScroll(android.view.View r7, int r8, int r9, int[] r10, int r11) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.onNestedPreScroll(android.view.View, int, int, int[], int):void");
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        if (type != 0) {
            return;
        }
        if (dyConsumed != 0) {
            this.nestedContentScrolled = true;
        }
        if (dyUnconsumed == 0) {
            return;
        }
        if (this.nestedSheetDragged) {
            if (!s0()) {
                consumed[1] = consumed[1] + dyUnconsumed;
                return;
            }
            float fY = Y(-dyUnconsumed);
            int i10 = consumed[1];
            if (fY != 0.0f) {
                dyUnconsumed = -C5227b.b(fY);
            }
            consumed[1] = i10 + dyUnconsumed;
            return;
        }
        if (dyUnconsumed < 0 && this.nestedContentScrolled && !u0()) {
            if (this.contentOverscroll.e(target, -dyUnconsumed)) {
                consumed[1] = consumed[1] + dyUnconsumed;
                return;
            }
            return;
        }
        if (!s0()) {
            if (this.contentOverscroll.e(target, -dyUnconsumed)) {
                consumed[1] = consumed[1] + dyUnconsumed;
                return;
            }
            return;
        }
        if (dyUnconsumed <= 0 || this.settleState != SheetSettleState.HALF || this.fullDragRawPull > 0.5f || this.sheetOffset > l0() + 0.5f || target.canScrollVertically(-1)) {
            float f10 = -dyUnconsumed;
            float fY2 = Y(f10);
            if (fY2 != 0.0f) {
                this.nestedSheetDragged = true;
                consumed[1] = consumed[1] + (-C5227b.b(fY2));
            } else if (this.contentOverscroll.e(target, f10)) {
                consumed[1] = consumed[1] + dyUnconsumed;
            }
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        this.nestedScrollingHelper.c(child, target, axes, type);
        androidx.dynamicanimation.animation.i iVar = this.settleAnim;
        if (iVar != null) {
            iVar.d();
        }
        k1();
        this.nestedScrollInProgress = true;
        this.nestedSheetDragged = false;
        this.nestedContentScrolled = false;
        this.nestedFlingVelocityY = 0.0f;
        this.dragGateBlocked = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        SheetSettleState sheetSettleState;
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (h10 <= 0 || (sheetSettleState = this.settleState) == SheetSettleState.HIDDEN || this.dragging) {
            return;
        }
        y1(this, sheetSettleState, false, null, 4, null);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        if (!this.dismissEnabled || this.dismissFromDragPending || K1() || e0() || type != 0 || (axes & 2) == 0 || q0(this.downX, this.downY)) {
            return false;
        }
        return this.dragHandleView == null || !A1(this.downX, this.downY);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View target, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        this.nestedScrollingHelper.e(target, type);
        if (type != 0) {
            return;
        }
        this.nestedScrollInProgress = false;
        this.nestedContentScrolled = false;
        this.contentOverscroll.g();
        if (this.nestedSheetDragged) {
            this.nestedSheetDragged = false;
            settleOrDismiss(this.nestedFlingVelocityY);
        }
        this.nestedFlingVelocityY = 0.0f;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (!this.dismissEnabled || !this.dragEnabled) {
            return false;
        }
        if (K1()) {
            InterfaceC5063a<Boolean> interfaceC5063a = this.floatingPanelTouchTransparentGate;
            if (interfaceC5063a == null || !interfaceC5063a.invoke().booleanValue()) {
                return event.getActionMasked() != 0 || event.getY() >= F0();
            }
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            if (event.getY() < F0()) {
                return false;
            }
            androidx.dynamicanimation.animation.i iVar = this.settleAnim;
            if (iVar != null) {
                iVar.d();
            }
            k1();
            this.downX = event.getRawX();
            this.downY = event.getRawY();
            this.lastY = event.getRawY();
            p1();
            this.allowDragGesture = A1(event.getRawX(), event.getRawY());
            this.dragPriorityGesture = v0(event.getRawX(), event.getRawY(), this.dragPriorityView);
            if (!this.allowDragGesture) {
                return false;
            }
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            velocityTrackerObtain.addMovement(event);
            this.velocityTracker = velocityTrackerObtain;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (!this.allowDragGesture) {
                    return false;
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                int i10 = this.touchAxis;
                if (i10 == -1 || i10 == -2) {
                    return false;
                }
                if (i10 == 0) {
                    if (!s1(event)) {
                        return this.touchAxis == 0;
                    }
                    this.lastY = event.getRawY();
                    return true;
                }
                float rawY = event.getRawY() - this.lastY;
                this.lastY = event.getRawY();
                Y(rawY);
                return true;
            }
            if (actionMasked != 3) {
                return super.onTouchEvent(event);
            }
        }
        if (!this.allowDragGesture) {
            return false;
        }
        boolean z10 = this.touchAxis == 1 && this.dragging;
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(event);
        }
        if (z10) {
            VelocityTracker velocityTracker4 = this.velocityTracker;
            if (velocityTracker4 != null) {
                velocityTracker4.computeCurrentVelocity(1000);
            }
            VelocityTracker velocityTracker5 = this.velocityTracker;
            settleOrDismiss(velocityTracker5 != null ? velocityTracker5.getYVelocity() : 0.0f);
        }
        this.allowDragGesture = false;
        VelocityTracker velocityTracker6 = this.velocityTracker;
        if (velocityTracker6 != null) {
            velocityTracker6.recycle();
        }
        this.velocityTracker = null;
        p1();
        return true;
    }

    public final float p0() {
        return getHeight() * this.immersiveTopRatio;
    }

    public final void p1() {
        this.touchAxis = 0;
        this.dragging = false;
        this.dragPriorityGesture = false;
        this.dragGateBlocked = false;
    }

    public final boolean q0(float rawX, float rawY) {
        int iIntValue;
        View sheet;
        int i10 = d.$EnumSwitchMapping$0[this.settleState.ordinal()];
        if (i10 != 1) {
            iIntValue = i10 != 2 ? 0 : this.topDragStripHeightPx;
        } else {
            Integer numValueOf = Integer.valueOf(this.fullTopDragStripHeightPx);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            iIntValue = numValueOf != null ? numValueOf.intValue() : this.topDragStripHeightPx;
        }
        if (iIntValue <= 0) {
            return false;
        }
        View view = this.dragHandleView;
        if ((view != null && (!view.isAttachedToWindow() || view.getVisibility() != 0)) || (sheet = getSheet()) == null || !sheet.isAttachedToWindow()) {
            return false;
        }
        sheet.getLocationOnScreen(this.tmpLocation);
        int[] iArr = this.tmpLocation;
        float f10 = rawX - iArr[0];
        float f11 = rawY - iArr[1];
        return f10 >= 0.0f && f11 >= 0.0f && f10 <= ((float) sheet.getWidth()) && f11 <= ((float) iIntValue);
    }

    public final void q1() {
        L l10 = this.scaleEnterBottomClip;
        if (l10 != null) {
            l10.c();
        }
        this.scaleEnterBottomClip = null;
        View sheet = getSheet();
        if (sheet != null) {
            R(sheet);
        }
        v1(this, 1.0f, 0.0f, 2, null);
        this.transitionScaleActive = false;
        this.transitionPivotYFraction = 0.0f;
        this.transitionPinScreenBottom = false;
        this.clipEnterOvershootExtend = false;
        Q();
    }

    /* renamed from: r0, reason: from getter */
    public final boolean getDismissFromDragPending() {
        return this.dismissFromDragPending;
    }

    public final SheetScaleMotion r1(SheetScaleMotion base) {
        kotlin.jvm.internal.p.i(base, "base");
        View sheet = getSheet();
        if (sheet != null) {
            int width = getWidth();
            int height = sheet.getHeight();
            if (width > 0 && height > 0) {
                HandleBounds handleBoundsA = this.handleBoundsProvider.a(this);
                getLocationOnScreen(new int[2]);
                float bottom = handleBoundsA.getBottom() - r6[1];
                float f10 = width;
                float fM = C5685n.m(handleBoundsA.h() / f10, 0.01f, 1.0f);
                float f11 = height;
                float fM2 = C5685n.m(handleBoundsA.d() / f11, 0.01f, 1.0f);
                return SheetScaleMotion.b(base, null, null, fM, C5685n.e((bottom - ((f11 * (1.0f - fM2)) / 2.0f)) - sheet.getTranslationY(), 0.0f) / f10, fM2, 3, null);
            }
        }
        return base;
    }

    public final boolean s0() {
        if (this.dragGateBlocked) {
            return false;
        }
        InterfaceC5063a<Boolean> interfaceC5063a = this.userDragGate;
        if (interfaceC5063a == null) {
            return true;
        }
        boolean zBooleanValue = interfaceC5063a.invoke().booleanValue();
        if (!zBooleanValue) {
            this.dragGateBlocked = true;
        }
        return zBooleanValue;
    }

    public final boolean s1(MotionEvent ev) {
        if (this.nestedScrollInProgress) {
            this.touchAxis = -2;
            return false;
        }
        int i10 = this.touchAxis;
        if (i10 == -2 || i10 == -3 || i10 == -1) {
            return false;
        }
        if (i10 == 1) {
            return true;
        }
        float rawX = ev.getRawX() - this.downX;
        float rawY = ev.getRawY() - this.downY;
        float fAbs = Math.abs(rawX);
        float fAbs2 = Math.abs(rawY);
        int i11 = this.touchSlop;
        if (fAbs <= i11 && fAbs2 <= i11) {
            return false;
        }
        float f10 = this.touchAxisLockRatio;
        if (fAbs > fAbs2 * f10) {
            this.touchAxis = -1;
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.sealHorizontalGesture);
            }
            return false;
        }
        if (fAbs2 <= fAbs * f10) {
            return false;
        }
        if ((!A1(ev.getRawX(), ev.getRawY()) || (this.dragHandleView == null && !q0(ev.getRawX(), ev.getRawY()))) && !this.dragPriorityGesture) {
            if (T(ev, rawY > 0.0f ? -1 : 1)) {
                this.touchAxis = -3;
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        }
        SheetSettleState sheetSettleState = this.settleState;
        SheetSettleState sheetSettleState2 = SheetSettleState.HALF;
        boolean z10 = (sheetSettleState == sheetSettleState2 || sheetSettleState == SheetSettleState.MINIFY) && rawY < 0.0f;
        boolean z11 = (sheetSettleState == SheetSettleState.FULL || sheetSettleState == sheetSettleState2) && rawY > 0.0f;
        boolean z12 = rawY > 0.0f;
        if (!z10 && !z11 && !z12) {
            this.touchAxis = -1;
            return false;
        }
        if (!s0()) {
            this.touchAxis = -1;
            return false;
        }
        this.touchAxis = 1;
        this.dragging = true;
        ViewParent parent3 = getParent();
        if (parent3 != null) {
            parent3.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public final void setAllowCollapseToHalf(boolean z10) {
        this.allowCollapseToHalf = z10;
    }

    public final void setBottomAnchorEnabled(boolean z10) {
        this.bottomAnchorEnabled = z10;
        if (isLaidOut()) {
            L();
        }
    }

    public final void setCallback(a aVar) {
        this.callback = aVar;
    }

    public final void setChromeTransparent(boolean z10) {
        this.chromeTransparent = z10;
    }

    public final void setContentAnchorView(View view) {
        this.contentAnchorView = view;
        if (isLaidOut()) {
            L();
        }
    }

    public final void setDismissEnabled(boolean z10) {
        this.dismissEnabled = z10;
    }

    public final void setDragEnabled(boolean z10) {
        this.dragEnabled = z10;
    }

    public final void setDragHandleView(View view) {
        this.dragHandleView = view;
    }

    public final void setDragPriorityView(View view) {
        this.dragPriorityView = view;
    }

    public final void setFastDismissVelocityPx(float f10) {
        this.fastDismissVelocityPx = f10;
    }

    public final void setFloatingPanelTouchTransparentGate(InterfaceC5063a<Boolean> interfaceC5063a) {
        this.floatingPanelTouchTransparentGate = interfaceC5063a;
    }

    public final void setFreezeContentHeightOnFullDrag(boolean z10) {
        this.freezeContentHeightOnFullDrag = z10;
    }

    public final void setFullTopDragStripHeightPx(int i10) {
        this.fullTopDragStripHeightPx = i10;
    }

    public final void setFullTopRatio(float f10) {
        this.fullTopRatio = f10;
    }

    public final void setHalfExpandContentAtBottom(InterfaceC5074l<? super View, Boolean> interfaceC5074l) {
        this.halfExpandContentAtBottom = interfaceC5074l;
    }

    public final void setHalfTopRatio(float f10) {
        this.halfTopRatio = f10;
    }

    public final void setHandleBoundsProvider(InterfaceC3456j interfaceC3456j) {
        kotlin.jvm.internal.p.i(interfaceC3456j, "<set-?>");
        this.handleBoundsProvider = interfaceC3456j;
    }

    public final void setHeightMode(SheetHeightMode value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.heightMode = value;
        if (isLaidOut()) {
            D1(false);
        }
    }

    public final void setHomeGroupExitOffsetY(float offsetY) {
        if (this.homeGroupExitOffsetY == offsetY) {
            return;
        }
        this.homeGroupExitOffsetY = offsetY;
        if (isLaidOut()) {
            L();
        }
    }

    public final void setImeInsetPx(float f10) {
        if (this.imeInsetPx == f10) {
            return;
        }
        this.imeInsetPx = f10;
        if (isLaidOut()) {
            L();
        }
    }

    public final void setImmersiveTopRatio(float f10) {
        this.immersiveTopRatio = f10;
    }

    public final void setMinPanelTopForImePx(float f10) {
        this.minPanelTopForImePx = f10;
    }

    public final void setMinifyContentView(View view) {
        if (this.minifyContentView == view) {
            return;
        }
        this.minifyContentView = view;
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public final void setMinifyTopRatio(float f10) {
        this.minifyTopRatio = f10;
    }

    public final void setSealHorizontalGesture(boolean z10) {
        this.sealHorizontalGesture = z10;
    }

    public final void setStackBackgroundColorAlphaEnabled(boolean z10) {
        if (this.stackBackgroundColorAlphaEnabled == z10) {
            return;
        }
        this.stackBackgroundColorAlphaEnabled = z10;
        if (isAttachedToWindow()) {
            if (z10) {
                getViewTreeObserver().addOnPreDrawListener(this.stackBackgroundPreDraw);
            } else {
                getViewTreeObserver().removeOnPreDrawListener(this.stackBackgroundPreDraw);
            }
        }
        if (z10) {
            J();
        } else {
            this.panelBackgroundAlpha.c();
        }
    }

    public final void setStackBackgroundPreserveOpacity(boolean z10) {
        if (this.stackBackgroundPreserveOpacity == z10) {
            return;
        }
        this.stackBackgroundPreserveOpacity = z10;
        J();
    }

    public final void setStackPeekSuppressed(boolean z10) {
        if (this.stackPeekSuppressed == z10) {
            return;
        }
        this.stackPeekSuppressed = z10;
        L();
    }

    public final void setTopDragStripHeightPx(int i10) {
        this.topDragStripHeightPx = i10;
    }

    public final void setTouchAxisLockRatio(float f10) {
        this.touchAxisLockRatio = f10;
    }

    public final void setTouchScrollableContentProvider(InterfaceC5063a<? extends View> interfaceC5063a) {
        this.touchScrollableContentProvider = interfaceC5063a;
    }

    public final void setUseFullDragThreshold(boolean z10) {
        this.useFullDragThreshold = z10;
    }

    public final void setUserDragGate(InterfaceC5063a<Boolean> interfaceC5063a) {
        this.userDragGate = interfaceC5063a;
    }

    public final boolean t0() {
        return C1();
    }

    public final float t1() {
        return this.settleState == SheetSettleState.HALF ? l0() : j0();
    }

    public final boolean u0() {
        if (this.settleState == SheetSettleState.HALF) {
            return this.nestedSheetDragged || this.sheetOffset < l0() - 0.5f;
        }
        return false;
    }

    public final void u1(float x10, float y10) {
        this.transitionScaleX = x10;
        this.transitionScaleY = y10;
    }

    public final boolean w0() {
        SheetSettleState sheetSettleState = this.settleState;
        return sheetSettleState == SheetSettleState.FULL || sheetSettleState == SheetSettleState.HALF;
    }

    public final void w1(boolean flingUp, boolean flingDown) {
        float fL0 = (l0() + A0()) / 2.0f;
        int i10 = d.$EnumSwitchMapping$0[this.settleState.ordinal()];
        if (i10 == 1) {
            if (B1(flingDown)) {
                o1();
                return;
            } else {
                y1(this, SheetSettleState.FULL, true, null, 4, null);
                return;
            }
        }
        if (i10 == 2) {
            if (flingDown || this.fullDragRawPull >= i0().getCommitB() - 0.5f) {
                o1();
                return;
            } else if (flingUp || this.sheetOffset < k0()) {
                y1(this, SheetSettleState.FULL, true, null, 4, null);
                return;
            } else {
                y1(this, SheetSettleState.HALF, true, null, 4, null);
                return;
            }
        }
        if (i10 != 3) {
            if (i10 != 4 && i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (flingUp || this.sheetOffset < fL0) {
                y1(this, SheetSettleState.HALF, true, null, 4, null);
                return;
            }
            if (!E0() || this.sheetOffset <= A0()) {
                y1(this, SheetSettleState.MINIFY, true, null, 4, null);
                return;
            }
            a aVar = this.callback;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final boolean x0() {
        androidx.dynamicanimation.animation.i iVar = this.settleAnim;
        return (iVar != null && iVar.i()) || this.bloomAnim != null || this.collapseClipAnim != null || this._scaleEnterRunning.getValue().booleanValue();
    }

    public final void x1(final SheetSettleState state, boolean animate, final InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(state, "state");
        if (this.anchorTargetState != null || this.clipEnterCancelCleanup != null) {
            O(true);
            this.anchorTargetState = null;
        }
        this.dismissFromDragPending = false;
        Q();
        final float fL1 = L1(state);
        this.settleState = state;
        if (animate && getSheet() != null && isLaidOut()) {
            F1(this, fL1, 0.0f, 0.0f, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.widget.n
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DraggableSheetLayout.z1(this.f28249a, fL1, state, onEnd);
                }
            }, 14, null);
            return;
        }
        this.sheetOffset = fL1;
        L();
        C0();
        a aVar = this.callback;
        if (aVar != null) {
            aVar.b(state);
        }
        if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void y0(boolean forceDescendants) {
        View view;
        View sheet;
        if (!this.bottomAnchorEnabled || (view = this.contentAnchorView) == null || (sheet = getSheet()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i10 = layoutParams != null ? layoutParams.height : 0;
        if (i10 <= 0 || sheet.getWidth() <= 0) {
            return;
        }
        int width = view.getWidth() > 0 ? view.getWidth() : sheet.getWidth();
        if (!forceDescendants && !view.isLayoutRequested() && view.getMeasuredWidth() == width && view.getMeasuredHeight() == i10 && view.getWidth() == width && view.getHeight() == i10) {
            return;
        }
        if (forceDescendants) {
            g0(view);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        int left = view.getLeft();
        int top = view.getTop();
        view.layout(left, top, view.getMeasuredWidth() + left, view.getMeasuredHeight() + top);
    }

    public final float z(float ratioY) {
        View view;
        int i10;
        return (this.minifyContentView != null && this.bottomAnchorEnabled && getHeight() > 0 && (view = this.contentAnchorView) != null && (i10 = this.cachedMinifyIntrinsic) > 0) ? C5685n.m(((getHeight() - view.getTop()) - view.getPaddingBottom()) - i10, j0(), ratioY) : ratioY;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableSheetLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.dismissEnabled = true;
        this.handleBoundsProvider = C3437e.INSTANCE;
        this.useFullDragThreshold = true;
        this.heightMode = SheetHeightMode.FULL_9;
        this.allowCollapseToHalf = true;
        this.fullTopRatio = 0.1f;
        this.halfTopRatio = 0.5f;
        this.minifyTopRatio = 0.86f;
        this.cachedMinifyIntrinsic = -1;
        this.dragEnabled = true;
        this.fastDismissVelocityPx = getResources().getDisplayMetrics().density * 2200.0f;
        this.touchAxisLockRatio = 1.1f;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.minFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.rubberBandScaleX = 1.0f;
        this.tmpLocation = new int[2];
        this.stackScale = 1.0f;
        this.stackAlpha = 1.0f;
        this.panelBackgroundAlpha = new Z();
        this.stackBackgroundPreDraw = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.ailauncher.sheet.widget.c
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return DraggableSheetLayout.I1(this.f28213a);
            }
        };
        this.suppressedSettleEndAnimations = Collections.newSetFromMap(new IdentityHashMap());
        Xa.k<Boolean> kVarA = Xa.u.a(Boolean.FALSE);
        this._scaleEnterRunning = kVarA;
        this.scaleEnterRunning = Xa.d.c(kVarA);
        this.transitionScaleX = 1.0f;
        this.transitionScaleY = 1.0f;
        this.sheetOvershootBaseH = -1;
        this.sheetOvershootSavedLpH = -1;
        this.settleState = SheetSettleState.MINIFY;
        this.nestedScrollingHelper = new C1337z(this);
        this.contentOverscroll = new b();
        this.nestedConsumedScratch = new int[2];
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        int[] iArr = this.nestedConsumedScratch;
        iArr[0] = 0;
        iArr[1] = 0;
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, iArr);
    }

    public /* synthetic */ DraggableSheetLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
