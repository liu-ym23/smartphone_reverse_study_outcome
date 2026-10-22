package com.stepos.ailauncher.task.detail;

import A1.g;
import P6.DocumentPreviewResponse;
import P6.DownloadUrlResponse;
import Ua.C1060i;
import Z8.C1165m;
import Z8.C1172u;
import Z8.C1173v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.Formatter;
import android.util.TypedValue;
import android.view.C1398p;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.Z;
import androidx.core.view.a0;
import com.airbnb.lottie.LottieAnimationView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatcore.Configuration;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.SessionHandler.d;
import com.stepos.agentframework.chatcore.SessionHandler.f;
import com.stepos.agentframework.chatcore.SessionHandler.g;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.manager.C2700i;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C3026z;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.view.E7;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.Z3;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.container.R$attr;
import com.stepos.ailauncher.contract.model.ArtifactDetailIntent;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.task.R$color;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.chat.TaskInputView;
import com.stepos.common.utils.filestorage.FileStorageManager;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import f5.C4058a;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import l9.C4877a;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;
import u6.C5578a;
import v9.C5685n;
import w4.ChatMessage;
import y4.InterfaceC5940b;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u009d\u00022\u00020\u0001:\u0007\u009e\u0002\u009f\u0002 \u0002SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0019\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010\u0018J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J!\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0011H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010<\u001a\u00020\u0011H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0003J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0003J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020@H\u0002¢\u0006\u0004\bE\u0010CJ\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\u0003J\u0017\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0011H\u0002¢\u0006\u0004\bL\u00102J\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u0010\u0003J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010\u0003J\u0017\u0010Q\u001a\u00020\u00062\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020O2\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u0004\u0018\u00010O2\u0006\u0010X\u001a\u00020\u0015H\u0002¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u0004\u0018\u00010O2\u0006\u0010[\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\\\u0010ZJ\u001f\u0010_\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020]H\u0002¢\u0006\u0004\b_\u0010`J9\u0010e\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\u00112\u0006\u0010^\u001a\u00020]2\u0010\b\u0002\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010cH\u0002¢\u0006\u0004\be\u0010fJ\u0019\u0010h\u001a\u00020\u00062\b\b\u0001\u0010g\u001a\u00020@H\u0002¢\u0006\u0004\bh\u0010CJ'\u0010j\u001a\u00020\u00062\u0006\u0010^\u001a\u00020]2\u0006\u0010b\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0015H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0004\bl\u0010UJ\u0017\u0010m\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u0015H\u0002¢\u0006\u0004\bm\u0010\u0018J\u000f\u0010n\u001a\u00020\u0006H\u0002¢\u0006\u0004\bn\u0010\u0003J\u000f\u0010o\u001a\u00020\u0006H\u0002¢\u0006\u0004\bo\u0010\u0003J\u0019\u0010p\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\bp\u0010\"J\u0017\u0010q\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0011H\u0002¢\u0006\u0004\bq\u00102J\u0017\u0010r\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0011H\u0002¢\u0006\u0004\br\u00102J\u000f\u0010s\u001a\u00020\u0006H\u0002¢\u0006\u0004\bs\u0010\u0003J1\u0010x\u001a\u00020\u00062\u0006\u0010u\u001a\u00020t2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010v\u001a\u00020\u00152\b\b\u0002\u0010w\u001a\u00020\u0011H\u0002¢\u0006\u0004\bx\u0010yJG\u0010}\u001a\u00020\u00062\u0006\u0010u\u001a\u00020t2\u0006\u0010{\u001a\u00020z2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010c2\b\b\u0002\u0010w\u001a\u00020\u0011H\u0002¢\u0006\u0004\b}\u0010~J\u001a\u0010\u007f\u001a\u0004\u0018\u00010\u00152\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u001c\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00152\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0080\u0001J\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0084\u0001J\u0019\u0010\u0087\u0001\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u0087\u0001\u0010UJ\u001a\u0010\u0088\u0001\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0080\u0001J!\u0010\u008a\u0001\u001a\u00020\u00062\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060cH\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0011\u0010\u008c\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0003J\u0017\u0010\u008e\u0001\u001a\u00020\u0011*\u00030\u008d\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\u00062\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0094\u0001\u0010\u0003J\"\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u001a2\u0007\u0010\u0095\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001a\u0010\u0099\u0001\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001a\u0010\u009b\u0001\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u0080\u0001J\u001c\u0010\u009d\u0001\u001a\u00020\u00062\b\u0010\u009c\u0001\u001a\u00030\u0096\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001a\u0010\u009f\u0001\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0018J\u001a\u0010 \u0001\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u001bH\u0002¢\u0006\u0006\b \u0001\u0010\u009a\u0001J\u001c\u0010¡\u0001\u001a\u00020\u00062\b\u0010\u009c\u0001\u001a\u00030\u0096\u0001H\u0002¢\u0006\u0006\b¡\u0001\u0010\u009e\u0001J%\u0010¥\u0001\u001a\u00020\u00062\b\u0010£\u0001\u001a\u00030¢\u00012\u0007\u0010¤\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001c\u0010§\u0001\u001a\u00020\u00152\b\u0010\u009c\u0001\u001a\u00030\u0096\u0001H\u0002¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001b\u0010©\u0001\u001a\u00020\u00152\u0007\u0010\u0085\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0006\b©\u0001\u0010\u0084\u0001JE\u0010\u00ad\u0001\u001a\u00020\u00062\b\u0010\u009c\u0001\u001a\u00030\u0096\u00012\b\u0010ª\u0001\u001a\u00030¢\u00012\u001d\b\u0002\u0010¬\u0001\u001a\u0016\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060«\u0001H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001JC\u0010¯\u0001\u001a\u00020\u00112\b\u0010\u009c\u0001\u001a\u00030\u0096\u00012\b\u0010ª\u0001\u001a\u00030¢\u00012\u001b\u0010¬\u0001\u001a\u0016\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060«\u0001H\u0002¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0011\u0010±\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b±\u0001\u0010\u0003JR\u0010´\u0001\u001a\u00020\u00062\b\u0010ª\u0001\u001a\u00030¢\u00012\u001d\b\u0002\u0010¬\u0001\u001a\u0016\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060«\u00012\u0015\u0010³\u0001\u001a\u0010\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020\u00060²\u0001H\u0002¢\u0006\u0006\b´\u0001\u0010µ\u0001J$\u0010¶\u0001\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00152\b\u0010ª\u0001\u001a\u00030¢\u0001H\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u001a\u0010¹\u0001\u001a\u00020\u00062\u0007\u0010¸\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b¹\u0001\u00102J\u0011\u0010º\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bº\u0001\u0010\u0003J\u0011\u0010»\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b»\u0001\u0010\u0003R\u001a\u0010½\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001f\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0019\u0010Á\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Å\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Ä\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0019\u0010È\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010Ç\u0001R\u001a\u0010Ê\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ç\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Ç\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001c\u0010Ñ\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ð\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ð\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ð\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ð\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001c\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Û\u0001\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ç\u0001R\u001b\u0010Þ\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010Ä\u0001R\u0019\u0010ß\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Ç\u0001R!\u0010å\u0001\u001a\u00030à\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001R\u001b\u0010æ\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001c\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001c\u0010ì\u0001\u001a\u0005\u0018\u00010ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001b\u0010î\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010Ä\u0001R\u0019\u0010ï\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010Ç\u0001R\u001c\u0010ñ\u0001\u001a\u0005\u0018\u00010ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u001c\u0010ó\u0001\u001a\u0005\u0018\u00010ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ò\u0001R\u0019\u0010ô\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010Ç\u0001R\u0019\u0010õ\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010Ç\u0001R\u0019\u0010ö\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010Â\u0001R\u0019\u0010÷\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010Â\u0001R \u0010û\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bø\u0001\u0010â\u0001\u001a\u0006\bù\u0001\u0010ú\u0001R\u0019\u0010ü\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010Ç\u0001R\u0019\u0010ý\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010Ç\u0001R\u001c\u0010þ\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R$\u0010\u0081\u0002\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060c0\u0080\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R!\u0010\u0083\u0002\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001c\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u001c\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0087\u0002R\u0019\u0010\u0089\u0002\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010Ä\u0001R\u001e\u0010\u008b\u0002\u001a\t\u0012\u0004\u0012\u00020\u00150\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001a\u0010\u008e\u0002\u001a\u00030\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001a\u0010\u0090\u0002\u001a\u00030\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u008f\u0002R\u0019\u0010\u0091\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010Ç\u0001R\u001c\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0019\u0010\u0095\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R\u0019\u0010\u0097\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0002\u0010Ç\u0001R\u0019\u0010\u0098\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010Ç\u0001R\u0019\u0010\u0099\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010Ç\u0001R\u0019\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002¨\u0006¡\u0002"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskDetailActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDestroy", "", "seedFileId", "Y2", "(Ljava/lang/String;)V", "fileId", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "I2", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K2", "Landroid/view/View;", "view", "d2", "(Landroid/view/View;)V", "z3", "o1", "m3", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "y1", "O3", "b2", "r1", "f2", "target", "animate", "d3", "(ZZ)V", "expandedNow", "I3", "(Z)V", "v3", "g1", "i2", "k1", "g3", "Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$ChipState;", "X2", "()Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$ChipState;", "J2", "A3", "()Z", "Z0", "i1", "", "delta", "E2", "(I)V", "index", "F3", "K3", "Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$HtmlView;", "mode", "b1", "(Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$HtmlView;)V", "enable", "d1", "D3", "e2", "Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$RenderKind;", "active", "L2", "(Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$RenderKind;)V", Const.INTENT_KEY_APIKEY, "V2", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "U2", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$RenderKind;", "mime", "y2", "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$RenderKind;", "ext", "N1", "Lcom/stepos/ailauncher/task/detail/TaskWebView;", AppUI.TYPE_WEB, "R1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Lcom/stepos/ailauncher/task/detail/TaskWebView;)V", "url", "asHtml", "Lkotlin/Function0;", "onFailRetry", "U1", "(Ljava/lang/String;ZLcom/stepos/ailauncher/task/detail/TaskWebView;Lp9/a;)V", "msgRes", "B3", "text", "N2", "(Lcom/stepos/ailauncher/task/detail/TaskWebView;ZLjava/lang/String;)V", "O2", "R2", "Q1", "v1", "C3", "f1", "e1", SdCardDbCreator.FIELD_LASTLOC_ID, "Landroid/widget/ImageView;", "image", "rawContent", "preferRgb565", "s2", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Z)V", "", "data", "cacheKey", "v2", "(Landroid/widget/ImageView;Ljava/lang/Object;Ljava/lang/String;Lp9/a;Z)V", "O1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "D2", "mimeType", "P1", "(Ljava/lang/String;)Ljava/lang/String;", "fileName", "x1", "W2", "s1", "block", "R3", "(Lp9/a;)V", "x3", "Landroidx/core/view/Z;", "c2", "(Landroidx/core/view/Z;)Z", "Landroidx/core/view/a0;", "insets", "c1", "(Landroidx/core/view/a0;)V", "G2", "current", "Lcom/stepos/ailauncher/task/detail/x;", "t1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/util/List;", "q2", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Z", "X1", "option", "H3", "(Lcom/stepos/ailauncher/task/detail/x;)V", "r2", "p2", SdCardDbCreator.FIELD_LASTLOC_TIME, "Landroid/net/Uri;", "uri", "success", "W1", "(Landroid/net/Uri;Z)V", "u1", "(Lcom/stepos/ailauncher/task/detail/x;)Ljava/lang/String;", "x2", "destUri", "Lkotlin/Function2;", "onDone", "E1", "(Lcom/stepos/ailauncher/task/detail/x;Landroid/net/Uri;Lp9/p;)V", "A1", "(Lcom/stepos/ailauncher/task/detail/x;Landroid/net/Uri;Lp9/p;)Z", "F2", "Lkotlin/Function1;", "write", "Z2", "(Landroid/net/Uri;Lp9/p;Lp9/l;)V", "C1", "(Ljava/lang/String;Landroid/net/Uri;)V", "downloading", "N3", "w1", "M2", "Lr6/b;", "binding", "Lr6/b;", "versions", "Ljava/util/List;", "currentIndex", "I", "taskId", "Ljava/lang/String;", "sessionId", "chatEnabled", "Z", "restoreWakeChat", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "expanded", "chatBlurAttached", "Ly7/E;", "sheetMaterialHandle", "Ly7/E;", "backGlassHandle", "versionGlassHandle", "actionGlassHandle", "chipGlassHandle", "Lcom/stepos/ailauncher/chat/view/E7$a;", "scrollBtnFloatHandle", "Lcom/stepos/ailauncher/chat/view/E7$a;", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "chatSpectrumController", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "htmlView", "Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$HtmlView;", "codeLoaded", "currentHtmlSource", "immersive", "Lcom/stepos/ailauncher/task/detail/r;", "moreMenu$delegate", "LY8/h;", SdCardDbCreator.FIELD_LASTLOC_INFO, "()Lcom/stepos/ailauncher/task/detail/r;", "moreMenu", "resultContentView", "Landroid/view/View;", "Lr6/q;", "resultBinding", "Lr6/q;", "Lkotlinx/coroutines/g;", "renderJob", "Lkotlinx/coroutines/g;", "currentHtmlUrl", "htmlFallbackDone", "Ljava/lang/Runnable;", "htmlFallbackRunnable", "Ljava/lang/Runnable;", "maskHideRunnable", "webviewFullscreen", "markdownEdgeToEdge", "contentTopInsetPx", "contentBottomInsetPx", "edgeColorHex$delegate", "Z1", "()Ljava/lang/String;", "edgeColorHex", "imeAnimating", "lastKeyboardUp", "pendingDownloadOption", "Lcom/stepos/ailauncher/task/detail/x;", "LZ8/m;", "pendingHostActions", "LZ8/m;", "syncContentBottomPadding", "Lp9/a;", "Landroid/view/View$OnLayoutChangeListener;", "bottomContainerLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "topBarLayoutChangeListener", "pendingSaveMime", "Ld/b;", "saveLauncher", "Ld/b;", "", "dragStartY", "F", "panelStartTy", "draggingCollapse", "Landroid/view/VelocityTracker;", "collapseVelocityTracker", "Landroid/view/VelocityTracker;", "chipState", "Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$ChipState;", "chipAwaitingReply", "chipReplying", "chipPendingCard", "Y1", "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "currentArtifact", "Companion", "HtmlView", "ChipState", "RenderKind", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskDetailActivity extends ActivityC6361a {
    private static final float COLLAPSE_THRESHOLD_RATIO = 0.35f;
    private static final int CONTENT_GAP_DP = 4;
    private static final float FLING_VELOCITY_PX_S = 1000.0f;
    private static final long HTML_FIRST_PAINT_TIMEOUT_MS = 4000;
    private static final int MAX_CONTENT_BLUR_RADIUS_DP = 20;
    private static final int PANEL_TOP_RADIUS_DP = 24;
    private static final long RENDER_MASK_TIMEOUT_MS = 4000;
    private static final float SCRIM_ALPHA = 0.34f;
    private static final long SLIDE_DURATION_MS = 280;
    private static final String TAG = "TaskDetailActivity";
    private y7.E actionGlassHandle;
    private y7.E backGlassHandle;
    private r6.b binding;
    private View.OnLayoutChangeListener bottomContainerLayoutChangeListener;
    private boolean chatBlurAttached;
    private boolean chatEnabled;
    private com.stepos.ailauncher.chat.wake.effect.c chatSpectrumController;
    private boolean chipAwaitingReply;
    private y7.E chipGlassHandle;
    private boolean chipPendingCard;
    private boolean chipReplying;
    private boolean codeLoaded;
    private VelocityTracker collapseVelocityTracker;
    private int contentBottomInsetPx;
    private int contentTopInsetPx;
    private String currentHtmlSource;
    private String currentHtmlUrl;
    private int currentIndex;
    private float dragStartY;
    private boolean draggingCollapse;
    private boolean expanded;
    private boolean htmlFallbackDone;
    private Runnable htmlFallbackRunnable;
    private boolean imeAnimating;
    private boolean immersive;
    private boolean lastKeyboardUp;
    private boolean markdownEdgeToEdge;
    private Runnable maskHideRunnable;
    private float panelStartTy;
    private DownloadOption pendingDownloadOption;
    private kotlinx.coroutines.g renderJob;
    private boolean restoreWakeChat;
    private r6.q resultBinding;
    private View resultContentView;
    private E7.a scrollBtnFloatHandle;
    private SessionHandler sessionHandler;
    private y7.E sheetMaterialHandle;
    private InterfaceC5063a<Y8.t> syncContentBottomPadding;
    private View.OnLayoutChangeListener topBarLayoutChangeListener;
    private y7.E versionGlassHandle;
    private boolean webviewFullscreen;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> PREVIEWABLE_DOC_EXTS = Z8.Y.j("pptx", ChatTracker.CONTENT_PPT, ChatTracker.CONTENT_DOC, "docx", "xls", "xlsx", "xlsm", "pdf");
    private static final Set<String> IMAGE_EXTS = Z8.Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp", "svg", "tif", "tiff", "heic", "heif", "avif");
    private static final Set<String> CODE_EXTS = Z8.Y.j("py", "js", "jsx", "mjs", "cjs", "ts", "tsx", "mts", "cts", "java", "kt", "kts", "go", "rs", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "cpp", "cc", "cxx", "hpp", "hxx", "cs", "swift", "rb", "php", "sh", "bash", "zsh", "fish", "sql", "json", "yaml", "yml", "toml", "ini", "cfg", "conf", "css", "scss", "sass", "less", "pl", "pm", "lua", "scala", "dart");
    private static final Set<String> GALLERY_IMAGE_EXTS = Z8.Y.j(C5578a.DST_JPG, "jpeg", "png", "webp", "gif", "bmp", "tif", "tiff", "heic", "heif");
    private static final Y8.h<tb.z> downloadClient$delegate = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.y
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskDetailActivity.z1();
        }
    });
    private List<SessionArtifact> versions = C1173v.m();
    private String taskId = "";
    private String sessionId = "";
    private HtmlView htmlView = HtmlView.PREVIEW;

    /* renamed from: moreMenu$delegate, reason: from kotlin metadata */
    private final Y8.h moreMenu = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.J
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskDetailActivity.z2(this.f28462a);
        }
    });

    /* renamed from: edgeColorHex$delegate, reason: from kotlin metadata */
    private final Y8.h edgeColorHex = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.V
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskDetailActivity.D1(this.f28494a);
        }
    });
    private final C1165m<InterfaceC5063a<Y8.t>> pendingHostActions = new C1165m<>();
    private String pendingSaveMime = "application/octet-stream";
    private final AbstractC3936b<String> saveLauncher = registerForActivityResult(new g(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.task.detail.g0
        @Override // d.InterfaceC3935a
        public final void a(Object obj) throws FileStorageException.NotInitialized {
            TaskDetailActivity.c3(this.f28638a, (Uri) obj);
        }
    });
    private ChipState chipState = ChipState.DONE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$ChipState;", "", "<init>", "(Ljava/lang/String;I)V", "THINKING", "EXECUTING", "TAKEOVER", "DONE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ChipState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ChipState[] $VALUES;
        public static final ChipState THINKING = new ChipState("THINKING", 0);
        public static final ChipState EXECUTING = new ChipState("EXECUTING", 1);
        public static final ChipState TAKEOVER = new ChipState("TAKEOVER", 2);
        public static final ChipState DONE = new ChipState("DONE", 3);

        private static final /* synthetic */ ChipState[] $values() {
            return new ChipState[]{THINKING, EXECUTING, TAKEOVER, DONE};
        }

        static {
            ChipState[] chipStateArr$values = $values();
            $VALUES = chipStateArr$values;
            $ENTRIES = kotlin.enums.a.a(chipStateArr$values);
        }

        private ChipState(String str, int i10) {
        }

        public static InterfaceC4149a<ChipState> getEntries() {
            return $ENTRIES;
        }

        public static ChipState valueOf(String str) {
            return (ChipState) Enum.valueOf(ChipState.class, str);
        }

        public static ChipState[] values() {
            return (ChipState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$HtmlView;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW", "CODE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HtmlView {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ HtmlView[] $VALUES;
        public static final HtmlView PREVIEW = new HtmlView("PREVIEW", 0);
        public static final HtmlView CODE = new HtmlView("CODE", 1);

        private static final /* synthetic */ HtmlView[] $values() {
            return new HtmlView[]{PREVIEW, CODE};
        }

        static {
            HtmlView[] htmlViewArr$values = $values();
            $VALUES = htmlViewArr$values;
            $ENTRIES = kotlin.enums.a.a(htmlViewArr$values);
        }

        private HtmlView(String str, int i10) {
        }

        public static InterfaceC4149a<HtmlView> getEntries() {
            return $ENTRIES;
        }

        public static HtmlView valueOf(String str) {
            return (HtmlView) Enum.valueOf(HtmlView.class, str);
        }

        public static HtmlView[] values() {
            return (HtmlView[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$RenderKind;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "HTML", "IMAGE", "FILE", "CODE", "FALLBACK", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RenderKind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ RenderKind[] $VALUES;
        public static final RenderKind TEXT = new RenderKind("TEXT", 0);
        public static final RenderKind HTML = new RenderKind("HTML", 1);
        public static final RenderKind IMAGE = new RenderKind("IMAGE", 2);
        public static final RenderKind FILE = new RenderKind("FILE", 3);
        public static final RenderKind CODE = new RenderKind("CODE", 4);
        public static final RenderKind FALLBACK = new RenderKind("FALLBACK", 5);

        private static final /* synthetic */ RenderKind[] $values() {
            return new RenderKind[]{TEXT, HTML, IMAGE, FILE, CODE, FALLBACK};
        }

        static {
            RenderKind[] renderKindArr$values = $values();
            $VALUES = renderKindArr$values;
            $ENTRIES = kotlin.enums.a.a(renderKindArr$values);
        }

        private RenderKind(String str, int i10) {
        }

        public static InterfaceC4149a<RenderKind> getEntries() {
            return $ENTRIES;
        }

        public static RenderKind valueOf(String str) {
            return (RenderKind) Enum.valueOf(RenderKind.class, str);
        }

        public static RenderKind[] values() {
            return (RenderKind[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001e¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/task/detail/TaskDetailActivity$a;", "", "<init>", "()V", "Ltb/z;", "downloadClient$delegate", "LY8/h;", Const.INTENT_KEY_PKGNAME, "()Ltb/z;", "downloadClient", "", "TAG", "Ljava/lang/String;", "", "SLIDE_DURATION_MS", "J", "", "COLLAPSE_THRESHOLD_RATIO", "F", "FLING_VELOCITY_PX_S", "", "PANEL_TOP_RADIUS_DP", "I", "SCRIM_ALPHA", "MAX_CONTENT_BLUR_RADIUS_DP", "CONTENT_GAP_DP", "RENDER_MASK_TIMEOUT_MS", "HTML_FIRST_PAINT_TIMEOUT_MS", "", "PREVIEWABLE_DOC_EXTS", "Ljava/util/Set;", "IMAGE_EXTS", "CODE_EXTS", "GALLERY_IMAGE_EXTS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.TaskDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final tb.z b() {
            return (tb.z) TaskDetailActivity.downloadClient$delegate.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ChipState.values().length];
            try {
                iArr[ChipState.THINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChipState.EXECUTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChipState.TAKEOVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChipState.DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RenderKind.values().length];
            try {
                iArr2[RenderKind.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[RenderKind.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[RenderKind.CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[RenderKind.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[RenderKind.FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[RenderKind.FALLBACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$c", "Lcom/stepos/agentframework/chatcore/session/AgentSession$g;", "Lw4/c;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements AgentSession.g {
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public void a(ChatMessage message) {
            kotlin.jvm.internal.p.i(message, "message");
            C4148a.k(TaskDetailActivity.TAG, "onResponse: " + message.getMessageId(), false, 4, null);
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public /* bridge */ void b(boolean z10, Integer num, String str) {
            super.b(z10, num, str);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ViewOutlineProvider {
        public d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            float fA = C4058a.INSTANCE.a(TaskDetailActivity.this, 24);
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + ((int) fA), fA);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$e", "Ly4/b$f;", "", "message", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5940b.f {
        public e() {
        }

        @Override // y4.InterfaceC5940b.f
        public void a(String message, List<FileInfo> images, Map<String, String> params) {
            if (message == null) {
                message = "";
            }
            String str = message;
            C2700i.INSTANCE.a("task_id", TaskDetailActivity.this.taskId);
            TaskDetailActivity taskDetailActivity = TaskDetailActivity.this;
            Map mapC = Z8.Q.c();
            mapC.put(RequestParameter.META_KEY_MSG_SOURCE, "direct");
            SessionArtifact sessionArtifactY1 = taskDetailActivity.Y1();
            if (sessionArtifactY1 != null) {
                String fileId = sessionArtifactY1.getFileId();
                if (fileId != null) {
                    if (La.H.x0(fileId)) {
                        fileId = null;
                    }
                    if (fileId != null) {
                    }
                }
                String cloudPath = sessionArtifactY1.getCloudPath();
                if (cloudPath != null) {
                    if (La.H.x0(cloudPath)) {
                        cloudPath = null;
                    }
                    if (cloudPath != null) {
                        mapC.put(RequestParameter.META_KEY_ACTIVE_FILE_PATH, cloudPath);
                    }
                }
            }
            Map mapB = Z8.Q.b(mapC);
            r6.b bVar = TaskDetailActivity.this.binding;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar = null;
            }
            LauncherChatLayout taskChatLayout = bVar.taskChatLayout;
            kotlin.jvm.internal.p.h(taskChatLayout, "taskChatLayout");
            AgentChatLayout.Q6(taskChatLayout, str, images, mapB, null, 8, null);
            r6.b bVar2 = TaskDetailActivity.this.binding;
            if (bVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar2 = null;
            }
            bVar2.inputViewTask.f(str);
            TaskDetailActivity.e3(TaskDetailActivity.this, true, false, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$f", "LA1/g$b;", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", Const.INTENT_KEY_APIKEY, "LA1/e;", "result", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements g.b {
        final /* synthetic */ InterfaceC5063a $onFailRetry$inlined;
        final /* synthetic */ TaskDetailActivity this$0;

        public f(InterfaceC5063a interfaceC5063a, TaskDetailActivity taskDetailActivity) {
            this.$onFailRetry$inlined = interfaceC5063a;
            this.this$0 = taskDetailActivity;
        }

        @Override // A1.g.b
        public void a(A1.g request) {
        }

        @Override // A1.g.b
        public void b(A1.g request) {
        }

        @Override // A1.g.b
        public void c(A1.g request, A1.o result) {
        }

        @Override // A1.g.b
        public void d(A1.g request, A1.e result) {
            C4148a.t(TaskDetailActivity.TAG, "loadImageWithCoil coil load failed", result.getThrowable(), false, 8, null);
            InterfaceC5063a interfaceC5063a = this.$onFailRetry$inlined;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            } else {
                this.this$0.B3(R$string.task_detail_download_failed);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$g", "Le/b;", "Landroid/content/Context;", "context", "", "input", "Landroid/content/Intent;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends e.b {
        public g() {
            super("*/*");
        }

        @Override // e.AbstractC3969a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, String input) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(input, "input");
            Intent type = super.a(context, input).setType(TaskDetailActivity.this.pendingSaveMime);
            kotlin.jvm.internal.p.h(type, "setType(...)");
            return type;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$h", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends AnimatorListenerAdapter {
        final /* synthetic */ LinearLayout $panel;

        public h(LinearLayout linearLayout) {
            this.$panel = linearLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (TaskDetailActivity.this.expanded) {
                return;
            }
            this.$panel.setVisibility(8);
            this.$panel.setTranslationY(0.0f);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/task/detail/TaskDetailActivity$i", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i extends Z.b {
        final /* synthetic */ LinearLayout $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LinearLayout linearLayout) {
            super(1);
            this.$container = linearLayout;
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (TaskDetailActivity.this.c2(animation)) {
                TaskDetailActivity.this.imeAnimating = false;
                androidx.core.view.a0 a0VarB = androidx.core.view.N.B(this.$container);
                if (a0VarB != null) {
                    TaskDetailActivity.this.c1(a0VarB);
                }
            }
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (TaskDetailActivity.this.c2(animation)) {
                TaskDetailActivity.this.imeAnimating = true;
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            TaskDetailActivity.this.c1(insets);
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j implements View.OnLayoutChangeListener {
        public j() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            List listM1 = Z8.F.m1(TaskDetailActivity.this.pendingHostActions);
            TaskDetailActivity.this.pendingHostActions.clear();
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((InterfaceC5063a) it.next()).invoke();
            }
        }
    }

    public static final Y8.t A2(TaskDetailActivity taskDetailActivity) throws Resources.NotFoundException {
        taskDetailActivity.b1(HtmlView.PREVIEW);
        return Y8.t.f7040a;
    }

    public static final Y8.t B1(TaskDetailActivity taskDetailActivity, String str, Uri it) throws IOException {
        kotlin.jvm.internal.p.i(it, "it");
        taskDetailActivity.C1(str, it);
        return Y8.t.f7040a;
    }

    public static final Y8.t B2(TaskDetailActivity taskDetailActivity) throws Resources.NotFoundException {
        taskDetailActivity.b1(HtmlView.CODE);
        return Y8.t.f7040a;
    }

    public static final Y8.t C2(TaskDetailActivity taskDetailActivity) throws FileStorageException.NotInitialized {
        taskDetailActivity.G2();
        return Y8.t.f7040a;
    }

    public static final String D1(TaskDetailActivity taskDetailActivity) {
        String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(taskDetailActivity.getColor(R$color.task_detail_page_background) & 16777215)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public static final void E3(TaskDetailActivity taskDetailActivity) {
        FrameLayout frameLayout;
        C4148a.u(TAG, "render mask hide by timeout", false, 4, null);
        r6.q qVar = taskDetailActivity.resultBinding;
        if (qVar == null || (frameLayout = qVar.resultRenderMask) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void F1(TaskDetailActivity taskDetailActivity, DownloadOption downloadOption, Uri uri, p9.p pVar, int i10, Object obj) throws FileStorageException.NotInitialized {
        if ((i10 & 4) != 0) {
            pVar = new p9.p() { // from class: com.stepos.ailauncher.task.detail.N
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return TaskDetailActivity.G1((Uri) obj2, ((Boolean) obj3).booleanValue());
                }
            };
        }
        taskDetailActivity.E1(downloadOption, uri, pVar);
    }

    public static final Y8.t G1(Uri uri, boolean z10) {
        kotlin.jvm.internal.p.i(uri, "<unused var>");
        return Y8.t.f7040a;
    }

    public static final Y8.t G3(TaskDetailActivity taskDetailActivity) {
        View view = taskDetailActivity.resultContentView;
        if (view != null) {
            view.setVisibility(0);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t H1(final TaskDetailActivity taskDetailActivity, Uri uri, p9.p pVar, final DocumentPreviewResponse resp) {
        kotlin.jvm.internal.p.i(resp, "resp");
        taskDetailActivity.Z2(uri, pVar, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.y0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.I1(this.f28764a, resp, (Uri) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t H2(TaskDetailActivity taskDetailActivity, DownloadOption selected) throws FileStorageException.NotInitialized {
        kotlin.jvm.internal.p.i(selected, "selected");
        taskDetailActivity.H3(selected);
        return Y8.t.f7040a;
    }

    public static final Y8.t I1(TaskDetailActivity taskDetailActivity, DocumentPreviewResponse documentPreviewResponse, Uri it) throws IOException {
        kotlin.jvm.internal.p.i(it, "it");
        taskDetailActivity.C1(documentPreviewResponse.getPreviewUrl(), it);
        return Y8.t.f7040a;
    }

    public static final Y8.t J1(String str, TaskDetailActivity taskDetailActivity, Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        C4148a.t(TAG, "getPreviewUrl(pdf) failed. fileId=" + str, e10, false, 8, null);
        taskDetailActivity.F2();
        return Y8.t.f7040a;
    }

    public static final View J3(TaskDetailActivity taskDetailActivity) {
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        return bVar.llFloatcardInputContainer;
    }

    public static final Y8.t K1(final TaskDetailActivity taskDetailActivity, Uri uri, p9.p pVar, final DownloadUrlResponse resp) {
        kotlin.jvm.internal.p.i(resp, "resp");
        taskDetailActivity.Z2(uri, pVar, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.B0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.L1(this.f28442a, resp, (Uri) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t L1(TaskDetailActivity taskDetailActivity, DownloadUrlResponse downloadUrlResponse, Uri it) throws IOException {
        kotlin.jvm.internal.p.i(it, "it");
        taskDetailActivity.C1(downloadUrlResponse.getDownloadUrl(), it);
        return Y8.t.f7040a;
    }

    public static final void L3(TaskDetailActivity taskDetailActivity) {
        if (taskDetailActivity.isDestroyed() || taskDetailActivity.versionGlassHandle != null) {
            return;
        }
        r6.b bVar = taskDetailActivity.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout versionBtnGroup = bVar.versionBtnGroup;
        kotlin.jvm.internal.p.h(versionBtnGroup, "versionBtnGroup");
        if (versionBtnGroup.getVisibility() == 0) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            r6.b bVar3 = taskDetailActivity.binding;
            if (bVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar3;
            }
            LinearLayout versionBtnGroup2 = bVar2.versionBtnGroup;
            kotlin.jvm.internal.p.h(versionBtnGroup2, "versionBtnGroup");
            taskDetailActivity.versionGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, versionBtnGroup2, false, Float.valueOf(22.0f), null, false, 24, null);
        }
    }

    public static final Y8.t M1(String str, TaskDetailActivity taskDetailActivity, DownloadOption downloadOption, Uri uri, p9.p pVar, Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        C4148a.t(TAG, "getDownloadUrl failed. fileId=" + str, e10, false, 8, null);
        if (!taskDetailActivity.A1(downloadOption, uri, pVar)) {
            taskDetailActivity.F2();
        }
        return Y8.t.f7040a;
    }

    public static final void M3(TaskDetailActivity taskDetailActivity) {
        if (taskDetailActivity.isDestroyed() || taskDetailActivity.actionGlassHandle != null) {
            return;
        }
        r6.b bVar = taskDetailActivity.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout actionBtnGroup = bVar.actionBtnGroup;
        kotlin.jvm.internal.p.h(actionBtnGroup, "actionBtnGroup");
        if (actionBtnGroup.getVisibility() == 0) {
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            r6.b bVar3 = taskDetailActivity.binding;
            if (bVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar3;
            }
            LinearLayout actionBtnGroup2 = bVar2.actionBtnGroup;
            kotlin.jvm.internal.p.h(actionBtnGroup2, "actionBtnGroup");
            taskDetailActivity.actionGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, actionBtnGroup2, false, Float.valueOf(22.0f), null, false, 24, null);
        }
    }

    public static final Y8.t P2(TaskDetailActivity taskDetailActivity, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        taskDetailActivity.R2(url);
        return Y8.t.f7040a;
    }

    public static final Y8.t P3(TaskDetailActivity taskDetailActivity) {
        taskDetailActivity.e2();
        taskDetailActivity.v1();
        return Y8.t.f7040a;
    }

    public static final Y8.t Q2(String str, TaskDetailActivity taskDetailActivity, SessionArtifact sessionArtifact, Throwable th) {
        C4148a.u(TAG, "renderFilePart getPreviewUrl(html) failed fileId=" + str + " e=" + th, false, 4, null);
        taskDetailActivity.W2(sessionArtifact);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q3(TaskDetailActivity taskDetailActivity, boolean z10) {
        taskDetailActivity.f1(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t S1(TaskDetailActivity taskDetailActivity, boolean z10, TaskWebView taskWebView, String url, InterfaceC5063a interfaceC5063a) {
        kotlin.jvm.internal.p.i(url, "url");
        taskDetailActivity.U1(url, z10, taskWebView, interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static final Y8.t S2(TaskDetailActivity taskDetailActivity, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        C4148a.u(TAG, "html treated as download, fallback to fetch+loadHtmlData", false, 4, null);
        taskDetailActivity.Q1();
        return Y8.t.f7040a;
    }

    public static final Y8.t T1(String str, TaskDetailActivity taskDetailActivity, SessionArtifact sessionArtifact, boolean z10, TaskWebView taskWebView, Throwable th) {
        C4148a.u(TAG, "fetchTextAndRender getDownloadUrl failed, fallback to cloudPath. fileId=" + str + " e=" + th, false, 4, null);
        String cloudPath = sessionArtifact.getCloudPath();
        if (cloudPath == null) {
            cloudPath = "";
        }
        V1(taskDetailActivity, cloudPath, z10, taskWebView, null, 8, null);
        return Y8.t.f7040a;
    }

    public static final void T2(TaskDetailActivity taskDetailActivity) {
        C4148a.u(TAG, "html first-paint timeout, fallback to fetch+loadHtmlData", false, 4, null);
        taskDetailActivity.Q1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V1(TaskDetailActivity taskDetailActivity, String str, boolean z10, TaskWebView taskWebView, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        taskDetailActivity.U1(str, z10, taskWebView, interfaceC5063a);
    }

    public static final Y8.t b3(TaskDetailActivity taskDetailActivity, Uri destUri, boolean z10) {
        kotlin.jvm.internal.p.i(destUri, "destUri");
        taskDetailActivity.W1(destUri, z10);
        return Y8.t.f7040a;
    }

    public static final void c3(TaskDetailActivity taskDetailActivity, Uri uri) throws FileStorageException.NotInitialized {
        DownloadOption downloadOption;
        taskDetailActivity.clearOverrideActivityTransition(0);
        taskDetailActivity.clearOverrideActivityTransition(1);
        if (uri == null || (downloadOption = taskDetailActivity.pendingDownloadOption) == null) {
            return;
        }
        taskDetailActivity.pendingDownloadOption = null;
        F1(taskDetailActivity, downloadOption, uri, null, 4, null);
    }

    private final void d3(boolean target, boolean animate) {
        boolean z10 = this.expanded != target;
        this.expanded = target;
        if (target && !this.chatBlurAttached) {
            g1();
        }
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout chatPanel = bVar.chatPanel;
        kotlin.jvm.internal.p.h(chatPanel, "chatPanel");
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        LinearLayout llCurrentStatus = bVar3.llCurrentStatus;
        kotlin.jvm.internal.p.h(llCurrentStatus, "llCurrentStatus");
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        View sheetScrim = bVar4.sheetScrim;
        kotlin.jvm.internal.p.h(sheetScrim, "sheetScrim");
        if (target) {
            chatPanel.setVisibility(0);
            llCurrentStatus.setVisibility(8);
            sheetScrim.setClickable(true);
            if (animate && z10) {
                chatPanel.setTranslationY(chatPanel.getHeight());
                chatPanel.animate().translationY(0.0f).setDuration(280L).setInterpolator(new DecelerateInterpolator()).start();
                sheetScrim.animate().alpha(0.34f).setDuration(280L).start();
            } else {
                chatPanel.setTranslationY(0.0f);
                sheetScrim.setAlpha(0.34f);
            }
        } else {
            llCurrentStatus.setVisibility(A3() ? 0 : 8);
            sheetScrim.setClickable(false);
            if (animate && z10) {
                chatPanel.animate().translationY(chatPanel.getHeight()).setDuration(280L).setInterpolator(new AccelerateInterpolator()).setListener(new h(chatPanel)).start();
                sheetScrim.animate().alpha(0.0f).setDuration(280L).start();
                llCurrentStatus.animate().alpha(1.0f).setDuration(280L).start();
            } else {
                chatPanel.setVisibility(8);
                chatPanel.setTranslationY(0.0f);
                sheetScrim.setAlpha(0.0f);
                llCurrentStatus.setAlpha(1.0f);
            }
        }
        I3(target);
        if (target) {
            r6.b bVar5 = this.binding;
            if (bVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar5;
            }
            bVar2.taskChatLayout.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.L
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.f3(this.f28465a);
                }
            });
        }
    }

    public static /* synthetic */ void e3(TaskDetailActivity taskDetailActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        taskDetailActivity.d3(z10, z11);
    }

    public static final void f3(TaskDetailActivity taskDetailActivity) {
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.taskChatLayout.M8();
    }

    public static final void g2(TaskDetailActivity taskDetailActivity, View view) {
        e3(taskDetailActivity, false, false, 2, null);
    }

    public static final void h1(TaskDetailActivity taskDetailActivity) {
        if (taskDetailActivity.isDestroyed()) {
            return;
        }
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(taskDetailActivity.sheetMaterialHandle);
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout chatPanel = bVar.chatPanel;
        kotlin.jvm.internal.p.h(chatPanel, "chatPanel");
        taskDetailActivity.sheetMaterialHandle = com.stepos.ailauncher.container.glass.h.o(hVar, chatPanel, 20.0f, false, null, 8, null);
    }

    public static final void h2(TaskDetailActivity taskDetailActivity, View view) {
        e3(taskDetailActivity, false, false, 2, null);
    }

    public static final int h3(ContextThemeWrapper contextThemeWrapper, int i10) {
        TypedValue typedValue = new TypedValue();
        contextThemeWrapper.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.data;
    }

    public static final Y8.t i3(TaskDetailActivity taskDetailActivity, DisplayMessage m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.getRole() == AgentRole.ASSISTANT) {
            boolean z10 = true;
            boolean z11 = taskDetailActivity.chipAwaitingReply || taskDetailActivity.chipReplying;
            taskDetailActivity.chipAwaitingReply = false;
            if (m10.getStatus() != EReplyStatus.COMPLETED && m10.getStatus() != EReplyStatus.CANCELED && m10.getStatus() != EReplyStatus.ERROR) {
                z10 = false;
            }
            if (z10 && z11) {
                SessionActivityTracker.INSTANCE.c(taskDetailActivity.sessionId);
                taskDetailActivity.K2();
                if (taskDetailActivity.expanded) {
                    e3(taskDetailActivity, false, false, 2, null);
                }
            }
            taskDetailActivity.chipReplying = !z10;
            if (!z10) {
                J0.INSTANCE.b(taskDetailActivity.sessionId);
            }
        }
        ChatView.INSTANCE.a(taskDetailActivity.sessionId);
        taskDetailActivity.J2();
        return Y8.t.f7040a;
    }

    public static final void j1(TaskDetailActivity taskDetailActivity, LinearLayout linearLayout) {
        if (!taskDetailActivity.isDestroyed() && taskDetailActivity.chipGlassHandle == null && linearLayout.getVisibility() == 0) {
            y7.E eM = com.stepos.ailauncher.container.glass.h.m(com.stepos.ailauncher.container.glass.h.INSTANCE, linearLayout, false, Float.valueOf(16.0f), null, false, 24, null);
            if (eM != null) {
                linearLayout.setBackground(null);
            } else {
                eM = null;
            }
            taskDetailActivity.chipGlassHandle = eM;
        }
    }

    public static final void j2(TaskDetailActivity taskDetailActivity) {
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.inputViewTask.setOnSendMessageListener(taskDetailActivity.new e());
    }

    public static final boolean j3(TaskDetailActivity taskDetailActivity, String sid, String inqId, List inquiries, String askUserMessageId) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(inqId, "inqId");
        kotlin.jvm.internal.p.i(inquiries, "inquiries");
        kotlin.jvm.internal.p.i(askUserMessageId, "askUserMessageId");
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        boolean zZb = bVar.inputViewTask.Zb(sid, inqId, inquiries, M5.c.PAGE_PRODUCT_DETAIL, new TaskDetailActivity$setupChatLayout$2$shown$1(taskDetailActivity, sid, inqId, askUserMessageId, null));
        if (zZb) {
            taskDetailActivity.chipPendingCard = true;
            taskDetailActivity.J2();
        }
        return zZb;
    }

    public static final Y8.t k2(TaskDetailActivity taskDetailActivity) {
        taskDetailActivity.chipAwaitingReply = true;
        taskDetailActivity.chipReplying = false;
        taskDetailActivity.chipPendingCard = false;
        J0.INSTANCE.b(taskDetailActivity.sessionId);
        SessionActivityTracker.INSTANCE.j(taskDetailActivity.sessionId);
        ChatView.INSTANCE.a(taskDetailActivity.sessionId);
        taskDetailActivity.J2();
        return Y8.t.f7040a;
    }

    public static final boolean k3(final TaskDetailActivity taskDetailActivity, final LauncherChatLayout launcherChatLayout, final String sid, final String requestId, final String messageId, String title, String str) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(title, "title");
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        boolean zGb = bVar.inputViewTask.Gb(sid, requestId, title, str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.l3(launcherChatLayout, sid, requestId, messageId, taskDetailActivity, (String) obj);
            }
        });
        if (zGb) {
            taskDetailActivity.chipPendingCard = true;
            taskDetailActivity.J2();
        }
        return zGb;
    }

    public static final Y8.t l1(LinearLayout linearLayout, TaskDetailActivity taskDetailActivity, ChatRecycleView chatRecycleView, FrameLayout frameLayout) {
        int height = linearLayout.getHeight();
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        int iF = C5685n.f(height - bVar.llFloatcardInputContainer.getTop(), 0);
        if (height > 0) {
            chatRecycleView.setPadding(chatRecycleView.getPaddingLeft(), chatRecycleView.getPaddingTop(), chatRecycleView.getPaddingRight(), iF);
        }
        if (!taskDetailActivity.lastKeyboardUp && !taskDetailActivity.imeAnimating) {
            if (height > 0) {
                taskDetailActivity.contentBottomInsetPx = iF;
                r6.b bVar2 = taskDetailActivity.binding;
                if (bVar2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    bVar2 = null;
                }
                if (bVar2.bottomScrim.getHeight() != iF) {
                    r6.b bVar3 = taskDetailActivity.binding;
                    if (bVar3 == null) {
                        kotlin.jvm.internal.p.A("binding");
                        bVar3 = null;
                    }
                    View bottomScrim = bVar3.bottomScrim;
                    kotlin.jvm.internal.p.h(bottomScrim, "bottomScrim");
                    ViewGroup.LayoutParams layoutParams = bottomScrim.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    layoutParams.height = iF;
                    bottomScrim.setLayoutParams(layoutParams);
                }
            }
            int i10 = taskDetailActivity.contentTopInsetPx;
            TaskWebView taskWebView = null;
            int i11 = taskDetailActivity.contentBottomInsetPx;
            r6.q qVar = taskDetailActivity.resultBinding;
            if (qVar != null) {
                taskWebView = qVar.resultWeb;
            }
            TaskWebView taskWebView2 = taskWebView;
            if (taskDetailActivity.immersive) {
                if (frameLayout.getPaddingBottom() != 0) {
                    frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), 0);
                    frameLayout.requestLayout();
                }
                if (taskWebView2 != null) {
                    taskWebView2.C();
                }
                if (taskWebView2 != null) {
                    taskWebView2.g0(0, 0);
                }
            } else if (taskDetailActivity.markdownEdgeToEdge) {
                if (frameLayout.getPaddingBottom() != 0) {
                    frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), 0);
                    frameLayout.requestLayout();
                }
                if (taskWebView2 != null) {
                    taskWebView2.g0(i10, i11);
                }
            } else if (taskDetailActivity.webviewFullscreen) {
                if (frameLayout.getPaddingBottom() != 0) {
                    frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), 0);
                    frameLayout.requestLayout();
                }
                if (taskWebView2 != null) {
                    TaskWebView.c0(taskWebView2, i10, i11, taskDetailActivity.Z1(), null, 8, null);
                }
            } else if (frameLayout.getPaddingBottom() != i11) {
                frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), i11);
                frameLayout.requestLayout();
            }
        }
        return Y8.t.f7040a;
    }

    public static final boolean l2(TaskDetailActivity taskDetailActivity) {
        SessionActivityTracker.INSTANCE.c(taskDetailActivity.sessionId);
        SessionHandler sessionHandler = taskDetailActivity.sessionHandler;
        if (sessionHandler == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
            sessionHandler = null;
        }
        sessionHandler.X3();
        return true;
    }

    public static final Y8.t l3(LauncherChatLayout launcherChatLayout, String str, String str2, String str3, TaskDetailActivity taskDetailActivity, String action) {
        kotlin.jvm.internal.p.i(action, "action");
        launcherChatLayout.q7(str, str2, str3, action);
        taskDetailActivity.chipPendingCard = false;
        taskDetailActivity.J2();
        return Y8.t.f7040a;
    }

    public static final void m1(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t m2(com.stepos.ailauncher.task.detail.TaskDetailActivity r4, boolean r5) {
        /*
            r6.b r0 = r4.binding
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        Lb:
            android.view.View r0 = r0.vSpeechBg
            if (r5 == 0) goto L22
            r6.b r3 = r4.binding
            if (r3 != 0) goto L17
            kotlin.jvm.internal.p.A(r2)
            goto L18
        L17:
            r1 = r3
        L18:
            com.stepos.ailauncher.task.chat.TaskInputView r1 = r1.inputViewTask
            boolean r1 = r1.b8()
            if (r1 != 0) goto L22
            r1 = 0
            goto L23
        L22:
            r1 = 4
        L23:
            r0.setVisibility(r1)
            com.stepos.ailauncher.chat.wake.effect.c r4 = r4.chatSpectrumController
            if (r4 == 0) goto L2d
            r4.l(r5)
        L2d:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.m2(com.stepos.ailauncher.task.detail.TaskDetailActivity, boolean):Y8.t");
    }

    public static final void n1(InterfaceC5063a interfaceC5063a, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t n2(com.stepos.ailauncher.task.detail.TaskDetailActivity r3, boolean r4) {
        /*
            r6.b r0 = r3.binding
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        Lb:
            android.view.View r0 = r0.vSpeechBg
            if (r4 == 0) goto L22
            r6.b r3 = r3.binding
            if (r3 != 0) goto L17
            kotlin.jvm.internal.p.A(r2)
            goto L18
        L17:
            r1 = r3
        L18:
            com.stepos.ailauncher.task.chat.TaskInputView r3 = r1.inputViewTask
            boolean r3 = r3.b8()
            if (r3 != 0) goto L22
            r3 = 0
            goto L23
        L22:
            r3 = 4
        L23:
            r0.setVisibility(r3)
            Y8.t r3 = Y8.t.f7040a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.n2(com.stepos.ailauncher.task.detail.TaskDetailActivity, boolean):Y8.t");
    }

    public static final void n3(TaskDetailActivity taskDetailActivity, View view) {
        taskDetailActivity.b2();
    }

    public static final Y8.t o2(TaskDetailActivity taskDetailActivity, boolean z10) {
        com.stepos.ailauncher.chat.wake.effect.c cVar = taskDetailActivity.chatSpectrumController;
        if (cVar != null) {
            cVar.k(z10);
        }
        return Y8.t.f7040a;
    }

    public static final void o3(TaskDetailActivity taskDetailActivity) {
        if (taskDetailActivity.isDestroyed() || taskDetailActivity.backGlassHandle != null) {
            return;
        }
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        ImageView ivBack = bVar.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        taskDetailActivity.backGlassHandle = com.stepos.ailauncher.container.glass.h.m(hVar, ivBack, false, Float.valueOf(22.0f), null, false, 24, null);
    }

    public static final androidx.core.view.a0 p1(View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        int i10 = insets.f(a0.o.f()).f41978b;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin != i10) {
            marginLayoutParams.topMargin = i10;
        }
        view.setLayoutParams(marginLayoutParams);
        return insets;
    }

    public static final void p3(TaskDetailActivity taskDetailActivity, View view) {
        taskDetailActivity.E2(-1);
    }

    public static final void q1(TaskDetailActivity taskDetailActivity, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int bottom = view.getBottom() + C4058a.INSTANCE.a(taskDetailActivity, 4);
        if (bottom == taskDetailActivity.contentTopInsetPx) {
            return;
        }
        taskDetailActivity.contentTopInsetPx = bottom;
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        View topScrim = bVar.topScrim;
        kotlin.jvm.internal.p.h(topScrim, "topScrim");
        ViewGroup.LayoutParams layoutParams = topScrim.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = bottom;
        topScrim.setLayoutParams(layoutParams);
        taskDetailActivity.a1();
    }

    public static final void q3(TaskDetailActivity taskDetailActivity, View view) {
        taskDetailActivity.E2(1);
    }

    public static final void r3(TaskDetailActivity taskDetailActivity, View view) throws FileStorageException.NotInitialized {
        taskDetailActivity.G2();
    }

    public static final void s3(TaskDetailActivity taskDetailActivity, View view) throws Resources.NotFoundException {
        boolean z10 = !taskDetailActivity.immersive;
        SessionArtifact sessionArtifactY1 = taskDetailActivity.Y1();
        if (sessionArtifactY1 != null) {
            M5.c cVar = M5.c.INSTANCE;
            String str = taskDetailActivity.sessionId;
            if (str.length() <= 0) {
                str = null;
            }
            cVar.r(sessionArtifactY1, str, z10);
        }
        taskDetailActivity.d1(z10);
    }

    public static final Y8.t t2(TaskDetailActivity taskDetailActivity, ImageView imageView, String str, boolean z10, String url, InterfaceC5063a interfaceC5063a) {
        kotlin.jvm.internal.p.i(url, "url");
        taskDetailActivity.v2(imageView, url, str, interfaceC5063a, z10);
        return Y8.t.f7040a;
    }

    public static final void t3(TaskDetailActivity taskDetailActivity, View view) {
        if (taskDetailActivity.a2().e()) {
            taskDetailActivity.a2().d();
            return;
        }
        r rVarA2 = taskDetailActivity.a2();
        r6.b bVar = taskDetailActivity.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout actionBtnGroup = bVar.actionBtnGroup;
        kotlin.jvm.internal.p.h(actionBtnGroup, "actionBtnGroup");
        rVarA2.f(actionBtnGroup, taskDetailActivity.htmlView == HtmlView.CODE);
    }

    public static final Y8.t u2(String str, TaskDetailActivity taskDetailActivity, ImageView imageView, String str2, String str3, boolean z10, Throwable th) {
        C4148a.u(TAG, "loadImageFromDownloadUrl getDownloadUrl failed, fallback to content. fileId=" + str + " e=" + th, false, 4, null);
        w2(taskDetailActivity, imageView, str2, str3, null, z10, 8, null);
        return Y8.t.f7040a;
    }

    public static final void u3(TaskDetailActivity taskDetailActivity) {
        taskDetailActivity.b2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w2(TaskDetailActivity taskDetailActivity, ImageView imageView, Object obj, String str, InterfaceC5063a interfaceC5063a, boolean z10, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        taskDetailActivity.v2(imageView, obj, str, interfaceC5063a, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean w3(com.stepos.ailauncher.task.detail.TaskDetailActivity r7, android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.w3(com.stepos.ailauncher.task.detail.TaskDetailActivity, android.view.View, android.view.MotionEvent):boolean");
    }

    public static final androidx.core.view.a0 y3(TaskDetailActivity taskDetailActivity, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        if (!taskDetailActivity.imeAnimating) {
            taskDetailActivity.c1(insets);
        }
        return insets;
    }

    public static final tb.z z1() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(30L, timeUnit).T(30L, timeUnit).W(30L, timeUnit).d();
    }

    public static final r z2(final TaskDetailActivity taskDetailActivity) {
        return new r(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.a0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.A2(this.f28506a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.b0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.B2(this.f28510a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.c0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.C2(this.f28512a);
            }
        });
    }

    public final boolean A1(DownloadOption option, Uri destUri, p9.p<? super Uri, ? super Boolean, Y8.t> onDone) {
        final String cloudPath = option.getArtifact().getCloudPath();
        if (cloudPath == null || La.H.x0(cloudPath) || !La.D.X(cloudPath, "http", false, 2, null)) {
            return false;
        }
        C4148a.k(TAG, "download via cloudPath fallback fileId=" + option.getArtifact().getFileId(), false, 4, null);
        Z2(destUri, onDone, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.q0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.B1(this.f28665a, cloudPath, (Uri) obj);
            }
        });
        return true;
    }

    public final boolean A3() {
        return (this.chipState == ChipState.DONE && J0.INSTANCE.a(this.sessionId)) ? false : true;
    }

    public final void B3(int msgRes) {
        TextView textView;
        e1(false);
        r6.q qVar = this.resultBinding;
        C3(qVar != null ? qVar.resultFallbackScroll : null);
        r6.q qVar2 = this.resultBinding;
        if (qVar2 == null || (textView = qVar2.resultFallback) == null) {
            return;
        }
        textView.setText(getString(msgRes));
    }

    public final void C1(String url, Uri destUri) throws IOException {
        C5530C c5530cExecute = INSTANCE.b().a(new C5528A.a().t(url).b()).execute();
        try {
            if (!c5530cExecute.getIsSuccessful()) {
                throw new IOException("HTTP " + c5530cExecute.getCode());
            }
            AbstractC5531D body = c5530cExecute.getBody();
            if (body == null) {
                throw new IOException("Empty response body");
            }
            OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(destUri);
            if (outputStreamOpenOutputStream == null) {
                throw new IOException("Cannot open output stream");
            }
            try {
                C4877a.b(body.b(), outputStreamOpenOutputStream, 0, 2, null);
                l9.b.a(outputStreamOpenOutputStream, null);
                l9.b.a(c5530cExecute, null);
            } finally {
            }
        } finally {
        }
    }

    public final void C3(View target) {
        r6.q qVar = this.resultBinding;
        if (qVar == null) {
            return;
        }
        TaskWebView resultWeb = qVar.resultWeb;
        kotlin.jvm.internal.p.h(resultWeb, "resultWeb");
        resultWeb.setVisibility(target == qVar.resultWeb ? 0 : 8);
        ImageView resultImage = qVar.resultImage;
        kotlin.jvm.internal.p.h(resultImage, "resultImage");
        resultImage.setVisibility(target == qVar.resultImage ? 0 : 8);
        ScrollView resultFallbackScroll = qVar.resultFallbackScroll;
        kotlin.jvm.internal.p.h(resultFallbackScroll, "resultFallbackScroll");
        resultFallbackScroll.setVisibility(target == qVar.resultFallbackScroll ? 0 : 8);
        f1(false);
    }

    public final String D2(SessionArtifact a10) {
        return u6.j.INSTANCE.i(a10.getFileName(), a10.getTitle(), a10.getCloudPath());
    }

    public final void D3() {
        FrameLayout frameLayout;
        r6.q qVar = this.resultBinding;
        if (qVar == null || (frameLayout = qVar.resultRenderMask) == null) {
            return;
        }
        frameLayout.setVisibility(0);
        Runnable runnable = this.maskHideRunnable;
        if (runnable != null) {
            frameLayout.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.task.detail.x0
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.E3(this.f28763a);
            }
        };
        this.maskHideRunnable = runnable2;
        frameLayout.postDelayed(runnable2, 4000L);
    }

    public final void E1(final DownloadOption option, final Uri destUri, final p9.p<? super Uri, ? super Boolean, Y8.t> onDone) throws FileStorageException.NotInitialized {
        N3(true);
        final String fileId = option.getArtifact().getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            if (A1(option, destUri, onDone)) {
                return;
            }
            F2();
        } else if (option.getAsPdfFromPreview()) {
            FileStorageManager.INSTANCE.k(fileId, "pdf", 600, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.h0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskDetailActivity.H1(this.f28640a, destUri, onDone, (DocumentPreviewResponse) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.i0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskDetailActivity.J1(fileId, this, (Throwable) obj);
                }
            });
        } else {
            FileStorageManager.j(FileStorageManager.INSTANCE, fileId, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.j0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskDetailActivity.K1(this.f28647a, destUri, onDone, (DownloadUrlResponse) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.k0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TaskDetailActivity.M1(fileId, this, option, destUri, onDone, (Throwable) obj);
                }
            }, 6, null);
        }
    }

    public final void E2(int delta) {
        int iN;
        if (this.versions.isEmpty() || (iN = C5685n.n(this.currentIndex + delta, 0, C1173v.o(this.versions))) == this.currentIndex) {
            return;
        }
        F3(iN);
    }

    public final void F2() {
        N3(false);
        Toast.makeText(this, R$string.task_detail_download_failed, 0).show();
    }

    public final void F3(int index) {
        this.currentIndex = index;
        SessionArtifact sessionArtifact = (SessionArtifact) Z8.F.t0(this.versions, index);
        if (sessionArtifact == null) {
            return;
        }
        this.htmlView = HtmlView.PREVIEW;
        this.codeLoaded = false;
        this.currentHtmlSource = null;
        K3();
        V2(sessionArtifact);
        R3(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.d0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.G3(this.f28536a);
            }
        });
    }

    public final void G2() throws FileStorageException.NotInitialized {
        SessionArtifact sessionArtifactY1 = Y1();
        if (sessionArtifactY1 == null) {
            return;
        }
        List<DownloadOption> listT1 = t1(sessionArtifactY1);
        if (listT1.size() <= 1) {
            H3((DownloadOption) Z8.F.q0(listT1));
            return;
        }
        C3565w c3565wA = C3565w.INSTANCE.a(listT1);
        c3565wA.E(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.o0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.H2(this.f28661a, (DownloadOption) obj);
            }
        });
        c3565wA.show(getSupportFragmentManager(), "download_format");
    }

    public final void H3(DownloadOption option) throws FileStorageException.NotInitialized {
        if (!option.getAsPdfFromPreview() && p2(option.getArtifact())) {
            a3(option);
        } else {
            this.pendingDownloadOption = option;
            r2(u1(option));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I2(java.lang.String r12, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SessionArtifact>> r13) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.stepos.ailauncher.task.detail.TaskDetailActivity$queryVersionGroup$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.ailauncher.task.detail.TaskDetailActivity$queryVersionGroup$1 r0 = (com.stepos.ailauncher.task.detail.TaskDetailActivity$queryVersionGroup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.detail.TaskDetailActivity$queryVersionGroup$1 r0 = new com.stepos.ailauncher.task.detail.TaskDetailActivity$queryVersionGroup$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.L$1
            com.stepos.ailauncher.task.detail.TaskDetailActivity r12 = (com.stepos.ailauncher.task.detail.TaskDetailActivity) r12
            java.lang.Object r12 = r0.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L32
            goto L67
        L32:
            r0 = move-exception
            r13 = r0
            goto L6e
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.C4849c.b(r13)
            java.lang.String r13 = r11.sessionId
            int r13 = r13.length()
            if (r13 != 0) goto L49
            return r4
        L49:
            kotlin.Result$a r13 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.ailauncher.foundation.task.TaskModule r13 = com.stepos.ailauncher.foundation.task.TaskModule.INSTANCE     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r11.sessionId     // Catch: java.lang.Throwable -> L32
            java.util.List r2 = Z8.C1172u.e(r2)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r13 = r13.e(r2, r0)     // Catch: java.lang.Throwable -> L32
            if (r13 != r1) goto L67
            return r1
        L67:
            java.util.List r13 = (java.util.List) r13     // Catch: java.lang.Throwable -> L32
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L32
            goto L78
        L6e:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        L78:
            java.lang.Throwable r7 = kotlin.Result.e(r13)
            if (r7 == 0) goto L9b
            java.lang.String r11 = r11.sessionId
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "queryVersionGroup failed sessionId="
            r0.append(r1)
            r0.append(r11)
            java.lang.String r6 = r0.toString()
            r9 = 8
            r10 = 0
            java.lang.String r5 = "TaskDetailActivity"
            r8 = 0
            h8.C4148a.t(r5, r6, r7, r8, r9, r10)
        L9b:
            boolean r11 = kotlin.Result.g(r13)
            if (r11 == 0) goto La2
            r13 = r4
        La2:
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto Laa
            java.util.List r4 = com.stepos.ailauncher.contract.model.SessionArtifactKt.versionGroupOf(r13, r12)
        Laa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.I2(java.lang.String, e9.c):java.lang.Object");
    }

    public final void I3(boolean expandedNow) {
        r6.b bVar = null;
        if (!expandedNow) {
            E7.a aVar = this.scrollBtnFloatHandle;
            if (aVar != null) {
                aVar.a();
            }
            this.scrollBtnFloatHandle = null;
            return;
        }
        if (this.scrollBtnFloatHandle == null) {
            E7 e72 = E7.INSTANCE;
            r6.b bVar2 = this.binding;
            if (bVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar2 = null;
            }
            FrameLayout frameLayoutB = bVar2.b();
            kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
            r6.b bVar3 = this.binding;
            if (bVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar3 = null;
            }
            this.scrollBtnFloatHandle = E7.e(e72, frameLayoutB, bVar3.taskChatLayout.getBtnScrollToBottom(), 0.0f, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.l0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return TaskDetailActivity.J3(this.f28656a);
                }
            }, null, 44, null);
            r6.b bVar4 = this.binding;
            if (bVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar = bVar4;
            }
            bVar.taskChatLayout.J8();
        }
    }

    public final void J2() {
        this.chipState = X2();
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LottieAnimationView chipLottie = bVar.chipLottie;
        kotlin.jvm.internal.p.h(chipLottie, "chipLottie");
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        ImageView ivStatus = bVar3.ivStatus;
        kotlin.jvm.internal.p.h(ivStatus, "ivStatus");
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar4;
        }
        TextView tvCurrentTaskTitle = bVar2.tvCurrentTaskTitle;
        kotlin.jvm.internal.p.h(tvCurrentTaskTitle, "tvCurrentTaskTitle");
        int i10 = b.$EnumSwitchMapping$0[this.chipState.ordinal()];
        if (i10 == 1) {
            chipLottie.setVisibility(0);
            ivStatus.setVisibility(8);
            tvCurrentTaskTitle.setText("思考中…");
        } else if (i10 == 2) {
            chipLottie.setVisibility(0);
            ivStatus.setVisibility(8);
            tvCurrentTaskTitle.setText("执行中…");
        } else if (i10 == 3) {
            chipLottie.setVisibility(8);
            ivStatus.setVisibility(0);
            ivStatus.setImageResource(R$drawable.ic_chip_takeover);
            tvCurrentTaskTitle.setText("待接管");
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            chipLottie.setVisibility(8);
            ivStatus.setVisibility(0);
            ivStatus.setImageResource(R$drawable.ic_chip_done);
            tvCurrentTaskTitle.setText(AlipayXuiIsland.LABEL_COMPLETED);
        }
        Z0();
    }

    public final void K2() {
        String fileId;
        SessionArtifact sessionArtifactY1 = Y1();
        if (sessionArtifactY1 == null || (fileId = sessionArtifactY1.getFileId()) == null) {
            return;
        }
        if (La.H.x0(fileId)) {
            fileId = null;
        }
        if (fileId == null) {
            return;
        }
        C1060i.d(C1398p.a(this), null, null, new TaskDetailActivity$refreshVersionsAfterRound$1(this, fileId, null), 3, null);
    }

    public final void K3() {
        boolean z10;
        SessionArtifact sessionArtifactY1 = Y1();
        boolean z11 = sessionArtifactY1 != null && U2(sessionArtifactY1) == RenderKind.HTML;
        boolean z12 = sessionArtifactY1 != null && U2(sessionArtifactY1) == RenderKind.CODE;
        boolean z13 = this.versions.size() > 1;
        boolean z14 = z13 && this.currentIndex > 0;
        boolean z15 = z13 && this.currentIndex < this.versions.size() - 1;
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.ivPartPrev.setEnabled(z14);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.ivPartNext.setEnabled(z15);
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        bVar4.ivPartPrev.setAlpha(z14 ? 1.0f : 0.3f);
        r6.b bVar5 = this.binding;
        if (bVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar5 = null;
        }
        bVar5.ivPartNext.setAlpha(z15 ? 1.0f : 0.3f);
        r6.b bVar6 = this.binding;
        if (bVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar6 = null;
        }
        ImageView ivFullscreen = bVar6.ivFullscreen;
        kotlin.jvm.internal.p.h(ivFullscreen, "ivFullscreen");
        ivFullscreen.setVisibility(sessionArtifactY1 != null ? 0 : 8);
        r6.b bVar7 = this.binding;
        if (bVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar7 = null;
        }
        ImageView ivMore = bVar7.ivMore;
        kotlin.jvm.internal.p.h(ivMore, "ivMore");
        ivMore.setVisibility(z11 && !this.immersive ? 0 : 8);
        r6.b bVar8 = this.binding;
        if (bVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar8 = null;
        }
        ImageView ivDownload = bVar8.ivDownload;
        kotlin.jvm.internal.p.h(ivDownload, "ivDownload");
        ivDownload.setVisibility(!this.immersive && sessionArtifactY1 != null && ((!z11 && O1(sessionArtifactY1) != null) || z12) ? 0 : 8);
        r6.b bVar9 = this.binding;
        if (bVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar9 = null;
        }
        ImageView ivBack = bVar9.ivBack;
        kotlin.jvm.internal.p.h(ivBack, "ivBack");
        ivBack.setVisibility(!this.immersive ? 0 : 8);
        r6.b bVar10 = this.binding;
        if (bVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar10 = null;
        }
        LinearLayout versionBtnGroup = bVar10.versionBtnGroup;
        kotlin.jvm.internal.p.h(versionBtnGroup, "versionBtnGroup");
        versionBtnGroup.setVisibility(z13 && !this.immersive ? 0 : 8);
        r6.b bVar11 = this.binding;
        if (bVar11 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar11 = null;
        }
        LinearLayout actionBtnGroup = bVar11.actionBtnGroup;
        kotlin.jvm.internal.p.h(actionBtnGroup, "actionBtnGroup");
        r6.b bVar12 = this.binding;
        if (bVar12 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar12 = null;
        }
        ImageView imageView = bVar12.ivFullscreen;
        r6.b bVar13 = this.binding;
        if (bVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar13 = null;
        }
        ImageView imageView2 = bVar13.ivMore;
        r6.b bVar14 = this.binding;
        if (bVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar14 = null;
        }
        List<ImageView> listP = C1173v.p(imageView, imageView2, bVar14.ivDownload);
        if ((listP instanceof Collection) && listP.isEmpty()) {
            z10 = false;
        } else {
            for (ImageView imageView3 : listP) {
                kotlin.jvm.internal.p.f(imageView3);
                if (imageView3.getVisibility() == 0) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        actionBtnGroup.setVisibility(z10 ? 0 : 8);
        r6.b bVar15 = this.binding;
        if (bVar15 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar15 = null;
        }
        View topScrim = bVar15.topScrim;
        kotlin.jvm.internal.p.h(topScrim, "topScrim");
        topScrim.setVisibility(!this.immersive ? 0 : 8);
        r6.b bVar16 = this.binding;
        if (bVar16 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar16 = null;
        }
        View bottomScrim = bVar16.bottomScrim;
        kotlin.jvm.internal.p.h(bottomScrim, "bottomScrim");
        bottomScrim.setVisibility(!this.immersive && this.chatEnabled ? 0 : 8);
        r6.b bVar17 = this.binding;
        if (bVar17 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar17 = null;
        }
        LinearLayout versionBtnGroup2 = bVar17.versionBtnGroup;
        kotlin.jvm.internal.p.h(versionBtnGroup2, "versionBtnGroup");
        if (versionBtnGroup2.getVisibility() == 0 && this.versionGlassHandle == null) {
            r6.b bVar18 = this.binding;
            if (bVar18 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar18 = null;
            }
            bVar18.versionBtnGroup.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.m0
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.L3(this.f28658a);
                }
            });
        }
        r6.b bVar19 = this.binding;
        if (bVar19 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar19 = null;
        }
        LinearLayout actionBtnGroup2 = bVar19.actionBtnGroup;
        kotlin.jvm.internal.p.h(actionBtnGroup2, "actionBtnGroup");
        if (actionBtnGroup2.getVisibility() == 0 && this.actionGlassHandle == null) {
            r6.b bVar20 = this.binding;
            if (bVar20 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar20;
            }
            bVar2.actionBtnGroup.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.n0
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.M3(this.f28659a);
                }
            });
        }
    }

    public final void L2(RenderKind active) {
        r6.q qVar = this.resultBinding;
        if (qVar == null) {
            return;
        }
        if (active != RenderKind.TEXT && active != RenderKind.HTML && active != RenderKind.FILE) {
            qVar.resultWeb.O("about:blank");
        }
        if (active != RenderKind.IMAGE) {
            qVar.resultImage.setImageDrawable(null);
        }
    }

    public final void M2() {
        r6.q qVar;
        FrameLayout frameLayout;
        Runnable runnable = this.maskHideRunnable;
        if (runnable != null && (qVar = this.resultBinding) != null && (frameLayout = qVar.resultRenderMask) != null) {
            frameLayout.removeCallbacks(runnable);
        }
        v1();
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        androidx.core.view.N.u0(bVar.bottomContainer, null);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        androidx.core.view.N.E0(bVar3.bottomContainer, null);
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        androidx.core.view.N.u0(bVar4.rlTop, null);
        View.OnLayoutChangeListener onLayoutChangeListener = this.topBarLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            r6.b bVar5 = this.binding;
            if (bVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar5 = null;
            }
            bVar5.rlTop.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        C2700i.INSTANCE.b("task_id");
        View.OnLayoutChangeListener onLayoutChangeListener2 = this.bottomContainerLayoutChangeListener;
        if (onLayoutChangeListener2 != null) {
            r6.b bVar6 = this.binding;
            if (bVar6 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar6;
            }
            bVar2.bottomContainer.removeOnLayoutChangeListener(onLayoutChangeListener2);
        }
    }

    public final RenderKind N1(String ext) {
        if (IMAGE_EXTS.contains(ext)) {
            return RenderKind.IMAGE;
        }
        if (kotlin.jvm.internal.p.d(ext, "html") || kotlin.jvm.internal.p.d(ext, "htm")) {
            return RenderKind.HTML;
        }
        if (kotlin.jvm.internal.p.d(ext, "md") || kotlin.jvm.internal.p.d(ext, "markdown") || kotlin.jvm.internal.p.d(ext, "txt")) {
            return RenderKind.TEXT;
        }
        if (CODE_EXTS.contains(ext)) {
            return RenderKind.CODE;
        }
        if (kotlin.jvm.internal.p.d(ext, "pdf") || PREVIEWABLE_DOC_EXTS.contains(ext)) {
            return RenderKind.FILE;
        }
        return null;
    }

    public final void N2(TaskWebView web, boolean asHtml, String text) throws Resources.NotFoundException {
        if (asHtml) {
            this.currentHtmlSource = text;
            web.L(text);
            return;
        }
        SessionArtifact sessionArtifactY1 = Y1();
        if (sessionArtifactY1 == null || U2(sessionArtifactY1) != RenderKind.CODE) {
            web.M(null, text);
        } else {
            SessionArtifact sessionArtifactY12 = Y1();
            web.K(text, x1(sessionArtifactY12 != null ? sessionArtifactY12.getFileName() : null));
        }
    }

    public final void N3(boolean downloading) {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.ivDownload.setEnabled(!downloading);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar3;
        }
        bVar2.ivDownload.setAlpha(downloading ? 0.5f : 1.0f);
    }

    public final String O1(SessionArtifact a10) {
        return u6.j.INSTANCE.e(a10.getMimeType(), a10.getFileName(), a10.getTitle(), a10.getCloudPath());
    }

    public final void O2(final SessionArtifact a10) {
        String previewUrl = a10.getPreviewUrl();
        if (previewUrl != null && !La.H.x0(previewUrl)) {
            r6.q qVar = this.resultBinding;
            C3(qVar != null ? qVar.resultWeb : null);
            f1(true);
            R2(previewUrl);
            return;
        }
        final String fileId = a10.getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            W2(a10);
            return;
        }
        r6.q qVar2 = this.resultBinding;
        C3(qVar2 != null ? qVar2.resultWeb : null);
        f1(true);
        u6.i.INSTANCE.k(fileId, "html", null, 600, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.s0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.P2(this.f28742a, (String) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.t0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.Q2(fileId, this, a10, (Throwable) obj);
            }
        });
    }

    public final void O3() {
        TaskWebView taskWebView;
        r6.q qVar = this.resultBinding;
        if (qVar == null || (taskWebView = qVar.resultWeb) == null) {
            return;
        }
        taskWebView.setOnContentFirstPaint(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.P3(this.f28435a);
            }
        });
        taskWebView.setOnPlainFlowDetected(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.Q3(this.f28441a, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final String P1(String mimeType) {
        return u6.j.INSTANCE.g(mimeType);
    }

    public final void Q1() {
        TaskWebView taskWebView;
        String str;
        if (this.htmlFallbackDone) {
            return;
        }
        this.htmlFallbackDone = true;
        v1();
        r6.q qVar = this.resultBinding;
        if (qVar == null || (taskWebView = qVar.resultWeb) == null || (str = this.currentHtmlUrl) == null) {
            return;
        }
        V1(this, str, true, taskWebView, null, 8, null);
    }

    public final void R1(final SessionArtifact a10, final TaskWebView web) {
        final boolean z10 = U2(a10) == RenderKind.HTML;
        final String fileId = a10.getFileId();
        if (fileId == null || La.H.x0(fileId)) {
            String cloudPath = a10.getCloudPath();
            if (cloudPath == null) {
                cloudPath = "";
            }
            V1(this, cloudPath, z10, web, null, 8, null);
            return;
        }
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        final boolean z11 = z10;
        u6.i.h(u6.i.INSTANCE, fileId, false, new p9.p() { // from class: com.stepos.ailauncher.task.detail.z0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return TaskDetailActivity.S1(this.f28767a, z10, web, (String) obj, (InterfaceC5063a) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.A0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.T1(fileId, this, a10, z11, web, (Throwable) obj);
            }
        }, 2, null);
    }

    public final void R2(String url) {
        TaskWebView taskWebView;
        r6.q qVar = this.resultBinding;
        if (qVar == null || (taskWebView = qVar.resultWeb) == null) {
            return;
        }
        this.currentHtmlUrl = url;
        this.htmlFallbackDone = false;
        taskWebView.setOnTreatedAsDownload(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.D0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.S2(this.f28447a, (String) obj);
            }
        });
        Runnable runnable = this.htmlFallbackRunnable;
        if (runnable != null) {
            taskWebView.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.task.detail.E0
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.T2(this.f28449a);
            }
        };
        this.htmlFallbackRunnable = runnable2;
        taskWebView.postDelayed(runnable2, 4000L);
        taskWebView.O(url);
    }

    public final void R3(InterfaceC5063a<Y8.t> block) {
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        FrameLayout contentHost = bVar.contentHost;
        kotlin.jvm.internal.p.h(contentHost, "contentHost");
        if (contentHost.getHeight() > 0) {
            block.invoke();
            return;
        }
        boolean zIsEmpty = this.pendingHostActions.isEmpty();
        this.pendingHostActions.addLast(block);
        if (zIsEmpty) {
            if (!contentHost.isLaidOut() || contentHost.isLayoutRequested()) {
                contentHost.addOnLayoutChangeListener(new j());
                return;
            }
            List listM1 = Z8.F.m1(this.pendingHostActions);
            this.pendingHostActions.clear();
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((InterfaceC5063a) it.next()).invoke();
            }
        }
    }

    public final void U1(String url, boolean asHtml, TaskWebView web, InterfaceC5063a<Y8.t> onFailRetry) {
        kotlinx.coroutines.g gVar = this.renderJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.renderJob = C1060i.d(C1398p.a(this), null, null, new TaskDetailActivity$fetchTextWithUrl$1(onFailRetry, this, web, asHtml, url, null), 3, null);
    }

    public final RenderKind U2(SessionArtifact a10) {
        RenderKind renderKind;
        String strJ = u6.j.INSTANCE.j(a10.getMimeType());
        RenderKind renderKindY2 = strJ != null ? y2(strJ) : null;
        String strD2 = D2(a10);
        RenderKind renderKindN1 = strD2 != null ? N1(strD2) : null;
        RenderKind renderKind2 = RenderKind.HTML;
        if (renderKindY2 == renderKind2) {
            return renderKind2;
        }
        RenderKind renderKind3 = RenderKind.IMAGE;
        if (renderKindY2 == renderKind3) {
            return renderKind3;
        }
        RenderKind renderKind4 = RenderKind.FILE;
        if (renderKindY2 == renderKind4) {
            return renderKind4;
        }
        RenderKind renderKind5 = RenderKind.CODE;
        if (renderKindY2 == renderKind5 || (renderKindY2 == (renderKind = RenderKind.TEXT) && renderKindN1 == renderKind5)) {
            return renderKind5;
        }
        if (renderKindY2 == renderKind) {
            return renderKind;
        }
        if (renderKindN1 != null) {
            return renderKindN1;
        }
        if (renderKindY2 != null) {
            return renderKindY2;
        }
        String fileId = a10.getFileId();
        return (fileId == null || La.H.x0(fileId)) ? RenderKind.FALLBACK : renderKind4;
    }

    public final void V2(SessionArtifact a10) {
        TaskWebView taskWebView;
        ImageView imageView;
        String fileId = a10.getFileId();
        String mimeType = a10.getMimeType();
        String fileName = a10.getFileName();
        String title = a10.getTitle();
        String cloudPath = a10.getCloudPath();
        String lowerCase = null;
        C4148a.k(TAG, "renderPart fileId=" + fileId + " mimeType=" + mimeType + " fileName=" + fileName + " title=" + title + " cloudPath=" + (cloudPath != null ? La.K.R1(cloudPath, 80) : null), false, 4, null);
        RenderKind renderKindU2 = U2(a10);
        e1(renderKindU2 == RenderKind.TEXT || renderKindU2 == RenderKind.CODE);
        L2(renderKindU2);
        if (renderKindU2 == RenderKind.HTML || renderKindU2 == RenderKind.FILE) {
            D3();
        } else {
            e2();
        }
        switch (b.$EnumSwitchMapping$1[renderKindU2.ordinal()]) {
            case 1:
            case 2:
            case 3:
                r6.q qVar = this.resultBinding;
                if (qVar == null || (taskWebView = qVar.resultWeb) == null) {
                    C4148a.u(TAG, "renderPart: resultWeb null", false, 4, null);
                    return;
                } else {
                    C3(taskWebView);
                    R1(a10, taskWebView);
                    return;
                }
            case 4:
                r6.q qVar2 = this.resultBinding;
                if (qVar2 == null || (imageView = qVar2.resultImage) == null) {
                    C4148a.u(TAG, "renderPart: resultImage null", false, 4, null);
                    return;
                }
                String fileId2 = a10.getFileId();
                if (fileId2 == null || La.H.x0(fileId2)) {
                    W2(a10);
                    return;
                }
                kotlinx.coroutines.g gVar = this.renderJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                C3(imageView);
                String strO1 = O1(a10);
                if (strO1 != null) {
                    lowerCase = strO1.toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                }
                boolean z10 = !kotlin.jvm.internal.p.d(lowerCase, "svg");
                String cloudPath2 = a10.getCloudPath();
                if (cloudPath2 == null) {
                    cloudPath2 = "";
                }
                s2(imageView, fileId2, cloudPath2, z10);
                return;
            case 5:
                O2(a10);
                return;
            case 6:
                W2(a10);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void W1(Uri uri, boolean success) {
        Object objB;
        int iDelete;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (success) {
                ContentResolver contentResolver = getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", (Integer) 0);
                Y8.t tVar = Y8.t.f7040a;
                iDelete = contentResolver.update(uri, contentValues, null, null);
            } else {
                iDelete = getContentResolver().delete(uri, null, null);
            }
            objB = Result.b(Integer.valueOf(iDelete));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "finalizeGalleryUri failed success=" + success, thE, false, 8, null);
        }
    }

    public final void W2(SessionArtifact a10) {
        ScrollView scrollView;
        TextView textView;
        kotlinx.coroutines.g gVar = this.renderJob;
        String shortFileSize = null;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        e2();
        r6.q qVar = this.resultBinding;
        if (qVar == null || (scrollView = qVar.resultFallbackScroll) == null || qVar == null || (textView = qVar.resultFallback) == null) {
            return;
        }
        C3(scrollView);
        String strS1 = s1(a10);
        Long size = a10.getSize();
        if (size != null) {
            if (size.longValue() <= 0) {
                size = null;
            }
            if (size != null) {
                shortFileSize = Formatter.formatShortFileSize(this, size.longValue());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strS1);
        if (shortFileSize != null && shortFileSize.length() != 0) {
            sb2.append("\n");
            sb2.append(shortFileSize);
        }
        sb2.append("\n\n");
        sb2.append(getString(R$string.task_detail_preview_unsupported));
        textView.setText(sb2.toString());
    }

    public final String X1(SessionArtifact a10) {
        String strO1 = O1(a10);
        if (strO1 == null) {
            return "FILE";
        }
        String upperCase = strO1.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        return upperCase == null ? "FILE" : upperCase;
    }

    public final ChipState X2() {
        return this.chipPendingCard ? ChipState.TAKEOVER : this.chipReplying ? ChipState.EXECUTING : this.chipAwaitingReply ? ChipState.THINKING : ChipState.DONE;
    }

    public final SessionArtifact Y1() {
        return (SessionArtifact) Z8.F.t0(this.versions, this.currentIndex);
    }

    public final void Y2(String seedFileId) {
        if (seedFileId != null) {
            if (La.H.x0(seedFileId)) {
                seedFileId = null;
            }
            if (seedFileId == null) {
                return;
            }
            C1060i.d(C1398p.a(this), null, null, new TaskDetailActivity$resolveVersionGroup$1(this, seedFileId, null), 3, null);
        }
    }

    public final void Z0() {
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout llCurrentStatus = bVar.llCurrentStatus;
        kotlin.jvm.internal.p.h(llCurrentStatus, "llCurrentStatus");
        llCurrentStatus.setVisibility(!this.expanded && A3() ? 0 : 8);
        i1();
    }

    public final String Z1() {
        return (String) this.edgeColorHex.getValue();
    }

    public final void Z2(Uri destUri, p9.p<? super Uri, ? super Boolean, Y8.t> onDone, InterfaceC5074l<? super Uri, Y8.t> write) {
        C1060i.d(C1398p.a(this), Ua.Y.b(), null, new TaskDetailActivity$runDownload$2(write, destUri, onDone, this, null), 2, null);
    }

    public final void a1() {
        TaskWebView taskWebView;
        boolean z10 = this.immersive || this.webviewFullscreen || this.markdownEdgeToEdge;
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        FrameLayout contentHost = bVar.contentHost;
        kotlin.jvm.internal.p.h(contentHost, "contentHost");
        ViewGroup.LayoutParams layoutParams = contentHost.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = z10 ? 0 : this.contentTopInsetPx;
        contentHost.setLayoutParams(marginLayoutParams);
        if (z10) {
            contentHost.setPadding(contentHost.getPaddingLeft(), contentHost.getPaddingTop(), contentHost.getPaddingRight(), 0);
        } else {
            r6.q qVar = this.resultBinding;
            if (qVar != null && (taskWebView = qVar.resultWeb) != null) {
                taskWebView.C();
            }
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.syncContentBottomPadding;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final r a2() {
        return (r) this.moreMenu.getValue();
    }

    public final void a3(DownloadOption option) throws FileStorageException.NotInitialized {
        SessionArtifact artifact = option.getArtifact();
        String strJ = u6.j.INSTANCE.j(artifact.getMimeType());
        if (strJ == null) {
            String strO1 = O1(artifact);
            if (strO1 != null) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                String lowerCase = strO1.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                strJ = singleton.getMimeTypeFromExtension(lowerCase);
            } else {
                strJ = null;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", u1(option));
        if (strJ != null) {
            contentValues.put("mime_type", strJ);
        }
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/AiLauncher");
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert != null) {
            E1(option, uriInsert, new p9.p() { // from class: com.stepos.ailauncher.task.detail.u0
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return TaskDetailActivity.b3(this.f28748a, (Uri) obj, ((Boolean) obj2).booleanValue());
                }
            });
            return;
        }
        C4148a.u(TAG, "saveImageToGallery insert returned null, fallback to SAF", false, 4, null);
        this.pendingDownloadOption = option;
        r2(u1(option));
    }

    public final void b1(HtmlView mode) throws Resources.NotFoundException {
        TaskWebView taskWebView;
        this.htmlView = mode;
        r6.q qVar = this.resultBinding;
        if (qVar == null || (taskWebView = qVar.resultWeb) == null) {
            return;
        }
        HtmlView htmlView = HtmlView.CODE;
        if (mode == htmlView) {
            String str = this.currentHtmlSource;
            if (str == null || str.length() == 0) {
                C4148a.u(TAG, "applyHtmlView CODE ignored: html source not ready", false, 4, null);
                this.htmlView = HtmlView.PREVIEW;
                return;
            } else if (this.codeLoaded) {
                taskWebView.m0();
            } else {
                taskWebView.K(str, "html");
                this.codeLoaded = true;
            }
        } else {
            taskWebView.n0();
        }
        e1(mode == htmlView);
    }

    public final void b2() {
        TaskWebView taskWebView;
        r6.q qVar = this.resultBinding;
        if (qVar == null || (taskWebView = qVar.resultWeb) == null || !taskWebView.D()) {
            if (this.expanded) {
                e3(this, false, false, 2, null);
                return;
            }
            if (this.chatEnabled && this.chipState == ChipState.DONE) {
                J0.INSTANCE.c(this.sessionId);
            }
            r1();
            finishAndRemoveTask();
        }
    }

    public final void c1(androidx.core.view.a0 insets) {
        int i10 = insets.f(a0.o.e()).f41980d;
        int i11 = insets.f(a0.o.b()).f41980d;
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout bottomContainer = bVar.bottomContainer;
        kotlin.jvm.internal.p.h(bottomContainer, "bottomContainer");
        bottomContainer.setPadding(bottomContainer.getPaddingLeft(), bottomContainer.getPaddingTop(), bottomContainer.getPaddingRight(), Math.max(i10, i11));
        this.lastKeyboardUp = C5685n.f(i11 - i10, 0) > 0;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.syncContentBottomPadding;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final boolean c2(androidx.core.view.Z z10) {
        return (z10.d() & a0.o.b()) != 0;
    }

    public final void d1(boolean enable) throws Resources.NotFoundException {
        if (this.immersive == enable) {
            return;
        }
        this.immersive = enable;
        r6.b bVar = null;
        C4148a.k(TAG, "setImmersive " + enable, false, 4, null);
        if (enable) {
            a2().d();
            if (this.expanded) {
                d3(false, false);
            }
        }
        r6.b bVar2 = this.binding;
        if (bVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar2 = null;
        }
        LinearLayout bottomContainer = bVar2.bottomContainer;
        kotlin.jvm.internal.p.h(bottomContainer, "bottomContainer");
        bottomContainer.setVisibility(!enable && this.chatEnabled ? 0 : 8);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.ivFullscreen.setImageResource(enable ? R$drawable.ic_task_detail_fullscreen_exit : R$drawable.ic_task_detail_fullscreen);
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        ConstraintLayout rlTop = bVar4.rlTop;
        kotlin.jvm.internal.p.h(rlTop, "rlTop");
        com.stepos.ailauncher.task.detail.chrome.s.a(rlTop, enable);
        if (enable) {
            r6.b bVar5 = this.binding;
            if (bVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar5 = null;
            }
            ViewGroup.LayoutParams layoutParams = bVar5.rlTop.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null && marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                r6.b bVar6 = this.binding;
                if (bVar6 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    bVar = bVar6;
                }
                bVar.rlTop.setLayoutParams(marginLayoutParams);
            }
        } else {
            r6.b bVar7 = this.binding;
            if (bVar7 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar = bVar7;
            }
            androidx.core.view.N.e0(bVar.rlTop);
        }
        K3();
        a1();
    }

    public final void d2(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class)) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (com.stepos.ailauncher.common.utils.B.INSTANCE.a(currentFocus, ev)) {
                d2(currentFocus);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void e1(boolean enable) {
        if (this.markdownEdgeToEdge == enable) {
            return;
        }
        this.markdownEdgeToEdge = enable;
        a1();
    }

    public final void e2() {
        r6.q qVar = this.resultBinding;
        FrameLayout frameLayout = qVar != null ? qVar.resultRenderMask : null;
        Runnable runnable = this.maskHideRunnable;
        if (runnable != null && frameLayout != null) {
            frameLayout.removeCallbacks(runnable);
        }
        this.maskHideRunnable = null;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void f1(boolean enable) {
        if (this.webviewFullscreen == enable) {
            return;
        }
        this.webviewFullscreen = enable;
        a1();
    }

    public final void f2() {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.chatPanel.setOutlineProvider(new d());
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.drawerHandleArea.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.g2(this.f28499a, view);
            }
        });
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar4;
        }
        bVar2.sheetScrim.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.h2(this.f28501a, view);
            }
        });
        v3();
    }

    public final void g1() {
        this.chatBlurAttached = true;
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.chatPanel.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.p0
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.h1(this.f28663a);
            }
        });
    }

    public final void g3() {
        r6.b bVar = this.binding;
        SessionHandler sessionHandler = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        final LauncherChatLayout taskChatLayout = bVar.taskChatLayout;
        kotlin.jvm.internal.p.h(taskChatLayout, "taskChatLayout");
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R$style.ChatMainActivityTheme);
        taskChatLayout.setAgentUiConfig(new AgentUIConfig.a().c(false).g(R$drawable.bg_task_chat_chip).i(true).d(new C3026z(this)).b(Z8.X.d(Integer.valueOf(R$id.menu_edit))).e(new AgentUIConfig.MessageTextStyle(new AgentUIConfig.TextStyle(h3(contextThemeWrapper, R$attr.color_with_wallpaper_main), 16.0f, 1.28f), new AgentUIConfig.TextStyle(h3(contextThemeWrapper, com.google.android.material.R$attr.colorOnSurface), 16.0f, 1.28f))).a());
        taskChatLayout.setEmptyShowEnable(false);
        taskChatLayout.setOnReceiveMessage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.r0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.i3(this.f28667a, (DisplayMessage) obj);
            }
        });
        taskChatLayout.setOnAskUserInquiry(new p9.r() { // from class: com.stepos.ailauncher.task.detail.C0
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Boolean.valueOf(TaskDetailActivity.j3(this.f28445a, (String) obj, (String) obj2, (List) obj3, (String) obj4));
            }
        });
        taskChatLayout.setOnToolApproval(new p9.s() { // from class: com.stepos.ailauncher.task.detail.F0
            @Override // p9.s
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return Boolean.valueOf(TaskDetailActivity.k3(this.f28451a, taskChatLayout, (String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5));
            }
        });
        SessionHandler sessionHandler2 = this.sessionHandler;
        if (sessionHandler2 == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
        } else {
            sessionHandler = sessionHandler2;
        }
        taskChatLayout.k3(sessionHandler);
    }

    public final void i1() {
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        final LinearLayout llCurrentStatus = bVar.llCurrentStatus;
        kotlin.jvm.internal.p.h(llCurrentStatus, "llCurrentStatus");
        if (this.chipGlassHandle == null && llCurrentStatus.getVisibility() == 0) {
            llCurrentStatus.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.M
                @Override // java.lang.Runnable
                public final void run() {
                    TaskDetailActivity.j1(this.f28469a, llCurrentStatus);
                }
            });
        }
    }

    public final void i2() {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        TaskInputView taskInputView = bVar.inputViewTask;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
            sessionHandler = null;
        }
        taskInputView.setSessionHandler(sessionHandler);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.inputViewTask.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.O
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.j2(this.f28476a);
            }
        });
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        bVar4.inputViewTask.setOnSendInitiated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.P
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.k2(this.f28481a);
            }
        });
        r6.b bVar5 = this.binding;
        if (bVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar5 = null;
        }
        bVar5.inputViewTask.setOnStopClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.Q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(TaskDetailActivity.l2(this.f28483a));
            }
        });
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.chatSpectrumController;
        if (cVar != null) {
            cVar.h();
        }
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        this.chatSpectrumController = new com.stepos.ailauncher.chat.wake.effect.c(decorView, new SpectrumBorderConfig(1.8f, 0.045f, 0.12f, 0.5f, 1.8f, 0.045f, 0.12f, 0.5f));
        r6.b bVar6 = this.binding;
        if (bVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar6 = null;
        }
        bVar6.inputViewTask.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.m2(this.f28488a, ((Boolean) obj).booleanValue());
            }
        });
        r6.b bVar7 = this.binding;
        if (bVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar7 = null;
        }
        bVar7.inputViewTask.setOnVoiceLongPressVisualChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.n2(this.f28489a, ((Boolean) obj).booleanValue());
            }
        });
        r6.b bVar8 = this.binding;
        if (bVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar8;
        }
        bVar2.inputViewTask.setOnSpeechCancelStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.o2(this.f28492a, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void k1() {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        final LinearLayout bottomContainer = bVar.bottomContainer;
        kotlin.jvm.internal.p.h(bottomContainer, "bottomContainer");
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        final FrameLayout contentHost = bVar3.contentHost;
        kotlin.jvm.internal.p.h(contentHost, "contentHost");
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar4;
        }
        final ChatRecycleView messageList = bVar2.taskChatLayout.getMessageList();
        final InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.G0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDetailActivity.l1(bottomContainer, this, messageList, contentHost);
            }
        };
        this.syncContentBottomPadding = interfaceC5063a;
        bottomContainer.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.H0
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.m1(interfaceC5063a);
            }
        });
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.I0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                TaskDetailActivity.n1(interfaceC5063a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.bottomContainerLayoutChangeListener = onLayoutChangeListener;
        bottomContainer.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final void m3() {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.n3(this.f28444a, view);
            }
        });
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.ivBack.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.D
            @Override // java.lang.Runnable
            public final void run() {
                TaskDetailActivity.o3(this.f28446a);
            }
        });
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        bVar4.ivPartPrev.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.p3(this.f28448a, view);
            }
        });
        r6.b bVar5 = this.binding;
        if (bVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar5 = null;
        }
        bVar5.ivPartNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.q3(this.f28450a, view);
            }
        });
        r6.b bVar6 = this.binding;
        if (bVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar6 = null;
        }
        bVar6.ivDownload.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws FileStorageException.NotInitialized {
                TaskDetailActivity.r3(this.f28453a, view);
            }
        });
        r6.b bVar7 = this.binding;
        if (bVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar7 = null;
        }
        bVar7.ivFullscreen.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                TaskDetailActivity.s3(this.f28458a, view);
            }
        });
        r6.b bVar8 = this.binding;
        if (bVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar8;
        }
        bVar2.ivMore.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailActivity.t3(this.f28460a, view);
            }
        });
        getOnBackInvokedDispatcher().registerOnBackInvokedCallback(1000, new OnBackInvokedCallback() { // from class: com.stepos.ailauncher.task.detail.K
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                TaskDetailActivity.u3(this.f28463a);
            }
        });
    }

    public final void o1() {
        r6.b bVar = this.binding;
        r6.b bVar2 = null;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        androidx.core.view.N.u0(bVar.rlTop, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.detail.W
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return TaskDetailActivity.p1(view, a0Var);
            }
        });
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.X
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                TaskDetailActivity.q1(this.f28497a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.topBarLayoutChangeListener = onLayoutChangeListener;
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            bVar2 = bVar3;
        }
        bVar2.rlTop.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        r6.b bVarC = r6.b.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(bVarC, "inflate(...)");
        this.binding = bVarC;
        r6.b bVar = null;
        if (bVarC == null) {
            kotlin.jvm.internal.p.A("binding");
            bVarC = null;
        }
        setContentView(bVarC.b());
        z3();
        ArtifactDetailIntent artifactDetailIntent = ArtifactDetailIntent.INSTANCE;
        Intent intent = getIntent();
        kotlin.jvm.internal.p.h(intent, "getIntent(...)");
        SessionArtifact sessionArtifactArtifactOf = artifactDetailIntent.artifactOf(intent);
        Intent intent2 = getIntent();
        kotlin.jvm.internal.p.h(intent2, "getIntent(...)");
        this.restoreWakeChat = artifactDetailIntent.restoreWakeChatOf(intent2);
        Z3.INSTANCE.c(this);
        r6.b bVar2 = this.binding;
        if (bVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar2 = null;
        }
        View viewInflate = bVar2.stubResultContent.inflate();
        this.resultContentView = viewInflate;
        kotlin.jvm.internal.p.f(viewInflate);
        this.resultBinding = r6.q.a(viewInflate);
        O3();
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams = bVar3.contentHost.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.contentTopInsetPx = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        o1();
        m3();
        if (sessionArtifactArtifactOf == null) {
            C4148a.u(TAG, "onCreate: no artifact in intent, show fallback", false, 4, null);
            r6.b bVar4 = this.binding;
            if (bVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar = bVar4;
            }
            LinearLayout bottomContainer = bVar.bottomContainer;
            kotlin.jvm.internal.p.h(bottomContainer, "bottomContainer");
            bottomContainer.setVisibility(8);
            B3(R$string.task_detail_completed_no_result);
            return;
        }
        this.versions = C1172u.e(sessionArtifactArtifactOf);
        this.currentIndex = 0;
        this.taskId = sessionArtifactArtifactOf.getTaskId();
        String sessionId = sessionArtifactArtifactOf.getSessionId();
        if (sessionId == null) {
            sessionId = "";
        }
        this.sessionId = sessionId;
        this.chatEnabled = sessionId.length() > 0;
        C4148a.k(TAG, "onCreate seed fileId=" + sessionArtifactArtifactOf.getFileId() + " taskId=" + this.taskId + " sessionId=" + this.sessionId + " chatEnabled=" + this.chatEnabled, false, 4, null);
        k1();
        if (this.chatEnabled) {
            y1(this.sessionId);
            f2();
            x3();
            i2();
            g3();
            J2();
            d3(false, false);
        } else {
            r6.b bVar5 = this.binding;
            if (bVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar5 = null;
            }
            LinearLayout bottomContainer2 = bVar5.bottomContainer;
            kotlin.jvm.internal.p.h(bottomContainer2, "bottomContainer");
            bottomContainer2.setVisibility(8);
            r6.b bVar6 = this.binding;
            if (bVar6 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar6 = null;
            }
            LinearLayout chatPanel = bVar6.chatPanel;
            kotlin.jvm.internal.p.h(chatPanel, "chatPanel");
            chatPanel.setVisibility(8);
            r6.b bVar7 = this.binding;
            if (bVar7 == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar7 = null;
            }
            View sheetScrim = bVar7.sheetScrim;
            kotlin.jvm.internal.p.h(sheetScrim, "sheetScrim");
            sheetScrim.setVisibility(8);
        }
        M5.c cVar = M5.c.INSTANCE;
        String str = this.sessionId;
        String str2 = str.length() > 0 ? str : null;
        Intent intent3 = getIntent();
        kotlin.jvm.internal.p.h(intent3, "getIntent(...)");
        M5.c.k(cVar, sessionArtifactArtifactOf, str2, artifactDetailIntent.sourceOf(intent3), null, null, 24, null);
        F3(this.currentIndex);
        Y2(sessionArtifactArtifactOf.getFileId());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        com.stepos.ailauncher.common.utils.y.INSTANCE.g(TAG);
        if (!isChangingConfigurations()) {
            InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        }
        M2();
        w1();
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        if (ArtifactDetailIntent.INSTANCE.artifactOf(intent) == null) {
            C4148a.u(TAG, "onNewIntent ignored: no artifact", false, 4, null);
        } else {
            setIntent(intent);
            recreate();
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        com.stepos.ailauncher.common.utils.y.INSTANCE.g(TAG);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        com.stepos.ailauncher.common.utils.y.INSTANCE.i(TAG);
        if (this.chatEnabled) {
            r6.b bVar = this.binding;
            r6.b bVar2 = null;
            if (bVar == null) {
                kotlin.jvm.internal.p.A("binding");
                bVar = null;
            }
            bVar.inputViewTask.Q8();
            r6.b bVar3 = this.binding;
            if (bVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                bVar2 = bVar3;
            }
            bVar2.inputViewTask.setInputBarGlassEnabledRuntime(true);
        }
    }

    public final boolean p2(SessionArtifact a10) {
        String strO1;
        if (U2(a10) == RenderKind.IMAGE && (strO1 = O1(a10)) != null) {
            String lowerCase = strO1.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return GALLERY_IMAGE_EXTS.contains(lowerCase);
            }
        }
        return false;
    }

    public final boolean q2(SessionArtifact a10) {
        String lowerCase;
        Set setJ = Z8.Y.j(ChatTracker.CONTENT_PPT, "pptx");
        String strO1 = O1(a10);
        if (strO1 != null) {
            lowerCase = strO1.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return Z8.F.f0(setJ, lowerCase);
    }

    public final void r1() {
        if (this.restoreWakeChat) {
            String str = this.sessionId;
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                WakeService.Companion companion = WakeService.INSTANCE;
                Context applicationContext = getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                companion.V1(applicationContext, str);
            }
        }
    }

    public final void r2(String fileName) {
        this.pendingSaveMime = x2(fileName);
        overrideActivityTransition(0, R.anim.fade_in, R.anim.fade_out);
        overrideActivityTransition(1, R.anim.fade_in, R.anim.fade_out);
        this.saveLauncher.a(fileName);
    }

    public final String s1(SessionArtifact a10) {
        String title = a10.getTitle();
        if (title != null) {
            if (La.H.x0(title)) {
                title = null;
            }
            if (title != null) {
                return title;
            }
        }
        String strP1 = P1(a10.getMimeType());
        if (strP1 == null) {
            strP1 = "bin";
        }
        return "result." + strP1;
    }

    public final void s2(final ImageView image, final String fileId, final String rawContent, final boolean preferRgb565) {
        final String strA = C5578a.INSTANCE.a(fileId);
        u6.i.h(u6.i.INSTANCE, fileId, false, new p9.p() { // from class: com.stepos.ailauncher.task.detail.v0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return TaskDetailActivity.t2(this.f28753a, image, strA, preferRgb565, (String) obj, (InterfaceC5063a) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskDetailActivity.u2(fileId, this, image, rawContent, strA, preferRgb565, (Throwable) obj);
            }
        }, 2, null);
    }

    public final List<DownloadOption> t1(SessionArtifact current) {
        DownloadOption downloadOption = new DownloadOption(X1(current), current, false, 4, null);
        String fileId = current.getFileId();
        return (fileId == null || La.H.x0(fileId) || !q2(current)) ? C1172u.e(downloadOption) : C1173v.p(downloadOption, new DownloadOption("PDF", current, true));
    }

    public final String u1(DownloadOption option) {
        return u6.j.INSTANCE.b("", option.getArtifact().getTitle(), option.getArtifact().getFileName(), option.getArtifact().getMimeType(), option.getArtifact().getCloudPath(), System.currentTimeMillis(), option.getAsPdfFromPreview() ? "pdf" : null);
    }

    public final void v1() {
        r6.q qVar;
        TaskWebView taskWebView;
        Runnable runnable = this.htmlFallbackRunnable;
        if (runnable != null && (qVar = this.resultBinding) != null && (taskWebView = qVar.resultWeb) != null) {
            taskWebView.removeCallbacks(runnable);
        }
        this.htmlFallbackRunnable = null;
    }

    public final void v2(ImageView image, Object data, String cacheKey, InterfaceC5063a<Y8.t> onFailRetry, boolean preferRgb565) {
        coil.c cVarC = com.stepos.ailauncher.task.common.h.INSTANCE.c();
        g.a aVarR = new g.a(image.getContext()).d(data).r(image);
        if (preferRgb565) {
            aVarR.b(Bitmap.Config.RGB_565);
        }
        if (cacheKey != null) {
            aVarR.j(cacheKey);
            aVarR.f(cacheKey);
        }
        aVarR.h(new f(onFailRetry, this));
        cVarC.c(aVarR.c());
    }

    public final void v3() {
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.drawerHandleArea.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.task.detail.f0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TaskDetailActivity.w3(this.f28576a, view, motionEvent);
            }
        });
    }

    public final void w1() {
        TaskWebView taskWebView;
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.sheetMaterialHandle);
        SessionHandler sessionHandler = null;
        this.sheetMaterialHandle = null;
        hVar.F(this.backGlassHandle);
        this.backGlassHandle = null;
        hVar.F(this.versionGlassHandle);
        this.versionGlassHandle = null;
        hVar.F(this.actionGlassHandle);
        this.actionGlassHandle = null;
        hVar.F(this.chipGlassHandle);
        this.chipGlassHandle = null;
        a2().d();
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.chatSpectrumController;
        if (cVar != null) {
            cVar.h();
        }
        this.chatSpectrumController = null;
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        bVar.inputViewTask.setOnVoiceLongPressVisualChanged(null);
        this.currentHtmlSource = null;
        r6.b bVar2 = this.binding;
        if (bVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar2 = null;
        }
        bVar2.inputViewTask.setInputBarGlassEnabledRuntime(false);
        r6.b bVar3 = this.binding;
        if (bVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar3 = null;
        }
        bVar3.taskChatLayout.O8();
        E7.a aVar = this.scrollBtnFloatHandle;
        if (aVar != null) {
            aVar.a();
        }
        this.scrollBtnFloatHandle = null;
        r6.q qVar = this.resultBinding;
        if (qVar != null && (taskWebView = qVar.resultWeb) != null) {
            ViewParent parent = taskWebView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(taskWebView);
            }
            taskWebView.F();
        }
        this.resultContentView = null;
        this.resultBinding = null;
        this.currentHtmlUrl = null;
        Z3.INSTANCE.b();
        this.maskHideRunnable = null;
        this.syncContentBottomPadding = null;
        this.bottomContainerLayoutChangeListener = null;
        r6.b bVar4 = this.binding;
        if (bVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar4 = null;
        }
        bVar4.taskChatLayout.L3();
        SessionHandler sessionHandler2 = this.sessionHandler;
        if (sessionHandler2 != null) {
            if (sessionHandler2 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler2 = null;
            }
            SessionHandler sessionHandler3 = this.sessionHandler;
            if (sessionHandler3 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler3 = null;
            }
            sessionHandler2.N3(sessionHandler3.new g());
            SessionHandler sessionHandler4 = this.sessionHandler;
            if (sessionHandler4 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler4 = null;
            }
            SessionHandler sessionHandler5 = this.sessionHandler;
            if (sessionHandler5 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler5 = null;
            }
            sessionHandler4.L3(sessionHandler5.new f());
            SessionHandler sessionHandler6 = this.sessionHandler;
            if (sessionHandler6 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler6 = null;
            }
            sessionHandler6.M3(null);
            SessionHandler sessionHandler7 = this.sessionHandler;
            if (sessionHandler7 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler7 = null;
            }
            SessionHandler sessionHandler8 = this.sessionHandler;
            if (sessionHandler8 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler8 = null;
            }
            sessionHandler7.E3(sessionHandler8.new d());
            SessionHandler sessionHandler9 = this.sessionHandler;
            if (sessionHandler9 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler9 = null;
            }
            sessionHandler9.K3(new SessionHandler.e());
            SessionHandler sessionHandler10 = this.sessionHandler;
            if (sessionHandler10 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler10 = null;
            }
            sessionHandler10.Q3(new SessionHandler.h());
            SessionHandler sessionHandler11 = this.sessionHandler;
            if (sessionHandler11 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler11 = null;
            }
            sessionHandler11.J3(null);
            SessionHandler sessionHandler12 = this.sessionHandler;
            if (sessionHandler12 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler12 = null;
            }
            sessionHandler12.G3(null);
            SessionHandler sessionHandler13 = this.sessionHandler;
            if (sessionHandler13 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler13 = null;
            }
            sessionHandler13.b3(null);
            SessionHandler sessionHandler14 = this.sessionHandler;
            if (sessionHandler14 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler14 = null;
            }
            sessionHandler14.c3(null);
            SessionHandler sessionHandler15 = this.sessionHandler;
            if (sessionHandler15 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
            } else {
                sessionHandler = sessionHandler15;
            }
            sessionHandler.d3();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0181 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String x1(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.x1(java.lang.String):java.lang.String");
    }

    public final String x2(String fileName) {
        String strH = u6.j.INSTANCE.h(fileName);
        if (strH == null) {
            return "application/octet-stream";
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = strH.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    public final void x3() {
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        LinearLayout bottomContainer = bVar.bottomContainer;
        kotlin.jvm.internal.p.h(bottomContainer, "bottomContainer");
        androidx.core.view.N.u0(bottomContainer, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.detail.z
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return TaskDetailActivity.y3(this.f28766a, view, a0Var);
            }
        });
        androidx.core.view.N.E0(bottomContainer, new i(bottomContainer));
    }

    public final void y1(String sessionKey) {
        SessionHandler sessionHandler = new SessionHandler(Configuration.INSTANCE.a("agent_bus").a(C1963x.AGENT_TYPE_AGENTBUS).e(sessionKey).c(false).b());
        this.sessionHandler = sessionHandler;
        sessionHandler.L3(new c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x011d, code lost:
    
        if (com.stepos.ailauncher.task.detail.TaskDetailActivity.PREVIEWABLE_DOC_EXTS.contains(r4) == true) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.task.detail.TaskDetailActivity.RenderKind y2(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.TaskDetailActivity.y2(java.lang.String):com.stepos.ailauncher.task.detail.TaskDetailActivity$RenderKind");
    }

    public final void z3() {
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        Window window = getWindow();
        r6.b bVar = this.binding;
        if (bVar == null) {
            kotlin.jvm.internal.p.A("binding");
            bVar = null;
        }
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(window, bVar.b());
        b0Var.e(false);
        b0Var.d(false);
    }
}
