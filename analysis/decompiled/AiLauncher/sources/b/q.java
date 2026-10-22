package b;

import V0.CreationExtras;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.C1382Y;
import android.view.C1399q;
import android.view.InterfaceC1391i;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.Menu;
import android.view.MenuItem;
import android.view.U;
import android.view.V;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.W;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.view.C1328p;
import androidx.core.view.InterfaceC1325m;
import b.q;
import c.C1479a;
import c.InterfaceC1480b;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import d.AbstractC3936b;
import d.AbstractC3939e;
import d.InterfaceC3935a;
import d.InterfaceC3940f;
import e.AbstractC3969a;
import g1.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4848b;
import kotlin.Metadata;
import o1.C4996a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 Ü\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\u00022\u00020\t2\u00020\n2\u00020\u00022\u00020\u000b2\u00020\f2\u00020\u00022\u00020\r2\u00020\u000e:\nÝ\u0001Þ\u0001ß\u0001à\u0001á\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010B\u0013\b\u0017\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001dH\u0015¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b%\u0010$J\u0019\u0010'\u001a\u00020\u00142\b\b\u0001\u0010&\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010\u0013J\u0019\u0010'\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b'\u0010*J#\u0010'\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b'\u0010-J#\u0010.\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u0014H\u0017¢\u0006\u0004\b/\u0010\u0010J\u0011\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00142\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\u00142\u0006\u00104\u001a\u000203¢\u0006\u0004\b7\u00106J)\u0010<\u001a\u00020;2\u0006\u00108\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u00020;2\u0006\u00108\u001a\u00020\u00112\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020;2\u0006\u00108\u001a\u00020\u00112\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00112\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\u00142\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u001f\u0010H\u001a\u00020\u00142\u0006\u0010G\u001a\u00020F2\u0006\u0010J\u001a\u00020\u0003H\u0016¢\u0006\u0004\bH\u0010KJ'\u0010H\u001a\u00020\u00142\u0006\u0010G\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00032\u0006\u0010M\u001a\u00020LH\u0017¢\u0006\u0004\bH\u0010NJ\u0017\u0010O\u001a\u00020\u00142\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bO\u0010IJ\u000f\u0010P\u001a\u00020\u0014H\u0016¢\u0006\u0004\bP\u0010\u0010J\u000f\u0010Q\u001a\u00020\u0014H\u0017¢\u0006\u0004\bQ\u0010\u0010J\u001f\u0010U\u001a\u00020\u00142\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0011H\u0017¢\u0006\u0004\bU\u0010VJ)\u0010U\u001a\u00020\u00142\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010\u001dH\u0017¢\u0006\u0004\bU\u0010XJA\u0010^\u001a\u00020\u00142\u0006\u0010S\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010R2\u0006\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u0011H\u0017¢\u0006\u0004\b^\u0010_JK\u0010^\u001a\u00020\u00142\u0006\u0010S\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010R2\u0006\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010\u001dH\u0017¢\u0006\u0004\b^\u0010`J)\u0010c\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010RH\u0015¢\u0006\u0004\bc\u0010dJ-\u0010j\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\u00112\f\u0010g\u001a\b\u0012\u0004\u0012\u00020f0e2\u0006\u0010i\u001a\u00020hH\u0017¢\u0006\u0004\bj\u0010kJI\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t\"\u0004\b\u0000\u0010l\"\u0004\b\u0001\u0010m2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010n2\u0006\u0010q\u001a\u00020p2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r¢\u0006\u0004\bu\u0010vJA\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000t\"\u0004\b\u0000\u0010l\"\u0004\b\u0001\u0010m2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010n2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00010r¢\u0006\u0004\bu\u0010wJ\u0017\u0010z\u001a\u00020\u00142\u0006\u0010y\u001a\u00020xH\u0017¢\u0006\u0004\bz\u0010{J\u001b\u0010}\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020x0|¢\u0006\u0004\b}\u0010~J\u001b\u0010\u007f\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020x0|¢\u0006\u0004\b\u007f\u0010~J\u001a\u0010\u0081\u0001\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020\u0011H\u0017¢\u0006\u0005\b\u0081\u0001\u0010\u0013J\u001d\u0010\u0082\u0001\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110|¢\u0006\u0005\b\u0082\u0001\u0010~J\u001d\u0010\u0083\u0001\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110|¢\u0006\u0005\b\u0083\u0001\u0010~J\u001a\u0010\u0084\u0001\u001a\u00020\u00142\u0006\u0010S\u001a\u00020RH\u0015¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001d\u0010\u0086\u0001\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020R0|¢\u0006\u0005\b\u0086\u0001\u0010~J\u001d\u0010\u0087\u0001\u001a\u00020\u00142\f\u00104\u001a\b\u0012\u0004\u0012\u00020R0|¢\u0006\u0005\b\u0087\u0001\u0010~J\u001b\u0010\u0089\u0001\u001a\u00020\u00142\u0007\u0010\u0088\u0001\u001a\u00020;H\u0017¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J#\u0010\u0089\u0001\u001a\u00020\u00142\u0007\u0010\u0088\u0001\u001a\u00020;2\u0006\u0010y\u001a\u00020xH\u0017¢\u0006\u0006\b\u0089\u0001\u0010\u008b\u0001J\u001e\u0010\u008d\u0001\u001a\u00020\u00142\r\u00104\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010|¢\u0006\u0005\b\u008d\u0001\u0010~J\u001e\u0010\u008e\u0001\u001a\u00020\u00142\r\u00104\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010|¢\u0006\u0005\b\u008e\u0001\u0010~J\u001b\u0010\u0090\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020;H\u0017¢\u0006\u0006\b\u0090\u0001\u0010\u008a\u0001J#\u0010\u0090\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020;2\u0006\u0010y\u001a\u00020xH\u0017¢\u0006\u0006\b\u0090\u0001\u0010\u008b\u0001J\u001e\u0010\u0092\u0001\u001a\u00020\u00142\r\u00104\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010|¢\u0006\u0005\b\u0092\u0001\u0010~J\u001e\u0010\u0093\u0001\u001a\u00020\u00142\r\u00104\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010|¢\u0006\u0005\b\u0093\u0001\u0010~J\u0011\u0010\u0094\u0001\u001a\u00020\u0014H\u0015¢\u0006\u0005\b\u0094\u0001\u0010\u0010J\u0019\u0010\u0096\u0001\u001a\u00020\u00142\u0007\u00104\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\u00142\u0007\u00104\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u0097\u0001J\u0011\u0010\u0099\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b\u0099\u0001\u0010\u0010R\u0018\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001f\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b¡\u0001\u0010¢\u0001\u0012\u0005\b£\u0001\u0010\u0010R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0017\u0010§\u0001\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R!\u0010®\u0001\u001a\u00030©\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010lR\u0018\u0010°\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001c\u0010²\u0001\u001a\u00020p8\u0006¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R$\u0010·\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0|0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R$\u0010¹\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110|0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010¸\u0001R$\u0010º\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0|0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010¸\u0001R%\u0010»\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010|0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¸\u0001R%\u0010¼\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0091\u00010|0¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010¸\u0001R\u001f\u0010½\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¸\u0001R\u0019\u0010¾\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¿\u0001R!\u0010Å\u0001\u001a\u00030Á\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bÂ\u0001\u0010«\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R'\u0010Ê\u0001\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\u0017\n\u0006\bÆ\u0001\u0010«\u0001\u0012\u0005\bÉ\u0001\u0010\u0010\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0018\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00028WX\u0096\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010$R\u0018\u0010Ð\u0001\u001a\u00030Í\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010Ó\u0001\u001a\u00030¤\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010×\u0001\u001a\u00030Ô\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0015\u0010Û\u0001\u001a\u00030Ø\u00018F¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001¨\u0006â\u0001"}, d2 = {"Lb/q;", "Landroidx/core/app/f;", "", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/W;", "Landroidx/lifecycle/i;", "Lg1/h;", "Lb/L;", "Ld/f;", "Landroidx/core/content/c;", "Landroidx/core/content/d;", "Landroidx/core/app/n;", "Landroidx/core/app/o;", "Landroidx/core/view/m;", "Lb/F;", "<init>", "()V", "", "contentLayoutId", "(I)V", "LY8/t;", "ensureViewModelStore", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "addObserverForBackInvoker", "(Landroidx/activity/OnBackPressedDispatcher;)V", "Lb/q$e;", "createFullyDrawnExecutor", "()Lb/q$e;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onRetainNonConfigurationInstance", "()Ljava/lang/Object;", "onRetainCustomNonConfigurationInstance", "layoutResID", "setContentView", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "initializeViewTreeOwners", "Landroid/content/Context;", "peekAvailableContext", "()Landroid/content/Context;", "Lc/b;", "listener", "addOnContextAvailableListener", "(Lc/b;)V", "removeOnContextAvailableListener", "featureId", "Landroid/view/Menu;", ChatTracker.TOPBAR_MENU, "", "onPreparePanel", "(ILandroid/view/View;Landroid/view/Menu;)Z", "onCreatePanelMenu", "(ILandroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onMenuItemSelected", "(ILandroid/view/MenuItem;)Z", "onPanelClosed", "(ILandroid/view/Menu;)V", "Landroidx/core/view/r;", Const.JSON_KEY_PROVIDER, "addMenuProvider", "(Landroidx/core/view/r;)V", "owner", "(Landroidx/core/view/r;Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$State;", VoiceWakeupReceiver.EXTRA_STATE, "(Landroidx/core/view/r;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;)V", "removeMenuProvider", "invalidateMenu", "onBackPressed", "Landroid/content/Intent;", "intent", "requestCode", "startActivityForResult", "(Landroid/content/Intent;I)V", "options", "(Landroid/content/Intent;ILandroid/os/Bundle;)V", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startIntentSenderForResult", "(Landroid/content/IntentSender;ILandroid/content/Intent;III)V", "(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "I", "O", "Le/a;", "contract", "Ld/e;", "registry", "Ld/a;", "callback", "Ld/b;", "registerForActivityResult", "(Le/a;Ld/e;Ld/a;)Ld/b;", "(Le/a;Ld/a;)Ld/b;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "LB0/a;", "addOnConfigurationChangedListener", "(LB0/a;)V", "removeOnConfigurationChangedListener", "level", "onTrimMemory", "addOnTrimMemoryListener", "removeOnTrimMemoryListener", "onNewIntent", "(Landroid/content/Intent;)V", "addOnNewIntentListener", "removeOnNewIntentListener", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "(ZLandroid/content/res/Configuration;)V", "Landroidx/core/app/g;", "addOnMultiWindowModeChangedListener", "removeOnMultiWindowModeChangedListener", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroidx/core/app/q;", "addOnPictureInPictureModeChangedListener", "removeOnPictureInPictureModeChangedListener", "onUserLeaveHint", "Ljava/lang/Runnable;", "addOnUserLeaveHintListener", "(Ljava/lang/Runnable;)V", "removeOnUserLeaveHintListener", "reportFullyDrawn", "Lc/a;", "contextAwareHelper", "Lc/a;", "Landroidx/core/view/p;", "menuHostHelper", "Landroidx/core/view/p;", "Lg1/g;", "savedStateRegistryController", "Lg1/g;", "getSavedStateRegistryController$annotations", "Landroidx/lifecycle/V;", "_viewModelStore", "Landroidx/lifecycle/V;", "reportFullyDrawnExecutor", "Lb/q$e;", "Lb/E;", "fullyDrawnReporter$delegate", "LY8/h;", "getFullyDrawnReporter", "()Lb/E;", "fullyDrawnReporter", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "activityResultRegistry", "Ld/e;", "getActivityResultRegistry", "()Ld/e;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onTrimMemoryListeners", "onNewIntentListeners", "onMultiWindowModeChangedListeners", "onPictureInPictureModeChangedListeners", "onUserLeaveHintListeners", "dispatchingOnMultiWindowModeChanged", "Z", "dispatchingOnPictureInPictureModeChanged", "Landroidx/lifecycle/U$c;", "defaultViewModelProviderFactory$delegate", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/U$c;", "defaultViewModelProviderFactory", "onBackPressedDispatcher$delegate", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "onBackPressedDispatcher", "getLastCustomNonConfigurationInstance", "lastCustomNonConfigurationInstance", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "getViewModelStore", "()Landroidx/lifecycle/V;", "viewModelStore", "LV0/a;", "getDefaultViewModelCreationExtras", "()LV0/a;", "defaultViewModelCreationExtras", "Lg1/e;", "getSavedStateRegistry", "()Lg1/e;", "savedStateRegistry", "Companion", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "e", "f", "c", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class q extends androidx.core.app.f implements LifecycleOwner, W, InterfaceC1391i, g1.h, L, InterfaceC3940f, androidx.core.content.c, androidx.core.content.d, androidx.core.app.n, androidx.core.app.o, InterfaceC1325m, InterfaceC1416F {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final c Companion = new c(null);
    private V _viewModelStore;
    private final AbstractC3939e activityResultRegistry;
    private int contentLayoutId;
    private final C1479a contextAwareHelper;

    /* renamed from: defaultViewModelProviderFactory$delegate, reason: from kotlin metadata */
    private final Y8.h defaultViewModelProviderFactory;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;

    /* renamed from: fullyDrawnReporter$delegate, reason: from kotlin metadata */
    private final Y8.h fullyDrawnReporter;
    private final C1328p menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;

    /* renamed from: onBackPressedDispatcher$delegate, reason: from kotlin metadata */
    private final Y8.h onBackPressedDispatcher;
    private final CopyOnWriteArrayList<B0.a<Configuration>> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<B0.a<androidx.core.app.g>> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<B0.a<Intent>> onNewIntentListeners;
    private final CopyOnWriteArrayList<B0.a<androidx.core.app.q>> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<B0.a<Integer>> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final e reportFullyDrawnExecutor;
    private final g1.g savedStateRegistryController;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"b/q$a", "Landroidx/lifecycle/m;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements InterfaceC1395m {
        public a() {
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(event, "event");
            q.this.ensureViewModelStore();
            q.this.getLifecycle().d(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lb/q$b;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/window/OnBackInvokedDispatcher;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)Landroid/window/OnBackInvokedDispatcher;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15206a = new b();

        public final OnBackInvokedDispatcher a(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            kotlin.jvm.internal.p.h(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            return onBackInvokedDispatcher;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lb/q$c;", "", "<init>", "()V", "", "ACTIVITY_RESULT_TAG", "Ljava/lang/String;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
            this();
        }

        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lb/q$d;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "()Ljava/lang/Object;", "c", "(Ljava/lang/Object;)V", "custom", "Landroidx/lifecycle/V;", Const.INTENT_KEY_PKGNAME, "Landroidx/lifecycle/V;", "()Landroidx/lifecycle/V;", Const.INTENT_KEY_UMID, "(Landroidx/lifecycle/V;)V", "viewModelStore", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Object custom;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public V viewModelStore;

        /* renamed from: a, reason: from getter */
        public final Object getCustom() {
            return this.custom;
        }

        /* renamed from: b, reason: from getter */
        public final V getViewModelStore() {
            return this.viewModelStore;
        }

        public final void c(Object obj) {
            this.custom = obj;
        }

        public final void d(V v10) {
            this.viewModelStore = v10;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bb\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lb/q$e;", "Ljava/util/concurrent/Executor;", "Landroid/view/View;", "view", "LY8/t;", "Y", "(Landroid/view/View;)V", "l", "()V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface e extends Executor {
        void Y(View view);

        void l();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u000fR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lb/q$f;", "Lb/q$e;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Ljava/lang/Runnable;", "<init>", "(Lb/q;)V", "Landroid/view/View;", "view", "LY8/t;", "Y", "(Landroid/view/View;)V", "l", "()V", "runnable", "execute", "(Ljava/lang/Runnable;)V", "onDraw", "run", "", Const.INTENT_KEY_APIKEY, "J", "getEndWatchTimeMillis", "()J", "endWatchTimeMillis", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Runnable;", "getCurrentRunnable", "()Ljava/lang/Runnable;", "setCurrentRunnable", "currentRunnable", "", "c", "Z", "getOnDrawScheduled", "()Z", "setOnDrawScheduled", "(Z)V", "onDrawScheduled", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class f implements e, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long endWatchTimeMillis = SystemClock.uptimeMillis() + 10000;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public Runnable currentRunnable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean onDrawScheduled;

        public f() {
        }

        public static final void b(f fVar) {
            Runnable runnable = fVar.currentRunnable;
            if (runnable != null) {
                kotlin.jvm.internal.p.f(runnable);
                runnable.run();
                fVar.currentRunnable = null;
            }
        }

        @Override // b.q.e
        public void Y(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            if (this.onDrawScheduled) {
                return;
            }
            this.onDrawScheduled = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            kotlin.jvm.internal.p.i(runnable, "runnable");
            this.currentRunnable = runnable;
            View decorView = q.this.getWindow().getDecorView();
            kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
            if (!this.onDrawScheduled) {
                decorView.postOnAnimation(new Runnable() { // from class: b.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.f.b(this.f15214a);
                    }
                });
            } else if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // b.q.e
        public void l() {
            q.this.getWindow().getDecorView().removeCallbacks(this);
            q.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.currentRunnable;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                    this.onDrawScheduled = false;
                    q.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.currentRunnable = null;
            if (q.this.getFullyDrawnReporter().c()) {
                this.onDrawScheduled = false;
                q.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JI\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00028\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"b/q$g", "Ld/e;", "I", "O", "", "requestCode", "Le/a;", "contract", "input", "Landroidx/core/app/c;", "options", "LY8/t;", "k", "(ILe/a;Ljava/lang/Object;Landroidx/core/app/c;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends AbstractC3939e {
        public g() {
        }

        public static final void u(g gVar, int i10, AbstractC3969a.C0391a c0391a) {
            gVar.g(i10, c0391a.a());
        }

        public static final void v(g gVar, int i10, IntentSender.SendIntentException sendIntentException) {
            gVar.f(i10, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
        }

        @Override // d.AbstractC3939e
        public <I, O> void k(final int requestCode, AbstractC3969a<I, O> contract, I input, androidx.core.app.c options) {
            Bundle bundleD;
            final int i10;
            kotlin.jvm.internal.p.i(contract, "contract");
            q qVar = q.this;
            final AbstractC3969a.C0391a<O> c0391aB = contract.b(qVar, input);
            if (c0391aB != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.g.u(this.f15215a, requestCode, c0391aB);
                    }
                });
                return;
            }
            Intent intentA = contract.a(qVar, input);
            if (intentA.getExtras() != null) {
                Bundle extras = intentA.getExtras();
                kotlin.jvm.internal.p.f(extras);
                if (extras.getClassLoader() == null) {
                    intentA.setExtrasClassLoader(qVar.getClassLoader());
                }
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleD = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleD = options != null ? options.d() : null;
            }
            Bundle bundle = bundleD;
            if (kotlin.jvm.internal.p.d("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.r(qVar, stringArrayExtra, requestCode);
                return;
            }
            if (!kotlin.jvm.internal.p.d("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", intentA.getAction())) {
                androidx.core.app.a.v(qVar, intentA, requestCode, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                kotlin.jvm.internal.p.f(intentSenderRequest);
                i10 = requestCode;
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                i10 = requestCode;
            }
            try {
                androidx.core.app.a.w(qVar, intentSenderRequest.getIntentSender(), i10, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                Y8.t tVar = Y8.t.f7040a;
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                final IntentSender.SendIntentException sendIntentException = e;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.g.v(this.f15218a, i10, sendIntentException);
                    }
                });
            }
        }
    }

    public q() {
        this.contextAwareHelper = new C1479a();
        this.menuHostHelper = new C1328p(new Runnable() { // from class: b.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f15191a.invalidateMenu();
            }
        });
        g1.g gVarB = g1.g.INSTANCE.b(this);
        this.savedStateRegistryController = gVarB;
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        this.fullyDrawnReporter = C4848b.b(new InterfaceC5063a() { // from class: b.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.fullyDrawnReporter_delegate$lambda$2(this.f15195a);
            }
        });
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new g();
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new InterfaceC1395m() { // from class: b.i
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                q._init_$lambda$4(this.f15196a, lifecycleOwner, event);
            }
        });
        getLifecycle().a(new InterfaceC1395m() { // from class: b.j
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                q._init_$lambda$5(this.f15197a, lifecycleOwner, event);
            }
        });
        getLifecycle().a(new a());
        gVarB.c();
        android.view.I.c(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new e.b() { // from class: b.k
            @Override // g1.e.b
            public final Bundle a() {
                return q._init_$lambda$6(this.f15198a);
            }
        });
        addOnContextAvailableListener(new InterfaceC1480b() { // from class: b.l
            @Override // c.InterfaceC1480b
            public final void a(Context context) {
                q._init_$lambda$7(this.f15199a, context);
            }
        });
        this.defaultViewModelProviderFactory = C4848b.b(new InterfaceC5063a() { // from class: b.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.defaultViewModelProviderFactory_delegate$lambda$9(this.f15200a);
            }
        });
        this.onBackPressedDispatcher = C4848b.b(new InterfaceC5063a() { // from class: b.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.onBackPressedDispatcher_delegate$lambda$13(this.f15201a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(q qVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Window window;
        View viewPeekDecorView;
        kotlin.jvm.internal.p.i(lifecycleOwner, "<unused var>");
        kotlin.jvm.internal.p.i(event, "event");
        if (event != Lifecycle.Event.ON_STOP || (window = qVar.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(q qVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        kotlin.jvm.internal.p.i(lifecycleOwner, "<unused var>");
        kotlin.jvm.internal.p.i(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            qVar.contextAwareHelper.b();
            if (!qVar.isChangingConfigurations()) {
                qVar.getViewModelStore().a();
            }
            qVar.reportFullyDrawnExecutor.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle _init_$lambda$6(q qVar) {
        Bundle bundle = new Bundle();
        qVar.activityResultRegistry.m(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(q qVar, Context it) {
        kotlin.jvm.internal.p.i(it, "it");
        Bundle bundleA = qVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            qVar.activityResultRegistry.l(bundleA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addObserverForBackInvoker(final OnBackPressedDispatcher dispatcher) {
        getLifecycle().a(new InterfaceC1395m() { // from class: b.f
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                q.addObserverForBackInvoker$lambda$14(dispatcher, this, lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addObserverForBackInvoker$lambda$14(OnBackPressedDispatcher onBackPressedDispatcher, q qVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        kotlin.jvm.internal.p.i(lifecycleOwner, "<unused var>");
        kotlin.jvm.internal.p.i(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            onBackPressedDispatcher.t(b.f15206a.a(qVar));
        }
    }

    private final e createFullyDrawnExecutor() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.view.M defaultViewModelProviderFactory_delegate$lambda$9(q qVar) {
        return new android.view.M(qVar.getApplication(), qVar, qVar.getIntent() != null ? qVar.getIntent().getExtras() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureViewModelStore() {
        if (this._viewModelStore == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this._viewModelStore = dVar.getViewModelStore();
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new V();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1415E fullyDrawnReporter_delegate$lambda$2(final q qVar) {
        return new C1415E(qVar.reportFullyDrawnExecutor, new InterfaceC5063a() { // from class: b.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.fullyDrawnReporter_delegate$lambda$2$lambda$1(this.f15194a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t fullyDrawnReporter_delegate$lambda$2$lambda$1(q qVar) {
        qVar.reportFullyDrawn();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private static /* synthetic */ void getSavedStateRegistryController$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBackPressedDispatcher onBackPressedDispatcher_delegate$lambda$13(final q qVar) {
        final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: b.o
            @Override // java.lang.Runnable
            public final void run() {
                q.onBackPressedDispatcher_delegate$lambda$13$lambda$10(this.f15202a);
            }
        });
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            qVar.addObserverForBackInvoker(onBackPressedDispatcher);
            return onBackPressedDispatcher;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f15203a.addObserverForBackInvoker(onBackPressedDispatcher);
            }
        });
        return onBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressedDispatcher_delegate$lambda$13$lambda$10(q qVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e10) {
            if (!kotlin.jvm.internal.p.d(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e10;
            }
        } catch (NullPointerException e11) {
            if (!kotlin.jvm.internal.p.d(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e11;
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        eVar.Y(decorView);
        super.addContentView(view, params);
    }

    @Override // androidx.core.view.InterfaceC1325m
    public void addMenuProvider(androidx.core.view.r provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        this.menuHostHelper.c(provider);
    }

    @Override // androidx.core.content.c
    public final void addOnConfigurationChangedListener(B0.a<Configuration> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    public final void addOnContextAvailableListener(InterfaceC1480b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.contextAwareHelper.a(listener);
    }

    @Override // androidx.core.app.n
    public final void addOnMultiWindowModeChangedListener(B0.a<androidx.core.app.g> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    public final void addOnNewIntentListener(B0.a<Intent> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    @Override // androidx.core.app.o
    public final void addOnPictureInPictureModeChangedListener(B0.a<androidx.core.app.q> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    @Override // androidx.core.content.d
    public final void addOnTrimMemoryListener(B0.a<Integer> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    public final void addOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // d.InterfaceC3940f
    public final AbstractC3939e getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.InterfaceC1391i
    public CreationExtras getDefaultViewModelCreationExtras() {
        V0.b bVar = new V0.b(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        if (getApplication() != null) {
            bVar.c(U.a.f14255h, getApplication());
        }
        bVar.c(android.view.I.f14182a, this);
        bVar.c(android.view.I.f14183b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            bVar.c(android.view.I.f14184c, extras);
        }
        return bVar;
    }

    @Override // android.view.InterfaceC1391i
    public U.c getDefaultViewModelProviderFactory() {
        return (U.c) this.defaultViewModelProviderFactory.getValue();
    }

    public C1415E getFullyDrawnReporter() {
        return (C1415E) this.fullyDrawnReporter.getValue();
    }

    public Object getLastCustomNonConfigurationInstance() {
        d dVar = (d) getLastNonConfigurationInstance();
        if (dVar != null) {
            return dVar.getCustom();
        }
        return null;
    }

    @Override // androidx.core.app.f, android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // b.L
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher.getValue();
    }

    @Override // g1.h
    public final g1.e getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // android.view.W
    public V getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        V v10 = this._viewModelStore;
        kotlin.jvm.internal.p.f(v10);
        return v10;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        android.view.View.b(decorView, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView2, "getDecorView(...)");
        C1382Y.a(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView3, "getDecorView(...)");
        g1.l.a(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView4, "getDecorView(...)");
        P.a(decorView4, this);
        View decorView5 = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView5, "getDecorView(...)");
        O.a(decorView5, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.activityResultRegistry.f(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().q();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator<B0.a<Configuration>> it = this.onConfigurationChangedListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(newConfig);
        }
    }

    @Override // androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        this.savedStateRegistryController.d(savedInstanceState);
        this.contextAwareHelper.c(this);
        super.onCreate(savedInstanceState);
        android.view.E.INSTANCE.b(this);
        int i10 = this.contentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        kotlin.jvm.internal.p.i(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onCreatePanelMenu(featureId, menu);
        this.menuHostHelper.f(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        if (featureId == 0) {
            return this.menuHostHelper.h(item);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<B0.a<androidx.core.app.g>> it = this.onMultiWindowModeChangedListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.g(isInMultiWindowMode));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        Iterator<B0.a<Intent>> it = this.onNewIntentListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        kotlin.jvm.internal.p.i(menu, "menu");
        this.menuHostHelper.g(menu);
        super.onPanelClosed(featureId, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<B0.a<androidx.core.app.q>> it = this.onPictureInPictureModeChangedListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.q(isInPictureInPictureMode));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        kotlin.jvm.internal.p.i(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onPreparePanel(featureId, view, menu);
        this.menuHostHelper.i(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.p.i(permissions, "permissions");
        kotlin.jvm.internal.p.i(grantResults, "grantResults");
        if (this.activityResultRegistry.f(requestCode, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        V viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            viewModelStore = dVar.getViewModelStore();
        }
        if (viewModelStore == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.c(objOnRetainCustomNonConfigurationInstance);
        dVar2.d(viewModelStore);
        return dVar2;
    }

    @Override // androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        if (getLifecycle() instanceof C1399q) {
            Lifecycle lifecycle = getLifecycle();
            kotlin.jvm.internal.p.g(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((C1399q) lifecycle).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.e(outState);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Iterator<B0.a<Integer>> it = this.onTrimMemoryListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(level));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.getContext();
    }

    public final <I, O> AbstractC3936b<I> registerForActivityResult(AbstractC3969a<I, O> contract, AbstractC3939e registry, InterfaceC3935a<O> callback) {
        kotlin.jvm.internal.p.i(contract, "contract");
        kotlin.jvm.internal.p.i(registry, "registry");
        kotlin.jvm.internal.p.i(callback, "callback");
        return registry.n("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // androidx.core.view.InterfaceC1325m
    public void removeMenuProvider(androidx.core.view.r provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        this.menuHostHelper.j(provider);
    }

    @Override // androidx.core.content.c
    public final void removeOnConfigurationChangedListener(B0.a<Configuration> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    public final void removeOnContextAvailableListener(InterfaceC1480b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.contextAwareHelper.e(listener);
    }

    @Override // androidx.core.app.n
    public final void removeOnMultiWindowModeChangedListener(B0.a<androidx.core.app.g> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    public final void removeOnNewIntentListener(B0.a<Intent> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    @Override // androidx.core.app.o
    public final void removeOnPictureInPictureModeChangedListener(B0.a<androidx.core.app.q> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // androidx.core.content.d
    public final void removeOnTrimMemoryListener(B0.a<Integer> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    public final void removeOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C4996a.c()) {
                C4996a.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            getFullyDrawnReporter().b();
        } finally {
            C4996a.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int layoutResID) {
        initializeViewTreeOwners();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        eVar.Y(decorView);
        super.setContentView(layoutResID);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.startActivityForResult(intent, requestCode);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    public void addMenuProvider(androidx.core.view.r provider, LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(provider, "provider");
        kotlin.jvm.internal.p.i(owner, "owner");
        this.menuHostHelper.d(provider, owner);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(androidx.core.view.r provider, LifecycleOwner owner, Lifecycle.State state) {
        kotlin.jvm.internal.p.i(provider, "provider");
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(state, "state");
        this.menuHostHelper.e(provider, owner, state);
    }

    public final <I, O> AbstractC3936b<I> registerForActivityResult(AbstractC3969a<I, O> contract, InterfaceC3935a<O> callback) {
        kotlin.jvm.internal.p.i(contract, "contract");
        kotlin.jvm.internal.p.i(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<B0.a<androidx.core.app.g>> it = this.onMultiWindowModeChangedListeners.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.g(isInMultiWindowMode, newConfig));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<B0.a<androidx.core.app.q>> it = this.onPictureInPictureModeChangedListeners.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.q(isInPictureInPictureMode, newConfig));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        eVar.Y(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        e eVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        eVar.Y(decorView);
        super.setContentView(view, params);
    }

    public q(int i10) {
        this();
        this.contentLayoutId = i10;
    }
}
