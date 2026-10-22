package com.stepos.ailauncher.agent.skill;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.taskstore.provider.c;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b3\b\u0087\b\u0018\u00002\u00020\u0001B§\u0003\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u000f¢\u0006\u0004\b0\u00101J\u001d\u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0012\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b:\u00109J\u0012\u0010;\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b;\u00109J\u0010\u0010<\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b<\u00109J\u0012\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b=\u00109J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u00109J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u00109J\u0012\u0010@\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b@\u00109J\u0012\u0010A\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bA\u00109J\u0012\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\bB\u0010CJ\u0012\u0010D\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bD\u00109J\u0012\u0010E\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\bE\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bG\u00109J\u0012\u0010H\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bH\u00109J\u0012\u0010I\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bI\u00109J\u0012\u0010J\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bJ\u00109J\u0012\u0010K\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bK\u00109J\u0012\u0010L\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bL\u00109J\u0012\u0010M\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bM\u00109J\u0010\u0010N\u001a\u00020\fHÆ\u0003¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\bP\u00101J\u0012\u0010Q\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bQ\u00109J\u0012\u0010R\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bR\u00109J\u0010\u0010S\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\bS\u00101J\u0012\u0010T\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bT\u00109J\u0012\u0010U\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\bU\u0010VJ\u0012\u0010W\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bW\u00109J\u0012\u0010X\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bX\u00109J\u0012\u0010Y\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\bY\u0010VJ\u0012\u0010Z\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\bZ\u0010FJ\u0012\u0010[\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b[\u00109J\u0012\u0010\\\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b\\\u0010]J\u0012\u0010^\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b^\u00109J\u0012\u0010_\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b_\u0010`J\u0012\u0010a\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0004\ba\u0010bJ\u0012\u0010c\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\bc\u0010dJ¶\u0003\u0010e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,HÆ\u0001¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bg\u00109J\u0010\u0010h\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\bh\u00101J\u001a\u0010k\u001a\u00020\u001e2\b\u0010j\u001a\u0004\u0018\u00010iHÖ\u0003¢\u0006\u0004\bk\u0010lR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010m\u001a\u0004\bn\u00109R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010m\u001a\u0004\bo\u00109R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010m\u001a\u0004\bp\u00109R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010m\u001a\u0004\bq\u00109R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010m\u001a\u0004\br\u00109R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010m\u001a\u0004\bs\u00109R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010m\u001a\u0004\bt\u00109R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010m\u001a\u0004\bu\u00109R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010m\u001a\u0004\bv\u00109R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010w\u001a\u0004\bx\u0010CR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010m\u001a\u0004\by\u00109R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010z\u001a\u0004\b{\u0010FR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010m\u001a\u0004\b|\u00109R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010m\u001a\u0004\b}\u00109R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010m\u001a\u0004\b~\u00109R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010m\u001a\u0004\b\u007f\u00109R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b\u0015\u0010m\u001a\u0005\b\u0080\u0001\u00109R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b\u0016\u0010m\u001a\u0005\b\u0081\u0001\u00109R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b\u0017\u0010m\u001a\u0005\b\u0082\u0001\u00109R\u0019\u0010\u0018\u001a\u00020\f8\u0006¢\u0006\u000e\n\u0005\b\u0018\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010OR\u001c\u0010\u0019\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0019\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u00101R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u001a\u0010m\u001a\u0005\b\u0087\u0001\u00109R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b\u001b\u0010m\u001a\u0005\b\u0088\u0001\u00109R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006¢\u0006\u000e\n\u0005\b\u001c\u0010\u0085\u0001\u001a\u0005\b\u0089\u0001\u00101R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b\u001d\u0010m\u001a\u0005\b\u008a\u0001\u00109R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\u000e\n\u0005\b\u001f\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010VR\u001a\u0010 \u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b \u0010m\u001a\u0005\b\u008d\u0001\u00109R\u001a\u0010!\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b!\u0010m\u001a\u0005\b\u008e\u0001\u00109R\u001a\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\r\n\u0005\b\"\u0010\u008b\u0001\u001a\u0004\b\"\u0010VR\u001a\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\r\n\u0004\b#\u0010z\u001a\u0005\b\u008f\u0001\u0010FR\u001a\u0010$\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b$\u0010m\u001a\u0005\b\u0090\u0001\u00109R\u001e\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b&\u0010\u0091\u0001\u001a\u0005\b\u0092\u0001\u0010]R\u001d\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b'\u0010m\u001a\u0005\b\u0093\u0001\u00109R\u001e\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b)\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010`R\u001b\u0010+\u001a\u0004\u0018\u00010*8\u0006¢\u0006\u000e\n\u0005\b+\u0010\u0096\u0001\u001a\u0005\b\u0097\u0001\u0010bR\u001b\u0010-\u001a\u0004\u0018\u00010,8\u0006¢\u0006\u000e\n\u0005\b-\u0010\u0098\u0001\u001a\u0005\b\u0099\u0001\u0010dR\u0013\u0010\u009b\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u00109¨\u0006\u009c\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Landroid/os/Parcelable;", "", "slug", "name", "displayName", c.a.COL_SUMMARY, "author", "license", "source", "ownerId", "skillUpdateTime", "", "versionId", "versionSkillId", "", "versionCode", "versionName", "version", "versionUpdateTime", "createTime", "updateTime", QueryAlgorithmBundle.KEY_CATEGORY, "categoryName", "downloadCount", "needUpdate", "installVersion", "statusMessage", "necessary", "path", "", "hasSkillMd", "localZipAbsolutePath", "remoteZipUrl", "isImportedPrivate", "taskSource", "catalogDescription", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "iconUrl", "Lcom/stepos/ailauncher/agent/skill/InstallSource;", "installSource", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "installKind", "Lcom/stepos/ailauncher/agent/skill/SkillSource;", "clientSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/InstallSource;Lcom/stepos/ailauncher/agent/skill/InstallKind;Lcom/stepos/ailauncher/agent/skill/SkillSource;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Long;", "component11", "component12", "()Ljava/lang/Integer;", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "()J", "component21", "component22", "component23", "component24", "component25", "component26", "()Ljava/lang/Boolean;", "component27", "component28", "component29", "component30", "component31", "component32", "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "component33", "component34", "()Lcom/stepos/ailauncher/agent/skill/InstallSource;", "component35", "()Lcom/stepos/ailauncher/agent/skill/InstallKind;", "component36", "()Lcom/stepos/ailauncher/agent/skill/SkillSource;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/SkillStatus;Ljava/lang/String;Lcom/stepos/ailauncher/agent/skill/InstallSource;Lcom/stepos/ailauncher/agent/skill/InstallKind;Lcom/stepos/ailauncher/agent/skill/SkillSource;)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSlug", "getName", "getDisplayName", "getSummary", "getAuthor", "getLicense", "getSource", "getOwnerId", "getSkillUpdateTime", "Ljava/lang/Long;", "getVersionId", "getVersionSkillId", "Ljava/lang/Integer;", "getVersionCode", "getVersionName", "getVersion", "getVersionUpdateTime", "getCreateTime", "getUpdateTime", "getCategory", "getCategoryName", "J", "getDownloadCount", "I", "getNeedUpdate", "getInstallVersion", "getStatusMessage", "getNecessary", "getPath", "Ljava/lang/Boolean;", "getHasSkillMd", "getLocalZipAbsolutePath", "getRemoteZipUrl", "getTaskSource", "getCatalogDescription", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "getStatus", "getIconUrl", "Lcom/stepos/ailauncher/agent/skill/InstallSource;", "getInstallSource", "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "getInstallKind", "Lcom/stepos/ailauncher/agent/skill/SkillSource;", "getClientSource", "getIdentifier", "identifier", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillItem implements Parcelable {
    public static final Parcelable.Creator<SkillItem> CREATOR = new a();
    private final String author;
    private final String catalogDescription;
    private final String category;
    private final String categoryName;
    private final transient SkillSource clientSource;
    private final String createTime;
    private final String displayName;
    private final long downloadCount;
    private final Boolean hasSkillMd;

    @SerializedName(alternate = {"iconUrl", "icon_url"}, value = "icon")
    private final String iconUrl;
    private final InstallKind installKind;

    @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
    private final InstallSource installSource;

    @SerializedName("installVersion")
    private final String installVersion;
    private final Boolean isImportedPrivate;
    private final String license;
    private final String localZipAbsolutePath;
    private final String name;
    private final int necessary;

    @SerializedName("needUpdate")
    private final int needUpdate;
    private final String ownerId;
    private final String path;
    private final String remoteZipUrl;
    private final String skillUpdateTime;

    @SerializedName("id")
    private final String slug;
    private final String source;

    @SerializedName("status")
    private final SkillStatus status;
    private final String statusMessage;

    @SerializedName("description")
    private final String summary;
    private final Integer taskSource;
    private final String updateTime;

    @SerializedName("version")
    private final String version;
    private final Integer versionCode;
    private final Long versionId;
    private final String versionName;
    private final String versionSkillId;
    private final String versionUpdateTime;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<SkillItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SkillItem createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string10 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            String string13 = parcel.readString();
            String string14 = parcel.readString();
            String string15 = parcel.readString();
            String string16 = parcel.readString();
            String string17 = parcel.readString();
            long j10 = parcel.readLong();
            int i10 = parcel.readInt();
            String string18 = parcel.readString();
            String string19 = parcel.readString();
            int i11 = parcel.readInt();
            String string20 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            boolean z10 = false;
            String string21 = parcel.readString();
            String string22 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                if (parcel.readInt() != 0) {
                    z10 = true;
                }
                boolValueOf2 = Boolean.valueOf(z10);
            }
            return new SkillItem(string, string2, string3, string4, string5, string6, string7, string8, string9, lValueOf, string10, numValueOf, string11, string12, string13, string14, string15, string16, string17, j10, i10, string18, string19, i11, string20, boolValueOf, string21, string22, boolValueOf2, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : SkillStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : InstallSource.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : InstallKind.valueOf(parcel.readString()), parcel.readInt() != 0 ? SkillSource.valueOf(parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SkillItem[] newArray(int i10) {
            return new SkillItem[i10];
        }
    }

    public SkillItem(String str, String name, String str2, String summary, String str3, String str4, String str5, String str6, String str7, Long l10, String str8, Integer num, String str9, String str10, String str11, String str12, String str13, String str14, String str15, long j10, int i10, String str16, String str17, int i11, String str18, Boolean bool, String str19, String str20, Boolean bool2, Integer num2, String str21, SkillStatus skillStatus, String str22, InstallSource installSource, InstallKind installKind, SkillSource skillSource) {
        p.i(name, "name");
        p.i(summary, "summary");
        this.slug = str;
        this.name = name;
        this.displayName = str2;
        this.summary = summary;
        this.author = str3;
        this.license = str4;
        this.source = str5;
        this.ownerId = str6;
        this.skillUpdateTime = str7;
        this.versionId = l10;
        this.versionSkillId = str8;
        this.versionCode = num;
        this.versionName = str9;
        this.version = str10;
        this.versionUpdateTime = str11;
        this.createTime = str12;
        this.updateTime = str13;
        this.category = str14;
        this.categoryName = str15;
        this.downloadCount = j10;
        this.needUpdate = i10;
        this.installVersion = str16;
        this.statusMessage = str17;
        this.necessary = i11;
        this.path = str18;
        this.hasSkillMd = bool;
        this.localZipAbsolutePath = str19;
        this.remoteZipUrl = str20;
        this.isImportedPrivate = bool2;
        this.taskSource = num2;
        this.catalogDescription = str21;
        this.status = skillStatus;
        this.iconUrl = str22;
        this.installSource = installSource;
        this.installKind = installKind;
        this.clientSource = skillSource;
    }

    public static /* synthetic */ SkillItem copy$default(SkillItem skillItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l10, String str10, Integer num, String str11, String str12, String str13, String str14, String str15, String str16, String str17, long j10, int i10, String str18, String str19, int i11, String str20, Boolean bool, String str21, String str22, Boolean bool2, Integer num2, String str23, SkillStatus skillStatus, String str24, InstallSource installSource, InstallKind installKind, SkillSource skillSource, int i12, int i13, Object obj) {
        SkillSource skillSource2;
        InstallKind installKind2;
        String str25 = (i12 & 1) != 0 ? skillItem.slug : str;
        String str26 = (i12 & 2) != 0 ? skillItem.name : str2;
        String str27 = (i12 & 4) != 0 ? skillItem.displayName : str3;
        String str28 = (i12 & 8) != 0 ? skillItem.summary : str4;
        String str29 = (i12 & 16) != 0 ? skillItem.author : str5;
        String str30 = (i12 & 32) != 0 ? skillItem.license : str6;
        String str31 = (i12 & 64) != 0 ? skillItem.source : str7;
        String str32 = (i12 & 128) != 0 ? skillItem.ownerId : str8;
        String str33 = (i12 & 256) != 0 ? skillItem.skillUpdateTime : str9;
        Long l11 = (i12 & 512) != 0 ? skillItem.versionId : l10;
        String str34 = (i12 & 1024) != 0 ? skillItem.versionSkillId : str10;
        Integer num3 = (i12 & 2048) != 0 ? skillItem.versionCode : num;
        String str35 = (i12 & 4096) != 0 ? skillItem.versionName : str11;
        String str36 = (i12 & b.THRESHOLD) != 0 ? skillItem.version : str12;
        String str37 = str25;
        String str38 = (i12 & 16384) != 0 ? skillItem.versionUpdateTime : str13;
        String str39 = (i12 & 32768) != 0 ? skillItem.createTime : str14;
        String str40 = (i12 & 65536) != 0 ? skillItem.updateTime : str15;
        String str41 = (i12 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? skillItem.category : str16;
        String str42 = (i12 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? skillItem.categoryName : str17;
        String str43 = str38;
        long j11 = (i12 & 524288) != 0 ? skillItem.downloadCount : j10;
        int i14 = (i12 & 1048576) != 0 ? skillItem.needUpdate : i10;
        String str44 = (i12 & 2097152) != 0 ? skillItem.installVersion : str18;
        int i15 = i14;
        String str45 = (i12 & 4194304) != 0 ? skillItem.statusMessage : str19;
        int i16 = (i12 & 8388608) != 0 ? skillItem.necessary : i11;
        String str46 = (i12 & 16777216) != 0 ? skillItem.path : str20;
        Boolean bool3 = (i12 & Const.FLAG_MUTABLE) != 0 ? skillItem.hasSkillMd : bool;
        String str47 = (i12 & 67108864) != 0 ? skillItem.localZipAbsolutePath : str21;
        String str48 = (i12 & 134217728) != 0 ? skillItem.remoteZipUrl : str22;
        Boolean bool4 = (i12 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? skillItem.isImportedPrivate : bool2;
        Integer num4 = (i12 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? skillItem.taskSource : num2;
        String str49 = (i12 & 1073741824) != 0 ? skillItem.catalogDescription : str23;
        SkillStatus skillStatus2 = (i12 & Integer.MIN_VALUE) != 0 ? skillItem.status : skillStatus;
        String str50 = (i13 & 1) != 0 ? skillItem.iconUrl : str24;
        InstallSource installSource2 = (i13 & 2) != 0 ? skillItem.installSource : installSource;
        InstallKind installKind3 = (i13 & 4) != 0 ? skillItem.installKind : installKind;
        if ((i13 & 8) != 0) {
            installKind2 = installKind3;
            skillSource2 = skillItem.clientSource;
        } else {
            skillSource2 = skillSource;
            installKind2 = installKind3;
        }
        return skillItem.copy(str37, str26, str27, str28, str29, str30, str31, str32, str33, l11, str34, num3, str35, str36, str43, str39, str40, str41, str42, j11, i15, str44, str45, i16, str46, bool3, str47, str48, bool4, num4, str49, skillStatus2, str50, installSource2, installKind2, skillSource2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getVersionId() {
        return this.versionId;
    }

    /* renamed from: component11, reason: from getter */
    public final String getVersionSkillId() {
        return this.versionSkillId;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component13, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component14, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component15, reason: from getter */
    public final String getVersionUpdateTime() {
        return this.versionUpdateTime;
    }

    /* renamed from: component16, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component17, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component18, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component19, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component20, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component21, reason: from getter */
    public final int getNeedUpdate() {
        return this.needUpdate;
    }

    /* renamed from: component22, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: component23, reason: from getter */
    public final String getStatusMessage() {
        return this.statusMessage;
    }

    /* renamed from: component24, reason: from getter */
    public final int getNecessary() {
        return this.necessary;
    }

    /* renamed from: component25, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component26, reason: from getter */
    public final Boolean getHasSkillMd() {
        return this.hasSkillMd;
    }

    /* renamed from: component27, reason: from getter */
    public final String getLocalZipAbsolutePath() {
        return this.localZipAbsolutePath;
    }

    /* renamed from: component28, reason: from getter */
    public final String getRemoteZipUrl() {
        return this.remoteZipUrl;
    }

    /* renamed from: component29, reason: from getter */
    public final Boolean getIsImportedPrivate() {
        return this.isImportedPrivate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component30, reason: from getter */
    public final Integer getTaskSource() {
        return this.taskSource;
    }

    /* renamed from: component31, reason: from getter */
    public final String getCatalogDescription() {
        return this.catalogDescription;
    }

    /* renamed from: component32, reason: from getter */
    public final SkillStatus getStatus() {
        return this.status;
    }

    /* renamed from: component33, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component34, reason: from getter */
    public final InstallSource getInstallSource() {
        return this.installSource;
    }

    /* renamed from: component35, reason: from getter */
    public final InstallKind getInstallKind() {
        return this.installKind;
    }

    /* renamed from: component36, reason: from getter */
    public final SkillSource getClientSource() {
        return this.clientSource;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLicense() {
        return this.license;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component8, reason: from getter */
    public final String getOwnerId() {
        return this.ownerId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSkillUpdateTime() {
        return this.skillUpdateTime;
    }

    public final SkillItem copy(String slug, String name, String displayName, String summary, String author, String license, String source, String ownerId, String skillUpdateTime, Long versionId, String versionSkillId, Integer versionCode, String versionName, String version, String versionUpdateTime, String createTime, String updateTime, String category, String categoryName, long downloadCount, int needUpdate, String installVersion, String statusMessage, int necessary, String path, Boolean hasSkillMd, String localZipAbsolutePath, String remoteZipUrl, Boolean isImportedPrivate, Integer taskSource, String catalogDescription, SkillStatus status, String iconUrl, InstallSource installSource, InstallKind installKind, SkillSource clientSource) {
        p.i(name, "name");
        p.i(summary, "summary");
        return new SkillItem(slug, name, displayName, summary, author, license, source, ownerId, skillUpdateTime, versionId, versionSkillId, versionCode, versionName, version, versionUpdateTime, createTime, updateTime, category, categoryName, downloadCount, needUpdate, installVersion, statusMessage, necessary, path, hasSkillMd, localZipAbsolutePath, remoteZipUrl, isImportedPrivate, taskSource, catalogDescription, status, iconUrl, installSource, installKind, clientSource);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillItem)) {
            return false;
        }
        SkillItem skillItem = (SkillItem) other;
        return p.d(this.slug, skillItem.slug) && p.d(this.name, skillItem.name) && p.d(this.displayName, skillItem.displayName) && p.d(this.summary, skillItem.summary) && p.d(this.author, skillItem.author) && p.d(this.license, skillItem.license) && p.d(this.source, skillItem.source) && p.d(this.ownerId, skillItem.ownerId) && p.d(this.skillUpdateTime, skillItem.skillUpdateTime) && p.d(this.versionId, skillItem.versionId) && p.d(this.versionSkillId, skillItem.versionSkillId) && p.d(this.versionCode, skillItem.versionCode) && p.d(this.versionName, skillItem.versionName) && p.d(this.version, skillItem.version) && p.d(this.versionUpdateTime, skillItem.versionUpdateTime) && p.d(this.createTime, skillItem.createTime) && p.d(this.updateTime, skillItem.updateTime) && p.d(this.category, skillItem.category) && p.d(this.categoryName, skillItem.categoryName) && this.downloadCount == skillItem.downloadCount && this.needUpdate == skillItem.needUpdate && p.d(this.installVersion, skillItem.installVersion) && p.d(this.statusMessage, skillItem.statusMessage) && this.necessary == skillItem.necessary && p.d(this.path, skillItem.path) && p.d(this.hasSkillMd, skillItem.hasSkillMd) && p.d(this.localZipAbsolutePath, skillItem.localZipAbsolutePath) && p.d(this.remoteZipUrl, skillItem.remoteZipUrl) && p.d(this.isImportedPrivate, skillItem.isImportedPrivate) && p.d(this.taskSource, skillItem.taskSource) && p.d(this.catalogDescription, skillItem.catalogDescription) && this.status == skillItem.status && p.d(this.iconUrl, skillItem.iconUrl) && this.installSource == skillItem.installSource && this.installKind == skillItem.installKind && this.clientSource == skillItem.clientSource;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getCatalogDescription() {
        return this.catalogDescription;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final SkillSource getClientSource() {
        return this.clientSource;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final Boolean getHasSkillMd() {
        return this.hasSkillMd;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIdentifier() {
        return this.name;
    }

    public final InstallKind getInstallKind() {
        return this.installKind;
    }

    public final InstallSource getInstallSource() {
        return this.installSource;
    }

    public final String getInstallVersion() {
        return this.installVersion;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getLocalZipAbsolutePath() {
        return this.localZipAbsolutePath;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNecessary() {
        return this.necessary;
    }

    public final int getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRemoteZipUrl() {
        return this.remoteZipUrl;
    }

    public final String getSkillUpdateTime() {
        return this.skillUpdateTime;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getSource() {
        return this.source;
    }

    public final SkillStatus getStatus() {
        return this.status;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Integer getTaskSource() {
        return this.taskSource;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public final Long getVersionId() {
        return this.versionId;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getVersionSkillId() {
        return this.versionSkillId;
    }

    public final String getVersionUpdateTime() {
        return this.versionUpdateTime;
    }

    public int hashCode() {
        String str = this.slug;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.name.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.summary.hashCode()) * 31;
        String str3 = this.author;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.license;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.source;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ownerId;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.skillUpdateTime;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l10 = this.versionId;
        int iHashCode8 = (iHashCode7 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str8 = this.versionSkillId;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.versionCode;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str9 = this.versionName;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.version;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.versionUpdateTime;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.createTime;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.updateTime;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.category;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.categoryName;
        int iHashCode17 = (((((iHashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31) + Long.hashCode(this.downloadCount)) * 31) + Integer.hashCode(this.needUpdate)) * 31;
        String str16 = this.installVersion;
        int iHashCode18 = (iHashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.statusMessage;
        int iHashCode19 = (((iHashCode18 + (str17 == null ? 0 : str17.hashCode())) * 31) + Integer.hashCode(this.necessary)) * 31;
        String str18 = this.path;
        int iHashCode20 = (iHashCode19 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Boolean bool = this.hasSkillMd;
        int iHashCode21 = (iHashCode20 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str19 = this.localZipAbsolutePath;
        int iHashCode22 = (iHashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.remoteZipUrl;
        int iHashCode23 = (iHashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        Boolean bool2 = this.isImportedPrivate;
        int iHashCode24 = (iHashCode23 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num2 = this.taskSource;
        int iHashCode25 = (iHashCode24 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str21 = this.catalogDescription;
        int iHashCode26 = (iHashCode25 + (str21 == null ? 0 : str21.hashCode())) * 31;
        SkillStatus skillStatus = this.status;
        int iHashCode27 = (iHashCode26 + (skillStatus == null ? 0 : skillStatus.hashCode())) * 31;
        String str22 = this.iconUrl;
        int iHashCode28 = (iHashCode27 + (str22 == null ? 0 : str22.hashCode())) * 31;
        InstallSource installSource = this.installSource;
        int iHashCode29 = (iHashCode28 + (installSource == null ? 0 : installSource.hashCode())) * 31;
        InstallKind installKind = this.installKind;
        int iHashCode30 = (iHashCode29 + (installKind == null ? 0 : installKind.hashCode())) * 31;
        SkillSource skillSource = this.clientSource;
        return iHashCode30 + (skillSource != null ? skillSource.hashCode() : 0);
    }

    public final Boolean isImportedPrivate() {
        return this.isImportedPrivate;
    }

    public String toString() {
        return "SkillItem(slug=" + this.slug + ", name=" + this.name + ", displayName=" + this.displayName + ", summary=" + this.summary + ", author=" + this.author + ", license=" + this.license + ", source=" + this.source + ", ownerId=" + this.ownerId + ", skillUpdateTime=" + this.skillUpdateTime + ", versionId=" + this.versionId + ", versionSkillId=" + this.versionSkillId + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", version=" + this.version + ", versionUpdateTime=" + this.versionUpdateTime + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", category=" + this.category + ", categoryName=" + this.categoryName + ", downloadCount=" + this.downloadCount + ", needUpdate=" + this.needUpdate + ", installVersion=" + this.installVersion + ", statusMessage=" + this.statusMessage + ", necessary=" + this.necessary + ", path=" + this.path + ", hasSkillMd=" + this.hasSkillMd + ", localZipAbsolutePath=" + this.localZipAbsolutePath + ", remoteZipUrl=" + this.remoteZipUrl + ", isImportedPrivate=" + this.isImportedPrivate + ", taskSource=" + this.taskSource + ", catalogDescription=" + this.catalogDescription + ", status=" + this.status + ", iconUrl=" + this.iconUrl + ", installSource=" + this.installSource + ", installKind=" + this.installKind + ", clientSource=" + this.clientSource + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.slug);
        dest.writeString(this.name);
        dest.writeString(this.displayName);
        dest.writeString(this.summary);
        dest.writeString(this.author);
        dest.writeString(this.license);
        dest.writeString(this.source);
        dest.writeString(this.ownerId);
        dest.writeString(this.skillUpdateTime);
        Long l10 = this.versionId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.versionSkillId);
        Integer num = this.versionCode;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.versionName);
        dest.writeString(this.version);
        dest.writeString(this.versionUpdateTime);
        dest.writeString(this.createTime);
        dest.writeString(this.updateTime);
        dest.writeString(this.category);
        dest.writeString(this.categoryName);
        dest.writeLong(this.downloadCount);
        dest.writeInt(this.needUpdate);
        dest.writeString(this.installVersion);
        dest.writeString(this.statusMessage);
        dest.writeInt(this.necessary);
        dest.writeString(this.path);
        Boolean bool = this.hasSkillMd;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.localZipAbsolutePath);
        dest.writeString(this.remoteZipUrl);
        Boolean bool2 = this.isImportedPrivate;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.taskSource;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.catalogDescription);
        SkillStatus skillStatus = this.status;
        if (skillStatus == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(skillStatus.name());
        }
        dest.writeString(this.iconUrl);
        InstallSource installSource = this.installSource;
        if (installSource == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(installSource.name());
        }
        InstallKind installKind = this.installKind;
        if (installKind == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(installKind.name());
        }
        SkillSource skillSource = this.clientSource;
        if (skillSource == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(skillSource.name());
        }
    }

    public /* synthetic */ SkillItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l10, String str10, Integer num, String str11, String str12, String str13, String str14, String str15, String str16, String str17, long j10, int i10, String str18, String str19, int i11, String str20, Boolean bool, String str21, String str22, Boolean bool2, Integer num2, String str23, SkillStatus skillStatus, String str24, InstallSource installSource, InstallKind installKind, SkillSource skillSource, int i12, int i13, i iVar) {
        this(str, str2, (i12 & 4) != 0 ? "" : str3, str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? null : str7, (i12 & 128) != 0 ? null : str8, (i12 & 256) != 0 ? null : str9, (i12 & 512) != 0 ? null : l10, (i12 & 1024) != 0 ? null : str10, (i12 & 2048) != 0 ? null : num, (i12 & 4096) != 0 ? null : str11, (i12 & b.THRESHOLD) != 0 ? null : str12, (i12 & 16384) != 0 ? null : str13, (32768 & i12) != 0 ? null : str14, (65536 & i12) != 0 ? null : str15, (131072 & i12) != 0 ? null : str16, (262144 & i12) != 0 ? null : str17, (524288 & i12) != 0 ? 0L : j10, (1048576 & i12) != 0 ? 0 : i10, (2097152 & i12) != 0 ? null : str18, (4194304 & i12) != 0 ? null : str19, (8388608 & i12) != 0 ? 0 : i11, (16777216 & i12) != 0 ? "" : str20, (33554432 & i12) != 0 ? Boolean.FALSE : bool, (67108864 & i12) != 0 ? null : str21, (134217728 & i12) != 0 ? null : str22, (268435456 & i12) != 0 ? Boolean.FALSE : bool2, (536870912 & i12) != 0 ? 2 : num2, (1073741824 & i12) != 0 ? null : str23, (i12 & Integer.MIN_VALUE) != 0 ? SkillStatus.UNINSTALLED : skillStatus, (i13 & 1) != 0 ? null : str24, (i13 & 2) != 0 ? InstallSource.CLOUD : installSource, (i13 & 4) != 0 ? InstallKind.SKILL : installKind, (i13 & 8) != 0 ? SkillSource.NORMAL : skillSource);
    }
}
