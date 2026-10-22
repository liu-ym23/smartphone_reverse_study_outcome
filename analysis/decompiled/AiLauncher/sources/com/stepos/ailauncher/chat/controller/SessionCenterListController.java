package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.os.SystemClock;
import android.view.AbstractC1393k;
import android.view.C1398p;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.S;
import com.stepos.ailauncher.chat.controller.SessionCenterListController;
import com.stepos.ailauncher.chat.controller.SidebarAgentActionsController;
import com.stepos.ailauncher.chat.controller.SidebarSessionActionsController;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.H8;
import com.stepos.ailauncher.chat.view.M8;
import com.stepos.ailauncher.chat.view.RemainingSpaceLinearLayout;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import com.stepos.ailauncher.chat.view.SidebarSnapshot;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.contract.model.search.SidebarSessionKind;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0006¦\u0001©\u0001¯\u0001\b\u0000\u0018\u0000 ²\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MB\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\rJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\rJ\u001d\u0010$\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0015H\u0002¢\u0006\u0004\b$\u0010\u0019J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\rJ\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\"H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010\u001dJ\u001d\u0010-\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\"0\u0015H\u0002¢\u0006\u0004\b4\u0010\u0019J\u0017\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020+H\u0002¢\u0006\u0004\b6\u00107J)\u0010<\u001a\u00020\u000b2\u0006\u00109\u001a\u0002082\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bA\u0010\u001dJ\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bB\u0010\u001dJ\r\u0010C\u001a\u00020\u000b¢\u0006\u0004\bC\u0010\rJ\r\u0010D\u001a\u00020\u000b¢\u0006\u0004\bD\u0010\rJ\u0017\u0010E\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bE\u0010\u001dJ\u0017\u0010F\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bF\u0010\u001dJ\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\rJ)\u0010J\u001a\u00020\u000b2\b\b\u0002\u0010H\u001a\u00020\u000e2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004¢\u0006\u0004\bJ\u0010KJ\u0011\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\bO\u00102J\u001f\u0010R\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u000eH\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u000bH\u0016¢\u0006\u0004\bT\u0010\rJ\u0019\u0010U\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\bU\u00107J\u0017\u0010W\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000eH\u0016¢\u0006\u0004\bW\u0010XJ\u001d\u0010Y\u001a\u00020\u000b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\bY\u0010\bJ\r\u0010Z\u001a\u00020\u000b¢\u0006\u0004\bZ\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010[R0\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR0\u0010c\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000b\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010^\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR2\u0010f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010^\u001a\u0004\bg\u0010`\"\u0004\bh\u0010bR\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010sR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\"0\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020/0\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010vR\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010vR\u0018\u0010~\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010{R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008b\u0001R\u001e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001f\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008f\u0001R'\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008b\u0001R%\u0010\u0098\u0001\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0094\u0001R\u001f\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u008f\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010qR\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R3\u0010\u009e\u0001\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020w\u0012\u0006\u0012\u0004\u0018\u00010+0\u009d\u00010\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0094\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u008b\u0001R\u001a\u0010 \u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0018\u0010¢\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010{R\u0018\u0010£\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b£\u0001\u0010{R\u0018\u0010¤\u0001\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010yR\u0018\u0010¥\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010{R\u0018\u0010§\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010ª\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010°\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001¨\u0006³\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionCenterListController;", "Landroidx/lifecycle/e;", "Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController$a;", "Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$b;", "Lkotlin/Function0;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "fallbackSessionHandler", "<init>", "(Lp9/a;)V", "z0", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "LY8/t;", "E0", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "()Z", "Lcom/stepos/ailauncher/chat/view/Y8;", "snapshot", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/ailauncher/chat/view/Y8;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "agents", "U", "(Ljava/util/List;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "m0", "(Landroidx/lifecycle/LifecycleOwner;)V", "p0", "h0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D0", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "paged", "i0", "F0", "session", "g0", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "o0", "", "", "ids", "q0", "(Ljava/util/Set;)V", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "f0", "(Lcom/stepos/ailauncher/chat/view/s8;)V", "sessions", "u0", "sessionId", "l0", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", "maskHost", "X", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/lifecycle/LifecycleOwner;Landroid/view/ViewGroup;)V", "handler", "A0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", UxipConstants.f30640D, "onResume", "s0", "r0", "onPause", "onDestroy", "e0", "refreshAgents", "onUpdated", "w0", "(ZLp9/a;)V", "LUa/M;", Const.INTENT_KEY_APIKEY, "()LUa/M;", Const.INTENT_KEY_UMID, "assetId", "uninstalling", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", ChatTracker.PREVIEW_LOADING, "f", "(Z)V", "e", "y0", "Lp9/a;", "Lkotlin/Function1;", "onSessionClick", "Lp9/l;", "getOnSessionClick", "()Lp9/l;", "C0", "(Lp9/l;)V", "onAgentClick", "getOnAgentClick", "B0", "onCurrentSessionRemoved", "getOnCurrentSessionRemoved", "setOnCurrentSessionRemoved", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/stepos/ailauncher/chat/adapter/S;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/S;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlinx/coroutines/g;", "loadJob", "Lkotlinx/coroutines/g;", "liveSessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "callbackHandler", "allSessions", "Ljava/util/List;", "", "loadedCount", "I", "isLoadingMore", "Z", "agentItems", "sidebarAgents", "highlightAgent", "Lcom/stepos/ailauncher/chat/view/s8;", "agentExpanded", "Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController;", "agentActions", "Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController;", "Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController;", "sessionActions", "Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController;", "Lcom/stepos/ailauncher/chat/view/M8;", "loadingMask", "Lcom/stepos/ailauncher/chat/view/M8;", "menuAgentKey", "Ljava/lang/String;", "menuSessionId", "", "uninstallingAssetIds", "Ljava/util/Set;", "activeConversationIds", "", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "chatActivityStates", "Ljava/util/Map;", "currentSessionId", "", "", "optimisticReadSessions", "displayedConversationIds", "displayedReadJob", "mainSession", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "Lkotlin/Pair;", "taskPresentationStates", "lastActivityDiagSignature", "agentsLoadedAtMs", "J", "firstLoadDelivered", "warmUpLoading", "seenAgentListRevision", "pageHidden", "com/stepos/ailauncher/chat/controller/SessionCenterListController$c", "scrollListener", "Lcom/stepos/ailauncher/chat/controller/SessionCenterListController$c;", "com/stepos/ailauncher/chat/controller/SessionCenterListController$d", "taskCardCallback", "Lcom/stepos/ailauncher/chat/controller/SessionCenterListController$d;", "Ljava/lang/Runnable;", "debouncedRefresh", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/controller/SessionCenterListController$b", "conversationListCallback", "Lcom/stepos/ailauncher/chat/controller/SessionCenterListController$b;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionCenterListController implements InterfaceC1387e, SidebarAgentActionsController.a, SidebarSessionActionsController.b {

    @Deprecated
    public static final long AGENTS_STALE_AFTER_MS = 2000;

    @Deprecated
    public static final int COLLAPSED_AGENT_COUNT = 3;

    @Deprecated
    public static final long CONVERSATION_LIST_REFRESH_DEBOUNCE_MS = 200;
    private static final a Companion = new a(null);

    @Deprecated
    public static final int EXPANDED_AGENT_COUNT = 8;

    @Deprecated
    public static final int LOAD_MORE_PREFETCH = 5;

    @Deprecated
    public static final int PAGE_SIZE = 20;

    @Deprecated
    public static final String TAG = "SessionCenterList";
    private Set<String> activeConversationIds;
    private com.stepos.ailauncher.chat.adapter.S adapter;
    private SidebarAgentActionsController agentActions;
    private boolean agentExpanded;
    private List<SidebarAgentItem> agentItems;
    private long agentsLoadedAtMs;
    private List<SidebarSession> allSessions;
    private SessionHandler callbackHandler;
    private Map<String, ? extends SessionActivityState> chatActivityStates;
    private final b conversationListCallback;
    private String currentSessionId;
    private final Runnable debouncedRefresh;
    private Set<String> displayedConversationIds;
    private kotlinx.coroutines.g displayedReadJob;
    private final InterfaceC5063a<SessionHandler> fallbackSessionHandler;
    private boolean firstLoadDelivered;
    private SidebarAgentItem highlightAgent;
    private boolean isLoadingMore;
    private String lastActivityDiagSignature;
    private LifecycleOwner lifecycleOwner;
    private SessionHandler liveSessionHandler;
    private kotlinx.coroutines.g loadJob;
    private int loadedCount;
    private M8 loadingMask;
    private SidebarSession mainSession;
    private String menuAgentKey;
    private String menuSessionId;
    private InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClick;
    private InterfaceC5074l<? super SidebarSession, Y8.t> onCurrentSessionRemoved;
    private InterfaceC5074l<? super SidebarSession, Y8.t> onSessionClick;
    private final Map<String, Long> optimisticReadSessions;
    private boolean pageHidden;
    private RecyclerView recyclerView;
    private final c scrollListener;
    private int seenAgentListRevision;
    private SidebarSessionActionsController sessionActions;
    private List<IExternalAgentBindService.SidebarAgent> sidebarAgents;
    private final d taskCardCallback;
    private final Map<String, Pair<Integer, String>> taskPresentationStates;
    private final Set<String> uninstallingAssetIds;
    private boolean warmUpLoading;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SessionCenterListController$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "AGENTS_STALE_AFTER_MS", "J", "", "PAGE_SIZE", "I", "LOAD_MORE_PREFETCH", "CONVERSATION_LIST_REFRESH_DEBOUNCE_MS", "COLLAPSED_AGENT_COUNT", "EXPANDED_AGENT_COUNT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/controller/SessionCenterListController$b", "Lcom/stepos/agentframework/chatcore/session/Z;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements com.stepos.agentframework.chatcore.session.Z {
        public b() {
        }

        @Override // com.stepos.agentframework.chatcore.session.Z
        public void a() {
            RecyclerView recyclerView = SessionCenterListController.this.recyclerView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.removeCallbacks(SessionCenterListController.this.debouncedRefresh);
            recyclerView.postDelayed(SessionCenterListController.this.debouncedRefresh, 200L);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/controller/SessionCenterListController$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "dx", "dy", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView rv, int newState) {
            kotlin.jvm.internal.p.i(rv, "rv");
            if (newState == 0) {
                return;
            }
            SidebarAgentActionsController sidebarAgentActionsController = SessionCenterListController.this.agentActions;
            if (sidebarAgentActionsController != null) {
                sidebarAgentActionsController.q();
            }
            SidebarSessionActionsController sidebarSessionActionsController = SessionCenterListController.this.sessionActions;
            if (sidebarSessionActionsController != null) {
                sidebarSessionActionsController.r();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            int iFindLastVisibleItemPosition;
            com.stepos.ailauncher.chat.adapter.S s10;
            kotlin.jvm.internal.p.i(rv, "rv");
            if (dy > 0 && !SessionCenterListController.this.isLoadingMore && SessionCenterListController.this.loadedCount < SessionCenterListController.this.allSessions.size()) {
                RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) == -1 || (s10 = SessionCenterListController.this.adapter) == null || iFindLastVisibleItemPosition < s10.getItemCount() - 5) {
                    return;
                }
                SessionCenterListController.this.isLoadingMore = true;
                SessionCenterListController sessionCenterListController = SessionCenterListController.this;
                sessionCenterListController.loadedCount = C5685n.j(sessionCenterListController.loadedCount + 20, SessionCenterListController.this.allSessions.size());
                SessionCenterListController.this.D0();
                SessionCenterListController.this.isLoadingMore = false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/controller/SessionCenterListController$d", "Lb6/a;", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "taskCard", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC1452a {
        public d() {
        }

        public static final void d(UiTask uiTask, SessionCenterListController sessionCenterListController) {
            Pair pairA = Y8.j.a(Integer.valueOf(uiTask.getStatus()), uiTask.getRequestedSessionKey());
            if (kotlin.jvm.internal.p.d(sessionCenterListController.taskPresentationStates.put(uiTask.getTaskId(), pairA), pairA)) {
                return;
            }
            SessionCenterListController.x0(sessionCenterListController, false, null, 3, null);
        }

        @Override // b6.InterfaceC1452a
        public /* bridge */ void a(UiTask uiTask, List<UiTask> list) {
            super.a(uiTask, list);
        }

        @Override // b6.InterfaceC1452a
        public void b(final UiTask taskCard) {
            kotlin.jvm.internal.p.i(taskCard, "taskCard");
            RecyclerView recyclerView = SessionCenterListController.this.recyclerView;
            if (recyclerView != null) {
                final SessionCenterListController sessionCenterListController = SessionCenterListController.this;
                recyclerView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.controller.W0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionCenterListController.d.d(taskCard, sessionCenterListController);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionCenterListController() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final Y8.t Y(SessionCenterListController sessionCenterListController, SidebarSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        sessionCenterListController.g0(session);
        return Y8.t.f7040a;
    }

    public static final Y8.t Z(SessionCenterListController sessionCenterListController, SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        sessionCenterListController.f0(agent);
        return Y8.t.f7040a;
    }

    public static final boolean a0(SidebarAgentActionsController sidebarAgentActionsController, View anchor, SidebarAgentItem agent, float f10, float f11) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(agent, "agent");
        return sidebarAgentActionsController.u(anchor, agent, f10, f11);
    }

    public static final Y8.t b0(SessionCenterListController sessionCenterListController) {
        sessionCenterListController.F0();
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(SidebarSessionActionsController sidebarSessionActionsController, View anchor, SidebarSession session, float f10, float f11) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(session, "session");
        sidebarSessionActionsController.D(anchor, session, f10, f11);
        return Y8.t.f7040a;
    }

    public static final void d0(SessionCenterListController sessionCenterListController) {
        x0(sessionCenterListController, false, null, 3, null);
    }

    public static final CharSequence j0(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final CharSequence k0(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId() + "/" + it.getActivityState();
    }

    public static final Y8.t t0(SessionCenterListController sessionCenterListController) {
        sessionCenterListController.warmUpLoading = false;
        return Y8.t.f7040a;
    }

    public static final SessionHandler u() {
        return AgentConfig.INSTANCE.a().n();
    }

    public static final boolean v0(Map map, SessionCenterListController sessionCenterListController, Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        String str = (String) entry.getKey();
        long jLongValue = ((Number) entry.getValue()).longValue();
        SidebarSession sidebarSession = (SidebarSession) map.get(str);
        boolean z10 = true;
        boolean z11 = sidebarSession == null;
        if (sidebarSession == null || !X0.e(sidebarSession)) {
            z10 = false;
        }
        return X0.f(z11, z10, sidebarSession != null ? sidebarSession.getUpdatedAt() : 0L, jLongValue, sessionCenterListController.displayedConversationIds.contains(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0(SessionCenterListController sessionCenterListController, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        sessionCenterListController.w0(z10, interfaceC5063a);
    }

    public final void A0(SessionHandler handler) {
        if (this.liveSessionHandler == handler) {
            return;
        }
        this.liveSessionHandler = handler;
        if (this.recyclerView == null) {
            return;
        }
        E0();
        if (this.firstLoadDelivered) {
            V();
        }
    }

    public final void B0(InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l) {
        this.onAgentClick = interfaceC5074l;
    }

    public final void C0(InterfaceC5074l<? super SidebarSession, Y8.t> interfaceC5074l) {
        this.onSessionClick = interfaceC5074l;
    }

    public final void D0() {
        RecyclerView recyclerView;
        Context context;
        com.stepos.ailauncher.chat.adapter.S s10 = this.adapter;
        if (s10 == null || (recyclerView = this.recyclerView) == null || (context = recyclerView.getContext()) == null) {
            return;
        }
        this.chatActivityStates = X0.g(SessionActivityTracker.INSTANCE.e().getValue());
        List<SidebarSession> listF1 = Z8.F.f1(this.allSessions, this.loadedCount);
        List listC = C1172u.c();
        if (!this.agentItems.isEmpty() || !listF1.isEmpty()) {
            if (!this.agentItems.isEmpty()) {
                String string = context.getString(R$string.session_center_section_agents);
                kotlin.jvm.internal.p.h(string, "getString(...)");
                listC.add(new S.f.SectionLabel(string));
                boolean z10 = this.agentItems.size() > 3;
                List<SidebarAgentItem> listF12 = (!z10 || this.agentExpanded) ? this.agentItems : Z8.F.f1(this.agentItems, 3);
                ArrayList arrayList = new ArrayList(C1174w.x(listF12, 10));
                for (SidebarAgentItem sidebarAgentItem : listF12) {
                    arrayList.add(new S.f.AgentRow(sidebarAgentItem, kotlin.jvm.internal.p.d(this.highlightAgent, sidebarAgentItem) || kotlin.jvm.internal.p.d(sidebarAgentItem.j(), this.menuAgentKey), !La.H.x0(sidebarAgentItem.getAssetId()) && this.uninstallingAssetIds.contains(sidebarAgentItem.getAssetId())));
                }
                if (arrayList.size() > 8) {
                    listC.add(new S.f.AgentList(arrayList, 8));
                } else {
                    listC.addAll(arrayList);
                }
                if (z10) {
                    listC.add(new S.f.AgentToggle(this.agentExpanded));
                }
                listC.add(S.f.d.INSTANCE);
            }
            String string2 = context.getString(R$string.session_center_section_history);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            listC.add(new S.f.SectionLabel(string2));
            if (!listF1.isEmpty()) {
                for (SidebarSession sidebarSession : listF1) {
                    boolean zContains = this.displayedConversationIds.contains(sidebarSession.getSessionId());
                    if (zContains) {
                        this.optimisticReadSessions.put(sidebarSession.getSessionId(), Long.valueOf(sidebarSession.getUpdatedAt()));
                    }
                    SidebarSession sidebarSessionD = (zContains || this.optimisticReadSessions.containsKey(sidebarSession.getSessionId())) ? X0.d(sidebarSession) : sidebarSession;
                    listC.add(new S.f.SessionRow(sidebarSessionD, kotlin.jvm.internal.p.d(sidebarSession.getSessionId(), this.currentSessionId) || kotlin.jvm.internal.p.d(sidebarSession.getSessionId(), this.menuSessionId), com.stepos.ailauncher.chat.adapter.N.a(sidebarSessionD.getActivityState(), this.activeConversationIds.contains(sidebarSession.getSessionId()), this.chatActivityStates.get(sidebarSession.getSessionId()), sidebarSessionD.isRead())));
                }
            } else if (this.firstLoadDelivered) {
                listC.add(S.f.e.INSTANCE);
            }
        } else if (this.firstLoadDelivered) {
            listC.add(S.f.e.INSTANCE);
        }
        s10.submitList(C1172u.a(listC));
        i0(listF1);
    }

    public final void E0() {
        SessionHandler sessionHandlerZ0 = z0();
        SessionHandler sessionHandler = this.callbackHandler;
        if (sessionHandler == sessionHandlerZ0) {
            return;
        }
        if (sessionHandler != null) {
            sessionHandler.j3(this.conversationListCallback);
        }
        sessionHandlerZ0.u0(this.conversationListCallback);
        this.callbackHandler = sessionHandlerZ0;
    }

    public final void F0() {
        this.agentExpanded = !this.agentExpanded;
        D0();
    }

    public final boolean T() {
        return this.agentsLoadedAtMs == 0 || SystemClock.elapsedRealtime() - this.agentsLoadedAtMs >= 2000;
    }

    public final void U(List<IExternalAgentBindService.SidebarAgent> agents) {
        this.sidebarAgents = agents;
        List<SidebarSession> listH = H8.H(this.allSessions, agents);
        this.allSessions = listH;
        this.agentItems = H8.o(listH, agents);
        V();
    }

    public final void V() {
        SidebarAgentItem sidebarAgentItemF;
        SessionHandler sessionHandlerZ0 = z0();
        AgentSession.AgentConversation agentConversationR1 = sessionHandlerZ0.R1();
        String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        if (strB == null) {
            strB = "";
        }
        this.currentSessionId = strB;
        List<SidebarSession> list = this.allSessions;
        if ((list instanceof Collection) && list.isEmpty()) {
            sidebarAgentItemF = H8.F(this.agentItems, sessionHandlerZ0);
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.p.d(((SidebarSession) it.next()).getSessionId(), this.currentSessionId)) {
                    sidebarAgentItemF = null;
                    break;
                }
            }
            sidebarAgentItemF = H8.F(this.agentItems, sessionHandlerZ0);
        }
        this.highlightAgent = sidebarAgentItemF;
        Set<String> setT0 = sessionHandlerZ0.t0();
        List<SidebarSession> list2 = this.allSessions;
        HashSet hashSet = new HashSet();
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            String sessionId = ((SidebarSession) it2.next()).getSessionId();
            if (sessionId.length() <= 0 || !setT0.contains(sessionId)) {
                sessionId = null;
            }
            if (sessionId != null) {
                hashSet.add(sessionId);
            }
        }
        this.activeConversationIds = hashSet;
        D0();
    }

    public final void W(SidebarSnapshot snapshot) {
        Object next;
        this.sidebarAgents = snapshot.a();
        this.allSessions = snapshot.b();
        u0(snapshot.b());
        Iterator<T> it = snapshot.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SidebarSession) next).getSessionKind() == SidebarSessionKind.MAIN) {
                    break;
                }
            }
        }
        this.mainSession = (SidebarSession) next;
        this.agentItems = H8.o(snapshot.b(), snapshot.a());
        this.loadedCount = C5685n.n(this.loadedCount, 20, Math.max(snapshot.b().size(), 20));
        this.firstLoadDelivered = true;
        V();
    }

    public final void X(RecyclerView recyclerView, LifecycleOwner owner, ViewGroup maskHost) {
        kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
        kotlin.jvm.internal.p.i(owner, "owner");
        if (this.recyclerView != null) {
            return;
        }
        final SidebarAgentActionsController sidebarAgentActionsController = new SidebarAgentActionsController(this);
        final SidebarSessionActionsController sidebarSessionActionsController = new SidebarSessionActionsController(this, new SessionCenterListController$bind$sessionMenus$1(this));
        com.stepos.ailauncher.chat.adapter.S s10 = new com.stepos.ailauncher.chat.adapter.S();
        s10.r(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.R0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterListController.Y(this.f25024a, (SidebarSession) obj);
            }
        });
        s10.o(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.S0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterListController.Z(this.f25026a, (SidebarAgentItem) obj);
            }
        });
        s10.q(new p9.r() { // from class: com.stepos.ailauncher.chat.controller.T0
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Boolean.valueOf(SessionCenterListController.a0(sidebarAgentActionsController, (View) obj, (SidebarAgentItem) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue()));
            }
        });
        s10.p(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.U0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionCenterListController.b0(this.f25033a);
            }
        });
        s10.s(new p9.r() { // from class: com.stepos.ailauncher.chat.controller.V0
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SessionCenterListController.c0(sidebarSessionActionsController, (View) obj, (SidebarSession) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
            }
        });
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.setLayoutManager(new RemainingSpaceLinearLayout.HostLayoutManager(context));
        recyclerView.setAdapter(s10);
        recyclerView.addOnScrollListener(this.scrollListener);
        this.recyclerView = recyclerView;
        this.adapter = s10;
        this.lifecycleOwner = owner;
        this.agentActions = sidebarAgentActionsController;
        this.sessionActions = sidebarSessionActionsController;
        this.loadingMask = maskHost != null ? new M8(maskHost) : null;
        TaskModule.INSTANCE.h(this.taskCardCallback);
        E0();
        p0(owner);
        m0(owner);
        o0(owner);
        owner.getLifecycle().a(this);
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarAgentActionsController.a, com.stepos.ailauncher.chat.controller.SidebarSessionActionsController.b
    public Ua.M a() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            return C1398p.a(lifecycleOwner);
        }
        return null;
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarSessionActionsController.b
    public void c(String sessionId) {
        if (kotlin.jvm.internal.p.d(this.menuSessionId, sessionId)) {
            return;
        }
        this.menuSessionId = sessionId;
        D0();
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarAgentActionsController.a
    public void d(SidebarAgentItem agent) {
        String strJ = agent != null ? agent.j() : null;
        if (kotlin.jvm.internal.p.d(this.menuAgentKey, strJ)) {
            return;
        }
        this.menuAgentKey = strJ;
        D0();
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarSessionActionsController.b
    public void e(InterfaceC5063a<Y8.t> onUpdated) {
        kotlin.jvm.internal.p.i(onUpdated, "onUpdated");
        x0(this, false, onUpdated, 1, null);
    }

    public final void e0() {
        SidebarAgentActionsController sidebarAgentActionsController = this.agentActions;
        if (sidebarAgentActionsController != null) {
            sidebarAgentActionsController.r();
        }
        SidebarSessionActionsController sidebarSessionActionsController = this.sessionActions;
        if (sidebarSessionActionsController != null) {
            sidebarSessionActionsController.s();
        }
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarSessionActionsController.b
    public void f(boolean loading) {
        M8 m82 = this.loadingMask;
        if (m82 == null) {
            return;
        }
        if (loading) {
            m82.c();
        } else {
            m82.a();
        }
    }

    public final void f0(SidebarAgentItem agent) {
        if (!kotlin.jvm.internal.p.d(this.highlightAgent, agent) || this.currentSessionId.length() > 0) {
            this.highlightAgent = agent;
            this.currentSessionId = "";
            D0();
        }
        InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l = this.onAgentClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(agent);
        }
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarAgentActionsController.a
    public void g(String assetId, boolean uninstalling) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        if (uninstalling ? this.uninstallingAssetIds.add(assetId) : this.uninstallingAssetIds.remove(assetId)) {
            D0();
        }
    }

    public final void g0(SidebarSession session) {
        if (!kotlin.jvm.internal.p.d(this.currentSessionId, session.getSessionId())) {
            this.currentSessionId = session.getSessionId();
            this.highlightAgent = null;
            D0();
        }
        InterfaceC5074l<? super SidebarSession, Y8.t> interfaceC5074l = this.onSessionClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(session);
        }
    }

    @Override // com.stepos.ailauncher.chat.controller.SidebarAgentActionsController.a
    public void h() {
        h0();
    }

    public final void h0() {
        this.agentsLoadedAtMs = 0L;
        x0(this, true, null, 2, null);
    }

    public final void i0(List<SidebarSession> paged) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : paged) {
            SidebarSession sidebarSession = (SidebarSession) obj;
            if (sidebarSession.getActivityState() == SessionActivityState.RUNNING && !this.activeConversationIds.contains(sidebarSession.getSessionId())) {
                arrayList.add(obj);
            }
        }
        String strA0 = Z8.F.A0(arrayList, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.N0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return SessionCenterListController.j0((SidebarSession) obj2);
            }
        }, 30, null);
        if (kotlin.jvm.internal.p.d(strA0, this.lastActivityDiagSignature)) {
            return;
        }
        this.lastActivityDiagSignature = strA0;
        if (arrayList.isEmpty()) {
            C4148a.k(TAG, "activityState diagnosis: no store-vs-framework divergence", false, 4, null);
            return;
        }
        C4148a.u(TAG, "activityState diagnosis: " + arrayList.size() + " row(s) 执行中 by task cards while framework reports no active round — " + Z8.F.A0(arrayList, null, null, null, 8, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.O0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return SessionCenterListController.k0((SidebarSession) obj2);
            }
        }, 23, null), false, 4, null);
    }

    public final void l0(String sessionId) {
        AbstractC1393k abstractC1393kA;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null || (abstractC1393kA = C1398p.a(lifecycleOwner)) == null) {
            return;
        }
        C1060i.d(abstractC1393kA, null, null, new SessionCenterListController$markSessionCompletedTasksRead$1(this, sessionId, null), 3, null);
    }

    public final void m0(LifecycleOwner owner) {
        this.chatActivityStates = X0.g(SessionActivityTracker.INSTANCE.e().getValue());
        C1060i.d(C1398p.a(owner), null, null, new SessionCenterListController$observeChatActivity$1(owner, this, null), 3, null);
    }

    public final void o0(LifecycleOwner owner) {
        kotlinx.coroutines.g gVar = this.displayedReadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.displayedReadJob = C1060i.d(C1398p.a(owner), null, null, new SessionCenterListController$observeDisplayedConversation$1(owner, this, null), 3, null);
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        y0();
    }

    @Override // android.view.InterfaceC1387e
    public void onPause(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        com.stepos.ailauncher.chat.adapter.S s10 = this.adapter;
        if (s10 != null) {
            s10.n(false);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.debouncedRefresh);
        }
        e0();
    }

    @Override // android.view.InterfaceC1387e
    public void onResume(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        if (this.pageHidden) {
            return;
        }
        s0();
    }

    @Override // android.view.InterfaceC1387e
    public void onStart(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        if (this.loadJob != null) {
            return;
        }
        this.warmUpLoading = true;
        x0(this, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.Q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionCenterListController.t0(this.f25023a);
            }
        }, 1, null);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void p0(LifecycleOwner owner) {
        Xa.t<StoreInstallActivity> installActivity;
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null || (installActivity = iAgentMarketService.getInstallActivity()) == null) {
            C4148a.u(TAG, "IAgentMarketService absent, sidebar agents won't auto-refresh after install", false, 4, null);
        } else {
            this.seenAgentListRevision = installActivity.getValue().getAgentListRevision();
            C1060i.d(C1398p.a(owner), null, null, new SessionCenterListController$observeStoreAgentChanges$1(owner, installActivity, this, null), 3, null);
        }
    }

    public final void q0(Set<String> ids) {
        if (this.lifecycleOwner == null) {
            return;
        }
        Set<String> set = this.displayedConversationIds;
        if (kotlin.jvm.internal.p.d(ids, set)) {
            return;
        }
        this.displayedConversationIds = ids;
        Set setM = Z8.Z.m(ids, set);
        for (SidebarSession sidebarSession : this.allSessions) {
            if (ids.contains(sidebarSession.getSessionId())) {
                this.optimisticReadSessions.put(sidebarSession.getSessionId(), Long.valueOf(sidebarSession.getUpdatedAt()));
            }
        }
        Iterator it = setM.iterator();
        while (it.hasNext()) {
            l0((String) it.next());
        }
        if (this.firstLoadDelivered) {
            D0();
        }
    }

    public final void r0() {
        if (this.pageHidden) {
            return;
        }
        this.pageHidden = true;
        com.stepos.ailauncher.chat.adapter.S s10 = this.adapter;
        if (s10 != null) {
            s10.n(false);
        }
    }

    public final void s0() {
        this.pageHidden = false;
        com.stepos.ailauncher.chat.adapter.S s10 = this.adapter;
        if (s10 != null) {
            s10.n(true);
        }
        E0();
        if (this.warmUpLoading) {
            return;
        }
        if (T()) {
            this.agentsLoadedAtMs = 0L;
        }
        x0(this, false, null, 3, null);
    }

    public final void u0(List<SidebarSession> sessions) {
        if (this.optimisticReadSessions.isEmpty()) {
            return;
        }
        List<SidebarSession> list = sessions;
        final LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((SidebarSession) obj).getSessionId(), obj);
        }
        Z8.A.J(this.optimisticReadSessions.entrySet(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.L0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(SessionCenterListController.v0(linkedHashMap, this, (Map.Entry) obj2));
            }
        });
    }

    public final void w0(boolean refreshAgents, InterfaceC5063a<Y8.t> onUpdated) {
        AbstractC1393k abstractC1393kA;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null || (abstractC1393kA = C1398p.a(lifecycleOwner)) == null) {
            if (onUpdated != null) {
                onUpdated.invoke();
            }
        } else {
            boolean z10 = refreshAgents || this.agentsLoadedAtMs == 0;
            kotlinx.coroutines.g gVar = this.loadJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.loadJob = C1060i.d(abstractC1393kA, null, null, new SessionCenterListController$refresh$1(this, z10, onUpdated, null), 3, null);
        }
    }

    public final void y0() {
        Lifecycle lifecycle;
        RecyclerView recyclerView = this.recyclerView;
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = null;
        kotlinx.coroutines.g gVar2 = this.displayedReadJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.displayedReadJob = null;
        SidebarAgentActionsController sidebarAgentActionsController = this.agentActions;
        if (sidebarAgentActionsController != null) {
            sidebarAgentActionsController.t();
        }
        this.agentActions = null;
        SidebarSessionActionsController sidebarSessionActionsController = this.sessionActions;
        if (sidebarSessionActionsController != null) {
            sidebarSessionActionsController.w();
        }
        this.sessionActions = null;
        M8 m82 = this.loadingMask;
        if (m82 != null) {
            m82.b();
        }
        this.loadingMask = null;
        TaskModule.INSTANCE.l(this.taskCardCallback);
        SessionHandler sessionHandler = this.callbackHandler;
        if (sessionHandler != null) {
            sessionHandler.j3(this.conversationListCallback);
        }
        this.callbackHandler = null;
        this.liveSessionHandler = null;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.debouncedRefresh);
            recyclerView.removeOnScrollListener(this.scrollListener);
            recyclerView.setAdapter(null);
        }
        com.stepos.ailauncher.chat.adapter.S s10 = this.adapter;
        if (s10 != null) {
            s10.r(null);
        }
        com.stepos.ailauncher.chat.adapter.S s11 = this.adapter;
        if (s11 != null) {
            s11.o(null);
        }
        com.stepos.ailauncher.chat.adapter.S s12 = this.adapter;
        if (s12 != null) {
            s12.q(null);
        }
        com.stepos.ailauncher.chat.adapter.S s13 = this.adapter;
        if (s13 != null) {
            s13.p(null);
        }
        com.stepos.ailauncher.chat.adapter.S s14 = this.adapter;
        if (s14 != null) {
            s14.s(null);
        }
        this.adapter = null;
        this.recyclerView = null;
        this.lifecycleOwner = null;
        this.onSessionClick = null;
        this.onAgentClick = null;
        this.onCurrentSessionRemoved = null;
        this.allSessions = C1173v.m();
        this.agentItems = C1173v.m();
        this.sidebarAgents = C1173v.m();
        this.agentsLoadedAtMs = 0L;
        this.firstLoadDelivered = false;
        this.warmUpLoading = false;
        this.pageHidden = true;
        this.activeConversationIds = Z8.Y.e();
        this.chatActivityStates = kotlin.collections.a.i();
        this.highlightAgent = null;
        this.mainSession = null;
        this.menuAgentKey = null;
        this.menuSessionId = null;
        this.uninstallingAssetIds.clear();
        this.optimisticReadSessions.clear();
        this.displayedConversationIds = Z8.Y.e();
        this.taskPresentationStates.clear();
    }

    public final SessionHandler z0() {
        SessionHandler sessionHandler = this.liveSessionHandler;
        return sessionHandler == null ? this.fallbackSessionHandler.invoke() : sessionHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionCenterListController(InterfaceC5063a<? extends SessionHandler> fallbackSessionHandler) {
        kotlin.jvm.internal.p.i(fallbackSessionHandler, "fallbackSessionHandler");
        this.fallbackSessionHandler = fallbackSessionHandler;
        this.allSessions = C1173v.m();
        this.loadedCount = 20;
        this.agentItems = C1173v.m();
        this.sidebarAgents = C1173v.m();
        this.uninstallingAssetIds = new LinkedHashSet();
        this.activeConversationIds = Z8.Y.e();
        this.chatActivityStates = kotlin.collections.a.i();
        this.currentSessionId = "";
        this.optimisticReadSessions = new LinkedHashMap();
        this.displayedConversationIds = Z8.Y.e();
        this.taskPresentationStates = new LinkedHashMap();
        this.pageHidden = true;
        this.scrollListener = new c();
        this.taskCardCallback = new d();
        this.debouncedRefresh = new Runnable() { // from class: com.stepos.ailauncher.chat.controller.M0
            @Override // java.lang.Runnable
            public final void run() {
                SessionCenterListController.d0(this.f25017a);
            }
        };
        this.conversationListCallback = new b();
    }

    public /* synthetic */ SessionCenterListController(InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.P0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SessionCenterListController.u();
            }
        } : interfaceC5063a);
    }
}
