package com.stepos.ailauncher.chat.controller;

import L4.AgentPlace;
import L4.AnimationInfo;
import L4.b;
import L4.l;
import L4.o;
import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.agentframework.util.C2154c;
import com.stepos.agentframework.util.E;
import com.stepos.agentsprite.view.AgentView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.SessionItem;
import com.stepos.ailauncher.chat.controller.ActiveConversationManager;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatAction;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.C2963t;
import com.stepos.ailauncher.chat.view.C2996w;
import com.stepos.ailauncher.chat.view.C3016y;
import com.stepos.ailauncher.chat.view.C5;
import com.stepos.ailauncher.chat.view.ChatHistoryView;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.view.MainInputView;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import com.stepos.ailauncher.chat.wake.ChatEntrySource;
import com.stepos.ailauncher.chat.wake.ExternalSessionRef;
import com.stepos.ailauncher.chat.wake.InstalledAgentRef;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageResumeReason;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import com.stepos.ailauncher.contract.model.search.TaskSearchHit;
import com.stepos.ailauncher.sla.C3475d;
import h8.C4148a;
import h9.InterfaceC4149a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import o5.ChatLaunchPayload;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;
import v9.C5685n;

@Metadata(d1 = {"\u0000ª\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f*\u0002²\u0002\u0018\u0000 Ý\u00022\u00020\u0001:\u0004Þ\u0002ß\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\f¢\u0006\u0004\b!\u0010 J\u0015\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000f¢\u0006\u0004\b)\u0010\u0014J\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010 J\r\u0010+\u001a\u00020\f¢\u0006\u0004\b+\u0010 J\u0015\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\f2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020\"¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\f¢\u0006\u0004\b3\u0010 J\u001d\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u0004\u0018\u000109*\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010;J!\u0010?\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\b?\u0010@JK\u0010E\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010<2\b\u0010B\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010C\u001a\u00020<2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\bE\u0010FJ9\u0010G\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010<2\b\u0010B\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010C\u001a\u00020<2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010 J+\u0010K\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010<2\b\u0010B\u001a\u0004\u0018\u00010<2\u0006\u0010J\u001a\u00020<H\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\"2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\"H\u0002¢\u0006\u0004\bR\u0010%J\u0017\u0010U\u001a\u00020\f2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\f2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bW\u0010VJ\u0017\u0010Y\u001a\u00020\f2\u0006\u0010T\u001a\u00020XH\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\f2\u0006\u0010T\u001a\u00020XH\u0002¢\u0006\u0004\b[\u0010ZJ\u0017\u0010]\u001a\u00020\f2\u0006\u0010T\u001a\u00020\\H\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\f2\u0006\u0010T\u001a\u00020\\H\u0002¢\u0006\u0004\b_\u0010^J\u000f\u0010`\u001a\u00020\fH\u0002¢\u0006\u0004\b`\u0010 J\u000f\u0010a\u001a\u00020\fH\u0002¢\u0006\u0004\ba\u0010 J\u0011\u0010c\u001a\u0004\u0018\u00010bH\u0002¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\fH\u0002¢\u0006\u0004\be\u0010 J\u000f\u0010f\u001a\u00020\fH\u0002¢\u0006\u0004\bf\u0010 J)\u0010g\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u00100\u001a\u00020\"H\u0002¢\u0006\u0004\bg\u0010hJ\u0019\u0010i\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\"H\u0002¢\u0006\u0004\bi\u0010%J)\u0010k\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0006\u0010j\u001a\u00020<2\b\b\u0002\u00100\u001a\u00020\"H\u0002¢\u0006\u0004\bk\u0010lJ#\u0010p\u001a\u00020\f2\b\u0010n\u001a\u0004\u0018\u00010m2\b\b\u0002\u0010o\u001a\u00020\u000fH\u0002¢\u0006\u0004\bp\u0010qJ/\u0010u\u001a\u00020\f2\u0006\u0010B\u001a\u00020<2\u0006\u0010r\u001a\u00020<2\u0006\u0010s\u001a\u00020<2\u0006\u0010t\u001a\u00020\u000fH\u0002¢\u0006\u0004\bu\u0010vJ'\u0010x\u001a\u00020\f2\u0006\u0010w\u001a\u00020<2\u0006\u0010J\u001a\u00020<2\u0006\u0010t\u001a\u00020\u000fH\u0002¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\fH\u0002¢\u0006\u0004\bz\u0010 J\u0017\u0010{\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020<H\u0002¢\u0006\u0004\b{\u0010|J\u000f\u0010}\u001a\u00020\fH\u0002¢\u0006\u0004\b}\u0010 J\u000f\u0010~\u001a\u00020\fH\u0002¢\u0006\u0004\b~\u0010 J\u000f\u0010\u007f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u007f\u0010\u0014J\u001a\u0010\u0081\u0001\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0081\u0001\u0010\u0012J\u0011\u0010\u0082\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0082\u0001\u0010 J\u0011\u0010\u0083\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0083\u0001\u0010 J\u001a\u0010\u0085\u0001\u001a\u00020\f2\u0007\u0010\u0084\u0001\u001a\u00020\"H\u0002¢\u0006\u0005\b\u0085\u0001\u0010%J\u001b\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0089\u0001\u0010 J\u001c\u0010\u008c\u0001\u001a\u00020\f2\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0011\u0010\u008e\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u008e\u0001\u0010 J\u001c\u0010\u0091\u0001\u001a\u00020\f2\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J#\u0010\u0096\u0001\u001a\u00020\f2\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u0001H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0098\u0001\u0010 J\u0011\u0010\u0099\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0099\u0001\u0010 J\u001a\u0010\u009b\u0001\u001a\u00020\f2\u0007\u0010\u009a\u0001\u001a\u00020<H\u0002¢\u0006\u0005\b\u009b\u0001\u0010|J\u001c\u0010\u009d\u0001\u001a\u00020\f2\b\u0010\u009c\u0001\u001a\u00030\u0094\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009f\u0001\u0010 J\u0011\u0010 \u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b \u0001\u0010 J0\u0010£\u0001\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0014\u0010¢\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0¡\u0001H\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0011\u0010¥\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¥\u0001\u0010 J\u0011\u0010¦\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¦\u0001\u0010 J\u0011\u0010§\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b§\u0001\u0010 J\u001a\u0010©\u0001\u001a\u00020\f2\u0007\u0010¨\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b©\u0001\u0010\u0012J\u0011\u0010ª\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bª\u0001\u0010 J\u0012\u0010«\u0001\u001a\u00020\"H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0011\u0010\u00ad\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u00ad\u0001\u0010 J\u0011\u0010®\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b®\u0001\u0010 J\u001a\u0010¯\u0001\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001c\u0010³\u0001\u001a\u00020\f2\b\u0010²\u0001\u001a\u00030±\u0001H\u0002¢\u0006\u0006\b³\u0001\u0010´\u0001J,\u0010µ\u0001\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\b\u0010²\u0001\u001a\u00030±\u0001H\u0002¢\u0006\u0006\bµ\u0001\u0010¶\u0001J!\u0010·\u0001\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0002¢\u0006\u0005\b·\u0001\u00108J,\u0010º\u0001\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\b\u0010¹\u0001\u001a\u00030¸\u0001H\u0002¢\u0006\u0006\bº\u0001\u0010»\u0001J\u001e\u0010¾\u0001\u001a\u00020\f2\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001J'\u0010Á\u0001\u001a\u00020\f2\u0007\u0010À\u0001\u001a\u00020<2\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u001e\u0010Ã\u0001\u001a\u00020\f2\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0002¢\u0006\u0006\bÃ\u0001\u0010¿\u0001J\u001a\u0010Å\u0001\u001a\u00020\f2\u0007\u0010Ä\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÅ\u0001\u0010\u0012J\u001e\u0010Æ\u0001\u001a\u00020\f2\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0002¢\u0006\u0006\bÆ\u0001\u0010¿\u0001J<\u0010É\u0001\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0007\u0010Ç\u0001\u001a\u00020<2\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u001c\u0010Í\u0001\u001a\u00020\f2\b\u0010Ì\u0001\u001a\u00030Ë\u0001H\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u001c\u0010Ð\u0001\u001a\u00020\f2\b\u0010Ì\u0001\u001a\u00030Ï\u0001H\u0002¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u0011\u0010Ò\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÒ\u0001\u0010 J\u0011\u0010Ó\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÓ\u0001\u0010 J\u0011\u0010Ô\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÔ\u0001\u0010 J\u0011\u0010Õ\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÕ\u0001\u0010 J\u0011\u0010Ö\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÖ\u0001\u0010 J\u0011\u0010×\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b×\u0001\u0010 J\u001a\u0010Ù\u0001\u001a\u00020\f2\u0007\u0010Ø\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÙ\u0001\u0010\u0012J\u0011\u0010Ú\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\bÚ\u0001\u0010 J\u001a\u0010Ü\u0001\u001a\u00020\f2\u0007\u0010Û\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\bÜ\u0001\u0010\u0012J\u001c\u0010Þ\u0001\u001a\u00020\f2\b\u0010Ý\u0001\u001a\u00030±\u0001H\u0002¢\u0006\u0006\bÞ\u0001\u0010´\u0001J\u0013\u0010à\u0001\u001a\u00030ß\u0001H\u0002¢\u0006\u0006\bà\u0001\u0010á\u0001J\"\u0010ã\u0001\u001a\u00020\f2\u000e\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020<0\u0093\u0001H\u0002¢\u0006\u0006\bã\u0001\u0010\u0097\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010ä\u0001R\u001b\u0010å\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010ç\u0001\u001a\u0005\u0018\u00010ß\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u001b\u0010é\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001b\u0010ë\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001c\u0010î\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u0019\u0010ð\u0001\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u0019\u0010ò\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001f\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030í\u00010ô\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u001c\u0010÷\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ï\u0001R\u001c\u0010ø\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ï\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ï\u0001R\u001c\u0010û\u0001\u001a\u0005\u0018\u00010ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001c\u0010þ\u0001\u001a\u0005\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u001a\u0010\u0088\u0002\u001a\u00030\u0087\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0089\u0002R\u0019\u0010\u008a\u0002\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010ñ\u0001R\u001c\u0010\u008b\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u0081\u0002R\u001c\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u0084\u0002R\u001c\u0010\u008d\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u0081\u0002R\u001c\u0010\u008e\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u0081\u0002R\u001c\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0084\u0002R!\u0010\u0091\u0002\u001a\n\u0012\u0005\u0012\u00030\u0090\u00020\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010ö\u0001R\u001c\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0092\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0019\u0010\u0095\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010ó\u0001R\u001c\u0010\u0096\u0002\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001c\u0010\u0098\u0002\u001a\u0005\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010ÿ\u0001R\u001c\u0010\u0099\u0002\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u0097\u0002R\u0018\u0010\u009b\u0002\u001a\u00030\u009a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001c\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001c\u0010¡\u0002\u001a\u0005\u0018\u00010 \u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R\u0019\u0010£\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010ó\u0001R\u0019\u0010¤\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010ó\u0001R\u001b\u0010¥\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010ê\u0001R\u001b\u0010¦\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010ê\u0001R\u001b\u0010§\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010ê\u0001R\u0019\u0010¨\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010ó\u0001R\u0018\u0010ª\u0002\u001a\u00030©\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0002\u0010«\u0002R%\u0010\u00ad\u0002\u001a\u0010\u0012\u0005\u0012\u00030¬\u0002\u0012\u0004\u0012\u00020\f0¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u001b\u0010¯\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010ê\u0001R\u0019\u0010°\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010ó\u0001R\u001b\u0010±\u0002\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010ê\u0001R\u0018\u0010³\u0002\u001a\u00030²\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0002\u0010´\u0002R\u0019\u0010µ\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010ó\u0001R\u0019\u0010¶\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010ó\u0001R\u0019\u0010·\u0002\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010ñ\u0001R\u0019\u0010¸\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010ó\u0001R\u001c\u0010º\u0002\u001a\u0005\u0018\u00010¹\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010»\u0002R\u001a\u0010½\u0002\u001a\u00030¼\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u0018\u0010À\u0002\u001a\u00030¿\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R\u001c\u0010Ã\u0002\u001a\u0005\u0018\u00010Â\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R#\u0010Å\u0002\u001a\f\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010ö\u0001R\u0018\u0010Ç\u0002\u001a\u00030Æ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010É\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010Ë\u0002R\u001c\u0010Í\u0002\u001a\u0005\u0018\u00010Ì\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0002\u0010Î\u0002R\u001c\u0010Ï\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010\u0081\u0002R\u001c\u0010Ð\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010\u0081\u0002R\u001c\u0010Ñ\u0002\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010\u0097\u0002R\u001c\u0010Ò\u0002\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010\u0097\u0002R\u001c\u0010Ó\u0002\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0002\u0010\u0081\u0002R\u001c\u0010Õ\u0002\u001a\u0005\u0018\u00010Ô\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010Ö\u0002R\u001c\u0010×\u0002\u001a\u0005\u0018\u00010É\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0002\u0010Ë\u0002R\u0018\u0010Ø\u0002\u001a\u00030¿\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0002\u0010Á\u0002R \u0010Ü\u0002\u001a\u000b Ù\u0002*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004¢\u0006\b\u001a\u0006\bÚ\u0002\u0010Û\u0002¨\u0006à\u0002"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/AgentSpaceController;", "", "Lcom/stepos/ailauncher/chat/view/y;", "view", "<init>", "(Lcom/stepos/ailauncher/chat/view/y;)V", "Landroid/content/Context;", "Landroidx/lifecycle/LifecycleOwner;", "A1", "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "LY8/t;", "S2", "(Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "", x5.d.EXTRA_ENABLED, "N3", "(Z)V", "B2", "()Z", "Lo5/e;", "payload", "Landroid/os/ResultReceiver;", "receiver", "c1", "(Lo5/e;Landroid/os/ResultReceiver;)V", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "reason", "V2", "(Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;)V", "U2", "()V", "X2", "", "level", "b3", "(I)V", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "T2", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", "M2", "R2", "N2", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "action", "n3", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;)V", "attempt", "p3", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;I)V", "w1", "", "rawX", "rawY", "r4", "(FF)Z", "Landroid/app/Activity;", "y1", "(Landroid/content/Context;)Landroid/app/Activity;", "", "sessionId", "closeDrawer", "n1", "(Ljava/lang/String;Z)Z", "agentId", "deviceId", "agentLabel", "deviceOnline", "o1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)Z", "j1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "F1", "displayName", "u4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;", "kind", "m1", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;)I", "hintRes", "T3", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$DisabledInfo;", "info", "V3", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$DisabledInfo;)V", "O2", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$UpdateInfo;", "d4", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$UpdateInfo;)V", "c3", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ReinstallInfo;", "X3", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ReinstallInfo;)V", "Y2", "u3", "I1", "", "L2", "()Ljava/lang/Long;", "y3", "j4", "x2", "(Lo5/e;Landroid/os/ResultReceiver;I)V", "I3", "fileId", "E3", "(Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "source", "onlyIfAbsent", "G2", "(Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;Z)V", "agentType", "deviceName", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "g3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "assetId", "i3", "(Ljava/lang/String;Ljava/lang/String;Z)V", "H3", "v3", "(Ljava/lang/String;)V", "w3", "z3", "i4", "isEmpty", "h1", "m4", "K1", "targetDp", "Z0", "imeVisible", "q1", "(Z)I", "e1", "Lcom/stepos/ailauncher/chat/controller/AgentSpaceController$HomeContentTier;", "tier", "f1", "(Lcom/stepos/ailauncher/chat/controller/AgentSpaceController$HomeContentTier;)V", "r2", "Lu4/m$d;", "tree", "f3", "(Lu4/m$d;)V", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifacts", "S3", "(Ljava/util/List;)V", "V1", "o4", "status", "x3", "artifact", "m3", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "s2", "X1", "Lkotlin/Function1;", "callback", "v1", "(Ljava/lang/String;Lp9/l;)V", "f4", "r1", "g4", "visible", "O3", "b1", "t3", "()I", "D1", "F2", "A2", "(F)Z", "Landroid/view/View;", "target", "E1", "(Landroid/view/View;)V", "C2", "(FFLandroid/view/View;)Z", "E2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "D2", "(FFLandroidx/recyclerview/widget/RecyclerView;)Z", "Lcom/stepos/ailauncher/chat/view/ChatHistoryView;", "historyView", "k2", "(Lcom/stepos/ailauncher/chat/view/ChatHistoryView;)V", "keyword", "i1", "(Ljava/lang/String;Lcom/stepos/ailauncher/chat/view/ChatHistoryView;)V", "x1", "searching", "P3", "Z3", "entryType", "agentName", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", com.stepos.ailauncher.sla.G.JUDGE_HIT, "k3", "(Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;)V", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "l3", "(Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;)V", "U1", "G1", "l1", "s4", "h4", "C1", "external", "M3", "B1", "keyboardShown", "t4", LinkHeader.Parameters.Anchor, SdCardDbCreator.FIELD_LASTLOC_NB, "Landroid/widget/PopupWindow;", "s1", "()Landroid/widget/PopupWindow;", "suggestions", "Q3", "Lcom/stepos/ailauncher/chat/view/y;", "cachedNavigationBarHeight", "Ljava/lang/Integer;", "sessionListPopup", "Landroid/widget/PopupWindow;", "sessionListLayerId", "Ljava/lang/String;", "overlayHost", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "Ly7/E;", "btnAppsMaterialHandle", "Ly7/E;", "pageResumeElapsedMs", "J", "homeLeaveReported", "Z", "", "topBarGlassHandles", "Ljava/util/List;", "searchBoxGlassHandle", "panelNewSessionGlassHandle", "newChatPillGlassHandle", "Lcom/stepos/ailauncher/chat/view/ChatView;", "chatView", "Lcom/stepos/ailauncher/chat/view/ChatView;", "Landroid/widget/LinearLayout;", "contentContainer", "Landroid/widget/LinearLayout;", "agentSpaceContent", "Landroid/view/View;", "Landroid/widget/TextView;", "tvGreeting", "Landroid/widget/TextView;", "homeTier", "Lcom/stepos/ailauncher/chat/controller/AgentSpaceController$HomeContentTier;", "Landroid/widget/ImageView;", "btnNewSession", "Landroid/widget/ImageView;", "lastNewSessionClickElapsedMs", "rightBtnGroup", "tvSubtitle", "topBar", "titleDropdownArea", "tvTitle", "Lcom/stepos/ailauncher/chat/adapter/U;", "sessionItems", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager;", "conversationManager", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager;", "lockScreenMode", "suggestionsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recommendContainer", "recommendRecyclerView", "Lcom/stepos/ailauncher/chat/view/C5;", "recommendSnapHelper", "Lcom/stepos/ailauncher/chat/view/C5;", "LL4/b;", "agentCtrl", "LL4/b;", "Lcom/stepos/agentsprite/view/AgentView;", "agentHomeView", "Lcom/stepos/agentsprite/view/AgentView;", "spriteBound", "isExternalSession", "currentExternalDeviceId", "currentExternalAgentType", "currentExternalDeviceName", "isPageResumed", "LUa/M;", "scope", "LUa/M;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "pickResultSessionReadyListener", "Lp9/l;", "reinstallBannerAgentId", "externalSuggestionsApplied", "pendingExternalFileId", "com/stepos/ailauncher/chat/controller/AgentSpaceController$c", "activeConversationsListener", "Lcom/stepos/ailauncher/chat/controller/AgentSpaceController$c;", "emptyMessage", "keyboardVisible", "keyboardDismissRequestedAtMs", "keyboardDesyncLogged", "Landroid/animation/ValueAnimator;", "contentMarginAnimator", "Landroid/animation/ValueAnimator;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "updateStatusTask", "Ljava/lang/Runnable;", "Lcom/google/android/material/bottomsheet/a;", "artifactsSheet", "Lcom/google/android/material/bottomsheet/a;", "pendingArtifactsRestore", "Lcom/stepos/ailauncher/chat/view/t;", "moreMenuPopup", "Lcom/stepos/ailauncher/chat/view/t;", "Lkotlinx/coroutines/g;", "moreMenuJob", "Lkotlinx/coroutines/g;", "Landroid/widget/EditText;", "searchEditText", "Landroid/widget/EditText;", "searchClearBtn", "searchCancelBtn", "searchResultsView", "drawerHistoryList", "searchEmptyView", "Lcom/stepos/ailauncher/chat/adapter/J;", "searchResultAdapter", "Lcom/stepos/ailauncher/chat/adapter/J;", "searchJob", "searchInputTrackRunnable", "kotlin.jvm.PlatformType", "z1", "()Landroid/content/Context;", "context", "Companion", Const.INTENT_KEY_APIKEY, "HomeContentTier", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentSpaceController {
    private static final int AGENT_VIEW_HEIGHT_COMPACT_DP = 184;
    private static final int AGENT_VIEW_HEIGHT_DP = 240;
    private static final int AGENT_VIEW_HEIGHT_TINY_DP = 138;
    private static final int AGENT_VIEW_WIDTH_COMPACT_DP = 240;
    private static final int AGENT_VIEW_WIDTH_DP = 312;
    private static final int AGENT_VIEW_WIDTH_TINY_DP = 180;
    private static final long CONTENT_MARGIN_ANIM_DURATION_MS = 250;
    private static final int CONTENT_MARGIN_TOP_COMPACT_DP = 70;
    private static final int CONTENT_MARGIN_TOP_DEFAULT_DP = 150;
    private static final int CONTENT_MARGIN_TOP_KEYBOARD_COMPACT_DP = 40;
    private static final int CONTENT_MARGIN_TOP_KEYBOARD_DP = 50;
    private static final int CONTENT_MARGIN_TOP_KEYBOARD_TINY_DP = 30;
    private static final int CONTENT_MARGIN_TOP_TINY_DP = 40;
    private static final float DRAWER_EDGE_ZONE_DP = 48.0f;
    private static final int DRAWER_SCRIM_COLOR = 1291845632;
    private static final float GREETING_TEXT_SIZE_COMPACT_SP = 16.0f;
    private static final float GREETING_TEXT_SIZE_SP = 20.0f;
    private static final float GREETING_TEXT_SIZE_TINY_SP = 14.0f;
    private static final long INJECT_RETRY_INTERVAL_MS = 100;
    private static final long KEYBOARD_INSETS_SYNC_TIMEOUT_MS = 600;
    private static final int MAX_INJECT_RETRY = 30;
    private static final float NAV_BAR_FALLBACK_DP = 20.0f;
    private static final long NEW_SESSION_CLICK_DEBOUNCE_MS = 120;
    private static final long SEARCH_DEBOUNCE_MS = 250;
    private static final String TAG = "AILauncher-AgentSpaceController";
    private static final int TIER_COMPACT_MIN_DP = 350;
    private static final int TIER_NORMAL_MIN_DP = 700;
    private final c activeConversationsListener;
    private L4.b agentCtrl;
    private AgentView agentHomeView;
    private View agentSpaceContent;
    private com.google.android.material.bottomsheet.a artifactsSheet;
    private y7.E btnAppsMaterialHandle;
    private ImageView btnNewSession;
    private volatile Integer cachedNavigationBarHeight;
    private ChatView chatView;
    private LinearLayout contentContainer;
    private ValueAnimator contentMarginAnimator;
    private ActiveConversationManager conversationManager;
    private String currentExternalAgentType;
    private String currentExternalDeviceId;
    private String currentExternalDeviceName;
    private RecyclerView drawerHistoryList;
    private volatile boolean emptyMessage;
    private boolean externalSuggestionsApplied;
    private boolean homeLeaveReported;
    private HomeContentTier homeTier;
    private boolean isExternalSession;
    private boolean isPageResumed;
    private boolean keyboardDesyncLogged;
    private long keyboardDismissRequestedAtMs;
    private boolean keyboardVisible;
    private long lastNewSessionClickElapsedMs;
    private boolean lockScreenMode;
    private Handler mainHandler;
    private kotlinx.coroutines.g moreMenuJob;
    private final C2963t moreMenuPopup;
    private y7.E newChatPillGlassHandle;
    private IOverlayPageHost overlayHost;
    private long pageResumeElapsedMs;
    private y7.E panelNewSessionGlassHandle;
    private List<SessionArtifact> pendingArtifactsRestore;
    private String pendingExternalFileId;
    private final InterfaceC5074l<BaseInputView, Y8.t> pickResultSessionReadyListener;
    private LinearLayout recommendContainer;
    private RecyclerView recommendRecyclerView;
    private final C5 recommendSnapHelper;
    private String reinstallBannerAgentId;
    private View rightBtnGroup;
    private final Ua.M scope;
    private y7.E searchBoxGlassHandle;
    private View searchCancelBtn;
    private View searchClearBtn;
    private EditText searchEditText;
    private View searchEmptyView;
    private final Runnable searchInputTrackRunnable;
    private kotlinx.coroutines.g searchJob;
    private com.stepos.ailauncher.chat.adapter.J searchResultAdapter;
    private RecyclerView searchResultsView;
    private List<SessionItem> sessionItems;
    private String sessionListLayerId;
    private PopupWindow sessionListPopup;
    private boolean spriteBound;
    private RecyclerView suggestionsRecyclerView;
    private View titleDropdownArea;
    private View topBar;
    private final List<y7.E> topBarGlassHandles;
    private TextView tvGreeting;
    private TextView tvSubtitle;
    private TextView tvTitle;
    private final Runnable updateStatusTask;
    private final C3016y view;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/AgentSpaceController$HomeContentTier;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "COMPACT", "TINY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HomeContentTier {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ HomeContentTier[] $VALUES;
        public static final HomeContentTier NORMAL = new HomeContentTier("NORMAL", 0);
        public static final HomeContentTier COMPACT = new HomeContentTier("COMPACT", 1);
        public static final HomeContentTier TINY = new HomeContentTier("TINY", 2);

        private static final /* synthetic */ HomeContentTier[] $values() {
            return new HomeContentTier[]{NORMAL, COMPACT, TINY};
        }

        static {
            HomeContentTier[] homeContentTierArr$values = $values();
            $VALUES = homeContentTierArr$values;
            $ENTRIES = kotlin.enums.a.a(homeContentTierArr$values);
        }

        private HomeContentTier(String str, int i10) {
        }

        public static InterfaceC4149a<HomeContentTier> getEntries() {
            return $ENTRIES;
        }

        public static HomeContentTier valueOf(String str) {
            return (HomeContentTier) Enum.valueOf(HomeContentTier.class, str);
        }

        public static HomeContentTier[] values() {
            return (HomeContentTier[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[IExternalAgentBindService.BusyKind.values().length];
            try {
                iArr[IExternalAgentBindService.BusyKind.INSTALLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IExternalAgentBindService.BusyKind.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IExternalAgentBindService.BusyKind.UPDATING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IExternalAgentBindService.BusyKind.UNINSTALLING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ChatEntrySource.values().length];
            try {
                iArr2[ChatEntrySource.EXTERNAL_AGENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ChatEntrySource.AGENT_MARKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ChatEntrySource.SIDEBAR_AGENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ChatEntrySource.AGENT_SPACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[OverlayPageResumeReason.values().length];
            try {
                iArr3[OverlayPageResumeReason.PAGE_SWITCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[OverlayPageResumeReason.LAUNCHER_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[OverlayPageResumeReason.OVERLAY_ACTIVITY_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[HomeContentTier.values().length];
            try {
                iArr4[HomeContentTier.TINY.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[HomeContentTier.COMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[HomeContentTier.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[LockScreenChatAction.values().length];
            try {
                iArr5[LockScreenChatAction.OPEN_DRAWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[LockScreenChatAction.OPEN_SESSION_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr5[LockScreenChatAction.NEW_CHAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr5[LockScreenChatAction.CHANGE_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[LockScreenChatAction.OPEN_TASK_DETAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr5[LockScreenChatAction.SHOW_MORE_PANEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr5[LockScreenChatAction.PICK_CAMERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[LockScreenChatAction.PICK_CAMERA_FROM_MORE.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[LockScreenChatAction.PICK_ALBUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[LockScreenChatAction.PICK_FILE.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[LockScreenChatAction.RESTORE_LAST_SESSION.ordinal()] = 11;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[LockScreenChatAction.CIRCLE_SELECT.ordinal()] = 12;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr5[LockScreenChatAction.ASK_SCREEN.ordinal()] = 13;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr5[LockScreenChatAction.OPEN_ARTIFACTS.ordinal()] = 14;
            } catch (NoSuchFieldError unused28) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[TopBarNewSessionTarget.values().length];
            try {
                iArr6[TopBarNewSessionTarget.AMOO.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr6[TopBarNewSessionTarget.CURRENT_EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr6[TopBarNewSessionTarget.CURRENT_INSTALLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            $EnumSwitchMapping$5 = iArr6;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/controller/AgentSpaceController$c", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$b;", "", "Lcom/stepos/ailauncher/chat/adapter/U;", "sessions", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ActiveConversationManager.b {
        public c() {
        }

        @Override // com.stepos.ailauncher.chat.controller.ActiveConversationManager.b
        public void a(List<SessionItem> sessions) {
            TextView textView;
            kotlin.jvm.internal.p.i(sessions, "sessions");
            AgentSpaceController.this.sessionItems = sessions;
            C4148a.d(AgentSpaceController.TAG, "活跃会话更新: " + sessions.size() + " 条", false, 4, null);
            View view = AgentSpaceController.this.titleDropdownArea;
            if (view == null || view.getVisibility() != 0) {
                List<SessionItem> list = sessions;
                if (!list.isEmpty() && (textView = AgentSpaceController.this.tvSubtitle) != null) {
                    textView.setText(AgentSpaceController.this.z1().getString(R$string.active_sessions_count, Integer.valueOf(sessions.size())));
                }
                PopupWindow popupWindow = AgentSpaceController.this.sessionListPopup;
                if (popupWindow != null) {
                    AgentSpaceController agentSpaceController = AgentSpaceController.this;
                    if (popupWindow.isShowing()) {
                        if (list.isEmpty()) {
                            popupWindow.dismiss();
                        }
                        View contentView = popupWindow.getContentView();
                        RecyclerView recyclerView = contentView != null ? (RecyclerView) contentView.findViewById(R$id.recycler_session_list) : null;
                        Object adapter = recyclerView != null ? recyclerView.getAdapter() : null;
                        com.stepos.ailauncher.chat.adapter.W w10 = adapter instanceof com.stepos.ailauncher.chat.adapter.W ? (com.stepos.ailauncher.chat.adapter.W) adapter : null;
                        if (w10 != null) {
                            w10.g(agentSpaceController.sessionItems);
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/controller/AgentSpaceController$d", "LL4/o;", "LL4/n;", "info", "LY8/t;", "c", "(LL4/n;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "", "success", Const.INTENT_KEY_APIKEY, "(LL4/n;Z)V", "e", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements L4.o {
        @Override // L4.o
        public void a(AnimationInfo info, boolean success) {
            kotlin.jvm.internal.p.i(info, "info");
            o.a.d(this, info, success);
            com.stepos.ailauncher.chat.trace.c.INSTANCE.b(info, success, com.stepos.ailauncher.chat.trace.c.POSITION_HOME_SCREEN);
        }

        @Override // L4.o
        public void b(AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
            o.a.c(this, info);
        }

        @Override // L4.o
        public void c(AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
            o.a.a(this, info);
        }

        @Override // L4.o
        public void d(AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
            o.a.b(this, info);
        }

        @Override // L4.o
        public void e(AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
            o.a.e(this, info);
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/stepos/ailauncher/chat/controller/AgentSpaceController$e", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "Landroidx/core/view/Z$a;", "bounds", "e", "(Landroidx/core/view/Z;Landroidx/core/view/Z$a;)Landroidx/core/view/Z$a;", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/core/view/Z;)V", "", "imeShowing", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends Z.b {
        final /* synthetic */ View $btnApps;
        private boolean imeShowing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(1);
            this.$btnApps = view;
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                this.$btnApps.setAlpha(this.imeShowing ? 0.0f : 1.0f);
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            Object next;
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            Iterator<T> it = runningAnimations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if ((((androidx.core.view.Z) next).d() & a0.o.b()) != 0) {
                    break;
                }
            }
            androidx.core.view.Z z10 = (androidx.core.view.Z) next;
            if (z10 == null) {
                return insets;
            }
            float fC = z10.c();
            View view = this.$btnApps;
            if (this.imeShowing) {
                fC = 1.0f - fC;
            }
            view.setAlpha(C5685n.m(fC, 0.0f, 1.0f));
            return insets;
        }

        @Override // androidx.core.view.Z.b
        public Z.a e(androidx.core.view.Z animation, Z.a bounds) {
            kotlin.jvm.internal.p.i(animation, "animation");
            kotlin.jvm.internal.p.i(bounds, "bounds");
            androidx.core.view.a0 a0VarB = androidx.core.view.N.B(AgentSpaceController.this.view);
            this.imeShowing = a0VarB != null ? a0VarB.r(a0.o.b()) : false;
            return bounds;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/controller/AgentSpaceController$f", "Landroidx/drawerlayout/widget/DrawerLayout$g;", "Landroid/view/View;", "drawerView", "", "slideOffset", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/View;F)V", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends DrawerLayout.g {
        final /* synthetic */ View $contentArea;
        final /* synthetic */ ChatHistoryView $historyView;
        final /* synthetic */ AgentSpaceController this$0;

        public f(View view, ChatHistoryView chatHistoryView, AgentSpaceController agentSpaceController) {
            this.$contentArea = view;
            this.$historyView = chatHistoryView;
            this.this$0 = agentSpaceController;
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View drawerView) {
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            ChatHistoryView chatHistoryView = this.$historyView;
            if (chatHistoryView != null) {
                ChatHistoryView.q1(chatHistoryView, true, null, 2, null);
            }
            ChatHistoryView chatHistoryView2 = this.$historyView;
            if (chatHistoryView2 != null) {
                chatHistoryView2.setDrawerContentActive(true);
            }
            ChatView chatView = this.this$0.chatView;
            if (chatView != null) {
                chatView.setInMain(false);
            }
            com.stepos.ailauncher.chat.trace.f.INSTANCE.h();
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View drawerView) {
            Editable text;
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
            Context contextZ1 = this.this$0.z1();
            kotlin.jvm.internal.p.h(contextZ1, "access$getContext(...)");
            a10.a(contextZ1, drawerView);
            com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SIDEBAR_COLLAPSE);
            ChatHistoryView chatHistoryView = this.$historyView;
            if (chatHistoryView != null) {
                chatHistoryView.setDrawerContentActive(false);
            }
            View view = this.$contentArea;
            if (view != null) {
                view.setTranslationX(0.0f);
            }
            ChatHistoryView chatHistoryView2 = this.$historyView;
            if (chatHistoryView2 != null) {
                chatHistoryView2.Z0();
            }
            EditText editText = this.this$0.searchEditText;
            if (editText != null && (text = editText.getText()) != null) {
                text.clear();
            }
            EditText editText2 = this.this$0.searchEditText;
            if (editText2 != null) {
                editText2.clearFocus();
            }
            this.this$0.x1(this.$historyView);
            ChatView chatView = this.this$0.chatView;
            if (chatView != null) {
                chatView.setInMain(true);
            }
            ChatView chatView2 = this.this$0.chatView;
            if (chatView2 != null) {
                chatView2.p3();
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View drawerView, float slideOffset) {
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            View view = this.$contentArea;
            if (view != null) {
                view.setTranslationX(drawerView.getWidth() * slideOffset);
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/controller/AgentSpaceController$g", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements TextWatcher {
        final /* synthetic */ ChatHistoryView $historyView;

        public g(ChatHistoryView chatHistoryView) {
            this.$historyView = chatHistoryView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            String string;
            String string2 = (s10 == null || (string = s10.toString()) == null) ? null : La.H.D1(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            View view = AgentSpaceController.this.searchClearBtn;
            if (view != null) {
                view.setVisibility(string2.length() > 0 ? 0 : 8);
            }
            AgentSpaceController agentSpaceController = AgentSpaceController.this;
            EditText editText = agentSpaceController.searchEditText;
            agentSpaceController.P3((editText != null && editText.hasFocus()) || string2.length() > 0);
            AgentSpaceController.this.mainHandler.removeCallbacks(AgentSpaceController.this.searchInputTrackRunnable);
            if (string2.length() > 0) {
                AgentSpaceController.this.mainHandler.postDelayed(AgentSpaceController.this.searchInputTrackRunnable, 1000L);
            }
            AgentSpaceController.this.i1(string2, this.$historyView);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public AgentSpaceController(C3016y view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
        this.homeLeaveReported = true;
        this.topBarGlassHandles = new ArrayList();
        this.sessionItems = C1173v.m();
        this.recommendSnapHelper = new C5();
        this.scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        this.pickResultSessionReadyListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.s3((BaseInputView) obj);
            }
        };
        this.activeConversationsListener = new c();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.updateStatusTask = new Runnable() { // from class: com.stepos.ailauncher.chat.controller.e0
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.z4(this.f25064a);
            }
        };
        this.moreMenuPopup = new C2963t(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.f0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.I2(this.f25068a, (List) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.g0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.J2(this.f25071a, (m.FolderMessage) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.h0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentSpaceController.K2(this.f25077a);
            }
        });
        this.searchInputTrackRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.controller.i0
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.L3();
            }
        };
    }

    public static final Y8.t A3(AgentSpaceController agentSpaceController, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        agentSpaceController.topBarGlassHandles.remove(released);
        return Y8.t.f7040a;
    }

    public static final Y8.t B3(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.panelNewSessionGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t C3(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.newChatPillGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t D3(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.searchBoxGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void F3(AgentSpaceController agentSpaceController, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        agentSpaceController.E3(str, str2, i10);
    }

    public static final void G3(AgentSpaceController agentSpaceController, String str, String str2, int i10) {
        agentSpaceController.E3(str, str2, i10 + 1);
    }

    public static final void H1(AgentSpaceController agentSpaceController, View view) {
        AgentView agentView = agentSpaceController.agentHomeView;
        AnimationInfo currentInfo = agentView != null ? agentView.getCurrentInfo() : null;
        if (currentInfo != null) {
            com.stepos.ailauncher.chat.trace.c.INSTANCE.a(currentInfo, com.stepos.ailauncher.chat.trace.c.POSITION_HOME_SCREEN);
        }
    }

    public static /* synthetic */ void H2(AgentSpaceController agentSpaceController, ChatEntrySource chatEntrySource, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        agentSpaceController.G2(chatEntrySource, z10);
    }

    public static final Y8.t I2(AgentSpaceController agentSpaceController, List artifacts) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        agentSpaceController.S3(artifacts);
        return Y8.t.f7040a;
    }

    public static final void J1(AgentSpaceController agentSpaceController, View view) {
        ChatTracker.INSTANCE.G(ChatTracker.WORLD_OLD, agentSpaceController.L2());
        ChatView chatView = agentSpaceController.chatView;
        if (chatView != null) {
            chatView.setSuppressPillOverlaySync(true);
        }
        IOverlayPageHost iOverlayPageHost = agentSpaceController.overlayHost;
        if (iOverlayPageHost != null) {
            iOverlayPageHost.closeOverlay(true);
        }
    }

    public static final Y8.t J2(AgentSpaceController agentSpaceController, m.FolderMessage tree) {
        kotlin.jvm.internal.p.i(tree, "tree");
        agentSpaceController.f3(tree);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void J3(AgentSpaceController agentSpaceController, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        agentSpaceController.I3(i10);
    }

    public static final Y8.t K2(AgentSpaceController agentSpaceController) {
        agentSpaceController.o4();
        return Y8.t.f7040a;
    }

    public static final void K3(AgentSpaceController agentSpaceController, int i10) {
        agentSpaceController.I3(i10 + 1);
    }

    public static final void L1(AgentSpaceController agentSpaceController, View view) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - agentSpaceController.lastNewSessionClickElapsedMs < 120) {
            return;
        }
        agentSpaceController.lastNewSessionClickElapsedMs = jElapsedRealtime;
        ChatTracker.INSTANCE.y("sidebar_create");
        agentSpaceController.g4();
    }

    public static final void L3() {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.j();
    }

    public static final androidx.core.view.a0 M1(AgentSpaceController agentSpaceController, View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        boolean zR = insets.r(a0.o.b());
        agentSpaceController.keyboardDismissRequestedAtMs = 0L;
        agentSpaceController.keyboardDesyncLogged = false;
        if (zR != agentSpaceController.keyboardVisible) {
            agentSpaceController.keyboardVisible = zR;
            agentSpaceController.Z0(agentSpaceController.q1(zR));
            agentSpaceController.t4(zR);
            if (zR) {
                View viewFindViewById = agentSpaceController.view.findViewById(R$id.btn_apps);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
            } else {
                agentSpaceController.j4();
            }
        }
        int i10 = insets.f(a0.o.e()).f41980d;
        Integer num = agentSpaceController.cachedNavigationBarHeight;
        C4148a.d(TAG, "navigationBarHeight: " + i10 + " (cached=" + (num != null ? num.intValue() : -1) + ")", false, 4, null);
        if (i10 > 0) {
            agentSpaceController.cachedNavigationBarHeight = Integer.valueOf(i10);
        }
        Integer num2 = agentSpaceController.cachedNavigationBarHeight;
        v10.setPadding(0, v10.getPaddingTop(), 0, num2 != null ? num2.intValue() : (int) (agentSpaceController.z1().getResources().getDisplayMetrics().density * 20.0f));
        return insets;
    }

    public static final Y8.t N1(View view, boolean z10) {
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
        return Y8.t.f7040a;
    }

    public static final void O1(AgentSpaceController agentSpaceController) {
        agentSpaceController.e1();
    }

    public static final Y8.t P1(AgentSpaceController agentSpaceController, String str) {
        C4148a.d(TAG, "onMsgSent", false, 4, null);
        agentSpaceController.mainHandler.removeCallbacks(agentSpaceController.updateStatusTask);
        agentSpaceController.h1(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t P2() {
        return Y8.t.f7040a;
    }

    public static final Y8.t Q1(AgentSpaceController agentSpaceController, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.mainHandler.removeCallbacks(agentSpaceController.updateStatusTask);
        agentSpaceController.h1(false);
        return Y8.t.f7040a;
    }

    public static final Y8.t Q2(AgentSpaceController agentSpaceController, IExternalAgentBindService.DisabledInfo disabledInfo, boolean z10) {
        if (!z10) {
            Toast.makeText(agentSpaceController.z1(), R$string.network_check_chat, 0).show();
            if (kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, disabledInfo.getAssetId())) {
                agentSpaceController.V3(disabledInfo);
            }
        } else if (kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, disabledInfo.getAssetId())) {
            C2996w.d(agentSpaceController.view, disabledInfo.getDisplayName(), true);
            agentSpaceController.F1();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t R1(AgentSpaceController agentSpaceController, boolean z10) {
        agentSpaceController.mainHandler.removeCallbacks(agentSpaceController.updateStatusTask);
        agentSpaceController.h1(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t R3(AgentSpaceController agentSpaceController, String text) {
        kotlin.jvm.internal.p.i(text, "text");
        AuthManager authManager = AuthManager.INSTANCE;
        Context contextZ1 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (!AuthManager.O(authManager, contextZ1, true, false, 4, null)) {
            return Y8.t.f7040a;
        }
        LinearLayout linearLayout = agentSpaceController.contentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        agentSpaceController.O3(true);
        ChatView chatView = agentSpaceController.chatView;
        if (chatView != null) {
            chatView.E3(text);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t S1(AgentSpaceController agentSpaceController, boolean z10) {
        agentSpaceController.mainHandler.removeCallbacks(agentSpaceController.updateStatusTask);
        agentSpaceController.emptyMessage = z10;
        agentSpaceController.mainHandler.postDelayed(agentSpaceController.updateStatusTask, 100L);
        return Y8.t.f7040a;
    }

    public static final void T1(View view) {
    }

    public static final Y8.t U3() {
        return Y8.t.f7040a;
    }

    public static final void W1(AgentSpaceController agentSpaceController, View view, View view2) {
        if (agentSpaceController.moreMenuPopup.f()) {
            agentSpaceController.moreMenuPopup.e();
            return;
        }
        View view3 = agentSpaceController.rightBtnGroup;
        if (view3 != null) {
            view = view3;
        }
        kotlinx.coroutines.g gVar = agentSpaceController.moreMenuJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        agentSpaceController.moreMenuJob = C1060i.d(agentSpaceController.scope, null, null, new AgentSpaceController$initMoreMenu$1$1(agentSpaceController, view, null), 3, null);
    }

    public static final void W2(AgentSpaceController agentSpaceController) {
        agentSpaceController.z3();
    }

    public static final Y8.t W3(AgentSpaceController agentSpaceController, IExternalAgentBindService.DisabledInfo disabledInfo) {
        agentSpaceController.O2(disabledInfo);
        return Y8.t.f7040a;
    }

    public static final void Y1(AgentSpaceController agentSpaceController) {
        agentSpaceController.b1();
    }

    public static final Y8.t Y3(AgentSpaceController agentSpaceController, IExternalAgentBindService.ReinstallInfo reinstallInfo) {
        agentSpaceController.Y2(reinstallInfo);
        return Y8.t.f7040a;
    }

    public static final Y8.t Z1(AgentSpaceController agentSpaceController, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context contextZ1 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, contextZ1, LockScreenChatAction.NEW_CHAT, null, null, 12, null)) {
            return Y8.t.f7040a;
        }
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_NEW_SESSION);
        ChatTracker.INSTANCE.y("sidebar_create");
        agentSpaceController.f4();
        return Y8.t.f7040a;
    }

    public static final Y8.t Z2() {
        return Y8.t.f7040a;
    }

    public static final void a1(ViewGroup.MarginLayoutParams marginLayoutParams, LinearLayout linearLayout, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        marginLayoutParams.topMargin = ((Integer) animatedValue).intValue();
        linearLayout.setLayoutParams(marginLayoutParams);
    }

    public static final void a2(final AgentSpaceController agentSpaceController, View view) {
        if (agentSpaceController.overlayHost == null || agentSpaceController.panelNewSessionGlassHandle != null) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        y7.E eD = C2851i7.d(c2851i7, view, false, Float.valueOf(22.0f), null, 8, null);
        agentSpaceController.panelNewSessionGlassHandle = eD;
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.c0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.b2(this.f25057a, (y7.E) obj);
            }
        });
    }

    public static final Y8.t a3(AgentSpaceController agentSpaceController, IExternalAgentBindService.ReinstallInfo reinstallInfo, boolean z10) {
        if (!z10) {
            Toast.makeText(agentSpaceController.z1(), R$string.network_check_chat, 0).show();
            if (kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, reinstallInfo.getAssetId())) {
                agentSpaceController.X3(reinstallInfo);
            }
        } else if (kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, reinstallInfo.getAssetId())) {
            agentSpaceController.F1();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t b2(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.panelNewSessionGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static final boolean b4(PopupWindow popupWindow) {
        return popupWindow.isShowing();
    }

    public static final Y8.t c2(AgentSpaceController agentSpaceController, String sessionId, String str, String str2) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (p1(agentSpaceController, sessionId, str, str2, null, null, false, 56, null)) {
            ChatTracker.INSTANCE.y("sidebar_historychat");
            q4(agentSpaceController, sessionId, com.stepos.ailauncher.chat.trace.f.ENTRY_HISTORY, null, str, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t c4(PopupWindow popupWindow) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        return Y8.t.f7040a;
    }

    public static final void d1(AgentSpaceController agentSpaceController) {
        J3(agentSpaceController, 0, 1, null);
    }

    public static final Y8.t d2(AgentSpaceController agentSpaceController) {
        agentSpaceController.view.d(8388611);
        return Y8.t.f7040a;
    }

    public static final Y8.t d3() {
        return Y8.t.f7040a;
    }

    public static final Y8.t e2(AgentSpaceController agentSpaceController, String sessionId, InterfaceC5074l callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(callback, "callback");
        agentSpaceController.v1(sessionId, callback);
        return Y8.t.f7040a;
    }

    public static final Y8.t e3(AgentSpaceController agentSpaceController, IExternalAgentBindService.UpdateInfo updateInfo, boolean z10) {
        if (!kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, updateInfo.getAssetId())) {
            return Y8.t.f7040a;
        }
        if (z10) {
            agentSpaceController.F1();
        } else {
            Toast.makeText(agentSpaceController.z1(), R$string.network_check_chat, 0).show();
            agentSpaceController.d4(updateInfo);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t e4(AgentSpaceController agentSpaceController, IExternalAgentBindService.UpdateInfo updateInfo) {
        agentSpaceController.c3(updateInfo);
        return Y8.t.f7040a;
    }

    public static final void f2(AgentSpaceController agentSpaceController, View view) {
        agentSpaceController.D1();
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_NEW_SESSION);
        ChatTracker.INSTANCE.y("sidebar_create");
        agentSpaceController.r1();
        LinearLayout linearLayout = agentSpaceController.contentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        agentSpaceController.O3(false);
        agentSpaceController.view.d(8388611);
    }

    public static final int g1(float f10, int i10) {
        return (int) (i10 * f10);
    }

    public static final void g2(final AgentSpaceController agentSpaceController, View view) {
        if (agentSpaceController.overlayHost == null || agentSpaceController.newChatPillGlassHandle != null) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        y7.E eD = C2851i7.d(c2851i7, view, false, Float.valueOf(22.0f), null, 8, null);
        agentSpaceController.newChatPillGlassHandle = eD;
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.h2(this.f25013a, (y7.E) obj);
            }
        });
    }

    public static final Y8.t h2(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.newChatPillGlassHandle = null;
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h3(com.stepos.ailauncher.chat.controller.AgentSpaceController r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1c
            com.stepos.ailauncher.chat.view.ChatView r1 = r10.chatView     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L14
            r5 = 4
            r6 = 0
            r4 = 0
            r3 = r11
            r2 = r12
            com.stepos.ailauncher.chat.view.ChatView.L1(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L11
            Y8.t r11 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L11
            goto L17
        L11:
            r0 = move-exception
        L12:
            r11 = r0
            goto L20
        L14:
            r3 = r11
            r2 = r12
            r11 = 0
        L17:
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L11
            goto L2a
        L1c:
            r0 = move-exception
            r3 = r11
            r2 = r12
            goto L12
        L20:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        L2a:
            java.lang.Throwable r6 = kotlin.Result.e(r11)
            if (r6 == 0) goto L3c
            r8 = 8
            r9 = 0
            java.lang.String r4 = "AILauncher-AgentSpaceController"
            java.lang.String r5 = "openFreshExternalChat failed"
            r7 = 0
            h8.C4148a.t(r4, r5, r6, r7, r8, r9)
        L3c:
            com.stepos.ailauncher.chat.view.y r11 = r10.view
            com.stepos.ailauncher.chat.view.C2996w.c(r11, r3, r2, r13, r14)
            r11 = 1
            r10.M3(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController.h3(com.stepos.ailauncher.chat.controller.AgentSpaceController, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.ViewGroup] */
    public static final Y8.t i2(AgentSpaceController agentSpaceController, ChatHistoryView chatHistoryView) {
        ?? r12;
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_NEW_AGENT);
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        if (iExternalAgentUiService != null) {
            Context context = agentSpaceController.view.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null || (r12 = (ViewGroup) activity.findViewById(R.id.content)) == 0) {
                View rootView = agentSpaceController.view.getRootView();
                ChatHistoryView chatHistoryView2 = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
                if (chatHistoryView2 != null) {
                    chatHistoryView = chatHistoryView2;
                }
            } else {
                chatHistoryView = r12;
            }
            iExternalAgentUiService.showAddAgentSheet(chatHistoryView);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t j2(AgentSpaceController agentSpaceController, SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        agentSpaceController.D1();
        LinearLayout linearLayout = agentSpaceController.contentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        agentSpaceController.O3(false);
        ChatTracker.INSTANCE.y("sidebar_agent");
        com.stepos.ailauncher.chat.trace.f.g(com.stepos.ailauncher.chat.trace.f.INSTANCE, null, null, null, "agent", agent.getDisplayName(), agent.getAgentId(), 6, null);
        if (agent.getIsPrimary()) {
            agentSpaceController.r1();
            agentSpaceController.view.d(8388611);
        } else if (agent.getInstalled()) {
            agentSpaceController.i3(agent.getAssetId(), agent.getDisplayName(), agent.getOnline());
            agentSpaceController.view.d(8388611);
        } else {
            agentSpaceController.g3(agent.getDeviceId(), agent.getAgentId(), agent.getDisplayName(), agent.getOnline());
            agentSpaceController.view.d(8388611);
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j3(com.stepos.ailauncher.chat.controller.AgentSpaceController r9, java.lang.String r10, boolean r11, java.lang.String r12) {
        /*
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L15
            com.stepos.ailauncher.chat.view.ChatView r1 = r9.chatView     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            java.lang.String r3 = ""
            r5 = 4
            r6 = 0
            r4 = 0
            r2 = r12
            com.stepos.ailauncher.chat.view.ChatView.L1(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L12
            Y8.t r12 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L12
            goto L1a
        L12:
            r0 = move-exception
        L13:
            r12 = r0
            goto L1f
        L15:
            r0 = move-exception
            r2 = r12
            goto L13
        L18:
            r2 = r12
            r12 = 0
        L1a:
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L12
            goto L29
        L1f:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L29:
            java.lang.Throwable r5 = kotlin.Result.e(r12)
            if (r5 == 0) goto L3b
            r7 = 8
            r8 = 0
            java.lang.String r3 = "AILauncher-AgentSpaceController"
            java.lang.String r4 = "openFreshInstalledChat failed"
            r6 = 0
            h8.C4148a.t(r3, r4, r5, r6, r7, r8)
        L3b:
            com.stepos.ailauncher.chat.view.y r12 = r9.view
            com.stepos.ailauncher.chat.view.C2996w.d(r12, r10, r11)
            java.lang.String r11 = ""
            r9.u4(r2, r11, r10)
            r10 = 1
            r9.M3(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController.j3(com.stepos.ailauncher.chat.controller.AgentSpaceController, java.lang.String, boolean, java.lang.String):void");
    }

    public static /* synthetic */ void k1(AgentSpaceController agentSpaceController, String str, String str2, String str3, Boolean bool, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        agentSpaceController.j1(str, str2, str3, bool);
    }

    public static final void k4(final AgentSpaceController agentSpaceController, View view) {
        if (agentSpaceController.overlayHost == null || agentSpaceController.btnAppsMaterialHandle != null) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        y7.E eD = C2851i7.d(c2851i7, view, false, Float.valueOf(14.0f), null, 8, null);
        agentSpaceController.btnAppsMaterialHandle = eD;
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.k0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.l4(this.f25091a, (y7.E) obj);
            }
        });
    }

    public static final void l2(final AgentSpaceController agentSpaceController, View view) {
        if (agentSpaceController.searchBoxGlassHandle != null) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        y7.E eD = C2851i7.d(c2851i7, view, false, Float.valueOf(22.0f), null, 8, null);
        agentSpaceController.searchBoxGlassHandle = eD;
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.n0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.m2(this.f25104a, (y7.E) obj);
            }
        });
    }

    public static final Y8.t l4(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.btnAppsMaterialHandle = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t m2(AgentSpaceController agentSpaceController, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        agentSpaceController.searchBoxGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static final void n2(View view) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SEARCH);
    }

    public static final void n4(AgentSpaceController agentSpaceController) {
        RecyclerView.Adapter adapter;
        ChatView chatView = agentSpaceController.chatView;
        if (chatView != null && chatView.getHandoffReloadPending()) {
            C4148a.d(TAG, "resume blank guard skipped: handoff still pending", false, 4, null);
            return;
        }
        ChatView chatView2 = agentSpaceController.chatView;
        ChatRecycleView messageList = chatView2 != null ? chatView2.getMessageList() : null;
        int itemCount = (messageList == null || (adapter = messageList.getAdapter()) == null) ? 0 : adapter.getItemCount();
        LinearLayout linearLayout = agentSpaceController.contentContainer;
        if ((linearLayout != null && linearLayout.getVisibility() == 0) || itemCount != 0) {
            return;
        }
        C4148a.u(TAG, "resume blank guard: content gone + empty list → show home", false, 4, null);
        agentSpaceController.mainHandler.removeCallbacks(agentSpaceController.updateStatusTask);
        agentSpaceController.h1(true);
    }

    public static final void o2(AgentSpaceController agentSpaceController, View view) {
        Editable text;
        EditText editText = agentSpaceController.searchEditText;
        if (editText == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    public static final void o3(AgentSpaceController agentSpaceController, LockScreenChatAction lockScreenChatAction) {
        MainInputView inputView;
        ChatView chatView = agentSpaceController.chatView;
        if (chatView == null || (inputView = chatView.getInputView()) == null) {
            return;
        }
        inputView.Y8(lockScreenChatAction);
    }

    public static /* synthetic */ boolean p1(AgentSpaceController agentSpaceController, String str, String str2, String str3, String str4, Boolean bool, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        String str5 = str4;
        if ((i10 & 16) != 0) {
            bool = null;
        }
        Boolean bool2 = bool;
        if ((i10 & 32) != 0) {
            z10 = true;
        }
        return agentSpaceController.o1(str, str2, str3, str5, bool2, z10);
    }

    public static final void p2(AgentSpaceController agentSpaceController, ChatHistoryView chatHistoryView, View view) {
        Editable text;
        EditText editText = agentSpaceController.searchEditText;
        if (editText != null && (text = editText.getText()) != null) {
            text.clear();
        }
        EditText editText2 = agentSpaceController.searchEditText;
        if (editText2 != null) {
            editText2.clearFocus();
        }
        EditText editText3 = agentSpaceController.searchEditText;
        if (editText3 != null) {
            agentSpaceController.E1(editText3);
        }
        agentSpaceController.x1(chatHistoryView);
        agentSpaceController.view.d(8388611);
    }

    public static final void q2(AgentSpaceController agentSpaceController, View view, boolean z10) {
        Editable text;
        EditText editText = agentSpaceController.searchEditText;
        boolean z11 = true;
        boolean z12 = (editText == null || (text = editText.getText()) == null || text.length() <= 0) ? false : true;
        if (!z10 && !z12) {
            z11 = false;
        }
        agentSpaceController.P3(z11);
    }

    public static /* synthetic */ void q3(AgentSpaceController agentSpaceController, LockScreenChatAction lockScreenChatAction, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        agentSpaceController.p3(lockScreenChatAction, i10);
    }

    public static /* synthetic */ void q4(AgentSpaceController agentSpaceController, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        agentSpaceController.p4(str, str2, str3, str4);
    }

    public static final void r3(AgentSpaceController agentSpaceController, LockScreenChatAction lockScreenChatAction, int i10) {
        agentSpaceController.p3(lockScreenChatAction, i10 + 1);
    }

    public static final Y8.t s3(BaseInputView input) {
        kotlin.jvm.internal.p.i(input, "input");
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        if (inputViewManager.C0()) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("pickResultSessionReady: input=%s", Arrays.copyOf(new Object[]{input}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            inputViewManager.Y0(input);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t t1(AgentSpaceController agentSpaceController, SessionItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        PopupWindow popupWindow = agentSpaceController.sessionListPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        agentSpaceController.n1(item.getSessionId(), false);
        return Y8.t.f7040a;
    }

    public static final void t2(AgentSpaceController agentSpaceController, View view) {
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context contextZ1 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, contextZ1, LockScreenChatAction.OPEN_SESSION_LIST, null, null, 12, null)) {
            return;
        }
        PopupWindow popupWindow = agentSpaceController.sessionListPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            View view2 = agentSpaceController.topBar;
            if (view2 != null) {
                agentSpaceController.a4(view2);
                return;
            }
            return;
        }
        PopupWindow popupWindow2 = agentSpaceController.sessionListPopup;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public static final void u1(AgentSpaceController agentSpaceController) {
        String str = agentSpaceController.sessionListLayerId;
        if (str != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            agentSpaceController.sessionListLayerId = null;
        }
    }

    public static final void u2(AgentSpaceController agentSpaceController, View view, View view2) {
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context contextZ1 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, contextZ1, LockScreenChatAction.OPEN_DRAWER, null, null, 12, null)) {
            return;
        }
        com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
        Context contextZ12 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ12, "<get-context>(...)");
        a10.a(contextZ12, view);
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SIDEBAR_EXPAND);
        agentSpaceController.view.K(8388611);
    }

    public static final void v2(final AgentSpaceController agentSpaceController, View view) {
        C2851i7 c2851i7;
        y7.E eD;
        if (agentSpaceController.overlayHost == null || (eD = C2851i7.d((c2851i7 = C2851i7.INSTANCE), view, false, Float.valueOf(22.0f), null, 8, null)) == null) {
            return;
        }
        agentSpaceController.topBarGlassHandles.add(eD);
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.w2(this.f24995a, (y7.E) obj);
            }
        });
    }

    public static final Y8.t v4(final AgentSpaceController agentSpaceController, final String str, final IExternalAgentBindService iExternalAgentBindService, IExternalAgentBindService.BusyInfo busyInfo) {
        if (!kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, str)) {
            return Y8.t.f7040a;
        }
        if (busyInfo == null) {
            iExternalAgentBindService.resolveDisabledMarketAgent(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.o0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.w4(this.f25110a, str, iExternalAgentBindService, (IExternalAgentBindService.DisabledInfo) obj);
                }
            });
            return Y8.t.f7040a;
        }
        int iM1 = agentSpaceController.m1(busyInfo.getKind());
        K0.INSTANCE.a(str, iM1);
        agentSpaceController.T3(iM1);
        return Y8.t.f7040a;
    }

    public static final Y8.t w2(AgentSpaceController agentSpaceController, y7.E released) {
        kotlin.jvm.internal.p.i(released, "released");
        agentSpaceController.topBarGlassHandles.remove(released);
        return Y8.t.f7040a;
    }

    public static final Y8.t w4(final AgentSpaceController agentSpaceController, final String str, final IExternalAgentBindService iExternalAgentBindService, IExternalAgentBindService.DisabledInfo disabledInfo) {
        if (!kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, str)) {
            return Y8.t.f7040a;
        }
        if (disabledInfo == null) {
            iExternalAgentBindService.resolveReinstallableAgent(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.r0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.x4(this.f25125a, str, iExternalAgentBindService, (IExternalAgentBindService.ReinstallInfo) obj);
                }
            });
            return Y8.t.f7040a;
        }
        K0.INSTANCE.a(str, R$string.chat_agent_disabled_hint);
        agentSpaceController.V3(disabledInfo);
        return Y8.t.f7040a;
    }

    public static final Y8.t x4(final AgentSpaceController agentSpaceController, final String str, IExternalAgentBindService iExternalAgentBindService, IExternalAgentBindService.ReinstallInfo reinstallInfo) {
        if (!kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, str)) {
            return Y8.t.f7040a;
        }
        if (reinstallInfo != null) {
            K0.INSTANCE.a(str, R$string.chat_agent_reinstall_hint);
            agentSpaceController.X3(reinstallInfo);
            return Y8.t.f7040a;
        }
        K0.INSTANCE.b();
        ChatView chatView = agentSpaceController.chatView;
        if (chatView != null) {
            chatView.g2();
        }
        iExternalAgentBindService.resolveUpdatableAgent(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.u0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.y4(this.f25136a, str, (IExternalAgentBindService.UpdateInfo) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void y2(AgentSpaceController agentSpaceController) {
        J3(agentSpaceController, 0, 1, null);
    }

    public static final Y8.t y4(AgentSpaceController agentSpaceController, String str, IExternalAgentBindService.UpdateInfo updateInfo) {
        if (!kotlin.jvm.internal.p.d(agentSpaceController.reinstallBannerAgentId, str)) {
            return Y8.t.f7040a;
        }
        if (updateInfo != null) {
            agentSpaceController.d4(updateInfo);
        }
        return Y8.t.f7040a;
    }

    public static final void z2(AgentSpaceController agentSpaceController, ChatLaunchPayload chatLaunchPayload, ResultReceiver resultReceiver, int i10) {
        agentSpaceController.x2(chatLaunchPayload, resultReceiver, i10 + 1);
    }

    public static final void z4(AgentSpaceController agentSpaceController) {
        ChatView chatView = agentSpaceController.chatView;
        if (chatView != null && chatView.getHandoffReloadPending()) {
            C4148a.d(TAG, "updateStatusTask skipped: handoff reload pending", false, 4, null);
            return;
        }
        C4148a.d(TAG, "initChatView, onSessionMessageListLoaded isNotEmpty:" + agentSpaceController.emptyMessage + " keyboardVisible:" + agentSpaceController.keyboardVisible, false, 4, null);
        agentSpaceController.h1(agentSpaceController.emptyMessage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LifecycleOwner A1(Context context) {
        kotlin.jvm.internal.p.i(context, "<this>");
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        kotlin.jvm.internal.p.h(baseContext, "getBaseContext(...)");
        return A1(baseContext);
    }

    public final boolean A2(float rawX) {
        return rawX < this.view.getResources().getDisplayMetrics().density * 48.0f;
    }

    public final void B1() {
        AgentView agentView = this.agentHomeView;
        if (agentView != null) {
            agentView.setVisibility(4);
        }
    }

    /* renamed from: B2, reason: from getter */
    public final boolean getLockScreenMode() {
        return this.lockScreenMode;
    }

    public final void C1() {
        AgentView agentView = this.agentHomeView;
        if (agentView != null) {
            agentView.setVisibility(4);
        }
    }

    public final boolean C2(float rawX, float rawY, View target) {
        int[] iArr = new int[2];
        target.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return rawX >= ((float) i10) && rawX <= ((float) (i10 + target.getWidth())) && rawY >= ((float) i11) && rawY <= ((float) (i11 + target.getHeight()));
    }

    public final void D1() {
        IBinder windowToken = this.view.getWindowToken();
        if (windowToken == null) {
            return;
        }
        Object systemService = z1().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }

    public final boolean D2(float rawX, float rawY, RecyclerView recyclerView) {
        if (!recyclerView.isShown()) {
            return false;
        }
        int[] iArr = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        return recyclerView.findChildViewUnder(rawX - ((float) iArr[0]), rawY - ((float) iArr[1])) != null;
    }

    public final void E1(View target) {
        Object systemService = z1().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(target.getWindowToken(), 0);
    }

    public final boolean E2(float rawX, float rawY) {
        List<View> listR = C1173v.r(this.searchClearBtn, this.searchCancelBtn);
        if (!(listR instanceof Collection) || !listR.isEmpty()) {
            for (View view : listR) {
                if (view.isShown() && C2(rawX, rawY, view)) {
                    return true;
                }
            }
        }
        List listR2 = C1173v.r(this.searchResultsView, this.drawerHistoryList);
        if ((listR2 instanceof Collection) && listR2.isEmpty()) {
            return false;
        }
        Iterator it = listR2.iterator();
        while (it.hasNext()) {
            if (D2(rawX, rawY, (RecyclerView) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void E3(final String sessionId, final String fileId, final int attempt) {
        ChatView chatView = this.chatView;
        MainInputView inputView = chatView != null ? chatView.getInputView() : null;
        if (inputView == null || !inputView.X7()) {
            if (attempt >= 30) {
                C4148a.u(TAG, "restoreSessionWhenReady: timeout, inputView not ready", false, 4, null);
                return;
            } else {
                this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgentSpaceController.G3(this.f25041a, sessionId, fileId, attempt);
                    }
                }, 100L);
                return;
            }
        }
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            chatView2.w1(sessionId);
        }
        C4148a.d(TAG, "restoreSessionWhenReady: restored session fileId=" + fileId + " -> sessionId=" + sessionId, false, 4, null);
    }

    public final void F1() {
        this.reinstallBannerAgentId = null;
        K0.INSTANCE.b();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.g2();
        }
    }

    public final void F2() {
        if (this.keyboardDismissRequestedAtMs == 0) {
            this.keyboardDismissRequestedAtMs = SystemClock.elapsedRealtime();
        }
    }

    public final void G1() {
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        LifecycleOwner lifecycleOwnerA1 = A1(contextZ1);
        if (lifecycleOwnerA1 == null) {
            return;
        }
        this.agentCtrl = N4.a.c(lifecycleOwnerA1, null, null, null, null, null, null, 63, null);
        AgentView agentView = (AgentView) this.view.findViewById(R$id.agent);
        this.agentHomeView = agentView;
        if (agentView != null) {
            agentView.setAnimationListener(new d());
        }
        AgentView agentView2 = this.agentHomeView;
        if (agentView2 != null) {
            agentView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentSpaceController.H1(this.f25103a, view);
                }
            });
        }
        l1();
    }

    public final void G2(ChatEntrySource source, boolean onlyIfAbsent) {
        String str;
        int i10 = source == null ? -1 : b.$EnumSwitchMapping$1[source.ordinal()];
        if (i10 != -1) {
            if (i10 == 1) {
                str = C3475d.EXTERNAL_AGENT;
            } else if (i10 == 2) {
                str = C3475d.AGENT_MARKET;
            } else if (i10 == 3) {
                str = "sidebar_agent";
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "agent_space";
            }
            C3475d c3475d = C3475d.INSTANCE;
            if (onlyIfAbsent) {
                c3475d.d(str);
            } else {
                c3475d.c(str);
            }
        }
    }

    public final void H3() {
        ChatView chatView;
        if (InputViewManager.INSTANCE.C0() && (chatView = this.chatView) != null) {
            chatView.f4(this.pickResultSessionReadyListener);
        }
    }

    public final void I1() {
        View viewFindViewById = this.view.findViewById(R$id.btn_apps);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentSpaceController.J1(this.f25116a, view);
            }
        });
        androidx.core.view.N.E0(this.view, new e(viewFindViewById));
    }

    public final void I3(final int attempt) {
        String str = this.pendingExternalFileId;
        if (str == null) {
            return;
        }
        ChatView chatView = this.chatView;
        String currentSessionId = chatView != null ? chatView.getCurrentSessionId() : null;
        if (currentSessionId == null || currentSessionId.length() == 0) {
            if (attempt >= 50) {
                C4148a.u(TAG, "saveExternalFileIdMapping: timeout, sessionId not available", false, 4, null);
                return;
            } else {
                this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.U
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgentSpaceController.K3(this.f25031a, attempt);
                    }
                }, 200L);
                return;
            }
        }
        com.stepos.ailauncher.chat.wake.T.INSTANCE.b(str, currentSessionId);
        C4148a.d(TAG, "saveExternalFileIdMapping: fileId=" + str + " -> sessionId=" + currentSessionId, false, 4, null);
        this.pendingExternalFileId = null;
    }

    public final void K1() {
        ChatRecycleView messageList;
        this.tvTitle = (TextView) this.view.findViewById(R$id.tv_title);
        View viewFindViewById = this.view.findViewById(R$id.btn_new_session);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.btnNewSession = (ImageView) viewFindViewById;
        this.rightBtnGroup = this.view.findViewById(R$id.right_btn_group);
        ImageView imageView = this.btnNewSession;
        View view = null;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnNewSession");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgentSpaceController.L1(this.f25119a, view2);
            }
        });
        androidx.core.view.N.u0(this.view.findViewById(R$id.bottom_container), new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.controller.r
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view2, androidx.core.view.a0 a0Var) {
                return AgentSpaceController.M1(this.f25124a, view2, a0Var);
            }
        });
        this.suggestionsRecyclerView = (RecyclerView) this.view.findViewById(R$id.ll_suggestions);
        ChatView chatView = (ChatView) this.view.findViewById(R$id.agentChatView);
        this.chatView = chatView;
        if (chatView != null) {
            chatView.setFullScreenModel(true);
        }
        final View viewFindViewById2 = this.view.findViewById(R$id.v_recording_touch_blocker_host);
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            chatView2.setOnRecordingTouchBlockHost(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.N1(viewFindViewById2, ((Boolean) obj).booleanValue());
                }
            });
        }
        ChatView chatView3 = this.chatView;
        if (chatView3 != null && (messageList = chatView3.getMessageList()) != null) {
            messageList.setClipToPadding(false);
            messageList.setPadding(messageList.getPaddingLeft(), (int) (104 * messageList.getResources().getDisplayMetrics().density), messageList.getPaddingRight(), messageList.getPaddingBottom());
        }
        this.contentContainer = (LinearLayout) this.view.findViewById(R$id.content_container);
        this.tvGreeting = (TextView) this.view.findViewById(R$id.tv_greeting);
        View viewFindViewById3 = this.view.findViewById(R$id.agent_space_content);
        if (viewFindViewById3 != null) {
            viewFindViewById3.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.u
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.O1(this.f25135a);
                }
            });
            view = viewFindViewById3;
        }
        this.agentSpaceContent = view;
        this.recommendRecyclerView = (RecyclerView) this.view.findViewById(R$id.rv_recommend_cards);
        this.recommendContainer = (LinearLayout) this.view.findViewById(R$id.content_recommend_container);
        ChatView chatView4 = this.chatView;
        if (chatView4 != null) {
            chatView4.setOnMsgSent(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.P1(this.f25140a, (String) obj);
                }
            });
        }
        ChatView chatView5 = this.chatView;
        if (chatView5 != null) {
            chatView5.setOnConversationSwitchStarted(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.w
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.Q1(this.f25146a, (String) obj);
                }
            });
        }
        ChatView chatView6 = this.chatView;
        if (chatView6 != null) {
            chatView6.setOnHandoffReloadFinished(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.R1(this.f25149a, ((Boolean) obj).booleanValue());
                }
            });
        }
        ChatView chatView7 = this.chatView;
        if (chatView7 != null) {
            chatView7.setOnMessageListChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.y
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.S1(this.f25152a, ((Boolean) obj).booleanValue());
                }
            });
        }
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AgentSpaceController.T1(view2);
                }
            });
        }
    }

    public final Long L2() {
        if (this.pageResumeElapsedMs > 0) {
            return Long.valueOf(SystemClock.elapsedRealtime() - this.pageResumeElapsedMs);
        }
        return null;
    }

    public final boolean M2() {
        C4148a.k(TAG, "onBackPressed", false, 4, null);
        if (com.stepos.agentframework.util.u.INSTANCE.d() || i4()) {
            return true;
        }
        if (!this.view.C(8388611)) {
            return false;
        }
        this.view.d(8388611);
        return true;
    }

    public final void M3(boolean external) {
        this.isExternalSession = external;
        if (external) {
            B1();
        } else {
            t4(this.keyboardVisible);
        }
    }

    public final void N2() {
        e1();
        b1();
    }

    public final void N3(boolean enabled) {
        this.lockScreenMode = enabled;
        this.view.setDrawerLockMode(enabled ? 1 : 0);
        C4148a.d(TAG, "setLockScreenMode: " + enabled, false, 4, null);
    }

    public final void O2(final IExternalAgentBindService.DisabledInfo info) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            return;
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_disabled_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_enabling);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.v0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.P2();
                }
            });
        }
        iExternalAgentBindService.enableMarketAgent(info.getAssetId(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.x0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.Q2(this.f25150a, info, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void O3(boolean visible) {
        ImageView imageView = this.btnNewSession;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnNewSession");
            imageView = null;
        }
        imageView.setVisibility(visible ? 0 : 8);
        View viewFindViewById = this.view.findViewById(R$id.iv_menu_right_spacer);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(visible ? 4 : 8);
        }
        int i10 = (int) ((visible ? 13 : 10) * z1().getResources().getDisplayMetrics().density);
        View view = this.rightBtnGroup;
        if (view != null) {
            view.setPadding(i10, 0, i10, 0);
        }
    }

    public final void P3(boolean searching) {
        View view = this.searchCancelBtn;
        if (view != null) {
            view.setVisibility(searching ? 0 : 8);
        }
    }

    public final void Q3(List<String> suggestions) {
        if (suggestions.isEmpty()) {
            RecyclerView recyclerView = this.suggestionsRecyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(null);
            }
            RecyclerView recyclerView2 = this.suggestionsRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
                return;
            }
            return;
        }
        RecyclerView recyclerView3 = this.suggestionsRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(0);
        }
        com.stepos.ailauncher.chat.adapter.o0 o0Var = new com.stepos.ailauncher.chat.adapter.o0(suggestions, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.R3(this.f25099a, (String) obj);
            }
        });
        RecyclerView recyclerView4 = this.suggestionsRecyclerView;
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(new LinearLayoutManager(z1()));
        }
        RecyclerView recyclerView5 = this.suggestionsRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(o0Var);
        }
    }

    public final void R2() {
        C4148a.k(TAG, "onNavigateHome", false, 4, null);
        i4();
    }

    public final void S2(IOverlayPageHost host) {
        kotlin.jvm.internal.p.i(host, "host");
        C4148a.d(TAG, "onPageCreate", false, 4, null);
        this.overlayHost = host;
        K1();
        I1();
        V1();
        r2();
        s2();
        X1();
        U1();
        G1();
    }

    public final void S3(List<SessionArtifact> artifacts) {
        ChatView chatView = this.chatView;
        String currentSessionId = chatView != null ? chatView.getCurrentSessionId() : null;
        ChatTracker.INSTANCE.e(currentSessionId, Integer.valueOf(artifacts.size()));
        C1060i.d(this.scope, null, null, new AgentSpaceController$showArtifactsSheet$1(this, artifacts, currentSessionId, null), 3, null);
    }

    public final void T2(OverlayPageDestroyReason reason) {
        MainInputView inputView;
        kotlin.jvm.internal.p.i(reason, "reason");
        y3();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.k3(this.pickResultSessionReadyListener);
        }
        com.stepos.ailauncher.common.utils.y.INSTANCE.g("agent_space");
        InputViewManager.d0(InputViewManager.INSTANCE, null, 1, null);
        w3();
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            ChatView.f3(chatView2, false, reason == OverlayPageDestroyReason.RELAUNCH, 1, null);
        }
        ChatView chatView3 = this.chatView;
        if (chatView3 != null && (inputView = chatView3.getInputView()) != null) {
            BaseInputView.C9(inputView, false, 1, null);
        }
        C4148a.d(TAG, "onPageDestroy reason=" + reason, false, 4, null);
        com.stepos.agentframework.chatui.appui.c cVarA = com.stepos.agentframework.chatui.appui.c.INSTANCE.a();
        Context context = this.view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        cVarA.e(context);
        if (reason == OverlayPageDestroyReason.DESTROY) {
            v3("onPageDestroy:" + reason);
        }
        s4();
        this.agentHomeView = null;
        this.agentCtrl = null;
        this.overlayHost = null;
        ActiveConversationManager activeConversationManager = this.conversationManager;
        if (activeConversationManager != null) {
            activeConversationManager.k();
        }
        this.conversationManager = null;
        ValueAnimator valueAnimator = this.contentMarginAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.contentMarginAnimator = null;
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }

    public final void T3(int hintRes) {
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(hintRes);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            chatView.M3(string, "", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.s0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.U3();
                }
            });
        }
    }

    public final void U1() {
        C4148a.d(TAG, "initConversationManager, chatView:" + this.chatView, false, 4, null);
        ChatView chatView = this.chatView;
        if (chatView == null) {
            return;
        }
        ActiveConversationManager activeConversationManager = new ActiveConversationManager(chatView);
        activeConversationManager.n(this.activeConversationsListener);
        activeConversationManager.i();
        this.conversationManager = activeConversationManager;
    }

    public final void U2() {
        MainInputView inputView;
        MainInputView inputView2;
        C4148a.d(TAG, "onPagePause", false, 4, null);
        s4();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.k3(this.pickResultSessionReadyListener);
        }
        ChatView chatView2 = this.chatView;
        if (chatView2 != null && (inputView2 = chatView2.getInputView()) != null) {
            InputViewManager.INSTANCE.h1(inputView2);
        }
        Context context = this.view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.ailauncher.common.utils.C.a(context, false);
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        ChatView chatView3 = this.chatView;
        vVar.b(chatView3 != null ? chatView3.getCurrentSessionId() : null, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        vVar.q(false, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        com.stepos.ailauncher.common.utils.y.INSTANCE.g("agent_space");
        ChatView chatView4 = this.chatView;
        if (chatView4 != null && (inputView = chatView4.getInputView()) != null) {
            BaseInputView.zc(inputView, null, 1, null);
        }
        ActiveConversationManager activeConversationManager = this.conversationManager;
        if (activeConversationManager != null) {
            activeConversationManager.l();
        }
        ChatHistoryView chatHistoryView = (ChatHistoryView) this.view.findViewById(R$id.v_slide_chat_history);
        if (chatHistoryView != null) {
            chatHistoryView.X0();
        }
        if (this.view.C(8388611)) {
            this.view.d(8388611);
        }
        kotlinx.coroutines.g gVar = this.moreMenuJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.moreMenuJob = null;
        this.moreMenuPopup.e();
        com.google.android.material.bottomsheet.a aVar = this.artifactsSheet;
        if (aVar != null) {
            aVar.dismiss();
        }
        this.artifactsSheet = null;
        com.stepos.ailauncher.container.dialog.f.m();
        this.isPageResumed = false;
    }

    public final void V1() {
        final View viewFindViewById = this.view.findViewById(R$id.iv_more);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentSpaceController.W1(this.f25108a, viewFindViewById, view);
            }
        });
    }

    public final void V2(OverlayPageResumeReason reason) {
        ChatEntrySource entrySource;
        ChatHistoryView chatHistoryView;
        kotlin.jvm.internal.p.i(reason, "reason");
        C4148a.d(TAG, "onPageResume reason=" + reason, false, 4, null);
        l1();
        this.pageResumeElapsedMs = SystemClock.elapsedRealtime();
        if (!this.lockScreenMode) {
            this.homeLeaveReported = false;
            ChatTracker.INSTANCE.p();
        }
        WakeService.Companion companion = WakeService.INSTANCE;
        ExternalSessionRef externalSessionRefQ = companion.Q();
        if (externalSessionRefQ != null) {
            if (this.view.C(8388611)) {
                this.view.d(8388611);
            }
            g3(externalSessionRefQ.getDeviceId(), externalSessionRefQ.getAgentType(), externalSessionRefQ.getDeviceName(), externalSessionRefQ.getDeviceOnline());
        }
        InstalledAgentRef installedAgentRefR = companion.R();
        if (installedAgentRefR != null) {
            if (this.view.C(8388611)) {
                this.view.d(8388611);
            }
            i3(installedAgentRefR.getAssetId(), installedAgentRefR.getDisplayName(), installedAgentRefR.getOnline());
        }
        if (externalSessionRefQ == null || (entrySource = externalSessionRefQ.getEntrySource()) == null) {
            entrySource = installedAgentRefR != null ? installedAgentRefR.getEntrySource() : null;
        }
        if (entrySource != null) {
            H2(this, entrySource, false, 2, null);
        } else {
            int i10 = b.$EnumSwitchMapping$2[reason.ordinal()];
            if (i10 == 1) {
                H2(this, ChatEntrySource.AGENT_SPACE, false, 2, null);
            } else if (i10 == 2) {
                G2(ChatEntrySource.AGENT_SPACE, true);
            } else if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        List<SessionArtifact> list = this.pendingArtifactsRestore;
        if (list != null) {
            this.pendingArtifactsRestore = null;
            S3(list);
        }
        Context context = this.view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.ailauncher.common.utils.C.a(context, true);
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        ChatView chatView = this.chatView;
        String currentSessionId = chatView != null ? chatView.getCurrentSessionId() : null;
        ChatView chatView2 = this.chatView;
        List<String> listP1 = chatView2 != null ? chatView2.P1() : null;
        if (listP1 == null) {
            listP1 = C1173v.m();
        }
        vVar.s(currentSessionId, listP1, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        vVar.q(true, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        vVar.r(true, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        com.stepos.ailauncher.common.utils.y.INSTANCE.i("agent_space");
        ActiveConversationManager activeConversationManager = this.conversationManager;
        if (activeConversationManager != null) {
            activeConversationManager.m();
        }
        ChatView chatView3 = this.chatView;
        boolean z10 = chatView3 != null && chatView3.getHandoffReloadPending();
        boolean z11 = (externalSessionRefQ == null && installedAgentRefR == null && !z10) ? false : true;
        boolean z12 = reason != OverlayPageResumeReason.PAGE_SWITCH;
        ChatView chatView4 = this.chatView;
        if (chatView4 != null) {
            chatView4.T2(true, !z11);
        }
        ChatView chatView5 = this.chatView;
        if (chatView5 != null) {
            chatView5.V2(z11, z12);
        }
        if (z10) {
            this.mainHandler.removeCallbacks(this.updateStatusTask);
            h1(false);
            C4148a.d(TAG, "resume blank guard skipped: handoff reload pending", false, 4, null);
        } else {
            m4();
        }
        ChatView chatView6 = this.chatView;
        if (chatView6 != null) {
            chatView6.p3();
        }
        H3();
        if (this.view.C(8388611) && (chatHistoryView = (ChatHistoryView) this.view.findViewById(R$id.v_slide_chat_history)) != null) {
            ChatHistoryView.q1(chatHistoryView, true, null, 2, null);
        }
        u3();
        RobotManager.INSTANCE.a().u();
        ChatView chatView7 = this.chatView;
        if (chatView7 != null) {
            chatView7.setSuppressPillOverlaySync(false);
        }
        j4();
        if (this.emptyMessage && !z10) {
            h4();
        }
        this.isPageResumed = true;
        this.view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.h
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.W2(this.f25076a);
            }
        });
    }

    public final void V3(final IExternalAgentBindService.DisabledInfo info) {
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_disabled_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_enable_action);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.t0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.W3(this.f25133a, info);
                }
            });
        }
    }

    public final void X1() {
        this.view.setScrimColor(DRAWER_SCRIM_COLOR);
        b1();
        this.view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.a0
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.Y1(this.f25048a);
            }
        });
        final View viewFindViewById = this.view.findViewById(R$id.btn_panel_new_session);
        if (viewFindViewById != null) {
            C2154c.b(viewFindViewById, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.l0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.Z1(this.f25094a, (View) obj);
                }
            });
        }
        if (viewFindViewById != null) {
            viewFindViewById.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.w0
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.a2(this.f25147a, viewFindViewById);
                }
            });
        }
        final ChatHistoryView chatHistoryView = (ChatHistoryView) this.view.findViewById(R$id.v_slide_chat_history);
        if (chatHistoryView != null) {
            chatHistoryView.setChangeConversation(new p9.q() { // from class: com.stepos.ailauncher.chat.controller.E0
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AgentSpaceController.c2(this.f24989a, (String) obj, (String) obj2, (String) obj3);
                }
            });
        }
        if (chatHistoryView != null) {
            chatHistoryView.setCloseDrawerFun(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.F0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.d2(this.f24992a);
                }
            });
        }
        if (chatHistoryView != null) {
            chatHistoryView.setOnDeleteSessionRequested(new p9.p() { // from class: com.stepos.ailauncher.chat.controller.G0
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return AgentSpaceController.e2(this.f24994a, (String) obj, (InterfaceC5074l) obj2);
                }
            });
        }
        final View viewFindViewById2 = this.view.findViewById(R$id.btn_slide_panel_new_chat);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentSpaceController.f2(this.f25080a, view);
                }
            });
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.j
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.g2(this.f25084a, viewFindViewById2);
                }
            });
        }
        if (chatHistoryView != null) {
            chatHistoryView.setOnAddAgentClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.i2(this.f25089a, chatHistoryView);
                }
            });
        }
        if (chatHistoryView != null) {
            chatHistoryView.setOnAgentClicked$chat_release(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSpaceController.j2(this.f25093a, (SidebarAgentItem) obj);
                }
            });
        }
        k2(chatHistoryView);
        this.view.a(new f(this.view.findViewById(R$id.agent_space_content), chatHistoryView, this));
    }

    public final void X2() {
        MainInputView inputView;
        C4148a.d(TAG, "onPageStop", false, 4, null);
        y3();
        com.stepos.ailauncher.common.utils.y.INSTANCE.g("agent_space");
        InputViewManager.d0(InputViewManager.INSTANCE, null, 1, null);
        ChatView chatView = this.chatView;
        if (chatView != null) {
            ChatView.U2(chatView, false, false, 2, null);
        }
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            ChatView.f3(chatView2, false, false, 2, null);
        }
        ChatView chatView3 = this.chatView;
        if (chatView3 != null && (inputView = chatView3.getInputView()) != null) {
            inputView.B9(true);
        }
        w3();
    }

    public final void X3(final IExternalAgentBindService.ReinstallInfo info) {
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_reinstall_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_reinstall_action);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.z0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.Y3(this.f25155a, info);
                }
            });
        }
    }

    public final void Y2(final IExternalAgentBindService.ReinstallInfo info) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            return;
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_reinstall_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_reinstalling);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.C0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.Z2();
                }
            });
        }
        iExternalAgentBindService.installMarketAgent(info.getAssetId(), info.getReversionId(), info.getSemver(), info.getDisplayName(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.D0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.a3(this.f24986a, info, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void Z0(int targetDp) {
        final LinearLayout linearLayout = this.contentContainer;
        if (linearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        final ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        int i10 = (int) (targetDp * z1().getResources().getDisplayMetrics().density);
        ValueAnimator valueAnimator = this.contentMarginAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i11 = marginLayoutParams.topMargin;
        if (i11 == i10) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, i10);
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.controller.j0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                AgentSpaceController.a1(marginLayoutParams, linearLayout, valueAnimator2);
            }
        });
        valueAnimatorOfInt.start();
        this.contentMarginAnimator = valueAnimatorOfInt;
    }

    public final void Z3(ChatHistoryView historyView) {
        if (historyView != null) {
            historyView.setVisibility(0);
        }
        RecyclerView recyclerView = this.searchResultsView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.searchEmptyView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void a4(View anchor) {
        List<SessionItem> list = this.sessionItems;
        if (list == null || list.isEmpty()) {
            return;
        }
        final PopupWindow popupWindowS1 = this.sessionListPopup;
        if (popupWindowS1 == null) {
            popupWindowS1 = s1();
            this.sessionListPopup = popupWindowS1;
        }
        if (popupWindowS1.isShowing()) {
            return;
        }
        View contentView = popupWindowS1.getContentView();
        RecyclerView recyclerView = contentView != null ? (RecyclerView) contentView.findViewById(R$id.recycler_session_list) : null;
        Object adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        com.stepos.ailauncher.chat.adapter.W w10 = adapter instanceof com.stepos.ailauncher.chat.adapter.W ? (com.stepos.ailauncher.chat.adapter.W) adapter : null;
        if (w10 != null) {
            w10.g(this.sessionItems);
        }
        popupWindowS1.showAsDropDown(anchor, 0, 0, 0);
        if (popupWindowS1.isShowing()) {
            com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
            String strC = iVar.c("session_list");
            this.sessionListLayerId = strC;
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = anchor.getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            iVar.e(strC, panelHomePolicy, rootView, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.W
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(AgentSpaceController.b4(popupWindowS1));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.X
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.c4(popupWindowS1);
                }
            }, new com.stepos.ailauncher.chat.panelui.y(popupWindowS1));
        }
    }

    public final void b1() {
        View viewFindViewById = this.view.findViewById(R$id.slide_panel_container);
        if (viewFindViewById == null) {
            return;
        }
        int iT3 = (int) (t3() * 0.85f);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        if (layoutParams.width != iT3) {
            layoutParams.width = iT3;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        O6.b bVar = O6.b.INSTANCE;
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), bVar.a(contextZ1));
    }

    public final void b3(int level) {
        if (level < 20) {
            return;
        }
        C4148a.d(TAG, "onTrimMemory level=" + level, false, 4, null);
        com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        gVar.F(contextZ1, level);
        RecyclerView recyclerView = this.recommendRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(0);
        }
        RecyclerView recyclerView2 = this.suggestionsRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setItemViewCacheSize(0);
        }
        if (level >= 40) {
            kotlinx.coroutines.g gVar2 = this.moreMenuJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            this.moreMenuJob = null;
            this.moreMenuPopup.e();
            com.google.android.material.bottomsheet.a aVar = this.artifactsSheet;
            if (aVar != null) {
                aVar.dismiss();
            }
            this.artifactsSheet = null;
            ChatHistoryView chatHistoryView = (ChatHistoryView) this.view.findViewById(R$id.v_slide_chat_history);
            if (chatHistoryView != null) {
                chatHistoryView.X0();
            }
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.Q3(level);
        }
    }

    public final void c1(ChatLaunchPayload payload, ResultReceiver receiver) {
        final AgentSpaceController agentSpaceController;
        kotlin.jvm.internal.p.i(payload, "payload");
        try {
            ChatTracker.INSTANCE.y("ask_ai_entry");
            String fileId = payload.getFileId();
            if (fileId == null || fileId.length() == 0) {
                agentSpaceController = this;
            } else {
                String strA = com.stepos.ailauncher.chat.wake.T.INSTANCE.a(payload.getFileId());
                if (strA == null || strA.length() == 0) {
                    agentSpaceController = this;
                } else {
                    agentSpaceController = this;
                    F3(agentSpaceController, strA, payload.getFileId(), 0, 4, null);
                }
                agentSpaceController.pendingExternalFileId = payload.getFileId();
            }
            if (!payload.d().isEmpty()) {
                agentSpaceController.externalSuggestionsApplied = true;
                agentSpaceController.Q3(payload.d());
            }
            String prompt = payload.getPrompt();
            if ((prompt != null && prompt.length() != 0) || !payload.b().isEmpty()) {
                agentSpaceController.x2(payload, receiver, 0);
                return;
            }
            if (receiver != null) {
                receiver.send(0, new Bundle());
            }
            if (agentSpaceController.pendingExternalFileId != null) {
                agentSpaceController.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.A
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgentSpaceController.d1(this.f24979a);
                    }
                }, 1000L);
            }
        } catch (Throwable th) {
            C4148a.g(TAG, "applyExternalPayload failed", th, false, 8, null);
            if (receiver != null) {
                String message = th.getMessage();
                if (message == null) {
                    message = "internal error";
                }
                receiver.send(1, x0.c.a(Y8.j.a("key_message", message)));
            }
        }
    }

    public final void c3(final IExternalAgentBindService.UpdateInfo info) {
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            return;
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_update_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_updating);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.A0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.d3();
                }
            });
        }
        iExternalAgentBindService.updateMarketAgent(info.getAssetId(), info.getReversionId(), info.getSemver(), info.getDisplayName(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.B0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.e3(this.f24982a, info, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void d4(final IExternalAgentBindService.UpdateInfo info) {
        ChatView chatView = this.chatView;
        if (chatView != null) {
            String string = z1().getString(R$string.chat_agent_update_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            String string2 = z1().getString(R$string.chat_agent_update_action);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            chatView.M3(string, string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.y0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentSpaceController.e4(this.f25153a, info);
                }
            });
        }
    }

    public final void e1() {
        int i10 = z1().getResources().getConfiguration().screenHeightDp;
        if (i10 <= 0) {
            return;
        }
        HomeContentTier homeContentTier = i10 >= TIER_NORMAL_MIN_DP ? HomeContentTier.NORMAL : i10 >= TIER_COMPACT_MIN_DP ? HomeContentTier.COMPACT : HomeContentTier.TINY;
        if (this.homeTier == homeContentTier) {
            return;
        }
        this.homeTier = homeContentTier;
        C4148a.d(TAG, "applyHomeContentForHeight screenHeightDp=" + i10 + " tier=" + homeContentTier, false, 4, null);
        f1(homeContentTier);
    }

    public final void f1(HomeContentTier tier) {
        int i10;
        float f10 = z1().getResources().getDisplayMetrics().density;
        AgentView agentView = this.agentHomeView;
        if (agentView == null) {
            agentView = (AgentView) this.view.findViewById(R$id.agent);
        }
        if (agentView != null) {
            int[] iArr = b.$EnumSwitchMapping$3;
            int i11 = iArr[tier.ordinal()];
            int i12 = 240;
            if (i11 == 1) {
                i10 = 180;
            } else if (i11 == 2) {
                i10 = 240;
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i10 = AGENT_VIEW_WIDTH_DP;
            }
            int i13 = iArr[tier.ordinal()];
            if (i13 == 1) {
                i12 = AGENT_VIEW_HEIGHT_TINY_DP;
            } else if (i13 == 2) {
                i12 = AGENT_VIEW_HEIGHT_COMPACT_DP;
            } else if (i13 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ViewGroup.LayoutParams layoutParams = agentView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = g1(f10, i10);
                layoutParams.height = g1(f10, i12);
            } else {
                layoutParams = null;
            }
            agentView.setLayoutParams(layoutParams);
            agentView.setVisibility(this.isExternalSession ? 4 : 0);
        }
        int i14 = b.$EnumSwitchMapping$3[tier.ordinal()];
        float f11 = i14 != 1 ? i14 != 2 ? 20.0f : 16.0f : 14.0f;
        TextView textView = this.tvGreeting;
        if (textView != null) {
            textView.setTextSize(2, f11);
        }
        LinearLayout linearLayout = this.contentContainer;
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = g1(f10, q1(this.keyboardVisible));
                linearLayout.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:2:0x0000, B:5:0x000a, B:9:0x002e, B:8:0x001f), top: B:17:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f3(u4.m.FolderMessage r7) {
        /*
            r6 = this;
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            p9.p r0 = com.stepos.agentframework.chatui.AgentFileSyncBridge.b()     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "<get-context>(...)"
            if (r0 == 0) goto L1f
            android.content.Context r2 = r6.z1()     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.p.h(r2, r1)     // Catch: java.lang.Throwable -> L35
            java.lang.Object r0 = r0.invoke(r2, r7)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L35
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L35
            r2 = 1
            if (r0 != r2) goto L1f
            goto L2e
        L1f:
            com.stepos.agentframework.chatui.folder.FolderTreeSheet r0 = new com.stepos.agentframework.chatui.folder.FolderTreeSheet     // Catch: java.lang.Throwable -> L35
            android.content.Context r6 = r6.z1()     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.p.h(r6, r1)     // Catch: java.lang.Throwable -> L35
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L35
            r0.show()     // Catch: java.lang.Throwable -> L35
        L2e:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L35
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L41
        L35:
            r0 = move-exception
            r6 = r0
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L41:
            java.lang.Throwable r2 = kotlin.Result.e(r6)
            if (r2 == 0) goto L53
            r4 = 8
            r5 = 0
            java.lang.String r0 = "AILauncher-AgentSpaceController"
            java.lang.String r1 = "openFileTree failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController.f3(u4.m$d):void");
    }

    public final void f4() {
        D1();
        r1();
        LinearLayout linearLayout = this.contentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        O3(false);
        this.view.d(8388611);
    }

    public final void g3(final String deviceId, final String agentType, final String deviceName, final boolean online) {
        AgentConfig.INSTANCE.a().v();
        this.isExternalSession = true;
        this.currentExternalDeviceId = deviceId;
        this.currentExternalAgentType = agentType;
        this.currentExternalDeviceName = deviceName;
        this.view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.J
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.h3(this.f25005a, deviceId, agentType, deviceName, online);
            }
        });
    }

    public final void g4() {
        String str;
        String str2;
        D1();
        ChatView chatView = this.chatView;
        String strQ1 = chatView != null ? chatView.Q1() : null;
        String strR1 = chatView != null ? chatView.R1() : null;
        String string = strQ1 != null ? La.H.D1(strQ1).toString() : null;
        if (string == null) {
            string = "";
        }
        TopBarNewSessionTarget topBarNewSessionTargetA = J0.a(strQ1 != null && com.stepos.agentframework.adapter.agentbus.bff.j.b(strQ1), strR1, (strR1 == null || La.H.x0(strR1)) && string.length() > 0 && !PrimaryAgent.INSTANCE.a(string) && !com.stepos.agentframework.adapter.agentbus.bff.j.b(string));
        int i10 = b.$EnumSwitchMapping$5[topBarNewSessionTargetA.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (chatView != null) {
                    ChatView.L1(chatView, string, "", false, 4, null);
                }
                String strA = com.stepos.ailauncher.chat.wake.L.INSTANCE.a(string);
                if (strA != null) {
                    if (La.H.x0(strA)) {
                        strA = null;
                    }
                    if (strA != null) {
                        C2996w.d(this.view, strA, true);
                        M3(true);
                    }
                }
            } else if (chatView != null) {
                str = strQ1;
                str2 = strR1;
                ChatView.L1(chatView, str, str2, false, 4, null);
            }
            str = strQ1;
            str2 = strR1;
        } else {
            str = strQ1;
            str2 = strR1;
            r1();
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str3 = String.format("startNewSessionSameAgent agentId=%s deviceId=%s target=%s", Arrays.copyOf(new Object[]{str, str2, topBarNewSessionTargetA}, 3));
        kotlin.jvm.internal.p.h(str3, "format(...)");
        C4148a.k(TAG, str3, false, 4, null);
        LinearLayout linearLayout = this.contentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        O3(false);
        this.view.d(8388611);
    }

    public final void h1(boolean isEmpty) {
        this.emptyMessage = isEmpty;
        if (isEmpty) {
            LinearLayout linearLayout = this.contentContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            h4();
        } else {
            LinearLayout linearLayout2 = this.contentContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            C1();
        }
        O3(!isEmpty);
    }

    public final void h4() {
        if (this.isExternalSession) {
            B1();
            return;
        }
        AgentView agentView = this.agentHomeView;
        if (agentView != null) {
            agentView.setVisibility(0);
        }
        L4.b bVar = this.agentCtrl;
        if (bVar != null) {
            b.a.a(bVar, l.C0928a.INSTANCE, 0L, 0, 6, null);
        }
    }

    public final void i1(String keyword, ChatHistoryView historyView) {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        if (keyword.length() == 0) {
            com.stepos.ailauncher.chat.adapter.J j10 = this.searchResultAdapter;
            if (j10 != null) {
                j10.clear();
            }
            Z3(historyView);
            return;
        }
        if (historyView != null) {
            historyView.setVisibility(8);
        }
        RecyclerView recyclerView = this.searchResultsView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.searchEmptyView;
        if (view != null) {
            view.setVisibility(8);
        }
        this.searchJob = C1060i.d(this.scope, null, null, new AgentSpaceController$applySearchState$1(keyword, this, historyView, null), 3, null);
    }

    public final void i3(final String assetId, final String displayName, final boolean online) {
        if (La.H.x0(assetId)) {
            C4148a.u(TAG, "openFreshInstalledChat skipped: blank assetId, name=" + displayName, false, 4, null);
            return;
        }
        AgentConfig.INSTANCE.a().v();
        this.isExternalSession = true;
        this.currentExternalDeviceId = null;
        this.currentExternalAgentType = null;
        this.currentExternalDeviceName = displayName;
        this.view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.I
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.j3(this.f24998a, displayName, online, assetId);
            }
        });
    }

    public final boolean i4() {
        BaseInputView baseInputViewR0;
        ChatView chatView = this.chatView;
        if ((chatView == null || (baseInputViewR0 = chatView.getInputView()) == null) && (baseInputViewR0 = InputViewManager.INSTANCE.r0()) == null) {
            return false;
        }
        if (!baseInputViewR0.a8() && !baseInputViewR0.R7()) {
            return false;
        }
        C4148a.k(TAG, "stopVoiceSessionIfActive: stopping " + baseInputViewR0.getClass().getSimpleName(), false, 4, null);
        BaseInputView.zc(baseInputViewR0, null, 1, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j1(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Boolean r13) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController.j1(java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean):void");
    }

    public final void j4() {
        final View viewFindViewById;
        View viewFindViewById2 = this.view.findViewById(R$id.btn_apps);
        if (viewFindViewById2 == null) {
            return;
        }
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (y1(contextZ1) != null) {
            viewFindViewById2.setVisibility(8);
            return;
        }
        boolean zH = com.stepos.ailauncher.container.m0.INSTANCE.h();
        viewFindViewById2.setVisibility(zH ? 0 : 8);
        if (zH) {
            viewFindViewById2.setAlpha(this.keyboardVisible ? 0.0f : 1.0f);
        }
        if (zH && this.btnAppsMaterialHandle == null && (viewFindViewById = this.view.findViewById(R$id.btn_apps_pill)) != null) {
            viewFindViewById.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.V
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.k4(this.f25034a, viewFindViewById);
                }
            });
        }
    }

    public final void k2(final ChatHistoryView historyView) {
        this.searchEditText = (EditText) this.view.findViewById(R$id.et_slide_panel_search);
        this.searchClearBtn = this.view.findViewById(R$id.iv_slide_panel_search_clear);
        this.searchCancelBtn = this.view.findViewById(R$id.tv_slide_panel_search_cancel);
        this.searchResultsView = (RecyclerView) this.view.findViewById(R$id.rv_slide_panel_search_results);
        this.drawerHistoryList = historyView != null ? (RecyclerView) historyView.findViewById(R$id.rv_chat_history) : null;
        this.searchEmptyView = this.view.findViewById(R$id.empty_search_result);
        final View viewFindViewById = this.view.findViewById(R$id.slide_panel_search_box);
        if (viewFindViewById != null) {
            viewFindViewById.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.B
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.l2(this.f24980a, viewFindViewById);
                }
            });
        }
        this.searchResultAdapter = new com.stepos.ailauncher.chat.adapter.J(new AgentSpaceController$initSlideSearch$2(this), new AgentSpaceController$initSlideSearch$3(this));
        RecyclerView recyclerView = this.searchResultsView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(z1()));
        }
        RecyclerView recyclerView2 = this.searchResultsView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.searchResultAdapter);
        }
        EditText editText = this.searchEditText;
        if (editText != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.C
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentSpaceController.n2(view);
                }
            });
        }
        View view = this.searchClearBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AgentSpaceController.o2(this.f24988a, view2);
                }
            });
        }
        View view2 = this.searchCancelBtn;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.F
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    AgentSpaceController.p2(this.f24990a, historyView, view3);
                }
            });
        }
        EditText editText2 = this.searchEditText;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.stepos.ailauncher.chat.controller.G
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view3, boolean z10) {
                    AgentSpaceController.q2(this.f24993a, view3, z10);
                }
            });
        }
        EditText editText3 = this.searchEditText;
        if (editText3 != null) {
            editText3.addTextChangedListener(new g(historyView));
        }
    }

    public final void k3(SessionSearchHit hit) {
        if (p1(this, hit.getSessionId(), hit.getAgentId(), hit.getDeviceId(), hit.getAgentLabel(), null, false, 48, null)) {
            ChatTracker.INSTANCE.y("sidebar_historychat");
            p4(hit.getSessionId(), "search", hit.getAgentLabel(), hit.getAgentId());
        }
    }

    public final void l1() {
        L4.b bVar;
        AgentView agentView;
        if (this.spriteBound || (bVar = this.agentCtrl) == null || (agentView = this.agentHomeView) == null) {
            return;
        }
        AgentView.t(agentView, bVar, null, 2, null);
        bVar.a(AgentPlace.c.INSTANCE);
        this.spriteBound = true;
        t4(this.keyboardVisible);
    }

    public final void l3(TaskSearchHit hit) {
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, contextZ1, LockScreenChatAction.CHANGE_SESSION, hit.getSessionId(), null, 8, null)) {
            return;
        }
        ChatTracker.INSTANCE.y("sidebar_historychat");
        q4(this, hit.getSessionId(), "search", null, hit.getAgentId(), 4, null);
        k1(this, hit.getAgentId(), hit.getDeviceId(), null, null, 12, null);
        IUnifiedSessionSearchService iUnifiedSessionSearchService = (IUnifiedSessionSearchService) D5.a.INSTANCE.a(IUnifiedSessionSearchService.class);
        if (iUnifiedSessionSearchService != null) {
            iUnifiedSessionSearchService.markTaskRead(hit.getTaskId());
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.O2(hit.getSessionId(), hit.getTaskId());
        }
        this.view.d(8388611);
    }

    public final int m1(IExternalAgentBindService.BusyKind kind) {
        int i10 = b.$EnumSwitchMapping$0[kind.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return R$string.chat_agent_installing_hint;
        }
        if (i10 == 3) {
            return R$string.chat_agent_updating_hint;
        }
        if (i10 == 4) {
            return R$string.chat_agent_uninstalling_hint;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void m3(SessionArtifact artifact) {
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        ChatView chatView = this.chatView;
        com.stepos.ailauncher.foundation.task.a.a(contextZ1, artifact, M5.c.SOURCE_ARTIFACT_SHEET, chatView != null ? chatView.getCurrentSessionId() : null);
    }

    public final void m4() {
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.M
            @Override // java.lang.Runnable
            public final void run() {
                AgentSpaceController.n4(this.f25016a);
            }
        });
    }

    public final boolean n1(String sessionId, boolean closeDrawer) {
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, contextZ1, LockScreenChatAction.CHANGE_SESSION, sessionId, null, 8, null)) {
            return false;
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.w1(sessionId);
        }
        if (!closeDrawer || !this.view.C(8388611)) {
            return true;
        }
        this.view.d(8388611);
        return true;
    }

    public final void n3(final LockScreenChatAction action) {
        ChatView chatView;
        kotlin.jvm.internal.p.i(action, "action");
        switch (b.$EnumSwitchMapping$4[action.ordinal()]) {
            case 1:
                D1();
                this.view.K(8388611);
                return;
            case 2:
                View view = this.topBar;
                if (view != null) {
                    a4(view);
                    return;
                }
                return;
            case 3:
                D1();
                r1();
                LinearLayout linearLayout = this.contentContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                this.view.d(8388611);
                return;
            case 4:
                String strF = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.f();
                if (strF == null || strF.length() == 0 || (chatView = this.chatView) == null) {
                    return;
                }
                chatView.w1(strF);
                return;
            case 5:
                String strG = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.g();
                if (strG == null || strG.length() == 0) {
                    return;
                }
                com.stepos.ailauncher.chat.lockscreen.E e10 = com.stepos.ailauncher.chat.lockscreen.E.INSTANCE;
                Context contextZ1 = z1();
                kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
                e10.a(contextZ1, strG);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                ChatView chatView2 = this.chatView;
                if (chatView2 != null) {
                    chatView2.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.m0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AgentSpaceController.o3(this.f25100a, action);
                        }
                    });
                    return;
                }
                return;
            case 11:
            case 12:
            case 13:
            case 14:
                C4148a.u(TAG, "performLockScreenRestoredAction: unsupported on legacy stack action=" + action, false, 4, null);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean o1(String sessionId, String agentId, String deviceId, String agentLabel, Boolean deviceOnline, boolean closeDrawer) {
        if (!n1(sessionId, false)) {
            return false;
        }
        j1(agentId, deviceId, agentLabel, deviceOnline);
        if (!closeDrawer || !this.view.C(8388611)) {
            return true;
        }
        this.view.d(8388611);
        return true;
    }

    public final void o4() {
        E.Companion companion = com.stepos.agentframework.util.E.INSTANCE;
        com.stepos.agentframework.util.E eA = companion.a();
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        com.stepos.agentframework.util.C c10 = com.stepos.agentframework.util.C.INSTANCE;
        boolean zE = com.stepos.agentframework.util.E.e(eA, contextZ1, c10.b(), false, null, 12, null);
        com.stepos.agentframework.util.E eA2 = companion.a();
        Context contextZ12 = z1();
        kotlin.jvm.internal.p.h(contextZ12, "<get-context>(...)");
        com.stepos.agentframework.util.E.k(eA2, contextZ12, c10.b(), !zE, null, 8, null);
        x3(zE ? "close" : "open");
        if (!zE) {
            Toast.makeText(z1(), R$string.auto_read_on, 0).show();
            return;
        }
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.N3();
        }
        Toast.makeText(z1(), R$string.auto_read_off, 0).show();
    }

    public final void p3(final LockScreenChatAction action, final int attempt) {
        kotlin.jvm.internal.p.i(action, "action");
        switch (b.$EnumSwitchMapping$4[action.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 5:
                n3(action);
                return;
            case 4:
                String strF = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.f();
                if (strF == null || strF.length() == 0) {
                    C4148a.u(TAG, "performLockScreenRestoredActionWhenReady: missing sessionId", false, 4, null);
                    return;
                } else {
                    F3(this, strF, "lock_screen_unlock", 0, 4, null);
                    return;
                }
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                ChatView chatView = this.chatView;
                MainInputView inputView = chatView != null ? chatView.getInputView() : null;
                if (inputView != null && inputView.X7()) {
                    inputView.Y8(action);
                    return;
                }
                if (attempt < 30) {
                    this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.T
                        @Override // java.lang.Runnable
                        public final void run() {
                            AgentSpaceController.r3(this.f25027a, action, attempt);
                        }
                    }, 100L);
                    return;
                }
                C4148a.u(TAG, "performLockScreenRestoredActionWhenReady timeout action=" + action, false, 4, null);
                return;
            case 11:
            case 12:
            case 13:
            case 14:
                C4148a.u(TAG, "performLockScreenRestoredActionWhenReady: unsupported on legacy stack action=" + action, false, 4, null);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void p4(String sessionId, String entryType, String agentName, String agentType) {
        C1060i.d(this.scope, null, null, new AgentSpaceController$trackSidebarCardClick$1(sessionId, entryType, agentName, agentType, null), 3, null);
    }

    public final int q1(boolean imeVisible) {
        HomeContentTier homeContentTier = this.homeTier;
        int i10 = homeContentTier == null ? -1 : b.$EnumSwitchMapping$3[homeContentTier.ordinal()];
        return i10 != 1 ? i10 != 2 ? imeVisible ? 50 : 150 : imeVisible ? 40 : 70 : imeVisible ? 30 : 40;
    }

    public final void r1() {
        ChatView chatView = this.chatView;
        if (chatView != null) {
            ChatView.L1(chatView, null, "", false, 4, null);
        }
        C2996w.h(this.view);
        F1();
        M3(false);
    }

    public final void r2() {
        Q3(C1173v.m());
    }

    public final boolean r4(float rawX, float rawY) {
        MainInputView inputView;
        if (!this.keyboardVisible) {
            return false;
        }
        if (this.keyboardDismissRequestedAtMs != 0 && SystemClock.elapsedRealtime() - this.keyboardDismissRequestedAtMs > KEYBOARD_INSETS_SYNC_TIMEOUT_MS) {
            if (!this.keyboardDesyncLogged) {
                this.keyboardDesyncLogged = true;
                C4148a.u(TAG, "IME insets 失联（请求收键盘后无回调），放行点击不再吞 DOWN", false, 4, null);
            }
            return false;
        }
        ChatView chatView = this.chatView;
        if (chatView == null || (inputView = chatView.getInputView()) == null || inputView.a8() || inputView.R7()) {
            return false;
        }
        boolean zC = this.view.C(8388611);
        View viewFindViewById = this.view.findViewById(R$id.slide_panel_container);
        if (!zC) {
            if (A2(rawX) || C2(rawX, rawY, inputView)) {
                return false;
            }
            F2();
            inputView.n6();
            return true;
        }
        if (viewFindViewById != null && C2(rawX, rawY, viewFindViewById)) {
            View view = this.searchEditText;
            if (view != null && view.hasFocus()) {
                if (C2(rawX, rawY, view) || E2(rawX, rawY)) {
                    return false;
                }
                F2();
                E1(view);
                view.clearFocus();
                return true;
            }
            if (!C2(rawX, rawY, inputView)) {
                F2();
                inputView.n6();
                return true;
            }
        }
        return false;
    }

    public final PopupWindow s1() {
        View viewInflate = LayoutInflater.from(z1()).inflate(R$layout.popup_session_list, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.recycler_session_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(z1()));
        recyclerView.setAdapter(new com.stepos.ailauncher.chat.adapter.W(this.sessionItems, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.p0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.t1(this.f25117a, (SessionItem) obj);
            }
        }));
        PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.ailauncher.chat.controller.q0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                AgentSpaceController.u1(this.f25120a);
            }
        });
        return popupWindow;
    }

    public final void s2() {
        this.titleDropdownArea = this.view.findViewById(R$id.title_dropdown_area);
        final View viewFindViewById = this.view.findViewById(R$id.iv_menu);
        this.topBar = this.view.findViewById(R$id.top_bar);
        this.tvSubtitle = (TextView) this.view.findViewById(R$id.tv_subtitle);
        View view = this.titleDropdownArea;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AgentSpaceController.t2(this.f25129a, view2);
                }
            });
        }
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.controller.D
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AgentSpaceController.u2(this.f24984a, viewFindViewById, view2);
                }
            });
        }
        for (final View view2 : C1173v.r(viewFindViewById, this.view.findViewById(R$id.right_btn_group))) {
            view2.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.O
                @Override // java.lang.Runnable
                public final void run() {
                    AgentSpaceController.v2(this.f25019a, view2);
                }
            });
        }
    }

    public final void s4() {
        if (this.spriteBound) {
            AgentView agentView = this.agentHomeView;
            if (agentView != null) {
                agentView.c0();
            }
            this.spriteBound = false;
        }
    }

    public final int t3() {
        DisplayMetrics displayMetrics = z1().getResources().getDisplayMetrics();
        int iF = C5685n.f(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), 1);
        int width = this.view.getWidth();
        return width > 0 ? Math.min(width, iF) : iF;
    }

    public final void t4(boolean keyboardShown) {
        if (this.isExternalSession) {
            B1();
            return;
        }
        if (keyboardShown) {
            L4.b bVar = this.agentCtrl;
            if (bVar != null) {
                b.a.a(bVar, l.C0929b.INSTANCE, 0L, 0, 6, null);
                return;
            }
            return;
        }
        L4.b bVar2 = this.agentCtrl;
        if (bVar2 != null) {
            bVar2.b(l.C0928a.INSTANCE, true);
        }
    }

    public final void u3() {
        String str;
        if (this.isExternalSession && (str = this.currentExternalDeviceId) != null) {
            if (La.H.x0(str)) {
                str = null;
            }
            if (str == null) {
                return;
            }
            String str2 = this.currentExternalAgentType;
            if (str2 == null) {
                str2 = "";
            }
            C1060i.d(this.scope, null, null, new AgentSpaceController$refreshExternalTopBarOnline$1(this, str, str2, null), 3, null);
        }
    }

    public final void u4(String agentId, String deviceId, String displayName) {
        final String string = agentId != null ? La.H.D1(agentId).toString() : null;
        if (string == null) {
            string = "";
        }
        if ((deviceId != null && !La.H.x0(deviceId)) || string.length() <= 0 || PrimaryAgent.INSTANCE.a(string) || com.stepos.agentframework.adapter.agentbus.bff.j.b(string)) {
            F1();
            return;
        }
        this.reinstallBannerAgentId = string;
        K0.INSTANCE.b();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.g2();
        }
        final IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            return;
        }
        iExternalAgentBindService.resolveBusyMarketAgent(string, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSpaceController.v4(this.f25010a, string, iExternalAgentBindService, (IExternalAgentBindService.BusyInfo) obj);
            }
        });
    }

    public final void v1(String sessionId, InterfaceC5074l<? super Boolean, Y8.t> callback) {
        SidebarSessionMutations.b(SidebarSessionMutations.INSTANCE, this.scope, sessionId, false, null, callback, 8, null);
    }

    public final void v3(String reason) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            A4.b.INSTANCE.a().i();
            objB = Result.b(Integer.valueOf(C4148a.k(TAG, "WidgetHolder.release ok reason=" + reason, false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "WidgetHolder.release failed reason=" + reason, thE, false, 8, null);
        }
    }

    public final void w1() {
        com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
        Context contextZ1 = z1();
        kotlin.jvm.internal.p.h(contextZ1, "<get-context>(...)");
        a10.a(contextZ1, this.view);
    }

    public final void w3() {
        C2851i7.INSTANCE.h(this.btnAppsMaterialHandle);
        this.btnAppsMaterialHandle = null;
        Iterator<T> it = this.topBarGlassHandles.iterator();
        while (it.hasNext()) {
            C2851i7.INSTANCE.h((y7.E) it.next());
        }
        this.topBarGlassHandles.clear();
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        c2851i7.h(this.searchBoxGlassHandle);
        this.searchBoxGlassHandle = null;
        c2851i7.h(this.panelNewSessionGlassHandle);
        this.panelNewSessionGlassHandle = null;
        c2851i7.h(this.newChatPillGlassHandle);
        this.newChatPillGlassHandle = null;
    }

    public final void x1(ChatHistoryView historyView) {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        P3(false);
        View view = this.searchClearBtn;
        if (view != null) {
            view.setVisibility(8);
        }
        com.stepos.ailauncher.chat.adapter.J j10 = this.searchResultAdapter;
        if (j10 != null) {
            j10.clear();
        }
        Z3(historyView);
    }

    public final void x2(final ChatLaunchPayload payload, final ResultReceiver receiver, final int attempt) {
        ChatView chatView = this.chatView;
        MainInputView inputView = chatView != null ? chatView.getInputView() : null;
        if (inputView == null || !inputView.X7()) {
            if (attempt < 30 && (inputView != null || this.chatView != null)) {
                this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgentSpaceController.z2(this.f25051a, payload, receiver, attempt);
                    }
                }, 100L);
                return;
            }
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("injectPayloadWhenReady: inputView not ready after %d attempts", Arrays.copyOf(new Object[]{Integer.valueOf(attempt)}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(TAG, str, false, 4, null);
            if (receiver != null) {
                receiver.send(1, x0.c.a(Y8.j.a("key_message", "inputView not ready")));
                return;
            }
            return;
        }
        try {
            List<String> listB = payload.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.parse((String) it.next()));
            }
            inputView.G4(payload.getPrompt(), arrayList);
            if (receiver != null) {
                receiver.send(0, new Bundle());
            }
            if (this.pendingExternalFileId != null) {
                this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgentSpaceController.y2(this.f25046a);
                    }
                }, 1000L);
            }
        } catch (Throwable th) {
            C4148a.g(TAG, "injectPayloadWhenReady inject failed", th, false, 8, null);
            if (receiver != null) {
                String message = th.getMessage();
                if (message == null) {
                    message = "inject failed";
                }
                receiver.send(1, x0.c.a(Y8.j.a("key_message", message)));
            }
        }
    }

    public final void x3(String status) {
        ChatTracker chatTracker = ChatTracker.INSTANCE;
        Ua.M m10 = this.scope;
        ChatView chatView = this.chatView;
        String currentSessionId = chatView != null ? chatView.getCurrentSessionId() : null;
        ChatView chatView2 = this.chatView;
        chatTracker.F(m10, currentSessionId, chatView2 != null ? chatView2.P2() : null, status);
    }

    public final Activity y1(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void y3() {
        if (this.lockScreenMode || this.homeLeaveReported) {
            return;
        }
        this.homeLeaveReported = true;
        ChatTracker.INSTANCE.o(L2());
    }

    public final Context z1() {
        return this.view.getContext();
    }

    public final void z3() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        Float fValueOf = Float.valueOf(22.0f);
        if (this.isPageResumed && this.overlayHost != null && this.view.isAttachedToWindow()) {
            if (this.topBarGlassHandles.isEmpty()) {
                for (View view : C1173v.r(this.view.findViewById(R$id.iv_menu), this.view.findViewById(R$id.right_btn_group))) {
                    C2851i7 c2851i7 = C2851i7.INSTANCE;
                    y7.E eD = C2851i7.d(c2851i7, view, false, fValueOf, null, 8, null);
                    if (eD != null) {
                        this.topBarGlassHandles.add(eD);
                        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.N
                            @Override // p9.InterfaceC5074l
                            public final Object invoke(Object obj) {
                                return AgentSpaceController.A3(this.f25018a, (y7.E) obj);
                            }
                        });
                    }
                }
            }
            if (this.panelNewSessionGlassHandle == null && (viewFindViewById3 = this.view.findViewById(R$id.btn_panel_new_session)) != null) {
                C2851i7 c2851i72 = C2851i7.INSTANCE;
                y7.E eD2 = C2851i7.d(c2851i72, viewFindViewById3, false, fValueOf, null, 8, null);
                this.panelNewSessionGlassHandle = eD2;
                c2851i72.i(viewFindViewById3, eD2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.P
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return AgentSpaceController.B3(this.f25021a, (y7.E) obj);
                    }
                });
            }
            if (this.newChatPillGlassHandle == null && (viewFindViewById2 = this.view.findViewById(R$id.btn_slide_panel_new_chat)) != null) {
                C2851i7 c2851i73 = C2851i7.INSTANCE;
                y7.E eD3 = C2851i7.d(c2851i73, viewFindViewById2, false, fValueOf, null, 8, null);
                this.newChatPillGlassHandle = eD3;
                c2851i73.i(viewFindViewById2, eD3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.Q
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return AgentSpaceController.C3(this.f25022a, (y7.E) obj);
                    }
                });
            }
            if (this.searchBoxGlassHandle == null && (viewFindViewById = this.view.findViewById(R$id.slide_panel_search_box)) != null) {
                C2851i7 c2851i74 = C2851i7.INSTANCE;
                y7.E eD4 = C2851i7.d(c2851i74, viewFindViewById, false, fValueOf, null, 8, null);
                this.searchBoxGlassHandle = eD4;
                c2851i74.i(viewFindViewById, eD4, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.S
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return AgentSpaceController.D3(this.f25025a, (y7.E) obj);
                    }
                });
            }
            j4();
        }
    }
}
