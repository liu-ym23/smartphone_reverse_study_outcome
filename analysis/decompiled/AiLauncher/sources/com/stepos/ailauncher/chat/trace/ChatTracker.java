package com.stepos.ailauncher.chat.trace;

import La.H;
import Y8.j;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.sla.C3475d;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b¤\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#Jc\u0010,\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-JY\u00102\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b2\u00103J5\u00105\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010(¢\u0006\u0004\b5\u00106J?\u00109\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b9\u0010:JW\u0010?\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010=\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010(¢\u0006\u0004\b?\u0010@J5\u0010B\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bB\u0010CJ3\u0010I\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020D2\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010A\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bI\u0010JJ!\u0010L\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010K\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bL\u0010MJ!\u0010P\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010O\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bP\u0010QJ+\u0010T\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010S\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bT\u0010UJ?\u0010X\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010V\u001a\u0004\u0018\u00010\u00042\b\u0010W\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bX\u0010:Je\u0010^\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010[\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u000b¢\u0006\u0004\b`\u0010\u0003J\u0017\u0010b\u001a\u00020\u000b2\b\u0010a\u001a\u0004\u0018\u00010(¢\u0006\u0004\bb\u0010cJ!\u0010e\u001a\u00020\u000b2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010a\u001a\u0004\u0018\u00010(¢\u0006\u0004\be\u0010fJ!\u0010i\u001a\u00020\u000b2\b\u0010g\u001a\u0004\u0018\u00010\u00042\b\u0010h\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bi\u0010jJ5\u0010l\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010k\u001a\u0004\u0018\u00010\u00042\b\u0010h\u001a\u0004\u0018\u00010\u00042\b\u0010g\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bl\u0010CJ!\u0010m\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bm\u0010jJ\u0017\u0010n\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bn\u0010\u0010J\u0017\u0010o\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bo\u0010\u0010J-\u0010q\u001a\u00020\u000b2\b\u0010p\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bq\u0010UJ!\u0010r\u001a\u00020\u000b2\b\u0010p\u001a\u0004\u0018\u00010\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\br\u0010jJ;\u0010s\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bs\u0010tR\u0014\u0010u\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010vR\u0014\u0010x\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bx\u0010vR\u0014\u0010y\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\by\u0010vR\u0014\u0010z\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010vR\u0014\u0010{\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010vR\u0014\u0010|\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b|\u0010vR\u0014\u0010}\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b}\u0010vR\u0014\u0010~\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b~\u0010vR\u0014\u0010\u007f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u007f\u0010vR\u0016\u0010\u0080\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010vR\u0016\u0010\u0081\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010vR\u0016\u0010\u0082\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010vR\u0016\u0010\u0083\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010vR\u0016\u0010\u0084\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010vR\u0016\u0010\u0085\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010vR\u0016\u0010\u0086\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010vR\u0016\u0010\u0087\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010vR\u0016\u0010\u0088\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010vR\u0016\u0010\u0089\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0016\u0010\u008a\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010vR\u0016\u0010\u008b\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010vR\u0016\u0010\u008c\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010vR\u0016\u0010\u008d\u0001\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010vR\u0016\u0010\u008e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010vR\u0016\u0010\u008f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010vR\u0016\u0010\u0090\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010vR\u0016\u0010\u0091\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010vR\u0016\u0010\u0092\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010vR\u0016\u0010\u0093\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010vR\u0016\u0010\u0094\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010vR\u0016\u0010\u0095\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010vR\u0016\u0010\u0096\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010vR\u0016\u0010\u0097\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010vR\u0016\u0010\u0098\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010vR\u0016\u0010\u0099\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010vR\u0016\u0010\u009a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010vR\u0016\u0010\u009b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010vR\u0016\u0010\u009c\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010vR\u0016\u0010\u009d\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010vR\u0016\u0010\u009e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010vR\u0016\u0010\u009f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010vR\u0016\u0010 \u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b \u0001\u0010vR\u0016\u0010¡\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¡\u0001\u0010vR\u0016\u0010¢\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¢\u0001\u0010vR\u0016\u0010£\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b£\u0001\u0010vR\u0016\u0010¤\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¤\u0001\u0010vR\u0016\u0010¥\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¥\u0001\u0010vR\u0016\u0010¦\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¦\u0001\u0010vR\u0016\u0010§\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b§\u0001\u0010vR\u0016\u0010¨\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¨\u0001\u0010vR\u0016\u0010©\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b©\u0001\u0010vR\u0016\u0010ª\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bª\u0001\u0010vR\u0016\u0010«\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b«\u0001\u0010vR\u0016\u0010¬\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¬\u0001\u0010vR\u0016\u0010\u00ad\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010vR\u0016\u0010®\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b®\u0001\u0010vR\u0016\u0010¯\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¯\u0001\u0010vR\u0016\u0010°\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b°\u0001\u0010vR\u001a\u0010±\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010vR\u0016\u0010²\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b²\u0001\u0010vR\u0016\u0010³\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b³\u0001\u0010vR\u0016\u0010´\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b´\u0001\u0010vR\u0016\u0010µ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bµ\u0001\u0010vR\u0016\u0010¶\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¶\u0001\u0010vR\u0016\u0010·\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b·\u0001\u0010vR\u0016\u0010¸\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¸\u0001\u0010vR\u0016\u0010¹\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¹\u0001\u0010vR\u0016\u0010º\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bº\u0001\u0010vR\u0016\u0010»\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b»\u0001\u0010vR\u0016\u0010¼\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¼\u0001\u0010vR\u0016\u0010½\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b½\u0001\u0010vR\u0016\u0010¾\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¾\u0001\u0010vR\u0016\u0010¿\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b¿\u0001\u0010vR\u0016\u0010À\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÀ\u0001\u0010vR\u0016\u0010Á\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÁ\u0001\u0010vR\u0016\u0010Â\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÂ\u0001\u0010vR\u0016\u0010Ã\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÃ\u0001\u0010vR\u0016\u0010Ä\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÄ\u0001\u0010vR\u0016\u0010Å\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÅ\u0001\u0010vR\u0016\u0010Æ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÆ\u0001\u0010vR\u0016\u0010Ç\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÇ\u0001\u0010vR\u0016\u0010È\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÈ\u0001\u0010vR\u0016\u0010É\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÉ\u0001\u0010vR\u0016\u0010Ê\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÊ\u0001\u0010vR\u0016\u0010Ë\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bË\u0001\u0010vR\u0016\u0010Ì\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÌ\u0001\u0010vR\u0016\u0010Í\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÍ\u0001\u0010vR\u0016\u0010Î\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÎ\u0001\u0010vR\u0016\u0010Ï\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÏ\u0001\u0010vR\u0016\u0010Ð\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÐ\u0001\u0010vR\u0016\u0010Ñ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÑ\u0001\u0010vR\u0016\u0010Ò\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÒ\u0001\u0010vR\u0016\u0010Ó\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÓ\u0001\u0010vR\u0016\u0010Ô\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÔ\u0001\u0010vR\u0016\u0010Õ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÕ\u0001\u0010vR\u0016\u0010Ö\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÖ\u0001\u0010vR\u0016\u0010×\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b×\u0001\u0010vR\u0016\u0010Ø\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bØ\u0001\u0010vR\u0016\u0010Ù\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÙ\u0001\u0010vR\u0016\u0010Ú\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÚ\u0001\u0010vR\u0016\u0010Û\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÛ\u0001\u0010vR\u0016\u0010Ü\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÜ\u0001\u0010vR\u0016\u0010Ý\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÝ\u0001\u0010vR\u0016\u0010Þ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bÞ\u0001\u0010vR\u0016\u0010ß\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bß\u0001\u0010vR\u0016\u0010à\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bà\u0001\u0010vR\u0016\u0010á\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bá\u0001\u0010vR\u0016\u0010â\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bâ\u0001\u0010vR\u0016\u0010ã\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bã\u0001\u0010vR\u0016\u0010ä\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bä\u0001\u0010vR\u0016\u0010å\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bå\u0001\u0010vR\u0016\u0010æ\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bæ\u0001\u0010vR\u0016\u0010ç\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bç\u0001\u0010vR\u0016\u0010è\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bè\u0001\u0010vR\u0016\u0010é\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bé\u0001\u0010vR\u0016\u0010ê\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\bê\u0001\u0010v¨\u0006ë\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/ChatTracker;", "", "<init>", "()V", "", "event", "", "params", "", "realtime", "page", "LY8/t;", "z", "(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)V", "entryType", "y", "(Ljava/lang/String;)V", "l", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "source", "t", "(Ljava/lang/String;)Ljava/lang/String;", "u", "isVoice", "isScreenCircle", "C", "(ZZ)Ljava/lang/String;", "", "length", "k", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "previous", "incoming", "D", "(Ljava/lang/String;Ljava/lang/String;)Z", "sessionId", "chatId", "messageId", "sendType", "", "voiceDuration", "contentLength", "agentType", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "responseType", "contentType", "status", "agentName", "w", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sessionDuration", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "messageSource", "clickTarget", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "feedbackType", "actionType", "actionTime", "answerStayDuration", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "ttsStatus", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "LUa/M;", "scope", "sessionFallback", "Lcom/stepos/agentframework/chatui/N1;", "clicked", "F", "(LUa/M;Ljava/lang/String;Lcom/stepos/agentframework/chatui/N1;Ljava/lang/String;)V", "artifactCount", "e", "(Ljava/lang/String;Ljava/lang/Integer;)V", "fileName", "mimeType", "f", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "taskId", "artifactType", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "interruptSource", "afterInterruptAction", Const.INTENT_KEY_APIKEY, "uploadType", "fileType", "fileSize", "uploadStatus", "failReason", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "p", "durationMs", "o", "(Ljava/lang/Long;)V", "buttonName", "G", "(Ljava/lang/String;Ljava/lang/Long;)V", "triggerSource", "toStage", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;)V", "fromStage", "B", ExifInterface.LONGITUDE_EAST, Const.INTENT_KEY_UMID, "c", "pageFrom", "r", "s", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "PAGE_NAME", "Ljava/lang/String;", "PAGE_DESKTOP", "EVENT_MESSAGE_SEND", "EVENT_MESSAGE_RECEIVE", "EVENT_EXIT", "EVENT_BUTTON_CLICK", "EVENT_FEEDBACK_CLICK", "EVENT_BROADCAST_CLICK", "EVENT_ARTIFACT_EXPOSE", "EVENT_ARTIFACT_CLICK", "EVENT_ANSWER_INTERRUPT", "EVENT_MEDIA_UPLOAD", "EVENT_IMAGE_PREVIEW", "EVENT_IMAGE_RETRY", "EVENT_HOME_VIEW", "EVENT_HOME_LEAVE", "EVENT_WORLD_SWITCH", "EVENT_RESIZE", "EVENT_TOPBAR_CLICK", "EVENT_ARTIFACT_ENTRY_EXPOSE", "EVENT_ARTIFACT_ENTRY_CLICK", "EVENT_INPUT_ACTION", "EVENT_INPUT_ADD_CLICK", "EVENT_OPEN", "ENTRY_LOCKSCREEN_SHORTCUT", "ENTRY_VOICE_WAKEUP", "ENTRY_HOME_INPUT", "ENTRY_AT_KEY_CLICK", "ENTRY_ASK_AI_ENTRY", "ENTRY_SHARE_AGENT", "ENTRY_GUI_AGENT", "ENTRY_SIDEBAR_AGENT", "ENTRY_SIDEBAR_HISTORY_CHAT", "ENTRY_SIDEBAR_CREATE", "OPEN_INPUT", "OPEN_DESKTOP_CARD", "STAGE_HALF", "STAGE_FULL", "STAGE_CLOSE", "TRIGGER_UPSLIDE", "TRIGGER_KEYBOARD", "TRIGGER_DRAG", "TRIGGER_CLOSE_BUTTON", "TRIGGER_DOWNSLIDE", "TOPBAR_SIDEBAR", "TOPBAR_NEW_CHAT", "TOPBAR_MENU", "PAGE_FROM_DESKTOP", "PAGE_FROM_CHATVIEW", "INPUT_WRITE", "INPUT_LONGPRESS", "INPUT_ADD", "INPUT_VOICE", "INPUT_SEND", "INPUT_SEND_TEXT", "INPUT_SEND_VOICE", "INPUT_UPLOAD_FILE", "INPUT_UPLOAD_IMAGE", "INPUT_UPLOAD_TAKE_PHOTO", "sessionEntryType", "SEND_TEXT", "SEND_VOICE", "SEND_SCREEN_CLICK", "SEND_PRESET", "RESPONSE_NORMAL", "RESPONSE_TASK_CREATIVE", "CONTENT_TEXT", "CONTENT_DOC", "CONTENT_SHEET", "CONTENT_PPT", "CONTENT_PDF", "CONTENT_IMAGE", "CONTENT_VIDEO", "CONTENT_OTHER", "STATUS_SUCCESS", "STATUS_FAIL", "STATUS_TIMEOUT", "STATUS_CANCEL", "SOURCE_USER_MESSAGE", "SOURCE_ASSISTANT_MESSAGE", "CLICK_COPY", "CLICK_EDIT", "CLICK_DELETE", "CLICK_LIKE", "CLICK_CANCEL_LIKE", "CLICK_DISLIKE", "CLICK_CANCEL_DISLIKE", "CLICK_REGENERATE", "CLICK_STOP_GENERATE", "FEEDBACK_LIKE", "FEEDBACK_DISLIKE", "ACTION_ADD", "ACTION_CANCEL", "TTS_OPEN", "TTS_CLOSE", "INTERRUPT_GENERATING_RESPONSE", "INTERRUPT_REGENERATE_RESPONSE", "AFTER_INTERRUPT_RESEND_MESSAGE", "AFTER_INTERRUPT_CLEAR_INPUT", "AFTER_INTERRUPT_EDIT_CHAT", "UPLOAD_CAMERA", "UPLOAD_ALBUM", "UPLOAD_FILE", "FILE_IMAGE", "FILE_VIDEO", "FILE_DOCUMENT", "FILE_AUDIO", "PREVIEW_LOADING", "PREVIEW_SUCCESS", "PREVIEW_ALL_FAIL", "PREVIEW_CONTENT_BLOCKED", "PREVIEW_LOAD_FAIL", "PREVIEW_EXPIRED", "RETRY_ALL", "RETRY_SINGLE", "RETRY_RELOAD", "WORLD_OLD", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatTracker {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CANCEL = "cancel";
    public static final String AFTER_INTERRUPT_CLEAR_INPUT = "clear_input";
    public static final String AFTER_INTERRUPT_EDIT_CHAT = "exit_chat";
    public static final String AFTER_INTERRUPT_RESEND_MESSAGE = "resend_message";
    public static final String CLICK_CANCEL_DISLIKE = "cancel_dislike";
    public static final String CLICK_CANCEL_LIKE = "cancel_like";
    public static final String CLICK_COPY = "copy";
    public static final String CLICK_DELETE = "delete";
    public static final String CLICK_DISLIKE = "dislike";
    public static final String CLICK_EDIT = "edit";
    public static final String CLICK_LIKE = "like";
    public static final String CLICK_REGENERATE = "regenerate";
    public static final String CLICK_STOP_GENERATE = "stop_generate";
    public static final String CONTENT_DOC = "doc";
    public static final String CONTENT_IMAGE = "image";
    public static final String CONTENT_OTHER = "other";
    public static final String CONTENT_PDF = "pdf";
    public static final String CONTENT_PPT = "ppt";
    public static final String CONTENT_SHEET = "sheet";
    public static final String CONTENT_TEXT = "text";
    public static final String CONTENT_VIDEO = "video";
    public static final String ENTRY_ASK_AI_ENTRY = "ask_ai_entry";
    public static final String ENTRY_AT_KEY_CLICK = "ai_key_click";
    public static final String ENTRY_GUI_AGENT = "gui_agent";
    public static final String ENTRY_HOME_INPUT = "home_inputbar";
    public static final String ENTRY_LOCKSCREEN_SHORTCUT = "lockscreen_shortcut";
    public static final String ENTRY_SHARE_AGENT = "share_agent";
    public static final String ENTRY_SIDEBAR_AGENT = "sidebar_agent";
    public static final String ENTRY_SIDEBAR_CREATE = "sidebar_create";
    public static final String ENTRY_SIDEBAR_HISTORY_CHAT = "sidebar_historychat";
    public static final String ENTRY_VOICE_WAKEUP = "voice_wakeup";
    private static final String EVENT_ANSWER_INTERRUPT = "chatview_answer_interrupt";
    private static final String EVENT_ARTIFACT_CLICK = "chatview_artifact_click";
    private static final String EVENT_ARTIFACT_ENTRY_CLICK = "chatview_artifact_entry_click";
    private static final String EVENT_ARTIFACT_ENTRY_EXPOSE = "chatview_artifact_entry_expose";
    private static final String EVENT_ARTIFACT_EXPOSE = "chatview_artifact_expose";
    private static final String EVENT_BROADCAST_CLICK = "chatview_broadcast_click";
    private static final String EVENT_BUTTON_CLICK = "chatview_button_click";
    private static final String EVENT_EXIT = "chatview_exit";
    private static final String EVENT_FEEDBACK_CLICK = "chatview_feedback_click";
    private static final String EVENT_HOME_LEAVE = "chatview_home_leave";
    private static final String EVENT_HOME_VIEW = "chatview_home_view";
    private static final String EVENT_IMAGE_PREVIEW = "chatview_image_preview";
    private static final String EVENT_IMAGE_RETRY = "chatview_image_retry";
    private static final String EVENT_INPUT_ACTION = "input_action";
    private static final String EVENT_INPUT_ADD_CLICK = "input_add_click";
    private static final String EVENT_MEDIA_UPLOAD = "chatview_media_upload";
    private static final String EVENT_MESSAGE_RECEIVE = "chatview_message_receive";
    private static final String EVENT_MESSAGE_SEND = "chatview_message_send";
    private static final String EVENT_OPEN = "chatview_open";
    private static final String EVENT_RESIZE = "chatview_resize";
    private static final String EVENT_TOPBAR_CLICK = "chatview_topbar_click";
    private static final String EVENT_WORLD_SWITCH = "world_switch_click";
    public static final String FEEDBACK_DISLIKE = "dislike";
    public static final String FEEDBACK_LIKE = "like";
    public static final String FILE_AUDIO = "audio";
    public static final String FILE_DOCUMENT = "document";
    public static final String FILE_IMAGE = "image";
    public static final String FILE_VIDEO = "video";
    public static final String INPUT_ADD = "add";
    public static final String INPUT_LONGPRESS = "inputbox_longpress";
    public static final String INPUT_SEND = "send";
    public static final String INPUT_SEND_TEXT = "text";
    public static final String INPUT_SEND_VOICE = "voice";
    public static final String INPUT_UPLOAD_FILE = "file_upload";
    public static final String INPUT_UPLOAD_IMAGE = "image_upload";
    public static final String INPUT_UPLOAD_TAKE_PHOTO = "take_photo";
    public static final String INPUT_VOICE = "voice";
    public static final String INPUT_WRITE = "inputbox_write";
    public static final ChatTracker INSTANCE = new ChatTracker();
    public static final String INTERRUPT_GENERATING_RESPONSE = "generating_response";
    public static final String INTERRUPT_REGENERATE_RESPONSE = "regenerate_response";
    public static final String OPEN_DESKTOP_CARD = "desktop_card";
    public static final String OPEN_INPUT = "input";
    private static final String PAGE_DESKTOP = "desktop";
    public static final String PAGE_FROM_CHATVIEW = "chatview";
    public static final String PAGE_FROM_DESKTOP = "desktop";
    private static final String PAGE_NAME = "chatview";
    public static final String PREVIEW_ALL_FAIL = "all_fail";
    public static final String PREVIEW_CONTENT_BLOCKED = "content_blocked";
    public static final String PREVIEW_EXPIRED = "expired";
    public static final String PREVIEW_LOADING = "loading";
    public static final String PREVIEW_LOAD_FAIL = "load_fail";
    public static final String PREVIEW_SUCCESS = "success";
    public static final String RESPONSE_NORMAL = "normal";
    public static final String RESPONSE_TASK_CREATIVE = "task_creation";
    public static final String RETRY_ALL = "all_retry";
    public static final String RETRY_RELOAD = "reload";
    public static final String RETRY_SINGLE = "single_retry";
    public static final String SEND_PRESET = "preset";
    public static final String SEND_SCREEN_CLICK = "screen_circle";
    public static final String SEND_TEXT = "text";
    public static final String SEND_VOICE = "voice";
    public static final String SOURCE_ASSISTANT_MESSAGE = "assistant_message";
    public static final String SOURCE_USER_MESSAGE = "user_message";
    public static final String STAGE_CLOSE = "close";
    public static final String STAGE_FULL = "full";
    public static final String STAGE_HALF = "half";
    public static final String STATUS_CANCEL = "cancel";
    public static final String STATUS_FAIL = "fail";
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_TIMEOUT = "timeout";
    public static final String TOPBAR_MENU = "menu";
    public static final String TOPBAR_NEW_CHAT = "new_chat";
    public static final String TOPBAR_SIDEBAR = "sidebar";
    public static final String TRIGGER_CLOSE_BUTTON = "close_button";
    public static final String TRIGGER_DOWNSLIDE = "downslide";
    public static final String TRIGGER_DRAG = "drag";
    public static final String TRIGGER_KEYBOARD = "keyboard";
    public static final String TRIGGER_UPSLIDE = "upslide";
    public static final String TTS_CLOSE = "close";
    public static final String TTS_OPEN = "open";
    public static final String UPLOAD_ALBUM = "album_upload";
    public static final String UPLOAD_CAMERA = "camera_upload";
    public static final String UPLOAD_FILE = "file_upload";
    public static final String WORLD_OLD = "old";
    private static volatile String sessionEntryType;

    public static /* synthetic */ void A(ChatTracker chatTracker, String str, Map map, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            str2 = "chatview";
        }
        chatTracker.z(str, map, z10, str2);
    }

    public final void B(String sessionId, String fromStage, String toStage, String triggerSource) {
        if (p.d(fromStage, toStage)) {
            return;
        }
        A(this, EVENT_RESIZE, kotlin.collections.a.m(j.a("to_stage", toStage), j.a("from_stage", fromStage), j.a("trigger_source", triggerSource), j.a("session_id", sessionId)), false, null, 12, null);
    }

    public final String C(boolean isVoice, boolean isScreenCircle) {
        return isVoice ? "voice" : isScreenCircle ? SEND_SCREEN_CLICK : "text";
    }

    public final boolean D(String previous, String incoming) {
        p.i(incoming, "incoming");
        if (previous == null) {
            return true;
        }
        if (p.d(previous, incoming) || p.d(incoming, "success")) {
            return false;
        }
        return p.d(previous, "success");
    }

    public final void E(String sessionId, String clickTarget) {
        A(this, EVENT_TOPBAR_CLICK, kotlin.collections.a.m(j.a("click_target", clickTarget), j.a("session_id", sessionId)), false, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(Ua.M r10, java.lang.String r11, com.stepos.agentframework.chatui.DisplayMessage r12, java.lang.String r13) {
        /*
            r9 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.p.i(r10, r0)
            r0 = 0
            if (r12 == 0) goto L1c
            java.lang.String r2 = r12.getSessionId()
            if (r2 == 0) goto L1c
            int r3 = r2.length()
            if (r3 <= 0) goto L16
            goto L17
        L16:
            r2 = r0
        L17:
            if (r2 != 0) goto L1a
            goto L1c
        L1a:
            r4 = r2
            goto L27
        L1c:
            if (r11 == 0) goto L26
            int r2 = r11.length()
            if (r2 <= 0) goto L26
            r4 = r11
            goto L27
        L26:
            r4 = r0
        L27:
            if (r12 == 0) goto L37
            java.lang.String r2 = r12.getPairId()
            if (r2 == 0) goto L37
            int r3 = r2.length()
            if (r3 <= 0) goto L37
            r5 = r2
            goto L38
        L37:
            r5 = r0
        L38:
            if (r12 == 0) goto L48
            java.lang.String r2 = r12.getMessageId()
            if (r2 == 0) goto L48
            int r3 = r2.length()
            if (r3 <= 0) goto L48
            r6 = r2
            goto L49
        L48:
            r6 = r0
        L49:
            if (r4 == 0) goto L5a
            int r0 = r4.length()
            if (r0 != 0) goto L52
            goto L5a
        L52:
            if (r5 == 0) goto L5a
            if (r6 == 0) goto L5a
            r9.g(r4, r5, r6, r13)
            return
        L5a:
            if (r4 == 0) goto L73
            int r0 = r4.length()
            if (r0 != 0) goto L63
            goto L73
        L63:
            com.stepos.ailauncher.chat.trace.ChatTracker$trackBroadcast$1 r3 = new com.stepos.ailauncher.chat.trace.ChatTracker$trackBroadcast$1
            r8 = 0
            r7 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r5 = 3
            r6 = 0
            r2 = 0
            r4 = r3
            r3 = 0
            r1 = r10
            Ua.C1056g.d(r1, r2, r3, r4, r5, r6)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.trace.ChatTracker.F(Ua.M, java.lang.String, com.stepos.agentframework.chatui.N1, java.lang.String):void");
    }

    public final void G(String buttonName, Long durationMs) {
        A(this, EVENT_WORLD_SWITCH, kotlin.collections.a.m(j.a("button_name", buttonName), j.a("duration", durationMs)), false, null, 12, null);
    }

    public final void a(String sessionId, String chatId, String messageId, String interruptSource, String afterInterruptAction) {
        A(this, EVENT_ANSWER_INTERRUPT, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("interrupt_source", interruptSource), j.a("after_interrupt_action", afterInterruptAction))), false, null, 12, null);
    }

    public final void b(String sessionId, String taskId, String artifactType) {
        A(this, EVENT_ARTIFACT_CLICK, kotlin.collections.a.m(j.a("session_id", sessionId), j.a("task_id", taskId), j.a("artifact_type", artifactType)), false, null, 12, null);
    }

    public final void c(String sessionId) {
        A(this, EVENT_ARTIFACT_ENTRY_CLICK, Q.f(j.a("session_id", sessionId)), false, null, 12, null);
    }

    public final void d(String sessionId) {
        A(this, EVENT_ARTIFACT_ENTRY_EXPOSE, Q.f(j.a("session_id", sessionId)), false, null, 12, null);
    }

    public final void e(String sessionId, Integer artifactCount) {
        A(this, EVENT_ARTIFACT_EXPOSE, kotlin.collections.a.m(j.a("session_id", sessionId), j.a("artifact_count", artifactCount)), false, null, 12, null);
    }

    public final String f(String fileName, String mimeType) {
        String strA = M5.c.INSTANCE.A(fileName, mimeType);
        int iHashCode = strA.hashCode();
        return iHashCode != 3682393 ? iHashCode != 100313435 ? (iHashCode == 112202875 && strA.equals("video")) ? "video" : CONTENT_DOC : !strA.equals("image") ? CONTENT_DOC : "image" : !strA.equals("xlsx") ? CONTENT_DOC : CONTENT_SHEET;
    }

    public final void g(String sessionId, String chatId, String messageId, String ttsStatus) {
        if (sessionId != null) {
            if (sessionId.length() <= 0) {
                sessionId = null;
            }
            if (sessionId == null || chatId == null) {
                return;
            }
            if (chatId.length() <= 0) {
                chatId = null;
            }
            if (chatId == null || messageId == null) {
                return;
            }
            if (messageId.length() <= 0) {
                messageId = null;
            }
            if (messageId == null) {
                return;
            }
            A(this, EVENT_BROADCAST_CLICK, kotlin.collections.a.r(q(sessionId, chatId, messageId), Q.f(j.a("to_status", ttsStatus))), false, null, 12, null);
        }
    }

    public final void h(String sessionId, String chatId, String messageId, String messageSource, String clickTarget) {
        A(this, EVENT_BUTTON_CLICK, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("message_source", messageSource), j.a("click_target", clickTarget))), false, null, 12, null);
    }

    public final void i(String triggerSource, String toStage) {
        A(this, EVENT_OPEN, kotlin.collections.a.m(j.a("trigger_source", triggerSource), j.a("to_stage", toStage)), false, null, 12, null);
    }

    public final void j() {
        sessionEntryType = null;
        C3475d.INSTANCE.a();
    }

    public final Integer k(Integer length) {
        if (length == null || length.intValue() <= 0) {
            return null;
        }
        return length;
    }

    public final String l() {
        return sessionEntryType;
    }

    public final void m(String sessionId, String chatId, String messageId, Long sessionDuration) {
        A(this, EVENT_EXIT, kotlin.collections.a.r(q(sessionId, chatId, messageId), Q.f(j.a("session_duration", sessionDuration))), true, null, 8, null);
        j();
    }

    public final void n(String sessionId, String chatId, String messageId, String feedbackType, String actionType, Long actionTime, Long answerStayDuration) {
        A(this, EVENT_FEEDBACK_CLICK, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("feedback_type", feedbackType), j.a("action_type", actionType), j.a("action_time", actionTime), j.a("answer_stay_duration", answerStayDuration))), false, null, 12, null);
    }

    public final void o(Long durationMs) {
        A(this, EVENT_HOME_LEAVE, Q.f(j.a("duration", durationMs)), false, null, 12, null);
    }

    public final void p() {
        A(this, EVENT_HOME_VIEW, kotlin.collections.a.i(), false, null, 12, null);
    }

    public final Map<String, Object> q(String sessionId, String chatId, String messageId) {
        if (sessionId == null) {
            sessionId = "";
        }
        Pair pairA = j.a("session_id", sessionId);
        if (chatId == null) {
            chatId = "";
        }
        Pair pairA2 = j.a("chat_id", chatId);
        if (messageId == null) {
            messageId = "";
        }
        return kotlin.collections.a.m(pairA, pairA2, j.a(RequestParameter.META_KEY_MESSAGE_ID, messageId));
    }

    public final void r(String pageFrom, String clickTarget, String sendType) {
        A(this, EVENT_INPUT_ACTION, kotlin.collections.a.m(j.a("page_from", pageFrom), j.a("click_target", clickTarget), j.a("send_type", sendType)), false, "desktop", 4, null);
    }

    public final void s(String pageFrom, String uploadType) {
        A(this, EVENT_INPUT_ADD_CLICK, kotlin.collections.a.m(j.a("upload_type", uploadType), j.a("page_from", pageFrom)), false, "desktop", 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0083 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String t(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L84
            int r1 = r2.hashCode()
            java.lang.String r0 = "ai_key_click"
            switch(r1) {
                case -1418033720: goto L7a;
                case -951070683: goto L6e;
                case -926107835: goto L65;
                case -833467215: goto L5c;
                case -548645468: goto L50;
                case 3208415: goto L47;
                case 293766892: goto L3c;
                case 390025893: goto L31;
                case 643045183: goto L28;
                case 684453624: goto L1f;
                case 797870729: goto L15;
                case 1080244305: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto L84
        Ld:
            boolean r1 = r2.equals(r0)
            if (r1 != 0) goto L83
            goto L84
        L15:
            java.lang.String r1 = "lock_screen_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L59
            goto L84
        L1f:
            java.lang.String r1 = "ai_key_long_click_end"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L83
            goto L84
        L28:
            java.lang.String r1 = "ai_key_long_click_start"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L83
            goto L84
        L31:
            java.lang.String r1 = "share_agent"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L3b
            goto L84
        L3b:
            return r1
        L3c:
            java.lang.String r1 = "voice_wakeup"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L46
            goto L84
        L46:
            return r1
        L47:
            java.lang.String r1 = "home"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L77
            goto L84
        L50:
            java.lang.String r1 = "lock_screen_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L59
            goto L84
        L59:
            java.lang.String r1 = "lockscreen_shortcut"
            return r1
        L5c:
            java.lang.String r1 = "ai_key_double_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L83
            goto L84
        L65:
            java.lang.String r1 = "home_key_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L77
            goto L84
        L6e:
            java.lang.String r1 = "bottom_bar_key_long_click"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L77
            goto L84
        L77:
            java.lang.String r1 = "home_inputbar"
            return r1
        L7a:
            java.lang.String r1 = "ai_key"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L83
            goto L84
        L83:
            return r0
        L84:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.trace.ChatTracker.t(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4.equals(k5.C4814a.AI_KEY_LONG_CLICK_END) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r4.equals(k5.C4814a.AI_KEY_LONG_CLICK_START) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r4.equals(k5.C4814a.AI_KEY_DOUBLE_CLICK) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r4.equals(k5.C4814a.AI_KEY_CLICK2) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        return "ai_key_click";
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r4.equals("ai_key_click") == false) goto L50;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String u(java.lang.String r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L87
            int r0 = r4.hashCode()
            java.lang.String r1 = "home_inputbar"
            java.lang.String r2 = "ai_key_click"
            switch(r0) {
                case -1418033720: goto L7d;
                case -951070683: goto L73;
                case -926107835: goto L69;
                case -833467215: goto L60;
                case -548645468: goto L54;
                case 3208415: goto L49;
                case 293766892: goto L3e;
                case 390025893: goto L33;
                case 643045183: goto L2a;
                case 684453624: goto L21;
                case 797870729: goto L17;
                case 1080244305: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto L87
        Lf:
            boolean r0 = r4.equals(r2)
            if (r0 != 0) goto L86
            goto L87
        L17:
            java.lang.String r0 = "lock_screen_click"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5d
            goto L87
        L21:
            java.lang.String r0 = "ai_key_long_click_end"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L86
            goto L87
        L2a:
            java.lang.String r0 = "ai_key_long_click_start"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L86
            goto L87
        L33:
            java.lang.String r0 = "share_agent"
            boolean r1 = r4.equals(r0)
            if (r1 != 0) goto L3d
            goto L87
        L3d:
            return r0
        L3e:
            java.lang.String r0 = "voice_wakeup"
            boolean r1 = r4.equals(r0)
            if (r1 != 0) goto L48
            goto L87
        L48:
            return r0
        L49:
            java.lang.String r0 = "home"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L87
            java.lang.String r3 = "input"
            return r3
        L54:
            java.lang.String r0 = "lock_screen_long_click"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5d
            goto L87
        L5d:
            java.lang.String r3 = "lockscreen_shortcut"
            return r3
        L60:
            java.lang.String r0 = "ai_key_double_click"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L86
            goto L87
        L69:
            java.lang.String r0 = "home_key_long_click"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L72
            goto L87
        L72:
            return r1
        L73:
            java.lang.String r0 = "bottom_bar_key_long_click"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L7c
            goto L87
        L7c:
            return r1
        L7d:
            java.lang.String r0 = "ai_key"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L86
            goto L87
        L86:
            return r2
        L87:
            java.lang.String r3 = r3.t(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.trace.ChatTracker.u(java.lang.String):java.lang.String");
    }

    public final void v(String sessionId, String chatId, String messageId, String uploadType, String fileType, Long fileSize, String uploadStatus, String failReason) {
        A(this, EVENT_MEDIA_UPLOAD, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("upload_type", uploadType), j.a("file_type", fileType), j.a("file_size", fileSize), j.a("upload_status", uploadStatus), j.a("fail_reason", failReason))), false, null, 12, null);
    }

    public final void w(String sessionId, String chatId, String messageId, String responseType, String contentType, String status, String agentName) {
        A(this, EVENT_MESSAGE_RECEIVE, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("response_type", responseType), j.a("content_type", contentType), j.a("status", status), j.a("agent_name", b.INSTANCE.a(agentName)))), false, null, 12, null);
    }

    public final void x(String sessionId, String chatId, String messageId, String entryType, String sendType, Long voiceDuration, Integer contentLength, String agentType) {
        A(this, EVENT_MESSAGE_SEND, kotlin.collections.a.r(q(sessionId, chatId, messageId), kotlin.collections.a.m(j.a("entry_type", entryType), j.a("send_type", sendType), j.a("voice_duration", voiceDuration), j.a("content_length", k(contentLength)), j.a("agent_type", b.INSTANCE.a(agentType)))), false, null, 12, null);
    }

    public final void y(String entryType) {
        if (entryType == null || H.x0(entryType)) {
            return;
        }
        sessionEntryType = entryType;
        C3475d.INSTANCE.c(entryType);
    }

    public final void z(String event, Map<String, ? extends Object> params, boolean realtime, String page) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map.put(key, value.toString());
            }
        }
        C4148a.k("Track", event + " page=" + page + " " + map, false, 4, null);
        if (realtime) {
            N.b(event, page, map);
        } else {
            N.a(event, page, map);
        }
    }
}
