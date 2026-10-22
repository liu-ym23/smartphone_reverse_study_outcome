package com.stepos.ailauncher.container;

import Ua.C1060i;
import Ua.L0;
import Z8.C1173v;
import android.R;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.view.a0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.memory.e;
import com.stepos.ailauncher.common.utils.J;
import com.stepos.ailauncher.container.MainScrollOverlayComponent;
import com.stepos.ailauncher.container.OverlayRecentsInputGate;
import com.stepos.ailauncher.container.api.IMemoryTrimmable;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageProvider;
import com.stepos.ailauncher.container.api.IOverlayPageRegistry;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageResumeReason;
import com.stepos.launcher.assistant.quickstep.RemoteTransitionParams;
import com.stepos.launcher.assistant.slidepanel.OverlayComponent;
import com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener;
import com.stepos.launcher.assistant.slidepanel.SlidingPanelLayout;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0006\u0086\u0002©\u0002±\u0002\u0018\u0000 »\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00013B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u0015J\u0019\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u0015J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010\u0015J\u000f\u0010+\u001a\u00020\fH\u0014¢\u0006\u0004\b+\u0010\u0015J\u000f\u0010,\u001a\u00020\fH\u0014¢\u0006\u0004\b,\u0010\u0015J\u0019\u0010/\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b1\u0010\u0015J\u000f\u00102\u001a\u00020\fH\u0016¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u0015J\u000f\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b4\u0010\u0015J\u0017\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0010H\u0014¢\u0006\u0004\b6\u0010\u0013J\u0017\u00108\u001a\u00020\f2\u0006\u00107\u001a\u00020&H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\f2\u0006\u00107\u001a\u00020&H\u0016¢\u0006\u0004\b:\u00109J\u0017\u0010=\u001a\u00020\f2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\f2\u0006\u0010?\u001a\u00020&H\u0016¢\u0006\u0004\b@\u00109J\u000f\u0010A\u001a\u00020\fH\u0016¢\u0006\u0004\bA\u0010\u0015J\u0017\u0010C\u001a\u00020\f2\u0006\u0010B\u001a\u00020&H\u0016¢\u0006\u0004\bC\u00109J\u000f\u0010D\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u0010\u0015J\u0017\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020&H\u0002¢\u0006\u0004\bF\u00109J\u0017\u0010H\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\bH\u0010>J\u0017\u0010I\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\bI\u0010>J\u001f\u0010K\u001a\u00020\f2\u0006\u0010G\u001a\u00020;2\u0006\u0010J\u001a\u00020&H\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\bM\u0010>J\u000f\u0010N\u001a\u00020&H\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020&H\u0002¢\u0006\u0004\bP\u0010OJ\u0017\u0010Q\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\bQ\u0010>J\u000f\u0010R\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010\u0015J\u000f\u0010S\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010\u0015J\u000f\u0010U\u001a\u00020TH\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\fH\u0002¢\u0006\u0004\bW\u0010\u0015J\u000f\u0010X\u001a\u00020\u0016H\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\fH\u0002¢\u0006\u0004\bZ\u0010\u0015J\u000f\u0010[\u001a\u00020\fH\u0002¢\u0006\u0004\b[\u0010\u0015J\u000f\u0010\\\u001a\u00020\fH\u0002¢\u0006\u0004\b\\\u0010\u0015J\u000f\u0010]\u001a\u00020\fH\u0002¢\u0006\u0004\b]\u0010\u0015J\u000f\u0010^\u001a\u00020&H\u0002¢\u0006\u0004\b^\u0010OJ\u000f\u0010_\u001a\u00020\fH\u0002¢\u0006\u0004\b_\u0010\u0015J\u000f\u0010`\u001a\u00020\fH\u0002¢\u0006\u0004\b`\u0010\u0015J\u000f\u0010a\u001a\u00020\fH\u0002¢\u0006\u0004\ba\u0010\u0015J\u000f\u0010b\u001a\u00020\fH\u0002¢\u0006\u0004\bb\u0010\u0015J\u000f\u0010c\u001a\u00020\fH\u0002¢\u0006\u0004\bc\u0010\u0015J\u000f\u0010d\u001a\u00020\fH\u0002¢\u0006\u0004\bd\u0010\u0015J\u0017\u0010e\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\be\u0010>J\u000f\u0010f\u001a\u00020\fH\u0002¢\u0006\u0004\bf\u0010\u0015J\u000f\u0010g\u001a\u00020\fH\u0002¢\u0006\u0004\bg\u0010\u0015J\u000f\u0010h\u001a\u00020\fH\u0002¢\u0006\u0004\bh\u0010\u0015J\u000f\u0010i\u001a\u00020\fH\u0002¢\u0006\u0004\bi\u0010\u0015J\u000f\u0010j\u001a\u00020\fH\u0002¢\u0006\u0004\bj\u0010\u0015J\u000f\u0010k\u001a\u00020\fH\u0002¢\u0006\u0004\bk\u0010\u0015J\u000f\u0010l\u001a\u00020\fH\u0002¢\u0006\u0004\bl\u0010\u0015J\u001f\u0010n\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010m\u001a\u00020;H\u0002¢\u0006\u0004\bn\u0010oJ\u001f\u0010q\u001a\u00020\f2\u0006\u0010p\u001a\u00020\u00162\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0004\bq\u0010oJ\u001f\u0010r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010m\u001a\u00020;H\u0002¢\u0006\u0004\br\u0010oJ\u001f\u0010s\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010m\u001a\u00020;H\u0002¢\u0006\u0004\bs\u0010oJ\u000f\u0010t\u001a\u00020\fH\u0002¢\u0006\u0004\bt\u0010\u0015J\u000f\u0010u\u001a\u00020\fH\u0002¢\u0006\u0004\bu\u0010\u0015J\u0017\u0010w\u001a\u00020\f2\u0006\u0010v\u001a\u00020&H\u0002¢\u0006\u0004\bw\u00109J\u000f\u0010x\u001a\u00020\fH\u0002¢\u0006\u0004\bx\u0010\u0015J\u000f\u0010y\u001a\u00020\fH\u0002¢\u0006\u0004\by\u0010\u0015J\u0017\u0010{\u001a\u00020\f2\u0006\u0010z\u001a\u00020&H\u0002¢\u0006\u0004\b{\u00109J\u000f\u0010|\u001a\u00020\fH\u0002¢\u0006\u0004\b|\u0010\u0015J\u000f\u0010}\u001a\u00020\fH\u0002¢\u0006\u0004\b}\u0010\u0015J\u000f\u0010~\u001a\u00020\fH\u0002¢\u0006\u0004\b~\u0010\u0015J\u000f\u0010\u007f\u001a\u00020&H\u0002¢\u0006\u0004\b\u007f\u0010OJ\u0011\u0010\u0080\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0015J$\u0010\u0082\u0001\u001a\u00020\f2\u0006\u0010G\u001a\u00020;2\t\b\u0002\u0010\u0081\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b\u0082\u0001\u0010LJ\u0011\u0010\u0083\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u0015J\u0011\u0010\u0084\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u0015J\u0011\u0010\u0085\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0015J\u001e\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001a\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u008a\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0013J\u0011\u0010\u008c\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0015J\u0011\u0010\u008d\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u008d\u0001\u0010\u0015J\u001a\u0010\u008f\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b\u008f\u0001\u00109J\u0011\u0010\u0090\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0015J\u0011\u0010\u0091\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0091\u0001\u0010\u0015J\u0011\u0010\u0092\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0092\u0001\u0010\u0015J\u0011\u0010\u0093\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0093\u0001\u0010\u0015J\u0011\u0010\u0094\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0094\u0001\u0010\u0015J\u001c\u0010\u0096\u0001\u001a\u00020&2\b\u0010\u0095\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b\u0098\u0001\u0010OJ\u0011\u0010\u0099\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0099\u0001\u0010\u0015J\u0011\u0010\u009a\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009a\u0001\u0010\u0015J\u0011\u0010\u009b\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u0015J\u0011\u0010\u009c\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b\u009c\u0001\u0010OJ\u0011\u0010\u009d\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009d\u0001\u0010\u0015J\u0019\u0010\u009e\u0001\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0005\b\u009e\u0001\u0010>J\u0019\u0010\u009f\u0001\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0005\b\u009f\u0001\u0010>J\u0019\u0010 \u0001\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0005\b \u0001\u0010>J\u0019\u0010¡\u0001\u001a\u00020\f2\u0006\u0010G\u001a\u00020;H\u0002¢\u0006\u0005\b¡\u0001\u0010>J\u0011\u0010¢\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¢\u0001\u0010\u0015J\u0011\u0010£\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b£\u0001\u0010\u0015J\u001c\u0010¥\u0001\u001a\u00020\f2\b\u0010¤\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001e\u0010§\u0001\u001a\u00020\f2\n\u0010¤\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002¢\u0006\u0006\b§\u0001\u0010¦\u0001J$\u0010ª\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\u00102\u0007\u0010©\u0001\u001a\u00020&H\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0011\u0010¬\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¬\u0001\u0010\u0015J\u0011\u0010\u00ad\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010OJ\u0011\u0010®\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b®\u0001\u0010OJ\u0011\u0010¯\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¯\u0001\u0010\u0015J\u0011\u0010°\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b°\u0001\u0010\u0015J\u001a\u0010±\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020&H\u0002¢\u0006\u0005\b±\u0001\u00109J\u001a\u0010²\u0001\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0002¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0019\u0010´\u0001\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0010H\u0002¢\u0006\u0005\b´\u0001\u0010\u0013J\u0011\u0010µ\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bµ\u0001\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\u000f\n\u0005\b\u0007\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R*\u0010¹\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¦\u0001R*\u0010¾\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¾\u0001\u0010º\u0001\u001a\u0006\b¿\u0001\u0010¼\u0001\"\u0006\bÀ\u0001\u0010¦\u0001R\u001a\u0010Á\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÁ\u0001\u0010º\u0001R\u001a\u0010Ã\u0001\u001a\u00030Â\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\"\u0010É\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Ë\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Í\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Ì\u0001R\u0019\u0010Î\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ï\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0019\u0010Ö\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010Ì\u0001R\u0019\u0010×\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ì\u0001R\u0019\u0010Ø\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ì\u0001R\u0019\u0010Ù\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ì\u0001R\u0018\u0010Û\u0001\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010Ý\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ì\u0001R\u0018\u0010ß\u0001\u001a\u00030Þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0019\u0010á\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010Ì\u0001R\u0018\u0010ã\u0001\u001a\u00030â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0019\u0010å\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010Ì\u0001R\u0019\u0010æ\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010Ì\u0001R\u0019\u0010ç\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010Ì\u0001R\u0019\u0010è\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010Ì\u0001R\u0019\u0010é\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010Ì\u0001R\u0019\u0010ê\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010Ì\u0001R\u0019\u0010ë\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010Ì\u0001R\u0019\u0010ì\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010Ì\u0001R\u0019\u0010í\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010Ì\u0001R\u001a\u0010ï\u0001\u001a\u00030î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001b\u0010ñ\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u0019\u0010ó\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010Ï\u0001R\u0019\u0010ô\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010Ì\u0001R\u0019\u0010õ\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010÷\u0001\u001a\u00030î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ð\u0001R\u0018\u0010ø\u0001\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0001\u0010Ü\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Ï\u0001R+\u0010ü\u0001\u001a\u0016\u0012\u0005\u0012\u00030Ú\u00010ú\u0001j\n\u0012\u0005\u0012\u00030Ú\u0001`û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u0019\u0010þ\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Ì\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010Ò\u0001R\u0019\u0010\u0080\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010Ì\u0001R\u0019\u0010\u0081\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010Ì\u0001R\u0019\u0010\u0082\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010Ì\u0001R\u0018\u0010\u0083\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010Ü\u0001R\u0018\u0010\u0084\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0002\u0010Ü\u0001R\u0018\u0010\u0085\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0002\u0010Ü\u0001R\u0018\u0010\u0087\u0002\u001a\u00030\u0086\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0019\u0010\u0089\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010Ï\u0001R\u0019\u0010\u008a\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010Ì\u0001R\u0019\u0010\u008b\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Ì\u0001R\u0018\u0010\u008c\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010Ü\u0001R\u001c\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001b\u0010\u0090\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010ò\u0001R\u0019\u0010\u0091\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010Ï\u0001R\u0019\u0010\u0092\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010Ï\u0001R\u0019\u0010\u0093\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010Ï\u0001R\u0018\u0010\u0094\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0002\u0010Ü\u0001R\u001c\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0019\u0010\u0098\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010Ì\u0001R\u0019\u0010\u0099\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010Ì\u0001R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009a\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001b\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010¶\u0001R\u0019\u0010\u009e\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010Ì\u0001R\u001b\u0010\u009f\u0002\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R\u0019\u0010¡\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010Ì\u0001R\u0018\u0010¢\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0002\u0010Ü\u0001R\u0019\u0010£\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010Ì\u0001R\u0018\u0010¤\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010Ü\u0001R\u0019\u0010¥\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010Ì\u0001R\u001a\u0010¦\u0002\u001a\u00030î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010ð\u0001R\u0019\u0010§\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010Ï\u0001R\u0018\u0010¨\u0002\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010Ü\u0001R\u0018\u0010ª\u0002\u001a\u00030©\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0002\u0010«\u0002R\u0019\u0010¬\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010Ì\u0001R\u0018\u0010®\u0002\u001a\u00030\u00ad\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R\u0019\u0010°\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010Ì\u0001R\u0018\u0010²\u0002\u001a\u00030±\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R\u001a\u0010´\u0002\u001a\u00030î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010ð\u0001R\u0019\u0010µ\u0002\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010Ï\u0001R\u001c\u0010·\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R\u0019\u0010¹\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010Ì\u0001R\u001c\u0010º\u0002\u001a\u0005\u0018\u00010Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010Ü\u0001¨\u0006¼\u0002"}, d2 = {"Lcom/stepos/ailauncher/container/MainScrollOverlayComponent;", "Lcom/stepos/ailauncher/container/d;", "Lcom/stepos/ailauncher/configuration/g;", "Lcom/stepos/ailauncher/configuration/d;", "Lcom/stepos/ailauncher/configuration/f;", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "bundle", "LY8/t;", "applyContentViewProperties", "(Landroid/os/Bundle;)V", "onCreate", "", "flags", "openOverlay", "(I)V", "onStartScroll", "()V", "", "progress", "onScroll", "(F)V", "onEndScroll", "onDestroy", "onResume", "onPause", "onStop", "Lcom/stepos/launcher/assistant/quickstep/RemoteTransitionParams;", "params", "onRemoteTransitionStart", "(Lcom/stepos/launcher/assistant/quickstep/RemoteTransitionParams;)V", "onRemoteTransitionEnd", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "onBackPressed", "navigateToDefaultPage", "q", "p", "Lcom/stepos/launcher/client/libraries/ILauncherOverlayCallback;", "iLauncherOverlayCallback", "setCallback", "(Lcom/stepos/launcher/client/libraries/ILauncherOverlayCallback;)V", "binderDied", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "level", "r", "animate", "closeOverlay", "(Z)V", "requestOpenOverlay", "", "pageId", "navigateToPage", "(Ljava/lang/String;)V", x5.d.EXTRA_ENABLED, "setEdgeBackGestureEnabled", "flushPendingPageResume", "owns", "setContentOwnsHorizontalGesture", "R2", "suspended", "S2", "reason", "O3", "k3", "requestFocus", "l3", "(Ljava/lang/String;Z)V", "m3", "f2", "()Z", "G2", "T1", "b3", "V3", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "V1", "()Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "C1", "W2", "()F", "P3", SdCardDbCreator.FIELD_LASTLOC_TIME, "v1", "G3", "J2", "d3", "j3", "h3", "Z1", "w2", "n3", "B1", "N1", "Y2", "U3", "A1", "x2", "F1", "g3", "phase", "U2", "(FLjava/lang/String;)V", "ratio", "T2", "V2", "c2", "L3", "N3", "pause", "d2", "K3", "M3", "open", "K1", "A3", "Q1", "o3", "B2", "G1", "force", "I2", "c3", "W3", "R3", "position", "Landroid/view/View;", "r2", "(I)Landroid/view/View;", "toPosition", "p3", "E1", "R1", "visible", "X3", "z1", "X2", "u2", "t2", "S1", "v", "C2", "(Landroid/view/View;)Z", "D2", "Q3", "q3", "P1", "J3", "O1", "v2", "f3", "h0", "i3", "H1", "b2", "decor", "L1", "(Landroid/view/View;)V", "U1", "gen", "probed", "j2", "(IZ)V", "C3", "F2", "E2", "s3", "r3", "S3", "g2", "(I)I", "T3", "D1", "Landroid/content/Context;", "o2", "()Landroid/content/Context;", "mRootView", "Landroid/view/View;", "q2", "()Landroid/view/View;", "I3", "mContentView", "p2", "H3", "mGuideView", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "Lcom/stepos/ailauncher/container/h0;", "mOverlayAdapter", "Lcom/stepos/ailauncher/container/h0;", "Lkotlin/Function0;", "mPagesChangedListener", "Lp9/a;", "mOverlayResumed", "Z", "isDestroyed", "mCurrentPage", "I", "initialPage", "pendingPageSwitchTo", "Ljava/lang/Integer;", "Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelDragListener;", "dragListener", "Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelDragListener;", "lastAllTasksEntryVisible", "allTasksEntryResumeHold", "allTasksEntryHoldExitSeen", "allTasksEntryHoldSettled", "Ljava/lang/Runnable;", "allTasksEntryHoldReleaseRunnable", "Ljava/lang/Runnable;", "alreadyInOpen", "Lcom/stepos/ailauncher/common/memory/e$a;", "heapPageTrimListener", "Lcom/stepos/ailauncher/common/memory/e$a;", "panelOpenedByLauncher", "Lcom/stepos/ailauncher/container/e0;", "openVeto", "Lcom/stepos/ailauncher/container/e0;", "overlayUndrawn", "drewSinceOpen", "stallProbeActive", "abandoningOverlay", "selfOpenRequest", "followPanelProgress", "wallpaperOpenFollowArmed", "fingerDragging", "imeInsetsAnimating", "", "lastOnScrollElapsed", "J", "pendingAiDesktopEndOpen", "Ljava/lang/Boolean;", "pendingEndRestTicks", "closeWallpaperEndLatched", "lastFollowRatio", "F", "lastFollowElapsed", "followPanelProgressRunnable", "openProgressResyncGeneration", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "openProgressResyncRunnables", "Ljava/util/ArrayList;", "wallpaperChangedReceiverRegistered", "deferredBootOpenFlags", "deferredBootOpenSettlePosted", "deferredBootOpenGaveUp", "wallpaperChangedResyncPosted", "wallpaperChangedResyncRunnable", "deferredBootOpenTimeoutRunnable", "deferredBootOpenSettleRunnable", "com/stepos/ailauncher/container/MainScrollOverlayComponent$h", "wallpaperChangedReceiver", "Lcom/stepos/ailauncher/container/MainScrollOverlayComponent$h;", "appliedThemeResId", "pendingRelaunch", "isRelaunching", "relaunchRunnable", "Lkotlinx/coroutines/g;", "playbackWatchJob", "Lkotlinx/coroutines/g;", "lastPlaybackPaused", "inputSurfaceSyncGeneration", "pageResumeRetryGeneration", "lifecycleResumeGeneration", "deferredOpenPanelResumeRunnable", "Landroid/window/OnBackInvokedCallback;", "backInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "edgeBackGestureEnabled", "contentOwnsHorizontalGesture", "Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper;", "mPagerTouchWrapper", "Lcom/stepos/ailauncher/container/ViewPagerTouchWrapper;", "originalBaseContext", "nightContextPinned", "lastLiveLauncherCallback", "Lcom/stepos/launcher/client/libraries/ILauncherOverlayCallback;", "pendingFontScaleRelaunch", "fontScaleRelaunchRunnable", "pendingLocaleRelaunch", "localeRelaunchRunnable", "pendingDisplaySizeRelaunch", "lastPanelTransitionUptimeMs", "displaySizeRelaunchRetries", "displaySizeRelaunchRunnable", "com/stepos/ailauncher/container/MainScrollOverlayComponent$g", "screenPowerListener", "Lcom/stepos/ailauncher/container/MainScrollOverlayComponent$g;", "overlayDrawSuppressed", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate;", "recentsInputGate", "Lcom/stepos/ailauncher/container/OverlayRecentsInputGate;", "recentsFocusYieldReceiverRegistered", "com/stepos/ailauncher/container/MainScrollOverlayComponent$f", "recentsFocusYieldReceiver", "Lcom/stepos/ailauncher/container/MainScrollOverlayComponent$f;", "lastDrawUptimeMs", "frameWatchdogGeneration", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "frameWatchdogPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "frameCommittedSinceProbe", "frameCommitCallback", "Companion", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainScrollOverlayComponent extends ComponentCallbacks2C3211d implements com.stepos.ailauncher.configuration.g, com.stepos.ailauncher.configuration.d, com.stepos.ailauncher.configuration.f, IOverlayPageHost {
    private static final String ACTION_CANCEL_GESTURE_VIEW = "com.android.systemui.recents.action.CANCEL_GESTURE_VIEW";
    private static final String ACTION_ENTER_RECENTS = "com.stepos.ACTION_ENTER_RECENTS";
    private static final String ACTION_SHOW_GESTURE_VIEW = "com.android.systemui.recents.action.SHOW_GESTURE_VIEW";
    private static final long ALL_TASKS_ENTRY_HOLD_FALLBACK_MS = 1500;
    private static final long ALL_TASKS_ENTRY_SETTLE_GRACE_MS = 100;
    private static final boolean CLOSE_ON_UNHANDLED_BACK = false;
    private static final boolean DEFAULT_ASSISTANT_AS_HOME = true;
    private static final int DEFAULT_SCREEN = 1;
    private static final int DISPLAY_SIZE_RELAUNCH_MAX_RETRIES = 8;
    private static final long DISPLAY_SIZE_RELAUNCH_QUIET_MS = 600;
    private static final int EDGE_GESTURE_EXCLUSION_PX = 120;
    private static final String EXTRA_ENTER_RECENTS = "enter";
    private static final int FLAG_ANIMATE = 1;
    private static final int FLAG_NO_ANIMATE = 2;
    private static final int FOCUS_INVISIBLE_WAIT_FRAMES = 24;
    private static final int FOCUS_RETRY_FRAMES = 18;
    private static final long FOCUS_YIELD_FALLBACK_MS = 2000;
    private static final long FRAME_STALL_PROBE_MS = 500;
    private static final long FRAME_STALL_THRESHOLD_MS = 3000;
    private static final long FRAME_WATCHDOG_INTERVAL_MS = 1500;
    private static final String KEY_OVERLAY_WINDOW_FOCUSABLE = "overlay_window_focusable";
    private static final long LIFECYCLE_RESUME_DEBOUNCE_MS = 400;
    private static final float OVERLAY_VISIBLE_ALPHA_EPS = 0.01f;
    private static final long RELAUNCH_DEBOUNCE_MS = 300;
    public static final String TAG = "MainScrollOverlay";
    private boolean abandoningOverlay;
    private boolean allTasksEntryHoldExitSeen;
    private final Runnable allTasksEntryHoldReleaseRunnable;
    private boolean allTasksEntryHoldSettled;
    private boolean allTasksEntryResumeHold;
    private boolean alreadyInOpen;
    private int appliedThemeResId;
    private OnBackInvokedCallback backInvokedCallback;
    private boolean closeWallpaperEndLatched;
    private boolean contentOwnsHorizontalGesture;
    private final Context context;
    private Integer deferredBootOpenFlags;
    private boolean deferredBootOpenGaveUp;
    private boolean deferredBootOpenSettlePosted;
    private final Runnable deferredBootOpenSettleRunnable;
    private final Runnable deferredBootOpenTimeoutRunnable;
    private final Runnable deferredOpenPanelResumeRunnable;
    private int displaySizeRelaunchRetries;
    private final Runnable displaySizeRelaunchRunnable;
    private SlidingPanelDragListener dragListener;
    private boolean drewSinceOpen;
    private boolean edgeBackGestureEnabled;
    private boolean fingerDragging;
    private boolean followPanelProgress;
    private final Runnable followPanelProgressRunnable;
    private final Runnable fontScaleRelaunchRunnable;
    private Runnable frameCommitCallback;
    private boolean frameCommittedSinceProbe;
    private int frameWatchdogGeneration;
    private ViewTreeObserver.OnPreDrawListener frameWatchdogPreDrawListener;
    private final e.a heapPageTrimListener;
    private boolean imeInsetsAnimating;
    private int initialPage;
    private int inputSurfaceSyncGeneration;
    private boolean isDestroyed;
    private boolean isRelaunching;
    private boolean lastAllTasksEntryVisible;
    private long lastDrawUptimeMs;
    private long lastFollowElapsed;
    private float lastFollowRatio;
    private volatile ILauncherOverlayCallback lastLiveLauncherCallback;
    private long lastOnScrollElapsed;
    private long lastPanelTransitionUptimeMs;
    private Boolean lastPlaybackPaused;
    private int lifecycleResumeGeneration;
    private final Runnable localeRelaunchRunnable;
    public View mContentView;
    private int mCurrentPage;
    private View mGuideView;
    private h0 mOverlayAdapter;
    private boolean mOverlayResumed;
    private ViewPagerTouchWrapper mPagerTouchWrapper;
    private InterfaceC5063a<Y8.t> mPagesChangedListener;
    public View mRootView;
    private ViewPager2 mViewPager;
    private boolean nightContextPinned;
    private int openProgressResyncGeneration;
    private final ArrayList<Runnable> openProgressResyncRunnables;
    private final e0 openVeto;
    private Context originalBaseContext;
    private boolean overlayDrawSuppressed;
    private boolean overlayUndrawn;
    private int pageResumeRetryGeneration;
    private boolean panelOpenedByLauncher;
    private Boolean pendingAiDesktopEndOpen;
    private boolean pendingDisplaySizeRelaunch;
    private int pendingEndRestTicks;
    private boolean pendingFontScaleRelaunch;
    private boolean pendingLocaleRelaunch;
    private Integer pendingPageSwitchTo;
    private boolean pendingRelaunch;
    private kotlinx.coroutines.g playbackWatchJob;
    private final f recentsFocusYieldReceiver;
    private boolean recentsFocusYieldReceiverRegistered;
    private final OverlayRecentsInputGate recentsInputGate;
    private final Runnable relaunchRunnable;
    private final g screenPowerListener;
    private boolean selfOpenRequest;
    private boolean stallProbeActive;
    private final h wallpaperChangedReceiver;
    private boolean wallpaperChangedReceiverRegistered;
    private boolean wallpaperChangedResyncPosted;
    private final Runnable wallpaperChangedResyncRunnable;
    private boolean wallpaperOpenFollowArmed;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final r0<MainScrollOverlayComponent> TRACKER = new r0<>();

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0014\u0010 \u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010&\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0012R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/container/MainScrollOverlayComponent$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_PKGNAME, "()Z", "", "TAG", "Ljava/lang/String;", "ACTION_SHOW_GESTURE_VIEW", "ACTION_CANCEL_GESTURE_VIEW", "ACTION_ENTER_RECENTS", "EXTRA_ENTER_RECENTS", "", "EDGE_GESTURE_EXCLUSION_PX", "I", "FLAG_ANIMATE", "FLAG_NO_ANIMATE", "", "RELAUNCH_DEBOUNCE_MS", "J", "ALL_TASKS_ENTRY_HOLD_FALLBACK_MS", "ALL_TASKS_ENTRY_SETTLE_GRACE_MS", "KEY_OVERLAY_WINDOW_FOCUSABLE", "DISPLAY_SIZE_RELAUNCH_QUIET_MS", "DISPLAY_SIZE_RELAUNCH_MAX_RETRIES", "LIFECYCLE_RESUME_DEBOUNCE_MS", "FOCUS_RETRY_FRAMES", "FOCUS_INVISIBLE_WAIT_FRAMES", "FOCUS_YIELD_FALLBACK_MS", "", "OVERLAY_VISIBLE_ALPHA_EPS", "F", "FRAME_WATCHDOG_INTERVAL_MS", "FRAME_STALL_THRESHOLD_MS", "FRAME_STALL_PROBE_MS", "CLOSE_ON_UNHANDLED_BACK", "Z", "DEFAULT_ASSISTANT_AS_HOME", "DEFAULT_SCREEN", "Lcom/stepos/ailauncher/container/r0;", "Lcom/stepos/ailauncher/container/MainScrollOverlayComponent;", "TRACKER", "Lcom/stepos/ailauncher/container/r0;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.container.MainScrollOverlayComponent$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a() {
            Object objB;
            Object objB2;
            Object objB3;
            MainScrollOverlayComponent mainScrollOverlayComponent = (MainScrollOverlayComponent) MainScrollOverlayComponent.TRACKER.a();
            if (mainScrollOverlayComponent == null) {
                return;
            }
            Log.i(MainScrollOverlayComponent.TAG, "tearing down previous overlay component");
            try {
                Result.Companion companion = Result.INSTANCE;
                if (mainScrollOverlayComponent.isAttachToWindow()) {
                    mainScrollOverlayComponent.setFocusable(false);
                    mainScrollOverlayComponent.hide();
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(MainScrollOverlayComponent.TAG, "leaked component yield focus failed", thE);
            }
            try {
                mainScrollOverlayComponent.onDestroy();
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                Log.w(MainScrollOverlayComponent.TAG, "leaked component onDestroy failed", thE2);
            }
            try {
                mainScrollOverlayComponent.h3();
                objB3 = Result.b(Y8.t.f7040a);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                objB3 = Result.b(C4849c.a(th3));
            }
            Throwable thE3 = Result.e(objB3);
            if (thE3 != null) {
                Log.w(MainScrollOverlayComponent.TAG, "leaked component window removal failed", thE3);
            }
            MainScrollOverlayComponent.TRACKER.c(mainScrollOverlayComponent);
        }

        public final boolean b() {
            MainScrollOverlayComponent mainScrollOverlayComponent = (MainScrollOverlayComponent) MainScrollOverlayComponent.TRACKER.a();
            return mainScrollOverlayComponent != null && mainScrollOverlayComponent.isAttachToWindow();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$b", "Landroid/view/WindowInsetsAnimationControlListener;", "Landroid/view/WindowInsetsAnimationController;", "c", "", "types", "LY8/t;", "onReady", "(Landroid/view/WindowInsetsAnimationController;I)V", "onFinished", "(Landroid/view/WindowInsetsAnimationController;)V", "onCancelled", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements WindowInsetsAnimationControlListener {
        @Override // android.view.WindowInsetsAnimationControlListener
        public void onCancelled(WindowInsetsAnimationController c10) {
            Log.i(MainScrollOverlayComponent.TAG, "hideImeInstantlyForPanelDrag cancelled ready=" + (c10 != null));
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onFinished(WindowInsetsAnimationController c10) {
            kotlin.jvm.internal.p.i(c10, "c");
            Log.i(MainScrollOverlayComponent.TAG, "hideImeInstantlyForPanelDrag finished");
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onReady(WindowInsetsAnimationController c10, int types) {
            kotlin.jvm.internal.p.i(c10, "c");
            c10.finish(false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$c", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "onPageScrollStateChanged", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ViewPager2.i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                MainScrollOverlayComponent.this.E1();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            MainScrollOverlayComponent.this.p3(position);
            MainScrollOverlayComponent.this.u2();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$d", "Lcom/stepos/launcher/assistant/slidepanel/SlidingPanelDragListener;", "LY8/t;", "open", "()V", "close", "", "p0", "closing", "(Z)V", "startDrag", "dragTouchable", "", "overlayScrollChanged", "(F)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements SlidingPanelDragListener {
        public d() {
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void close() {
            Object objB;
            MainScrollOverlayComponent.this.lastPanelTransitionUptimeMs = SystemClock.uptimeMillis();
            MainScrollOverlayComponent.this.N1();
            MainScrollOverlayComponent.this.P1();
            MainScrollOverlayComponent.this.U3();
            Log.i(MainScrollOverlayComponent.TAG, "dragListener.close (reset panel open reason)");
            MainScrollOverlayComponent.this.deferredBootOpenFlags = null;
            MainScrollOverlayComponent.this.deferredBootOpenSettlePosted = false;
            MainScrollOverlayComponent.this.deferredBootOpenGaveUp = false;
            MainScrollOverlayComponent.this.Q1();
            com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
            if (aVar.y(MainScrollOverlayComponent.this.closeWallpaperEndLatched)) {
                MainScrollOverlayComponent.this.V2(aVar.h(false), com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
            } else {
                m0.INSTANCE.s(0.0f);
                Log.i(MainScrollOverlayComponent.TAG, "skip duplicate close END, wallpaper already primed");
            }
            MainScrollOverlayComponent.this.closeWallpaperEndLatched = false;
            if (com.stepos.ailauncher.container.wallpaper.g.INSTANCE.b(0.0f, 0.01f, true, true, true)) {
                MainScrollOverlayComponent.this.g3();
            }
            MainScrollOverlayComponent.this.pendingAiDesktopEndOpen = null;
            MainScrollOverlayComponent.this.pendingEndRestTicks = 0;
            MainScrollOverlayComponent.this.M3();
            if (!MainScrollOverlayComponent.this.abandoningOverlay && MainScrollOverlayComponent.this.overlayUndrawn) {
                MainScrollOverlayComponent.this.f3("close");
            }
            MainScrollOverlayComponent.this.drewSinceOpen = false;
            MainScrollOverlayComponent.this.panelOpenedByLauncher = false;
            MainScrollOverlayComponent.this.wallpaperOpenFollowArmed = false;
            MainScrollOverlayComponent.this.openVeto.f();
            MainScrollOverlayComponent mainScrollOverlayComponent = MainScrollOverlayComponent.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                mainScrollOverlayComponent.setFocusable(false);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(MainScrollOverlayComponent.TAG, "close setFocusable(false) failed: " + thE.getMessage());
            }
            if (MainScrollOverlayComponent.this.alreadyInOpen) {
                MainScrollOverlayComponent.this.alreadyInOpen = false;
                MainScrollOverlayComponent.this.fingerDragging = false;
                m0.INSTANCE.o(false, true);
                MainScrollOverlayComponent mainScrollOverlayComponent2 = MainScrollOverlayComponent.this;
                KeyEvent.Callback callbackR2 = mainScrollOverlayComponent2.r2(mainScrollOverlayComponent2.mCurrentPage);
                IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
                if (iOverlayPageView != null) {
                    iOverlayPageView.onPagePause();
                }
                MainScrollOverlayComponent mainScrollOverlayComponent3 = MainScrollOverlayComponent.this;
                KeyEvent.Callback callbackR22 = mainScrollOverlayComponent3.r2(mainScrollOverlayComponent3.mCurrentPage);
                IOverlayPageView iOverlayPageView2 = callbackR22 instanceof IOverlayPageView ? (IOverlayPageView) callbackR22 : null;
                if (iOverlayPageView2 != null) {
                    iOverlayPageView2.onPageStop();
                }
            }
            MainScrollOverlayComponent.this.lastAllTasksEntryVisible = false;
            MainScrollOverlayComponent.this.z1();
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void closing(boolean p02) {
            MainScrollOverlayComponent.this.fingerDragging = false;
            MainScrollOverlayComponent.this.P1();
            if (!MainScrollOverlayComponent.this.closeWallpaperEndLatched) {
                MainScrollOverlayComponent.this.K1(false);
            }
            SlidingPanelLayout slidingPanelLayout = MainScrollOverlayComponent.this.getSlidingPanelLayout();
            Float fValueOf = slidingPanelLayout != null ? Float.valueOf(slidingPanelLayout.mPanelPositionRatio) : null;
            Log.i(MainScrollOverlayComponent.TAG, "dragListener.closing latched=" + MainScrollOverlayComponent.this.closeWallpaperEndLatched + " ratio=" + fValueOf);
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void dragTouchable() {
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void open() {
            MainScrollOverlayComponent.this.lastPanelTransitionUptimeMs = SystemClock.uptimeMillis();
            MainScrollOverlayComponent.this.S3(false);
            MainScrollOverlayComponent.this.F1();
            MainScrollOverlayComponent mainScrollOverlayComponent = MainScrollOverlayComponent.this;
            boolean z10 = mainScrollOverlayComponent.r2(mainScrollOverlayComponent.mCurrentPage) != null;
            Log.i(MainScrollOverlayComponent.TAG, "dragListener.open alreadyInOpen=" + MainScrollOverlayComponent.this.alreadyInOpen + " pageReady=" + z10);
            if (!MainScrollOverlayComponent.this.alreadyInOpen) {
                MainScrollOverlayComponent.this.alreadyInOpen = true;
                MainScrollOverlayComponent.this.fingerDragging = false;
                MainScrollOverlayComponent.this.drewSinceOpen = false;
                if (MainScrollOverlayComponent.this.overlayUndrawn) {
                    MainScrollOverlayComponent.this.f3("open");
                }
                m0.p(m0.INSTANCE, true, false, 2, null);
                if (!MainScrollOverlayComponent.this.wallpaperOpenFollowArmed) {
                    MainScrollOverlayComponent.this.K1(true);
                }
                MainScrollOverlayComponent.this.wallpaperOpenFollowArmed = false;
                MainScrollOverlayComponent.this.A3();
            }
            MainScrollOverlayComponent.this.s3();
            MainScrollOverlayComponent.this.Y2();
            MainScrollOverlayComponent mainScrollOverlayComponent2 = MainScrollOverlayComponent.this;
            KeyEvent.Callback callbackR2 = mainScrollOverlayComponent2.r2(mainScrollOverlayComponent2.mCurrentPage);
            IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPageResume(mainScrollOverlayComponent2.V1());
            }
            MainScrollOverlayComponent.this.X2();
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void overlayScrollChanged(float p02) {
            if (!MainScrollOverlayComponent.this.closeWallpaperEndLatched && com.stepos.ailauncher.container.wallpaper.a.INSTANCE.A(MainScrollOverlayComponent.this.followPanelProgress)) {
                MainScrollOverlayComponent.this.U2(p02, com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE);
            }
        }

        @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
        public void startDrag() {
            if (MainScrollOverlayComponent.this.J3()) {
                Log.i(MainScrollOverlayComponent.TAG, "dragListener.startDrag ignored (content not shown, no veto)");
                MainScrollOverlayComponent.this.fingerDragging = false;
                MainScrollOverlayComponent.this.v2("startDrag-undrawn");
                return;
            }
            Log.i(MainScrollOverlayComponent.TAG, "dragListener.startDrag (finger drag, veto launcher-open)");
            MainScrollOverlayComponent.this.F1();
            if (MainScrollOverlayComponent.this.D2()) {
                MainScrollOverlayComponent.this.t2();
            }
            MainScrollOverlayComponent.this.openVeto.d();
            MainScrollOverlayComponent.this.panelOpenedByLauncher = false;
            MainScrollOverlayComponent.this.wallpaperOpenFollowArmed = false;
            MainScrollOverlayComponent.this.fingerDragging = true;
            MainScrollOverlayComponent.this.pendingAiDesktopEndOpen = null;
            MainScrollOverlayComponent.this.pendingEndRestTicks = 0;
            MainScrollOverlayComponent.this.closeWallpaperEndLatched = false;
            MainScrollOverlayComponent.this.lastFollowRatio = Float.NaN;
            MainScrollOverlayComponent.this.lastFollowElapsed = 0L;
            MainScrollOverlayComponent.this.K3();
            SlidingPanelLayout slidingPanelLayout = MainScrollOverlayComponent.this.getSlidingPanelLayout();
            MainScrollOverlayComponent.this.U2(slidingPanelLayout != null ? slidingPanelLayout.mPanelPositionRatio : m0.INSTANCE.e().getValue().floatValue(), "start");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$e", "Landroid/view/WindowInsetsAnimation$Callback;", "Landroid/view/WindowInsetsAnimation;", "animation", "LY8/t;", "onPrepare", "(Landroid/view/WindowInsetsAnimation;)V", "Landroid/view/WindowInsets;", "insets", "", "runningAnimations", "onProgress", "(Landroid/view/WindowInsets;Ljava/util/List;)Landroid/view/WindowInsets;", "onEnd", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends WindowInsetsAnimation.Callback {
        public e() {
            super(1);
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onEnd(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                MainScrollOverlayComponent.this.imeInsetsAnimating = false;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onPrepare(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                MainScrollOverlayComponent.this.imeInsetsAnimating = true;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$f", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends BroadcastReceiver {
        public f() {
        }

        public static final void e(MainScrollOverlayComponent mainScrollOverlayComponent, int i10, OverlayRecentsInputGate.a aVar) {
            if (mainScrollOverlayComponent.isDestroyed) {
                return;
            }
            if (mainScrollOverlayComponent.recentsInputGate.h(i10)) {
                mainScrollOverlayComponent.O3(((OverlayRecentsInputGate.a.Suppress) aVar).getReason());
                return;
            }
            Log.i(MainScrollOverlayComponent.TAG, "drop stale SHOW_GESTURE_VIEW suppress gen=" + i10 + " phase=" + mainScrollOverlayComponent.recentsInputGate.getPhase());
        }

        public static final void f(MainScrollOverlayComponent mainScrollOverlayComponent) {
            mainScrollOverlayComponent.k3("CANCEL_GESTURE_VIEW");
        }

        public static final void g(MainScrollOverlayComponent mainScrollOverlayComponent, int i10, OverlayRecentsInputGate.a aVar) {
            if (!mainScrollOverlayComponent.isDestroyed && mainScrollOverlayComponent.recentsInputGate.h(i10)) {
                mainScrollOverlayComponent.O3(((OverlayRecentsInputGate.a.Suppress) aVar).getReason());
            }
        }

        public static final void h(MainScrollOverlayComponent mainScrollOverlayComponent, OverlayRecentsInputGate.a aVar) {
            mainScrollOverlayComponent.k3(((OverlayRecentsInputGate.a.Restore) aVar).getReason());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctx, Intent intent) {
            if (MainScrollOverlayComponent.this.isDestroyed) {
                return;
            }
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -731730151) {
                    if (action.equals("com.stepos.ACTION_ENTER_RECENTS")) {
                        final OverlayRecentsInputGate.a aVarC = MainScrollOverlayComponent.this.recentsInputGate.c(intent.getBooleanExtra(MainScrollOverlayComponent.EXTRA_ENTER_RECENTS, false));
                        if (aVarC instanceof OverlayRecentsInputGate.a.Suppress) {
                            final int generation = ((OverlayRecentsInputGate.a.Suppress) aVarC).getGeneration();
                            Handler handler = ((OverlayComponent) MainScrollOverlayComponent.this).mMainHandler;
                            final MainScrollOverlayComponent mainScrollOverlayComponent = MainScrollOverlayComponent.this;
                            handler.post(new Runnable() { // from class: com.stepos.ailauncher.container.W
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MainScrollOverlayComponent.f.g(mainScrollOverlayComponent, generation, aVarC);
                                }
                            });
                            return;
                        }
                        if (aVarC instanceof OverlayRecentsInputGate.a.Restore) {
                            Handler handler2 = ((OverlayComponent) MainScrollOverlayComponent.this).mMainHandler;
                            final MainScrollOverlayComponent mainScrollOverlayComponent2 = MainScrollOverlayComponent.this;
                            handler2.post(new Runnable() { // from class: com.stepos.ailauncher.container.X
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MainScrollOverlayComponent.f.h(mainScrollOverlayComponent2, aVarC);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (iHashCode != -374769766) {
                    if (iHashCode == 1504380925 && action.equals("com.android.systemui.recents.action.CANCEL_GESTURE_VIEW")) {
                        MainScrollOverlayComponent.this.recentsInputGate.b();
                        Handler handler3 = ((OverlayComponent) MainScrollOverlayComponent.this).mMainHandler;
                        final MainScrollOverlayComponent mainScrollOverlayComponent3 = MainScrollOverlayComponent.this;
                        handler3.post(new Runnable() { // from class: com.stepos.ailauncher.container.V
                            @Override // java.lang.Runnable
                            public final void run() {
                                MainScrollOverlayComponent.f.f(mainScrollOverlayComponent3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (action.equals("com.android.systemui.recents.action.SHOW_GESTURE_VIEW")) {
                    OverlayRecentsInputGate.Companion companion = OverlayRecentsInputGate.INSTANCE;
                    m0 m0Var = m0.INSTANCE;
                    boolean zA = companion.a(m0Var.d(), MainScrollOverlayComponent.this.alreadyInOpen, MainScrollOverlayComponent.this.isPanelOpen());
                    final OverlayRecentsInputGate.a aVarF = MainScrollOverlayComponent.this.recentsInputGate.f(zA);
                    if (aVarF instanceof OverlayRecentsInputGate.a.Suppress) {
                        final int generation2 = ((OverlayRecentsInputGate.a.Suppress) aVarF).getGeneration();
                        Handler handler4 = ((OverlayComponent) MainScrollOverlayComponent.this).mMainHandler;
                        final MainScrollOverlayComponent mainScrollOverlayComponent4 = MainScrollOverlayComponent.this;
                        handler4.post(new Runnable() { // from class: com.stepos.ailauncher.container.U
                            @Override // java.lang.Runnable
                            public final void run() {
                                MainScrollOverlayComponent.f.e(mainScrollOverlayComponent4, generation2, aVarF);
                            }
                        });
                        return;
                    }
                    Log.i(MainScrollOverlayComponent.TAG, "SHOW_GESTURE_VIEW ignored (no suppress) midDrag=" + zA + " progress=" + m0Var.d() + " panelOpen=" + MainScrollOverlayComponent.this.alreadyInOpen + " aarOpen=" + MainScrollOverlayComponent.this.isPanelOpen());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$g", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements J.a {
        public g() {
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            if (MainScrollOverlayComponent.this.isDestroyed) {
                return;
            }
            MainScrollOverlayComponent.this.T1("SCREEN_ON");
            if (MainScrollOverlayComponent.this.mOverlayResumed && MainScrollOverlayComponent.this.D2()) {
                MainScrollOverlayComponent.this.k3("SCREEN_ON");
                MainScrollOverlayComponent.this.C3();
                Log.i(MainScrollOverlayComponent.TAG, "screenOn power gate: restore surface sync + page resume retry");
            }
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            if (MainScrollOverlayComponent.this.isDestroyed) {
                return;
            }
            MainScrollOverlayComponent.this.O3("SCREEN_OFF");
            boolean zR = com.stepos.ailauncher.common.memory.e.r(com.stepos.ailauncher.common.memory.e.INSTANCE, MainScrollOverlayComponent.this.getContext(), true, null, 4, null);
            if (!zR && !MainScrollOverlayComponent.this.alreadyInOpen) {
                MainScrollOverlayComponent.this.r(20);
            }
            Log.i(MainScrollOverlayComponent.TAG, "screenOff power gate: suppressed heapTrim=" + zR + " panelOpen=" + MainScrollOverlayComponent.this.alreadyInOpen);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/container/MainScrollOverlayComponent$h", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends BroadcastReceiver {
        public h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.WALLPAPER_CHANGED")) {
                MainScrollOverlayComponent.this.o3();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainScrollOverlayComponent(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.allTasksEntryHoldReleaseRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.p
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.y1(this.f27067a);
            }
        };
        this.heapPageTrimListener = new e.a() { // from class: com.stepos.ailauncher.container.L
            @Override // com.stepos.ailauncher.common.memory.e.a
            public final void a(int i10) {
                MainScrollOverlayComponent.s2(this.f27007a, i10);
            }
        };
        this.openVeto = new e0(0.0f, 1, null);
        this.lastFollowRatio = Float.NaN;
        this.followPanelProgressRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.N
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.h2(this.f27009a);
            }
        };
        this.openProgressResyncRunnables = new ArrayList<>();
        this.wallpaperChangedResyncRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.O
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.Y3(this.f27010a);
            }
        };
        this.deferredBootOpenTimeoutRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.P
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.X1(this.f27011a);
            }
        };
        this.deferredBootOpenSettleRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.Q
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.W1(this.f27012a);
            }
        };
        this.wallpaperChangedReceiver = new h();
        this.appliedThemeResId = R$style.AppTheme;
        this.relaunchRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.S
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.e3(this.f27013a);
            }
        };
        this.deferredOpenPanelResumeRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.T
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.Y1(this.f27014a);
            }
        };
        this.fontScaleRelaunchRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.f
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.i2(this.f27043a);
            }
        };
        this.localeRelaunchRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.g
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.H2(this.f27045a);
            }
        };
        this.displaySizeRelaunchRunnable = new Runnable() { // from class: com.stepos.ailauncher.container.A
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.e2(this.f26978a);
            }
        };
        this.screenPowerListener = new g();
        this.recentsInputGate = new OverlayRecentsInputGate();
        this.recentsFocusYieldReceiver = new f();
    }

    public static final void A2(View view, float f10) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
    }

    public static final void B3(int i10, MainScrollOverlayComponent mainScrollOverlayComponent, int i11, long j10) {
        if (i10 != mainScrollOverlayComponent.openProgressResyncGeneration) {
            return;
        }
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        if (aVar.D(mainScrollOverlayComponent.alreadyInOpen, mainScrollOverlayComponent.isDestroyed)) {
            if (i11 == 0) {
                SlidingPanelLayout slidingPanelLayout = mainScrollOverlayComponent.getSlidingPanelLayout();
                float fFloatValue = slidingPanelLayout != null ? slidingPanelLayout.mPanelPositionRatio : m0.INSTANCE.e().getValue().floatValue();
                if (aVar.H(fFloatValue)) {
                    Log.i(TAG, "skip immediate open resync ratio=" + fFloatValue + " (already latched open)");
                    return;
                }
            }
            boolean zB2 = mainScrollOverlayComponent.B2();
            if (aVar.I(j10, zB2)) {
                Log.i(TAG, "skip late open resync idx=" + i11 + " delay=" + j10 + "ms (AiDesktop bound)");
                return;
            }
            Log.i(TAG, "resync open AiDesktop progress=1 idx=" + i11 + " delay=" + j10 + "ms bound=" + zB2);
            mainScrollOverlayComponent.V2(aVar.h(true), com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
        }
    }

    public static final void D3(final int i10, final MainScrollOverlayComponent mainScrollOverlayComponent, final int i11) {
        if (i10 == mainScrollOverlayComponent.pageResumeRetryGeneration && !mainScrollOverlayComponent.isDestroyed && !mainScrollOverlayComponent.isRelaunching && mainScrollOverlayComponent.mOverlayResumed) {
            if (mainScrollOverlayComponent.alreadyInOpen || mainScrollOverlayComponent.isPanelOpen()) {
                KeyEvent.Callback callbackR2 = mainScrollOverlayComponent.r2(mainScrollOverlayComponent.mCurrentPage);
                IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
                if (iOverlayPageView != null) {
                    Log.i(TAG, "pageResume delivered remainingWas=" + i11);
                    iOverlayPageView.onPageResume(mainScrollOverlayComponent.V1());
                    iOverlayPageView.onAllTasksEntryVisibilityChanged(mainScrollOverlayComponent.f2());
                    return;
                }
                Log.d(TAG, "pageResume retry pageNotReady remaining=" + i11);
                if (i11 > 0) {
                    mainScrollOverlayComponent.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.E
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainScrollOverlayComponent.E3(i11, i10, mainScrollOverlayComponent);
                        }
                    });
                    return;
                }
                Log.w(TAG, "pageResume give up: ViewHolder still null at page=" + mainScrollOverlayComponent.mCurrentPage);
            }
        }
    }

    public static final void E3(int i10, int i11, MainScrollOverlayComponent mainScrollOverlayComponent) {
        D3(i11, mainScrollOverlayComponent, i10 - 1);
    }

    public static final void F3(int i10, MainScrollOverlayComponent mainScrollOverlayComponent) {
        D3(i10, mainScrollOverlayComponent, 18);
    }

    public static final void H2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        if (mainScrollOverlayComponent.mOverlayResumed) {
            mainScrollOverlayComponent.d3();
        } else {
            mainScrollOverlayComponent.pendingLocaleRelaunch = true;
        }
    }

    public static final boolean I1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.lastDrawUptimeMs = SystemClock.uptimeMillis();
        if (!mainScrollOverlayComponent.stallProbeActive) {
            mainScrollOverlayComponent.drewSinceOpen = true;
        }
        return true;
    }

    public static final void J1(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.j2(i10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void K2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        ViewPager2 viewPager2 = mainScrollOverlayComponent.mViewPager;
        ViewPager2 viewPager22 = null;
        ViewPager2 viewPager23 = null;
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager2 = null;
        }
        if (viewPager2.getCurrentItem() == i10 && mainScrollOverlayComponent.mCurrentPage == i10) {
            mainScrollOverlayComponent.R1();
            View viewR2 = mainScrollOverlayComponent.r2(i10);
            IOverlayPageView iOverlayPageView = viewR2 instanceof IOverlayPageView ? (IOverlayPageView) viewR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPageResume(OverlayPageResumeReason.PAGE_SWITCH);
            }
            View viewR22 = mainScrollOverlayComponent.r2(i10);
            IOverlayPageView iOverlayPageView2 = viewR22 instanceof IOverlayPageView ? (IOverlayPageView) viewR22 : null;
            if (iOverlayPageView2 == null) {
                return;
            }
            iOverlayPageView2.onAllTasksEntryVisibilityChanged(mainScrollOverlayComponent.f2());
            return;
        }
        if (mainScrollOverlayComponent.mOverlayResumed) {
            ViewPager2 viewPager24 = mainScrollOverlayComponent.mViewPager;
            if (viewPager24 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
            } else {
                viewPager23 = viewPager24;
            }
            viewPager23.m(i10, true);
            return;
        }
        mainScrollOverlayComponent.R1();
        ViewPager2 viewPager25 = mainScrollOverlayComponent.mViewPager;
        if (viewPager25 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
        } else {
            viewPager22 = viewPager25;
        }
        viewPager22.m(i10, false);
        mainScrollOverlayComponent.mCurrentPage = i10;
    }

    public static final Y8.t L2(final MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.n
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.M2(this.f27065a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void M1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.frameCommittedSinceProbe = true;
        mainScrollOverlayComponent.lastDrawUptimeMs = SystemClock.uptimeMillis();
    }

    public static final void M2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.i3("client");
    }

    public static final Y8.t N2(final MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.o
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.O2(this.f27066a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void O2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.k3("explicit-wake");
    }

    public static final Y8.t P2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        KeyEvent.Callback callbackR2 = mainScrollOverlayComponent.r2(mainScrollOverlayComponent.mCurrentPage);
        IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
        if (iOverlayPageView != null) {
            iOverlayPageView.hideImeForHomeConsume();
        }
        return Y8.t.f7040a;
    }

    public static final void Q2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        boolean z10 = mainScrollOverlayComponent.isDestroyed;
        if (!z10 && mainScrollOverlayComponent.mCallback != null) {
            mainScrollOverlayComponent.selfOpenRequest = true;
            mainScrollOverlayComponent.openOverlay(0);
            return;
        }
        Log.w(TAG, "skip restore-open: destroyed=" + z10 + " hasCallback=" + (mainScrollOverlayComponent.mCallback != null));
    }

    public static final void W1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.deferredBootOpenSettlePosted = false;
        mainScrollOverlayComponent.I2("ai_desktop_settled", false);
    }

    public static final void X1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.I2("timeout", true);
    }

    public static final void Y1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        if (mainScrollOverlayComponent.isDestroyed || !mainScrollOverlayComponent.mOverlayResumed || mainScrollOverlayComponent.isRelaunching) {
            return;
        }
        if (mainScrollOverlayComponent.alreadyInOpen || mainScrollOverlayComponent.isPanelOpen()) {
            mainScrollOverlayComponent.B1("debounced");
        }
    }

    public static final void Y3(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.wallpaperChangedResyncPosted = false;
        mainScrollOverlayComponent.G1();
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        if (aVar.D(mainScrollOverlayComponent.alreadyInOpen, mainScrollOverlayComponent.isDestroyed)) {
            Log.i(TAG, "resync open AiDesktop progress=1 reason=wallpaper_changed_debounced");
            mainScrollOverlayComponent.V2(aVar.h(true), com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
        }
    }

    public static final void Z2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        Log.i(TAG, "OnBackInvokedCallback → onBackPressed");
        mainScrollOverlayComponent.onBackPressed();
    }

    public static final void a2() {
        INSTANCE.a();
    }

    public static final void e2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        View view;
        if (!mainScrollOverlayComponent.mOverlayResumed) {
            mainScrollOverlayComponent.pendingDisplaySizeRelaunch = true;
            return;
        }
        if (!mainScrollOverlayComponent.D2()) {
            mainScrollOverlayComponent.displaySizeRelaunchRetries = 0;
            mainScrollOverlayComponent.s3();
            return;
        }
        boolean z10 = SystemClock.uptimeMillis() - mainScrollOverlayComponent.lastPanelTransitionUptimeMs >= DISPLAY_SIZE_RELAUNCH_QUIET_MS;
        boolean z11 = mainScrollOverlayComponent.E2() && (view = mainScrollOverlayComponent.mDecorView) != null && view.hasWindowFocus();
        if (z10 && z11) {
            mainScrollOverlayComponent.displaySizeRelaunchRetries = 0;
            mainScrollOverlayComponent.S3(true);
            mainScrollOverlayComponent.d3();
            return;
        }
        int i10 = mainScrollOverlayComponent.displaySizeRelaunchRetries;
        if (i10 < 8) {
            mainScrollOverlayComponent.displaySizeRelaunchRetries = i10 + 1;
            mainScrollOverlayComponent.q3();
        } else {
            mainScrollOverlayComponent.displaySizeRelaunchRetries = 0;
            mainScrollOverlayComponent.s3();
        }
    }

    public static final void e3(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.J2();
    }

    public static final void h2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.R3();
    }

    public static final void i0(MainScrollOverlayComponent mainScrollOverlayComponent) {
        if (!mainScrollOverlayComponent.overlayUndrawn || mainScrollOverlayComponent.isDestroyed) {
            return;
        }
        mainScrollOverlayComponent.v2("abandon-after-close");
    }

    public static final void i2(MainScrollOverlayComponent mainScrollOverlayComponent) {
        if (mainScrollOverlayComponent.mOverlayResumed) {
            mainScrollOverlayComponent.d3();
        } else {
            mainScrollOverlayComponent.pendingFontScaleRelaunch = true;
        }
    }

    public static final void k2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.j2(i10, false);
    }

    public static final void l2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.j2(i10, false);
    }

    public static final void m2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.j2(i10, false);
    }

    public static final void n2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.j2(i10, true);
    }

    public static final void s2(MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        if (mainScrollOverlayComponent.isDestroyed) {
            return;
        }
        mainScrollOverlayComponent.T3(i10);
    }

    public static final void t3(final int i10, final MainScrollOverlayComponent mainScrollOverlayComponent, final View view, final int i11, final int i12) {
        Object objB;
        Object objB2;
        if (i10 != mainScrollOverlayComponent.inputSurfaceSyncGeneration || !mainScrollOverlayComponent.alreadyInOpen || mainScrollOverlayComponent.isRelaunching || !mainScrollOverlayComponent.mOverlayResumed || mainScrollOverlayComponent.overlayUndrawn || mainScrollOverlayComponent.overlayDrawSuppressed || com.stepos.ailauncher.common.utils.J.INSTANCE.f(mainScrollOverlayComponent.context)) {
            return;
        }
        if (!view.isAttachedToWindow()) {
            if (i11 > 0) {
                view.post(new Runnable() { // from class: com.stepos.ailauncher.container.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.u3(i11, i12, i10, mainScrollOverlayComponent, view);
                    }
                });
                return;
            }
            return;
        }
        if (!mainScrollOverlayComponent.E2() && !view.hasWindowFocus()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                mainScrollOverlayComponent.setFocusable(false);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                Log.w(TAG, "yield focus setFocusable(false) failed: " + thE.getMessage());
            }
            Log.d(TAG, "input surface sync yield focus: overlay invisible");
            if (i12 > 0) {
                view.post(new Runnable() { // from class: com.stepos.ailauncher.container.B
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.v3(i11, i12, i10, mainScrollOverlayComponent, view);
                    }
                });
                return;
            }
            return;
        }
        if (mainScrollOverlayComponent.F2()) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                mainScrollOverlayComponent.setFocusable(true);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB);
            if (thE2 != null) {
                Log.w(TAG, "input surface sync restore focusable failed: " + thE2.getMessage());
                return;
            }
            Log.i(TAG, "input surface sync restored focusable remaining=" + i11);
        }
        if (com.stepos.ailauncher.common.memory.e.l(com.stepos.ailauncher.common.memory.e.INSTANCE, null, 1, null)) {
            Log.d(TAG, "input surface sync skip invalidate under heap pressure");
            if (i11 > 0) {
                view.post(new Runnable() { // from class: com.stepos.ailauncher.container.C
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.w3(i11, i12, i10, mainScrollOverlayComponent, view);
                    }
                });
                return;
            }
            return;
        }
        view.invalidate();
        view.requestApplyInsets();
        if (view.hasWindowFocus()) {
            Log.i(TAG, "input surface sync ok remainingWas=" + i11);
            return;
        }
        if (view.findFocus() == null) {
            view.requestFocus();
        }
        if (i11 > 1 || !mainScrollOverlayComponent.alreadyInOpen || !mainScrollOverlayComponent.E2() || mainScrollOverlayComponent.F2()) {
            if (i11 > 0) {
                view.post(new Runnable() { // from class: com.stepos.ailauncher.container.D
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.x3(i11, i12, i10, mainScrollOverlayComponent, view);
                    }
                });
                return;
            }
            return;
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            mainScrollOverlayComponent.setFocusable(true);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
        if (view.findFocus() == null) {
            view.requestFocus();
        }
        Log.w(TAG, "input surface sync final nudge setFocusable+requestFocus");
    }

    public static final void u3(int i10, int i11, int i12, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        t3(i12, mainScrollOverlayComponent, view, i10 - 1, i11);
    }

    public static final void v3(int i10, int i11, int i12, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        t3(i12, mainScrollOverlayComponent, view, i10, i11 - 1);
    }

    public static final void w1(final MainScrollOverlayComponent mainScrollOverlayComponent, int i10) {
        mainScrollOverlayComponent.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.K
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.x1(this.f27006a);
            }
        });
    }

    public static final void w3(int i10, int i11, int i12, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        t3(i12, mainScrollOverlayComponent, view, i10 - 1, i11);
    }

    public static final void x1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        mainScrollOverlayComponent.G3();
    }

    private final void x2() {
        View viewFindViewById = findViewById(R$id.root_view);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        I3(viewFindViewById);
        View viewQ2 = q2();
        ViewPager2 viewPager2 = null;
        OverlayRootLayout overlayRootLayout = viewQ2 instanceof OverlayRootLayout ? (OverlayRootLayout) viewQ2 : null;
        if (overlayRootLayout != null) {
            overlayRootLayout.setAllTasksEntryListener(new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return MainScrollOverlayComponent.y2(this.f27068a, ((Boolean) obj).booleanValue());
                }
            });
        }
        q2().setWindowInsetsAnimationCallback(new e());
        View viewFindViewById2 = q2().findViewById(R$id.content_container);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        H3(viewFindViewById2);
        this.mGuideView = p2();
        D1();
        View viewFindViewById3 = q2().findViewById(R$id.view_pager);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        ViewPager2 viewPager22 = (ViewPager2) viewFindViewById3;
        this.mViewPager = viewPager22;
        if (viewPager22 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager22 = null;
        }
        viewPager22.setUserInputEnabled(true);
        ViewPagerTouchWrapper viewPagerTouchWrapper = (ViewPagerTouchWrapper) q2().findViewById(R$id.view_pager_wrapper);
        ViewPager2 viewPager23 = this.mViewPager;
        if (viewPager23 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager23 = null;
        }
        viewPagerTouchWrapper.setViewPager(viewPager23);
        viewPagerTouchWrapper.setContentOwnsHorizontalGesture(this.contentOwnsHorizontalGesture);
        this.mPagerTouchWrapper = viewPagerTouchWrapper;
        final IOverlayPageRegistry iOverlayPageRegistry = (IOverlayPageRegistry) D5.a.INSTANCE.a(IOverlayPageRegistry.class);
        if (iOverlayPageRegistry != null) {
            this.mOverlayAdapter = new h0(iOverlayPageRegistry.getPages(), this);
            ViewPager2 viewPager24 = this.mViewPager;
            if (viewPager24 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
                viewPager24 = null;
            }
            viewPager24.setAdapter(this.mOverlayAdapter);
            InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.container.r
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MainScrollOverlayComponent.z2(this.f27069a, iOverlayPageRegistry);
                }
            };
            this.mPagesChangedListener = interfaceC5063a;
            kotlin.jvm.internal.p.f(interfaceC5063a);
            iOverlayPageRegistry.addOnPagesChangedListener(interfaceC5063a);
        }
        this.edgeBackGestureEnabled = false;
        A1();
        ViewPager2 viewPager25 = this.mViewPager;
        if (viewPager25 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager25 = null;
        }
        viewPager25.setOverScrollMode(1);
        ViewPager2 viewPager26 = this.mViewPager;
        if (viewPager26 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager26 = null;
        }
        View childAt = viewPager26.getChildAt(0);
        kotlin.jvm.internal.p.g(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) childAt).setOverScrollMode(2);
        ViewPager2 viewPager27 = this.mViewPager;
        if (viewPager27 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager27 = null;
        }
        viewPager27.setOffscreenPageLimit(1);
        ViewPager2 viewPager28 = this.mViewPager;
        if (viewPager28 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager28 = null;
        }
        viewPager28.setPageTransformer(new ViewPager2.k() { // from class: com.stepos.ailauncher.container.s
            @Override // androidx.viewpager2.widget.ViewPager2.k
            public final void a(View view, float f10) {
                MainScrollOverlayComponent.A2(view, f10);
            }
        });
        h0 h0Var = this.mOverlayAdapter;
        int itemCount = h0Var != null ? h0Var.getItemCount() : 0;
        this.initialPage = C5685n.f(itemCount - 2, 0);
        if (itemCount == 0) {
            Log.w(TAG, "No overlay pages registered, fallback to page 0");
        }
        ViewPager2 viewPager29 = this.mViewPager;
        if (viewPager29 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
        } else {
            viewPager2 = viewPager29;
        }
        viewPager2.m(this.initialPage, false);
        this.mCurrentPage = this.initialPage;
        F1();
    }

    public static final void x3(int i10, int i11, int i12, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        t3(i12, mainScrollOverlayComponent, view, i10 - 1, i11);
    }

    public static final void y1(MainScrollOverlayComponent mainScrollOverlayComponent) {
        if (mainScrollOverlayComponent.allTasksEntryResumeHold) {
            mainScrollOverlayComponent.allTasksEntryResumeHold = false;
            mainScrollOverlayComponent.allTasksEntryHoldExitSeen = false;
            mainScrollOverlayComponent.allTasksEntryHoldSettled = false;
            Log.i(TAG, "allTasksEntry resume hold released visible=" + mainScrollOverlayComponent.lastAllTasksEntryVisible);
            mainScrollOverlayComponent.X2();
        }
    }

    public static final Y8.t y2(MainScrollOverlayComponent mainScrollOverlayComponent, boolean z10) {
        mainScrollOverlayComponent.X3(z10);
        return Y8.t.f7040a;
    }

    public static final void y3(int i10, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        Object objB;
        if (i10 != mainScrollOverlayComponent.inputSurfaceSyncGeneration || !mainScrollOverlayComponent.alreadyInOpen || !mainScrollOverlayComponent.mOverlayResumed || mainScrollOverlayComponent.isRelaunching || mainScrollOverlayComponent.overlayDrawSuppressed || com.stepos.ailauncher.common.utils.J.INSTANCE.f(mainScrollOverlayComponent.context) || view.hasWindowFocus()) {
            return;
        }
        mainScrollOverlayComponent.O1();
        if (!mainScrollOverlayComponent.F2()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                mainScrollOverlayComponent.setFocusable(false);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "focus yield fallback failed: " + thE.getMessage());
            }
        }
        Log.w(TAG, "focus never converged in 2000ms, yield to launcher");
    }

    public static final Y8.t z2(MainScrollOverlayComponent mainScrollOverlayComponent, IOverlayPageRegistry iOverlayPageRegistry) {
        h0 h0Var = mainScrollOverlayComponent.mOverlayAdapter;
        if (h0Var != null) {
            h0Var.g(iOverlayPageRegistry.getPages());
        }
        return Y8.t.f7040a;
    }

    public static final void z3(int i10, MainScrollOverlayComponent mainScrollOverlayComponent, View view) {
        t3(i10, mainScrollOverlayComponent, view, 18, 24);
    }

    public final void A1() {
        List<Rect> listP;
        if (this.mRootView == null) {
            return;
        }
        View viewQ2 = q2();
        if (this.edgeBackGestureEnabled) {
            listP = C1173v.m();
        } else {
            int i10 = getResources().getDisplayMetrics().widthPixels;
            int i11 = getResources().getDisplayMetrics().heightPixels;
            listP = C1173v.p(new Rect(i10 - 120, 0, i10, i11), new Rect(0, 0, 120, i11));
        }
        viewQ2.setSystemGestureExclusionRects(listP);
    }

    public final void A3() {
        if (this.mRootView == null) {
            return;
        }
        Q1();
        c3();
        final int i10 = this.openProgressResyncGeneration + 1;
        this.openProgressResyncGeneration = i10;
        long[] jArrD = com.stepos.ailauncher.container.wallpaper.a.INSTANCE.d();
        int length = jArrD.length;
        final int i11 = 0;
        while (i11 < length) {
            final long j10 = jArrD[i11];
            final MainScrollOverlayComponent mainScrollOverlayComponent = this;
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.container.y
                @Override // java.lang.Runnable
                public final void run() {
                    MainScrollOverlayComponent.B3(i10, mainScrollOverlayComponent, i11, j10);
                }
            };
            mainScrollOverlayComponent.openProgressResyncRunnables.add(runnable);
            mainScrollOverlayComponent.q2().postDelayed(runnable, j10);
            i11++;
            this = mainScrollOverlayComponent;
        }
    }

    public final void B1(String reason) {
        boolean z10 = r2(this.mCurrentPage) != null;
        Log.i(TAG, "onResume resume-branch reason=" + reason + " pageReady=" + z10 + " visible=" + E2());
        l3("open-panel-resume", E2());
        S3(false);
        C3();
        s3();
        Y2();
    }

    public final boolean B2() {
        Object objB;
        ComponentName component;
        try {
            Result.Companion companion = Result.INSTANCE;
            WallpaperInfo wallpaperInfo = WallpaperManager.getInstance(this.context).getWallpaperInfo();
            objB = Result.b(Boolean.valueOf(com.stepos.ailauncher.container.wallpaper.a.INSTANCE.e((wallpaperInfo == null || (component = wallpaperInfo.getComponent()) == null) ? null : component.getClassName())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void C1() {
        Object objB;
        float fW2 = W2();
        float fMin = Math.min(fW2, 1.18f);
        Configuration configuration = getResources().getConfiguration();
        if (this.nightContextPinned && configuration.fontScale == fMin) {
            return;
        }
        Context baseContext = this.originalBaseContext;
        if (baseContext == null) {
            baseContext = getBaseContext();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Configuration configuration2 = new Configuration(baseContext.getResources().getConfiguration());
            configuration2.fontScale = fMin;
            configuration2.uiMode = (configuration2.uiMode & (-49)) | 32;
            Context contextCreateConfigurationContext = baseContext.createConfigurationContext(configuration2);
            Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            declaredField.set(this, contextCreateConfigurationContext);
            String[] strArr = {"mResources", "mInflater"};
            for (int i10 = 0; i10 < 2; i10++) {
                String str = strArr[i10];
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    Field declaredField2 = ContextThemeWrapper.class.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    declaredField2.set(this, null);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            float f10 = displayMetrics.density * fMin;
            displayMetrics.scaledDensity = f10;
            Log.i(TAG, "[ThemeCap-Overlay] night forced, systemFs=" + fW2 + " targetFs=" + fMin + " (sd=" + f10 + ")");
            this.nightContextPinned = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "[ThemeCap-Overlay] reflect failed", thE);
        }
    }

    public final boolean C2(View v10) {
        if (v10 == q2()) {
            return true;
        }
        for (ViewParent parent = v10.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == q2()) {
                return true;
            }
        }
        return false;
    }

    public final void C3() {
        if (this.isDestroyed || this.isRelaunching) {
            return;
        }
        if (this.alreadyInOpen || isPanelOpen()) {
            final int i10 = this.pageResumeRetryGeneration + 1;
            this.pageResumeRetryGeneration = i10;
            this.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.u
                @Override // java.lang.Runnable
                public final void run() {
                    MainScrollOverlayComponent.F3(i10, this);
                }
            });
        }
    }

    public final void D1() {
        Object objB;
        boolean z10 = !this.contentOwnsHorizontalGesture;
        try {
            Result.Companion companion = Result.INSTANCE;
            getSlidingPanelLayout().setPanelDragEnable(z10);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "applyPanelDragEnable(" + z10 + ") failed", thE);
        }
    }

    public final boolean D2() {
        return this.alreadyInOpen || isPanelOpen();
    }

    public final void E1() {
        Integer num;
        int i10;
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 == null) {
            return;
        }
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager2 = null;
        }
        if (viewPager2.getScrollState() == 0 && (num = this.pendingPageSwitchTo) != null) {
            int iIntValue = num.intValue();
            this.pendingPageSwitchTo = null;
            if (this.mOverlayResumed && isPanelOpen() && (i10 = this.mCurrentPage) != iIntValue) {
                Log.i(TAG, "pageSwitch apply from=" + i10 + " to=" + iIntValue);
                KeyEvent.Callback callbackR2 = r2(i10);
                IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
                if (iOverlayPageView != null) {
                    iOverlayPageView.onPagePause();
                }
                KeyEvent.Callback callbackR22 = r2(i10);
                IOverlayPageView iOverlayPageView2 = callbackR22 instanceof IOverlayPageView ? (IOverlayPageView) callbackR22 : null;
                if (iOverlayPageView2 != null) {
                    iOverlayPageView2.onPageStop();
                }
                this.mCurrentPage = iIntValue;
                KeyEvent.Callback callbackR23 = r2(iIntValue);
                IOverlayPageView iOverlayPageView3 = callbackR23 instanceof IOverlayPageView ? (IOverlayPageView) callbackR23 : null;
                if (iOverlayPageView3 != null) {
                    iOverlayPageView3.onPageResume(OverlayPageResumeReason.PAGE_SWITCH);
                }
                KeyEvent.Callback callbackR24 = r2(iIntValue);
                IOverlayPageView iOverlayPageView4 = callbackR24 instanceof IOverlayPageView ? (IOverlayPageView) callbackR24 : null;
                if (iOverlayPageView4 == null) {
                    return;
                }
                iOverlayPageView4.onAllTasksEntryVisibilityChanged(f2());
            }
        }
    }

    public final boolean E2() {
        WindowManager.LayoutParams attributes;
        Window window = this.mWindow;
        return (window == null || (attributes = window.getAttributes()) == null || attributes.alpha <= 0.01f) ? false : true;
    }

    public final void F1() {
        WindowManager.LayoutParams attributes;
        Window window = this.mWindow;
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        com.stepos.ailauncher.container.wallpaper.g gVar = com.stepos.ailauncher.container.wallpaper.g.INSTANCE;
        if (!gVar.a(attributes.flags)) {
            attributes.flags = gVar.c(attributes.flags);
            window.setAttributes(attributes);
            Log.i(TAG, "applyShowWallpaperWindow: FLAG_SHOW_WALLPAPER");
        }
        window.setBackgroundDrawableResource(R.color.transparent);
        if (this.mRootView != null) {
            q2().setBackgroundColor(0);
        }
        if (this.mContentView != null) {
            p2().setBackgroundColor(0);
        }
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            if (viewPager2 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
                viewPager2 = null;
            }
            viewPager2.setBackgroundColor(0);
        }
    }

    public final boolean F2() {
        WindowManager.LayoutParams attributes;
        Window window = this.mWindow;
        return window == null || (attributes = window.getAttributes()) == null || (attributes.flags & 8) != 0;
    }

    public final void G1() {
        if (this.deferredBootOpenFlags == null || this.isDestroyed || this.mRootView == null) {
            return;
        }
        boolean zB2 = B2();
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        if (!aVar.q(true, zB2)) {
            q2().removeCallbacks(this.deferredBootOpenSettleRunnable);
            this.deferredBootOpenSettlePosted = false;
            Log.i(TAG, "cancel deferred settle: AiDesktop unbound");
        } else {
            if (!aVar.C(zB2, this.deferredBootOpenSettlePosted)) {
                Log.i(TAG, "keep deferred settle (AiDesktop still bound)");
                return;
            }
            q2().removeCallbacks(this.deferredBootOpenSettleRunnable);
            this.deferredBootOpenSettlePosted = true;
            q2().postDelayed(this.deferredBootOpenSettleRunnable, 2000L);
            Log.i(TAG, "arm deferred open settle 2000ms");
        }
    }

    public final boolean G2() {
        WindowManager.LayoutParams attributes;
        Window window = this.mWindow;
        return (window == null || (attributes = window.getAttributes()) == null || (attributes.flags & 16) == 0) ? false : true;
    }

    public final void G3() {
        this.mMainHandler.removeCallbacks(this.relaunchRunnable);
        this.mMainHandler.postDelayed(this.relaunchRunnable, 300L);
    }

    public final void H1() {
        View view = this.mDecorView;
        if (view == null) {
            return;
        }
        b2();
        final int i10 = this.frameWatchdogGeneration + 1;
        this.frameWatchdogGeneration = i10;
        this.lastDrawUptimeMs = SystemClock.uptimeMillis();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.ailauncher.container.v
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return MainScrollOverlayComponent.I1(this.f27074a);
                }
            };
            this.frameWatchdogPreDrawListener = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
            this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.w
                @Override // java.lang.Runnable
                public final void run() {
                    MainScrollOverlayComponent.J1(this.f27075a, i10);
                }
            }, 1500L);
        }
    }

    public final void H3(View view) {
        kotlin.jvm.internal.p.i(view, "<set-?>");
        this.mContentView = view;
    }

    public final void I2(String reason, boolean force) {
        Integer num = this.deferredBootOpenFlags;
        if (num != null) {
            int iIntValue = num.intValue();
            if (this.isDestroyed) {
                this.deferredBootOpenFlags = null;
                return;
            }
            boolean zB2 = B2();
            if (force || (kotlin.jvm.internal.p.d(reason, "ai_desktop_settled") && zB2)) {
                this.deferredBootOpenFlags = null;
                this.deferredBootOpenSettlePosted = false;
                if (force) {
                    this.deferredBootOpenGaveUp = true;
                }
                if (this.mRootView != null) {
                    q2().removeCallbacks(this.deferredBootOpenTimeoutRunnable);
                    q2().removeCallbacks(this.deferredBootOpenSettleRunnable);
                }
                Log.i(TAG, "complete deferred openOverlay reason=" + reason + " force=" + force + " aiDesktop=" + zB2 + " flags=" + iIntValue);
                openOverlay(iIntValue);
            }
        }
    }

    public final void I3(View view) {
        kotlin.jvm.internal.p.i(view, "<set-?>");
        this.mRootView = view;
    }

    public final boolean J2() {
        int iA = n0.INSTANCE.a(this);
        if (iA == this.appliedThemeResId) {
            this.pendingRelaunch = false;
            return false;
        }
        if (!this.mOverlayResumed) {
            this.pendingRelaunch = true;
            return false;
        }
        this.appliedThemeResId = iA;
        d3();
        return true;
    }

    public final boolean J3() {
        return !this.fingerDragging && this.openVeto.i(D2(), this.overlayUndrawn);
    }

    public final void K1(boolean open) {
        this.pendingAiDesktopEndOpen = Boolean.valueOf(open);
        this.pendingEndRestTicks = 0;
        K3();
    }

    public final void K3() {
        if (this.isDestroyed || this.mRootView == null) {
            return;
        }
        this.followPanelProgress = true;
        q2().removeCallbacks(this.followPanelProgressRunnable);
        q2().postOnAnimation(this.followPanelProgressRunnable);
    }

    public final void L1(View decor) {
        U1(decor);
        this.frameCommittedSinceProbe = false;
        ViewTreeObserver viewTreeObserver = decor.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.container.J
                @Override // java.lang.Runnable
                public final void run() {
                    MainScrollOverlayComponent.M1(this.f27005a);
                }
            };
            this.frameCommitCallback = runnable;
            viewTreeObserver.registerFrameCommitCallback(runnable);
        }
    }

    public final void L3() {
        N3();
        this.lastPlaybackPaused = null;
        this.playbackWatchJob = C1060i.d(kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate())), null, null, new MainScrollOverlayComponent$startWallpaperPlaybackWatch$1(this, null), 3, null);
    }

    public final void M3() {
        this.followPanelProgress = false;
        if (this.mRootView != null) {
            q2().removeCallbacks(this.followPanelProgressRunnable);
        }
    }

    public final void N1() {
        this.lifecycleResumeGeneration++;
        this.mMainHandler.removeCallbacks(this.deferredOpenPanelResumeRunnable);
    }

    public final void N3() {
        kotlinx.coroutines.g gVar = this.playbackWatchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.playbackWatchJob = null;
        this.lastPlaybackPaused = null;
    }

    public final void O1() {
        this.inputSurfaceSyncGeneration++;
    }

    public final void O3(String reason) {
        Object objB;
        if (this.isDestroyed) {
            return;
        }
        this.overlayDrawSuppressed = true;
        this.allTasksEntryResumeHold = true;
        this.allTasksEntryHoldExitSeen = false;
        this.allTasksEntryHoldSettled = false;
        this.mMainHandler.removeCallbacks(this.allTasksEntryHoldReleaseRunnable);
        N1();
        P1();
        u2();
        KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
        IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
        if (iOverlayPageView != null) {
            iOverlayPageView.onEnterSystemRecents();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            setFocusable(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "suppress setFocusable(false) failed: " + thE.getMessage());
        }
        Log.i(TAG, "suppress overlay draw+input reason=" + reason + " panelOpen=" + this.alreadyInOpen + " aarOpen=" + isPanelOpen());
    }

    public final void P1() {
        this.inputSurfaceSyncGeneration++;
        this.pageResumeRetryGeneration++;
        b2();
    }

    public final void P3() {
        Object objB;
        LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
        kotlin.jvm.internal.p.h(locales, "getLocales(...)");
        LocaleList locales2 = getResources().getConfiguration().getLocales();
        kotlin.jvm.internal.p.h(locales2, "getLocales(...)");
        if (kotlin.jvm.internal.p.d(locales, locales2)) {
            return;
        }
        Context baseContext = this.originalBaseContext;
        if (baseContext == null) {
            baseContext = getBaseContext();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Configuration configuration = new Configuration(baseContext.getResources().getConfiguration());
            configuration.setLocales(locales);
            Context contextCreateConfigurationContext = baseContext.createConfigurationContext(configuration);
            Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            declaredField.set(this, contextCreateConfigurationContext);
            String[] strArr = {"mResources", "mInflater"};
            for (int i10 = 0; i10 < 2; i10++) {
                String str = strArr[i10];
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    Field declaredField2 = ContextThemeWrapper.class.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    declaredField2.set(this, null);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
            this.originalBaseContext = contextCreateConfigurationContext;
            objB = Result.b(Integer.valueOf(Log.i(TAG, "[LocaleSync-Overlay] synced locale to " + locales)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "[LocaleSync-Overlay] reflect failed", thE);
        }
    }

    public final void Q1() {
        this.openProgressResyncGeneration++;
        if (this.mRootView != null) {
            Iterator<Runnable> it = this.openProgressResyncRunnables.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                Runnable next = it.next();
                kotlin.jvm.internal.p.h(next, "next(...)");
                q2().removeCallbacks(next);
            }
            q2().removeCallbacks(this.wallpaperChangedResyncRunnable);
            q2().removeCallbacks(this.deferredBootOpenTimeoutRunnable);
            q2().removeCallbacks(this.deferredBootOpenSettleRunnable);
        }
        this.openProgressResyncRunnables.clear();
        this.wallpaperChangedResyncPosted = false;
        if (!this.alreadyInOpen) {
            this.deferredBootOpenFlags = null;
            this.deferredBootOpenSettlePosted = false;
            this.deferredBootOpenGaveUp = false;
        }
        W3();
    }

    public final void Q3() {
        if (isPanelOpen()) {
            this.alreadyInOpen = true;
            m0.p(m0.INSTANCE, true, false, 2, null);
        }
    }

    public final void R1() {
        this.pendingPageSwitchTo = null;
    }

    public final void R2() {
        if (this.allTasksEntryResumeHold) {
            this.allTasksEntryHoldExitSeen = false;
            if (this.overlayDrawSuppressed) {
                this.allTasksEntryHoldSettled = true;
                Log.i(TAG, "allTasksEntry launcher settled, wait restore");
            } else {
                this.mMainHandler.removeCallbacks(this.allTasksEntryHoldReleaseRunnable);
                this.mMainHandler.postDelayed(this.allTasksEntryHoldReleaseRunnable, 100L);
                Log.i(TAG, "allTasksEntry launcher settled, release hold");
            }
        }
    }

    public final void R3() {
        SlidingPanelLayout slidingPanelLayout;
        if (!this.followPanelProgress || this.isDestroyed || this.mRootView == null || (slidingPanelLayout = getSlidingPanelLayout()) == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Boolean bool = this.pendingAiDesktopEndOpen;
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        boolean zF = aVar.f(this.fingerDragging, slidingPanelLayout.mSettling, slidingPanelLayout.mIsPageMoving);
        if (bool != null && zF) {
            this.pendingEndRestTicks++;
        } else if (bool != null) {
            this.pendingEndRestTicks = 0;
        }
        float f10 = slidingPanelLayout.mPanelPositionRatio;
        long j10 = this.lastFollowElapsed;
        long j11 = j10 != 0 ? jElapsedRealtime - j10 : 0L;
        if (aVar.B(this.closeWallpaperEndLatched, f10, this.lastFollowRatio)) {
            this.closeWallpaperEndLatched = false;
            Log.i(TAG, "wallpaper close END released ratio=" + f10 + " (drag reversed)");
        }
        Boolean bool2 = Boolean.FALSE;
        if (aVar.x(aVar.c(kotlin.jvm.internal.p.d(bool, bool2), this.fingerDragging), f10, this.lastFollowRatio, j11, this.closeWallpaperEndLatched)) {
            T2(f10, "fast-drag");
            this.pendingAiDesktopEndOpen = null;
            this.pendingEndRestTicks = 0;
        }
        if (aVar.w(kotlin.jvm.internal.p.d(bool, bool2), f10, this.closeWallpaperEndLatched)) {
            T2(f10, "settle");
            this.pendingAiDesktopEndOpen = null;
            this.pendingEndRestTicks = 0;
        }
        this.lastFollowRatio = f10;
        this.lastFollowElapsed = jElapsedRealtime;
        if (!this.closeWallpaperEndLatched && bool != null && aVar.u(bool.booleanValue(), slidingPanelLayout.mPanelPositionRatio, zF, this.pendingEndRestTicks)) {
            V2(aVar.h(bool.booleanValue()), com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
            if (!bool.booleanValue()) {
                this.closeWallpaperEndLatched = true;
                Log.i(TAG, "wallpaper close END latched, handoff waits for panel close");
            }
            this.pendingAiDesktopEndOpen = null;
            this.pendingEndRestTicks = 0;
            this.followPanelProgress = false;
            return;
        }
        if (this.closeWallpaperEndLatched) {
            m0.INSTANCE.s(slidingPanelLayout.mPanelPositionRatio);
        } else if (aVar.z(this.fingerDragging, jElapsedRealtime - this.lastOnScrollElapsed)) {
            U2(slidingPanelLayout.mPanelPositionRatio, com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE);
        }
        if (aVar.t(this.fingerDragging, slidingPanelLayout.mSettling, slidingPanelLayout.mIsPageMoving, this.pendingAiDesktopEndOpen != null)) {
            q2().postOnAnimation(this.followPanelProgressRunnable);
        } else {
            this.followPanelProgress = false;
        }
    }

    public final void S1() {
        Object objB;
        if (this.mRootView == null) {
            return;
        }
        Object systemService = this.context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        View rootView = q2().getRootView();
        String[] strArr = {"mNextServedView", "mServedView", "mCurRootView"};
        for (int i10 = 0; i10 < 3; i10++) {
            String str = strArr[i10];
            try {
                Result.Companion companion = Result.INSTANCE;
                Field declaredField = InputMethodManager.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(inputMethodManager);
                View view = obj instanceof View ? (View) obj : null;
                if (view != null && (view.getRootView() == rootView || C2(view))) {
                    declaredField.set(inputMethodManager, null);
                    Log.i(TAG, "clearImmFocusLeak: cleared IMM." + str);
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "clearImmFocusLeak " + str + " failed: " + thE.getMessage());
            }
        }
    }

    public final void S2(boolean suspended) {
        m0.INSTANCE.t(suspended);
        OverlayRecentsInputGate.a aVarE = this.recentsInputGate.e(suspended);
        if (aVarE instanceof OverlayRecentsInputGate.a.Suppress) {
            if (this.isDestroyed) {
                return;
            }
            O3(((OverlayRecentsInputGate.a.Suppress) aVarE).getReason());
        } else if (aVarE instanceof OverlayRecentsInputGate.a.Restore) {
            k3(((OverlayRecentsInputGate.a.Restore) aVarE).getReason());
        }
    }

    public final void S3(boolean force) {
        if (this.isDestroyed) {
            return;
        }
        com.stepos.ailauncher.common.memory.e.r(com.stepos.ailauncher.common.memory.e.INSTANCE, this.context, force, null, 4, null);
    }

    public final void T1(String reason) {
        if (this.overlayDrawSuppressed) {
            this.overlayDrawSuppressed = false;
            Log.i(TAG, "clear overlay draw suppress reason=" + reason);
            m3(reason);
        }
    }

    public final void T2(float ratio, String reason) {
        if (this.mRootView == null) {
            return;
        }
        this.closeWallpaperEndLatched = true;
        Log.i(TAG, "wallpaper close END primed ratio=" + ratio + " reason=" + reason + ", handoff waits for panel close");
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        aVar.n(this, q2().getWindowToken(), aVar.h(false), com.stepos.ailauncher.container.wallpaper.a.PHASE_END, true);
    }

    public final void T3(int level) {
        Object objB;
        if (this.isDestroyed) {
            return;
        }
        h0 h0Var = this.mOverlayAdapter;
        int itemCount = h0Var != null ? h0Var.getItemCount() : 0;
        Log.d(TAG, "trimOverlayPages level=" + level + " pages=" + itemCount);
        for (int i10 = 0; i10 < itemCount; i10++) {
            KeyEvent.Callback callbackR2 = r2(i10);
            IMemoryTrimmable iMemoryTrimmable = callbackR2 instanceof IMemoryTrimmable ? (IMemoryTrimmable) callbackR2 : null;
            if (iMemoryTrimmable != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    iMemoryTrimmable.onTrimMemory(level);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "onTrimMemory failed at page=" + i10, thE);
                }
            }
        }
    }

    public final void U1(View decor) {
        ViewTreeObserver viewTreeObserver;
        Runnable runnable = this.frameCommitCallback;
        if (runnable == null) {
            return;
        }
        this.frameCommitCallback = null;
        if (decor == null || (viewTreeObserver = decor.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.unregisterFrameCommitCallback(runnable);
    }

    public final void U2(float progress, String phase) {
        m0.INSTANCE.s(progress);
        c2(progress, phase);
    }

    public final void U3() {
        Object objB;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.backInvokedCallback;
        if (onBackInvokedCallback == null) {
            return;
        }
        Y8.t tVar = null;
        this.backInvokedCallback = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            Window window = this.mWindow;
            if (window != null && (onBackInvokedDispatcher = window.getOnBackInvokedDispatcher()) != null) {
                onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
                tVar = Y8.t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "unregisterOnBackInvokedCallback failed: " + thE.getMessage());
        }
    }

    public final OverlayPageResumeReason V1() {
        if (!this.panelOpenedByLauncher) {
            return OverlayPageResumeReason.OVERLAY_ACTIVITY_RESUME;
        }
        this.panelOpenedByLauncher = false;
        Log.i(TAG, "pageResume reason=LAUNCHER_OPEN (panel opened by launcher, not dragged)");
        return OverlayPageResumeReason.LAUNCHER_OPEN;
    }

    public final void V2(float progress, String phase) {
        m0.INSTANCE.s(progress);
        if (this.mRootView == null) {
            return;
        }
        com.stepos.ailauncher.container.wallpaper.a.INSTANCE.n(this, q2().getWindowToken(), progress, phase, true);
    }

    public final void V3() {
        Object objB;
        if (this.recentsFocusYieldReceiverRegistered) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.context.getApplicationContext().unregisterReceiver(this.recentsFocusYieldReceiver);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "unregister recents focus-yield receiver failed", thE);
            }
            this.recentsFocusYieldReceiverRegistered = false;
        }
    }

    public final float W2() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Float.valueOf(Settings.System.getFloat(this.context.getContentResolver(), "font_scale", 1.0f)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Float fValueOf = Float.valueOf(1.0f);
        if (Result.g(objB)) {
            objB = fValueOf;
        }
        return ((Number) objB).floatValue();
    }

    public final void W3() {
        Object objB;
        if (this.deferredBootOpenFlags == null && this.wallpaperChangedReceiverRegistered) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.context.getApplicationContext().unregisterReceiver(this.wallpaperChangedReceiver);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "unregister wallpaper changed receiver failed", thE);
            }
            this.wallpaperChangedReceiverRegistered = false;
        }
    }

    public final void X2() {
        KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
        IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
        if (iOverlayPageView == null) {
            return;
        }
        iOverlayPageView.onAllTasksEntryVisibilityChanged(f2());
    }

    public final void X3(boolean visible) {
        this.lastAllTasksEntryVisible = visible;
        m0.INSTANCE.r(visible);
        z1();
    }

    public final void Y2() {
        Window window;
        Object objB;
        if (this.backInvokedCallback == null && (window = this.mWindow) != null) {
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: com.stepos.ailauncher.container.x
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    MainScrollOverlayComponent.Z2(this.f27077a);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                window.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, onBackInvokedCallback);
                this.backInvokedCallback = onBackInvokedCallback;
                objB = Result.b(Integer.valueOf(Log.i(TAG, "OnBackInvokedCallback registered")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "registerOnBackInvokedCallback failed: " + thE.getMessage());
            }
        }
    }

    public final void Z1() {
        try {
            N3();
            this.mMainHandler.removeCallbacksAndMessages(null);
            com.stepos.ailauncher.configuration.b.INSTANCE.a().n(this);
            com.stepos.ailauncher.container.wallpaper.e.b().h();
            com.stepos.ailauncher.common.utils.J.INSTANCE.h(this.screenPowerListener);
            V3();
        } catch (Exception e10) {
            Log.e(TAG, " message: " + e10.getMessage());
        }
    }

    @Override // com.stepos.ailauncher.configuration.d
    public void a() {
        Log.d(TAG, "fontScaleChanged");
        r3();
    }

    public final void a3() {
        v1();
        L3();
        com.stepos.ailauncher.configuration.b.INSTANCE.a().l(this);
        com.stepos.ailauncher.common.utils.J.c(com.stepos.ailauncher.common.utils.J.INSTANCE, this.context, this.screenPowerListener, false, 4, null);
        b3();
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void applyContentViewProperties(Bundle bundle) {
        kotlin.jvm.internal.p.i(bundle, "bundle");
        boolean zIsOverlayInputSuspendedByRecents = isOverlayInputSuspendedByRecents();
        super.applyContentViewProperties(bundle);
        boolean zIsOverlayInputSuspendedByRecents2 = isOverlayInputSuspendedByRecents();
        if (zIsOverlayInputSuspendedByRecents != zIsOverlayInputSuspendedByRecents2) {
            if (!zIsOverlayInputSuspendedByRecents2 && this.allTasksEntryResumeHold) {
                this.allTasksEntryHoldExitSeen = true;
            }
            S2(zIsOverlayInputSuspendedByRecents2);
            return;
        }
        if (!zIsOverlayInputSuspendedByRecents2 && this.allTasksEntryHoldExitSeen && bundle.containsKey("overlay_window_focusable")) {
            R2();
        }
    }

    @Override // com.stepos.ailauncher.configuration.g
    public void b() {
        Log.d(TAG, "uiModeChanged");
        G3();
    }

    public final void b2() {
        ViewTreeObserver viewTreeObserver;
        this.frameWatchdogGeneration++;
        this.stallProbeActive = false;
        U1(this.mDecorView);
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.frameWatchdogPreDrawListener;
        if (onPreDrawListener == null) {
            return;
        }
        this.frameWatchdogPreDrawListener = null;
        View view = this.mDecorView;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
    }

    public final void b3() {
        Object objB;
        if (this.recentsFocusYieldReceiverRegistered) {
            return;
        }
        Context applicationContext = this.context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.systemui.recents.action.SHOW_GESTURE_VIEW");
        intentFilter.addAction("com.android.systemui.recents.action.CANCEL_GESTURE_VIEW");
        intentFilter.addAction("com.stepos.ACTION_ENTER_RECENTS");
        try {
            Result.Companion companion = Result.INSTANCE;
            applicationContext.registerReceiver(this.recentsFocusYieldReceiver, intentFilter, 2);
            this.recentsFocusYieldReceiverRegistered = true;
            objB = Result.b(Integer.valueOf(Log.d(TAG, "registered recents focus-yield receiver")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "register recents focus-yield receiver failed", thE);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.lastLiveLauncherCallback = null;
        super.binderDied();
    }

    @Override // com.stepos.ailauncher.configuration.f
    public void c() {
        Log.d(TAG, "localeChanged");
        this.mMainHandler.removeCallbacks(this.localeRelaunchRunnable);
        this.mMainHandler.postDelayed(this.localeRelaunchRunnable, 300L);
    }

    public final void c2(float progress, String phase) {
        if (this.mRootView == null) {
            return;
        }
        com.stepos.ailauncher.container.wallpaper.a.INSTANCE.m(this, q2().getWindowToken(), progress, phase);
    }

    public final void c3() {
        Object objB;
        if (this.wallpaperChangedReceiverRegistered) {
            return;
        }
        Context applicationContext = this.context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.WALLPAPER_CHANGED");
        try {
            Result.Companion companion = Result.INSTANCE;
            applicationContext.registerReceiver(this.wallpaperChangedReceiver, intentFilter, 2);
            this.wallpaperChangedReceiverRegistered = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "register wallpaper changed receiver failed", thE);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.ailauncher.container.api.IOverlayPageHost
    public void closeOverlay(boolean animate) {
        super.closeOverlay(animate);
        K3();
    }

    public final void d2(boolean pause) {
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        Boolean boolK = aVar.k(this.lastPlaybackPaused, pause);
        if (boolK == null) {
            this.lastPlaybackPaused = Boolean.valueOf(pause);
            return;
        }
        boolean zBooleanValue = boolK.booleanValue();
        if (this.mRootView == null) {
            return;
        }
        this.lastPlaybackPaused = boolK;
        aVar.o(this, q2().getWindowToken(), zBooleanValue);
    }

    public final void d3() {
        Object objB;
        if (this.isRelaunching) {
            Log.w(TAG, "relaunch ignored: already relaunching");
            return;
        }
        this.isRelaunching = true;
        this.pendingRelaunch = false;
        P1();
        try {
            Result.Companion companion = Result.INSTANCE;
            setFocusable(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "relaunch setFocusable(false) failed: " + thE.getMessage());
        }
        View view = this.mDecorView;
        boolean zIsEnabled = view != null ? view.isEnabled() : true;
        if (view != null) {
            view.setEnabled(false);
        }
        try {
            Bundle bundleSaveHierarchyState = this.mWindow.saveHierarchyState();
            bundleSaveHierarchyState.putBoolean("state_before_relaunch", isPanelOpen());
            onDestroy();
            j3();
            onCreate(bundleSaveHierarchyState);
        } finally {
            if (view != null) {
                view.setEnabled(zIsEnabled);
            }
            this.isRelaunching = false;
            if (D2()) {
                s3();
            }
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.DialogOverlayContextWrapper, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        int keyCode = event.getKeyCode();
        if (keyCode == 4) {
            if (event.getAction() == 1 && !event.isCanceled()) {
                Log.i(TAG, "dispatchKeyEvent BACK → onBackPressed");
                onBackPressed();
            }
            return true;
        }
        if (keyCode != 82 && keyCode != 84 && keyCode != 187) {
            return super.dispatchKeyEvent(event);
        }
        Log.d(TAG, "dispatchKeyEvent fast-ack key=" + event.getKeyCode() + " action=" + event.getAction());
        return true;
    }

    public final boolean f2() {
        return this.lastAllTasksEntryVisible && !this.allTasksEntryResumeHold;
    }

    public final void f3(String reason) {
        Object objB;
        Y8.t tVar;
        if (this.overlayUndrawn || G2()) {
            this.overlayUndrawn = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                Window window = this.mWindow;
                if (window != null) {
                    window.clearFlags(16);
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                objB = Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "release FLAG_NOT_TOUCHABLE failed: " + thE.getMessage());
            }
            Log.i(TAG, "release overlay input reason=" + reason);
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
    public void flushPendingPageResume() {
        if (this.isDestroyed || !this.mOverlayResumed || this.isRelaunching) {
            return;
        }
        if (this.alreadyInOpen || isPanelOpen()) {
            this.mMainHandler.removeCallbacks(this.deferredOpenPanelResumeRunnable);
            this.deferredOpenPanelResumeRunnable.run();
        }
    }

    public final int g2(int level) {
        return com.stepos.ailauncher.common.memory.e.f(com.stepos.ailauncher.common.memory.e.INSTANCE, level, null, 2, null);
    }

    public final void g3() {
        WindowManager.LayoutParams attributes;
        if (this.deferredBootOpenFlags != null) {
            Log.i(TAG, "keep FLAG_SHOW_WALLPAPER: boot open still deferred");
            return;
        }
        Window window = this.mWindow;
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        com.stepos.ailauncher.container.wallpaper.g gVar = com.stepos.ailauncher.container.wallpaper.g.INSTANCE;
        if (gVar.a(attributes.flags)) {
            attributes.flags = gVar.d(attributes.flags);
            window.setAttributes(attributes);
            Log.i(TAG, "relinquishWallpaperTargetForClose: clear FLAG_SHOW_WALLPAPER");
        }
    }

    public final void h0(String reason) {
        Object objB;
        Object objB2;
        if (this.isDestroyed || this.abandoningOverlay) {
            return;
        }
        this.abandoningOverlay = true;
        try {
            Log.w(TAG, "abandon undrawn overlay reason=" + reason + " panelOpen=" + this.alreadyInOpen + " aarOpen=" + isPanelOpen());
            P1();
            this.fingerDragging = false;
            this.openVeto.f();
            this.panelOpenedByLauncher = false;
            v2("abandon-" + reason);
            if (this.alreadyInOpen || isPanelOpen() || isPanelBeingDragged()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    closeOverlay(false);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "abandon closeOverlay failed: " + thE.getMessage());
                }
                View view = this.mDecorView;
                if (view != null) {
                    view.post(new Runnable() { // from class: com.stepos.ailauncher.container.M
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainScrollOverlayComponent.i0(this.f27008a);
                        }
                    });
                }
                if (this.alreadyInOpen) {
                    Log.w(TAG, "abandon: close did not reset panel, forcing local closed");
                    this.alreadyInOpen = false;
                    m0.INSTANCE.o(false, true);
                    try {
                        setFocusable(false);
                        objB2 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th2) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th2));
                    }
                    Throwable thE2 = Result.e(objB2);
                    if (thE2 != null) {
                        Log.w(TAG, "abandon setFocusable(false) failed: " + thE2.getMessage());
                    }
                }
            }
        } finally {
            this.abandoningOverlay = false;
        }
    }

    public final void h3() {
        if (isAttachToWindow()) {
            Log.w(TAG, "window still attached after onDestroy, removing decor view directly");
            removeDecorViewIfNeeded();
        }
    }

    public final void i3(String reason) {
        Object objB;
        if (this.isDestroyed || !this.alreadyInOpen || !this.mOverlayResumed || this.isRelaunching) {
            return;
        }
        if (this.overlayUndrawn) {
            Log.d(TAG, "requestOverlayInputFocus skip undrawn reason=" + reason);
            return;
        }
        if (com.stepos.ailauncher.common.utils.J.INSTANCE.f(this.context)) {
            Log.d(TAG, "requestOverlayInputFocus skip screenOff reason=" + reason);
            return;
        }
        if (this.overlayDrawSuppressed) {
            if (!E2()) {
                Log.d(TAG, "requestOverlayInputFocus skip suppressed reason=" + reason);
                return;
            }
            k3(reason + "-while-suppressed");
        }
        if (!E2()) {
            Log.d(TAG, "requestOverlayInputFocus skip invisible reason=" + reason);
            return;
        }
        View view = this.mDecorView;
        boolean z10 = false;
        if (view != null && view.hasWindowFocus()) {
            z10 = true;
        }
        boolean zF2 = F2();
        Log.i(TAG, "requestOverlayInputFocus reason=" + reason + " windowFocused=" + z10 + " notFocusable=" + zF2);
        if (!zF2) {
            if (z10) {
                return;
            }
            s3();
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            setFocusable(true);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "requestOverlayInputFocus setFocusable failed: " + thE.getMessage());
        }
        s3();
    }

    public final void j2(final int gen, boolean probed) {
        if (gen == this.frameWatchdogGeneration && !this.isDestroyed && !this.isRelaunching && this.mOverlayResumed && this.alreadyInOpen && !this.overlayDrawSuppressed && E2() && !com.stepos.ailauncher.common.utils.J.INSTANCE.f(this.context)) {
            if (com.stepos.ailauncher.common.memory.e.l(com.stepos.ailauncher.common.memory.e.INSTANCE, null, 1, null)) {
                Log.w(TAG, "frame stall check skip invalidate under heap pressure");
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.F
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.k2(this.f26997a, gen);
                    }
                }, 1500L);
                return;
            }
            View view = this.mDecorView;
            if (view == null) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jA = c0.INSTANCE.a();
            if (!probed) {
                long j10 = this.lastDrawUptimeMs;
                if (jA <= j10 || jUptimeMillis - jA < 3000) {
                    this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.H
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainScrollOverlayComponent.m2(this.f27001a, gen);
                        }
                    }, 1500L);
                    return;
                }
                Log.w(TAG, "frame stall suspected, invalidate probe: " + ("sinceInput=" + (jUptimeMillis - jA) + "ms sinceDraw=" + (jUptimeMillis - j10) + "ms page=" + this.mCurrentPage));
                this.stallProbeActive = true;
                v2("frame-stall-suspected");
                L1(view);
                view.invalidate();
                view.requestLayout();
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.I
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.n2(this.f27003a, gen);
                    }
                }, 500L);
                return;
            }
            this.stallProbeActive = false;
            boolean z10 = this.frameCommittedSinceProbe;
            U1(view);
            if (z10) {
                if (this.overlayUndrawn) {
                    f3("frame-stall-recovered");
                    if (this.alreadyInOpen && this.mOverlayResumed && !this.isRelaunching) {
                        s3();
                    }
                }
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.G
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainScrollOverlayComponent.l2(this.f26999a, gen);
                    }
                }, 1500L);
                return;
            }
            String str = "sinceInput=" + (jUptimeMillis - jA) + "ms sinceDraw=" + (jUptimeMillis - this.lastDrawUptimeMs) + "ms page=" + this.mCurrentPage + " drew=" + this.drewSinceOpen;
            if (this.drewSinceOpen) {
                Log.e(TAG, "frame stall confirmed after probe, relaunch to recover: " + str);
                d3();
                return;
            }
            Log.e(TAG, "frame stall confirmed while undrawn, close overlay: " + str);
            h0("frame-stall");
        }
    }

    public final void j3() throws RemoteException {
        Object objB;
        ILauncherOverlayCallback iLauncherOverlayCallback = this.lastLiveLauncherCallback;
        if (iLauncherOverlayCallback == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(iLauncherOverlayCallback.asBinder().isBinderAlive()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            this.lastLiveLauncherCallback = null;
        } else {
            Log.i(TAG, "re-deliver launcher callback after rebuild");
            super.setCallback(iLauncherOverlayCallback);
        }
    }

    public final void k3(String reason) {
        if (this.isDestroyed) {
            return;
        }
        if (com.stepos.ailauncher.common.utils.J.INSTANCE.f(this.context)) {
            Log.i(TAG, "restore overlay input skip screenOff reason=" + reason);
            return;
        }
        if (this.mOverlayResumed) {
            l3(reason, D2());
            if (D2()) {
                s3();
                return;
            }
            return;
        }
        Log.i(TAG, "restore overlay input defer (not resumed) reason=" + reason);
    }

    public final void l3(String reason, boolean requestFocus) {
        Object objB;
        Object objB2;
        Y8.t tVar;
        if (this.isDestroyed) {
            return;
        }
        boolean z10 = this.overlayDrawSuppressed;
        this.overlayDrawSuppressed = false;
        boolean zG2 = G2();
        if (zG2 && !this.overlayUndrawn) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Window window = this.mWindow;
                if (window != null) {
                    window.clearFlags(16);
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                objB2 = Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                Log.w(TAG, "restore clear FLAG_NOT_TOUCHABLE failed: " + thE.getMessage());
            }
        } else if (zG2 && this.overlayUndrawn) {
            Log.i(TAG, "restore keep NOT_TOUCHABLE reason=" + reason + " undrawn");
        }
        if (requestFocus && !this.overlayUndrawn && D2() && E2()) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                setFocusable(true);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB);
            if (thE2 != null) {
                Log.w(TAG, "restore setFocusable(true) failed: " + thE2.getMessage());
            }
        }
        if (z10 || zG2) {
            Log.i(TAG, "restore overlay input reason=" + reason + " wasSuppressed=" + z10 + " clearedNotTouchable=" + zG2 + " panelOpen=" + this.alreadyInOpen + " aarOpen=" + isPanelOpen());
            m3(reason);
        }
    }

    public final void m3(String reason) {
        if (this.allTasksEntryResumeHold) {
            this.mMainHandler.removeCallbacks(this.allTasksEntryHoldReleaseRunnable);
            if (this.allTasksEntryHoldSettled) {
                this.mMainHandler.postDelayed(this.allTasksEntryHoldReleaseRunnable, 100L);
            } else {
                this.mMainHandler.postDelayed(this.allTasksEntryHoldReleaseRunnable, 1500L);
            }
            Log.i(TAG, "allTasksEntry resume hold scheduled reason=" + reason + " settled=" + this.allTasksEntryHoldSettled);
        }
    }

    public final void n3() {
        this.lifecycleResumeGeneration++;
        this.mMainHandler.removeCallbacks(this.deferredOpenPanelResumeRunnable);
        this.mMainHandler.postDelayed(this.deferredOpenPanelResumeRunnable, 400L);
        Log.d(TAG, "schedule debounced open-panel resume gen=" + this.lifecycleResumeGeneration);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void navigateToDefaultPage() {
        Log.d(TAG, "navigateToDefaultPage");
        KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
        ViewPager2 viewPager2 = null;
        IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
        if (iOverlayPageView != null) {
            iOverlayPageView.onNavigateHome();
        }
        if (this.mCurrentPage != this.initialPage) {
            ViewPager2 viewPager22 = this.mViewPager;
            if (viewPager22 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.m(this.initialPage, true);
        }
        com.stepos.ailauncher.container.dialog.f.m();
        super.navigateToDefaultPage();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
    public void navigateToPage(String pageId) {
        List<IOverlayPageProvider> pages;
        kotlin.jvm.internal.p.i(pageId, "pageId");
        IOverlayPageRegistry iOverlayPageRegistry = (IOverlayPageRegistry) D5.a.INSTANCE.a(IOverlayPageRegistry.class);
        if (iOverlayPageRegistry == null || (pages = iOverlayPageRegistry.getPages()) == null) {
            return;
        }
        Iterator<IOverlayPageProvider> it = pages.iterator();
        final int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (kotlin.jvm.internal.p.d(it.next().getPageId(), pageId)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.e
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.K2(this.f27041a, i10);
            }
        });
    }

    /* renamed from: o2, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void o3() {
        if (this.mRootView == null) {
            G1();
        } else {
            if (this.wallpaperChangedResyncPosted) {
                return;
            }
            this.wallpaperChangedResyncPosted = true;
            q2().postDelayed(this.wallpaperChangedResyncRunnable, 500L);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.DialogOverlayContextWrapper
    public void onBackPressed() {
        KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
        IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
        boolean z10 = false;
        if (iOverlayPageView != null && iOverlayPageView.onBackPressed()) {
            z10 = true;
        }
        Log.i(TAG, "onBackPressed handled=" + z10 + " closeOnUnhandled=false");
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onCreate(Bundle bundle) {
        Log.i(TAG, "onCreate");
        this.isDestroyed = false;
        this.alreadyInOpen = false;
        this.recentsInputGate.g();
        this.panelOpenedByLauncher = false;
        this.openVeto.h();
        this.overlayUndrawn = false;
        this.drewSinceOpen = false;
        this.stallProbeActive = false;
        this.selfOpenRequest = false;
        kotlin.jvm.internal.p.i(bundle, "bundle");
        if (this.originalBaseContext == null) {
            this.originalBaseContext = getBaseContext();
        }
        P3();
        C1();
        super.onCreate(bundle);
        TRACKER.b(this);
        int iA = n0.INSTANCE.a(this);
        this.appliedThemeResId = iA;
        setContentView(iA, R$layout.layout_container);
        x2();
        w2();
        a3();
        com.stepos.ailauncher.common.memory.e.INSTANCE.c(this.heapPageTrimListener);
        m0 m0Var = m0.INSTANCE;
        m0Var.m(new InterfaceC5063a() { // from class: com.stepos.ailauncher.container.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MainScrollOverlayComponent.L2(this.f27054a);
            }
        });
        m0Var.n(new InterfaceC5063a() { // from class: com.stepos.ailauncher.container.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MainScrollOverlayComponent.N2(this.f27055a);
            }
        });
        m0Var.l(new InterfaceC5063a() { // from class: com.stepos.ailauncher.container.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MainScrollOverlayComponent.P2(this.f27056a);
            }
        });
        if (bundle.containsKey("state_before_relaunch") && bundle.getBoolean("state_before_relaunch")) {
            this.mMainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.container.k
                @Override // java.lang.Runnable
                public final void run() {
                    MainScrollOverlayComponent.Q2(this.f27057a);
                }
            });
        }
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d, com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onDestroy() {
        IOverlayPageRegistry iOverlayPageRegistry;
        if (this.isDestroyed) {
            Log.w(TAG, "onDestroy called multiple times, ignoring");
            return;
        }
        this.isDestroyed = true;
        if (this.mRootView != null) {
            View viewQ2 = q2();
            OverlayRootLayout overlayRootLayout = viewQ2 instanceof OverlayRootLayout ? (OverlayRootLayout) viewQ2 : null;
            if (overlayRootLayout != null) {
                overlayRootLayout.setDrawSuppressed(true);
            }
        }
        com.stepos.ailauncher.common.memory.e.INSTANCE.o(this.heapPageTrimListener);
        M3();
        Q1();
        m0 m0Var = m0.INSTANCE;
        m0Var.m(null);
        m0Var.n(null);
        m0Var.l(null);
        N1();
        P1();
        U3();
        S1();
        if (!this.isRelaunching) {
            m0.p(m0Var, false, false, 2, null);
            m0Var.t(false);
        }
        OverlayPageDestroyReason overlayPageDestroyReason = this.isRelaunching ? OverlayPageDestroyReason.RELAUNCH : OverlayPageDestroyReason.DESTROY;
        h0 h0Var = this.mOverlayAdapter;
        if (h0Var != null) {
            h0Var.c(overlayPageDestroyReason);
        } else {
            KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
            IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPageStop();
                iOverlayPageView.onPageDestroy(overlayPageDestroyReason);
            }
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.mPagesChangedListener;
        if (interfaceC5063a != null && (iOverlayPageRegistry = (IOverlayPageRegistry) D5.a.INSTANCE.a(IOverlayPageRegistry.class)) != null) {
            iOverlayPageRegistry.removeOnPagesChangedListener(interfaceC5063a);
        }
        this.mPagesChangedListener = null;
        super.onDestroy();
        TRACKER.c(this);
        Log.i(TAG, "ScrollOverlayComponent onDestroy completed");
        if (!this.isRelaunching) {
            View viewQ22 = q2();
            ViewGroup viewGroup = viewQ22 instanceof ViewGroup ? (ViewGroup) viewQ22 : null;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            View viewP2 = p2();
            ViewGroup viewGroup2 = viewP2 instanceof ViewGroup ? (ViewGroup) viewP2 : null;
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            this.lastLiveLauncherCallback = null;
        }
        Z1();
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void onEndScroll() {
        this.fingerDragging = false;
        boolean zJ = this.openVeto.j();
        this.openVeto.e();
        if (zJ && !this.openVeto.j()) {
            Log.i(TAG, "clear finger-drag veto reason=endScroll-closed progress=" + this.openVeto.getLastProgress());
        }
        super.onEndScroll();
        K3();
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onPause() {
        Object objB;
        m0.INSTANCE.q(false);
        N1();
        R1();
        this.mOverlayResumed = false;
        P1();
        if (!this.alreadyInOpen) {
            try {
                Result.Companion companion = Result.INSTANCE;
                setFocusable(false);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "onPause setFocusable(false) failed: " + thE.getMessage());
            }
        }
        if (this.alreadyInOpen) {
            KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
            IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPagePause();
            }
        }
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void onRemoteTransitionEnd(RemoteTransitionParams params) throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            super.onRemoteTransitionEnd(params);
        } else {
            Log.i(TAG, "onRemoteTransitionEnd skipped: privacy not granted");
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void onRemoteTransitionStart(RemoteTransitionParams params) throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            super.onRemoteTransitionStart(params);
        } else {
            Log.i(TAG, "onRemoteTransitionStart skipped: privacy not granted");
        }
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d, com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onResume() {
        super.onResume();
        Q3();
        boolean zD2 = D2();
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        if (aVar.G(zD2)) {
            F1();
            c2(aVar.l(zD2, m0.INSTANCE.e().getValue().floatValue()), com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
        } else {
            V2(0.0f, com.stepos.ailauncher.container.wallpaper.a.PHASE_END);
            g3();
        }
        this.mOverlayResumed = true;
        m0.INSTANCE.q(true);
        this.recentsInputGate.d();
        l3("onResume", false);
        D5.a.INSTANCE.b(IOverlayPageHost.class, this);
        Log.i(TAG, "onResume");
        if (this.pendingRelaunch) {
            this.pendingRelaunch = false;
            if (J2()) {
                return;
            }
        }
        if (this.pendingFontScaleRelaunch) {
            this.pendingFontScaleRelaunch = false;
            d3();
            return;
        }
        if (this.pendingLocaleRelaunch) {
            this.pendingLocaleRelaunch = false;
            d3();
            return;
        }
        if (this.pendingDisplaySizeRelaunch) {
            this.pendingDisplaySizeRelaunch = false;
            if (D2()) {
                this.displaySizeRelaunchRetries = 0;
                q3();
            }
        }
        if (zD2) {
            n3();
        } else {
            Log.i(TAG, "panel not open yet");
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void onScroll(float progress) {
        super.onScroll(progress);
        this.lastOnScrollElapsed = SystemClock.elapsedRealtime();
        boolean zJ = this.openVeto.j();
        this.openVeto.g(progress, this.fingerDragging);
        if (zJ && !this.openVeto.j()) {
            Log.i(TAG, "clear finger-drag veto reason=onScroll-closed progress=" + progress);
        }
        U2(progress, com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void onStartScroll() {
        if (J3()) {
            Log.i(TAG, "onStartScroll ignored (content not shown, no veto)");
            this.fingerDragging = false;
            v2("startScroll-undrawn");
            return;
        }
        this.openVeto.d();
        this.panelOpenedByLauncher = false;
        this.wallpaperOpenFollowArmed = false;
        this.fingerDragging = true;
        this.pendingAiDesktopEndOpen = null;
        this.pendingEndRestTicks = 0;
        this.closeWallpaperEndLatched = false;
        F1();
        super.onStartScroll();
        K3();
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d, com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onStop() {
        R1();
        O3("onStop");
        if (this.alreadyInOpen) {
            KeyEvent.Callback callbackR2 = r2(this.mCurrentPage);
            IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onPageStop();
            }
        }
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void openOverlay(int flags) {
        boolean z10 = (flags & 1) != 0 && (flags & 2) == 0;
        com.stepos.ailauncher.container.wallpaper.a aVar = com.stepos.ailauncher.container.wallpaper.a.INSTANCE;
        if (aVar.r(z10, B2(), this.deferredBootOpenGaveUp)) {
            if (this.deferredBootOpenFlags != null) {
                this.deferredBootOpenFlags = Integer.valueOf(flags);
                return;
            }
            this.deferredBootOpenFlags = Integer.valueOf(flags);
            c3();
            F1();
            if (this.mRootView != null) {
                q2().removeCallbacks(this.deferredBootOpenTimeoutRunnable);
                q2().postDelayed(this.deferredBootOpenTimeoutRunnable, 15000L);
            }
            Log.i(TAG, "defer openOverlay until AiDesktop bound flags=" + flags);
            return;
        }
        if (this.selfOpenRequest) {
            this.selfOpenRequest = false;
        } else if (!this.openVeto.j() && z10) {
            this.panelOpenedByLauncher = true;
        }
        Log.i(TAG, "openOverlay flags=" + flags + " animated=" + z10 + " byLauncher=" + this.panelOpenedByLauncher + " dragSeen=" + this.openVeto.getDragSeen() + " settledClosed=" + this.openVeto.getSettledClosed());
        SlidingPanelLayout slidingPanelLayout = getSlidingPanelLayout();
        boolean zS = aVar.s(z10, slidingPanelLayout != null ? slidingPanelLayout.mPanelPositionRatio : m0.INSTANCE.e().getValue().floatValue());
        if (zS) {
            F1();
        }
        this.lastPanelTransitionUptimeMs = SystemClock.uptimeMillis();
        super.openOverlay(flags);
        if (!zS) {
            K3();
        } else {
            this.wallpaperOpenFollowArmed = true;
            K1(true);
        }
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d
    public void p() {
        Log.d(TAG, "onDisplaySizeChanged resumed=" + this.mOverlayResumed + " open=" + D2());
        this.pendingDisplaySizeRelaunch = false;
        this.displaySizeRelaunchRetries = 0;
        q3();
    }

    public final View p2() {
        View view = this.mContentView;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.p.A("mContentView");
        return null;
    }

    public final void p3(int toPosition) {
        if (this.mOverlayResumed && isPanelOpen()) {
            if (toPosition == this.mCurrentPage) {
                R1();
                return;
            }
            this.pendingPageSwitchTo = Integer.valueOf(toPosition);
            ViewPager2 viewPager2 = this.mViewPager;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
                viewPager2 = null;
            }
            if (viewPager2.getScrollState() == 0) {
                E1();
                return;
            }
            int i10 = this.mCurrentPage;
            ViewPager2 viewPager23 = this.mViewPager;
            if (viewPager23 == null) {
                kotlin.jvm.internal.p.A("mViewPager");
            } else {
                viewPager22 = viewPager23;
            }
            Log.d(TAG, "pageSwitch deferred to=" + toPosition + " from=" + i10 + " scrollState=" + viewPager22.getScrollState());
        }
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d
    public void q() {
        Log.d(TAG, "onLandscapeConfigurationIgnored, pending display size relaunch");
        this.pendingDisplaySizeRelaunch = true;
    }

    public final View q2() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.p.A("mRootView");
        return null;
    }

    public final void q3() {
        this.mMainHandler.removeCallbacks(this.displaySizeRelaunchRunnable);
        this.mMainHandler.postDelayed(this.displaySizeRelaunchRunnable, 300L);
    }

    @Override // com.stepos.ailauncher.container.ComponentCallbacks2C3211d
    public void r(int level) {
        int iG2;
        if (!this.isDestroyed && (iG2 = g2(level)) >= 20) {
            T3(iG2);
        }
    }

    public final View r2(int position) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager2 = null;
        }
        View childAt = viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView == null || (viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position)) == null) {
            return null;
        }
        return viewHolderFindViewHolderForAdapterPosition.itemView;
    }

    public final void r3() {
        this.mMainHandler.removeCallbacks(this.fontScaleRelaunchRunnable);
        this.mMainHandler.postDelayed(this.fontScaleRelaunchRunnable, 300L);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
    public void requestOpenOverlay(boolean animate) {
        this.selfOpenRequest = true;
        Log.i(TAG, "requestOpenOverlay animate=" + animate + " flags=" + (animate ? 1 : 0));
        openOverlay(animate ? 1 : 0);
    }

    public final void s3() {
        final View view = this.mDecorView;
        if (view == null) {
            return;
        }
        boolean z10 = this.alreadyInOpen;
        if (!z10 || !this.mOverlayResumed || this.isRelaunching) {
            Log.d(TAG, "scheduleInputSurfaceSync skip open=" + z10 + " resumed=" + this.mOverlayResumed + " relaunch=" + this.isRelaunching);
            return;
        }
        if (this.overlayDrawSuppressed || com.stepos.ailauncher.common.utils.J.INSTANCE.f(this.context)) {
            Log.d(TAG, "scheduleInputSurfaceSync skip suppressed=" + this.overlayDrawSuppressed + " screenOff");
            return;
        }
        if (this.overlayUndrawn) {
            Log.d(TAG, "scheduleInputSurfaceSync skip undrawn");
            return;
        }
        final int i10 = this.inputSurfaceSyncGeneration + 1;
        this.inputSurfaceSyncGeneration = i10;
        if (E2()) {
            H1();
        }
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.l
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.y3(i10, this, view);
            }
        }, 2000L);
        view.post(new Runnable() { // from class: com.stepos.ailauncher.container.m
            @Override // java.lang.Runnable
            public final void run() {
                MainScrollOverlayComponent.z3(i10, this, view);
            }
        });
    }

    @Override // com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent
    public void setCallback(ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
        if (iLauncherOverlayCallback != null) {
            this.lastLiveLauncherCallback = iLauncherOverlayCallback;
        }
        super.setCallback(iLauncherOverlayCallback);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
    public void setContentOwnsHorizontalGesture(boolean owns) {
        if (this.contentOwnsHorizontalGesture == owns) {
            return;
        }
        this.contentOwnsHorizontalGesture = owns;
        Log.i(TAG, "setContentOwnsHorizontalGesture=" + owns);
        ViewPagerTouchWrapper viewPagerTouchWrapper = this.mPagerTouchWrapper;
        if (viewPagerTouchWrapper != null) {
            viewPagerTouchWrapper.setContentOwnsHorizontalGesture(owns);
        }
        D1();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
    public void setEdgeBackGestureEnabled(boolean enabled) {
        if (this.edgeBackGestureEnabled == enabled) {
            return;
        }
        this.edgeBackGestureEnabled = enabled;
        Log.i(TAG, "setEdgeBackGestureEnabled=" + enabled);
        A1();
    }

    public final void t2() {
        WindowInsetsController windowInsetsController;
        if (this.mRootView == null) {
            return;
        }
        WindowInsets rootWindowInsets = q2().getRootWindowInsets();
        boolean z10 = false;
        if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsets.Type.ime())) {
            z10 = true;
        }
        if ((z10 || this.imeInsetsAnimating) && (windowInsetsController = q2().getWindowInsetsController()) != null) {
            Log.i(TAG, "hideImeInstantlyForPanelDrag visible=" + z10 + " animating=" + this.imeInsetsAnimating);
            windowInsetsController.controlWindowInsetsAnimation(WindowInsets.Type.ime(), 0L, null, null, new b());
        }
    }

    public final void u2() {
        if (this.mRootView == null) {
            return;
        }
        View viewFindFocus = q2().findFocus();
        if (viewFindFocus == null) {
            viewFindFocus = q2();
        }
        androidx.core.view.b0 b0VarG = androidx.core.view.N.G(viewFindFocus);
        if (b0VarG != null) {
            b0VarG.a(a0.o.b());
        }
        Object systemService = this.context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        IBinder windowToken = viewFindFocus.getWindowToken();
        if (windowToken == null && (windowToken = q2().getWindowToken()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }

    public final void v1() {
        com.stepos.ailauncher.container.wallpaper.e.b().e();
        com.stepos.ailauncher.container.wallpaper.e.b().f(new com.stepos.ailauncher.container.wallpaper.d() { // from class: com.stepos.ailauncher.container.t
            @Override // com.stepos.ailauncher.container.wallpaper.d
            public final void a(int i10) {
                MainScrollOverlayComponent.w1(this.f27071a, i10);
            }
        });
    }

    public final void v2(String reason) {
        Object objB;
        Object objB2;
        Y8.t tVar;
        if (this.isDestroyed) {
            return;
        }
        this.overlayUndrawn = true;
        O1();
        try {
            Result.Companion companion = Result.INSTANCE;
            setFocusable(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "hold setFocusable(false) failed: " + thE.getMessage());
        }
        try {
            Window window = this.mWindow;
            if (window != null) {
                window.addFlags(16);
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB2 = Result.b(tVar);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.w(TAG, "hold FLAG_NOT_TOUCHABLE failed: " + thE2.getMessage());
        }
        Log.i(TAG, "hold overlay input reason=" + reason);
    }

    public final void w2() {
        com.stepos.ailauncher.container.dialog.f.p(this.mDecorView);
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 == null) {
            kotlin.jvm.internal.p.A("mViewPager");
            viewPager2 = null;
        }
        viewPager2.j(new c());
        d dVar = new d();
        this.dragListener = dVar;
        addSlidingPanelDragListener(dVar);
    }

    public final void z1() {
        h0 h0Var;
        if (this.mViewPager == null || (h0Var = this.mOverlayAdapter) == null) {
            return;
        }
        int itemCount = h0Var.getItemCount();
        for (int i10 = 0; i10 < itemCount; i10++) {
            KeyEvent.Callback callbackR2 = r2(i10);
            IOverlayPageView iOverlayPageView = callbackR2 instanceof IOverlayPageView ? (IOverlayPageView) callbackR2 : null;
            if (iOverlayPageView != null) {
                iOverlayPageView.onAllTasksEntryVisibilityChanged(f2());
            }
        }
    }
}
