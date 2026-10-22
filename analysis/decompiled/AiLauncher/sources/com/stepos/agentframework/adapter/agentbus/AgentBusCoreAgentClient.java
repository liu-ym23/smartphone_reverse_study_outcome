package com.stepos.agentframework.adapter.agentbus;

import Ua.C1056g;
import Ua.C1060i;
import Ua.InterfaceC1089x;
import Ua.L0;
import Ua.Q;
import Z8.C1173v;
import Z8.IndexedValue;
import Z8.Y;
import a4.CustomEvent;
import a4.Message;
import a4.StepClawEvent;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentbus.generated.Role;
import com.stepos.agentbus.generated.c;
import com.stepos.agentframework.adapter.agentbus.M;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.adapter.netcore.SessionUpdate;
import com.stepos.agentframework.adapter.netcore.TaskDismiss;
import com.stepos.agentframework.adapter.netcore.TaskEventPayload;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.AbilityType;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import h8.C4148a;
import h9.InterfaceC4149a;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.AbstractC0913i;
import kotlin.AgentDetailRequest;
import kotlin.C0905a;
import kotlin.C0914j;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.TranscriptEvent;
import kotlin.UploadFileRequest;
import org.json.JSONObject;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Ì\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Ð\u00022\u00020\u0001:\bÃ\u0001Ñ\u0002Ý\u0001Ò\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u001c\u0010\u0017\u001a\u00020\r*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020\r*\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010'J\u0019\u0010)\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b)\u0010*JC\u00101\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b7\u00104J\u0017\u00108\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b8\u00109J3\u0010>\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b>\u0010?J\u001a\u0010A\u001a\u0004\u0018\u00010\u00192\u0006\u0010@\u001a\u00020\u0019H\u0082@¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0004\bC\u0010DJ!\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0F*\u00020EH\u0002¢\u0006\u0004\bH\u0010IJ\u0012\u0010J\u001a\u0004\u0018\u00010\u0010H\u0082@¢\u0006\u0004\bJ\u0010DJ\u0017\u0010K\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bK\u0010\u0013J\u0017\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bP\u0010\u0013J\u0017\u0010Q\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bQ\u0010\u0013J\u0017\u0010T\u001a\u00020\n2\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UJ\u0019\u0010W\u001a\u00020\r2\b\u0010V\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\bW\u00109J%\u0010Y\u001a\u00020\n2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0FH\u0002¢\u0006\u0004\bY\u0010ZJ+\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0FH\u0002¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020\n2\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\b]\u0010UJ\u0017\u0010^\u001a\u00020\u00152\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010a\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0019H\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\n2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bd\u0010eJ\u0013\u0010f\u001a\u00020\u0019*\u00020cH\u0002¢\u0006\u0004\bf\u0010gJ\u001f\u0010i\u001a\u00020\n2\u0006\u0010S\u001a\u00020c2\u0006\u0010h\u001a\u00020\u0019H\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\n2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bk\u0010eJ\u0019\u0010l\u001a\u0004\u0018\u00010L2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bl\u0010mJ\u0019\u0010o\u001a\u0004\u0018\u00010n2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bo\u0010pJ%\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0F2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001a\u00020t2\u0006\u0010s\u001a\u00020\u0019H\u0002¢\u0006\u0004\bu\u0010vJ\u0017\u0010w\u001a\u00020\n2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\bw\u0010eJ7\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010:0y2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u00192\b\b\u0002\u0010x\u001a\u00020\rH\u0002¢\u0006\u0004\bz\u0010{J-\u0010}\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010\u00042\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0FH\u0002¢\u0006\u0004\b}\u0010\\J\u0017\u0010~\u001a\u00020\n2\u0006\u0010S\u001a\u00020cH\u0002¢\u0006\u0004\b~\u0010eJ\"\u0010\u0080\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001e\u0010\u0082\u0001\u001a\u00020\u0019*\u00020\u007f2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0017\u0010\u0085\u0001\u001a\u00020\u0019*\u00030\u0084\u0001H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\"\u0010\u0087\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0081\u0001J#\u0010\u0089\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0007\u0010\u0088\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\"\u0010\u008b\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u0081\u0001J#\u0010\u008c\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0007\u0010\u0088\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008a\u0001J.\u0010\u008e\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0007\u0010\u0088\u0001\u001a\u00020\u00192\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\"\u0010\u0090\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0081\u0001J\"\u0010\u0091\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0081\u0001J\"\u0010\u0092\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0081\u0001J\"\u0010\u0093\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0081\u0001J\"\u0010\u0094\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0081\u0001J4\u0010\u0095\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00040y2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J0\u0010\u0097\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020:\u0018\u00010y2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0096\u0001J#\u0010\u0099\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0007\u0010\u0098\u0001\u001a\u00020:H\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001c\u0010\u009b\u0001\u001a\u0004\u0018\u00010:2\u0006\u0010,\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\"\u0010\u009d\u0001\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J.\u0010¡\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0007\u0010\u009f\u0001\u001a\u00020\u00192\t\b\u0002\u0010 \u0001\u001a\u00020\rH\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001JL\u0010¨\u0001\u001a\u0004\u0018\u00018\u0000\"\u0005\b\u0000\u0010£\u00012\u0007\u0010¤\u0001\u001a\u00020\u00192%\u0010§\u0001\u001a \b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000¦\u0001\u0012\u0006\u0012\u0004\u0018\u00010G0¥\u0001H\u0082@¢\u0006\u0006\b¨\u0001\u0010©\u0001J\"\u0010ª\u0001\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u007fH\u0002¢\u0006\u0006\bª\u0001\u0010\u0081\u0001J&\u0010¯\u0001\u001a\u00020\n2\b\u0010¬\u0001\u001a\u00030«\u00012\b\u0010®\u0001\u001a\u00030\u00ad\u0001H\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001b\u0010²\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001b\u0010´\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0006\b´\u0001\u0010³\u0001J\u0011\u0010µ\u0001\u001a\u00020\rH\u0016¢\u0006\u0005\bµ\u0001\u0010\u000fJ)\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00012\b\u0010·\u0001\u001a\u00030¶\u00012\u0007\u0010±\u0001\u001a\u00020\u001cH\u0096@¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0011\u0010»\u0001\u001a\u00020\rH\u0016¢\u0006\u0005\b»\u0001\u0010\u000fJ2\u0010½\u0001\u001a\u0005\u0018\u00010¸\u00012\b\u0010·\u0001\u001a\u00030¶\u00012\u0007\u0010¼\u0001\u001a\u00020\u00192\u0007\u0010±\u0001\u001a\u00020\u001cH\u0096@¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0014\u0010¿\u0001\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0005\b¿\u0001\u0010DJ\u001c\u0010À\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010@\u001a\u00020\u0019H\u0096@¢\u0006\u0005\bÀ\u0001\u0010BJ\u001c\u0010Á\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010@\u001a\u00020\u0019H\u0086@¢\u0006\u0005\bÁ\u0001\u0010BJ\u0014\u0010Â\u0001\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0005\bÂ\u0001\u0010DJ\u001c\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010@\u001a\u00020\u0019H\u0096@¢\u0006\u0005\bÃ\u0001\u0010BJ\u001d\u0010Å\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030Ä\u0001H\u0096@¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u001e\u0010É\u0001\u001a\u00030È\u00012\b\u0010·\u0001\u001a\u00030Ç\u0001H\u0096@¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J@\u0010Î\u0001\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00192\u0007\u0010Ë\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0017\u0010Ð\u0001\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0019¢\u0006\u0005\bÐ\u0001\u00109J,\u0010Ñ\u0001\u001a\u0005\u0018\u00010¸\u00012\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\u0007\u0010±\u0001\u001a\u00020\u001c¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u001d\u0010Ô\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030Ó\u0001H\u0096@¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u001d\u0010×\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030Ö\u0001H\u0096@¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u001d\u0010Ú\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030Ù\u0001H\u0096@¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u001d\u0010Ý\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030Ü\u0001H\u0096@¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J4\u0010â\u0001\u001a\u00030á\u00012\u0006\u0010+\u001a\u00020\u00192\u0007\u0010ß\u0001\u001a\u00020\u00192\r\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004H\u0096@¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u001d\u0010å\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030ä\u0001H\u0096@¢\u0006\u0006\bå\u0001\u0010æ\u0001J\u001d\u0010è\u0001\u001a\u00020\r2\b\u0010·\u0001\u001a\u00030ç\u0001H\u0096@¢\u0006\u0006\bè\u0001\u0010é\u0001JY\u0010í\u0001\u001a\u00020\n2\b\u0010¬\u0001\u001a\u00030«\u00012\b\u0010·\u0001\u001a\u00030ê\u000120\u0010ì\u0001\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0ë\u0001H\u0096@¢\u0006\u0006\bí\u0001\u0010î\u0001J0\u0010ò\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020\u00192\u0007\u0010ð\u0001\u001a\u00020\u00192\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0019H\u0096@¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u001e\u0010ö\u0001\u001a\u00030õ\u00012\b\u0010·\u0001\u001a\u00030ô\u0001H\u0096@¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u001b\u0010ù\u0001\u001a\u00020\r2\u0007\u0010ø\u0001\u001a\u00020\u0019H\u0096@¢\u0006\u0005\bù\u0001\u0010BJ$\u0010£\u0001\u001a\u00020\n2\u0007\u0010ø\u0001\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@¢\u0006\u0006\b£\u0001\u0010ú\u0001J\u001b\u0010û\u0001\u001a\u00020\n2\u0007\u0010ø\u0001\u001a\u00020\u0019H\u0096@¢\u0006\u0005\bû\u0001\u0010BJ%\u0010ý\u0001\u001a\u00020\n2\u0007\u0010ø\u0001\u001a\u00020\u00192\u0007\u0010ü\u0001\u001a\u00020\u0019H\u0096@¢\u0006\u0006\bý\u0001\u0010ú\u0001J\u001d\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010þ\u0001\u001a\u00020\u0019H\u0096@¢\u0006\u0005\bÿ\u0001\u0010BJ%\u0010\u0081\u0002\u001a\u00020\r2\u0007\u0010þ\u0001\u001a\u00020\u00192\u0007\u0010\u0080\u0002\u001a\u00020\u0019H\u0096@¢\u0006\u0006\b\u0081\u0002\u0010ú\u0001J\u001c\u0010\u0083\u0002\u001a\u00020\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010\u0082\u0002¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002R \u0010þ\u0001\u001a\u00030\u0085\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bþ\u0001\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R)\u0010\u008c\u0002\u001a\u0014\u0012\u000f\u0012\r \u008b\u0002*\u0005\u0018\u00010\u008a\u00020\u008a\u00020\u0089\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0017\u0010\u008e\u0002\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u0018\u0010\u0091\u0002\u001a\u00030\u0090\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R\u0018\u0010\u0094\u0002\u001a\u00030\u0093\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0095\u0002R\u0018\u0010\u0097\u0002\u001a\u00030\u0096\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0098\u0002R@\u0010\u009b\u0002\u001a+\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00100\u0010 \u008b\u0002*\u0014\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u009a\u00020\u0099\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u0018\u0010\u009e\u0002\u001a\u00030\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u0018\u0010¡\u0002\u001a\u00030 \u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R\u0018\u0010£\u0002\u001a\u00030 \u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0002\u0010¢\u0002R-\u0010¦\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00190¥\u00020¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R\u0018\u0010¨\u0002\u001a\u00030 \u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010¢\u0002R-\u0010©\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00190¥\u00020¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0002\u0010§\u0002R\u001b\u0010ª\u0002\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010«\u0002R\u001b\u0010¬\u0002\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010«\u0002R\u001b\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u001c\u0010°\u0002\u001a\u0005\u0018\u00010¯\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010±\u0002R\u001c\u0010²\u0002\u001a\u0005\u0018\u00010¯\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010±\u0002R\u001c\u0010³\u0002\u001a\u0005\u0018\u00010¯\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010±\u0002R\u001c\u0010´\u0002\u001a\u0005\u0018\u00010¯\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010±\u0002R]\u0010¶\u0002\u001aH\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00050\u0005\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\r0\r \u008b\u0002*\"\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00050\u0005\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\r0\r\u0018\u00010F0µ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0002\u0010·\u0002R\u0019\u0010¸\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010ÿ\u0001R@\u0010¹\u0002\u001a+\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00190\u0019 \u008b\u0002*\u0014\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u009a\u00020\u0099\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010\u009c\u0002R1\u0010º\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0019\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020:0¤\u00020¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0002\u0010§\u0002R%\u0010¼\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0005\u0012\u00030»\u00020¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0002\u0010§\u0002R\u001e\u0010½\u0002\u001a\t\u0012\u0004\u0012\u00020\u00190\u0099\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010\u009c\u0002R\u0018\u0010¿\u0002\u001a\u00030¾\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R@\u0010Á\u0002\u001a+\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00190\u0019 \u008b\u0002*\u0014\u0012\r\u0012\u000b \u008b\u0002*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u009a\u00020\u0099\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010\u009c\u0002R$\u0010Â\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0002\u0010§\u0002R$\u0010Ã\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0002\u0010§\u0002R\u001c\u0010Ä\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R>\u0010Æ\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÆ\u0002\u0010Ç\u0002\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R5\u0010Î\u0002\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0Ì\u0002j\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b`Í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002¨\u0006Ó\u0002"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "<init>", "()V", "", "Lcom/stepos/agentframework/adapter/netcore/B;", "b2", "()Ljava/util/List;", "", "count", "LY8/t;", "i2", "(I)V", "", "v1", "()Z", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "bus", "X0", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "d2", "", "timeoutMs", "N0", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;JLe9/c;)Ljava/lang/Object;", "", "reason", "Lkotlin/Function1;", "Lcom/stepos/agentframework/adapter/netcore/h;", "action", "G1", "(Ljava/lang/String;Lp9/l;)V", "w1", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)Z", "M0", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Le9/c;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "res", "x1", "(Lorg/json/JSONObject;)Z", "y1", "O0", "(Lorg/json/JSONObject;)Ljava/lang/String;", "sessionId", "outboundId", "code", "cloudMsg", "didRetry", "retryReason", "A1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;)V", "E1", "(Ljava/lang/String;)V", "M1", "(Ljava/lang/String;)Ljava/lang/Long;", "F1", "P0", "(Ljava/lang/String;)Z", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;", "active", "success", "message", "b1", "(Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;ZLjava/lang/Integer;Ljava/lang/String;)V", "agentId", "Y0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Z0", "(Le9/c;)Ljava/lang/Object;", "LK6/L;", "", "", "e2", "(LK6/L;)Ljava/util/Map;", "c1", SdCardDbCreator.FIELD_LASTLOC_INFO, "Lcom/stepos/agentframework/adapter/netcore/C;", "event", "W0", "(Lcom/stepos/agentframework/adapter/netcore/C;)V", "Z1", "Y1", "La4/r;", "ev", "j2", "(La4/r;)V", UxipConstants.f30680s, "z1", "payload", "t1", "(Ljava/util/Map;)V", "L1", "(Ljava/util/Map;)Ljava/util/List;", "m1", "h2", "(Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;)J", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "f1", "(Ljava/lang/String;Ljava/lang/String;)V", "La4/z;", "s1", "(La4/z;)V", SdCardDbCreator.FIELD_LASTLOC_ID, "(La4/z;)Ljava/lang/String;", "stream", "k2", "(La4/z;Ljava/lang/String;)V", "q1", "K1", "(La4/z;)Lcom/stepos/agentframework/adapter/netcore/C;", "Lcom/stepos/agentframework/adapter/netcore/z;", "J1", "(La4/z;)Lcom/stepos/agentframework/adapter/netcore/z;", "c2", "(La4/z;)Ljava/util/Map;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "D1", "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "p1", "allowUnboundFallback", "Lkotlin/Pair;", "h1", "(Ljava/lang/String;Ljava/lang/String;Z)Lkotlin/Pair;", "LK6/A;", "I1", "l1", "La4/w;", "H1", "(Ljava/lang/String;La4/w;)V", "T0", "(La4/w;Ljava/lang/String;)Ljava/lang/String;", "LK6/m;", "B1", "(LK6/m;)Ljava/lang/String;", "U0", "lookupSessionId", "U1", "(Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;Ljava/lang/String;)V", "r1", "T1", "graceMs", "V1", "(Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;Ljava/lang/String;J)V", "n1", "R0", "o1", "S0", "e1", "C1", "(Ljava/lang/String;La4/w;)Lkotlin/Pair;", "j1", AbilityType.CHAT, "N1", "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;)V", "g1", "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;", "f2", "(Ljava/lang/String;Ljava/lang/String;)Z", "chatId", "discardLateFrames", "R1", "(Ljava/lang/String;Ljava/lang/String;Z)V", ExifInterface.GPS_DIRECTION_TRUE, "op", "Lkotlin/Function2;", "Le9/c;", "block", "l2", "(Ljava/lang/String;Lp9/p;Le9/c;)Ljava/lang/Object;", "g2", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "listener", "n", "(Lcom/stepos/agentframework/adapter/netcore/B;)V", "y", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "D", "originRunId", "B", "(LK6/n;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Q0", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_PKGNAME, "LK6/I;", "l", "(LK6/I;Le9/c;)Ljava/lang/Object;", "LK6/J;", "LK6/K;", Const.INTENT_KEY_UMID, "(LK6/J;Le9/c;)Ljava/lang/Object;", "requestId", "decision", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "u1", "Q1", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/h;)Lcom/stepos/agentframework/adapter/netcore/n;", "LK6/G;", "f", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_APIKEY, "(LK6/H;Le9/c;)Ljava/lang/Object;", "inquiryId", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LK6/s;", "C", "(LK6/s;Le9/c;)Ljava/lang/Object;", "LK6/O;", "u", "(LK6/O;Le9/c;)Ljava/lang/Object;", "LK6/M;", "Lkotlin/Function5;", "onProgress", "o", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "fileUri", "mime", DidiCardProvider.KEY_TRACE_ID, "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/C;", "LK6/D;", "K", "(LK6/C;Le9/c;)Ljava/lang/Object;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "a0", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "L", "title", ExifInterface.LONGITUDE_WEST, "type", "I", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Z", "Lcom/stepos/agentframework/adapter/netcore/t;", "W1", "(Lcom/stepos/agentframework/adapter/netcore/t;)V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$Lifecycle;", "kotlin.jvm.PlatformType", "lifecycle", "Ljava/util/concurrent/atomic/AtomicReference;", "lifecycleLock", "Ljava/lang/Object;", "Ljava/util/concurrent/CountDownLatch;", "teardownLatch", "Ljava/util/concurrent/CountDownLatch;", "LUa/x;", "ownerJob", "LUa/x;", "LUa/M;", "scope", "LUa/M;", "", "", "stoppedBindings", "Ljava/util/Set;", "LUa/I;", "inboundSerial", "LUa/I;", "Leb/a;", "connectMutex", "Leb/a;", "createSessionMutex", "Ljava/util/concurrent/ConcurrentHashMap;", "LUa/Q;", "inflightCreateSession", "Ljava/util/concurrent/ConcurrentHashMap;", "hotSessionMutex", "inflightHotSession", "binding", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "connectingBinding", "hostPackageName", "Ljava/lang/String;", "Lkotlinx/coroutines/g;", "taskEventsJob", "Lkotlinx/coroutines/g;", "stepClawEventsJob", "uiActionEventsJob", "customEventsJob", "", "taskEventListeners", "Ljava/util/Map;", "taskListenerHighWater", "warnedUnhandledStreams", "activeChats", "Lcom/stepos/agentframework/adapter/agentbus/N;", "pushToolTrackers", "completedOutboundIds", "Lcom/stepos/agentframework/adapter/agentbus/K;", "staleReplayGuard", "Lcom/stepos/agentframework/adapter/agentbus/K;", "seenModerationKeys", "recentUserAbortAtMs", "recentSessionDeleteAtMs", "pushMessageListener", "Lcom/stepos/agentframework/adapter/netcore/t;", "serverInitiatedRoundAdopter", "Lp9/p;", "getServerInitiatedRoundAdopter", "()Lp9/p;", "X1", "(Lp9/p;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "inboundAnchors", "Ljava/util/LinkedHashMap;", "Companion", "Lifecycle", "AgentBusCancelHandle", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusCoreAgentClient implements com.stepos.agentframework.adapter.netcore.o {
    private static final long ACK_TIMEOUT_MS = 125000;
    private static final int ANCHOR_CAP = 16;
    private static final int CLOUD_ERR_MSG_LOG_MAX = 180;
    private static final long CLOUD_READY_TIMEOUT_MS = 120000;
    private static final int COMPLETED_OUTBOUND_ID_CAP = 500;
    private static final long CONNECT_TIMEOUT_MS = 10000;
    private static final int DELETE_SESSION_ATTEMPTS = 3;
    private static final long DELETE_SESSION_RETRY_DELAY_MS = 400;
    private static final long DISCONNECT_TERMINAL_GRACE_MS = 20000;
    private static final long EMPTY_TERMINAL_GRACE_MS = 15000;
    private static final int ERROR_CODE_NO_NETWORK = -100;
    private static final int HOT_SESSION_ACQUIRE_RETRIES = 1;
    private static final long HOT_SESSION_ACQUIRE_TIMEOUT_MS = 1200;
    private static final String INVOKE_ERROR_TIMEOUT = "TIMEOUT";
    private static final String LOCAL_CLOUD_SNAPSHOT_REASON = "agentbus disconnected";
    private static final int OPENCLAW_UNAVAILABLE = 5;
    private static final long POST_ABORT_ACK_GRACE_MS = 8000;
    private static final long POST_ABORT_RETRY_WINDOW_MS = 15000;
    private static final int RECENT_ABORT_CAP = 32;
    private static final int RECENT_DELETE_CAP = 64;
    private static final long RECENT_DELETE_CORRELATE_MS = 600000;
    private static final long SEND_CONFLICT_RETRY_DELAY_MS = 400;
    private static final long SEND_UNAVAILABLE_RETRY_DELAY_MS = 600;
    private static final String STEP_CLAW_SESSION_UPDATE = "stepclaw.session.update";
    private static final long STEP_TERMINAL_GRACE_MS = 120000;
    private static final String TAG = "AgentBusCoreAgentClient";
    private static final int TASK_LISTENER_WARN_THRESHOLD = 4;
    private static final String UI_STREAM = "ui";
    private static final int UNHANDLED_STREAM_WARN_CAP = 32;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, ActiveChat>> activeChats;
    private volatile ClawChannelAgentBusBinding binding;
    private final Set<String> completedOutboundIds;
    private final InterfaceC4021a connectMutex;
    private volatile ClawChannelAgentBusBinding connectingBinding;
    private final InterfaceC4021a createSessionMutex;
    private kotlinx.coroutines.g customEventsJob;
    private volatile String hostPackageName;
    private final InterfaceC4021a hotSessionMutex;
    private final LinkedHashMap<String, Integer> inboundAnchors;
    private final Ua.I inboundSerial;
    private final ConcurrentHashMap<String, Q<String>> inflightCreateSession;
    private final ConcurrentHashMap<String, Q<String>> inflightHotSession;
    private final InterfaceC1089x ownerJob;
    private volatile com.stepos.agentframework.adapter.netcore.t pushMessageListener;
    private final ConcurrentHashMap<String, N> pushToolTrackers;
    private final ConcurrentHashMap<String, Long> recentSessionDeleteAtMs;
    private final ConcurrentHashMap<String, Long> recentUserAbortAtMs;
    private final Ua.M scope;
    private final Set<String> seenModerationKeys;
    private volatile p9.p<? super String, ? super String, Boolean> serverInitiatedRoundAdopter;
    private final K staleReplayGuard;
    private kotlinx.coroutines.g stepClawEventsJob;
    private final Set<ClawChannelAgentBusBinding> stoppedBindings;
    private final Map<com.stepos.agentframework.adapter.netcore.B, Boolean> taskEventListeners;
    private kotlinx.coroutines.g taskEventsJob;
    private volatile int taskListenerHighWater;
    private kotlinx.coroutines.g uiActionEventsJob;
    private final Set<String> warnedUnhandledStreams;
    private static final String STEP_CLAW_REFERENCE_EVENT = "stepclaw.reference";
    private static final String STEP_CLAW_TASK_UPSERT = "stepclaw.task.v2.upsert";
    private static final String STEP_CLAW_TASK_DISMISS = "stepclaw.task.v2.dismiss";
    private static final String STEP_CLAW_UI_EVENT = "stepclaw.ui";
    private static final String STEP_CLAW_CARD_EVENT = "stepclaw.card";
    private static final Set<String> STEP_CLAW_HANDLED_STREAMS = Y.j(STEP_CLAW_REFERENCE_EVENT, STEP_CLAW_TASK_UPSERT, STEP_CLAW_TASK_DISMISS, "stepclaw.session.update", STEP_CLAW_UI_EVENT, STEP_CLAW_CARD_EVENT);
    private static final Set<BusTaskStatus> TASK_V2_TERMINAL_STATUSES = Y.j(BusTaskStatus.COMPLETED, BusTaskStatus.FAILED, BusTaskStatus.CANCELLED);
    private final ApiType type = ApiType.AGENTBUS;
    private final AtomicReference<Lifecycle> lifecycle = new AtomicReference<>(Lifecycle.ALIVE);
    private final Object lifecycleLock = new Object();
    private final CountDownLatch teardownLatch = new CountDownLatch(1);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$AgentBusCancelHandle;", "Lcom/stepos/agentframework/adapter/netcore/n;", "", "sessionId", "chatId", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient;Ljava/lang/String;Ljava/lang/String;)V", "LY8/t;", "c", "()V", "reason", "", "cancel", "(Ljava/lang/String;)Z", "isCancelled", "()Z", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class AgentBusCancelHandle implements com.stepos.agentframework.adapter.netcore.n {
        private final AtomicBoolean cancelled;
        private final String chatId;
        private final String sessionId;
        final /* synthetic */ AgentBusCoreAgentClient this$0;

        public AgentBusCancelHandle(AgentBusCoreAgentClient agentBusCoreAgentClient, String sessionId, String chatId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(chatId, "chatId");
            this.this$0 = agentBusCoreAgentClient;
            this.sessionId = sessionId;
            this.chatId = chatId;
            this.cancelled = new AtomicBoolean(false);
        }

        public final ActiveChat b() {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.this$0.activeChats.get(this.sessionId);
            if (concurrentHashMap != null) {
                return (ActiveChat) concurrentHashMap.get(this.chatId);
            }
            return null;
        }

        public final void c() {
            AtomicBoolean finished;
            ActiveChat activeChatB = b();
            if (activeChatB != null && (finished = activeChatB.getFinished()) != null) {
                finished.set(true);
            }
            this.cancelled.set(true);
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        public boolean cancel(String reason) {
            String outboundId;
            String str;
            AtomicReference<String> atomicReferenceO;
            AtomicReference<kotlinx.coroutines.g> atomicReferenceM;
            kotlinx.coroutines.g andSet;
            AtomicReference<String> atomicReferenceO2;
            String str2;
            AtomicBoolean finished;
            AtomicBoolean finished2;
            kotlin.jvm.internal.p.i(reason, "reason");
            ActiveChat activeChatB = b();
            if ((activeChatB != null && (finished2 = activeChatB.getFinished()) != null && finished2.get()) || !this.cancelled.compareAndSet(false, true)) {
                C4148a.d(AgentBusCoreAgentClient.TAG, "cancel ignored sessionId=" + this.sessionId + " chatId=" + this.chatId + " finished=" + ((activeChatB == null || (finished = activeChatB.getFinished()) == null) ? null : Boolean.valueOf(finished.get())), false, 4, null);
                return false;
            }
            C4148a.k(AgentBusCoreAgentClient.TAG, "cancel sessionId=" + this.sessionId + " chatId=" + this.chatId + " reason=" + reason + " outboundId=" + (activeChatB != null ? activeChatB.getOutboundId() : null) + " runId=" + ((activeChatB == null || (atomicReferenceO2 = activeChatB.o()) == null || (str2 = atomicReferenceO2.get()) == null) ? null : La.K.R1(str2, 32)), false, 4, null);
            if (activeChatB != null && (atomicReferenceM = activeChatB.m()) != null && (andSet = atomicReferenceM.getAndSet(null)) != null) {
                kotlinx.coroutines.g.Y0(andSet, null, 1, null);
            }
            if (kotlin.jvm.internal.p.d(reason, "user.abort")) {
                this.this$0.F1(this.sessionId);
                if (activeChatB == null || (outboundId = activeChatB.getOutboundId()) == null || outboundId.length() <= 0) {
                    outboundId = null;
                }
                if (activeChatB == null || (atomicReferenceO = activeChatB.o()) == null || (str = atomicReferenceO.get()) == null || str.length() <= 0) {
                    str = null;
                }
                if (outboundId != null || str != null) {
                    Map mapC = Z8.Q.c();
                    mapC.put("sessionId", this.sessionId);
                    mapC.put("reason", reason);
                    if (outboundId != null) {
                        mapC.put("outboundId", outboundId);
                    }
                    if (str != null) {
                        mapC.put(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, str);
                    }
                    C1060i.d(this.this$0.scope, null, null, new AgentBusCoreAgentClient$AgentBusCancelHandle$cancel$1(this.this$0, Z8.Q.b(mapC), null), 3, null);
                }
            }
            this.this$0.R1(this.sessionId, this.chatId, com.stepos.agentframework.adapter.netcore.n.INSTANCE.a(reason));
            return true;
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        /* renamed from: isCancelled */
        public boolean getCancelled() {
            ActiveChat activeChatB;
            AtomicBoolean finished;
            return this.cancelled.get() || !((activeChatB = b()) == null || (finished = activeChatB.getFinished()) == null || !finished.get());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$Lifecycle;", "", "<init>", "(Ljava/lang/String;I)V", "ALIVE", "DESTROYING", "DESTROYED", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Lifecycle {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Lifecycle[] $VALUES;
        public static final Lifecycle ALIVE = new Lifecycle("ALIVE", 0);
        public static final Lifecycle DESTROYING = new Lifecycle("DESTROYING", 1);
        public static final Lifecycle DESTROYED = new Lifecycle("DESTROYED", 2);

        private static final /* synthetic */ Lifecycle[] $values() {
            return new Lifecycle[]{ALIVE, DESTROYING, DESTROYED};
        }

        static {
            Lifecycle[] lifecycleArr$values = $values();
            $VALUES = lifecycleArr$values;
            $ENTRIES = kotlin.enums.a.a(lifecycleArr$values);
        }

        private Lifecycle(String str, int i10) {
        }

        public static InterfaceC4149a<Lifecycle> getEntries() {
            return $ENTRIES;
        }

        public static Lifecycle valueOf(String str) {
            return (Lifecycle) Enum.valueOf(Lifecycle.class, str);
        }

        public static Lifecycle[] values() {
            return (Lifecycle[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TurnDoneCloseAction.values().length];
            try {
                iArr[TurnDoneCloseAction.AWAIT_REPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TurnDoneCloseAction.CLOSE_NOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TurnDoneCloseAction.ARM_GRACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AgentBusCoreAgentClient() {
        InterfaceC1089x interfaceC1089xB = L0.b(null, 1, null);
        this.ownerJob = interfaceC1089xB;
        this.scope = kotlinx.coroutines.d.a(interfaceC1089xB.plus(Ua.Y.b()));
        this.stoppedBindings = Collections.newSetFromMap(new WeakHashMap());
        this.inboundSerial = Ua.I.t1(Ua.Y.b(), 1, null, 2, null);
        int i10 = 0;
        this.connectMutex = eb.f.b(false, 1, null);
        this.createSessionMutex = eb.f.b(false, 1, null);
        this.inflightCreateSession = new ConcurrentHashMap<>();
        this.hotSessionMutex = eb.f.b(false, 1, null);
        this.inflightHotSession = new ConcurrentHashMap<>();
        this.taskEventListeners = Collections.synchronizedMap(new WeakHashMap());
        this.warnedUnhandledStreams = Collections.newSetFromMap(new ConcurrentHashMap());
        this.activeChats = new ConcurrentHashMap<>();
        this.pushToolTrackers = new ConcurrentHashMap<>();
        Set<String> setSynchronizedSet = Collections.synchronizedSet(Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() { // from class: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$completedOutboundIds$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return d((String) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Boolean) {
                    return g((Boolean) obj);
                }
                return false;
            }

            public /* bridge */ boolean d(String str) {
                return super.containsKey(str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
                return i();
            }

            public /* bridge */ boolean g(Boolean bool) {
                return super.containsValue(bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return h((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : n((String) obj, (Boolean) obj2);
            }

            public /* bridge */ Boolean h(String str) {
                return (Boolean) super.get(str);
            }

            public /* bridge */ Set<Map.Entry<String, Boolean>> i() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> j() {
                return super.keySet();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return j();
            }

            public /* bridge */ Boolean n(String str, Boolean bool) {
                return (Boolean) super.getOrDefault(str, bool);
            }

            public /* bridge */ int q() {
                return super.size();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return t((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > 500;
            }

            public /* bridge */ Collection<Boolean> s() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return q();
            }

            public /* bridge */ Boolean t(String str) {
                return (Boolean) super.remove(str);
            }

            public /* bridge */ boolean u(String str, Boolean bool) {
                return super.remove(str, bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Boolean> values() {
                return s();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof Boolean)) {
                    return u((String) obj, (Boolean) obj2);
                }
                return false;
            }
        }));
        kotlin.jvm.internal.p.h(setSynchronizedSet, "synchronizedSet(...)");
        this.completedOutboundIds = setSynchronizedSet;
        this.staleReplayGuard = new K(i10, i10, 3, null);
        this.seenModerationKeys = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() { // from class: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$seenModerationKeys$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return d((String) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Boolean) {
                    return g((Boolean) obj);
                }
                return false;
            }

            public /* bridge */ boolean d(String str) {
                return super.containsKey(str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
                return i();
            }

            public /* bridge */ boolean g(Boolean bool) {
                return super.containsValue(bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return h((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : n((String) obj, (Boolean) obj2);
            }

            public /* bridge */ Boolean h(String str) {
                return (Boolean) super.get(str);
            }

            public /* bridge */ Set<Map.Entry<String, Boolean>> i() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> j() {
                return super.keySet();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return j();
            }

            public /* bridge */ Boolean n(String str, Boolean bool) {
                return (Boolean) super.getOrDefault(str, bool);
            }

            public /* bridge */ int q() {
                return super.size();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return t((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > 200;
            }

            public /* bridge */ Collection<Boolean> s() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return q();
            }

            public /* bridge */ Boolean t(String str) {
                return (Boolean) super.remove(str);
            }

            public /* bridge */ boolean u(String str, Boolean bool) {
                return super.remove(str, bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Boolean> values() {
                return s();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof Boolean)) {
                    return u((String) obj, (Boolean) obj2);
                }
                return false;
            }
        });
        this.recentUserAbortAtMs = new ConcurrentHashMap<>();
        this.recentSessionDeleteAtMs = new ConcurrentHashMap<>();
        this.inboundAnchors = new LinkedHashMap<>();
    }

    public static final ConcurrentHashMap O1(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new ConcurrentHashMap();
    }

    public static final ConcurrentHashMap P1(InterfaceC5074l interfaceC5074l, Object obj) {
        return (ConcurrentHashMap) interfaceC5074l.invoke(obj);
    }

    public static /* synthetic */ void S1(AgentBusCoreAgentClient agentBusCoreAgentClient, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        agentBusCoreAgentClient.R1(str, str2, z10);
    }

    public static final CharSequence V0(IndexedValue indexedValue) {
        kotlin.jvm.internal.p.i(indexedValue, "<destruct>");
        return Const.STR_MART_WELL + indexedValue.getIndex() + " " + ((C0917m) indexedValue.b());
    }

    public static final Y8.t d1(AgentBusCoreAgentClient agentBusCoreAgentClient, String sessionId, Message message) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        if (!agentBusCoreAgentClient.v1()) {
            return Y8.t.f7040a;
        }
        agentBusCoreAgentClient.H1(sessionId, message);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Pair i1(AgentBusCoreAgentClient agentBusCoreAgentClient, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return agentBusCoreAgentClient.h1(str, str2, z10);
    }

    public static final boolean k1(ActiveChat activeChat, String str) {
        return (!kotlin.jvm.internal.p.d(activeChat.getExpectedRunId(), str) || activeChat.getFinished().get() || activeChat.getCancelHandle().getCancelled()) ? false : true;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    public final void A1(String sessionId, String outboundId, Integer code, String cloudMsg, boolean didRetry, String retryReason) {
        String str;
        Long lM1 = M1(sessionId);
        if (cloudMsg.length() <= 180) {
            str = cloudMsg;
        } else {
            str = La.K.R1(cloudMsg, 180) + "…(len=" + cloudMsg.length() + ")";
        }
        if (lM1 == null) {
            C4148a.h(TAG, "[CLOUD_ESCALATE] AIOSBUG-14686 chat.send UNAVAILABLE sessionId=" + sessionId + " outboundId=" + outboundId + " code=" + code + " didRetry=" + didRetry + " retryReason=" + retryReason + " cloudMsg=" + str + " hint=no_local_delete_in_600000ms_escalate_gateway_session_unavailable", false, 4, null);
            return;
        }
        C4148a.h(TAG, "[CLIENT_HINT] AIOSBUG-14686 chat.send UNAVAILABLE after local sessions.delete sessionId=" + sessionId + " outboundId=" + outboundId + " code=" + code + " deleteAgeMs=" + lM1 + " didRetry=" + didRetry + " retryReason=" + retryReason + " cloudMsg=" + str + " hint=reuse_deleted_session_key_check_topConversation_home_inputbar", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ee  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object B(kotlin.C0918n r46, java.lang.String r47, com.stepos.agentframework.adapter.netcore.h r48, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r49) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.B(K6.n, java.lang.String, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
    }

    public final String B1(C0917m c0917m) {
        String messageId = c0917m.getMessageId();
        int seqId = c0917m.getSeqId();
        int index = c0917m.getIndex();
        boolean isFinish = c0917m.getIsFinish();
        String answerType = c0917m.getAnswerType();
        String contentType = c0917m.getContentType();
        List<AbstractC0913i> listN = c0917m.n();
        int size = listN != null ? listN.size() : 0;
        boolean z10 = c0917m.getFunctionCall() != null;
        List<ReferenceSource> listX = c0917m.x();
        return "ChatReplyInfo(messageId=" + messageId + " seqId=" + seqId + " index=" + index + " isFinish=" + isFinish + " answerType=" + answerType + " contentType=" + contentType + " contentParts=" + size + " hasFunctionCall=" + z10 + " refs=" + (listX != null ? listX.size() : 0) + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(kotlin.FeedbackRequest r18, e9.InterfaceC4014c<? super java.lang.Boolean> r19) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$1
            if (r2 == 0) goto L17
            r2 = r1
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$1 r2 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$1 r2 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3d
            if (r4 != r5) goto L35
            java.lang.Object r0 = r2.L$1
            K6.O r0 = (kotlin.VoteRequest) r0
            java.lang.Object r0 = r2.L$0
            K6.s r0 = (kotlin.FeedbackRequest) r0
            kotlin.C4849c.b(r1)
            goto L7a
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            kotlin.C4849c.b(r1)
            K6.O r6 = new K6.O
            java.lang.String r7 = r18.getMessageId()
            java.lang.String r8 = r18.getConversationId()
            int r10 = r18.getVoteType()
            java.lang.String r11 = r18.getConversationId()
            r15 = 228(0xe4, float:3.2E-43)
            r16 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$2 r1 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$feedback$2
            r4 = 0
            r1.<init>(r6, r4)
            java.lang.Object r4 = g9.h.a(r18)
            r2.L$0 = r4
            java.lang.Object r4 = g9.h.a(r6)
            r2.L$1 = r4
            r2.label = r5
            java.lang.String r4 = "feedback"
            java.lang.Object r1 = r0.l2(r4, r1, r2)
            if (r1 != r3) goto L7a
            return r3
        L7a:
            java.lang.Boolean r0 = g9.C4109a.a(r5)
            boolean r0 = kotlin.jvm.internal.p.d(r1, r0)
            java.lang.Boolean r0 = g9.C4109a.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.C(K6.s, e9.c):java.lang.Object");
    }

    public final Pair<String, List<ActiveChat>> C1(String sessionId, Message message) {
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ConcurrentHashMap<String, ActiveChat>> entry : this.activeChats.entrySet()) {
            String key = entry.getKey();
            for (ActiveChat activeChat : entry.getValue().values()) {
                kotlin.jvm.internal.p.h(activeChat, "next(...)");
                ActiveChat activeChat2 = activeChat;
                arrayList.add(new ActiveChatSnapshot(key, activeChat2.getChatId(), activeChat2.getOutboundId(), activeChat2.o().get(), activeChat2.getFinished().get(), activeChat2.getCancelHandle().getCancelled(), activeChat2.m().get() != null, activeChat2.getCreatedAtMs()));
            }
        }
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str = null;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null && str2.length() > 0) {
            str = str2;
        }
        Pair<String, List<ActiveChatSnapshot>> pairC = AgentBusChannelOpsKt.C(sessionId, message.getReplyTo(), str, arrayList);
        String strA = pairC.a();
        List<ActiveChatSnapshot> listB = pairC.b();
        if (!listB.isEmpty() && (concurrentHashMap = this.activeChats.get(strA)) != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                ActiveChat activeChat3 = concurrentHashMap.get(((ActiveChatSnapshot) it.next()).getChatId());
                if (activeChat3 != null) {
                    arrayList2.add(activeChat3);
                }
            }
            return Y8.j.a(strA, arrayList2);
        }
        return Y8.j.a(strA, C1173v.m());
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public boolean D() {
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r1.equals("finish") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r1.equals("success") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return com.stepos.agentframework.adapter.netcore.BusTaskStatus.COMPLETED;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.adapter.netcore.BusTaskStatus D1(java.lang.String r1) {
        /*
            r0 = this;
            int r0 = r1.hashCode()
            switch(r0) {
                case -1867169789: goto L41;
                case -1281977283: goto L35;
                case -1274442605: goto L2c;
                case -643901989: goto L20;
                case 476588369: goto L14;
                case 1550783935: goto L8;
                default: goto L7;
            }
        L7:
            goto L49
        L8:
            java.lang.String r0 = "running"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L11
            goto L49
        L11:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.RUNNING
            return r0
        L14:
            java.lang.String r0 = "cancelled"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L1d
            goto L49
        L1d:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.CANCELLED
            return r0
        L20:
            java.lang.String r0 = "takeover"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L29
            goto L49
        L29:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.WAITING
            return r0
        L2c:
            java.lang.String r0 = "finish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L4c
            goto L49
        L35:
            java.lang.String r0 = "failed"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L3e
            goto L49
        L3e:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.FAILED
            return r0
        L41:
            java.lang.String r0 = "success"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L4c
        L49:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.RUNNING
            return r0
        L4c:
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r0 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.COMPLETED
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.D1(java.lang.String):com.stepos.agentframework.adapter.netcore.BusTaskStatus");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x077e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x077f  */
    /* JADX WARN: Removed duplicated region for block: B:260:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0338  */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v20 */
    /* JADX WARN: Type inference failed for: r20v21 */
    /* JADX WARN: Type inference failed for: r20v29 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.stepos.agentframework.adapter.netcore.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v53, types: [T] */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r46v0, types: [com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient] */
    /* JADX WARN: Type inference failed for: r4v46, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v35, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v42 */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(kotlin.C0918n r47, com.stepos.agentframework.adapter.netcore.h r48, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r49) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.E(K6.n, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
    }

    public final void E1(String sessionId) {
        Object obj;
        String str;
        if (sessionId.length() == 0) {
            return;
        }
        this.recentSessionDeleteAtMs.put(sessionId, Long.valueOf(System.currentTimeMillis()));
        if (this.recentSessionDeleteAtMs.size() <= 64) {
            return;
        }
        Iterator<T> it = this.recentSessionDeleteAtMs.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long jLongValue = ((Number) ((Map.Entry) next).getValue()).longValue();
                do {
                    Object next2 = it.next();
                    long jLongValue2 = ((Number) ((Map.Entry) next2).getValue()).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null || (str = (String) entry.getKey()) == null) {
            return;
        }
        this.recentSessionDeleteAtMs.remove(str);
    }

    public final void F1(String sessionId) {
        Object obj;
        String str;
        if (sessionId.length() == 0) {
            return;
        }
        this.recentUserAbortAtMs.put(sessionId, Long.valueOf(System.currentTimeMillis()));
        if (this.recentUserAbortAtMs.size() <= 32) {
            return;
        }
        Iterator<T> it = this.recentUserAbortAtMs.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long jLongValue = ((Number) ((Map.Entry) next).getValue()).longValue();
                do {
                    Object next2 = it.next();
                    long jLongValue2 = ((Number) ((Map.Entry) next2).getValue()).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null || (str = (String) entry.getKey()) == null) {
            return;
        }
        this.recentUserAbortAtMs.remove(str);
    }

    public final void G1(String reason, InterfaceC5074l<? super com.stepos.agentframework.adapter.netcore.h, Y8.t> action) {
        Object objB;
        if (v1()) {
            Collection<ConcurrentHashMap<String, ActiveChat>> collectionValues = this.activeChats.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                Collection collectionValues2 = ((ConcurrentHashMap) it.next()).values();
                kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
                Z8.A.E(arrayList, collectionValues2);
            }
            ArrayList<ActiveChat> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                ActiveChat activeChat = (ActiveChat) obj;
                if (!activeChat.getFinished().get() && !activeChat.getCancelHandle().getCancelled()) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            C4148a.u(TAG, reason + " -> notify " + arrayList2.size() + " in-flight chat(s)", false, 4, null);
            boolean zG0 = La.H.g0(reason, "disconnected", false, 2, null);
            for (ActiveChat activeChat2 : arrayList2) {
                if (zG0) {
                    activeChat2.getLastCloudDisconnectAtMs().set(System.currentTimeMillis());
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    action.invoke(activeChat2.getListener());
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.u(TAG, reason + " dispatch failed: " + thE.getMessage(), false, 4, null);
                }
            }
        }
    }

    public final void H1(String sessionId, Message message) {
        if (v1()) {
            C4148a.k(TAG, "← inbound sessionId=" + sessionId + " message=" + T0(message, sessionId), false, 4, null);
            if (v.INSTANCE.a()) {
                C4148a.k(TAG, "VERBOSE " + ((Object) ("← IN sessionId=" + sessionId + " " + C1835k.c(message))), false, 4, null);
            }
            if (message.getRole() == Role.ASSISTANT || message.getRole() == Role.TOOL) {
                C1060i.d(this.scope, this.inboundSerial, null, new AgentBusCoreAgentClient$onIncomingMessage$2(this, sessionId, message, null), 2, null);
                return;
            }
            C4148a.d(TAG, "← skip role=" + message.getRole() + " sessionId=" + sessionId + " message=" + T0(message, sessionId), false, 4, null);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object I(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return l2("readCoreFile", new AgentBusCoreAgentClient$readCoreFile$2(str, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<kotlin.ReferenceSource> I1(java.util.Map<java.lang.String, ? extends java.lang.Object> r8) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.I1(java.util.Map):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.adapter.netcore.TaskDismiss J1(a4.StepClawEvent r4) {
        /*
            r3 = this;
            java.util.Map r3 = r3.c2(r4)
            java.lang.String r4 = "taskId"
            java.lang.Object r4 = r3.get(r4)
            boolean r0 = r4 instanceof java.lang.String
            r1 = 0
            if (r0 == 0) goto L12
            java.lang.String r4 = (java.lang.String) r4
            goto L13
        L12:
            r4 = r1
        L13:
            if (r4 == 0) goto L58
            boolean r0 = La.H.x0(r4)
            if (r0 != 0) goto L1c
            goto L1d
        L1c:
            r4 = r1
        L1d:
            if (r4 == 0) goto L58
            java.lang.String r4 = com.stepos.agentframework.adapter.agentbus.C1832h.a(r4)
            if (r4 == 0) goto L58
            java.lang.String r0 = "surface"
            java.lang.Object r0 = r3.get(r0)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L32
            java.lang.String r0 = (java.lang.String) r0
            goto L33
        L32:
            r0 = r1
        L33:
            if (r0 == 0) goto L3f
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L3c
            goto L3d
        L3c:
            r0 = r1
        L3d:
            if (r0 != 0) goto L41
        L3f:
            java.lang.String r0 = "all"
        L41:
            java.lang.String r2 = "reason"
            java.lang.Object r3 = r3.get(r2)
            boolean r2 = r3 instanceof java.lang.String
            if (r2 == 0) goto L4e
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
        L4e:
            if (r1 != 0) goto L52
            java.lang.String r1 = ""
        L52:
            com.stepos.agentframework.adapter.netcore.z r3 = new com.stepos.agentframework.adapter.netcore.z
            r3.<init>(r4, r0, r1)
            return r3
        L58:
            r3 = 0
            r4 = 4
            java.lang.String r0 = "AgentBusCoreAgentClient"
            java.lang.String r2 = "task.v2.dismiss without taskId, dropped"
            h8.C4148a.u(r0, r2, r3, r4, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.J1(a4.z):com.stepos.agentframework.adapter.netcore.z");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(kotlin.SyncHistoryRequest r8, e9.InterfaceC4014c<? super kotlin.SyncHistoryResult> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            K6.C r7 = (kotlin.SyncHistoryRequest) r7
            kotlin.C4849c.b(r9)
            goto L4f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.C4849c.b(r9)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$2 r9 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncHistory$2
            r2 = 0
            r9.<init>(r8, r2)
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            r0.label = r3
            java.lang.String r8 = "syncHistory"
            java.lang.Object r9 = r7.l2(r8, r9, r0)
            if (r9 != r1) goto L4f
            return r1
        L4f:
            K6.D r9 = (kotlin.SyncHistoryResult) r9
            if (r9 != 0) goto L61
            K6.D r0 = new K6.D
            r5 = 9
            r6 = 0
            r1 = 0
            r2 = 0
            java.lang.String r3 = "AgentBus 未连接"
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        L61:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.K(K6.C, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.adapter.netcore.TaskEventPayload K1(a4.StepClawEvent r36) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.K1(a4.z):com.stepos.agentframework.adapter.netcore.C");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object L(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objL2 = l2("clearSession", new AgentBusCoreAgentClient$clearSession$2(str, null), interfaceC4014c);
        return objL2 == C4063a.g() ? objL2 : Y8.t.f7040a;
    }

    public final List<String> L1(Map<String, ? extends Object> payload) {
        Object obj = payload.get("actions");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            Object obj2 = payload.get("data");
            Map map = obj2 instanceof Map ? (Map) obj2 : null;
            Object obj3 = map != null ? map.get("actions") : null;
            list = obj3 instanceof List ? (List) obj3 : null;
            if (list == null) {
                return C1173v.m();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : list) {
            Map map2 = obj4 instanceof Map ? (Map) obj4 : null;
            Object obj5 = map2 != null ? map2.get("type") : null;
            String str = obj5 instanceof String ? (String) obj5 : null;
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj6 : arrayList) {
            if (((String) obj6).length() > 0) {
                arrayList2.add(obj6);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M0(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 4
            java.lang.String r3 = "AgentBusCoreAgentClient"
            r4 = 0
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L3a
            if (r1 != r6) goto L32
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r10
            kotlin.C4849c.b(r9)
            goto L7b
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.C4849c.b(r9)
            boolean r9 = r10.C()
            if (r9 == 0) goto L48
            java.lang.Boolean r9 = g9.C4109a.a(r6)
            return r9
        L48:
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$b r9 = r10.getHealth()
            Xa.t r9 = r9.b()
            java.lang.Object r9 = r9.getValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "cloud channel not ready, wait up to 120000ms status="
            r1.append(r7)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            h8.C4148a.k(r3, r9, r5, r2, r4)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1 r9 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitCloudConnected$ready$1
            r9.<init>(r10, r4)
            r0.L$0 = r10
            r0.label = r6
            r7 = 120000(0x1d4c0, double:5.9288E-319)
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.e(r7, r9, r0)
            if (r9 != r11) goto L7b
            return r11
        L7b:
            java.lang.Boolean r11 = g9.C4109a.a(r6)
            boolean r9 = kotlin.jvm.internal.p.d(r9, r11)
            boolean r11 = r10.D()
            if (r11 != 0) goto L93
            java.lang.String r9 = "local binding dropped while waiting for cloud channel"
            h8.C4148a.u(r3, r9, r5, r2, r4)
            java.lang.Boolean r9 = g9.C4109a.a(r5)
            return r9
        L93:
            if (r9 == 0) goto L9a
            java.lang.String r11 = "cloud channel became ready while waiting"
            h8.C4148a.k(r3, r11, r5, r2, r4)
        L9a:
            if (r9 != 0) goto La2
            boolean r9 = r10.C()
            if (r9 == 0) goto La3
        La2:
            r5 = r6
        La3:
            java.lang.Boolean r9 = g9.C4109a.a(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.M0(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, e9.c):java.lang.Object");
    }

    public final Long M1(String sessionId) {
        Long l10 = this.recentSessionDeleteAtMs.get(sessionId);
        if (l10 != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - l10.longValue();
            if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= 600000) {
                return Long.valueOf(jCurrentTimeMillis);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object N(java.lang.String r5, java.lang.String r6, java.lang.String r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.C4849c.b(r8)
            goto L63
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r8)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$2 r8 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$checkImagePrivacy$2
            r2 = 0
            r8.<init>(r5, r6, r7, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            java.lang.Object r5 = g9.h.a(r7)
            r0.L$2 = r5
            r0.label = r3
            java.lang.String r5 = "checkImagePrivacy"
            java.lang.Object r8 = r4.l2(r5, r8, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L6b
            boolean r3 = r8.booleanValue()
        L6b:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.N(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r6, long r7, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitConnectedIfAlive$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitConnectedIfAlive$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitConnectedIfAlive$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitConnectedIfAlive$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$awaitConnectedIfAlive$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r6 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r6
            kotlin.C4849c.b(r9)     // Catch: java.util.concurrent.CancellationException -> L2e
            goto L5d
        L2e:
            r6 = move-exception
            goto L67
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.C4849c.b(r9)
            boolean r9 = r5.v1()
            if (r9 != 0) goto L46
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        L46:
            boolean r9 = r6.D()     // Catch: java.util.concurrent.CancellationException -> L2e
            if (r9 != 0) goto L65
            java.lang.Object r9 = g9.h.a(r6)     // Catch: java.util.concurrent.CancellationException -> L2e
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> L2e
            r0.J$0 = r7     // Catch: java.util.concurrent.CancellationException -> L2e
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> L2e
            java.lang.Object r9 = r6.m(r7, r0)     // Catch: java.util.concurrent.CancellationException -> L2e
            if (r9 != r1) goto L5d
            return r1
        L5d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.util.concurrent.CancellationException -> L2e
            boolean r5 = r9.booleanValue()     // Catch: java.util.concurrent.CancellationException -> L2e
            if (r5 == 0) goto L6d
        L65:
            r3 = r4
            goto L6d
        L67:
            boolean r5 = r5.v1()
            if (r5 != 0) goto L72
        L6d:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        L72:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.N0(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, long, e9.c):java.lang.Object");
    }

    public final void N1(String sessionId, ActiveChat chat) {
        if (v1()) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, ActiveChat>> concurrentHashMap = this.activeChats;
            final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentBusCoreAgentClient.O1((String) obj);
                }
            };
            ConcurrentHashMap<String, ActiveChat> concurrentHashMapComputeIfAbsent = concurrentHashMap.computeIfAbsent(sessionId, new Function() { // from class: com.stepos.agentframework.adapter.agentbus.d
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AgentBusCoreAgentClient.P1(interfaceC5074l, obj);
                }
            });
            kotlin.jvm.internal.p.h(concurrentHashMapComputeIfAbsent, "computeIfAbsent(...)");
            ConcurrentHashMap<String, ActiveChat> concurrentHashMap2 = concurrentHashMapComputeIfAbsent;
            Collection<ActiveChat> collectionValues = concurrentHashMap2.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            ArrayList<ActiveChat> arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (!kotlin.jvm.internal.p.d(((ActiveChat) obj).getChatId(), chat.getChatId())) {
                    arrayList.add(obj);
                }
            }
            concurrentHashMap2.put(chat.getChatId(), chat);
            if (!v1()) {
                concurrentHashMap2.remove(chat.getChatId());
                if (concurrentHashMap2.isEmpty()) {
                    this.activeChats.remove(sessionId, concurrentHashMap2);
                    return;
                }
                return;
            }
            for (ActiveChat activeChat : arrayList) {
                if (activeChat.getFinished().get() || activeChat.getCancelHandle().getCancelled()) {
                    S1(this, sessionId, activeChat.getChatId(), false, 4, null);
                } else {
                    C4148a.k(TAG, "preempt old chat sessionId=" + sessionId + " old=" + activeChat.getChatId() + " new=" + chat.getChatId(), false, 4, null);
                    activeChat.getCancelHandle().cancel("client.superseded");
                }
            }
            String chatId = chat.getChatId();
            ConcurrentHashMap<String, ActiveChat> concurrentHashMap3 = this.activeChats.get(sessionId);
            C4148a.d(TAG, "active chat registered sessionId=" + sessionId + " chatId=" + chatId + " count=" + (concurrentHashMap3 != null ? Integer.valueOf(concurrentHashMap3.size()) : null), false, 4, null);
        }
    }

    public final String O0(JSONObject res) {
        JSONObject jSONObjectOptJSONObject;
        String str;
        if (res == null || (jSONObjectOptJSONObject = res.optJSONObject("error")) == null) {
            return res == null ? "null_res" : "no_error";
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("code", -1);
        String strOptString = jSONObjectOptJSONObject.optString("message");
        if (strOptString == null) {
            strOptString = "";
        }
        if (strOptString.length() <= 180) {
            str = strOptString;
        } else {
            str = La.K.R1(strOptString, 180) + "…(len=" + strOptString.length() + ")";
        }
        return "code=" + iOptInt + " msgLen=" + strOptString.length() + " msg=" + str;
    }

    public final boolean P0(String sessionId) {
        Long lRemove = this.recentUserAbortAtMs.remove(sessionId);
        if (lRemove != null) {
            if (System.currentTimeMillis() - lRemove.longValue() < 15000) {
                return true;
            }
        }
        return false;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object Q(String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.Q(str, str2, interfaceC4014c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f6, code lost:
    
        if (r1 != r3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q0(java.lang.String r17, e9.InterfaceC4014c<? super java.lang.String> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.Q0(java.lang.String, e9.c):java.lang.Object");
    }

    public final com.stepos.agentframework.adapter.netcore.n Q1(String sessionId, String outboundId, com.stepos.agentframework.adapter.netcore.h listener) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        kotlin.jvm.internal.p.i(listener, "listener");
        if (!v1()) {
            return null;
        }
        String string = La.H.D1(sessionId).toString();
        String string2 = La.H.D1(outboundId).toString();
        if (string.length() == 0 || string2.length() == 0) {
            C4148a.u(TAG, "registerPendingActiveChat skip: empty sessionId/outboundId", false, 4, null);
            return null;
        }
        ActiveChat activeChatG1 = g1(string2);
        if (activeChatG1 != null) {
            C4148a.k(TAG, "registerPendingActiveChat idempotent outboundId=" + string2 + " chatId=" + activeChatG1.getChatId(), false, 4, null);
            return activeChatG1.getCancelHandle();
        }
        String string3 = UUID.randomUUID().toString();
        kotlin.jvm.internal.p.h(string3, "toString(...)");
        String strT = La.D.T(string3, O6.l.DATE_SEPARATOR, "", false, 4, null);
        C0918n c0918n = new C0918n(null, null, string, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554427, null);
        AgentBusCancelHandle agentBusCancelHandle = new AgentBusCancelHandle(this, string, strT);
        ActiveChat activeChat = new ActiveChat(strT, c0918n, listener, agentBusCancelHandle, null, null, string2, null, null, null, null, null, null, null, null, 0L, null, null, null, null, 1048496, null);
        N1(string, activeChat);
        if (!v1()) {
            S1(this, string, strT, false, 4, null);
            return null;
        }
        C4148a.k(TAG, "registerPendingActiveChat ok sessionId=" + string + " chatId=" + strT + " outboundId=" + string2, false, 4, null);
        listener.f(c0918n);
        b1(activeChat, true, null, null);
        return agentBusCancelHandle;
    }

    public final void R0(String sessionId, Message message) {
        if (v1()) {
            com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
            if (tVar != null) {
                Iterator it = q.z(q.INSTANCE, message, new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null), sessionId, new N(), false, 8, null).iterator();
                while (it.hasNext()) {
                    tVar.a((C0917m) it.next(), getType());
                }
            } else {
                C4148a.u(TAG, "moderation dropped: no pushMessageListener sessionId=" + sessionId, false, 4, null);
            }
        }
    }

    public final void R1(String sessionId, String chatId, boolean discardLateFrames) {
        String outboundId;
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap = this.activeChats.get(sessionId);
        ActiveChat activeChatRemove = concurrentHashMap != null ? concurrentHashMap.remove(chatId) : null;
        if (activeChatRemove != null) {
            K k10 = this.staleReplayGuard;
            String strB = C0914j.b(activeChatRemove.getRequest().j());
            if (strB == null) {
                strB = "";
            }
            String lastInboundCumulative = activeChatRemove.getLastInboundCumulative();
            if (lastInboundCumulative.length() == 0) {
                lastInboundCumulative = activeChatRemove.getDispatchedText().toString();
                kotlin.jvm.internal.p.h(lastInboundCumulative, "toString(...)");
            }
            k10.e(sessionId, strB, lastInboundCumulative);
        }
        if (discardLateFrames && activeChatRemove != null && (outboundId = activeChatRemove.getOutboundId()) != null) {
            if (outboundId.length() <= 0) {
                outboundId = null;
            }
            if (outboundId != null) {
                this.completedOutboundIds.add(outboundId);
            }
        }
        if (concurrentHashMap != null && concurrentHashMap.isEmpty()) {
            this.activeChats.remove(sessionId, concurrentHashMap);
        }
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap2 = this.activeChats.get(sessionId);
        C4148a.d(TAG, "active chat removed sessionId=" + sessionId + " chatId=" + chatId + " discardLate=" + discardLateFrames + " remaining=" + (concurrentHashMap2 != null ? concurrentHashMap2.size() : 0), false, 4, null);
    }

    public final void S0(String sessionId, Message message) {
        if (v1()) {
            com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
            if (tVar != null) {
                tVar.a(q.INSTANCE.F(message, new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null), sessionId), getType());
                return;
            }
            C4148a.u(TAG, "privacyBlocked dropped: no pushMessageListener sessionId=" + sessionId, false, 4, null);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object T(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Collection<ActiveChat> collectionValues;
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap = this.activeChats.get(str);
        List listM1 = (concurrentHashMap == null || (collectionValues = concurrentHashMap.values()) == null) ? null : Z8.F.m1(collectionValues);
        if (listM1 == null) {
            listM1 = C1173v.m();
        }
        if (listM1.isEmpty()) {
            return Y8.t.f7040a;
        }
        C4148a.k(TAG, "abortSession sessionId=" + str + " reason=" + str2 + " count=" + listM1.size(), false, 4, null);
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((ActiveChat) it.next()).getCancelHandle().cancel(str2);
        }
        return Y8.t.f7040a;
    }

    public final String T0(Message message, String str) {
        int iB = C1835k.b(message);
        String hexString = Integer.toHexString(iB);
        synchronized (this.inboundAnchors) {
            try {
                Integer num = this.inboundAnchors.get(str);
                if (num != null && num.intValue() == iB) {
                    int length = message.getContent().length();
                    String delta = message.getDelta();
                    return Const.STR_MART_WELL + hexString + " len=" + length + " deltaLen=" + (delta != null ? delta.length() : 0);
                }
                this.inboundAnchors.put(str, Integer.valueOf(iB));
                if (this.inboundAnchors.size() > 16) {
                    Iterator<String> it = this.inboundAnchors.keySet().iterator();
                    it.next();
                    it.remove();
                }
                Y8.t tVar = Y8.t.f7040a;
                Role role = message.getRole();
                String replyTo = message.getReplyTo();
                int length2 = message.getContent().length();
                String delta2 = message.getDelta();
                return Const.STR_MART_WELL + hexString + " FULL role=" + role + " replyTo=" + replyTo + " contentLen=" + length2 + " deltaLen=" + (delta2 != null ? delta2.length() : 0) + " tools(" + message.g().size() + ")=[" + C1835k.e(message, 0, 1, null) + "] att=" + message.a().size() + " streaming=" + message.d().get("streaming") + " runId=" + message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void T1(ActiveChat active, String lookupSessionId) {
        kotlinx.coroutines.g andSet = active.m().getAndSet(C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$scheduleDisconnectTerminalFallback$job$1(active, this, lookupSessionId, null), 3, null));
        if (andSet != null) {
            kotlinx.coroutines.g.Y0(andSet, null, 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0a0a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0b44  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0d6c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(java.lang.String r35, a4.Message r36) {
        /*
            Method dump skipped, instructions count: 3725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.U0(java.lang.String, a4.w):void");
    }

    public final void U1(ActiveChat active, String lookupSessionId) {
        kotlinx.coroutines.g andSet = active.m().getAndSet(C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$scheduleEmptyTerminalFallback$job$1(active, this, lookupSessionId, null), 3, null));
        if (andSet != null) {
            kotlinx.coroutines.g.Y0(andSet, null, 1, null);
        }
    }

    public final void V1(ActiveChat active, String lookupSessionId, long graceMs) {
        kotlinx.coroutines.g andSet = active.m().getAndSet(C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$scheduleStepTerminalFallback$job$1(graceMs, active, this, lookupSessionId, null), 3, null));
        if (andSet != null) {
            kotlinx.coroutines.g.Y0(andSet, null, 1, null);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object W(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objL2 = l2("renameSession", new AgentBusCoreAgentClient$renameSession$2(str, str2, null), interfaceC4014c);
        return objL2 == C4063a.g() ? objL2 : Y8.t.f7040a;
    }

    public final void W0(TaskEventPayload event) {
        Object objB;
        if (v1()) {
            C4148a.k(TAG, "dispatchTaskEvent type=" + event.getEventType() + " taskId=" + event.g() + " seq=" + event.getSeq(), false, 4, null);
            if (v.INSTANCE.a()) {
                C4148a.k(TAG, "VERBOSE " + ((Object) ("taskEvent type=" + event.getEventType() + " seq=" + event.getSeq() + " ts=" + event.getTs() + " sessionKey=" + event.getSessionKey() + " listeners=" + b2().size() + " task=" + event.getTask())), false, 4, null);
            }
            if (La.H.x0(event.g())) {
                C4148a.u(TAG, "ignore task event without taskId type=" + event.getEventType() + " seq=" + event.getSeq(), false, 4, null);
                return;
            }
            List<com.stepos.agentframework.adapter.netcore.B> listB2 = b2();
            i2(listB2.size());
            for (com.stepos.agentframework.adapter.netcore.B b10 : listB2) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    b10.a(event);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.u(TAG, "task listener failed: " + thE.getMessage(), false, 4, null);
                }
            }
        }
    }

    public final void W1(com.stepos.agentframework.adapter.netcore.t listener) {
        if (v1()) {
            this.pushMessageListener = listener;
            C4148a.k(TAG, "setPushMessageCallback: " + (listener != null), false, 4, null);
        }
    }

    public final void X0(ClawChannelAgentBusBinding bus) {
        boolean zAdd;
        Object objB;
        if (bus == null) {
            return;
        }
        Set<ClawChannelAgentBusBinding> stoppedBindings = this.stoppedBindings;
        kotlin.jvm.internal.p.h(stoppedBindings, "stoppedBindings");
        synchronized (stoppedBindings) {
            zAdd = this.stoppedBindings.add(bus);
        }
        if (zAdd) {
            try {
                Result.Companion companion = Result.INSTANCE;
                bus.R();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.d(TAG, "disposeBinding stop failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final void X1(p9.p<? super String, ? super String, Boolean> pVar) {
        this.serverInitiatedRoundAdopter = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r13 == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
    
        if (r13 != r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(java.lang.String r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.Y0(java.lang.String, e9.c):java.lang.Object");
    }

    public final void Y1(ClawChannelAgentBusBinding bus) {
        if (v1()) {
            kotlinx.coroutines.g gVar = this.customEventsJob;
            if (gVar == null || !gVar.b()) {
                this.customEventsJob = C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$startCustomEventsCollector$1(bus, this, null), 3, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object Z(java.lang.String r5, java.lang.String r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.C4849c.b(r7)
            goto L59
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r7)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$2 r7 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$writeCoreFile$2
            r2 = 0
            r7.<init>(r5, r6, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            r0.label = r3
            java.lang.String r5 = "writeCoreFile"
            java.lang.Object r7 = r4.l2(r5, r7, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r7, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.Z(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:29:0x0073, B:35:0x0086], limit reached: 78 */
    /* JADX WARN: Path cross not found for [B:35:0x0086, B:29:0x0073], limit reached: 78 */
    /* JADX WARN: Path cross not found for [B:42:0x009b, B:45:0x00aa], limit reached: 78 */
    /* JADX WARN: Path cross not found for [B:47:0x00af, B:51:0x00bc], limit reached: 78 */
    /* JADX WARN: Path cross not found for [B:61:0x010b, B:64:0x0116], limit reached: 78 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: Exception -> 0x0039, CancellationException -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x003c, blocks: (B:12:0x0035, B:29:0x0073, B:31:0x0079, B:33:0x0081, B:39:0x008f, B:42:0x009b, B:44:0x00a1, B:47:0x00af, B:49:0x00b5, B:22:0x0050), top: B:78:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073 A[Catch: Exception -> 0x0039, CancellationException -> 0x003c, TRY_ENTER, TryCatch #0 {CancellationException -> 0x003c, blocks: (B:12:0x0035, B:29:0x0073, B:31:0x0079, B:33:0x0081, B:39:0x008f, B:42:0x009b, B:44:0x00a1, B:47:0x00af, B:49:0x00b5, B:22:0x0050), top: B:78:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f A[Catch: Exception -> 0x0039, CancellationException -> 0x003c, TRY_ENTER, TryCatch #0 {CancellationException -> 0x003c, blocks: (B:12:0x0035, B:29:0x0073, B:31:0x0079, B:33:0x0081, B:39:0x008f, B:42:0x009b, B:44:0x00a1, B:47:0x00af, B:49:0x00b5, B:22:0x0050), top: B:78:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006e -> B:81:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z0(e9.InterfaceC4014c<? super java.lang.String> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.Z0(e9.c):java.lang.Object");
    }

    public final void Z1(ClawChannelAgentBusBinding bus) {
        if (v1()) {
            kotlinx.coroutines.g gVar = this.stepClawEventsJob;
            if (gVar == null || !gVar.b()) {
                this.stepClawEventsJob = C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$startStepClawEventsCollector$1(bus, this, null), 3, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(kotlin.TaskInteractRequest r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            K6.H r4 = (kotlin.TaskInteractRequest) r4
            kotlin.C4849c.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$2 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$interactTask$2
            r2 = 0
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r5 = "interactTask"
            java.lang.Object r6 = r4.l2(r5, r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r6, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.a(K6.H, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        if (r15 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0093 -> B:28:0x0096). Please report as a decompilation issue!!! */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a0(java.lang.String r14, e9.InterfaceC4014c<? super java.lang.Boolean> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.a0(java.lang.String, e9.c):java.lang.Object");
    }

    public final String a1(StepClawEvent stepClawEvent) {
        if (STEP_CLAW_HANDLED_STREAMS.contains(stepClawEvent.getName())) {
            return stepClawEvent.getName();
        }
        Object obj = stepClawEvent.b().get("stream");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            String str2 = La.H.x0(str) ? null : str;
            if (str2 != null) {
                return str2;
            }
        }
        return stepClawEvent.getName();
    }

    public final void a2(ClawChannelAgentBusBinding bus) {
        if (v1()) {
            Z1(bus);
            Y1(bus);
            kotlinx.coroutines.g gVar = this.taskEventsJob;
            if (gVar == null || !gVar.b()) {
                this.taskEventsJob = C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$startTaskEventsCollector$1(bus, this, null), 3, null);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0092: MOVE (r9 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:19:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0205 A[Catch: all -> 0x0091, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0091, blocks: (B:16:0x0089, B:91:0x01c4, B:107:0x0205), top: B:124:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022c A[Catch: all -> 0x0232, TryCatch #3 {all -> 0x0232, blocks: (B:112:0x0224, B:114:0x022c, B:117:0x0234), top: B:127:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133 A[Catch: all -> 0x0163, TryCatch #4 {all -> 0x0163, blocks: (B:54:0x012b, B:57:0x0133, B:60:0x013f, B:62:0x015a), top: B:129:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ab A[Catch: all -> 0x01b1, TryCatch #2 {all -> 0x01b1, blocks: (B:77:0x01a3, B:79:0x01ab, B:82:0x01b3), top: B:125:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f3 A[Catch: all -> 0x01f9, TryCatch #7 {all -> 0x01f9, blocks: (B:97:0x01eb, B:99:0x01f3, B:102:0x01fb), top: B:134:0x01eb }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r17, e9.InterfaceC4014c<? super java.lang.String> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.b(java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void b0(boolean z10) {
        super.b0(z10);
    }

    public final void b1(ActiveChat active, boolean success, Integer code, String message) {
        if (v1() && active.getSendAckEmitted().compareAndSet(false, true)) {
            active.getListener().c(active.getRequest(), success, code, message);
        }
    }

    public final List<com.stepos.agentframework.adapter.netcore.B> b2() {
        List<com.stepos.agentframework.adapter.netcore.B> listM1;
        Map<com.stepos.agentframework.adapter.netcore.B, Boolean> taskEventListeners = this.taskEventListeners;
        kotlin.jvm.internal.p.h(taskEventListeners, "taskEventListeners");
        synchronized (taskEventListeners) {
            listM1 = Z8.F.m1(this.taskEventListeners.keySet());
        }
        return listM1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0138, code lost:
    
        if (r1 != r3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, e9.InterfaceC4014c<? super java.lang.Boolean> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r0 == r3) goto L119;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0152 A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #4 {all -> 0x012c, blocks: (B:78:0x0118, B:80:0x0120, B:83:0x0127, B:86:0x0130, B:87:0x0135, B:94:0x0141, B:95:0x0142, B:99:0x014b, B:102:0x0152, B:103:0x0157, B:104:0x0169, B:110:0x0179, B:112:0x017c, B:117:0x018b, B:156:0x01fd, B:157:0x01fe, B:96:0x0148, B:97:0x0149, B:69:0x00f3, B:72:0x00fc, B:74:0x0100, B:88:0x0136, B:90:0x013a, B:93:0x013f), top: B:200:0x00f3, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ab A[Catch: all -> 0x0047, Exception -> 0x004a, CancellationException -> 0x004d, TryCatch #2 {all -> 0x0047, blocks: (B:15:0x0042, B:121:0x01a3, B:123:0x01ab, B:125:0x01b1, B:126:0x01b3, B:133:0x01bf, B:134:0x01c0, B:136:0x01c6, B:137:0x01c7, B:138:0x01c8, B:139:0x01cf, B:140:0x01d0, B:141:0x01d2, B:147:0x01e4, B:149:0x01e7, B:150:0x01eb, B:153:0x01fa, B:154:0x01fb, B:158:0x01ff, B:159:0x021e, B:169:0x0234, B:170:0x0235, B:171:0x023e, B:172:0x023f, B:173:0x0240, B:174:0x025c, B:184:0x0272, B:185:0x0273, B:190:0x0286, B:191:0x0287, B:192:0x0288, B:175:0x025d, B:177:0x0263, B:180:0x0268, B:182:0x026e, B:183:0x0270, B:160:0x021f, B:162:0x0225, B:165:0x022a, B:167:0x0230, B:168:0x0232), top: B:197:0x002c, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d0 A[Catch: all -> 0x0047, Exception -> 0x004a, CancellationException -> 0x004d, TryCatch #2 {all -> 0x0047, blocks: (B:15:0x0042, B:121:0x01a3, B:123:0x01ab, B:125:0x01b1, B:126:0x01b3, B:133:0x01bf, B:134:0x01c0, B:136:0x01c6, B:137:0x01c7, B:138:0x01c8, B:139:0x01cf, B:140:0x01d0, B:141:0x01d2, B:147:0x01e4, B:149:0x01e7, B:150:0x01eb, B:153:0x01fa, B:154:0x01fb, B:158:0x01ff, B:159:0x021e, B:169:0x0234, B:170:0x0235, B:171:0x023e, B:172:0x023f, B:173:0x0240, B:174:0x025c, B:184:0x0272, B:185:0x0273, B:190:0x0286, B:191:0x0287, B:192:0x0288, B:175:0x025d, B:177:0x0263, B:180:0x0268, B:182:0x026e, B:183:0x0270, B:160:0x021f, B:162:0x0225, B:165:0x022a, B:167:0x0230, B:168:0x0232), top: B:197:0x002c, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc A[Catch: all -> 0x012c, TryCatch #4 {all -> 0x012c, blocks: (B:78:0x0118, B:80:0x0120, B:83:0x0127, B:86:0x0130, B:87:0x0135, B:94:0x0141, B:95:0x0142, B:99:0x014b, B:102:0x0152, B:103:0x0157, B:104:0x0169, B:110:0x0179, B:112:0x017c, B:117:0x018b, B:156:0x01fd, B:157:0x01fe, B:96:0x0148, B:97:0x0149, B:69:0x00f3, B:72:0x00fc, B:74:0x0100, B:88:0x0136, B:90:0x013a, B:93:0x013f), top: B:200:0x00f3, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120 A[Catch: all -> 0x012c, TryCatch #4 {all -> 0x012c, blocks: (B:78:0x0118, B:80:0x0120, B:83:0x0127, B:86:0x0130, B:87:0x0135, B:94:0x0141, B:95:0x0142, B:99:0x014b, B:102:0x0152, B:103:0x0157, B:104:0x0169, B:110:0x0179, B:112:0x017c, B:117:0x018b, B:156:0x01fd, B:157:0x01fe, B:96:0x0148, B:97:0x0149, B:69:0x00f3, B:72:0x00fc, B:74:0x0100, B:88:0x0136, B:90:0x013a, B:93:0x013f), top: B:200:0x00f3, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0130 A[Catch: all -> 0x012c, TryCatch #4 {all -> 0x012c, blocks: (B:78:0x0118, B:80:0x0120, B:83:0x0127, B:86:0x0130, B:87:0x0135, B:94:0x0141, B:95:0x0142, B:99:0x014b, B:102:0x0152, B:103:0x0157, B:104:0x0169, B:110:0x0179, B:112:0x017c, B:117:0x018b, B:156:0x01fd, B:157:0x01fe, B:96:0x0148, B:97:0x0149, B:69:0x00f3, B:72:0x00fc, B:74:0x0100, B:88:0x0136, B:90:0x013a, B:93:0x013f), top: B:200:0x00f3, inners: #11 }] */
    /* JADX WARN: Type inference failed for: r0v8, types: [eb.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v4, types: [T, com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$ensureBinding$1, e9.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c1(e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.c1(e9.c):java.lang.Object");
    }

    public final Map<String, Object> c2(StepClawEvent ev) {
        Object obj = ev.b().get("data");
        Map<String, Object> map = obj instanceof Map ? (Map) obj : null;
        return map == null ? ev.b() : map;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlin.TranscriptAppendRequest r20, e9.InterfaceC4014c<? super kotlin.TranscriptAppendResult> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.d(K6.J, e9.c):java.lang.Object");
    }

    public final void d2() {
        kotlinx.coroutines.g gVar = this.taskEventsJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.taskEventsJob = null;
        kotlinx.coroutines.g gVar2 = this.stepClawEventsJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.stepClawEventsJob = null;
        kotlinx.coroutines.g gVar3 = this.uiActionEventsJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.uiActionEventsJob = null;
        kotlinx.coroutines.g gVar4 = this.customEventsJob;
        if (gVar4 != null) {
            kotlinx.coroutines.g.Y0(gVar4, null, 1, null);
        }
        this.customEventsJob = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(kotlin.TaskCancelRequest r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            K6.F r4 = (kotlin.TaskCancelRequest) r4
            kotlin.C4849c.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$2 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$cancelTask$2
            r2 = 0
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r5 = "cancelTask"
            java.lang.Object r6 = r4.l2(r5, r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r6, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.e(K6.F, e9.c):java.lang.Object");
    }

    public final void e1(String sessionId, Message message) {
        Object objB;
        if (v1()) {
            Pair<String, List<ActiveChat>> pairC1 = C1(sessionId, message);
            String strA = pairC1.a();
            for (ActiveChat activeChat : pairC1.b()) {
                kotlinx.coroutines.g andSet = activeChat.m().getAndSet(null);
                if (andSet != null) {
                    kotlinx.coroutines.g.Y0(andSet, null, 1, null);
                }
                if (!activeChat.getCancelHandle().getCancelled() && !activeChat.getFinished().getAndSet(true)) {
                    activeChat.getStreamAccumulator().c();
                    activeChat.getCancelHandle().c();
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        activeChat.getListener().j(activeChat.getRequest());
                        objB = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB);
                    if (thE != null) {
                        C4148a.d(TAG, "moderation onClosed failed: " + thE.getMessage(), false, 4, null);
                    }
                }
                S1(this, strA, activeChat.getChatId(), false, 4, null);
            }
        }
    }

    public final Map<String, Object> e2(TranscriptEvent transcriptEvent) {
        Map mapC = Z8.Q.c();
        mapC.put("clientEventId", transcriptEvent.getClientEventId());
        mapC.put("type", transcriptEvent.getType());
        String timestampMs = transcriptEvent.getTimestampMs();
        if (timestampMs != null) {
            mapC.put("timestampMs", timestampMs);
        }
        String text = transcriptEvent.getText();
        if (text != null) {
            mapC.put("text", text);
        }
        String toolCallId = transcriptEvent.getToolCallId();
        if (toolCallId != null) {
            mapC.put("toolCallId", toolCallId);
        }
        String toolName = transcriptEvent.getToolName();
        if (toolName != null) {
            mapC.put("toolName", toolName);
        }
        Map<String, Object> mapA = transcriptEvent.a();
        if (mapA != null) {
            mapC.put("arguments", mapA);
        }
        Boolean isError = transcriptEvent.getIsError();
        if (isError != null) {
            mapC.put("isError", isError);
        }
        Map<String, Object> mapC2 = transcriptEvent.c();
        if (mapC2 != null) {
            mapC.put("details", mapC2);
        }
        return Z8.Q.b(mapC);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(kotlin.TaskDeleteRequest r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            K6.G r4 = (kotlin.TaskDeleteRequest) r4
            kotlin.C4849c.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$2 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$deleteTask$2
            r2 = 0
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r5 = "deleteTask"
            java.lang.Object r6 = r4.l2(r5, r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r6, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.f(K6.G, e9.c):java.lang.Object");
    }

    public final void f1(String sessionId, String runId) {
        Pair pairI1 = i1(this, sessionId, runId, false, 4, null);
        String str = (String) pairI1.a();
        ActiveChat activeChat = (ActiveChat) pairI1.b();
        if (activeChat == null) {
            C4148a.d(TAG, "turn_done: no active chat sessionId=" + sessionId + " runId=" + La.K.R1(runId, 32), false, 4, null);
            return;
        }
        if (activeChat.getFinished().get() || activeChat.getCancelHandle().getCancelled()) {
            return;
        }
        TurnDoneCloseAction turnDoneCloseActionA = AgentBusChannelOpsKt.A(activeChat.getHasDispatchedReply().get(), activeChat.getTerminalFrameSeen().get(), activeChat.getHasInflightTool().get());
        if (AgentBusChannelOpsKt.H(turnDoneCloseActionA)) {
            activeChat.getTurnDone().set(true);
        }
        int i10 = c.$EnumSwitchMapping$0[turnDoneCloseActionA.ordinal()];
        if (i10 == 1) {
            C4148a.k(TAG, "turn_done: no reply yet, ignore as round-end sessionId=" + str + " runId=" + La.K.R1(runId, 32) + " chatId=" + activeChat.getChatId(), false, 4, null);
            return;
        }
        if (i10 == 2) {
            kotlinx.coroutines.g andSet = activeChat.m().getAndSet(null);
            if (andSet != null) {
                kotlinx.coroutines.g.Y0(andSet, null, 1, null);
            }
            C4148a.k(TAG, "turn_done → close now (terminal frame seen, no inflight tool) sessionId=" + str + " runId=" + La.K.R1(runId, 32) + " chatId=" + activeChat.getChatId(), false, 4, null);
            activeChat.getStreamAccumulator().c();
            activeChat.getCancelHandle().c();
            activeChat.getListener().j(activeChat.getRequest());
            S1(this, str, activeChat.getChatId(), false, 4, null);
            return;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        long jH2 = h2(activeChat);
        C4148a.k(TAG, "turn_done: no terminal frame / tool inflight, (re)arm idle close grace=" + jH2 + "ms inflightTool=" + activeChat.getHasInflightTool().get() + " sessionId=" + str + " runId=" + La.K.R1(runId, 32) + " chatId=" + activeChat.getChatId(), false, 4, null);
        V1(activeChat, str, jH2);
    }

    public final boolean f2(String sessionId, String outboundId) {
        if (g1(outboundId) != null) {
            return true;
        }
        p9.p<? super String, ? super String, Boolean> pVar = this.serverInitiatedRoundAdopter;
        if (pVar == null) {
            C4148a.u(TAG, "tryAdoptServerInitiatedRound: no adopter outboundId=" + outboundId, false, 4, null);
            return false;
        }
        try {
            boolean zBooleanValue = pVar.invoke(sessionId, outboundId).booleanValue();
            C4148a.k(TAG, "tryAdoptServerInitiatedRound result=" + zBooleanValue + " sessionId=" + sessionId + " outboundId=" + outboundId, false, 4, null);
            if (zBooleanValue) {
                if (g1(outboundId) != null) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            C4148a.g(TAG, "tryAdoptServerInitiatedRound failed: " + e10.getMessage(), e10, false, 8, null);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(kotlin.TaskBatchDeleteRequest r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            K6.E r4 = (kotlin.TaskBatchDeleteRequest) r4
            kotlin.C4849c.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$2 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$batchDeleteTasks$2
            r2 = 0
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r5 = "batchDeleteTasks"
            java.lang.Object r6 = r4.l2(r5, r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r6, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.g(K6.E, e9.c):java.lang.Object");
    }

    public final ActiveChat g1(String outboundId) {
        if (outboundId.length() == 0) {
            return null;
        }
        for (ConcurrentHashMap<String, ActiveChat> concurrentHashMap : this.activeChats.values()) {
            kotlin.jvm.internal.p.h(concurrentHashMap, "next(...)");
            for (ActiveChat activeChat : concurrentHashMap.values()) {
                kotlin.jvm.internal.p.h(activeChat, "next(...)");
                ActiveChat activeChat2 = activeChat;
                if (kotlin.jvm.internal.p.d(activeChat2.getOutboundId(), outboundId) && !activeChat2.getCancelHandle().getCancelled() && !activeChat2.getFinished().get()) {
                    return activeChat2;
                }
            }
        }
        return null;
    }

    public final void g2(String sessionId, Message message) {
        String str;
        N nPutIfAbsent;
        if (v1()) {
            q qVar = q.INSTANCE;
            if (qVar.q(message)) {
                Object obj = message.d().get("disconnectReason");
                String str2 = obj instanceof String ? (String) obj : null;
                if (str2 == null) {
                    str2 = "";
                }
                com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
                if (tVar == null) {
                    C4148a.k(TAG, "push disconnect finalize dropped: no listener sessionId=" + sessionId + " reason=" + str2, false, 4, null);
                    return;
                }
                C0917m c0917mX = qVar.x(message, new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null), sessionId);
                String messageId = c0917mX.getMessageId();
                if (messageId == null || La.H.x0(messageId)) {
                    C4148a.u(TAG, "push disconnect finalize dropped: no messageId sessionId=" + sessionId + " reason=" + str2, false, 4, null);
                    return;
                }
                C4148a.k(TAG, "push disconnect finalize without error body sessionId=" + sessionId + " messageId=" + c0917mX.getMessageId() + " reason=" + str2, false, 4, null);
                tVar.a(c0917mX, getType());
                return;
            }
            C4148a.d(TAG, "try Handle As Push Message: sessionId=" + sessionId + " message=" + T0(message, sessionId) + ", replyTo:" + message.getReplyTo() + ", handle as a push message", false, 4, null);
            boolean zR = qVar.r(message);
            if (v.INSTANCE.a()) {
                String replyTo = message.getReplyTo();
                boolean z10 = this.pushMessageListener != null;
                C4148a.k(TAG, "VERBOSE " + ((Object) ("push enter sessionId=" + sessionId + " replyTo=" + replyTo + " approval=" + zR + " hasListener=" + z10 + " " + C1835k.c(message))), false, 4, null);
            }
            String replyTo2 = message.getReplyTo();
            if (replyTo2 != null && !La.H.x0(replyTo2) && !kotlin.jvm.internal.p.d(message.getReplyTo(), "null") && !zR) {
                C4148a.k(TAG, "skip push: replyTo=" + message.getReplyTo() + " terminal=" + AgentBusChannelOpsKt.v(message) + " approval=" + zR, false, 4, null);
                return;
            }
            Role role = message.getRole();
            int length = message.getContent().length();
            String delta = message.getDelta();
            C4148a.k(TAG, "handlePushMessage: role=" + role + " contentLen=" + length + " deltaLen=" + (delta != null ? delta.length() : 0), false, 4, null);
            try {
                com.stepos.agentframework.adapter.netcore.t tVar2 = this.pushMessageListener;
                if (tVar2 == null) {
                    C4148a.k(TAG, "handlePushMessage: no pushMessageListener set, message not handled", false, 4, null);
                    return;
                }
                C4148a.k(TAG, "handlePushMessage: notifying pushMessageListener", false, 4, null);
                ConcurrentHashMap<String, N> concurrentHashMap = this.pushToolTrackers;
                N n10 = concurrentHashMap.get(sessionId);
                if (n10 == null && (nPutIfAbsent = concurrentHashMap.putIfAbsent(sessionId, (n10 = new N()))) != null) {
                    n10 = nPutIfAbsent;
                }
                N n11 = n10;
                C0918n c0918n = new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null);
                kotlin.jvm.internal.p.f(n11);
                String str3 = " terminal=";
                for (C0917m c0917m : q.z(qVar, message, c0918n, sessionId, n11, false, 8, null)) {
                    C4148a.k(TAG, "notifying pushMessageListener: " + c0917m.getAnswerType(), false, 4, null);
                    if (v.INSTANCE.a()) {
                        String answerType = c0917m.getAnswerType();
                        boolean zV = AgentBusChannelOpsKt.v(message);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("push reply sessionId=");
                        sb2.append(sessionId);
                        sb2.append(" answerType=");
                        sb2.append(answerType);
                        str = str3;
                        sb2.append(str);
                        sb2.append(zV);
                        sb2.append(" approval=");
                        sb2.append(zR);
                        sb2.append(" reply=");
                        sb2.append(c0917m);
                        C4148a.k(TAG, "VERBOSE " + ((Object) sb2.toString()), false, 4, null);
                    } else {
                        str = str3;
                    }
                    if (kotlin.jvm.internal.p.d(c0917m.getAnswerType(), "function_call") || kotlin.jvm.internal.p.d(c0917m.getAnswerType(), "tool_response")) {
                        tVar2.b(c0917m, getType());
                    } else if (AgentBusChannelOpsKt.v(message) || zR) {
                        C4148a.d(TAG, "enter push message: sessionId=" + sessionId + " is terminal, message=" + T0(message, sessionId), false, 4, null);
                        tVar2.a(c0917m, getType());
                    }
                    str3 = str;
                }
                if (C1832h.c(message)) {
                    this.pushToolTrackers.remove(sessionId);
                }
                Y8.t tVar3 = Y8.t.f7040a;
            } catch (Exception e10) {
                C4148a.k(TAG, "Failed to handle push message: " + e10.getMessage(), false, 4, null);
            }
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public boolean h() {
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.binding;
        return clawChannelAgentBusBinding != null && clawChannelAgentBusBinding.C();
    }

    public final Pair<String, ActiveChat> h1(String sessionId, String runId, boolean allowUnboundFallback) {
        List listM;
        Collection<ActiveChat> collectionValues;
        Object next;
        Collection<ActiveChat> collectionValues2;
        Object next2;
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap = this.activeChats.get(sessionId);
        if (concurrentHashMap != null && (collectionValues2 = concurrentHashMap.values()) != null) {
            Iterator<T> it = collectionValues2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                ActiveChat activeChat = (ActiveChat) next2;
                if (kotlin.jvm.internal.p.d(activeChat.o().get(), runId) && !activeChat.getCancelHandle().getCancelled()) {
                    break;
                }
            }
            ActiveChat activeChat2 = (ActiveChat) next2;
            if (activeChat2 != null) {
                return Y8.j.a(sessionId, activeChat2);
            }
        }
        for (Map.Entry<String, ConcurrentHashMap<String, ActiveChat>> entry : this.activeChats.entrySet()) {
            String key = entry.getKey();
            Collection<ActiveChat> collectionValues3 = entry.getValue().values();
            kotlin.jvm.internal.p.h(collectionValues3, "<get-values>(...)");
            Iterator<T> it2 = collectionValues3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                ActiveChat activeChat3 = (ActiveChat) next;
                if (kotlin.jvm.internal.p.d(activeChat3.o().get(), runId) && !activeChat3.getCancelHandle().getCancelled()) {
                    break;
                }
            }
            ActiveChat activeChat4 = (ActiveChat) next;
            if (activeChat4 != null) {
                return Y8.j.a(key, activeChat4);
            }
        }
        if (!allowUnboundFallback) {
            return Y8.j.a(sessionId, null);
        }
        ConcurrentHashMap<String, ActiveChat> concurrentHashMap2 = this.activeChats.get(sessionId);
        if (concurrentHashMap2 == null || (collectionValues = concurrentHashMap2.values()) == null) {
            listM = null;
        } else {
            listM = new ArrayList();
            for (Object obj : collectionValues) {
                ActiveChat activeChat5 = (ActiveChat) obj;
                if (!activeChat5.getCancelHandle().getCancelled() && AgentBusChannelOpsKt.g(activeChat5.o().get())) {
                    listM.add(obj);
                }
            }
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        return listM.size() == 1 ? Y8.j.a(sessionId, Z8.F.q0(listM)) : Y8.j.a(sessionId, null);
    }

    public final long h2(ActiveChat active) {
        if (active.getHasInflightTool().get()) {
            return 120000L;
        }
        return AgentBusChannelOpsKt.J(active.getDispatchedText().length() > 0);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return b("main", interfaceC4014c);
    }

    public final void i2(int count) {
        if (count <= 4 || count <= this.taskListenerHighWater) {
            return;
        }
        this.taskListenerHighWater = count;
        C4148a.u(TAG, "task listeners piling up: " + count + " — 宿主可能漏调 removeTaskEventListener,每条 task event 会 N× 扇出(历史事故:420 份 → 61.6 万排队协程 → MEM_EXCEPTION)", false, 4, null);
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0092: MOVE (r9 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:19:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fc A[Catch: all -> 0x0091, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0091, blocks: (B:16:0x0089, B:88:0x01bb, B:104:0x01fc), top: B:123:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0223 A[Catch: all -> 0x0229, TryCatch #7 {all -> 0x0229, blocks: (B:109:0x021b, B:111:0x0223, B:114:0x022b), top: B:129:0x021b }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[Catch: all -> 0x015a, TryCatch #8 {all -> 0x015a, blocks: (B:51:0x0122, B:54:0x012a, B:57:0x0136, B:59:0x0151), top: B:131:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0162 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a2 A[Catch: all -> 0x01a8, TryCatch #5 {all -> 0x01a8, blocks: (B:74:0x019a, B:76:0x01a2, B:79:0x01aa), top: B:125:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ea A[Catch: all -> 0x01f0, TryCatch #0 {all -> 0x01f0, blocks: (B:94:0x01e2, B:96:0x01ea, B:99:0x01f2), top: B:121:0x01e2 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r17, e9.InterfaceC4014c<? super java.lang.String> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.j(java.lang.String, e9.c):java.lang.Object");
    }

    public final Pair<String, ActiveChat> j1(String sessionId, Message message) {
        Object next;
        Collection<ActiveChat> collectionValues;
        Object next2;
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                ConcurrentHashMap<String, ActiveChat> concurrentHashMap = this.activeChats.get(sessionId);
                if (concurrentHashMap != null && (collectionValues = concurrentHashMap.values()) != null) {
                    Iterator<T> it = collectionValues.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        ActiveChat activeChat = (ActiveChat) next2;
                        kotlin.jvm.internal.p.f(activeChat);
                        if (k1(activeChat, str)) {
                            break;
                        }
                    }
                    ActiveChat activeChat2 = (ActiveChat) next2;
                    if (activeChat2 != null) {
                        return Y8.j.a(sessionId, activeChat2);
                    }
                }
                for (Map.Entry<String, ConcurrentHashMap<String, ActiveChat>> entry : this.activeChats.entrySet()) {
                    String key = entry.getKey();
                    Collection<ActiveChat> collectionValues2 = entry.getValue().values();
                    kotlin.jvm.internal.p.h(collectionValues2, "<get-values>(...)");
                    Iterator<T> it2 = collectionValues2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        ActiveChat activeChat3 = (ActiveChat) next;
                        kotlin.jvm.internal.p.f(activeChat3);
                        if (k1(activeChat3, str)) {
                            break;
                        }
                    }
                    ActiveChat activeChat4 = (ActiveChat) next;
                    if (activeChat4 != null) {
                        return Y8.j.a(key, activeChat4);
                    }
                }
            }
        }
        return null;
    }

    public final void j2(CustomEvent ev) {
        if (this.warnedUnhandledStreams.size() >= 32) {
            return;
        }
        if (this.warnedUnhandledStreams.add("custom:" + ev.getEvent())) {
            C4148a.u(TAG, "unhandled custom event='" + ev.getEvent() + "' stream='" + ev.b().get("stream") + "' payloadKeys=" + ev.b().keySet(), false, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r6, java.lang.String r7, java.util.List<java.lang.String> r8, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.InquiryAnswerResult> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)
            goto L63
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.C4849c.b(r9)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$2 r9 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$answerInquiry$2
            r9.<init>(r6, r7, r8, r4)
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$0 = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.L$1 = r6
            java.lang.Object r6 = g9.h.a(r8)
            r0.L$2 = r6
            r0.label = r3
            java.lang.String r6 = "answerInquiry"
            java.lang.Object r9 = r5.l2(r6, r9, r0)
            if (r9 != r1) goto L63
            return r1
        L63:
            com.stepos.agentframework.adapter.netcore.q r9 = (com.stepos.agentframework.adapter.netcore.InquiryAnswerResult) r9
            if (r9 != 0) goto L6f
            com.stepos.agentframework.adapter.netcore.q r5 = new com.stepos.agentframework.adapter.netcore.q
            r6 = 0
            r7 = 2
            r5.<init>(r6, r4, r7, r4)
            return r5
        L6f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.k(java.lang.String, java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    public final void k2(StepClawEvent ev, String stream) {
        if (this.warnedUnhandledStreams.size() < 32 && this.warnedUnhandledStreams.add(stream)) {
            C4148a.u(TAG, "unhandled stepClaw stream='" + stream + "' name='" + ev.getName() + "' sessionId=" + ev.getSessionId() + " payloadKeys=" + ev.b().keySet(), false, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(kotlin.TaskSyncRemoteRequest r10, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = "AgentBusCoreAgentClient"
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L40
            if (r2 != r6) goto L38
            long r1 = r0.J$0
            java.lang.Object r10 = r0.L$0
            K6.I r10 = (kotlin.TaskSyncRemoteRequest) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            goto L60
        L33:
            r9 = move-exception
            goto L95
        L35:
            r10 = move-exception
            goto Laf
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            kotlin.C4849c.b(r11)
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.String r11 = "syncTaskWithRemote"
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$result$1 r2 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$syncTaskWithRemote$result$1     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r2.<init>(r10, r4)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.Object r10 = g9.h.a(r10)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r0.L$0 = r10     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r0.J$0 = r7     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r0.label = r6     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.Object r11 = r9.l2(r11, r2, r0)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r1 = r7
        L60:
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            long r7 = r7 - r1
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r10.<init>()     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.String r0 = "syncTaskWithRemote cost:"
            r10.append(r0)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r10.append(r7)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.String r0 = ", result: "
            r10.append(r0)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            r10.append(r11)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            h8.C4148a.j(r3, r10, r6)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            if (r11 == 0) goto L8e
            int r10 = r11.length()     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            if (r10 != 0) goto L8c
            goto L8e
        L8c:
            r10 = r5
            goto L8f
        L8e:
            r10 = r6
        L8f:
            r10 = r10 ^ r6
            java.lang.Boolean r9 = g9.C4109a.a(r10)     // Catch: java.lang.Exception -> L33 java.util.concurrent.CancellationException -> L35
            return r9
        L95:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "syncTaskWithRemote error: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 4
            h8.C4148a.h(r3, r9, r5, r10, r4)
            java.lang.Boolean r9 = g9.C4109a.a(r5)
            return r9
        Laf:
            boolean r9 = r9.v1()
            if (r9 != 0) goto Lba
            java.lang.Boolean r9 = g9.C4109a.a(r5)
            return r9
        Lba:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.l(K6.I, e9.c):java.lang.Object");
    }

    public final void l1(StepClawEvent ev) {
        String runId = ev.getRunId();
        if (runId != null) {
            if (runId.length() <= 0) {
                runId = null;
            }
            if (runId != null) {
                String sessionId = ev.getSessionId();
                if (sessionId == null) {
                    sessionId = "";
                }
                String str = sessionId;
                M.CardPayload cardPayloadD = M.INSTANCE.d(ev.b());
                if (cardPayloadD == null) {
                    C4148a.u(TAG, "card event payload unusable, dropped runId=" + La.K.R1(runId, 32), false, 4, null);
                    return;
                }
                C4148a.k(TAG, "card event sessionId=" + str + " runId=" + La.K.R1(runId, 32) + " name=" + cardPayloadD.getName() + " resultLen=" + cardPayloadD.getResultJson().length(), false, 4, null);
                if (v.INSTANCE.a()) {
                    C4148a.k(TAG, "VERBOSE " + ((Object) ("card sessionId=" + str + " runId=" + runId + " name=" + cardPayloadD.getName() + " resultLen=" + cardPayloadD.getResultJson().length() + " rawPayload=" + ev.b())), false, 4, null);
                }
                ActiveChat activeChatB = h1(str, runId, false).b();
                if (activeChatB != null) {
                    activeChatB.getListener().h(activeChatB.getRequest(), runId, cardPayloadD.getName(), cardPayloadD.getResultJson());
                    return;
                }
                com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
                if (tVar == null) {
                    C4148a.u(TAG, "card dropped: no active chat & no pushMessageListener runId=" + La.K.R1(runId, 32), false, 4, null);
                    return;
                }
                C4148a.k(TAG, "card → push fallback sessionId=" + str + " runId=" + La.K.R1(runId, 32) + " name=" + cardPayloadD.getName(), false, 4, null);
                tVar.a(new C0917m(null, null, str, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, 5, false, null, 0, null, 0, null, 0, null, null, null, null, null, runId, runId, null, "card", null, null, null, null, null, null, null, null, null, cardPayloadD.getName(), cardPayloadD.getResultJson(), null, -1619197957, 5118, null), getType());
                return;
            }
        }
        C4148a.u(TAG, "card event without runId, dropped", false, 4, null);
    }

    public final <T> Object l2(String str, p9.p<? super ClawChannelAgentBusBinding, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super T> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new AgentBusCoreAgentClient$withBinding$2(this, str, pVar, null), interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return j("main", interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1(a4.CustomEvent r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getEvent()
            java.util.Map r1 = r10.b()
            boolean r0 = com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.w(r0, r1)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.util.Map r0 = r10.b()
            java.lang.String r1 = "runId"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L21
            java.lang.String r0 = (java.lang.String) r0
            goto L22
        L21:
            r0 = r2
        L22:
            if (r0 == 0) goto L74
            int r1 = r0.length()
            if (r1 <= 0) goto L2b
            goto L2c
        L2b:
            r0 = r2
        L2c:
            if (r0 != 0) goto L2f
            goto L74
        L2f:
            java.util.Map r1 = r10.b()
            java.lang.String r3 = "sessionKey"
            java.lang.Object r1 = r1.get(r3)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L40
            java.lang.String r1 = (java.lang.String) r1
            goto L41
        L40:
            r1 = r2
        L41:
            if (r1 == 0) goto L4d
            int r3 = r1.length()
            if (r3 <= 0) goto L4a
            goto L4b
        L4a:
            r1 = r2
        L4b:
            if (r1 != 0) goto L64
        L4d:
            java.util.Map r10 = r10.b()
            java.lang.String r1 = "sessionId"
            java.lang.Object r10 = r10.get(r1)
            boolean r1 = r10 instanceof java.lang.String
            if (r1 == 0) goto L5f
            java.lang.String r10 = (java.lang.String) r10
            r1 = r10
            goto L60
        L5f:
            r1 = r2
        L60:
            if (r1 != 0) goto L64
            java.lang.String r1 = ""
        L64:
            Ua.M r3 = r9.scope
            Ua.I r4 = r9.inboundSerial
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$handleCustomEvent$1 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$handleCustomEvent$1
            r6.<init>(r9, r1, r0, r2)
            r7 = 2
            r8 = 0
            r5 = 0
            Ua.C1056g.d(r3, r4, r5, r6, r7, r8)
            return
        L74:
            r9 = 0
            r10 = 4
            java.lang.String r0 = "AgentBusCoreAgentClient"
            java.lang.String r1 = "turn_done without runId, dropped"
            h8.C4148a.u(r0, r1, r9, r10, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.m1(a4.r):void");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void n(com.stepos.agentframework.adapter.netcore.B listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        if (v1()) {
            Map<com.stepos.agentframework.adapter.netcore.B, Boolean> taskEventListeners = this.taskEventListeners;
            kotlin.jvm.internal.p.h(taskEventListeners, "taskEventListeners");
            taskEventListeners.put(listener, Boolean.TRUE);
            C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$addTaskEventListener$1(this, null), 3, null);
        }
    }

    public final void n1(String sessionId, Message message) {
        String str;
        if (v1()) {
            Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 == null) {
                str2 = "";
            }
            Object obj2 = message.d().get("blockedAt");
            String string = obj2 != null ? obj2.toString() : null;
            if (string == null) {
                string = "";
            }
            if (str2.length() == 0) {
                String replyTo = message.getReplyTo();
                str = (replyTo != null ? replyTo : "") + ServerSentEventKt.COLON + string;
            } else {
                str = str2;
            }
            if (str.length() == 0 || !this.seenModerationKeys.add(str)) {
                C4148a.d(TAG, "moderation dedup sessionId=" + sessionId + " key=" + str, false, 4, null);
                return;
            }
            C4148a.k(TAG, "moderation dispatch sessionId=" + sessionId + " runId=" + La.K.R1(str2, 32) + " replyTo=" + message.getReplyTo(), false, 4, null);
            R0(sessionId, message);
            e1(sessionId, message);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object o(Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        if (uploadFileRequest.getFile() != null) {
            FileStorageUploadHelper fileStorageUploadHelper = FileStorageUploadHelper.INSTANCE;
            File file = uploadFileRequest.getFile();
            kotlin.jvm.internal.p.f(file);
            Object objL = fileStorageUploadHelper.l(context, file, sVar, interfaceC4014c);
            return objL == C4063a.g() ? objL : Y8.t.f7040a;
        }
        if (uploadFileRequest.getUri() == null) {
            throw new IllegalArgumentException("No file or uri provided");
        }
        FileStorageUploadHelper fileStorageUploadHelper2 = FileStorageUploadHelper.INSTANCE;
        Uri uri = uploadFileRequest.getUri();
        kotlin.jvm.internal.p.f(uri);
        Object objN = fileStorageUploadHelper2.n(context, uri, sVar, interfaceC4014c);
        return objN == C4063a.g() ? objN : Y8.t.f7040a;
    }

    public final void o1(String sessionId, Message message) {
        if (v1()) {
            Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
            String str = obj instanceof String ? (String) obj : null;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (str.length() == 0) {
                String replyTo = message.getReplyTo();
                if (replyTo != null) {
                    str2 = replyTo;
                }
            } else {
                str2 = str;
            }
            String str3 = "privacy:" + ((Object) str2);
            if (kotlin.jvm.internal.p.d(str3, "privacy:") || !this.seenModerationKeys.add(str3)) {
                C4148a.d(TAG, "privacyBlocked dedup sessionId=" + sessionId + " key=" + str3, false, 4, null);
                return;
            }
            C4148a.k(TAG, "privacyBlocked dispatch sessionId=" + sessionId + " runId=" + La.K.R1(str, 32) + " replyTo=" + message.getReplyTo(), false, 4, null);
            S0(sessionId, message);
            e1(sessionId, message);
        }
    }

    public final void p1(StepClawEvent ev) {
        String runId = ev.getRunId();
        if (runId != null) {
            String str = runId.length() > 0 ? runId : null;
            if (str != null) {
                String sessionId = ev.getSessionId();
                if (sessionId == null) {
                    sessionId = "";
                }
                List<ReferenceSource> listI1 = I1(ev.b());
                if (listI1 == null) {
                    C4148a.u(TAG, "reference event without items, dropped runId=" + La.K.R1(str, 32), false, 4, null);
                    return;
                }
                C4148a.k(TAG, "reference event sessionId=" + sessionId + " runId=" + La.K.R1(str, 32) + " size=" + listI1.size(), false, 4, null);
                if (v.INSTANCE.a()) {
                    C4148a.k(TAG, "VERBOSE " + ((Object) ("reference sessionId=" + sessionId + " runId=" + str + " size=" + listI1.size() + " items=" + listI1 + " rawPayload=" + ev.b())), false, 4, null);
                }
                ActiveChat activeChat = (ActiveChat) i1(this, sessionId, str, false, 4, null).b();
                if (activeChat != null) {
                    activeChat.getListener().e(activeChat.getRequest(), str, listI1);
                    return;
                }
                com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
                if (tVar == null) {
                    C4148a.u(TAG, "reference dropped: no active chat & no pushMessageListener runId=" + La.K.R1(str, 32), false, 4, null);
                    return;
                }
                C4148a.k(TAG, "reference → push fallback sessionId=" + sessionId + " runId=" + La.K.R1(str, 32), false, 4, null);
                tVar.a(new C0917m(null, null, sessionId, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, 5, false, null, 0, null, 0, null, 0, null, null, null, null, null, str, str, null, SkillStoreKt.SKILL_DOC_TYPE_REFERENCE, null, null, null, null, null, null, null, listI1, null, null, null, null, -1619197957, 7934, null), getType());
                return;
            }
        }
        C4148a.u(TAG, "reference event without runId, dropped", false, 4, null);
    }

    public final void q1(StepClawEvent ev) {
        SessionUpdate sessionUpdateD = com.stepos.agentframework.adapter.netcore.x.d(com.stepos.agentframework.adapter.netcore.x.INSTANCE, ev.b(), ev.getSessionId(), false, 4, null);
        if (sessionUpdateD == null) {
            C4148a.u(TAG, "session.update dropped: missing label/sessionId sessionId=" + ev.getSessionId(), false, 4, null);
            return;
        }
        C4148a.k(TAG, "session.update sessionId=" + sessionUpdateD.getSessionId() + " label='" + sessionUpdateD.getLabel() + "' seq=" + sessionUpdateD.getSeq(), false, 4, null);
        com.stepos.agentframework.adapter.netcore.w.a(sessionUpdateD);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, com.stepos.agentframework.adapter.netcore.p log) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(log, "log");
        if (!v1()) {
            C4148a.u(TAG, "init ignored: already destroyed", false, 4, null);
            return;
        }
        this.hostPackageName = context.getPackageName();
        v.INSTANCE.b(context);
        C1060i.d(this.scope, null, null, new AgentBusCoreAgentClient$init$1(this, null), 3, null);
        C4148a.k(TAG, "initialized", false, 4, null);
    }

    public final void r1(String sessionId, Message message) {
        SessionUpdate sessionUpdateD = com.stepos.agentframework.adapter.netcore.x.d(com.stepos.agentframework.adapter.netcore.x.INSTANCE, message.d(), sessionId, false, 4, null);
        if (sessionUpdateD == null) {
            C4148a.u(TAG, "session.update message dropped: missing label sessionId=" + sessionId, false, 4, null);
            return;
        }
        C4148a.k(TAG, "session.update message sessionId=" + sessionUpdateD.getSessionId() + " label='" + sessionUpdateD.getLabel() + "'", false, 4, null);
        com.stepos.agentframework.adapter.netcore.w.a(sessionUpdateD);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void s1(StepClawEvent ev) {
        if (v1()) {
            if (v.INSTANCE.a()) {
                C4148a.k(TAG, "VERBOSE " + ((Object) ("stepClawEvent name=" + ev.getName() + " sessionId=" + ev.getSessionId() + " runId=" + ev.getRunId() + " payload=" + ev.b())), false, 4, null);
            }
            String strA1 = a1(ev);
            switch (strA1.hashCode()) {
                case -1201077193:
                    if (strA1.equals(STEP_CLAW_UI_EVENT)) {
                        t1(ev.b());
                        return;
                    }
                    break;
                case -575312677:
                    if (strA1.equals(STEP_CLAW_TASK_UPSERT)) {
                        TaskEventPayload taskEventPayloadK1 = K1(ev);
                        if (taskEventPayloadK1 != null) {
                            W0(taskEventPayloadK1);
                            return;
                        }
                        return;
                    }
                    break;
                case -272352184:
                    if (strA1.equals(STEP_CLAW_REFERENCE_EVENT)) {
                        p1(ev);
                        return;
                    }
                    break;
                case -187236284:
                    if (strA1.equals("stepclaw.session.update")) {
                        q1(ev);
                        return;
                    }
                    break;
                case 1110479859:
                    if (strA1.equals(STEP_CLAW_CARD_EVENT)) {
                        l1(ev);
                        return;
                    }
                    break;
                case 1237308510:
                    if (strA1.equals(STEP_CLAW_TASK_DISMISS)) {
                        TaskDismiss taskDismissJ1 = J1(ev);
                        if (taskDismissJ1 != null) {
                            com.stepos.agentframework.adapter.netcore.A.a(taskDismissJ1);
                            return;
                        }
                        return;
                    }
                    break;
            }
            if (z1(strA1) || z1(ev.getName())) {
                t1(ev.b());
            } else {
                k2(ev, strA1);
            }
        }
    }

    public final void t1(Map<String, ? extends Object> payload) {
        Object obj = payload.get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                Object obj2 = payload.get(SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY);
                if (obj2 == null) {
                    obj2 = payload.get("sessionId");
                }
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                List<String> listL1 = L1(payload);
                C4148a.k(TAG, "ui action event sessionId=" + str3 + " runId=" + La.K.R1(str, 32) + " actions=" + listL1, false, 4, null);
                C1060i.d(this.scope, this.inboundSerial, null, new AgentBusCoreAgentClient$handleUiActionEvent$1(this, str3, str, null), 2, null);
                com.stepos.agentframework.adapter.netcore.t tVar = this.pushMessageListener;
                if (tVar != null) {
                    tVar.a(new C0917m(null, null, str3, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, 5, false, null, 0, null, 0, null, 0, null, null, null, null, null, str, str, null, "ui_actions", null, null, null, null, null, null, null, null, listL1, null, null, null, -1619197957, 7678, null), getType());
                    return;
                }
                C4148a.u(TAG, "ui action dropped: no pushMessageListener runId=" + La.K.R1(str, 32), false, 4, null);
                return;
            }
        }
        C4148a.u(TAG, "ui action event without runId, dropped", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(kotlin.VoteRequest r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            K6.O r4 = (kotlin.VoteRequest) r4
            kotlin.C4849c.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$2 r6 = new com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$vote$2
            r2 = 0
            r6.<init>(r5, r2)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r5 = "vote"
            java.lang.Object r6 = r4.l2(r5, r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            boolean r4 = kotlin.jvm.internal.p.d(r6, r4)
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient.u(K6.O, e9.c):java.lang.Object");
    }

    public final boolean u1(String outboundId) {
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        return g1(outboundId) != null;
    }

    public final boolean v1() {
        return this.lifecycle.get() == Lifecycle.ALIVE;
    }

    public final boolean w1(ClawChannelAgentBusBinding clawChannelAgentBusBinding) {
        com.stepos.agentbus.generated.c value = clawChannelAgentBusBinding.getHealth().b().getValue();
        if (!(value instanceof c.Available) && !(value instanceof c.Degraded)) {
            c.Unavailable unavailable = value instanceof c.Unavailable ? (c.Unavailable) value : null;
            String reason = unavailable != null ? unavailable.getReason() : null;
            if (reason == null) {
                reason = "";
            }
            if (reason.length() > 0 && !kotlin.jvm.internal.p.d(reason, LOCAL_CLOUD_SNAPSHOT_REASON)) {
                return true;
            }
        }
        return false;
    }

    public final boolean x1(JSONObject res) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString = (res == null || (jSONObjectOptJSONObject = res.optJSONObject("error")) == null) ? null : jSONObjectOptJSONObject.optString("message");
        if (strOptString == null) {
            strOptString = "";
        }
        return La.H.e0(strOptString, "modified by another", true);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void y(com.stepos.agentframework.adapter.netcore.B listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.taskEventListeners.remove(listener);
    }

    public final boolean y1(JSONObject res) {
        JSONObject jSONObjectOptJSONObject;
        if (res == null || (jSONObjectOptJSONObject = res.optJSONObject("error")) == null) {
            return false;
        }
        if (jSONObjectOptJSONObject.optInt("code") == 5) {
            return true;
        }
        String strOptString = jSONObjectOptJSONObject.optString("message");
        if (strOptString == null) {
            strOptString = "";
        }
        return La.H.e0(strOptString, "already active", true) || La.H.e0(strOptString, "ReplyRunAlreadyActive", true);
    }

    public final boolean z1(String value) {
        return kotlin.jvm.internal.p.d(value, STEP_CLAW_UI_EVENT) || kotlin.jvm.internal.p.d(value, UI_STREAM);
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\b\u0082\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\n\u001a\u00060\bR\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\f\b\u0002\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010'R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106R\u001b\u0010\n\u001a\u00060\bR\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b8\u00109R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\b>\u0010?R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010/\u001a\u0004\b@\u0010'\"\u0004\bA\u0010BR\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u0014\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010F\u001a\u0004\bI\u0010HR\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010F\u001a\u0004\bJ\u0010HR\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u0010C\u001a\u0004\bK\u0010ER\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010L\u001a\u0004\bM\u0010NR\u001b\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010O\u001a\u0004\bP\u0010QR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010/\u001a\u0004\bR\u0010'\"\u0004\bS\u0010BR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\bW\u0010'R\u0017\u0010!\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b!\u0010F\u001a\u0004\bX\u0010HR\u0017\u0010\"\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\"\u0010F\u001a\u0004\bY\u0010HR\u0017\u0010#\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b#\u0010F\u001a\u0004\bZ\u0010H¨\u0006["}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$a;", "", "", "chatId", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$AgentBusCancelHandle;", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient;", "cancelHandle", "Lcom/stepos/agentframework/adapter/agentbus/s;", "streamAccumulator", "Lcom/stepos/agentframework/adapter/agentbus/N;", "toolEmitTracker", "outboundId", "Ljava/util/concurrent/atomic/AtomicReference;", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "sendAckEmitted", "hasDispatchedReply", "Lkotlinx/coroutines/g;", "pendingEmptyFallback", "Ljava/util/concurrent/atomic/AtomicLong;", "lastCloudDisconnectAtMs", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "dispatchedText", "lastInboundCumulative", "", "createdAtMs", "expectedRunId", "turnDone", "terminalFrameSeen", "hasInflightTool", "<init>", "(Ljava/lang/String;LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$AgentBusCancelHandle;Lcom/stepos/agentframework/adapter/agentbus/s;Lcom/stepos/agentframework/adapter/agentbus/N;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicLong;Ljava/lang/StringBuilder;Ljava/lang/String;JLjava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LK6/n;", "n", "()LK6/n;", "Lcom/stepos/agentframework/adapter/netcore/h;", "k", "()Lcom/stepos/agentframework/adapter/netcore/h;", "Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$AgentBusCancelHandle;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/agentbus/AgentBusCoreAgentClient$AgentBusCancelHandle;", "Lcom/stepos/agentframework/adapter/agentbus/s;", "q", "()Lcom/stepos/agentframework/adapter/agentbus/s;", "Lcom/stepos/agentframework/adapter/agentbus/N;", "s", "()Lcom/stepos/agentframework/adapter/agentbus/N;", "l", "v", "(Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicReference;", "o", "()Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "p", Const.INTENT_KEY_BACKGROUND_COMMAND, "m", "Ljava/util/concurrent/atomic/AtomicLong;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/lang/StringBuilder;", Const.INTENT_KEY_UMID, "()Ljava/lang/StringBuilder;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "u", "J", "c", "()J", "e", "t", "r", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient$a, reason: from toString */
    public static final /* data */ class ActiveChat {
        private final AgentBusCancelHandle cancelHandle;
        private final String chatId;
        private final long createdAtMs;
        private final StringBuilder dispatchedText;
        private final String expectedRunId;
        private final AtomicBoolean finished;
        private final AtomicBoolean hasDispatchedReply;
        private final AtomicBoolean hasInflightTool;
        private final AtomicLong lastCloudDisconnectAtMs;
        private String lastInboundCumulative;
        private final com.stepos.agentframework.adapter.netcore.h listener;
        private String outboundId;
        private final AtomicReference<kotlinx.coroutines.g> pendingEmptyFallback;
        private final C0918n request;
        private final AtomicReference<String> runId;
        private final AtomicBoolean sendAckEmitted;
        private final s streamAccumulator;
        private final AtomicBoolean terminalFrameSeen;
        private final N toolEmitTracker;
        private final AtomicBoolean turnDone;

        public ActiveChat(String chatId, C0918n request, com.stepos.agentframework.adapter.netcore.h listener, AgentBusCancelHandle cancelHandle, s streamAccumulator, N toolEmitTracker, String str, AtomicReference<String> runId, AtomicBoolean finished, AtomicBoolean sendAckEmitted, AtomicBoolean hasDispatchedReply, AtomicReference<kotlinx.coroutines.g> pendingEmptyFallback, AtomicLong lastCloudDisconnectAtMs, StringBuilder dispatchedText, String lastInboundCumulative, long j10, String str2, AtomicBoolean turnDone, AtomicBoolean terminalFrameSeen, AtomicBoolean hasInflightTool) {
            kotlin.jvm.internal.p.i(chatId, "chatId");
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(listener, "listener");
            kotlin.jvm.internal.p.i(cancelHandle, "cancelHandle");
            kotlin.jvm.internal.p.i(streamAccumulator, "streamAccumulator");
            kotlin.jvm.internal.p.i(toolEmitTracker, "toolEmitTracker");
            kotlin.jvm.internal.p.i(runId, "runId");
            kotlin.jvm.internal.p.i(finished, "finished");
            kotlin.jvm.internal.p.i(sendAckEmitted, "sendAckEmitted");
            kotlin.jvm.internal.p.i(hasDispatchedReply, "hasDispatchedReply");
            kotlin.jvm.internal.p.i(pendingEmptyFallback, "pendingEmptyFallback");
            kotlin.jvm.internal.p.i(lastCloudDisconnectAtMs, "lastCloudDisconnectAtMs");
            kotlin.jvm.internal.p.i(dispatchedText, "dispatchedText");
            kotlin.jvm.internal.p.i(lastInboundCumulative, "lastInboundCumulative");
            kotlin.jvm.internal.p.i(turnDone, "turnDone");
            kotlin.jvm.internal.p.i(terminalFrameSeen, "terminalFrameSeen");
            kotlin.jvm.internal.p.i(hasInflightTool, "hasInflightTool");
            this.chatId = chatId;
            this.request = request;
            this.listener = listener;
            this.cancelHandle = cancelHandle;
            this.streamAccumulator = streamAccumulator;
            this.toolEmitTracker = toolEmitTracker;
            this.outboundId = str;
            this.runId = runId;
            this.finished = finished;
            this.sendAckEmitted = sendAckEmitted;
            this.hasDispatchedReply = hasDispatchedReply;
            this.pendingEmptyFallback = pendingEmptyFallback;
            this.lastCloudDisconnectAtMs = lastCloudDisconnectAtMs;
            this.dispatchedText = dispatchedText;
            this.lastInboundCumulative = lastInboundCumulative;
            this.createdAtMs = j10;
            this.expectedRunId = str2;
            this.turnDone = turnDone;
            this.terminalFrameSeen = terminalFrameSeen;
            this.hasInflightTool = hasInflightTool;
        }

        /* renamed from: a, reason: from getter */
        public final AgentBusCancelHandle getCancelHandle() {
            return this.cancelHandle;
        }

        /* renamed from: b, reason: from getter */
        public final String getChatId() {
            return this.chatId;
        }

        /* renamed from: c, reason: from getter */
        public final long getCreatedAtMs() {
            return this.createdAtMs;
        }

        /* renamed from: d, reason: from getter */
        public final StringBuilder getDispatchedText() {
            return this.dispatchedText;
        }

        /* renamed from: e, reason: from getter */
        public final String getExpectedRunId() {
            return this.expectedRunId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveChat)) {
                return false;
            }
            ActiveChat activeChat = (ActiveChat) other;
            return kotlin.jvm.internal.p.d(this.chatId, activeChat.chatId) && kotlin.jvm.internal.p.d(this.request, activeChat.request) && kotlin.jvm.internal.p.d(this.listener, activeChat.listener) && kotlin.jvm.internal.p.d(this.cancelHandle, activeChat.cancelHandle) && kotlin.jvm.internal.p.d(this.streamAccumulator, activeChat.streamAccumulator) && kotlin.jvm.internal.p.d(this.toolEmitTracker, activeChat.toolEmitTracker) && kotlin.jvm.internal.p.d(this.outboundId, activeChat.outboundId) && kotlin.jvm.internal.p.d(this.runId, activeChat.runId) && kotlin.jvm.internal.p.d(this.finished, activeChat.finished) && kotlin.jvm.internal.p.d(this.sendAckEmitted, activeChat.sendAckEmitted) && kotlin.jvm.internal.p.d(this.hasDispatchedReply, activeChat.hasDispatchedReply) && kotlin.jvm.internal.p.d(this.pendingEmptyFallback, activeChat.pendingEmptyFallback) && kotlin.jvm.internal.p.d(this.lastCloudDisconnectAtMs, activeChat.lastCloudDisconnectAtMs) && kotlin.jvm.internal.p.d(this.dispatchedText, activeChat.dispatchedText) && kotlin.jvm.internal.p.d(this.lastInboundCumulative, activeChat.lastInboundCumulative) && this.createdAtMs == activeChat.createdAtMs && kotlin.jvm.internal.p.d(this.expectedRunId, activeChat.expectedRunId) && kotlin.jvm.internal.p.d(this.turnDone, activeChat.turnDone) && kotlin.jvm.internal.p.d(this.terminalFrameSeen, activeChat.terminalFrameSeen) && kotlin.jvm.internal.p.d(this.hasInflightTool, activeChat.hasInflightTool);
        }

        /* renamed from: f, reason: from getter */
        public final AtomicBoolean getFinished() {
            return this.finished;
        }

        /* renamed from: g, reason: from getter */
        public final AtomicBoolean getHasDispatchedReply() {
            return this.hasDispatchedReply;
        }

        /* renamed from: h, reason: from getter */
        public final AtomicBoolean getHasInflightTool() {
            return this.hasInflightTool;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.chatId.hashCode() * 31) + this.request.hashCode()) * 31) + this.listener.hashCode()) * 31) + this.cancelHandle.hashCode()) * 31) + this.streamAccumulator.hashCode()) * 31) + this.toolEmitTracker.hashCode()) * 31;
            String str = this.outboundId;
            int iHashCode2 = (((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.runId.hashCode()) * 31) + this.finished.hashCode()) * 31) + this.sendAckEmitted.hashCode()) * 31) + this.hasDispatchedReply.hashCode()) * 31) + this.pendingEmptyFallback.hashCode()) * 31) + this.lastCloudDisconnectAtMs.hashCode()) * 31) + this.dispatchedText.hashCode()) * 31) + this.lastInboundCumulative.hashCode()) * 31) + Long.hashCode(this.createdAtMs)) * 31;
            String str2 = this.expectedRunId;
            return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.turnDone.hashCode()) * 31) + this.terminalFrameSeen.hashCode()) * 31) + this.hasInflightTool.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final AtomicLong getLastCloudDisconnectAtMs() {
            return this.lastCloudDisconnectAtMs;
        }

        /* renamed from: j, reason: from getter */
        public final String getLastInboundCumulative() {
            return this.lastInboundCumulative;
        }

        /* renamed from: k, reason: from getter */
        public final com.stepos.agentframework.adapter.netcore.h getListener() {
            return this.listener;
        }

        /* renamed from: l, reason: from getter */
        public final String getOutboundId() {
            return this.outboundId;
        }

        public final AtomicReference<kotlinx.coroutines.g> m() {
            return this.pendingEmptyFallback;
        }

        /* renamed from: n, reason: from getter */
        public final C0918n getRequest() {
            return this.request;
        }

        public final AtomicReference<String> o() {
            return this.runId;
        }

        /* renamed from: p, reason: from getter */
        public final AtomicBoolean getSendAckEmitted() {
            return this.sendAckEmitted;
        }

        /* renamed from: q, reason: from getter */
        public final s getStreamAccumulator() {
            return this.streamAccumulator;
        }

        /* renamed from: r, reason: from getter */
        public final AtomicBoolean getTerminalFrameSeen() {
            return this.terminalFrameSeen;
        }

        /* renamed from: s, reason: from getter */
        public final N getToolEmitTracker() {
            return this.toolEmitTracker;
        }

        /* renamed from: t, reason: from getter */
        public final AtomicBoolean getTurnDone() {
            return this.turnDone;
        }

        public String toString() {
            String str = this.chatId;
            C0918n c0918n = this.request;
            com.stepos.agentframework.adapter.netcore.h hVar = this.listener;
            AgentBusCancelHandle agentBusCancelHandle = this.cancelHandle;
            s sVar = this.streamAccumulator;
            N n10 = this.toolEmitTracker;
            String str2 = this.outboundId;
            AtomicReference<String> atomicReference = this.runId;
            AtomicBoolean atomicBoolean = this.finished;
            AtomicBoolean atomicBoolean2 = this.sendAckEmitted;
            AtomicBoolean atomicBoolean3 = this.hasDispatchedReply;
            AtomicReference<kotlinx.coroutines.g> atomicReference2 = this.pendingEmptyFallback;
            AtomicLong atomicLong = this.lastCloudDisconnectAtMs;
            StringBuilder sb2 = this.dispatchedText;
            return "ActiveChat(chatId=" + str + ", request=" + c0918n + ", listener=" + hVar + ", cancelHandle=" + agentBusCancelHandle + ", streamAccumulator=" + sVar + ", toolEmitTracker=" + n10 + ", outboundId=" + str2 + ", runId=" + atomicReference + ", finished=" + atomicBoolean + ", sendAckEmitted=" + atomicBoolean2 + ", hasDispatchedReply=" + atomicBoolean3 + ", pendingEmptyFallback=" + atomicReference2 + ", lastCloudDisconnectAtMs=" + atomicLong + ", dispatchedText=" + ((Object) sb2) + ", lastInboundCumulative=" + this.lastInboundCumulative + ", createdAtMs=" + this.createdAtMs + ", expectedRunId=" + this.expectedRunId + ", turnDone=" + this.turnDone + ", terminalFrameSeen=" + this.terminalFrameSeen + ", hasInflightTool=" + this.hasInflightTool + ")";
        }

        public final void u(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.lastInboundCumulative = str;
        }

        public final void v(String str) {
            this.outboundId = str;
        }

        public /* synthetic */ ActiveChat(String str, C0918n c0918n, com.stepos.agentframework.adapter.netcore.h hVar, AgentBusCancelHandle agentBusCancelHandle, s sVar, N n10, String str2, AtomicReference atomicReference, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, AtomicReference atomicReference2, AtomicLong atomicLong, StringBuilder sb2, String str3, long j10, String str4, AtomicBoolean atomicBoolean4, AtomicBoolean atomicBoolean5, AtomicBoolean atomicBoolean6, int i10, kotlin.jvm.internal.i iVar) {
            this(str, c0918n, hVar, agentBusCancelHandle, (i10 & 16) != 0 ? new s() : sVar, (i10 & 32) != 0 ? new N() : n10, (i10 & 64) != 0 ? null : str2, (i10 & 128) != 0 ? new AtomicReference(null) : atomicReference, (i10 & 256) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i10 & 512) != 0 ? new AtomicBoolean(false) : atomicBoolean2, (i10 & 1024) != 0 ? new AtomicBoolean(false) : atomicBoolean3, (i10 & 2048) != 0 ? new AtomicReference(null) : atomicReference2, (i10 & 4096) != 0 ? new AtomicLong(0L) : atomicLong, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? new StringBuilder() : sb2, (i10 & 16384) != 0 ? "" : str3, (32768 & i10) != 0 ? System.currentTimeMillis() : j10, (65536 & i10) != 0 ? null : str4, (131072 & i10) != 0 ? new AtomicBoolean(false) : atomicBoolean4, (262144 & i10) != 0 ? new AtomicBoolean(false) : atomicBoolean5, (i10 & 524288) != 0 ? new AtomicBoolean(false) : atomicBoolean6);
        }
    }
}
