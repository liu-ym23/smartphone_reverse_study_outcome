package com.stepos.agentsprite.view;

import L4.AgentEmotion;
import L4.AgentPlace;
import L4.AgentSkin;
import L4.AnimationInfo;
import L4.a;
import L4.b;
import L4.g;
import L4.l;
import L4.o;
import La.C0953c;
import M4.c;
import M4.g;
import M4.k;
import M4.m;
import M4.n;
import N4.j;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.i;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.SceneLayerSpec;
import com.stepos.agentsprite.view.AgentView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import p9.InterfaceC5063a;
import s0.h;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0002È\u0001\b\u0007\u0018\u0000 A2\u00020\u0001:\u0005ß\u0001vo}B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\u0010J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u0010J\u001f\u0010-\u001a\u00020\f2\u0006\u0010*\u001a\u00020\n2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J'\u00102\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J;\u00107\u001a\u00020\f2\u0006\u00104\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002002\b\b\u0002\u00106\u001a\u00020+H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J!\u0010>\u001a\u00020\f2\u0006\u0010:\u001a\u00020=2\b\b\u0002\u00106\u001a\u00020+H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u000200H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u0010\u0010J\u0017\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010\u0010J\u0017\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020+H\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010\u0010J\u0011\u0010O\u001a\u0004\u0018\u00010NH\u0002¢\u0006\u0004\bO\u0010PJ\u0013\u0010S\u001a\u00020R*\u00020QH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010W\u001a\u00020\f2\b\u0010V\u001a\u0004\u0018\u00010UH\u0007¢\u0006\u0004\bW\u0010XJ\u0011\u0010Z\u001a\u0004\u0018\u00010YH\u0007¢\u0006\u0004\bZ\u0010[J#\u0010_\u001a\u00020\f2\u0006\u0010\\\u001a\u00020Q2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010]H\u0007¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0007¢\u0006\u0004\ba\u0010\u0010J\u0017\u0010c\u001a\u00020\f2\u0006\u0010b\u001a\u00020+H\u0016¢\u0006\u0004\bc\u0010LJ\u0017\u0010f\u001a\u00020+2\u0006\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\fH\u0014¢\u0006\u0004\bh\u0010\u0010J/\u0010l\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006H\u0014¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\fH\u0014¢\u0006\u0004\bn\u0010\u0010R(\u0010t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bo\u0010S\u0012\u0004\bs\u0010\u0010\u001a\u0004\bp\u0010q\"\u0004\br\u0010(R0\u0010|\u001a\u00020+2\u0006\u0010u\u001a\u00020+8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\bv\u0010w\u0012\u0004\b{\u0010\u0010\u001a\u0004\bx\u0010y\"\u0004\bz\u0010LR+\u0010\u0082\u0001\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u001a\n\u0004\b}\u0010\u001c\u0012\u0005\b\u0081\u0001\u0010\u0010\u001a\u0004\b~\u0010\u007f\"\u0005\b\u0080\u0001\u0010BR1\u0010\u008b\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u0012\u0005\b\u008a\u0001\u0010\u0010\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010\u008d\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010SR\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010wR\u0017\u0010\u0093\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010CR\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\\\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009a\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010wR\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010¡\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010¤\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010\u00ad\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0016\u0010¬\u0001R\u0017\u0010®\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bI\u0010¬\u0001R\u0019\u0010¯\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b_\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010¬\u0001R\u001b\u0010´\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010³\u0001R\u001b\u0010µ\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b!\u0010³\u0001R\u001b\u0010¸\u0001\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bG\u0010·\u0001R\u001b\u0010»\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bZ\u0010º\u0001R\u001b\u0010¾\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010½\u0001R\u001b\u0010Á\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010À\u0001R\u001b\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010Ã\u0001R\u0019\u0010Ç\u0001\u001a\u00030Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010Æ\u0001R\u0017\u0010Ê\u0001\u001a\u00030È\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\r\u0010É\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ð\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010Ï\u0001R\u0019\u0010Ó\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010Ò\u0001R\u0017\u0010Ô\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010wR\u0017\u0010Õ\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010wR\u0017\u0010Ö\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010CR\u0017\u0010×\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010wR\u0017\u0010Ú\u0001\u001a\u00030Ø\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b#\u0010Ù\u0001R\u0017\u0010Û\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010wR\u0016\u0010Ý\u0001\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001f\u0010Ü\u0001R\u0016\u0010Þ\u0001\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bO\u0010Ü\u0001¨\u0006à\u0001"}, d2 = {"Lcom/stepos/agentsprite/view/AgentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "msg", "LY8/t;", "C", "(Ljava/lang/String;)V", "P", "()V", "G", "Lcom/stepos/agentsprite/view/AgentView$a;", "snap", "LM4/g;", "res", "q", "(Lcom/stepos/agentsprite/view/AgentView$a;LM4/g;)V", "z", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "F", "", "durationMs", "M", "(J)V", "v", ExifInterface.LONGITUDE_EAST, "K", "L", "H", "resId", "R", "(I)V", "u", "html", "", "sandbox", "X", "(Ljava/lang/String;Z)V", "loop", "", Const.JSON_KEY_SPEED, "Y", "(IIF)V", "assetPath", "fps", "freeze", "a0", "(Ljava/lang/String;ILjava/lang/Float;FZ)V", "Lcom/stepos/agentsprite/SceneLayerSpec$k;", "spec", "b0", "(Lcom/stepos/agentsprite/SceneLayerSpec$k;)V", "Lcom/stepos/agentsprite/SceneLayerSpec$b;", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/stepos/agentsprite/SceneLayerSpec$b;Z)V", "target", "O", "(F)V", "J", "Landroidx/dynamicanimation/animation/e$s;", "property", "Landroidx/dynamicanimation/animation/i;", "w", "(Landroidx/dynamicanimation/animation/e$s;)Landroidx/dynamicanimation/animation/i;", "r", "disposeController", "d0", "(Z)V", "Q", "LUa/M;", "N", "()LUa/M;", "LL4/b;", "LM4/c;", "I", "(LL4/b;)LM4/c;", "LL4/o;", "listener", "setAnimationListener", "(LL4/o;)V", "LL4/n;", "x", "()LL4/n;", "controller", "LL4/d;", "interactions", "s", "(LL4/b;LL4/d;)V", "c0", "isVisible", "onVisibilityAggregated", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onAttachedToWindow", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "onDetachedFromWindow", Const.INTENT_KEY_APIKEY, "getCrossfadeDurationMillis", "()I", "setCrossfadeDurationMillis", "getCrossfadeDurationMillis$annotations", "crossfadeDurationMillis", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "Z", "getPressFeedback", "()Z", "setPressFeedback", "getPressFeedback$annotations", "pressFeedback", "c", "getPressFeedbackScale", "()F", "setPressFeedbackScale", "getPressFeedbackScale$annotations", "pressFeedbackScale", "LL4/g;", Const.INTENT_KEY_UMID, "LL4/g;", "getAgentSize", "()LL4/g;", "setAgentSize", "(LL4/g;)V", "getAgentSize$annotations", "agentSize", "e", "viewId", "f", "LL4/n;", "currentInfo", Const.INTENT_KEY_BACKGROUND_COMMAND, "currentSuccess", "lastShownAtMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LL4/o;", "animationListener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LM4/c;", "k", "ownsController", "l", "LM4/g;", "resolver", "Lkotlin/Function0;", "m", "Lp9/a;", "interactionDetached", "Lkotlinx/coroutines/g;", "n", "Lkotlinx/coroutines/g;", "collectJob", "o", "replayJob", "p", "LUa/M;", "fallbackScope", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "imageA", "imageB", "active", "t", "idle", "Landroid/view/ViewPropertyAnimator;", "Landroid/view/ViewPropertyAnimator;", "fadeOutAnim", "fadeInAnim", "Landroid/webkit/WebView;", "Landroid/webkit/WebView;", "htmlWebView", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "LN4/o;", "LN4/o;", "spriteView", "LN4/j;", "LN4/j;", "framesView", "Lorg/libpag/PAGView;", "Lorg/libpag/PAGView;", "pagView", "Lcom/stepos/agentsprite/view/AgentView$BodyMode;", "Lcom/stepos/agentsprite/view/AgentView$BodyMode;", "currentBodyMode", "com/stepos/agentsprite/view/AgentView$e", "Lcom/stepos/agentsprite/view/AgentView$e;", "pagTraceListener", "Lorg/libpag/PAGFile;", "D", "Lorg/libpag/PAGFile;", "lastPagFile", "Ljava/lang/String;", "currentPagAsset", "LL4/a;", "LL4/a;", "currentBackgroundRatio", "pagFiniteLoop", "pagPlayedOnce", "pagFiniteDurationMs", "pagFinitePinScheduled", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "pagFinitePin", "aggregatedVisible", "Landroidx/dynamicanimation/animation/i;", "springX", "springY", "BodyMode", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentView extends FrameLayout {

    /* renamed from: P, reason: collision with root package name */
    public static final AtomicInteger f23405P = new AtomicInteger(0);

    /* renamed from: Q, reason: collision with root package name */
    public static final AtomicInteger f23406Q = new AtomicInteger(0);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public PAGView pagView;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public BodyMode currentBodyMode;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public final e pagTraceListener;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public PAGFile lastPagFile;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public String currentPagAsset;

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public a currentBackgroundRatio;

    /* renamed from: G, reason: collision with root package name and from kotlin metadata */
    public boolean pagFiniteLoop;

    /* renamed from: H, reason: collision with root package name and from kotlin metadata */
    public boolean pagPlayedOnce;

    /* renamed from: I, reason: collision with root package name and from kotlin metadata */
    public long pagFiniteDurationMs;

    /* renamed from: J, reason: collision with root package name and from kotlin metadata */
    public boolean pagFinitePinScheduled;

    /* renamed from: K, reason: collision with root package name and from kotlin metadata */
    public final Runnable pagFinitePin;

    /* renamed from: L, reason: collision with root package name and from kotlin metadata */
    public boolean aggregatedVisible;

    /* renamed from: M, reason: collision with root package name and from kotlin metadata */
    public final i springX;

    /* renamed from: N, reason: collision with root package name and from kotlin metadata */
    public final i springY;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int crossfadeDurationMillis;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean pressFeedback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float pressFeedbackScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public g agentSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int viewId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public AnimationInfo currentInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean currentSuccess;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public long lastShownAtMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public o animationListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public c controller;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean ownsController;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public M4.g resolver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> interactionDetached;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g collectJob;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g replayJob;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public M fallbackScope;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final AppCompatImageView imageA;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final AppCompatImageView imageB;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public AppCompatImageView active;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public AppCompatImageView idle;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public ViewPropertyAnimator fadeOutAnim;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public ViewPropertyAnimator fadeInAnim;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public WebView htmlWebView;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public LottieAnimationView lottieView;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public N4.o spriteView;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public j framesView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentsprite/view/AgentView$BodyMode;", "", "<init>", "(Ljava/lang/String;I)V", "DRAWABLE", "HTML", L.TAG, "SPRITE", "FRAMES", "PAG", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BodyMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ BodyMode[] $VALUES;
        public static final BodyMode DRAWABLE = new BodyMode("DRAWABLE", 0);
        public static final BodyMode HTML = new BodyMode("HTML", 1);
        public static final BodyMode LOTTIE = new BodyMode(L.TAG, 2);
        public static final BodyMode SPRITE = new BodyMode("SPRITE", 3);
        public static final BodyMode FRAMES = new BodyMode("FRAMES", 4);
        public static final BodyMode PAG = new BodyMode("PAG", 5);

        private static final /* synthetic */ BodyMode[] $values() {
            return new BodyMode[]{DRAWABLE, HTML, LOTTIE, SPRITE, FRAMES, PAG};
        }

        static {
            BodyMode[] bodyModeArr$values = $values();
            $VALUES = bodyModeArr$values;
            $ENTRIES = kotlin.enums.a.a(bodyModeArr$values);
        }

        private BodyMode(String str, int i10) {
        }

        public static InterfaceC4149a<BodyMode> getEntries() {
            return $ENTRIES;
        }

        public static BodyMode valueOf(String str) {
            return (BodyMode) Enum.valueOf(BodyMode.class, str);
        }

        public static BodyMode[] values() {
            return (BodyMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b$\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b\"\u0010*R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0013R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\u001b\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentsprite/view/AgentView$a;", "", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "LL4/c;", "emotion", "LL4/h;", "skin", "LL4/e;", "nightMode", "LL4/f;", "place", "", "assetsPackage", "LL4/a;", "backgroundRatio", "<init>", "(LL4/l;LL4/c;LL4/h;LL4/e;LL4/f;Ljava/lang/String;LL4/a;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LL4/l;", "e", "()LL4/l;", Const.INTENT_KEY_PKGNAME, "LL4/c;", "()LL4/c;", "c", "LL4/h;", Const.INTENT_KEY_UMID, "()LL4/h;", "LL4/e;", "getNightMode", "()LL4/e;", "LL4/f;", "()LL4/f;", "f", "Ljava/lang/String;", "getAssetsPackage", Const.INTENT_KEY_BACKGROUND_COMMAND, "LL4/a;", "()LL4/a;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.view.AgentView$a, reason: from toString */
    public static final /* data */ class AssetSnapshot {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final l state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentEmotion emotion;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentSkin skin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final L4.e nightMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentPlace place;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final String assetsPackage;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final a backgroundRatio;

        public AssetSnapshot(l state, AgentEmotion emotion, AgentSkin skin, L4.e nightMode, AgentPlace place, String str, a backgroundRatio) {
            p.i(state, "state");
            p.i(emotion, "emotion");
            p.i(skin, "skin");
            p.i(nightMode, "nightMode");
            p.i(place, "place");
            p.i(backgroundRatio, "backgroundRatio");
            this.state = state;
            this.emotion = emotion;
            this.skin = skin;
            this.nightMode = nightMode;
            this.place = place;
            this.assetsPackage = str;
            this.backgroundRatio = backgroundRatio;
        }

        /* renamed from: a, reason: from getter */
        public final a getBackgroundRatio() {
            return this.backgroundRatio;
        }

        /* renamed from: b, reason: from getter */
        public final AgentEmotion getEmotion() {
            return this.emotion;
        }

        /* renamed from: c, reason: from getter */
        public final AgentPlace getPlace() {
            return this.place;
        }

        /* renamed from: d, reason: from getter */
        public final AgentSkin getSkin() {
            return this.skin;
        }

        /* renamed from: e, reason: from getter */
        public final l getState() {
            return this.state;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssetSnapshot)) {
                return false;
            }
            AssetSnapshot assetSnapshot = (AssetSnapshot) other;
            return p.d(this.state, assetSnapshot.state) && p.d(this.emotion, assetSnapshot.emotion) && p.d(this.skin, assetSnapshot.skin) && p.d(this.nightMode, assetSnapshot.nightMode) && p.d(this.place, assetSnapshot.place) && p.d(this.assetsPackage, assetSnapshot.assetsPackage) && p.d(this.backgroundRatio, assetSnapshot.backgroundRatio);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.state.hashCode() * 31) + this.emotion.hashCode()) * 31) + this.skin.hashCode()) * 31) + this.nightMode.hashCode()) * 31) + this.place.hashCode()) * 31;
            String str = this.assetsPackage;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.backgroundRatio.hashCode();
        }

        public String toString() {
            return "AssetSnapshot(state=" + this.state + ", emotion=" + this.emotion + ", skin=" + this.skin + ", nightMode=" + this.nightMode + ", place=" + this.place + ", assetsPackage=" + this.assetsPackage + ", backgroundRatio=" + this.backgroundRatio + ")";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010#\u001a\u0004\b\u001c\u0010$R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\u001f\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentsprite/view/AgentView$b;", "", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "LL4/c;", "emotion", "LL4/h;", "skin", "LL4/e;", "nightMode", "LL4/f;", "place", "<init>", "(LL4/l;LL4/c;LL4/h;LL4/e;LL4/f;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LL4/l;", "e", "()LL4/l;", Const.INTENT_KEY_PKGNAME, "LL4/c;", "()LL4/c;", "c", "LL4/h;", Const.INTENT_KEY_UMID, "()LL4/h;", "LL4/e;", "()LL4/e;", "LL4/f;", "()LL4/f;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.view.AgentView$b, reason: from toString */
    public static final /* data */ class BodyDimensionSnapshot {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final l state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentEmotion emotion;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentSkin skin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final L4.e nightMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final AgentPlace place;

        public BodyDimensionSnapshot(l state, AgentEmotion emotion, AgentSkin skin, L4.e nightMode, AgentPlace place) {
            p.i(state, "state");
            p.i(emotion, "emotion");
            p.i(skin, "skin");
            p.i(nightMode, "nightMode");
            p.i(place, "place");
            this.state = state;
            this.emotion = emotion;
            this.skin = skin;
            this.nightMode = nightMode;
            this.place = place;
        }

        /* renamed from: a, reason: from getter */
        public final AgentEmotion getEmotion() {
            return this.emotion;
        }

        /* renamed from: b, reason: from getter */
        public final L4.e getNightMode() {
            return this.nightMode;
        }

        /* renamed from: c, reason: from getter */
        public final AgentPlace getPlace() {
            return this.place;
        }

        /* renamed from: d, reason: from getter */
        public final AgentSkin getSkin() {
            return this.skin;
        }

        /* renamed from: e, reason: from getter */
        public final l getState() {
            return this.state;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BodyDimensionSnapshot)) {
                return false;
            }
            BodyDimensionSnapshot bodyDimensionSnapshot = (BodyDimensionSnapshot) other;
            return p.d(this.state, bodyDimensionSnapshot.state) && p.d(this.emotion, bodyDimensionSnapshot.emotion) && p.d(this.skin, bodyDimensionSnapshot.skin) && p.d(this.nightMode, bodyDimensionSnapshot.nightMode) && p.d(this.place, bodyDimensionSnapshot.place);
        }

        public int hashCode() {
            return (((((((this.state.hashCode() * 31) + this.emotion.hashCode()) * 31) + this.skin.hashCode()) * 31) + this.nightMode.hashCode()) * 31) + this.place.hashCode();
        }

        public String toString() {
            return "BodyDimensionSnapshot(state=" + this.state + ", emotion=" + this.emotion + ", skin=" + this.skin + ", nightMode=" + this.nightMode + ", place=" + this.place + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23459a;

        static {
            int[] iArr = new int[BodyMode.values().length];
            try {
                iArr[BodyMode.PAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BodyMode.LOTTIE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BodyMode.SPRITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BodyMode.FRAMES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BodyMode.DRAWABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BodyMode.HTML.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f23459a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"com/stepos/agentsprite/view/AgentView$e", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "view", "LY8/t;", "onAnimationStart", "(Lorg/libpag/PAGView;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements PAGView.PAGViewListener {
        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView view) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView view) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView view) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView view) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView view) {
            M4.d.f4544a.b("AgentSpriteSDK#Pag");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/agentsprite/view/AgentView$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            p.i(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            p.i(animation, "animation");
            AgentView.this.y();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            p.i(animation, "animation");
            AgentView.this.A();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            p.i(animation, "animation");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public static final void D(AgentView agentView) {
        agentView.pagFinitePinScheduled = false;
        PAGView pAGView = agentView.pagView;
        if (pAGView != null && agentView.currentBodyMode == BodyMode.PAG) {
            pAGView.setProgress(1.0d);
            pAGView.stop();
            agentView.pagPlayedOnce = true;
            agentView.y();
        }
    }

    public static final void S(AppCompatImageView appCompatImageView) {
        appCompatImageView.setImageDrawable(null);
    }

    public static final t U(AgentView agentView) {
        agentView.z();
        return t.f7040a;
    }

    public static final t V(AgentView agentView) {
        agentView.y();
        return t.f7040a;
    }

    public static final t W(AgentView agentView) {
        agentView.A();
        return t.f7040a;
    }

    public static final void Z(ValueAnimator it) {
        p.i(it, "it");
        M4.d.f4544a.b("AgentSpriteSDK#Lottie");
    }

    public static /* synthetic */ void getAgentSize$annotations() {
    }

    public static /* synthetic */ void getCrossfadeDurationMillis$annotations() {
    }

    public static /* synthetic */ void getPressFeedback$annotations() {
    }

    public static /* synthetic */ void getPressFeedbackScale$annotations() {
    }

    public static /* synthetic */ void t(AgentView agentView, b bVar, L4.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            dVar = null;
        }
        agentView.s(bVar, dVar);
    }

    public final void A() {
        o oVar;
        AnimationInfo animationInfo = this.currentInfo;
        if (animationInfo == null || (oVar = this.animationListener) == null) {
            return;
        }
        oVar.b(animationInfo);
    }

    public final void B() {
        v();
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
            pAGView.setVisibility(8);
        }
        this.lastPagFile = null;
        this.currentPagAsset = null;
    }

    public final void C(String msg) {
        M4.d.f4544a.a("v" + this.viewId + " " + msg);
    }

    public final void E() {
        v();
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
            if (this.pagFiniteLoop && this.currentBodyMode == BodyMode.PAG && this.pagPlayedOnce) {
                pAGView.setProgress(1.0d);
            }
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
        }
    }

    public final void F() {
        PAGView pAGView;
        if (this.controller == null || (pAGView = this.pagView) == null) {
            return;
        }
        if (pAGView.getComposition() == null) {
            pAGView = null;
        }
        if (pAGView == null) {
            return;
        }
        pAGView.play();
        this.pagPlayedOnce = true;
        AnimationInfo animationInfo = this.currentInfo;
        String state = animationInfo != null ? animationInfo.getState() : null;
        C("Pag.play state=" + state + " asset=" + this.currentPagAsset + " finite=" + this.pagFiniteLoop + " durMs=" + this.pagFiniteDurationMs);
        if (this.pagFiniteLoop) {
            M(this.pagFiniteDurationMs);
        }
    }

    public final void G() {
        PAGFile pAGFile;
        PAGView pAGView = this.pagView;
        if (pAGView != null && (pAGFile = this.lastPagFile) != null && this.currentBodyMode == BodyMode.PAG && getWidth() > 0 && getHeight() > 0) {
            m.f4635a.a(pAGView, pAGFile, this.currentBackgroundRatio, getWidth(), getHeight());
        }
    }

    public final void H() {
        Xa.t<Boolean> tVarP;
        N4.o oVar;
        j jVar;
        Xa.t<Boolean> tVarP2;
        o oVar2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.lastShownAtMs >= 32) {
            AnimationInfo animationInfo = this.currentInfo;
            if (animationInfo != null && (oVar2 = this.animationListener) != null) {
                oVar2.e(animationInfo);
                oVar2.a(animationInfo, this.currentSuccess);
            }
            this.lastShownAtMs = jUptimeMillis;
        }
        switch (d.f23459a[this.currentBodyMode.ordinal()]) {
            case 1:
                PAGView pAGView = this.pagView;
                if (pAGView != null) {
                    PAGView pAGView2 = pAGView.getComposition() != null ? pAGView : null;
                    if (pAGView2 == null) {
                        return;
                    }
                    v();
                    c cVar = this.controller;
                    if (cVar != null && (tVarP = cVar.p()) != null && tVarP.getValue().booleanValue()) {
                        pAGView2.stop();
                        pAGView2.setProgress(1.0d);
                        this.pagPlayedOnce = true;
                        return;
                    } else {
                        pAGView2.setProgress(0.0d);
                        if (this.aggregatedVisible) {
                            F();
                            return;
                        } else {
                            this.pagPlayedOnce = false;
                            return;
                        }
                    }
                }
                return;
            case 2:
                LottieAnimationView lottieAnimationView = this.lottieView;
                if (lottieAnimationView != null) {
                    LottieAnimationView lottieAnimationView2 = lottieAnimationView.getComposition() != null ? lottieAnimationView : null;
                    if (lottieAnimationView2 != null) {
                        lottieAnimationView2.setProgress(0.0f);
                        if (this.aggregatedVisible) {
                            lottieAnimationView2.playAnimation();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (!this.aggregatedVisible || (oVar = this.spriteView) == null) {
                    return;
                }
                oVar.g();
                return;
            case 4:
                c cVar2 = this.controller;
                if (cVar2 == null || (tVarP2 = cVar2.p()) == null || !tVarP2.getValue().booleanValue()) {
                    if (!this.aggregatedVisible || (jVar = this.framesView) == null) {
                        return;
                    }
                    jVar.l();
                    return;
                }
                j jVar2 = this.framesView;
                if (jVar2 != null) {
                    jVar2.o();
                    return;
                }
                return;
            case 5:
            case 6:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final c I(b bVar) {
        c cVar = bVar instanceof c ? (c) bVar : null;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("AgentView requires an AgentController produced by obtainAgent() / rememberAgent(). Custom AgentController implementations are not supported.");
    }

    public final void J() {
        this.springX.d();
        this.springY.d();
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public final void K() {
        Xa.t<Boolean> tVarP;
        if (this.controller == null) {
            return;
        }
        switch (d.f23459a[this.currentBodyMode.ordinal()]) {
            case 1:
                L();
                return;
            case 2:
                LottieAnimationView lottieAnimationView = this.lottieView;
                if (lottieAnimationView != null) {
                    if (lottieAnimationView.getComposition() == null) {
                        lottieAnimationView = null;
                    }
                    if (lottieAnimationView != null) {
                        lottieAnimationView.resumeAnimation();
                        return;
                    }
                    return;
                }
                return;
            case 3:
                N4.o oVar = this.spriteView;
                if (oVar != null) {
                    oVar.i();
                    return;
                }
                return;
            case 4:
                c cVar = this.controller;
                if (cVar == null || (tVarP = cVar.p()) == null || !tVarP.getValue().booleanValue()) {
                    j jVar = this.framesView;
                    if (jVar != null) {
                        jVar.p();
                        return;
                    }
                    return;
                }
                j jVar2 = this.framesView;
                if (jVar2 != null) {
                    jVar2.o();
                    return;
                }
                return;
            case 5:
            case 6:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void L() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            if (pAGView.getComposition() == null) {
                pAGView = null;
            }
            if (pAGView == null) {
                return;
            }
            if (this.pagFiniteLoop && this.pagPlayedOnce) {
                pAGView.setProgress(1.0d);
            } else {
                F();
            }
        }
    }

    public final void M(long durationMs) {
        v();
        if (durationMs <= 0) {
            return;
        }
        this.pagFiniteDurationMs = durationMs;
        this.pagFinitePinScheduled = true;
        postDelayed(this.pagFinitePin, durationMs);
    }

    public final M N() {
        LifecycleOwner lifecycleOwnerA = View.a(this);
        if (lifecycleOwnerA != null) {
            return C1398p.a(lifecycleOwnerA);
        }
        if (this.fallbackScope == null) {
            this.fallbackScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
        }
        return this.fallbackScope;
    }

    public final void O(float target) {
        this.springX.w(target);
        this.springY.w(target);
    }

    public final void P() {
        M mN;
        c cVar = this.controller;
        if (cVar == null || (mN = N()) == null) {
            return;
        }
        this.collectJob = C1060i.d(mN, Y.c().getImmediate(), null, new AgentView$startCollecting$1(cVar, this, null), 2, null);
        this.replayJob = C1060i.d(mN, Y.c().getImmediate(), null, new AgentView$startCollecting$2(cVar, this, null), 2, null);
    }

    public final void Q() {
        kotlinx.coroutines.g gVar = this.collectJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.collectJob = null;
        kotlinx.coroutines.g gVar2 = this.replayJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.replayJob = null;
        u();
    }

    public final void R(int resId) {
        Object objB;
        Drawable drawable;
        M4.g gVar;
        BodyMode bodyMode = this.currentBodyMode;
        BodyMode bodyMode2 = BodyMode.DRAWABLE;
        if (bodyMode != bodyMode2) {
            WebView webView = this.htmlWebView;
            if (webView != null) {
                webView.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView = this.lottieView;
            if (lottieAnimationView != null) {
                lottieAnimationView.pauseAnimation();
                lottieAnimationView.setVisibility(8);
            }
            N4.o oVar = this.spriteView;
            if (oVar != null) {
                oVar.j();
                oVar.setVisibility(8);
            }
            j jVar = this.framesView;
            if (jVar != null) {
                jVar.q();
                jVar.setVisibility(8);
            }
            B();
            this.imageA.setVisibility(0);
            this.imageB.setVisibility(0);
            this.currentBodyMode = bodyMode2;
        }
        if (resId == 0) {
            drawable = null;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                gVar = this.resolver;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (gVar == null) {
                return;
            }
            objB = Result.b(h.e(gVar.getResources(), resId, getContext().getTheme()));
            if (Result.g(objB)) {
                objB = null;
            }
            drawable = (Drawable) objB;
        }
        u();
        if (drawable == null) {
            this.imageA.setImageDrawable(null);
            this.imageA.setAlpha(1.0f);
            this.imageB.setImageDrawable(null);
            this.imageB.setAlpha(0.0f);
            this.active = this.imageA;
            this.idle = this.imageB;
            return;
        }
        int i10 = this.crossfadeDurationMillis;
        if (i10 <= 0 || this.active.getDrawable() == null) {
            this.active.setImageDrawable(drawable);
            this.active.setAlpha(1.0f);
            this.idle.setImageDrawable(null);
            this.idle.setAlpha(0.0f);
            return;
        }
        this.idle.setImageDrawable(drawable);
        this.idle.setAlpha(0.0f);
        final AppCompatImageView appCompatImageView = this.active;
        AppCompatImageView appCompatImageView2 = this.idle;
        this.active = appCompatImageView2;
        this.idle = appCompatImageView;
        long j10 = i10;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction = appCompatImageView.animate().alpha(0.0f).setDuration(j10).withEndAction(new Runnable() { // from class: N4.c
            @Override // java.lang.Runnable
            public final void run() {
                AgentView.S(appCompatImageView);
            }
        });
        this.fadeOutAnim = viewPropertyAnimatorWithEndAction;
        if (viewPropertyAnimatorWithEndAction != null) {
            viewPropertyAnimatorWithEndAction.start();
        }
        ViewPropertyAnimator duration = appCompatImageView2.animate().alpha(1.0f).setDuration(j10);
        this.fadeInAnim = duration;
        if (duration != null) {
            duration.start();
        }
    }

    public final void T(SceneLayerSpec.Frames spec, boolean freeze) {
        Resources resources;
        u();
        this.imageA.setVisibility(8);
        this.imageB.setVisibility(8);
        WebView webView = this.htmlWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
            oVar.setVisibility(8);
        }
        B();
        this.currentBodyMode = BodyMode.FRAMES;
        M4.g gVar = this.resolver;
        if (gVar == null || (resources = gVar.getResources()) == null) {
            resources = getContext().getResources();
        }
        j jVar = this.framesView;
        if (jVar == null) {
            Context context = getContext();
            p.h(context, "getContext(...)");
            jVar = new j(context);
            addView(jVar, new FrameLayout.LayoutParams(-1, -1));
            this.framesView = jVar;
        }
        int i10 = this.viewId;
        AnimationInfo animationInfo = this.currentInfo;
        jVar.setDiagLabel("v" + i10 + " state=" + (animationInfo != null ? animationInfo.getState() : null) + " ");
        jVar.setOnLoad(new InterfaceC5063a() { // from class: N4.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentView.U(this.f4796a);
            }
        });
        jVar.setOnEnd(new InterfaceC5063a() { // from class: N4.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentView.V(this.f4797a);
            }
        });
        jVar.setOnRepeat(new InterfaceC5063a() { // from class: N4.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentView.W(this.f4798a);
            }
        });
        jVar.setVisibility(0);
        p.f(resources);
        jVar.n(spec, resources);
        if (freeze) {
            jVar.o();
        } else {
            if (this.aggregatedVisible) {
                return;
            }
            jVar.q();
        }
    }

    public final void X(String html, boolean sandbox) {
        u();
        this.imageA.setVisibility(8);
        this.imageB.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
            oVar.setVisibility(8);
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
            jVar.setVisibility(8);
        }
        B();
        this.currentBodyMode = BodyMode.HTML;
        WebView webView = this.htmlWebView;
        if (webView == null) {
            webView = new WebView(getContext());
            webView.setBackgroundColor(0);
            addView(webView, new FrameLayout.LayoutParams(-1, -1));
            this.htmlWebView = webView;
        }
        WebView webView2 = webView;
        webView2.setVisibility(0);
        webView2.getSettings().setJavaScriptEnabled(!sandbox);
        webView2.getSettings().setAllowFileAccess(!sandbox);
        webView2.getSettings().setAllowContentAccess(!sandbox);
        webView2.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(int resId, int loop, float speed) {
        String strB;
        if (resId == 0) {
            R(0);
            return;
        }
        u();
        this.imageA.setVisibility(8);
        this.imageB.setVisibility(8);
        WebView webView = this.htmlWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
            oVar.setVisibility(8);
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
            jVar.setVisibility(8);
        }
        B();
        this.currentBodyMode = BodyMode.LOTTIE;
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView == null) {
            lottieAnimationView = new LottieAnimationView(getContext());
            lottieAnimationView.setBackgroundColor(0);
            addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -1));
            this.lottieView = lottieAnimationView;
        }
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.pauseAnimation();
        M4.g gVar = this.resolver;
        Resources resources = gVar != null ? gVar.getResources() : null;
        if (resources != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                InputStream inputStreamOpenRawResource = resources.openRawResource(resId);
                p.h(inputStreamOpenRawResource, "openRawResource(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                try {
                    String strE = l9.m.e(bufferedReader);
                    l9.b.a(bufferedReader, null);
                    strB = Result.b(strE);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                strB = Result.b(C4849c.a(th));
            }
            str = Result.g(strB) ? null : strB;
        }
        if (str != null) {
            lottieAnimationView.setAnimationFromJson(str, "agent_lottie_" + resId);
        } else {
            lottieAnimationView.setAnimation(resId);
        }
        z();
        lottieAnimationView.removeAllAnimatorListeners();
        lottieAnimationView.addAnimatorListener(new f());
        lottieAnimationView.setRepeatCount(k.a(loop));
        if (speed <= 0.0f) {
            speed = 1.0f;
        }
        lottieAnimationView.setSpeed(speed);
        lottieAnimationView.setProgress(0.0f);
        lottieAnimationView.removeAllUpdateListeners();
        lottieAnimationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: N4.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AgentView.Z(valueAnimator);
            }
        });
        C("Lottie.play loop=" + loop + " visible=" + this.aggregatedVisible);
        if (this.aggregatedVisible) {
            lottieAnimationView.playAnimation();
        }
    }

    public final void a0(String assetPath, int loop, Float fps, float speed, boolean freeze) {
        String packageName;
        Object objB;
        Object objB2;
        if (assetPath.length() == 0) {
            R(0);
            return;
        }
        u();
        this.imageA.setVisibility(8);
        this.imageB.setVisibility(8);
        WebView webView = this.htmlWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
            oVar.setVisibility(8);
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
            jVar.setVisibility(8);
        }
        this.currentBodyMode = BodyMode.PAG;
        this.pagFiniteLoop = loop >= 0;
        this.pagPlayedOnce = false;
        v();
        this.pagFiniteDurationMs = 0L;
        M4.g gVar = this.resolver;
        if (gVar == null || (packageName = gVar.getPackageName()) == null) {
            packageName = "com.stepos.agentpack";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getContext().createPackageContext(packageName, 0).getAssets());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = getContext().getAssets();
        }
        try {
            objB2 = Result.b(PAGFile.Load((AssetManager) objB, assetPath));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        PAGFile pAGFileCopyOriginal = (PAGFile) objB2;
        if (pAGFileCopyOriginal == null) {
            R(0);
            return;
        }
        M4.p pVar = M4.p.f4640a;
        if (pVar.b(speed)) {
            pAGFileCopyOriginal = pAGFileCopyOriginal.copyOriginal();
        }
        PAGFile pAGFile = pAGFileCopyOriginal;
        p.f(pAGFile);
        pVar.a(pAGFile, speed);
        PAGView pAGView = this.pagView;
        if (pAGView == null) {
            pAGView = new PAGView(getContext());
            pAGView.setBackgroundColor(0);
            pAGView.addListener(this.pagTraceListener);
            addView(pAGView, new FrameLayout.LayoutParams(-1, -1));
            this.pagView = pAGView;
        }
        PAGView pAGView2 = pAGView;
        pAGView2.setVisibility(0);
        this.currentPagAsset = assetPath;
        AnimationInfo animationInfo = this.currentInfo;
        String state = animationInfo != null ? animationInfo.getState() : null;
        boolean z10 = this.controller != null;
        C("Pag.switch state=" + state + " asset=" + assetPath + " loop=" + loop + " freeze=" + freeze + " bound=" + z10 + " visible=" + this.aggregatedVisible);
        n.f4639a.a(pAGView2, fps, pAGFile, assetPath);
        pAGView2.setComposition(pAGFile);
        z();
        pAGView2.setRepeatCount(this.pagFiniteLoop ? 0 : M4.o.a(loop));
        pAGView2.stop();
        this.lastPagFile = pAGFile;
        m.f4635a.a(pAGView2, pAGFile, this.currentBackgroundRatio, getWidth(), getHeight());
        this.pagFiniteDurationMs = this.pagFiniteLoop ? (pAGFile.duration() / 1000) * C5685n.f(loop, 1) : 0L;
        if (freeze) {
            this.pagFiniteLoop = true;
            this.pagPlayedOnce = true;
            pAGView2.setProgress(1.0d);
            pAGView2.flush();
            return;
        }
        pAGView2.setProgress(0.0d);
        if (this.aggregatedVisible) {
            F();
        }
    }

    public final void b0(SceneLayerSpec.SpriteSheet spec) {
        Resources resources;
        u();
        this.imageA.setVisibility(8);
        this.imageB.setVisibility(8);
        WebView webView = this.htmlWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
            jVar.setVisibility(8);
        }
        B();
        this.currentBodyMode = BodyMode.SPRITE;
        M4.g gVar = this.resolver;
        if (gVar == null || (resources = gVar.getResources()) == null) {
            resources = getContext().getResources();
        }
        N4.o oVar = this.spriteView;
        if (oVar == null) {
            Context context = getContext();
            p.h(context, "getContext(...)");
            oVar = new N4.o(context);
            addView(oVar, new FrameLayout.LayoutParams(-1, -1));
            this.spriteView = oVar;
        }
        int i10 = this.viewId;
        AnimationInfo animationInfo = this.currentInfo;
        oVar.setDiagLabel("v" + i10 + " state=" + (animationInfo != null ? animationInfo.getState() : null) + " ");
        oVar.setVisibility(0);
        p.f(resources);
        oVar.h(spec, resources);
        if (this.aggregatedVisible) {
            return;
        }
        oVar.j();
    }

    public final void c0() {
        d0(true);
    }

    public final void d0(boolean disposeController) {
        c cVar;
        C("unbind dispose=" + disposeController + " owns=" + this.ownsController + " mode=" + this.currentBodyMode + " asset=" + this.currentPagAsset);
        kotlinx.coroutines.g gVar = this.collectJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.collectJob = null;
        kotlinx.coroutines.g gVar2 = this.replayJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.replayJob = null;
        InterfaceC5063a<t> interfaceC5063a = this.interactionDetached;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.interactionDetached = null;
        u();
        v();
        LottieAnimationView lottieAnimationView = this.lottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setImageDrawable(null);
        }
        N4.o oVar = this.spriteView;
        if (oVar != null) {
            oVar.j();
        }
        j jVar = this.framesView;
        if (jVar != null) {
            jVar.q();
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
            pAGView.freeCache();
        }
        this.lastPagFile = null;
        if (disposeController && this.ownsController && (cVar = this.controller) != null) {
            cVar.s();
        }
        this.controller = null;
        this.ownsController = false;
        this.resolver = null;
        this.imageA.setImageDrawable(null);
        this.imageA.setAlpha(1.0f);
        this.imageB.setImageDrawable(null);
        this.imageB.setAlpha(0.0f);
        this.active = this.imageA;
        this.idle = this.imageB;
    }

    public final g getAgentSize() {
        return this.agentSize;
    }

    public final int getCrossfadeDurationMillis() {
        return this.crossfadeDurationMillis;
    }

    public final boolean getPressFeedback() {
        return this.pressFeedback;
    }

    public final float getPressFeedbackScale() {
        return this.pressFeedbackScale;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean z10 = this.controller != null;
        C("attached bound=" + z10 + " mode=" + this.currentBodyMode + " asset=" + this.currentPagAsset + " live=" + f23406Q.incrementAndGet());
        if (this.controller == null || this.collectJob != null) {
            return;
        }
        r();
        P();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C("detached owns=" + this.ownsController + " mode=" + this.currentBodyMode + " asset=" + this.currentPagAsset + " live=" + f23406Q.decrementAndGet());
        E();
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.freeCache();
        }
        if (this.ownsController) {
            d0(true);
        } else {
            Q();
            InterfaceC5063a<t> interfaceC5063a = this.interactionDetached;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            this.interactionDetached = null;
        }
        M m10 = this.fallbackScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.fallbackScope = null;
        J();
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (!(w10 == oldw && h10 == oldh) && w10 > 0 && h10 > 0) {
            G();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (this.pressFeedback) {
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                O(this.pressFeedbackScale);
            } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
                O(1.0f);
            }
        }
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (this.pressFeedback) {
            return true;
        }
        return zOnTouchEvent;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        Xa.t<l> tVarO;
        l value;
        super.onVisibilityAggregated(isVisible);
        if (this.aggregatedVisible == isVisible) {
            return;
        }
        this.aggregatedVisible = isVisible;
        BodyMode bodyMode = this.currentBodyMode;
        String str = this.currentPagAsset;
        c cVar = this.controller;
        C("visAggregated=" + isVisible + " mode=" + bodyMode + " asset=" + str + " bound=" + (cVar != null) + " state=" + ((cVar == null || (tVarO = cVar.o()) == null || (value = tVarO.getValue()) == null) ? null : value.getKey()));
        if (isVisible) {
            K();
        } else {
            E();
        }
    }

    public final void q(AssetSnapshot snap, M4.g res) {
        String strG;
        String id;
        Xa.t<Boolean> tVarP;
        AgentView agentView;
        Xa.t<Boolean> tVarP2;
        String name;
        c cVar = this.controller;
        if (cVar == null || (strG = cVar.getAgentId()) == null) {
            return;
        }
        SceneLayerSpec sceneLayerSpecD = res.d(strG, snap.getEmotion(), snap.getSkin());
        boolean zD = p.d(sceneLayerSpecD, SceneLayerSpec.f.f23369a);
        if (zD) {
            sceneLayerSpecD = res.e(strG, snap.getState(), snap.getSkin(), snap.getPlace());
        }
        g.ResolvedAnimation resolvedAnimationB = !zD ? res.b(strG, snap.getEmotion(), snap.getSkin()) : res.c(strG, snap.getState(), snap.getSkin(), snap.getPlace());
        boolean z10 = false;
        boolean z11 = resolvedAnimationB != null;
        String str = "";
        if (resolvedAnimationB == null || (id = resolvedAnimationB.getId()) == null) {
            id = "";
        }
        if (resolvedAnimationB != null && (name = resolvedAnimationB.getName()) != null) {
            str = name;
        }
        AnimationInfo animationInfo = new AnimationInfo(id, str, snap.getState().getKey());
        this.currentInfo = animationInfo;
        this.currentSuccess = z11;
        if (sceneLayerSpecD instanceof SceneLayerSpec.Html) {
            SceneLayerSpec.Html html = (SceneLayerSpec.Html) sceneLayerSpecD;
            X(html.getHtml(), html.getSandbox());
            z();
        } else if (sceneLayerSpecD instanceof SceneLayerSpec.Drawable) {
            R(((SceneLayerSpec.Drawable) sceneLayerSpecD).getResId());
            z();
        } else if (sceneLayerSpecD instanceof SceneLayerSpec.Lottie) {
            SceneLayerSpec.Lottie lottie = (SceneLayerSpec.Lottie) sceneLayerSpecD;
            Y(lottie.getResId(), lottie.getLoop(), lottie.getSpeed());
        } else if (sceneLayerSpecD instanceof SceneLayerSpec.Pag) {
            SceneLayerSpec.Pag pag = (SceneLayerSpec.Pag) sceneLayerSpecD;
            String asset = pag.getAsset();
            int loop = pag.getLoop();
            Float fps = pag.getFps();
            float speed = pag.getSpeed();
            c cVar2 = this.controller;
            if (cVar2 == null || (tVarP2 = cVar2.p()) == null || !tVarP2.getValue().booleanValue()) {
                agentView = this;
            } else {
                agentView = this;
                z10 = true;
            }
            agentView.a0(asset, loop, fps, speed, z10);
        } else if (sceneLayerSpecD instanceof SceneLayerSpec.SpriteSheet) {
            b0((SceneLayerSpec.SpriteSheet) sceneLayerSpecD);
        } else if (sceneLayerSpecD instanceof SceneLayerSpec.Frames) {
            SceneLayerSpec.Frames frames = (SceneLayerSpec.Frames) sceneLayerSpecD;
            c cVar3 = this.controller;
            if (cVar3 != null && (tVarP = cVar3.p()) != null && tVarP.getValue().booleanValue()) {
                z10 = true;
            }
            T(frames, z10);
        } else {
            int iF = res.f(strG, snap.getEmotion(), snap.getSkin());
            if (iF == 0) {
                iF = M4.g.h(res, strG, snap.getState(), snap.getSkin(), null, 8, null);
            }
            R(iF);
            z();
        }
        o oVar = this.animationListener;
        if (oVar != null) {
            oVar.e(animationInfo);
            oVar.a(animationInfo, z11);
        }
        this.lastShownAtMs = SystemClock.uptimeMillis();
    }

    public final void r() {
        InterfaceC5063a<t> interfaceC5063a = this.interactionDetached;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.interactionDetached = null;
    }

    public final void s(b controller, L4.d interactions) {
        p.i(controller, "controller");
        d0(false);
        c cVarI = I(controller);
        this.controller = cVarI;
        this.ownsController = false;
        this.resolver = cVarI.getResolver();
        C("bind agentId=" + cVarI.getAgentId() + " shared=true");
        r();
        P();
    }

    public final void setAgentSize(L4.g gVar) {
        p.i(gVar, "<set-?>");
        this.agentSize = gVar;
    }

    public final void setAnimationListener(o listener) {
        this.animationListener = listener;
    }

    public final void setCrossfadeDurationMillis(int i10) {
        this.crossfadeDurationMillis = i10;
    }

    public final void setPressFeedback(boolean z10) {
        this.pressFeedback = z10;
        if (z10) {
            return;
        }
        J();
    }

    public final void setPressFeedbackScale(float f10) {
        this.pressFeedbackScale = f10;
    }

    public final void u() {
        ViewPropertyAnimator viewPropertyAnimator = this.fadeOutAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.fadeOutAnim = null;
        ViewPropertyAnimator viewPropertyAnimator2 = this.fadeInAnim;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
        }
        this.fadeInAnim = null;
    }

    public final void v() {
        if (this.pagFinitePinScheduled) {
            removeCallbacks(this.pagFinitePin);
            this.pagFinitePinScheduled = false;
        }
    }

    public final i w(e.s property) {
        i iVar = new i(this, property, 1.0f);
        androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j(1.0f);
        jVar.h(1500.0f);
        jVar.f(0.5f);
        iVar.B(jVar);
        return iVar;
    }

    /* renamed from: x, reason: from getter */
    public final AnimationInfo getCurrentInfo() {
        return this.currentInfo;
    }

    public final void y() {
        o oVar;
        AnimationInfo animationInfo = this.currentInfo;
        if (animationInfo == null || (oVar = this.animationListener) == null) {
            return;
        }
        oVar.c(animationInfo);
    }

    public final void z() {
        o oVar;
        AnimationInfo animationInfo = this.currentInfo;
        if (animationInfo == null || (oVar = this.animationListener) == null) {
            return;
        }
        oVar.d(animationInfo);
    }

    public /* synthetic */ AgentView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.crossfadeDurationMillis = 250;
        this.pressFeedback = true;
        this.pressFeedbackScale = 0.92f;
        this.agentSize = g.c.INSTANCE;
        this.viewId = f23405P.incrementAndGet();
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        appCompatImageView.setScaleType(scaleType);
        appCompatImageView.setAlpha(1.0f);
        this.imageA = appCompatImageView;
        AppCompatImageView appCompatImageView2 = new AppCompatImageView(context);
        appCompatImageView2.setScaleType(scaleType);
        appCompatImageView2.setAlpha(0.0f);
        this.imageB = appCompatImageView2;
        this.active = appCompatImageView;
        this.idle = appCompatImageView2;
        this.currentBodyMode = BodyMode.DRAWABLE;
        this.pagTraceListener = new e();
        this.currentBackgroundRatio = a.C0070a.f4301c;
        this.pagFinitePin = new Runnable() { // from class: N4.b
            @Override // java.lang.Runnable
            public final void run() {
                AgentView.D(this.f4794a);
            }
        };
        this.aggregatedVisible = true;
        e.s SCALE_X = androidx.dynamicanimation.animation.e.f13693q;
        p.h(SCALE_X, "SCALE_X");
        this.springX = w(SCALE_X);
        e.s SCALE_Y = androidx.dynamicanimation.animation.e.f13694r;
        p.h(SCALE_Y, "SCALE_Y");
        this.springY = w(SCALE_Y);
        addView(appCompatImageView, new FrameLayout.LayoutParams(-1, -1));
        addView(appCompatImageView2, new FrameLayout.LayoutParams(-1, -1));
        M4.j.f4631a.b();
    }
}
