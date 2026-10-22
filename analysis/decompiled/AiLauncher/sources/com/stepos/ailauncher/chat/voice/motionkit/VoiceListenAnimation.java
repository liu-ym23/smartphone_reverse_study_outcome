package com.stepos.ailauncher.chat.voice.motionkit;

import Ua.C1060i;
import Ua.L0;
import Z8.Y;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import h9.InterfaceC4149a;
import io.ktor.http.LinkHeader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n*\u0004¥\u0001¨\u0001\u0018\u0000 ¿\u00012\u00020\u0001:\u0006À\u0001Á\u0001Â\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010\u0014J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010\u0014J\u0010\u0010%\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b%\u0010&J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020'H\u0082@¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b.\u0010&J\u0010\u0010/\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b/\u0010&J\u0010\u00100\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b0\u0010&J\u000f\u00101\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u0010\u0014J\u000f\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b2\u0010\u0014J\u001b\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020403H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000fH\u0002¢\u0006\u0004\b7\u0010\u0014J\u000f\u00108\u001a\u00020\u000fH\u0002¢\u0006\u0004\b8\u0010\u0014J\u000f\u00109\u001a\u00020\u000fH\u0002¢\u0006\u0004\b9\u0010\u0014J\u001b\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020403H\u0002¢\u0006\u0004\b:\u00106J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\bJ\u0013\u0010=\u001a\u00020\u000f*\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000fH\u0002¢\u0006\u0004\b?\u0010\u0014J\u000f\u0010@\u001a\u00020\u000fH\u0002¢\u0006\u0004\b@\u0010\u0014J\u000f\u0010A\u001a\u00020\u000fH\u0002¢\u0006\u0004\bA\u0010\u0014J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\bJ\u000f\u0010C\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010\u0014J\u000f\u0010D\u001a\u00020\u000fH\u0002¢\u0006\u0004\bD\u0010\u0014JI\u0010J\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020F2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u000204032\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0HH\u0002¢\u0006\u0004\bJ\u0010KJ\u0015\u0010M\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020'¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u000fH\u0000¢\u0006\u0004\bO\u0010\u0014J\r\u0010P\u001a\u00020\u000f¢\u0006\u0004\bP\u0010\u0014J\r\u0010Q\u001a\u00020\u000f¢\u0006\u0004\bQ\u0010\u0014J\u0015\u0010T\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u000f¢\u0006\u0004\bV\u0010\u0014J\r\u0010W\u001a\u00020\u000f¢\u0006\u0004\bW\u0010\u0014J\r\u0010X\u001a\u00020\u000f¢\u0006\u0004\bX\u0010\u0014J\r\u0010Y\u001a\u00020\u000f¢\u0006\u0004\bY\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010ZR\u0017\u0010\\\u001a\u00020[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0017\u0010a\u001a\u00020`8\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0017\u0010e\u001a\u00020`8\u0006¢\u0006\f\n\u0004\be\u0010b\u001a\u0004\bf\u0010dR\u0017\u0010h\u001a\u00020g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0017\u0010m\u001a\u00020l8\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\"\u0010q\u001a\u00020R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010UR*\u0010x\u001a\u00020v2\u0006\u0010w\u001a\u00020v8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R-\u0010~\u001a\u00020'2\u0006\u0010w\u001a\u00020'8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0005\b\u0082\u0001\u0010NR7\u0010\u0086\u0001\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001j\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0005\u0012\u00030\u0084\u0001`\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010\u008a\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u000f0\u0089\u00010\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008c\u0001\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008d\u0001R\u0017\u0010\u008f\u0001\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008d\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008d\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008d\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0096\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009a\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010 \u0001\u001a\u00030\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0018\u0010¢\u0001\u001a\u00030\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010¡\u0001R\u0019\u0010£\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010¦\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010©\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010¬\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010°\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010°\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010°\u0001R\u0018\u0010µ\u0001\u001a\u00030´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0019\u0010·\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¤\u0001R\u0019\u0010¸\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¤\u0001R\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001a\u0010¼\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010»\u0001R\u001a\u0010½\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010»\u0001R\u001a\u0010¾\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010»\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation;", "", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "<init>", "(Landroid/view/View;)V", "", "c0", "()Z", "Ls7/o;", "h0", "()Ls7/o;", "i0", "Landroid/view/ViewGroup;", Parameters.ROOT, "LY8/t;", "A0", "(Landroid/view/ViewGroup;)V", "l1", "K0", "()V", "a0", "M0", "()Landroid/view/View;", "T0", "u0", "showIfNeeded", "y0", "(Z)V", "", "effect", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "b0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "B0", "f1", "L0", "i1", "(Le9/c;)Ljava/lang/Object;", "", "sec", "e0", "(FLe9/c;)Ljava/lang/Object;", "keyFeedback", "c1", "(Z)Z", "W0", "X0", "g0", "j0", ExifInterface.LONGITUDE_WEST, "", "", "m1", "()Ljava/util/Map;", "F0", "H0", "Z0", "Q0", "d0", "Ls7/j;", "X", "(Ls7/j;)V", "x0", "Y0", "g1", "G0", "v0", "w0", "host", "Ls7/e;", "vals", "Lkotlin/Function1;", "config", "V0", "(Ls7/o;Ls7/e;Ljava/util/Map;Lp9/l;)V", "volume", "S0", "(F)V", "N0", "D0", "E0", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$PlayMask;", "mask", "C0", "(Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$PlayMask;)V", "I0", "d1", "f0", "e1", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/voice/motionkit/j;", "glow", "Lcom/stepos/ailauncher/chat/voice/motionkit/j;", "m0", "()Lcom/stepos/ailauncher/chat/voice/motionkit/j;", "Lcom/stepos/ailauncher/chat/voice/motionkit/T;", "glowRipple", "Lcom/stepos/ailauncher/chat/voice/motionkit/T;", "n0", "()Lcom/stepos/ailauncher/chat/voice/motionkit/T;", "waterDrop", "q0", "Lcom/stepos/ailauncher/chat/voice/motionkit/f;", "audioWave", "Lcom/stepos/ailauncher/chat/voice/motionkit/f;", "l0", "()Lcom/stepos/ailauncher/chat/voice/motionkit/f;", "Lcom/stepos/ailauncher/chat/voice/motionkit/x;", "timing", "Lcom/stepos/ailauncher/chat/voice/motionkit/x;", "p0", "()Lcom/stepos/ailauncher/chat/voice/motionkit/x;", "playMask", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$PlayMask;", "getPlayMask$chat_release", "()Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$PlayMask;", "setPlayMask$chat_release", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$WaterBackend;", UxipConstants.f30680s, "waterBackend", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$WaterBackend;", "getWaterBackend", "()Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$WaterBackend;", "setWaterBackend", "(Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$WaterBackend;)V", Const.JSON_KEY_SPEED, "F", "o0", "()F", "R0", "Ljava/util/LinkedHashMap;", "Ls7/k;", "Lkotlin/collections/LinkedHashMap;", "instances", "Ljava/util/LinkedHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "glowBag", "Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "rippleBag", "waterBag", "waveBag", "timingBag", "Lcom/stepos/ailauncher/chat/voice/motionkit/m;", "glowOverlay", "Lcom/stepos/ailauncher/chat/voice/motionkit/m;", "sfHost", "Ls7/o;", "surfaceHost", "Landroid/widget/FrameLayout;", "sfHostView", "Landroid/widget/FrameLayout;", "waveBandView", "Landroid/widget/PopupWindow;", "sfPopup", "Landroid/widget/PopupWindow;", "Landroid/graphics/Rect;", "lastOverlay", "Landroid/graphics/Rect;", "lastScreenBox", "waterClockPosted", "Z", "com/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$d", "waterClock", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$d;", "com/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$c", "attachWaiter", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$c;", "LUa/M;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "keyFeedbackJob", "Lkotlinx/coroutines/g;", "listenJob", "waveIntroJob", "waveRetireJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", "fingerUp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "keyFeedbackHolding", "listenHolding", "", "glowPlayAtMs", "J", "ripplePlayAtMs", "waterPlayAtMs", "wavePlayAtMs", "Companion", "PlayMask", "WaterBackend", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceListenAnimation {
    public static final String GLOW = "Glow";
    public static final String GLOW_RIPPLE = "GlowRipple";
    public static final String TIMING = "Timing";
    public static final String WATER = "WaterDrop";
    public static final String WAVE = "AudioWave";
    private final View anchor;
    private final c attachWaiter;
    private final C3066f audioWave;
    private final AtomicBoolean fingerUp;
    private final C3070j glow;
    private final C3077q glowBag;
    private final C3073m glowOverlay;
    private long glowPlayAtMs;
    private final T glowRipple;
    private final LinkedHashMap<String, s7.k> instances;
    private boolean keyFeedbackHolding;
    private kotlinx.coroutines.g keyFeedbackJob;
    private final Rect lastOverlay;
    private final Rect lastScreenBox;
    private boolean listenHolding;
    private kotlinx.coroutines.g listenJob;
    private final CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> listeners;
    private PlayMask playMask;
    private final C3077q rippleBag;
    private long ripplePlayAtMs;
    private final Ua.M scope;
    private s7.o sfHost;
    private final FrameLayout sfHostView;
    private final PopupWindow sfPopup;
    private float speed;
    private s7.o surfaceHost;
    private final x timing;
    private final C3077q timingBag;
    private WaterBackend waterBackend;
    private final C3077q waterBag;
    private final d waterClock;
    private boolean waterClockPosted;
    private final T waterDrop;
    private long waterPlayAtMs;
    private final C3077q waveBag;
    private final FrameLayout waveBandView;
    private kotlinx.coroutines.g waveIntroJob;
    private long wavePlayAtMs;
    private kotlinx.coroutines.g waveRetireJob;
    private static final String PX_PER_DP = "uPxPerDp";
    private static final Set<String> RUNTIME_WATER = Y.j("uScreenSize", "uViewOrigin", "uCoordScale", "uListenTime", "uRippleTime", PX_PER_DP, "uGpuReady", "uGpuListenEA", "uGpuListenFade", "uGpuRing1", "uGpuRing2", "uGpuRippleEA", "uGpuRippleRing");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$PlayMask;", "", "<init>", "(Ljava/lang/String;I)V", "LISTEN", "KEY_FEEDBACK", "BOTH", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PlayMask {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PlayMask[] $VALUES;
        public static final PlayMask LISTEN = new PlayMask("LISTEN", 0);
        public static final PlayMask KEY_FEEDBACK = new PlayMask("KEY_FEEDBACK", 1);
        public static final PlayMask BOTH = new PlayMask("BOTH", 2);

        private static final /* synthetic */ PlayMask[] $values() {
            return new PlayMask[]{LISTEN, KEY_FEEDBACK, BOTH};
        }

        static {
            PlayMask[] playMaskArr$values = $values();
            $VALUES = playMaskArr$values;
            $ENTRIES = kotlin.enums.a.a(playMaskArr$values);
        }

        private PlayMask(String str, int i10) {
        }

        public static InterfaceC4149a<PlayMask> getEntries() {
            return $ENTRIES;
        }

        public static PlayMask valueOf(String str) {
            return (PlayMask) Enum.valueOf(PlayMask.class, str);
        }

        public static PlayMask[] values() {
            return (PlayMask[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$WaterBackend;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "SF", "SURFACE_VIEW", "TEXTURE_VIEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WaterBackend {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ WaterBackend[] $VALUES;
        public static final WaterBackend SF = new WaterBackend("SF", 0, "SF");
        public static final WaterBackend SURFACE_VIEW = new WaterBackend("SURFACE_VIEW", 1, "SurfaceView");
        public static final WaterBackend TEXTURE_VIEW = new WaterBackend("TEXTURE_VIEW", 2, "TextureView");
        private final String label;

        private static final /* synthetic */ WaterBackend[] $values() {
            return new WaterBackend[]{SF, SURFACE_VIEW, TEXTURE_VIEW};
        }

        static {
            WaterBackend[] waterBackendArr$values = $values();
            $VALUES = waterBackendArr$values;
            $ENTRIES = kotlin.enums.a.a(waterBackendArr$values);
        }

        private WaterBackend(String str, int i10, String str2) {
            this.label = str2;
        }

        public static InterfaceC4149a<WaterBackend> getEntries() {
            return $ENTRIES;
        }

        public static WaterBackend valueOf(String str) {
            return (WaterBackend) Enum.valueOf(WaterBackend.class, str);
        }

        public static WaterBackend[] values() {
            return (WaterBackend[]) $VALUES.clone();
        }

        public final String getLabel() {
            return this.label;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PlayMask.values().length];
            try {
                iArr[PlayMask.KEY_FEEDBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMask.LISTEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayMask.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WaterBackend.values().length];
            try {
                iArr2[WaterBackend.SF.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[WaterBackend.SURFACE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[WaterBackend.TEXTURE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) throws IOException {
            kotlin.jvm.internal.p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            VoiceListenAnimation.this.c0();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation$d", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "LY8/t;", "doFrame", "(J)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Choreographer.FrameCallback {
        public d() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (VoiceListenAnimation.this.G0()) {
                Choreographer.getInstance().postFrameCallback(this);
            } else {
                VoiceListenAnimation.this.waterClockPosted = false;
            }
        }
    }

    public VoiceListenAnimation(View anchor) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        this.anchor = anchor;
        this.playMask = PlayMask.BOTH;
        this.waterBackend = WaterBackend.SF;
        this.speed = 1.0f;
        this.instances = new LinkedHashMap<>();
        this.listeners = new CopyOnWriteArrayList<>();
        C3077q c3077q = new C3077q(GLOW, new p9.p() { // from class: com.stepos.ailauncher.chat.voice.motionkit.H
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VoiceListenAnimation.r0(this.f26494a, (String) obj, (float[]) obj2);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceListenAnimation.s0(this.f26495a);
            }
        });
        this.glowBag = c3077q;
        C3077q c3077q2 = new C3077q(GLOW_RIPPLE, new p9.p() { // from class: com.stepos.ailauncher.chat.voice.motionkit.J
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VoiceListenAnimation.O0(this.f26496a, (String) obj, (float[]) obj2);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceListenAnimation.P0(this.f26497a);
            }
        });
        this.rippleBag = c3077q2;
        C3077q c3077q3 = new C3077q(WATER, new p9.p() { // from class: com.stepos.ailauncher.chat.voice.motionkit.L
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VoiceListenAnimation.j1(this.f26498a, (String) obj, (float[]) obj2);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceListenAnimation.k1(this.f26499a);
            }
        });
        this.waterBag = c3077q3;
        C3077q c3077q4 = new C3077q(WAVE, new p9.p() { // from class: com.stepos.ailauncher.chat.voice.motionkit.N
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return VoiceListenAnimation.n1(this.f26500a, (String) obj, (float[]) obj2);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceListenAnimation.o1(this.f26511a);
            }
        });
        this.waveBag = c3077q4;
        C3077q c3077q5 = new C3077q(TIMING, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return VoiceListenAnimation.h1(this.f26491a);
            }
        }, 2, null);
        this.timingBag = c3077q5;
        this.glowOverlay = new C3073m(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(VoiceListenAnimation.t0(this.f26492a, (String) obj));
            }
        });
        FrameLayout frameLayout = new FrameLayout(anchor.getContext());
        this.sfHostView = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(anchor.getContext());
        frameLayout2.setClipChildren(false);
        frameLayout2.setClipToPadding(false);
        this.waveBandView = frameLayout2;
        this.sfPopup = O.j(frameLayout);
        this.lastOverlay = new Rect();
        this.lastScreenBox = new Rect();
        this.waterClock = new d();
        c cVar = new c();
        this.attachWaiter = cVar;
        this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        this.fingerUp = new AtomicBoolean(false);
        this.glow = new C3070j(c3077q);
        this.glowRipple = new T(c3077q2);
        this.waterDrop = new T(c3077q3);
        this.audioWave = new C3066f(c3077q4);
        this.timing = new x(c3077q5);
        N0();
        if (c0()) {
            return;
        }
        anchor.addOnAttachStateChangeListener(cVar);
    }

    public static final void J0(VoiceListenAnimation voiceListenAnimation, long j10, float f10, String str, long j11) {
        s7.k kVar = voiceListenAnimation.instances.get(str);
        if (kVar == null) {
            return;
        }
        if (j11 <= 0) {
            j11 = j10;
        }
        float fE = C5685n.e(((j10 - j11) / 1000.0f) * f10, 0.0f);
        kVar.g("uReleaseAt", fE);
        C3077q c3077qB0 = voiceListenAnimation.b0(str);
        if (c3077qB0 != null) {
            c3077qB0.h("uReleaseAt", new float[]{fE}, false);
        }
    }

    public static final Y8.t O0(VoiceListenAnimation voiceListenAnimation, String n10, float[] v10) {
        kotlin.jvm.internal.p.i(n10, "n");
        kotlin.jvm.internal.p.i(v10, "v");
        String strI = O.i(n10);
        voiceListenAnimation.waterBag.h(strI, v10, false);
        s7.k kVar = voiceListenAnimation.instances.get(WATER);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar != null) {
                O.k(kVar, strI, v10);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t P0(VoiceListenAnimation voiceListenAnimation) {
        voiceListenAnimation.B0();
        return Y8.t.f7040a;
    }

    public static final void U0(View view, VoiceListenAnimation voiceListenAnimation) {
        if (view.isAttachedToWindow()) {
            voiceListenAnimation.y0(true);
            O.h(voiceListenAnimation.sfPopup);
        }
    }

    public static final Y8.t Y(s7.t surface) {
        kotlin.jvm.internal.p.i(surface, "$this$surface");
        surface.d(SurfaceRendererType.AGSL);
        surface.c(SurfacePresentation.SURFACE_VIEW);
        return Y8.t.f7040a;
    }

    public static final Y8.t Z(s7.t surface) {
        kotlin.jvm.internal.p.i(surface, "$this$surface");
        surface.d(SurfaceRendererType.AGSL);
        surface.c(SurfacePresentation.TEXTURE_VIEW);
        return Y8.t.f7040a;
    }

    public static final Y8.t a1(s7.j start) {
        kotlin.jvm.internal.p.i(start, "$this$start");
        start.i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return VoiceListenAnimation.b1((s7.t) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t b1(s7.t surface) {
        kotlin.jvm.internal.p.i(surface, "$this$surface");
        surface.d(SurfaceRendererType.GLES);
        surface.c(SurfacePresentation.SURFACE_VIEW);
        return Y8.t.f7040a;
    }

    public static final Y8.t h1(VoiceListenAnimation voiceListenAnimation) {
        voiceListenAnimation.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t j1(VoiceListenAnimation voiceListenAnimation, String n10, float[] v10) {
        s7.k kVar;
        kotlin.jvm.internal.p.i(n10, "n");
        kotlin.jvm.internal.p.i(v10, "v");
        if (!O.g(n10) && (kVar = voiceListenAnimation.instances.get(WATER)) != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar != null) {
                O.k(kVar, n10, v10);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t k0(VoiceListenAnimation voiceListenAnimation, s7.j start) {
        kotlin.jvm.internal.p.i(start, "$this$start");
        voiceListenAnimation.X(start);
        return Y8.t.f7040a;
    }

    public static final Y8.t k1(VoiceListenAnimation voiceListenAnimation) {
        voiceListenAnimation.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t n1(VoiceListenAnimation voiceListenAnimation, String n10, float[] v10) {
        kotlin.jvm.internal.p.i(n10, "n");
        kotlin.jvm.internal.p.i(v10, "v");
        s7.k kVar = voiceListenAnimation.instances.get(WAVE);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar != null) {
                O.k(kVar, n10, v10);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t o1(VoiceListenAnimation voiceListenAnimation) {
        voiceListenAnimation.B0();
        return Y8.t.f7040a;
    }

    public static final Y8.t r0(VoiceListenAnimation voiceListenAnimation, String n10, float[] v10) {
        kotlin.jvm.internal.p.i(n10, "n");
        kotlin.jvm.internal.p.i(v10, "v");
        s7.k kVar = voiceListenAnimation.instances.get(GLOW);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar != null) {
                O.k(kVar, n10, v10);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t s0(VoiceListenAnimation voiceListenAnimation) {
        voiceListenAnimation.B0();
        return Y8.t.f7040a;
    }

    public static final float t0(VoiceListenAnimation voiceListenAnimation, String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return voiceListenAnimation.glowBag.g(name);
    }

    public static /* synthetic */ void z0(VoiceListenAnimation voiceListenAnimation, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        voiceListenAnimation.y0(z10);
    }

    public final void A0(ViewGroup root) {
        int width = root.getWidth();
        int height = root.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int iF = C5685n.f(U.INSTANCE.a(this.waveBag, width, height), 32);
        ViewGroup.LayoutParams layoutParams = this.waveBandView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, iF, 80);
        }
        layoutParams2.width = -1;
        layoutParams2.height = iF;
        layoutParams2.gravity = 80;
        if (this.waveBandView.getParent() != root) {
            ViewParent parent = this.waveBandView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.waveBandView);
            }
            root.addView(this.waveBandView, layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.waveBandView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 == null || layoutParams4.height != iF) {
            this.waveBandView.setLayoutParams(layoutParams2);
        }
    }

    public final void B0() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC5063a) it.next()).invoke();
        }
    }

    public final void C0(PlayMask mask) {
        kotlin.jvm.internal.p.i(mask, "mask");
        this.playMask = mask;
        int i10 = b.$EnumSwitchMapping$0[mask.ordinal()];
        if (i10 == 1) {
            f1();
            D0();
        } else if (i10 == 2) {
            e1();
            E0();
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            D0();
            E0();
        }
    }

    public final void D0() {
        this.playMask = this.listenHolding ? PlayMask.BOTH : PlayMask.KEY_FEEDBACK;
        kotlinx.coroutines.g gVar = this.keyFeedbackJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.keyFeedbackJob = C1060i.d(this.scope, null, null, new VoiceListenAnimation$playKeyFeedback$1(this, null), 3, null);
    }

    public final void E0() {
        this.playMask = this.keyFeedbackHolding ? PlayMask.BOTH : PlayMask.LISTEN;
        kotlinx.coroutines.g gVar = this.listenJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.listenJob = C1060i.d(this.scope, null, null, new VoiceListenAnimation$playListen$1(this, null), 3, null);
    }

    public final void F0() {
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar == null) {
                return;
            }
            for (Map.Entry<String, float[]> entry : Q0().entrySet()) {
                O.k(kVar, entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00af A[PHI: r7
      0x00af: PHI (r7v13 java.lang.Integer) = (r7v3 java.lang.Integer), (r7v6 java.lang.Integer) binds: [B:52:0x00ad, B:61:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G0() {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.G0():boolean");
    }

    public final void H0() {
        s7.k kVar = this.instances.get(WAVE);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar == null) {
                return;
            }
            for (Map.Entry<String, float[]> entry : this.waveBag.l().entrySet()) {
                String key = entry.getKey();
                float[] value = entry.getValue();
                if (!kotlin.jvm.internal.p.d(key, "uWaveTime")) {
                    O.k(kVar, key, value);
                }
            }
        }
    }

    public final void I0() {
        if (this.fingerUp.compareAndSet(false, true)) {
            this.keyFeedbackHolding = false;
            this.listenHolding = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            float fE = C5685n.e(this.speed, 0.01f);
            long j10 = this.glowPlayAtMs;
            if (j10 <= 0) {
                j10 = jElapsedRealtime;
            }
            this.glowBag.h("uReleaseAt", new float[]{C5685n.e(((jElapsedRealtime - j10) / 1000.0f) * fE, 0.0f)}, false);
            if (this.glowPlayAtMs > 0) {
                this.glowOverlay.n();
            }
            J0(this, jElapsedRealtime, fE, WATER, this.waterPlayAtMs);
            J0(this, jElapsedRealtime, fE, WAVE, this.wavePlayAtMs);
            s7.k kVar = this.instances.get(WATER);
            if (kVar != null) {
                long j11 = this.ripplePlayAtMs;
                if (j11 <= 0) {
                    j11 = jElapsedRealtime;
                }
                float fE2 = C5685n.e(((jElapsedRealtime - j11) / 1000.0f) * fE, 0.0f);
                kVar.g("uRReleaseAt", fE2);
                this.rippleBag.h("uReleaseAt", new float[]{fE2}, false);
            }
            if (this.wavePlayAtMs > 0) {
                x0();
            }
            B0();
        }
    }

    public final void K0() {
        s7.k kVar;
        s7.k kVar2 = this.instances.get(WATER);
        if ((kVar2 == null || !kVar2.getIsActive()) && this.waterBackend == WaterBackend.SF) {
            s7.o oVar = this.sfHost;
            if (oVar != null) {
                oVar.k();
            }
            this.sfHost = null;
        }
        s7.k kVar3 = this.instances.get(WAVE);
        if (kVar3 == null || !kVar3.getIsActive()) {
            if (this.waterBackend == WaterBackend.SF || (kVar = this.instances.get(WATER)) == null || !kVar.getIsActive()) {
                s7.o oVar2 = this.surfaceHost;
                if (oVar2 != null) {
                    oVar2.k();
                }
                this.surfaceHost = null;
                ViewParent parent = this.waveBandView.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.waveBandView);
                }
            }
        }
    }

    public final void L0() {
        s7.k kVarRemove = this.instances.remove(WATER);
        if (kVarRemove != null) {
            kVarRemove.release();
        }
        u0();
        s7.k kVar = this.instances.get(WAVE);
        if (kVar == null || !kVar.getIsActive()) {
            g1();
        }
        K0();
    }

    public final View M0() {
        View rootView = this.anchor.isAttachedToWindow() ? this.anchor : this.anchor.getRootView().isAttachedToWindow() ? this.anchor.getRootView() : null;
        if (rootView == null) {
            return null;
        }
        Context context = rootView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            Context context2 = this.anchor.getContext();
            activity = context2 instanceof Activity ? (Activity) context2 : null;
        }
        ViewGroup viewGroup = activity != null ? (ViewGroup) activity.findViewById(R.id.content) : null;
        return (viewGroup == null || !viewGroup.isAttachedToWindow()) ? rootView.getRootView() : viewGroup;
    }

    public final void N0() {
        this.glowBag.k(O.l(C3069i.a()));
        this.rippleBag.k(O.l(C3062b.a()));
        this.waterBag.k(O.l(C3064d.a()));
        this.waveBag.k(O.l(C3061a.a()));
        this.timingBag.k(w.INSTANCE.a());
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar != null) {
                W();
                z0(this, false, 1, null);
            }
        }
        s7.k kVar2 = this.instances.get(WAVE);
        if (kVar2 != null) {
            s7.k kVar3 = kVar2.getIsActive() ? kVar2 : null;
            if (kVar3 != null) {
                for (Map.Entry<String, float[]> entry : this.waveBag.l().entrySet()) {
                    String key = entry.getKey();
                    float[] value = entry.getValue();
                    if (!kotlin.jvm.internal.p.d(key, PX_PER_DP) && !kotlin.jvm.internal.p.d(key, "uWaveTime")) {
                        O.k(kVar3, key, value);
                    }
                }
            }
        }
        B0();
    }

    public final Map<String, float[]> Q0() {
        Map<String, float[]> mapL = this.rippleBag.l();
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(mapL.size()));
        Iterator<T> it = mapL.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(O.i((String) entry.getKey()), entry.getValue());
        }
        return linkedHashMap;
    }

    public final void R0(float f10) {
        this.speed = f10;
        this.glowOverlay.o(f10);
        Collection<s7.k> collectionValues = this.instances.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (s7.k kVar : collectionValues) {
            if (kVar.getIsActive()) {
                kVar.d(f10);
            }
        }
        B0();
    }

    public final void S0(float volume) {
        this.audioWave.c(volume);
    }

    public final void T0(final View root) {
        if (root.isAttachedToWindow()) {
            y0(true);
            O.h(this.sfPopup);
            root.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.motionkit.y
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceListenAnimation.U0(root, this);
                }
            });
        }
    }

    public final void V0(s7.o host, EffectDefinition effect, Map<String, float[]> vals, InterfaceC5074l<? super s7.j, Y8.t> config) {
        Map mapS = kotlin.collections.a.s(vals, Y8.j.a(PX_PER_DP, new float[]{host.getView().getResources().getDisplayMetrics().density}));
        s7.k kVarF = t7.j.f(t7.j.e(host), O.n(effect, mapS), config);
        if (kVarF == null) {
            Log.e("MKDemo", "play " + effect.getName() + " failed");
            return;
        }
        this.instances.put(effect.getName(), kVarF);
        kVarF.d(this.speed);
        for (Map.Entry entry : mapS.entrySet()) {
            O.k(kVarF, (String) entry.getKey(), (float[]) entry.getValue());
        }
    }

    public final void W() {
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null) {
            if (!kVar.getIsActive()) {
                kVar = null;
            }
            if (kVar == null) {
                return;
            }
            for (Map.Entry<String, float[]> entry : m1().entrySet()) {
                O.k(kVar, entry.getKey(), entry.getValue());
            }
            F0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        if (kotlinx.coroutines.d.f(r10, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W0(e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$1 r0 = (com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$1 r0 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r10)
            goto La0
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            kotlin.C4849c.b(r10)
            goto L7b
        L38:
            kotlin.C4849c.b(r10)
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.fingerUp
            r2 = 0
            r10.set(r2)
            r9.keyFeedbackHolding = r4
            com.stepos.ailauncher.chat.voice.motionkit.m r10 = r9.glowOverlay
            r10.p()
            r5 = 0
            r9.glowPlayAtMs = r5
            r9.ripplePlayAtMs = r5
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.glowBag
            float[] r5 = new float[r4]
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5[r2] = r6
            java.lang.String r7 = "uReleaseAt"
            r10.h(r7, r5, r2)
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.glowBag
            float[] r5 = new float[r4]
            r8 = 0
            r5[r2] = r8
            java.lang.String r8 = "uHoldMs"
            r10.h(r8, r5, r2)
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.rippleBag
            float[] r5 = new float[r4]
            r5[r2] = r6
            r10.h(r7, r5, r2)
            r0.label = r4
            java.lang.Object r10 = r9.i1(r0)
            if (r10 != r1) goto L7b
            goto L9f
        L7b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L8e
            java.lang.String r9 = "MKDemo"
            java.lang.String r10 = "startKeyFeedback waitReady failed"
            android.util.Log.e(r9, r10)
            Y8.t r9 = Y8.t.f7040a
            return r9
        L8e:
            r9.j0()
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2 r10 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startKeyFeedback$2
            r2 = 0
            r10.<init>(r9, r2)
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.d.f(r10, r0)
            if (r9 != r1) goto La0
        L9f:
            return r1
        La0:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.W0(e9.c):java.lang.Object");
    }

    public final void X(s7.j jVar) {
        int i10 = b.$EnumSwitchMapping$1[this.waterBackend.ordinal()];
        if (i10 == 1) {
            jVar.h();
        } else if (i10 == 2) {
            jVar.i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.C
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return VoiceListenAnimation.Y((s7.t) obj);
                }
            });
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            jVar.i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.D
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return VoiceListenAnimation.Z((s7.t) obj);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
    
        if (kotlinx.coroutines.d.f(r10, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$1 r0 = (com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$1 r0 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L35
            if (r2 != r3) goto L2d
            kotlin.C4849c.b(r10)
            goto La3
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.C4849c.b(r10)
            goto L7f
        L39:
            kotlin.C4849c.b(r10)
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.fingerUp
            r2 = 0
            r10.set(r2)
            r9.listenHolding = r5
            kotlinx.coroutines.g r10 = r9.waveRetireJob
            if (r10 == 0) goto L4b
            kotlinx.coroutines.g.Y0(r10, r4, r5, r4)
        L4b:
            r9.waveRetireJob = r4
            r6 = 0
            r9.waterPlayAtMs = r6
            r9.wavePlayAtMs = r6
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.waterBag
            float[] r6 = new float[r5]
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6[r2] = r7
            java.lang.String r8 = "uReleaseAt"
            r10.h(r8, r6, r2)
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.waveBag
            float[] r6 = new float[r5]
            r6[r2] = r7
            r10.h(r8, r6, r2)
            com.stepos.ailauncher.chat.voice.motionkit.q r10 = r9.waveBag
            float[] r6 = new float[r5]
            r6[r2] = r7
            java.lang.String r7 = "uStartAt"
            r10.h(r7, r6, r2)
            r0.label = r5
            java.lang.Object r10 = r9.i1(r0)
            if (r10 != r1) goto L7f
            goto La2
        L7f:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L92
            java.lang.String r9 = "MKDemo"
            java.lang.String r10 = "startListen waitReady failed"
            android.util.Log.e(r9, r10)
            Y8.t r9 = Y8.t.f7040a
            return r9
        L92:
            r9.j0()
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$2 r10 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$startListen$2
            r10.<init>(r9, r4)
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.d.f(r10, r0)
            if (r9 != r1) goto La3
        La2:
            return r1
        La3:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.X0(e9.c):java.lang.Object");
    }

    public final void Y0() {
        if (this.waterClockPosted) {
            return;
        }
        this.waterClockPosted = true;
        Choreographer.getInstance().postFrameCallback(this.waterClock);
    }

    public final void Z0() {
        s7.k kVar = this.instances.get(WAVE);
        if (kVar != null && kVar.getIsActive()) {
            H0();
            return;
        }
        s7.o oVarI0 = i0();
        if (oVarI0 == null) {
            return;
        }
        V0(oVarI0, EffectDefinition.b(C3061a.a(), null, null, null, null, null, false, null, 63, null), this.waveBag.l(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return VoiceListenAnimation.a1((s7.j) obj);
            }
        });
    }

    public final void a0(View root) {
        s7.k kVar;
        if (root == null) {
            return;
        }
        if (this.waterBackend == WaterBackend.SF && (kVar = this.instances.get(WATER)) != null && kVar.getIsActive()) {
            T0(root);
        } else {
            u0();
        }
    }

    public final C3077q b0(String effect) {
        switch (effect.hashCode()) {
            case -2133928387:
                if (effect.equals(GLOW_RIPPLE)) {
                    return this.rippleBag;
                }
                return null;
            case -2102728753:
                if (effect.equals(WAVE)) {
                    return this.waveBag;
                }
                return null;
            case -1789797270:
                if (effect.equals(TIMING)) {
                    return this.timingBag;
                }
                return null;
            case 2222509:
                if (effect.equals(GLOW)) {
                    return this.glowBag;
                }
                return null;
            case 1789338758:
                if (effect.equals(WATER)) {
                    return this.waterBag;
                }
                return null;
            default:
                return null;
        }
    }

    public final boolean c0() throws IOException {
        View viewM0 = M0();
        if (viewM0 == null) {
            return false;
        }
        if (viewM0 instanceof ViewGroup) {
            this.glowOverlay.f((ViewGroup) viewM0);
        }
        a0(viewM0);
        return true;
    }

    public final boolean c1(boolean keyFeedback) {
        if (this.fingerUp.get()) {
            return false;
        }
        return keyFeedback ? this.keyFeedbackHolding : this.listenHolding;
    }

    public final boolean d0() {
        return this.waterPlayAtMs <= 0 && this.ripplePlayAtMs <= 0;
    }

    public final void d1() {
        this.fingerUp.set(true);
        this.keyFeedbackHolding = false;
        this.listenHolding = false;
        kotlinx.coroutines.g gVar = this.keyFeedbackJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        kotlinx.coroutines.g gVar2 = this.listenJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        kotlinx.coroutines.g gVar3 = this.waveIntroJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        kotlinx.coroutines.g gVar4 = this.waveRetireJob;
        if (gVar4 != null) {
            kotlinx.coroutines.g.Y0(gVar4, null, 1, null);
        }
        this.keyFeedbackJob = null;
        this.listenJob = null;
        this.waveIntroJob = null;
        this.waveRetireJob = null;
        this.glowOverlay.p();
        g1();
        Collection<s7.k> collectionValues = this.instances.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((s7.k) it.next()).release();
        }
        this.instances.clear();
        u0();
        K0();
        B0();
    }

    public final Object e0(float f10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objA;
        long jE = (long) ((C5685n.e(f10, 0.0f) * 1000.0f) / C5685n.e(this.speed, 0.01f));
        return (jE <= 0 || (objA = Ua.U.a(jE, interfaceC4014c)) != C4063a.g()) ? Y8.t.f7040a : objA;
    }

    public final void e1() {
        kotlinx.coroutines.g gVar = this.keyFeedbackJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.keyFeedbackJob = null;
        this.keyFeedbackHolding = false;
        this.glowOverlay.p();
        this.glowPlayAtMs = 0L;
        this.ripplePlayAtMs = 0L;
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null) {
            kVar.g("uRippleTime", -1.0f);
        }
        if (d0()) {
            L0();
        }
    }

    public final void f0() {
        d1();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        this.anchor.removeOnAttachStateChangeListener(this.attachWaiter);
        this.glowOverlay.h();
        s7.o oVar = this.surfaceHost;
        if (oVar != null) {
            oVar.k();
        }
        s7.o oVar2 = this.sfHost;
        if (oVar2 != null) {
            oVar2.k();
        }
        if (this.sfPopup.isShowing()) {
            this.sfPopup.dismiss();
        }
        this.listeners.clear();
    }

    public final void f1() {
        kotlinx.coroutines.g gVar = this.listenJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.listenJob = null;
        kotlinx.coroutines.g gVar2 = this.waveIntroJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.waveIntroJob = null;
        kotlinx.coroutines.g gVar3 = this.waveRetireJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.waveRetireJob = null;
        this.listenHolding = false;
        this.waterPlayAtMs = 0L;
        this.wavePlayAtMs = 0L;
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null) {
            kVar.g("uListenTime", -1.0f);
        }
        s7.k kVarRemove = this.instances.remove(WAVE);
        if (kVarRemove != null) {
            kVarRemove.release();
        }
        if (d0()) {
            L0();
        }
        K0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$driveWaveIntro$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$driveWaveIntro$1 r0 = (com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$driveWaveIntro$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$driveWaveIntro$1 r0 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$driveWaveIntro$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            float r2 = r0.F$0
            long r4 = r0.J$0
            java.lang.Object r6 = r0.L$0
            s7.k r6 = (s7.k) r6
            kotlin.C4849c.b(r11)
            goto L4e
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.C4849c.b(r11)
            long r4 = android.os.SystemClock.elapsedRealtime()
            com.stepos.ailauncher.chat.voice.motionkit.x r11 = r10.timing
            float r11 = r11.d()
            r2 = 1028443341(0x3d4ccccd, float:0.05)
            float r11 = v9.C5685n.e(r11, r2)
            r2 = r11
        L4e:
            java.util.LinkedHashMap<java.lang.String, s7.k> r11 = r10.instances
            java.lang.String r6 = "AudioWave"
            java.lang.Object r11 = r11.get(r6)
            s7.k r11 = (s7.k) r11
            if (r11 == 0) goto Lae
            boolean r6 = r11.getIsActive()
            if (r6 == 0) goto L61
            goto L62
        L61:
            r11 = 0
        L62:
            if (r11 != 0) goto L65
            goto Lae
        L65:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r4
            float r6 = (float) r6
            r7 = 1148846080(0x447a0000, float:1000.0)
            float r6 = r6 / r7
            float r7 = r10.speed
            r8 = 1008981770(0x3c23d70a, float:0.01)
            float r7 = v9.C5685n.e(r7, r8)
            float r6 = r6 * r7
            float r6 = r6 / r2
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            float r6 = v9.C5685n.m(r6, r7, r8)
            com.stepos.ailauncher.chat.voice.motionkit.g r7 = com.stepos.ailauncher.chat.voice.motionkit.C3068h.e()
            float r7 = r7.a(r6)
            java.lang.String r9 = "uIntro"
            r11.g(r9, r7)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto L95
            Y8.t r10 = Y8.t.f7040a
            return r10
        L95:
            java.lang.Object r11 = g9.h.a(r11)
            r0.L$0 = r11
            r0.J$0 = r4
            r0.F$0 = r2
            r0.F$1 = r6
            r0.F$2 = r7
            r0.label = r3
            r6 = 16
            java.lang.Object r11 = Ua.U.a(r6, r0)
            if (r11 != r1) goto L4e
            return r1
        Lae:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.g0(e9.c):java.lang.Object");
    }

    public final void g1() {
        if (this.waterClockPosted) {
            this.waterClockPosted = false;
            Choreographer.getInstance().removeFrameCallback(this.waterClock);
        }
    }

    public final s7.o h0() {
        s7.o oVar = this.sfHost;
        if (oVar != null) {
            return oVar;
        }
        s7.o oVarC = t7.j.c(s7.o.INSTANCE, this.sfHostView);
        t7.j.e(oVarC).a(0);
        this.sfHost = oVarC;
        return oVarC;
    }

    public final s7.o i0() {
        View viewM0 = M0();
        ViewGroup viewGroup = viewM0 instanceof ViewGroup ? (ViewGroup) viewM0 : null;
        if (viewGroup == null) {
            return this.surfaceHost;
        }
        A0(viewGroup);
        s7.o oVar = this.surfaceHost;
        if (oVar != null) {
            return oVar;
        }
        s7.o oVarC = t7.j.c(s7.o.INSTANCE, this.waveBandView);
        t7.j.e(oVarC).a(0);
        this.surfaceHost = oVarC;
        return oVarC;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:23:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00a2 -> B:48:0x00a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i1(e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$waitReady$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$waitReady$1 r0 = (com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$waitReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$waitReady$1 r0 = new com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$waitReady$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 16
            r5 = 60
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L46
            if (r2 == r8) goto L40
            if (r2 != r6) goto L38
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$0
            android.view.View r2 = (android.view.View) r2
            kotlin.C4849c.b(r11)
            goto La5
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            int r2 = r0.I$0
            kotlin.C4849c.b(r11)
            goto L5d
        L46:
            kotlin.C4849c.b(r11)
            r2 = r7
        L4a:
            boolean r11 = r10.c0()
            if (r11 != 0) goto L5f
            if (r2 >= r5) goto L5f
            r0.I$0 = r2
            r0.label = r8
            java.lang.Object r11 = Ua.U.a(r3, r0)
            if (r11 != r1) goto L5d
            goto La4
        L5d:
            int r2 = r2 + r8
            goto L4a
        L5f:
            s7.o r11 = r10.l1()
            if (r11 != 0) goto L6a
            java.lang.Boolean r10 = g9.C4109a.a(r7)
            return r10
        L6a:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$WaterBackend r11 = r10.waterBackend
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$WaterBackend r2 = com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.WaterBackend.SF
            if (r11 != r2) goto L79
            android.view.View r11 = r10.M0()
            if (r11 == 0) goto L79
            r10.T0(r11)
        L79:
            com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation$WaterBackend r11 = r10.waterBackend
            if (r11 != r2) goto L80
            android.widget.FrameLayout r10 = r10.sfHostView
            goto L84
        L80:
            android.view.View r10 = r10.M0()
        L84:
            r2 = r10
            r10 = r7
        L86:
            r11 = 64
            if (r2 == 0) goto L96
            boolean r9 = r2.isAttachedToWindow()
            if (r9 == 0) goto L96
            int r9 = r2.getWidth()
            if (r9 >= r11) goto La7
        L96:
            if (r10 >= r5) goto La7
            r0.L$0 = r2
            r0.I$0 = r10
            r0.label = r6
            java.lang.Object r11 = Ua.U.a(r3, r0)
            if (r11 != r1) goto La5
        La4:
            return r1
        La5:
            int r10 = r10 + r8
            goto L86
        La7:
            if (r2 == 0) goto Lb6
            boolean r10 = r2.isAttachedToWindow()
            if (r10 == 0) goto Lb6
            int r10 = r2.getWidth()
            if (r10 < r11) goto Lb6
            r7 = r8
        Lb6:
            java.lang.Boolean r10 = g9.C4109a.a(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation.i1(e9.c):java.lang.Object");
    }

    public final void j0() {
        View viewM0;
        if (this.waterBackend == WaterBackend.SF && (viewM0 = M0()) != null) {
            T0(viewM0);
        }
        s7.k kVar = this.instances.get(WATER);
        if (kVar != null && kVar.getIsActive()) {
            W();
            z0(this, false, 1, null);
            return;
        }
        s7.o oVarL1 = l1();
        if (oVarL1 == null) {
            return;
        }
        V0(oVarL1, C3064d.a(), kotlin.collections.a.r(m1(), Q0()), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return VoiceListenAnimation.k0(this.f26493a, (s7.j) obj);
            }
        });
        s7.k kVar2 = this.instances.get(WATER);
        if (kVar2 != null) {
            kVar2.g("uListenTime", -1.0f);
        }
        s7.k kVar3 = this.instances.get(WATER);
        if (kVar3 != null) {
            kVar3.g("uRippleTime", -1.0f);
        }
        z0(this, false, 1, null);
    }

    /* renamed from: l0, reason: from getter */
    public final C3066f getAudioWave() {
        return this.audioWave;
    }

    public final s7.o l1() {
        int i10 = b.$EnumSwitchMapping$1[this.waterBackend.ordinal()];
        if (i10 == 1) {
            return h0();
        }
        if (i10 == 2 || i10 == 3) {
            return i0();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: m0, reason: from getter */
    public final C3070j getGlow() {
        return this.glow;
    }

    public final Map<String, float[]> m1() {
        Map<String, float[]> mapL = this.waterBag.l();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, float[]> entry : mapL.entrySet()) {
            String key = entry.getKey();
            if (!RUNTIME_WATER.contains(key) && !O.g(key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: n0, reason: from getter */
    public final T getGlowRipple() {
        return this.glowRipple;
    }

    /* renamed from: o0, reason: from getter */
    public final float getSpeed() {
        return this.speed;
    }

    /* renamed from: p0, reason: from getter */
    public final x getTiming() {
        return this.timing;
    }

    /* renamed from: q0, reason: from getter */
    public final T getWaterDrop() {
        return this.waterDrop;
    }

    public final void u0() {
        this.lastOverlay.setEmpty();
        this.lastScreenBox.setEmpty();
        if (this.sfPopup.isShowing()) {
            this.sfPopup.dismiss();
        }
    }

    public final void v0() {
        C1060i.d(this.scope, null, null, new VoiceListenAnimation$launchListenRetire$1(this, null), 3, null);
    }

    public final void w0() {
        C1060i.d(this.scope, null, null, new VoiceListenAnimation$launchRippleRetire$1(this, null), 3, null);
    }

    public final void x0() {
        float fG = this.waveBag.g("uExitDur");
        if (fG <= 0.0f) {
            fG = 0.433f;
        }
        kotlinx.coroutines.g gVar = this.waveRetireJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.waveRetireJob = C1060i.d(this.scope, null, null, new VoiceListenAnimation$launchWaveRetire$1(fG, this, null), 3, null);
    }

    public final void y0(boolean showIfNeeded) {
        View viewM0;
        if (this.waterBackend == WaterBackend.SF && (viewM0 = M0()) != null) {
            View rootView = viewM0.getRootView();
            int width = rootView.getWidth();
            int height = rootView.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            boolean z10 = true;
            boolean z11 = this.listenHolding || this.waterPlayAtMs > 0;
            if (!this.keyFeedbackHolding && this.ripplePlayAtMs <= 0) {
                z10 = false;
            }
            s7.k kVar = null;
            Rect rectA = S.INSTANCE.a(z11 ? this.waterBag : null, z10 ? this.rippleBag : null, width, height, viewM0.getResources().getDisplayMetrics().density);
            if (rectA == null) {
                return;
            }
            int iMin = (rectA.left / 32) * 32;
            int iMin2 = (rectA.top / 32) * 32;
            int iMax = ((rectA.right + 31) / 32) * 32;
            int iMax2 = ((rectA.bottom + 31) / 32) * 32;
            if (!this.lastScreenBox.isEmpty()) {
                iMin = Math.min(iMin, this.lastScreenBox.left);
                iMin2 = Math.min(iMin2, this.lastScreenBox.top);
                iMax = Math.max(iMax, this.lastScreenBox.right);
                iMax2 = Math.max(iMax2, this.lastScreenBox.bottom);
            }
            this.lastScreenBox.set(iMin, iMin2, iMax, iMax2);
            int iF = C5685n.f(iMax - iMin, 32);
            int iF2 = C5685n.f(iMax2 - iMin2, 32);
            s7.k kVar2 = this.instances.get(WATER);
            if (kVar2 != null && kVar2.getIsActive()) {
                kVar = kVar2;
            }
            if (kVar != null) {
                kVar.c("uScreenSize", width, height);
            }
            if (kVar != null) {
                kVar.c("uViewOrigin", iMin, iMin2);
            }
            if (kVar != null) {
                kVar.g("uCoordScale", 1.0f);
            }
            Rect rect = this.lastOverlay;
            if (rect.left == iMin && rect.top == iMin2 && rect.right == iMin + iF && rect.bottom == iMin2 + iF2) {
                if (showIfNeeded && !this.sfPopup.isShowing() && viewM0.isAttachedToWindow()) {
                    this.sfPopup.showAtLocation(viewM0, 0, iMin, iMin2);
                    return;
                }
                return;
            }
            rect.set(iMin, iMin2, iMin + iF, iMin2 + iF2);
            if (this.sfPopup.isShowing()) {
                this.sfPopup.update(iMin, iMin2, iF, iF2);
            } else if (showIfNeeded && viewM0.isAttachedToWindow()) {
                this.sfPopup.setWidth(iF);
                this.sfPopup.setHeight(iF2);
                this.sfPopup.showAtLocation(viewM0, 0, iMin, iMin2);
            }
        }
    }
}
