package com.stepos.ailauncher.chat.fragment;

import A1.g;
import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardOptions;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.g;
import Ua.C1060i;
import V0.CreationExtras;
import Z8.C1168p;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardStatus;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.chat.fragment.I0;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.AskUserInquiryBinder;
import com.stepos.ailauncher.chat.view.AskUserRequest;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.ToolApprovalRequest;
import com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.network.model.RecommendCard;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.C4814a;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t1.C5503a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 é\u00012\u00020\u0001:\u0002ê\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0016J!\u00101\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\u000eJ\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010@\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\t2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0003J\u001d\u0010F\u001a\u00020\u00062\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\u0003J\u0017\u0010K\u001a\u00020\u00062\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bO\u0010PJ\u001f\u0010Q\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bQ\u0010PJ\u0017\u0010R\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bR\u0010 J\u000f\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bS\u0010\u0003J\u000f\u0010T\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010\u0003J\u000f\u0010U\u001a\u00020\u0006H\u0002¢\u0006\u0004\bU\u0010\u0003J\u000f\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010\u0003J\u0017\u0010W\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010XJ\u0015\u0010Z\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0004¢\u0006\u0004\bZ\u0010\bJ!\u0010]\u001a\u00020\u00062\u0006\u00109\u001a\u00020\t2\b\u0010\\\u001a\u0004\u0018\u00010[H\u0016¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u0006¢\u0006\u0004\b_\u0010\u0003J\r\u0010`\u001a\u00020\u0006¢\u0006\u0004\b`\u0010\u0003J\u0017\u0010a\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\t¢\u0006\u0004\ba\u0010bJ\u0015\u0010c\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\bc\u0010\bJa\u0010h\u001a\u00020\u00062\u001a\u0010e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0006\u0018\u00010d2\u001a\u0010f\u001a\u0016\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010d2\u001a\u0010g\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0006\u0018\u00010d¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bj\u0010\u0016J\u0015\u0010l\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0013¢\u0006\u0004\bl\u0010\u0016J\u000f\u0010m\u001a\u00020\u0006H\u0016¢\u0006\u0004\bm\u0010\u0003J\u0015\u0010o\u001a\u00020\u00062\u0006\u0010n\u001a\u00020:¢\u0006\u0004\bo\u0010pJ\r\u0010q\u001a\u00020\u0006¢\u0006\u0004\bq\u0010\u0003J\u0015\u0010t\u001a\u00020\u00062\u0006\u0010s\u001a\u00020r¢\u0006\u0004\bt\u0010uJ\r\u0010v\u001a\u00020\u0006¢\u0006\u0004\bv\u0010\u0003J\u0017\u0010x\u001a\u00020\u00062\u0006\u0010w\u001a\u00020[H\u0016¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\u0006H\u0016¢\u0006\u0004\bz\u0010\u0003R(\u0010|\u001a\u0004\u0018\u00010\u000b2\b\u0010{\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R/\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00012\t\u0010{\u001a\u0005\u0018\u00010\u0082\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008c\u0001\u001a\u00030\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R2\u0010\u008e\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0081\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0081\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0098\u0001R-\u0010¦\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0006\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R-\u0010¨\u0001\u001a\u0016\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010§\u0001R-\u0010©\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0006\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010§\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0081\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¢\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010¤\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010 \u0001R\u001b\u0010º\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010 \u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010\u0098\u0001R!\u0010¾\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010½\u00010¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R!\u0010Á\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010À\u00010¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R \u0010Ã\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001e\u0010Æ\u0001\u001a\t\u0012\u0004\u0012\u00020>0Å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R%\u0010Ê\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030É\u00010È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010\u0081\u0001R\u001f\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Ç\u0001R\u0019\u0010Î\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u0081\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010\u0081\u0001R8\u0010Ñ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ð\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R8\u0010×\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ð\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ò\u0001\u001a\u0006\bØ\u0001\u0010Ô\u0001\"\u0006\bÙ\u0001\u0010Ö\u0001R8\u0010Ú\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ð\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Ò\u0001\u001a\u0006\bÛ\u0001\u0010Ô\u0001\"\u0006\bÜ\u0001\u0010Ö\u0001R\u001c\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u0019\u0010à\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010\u0081\u0001R\u0019\u0010á\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010\u0081\u0001R\u0019\u0010â\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0019\u0010ä\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010\u0081\u0001R\u0019\u0010å\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010\u0081\u0001R\u001c\u0010æ\u0001\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u0018\u0010è\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010\u009d\u0001¨\u0006ë\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "hasContent", "LY8/t;", "A1", "(Z)V", "Landroid/view/View;", Parameters.ROOT, "Lcom/stepos/ailauncher/chat/view/FloatInputView;", "input", "H1", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/FloatInputView;)V", "finalizing", "o0", "Q0", "N0", "", "sessionId", "W1", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/view/X;", "req", "N1", "(Lcom/stepos/ailauncher/chat/view/X;)V", "Lcom/stepos/ailauncher/chat/view/g9;", "T1", "(Lcom/stepos/ailauncher/chat/view/g9;)V", "u1", "s0", "(Lcom/stepos/ailauncher/chat/view/FloatInputView;)V", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "q0", "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "o1", "()Landroid/view/View;", "G0", "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;)V", "J0", "q1", "O0", "A0", "source", "t1", "R0", "(Lcom/stepos/ailauncher/chat/view/FloatInputView;Ljava/lang/String;)V", "K1", "v0", "u0", "suspended", "G1", "w0", "view", "", "M0", "(Landroid/view/View;)F", "chip", "Ly7/E;", "handle", "y0", "(Landroid/view/View;Ly7/E;)V", "V0", "", "Lcom/stepos/ailauncher/network/model/RecommendCard;", "cards", "L0", "(Ljava/util/List;)V", "Z0", "", "index", "c1", "(I)V", "Lcom/stepos/ailauncher/chat/wake/WakeService$b;", "payload", "P1", "(Lcom/stepos/ailauncher/chat/view/FloatInputView;Lcom/stepos/ailauncher/chat/wake/WakeService$b;)V", "R1", "T0", "w1", "P0", "s1", "x0", "V1", "(Landroid/view/View;)Landroid/view/View;", "suppressed", "F1", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "v1", "X1", "I0", "(Landroid/view/View;)V", "z1", "Lkotlin/Function2;", UxipConstants.f30640D, "onFrame", "onEnd", "y1", "(Lp9/p;Lp9/p;Lp9/p;)V", "Y1", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "x1", "onResume", "descentPx", "b1", "(F)V", "n1", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "t0", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", SdCardDbCreator.FIELD_LASTLOC_ID, "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", UxipConstants.f30680s, "inputView", "Lcom/stepos/ailauncher/chat/view/FloatInputView;", "Y0", "()Lcom/stepos/ailauncher/chat/view/FloatInputView;", "inputBarGlassSuspended", "Z", "Landroid/view/ViewGroup;", "circleSelectChipHost", "Landroid/view/ViewGroup;", "W0", "()Landroid/view/ViewGroup;", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "LY8/h;", "X0", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "Lkotlin/Function0;", "onMessageSent", "Lp9/a;", "getOnMessageSent", "()Lp9/a;", "C1", "(Lp9/a;)V", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "recordingSpectrum", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "asrWaitingBar", "Landroid/view/View;", "asrWaitingStop", "asrFinalizing", "Ljava/lang/Runnable;", "pendingAsrFinalizingUiRunnable", "Ljava/lang/Runnable;", "deferWakeVisuals", "pendingEntranceSource", "Ljava/lang/String;", "pendingChatLayout", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "pendingHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "overlayHeightView", "imeAnimationStartCallback", "Lp9/p;", "imeInsetsFrameCallback", "imeAnimationEndCallback", "inputBound", "boundChatLayout", "boundHandler", "Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "bufferedSharePayload", "Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "floatCardContainer", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "LG4/h;", "floatCardHost", "LG4/h;", "Lcom/stepos/ailauncher/chat/wake/U;", "suggestCardEventHandler", "Lcom/stepos/ailauncher/chat/wake/U;", "currentSuggestCardId", "pendingFileIdForMapping", "recommendChips", "", "Landroid/widget/TextView;", "recommendTexts", "[Landroid/widget/TextView;", "Landroid/widget/ImageView;", "recommendIcons", "[Landroid/widget/ImageView;", "recommendChipViews", "[Landroid/view/View;", "", "recommendGlassHandles", "Ljava/util/List;", "", "Landroid/view/View$OnLayoutChangeListener;", "recommendCornerListeners", "Ljava/util/Map;", "recommendGlassAttached", "recommendCards", "recommendExposeReported", "inputHasContent", "Lkotlin/Function1;", "onInputContentChanged", "Lp9/l;", "getOnInputContentChanged", "()Lp9/l;", "B1", "(Lp9/l;)V", "onRecordingPopupShown", "getOnRecordingPopupShown", "D1", "onRecordingTouchBlockNeeded", "getOnRecordingTouchBlockNeeded", "E1", "Landroid/text/TextWatcher;", "recommendInputWatcher", "Landroid/text/TextWatcher;", "recommendConditionsMet", "recommendChipsSuppressed", "lastPanelDescentPx", "F", "overlayHeightSyncPosted", "overlayHeightSyncPending", "overlayRootLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "overlayHeightSyncRunnable", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatInputFragment extends Fragment {
    private static final long ASR_FINALIZING_HIDE_DELAY_MS = 33;
    private static final int RECOMMEND_COUNT = 3;
    private static final float RECOMMEND_GLASS_CORNER_DP = 21.0f;
    private static final float RECOMMEND_ON_CHAT_MIN = 0.99f;
    private static final String RECOMMEND_SCENE = "default";
    private static final long SPECTRUM_BORDER_DURATION_MS = 3500;
    private static final long SPECTRUM_BORDER_FADE_OUT_MS = 1500;
    private static final String TAG = "ChatInputFragment";
    private static final long WAKE_VISUALS_FALLBACK_MS = 450;
    private boolean asrFinalizing;
    private View asrWaitingBar;
    private View asrWaitingStop;
    private LauncherChatLayout boundChatLayout;
    private SessionHandler boundHandler;
    private WakeService.SharePayload bufferedSharePayload;
    private ViewGroup circleSelectChipHost;

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel;
    private String currentSuggestCardId;
    private boolean deferWakeVisuals;
    private FloatCardContainerView floatCardContainer;
    private G4.h floatCardHost;
    private p9.p<? super Boolean, ? super Integer, Y8.t> imeAnimationEndCallback;
    private p9.p<? super Boolean, ? super Integer, Y8.t> imeAnimationStartCallback;
    private p9.p<? super Integer, ? super Boolean, Y8.t> imeInsetsFrameCallback;
    private boolean inputBarGlassSuspended;
    private boolean inputBound;
    private boolean inputHasContent;
    private FloatInputView inputView;
    private float lastPanelDescentPx;
    private InterfaceC5074l<? super Boolean, Y8.t> onInputContentChanged;
    private InterfaceC5063a<Y8.t> onMessageSent;
    private InterfaceC5074l<? super Boolean, Y8.t> onRecordingPopupShown;
    private InterfaceC5074l<? super Boolean, Y8.t> onRecordingTouchBlockNeeded;
    private boolean overlayHeightSyncPending;
    private boolean overlayHeightSyncPosted;
    private final Runnable overlayHeightSyncRunnable;
    private View overlayHeightView;
    private View.OnLayoutChangeListener overlayRootLayoutListener;
    private Runnable pendingAsrFinalizingUiRunnable;
    private LauncherChatLayout pendingChatLayout;
    private String pendingEntranceSource;
    private String pendingFileIdForMapping;
    private SessionHandler pendingHandler;
    private List<RecommendCard> recommendCards;
    private final View[] recommendChipViews;
    private View recommendChips;
    private boolean recommendChipsSuppressed;
    private boolean recommendConditionsMet;
    private final Map<View, View.OnLayoutChangeListener> recommendCornerListeners;
    private boolean recommendExposeReported;
    private boolean recommendGlassAttached;
    private final List<y7.E> recommendGlassHandles;
    private final ImageView[] recommendIcons;
    private TextWatcher recommendInputWatcher;
    private final TextView[] recommendTexts;
    private com.stepos.ailauncher.chat.wake.effect.c recordingSpectrum;
    private com.stepos.ailauncher.chat.wake.U suggestCardEventHandler;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> SPECTRUM_BORDER_ENTRANCE_SOURCES = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_LONG_CLICK_START, "voice_wakeup", C4814a.HEADSET_WAKEUP, C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK);
    private static final int[] RECOMMEND_FALLBACK_TEXTS = {R$string.recommend_chip_schedule, R$string.recommend_chip_bills, R$string.recommend_chip_trips};
    private static final int[] RECOMMEND_FALLBACK_ICONS = {R$drawable.ic_recommend_schedule, R$drawable.ic_recommend_bills, R$drawable.ic_recommend_trips};
    private static final SpectrumBorderConfig ENTRANCE_CONFIG = new SpectrumBorderConfig(1.8f, 0.045f, 0.12f, 0.5f, 1.8f, 0.045f, 0.12f, 0.5f);

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment;", "", "TAG", "Ljava/lang/String;", "", "WAKE_VISUALS_FALLBACK_MS", "J", "", "SPECTRUM_BORDER_ENTRANCE_SOURCES", "Ljava/util/Set;", "SPECTRUM_BORDER_DURATION_MS", "SPECTRUM_BORDER_FADE_OUT_MS", "", "RECOMMEND_COUNT", "I", "", "RECOMMEND_ON_CHAT_MIN", "F", "RECOMMEND_SCENE", "", "RECOMMEND_FALLBACK_TEXTS", "[I", "RECOMMEND_FALLBACK_ICONS", "RECOMMEND_GLASS_CORNER_DP", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "ENTRANCE_CONFIG", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "ASR_FINALIZING_HIDE_DELAY_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatInputFragment a() {
            return new ChatInputFragment();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ ChatInputFragment this$0;

        public b(View view, ChatInputFragment chatInputFragment) {
            this.$this_doOnPreDraw = view;
            this.this$0 = chatInputFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.this$0.isAdded() || this.this$0.inputBarGlassSuspended || this.this$0.recommendGlassAttached) {
                return;
            }
            List listV = Z8.r.V(this.this$0.recommendChipViews);
            ArrayList<View> arrayList = new ArrayList();
            for (Object obj : listV) {
                View view = (View) obj;
                if (view.getWidth() > 0 && view.getHeight() > 0) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() >= 3) {
                this.this$0.recommendGlassAttached = true;
                for (View view2 : arrayList) {
                    view2.setBackground(null);
                    C2851i7 c2851i7 = C2851i7.INSTANCE;
                    y7.E eC = c2851i7.c(view2, false, Float.valueOf(this.this$0.M0(view2)), y7.o.INSTANCE.i());
                    if (eC != null) {
                        this.this$0.recommendGlassHandles.add(eC);
                        c2851i7.i(view2, eC, this.this$0.new c(view2));
                        this.this$0.y0(view2, eC);
                    }
                }
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5074l<y7.E, Y8.t> {
        final /* synthetic */ View $chip;

        public c(View view) {
            this.$chip = view;
        }

        public final void a(y7.E released) {
            kotlin.jvm.internal.p.i(released, "released");
            ChatInputFragment.this.recommendGlassHandles.remove(released);
            View.OnLayoutChangeListener onLayoutChangeListener = (View.OnLayoutChangeListener) ChatInputFragment.this.recommendCornerListeners.remove(this.$chip);
            if (onLayoutChangeListener != null) {
                this.$chip.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
            if (ChatInputFragment.this.recommendGlassHandles.isEmpty()) {
                ChatInputFragment.this.recommendGlassAttached = false;
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(y7.E e10) {
            a(e10);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            String displayText = ((RecommendCard) t10).getDisplayText();
            Integer numValueOf = Integer.valueOf(displayText != null ? displayText.length() : 0);
            String displayText2 = ((RecommendCard) t11).getDisplayText();
            return b9.b.d(numValueOf, Integer.valueOf(displayText2 != null ? displayText2.length() : 0));
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/chat/fragment/ChatInputFragment$e", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            ChatInputFragment.this.u1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12", f = "ChatInputFragment.kt", l = {478}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12, reason: invalid class name */
    public static final class AnonymousClass12 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ View $view;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1", f = "ChatInputFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ View $view;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatInputFragment this$0;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$1", f = "ChatInputFragment.kt", l = {481}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02811 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$1$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    @Override // Xa.c
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(I0.ChatCoreHandle aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        if (aVar != null) {
                            this.this$0.q0(aVar.getChatLayout(), aVar.getHandler());
                        } else {
                            this.this$0.O0();
                        }
                        return Y8.t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02811(ChatInputFragment chatInputFragment, InterfaceC4014c<? super C02811> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new C02811(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((C02811) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.t<I0.ChatCoreHandle> tVarL = this.this$0.X0().l();
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (tVarL.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$2", f = "ChatInputFragment.kt", l = {491}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                final /* synthetic */ View $view;
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$2$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ View $view;
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(View view, ChatInputFragment chatInputFragment) {
                        this.$view = view;
                        this.this$0 = chatInputFragment;
                    }

                    public final Object b(float f10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        this.$view.setTranslationX(r4.getWidth() * (1.0f - f10));
                        if (f10 >= 0.99f) {
                            this.this$0.u1();
                            this.this$0.Z0();
                        }
                        return Y8.t.f7040a;
                    }

                    @Override // Xa.c
                    public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                        return b(((Number) obj).floatValue(), interfaceC4014c);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(ChatInputFragment chatInputFragment, View view, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                    this.$view = view;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass2(this.this$0, this.$view, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.t<Float> tVarP = this.this$0.X0().p();
                        a aVar = new a(this.$view, this.this$0);
                        this.label = 1;
                        if (tVarP.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$3", f = "ChatInputFragment.kt", l = {503}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$3$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    @Override // Xa.c
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(SessionArtifact sessionArtifact, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        FloatInputView inputView = this.this$0.getInputView();
                        if (inputView != null) {
                            inputView.D9();
                        }
                        return Y8.t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(ChatInputFragment chatInputFragment, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass3(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.t<SessionArtifact> tVarI = this.this$0.X0().i();
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (tVarI.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$4", f = "ChatInputFragment.kt", l = {528}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$4, reason: invalid class name */
            public static final class AnonymousClass4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "empty", "collapse", "", "external"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$4$1", f = "ChatInputFragment.kt", l = {}, m = "invokeSuspend", v = 1)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$4$1, reason: invalid class name and collision with other inner class name */
                public static final class C02821 extends SuspendLambda implements p9.s<SheetSettleState, Boolean, Float, Boolean, InterfaceC4014c<? super Boolean>, Object> {
                    /* synthetic */ float F$0;
                    /* synthetic */ Object L$0;
                    /* synthetic */ boolean Z$0;
                    /* synthetic */ boolean Z$1;
                    int label;

                    public C02821(InterfaceC4014c<? super C02821> interfaceC4014c) {
                        super(5, interfaceC4014c);
                    }

                    public final Object f(SheetSettleState sheetSettleState, boolean z10, float f10, boolean z11, InterfaceC4014c<? super Boolean> interfaceC4014c) {
                        C02821 c02821 = new C02821(interfaceC4014c);
                        c02821.L$0 = sheetSettleState;
                        c02821.Z$0 = z10;
                        c02821.F$0 = f10;
                        c02821.Z$1 = z11;
                        return c02821.invokeSuspend(Y8.t.f7040a);
                    }

                    @Override // p9.s
                    public /* bridge */ /* synthetic */ Object invoke(SheetSettleState sheetSettleState, Boolean bool, Float f10, Boolean bool2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
                        return f(sheetSettleState, bool.booleanValue(), f10.floatValue(), bool2.booleanValue(), interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        SheetSettleState sheetSettleState = (SheetSettleState) this.L$0;
                        boolean z10 = this.Z$0;
                        float f10 = this.F$0;
                        boolean z11 = this.Z$1;
                        C4063a.g();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                        return C4109a.a(sheetSettleState == SheetSettleState.FULL && z10 && !z11 && f10 >= 0.99f);
                    }
                }

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$4$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        this.this$0.recommendConditionsMet = z10;
                        this.this$0.v0();
                        return Y8.t.f7040a;
                    }

                    @Override // Xa.c
                    public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                        return b(((Boolean) obj).booleanValue(), interfaceC4014c);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(ChatInputFragment chatInputFragment, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass4(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.b bVarL = Xa.d.l(this.this$0.X0().t(), this.this$0.X0().k(), this.this$0.X0().n(), this.this$0.X0().m(), new C02821(null));
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (bVarL.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    return Y8.t.f7040a;
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$5", f = "ChatInputFragment.kt", l = {537}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$5, reason: invalid class name */
            public static final class AnonymousClass5 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$5$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    @Override // Xa.c
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(AskUserRequest askUserRequest, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        if (askUserRequest != null) {
                            this.this$0.N1(askUserRequest);
                        }
                        return Y8.t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass5(ChatInputFragment chatInputFragment, InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass5(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass5) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.t<AskUserRequest> tVarJ = this.this$0.X0().j();
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (tVarJ.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$6", f = "ChatInputFragment.kt", l = {540}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$6, reason: invalid class name */
            public static final class AnonymousClass6 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$6$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    @Override // Xa.c
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(ToolApprovalRequest toolApprovalRequest, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        if (toolApprovalRequest != null) {
                            this.this$0.T1(toolApprovalRequest);
                        }
                        return Y8.t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass6(ChatInputFragment chatInputFragment, InterfaceC4014c<? super AnonymousClass6> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass6(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass6) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.t<ToolApprovalRequest> tVarV = this.this$0.X0().v();
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (tVarV.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$7", f = "ChatInputFragment.kt", l = {544}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$7, reason: invalid class name */
            public static final class AnonymousClass7 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
                int label;
                final /* synthetic */ ChatInputFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.chat.fragment.ChatInputFragment$onViewCreated$12$1$7$a */
                public static final class a<T> implements Xa.c {
                    final /* synthetic */ ChatInputFragment this$0;

                    public a(ChatInputFragment chatInputFragment) {
                        this.this$0 = chatInputFragment;
                    }

                    @Override // Xa.c
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                        this.this$0.W1(str);
                        return Y8.t.f7040a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass7(ChatInputFragment chatInputFragment, InterfaceC4014c<? super AnonymousClass7> interfaceC4014c) {
                    super(2, interfaceC4014c);
                    this.this$0 = chatInputFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass7(this.this$0, interfaceC4014c);
                }

                @Override // p9.p
                public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    return ((AnonymousClass7) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objG = C4063a.g();
                    int i10 = this.label;
                    if (i10 == 0) {
                        C4849c.b(obj);
                        Xa.o<String> oVarS = this.this$0.X0().s();
                        a aVar = new a(this.this$0);
                        this.label = 1;
                        if (oVarS.collect(aVar, this) == objG) {
                            return objG;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        C4849c.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ChatInputFragment chatInputFragment, View view, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = chatInputFragment;
                this.$view = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$view, interfaceC4014c);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Ua.M m10 = (Ua.M) this.L$0;
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                C1060i.d(m10, null, null, new C02811(this.this$0, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass2(this.this$0, this.$view, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass3(this.this$0, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass4(this.this$0, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass5(this.this$0, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass6(this.this$0, null), 3, null);
                C1060i.d(m10, null, null, new AnonymousClass7(this.this$0, null), 3, null);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass12(View view, InterfaceC4014c<? super AnonymousClass12> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$view = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ChatInputFragment.this.new AnonymousClass12(this.$view, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass12) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                LifecycleOwner viewLifecycleOwner = ChatInputFragment.this.getViewLifecycleOwner();
                kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ChatInputFragment.this, this.$view, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public ChatInputFragment() {
        super(R$layout.fragment_chat_input);
        final InterfaceC5063a interfaceC5063a = null;
        this.coreViewModel = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.t.b(I0.class), new InterfaceC5063a<android.view.V>() { // from class: com.stepos.ailauncher.chat.fragment.ChatInputFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final android.view.V invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new InterfaceC5063a<CreationExtras>() { // from class: com.stepos.ailauncher.chat.fragment.ChatInputFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                InterfaceC5063a interfaceC5063a2 = interfaceC5063a;
                return (interfaceC5063a2 == null || (creationExtras = (CreationExtras) interfaceC5063a2.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new InterfaceC5063a<U.c>() { // from class: com.stepos.ailauncher.chat.fragment.ChatInputFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U.c invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.recommendTexts = new TextView[3];
        this.recommendIcons = new ImageView[3];
        this.recommendChipViews = new View[3];
        this.recommendGlassHandles = new ArrayList();
        this.recommendCornerListeners = new LinkedHashMap();
        this.recommendCards = C1173v.m();
        this.overlayHeightSyncRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.w1
            @Override // java.lang.Runnable
            public final void run() {
                ChatInputFragment.p1(this.f25351a);
            }
        };
    }

    public static final Y8.t B0(ChatInputFragment chatInputFragment, String str) {
        chatInputFragment.w1();
        InterfaceC5063a<Y8.t> interfaceC5063a = chatInputFragment.onMessageSent;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t C0(ChatInputFragment chatInputFragment) throws Resources.NotFoundException {
        chatInputFragment.X0().x();
        chatInputFragment.t1(M5.c.INTERRUPT_USER_NEW_INPUT);
        androidx.fragment.app.r activity = chatInputFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.m8();
            chatActivity.u8();
        }
        return Y8.t.f7040a;
    }

    public static final boolean D0(ChatInputFragment chatInputFragment, FloatInputView floatInputView) {
        AgentSession.AgentConversation agentConversationR1;
        chatInputFragment.X0().z();
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        LauncherChatLayout launcherChatLayout = chatInputFragment.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.p7();
        }
        SessionHandler sessionHandler = chatInputFragment.pendingHandler;
        String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        ChatTracker.INSTANCE.a(strB, strB, null, ChatTracker.INTERRUPT_GENERATING_RESPONSE, null);
        chatInputFragment.t1("user_cancel");
        BaseInputView.k6(floatInputView, false, false, 3, null);
        ChatStopActions.INSTANCE.e(chatInputFragment.pendingHandler);
        return false;
    }

    public static final boolean E0(LauncherChatLayout launcherChatLayout, FloatInputView floatInputView) {
        return launcherChatLayout.isAttachedToWindow() && !floatInputView.a8();
    }

    public static final Y8.t F0(FloatInputView floatInputView) {
        BaseInputView.k6(floatInputView, false, false, 3, null);
        return Y8.t.f7040a;
    }

    public static final void H0(ChatInputFragment chatInputFragment, LauncherChatLayout launcherChatLayout, View view) {
        View viewO1;
        if (chatInputFragment.pendingChatLayout == launcherChatLayout && chatInputFragment.isAdded() && (viewO1 = chatInputFragment.o1()) != view) {
            launcherChatLayout.q8(viewO1);
        }
    }

    public static final void I1(FloatInputView floatInputView, View view) {
        floatInputView.t5();
    }

    public static final Y8.t J1(ChatInputFragment chatInputFragment, boolean z10) {
        chatInputFragment.o0(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t K0(ChatInputFragment chatInputFragment, boolean z10, boolean z11) {
        LauncherChatLayout launcherChatLayout = chatInputFragment.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.r8(z10, z11);
        }
        return Y8.t.f7040a;
    }

    public static final void L1(ChatInputFragment chatInputFragment, int i10, View view) {
        chatInputFragment.c1(i10);
    }

    public static final Y8.t M1(InterfaceC5074l interfaceC5074l, ChatInputFragment chatInputFragment, boolean z10) {
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        chatInputFragment.A1(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t O1(ChatInputFragment chatInputFragment, boolean z10) {
        chatInputFragment.X0().I(z10);
        return Y8.t.f7040a;
    }

    public static final void Q1(ChatInputFragment chatInputFragment, FloatInputView floatInputView, WakeService.SuggestPayload suggestPayload) {
        chatInputFragment.R1(floatInputView, suggestPayload);
    }

    public static final void S0(FloatInputView floatInputView, String str, List list, String str2) {
        if (str == null) {
            str = "";
        }
        floatInputView.eb(str, list, true, str2);
    }

    public static final Y8.t S1(ChatInputFragment chatInputFragment, FloatInputView floatInputView, String selectedText) {
        Editable text;
        String string;
        kotlin.jvm.internal.p.i(selectedText, "selectedText");
        chatInputFragment.P0();
        EditText editText = (EditText) floatInputView.findViewById(R$id.et_input_bar);
        String string2 = (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 0) {
            selectedText = string2 + " " + selectedText;
        }
        floatInputView.Va(selectedText);
        return Y8.t.f7040a;
    }

    public static final Y8.t U0(ChatInputFragment chatInputFragment, boolean z10, FloatCardOptions floatCardOptions) {
        kotlin.jvm.internal.p.i(floatCardOptions, "<unused var>");
        LauncherChatLayout launcherChatLayout = chatInputFragment.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.setScrollToBottomLiftedForFloatingCard(z10);
        }
        return Y8.t.f7040a;
    }

    public static final void U1(FloatInputView floatInputView, LauncherChatLayout launcherChatLayout) {
        if (floatInputView.U6()) {
            return;
        }
        launcherChatLayout.L8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I0 X0() {
        return (I0) this.coreViewModel.getValue();
    }

    public static final void Z1(ChatInputFragment chatInputFragment) {
        chatInputFragment.n1();
    }

    public static final boolean d1(ChatInputFragment chatInputFragment) {
        return chatInputFragment.inputBound;
    }

    public static final Y8.t e1(ChatInputFragment chatInputFragment, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatInputFragment.onRecordingPopupShown;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t f1(ChatInputFragment chatInputFragment, String str) {
        chatInputFragment.v0();
        androidx.fragment.app.r activity = chatInputFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.U6();
        }
        return Y8.t.f7040a;
    }

    public static final RecordingPresentation g1(ChatActivity chatActivity, FloatInputView floatInputView) {
        if (chatActivity != null) {
            RecordingPresentation recordingPresentationV9 = chatActivity.v9(floatInputView.getRecordingPresentation() == RecordingPresentation.INPUT_BAR);
            if (recordingPresentationV9 != null) {
                return recordingPresentationV9;
            }
        }
        return floatInputView.getRecordingPresentation();
    }

    public static final com.stepos.ailauncher.chat.voice.longpress.N h1(ChatActivity chatActivity) {
        return chatActivity.R6();
    }

    public static final Y8.t i1(ChatInputFragment chatInputFragment) {
        chatInputFragment.u1();
        return Y8.t.f7040a;
    }

    public static final void j1(ChatInputFragment chatInputFragment, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        chatInputFragment.u1();
    }

    public static final Y8.t k1(ChatInputFragment chatInputFragment, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatInputFragment.onRecordingPopupShown;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t l1(ChatInputFragment chatInputFragment, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatInputFragment.onRecordingPopupShown;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t m1(ChatInputFragment chatInputFragment, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatInputFragment.onRecordingTouchBlockNeeded;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final void p0(ChatInputFragment chatInputFragment) {
        chatInputFragment.pendingAsrFinalizingUiRunnable = null;
        chatInputFragment.Q0();
    }

    public static final void p1(ChatInputFragment chatInputFragment) {
        View view;
        LauncherChatLayout launcherChatLayout;
        chatInputFragment.overlayHeightSyncPosted = false;
        if (chatInputFragment.overlayHeightSyncPending && chatInputFragment.isAdded() && (view = chatInputFragment.getView()) != null && view.isAttachedToWindow() && (launcherChatLayout = chatInputFragment.pendingChatLayout) != null) {
            chatInputFragment.overlayHeightSyncPending = false;
            if (launcherChatLayout != null) {
                launcherChatLayout.c9();
            }
        }
    }

    public static final void r0(ChatInputFragment chatInputFragment) {
        String strG = chatInputFragment.X0().g();
        if (strG != null) {
            chatInputFragment.x1(strG);
        }
    }

    public static final boolean r1() {
        return true;
    }

    public static final void z0(y7.E e10, ChatInputFragment chatInputFragment, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i13 - i11 == i17 - i15) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        kotlin.jvm.internal.p.f(view);
        c2851i7.m(e10, chatInputFragment.M0(view), view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0() {
        final LauncherChatLayout launcherChatLayout;
        SessionHandler sessionHandler;
        final FloatInputView floatInputView = this.inputView;
        if (floatInputView == null || (launcherChatLayout = this.pendingChatLayout) == null || (sessionHandler = this.pendingHandler) == null) {
            return;
        }
        if (this.inputBound && this.boundChatLayout == launcherChatLayout && this.boundHandler == sessionHandler) {
            return;
        }
        q1();
        launcherChatLayout.m3(floatInputView);
        floatInputView.b(sessionHandler);
        floatInputView.setOnMessageSentCallback(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.e1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.B0(this.f25267a, (String) obj);
            }
        });
        floatInputView.setOnSendInitiated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.f1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatInputFragment.C0(this.f25270a);
            }
        });
        floatInputView.setOnStopClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.g1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ChatInputFragment.D0(this.f25274a, floatInputView));
            }
        });
        floatInputView.setActiveArtifactFlow(X0().i());
        launcherChatLayout.setCanPlayTTS(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.h1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ChatInputFragment.E0(launcherChatLayout, floatInputView));
            }
        });
        launcherChatLayout.setOnRoundUnsuccessfulListener(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.i1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatInputFragment.F0(floatInputView);
            }
        });
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.h();
        }
        com.stepos.ailauncher.chat.wake.effect.c cVar2 = new com.stepos.ailauncher.chat.wake.effect.c(V1(floatInputView), null, 2, 0 == true ? 1 : 0);
        cVar2.d(floatInputView);
        this.recordingSpectrum = cVar2;
        this.boundChatLayout = launcherChatLayout;
        this.boundHandler = sessionHandler;
        this.inputBound = true;
        floatInputView.P8();
        WakeService.SharePayload sharePayload = this.bufferedSharePayload;
        if (sharePayload != null) {
            this.bufferedSharePayload = null;
            floatInputView.G4(sharePayload.getText(), sharePayload.b());
        }
        C4148a.d(TAG, "bind done handler=" + sessionHandler, false, 4, null);
    }

    public final void A1(boolean hasContent) {
        if (hasContent == this.inputHasContent) {
            return;
        }
        this.inputHasContent = hasContent;
        v0();
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onInputContentChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(hasContent));
        }
    }

    public final void B1(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onInputContentChanged = interfaceC5074l;
    }

    public final void C1(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onMessageSent = interfaceC5063a;
    }

    public final void D1(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onRecordingPopupShown = interfaceC5074l;
    }

    public final void E1(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onRecordingTouchBlockNeeded = interfaceC5074l;
    }

    public final void F1(boolean suppressed) {
        if (suppressed == this.recommendChipsSuppressed) {
            return;
        }
        this.recommendChipsSuppressed = suppressed;
        v0();
    }

    public final void G0(final LauncherChatLayout chatLayout) {
        final View viewRequireView = requireView();
        kotlin.jvm.internal.p.h(viewRequireView, "requireView(...)");
        View viewO1 = o1();
        chatLayout.q8(viewO1);
        if (viewO1 == viewRequireView) {
            viewRequireView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.u1
                @Override // java.lang.Runnable
                public final void run() {
                    ChatInputFragment.H0(this.f25341a, chatLayout, viewRequireView);
                }
            });
        }
    }

    public final void G1(boolean suspended) {
        if (!suspended) {
            View view = this.recommendChips;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            w0();
            return;
        }
        Iterator<T> it = this.recommendGlassHandles.iterator();
        while (it.hasNext()) {
            C2851i7.INSTANCE.h((y7.E) it.next());
        }
        this.recommendGlassHandles.clear();
        for (Map.Entry<View, View.OnLayoutChangeListener> entry : this.recommendCornerListeners.entrySet()) {
            entry.getKey().removeOnLayoutChangeListener(entry.getValue());
        }
        this.recommendCornerListeners.clear();
        this.recommendGlassAttached = false;
    }

    public final void H1(View root, final FloatInputView input) {
        this.asrWaitingBar = root.findViewById(R$id.chat_input_waiting_bar);
        View viewFindViewById = root.findViewById(R$id.chat_input_waiting_stop);
        this.asrWaitingStop = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.q1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatInputFragment.I1(input, view);
                }
            });
        }
        input.setOnAsrFinalizingChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.r1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.J1(this.f25333a, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void I0(View view) {
        LauncherChatLayout launcherChatLayout;
        if (this.overlayHeightView == view) {
            return;
        }
        this.overlayHeightView = view;
        if ((view == null && (view = getView()) == null) || (launcherChatLayout = this.pendingChatLayout) == null) {
            return;
        }
        launcherChatLayout.q8(view);
        u1();
    }

    public final void J0() {
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setOverlayReserveFreezeAction(new p9.p() { // from class: com.stepos.ailauncher.chat.fragment.o1
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return ChatInputFragment.K0(this.f25324a, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K1(View root, FloatInputView input) {
        String string;
        Editable text;
        String string2;
        this.recommendChips = root.findViewById(R$id.recommend_chips);
        int[] iArr = {R$id.chip_recommend_1, R$id.chip_recommend_2, R$id.chip_recommend_3};
        int[] iArr2 = {R$id.tv_recommend_1, R$id.tv_recommend_2, R$id.tv_recommend_3};
        int[] iArr3 = {R$id.iv_recommend_1, R$id.iv_recommend_2, R$id.iv_recommend_3};
        final int i10 = 0;
        while (true) {
            string = null;
            if (i10 >= 3) {
                break;
            }
            this.recommendTexts[i10] = root.findViewById(iArr2[i10]);
            this.recommendIcons[i10] = root.findViewById(iArr3[i10]);
            View[] viewArr = this.recommendChipViews;
            View viewFindViewById = root.findViewById(iArr[i10]);
            if (viewFindViewById != 0) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.j1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatInputFragment.L1(this.f25297a, i10, view);
                    }
                });
                Y8.t tVar = Y8.t.f7040a;
                string = viewFindViewById;
            }
            viewArr[i10] = string;
            i10++;
        }
        final InterfaceC5074l<Boolean, Y8.t> onInputContentChanged = input.getOnInputContentChanged();
        input.setOnInputContentChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.k1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.M1(onInputContentChanged, this, ((Boolean) obj).booleanValue());
            }
        });
        EditText editText = (EditText) input.findViewById(R$id.et_input_bar);
        if (editText != null && (text = editText.getText()) != null && (string2 = text.toString()) != null) {
            string = La.H.D1(string2).toString();
        }
        A1(((string == null || string.length() == 0) && input.dc().isEmpty()) ? false : true);
        e eVar = new e();
        if (editText != null) {
            editText.addTextChangedListener(eVar);
        }
        this.recommendInputWatcher = eVar;
        V0();
    }

    public final void L0(List<RecommendCard> cards) {
        ImageView imageView;
        TextView textView;
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            List<RecommendCard> listC1 = Z8.F.c1(cards, new d());
            if (kotlin.jvm.internal.p.d(listC1, this.recommendCards)) {
                return;
            }
            this.recommendCards = listC1;
            for (int i10 = 0; i10 < 3; i10++) {
                RecommendCard recommendCard = (RecommendCard) Z8.F.t0(listC1, i10);
                if (recommendCard != null) {
                    String displayText = recommendCard.getDisplayText();
                    if (displayText != null) {
                        if (La.H.x0(displayText)) {
                            displayText = null;
                        }
                        if (displayText != null && (textView = this.recommendTexts[i10]) != null) {
                            textView.setText(displayText);
                        }
                    }
                    String iconUrl = recommendCard.getIconUrl();
                    if (iconUrl != null) {
                        String str = La.H.x0(iconUrl) ? null : iconUrl;
                        if (str != null && (imageView = this.recommendIcons[i10]) != null) {
                            coil.c cVarA = C5503a.a(imageView.getContext());
                            g.a aVarR = new g.a(imageView.getContext()).d(str).r(imageView);
                            aVarR.a(false);
                            int[] iArr = RECOMMEND_FALLBACK_ICONS;
                            aVarR.k(iArr[i10]);
                            aVarR.g(iArr[i10]);
                            cVarA.c(aVarR.c());
                        }
                    }
                }
            }
            Z0();
        }
    }

    public final float M0(View view) {
        if (view.getHeight() <= 0) {
            return RECOMMEND_GLASS_CORNER_DP;
        }
        return (Math.min(view.getWidth(), r1) / 2.0f) / view.getResources().getDisplayMetrics().density;
    }

    public final void N0() {
        this.asrFinalizing = false;
        View view = this.asrWaitingBar;
        if (view == null) {
            view = this.inputView;
        }
        Runnable runnable = this.pendingAsrFinalizingUiRunnable;
        if (runnable != null && view != null) {
            view.removeCallbacks(runnable);
        }
        this.pendingAsrFinalizingUiRunnable = null;
        View view2 = this.asrWaitingBar;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setVisibility(0);
        }
        FloatInputView floatInputView2 = this.inputView;
        if (floatInputView2 != null) {
            floatInputView2.setOnAsrFinalizingChanged(null);
        }
        View view3 = this.asrWaitingStop;
        if (view3 != null) {
            view3.setOnClickListener(null);
        }
        this.asrWaitingBar = null;
        this.asrWaitingStop = null;
    }

    public final void N1(AskUserRequest req) {
        FloatInputView floatInputView = this.inputView;
        if (floatInputView == null) {
            return;
        }
        X0().f();
        AskUserInquiryBinder.INSTANCE.j(floatInputView, req, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.p1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.O1(this.f25327a, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void O0() {
        FloatInputView floatInputView;
        if (this.inputBound && (floatInputView = this.inputView) != null) {
            BaseInputView.y5(floatInputView, null, 1, null);
        }
        q1();
        FloatInputView floatInputView2 = this.inputView;
        if (floatInputView2 != null) {
            floatInputView2.setActiveArtifactFlow(null);
        }
        FloatInputView floatInputView3 = this.inputView;
        if (floatInputView3 != null) {
            floatInputView3.setOverlayReserveFreezeAction(null);
        }
        LauncherChatLayout launcherChatLayout = this.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.e9();
        }
        this.pendingChatLayout = null;
        this.pendingHandler = null;
        this.inputBound = false;
    }

    public final void P0() {
        IFloatCardService iFloatCardService;
        String str = this.currentSuggestCardId;
        if (str != null && (iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            IFloatCardService.dismiss$default(iFloatCardService, str, false, 2, null);
        }
        this.currentSuggestCardId = null;
    }

    public final void P1(final FloatInputView input, final WakeService.SuggestPayload payload) {
        String fileId = payload.getFileId();
        if (fileId != null && fileId.length() != 0) {
            this.pendingFileIdForMapping = payload.getFileId();
        }
        input.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.x1
            @Override // java.lang.Runnable
            public final void run() {
                ChatInputFragment.Q1(this.f25354a, input, payload);
            }
        });
    }

    public final void Q0() {
        boolean z10 = this.asrFinalizing;
        View view = this.asrWaitingBar;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setVisibility(z10 ? 4 : 0);
        }
    }

    public final void R0(final FloatInputView input, String source) {
        List<FileInfo> list;
        WakeService.Companion companion = WakeService.INSTANCE;
        Pair<String, List<FileInfo>> pairT = companion.T();
        if (pairT != null) {
            final String strA = pairT.a();
            final List<FileInfo> listB = pairT.b();
            if ((strA != null && strA.length() != 0) || ((list = listB) != null && !list.isEmpty())) {
                final String str = WakeDialogImpl.INSTANCE.f(source) ? WakeDialogImpl.MSG_SOURCE_AI_WAKE : null;
                input.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.v1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatInputFragment.S0(input, strA, listB, str);
                    }
                }, 200L);
            }
        }
        WakeService.SharePayload sharePayloadU = companion.U();
        if (sharePayloadU != null) {
            if (this.inputBound) {
                input.G4(sharePayloadU.getText(), sharePayloadU.b());
            } else {
                this.bufferedSharePayload = sharePayloadU;
            }
        }
        WakeService.SuggestPayload suggestPayloadV = companion.V();
        if (suggestPayloadV != null) {
            P1(input, suggestPayloadV);
        }
    }

    public final void R1(final FloatInputView input, WakeService.SuggestPayload payload) {
        FloatCardContent floatCardContent;
        IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
        if (iFloatCardService == null) {
            C4148a.u(TAG, "showSuggestCardInternal: IFloatCardService is null", false, 4, null);
            return;
        }
        T0(input);
        if (this.floatCardHost == null) {
            C4148a.u(TAG, "showSuggestCardInternal: floatCardHost is null", false, 4, null);
            return;
        }
        if (this.suggestCardEventHandler == null) {
            com.stepos.ailauncher.chat.wake.U u10 = new com.stepos.ailauncher.chat.wake.U(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.y1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatInputFragment.S1(this.f25361a, input, (String) obj);
                }
            });
            iFloatCardService.registerEventHandler(u10);
            this.suggestCardEventHandler = u10;
        }
        boolean zIsEmpty = payload.b().isEmpty();
        String str = this.currentSuggestCardId;
        if (str != null && !zIsEmpty) {
            List<String> listB = payload.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            for (String str2 : listB) {
                arrayList.add(new FloatCardOption(str2, str2, false, false, false, 28, null));
            }
            iFloatCardService.update(str, new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, C1172u.e(new g.Selection("suggest_selection", null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), null, null, Boolean.FALSE, null, null, 878, null)), null, FloatCardStatus.Normal, null, null, 26, null));
            return;
        }
        String str3 = "suggest_card_" + System.currentTimeMillis();
        this.currentSuggestCardId = str3;
        if (zIsEmpty) {
            floatCardContent = new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, null, null, null, Boolean.FALSE, null, null, 894, null)), null, FloatCardStatus.Loading, null, null, 26, null);
        } else {
            List<String> listB2 = payload.b();
            ArrayList arrayList2 = new ArrayList(C1174w.x(listB2, 10));
            for (String str4 : listB2) {
                arrayList2.add(new FloatCardOption(str4, str4, false, false, false, 28, null));
            }
            floatCardContent = new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, C1172u.e(new g.Selection("suggest_selection", null, arrayList2, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), null, null, Boolean.FALSE, null, null, 878, null)), null, null, null, null, 30, null);
        }
        iFloatCardService.show(new FloatCardRequest(str3, "common_form", com.stepos.ailauncher.chat.wake.U.BUSINESS_TYPE, FloatCardScene.WakeDialog, floatCardContent, new FloatCardOptions(false, true, true, false, false, 24, null), null, 64, null));
    }

    public final void T0(FloatInputView input) {
        ViewStub viewStub;
        FloatCardContainerView floatCardContainerView;
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if (floatCardContainerView2 == null || this.floatCardHost == null) {
            if (floatCardContainerView2 == null && (viewStub = (ViewStub) input.findViewById(R$id.vsInfoCard)) != null) {
                View viewInflate = viewStub.inflate();
                FloatCardContainerView floatCardContainerView3 = null;
                ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
                if (viewGroup != null && (floatCardContainerView = (FloatCardContainerView) viewGroup.findViewById(R$id.float_card_container)) != null) {
                    floatCardContainerView3 = floatCardContainerView;
                } else if (viewInflate instanceof FloatCardContainerView) {
                    floatCardContainerView3 = (FloatCardContainerView) viewInflate;
                }
                this.floatCardContainer = floatCardContainerView3;
            }
            if (this.floatCardContainer == null || this.floatCardHost != null) {
                return;
            }
            Context context = input.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            FloatCardContainerView floatCardContainerView4 = this.floatCardContainer;
            kotlin.jvm.internal.p.f(floatCardContainerView4);
            G4.h hVar = new G4.h("chat_input_float_card", 100, context, floatCardContainerView4, Z8.X.d(FloatCardScene.WakeDialog), new p9.p() { // from class: com.stepos.ailauncher.chat.fragment.z1
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return ChatInputFragment.U0(this.f25367a, ((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
                }
            }, null, null, 192, null);
            this.floatCardHost = hVar;
            IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
            if (iFloatCardService != null) {
                iFloatCardService.registerHost(hVar);
            }
        }
    }

    public final void T1(ToolApprovalRequest req) {
        final LauncherChatLayout launcherChatLayout;
        final FloatInputView floatInputView = this.inputView;
        if (floatInputView == null || (launcherChatLayout = this.pendingChatLayout) == null) {
            return;
        }
        X0().h();
        if (AskUserInquiryBinder.INSTANCE.l(floatInputView, launcherChatLayout, req)) {
            return;
        }
        launcherChatLayout.S8();
        floatInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.n1
            @Override // java.lang.Runnable
            public final void run() {
                ChatInputFragment.U1(floatInputView, launcherChatLayout);
            }
        });
    }

    public final void V0() {
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ChatInputFragment$fetchRecommendCards$1(this, null), 3, null);
        }
    }

    public final View V1(View input) {
        for (Context context = input.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                View decorView = ((Activity) context).getWindow().getDecorView();
                kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
                return decorView;
            }
        }
        return input;
    }

    /* renamed from: W0, reason: from getter */
    public final ViewGroup getCircleSelectChipHost() {
        return this.circleSelectChipHost;
    }

    public final void W1(String sessionId) {
        SessionHandler sessionHandler;
        SessionHandler sessionHandler2;
        AskUserRequest value = X0().j().getValue();
        if (value != null) {
            FloatInputView floatInputView = this.inputView;
            if (!((floatInputView == null || (sessionHandler2 = floatInputView.getSessionHandler()) == null) ? kotlin.jvm.internal.p.d(value.getSessionId(), sessionId) : sessionHandler2.z3(value.getSessionId(), sessionId))) {
                X0().f();
                X0().I(false);
            }
        }
        ToolApprovalRequest value2 = X0().v().getValue();
        if (value2 != null) {
            FloatInputView floatInputView2 = this.inputView;
            if (!((floatInputView2 == null || (sessionHandler = floatInputView2.getSessionHandler()) == null) ? kotlin.jvm.internal.p.d(value2.getSessionId(), sessionId) : sessionHandler.z3(value2.getSessionId(), sessionId))) {
                X0().h();
            }
        }
        FloatInputView floatInputView3 = this.inputView;
        if (floatInputView3 != null && floatInputView3.m6(sessionId)) {
            X0().I(false);
        }
    }

    public final void X1() {
        LauncherChatLayout launcherChatLayout = this.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.c9();
        }
        u1();
    }

    /* renamed from: Y0, reason: from getter */
    public final FloatInputView getInputView() {
        return this.inputView;
    }

    public final void Y1(String source) {
        FloatInputView floatInputView = this.inputView;
        if (floatInputView == null) {
            C4148a.u(TAG, "wake skipped: inputView not ready", false, 4, null);
            return;
        }
        floatInputView.f9(source);
        x0();
        floatInputView.hd(source);
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
            floatInputView.t4();
        } else if (C4814a.INSTANCE.f(source)) {
            BaseInputView.oc(floatInputView, null, null, 3, null);
        }
        R0(floatInputView, source);
        floatInputView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.s1
            @Override // java.lang.Runnable
            public final void run() {
                ChatInputFragment.Z1(this.f25335a);
            }
        }, WAKE_VISUALS_FALLBACK_MS);
    }

    public final void Z0() {
        View view;
        if (this.recommendExposeReported || (view = this.recommendChips) == null || view.getVisibility() != 0 || X0().p().getValue().floatValue() < 0.99f || this.recommendCards.isEmpty()) {
            return;
        }
        this.recommendExposeReported = true;
        int i10 = 0;
        while (i10 < 3) {
            com.stepos.ailauncher.chat.trace.d dVar = com.stepos.ailauncher.chat.trace.d.INSTANCE;
            RecommendCard recommendCard = (RecommendCard) Z8.F.t0(this.recommendCards, i10);
            i10++;
            dVar.d(recommendCard != null ? recommendCard.getId() : null, "chatview", i10);
        }
    }

    public final void a1() {
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            BaseInputView.k6(floatInputView, false, false, 2, null);
        }
        FloatInputView floatInputView2 = this.inputView;
        if (floatInputView2 != null) {
            floatInputView2.n6();
        }
        X0().I(false);
        P0();
    }

    public final void b1(float descentPx) {
        this.lastPanelDescentPx = descentPx;
        u0();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c1(int r12) {
        /*
            r11 = this;
            com.stepos.ailauncher.chat.trace.d r0 = com.stepos.ailauncher.chat.trace.d.INSTANCE
            java.util.List<com.stepos.ailauncher.network.model.RecommendCard> r1 = r11.recommendCards
            java.lang.Object r1 = Z8.F.t0(r1, r12)
            com.stepos.ailauncher.network.model.RecommendCard r1 = (com.stepos.ailauncher.network.model.RecommendCard) r1
            r2 = 0
            if (r1 == 0) goto L12
            java.lang.String r1 = r1.getId()
            goto L13
        L12:
            r1 = r2
        L13:
            int r3 = r12 + 1
            java.lang.String r4 = "chatview"
            r0.c(r1, r4, r3)
            android.content.Context r6 = r11.getContext()
            if (r6 != 0) goto L21
            goto L2d
        L21:
            com.stepos.ailauncher.chat.manager.AuthManager r5 = com.stepos.ailauncher.chat.manager.AuthManager.INSTANCE
            r9 = 4
            r10 = 0
            r7 = 1
            r8 = 0
            boolean r0 = com.stepos.ailauncher.chat.manager.AuthManager.O(r5, r6, r7, r8, r9, r10)
            if (r0 != 0) goto L2e
        L2d:
            return
        L2e:
            java.util.List<com.stepos.ailauncher.network.model.RecommendCard> r0 = r11.recommendCards
            java.lang.Object r0 = Z8.F.t0(r0, r12)
            com.stepos.ailauncher.network.model.RecommendCard r0 = (com.stepos.ailauncher.network.model.RecommendCard) r0
            if (r0 == 0) goto L48
            java.lang.String r0 = r0.getPrompt()
            if (r0 == 0) goto L48
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L45
            goto L46
        L45:
            r0 = r2
        L46:
            if (r0 != 0) goto L55
        L48:
            int[] r0 = com.stepos.ailauncher.chat.fragment.ChatInputFragment.RECOMMEND_FALLBACK_TEXTS
            r12 = r0[r12]
            java.lang.String r0 = r11.getString(r12)
            java.lang.String r12 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r12)
        L55:
            com.stepos.ailauncher.chat.view.FloatInputView r11 = r11.inputView
            if (r11 != 0) goto L63
            r11 = 0
            r12 = 4
            java.lang.String r0 = "ChatInputFragment"
            java.lang.String r1 = "onRecommendClick skipped: inputView not ready"
            h8.C4148a.u(r0, r1, r11, r12, r2)
            return
        L63:
            r11.E4(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.ChatInputFragment.c1(int):void");
    }

    public final void n1() {
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.ca();
        }
        if (this.deferWakeVisuals) {
            this.deferWakeVisuals = false;
            com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
            if (cVar != null) {
                cVar.j(false);
            }
        }
    }

    public final void o0(boolean finalizing) {
        this.asrFinalizing = finalizing;
        View view = this.asrWaitingBar;
        if (view == null && (view = this.inputView) == null) {
            return;
        }
        Runnable runnable = this.pendingAsrFinalizingUiRunnable;
        if (runnable != null) {
            view.removeCallbacks(runnable);
        }
        this.pendingAsrFinalizingUiRunnable = null;
        if (finalizing) {
            Q0();
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.t1
            @Override // java.lang.Runnable
            public final void run() {
                ChatInputFragment.p0(this.f25338a);
            }
        };
        this.pendingAsrFinalizingUiRunnable = runnable2;
        view.postDelayed(runnable2, 33L);
    }

    public final View o1() {
        View view = this.overlayHeightView;
        if (view != null) {
            return view;
        }
        View viewRequireView = requireView();
        kotlin.jvm.internal.p.h(viewRequireView, "requireView(...)");
        Object parent = viewRequireView.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        return (view2 == null || view2.getId() != com.stepos.ailauncher.sheet.R$id.ail_resident_bottom_slot) ? viewRequireView : view2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        FloatInputView floatInputView;
        EditText editText;
        View view;
        FloatInputView floatInputView2 = this.inputView;
        if (floatInputView2 != null) {
            BaseInputView.y5(floatInputView2, null, 1, null);
        }
        q1();
        FloatInputView floatInputView3 = this.inputView;
        if (floatInputView3 != null) {
            floatInputView3.setRecordingSendReady(null);
        }
        View view2 = getView();
        if (view2 != null) {
            view2.removeCallbacks(this.overlayHeightSyncRunnable);
        }
        this.overlayHeightSyncPosted = false;
        this.overlayHeightSyncPending = false;
        View.OnLayoutChangeListener onLayoutChangeListener = this.overlayRootLayoutListener;
        if (onLayoutChangeListener != null && (view = getView()) != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.overlayRootLayoutListener = null;
        FloatInputView floatInputView4 = this.inputView;
        if (floatInputView4 != null) {
            floatInputView4.setRecordingPresentationProvider(null);
        }
        FloatInputView floatInputView5 = this.inputView;
        if (floatInputView5 != null) {
            floatInputView5.setOnFullScreenListeningDismissRequest(null);
        }
        FloatInputView floatInputView6 = this.inputView;
        if (floatInputView6 != null) {
            floatInputView6.setOnInputLayoutChanged(null);
        }
        FloatInputView floatInputView7 = this.inputView;
        if (floatInputView7 != null) {
            floatInputView7.setOnImeAnimationStart(null);
        }
        FloatInputView floatInputView8 = this.inputView;
        if (floatInputView8 != null) {
            floatInputView8.setOnImeInsetsFrame(null);
        }
        FloatInputView floatInputView9 = this.inputView;
        if (floatInputView9 != null) {
            floatInputView9.setOnImeAnimationEnd(null);
        }
        FloatInputView floatInputView10 = this.inputView;
        if (floatInputView10 != null) {
            floatInputView10.setOnVoiceLongPressVisualChanged(null);
        }
        FloatInputView floatInputView11 = this.inputView;
        if (floatInputView11 != null) {
            floatInputView11.setOnInputContentChanged(null);
        }
        s1();
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.h();
        }
        this.recordingSpectrum = null;
        N0();
        TextWatcher textWatcher = this.recommendInputWatcher;
        if (textWatcher != null && (floatInputView = this.inputView) != null && (editText = (EditText) floatInputView.findViewById(R$id.et_input_bar)) != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        this.recommendInputWatcher = null;
        Iterator<T> it = this.recommendGlassHandles.iterator();
        while (it.hasNext()) {
            C2851i7.INSTANCE.h((y7.E) it.next());
        }
        this.recommendGlassHandles.clear();
        for (Map.Entry<View, View.OnLayoutChangeListener> entry : this.recommendCornerListeners.entrySet()) {
            entry.getKey().removeOnLayoutChangeListener(entry.getValue());
        }
        this.recommendCornerListeners.clear();
        this.recommendGlassAttached = false;
        this.recommendChips = null;
        C1168p.B(this.recommendTexts, null, 0, 0, 6, null);
        C1168p.B(this.recommendIcons, null, 0, 0, 6, null);
        C1168p.B(this.recommendChipViews, null, 0, 0, 6, null);
        A1(false);
        FloatInputView floatInputView12 = this.inputView;
        if (floatInputView12 != null) {
            floatInputView12.setOverlayReserveFreezeAction(null);
        }
        this.inputView = null;
        this.circleSelectChipHost = null;
        LauncherChatLayout launcherChatLayout = this.pendingChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.e9();
        }
        this.overlayHeightView = null;
        this.pendingChatLayout = null;
        this.pendingHandler = null;
        this.inputBound = false;
        this.bufferedSharePayload = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getView() != null) {
            V0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        RecordingPresentation recordingPresentation;
        kotlin.jvm.internal.p.i(outState, "outState");
        super.onSaveInstanceState(outState);
        FloatInputView floatInputView = this.inputView;
        outState.putString("voice_wake_presentation", (floatInputView == null || (recordingPresentation = floatInputView.getRecordingPresentation()) == null) ? null : recordingPresentation.name());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecordingPresentation recordingPresentationA;
        ChatScene chatSceneX7;
        String string;
        RecordingPresentation next;
        Intent intent;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final FloatInputView floatInputView = (FloatInputView) view.findViewById(R$id.chat_input_view);
        boolean z10 = true;
        floatInputView.setRegisterAsAgentInputView(true);
        floatInputView.setInputBarHeightBlurEnabled(true);
        this.inputView = floatInputView;
        floatInputView.setRecordingSendReady(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.A1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ChatInputFragment.d1(this.f25159a));
            }
        });
        floatInputView.setInputBarGlassSuspended(this.inputBarGlassSuspended);
        J0();
        kotlin.jvm.internal.p.f(floatInputView);
        H1(view, floatInputView);
        androidx.fragment.app.r activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("com.stepos.ailauncher.chat.sheet.WAKE_SOURCE");
        androidx.fragment.app.r activity2 = getActivity();
        final ChatActivity chatActivity = activity2 instanceof ChatActivity ? (ChatActivity) activity2 : null;
        if (savedInstanceState == null || (string = savedInstanceState.getString("voice_wake_presentation")) == null) {
            recordingPresentationA = null;
        } else {
            Iterator<RecordingPresentation> it = RecordingPresentation.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (kotlin.jvm.internal.p.d(next.name(), string)) {
                        break;
                    }
                }
            }
            recordingPresentationA = next;
        }
        if (recordingPresentationA == null) {
            com.stepos.ailauncher.chat.voice.longpress.S s10 = com.stepos.ailauncher.chat.voice.longpress.S.INSTANCE;
            if ((chatActivity == null || (chatSceneX7 = chatActivity.x7()) == null || !chatSceneX7.isHomeFollowing()) && C4814a.INSTANCE.d(stringExtra)) {
                z10 = false;
            }
            recordingPresentationA = s10.a(false, false, z10);
        }
        floatInputView.xa(recordingPresentationA);
        if (savedInstanceState == null && C4814a.INSTANCE.d(stringExtra)) {
            floatInputView.e9(recordingPresentationA);
        }
        floatInputView.setRecordingPresentationProvider(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.B1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatInputFragment.g1(chatActivity, floatInputView);
            }
        });
        floatInputView.setOnFullScreenListeningDismissRequest(chatActivity != null ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.C1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatInputFragment.h1(chatActivity);
            }
        } : null);
        s0(floatInputView);
        floatInputView.setOnInputLayoutChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.D1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatInputFragment.i1(this.f25168a);
            }
        });
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.fragment.E1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ChatInputFragment.j1(this.f25169a, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.overlayRootLayoutListener = onLayoutChangeListener;
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        floatInputView.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.F1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.k1(this.f25172a, ((Boolean) obj).booleanValue());
            }
        });
        floatInputView.setOnRecordingStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.G1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.l1(this.f25174a, ((Boolean) obj).booleanValue());
            }
        });
        floatInputView.setOnRecordingTouchBlockNeeded(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.b1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.m1(this.f25239a, ((Boolean) obj).booleanValue());
            }
        });
        floatInputView.setOnVoiceLongPressVisualChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.c1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.e1(this.f25246a, ((Boolean) obj).booleanValue());
            }
        });
        floatInputView.setOnWakeSwitchToChatPage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.d1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatInputFragment.f1(this.f25252a, (String) obj);
            }
        });
        this.circleSelectChipHost = (ViewGroup) view.findViewById(R$id.circle_select_chip_host);
        A0();
        K1(view, floatInputView);
        u1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AnonymousClass12(view, null), 3, null);
    }

    public final void q0(LauncherChatLayout chatLayout, SessionHandler handler) {
        LauncherChatLayout launcherChatLayout = this.pendingChatLayout;
        if (launcherChatLayout != chatLayout && launcherChatLayout != null) {
            launcherChatLayout.e9();
        }
        this.pendingChatLayout = chatLayout;
        this.pendingHandler = handler;
        J0();
        G0(chatLayout);
        u1();
        A0();
        ToolApprovalRequest value = X0().v().getValue();
        if (value != null) {
            T1(value);
        }
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.m1
                @Override // java.lang.Runnable
                public final void run() {
                    ChatInputFragment.r0(this.f25316a);
                }
            });
        }
    }

    public final void q1() {
        LauncherChatLayout launcherChatLayout = this.boundChatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.setCanPlayTTS(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.l1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(ChatInputFragment.r1());
                }
            });
        }
        LauncherChatLayout launcherChatLayout2 = this.boundChatLayout;
        if (launcherChatLayout2 != null) {
            launcherChatLayout2.setOnRoundUnsuccessfulListener(null);
        }
        this.boundChatLayout = null;
        this.boundHandler = null;
        this.inputBound = false;
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.h();
        }
        this.recordingSpectrum = null;
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setOnSendMessageListener(null);
        }
        FloatInputView floatInputView2 = this.inputView;
        if (floatInputView2 != null) {
            floatInputView2.setOnMessageSentCallback(null);
        }
        FloatInputView floatInputView3 = this.inputView;
        if (floatInputView3 != null) {
            floatInputView3.setOnSendInitiated(null);
        }
        FloatInputView floatInputView4 = this.inputView;
        if (floatInputView4 != null) {
            floatInputView4.setOnStopClicked(null);
        }
        FloatInputView floatInputView5 = this.inputView;
        if (floatInputView5 != null) {
            floatInputView5.b(null);
        }
    }

    public final void s0(FloatInputView input) {
        input.setOnImeAnimationStart(this.imeAnimationStartCallback);
        input.setOnImeInsetsFrame(this.imeInsetsFrameCallback);
        input.setOnImeAnimationEnd(this.imeAnimationEndCallback);
    }

    public final void s1() {
        IFloatCardService iFloatCardService;
        IFloatCardService iFloatCardService2;
        P0();
        com.stepos.ailauncher.chat.wake.U u10 = this.suggestCardEventHandler;
        if (u10 != null && (iFloatCardService2 = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            iFloatCardService2.unregisterEventHandler(u10.getBusinessType());
        }
        this.suggestCardEventHandler = null;
        G4.h hVar = this.floatCardHost;
        if (hVar != null && (iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            iFloatCardService.unregisterHost(hVar);
        }
        this.floatCardHost = null;
        this.floatCardContainer = null;
        this.pendingFileIdForMapping = null;
    }

    public final void t0(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setInputBarGlassCrossWindowRuntime(state == SheetSettleState.MINIFY);
        }
    }

    public final void t1(String source) {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.pendingHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null) {
            return;
        }
        if (La.H.x0(strB)) {
            strB = null;
        }
        if (strB == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ChatInputFragment$reportTaskInterrupt$1(strB, source, null), 3, null);
    }

    public final void u0() {
        View view = this.recommendChips;
        if (view == null) {
            return;
        }
        if (view.getVisibility() != 0) {
            view.setTranslationY(0.0f);
        } else {
            if (view.getHeight() <= 0) {
                return;
            }
            view.setTranslationY(C5685n.e(this.lastPanelDescentPx, 0.0f));
        }
    }

    public final void u1() {
        this.overlayHeightSyncPending = true;
        View view = getView();
        if (view == null || !view.isAttachedToWindow() || this.overlayHeightSyncPosted) {
            return;
        }
        this.overlayHeightSyncPosted = true;
        view.postOnAnimation(this.overlayHeightSyncRunnable);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v0() {
        /*
            r5 = this;
            boolean r0 = r5.recommendConditionsMet
            boolean r1 = r5.inputHasContent
            boolean r2 = r5.recommendChipsSuppressed
            r3 = 0
            if (r2 != 0) goto L1a
            com.stepos.ailauncher.chat.view.FloatInputView r2 = r5.inputView
            if (r2 == 0) goto L12
            com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation r2 = r2.getRecordingPresentation()
            goto L13
        L12:
            r2 = 0
        L13:
            com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation r4 = com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation.FULL_SCREEN
            if (r2 != r4) goto L18
            goto L1a
        L18:
            r2 = r3
            goto L1b
        L1a:
            r2 = 1
        L1b:
            boolean r0 = com.stepos.ailauncher.chat.fragment.a2.a(r0, r1, r2)
            android.view.View r1 = r5.recommendChips
            if (r1 == 0) goto L2c
            if (r0 == 0) goto L27
            r2 = r3
            goto L29
        L27:
            r2 = 8
        L29:
            r1.setVisibility(r2)
        L2c:
            if (r0 == 0) goto L35
            r5.w0()
            r5.Z0()
            goto L37
        L35:
            r5.recommendExposeReported = r3
        L37:
            r5.u0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.ChatInputFragment.v0():void");
    }

    public final void v1() {
        LauncherChatLayout launcherChatLayout;
        FloatInputView floatInputView = this.inputView;
        if (floatInputView == null || (launcherChatLayout = this.pendingChatLayout) == null) {
            return;
        }
        launcherChatLayout.X8(floatInputView);
    }

    public final void w0() {
        View view;
        if (this.inputBarGlassSuspended || this.recommendGlassAttached || (view = this.recommendChips) == null) {
            return;
        }
        androidx.core.view.D.a(view, new b(view, this));
    }

    public final void w1() {
        AgentSession.AgentConversation agentConversationR1;
        String str = this.pendingFileIdForMapping;
        if (str == null || str.length() == 0) {
            return;
        }
        SessionHandler sessionHandler = this.pendingHandler;
        String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        if (strB == null || strB.length() == 0) {
            return;
        }
        com.stepos.ailauncher.chat.wake.T.INSTANCE.b(str, strB);
        this.pendingFileIdForMapping = null;
    }

    public final void x0() throws Exception {
        this.deferWakeVisuals = true;
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.j(true);
        }
    }

    public final void x1(String content) {
        kotlin.jvm.internal.p.i(content, "content");
        FloatInputView floatInputView = this.inputView;
        if (floatInputView == null) {
            C4148a.u(TAG, "sendMessage skipped: inputView not ready", false, 4, null);
        } else {
            if (La.H.x0(content)) {
                return;
            }
            floatInputView.Va(content);
        }
    }

    public final void y0(View chip, final y7.E handle) {
        View.OnLayoutChangeListener onLayoutChangeListenerRemove = this.recommendCornerListeners.remove(chip);
        if (onLayoutChangeListenerRemove != null) {
            chip.removeOnLayoutChangeListener(onLayoutChangeListenerRemove);
        }
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.fragment.a1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ChatInputFragment.z0(handle, this, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.recommendCornerListeners.put(chip, onLayoutChangeListener);
        chip.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final void y1(p9.p<? super Boolean, ? super Integer, Y8.t> onStart, p9.p<? super Integer, ? super Boolean, Y8.t> onFrame, p9.p<? super Boolean, ? super Integer, Y8.t> onEnd) {
        this.imeAnimationStartCallback = onStart;
        this.imeInsetsFrameCallback = onFrame;
        this.imeAnimationEndCallback = onEnd;
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            s0(floatInputView);
        }
    }

    public final void z1(boolean suspended) {
        this.inputBarGlassSuspended = suspended;
        FloatInputView floatInputView = this.inputView;
        if (floatInputView != null) {
            floatInputView.setInputBarGlassSuspended(suspended);
        }
        G1(suspended);
    }
}
