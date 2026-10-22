package com.stepos.ailauncher.agent.skill.opera;

import La.D;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import X4.OperaError;
import Xa.d;
import Xa.j;
import Xa.k;
import Xa.o;
import Xa.t;
import Xa.u;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Y;
import Z8.Z;
import Z8.r;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.InstallSource;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillSource;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller;
import com.stepos.ailauncher.agent.skill.installer.CloudSkillInstaller;
import com.stepos.ailauncher.agent.skill.installer.CommandKind;
import com.stepos.ailauncher.agent.skill.installer.LocalSkillInstaller;
import com.stepos.ailauncher.agent.skill.installer.SkillInstaller;
import com.stepos.ailauncher.agent.skill.opera.b;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import h8.C4148a;
import h9.InterfaceC4149a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.g;
import v9.C5685n;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003¬\u0001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010 \u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001eH\u0082@¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010$J1\u0010(\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010)J3\u0010-\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b-\u0010.J;\u0010/\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b/\u00100J3\u00102\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e09H\u0002¢\u0006\u0004\b:\u0010;J$\u0010<\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001eH\u0082@¢\u0006\u0004\b<\u0010!J#\u0010=\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b?\u0010@J\u0018\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001aH\u0082@¢\u0006\u0004\bB\u0010\u001dJ\u001f\u0010C\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\bC\u0010DJ!\u0010H\u001a\u00020G2\u0006\u0010F\u001a\u00020E2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bH\u0010IJ'\u0010K\u001a\u00020J2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bM\u00107J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010\u0003J\u000f\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010\u0003JF\u0010U\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001a0P2\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001a0R2\u0016\b\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001eH\u0082@¢\u0006\u0004\bU\u0010VJ\u0015\u0010X\u001a\u00020\n2\u0006\u0010W\u001a\u00020\u001a¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\\\u0010[J\u0017\u0010]\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b]\u0010[J\u0017\u0010^\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b^\u0010[J\u0017\u0010_\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b_\u0010[J\u0017\u0010`\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b`\u0010[J\u0017\u0010a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\ba\u0010[J\u0019\u0010b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010W\u001a\u00020\u001aH\u0016¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\bf\u0010eR\u0014\u0010g\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082T¢\u0006\u0006\n\u0004\bj\u0010\tR\u0014\u0010k\u001a\u00020i8\u0002X\u0082T¢\u0006\u0006\n\u0004\bk\u0010\tR\u0014\u0010l\u001a\u00020i8\u0002X\u0082T¢\u0006\u0006\n\u0004\bl\u0010\tR\u0014\u0010n\u001a\u00020m8\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010 R\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00120R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR \u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR&\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR \u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010sR&\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bz\u0010v\u001a\u0004\b{\u0010xR \u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010sR&\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b}\u0010v\u001a\u0004\b~\u0010xR\u0017\u0010\u0080\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R)\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0R0t8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010v\u001a\u0005\b\u0083\u0001\u0010xR\u001f\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010\u0089\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0088\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010\u008d\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001e0q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010sR/\u0010\u008e\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u001e0t8\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010v\u001a\u0005\b\u008f\u0001\u0010xR\u001d\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0090\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010pR$\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020E0\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001d\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0090\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010pR$\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R$\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020i0\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009b\u0001\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010 R\u0018\u0010\u009c\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u00106R\u0018\u0010\u009d\u0001\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010 R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R3\u0010«\u0001\u001a\u001e\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030©\u00010§\u0001\u0012\u0005\u0012\u00030ª\u00010\u001e8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010\u0094\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager;", "LX4/a;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$InstallSpritePhase;", "phase", "LY8/t;", "N", "(Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$InstallSpritePhase;)V", "J", "", "failed", ExifInterface.LATITUDE_SOUTH, "(Z)V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;", "commandKind", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "targetStatus", "previousStatus", "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "errorKind", "Lkotlin/Result;", "l0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;Le9/c;)Ljava/lang/Object;", "", "id", "K", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", AlgorithmUpdateBundle.KEY_UPDATES, "I", "(Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "status", "Q", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "incoming", "authoritativeNeedUpdate", "adoptIncomingVersion", "P", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZ)V", "displayName", "kind", "msg", "O", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;Ljava/lang/String;)V", "R", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Ljava/lang/String;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;Ljava/lang/String;)V", "existing", "f0", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZ)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "d0", "e0", "Z", "()Z", "k0", "", "M", "()Ljava/util/List;", "X", "h0", "(Ljava/util/Map;)V", "L", "(Le9/c;)Ljava/lang/Object;", "reason", "j0", "a0", "(Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Z", "Lcom/stepos/ailauncher/agent/skill/opera/a;", "ctx", "Lcom/stepos/ailauncher/agent/skill/opera/b;", "i0", "(Lcom/stepos/ailauncher/agent/skill/opera/a;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/skill/opera/b;", "Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$a;", "U", "(Lcom/stepos/ailauncher/agent/skill/installer/CommandKind;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;)Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$a;", "Y", "c0", ExifInterface.GPS_DIRECTION_TRUE, "", "terminalIds", "", "failedIds", "failReasons", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/Collection;Ljava/util/Set;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "identifier", "b0", "(Ljava/lang/String;)Z", "n", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "TAG", "Ljava/lang/String;", "", "POLL_INTERVAL_MS", "COMMAND_TIMEOUT_MS", "OBSERVED_TIMEOUT_MS", "", "TABLE_SIZE_LIMIT", "AUTHORITATIVE_INSTALLED_STATUSES", "Ljava/util/Set;", "LXa/k;", "_installingIds", "LXa/k;", "LXa/t;", "installingIdentifierSet", "LXa/t;", "getInstallingIdentifierSet", "()LXa/t;", "_toggling", "togglingIds", "l", "_uninstallingIds", "uninstallingIds", Const.INTENT_KEY_UMID, "LUa/M;", "scope", "LUa/M;", "inFlightIds", "getInFlightIds", "LXa/j;", "LX4/b;", "_errorEvents", "LXa/j;", "LXa/o;", "errorEvents", "LXa/o;", "m", "()LXa/o;", "_skillStateTable", "skillStateTable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "testingSkillIds", "", "inFlightMeta", "Ljava/util/Map;", "_subscribers", "_observedInflightItems", "_observedInflightStartMs", "Lkotlinx/coroutines/g;", "unifiedPollJob", "Lkotlinx/coroutines/g;", "consecutiveFailures", "batchHasFailure", "spriteInstallInflight", "Lcom/stepos/ailauncher/agent/skill/installer/CloudSkillInstaller;", "cloudSkillInstaller", "Lcom/stepos/ailauncher/agent/skill/installer/CloudSkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/CliSkillInstaller;", "cliSkillInstaller", "Lcom/stepos/ailauncher/agent/skill/installer/CliSkillInstaller;", "Lcom/stepos/ailauncher/agent/skill/installer/LocalSkillInstaller;", "localSkillInstaller", "Lcom/stepos/ailauncher/agent/skill/installer/LocalSkillInstaller;", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/agent/skill/InstallSource;", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "Lcom/stepos/ailauncher/agent/skill/installer/SkillInstaller;", "installers", "InstallSpritePhase", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillOperaManager implements X4.a {
    private static final long COMMAND_TIMEOUT_MS = 120000;
    private static final long OBSERVED_TIMEOUT_MS = 60000;
    private static final long POLL_INTERVAL_MS = 2000;
    private static final int TABLE_SIZE_LIMIT = 200;
    private static final String TAG = "SkillOperaMgr";
    private static final j<OperaError> _errorEvents;
    private static final k<Set<String>> _installingIds;
    private static final Map<String, SkillItem> _observedInflightItems;
    private static final Map<String, Long> _observedInflightStartMs;
    private static final k<Map<String, SkillItem>> _skillStateTable;
    private static final Set<String> _subscribers;
    private static final k<Set<String>> _toggling;
    private static final k<Set<String>> _uninstallingIds;
    private static boolean batchHasFailure;
    private static final CliSkillInstaller cliSkillInstaller;
    private static final CloudSkillInstaller cloudSkillInstaller;
    private static int consecutiveFailures;
    private static final o<OperaError> errorEvents;
    private static final t<Set<String>> inFlightIds;
    private static final Map<String, InFlightContext> inFlightMeta;
    private static final Map<Pair<InstallSource, InstallKind>, SkillInstaller> installers;
    private static final t<Set<String>> installingIdentifierSet;
    private static final LocalSkillInstaller localSkillInstaller;
    private static final M scope;
    private static final t<Map<String, SkillItem>> skillStateTable;
    private static int spriteInstallInflight;
    private static final Set<String> testingSkillIds;
    private static final t<Set<String>> togglingIds;
    private static g unifiedPollJob;
    private static final t<Set<String>> uninstallingIds;
    public static final SkillOperaManager INSTANCE = new SkillOperaManager();
    private static final Set<SkillStatus> AUTHORITATIVE_INSTALLED_STATUSES = Y.j(SkillStatus.INSTALLED_ENABLED, SkillStatus.INSTALLED_DISABLED, SkillStatus.INSTALLED);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$InstallSpritePhase;", "", "<init>", "(Ljava/lang/String;I)V", "START", "FINISH", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InstallSpritePhase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ InstallSpritePhase[] $VALUES;
        public static final InstallSpritePhase START = new InstallSpritePhase("START", 0);
        public static final InstallSpritePhase FINISH = new InstallSpritePhase("FINISH", 1);

        private static final /* synthetic */ InstallSpritePhase[] $values() {
            return new InstallSpritePhase[]{START, FINISH};
        }

        static {
            InstallSpritePhase[] installSpritePhaseArr$values = $values();
            $VALUES = installSpritePhaseArr$values;
            $ENTRIES = kotlin.enums.a.a(installSpritePhaseArr$values);
        }

        private InstallSpritePhase(String str, int i10) {
        }

        public static InterfaceC4149a<InstallSpritePhase> getEntries() {
            return $ENTRIES;
        }

        public static InstallSpritePhase valueOf(String str) {
            return (InstallSpritePhase) Enum.valueOf(InstallSpritePhase.class, str);
        }

        public static InstallSpritePhase[] values() {
            return (InstallSpritePhase[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/SkillOperaManager$a;", "", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "errorKind", "", C3081a.ERROR_MSG, "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "c", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$a, reason: from toString */
    public static final /* data */ class Fb {
        private final OperaErrorKind errorKind;
        private final String errorMsg;
        private final SkillStatus status;

        public Fb(SkillStatus status, OperaErrorKind operaErrorKind, String str) {
            p.i(status, "status");
            this.status = status;
            this.errorKind = operaErrorKind;
            this.errorMsg = str;
        }

        /* renamed from: a, reason: from getter */
        public final OperaErrorKind getErrorKind() {
            return this.errorKind;
        }

        /* renamed from: b, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* renamed from: c, reason: from getter */
        public final SkillStatus getStatus() {
            return this.status;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fb)) {
                return false;
            }
            Fb fb2 = (Fb) other;
            return this.status == fb2.status && this.errorKind == fb2.errorKind && p.d(this.errorMsg, fb2.errorMsg);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            OperaErrorKind operaErrorKind = this.errorKind;
            int iHashCode2 = (iHashCode + (operaErrorKind == null ? 0 : operaErrorKind.hashCode())) * 31;
            String str = this.errorMsg;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Fb(status=" + this.status + ", errorKind=" + this.errorKind + ", errorMsg=" + this.errorMsg + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InstallSpritePhase.values().length];
            try {
                iArr[InstallSpritePhase.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InstallSpritePhase.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CommandKind.values().length];
            try {
                iArr2[CommandKind.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CommandKind.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CommandKind.UNINSTALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CommandKind.DISABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CommandKind.ENABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Long) ((Map.Entry) t10).getValue(), (Long) ((Map.Entry) t11).getValue());
        }
    }

    static {
        k<Set<String>> kVarA = u.a(Y.e());
        _installingIds = kVarA;
        installingIdentifierSet = d.c(kVarA);
        k<Set<String>> kVarA2 = u.a(Y.e());
        _toggling = kVarA2;
        togglingIds = d.c(kVarA2);
        k<Set<String>> kVarA3 = u.a(Y.e());
        _uninstallingIds = kVarA3;
        uninstallingIds = d.c(kVarA3);
        M mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        scope = mA;
        inFlightIds = d.M(d.m(kVarA, kVarA2, kVarA3, new SkillOperaManager$inFlightIds$1(null)), mA, kotlinx.coroutines.flow.a.INSTANCE.c(), Y.e());
        j<OperaError> jVarB = Xa.p.b(0, 16, BufferOverflow.DROP_OLDEST, 1, null);
        _errorEvents = jVarB;
        errorEvents = d.b(jVarB);
        k<Map<String, SkillItem>> kVarA4 = u.a(kotlin.collections.a.i());
        _skillStateTable = kVarA4;
        skillStateTable = d.c(kVarA4);
        testingSkillIds = new LinkedHashSet();
        inFlightMeta = new LinkedHashMap();
        _subscribers = new LinkedHashSet();
        _observedInflightItems = new LinkedHashMap();
        _observedInflightStartMs = new LinkedHashMap();
        CloudSkillInstaller cloudSkillInstaller2 = new CloudSkillInstaller(null, 1, null);
        cloudSkillInstaller = cloudSkillInstaller2;
        CliSkillInstaller cliSkillInstaller2 = new CliSkillInstaller(null, 1, null);
        cliSkillInstaller = cliSkillInstaller2;
        LocalSkillInstaller localSkillInstaller2 = new LocalSkillInstaller(new com.stepos.ailauncher.agent.skill.installer.c(C3197a.INSTANCE.a(), mA));
        localSkillInstaller = localSkillInstaller2;
        InstallSource installSource = InstallSource.CLOUD;
        InstallKind installKind = InstallKind.SKILL;
        Pair pairA = Y8.j.a(Y8.j.a(installSource, installKind), cloudSkillInstaller2);
        InstallSource installSource2 = InstallSource.LOCAL;
        Pair pairA2 = Y8.j.a(Y8.j.a(installSource2, installKind), localSkillInstaller2);
        InstallKind installKind2 = InstallKind.CLI;
        Map<Pair<InstallSource, InstallKind>, SkillInstaller> mapM = kotlin.collections.a.m(pairA, pairA2, Y8.j.a(Y8.j.a(installSource, installKind2), cliSkillInstaller2), Y8.j.a(Y8.j.a(installSource2, installKind2), cliSkillInstaller2));
        installers = mapM;
        List listG0 = F.g0(mapM.values());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listG0) {
            if (((SkillInstaller) obj).getStatusModel() == SkillInstaller.StatusModel.PUSH) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1060i.d(scope, null, null, new SkillOperaManager$2$1((SkillInstaller) it.next(), null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object W(SkillOperaManager skillOperaManager, Collection collection, Set set, Map map, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = Y.e();
        }
        if ((i10 & 4) != 0) {
            map = kotlin.collections.a.i();
        }
        return skillOperaManager.V(collection, set, map, interfaceC4014c);
    }

    public static /* synthetic */ SkillItem g0(SkillOperaManager skillOperaManager, SkillItem skillItem, SkillItem skillItem2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return skillOperaManager.f0(skillItem, skillItem2, z10, z11);
    }

    public final Object I(Map<String, SkillItem> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Map<String, SkillItem> value;
        Map mapC;
        if (map.isEmpty()) {
            return Y8.t.f7040a;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        k<Map<String, SkillItem>> kVar = _skillStateTable;
        boolean z10 = false;
        do {
            value = kVar.getValue();
            mapC = kotlin.collections.a.C(value);
            for (Map.Entry<String, SkillItem> entry : map.entrySet()) {
                String key = entry.getKey();
                SkillItem value2 = entry.getValue();
                SkillItem skillItem = (SkillItem) mapC.get(key);
                mapC.put(key, skillItem != null ? g0(INSTANCE, skillItem, value2, false, false, 12, null) : value2);
                SkillStatus status = value2.getStatus();
                if (status != null && status.isInFlight() && !inFlightMeta.containsKey(key)) {
                    Map<String, SkillItem> map2 = _observedInflightItems;
                    if (!map2.containsKey(key)) {
                        map2.put(key, value2);
                        _observedInflightStartMs.put(key, C4109a.g(jCurrentTimeMillis));
                        C4148a.d(TAG, "observedInflight: add id=" + key + " status=" + value2.getStatus(), false, 4, null);
                        z10 = true;
                    }
                }
            }
        } while (!kVar.d(value, kotlin.collections.a.A(mapC)));
        if (z10) {
            d0();
        }
        T();
        return Y8.t.f7040a;
    }

    public final void J() {
        if (spriteInstallInflight == 0) {
            N(InstallSpritePhase.START);
        }
        spriteInstallInflight++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0139, code lost:
    
        if (V(r0, r5, r7, r15) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(java.lang.String r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.K(java.lang.String, e9.c):java.lang.Object");
    }

    public final Object L(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        long j10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, InFlightContext> map = inFlightMeta;
        long j11 = 0;
        if (map.isEmpty()) {
            j10 = 0;
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, InFlightContext> entry : map.entrySet()) {
                String key = entry.getKey();
                InFlightContext value = entry.getValue();
                long pollStartElapsedMs = value.getPollStartElapsedMs() > j11 ? value.getPollStartElapsedMs() : value.getStartElapsedMs();
                arrayList.add(key + ServerSentEventKt.COLON + value.getCommandKind() + ServerSentEventKt.COLON + (jCurrentTimeMillis - pollStartElapsedMs) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
                j11 = j11;
            }
            j10 = j11;
            C4148a.d(TAG, "checkCommandTimeout tick threshold=120000ms inflight=" + arrayList, false, 4, null);
        }
        ArrayList arrayList2 = new ArrayList();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, InFlightContext> entry2 : inFlightMeta.entrySet()) {
            String key2 = entry2.getKey();
            InFlightContext value2 = entry2.getValue();
            long pollStartElapsedMs2 = jCurrentTimeMillis - (value2.getPollStartElapsedMs() > j10 ? value2.getPollStartElapsedMs() : value2.getStartElapsedMs());
            if (pollStartElapsedMs2 > COMMAND_TIMEOUT_MS) {
                C4148a.u(TAG, "command timeout id=" + key2 + " kind=" + value2.getCommandKind() + " elapsed=" + pollStartElapsedMs2 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
                Fb fbU = U(value2.getCommandKind(), value2.getPreviousStatus(), value2.getErrorKind());
                CommandKind commandKind = value2.getCommandKind();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(commandKind);
                sb2.append(" timeout");
                String string = sb2.toString();
                R(key2, fbU.getStatus(), value2.getItem().getDisplayName(), value2.getErrorKind(), string);
                arrayList2.add(key2);
                linkedHashMap.put(key2, string);
            }
        }
        Object objV = V(arrayList2, F.r1(arrayList2), linkedHashMap, interfaceC4014c);
        return objV == C4063a.g() ? objV : Y8.t.f7040a;
    }

    public final List<SkillItem> M() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, InFlightContext>> it = inFlightMeta.entrySet().iterator();
        while (it.hasNext()) {
            InFlightContext value = it.next().getValue();
            if (value.getPendingAcked()) {
                arrayList.add(value.getItem());
            }
        }
        arrayList.addAll(_observedInflightItems.values());
        return arrayList;
    }

    public final void N(InstallSpritePhase phase) {
        int i10 = b.$EnumSwitchMapping$0[phase.ordinal()];
        if (i10 == 1) {
            C4148a.u(TAG, "dispatchInstallSprite START", false, 4, null);
            U5.b.INSTANCE.r(SpriteEventAction.MARKET_SKILL_INSTALL_START);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String str = batchHasFailure ? SpriteEventAction.MARKET_SKILL_INSTALL_FAIL : SpriteEventAction.MARKET_SKILL_INSTALL_SUCCESS;
            C4148a.u(TAG, "dispatchInstallSprite FINISH action=" + str, false, 4, null);
            U5.b.INSTANCE.r(str);
            Toast.makeText(C3197a.INSTANCE.a(), batchHasFailure ? R$string.store_install_failed_toast : R$string.store_install_success_toast, 0).show();
            batchHasFailure = false;
        }
    }

    public final void O(String id, String displayName, OperaErrorKind kind, String msg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        p.h(stackTrace, "getStackTrace(...)");
        StackTraceElement stackTraceElement = (StackTraceElement) r.j0(stackTrace, 4);
        C4148a.u(TAG, "emitError id=" + id + " kind=" + kind + " msg=" + msg + " caller=" + (stackTraceElement != null ? stackTraceElement.getMethodName() : null), false, 4, null);
        j<OperaError> jVar = _errorEvents;
        if (displayName == null) {
            displayName = id;
        }
        jVar.a(new OperaError(id, displayName, kind, msg));
    }

    public final void P(String id, SkillItem incoming, boolean authoritativeNeedUpdate, boolean adoptIncomingVersion) {
        Map<String, SkillItem> value;
        Map<String, SkillItem> map;
        SkillItem skillItemF0;
        SkillItem item;
        k<Map<String, SkillItem>> kVar = _skillStateTable;
        do {
            value = kVar.getValue();
            map = value;
            SkillItem skillItem = map.get(id);
            SkillStatus status = skillItem != null ? skillItem.getStatus() : null;
            SkillItem skillItem2 = map.get(id);
            if (skillItem2 == null || (skillItemF0 = INSTANCE.f0(skillItem2, incoming, authoritativeNeedUpdate, adoptIncomingVersion)) == null) {
                InFlightContext inFlightContext = inFlightMeta.get(id);
                skillItemF0 = (inFlightContext == null || (item = inFlightContext.getItem()) == null) ? incoming : INSTANCE.f0(item, incoming, authoritativeNeedUpdate, adoptIncomingVersion);
            }
            C4148a.d(TAG, "emitStatus(authoritative) id=" + id + " before=" + status + " after=" + incoming.getStatus() + " needUpdate=" + incoming.getNeedUpdate(), false, 4, null);
        } while (!kVar.d(value, kotlin.collections.a.s(map, Y8.j.a(id, skillItemF0))));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(java.lang.String r91, com.stepos.ailauncher.agent.skill.SkillStatus r92) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.Q(java.lang.String, com.stepos.ailauncher.agent.skill.SkillStatus):void");
    }

    public final void R(String id, SkillStatus status, String displayName, OperaErrorKind kind, String msg) {
        Q(id, status);
        O(id, displayName, kind, msg);
    }

    public final void S(boolean failed) {
        int i10 = spriteInstallInflight;
        if (i10 == 0) {
            return;
        }
        if (failed) {
            batchHasFailure = true;
        }
        int i11 = i10 - 1;
        spriteInstallInflight = i11;
        if (i11 == 0) {
            N(InstallSpritePhase.FINISH);
        }
    }

    public final void T() {
        Map<String, SkillItem> value;
        Map<String, SkillItem> value2;
        Map<String, SkillItem> value3 = _skillStateTable.getValue();
        if (value3.size() <= 200) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, SkillItem>> it = value3.entrySet().iterator();
        while (true) {
            boolean z10 = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SkillItem> next = it.next();
            SkillStatus status = next.getValue().getStatus();
            if (status != null && status.isInFlight()) {
                z10 = true;
            }
            if (!z10) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!linkedHashMap.isEmpty()) {
            List listF1 = F.f1(linkedHashMap.keySet(), value3.size() - 200);
            C4148a.u(TAG, "enforceTableSizeLimit: evicting " + listF1.size() + " terminal entries (size=" + value3.size() + ")", false, 4, null);
            k<Map<String, SkillItem>> kVar = _skillStateTable;
            do {
                value2 = kVar.getValue();
            } while (!kVar.d(value2, kotlin.collections.a.n(value2, F.r1(listF1))));
        }
        int size = _skillStateTable.getValue().size() - 200;
        if (size > 0) {
            List listF12 = F.f1(F.c1(_observedInflightStartMs.entrySet(), new c()), size);
            ArrayList<String> arrayList = new ArrayList(C1174w.x(listF12, 10));
            Iterator it2 = listF12.iterator();
            while (it2.hasNext()) {
                arrayList.add((String) ((Map.Entry) it2.next()).getKey());
            }
            if (arrayList.isEmpty()) {
                return;
            }
            k<Map<String, SkillItem>> kVar2 = _skillStateTable;
            do {
                value = kVar2.getValue();
            } while (!kVar2.d(value, kotlin.collections.a.n(value, F.r1(arrayList))));
            for (String str : arrayList) {
                _observedInflightItems.remove(str);
                _observedInflightStartMs.remove(str);
            }
        }
    }

    public final Fb U(CommandKind commandKind, SkillStatus previousStatus, OperaErrorKind errorKind) {
        int i10 = b.$EnumSwitchMapping$1[commandKind.ordinal()];
        if (i10 == 1) {
            return new Fb(SkillStatus.INSTALL_FAILED, errorKind, "install failed");
        }
        if (i10 == 2) {
            return new Fb(previousStatus, errorKind, "update failed");
        }
        if (i10 == 3) {
            return new Fb(previousStatus, errorKind, "uninstall failed");
        }
        if (i10 == 4) {
            return new Fb(previousStatus, errorKind, "disable failed");
        }
        if (i10 == 5) {
            return new Fb(previousStatus, errorKind, "enable failed");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object V(Collection<String> collection, Set<String> set, Map<String, String> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Set<String> value;
        Set set2;
        Set<String> value2;
        Set<String> value3;
        Set<String> setR1 = F.r1(collection);
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (String str : setR1) {
            InFlightContext inFlightContext = inFlightMeta.get(str);
            if (inFlightContext != null) {
                boolean zContains = set.contains(str);
                int i10 = b.$EnumSwitchMapping$1[inFlightContext.getCommandKind().ordinal()];
                if (i10 == 1) {
                    S(zContains);
                    SkillAnalytics.INSTANCE.e(inFlightContext.getItem(), !zContains, zContains ? map.get(str) : null, jCurrentTimeMillis - inFlightContext.getStartElapsedMs());
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        SkillAnalytics.INSTANCE.g(inFlightContext.getItem(), !zContains);
                        if (!zContains) {
                            Toast.makeText(C3197a.INSTANCE.a(), R$string.store_uninstall_success_toast, 0).show();
                        }
                    } else {
                        if (i10 != 4 && i10 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!zContains) {
                            SkillAnalytics.INSTANCE.b(inFlightContext.getItem(), inFlightContext.getCommandKind() == CommandKind.ENABLE);
                        }
                    }
                } else if (zContains) {
                    SkillAnalytics.INSTANCE.k(inFlightContext.getItem(), inFlightContext.getOldVersion(), null, false, map.get(str));
                } else {
                    SkillItem skillItem = _skillStateTable.getValue().get(inFlightContext.getItem().getIdentifier());
                    SkillAnalytics.INSTANCE.k(inFlightContext.getItem(), inFlightContext.getOldVersion(), skillItem != null ? skillItem.getInstallVersion() : null, true, null);
                }
            }
        }
        k<Set<String>> kVar = _installingIds;
        do {
            value = kVar.getValue();
            set2 = setR1;
        } while (!kVar.d(value, Z.m(value, set2)));
        k<Set<String>> kVar2 = _toggling;
        do {
            value2 = kVar2.getValue();
        } while (!kVar2.d(value2, Z.m(value2, set2)));
        k<Set<String>> kVar3 = _uninstallingIds;
        do {
            value3 = kVar3.getValue();
        } while (!kVar3.d(value3, Z.m(value3, set2)));
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            inFlightMeta.remove((String) it.next());
        }
        e0();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X(java.util.Map<java.lang.String, com.stepos.ailauncher.agent.skill.SkillItem> r59, e9.InterfaceC4014c<? super Y8.t> r60) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.X(java.util.Map, e9.c):java.lang.Object");
    }

    public final boolean Y() {
        Set<String> set = _subscribers;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (D.X((String) it.next(), "skillTab_", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean Z() {
        Map<String, InFlightContext> map = inFlightMeta;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, InFlightContext>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getPendingAcked()) {
                    return true;
                }
            }
        }
        return !_observedInflightItems.isEmpty();
    }

    @Override // X4.a
    public void a(String id) {
        p.i(id, "id");
        C1060i.d(scope, null, null, new SkillOperaManager$unregisterSubscriber$1(id, null), 3, null);
    }

    public final boolean a0(CommandKind commandKind, SkillStatus status) {
        int i10 = b.$EnumSwitchMapping$1[commandKind.ordinal()];
        if (i10 == 1) {
            return status == SkillStatus.INSTALLING || status == SkillStatus.QUEUED || status == SkillStatus.TOGGLING;
        }
        if (i10 == 2) {
            return status == SkillStatus.INSTALLING || status == SkillStatus.QUEUED || status == SkillStatus.TOGGLING;
        }
        if (i10 == 3) {
            return status == SkillStatus.UNINSTALLING || status == SkillStatus.QUEUED;
        }
        if (i10 == 4 || i10 == 5) {
            return status == SkillStatus.TOGGLING || status == SkillStatus.QUEUED;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // X4.a
    public void b(SkillItem item) {
        p.i(item, "item");
        C1060i.d(scope, null, null, new SkillOperaManager$setDisable$1(item, null), 3, null);
    }

    public final boolean b0(String identifier) {
        p.i(identifier, "identifier");
        return testingSkillIds.contains(identifier);
    }

    @Override // X4.a
    public void c(SkillItem item) {
        p.i(item, "item");
        C1060i.d(scope, null, null, new SkillOperaManager$setEnabled$1(item, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.c0():void");
    }

    @Override // X4.a
    public t<Set<String>> d() {
        return uninstallingIds;
    }

    public final void d0() {
        g gVar = unifiedPollJob;
        boolean z10 = (gVar == null || !gVar.b()) && Z();
        g gVar2 = unifiedPollJob;
        Boolean boolValueOf = gVar2 != null ? Boolean.valueOf(gVar2.b()) : null;
        C4148a.d(TAG, "maybeStartPoll: shouldStart=" + z10 + " pollActive=" + boolValueOf + " hasPull=" + Z() + " subscribers=" + _subscribers.size(), false, 4, null);
        if (z10) {
            k0();
        }
    }

    @Override // X4.a
    public void e(String id) {
        p.i(id, "id");
        C1060i.d(scope, null, null, new SkillOperaManager$registerSubscriber$1(id, null), 3, null);
    }

    public final void e0() {
        if (Z()) {
            return;
        }
        g gVar = unifiedPollJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        unifiedPollJob = null;
        C4148a.d(TAG, "Polling stopped via maybeStopPoll", false, 4, null);
    }

    @Override // X4.a
    public void f(SkillItem item) {
        p.i(item, "item");
        C1060i.d(scope, null, null, new SkillOperaManager$cancel$1(item, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.agent.skill.SkillItem f0(com.stepos.ailauncher.agent.skill.SkillItem r43, com.stepos.ailauncher.agent.skill.SkillItem r44, boolean r45, boolean r46) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.f0(com.stepos.ailauncher.agent.skill.SkillItem, com.stepos.ailauncher.agent.skill.SkillItem, boolean, boolean):com.stepos.ailauncher.agent.skill.SkillItem");
    }

    @Override // X4.a
    public SkillItem g(String identifier) {
        p.i(identifier, "identifier");
        return _skillStateTable.getValue().get(identifier);
    }

    @Override // X4.a
    public void h(SkillItem item) {
        p.i(item, "item");
        C1060i.d(scope, null, null, new SkillOperaManager$uninstall$1(item, null), 3, null);
    }

    public final void h0(Map<String, SkillItem> updates) {
        Map<String, SkillItem> value;
        Map<String, SkillItem> mapS;
        SkillStatus status;
        Map<String, SkillItem> map;
        Map<String, SkillItem> map2;
        SkillItem skillItemG0;
        Map<String, SkillItem> map3 = _observedInflightItems;
        if (map3.isEmpty()) {
            return;
        }
        C4148a.d(TAG, "resolveObservedInflight observed=" + map3.keySet() + " updates=" + updates.keySet(), false, 4, null);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, SkillItem>> it = map3.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!inFlightMeta.containsKey(key)) {
                SkillItem skillItem = updates.get(key);
                if (skillItem == null || ((status = skillItem.getStatus()) != null && status.isInFlight())) {
                    Long l10 = _observedInflightStartMs.get(key);
                    if (jCurrentTimeMillis - (l10 != null ? l10.longValue() : 0L) > 60000) {
                        k<Map<String, SkillItem>> kVar = _skillStateTable;
                        do {
                            value = kVar.getValue();
                            mapS = value;
                            SkillItem skillItem2 = mapS.get(key);
                            if (skillItem2 != null) {
                                mapS = kotlin.collections.a.s(mapS, Y8.j.a(key, SkillItem.copy$default(skillItem2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0, null, null, 0, null, null, null, null, null, null, null, SkillStatus.UNINSTALLED, null, null, null, null, Integer.MAX_VALUE, 15, null)));
                            }
                        } while (!kVar.d(value, mapS));
                        arrayList2.add(key);
                        C4148a.u(TAG, "observedInflight timeout id=" + key + ", force UNINSTALLED", false, 4, null);
                    }
                } else {
                    k<Map<String, SkillItem>> kVar2 = _skillStateTable;
                    do {
                        Map<String, SkillItem> value2 = kVar2.getValue();
                        Map<String, SkillItem> map4 = value2;
                        SkillItem skillItem3 = map4.get(key);
                        if (skillItem3 != null) {
                            map2 = map4;
                            map = value2;
                            skillItemG0 = g0(INSTANCE, skillItem3, skillItem, false, false, 12, null);
                        } else {
                            map = value2;
                            map2 = map4;
                            skillItemG0 = skillItem;
                        }
                    } while (!kVar2.d(map, kotlin.collections.a.s(map2, Y8.j.a(key, skillItemG0))));
                    arrayList.add(key);
                    C4148a.d(TAG, "observedInflight resolved id=" + key + " status=" + skillItem.getStatus(), false, 4, null);
                }
            }
        }
        for (String str : F.S0(arrayList, arrayList2)) {
            _observedInflightItems.remove(str);
            _observedInflightStartMs.remove(str);
        }
    }

    @Override // X4.a
    public void i(SkillItem item) {
        p.i(item, "item");
        if (item.getClientSource() == SkillSource.TESTING) {
            testingSkillIds.add(item.getIdentifier());
        }
        C1060i.d(scope, null, null, new SkillOperaManager$retry$1(item, null), 3, null);
    }

    public final com.stepos.ailauncher.agent.skill.opera.b i0(InFlightContext ctx, SkillStatus status) {
        ctx.getPreviousStatus();
        C4148a.d(TAG, "id: " + ctx.getItem().getIdentifier() + ", command: " + ctx.getCommandKind() + ",  resolvePoll: server status: " + status, false, 4, null);
        int i10 = b.$EnumSwitchMapping$1[ctx.getCommandKind().ordinal()];
        if (i10 == 1) {
            return (status == null || status.isInFlight()) ? new b.Continue(status) : (status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED || status == SkillStatus.INSTALLED) ? new b.Terminal(status, null) : new b.Terminal(status, null);
        }
        if (i10 == 2) {
            return (status == null || status.isInFlight()) ? new b.Continue(status) : (status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED || status == SkillStatus.INSTALLED) ? new b.Terminal(status, null) : new b.Terminal(status, null);
        }
        if (i10 == 3) {
            return (status == null || status.isInFlight()) ? new b.Continue(status) : status == SkillStatus.UNINSTALLED ? new b.Terminal(status, null) : (status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED_DISABLED || status == SkillStatus.INSTALLED) ? new b.Terminal(status, null) : new b.Terminal(status, null);
        }
        if (i10 == 4) {
            return (status == null || status.isInFlight()) ? new b.Continue(status) : (status == SkillStatus.INSTALLED_DISABLED || status == SkillStatus.INSTALLED) ? new b.Terminal(status, null) : new b.Terminal(status, null);
        }
        if (i10 == 5) {
            return (status == null || status.isInFlight()) ? new b.Continue(status) : (status == SkillStatus.INSTALLED_ENABLED || status == SkillStatus.INSTALLED) ? new b.Terminal(status, null) : new b.Terminal(status, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // X4.a
    public t<Map<String, SkillItem>> j() {
        return skillStateTable;
    }

    public final Object j0(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Map<String, InFlightContext> map = inFlightMeta;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, InFlightContext> entry : map.entrySet()) {
            if (entry.getValue().getPendingAcked()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        List<String> listM1 = F.m1(linkedHashMap.keySet());
        if (listM1.isEmpty()) {
            e0();
            return Y8.t.f7040a;
        }
        for (String str2 : listM1) {
            InFlightContext inFlightContext = inFlightMeta.get(str2);
            if (inFlightContext != null) {
                R(str2, inFlightContext.getCommandKind() == CommandKind.INSTALL ? SkillStatus.INSTALL_FAILED : inFlightContext.getPreviousStatus(), inFlightContext.getItem().getDisplayName(), inFlightContext.getErrorKind(), str);
            }
        }
        List list = listM1;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap2.put(obj, str);
        }
        Object objV = V(listM1, F.r1(list), linkedHashMap2, interfaceC4014c);
        return objV == C4063a.g() ? objV : Y8.t.f7040a;
    }

    @Override // X4.a
    public void k(SkillItem item) {
        p.i(item, "item");
        C1060i.d(scope, null, null, new SkillOperaManager$update$1(item, null), 3, null);
    }

    public final void k0() {
        g gVar = unifiedPollJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        consecutiveFailures = 0;
        unifiedPollJob = C1060i.d(scope, null, null, new SkillOperaManager$startPoll$1(null), 3, null);
    }

    @Override // X4.a
    public t<Set<String>> l() {
        return togglingIds;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00b2: MOVE (r14 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:18:0x00a6 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ad: MOVE (r10 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:18:0x00a6 */
    public final java.lang.Object l0(com.stepos.ailauncher.agent.skill.SkillItem r101, com.stepos.ailauncher.agent.skill.installer.CommandKind r102, com.stepos.ailauncher.agent.skill.SkillStatus r103, com.stepos.ailauncher.agent.skill.SkillStatus r104, com.stepos.ailauncher.agent.contract.OperaErrorKind r105, e9.InterfaceC4014c<? super kotlin.Result<Y8.t>> r106) {
        /*
            Method dump skipped, instructions count: 2844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.opera.SkillOperaManager.l0(com.stepos.ailauncher.agent.skill.SkillItem, com.stepos.ailauncher.agent.skill.installer.CommandKind, com.stepos.ailauncher.agent.skill.SkillStatus, com.stepos.ailauncher.agent.skill.SkillStatus, com.stepos.ailauncher.agent.contract.OperaErrorKind, e9.c):java.lang.Object");
    }

    @Override // X4.a
    public o<OperaError> m() {
        return errorEvents;
    }

    @Override // X4.a
    public void n(SkillItem item) {
        p.i(item, "item");
        if (item.getClientSource() == SkillSource.TESTING) {
            testingSkillIds.add(item.getIdentifier());
        }
        C1060i.d(scope, null, null, new SkillOperaManager$install$1(item, null), 3, null);
    }
}
