package com.stepos.ailauncher.taskstore.entity;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.provider.c;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u000e¢\u0006\u0004\b1\u00102J\u001d\u00107\u001a\u0002062\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u000e¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b9\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0012\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b=\u0010<J\u0012\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b@\u0010?J\u0012\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bA\u0010?J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bHÆ\u0003¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\bD\u0010?J\u0012\u0010E\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\bE\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bG\u0010?J\u0010\u0010H\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\bH\u00102J\u0010\u0010I\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\bI\u00102J\u0010\u0010J\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\bL\u0010MJ\u0012\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bN\u0010?J\u0012\u0010O\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bO\u0010?J\u0012\u0010P\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bP\u0010?J\u0012\u0010Q\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\bQ\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bS\u0010?J\u0012\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bT\u0010?J\u0018\u0010U\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\bU\u0010CJ\u0012\u0010V\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bV\u0010?J\u0010\u0010W\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\bW\u0010XJ\u0012\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bY\u0010<J\u0012\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bZ\u0010<J\u0010\u0010[\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b[\u0010XJ\u0018\u0010\\\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\\\u0010CJ\u0012\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b]\u0010?J\u0018\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b^\u0010CJ\u0012\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b_\u0010?J\u0012\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b`\u0010<J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bHÆ\u0003¢\u0006\u0004\ba\u0010CJ\u0012\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bb\u0010<J\u0012\u0010c\u001a\u0004\u0018\u00010-HÆ\u0003¢\u0006\u0004\bc\u0010dJ°\u0003\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010!\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-HÆ\u0001¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\bg\u0010?J\u0010\u0010h\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bh\u00102J\u001a\u0010k\u001a\u00020\u00132\b\u0010j\u001a\u0004\u0018\u00010iHÖ\u0003¢\u0006\u0004\bk\u0010lR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010m\u001a\u0004\bn\u0010:R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010o\u001a\u0004\bp\u0010<R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010o\u001a\u0004\bq\u0010<R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010r\u001a\u0004\bs\u0010?R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010r\u001a\u0004\bt\u0010?R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010r\u001a\u0004\bu\u0010?R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010v\u001a\u0004\bw\u0010CR\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010r\u001a\u0004\bx\u0010?R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010y\u001a\u0004\bz\u0010FR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010r\u001a\u0004\b{\u0010?R\u0017\u0010\u0011\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0011\u0010|\u001a\u0004\b}\u00102R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010|\u001a\u0004\b~\u00102R\u0018\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\r\n\u0004\b\u0014\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010KR\u0019\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\u000e\n\u0005\b\u0016\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010MR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b\u0017\u0010r\u001a\u0005\b\u0083\u0001\u0010?R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b\u0018\u0010r\u001a\u0005\b\u0084\u0001\u0010?R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b\u0019\u0010r\u001a\u0005\b\u0085\u0001\u0010?R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\u000e\n\u0005\b\u001b\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u0010RR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b\u001c\u0010r\u001a\u0005\b\u0088\u0001\u0010?R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b\u001d\u0010r\u001a\u0005\b\u0089\u0001\u0010?R \u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b8\u0006¢\u0006\r\n\u0004\b\u001f\u0010v\u001a\u0005\b\u008a\u0001\u0010CR\u001a\u0010 \u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b \u0010r\u001a\u0005\b\u008b\u0001\u0010?R\u0019\u0010!\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b!\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010XR\u001a\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\"\u0010o\u001a\u0005\b\u008e\u0001\u0010<R\u001a\u0010#\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b#\u0010o\u001a\u0005\b\u008f\u0001\u0010<R\u0019\u0010$\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b$\u0010\u008c\u0001\u001a\u0005\b\u0090\u0001\u0010XR \u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000b8\u0006¢\u0006\r\n\u0004\b&\u0010v\u001a\u0005\b\u0091\u0001\u0010CR\u001a\u0010'\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b'\u0010r\u001a\u0005\b\u0092\u0001\u0010?R \u0010(\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006¢\u0006\r\n\u0004\b(\u0010v\u001a\u0005\b\u0093\u0001\u0010CR\u001a\u0010)\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\r\n\u0004\b)\u0010r\u001a\u0005\b\u0094\u0001\u0010?R\u001a\u0010*\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b*\u0010o\u001a\u0005\b\u0095\u0001\u0010<R\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006¢\u0006\r\n\u0004\b+\u0010v\u001a\u0005\b\u0096\u0001\u0010CR\u001a\u0010,\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b,\u0010o\u001a\u0005\b\u0097\u0001\u0010<R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006¢\u0006\u000e\n\u0005\b.\u0010\u0098\u0001\u001a\u0005\b\u0099\u0001\u0010d¨\u0006\u009a\u0001"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "Landroid/os/Parcelable;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "eventType", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "taskId", "parentTaskId", "", "subTaskIds", "type", "", "version", "versionId", "taskVersion", "activeTaskVersion", "", "noTaskDetail", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "title", "subTitle", "iconUrl", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "progress", c.a.COL_SUMMARY, "requestSessionKey", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "pendingQuestions", "intention", "createdAt", "startedAt", "endedAt", "updatedAt", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "result", "extensionsJson", "subTasks", "notificationDismissedStatus", "durationMs", "answeredQuestionTexts", "readAt", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "answer", "<init>", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IIZLcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;JLjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "component2", "()Ljava/lang/Long;", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "()Ljava/util/List;", "component8", "component9", "()Ljava/lang/Integer;", "component10", "component11", "component12", "component13", "()Z", "component14", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "component15", "component16", "component17", "component18", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "component19", "component20", "component21", "component22", "component23", "()J", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", ChatTracker.CLICK_COPY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IIZLcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;JLjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Long;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "getEventType", "Ljava/lang/Long;", "getSeq", "getTs", "Ljava/lang/String;", "getSessionKey", "getTaskId", "getParentTaskId", "Ljava/util/List;", "getSubTaskIds", "getType", "Ljava/lang/Integer;", "getVersion", "getVersionId", "I", "getTaskVersion", "getActiveTaskVersion", "Z", "getNoTaskDetail", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "getStatus", "getTitle", "getSubTitle", "getIconUrl", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "getProgress", "getSummary", "getRequestSessionKey", "getPendingQuestions", "getIntention", "J", "getCreatedAt", "getStartedAt", "getEndedAt", "getUpdatedAt", "getResult", "getExtensionsJson", "getSubTasks", "getNotificationDismissedStatus", "getDurationMs", "getAnsweredQuestionTexts", "getReadAt", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "getAnswer", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoCard implements Parcelable {
    public static final Parcelable.Creator<TaskInfoCard> CREATOR = new Creator();
    private final int activeTaskVersion;
    private final TaskInfoAnswer answer;
    private final List<String> answeredQuestionTexts;
    private final long createdAt;
    private final Long durationMs;
    private final Long endedAt;
    private final TaskInfoEventType eventType;
    private final String extensionsJson;
    private final String iconUrl;
    private final String intention;
    private final boolean noTaskDetail;
    private final String notificationDismissedStatus;
    private final String parentTaskId;
    private final List<TaskInfoQuestion> pendingQuestions;
    private final TaskInfoProgress progress;
    private final Long readAt;
    private final String requestSessionKey;
    private final List<TaskInfoPart> result;
    private final Long seq;
    private final String sessionKey;
    private final Long startedAt;
    private final TaskInfoStatus status;
    private final List<String> subTaskIds;
    private final List<TaskInfoCard> subTasks;
    private final String subTitle;
    private final String summary;
    private final String taskId;
    private final int taskVersion;
    private final String title;
    private final Long ts;
    private final String type;
    private final long updatedAt;
    private final Integer version;
    private final String versionId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoCard> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoCard createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            boolean z10;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            p.i(parcel, "parcel");
            TaskInfoEventType taskInfoEventTypeValueOf = TaskInfoEventType.valueOf(parcel.readString());
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long lValueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String string4 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string5 = parcel.readString();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            boolean z11 = parcel.readInt() != 0;
            TaskInfoStatus taskInfoStatusValueOf = TaskInfoStatus.valueOf(parcel.readString());
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            TaskInfoProgress taskInfoProgressCreateFromParcel = parcel.readInt() == 0 ? null : TaskInfoProgress.CREATOR.createFromParcel(parcel);
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i12 = parcel.readInt();
                arrayList = new ArrayList(i12);
                boolean z12 = z11;
                for (int i13 = 0; i13 != i12; i13++) {
                    arrayList.add(TaskInfoQuestion.CREATOR.createFromParcel(parcel));
                }
                z11 = z12;
            }
            String string11 = parcel.readString();
            long j10 = parcel.readLong();
            Long lValueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long lValueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            long j11 = parcel.readLong();
            if (parcel.readInt() == 0) {
                z10 = z11;
                arrayList2 = null;
            } else {
                int i14 = parcel.readInt();
                z10 = z11;
                arrayList2 = new ArrayList(i14);
                int i15 = 0;
                while (i15 != i14) {
                    arrayList2.add(TaskInfoPart.CREATOR.createFromParcel(parcel));
                    i15++;
                    i14 = i14;
                }
                taskInfoEventTypeValueOf = taskInfoEventTypeValueOf;
            }
            String string12 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList3 = arrayList2;
                arrayList4 = null;
            } else {
                int i16 = parcel.readInt();
                arrayList3 = arrayList2;
                arrayList4 = new ArrayList(i16);
                TaskInfoEventType taskInfoEventType = taskInfoEventTypeValueOf;
                int i17 = 0;
                while (i17 != i16) {
                    arrayList4.add(TaskInfoCard.CREATOR.createFromParcel(parcel));
                    i17++;
                    i16 = i16;
                }
                taskInfoEventTypeValueOf = taskInfoEventType;
            }
            return new TaskInfoCard(taskInfoEventTypeValueOf, lValueOf, lValueOf2, string, string2, string3, arrayListCreateStringArrayList, string4, numValueOf, string5, i10, i11, z10, taskInfoStatusValueOf, string6, string7, string8, taskInfoProgressCreateFromParcel, string9, string10, arrayList, string11, j10, lValueOf3, lValueOf4, j11, arrayList3, string12, arrayList4, parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.createStringArrayList(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : TaskInfoAnswer.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoCard[] newArray(int i10) {
            return new TaskInfoCard[i10];
        }
    }

    public TaskInfoCard(TaskInfoEventType eventType, Long l10, Long l11, String str, String taskId, String str2, List<String> subTaskIds, String type, Integer num, String str3, int i10, int i11, boolean z10, TaskInfoStatus status, String str4, String str5, String str6, TaskInfoProgress taskInfoProgress, String str7, String str8, List<TaskInfoQuestion> list, String str9, long j10, Long l12, Long l13, long j11, List<TaskInfoPart> list2, String str10, List<TaskInfoCard> list3, String str11, Long l14, List<String> answeredQuestionTexts, Long l15, TaskInfoAnswer taskInfoAnswer) {
        p.i(eventType, "eventType");
        p.i(taskId, "taskId");
        p.i(subTaskIds, "subTaskIds");
        p.i(type, "type");
        p.i(status, "status");
        p.i(answeredQuestionTexts, "answeredQuestionTexts");
        this.eventType = eventType;
        this.seq = l10;
        this.ts = l11;
        this.sessionKey = str;
        this.taskId = taskId;
        this.parentTaskId = str2;
        this.subTaskIds = subTaskIds;
        this.type = type;
        this.version = num;
        this.versionId = str3;
        this.taskVersion = i10;
        this.activeTaskVersion = i11;
        this.noTaskDetail = z10;
        this.status = status;
        this.title = str4;
        this.subTitle = str5;
        this.iconUrl = str6;
        this.progress = taskInfoProgress;
        this.summary = str7;
        this.requestSessionKey = str8;
        this.pendingQuestions = list;
        this.intention = str9;
        this.createdAt = j10;
        this.startedAt = l12;
        this.endedAt = l13;
        this.updatedAt = j11;
        this.result = list2;
        this.extensionsJson = str10;
        this.subTasks = list3;
        this.notificationDismissedStatus = str11;
        this.durationMs = l14;
        this.answeredQuestionTexts = answeredQuestionTexts;
        this.readAt = l15;
        this.answer = taskInfoAnswer;
    }

    public static /* synthetic */ TaskInfoCard copy$default(TaskInfoCard taskInfoCard, TaskInfoEventType taskInfoEventType, Long l10, Long l11, String str, String str2, String str3, List list, String str4, Integer num, String str5, int i10, int i11, boolean z10, TaskInfoStatus taskInfoStatus, String str6, String str7, String str8, TaskInfoProgress taskInfoProgress, String str9, String str10, List list2, String str11, long j10, Long l12, Long l13, long j11, List list3, String str12, List list4, String str13, Long l14, List list5, Long l15, TaskInfoAnswer taskInfoAnswer, int i12, int i13, Object obj) {
        TaskInfoAnswer taskInfoAnswer2;
        Long l16;
        String str14;
        List list6;
        String str15;
        long j12;
        Long l17;
        Long l18;
        long j13;
        List list7;
        List list8;
        String str16;
        Long l19;
        List list9;
        String str17;
        String str18;
        String str19;
        String str20;
        Integer num2;
        String str21;
        int i14;
        int i15;
        boolean z11;
        TaskInfoStatus taskInfoStatus2;
        String str22;
        String str23;
        TaskInfoProgress taskInfoProgress2;
        String str24;
        String str25;
        Long l20;
        Long l21;
        String str26;
        TaskInfoEventType taskInfoEventType2 = (i12 & 1) != 0 ? taskInfoCard.eventType : taskInfoEventType;
        Long l22 = (i12 & 2) != 0 ? taskInfoCard.seq : l10;
        Long l23 = (i12 & 4) != 0 ? taskInfoCard.ts : l11;
        String str27 = (i12 & 8) != 0 ? taskInfoCard.sessionKey : str;
        String str28 = (i12 & 16) != 0 ? taskInfoCard.taskId : str2;
        String str29 = (i12 & 32) != 0 ? taskInfoCard.parentTaskId : str3;
        List list10 = (i12 & 64) != 0 ? taskInfoCard.subTaskIds : list;
        String str30 = (i12 & 128) != 0 ? taskInfoCard.type : str4;
        Integer num3 = (i12 & 256) != 0 ? taskInfoCard.version : num;
        String str31 = (i12 & 512) != 0 ? taskInfoCard.versionId : str5;
        int i16 = (i12 & 1024) != 0 ? taskInfoCard.taskVersion : i10;
        int i17 = (i12 & 2048) != 0 ? taskInfoCard.activeTaskVersion : i11;
        boolean z12 = (i12 & 4096) != 0 ? taskInfoCard.noTaskDetail : z10;
        TaskInfoStatus taskInfoStatus3 = (i12 & b.THRESHOLD) != 0 ? taskInfoCard.status : taskInfoStatus;
        TaskInfoEventType taskInfoEventType3 = taskInfoEventType2;
        String str32 = (i12 & 16384) != 0 ? taskInfoCard.title : str6;
        String str33 = (i12 & 32768) != 0 ? taskInfoCard.subTitle : str7;
        String str34 = (i12 & 65536) != 0 ? taskInfoCard.iconUrl : str8;
        TaskInfoProgress taskInfoProgress3 = (i12 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? taskInfoCard.progress : taskInfoProgress;
        String str35 = (i12 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? taskInfoCard.summary : str9;
        String str36 = (i12 & 524288) != 0 ? taskInfoCard.requestSessionKey : str10;
        List list11 = (i12 & 1048576) != 0 ? taskInfoCard.pendingQuestions : list2;
        String str37 = (i12 & 2097152) != 0 ? taskInfoCard.intention : str11;
        String str38 = str32;
        long j14 = (i12 & 4194304) != 0 ? taskInfoCard.createdAt : j10;
        Long l24 = (i12 & 8388608) != 0 ? taskInfoCard.startedAt : l12;
        Long l25 = (i12 & 16777216) != 0 ? taskInfoCard.endedAt : l13;
        long j15 = (i12 & Const.FLAG_MUTABLE) != 0 ? taskInfoCard.updatedAt : j11;
        List list12 = (i12 & 67108864) != 0 ? taskInfoCard.result : list3;
        String str39 = (i12 & 134217728) != 0 ? taskInfoCard.extensionsJson : str12;
        List list13 = list12;
        List list14 = (i12 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? taskInfoCard.subTasks : list4;
        String str40 = (i12 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? taskInfoCard.notificationDismissedStatus : str13;
        Long l26 = (i12 & 1073741824) != 0 ? taskInfoCard.durationMs : l14;
        List list15 = (i12 & Integer.MIN_VALUE) != 0 ? taskInfoCard.answeredQuestionTexts : list5;
        Long l27 = (i13 & 1) != 0 ? taskInfoCard.readAt : l15;
        if ((i13 & 2) != 0) {
            l16 = l27;
            taskInfoAnswer2 = taskInfoCard.answer;
            list6 = list11;
            str15 = str37;
            j12 = j14;
            l17 = l24;
            l18 = l25;
            j13 = j15;
            list7 = list13;
            list8 = list14;
            str16 = str40;
            l19 = l26;
            list9 = list15;
            str17 = str39;
            str19 = str29;
            str20 = str30;
            num2 = num3;
            str21 = str31;
            i14 = i16;
            i15 = i17;
            z11 = z12;
            taskInfoStatus2 = taskInfoStatus3;
            str22 = str33;
            str23 = str34;
            taskInfoProgress2 = taskInfoProgress3;
            str24 = str35;
            str14 = str36;
            str25 = str38;
            l20 = l22;
            l21 = l23;
            str26 = str27;
            str18 = str28;
        } else {
            taskInfoAnswer2 = taskInfoAnswer;
            l16 = l27;
            str14 = str36;
            list6 = list11;
            str15 = str37;
            j12 = j14;
            l17 = l24;
            l18 = l25;
            j13 = j15;
            list7 = list13;
            list8 = list14;
            str16 = str40;
            l19 = l26;
            list9 = list15;
            str17 = str39;
            str18 = str28;
            str19 = str29;
            str20 = str30;
            num2 = num3;
            str21 = str31;
            i14 = i16;
            i15 = i17;
            z11 = z12;
            taskInfoStatus2 = taskInfoStatus3;
            str22 = str33;
            str23 = str34;
            taskInfoProgress2 = taskInfoProgress3;
            str24 = str35;
            str25 = str38;
            l20 = l22;
            l21 = l23;
            str26 = str27;
        }
        return taskInfoCard.copy(taskInfoEventType3, l20, l21, str26, str18, str19, list10, str20, num2, str21, i14, i15, z11, taskInfoStatus2, str25, str22, str23, taskInfoProgress2, str24, str14, list6, str15, j12, l17, l18, j13, list7, str17, list8, str16, l19, list9, l16, taskInfoAnswer2);
    }

    /* renamed from: component1, reason: from getter */
    public final TaskInfoEventType getEventType() {
        return this.eventType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    /* renamed from: component11, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: component12, reason: from getter */
    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    /* renamed from: component14, reason: from getter */
    public final TaskInfoStatus getStatus() {
        return this.status;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component16, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: component17, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component18, reason: from getter */
    public final TaskInfoProgress getProgress() {
        return this.progress;
    }

    /* renamed from: component19, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    /* renamed from: component20, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    public final List<TaskInfoQuestion> component21() {
        return this.pendingQuestions;
    }

    /* renamed from: component22, reason: from getter */
    public final String getIntention() {
        return this.intention;
    }

    /* renamed from: component23, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component24, reason: from getter */
    public final Long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: component25, reason: from getter */
    public final Long getEndedAt() {
        return this.endedAt;
    }

    /* renamed from: component26, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<TaskInfoPart> component27() {
        return this.result;
    }

    /* renamed from: component28, reason: from getter */
    public final String getExtensionsJson() {
        return this.extensionsJson;
    }

    public final List<TaskInfoCard> component29() {
        return this.subTasks;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTs() {
        return this.ts;
    }

    /* renamed from: component30, reason: from getter */
    public final String getNotificationDismissedStatus() {
        return this.notificationDismissedStatus;
    }

    /* renamed from: component31, reason: from getter */
    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final List<String> component32() {
        return this.answeredQuestionTexts;
    }

    /* renamed from: component33, reason: from getter */
    public final Long getReadAt() {
        return this.readAt;
    }

    /* renamed from: component34, reason: from getter */
    public final TaskInfoAnswer getAnswer() {
        return this.answer;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final List<String> component7() {
        return this.subTaskIds;
    }

    /* renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    public final TaskInfoCard copy(TaskInfoEventType eventType, Long seq, Long ts, String sessionKey, String taskId, String parentTaskId, List<String> subTaskIds, String type, Integer version, String versionId, int taskVersion, int activeTaskVersion, boolean noTaskDetail, TaskInfoStatus status, String title, String subTitle, String iconUrl, TaskInfoProgress progress, String summary, String requestSessionKey, List<TaskInfoQuestion> pendingQuestions, String intention, long createdAt, Long startedAt, Long endedAt, long updatedAt, List<TaskInfoPart> result, String extensionsJson, List<TaskInfoCard> subTasks, String notificationDismissedStatus, Long durationMs, List<String> answeredQuestionTexts, Long readAt, TaskInfoAnswer answer) {
        p.i(eventType, "eventType");
        p.i(taskId, "taskId");
        p.i(subTaskIds, "subTaskIds");
        p.i(type, "type");
        p.i(status, "status");
        p.i(answeredQuestionTexts, "answeredQuestionTexts");
        return new TaskInfoCard(eventType, seq, ts, sessionKey, taskId, parentTaskId, subTaskIds, type, version, versionId, taskVersion, activeTaskVersion, noTaskDetail, status, title, subTitle, iconUrl, progress, summary, requestSessionKey, pendingQuestions, intention, createdAt, startedAt, endedAt, updatedAt, result, extensionsJson, subTasks, notificationDismissedStatus, durationMs, answeredQuestionTexts, readAt, answer);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoCard)) {
            return false;
        }
        TaskInfoCard taskInfoCard = (TaskInfoCard) other;
        return this.eventType == taskInfoCard.eventType && p.d(this.seq, taskInfoCard.seq) && p.d(this.ts, taskInfoCard.ts) && p.d(this.sessionKey, taskInfoCard.sessionKey) && p.d(this.taskId, taskInfoCard.taskId) && p.d(this.parentTaskId, taskInfoCard.parentTaskId) && p.d(this.subTaskIds, taskInfoCard.subTaskIds) && p.d(this.type, taskInfoCard.type) && p.d(this.version, taskInfoCard.version) && p.d(this.versionId, taskInfoCard.versionId) && this.taskVersion == taskInfoCard.taskVersion && this.activeTaskVersion == taskInfoCard.activeTaskVersion && this.noTaskDetail == taskInfoCard.noTaskDetail && this.status == taskInfoCard.status && p.d(this.title, taskInfoCard.title) && p.d(this.subTitle, taskInfoCard.subTitle) && p.d(this.iconUrl, taskInfoCard.iconUrl) && p.d(this.progress, taskInfoCard.progress) && p.d(this.summary, taskInfoCard.summary) && p.d(this.requestSessionKey, taskInfoCard.requestSessionKey) && p.d(this.pendingQuestions, taskInfoCard.pendingQuestions) && p.d(this.intention, taskInfoCard.intention) && this.createdAt == taskInfoCard.createdAt && p.d(this.startedAt, taskInfoCard.startedAt) && p.d(this.endedAt, taskInfoCard.endedAt) && this.updatedAt == taskInfoCard.updatedAt && p.d(this.result, taskInfoCard.result) && p.d(this.extensionsJson, taskInfoCard.extensionsJson) && p.d(this.subTasks, taskInfoCard.subTasks) && p.d(this.notificationDismissedStatus, taskInfoCard.notificationDismissedStatus) && p.d(this.durationMs, taskInfoCard.durationMs) && p.d(this.answeredQuestionTexts, taskInfoCard.answeredQuestionTexts) && p.d(this.readAt, taskInfoCard.readAt) && p.d(this.answer, taskInfoCard.answer);
    }

    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    public final TaskInfoAnswer getAnswer() {
        return this.answer;
    }

    public final List<String> getAnsweredQuestionTexts() {
        return this.answeredQuestionTexts;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final Long getEndedAt() {
        return this.endedAt;
    }

    public final TaskInfoEventType getEventType() {
        return this.eventType;
    }

    public final String getExtensionsJson() {
        return this.extensionsJson;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIntention() {
        return this.intention;
    }

    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    public final String getNotificationDismissedStatus() {
        return this.notificationDismissedStatus;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final List<TaskInfoQuestion> getPendingQuestions() {
        return this.pendingQuestions;
    }

    public final TaskInfoProgress getProgress() {
        return this.progress;
    }

    public final Long getReadAt() {
        return this.readAt;
    }

    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    public final List<TaskInfoPart> getResult() {
        return this.result;
    }

    public final Long getSeq() {
        return this.seq;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final Long getStartedAt() {
        return this.startedAt;
    }

    public final TaskInfoStatus getStatus() {
        return this.status;
    }

    public final List<String> getSubTaskIds() {
        return this.subTaskIds;
    }

    public final List<TaskInfoCard> getSubTasks() {
        return this.subTasks;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTs() {
        return this.ts;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Long l10 = this.seq;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.ts;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.sessionKey;
        int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.taskId.hashCode()) * 31;
        String str2 = this.parentTaskId;
        int iHashCode5 = (((((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subTaskIds.hashCode()) * 31) + this.type.hashCode()) * 31;
        Integer num = this.version;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.versionId;
        int iHashCode7 = (((((((((iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31) + Integer.hashCode(this.activeTaskVersion)) * 31) + Boolean.hashCode(this.noTaskDetail)) * 31) + this.status.hashCode()) * 31;
        String str4 = this.title;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subTitle;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.iconUrl;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        TaskInfoProgress taskInfoProgress = this.progress;
        int iHashCode11 = (iHashCode10 + (taskInfoProgress == null ? 0 : taskInfoProgress.hashCode())) * 31;
        String str7 = this.summary;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.requestSessionKey;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<TaskInfoQuestion> list = this.pendingQuestions;
        int iHashCode14 = (iHashCode13 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.intention;
        int iHashCode15 = (((iHashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l12 = this.startedAt;
        int iHashCode16 = (iHashCode15 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.endedAt;
        int iHashCode17 = (((iHashCode16 + (l13 == null ? 0 : l13.hashCode())) * 31) + Long.hashCode(this.updatedAt)) * 31;
        List<TaskInfoPart> list2 = this.result;
        int iHashCode18 = (iHashCode17 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str10 = this.extensionsJson;
        int iHashCode19 = (iHashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<TaskInfoCard> list3 = this.subTasks;
        int iHashCode20 = (iHashCode19 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str11 = this.notificationDismissedStatus;
        int iHashCode21 = (iHashCode20 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Long l14 = this.durationMs;
        int iHashCode22 = (((iHashCode21 + (l14 == null ? 0 : l14.hashCode())) * 31) + this.answeredQuestionTexts.hashCode()) * 31;
        Long l15 = this.readAt;
        int iHashCode23 = (iHashCode22 + (l15 == null ? 0 : l15.hashCode())) * 31;
        TaskInfoAnswer taskInfoAnswer = this.answer;
        return iHashCode23 + (taskInfoAnswer != null ? taskInfoAnswer.hashCode() : 0);
    }

    public String toString() {
        return "TaskInfoCard(eventType=" + this.eventType + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ", taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", subTaskIds=" + this.subTaskIds + ", type=" + this.type + ", version=" + this.version + ", versionId=" + this.versionId + ", taskVersion=" + this.taskVersion + ", activeTaskVersion=" + this.activeTaskVersion + ", noTaskDetail=" + this.noTaskDetail + ", status=" + this.status + ", title=" + this.title + ", subTitle=" + this.subTitle + ", iconUrl=" + this.iconUrl + ", progress=" + this.progress + ", summary=" + this.summary + ", requestSessionKey=" + this.requestSessionKey + ", pendingQuestions=" + this.pendingQuestions + ", intention=" + this.intention + ", createdAt=" + this.createdAt + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", updatedAt=" + this.updatedAt + ", result=" + this.result + ", extensionsJson=" + this.extensionsJson + ", subTasks=" + this.subTasks + ", notificationDismissedStatus=" + this.notificationDismissedStatus + ", durationMs=" + this.durationMs + ", answeredQuestionTexts=" + this.answeredQuestionTexts + ", readAt=" + this.readAt + ", answer=" + this.answer + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.eventType.name());
        Long l10 = this.seq;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Long l11 = this.ts;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        dest.writeString(this.sessionKey);
        dest.writeString(this.taskId);
        dest.writeString(this.parentTaskId);
        dest.writeStringList(this.subTaskIds);
        dest.writeString(this.type);
        Integer num = this.version;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.versionId);
        dest.writeInt(this.taskVersion);
        dest.writeInt(this.activeTaskVersion);
        dest.writeInt(this.noTaskDetail ? 1 : 0);
        dest.writeString(this.status.name());
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
        dest.writeString(this.iconUrl);
        TaskInfoProgress taskInfoProgress = this.progress;
        if (taskInfoProgress == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskInfoProgress.writeToParcel(dest, flags);
        }
        dest.writeString(this.summary);
        dest.writeString(this.requestSessionKey);
        List<TaskInfoQuestion> list = this.pendingQuestions;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<TaskInfoQuestion> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.intention);
        dest.writeLong(this.createdAt);
        Long l12 = this.startedAt;
        if (l12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l12.longValue());
        }
        Long l13 = this.endedAt;
        if (l13 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l13.longValue());
        }
        dest.writeLong(this.updatedAt);
        List<TaskInfoPart> list2 = this.result;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<TaskInfoPart> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.extensionsJson);
        List<TaskInfoCard> list3 = this.subTasks;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            Iterator<TaskInfoCard> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.notificationDismissedStatus);
        Long l14 = this.durationMs;
        if (l14 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l14.longValue());
        }
        dest.writeStringList(this.answeredQuestionTexts);
        Long l15 = this.readAt;
        if (l15 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l15.longValue());
        }
        TaskInfoAnswer taskInfoAnswer = this.answer;
        if (taskInfoAnswer == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            taskInfoAnswer.writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ TaskInfoCard(TaskInfoEventType taskInfoEventType, Long l10, Long l11, String str, String str2, String str3, List list, String str4, Integer num, String str5, int i10, int i11, boolean z10, TaskInfoStatus taskInfoStatus, String str6, String str7, String str8, TaskInfoProgress taskInfoProgress, String str9, String str10, List list2, String str11, long j10, Long l12, Long l13, long j11, List list3, String str12, List list4, String str13, Long l14, List list5, Long l15, TaskInfoAnswer taskInfoAnswer, int i12, int i13, i iVar) {
        this(taskInfoEventType, (i12 & 2) != 0 ? null : l10, (i12 & 4) != 0 ? null : l11, (i12 & 8) != 0 ? null : str, str2, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? C1173v.m() : list, str4, (i12 & 256) != 0 ? null : num, (i12 & 512) != 0 ? null : str5, (i12 & 1024) != 0 ? 0 : i10, (i12 & 2048) != 0 ? 0 : i11, (i12 & 4096) != 0 ? false : z10, taskInfoStatus, (i12 & 16384) != 0 ? null : str6, (32768 & i12) != 0 ? null : str7, (65536 & i12) != 0 ? null : str8, (131072 & i12) != 0 ? null : taskInfoProgress, (262144 & i12) != 0 ? null : str9, (524288 & i12) != 0 ? null : str10, (1048576 & i12) != 0 ? null : list2, (2097152 & i12) != 0 ? null : str11, j10, (8388608 & i12) != 0 ? null : l12, (16777216 & i12) != 0 ? null : l13, j11, (67108864 & i12) != 0 ? null : list3, (134217728 & i12) != 0 ? null : str12, (268435456 & i12) != 0 ? null : list4, (536870912 & i12) != 0 ? null : str13, (1073741824 & i12) != 0 ? null : l14, (i12 & Integer.MIN_VALUE) != 0 ? C1173v.m() : list5, (i13 & 1) != 0 ? null : l15, (i13 & 2) != 0 ? null : taskInfoAnswer);
    }
}
