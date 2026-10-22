package com.stepos.ailauncher.chat.view;

import Ua.C1060i;
import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatui.history.DrawerTitleItem;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.adapter.ChatHistoryAdapter;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.ChatHistoryView;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0004\u008e\u0001Ä\u0001\b\u0007\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u0018J)\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\u0018J\u000f\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u0018J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\nH\u0002¢\u0006\u0004\b$\u0010\rJ\u000f\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010\u0018J/\u0010+\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010.J+\u00101\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u0010\u001dJ\u001f\u00106\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0018J\u000f\u00109\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010\u0018JE\u0010>\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\n0<j\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\n`=2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\nH\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\bD\u0010.J/\u0010K\u001a\u00020\u00132\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020:2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020HH\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0013H\u0002¢\u0006\u0004\bP\u0010\u0018J\u000f\u0010Q\u001a\u00020\u0013H\u0002¢\u0006\u0004\bQ\u0010\u0018J\u000f\u0010R\u001a\u00020\u0013H\u0002¢\u0006\u0004\bR\u0010\u0018J\u000f\u0010S\u001a\u00020\u0013H\u0002¢\u0006\u0004\bS\u0010\u0018J\u000f\u0010T\u001a\u00020\u0013H\u0002¢\u0006\u0004\bT\u0010\u0018J\u000f\u0010U\u001a\u00020\u0013H\u0002¢\u0006\u0004\bU\u0010\u0018J\u0011\u0010W\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010\\\u001a\u00020\u00132\u0006\u0010Y\u001a\u00020E2\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]J\u001f\u0010`\u001a\u00020\u00132\u0006\u0010[\u001a\u00020Z2\u0006\u0010_\u001a\u00020^H\u0002¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020\u00132\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u00132\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\bd\u0010cJ\u0011\u0010e\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR.\u0010z\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0y0x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010}R\u001f\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R!\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010hR\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010hR\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010hR\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0086\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R/\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0080\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001RH\u0010\u0097\u0001\u001a!\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001RJ\u0010\u009e\u0001\u001a#\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130/\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u009d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0016\u0010¤\u0001\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010hR\u001a\u0010¥\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010hR1\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010\u0080\u0001\u001a\u0006\b§\u0001\u0010\u0093\u0001\"\u0006\b¨\u0001\u0010\u0095\u0001R7\u0010©\u0001\u001a\u0010\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\u0013\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001f\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020Z0\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001b\u0010±\u0001\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u008d\u0001R\u0019\u0010²\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001f\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010°\u0001R\u001f\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020:0\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010°\u0001R\u0019\u0010¶\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010³\u0001R\u0018\u0010¹\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¹\u0001\u0010hR\u0019\u0010º\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010³\u0001R \u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u0084\u0001R\u0019\u0010½\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010³\u0001R\u0018\u0010¿\u0001\u001a\u00030¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Â\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Å\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R*\u0010Ç\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00130\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010\u009f\u0001R\u0018\u0010Ë\u0001\u001a\u00030È\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ChatHistoryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "C0", "()Ljava/util/List;", "", "currentSessionId", "", "refreshAgents", "Lkotlin/Function0;", "LY8/t;", "onUpdated", "j1", "(Ljava/lang/String;ZLp9/a;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Z0", "active", "setDrawerContentActive", "(Z)V", "X0", "p1", "(ZLp9/a;)V", "O0", "o1", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter$Item;", "B0", "n1", "l1", "s1", "sessionId", "agentId", "deviceId", "D0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "t1", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "callback", "U0", "(Ljava/lang/String;Lp9/l;)V", "success", "g1", "newTitle", "r1", "(Ljava/lang/String;Ljava/lang/String;)V", "E1", "i1", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "conversations", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "f1", "(Ljava/util/List;)Ljava/util/LinkedHashMap;", "", "timeMillis", "e1", "(J)J", "m1", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "conversationTitle", "", "rawX", "rawY", "F1", "(Landroid/view/View;Lcom/stepos/ailauncher/contract/model/search/SidebarSession;FF)V", "Landroid/widget/PopupWindow;", "P0", "()Landroid/widget/PopupWindow;", "v1", "J1", "b1", "x1", "Y0", SdCardDbCreator.FIELD_LASTLOC_ID, "Landroidx/fragment/app/r;", "d1", "()Landroidx/fragment/app/r;", "item", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "w0", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;)V", "Lcom/stepos/ailauncher/chat/view/AgentAction;", "action", "c1", "(Lcom/stepos/ailauncher/chat/view/s8;Lcom/stepos/ailauncher/chat/view/AgentAction;)V", "H0", "(Lcom/stepos/ailauncher/chat/view/s8;)V", "K0", "u1", "()Lcom/stepos/ailauncher/chat/view/s8;", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/ChatHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "LUa/M;", "viewScope", "LUa/M;", "Lkotlinx/coroutines/g;", "loadJob", "Lkotlinx/coroutines/g;", "", "Lkotlin/Pair;", "taskPresentationStates", "Ljava/util/Map;", "renamePopupWindow", "Landroid/widget/PopupWindow;", "agentActionsPopupWindow", "agentDisconnectDismiss", "Lp9/a;", "agentUninstallDismiss", "", "uninstallingAgentIds", "Ljava/util/Set;", "deleteDialogWindowView", "Landroid/view/View;", "renameDialogWindowView", "renamePopupLayerId", "deleteDialogLayerId", "renameWindowLayerId", "listLoadingView", "currentConversationTitle", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "com/stepos/ailauncher/chat/view/ChatHistoryView$c", "accountCallback", "Lcom/stepos/ailauncher/chat/view/ChatHistoryView$c;", "closeDrawerFun", "getCloseDrawerFun", "()Lp9/a;", "setCloseDrawerFun", "(Lp9/a;)V", "Lkotlin/Function3;", "changeConversation", "Lp9/q;", "getChangeConversation", "()Lp9/q;", "setChangeConversation", "(Lp9/q;)V", "Lkotlin/Function2;", "onDeleteSessionRequested", "Lp9/p;", "getOnDeleteSessionRequested", "()Lp9/p;", "setOnDeleteSessionRequested", "(Lp9/p;)V", "txtDeleteChat", "mainSessionId", "onAddAgentClicked", "getOnAddAgentClicked", "setOnAddAgentClicked", "onAgentClicked", "Lp9/l;", "getOnAgentClicked$chat_release", "()Lp9/l;", "setOnAgentClicked$chat_release", "(Lp9/l;)V", "agentItems", "Ljava/util/List;", "currentAgentSession", "agentsExpanded", "Z", "sidebarAgents", "allSessions", "loadedCount", "I", "isLoadingMore", "currentSessionIdForBuild", "pendingEmptyCacheClear", "", "activeSessionIds", "agentExposeReported", "Lb6/a;", "iTaskUpdate", "Lb6/a;", "Ljava/lang/Runnable;", "debouncedRefreshFromCallback", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/view/ChatHistoryView$d", "conversationListChangeCallback", "Lcom/stepos/ailauncher/chat/view/ChatHistoryView$d;", "clickListener", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatHistoryView extends ConstraintLayout {

    @Deprecated
    public static final long CONVERSATION_LIST_REFRESH_DEBOUNCE_MS = 200;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int LOAD_MORE_PREFETCH = 5;

    @Deprecated
    public static final int PAGE_SIZE = 20;

    @Deprecated
    public static final long RELATIVE_TIME_BUCKET_MS = 60000;

    @Deprecated
    public static final float SECTION_CORNER_RADIUS_DP = 20.0f;
    private final String TAG;
    private final c accountCallback;
    private Set<String> activeSessionIds;
    private final ChatHistoryAdapter adapter;
    private PopupWindow agentActionsPopupWindow;
    private InterfaceC5063a<Y8.t> agentDisconnectDismiss;
    private boolean agentExposeReported;
    private List<SidebarAgentItem> agentItems;
    private InterfaceC5063a<Y8.t> agentUninstallDismiss;
    private boolean agentsExpanded;
    private List<SidebarSession> allSessions;
    private p9.q<? super String, ? super String, ? super String, Y8.t> changeConversation;
    private final p9.p<String, SidebarSession, Y8.t> clickListener;
    private InterfaceC5063a<Y8.t> closeDrawerFun;
    private final d conversationListChangeCallback;
    private SidebarSession currentAgentSession;
    private SidebarSession currentConversationTitle;
    private String currentSessionIdForBuild;
    private final Runnable debouncedRefreshFromCallback;
    private String deleteDialogLayerId;
    private View deleteDialogWindowView;
    private final InterfaceC1452a iTaskUpdate;
    private boolean isLoadingMore;
    private View listLoadingView;
    private kotlinx.coroutines.g loadJob;
    private int loadedCount;
    private String mainSessionId;
    private InterfaceC5063a<Y8.t> onAddAgentClicked;
    private InterfaceC5074l<? super SidebarAgentItem, Y8.t> onAgentClicked;
    private p9.p<? super String, ? super InterfaceC5074l<? super Boolean, Y8.t>, Y8.t> onDeleteSessionRequested;
    private boolean pendingEmptyCacheClear;
    private final RecyclerView recyclerView;
    private View renameDialogWindowView;
    private String renamePopupLayerId;
    private PopupWindow renamePopupWindow;
    private String renameWindowLayerId;
    private SessionHandler sessionHandler;
    private List<IExternalAgentBindService.SidebarAgent> sidebarAgents;
    private final Map<String, Pair<Integer, String>> taskPresentationStates;
    private final String txtDeleteChat;
    private final Set<String> uninstallingAgentIds;
    private Ua.M viewScope;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ChatHistoryView$Companion;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "", "PAGE_SIZE", "I", "LOAD_MORE_PREFETCH", "", "SECTION_CORNER_RADIUS_DP", "F", "", "CONVERSATION_LIST_REFRESH_DEBOUNCE_MS", "J", "RELATIVE_TIME_BUCKET_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void b() {
            Function2.a(new ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1(null));
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "", "dx", "dy", "LY8/t;", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            kotlin.jvm.internal.p.i(rv, "rv");
            if (dy > 0) {
                ChatHistoryView.this.n1();
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentAction.values().length];
            try {
                iArr[AgentAction.Disconnect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentAction.Uninstall.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$c", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements com.stepos.ailauncher.foundation.account.i {
        public c() {
        }

        public static final void c(ChatHistoryView chatHistoryView, AccountInfo accountInfo) {
            if (chatHistoryView.viewScope == null) {
                return;
            }
            if (accountInfo != null && ChatCoreSdk.INSTANCE.g()) {
                com.stepos.ailauncher.chat.manager.Y.INSTANCE.b();
            }
            ChatHistoryView.q1(chatHistoryView, false, null, 3, null);
        }

        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(final AccountInfo accountInfo) {
            final ChatHistoryView chatHistoryView = ChatHistoryView.this;
            chatHistoryView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.O3
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryView.c.c(chatHistoryView, accountInfo);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$d", "Lcom/stepos/agentframework/chatcore/session/Z;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements com.stepos.agentframework.chatcore.session.Z {
        public d() {
        }

        @Override // com.stepos.agentframework.chatcore.session.Z
        public void a() {
            ChatHistoryView chatHistoryView = ChatHistoryView.this;
            chatHistoryView.removeCallbacks(chatHistoryView.debouncedRefreshFromCallback);
            ChatHistoryView chatHistoryView2 = ChatHistoryView.this;
            chatHistoryView2.postDelayed(chatHistoryView2.debouncedRefreshFromCallback, 200L);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$e", "Lb6/a;", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "taskCard", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC1452a {
        public e() {
        }

        public static final void d(UiTask uiTask, ChatHistoryView chatHistoryView) {
            Pair pairA = Y8.j.a(Integer.valueOf(uiTask.getStatus()), uiTask.getRequestedSessionKey());
            if (kotlin.jvm.internal.p.d(chatHistoryView.taskPresentationStates.put(uiTask.getTaskId(), pairA), pairA)) {
                return;
            }
            ChatHistoryView.q1(chatHistoryView, false, null, 3, null);
        }

        @Override // b6.InterfaceC1452a
        public /* bridge */ void a(UiTask uiTask, List<UiTask> list) {
            super.a(uiTask, list);
        }

        @Override // b6.InterfaceC1452a
        public void b(final UiTask taskCard) {
            kotlin.jvm.internal.p.i(taskCard, "taskCard");
            final ChatHistoryView chatHistoryView = ChatHistoryView.this;
            chatHistoryView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.Q3
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryView.e.d(taskCard, chatHistoryView);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JA\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$f", "Landroid/text/InputFilter;", "", "source", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "LY8/t;", "c", "()V", "", "lastToastTime", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements InputFilter {
        final /* synthetic */ int $maxTitleLength;
        final /* synthetic */ TextView $tvLengthToast;
        private long lastToastTime;

        public f(int i10, TextView textView) {
            this.$maxTitleLength = i10;
            this.$tvLengthToast = textView;
        }

        public static final void d(final TextView textView) {
            textView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.W3
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryView.f.e(textView);
                }
            }).start();
        }

        public static final void e(TextView textView) {
            textView.setVisibility(8);
        }

        public final void c() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastToastTime < 1500) {
                return;
            }
            this.lastToastTime = jCurrentTimeMillis;
            this.$tvLengthToast.setText("长度最大限制为" + this.$maxTitleLength + "个字符");
            this.$tvLengthToast.animate().cancel();
            this.$tvLengthToast.setAlpha(1.0f);
            this.$tvLengthToast.setVisibility(0);
            final TextView textView = this.$tvLengthToast;
            textView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.V3
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryView.f.d(textView);
                }
            }, 1500L);
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(dest, "dest");
            int length = this.$maxTitleLength - (dest.length() - (dend - dstart));
            if (length <= 0) {
                c();
                return "";
            }
            if (length >= end - start) {
                return null;
            }
            c();
            return source.subSequence(start, length + start);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$g", "Landroid/view/WindowInsetsAnimation$Callback;", "Landroid/view/WindowInsetsAnimation;", "animation", "LY8/t;", "onPrepare", "(Landroid/view/WindowInsetsAnimation;)V", "Landroid/view/WindowInsets;", "insets", "", "runningAnimations", "onProgress", "(Landroid/view/WindowInsets;Ljava/util/List;)Landroid/view/WindowInsets;", "onEnd", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends WindowInsetsAnimation.Callback {
        final /* synthetic */ InterfaceC5074l<Integer, Y8.t> $alignCardAboveIme;
        final /* synthetic */ Ref$BooleanRef $imeAnimating;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(Ref$BooleanRef ref$BooleanRef, InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l) {
            super(1);
            this.$imeAnimating = ref$BooleanRef;
            this.$alignCardAboveIme = interfaceC5074l;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onEnd(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                this.$imeAnimating.f34815a = false;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onPrepare(WindowInsetsAnimation animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                this.$imeAnimating.f34815a = true;
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            this.$alignCardAboveIme.invoke(Integer.valueOf(insets.getInsets(WindowInsets.Type.ime()).bottom));
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$h", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements TextWatcher {
        final /* synthetic */ int $colorActive;
        final /* synthetic */ int $colorDisabled;
        final /* synthetic */ ImageView $ivClearInput;
        final /* synthetic */ TextView $tvConfirm;

        public h(ImageView imageView, TextView textView, int i10, int i11) {
            this.$ivClearInput = imageView;
            this.$tvConfirm = textView;
            this.$colorActive = i10;
            this.$colorDisabled = i11;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            CharSequence charSequenceD1;
            ChatHistoryView.T1(this.$tvConfirm, this.$colorActive, this.$colorDisabled, (s10 == null || (charSequenceD1 = La.H.D1(s10)) == null || charSequenceD1.length() <= 0) ? false : true);
            this.$ivClearInput.setVisibility((s10 == null || s10.length() == 0) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/ChatHistoryView$i", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "LY8/t;", "onWindowFocusChanged", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i implements ViewTreeObserver.OnWindowFocusChangeListener {
        final /* synthetic */ View $dialogView;
        final /* synthetic */ EditText $etTitleInput;

        public i(View view, EditText editText) {
            this.$dialogView = view;
            this.$etTitleInput = editText;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            if (hasFocus) {
                this.$dialogView.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                this.$etTitleInput.requestFocus();
                WindowInsetsController windowInsetsController = this.$etTitleInput.getWindowInsetsController();
                if (windowInsetsController != null) {
                    windowInsetsController.show(WindowInsets.Type.ime());
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatHistoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t A0(ChatHistoryView chatHistoryView, SidebarAgentItem sidebarAgentItem, AgentAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        chatHistoryView.c1(sidebarAgentItem, action);
        return Y8.t.f7040a;
    }

    public static final void A1(View view) {
    }

    public static final void B1(ChatHistoryView chatHistoryView, SidebarSession sidebarSession, View view) {
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context context = chatHistoryView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!i10.b(context)) {
            Toast.makeText(chatHistoryView.getContext(), R$string.chat_network_error_retry_later, 0).show();
            return;
        }
        chatHistoryView.E1();
        chatHistoryView.U0(sidebarSession.getSessionId(), new ChatHistoryView$showDeleteConfirmDialog$4$1(chatHistoryView));
        chatHistoryView.Y0();
    }

    public static final boolean C1(ChatHistoryView chatHistoryView) {
        View view = chatHistoryView.deleteDialogWindowView;
        return view != null && view.isAttachedToWindow();
    }

    public static final Y8.t D1(ChatHistoryView chatHistoryView) {
        chatHistoryView.Y0();
        return Y8.t.f7040a;
    }

    public static final Y8.t E0(ChatHistoryView chatHistoryView, String mode, final SidebarSession title) {
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(title, "title");
        int iHashCode = mode.hashCode();
        if (iHashCode != -1335458389) {
            if (iHashCode != -1039745817) {
                if (iHashCode == -934594754 && mode.equals(W4.c.MANAGE_RENAME)) {
                    chatHistoryView.r1(title.getSessionId(), title.getTitle());
                }
            } else if (mode.equals("normal")) {
                chatHistoryView.adapter.n(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.b3
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ChatHistoryView.F0(title, (SidebarSession) obj));
                    }
                });
                chatHistoryView.m1(title.getSessionId());
                chatHistoryView.D0(title.getSessionId(), title.getAgentId(), title.getDeviceId());
                chatHistoryView.closeDrawerFun.invoke();
            }
        } else if (mode.equals(ChatTracker.CLICK_DELETE)) {
            chatHistoryView.t1(title.getSessionId());
        }
        return Y8.t.f7040a;
    }

    public static final boolean F0(SidebarSession sidebarSession, SidebarSession sidebarSession2) {
        return kotlin.jvm.internal.p.d(sidebarSession2 != null ? sidebarSession2.getSessionId() : null, sidebarSession.getSessionId());
    }

    public static final Y8.t G0() {
        return Y8.t.f7040a;
    }

    public static final boolean G1(SidebarSession sidebarSession, String str, SidebarSession sidebarSession2) {
        if (kotlin.jvm.internal.p.d(sidebarSession2 != null ? sidebarSession2.getSessionId() : null, sidebarSession.getSessionId())) {
            return true;
        }
        return kotlin.jvm.internal.p.d(sidebarSession2 != null ? sidebarSession2.getSessionId() : null, str);
    }

    public static final boolean H1(PopupWindow popupWindow) {
        return popupWindow.isShowing();
    }

    public static final Y8.t I0(SidebarAgentItem sidebarAgentItem, ChatHistoryView chatHistoryView) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.a("confirm", sidebarAgentItem.getAgentId(), sidebarAgentItem.getAgentId());
        chatHistoryView.agentDisconnectDismiss = null;
        Ua.M m10 = chatHistoryView.viewScope;
        if (m10 == null) {
            return Y8.t.f7040a;
        }
        chatHistoryView.E1();
        C1060i.d(m10, null, null, new ChatHistoryView$confirmAndDisconnectAgent$1$1(chatHistoryView, sidebarAgentItem, null), 3, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t I1(PopupWindow popupWindow) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t J0(SidebarAgentItem sidebarAgentItem, ChatHistoryView chatHistoryView) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.a("cancel", sidebarAgentItem.getAgentId(), sidebarAgentItem.getAgentId());
        chatHistoryView.agentDisconnectDismiss = null;
        return Y8.t.f7040a;
    }

    public static final void K1(ChatHistoryView chatHistoryView, View view) {
        chatHistoryView.b1();
    }

    public static final Y8.t L0(final String str, final ChatHistoryView chatHistoryView, SidebarAgentItem sidebarAgentItem) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.d("confirm", str);
        chatHistoryView.agentUninstallDismiss = null;
        if (chatHistoryView.viewScope == null) {
            return Y8.t.f7040a;
        }
        chatHistoryView.uninstallingAgentIds.add(str);
        chatHistoryView.o1();
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService != null) {
            iExternalAgentBindService.uninstallInstalledAgent(str, sidebarAgentItem.getReversionId(), sidebarAgentItem.getSemver(), sidebarAgentItem.getDisplayName(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.H3
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatHistoryView.M0(this.f25796a, str, ((Boolean) obj).booleanValue());
                }
            });
            return Y8.t.f7040a;
        }
        chatHistoryView.uninstallingAgentIds.remove(str);
        chatHistoryView.o1();
        Toast.makeText(chatHistoryView.getContext(), com.stepos.ailauncher.chat.R$string.sidebar_agent_uninstall_failed, 0).show();
        return Y8.t.f7040a;
    }

    public static final void L1(ChatHistoryView chatHistoryView, View view) {
        chatHistoryView.b1();
    }

    public static final Y8.t M0(ChatHistoryView chatHistoryView, String str, boolean z10) {
        chatHistoryView.uninstallingAgentIds.remove(str);
        Toast.makeText(chatHistoryView.getContext(), z10 ? com.stepos.ailauncher.chat.R$string.sidebar_agent_uninstall_done : com.stepos.ailauncher.chat.R$string.sidebar_agent_uninstall_failed, 0).show();
        if (chatHistoryView.viewScope != null) {
            q1(chatHistoryView, true, null, 2, null);
        } else {
            chatHistoryView.o1();
        }
        return Y8.t.f7040a;
    }

    public static final void M1(View view) {
    }

    public static final Y8.t N0(String str, ChatHistoryView chatHistoryView) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.d("cancel", str);
        chatHistoryView.agentUninstallDismiss = null;
        return Y8.t.f7040a;
    }

    public static final void N1(EditText editText, View view) {
        editText.setText("");
        editText.requestFocus();
    }

    public static final Y8.t O1(View view, View view2, float f10, int i10) {
        int height;
        if (view != null && (height = view2.getHeight()) != 0) {
            float bottom = (view.getBottom() + f10) - (height - i10);
            view.setTranslationY(bottom > 0.0f ? -bottom : 0.0f);
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static final WindowInsets P1(Ref$BooleanRef ref$BooleanRef, InterfaceC5074l interfaceC5074l, View view, WindowInsets insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        if (!ref$BooleanRef.f34815a) {
            interfaceC5074l.invoke(Integer.valueOf(insets.getInsets(WindowInsets.Type.ime()).bottom));
        }
        return insets;
    }

    public static final void Q0(ChatHistoryView chatHistoryView, View view) {
        PopupWindow popupWindow = chatHistoryView.renamePopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SESSION_RENAME);
        chatHistoryView.J1();
    }

    public static final void Q1(EditText editText, String str, ChatHistoryView chatHistoryView, String str2, View view) {
        String string = La.H.D1(editText.getText().toString()).toString();
        if (string.length() == 0) {
            return;
        }
        if (kotlin.jvm.internal.p.d(string, str)) {
            chatHistoryView.b1();
        } else {
            chatHistoryView.r1(str2, string);
            chatHistoryView.b1();
        }
    }

    public static final void R0(ChatHistoryView chatHistoryView, View view) {
        PopupWindow popupWindow = chatHistoryView.renamePopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SESSION_DELETE);
        chatHistoryView.x1();
    }

    public static final boolean R1(ChatHistoryView chatHistoryView) {
        View view = chatHistoryView.renameDialogWindowView;
        return view != null && view.isAttachedToWindow();
    }

    public static final void S0(ChatHistoryView chatHistoryView) {
        String str = chatHistoryView.renamePopupLayerId;
        if (str != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            chatHistoryView.renamePopupLayerId = null;
        }
        chatHistoryView.v1();
    }

    public static final Y8.t S1(ChatHistoryView chatHistoryView) {
        chatHistoryView.b1();
        return Y8.t.f7040a;
    }

    public static final Y8.t T(ChatHistoryView chatHistoryView) {
        InterfaceC5063a<Y8.t> interfaceC5063a = chatHistoryView.onAddAgentClicked;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final void T0(ChatHistoryView chatHistoryView) {
        q1(chatHistoryView, false, null, 3, null);
    }

    public static final void T1(TextView textView, int i10, int i11, boolean z10) {
        if (!z10) {
            i10 = i11;
        }
        textView.setTextColor(i10);
        textView.setEnabled(z10);
    }

    public static final Y8.t U(ChatHistoryView chatHistoryView, SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l = chatHistoryView.onAgentClicked;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(agent);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t V(ChatHistoryView chatHistoryView) {
        boolean z10 = !chatHistoryView.agentsExpanded;
        chatHistoryView.agentsExpanded = z10;
        chatHistoryView.adapter.f(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t V0(ChatHistoryView chatHistoryView, final InterfaceC5074l interfaceC5074l, final boolean z10) {
        chatHistoryView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.k3
            @Override // java.lang.Runnable
            public final void run() {
                ChatHistoryView.W0(interfaceC5074l, z10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t W(ChatHistoryView chatHistoryView, View view, SidebarSession data, float f10, float f11) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(data, "data");
        chatHistoryView.F1(view, data, f10, f11);
        return Y8.t.f7040a;
    }

    public static final void W0(InterfaceC5074l interfaceC5074l, boolean z10) {
        interfaceC5074l.invoke(Boolean.valueOf(z10));
    }

    public static final Y8.t X(ChatHistoryView chatHistoryView, View view, SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(agent, "agent");
        chatHistoryView.w0(view, agent);
        return Y8.t.f7040a;
    }

    private final WindowManager getWindowManager() {
        Object systemService = getContext().getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) systemService;
    }

    public static final Y8.t h1(ChatHistoryView chatHistoryView) {
        chatHistoryView.i1();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k1(ChatHistoryView chatHistoryView, String str, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        chatHistoryView.j1(str, z10, interfaceC5063a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q1(ChatHistoryView chatHistoryView, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        chatHistoryView.p1(z10, interfaceC5063a);
    }

    public static final boolean w1(String str, SidebarSession sidebarSession) {
        return kotlin.jvm.internal.p.d(sidebarSession != null ? sidebarSession.getSessionId() : null, str);
    }

    public static final boolean x0(Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, View view, MotionEvent motionEvent) {
        ref$FloatRef.f34817a = motionEvent.getRawX();
        ref$FloatRef2.f34817a = motionEvent.getRawY();
        return false;
    }

    public static final boolean y0(final ChatHistoryView chatHistoryView, final View view, final SidebarAgentItem sidebarAgentItem, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, View view2) {
        PopupWindow popupWindow = chatHistoryView.agentActionsPopupWindow;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow = null;
            }
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        final boolean zIsSelected = view.isSelected();
        if (!zIsSelected) {
            view.setSelected(true);
        }
        chatHistoryView.agentActionsPopupWindow = C2788d.c(view, sidebarAgentItem, ref$FloatRef.f34817a, ref$FloatRef2.f34817a, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.h3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.z0(zIsSelected, view);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.j3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatHistoryView.A0(this.f26199a, sidebarAgentItem, (AgentAction) obj);
            }
        });
        return true;
    }

    public static final void y1(ChatHistoryView chatHistoryView, View view) {
        chatHistoryView.Y0();
    }

    public static final Y8.t z0(boolean z10, View view) {
        if (!z10) {
            view.setSelected(false);
        }
        return Y8.t.f7040a;
    }

    public static final void z1(ChatHistoryView chatHistoryView, View view) {
        chatHistoryView.Y0();
    }

    public final List<ChatHistoryAdapter.Item> B0() {
        String str = this.currentSessionIdForBuild;
        List<SidebarSession> listF1 = Z8.F.f1(this.allSessions, this.loadedCount);
        List listC = C1172u.c();
        if (this.agentItems.isEmpty()) {
            this.agentExposeReported = false;
        } else {
            listC.add(new ChatHistoryAdapter.Item.AgentHeader(this.agentItems, this.agentsExpanded, this.currentAgentSession == null ? u1() : null, Z8.F.r1(this.uninstallingAgentIds), System.currentTimeMillis() / 60000));
            s1();
        }
        if (listF1.isEmpty()) {
            listC.add(ChatHistoryAdapter.Item.HistorySectionHeader.INSTANCE);
            listC.add(ChatHistoryAdapter.Item.Empty.INSTANCE);
        } else {
            listC.add(ChatHistoryAdapter.Item.HistorySectionHeader.INSTANCE);
            Set<Map.Entry<String, List<SidebarSession>>> setEntrySet = f1(listF1).entrySet();
            kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
            List listM1 = Z8.F.m1(setEntrySet);
            int iO = C1173v.o(listM1);
            int i10 = 0;
            for (Object obj : listM1) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.p.f(entry);
                Object key = entry.getKey();
                kotlin.jvm.internal.p.h(key, "component1(...)");
                Object value = entry.getValue();
                kotlin.jvm.internal.p.h(value, "component2(...)");
                List list = (List) value;
                listC.add(new ChatHistoryAdapter.Item.TimeHeader((String) key));
                int i12 = 0;
                for (Object obj2 : list) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        C1173v.w();
                    }
                    SidebarSession sidebarSession = (SidebarSession) obj2;
                    listC.add(new ChatHistoryAdapter.Item.HistoryRow(new DrawerTitleItem(0, sidebarSession.getTitle(), X3.b(sidebarSession.getSessionKind()), sidebarSession, kotlin.jvm.internal.p.d(str, sidebarSession.getSessionId()), this.clickListener), i10 == iO && i12 == C1173v.o(list), com.stepos.ailauncher.chat.adapter.N.b(sidebarSession.getActivityState(), this.activeSessionIds.contains(sidebarSession.getSessionId()), null, sidebarSession.isRead(), 4, null)));
                    i12 = i13;
                }
                i10 = i11;
            }
        }
        return C1172u.a(listC);
    }

    public final List<IExternalAgentBindService.SidebarAgent> C0() {
        return this.sidebarAgents;
    }

    public final void D0(String sessionId, String agentId, String deviceId) {
        p9.q<? super String, ? super String, ? super String, Y8.t> qVar = this.changeConversation;
        if (qVar != null) {
            qVar.invoke(sessionId, agentId, deviceId);
        }
    }

    public final void E1() {
        if (this.listLoadingView != null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(M8.SCRIM_COLOR);
        frameLayout.setClickable(true);
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.agentframework.uikit.IndeterminateSpinnerView indeterminateSpinnerView = new com.stepos.agentframework.uikit.IndeterminateSpinnerView(context, null, 0, 6, null);
        indeterminateSpinnerView.setBackgroundCircleColor(androidx.core.content.a.c(indeterminateSpinnerView.getContext(), R$color.popup_rename_bg));
        indeterminateSpinnerView.setColor(androidx.core.content.a.c(indeterminateSpinnerView.getContext(), R$color.rename_btn_confirm_text));
        indeterminateSpinnerView.setRingPaddingDp(8.0f);
        int i10 = (int) (60 * getResources().getDisplayMetrics().density);
        frameLayout.addView(indeterminateSpinnerView, new FrameLayout.LayoutParams(i10, i10, 17));
        addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.listLoadingView = frameLayout;
    }

    public final void F1(View anchor, final SidebarSession conversationTitle, float rawX, float rawY) {
        this.currentConversationTitle = conversationTitle;
        final PopupWindow popupWindowP0 = this.renamePopupWindow;
        if (popupWindowP0 == null) {
            popupWindowP0 = P0();
            this.renamePopupWindow = popupWindowP0;
        }
        if (popupWindowP0.isShowing()) {
            popupWindowP0.dismiss();
            return;
        }
        AgentSession.AgentConversation agentConversationR1 = this.sessionHandler.R1();
        final String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        this.adapter.n(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.M3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatHistoryView.G1(conversationTitle, strB, (SidebarSession) obj));
            }
        });
        popupWindowP0.showAtLocation(anchor, 8388659, (int) rawX, (int) rawY);
        if (popupWindowP0.isShowing()) {
            com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
            String strC = iVar.c("history_rename_menu");
            this.renamePopupLayerId = strC;
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            iVar.e(strC, panelHomePolicy, rootView, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.N3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(ChatHistoryView.H1(popupWindowP0));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.Y2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ChatHistoryView.I1(popupWindowP0);
                }
            }, new com.stepos.ailauncher.chat.panelui.y(popupWindowP0));
        }
    }

    public final void H0(final SidebarAgentItem agent) {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.agentDisconnectDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        View rootView = getRootView();
        kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
        this.agentDisconnectDismiss = C2788d.e(context, rootView, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.v3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.I0(agent, this);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.w3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.J0(agent, this);
            }
        });
    }

    public final void J1() {
        SidebarSession sidebarSession = this.currentConversationTitle;
        if (sidebarSession == null) {
            return;
        }
        View view = this.renameDialogWindowView;
        if (view != null && view.isShown()) {
            b1();
            C4148a.k(this.TAG, "renameDialogWindowView is showing, dismiss~", false, 4, null);
        }
        final String sessionId = sidebarSession.getSessionId();
        final String title = sidebarSession.getTitle();
        final View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_rename_title, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R$id.et_title_input);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_clear_input);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_cancel);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_confirm);
        View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.tv_length_toast);
        final View viewFindViewById2 = viewInflate.findViewById(R$id.ll_dialog_card);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.x3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.K1(this.f26413a, view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.y3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.L1(this.f26424a, view2);
            }
        });
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.z3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryView.M1(view2);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.A3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.N1(editText, view2);
            }
        });
        editText.setFilters(new f[]{new f(20, textView3)});
        final float f10 = getResources().getDisplayMetrics().density * 16.0f;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.B3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatHistoryView.O1(viewFindViewById2, viewInflate, f10, ((Integer) obj).intValue());
            }
        };
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        viewInflate.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.stepos.ailauncher.chat.view.C3
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                return ChatHistoryView.P1(ref$BooleanRef, interfaceC5074l, view2, windowInsets);
            }
        });
        viewInflate.setWindowInsetsAnimationCallback(new g(ref$BooleanRef, interfaceC5074l));
        editText.addTextChangedListener(new h(imageView, textView2, androidx.core.content.a.c(getContext(), R$color.rename_btn_confirm_text), androidx.core.content.a.c(getContext(), R$color.rename_btn_confirm_text_disabled)));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.D3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.Q1(editText, title, this, sessionId, view2);
            }
        });
        editText.setText(title);
        editText.setSelection(title.length());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 768, -3);
        layoutParams.softInputMode = 52;
        try {
            getWindowManager().addView(viewInflate, layoutParams);
            this.renameDialogWindowView = viewInflate;
            com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
            String strC = iVar.c("history_rename_window");
            this.renameWindowLayerId = strC;
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            InterfaceC5063a<Boolean> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.F3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(ChatHistoryView.R1(this.f25772a));
                }
            };
            InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.G3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ChatHistoryView.S1(this.f25785a);
                }
            };
            WindowManager windowManager = getWindowManager();
            kotlin.jvm.internal.p.f(viewInflate);
            iVar.e(strC, panelHomePolicy, rootView, interfaceC5063a, interfaceC5063a2, new com.stepos.ailauncher.chat.panelui.f(windowManager, viewInflate, layoutParams));
            editText.requestFocus();
            if (!viewInflate.hasWindowFocus()) {
                viewInflate.getViewTreeObserver().addOnWindowFocusChangeListener(new i(viewInflate, editText));
            } else {
                WindowInsetsController windowInsetsController = editText.getWindowInsetsController();
                if (windowInsetsController != null) {
                    windowInsetsController.show(WindowInsets.Type.ime());
                }
            }
        } catch (Exception e10) {
            C4148a.g(this.TAG, "showRenameWindow: 添加窗口失败", e10, false, 8, null);
        }
    }

    public final void K0(final SidebarAgentItem agent) {
        final String assetId = agent.getAssetId();
        if (La.H.x0(assetId)) {
            assetId = null;
        }
        if (assetId == null) {
            return;
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.agentUninstallDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        View rootView = getRootView();
        kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
        this.agentUninstallDismiss = C2788d.f(context, rootView, agent.getDisplayName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.m3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.L0(assetId, this, agent);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.n3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.N0(assetId, this);
            }
        });
    }

    public final void O0() {
        if (this.pendingEmptyCacheClear) {
            this.pendingEmptyCacheClear = false;
            if (this.allSessions.isEmpty()) {
                Companion.b();
            }
        }
    }

    public final PopupWindow P0() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.popup_rename_title, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_rename_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_delete);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryView.Q0(this.f26101a, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.e3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryView.R0(this.f26116a, view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setElevation(16.0f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.ailauncher.chat.view.f3
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ChatHistoryView.S0(this.f26129a);
            }
        });
        return popupWindow;
    }

    public final void U0(String sessionId, final InterfaceC5074l<? super Boolean, Y8.t> callback) {
        p9.p<? super String, ? super InterfaceC5074l<? super Boolean, Y8.t>, Y8.t> pVar = this.onDeleteSessionRequested;
        if (pVar == null) {
            callback.invoke(Boolean.FALSE);
        } else {
            pVar.invoke(sessionId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.c3
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatHistoryView.V0(this.f26090a, callback, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    public final void X0() {
        Z0();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.agentDisconnectDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.agentDisconnectDismiss = null;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.agentUninstallDismiss;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
        this.agentUninstallDismiss = null;
        this.uninstallingAgentIds.clear();
        a1();
        b1();
        Y0();
        i1();
    }

    public final void Y0() {
        View view = this.deleteDialogWindowView;
        if (view == null) {
            return;
        }
        this.deleteDialogWindowView = null;
        String str = this.deleteDialogLayerId;
        if (str != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            this.deleteDialogLayerId = null;
        }
        try {
            getWindowManager().removeView(view);
        } catch (Exception e10) {
            C4148a.g("ChatHistoryView", "dismissDeleteDialog: 移除窗口失败", e10, false, 8, null);
        }
    }

    public final void Z0() {
        PopupWindow popupWindow = this.renamePopupWindow;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow = null;
            }
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        PopupWindow popupWindow2 = this.agentActionsPopupWindow;
        if (popupWindow2 != null) {
            if (!popupWindow2.isShowing()) {
                popupWindow2 = null;
            }
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
        }
        this.agentActionsPopupWindow = null;
    }

    public final void a1() {
        androidx.fragment.app.r rVarD1 = d1();
        if (rVarD1 == null) {
            return;
        }
        Fragment fragmentL0 = rVarD1.getSupportFragmentManager().l0(C3024y7.TAG);
        C3024y7 c3024y7 = fragmentL0 instanceof C3024y7 ? (C3024y7) fragmentL0 : null;
        if (c3024y7 != null) {
            c3024y7.dismissAllowingStateLoss();
        }
    }

    public final void b1() {
        View view = this.renameDialogWindowView;
        if (view == null) {
            return;
        }
        this.renameDialogWindowView = null;
        String str = this.renameWindowLayerId;
        if (str != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            this.renameWindowLayerId = null;
        }
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.ime());
        }
        try {
            getWindowManager().removeView(view);
        } catch (Exception e10) {
            C4148a.g(this.TAG, "dismissRenameWindow: 移除窗口失败", e10, false, 8, null);
        }
    }

    public final void c1(SidebarAgentItem agent, AgentAction action) {
        String str;
        int[] iArr = b.$EnumSwitchMapping$0;
        int i10 = iArr[action.ordinal()];
        if (i10 == 1) {
            str = "disconnect";
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "uninstall";
        }
        com.stepos.ailauncher.chat.trace.f.INSTANCE.c(str, agent.getAgentId(), agent.getAgentId());
        int i11 = iArr[action.ordinal()];
        if (i11 == 1) {
            H0(agent);
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            K0(agent);
        }
    }

    public final androidx.fragment.app.r d1() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        while (context instanceof ContextWrapper) {
            if (context instanceof androidx.fragment.app.r) {
                return (androidx.fragment.app.r) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return null;
    }

    public final long e1(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final LinkedHashMap<String, List<SidebarSession>> f1(List<SidebarSession> conversations) {
        LinkedHashMap<String, List<SidebarSession>> linkedHashMap = new LinkedHashMap<>();
        long jE1 = e1(System.currentTimeMillis());
        long j10 = jE1 - 86400000;
        long j11 = jE1 - 604800000;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (SidebarSession sidebarSession : conversations) {
            long updatedAt = sidebarSession.getUpdatedAt();
            if (updatedAt >= jE1) {
                arrayList.add(sidebarSession);
            } else if (updatedAt >= j10) {
                arrayList2.add(sidebarSession);
            } else if (updatedAt >= j11) {
                arrayList3.add(sidebarSession);
            } else {
                arrayList4.add(sidebarSession);
            }
        }
        if (!arrayList.isEmpty()) {
            linkedHashMap.put(getContext().getString(com.stepos.ailauncher.chat.R$string.time_today), arrayList);
        }
        if (!arrayList2.isEmpty()) {
            linkedHashMap.put(getContext().getString(com.stepos.ailauncher.chat.R$string.time_yesterday), arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            linkedHashMap.put(getContext().getString(com.stepos.ailauncher.chat.R$string.time_within_7days), arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            linkedHashMap.put(getContext().getString(com.stepos.ailauncher.chat.R$string.time_earlier), arrayList4);
        }
        return linkedHashMap;
    }

    public final void g1(boolean success) {
        if (success) {
            this.pendingEmptyCacheClear = true;
            q1(this, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.g3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ChatHistoryView.h1(this.f26139a);
                }
            }, 1, null);
        } else {
            i1();
            Toast.makeText(getContext(), com.stepos.ailauncher.chat.R$string.chat_history_delete_failed, 0).show();
        }
    }

    public final p9.q<String, String, String, Y8.t> getChangeConversation() {
        return this.changeConversation;
    }

    public final InterfaceC5063a<Y8.t> getCloseDrawerFun() {
        return this.closeDrawerFun;
    }

    public final InterfaceC5063a<Y8.t> getOnAddAgentClicked() {
        return this.onAddAgentClicked;
    }

    public final InterfaceC5074l<SidebarAgentItem, Y8.t> getOnAgentClicked$chat_release() {
        return this.onAgentClicked;
    }

    public final p9.p<String, InterfaceC5074l<? super Boolean, Y8.t>, Y8.t> getOnDeleteSessionRequested() {
        return this.onDeleteSessionRequested;
    }

    public final void i1() {
        View view = this.listLoadingView;
        if (view != null) {
            removeView(view);
        }
        this.listLoadingView = null;
    }

    public final void j1(String currentSessionId, boolean refreshAgents, InterfaceC5063a<Y8.t> onUpdated) {
        kotlin.jvm.internal.p.i(currentSessionId, "currentSessionId");
        Ua.M m10 = this.viewScope;
        if (m10 == null) {
            return;
        }
        kotlinx.coroutines.g gVar = this.loadJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.loadJob = C1060i.d(m10, null, null, new ChatHistoryView$loadData$1(this, onUpdated, currentSessionId, refreshAgents, null), 3, null);
    }

    public final void l1() {
        this.isLoadingMore = true;
        this.loadedCount = C5685n.j(this.loadedCount + 20, this.allSessions.size());
        o1();
        this.isLoadingMore = false;
    }

    public final void m1(String sessionId) {
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new ChatHistoryView$markSessionCompletedTasksRead$1(this, sessionId, null), 3, null);
        }
    }

    public final void n1() {
        int iFindLastVisibleItemPosition;
        if (this.isLoadingMore || this.loadedCount >= this.allSessions.size()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) == -1 || iFindLastVisibleItemPosition < this.adapter.getItemCount() - 5) {
            return;
        }
        l1();
    }

    public final void o1() {
        this.adapter.m(B0());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.viewScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        TaskModule.INSTANCE.h(this.iTaskUpdate);
        this.sessionHandler.u0(this.conversationListChangeCallback);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(this.accountCallback);
        int childCount = this.recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerView = this.recyclerView;
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i10));
            if (childViewHolder instanceof ChatHistoryAdapter.d) {
                ((ChatHistoryAdapter.d) childViewHolder).a();
            }
        }
        q1(this, true, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.debouncedRefreshFromCallback);
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.viewScope = null;
        this.loadJob = null;
        this.taskPresentationStates.clear();
        this.agentExposeReported = false;
        PopupWindow popupWindow = this.renamePopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this.agentActionsPopupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        this.agentActionsPopupWindow = null;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.agentDisconnectDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.agentDisconnectDismiss = null;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.agentUninstallDismiss;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
        this.agentUninstallDismiss = null;
        this.uninstallingAgentIds.clear();
        a1();
        b1();
        Y0();
        i1();
        int childCount = this.recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerView = this.recyclerView;
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i10));
            if (childViewHolder instanceof ChatHistoryAdapter.d) {
                ((ChatHistoryAdapter.d) childViewHolder).b();
            }
        }
        TaskModule.INSTANCE.l(this.iTaskUpdate);
        this.sessionHandler.j3(this.conversationListChangeCallback);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.C(this.accountCallback);
    }

    public final void p1(boolean refreshAgents, InterfaceC5063a<Y8.t> onUpdated) {
        AgentSession.AgentConversation agentConversationR1 = this.sessionHandler.R1();
        String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        if (strB == null) {
            strB = "";
        }
        j1(strB, refreshAgents, onUpdated);
    }

    public final void r1(String sessionId, String newTitle) {
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!i10.b(context)) {
            Toast.makeText(getContext(), com.stepos.ailauncher.chat.R$string.chat_history_rename_failed, 0).show();
            return;
        }
        E1();
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new ChatHistoryView$renameConversion$1(this, newTitle, sessionId, null), 3, null);
        }
    }

    public final void s1() {
        if (!isAttachedToWindow() || this.agentExposeReported) {
            return;
        }
        this.agentExposeReported = true;
        com.stepos.ailauncher.chat.trace.f.INSTANCE.b();
    }

    public final void setChangeConversation(p9.q<? super String, ? super String, ? super String, Y8.t> qVar) {
        this.changeConversation = qVar;
    }

    public final void setCloseDrawerFun(InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.closeDrawerFun = interfaceC5063a;
    }

    public final void setDrawerContentActive(boolean active) {
        this.adapter.g(active);
        if (active) {
            this.agentExposeReported = false;
        }
    }

    public final void setOnAddAgentClicked(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onAddAgentClicked = interfaceC5063a;
    }

    public final void setOnAgentClicked$chat_release(InterfaceC5074l<? super SidebarAgentItem, Y8.t> interfaceC5074l) {
        this.onAgentClicked = interfaceC5074l;
    }

    public final void setOnDeleteSessionRequested(p9.p<? super String, ? super InterfaceC5074l<? super Boolean, Y8.t>, Y8.t> pVar) {
        this.onDeleteSessionRequested = pVar;
    }

    public final void t1(String sessionId) {
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!i10.b(context)) {
            Toast.makeText(getContext(), R$string.chat_network_error_retry_later, 0).show();
        } else {
            E1();
            U0(sessionId, new ChatHistoryView$requestDeleteConversation$1(this));
        }
    }

    public final SidebarAgentItem u1() {
        Object objB;
        Object objB2;
        Object next;
        Object next2;
        AgentSession.AgentConversation agentConversationR1 = this.sessionHandler.R1();
        Object obj = null;
        if (agentConversationR1 == null) {
            Iterator<T> it = this.agentItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next3 = it.next();
                if (((SidebarAgentItem) next3).getIsPrimary()) {
                    obj = next3;
                    break;
                }
            }
            return (SidebarAgentItem) obj;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(agentConversationR1.getDeviceId());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        try {
            objB2 = Result.b(agentConversationR1.getAgentId());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        String str2 = (String) objB2;
        String str3 = str2 != null ? str2 : "";
        if (La.H.x0(str)) {
            Iterator<T> it2 = this.agentItems.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                SidebarAgentItem sidebarAgentItem = (SidebarAgentItem) next2;
                if (sidebarAgentItem.getInstalled() && !La.H.x0(sidebarAgentItem.getAssetId()) && La.D.L(La.H.D1(sidebarAgentItem.getAssetId()).toString(), La.H.D1(str3).toString(), true)) {
                    break;
                }
            }
            SidebarAgentItem sidebarAgentItem2 = (SidebarAgentItem) next2;
            if (sidebarAgentItem2 != null) {
                return sidebarAgentItem2;
            }
            Iterator<T> it3 = this.agentItems.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next4 = it3.next();
                if (((SidebarAgentItem) next4).getIsPrimary()) {
                    obj = next4;
                    break;
                }
            }
            return (SidebarAgentItem) obj;
        }
        Iterator<T> it4 = this.agentItems.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next = null;
                break;
            }
            next = it4.next();
            SidebarAgentItem sidebarAgentItem3 = (SidebarAgentItem) next;
            if (!sidebarAgentItem3.getIsPrimary() && kotlin.jvm.internal.p.d(sidebarAgentItem3.getDeviceId(), str) && kotlin.jvm.internal.p.d(sidebarAgentItem3.getAgentId(), str3)) {
                break;
            }
        }
        SidebarAgentItem sidebarAgentItem4 = (SidebarAgentItem) next;
        if (sidebarAgentItem4 != null) {
            return sidebarAgentItem4;
        }
        Iterator<T> it5 = this.agentItems.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next5 = it5.next();
            if (((SidebarAgentItem) next5).getIsPrimary()) {
                obj = next5;
                break;
            }
        }
        return (SidebarAgentItem) obj;
    }

    public final void v1() {
        AgentSession.AgentConversation agentConversationR1 = this.sessionHandler.R1();
        final String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        this.adapter.n(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.l3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatHistoryView.w1(strB, (SidebarSession) obj));
            }
        });
    }

    public final void w0(final View item, final SidebarAgentItem agent) {
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        item.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.view.Z2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatHistoryView.x0(ref$FloatRef, ref$FloatRef2, view, motionEvent);
            }
        });
        item.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.ailauncher.chat.view.a3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ChatHistoryView.y0(this.f26059a, item, agent, ref$FloatRef, ref$FloatRef2, view);
            }
        });
    }

    public final void x1() {
        final SidebarSession sidebarSession = this.currentConversationTitle;
        if (sidebarSession == null) {
            return;
        }
        View view = this.deleteDialogWindowView;
        if (view != null && view.isShown()) {
            Y0();
            C4148a.k(this.TAG, "deleteDialogWindowView is showing, dismiss~", false, 4, null);
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_delete_confirm, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_dialog_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_dialog_message);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.tv_cancel);
        TextView textView4 = (TextView) viewInflate.findViewById(R$id.tv_confirm);
        View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        textView.setText(this.txtDeleteChat);
        textView2.setText(getContext().getString(com.stepos.ailauncher.chat.R$string.delete_confirm_message));
        textView4.setText(getContext().getString(com.stepos.ailauncher.chat.R$string.common_confirm_delete));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.o3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.y1(this.f26276a, view2);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.p3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.z1(this.f26288a, view2);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R$id.ll_dialog_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.q3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryView.A1(view2);
                }
            });
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryView.B1(this.f26313a, sidebarSession, view2);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 768, -3);
        try {
            getWindowManager().addView(viewInflate, layoutParams);
            this.deleteDialogWindowView = viewInflate;
            com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
            String strC = iVar.c("history_delete_confirm");
            this.deleteDialogLayerId = strC;
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            InterfaceC5063a<Boolean> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.s3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(ChatHistoryView.C1(this.f26325a));
                }
            };
            InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.u3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ChatHistoryView.D1(this.f26377a);
                }
            };
            WindowManager windowManager = getWindowManager();
            kotlin.jvm.internal.p.f(viewInflate);
            iVar.e(strC, panelHomePolicy, rootView, interfaceC5063a, interfaceC5063a2, new com.stepos.ailauncher.chat.panelui.f(windowManager, viewInflate, layoutParams));
        } catch (Exception e10) {
            C4148a.g("ChatHistoryView", "showDeleteConfirmDialog: 添加窗口失败", e10, false, 8, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "ChatHistoryView";
        this.taskPresentationStates = new LinkedHashMap();
        this.uninstallingAgentIds = new LinkedHashSet();
        this.accountCallback = new c();
        this.closeDrawerFun = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.X2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.G0();
            }
        };
        String string = context.getString(com.stepos.ailauncher.chat.R$string.delete_chat);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        this.txtDeleteChat = string;
        this.agentItems = C1173v.m();
        this.sidebarAgents = C1173v.m();
        this.allSessions = C1173v.m();
        this.loadedCount = 20;
        this.currentSessionIdForBuild = "";
        this.activeSessionIds = Z8.Y.e();
        this.agentExposeReported = true;
        View.inflate(context, R$layout.layout_chat_history, this);
        View viewFindViewById = findViewById(R$id.rv_chat_history);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.recyclerView = recyclerView;
        this.sessionHandler = AgentConfig.INSTANCE.a().n();
        ChatHistoryAdapter chatHistoryAdapter = new ChatHistoryAdapter();
        this.adapter = chatHistoryAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerView.setAdapter(chatHistoryAdapter);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addItemDecoration(new L7(ChatHistoryAdapter.INSTANCE.a(), getResources().getDisplayMetrics().density * 20.0f, 0, 4, null));
        chatHistoryAdapter.h(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.i3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.T(this.f26171a);
            }
        });
        chatHistoryAdapter.i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.t3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatHistoryView.U(this.f26365a, (SidebarAgentItem) obj);
            }
        });
        chatHistoryAdapter.j(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.E3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView.V(this.f25765a);
            }
        });
        chatHistoryAdapter.l(new p9.r() { // from class: com.stepos.ailauncher.chat.view.I3
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatHistoryView.W(this.f25807a, (View) obj, (SidebarSession) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
            }
        });
        chatHistoryAdapter.k(new p9.p() { // from class: com.stepos.ailauncher.chat.view.J3
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatHistoryView.X(this.f25834a, (View) obj, (SidebarAgentItem) obj2);
            }
        });
        recyclerView.addOnScrollListener(new a());
        this.iTaskUpdate = new e();
        this.debouncedRefreshFromCallback = new Runnable() { // from class: com.stepos.ailauncher.chat.view.K3
            @Override // java.lang.Runnable
            public final void run() {
                ChatHistoryView.T0(this.f25850a);
            }
        };
        this.conversationListChangeCallback = new d();
        this.clickListener = new p9.p() { // from class: com.stepos.ailauncher.chat.view.L3
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatHistoryView.E0(this.f25865a, (String) obj, (SidebarSession) obj2);
            }
        };
    }

    public /* synthetic */ ChatHistoryView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
