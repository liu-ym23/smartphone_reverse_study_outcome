package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.common.FunctionCall;
import com.stepos.common.LikeState;
import com.stepos.common.MetaData;
import com.stepos.common.RequiredAction;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b\u0087\u0001\b\u0016\u0018\u00002\u00020\u0001B¯\u0004\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0005H\u0016¢\u0006\u0004\bB\u0010CR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010I\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010LR$\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010I\u001a\u0004\bM\u0010C\"\u0004\bN\u0010LR$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010I\u001a\u0004\bO\u0010C\"\u0004\bP\u0010LR\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010\u000f\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Q\u001a\u0004\b`\u0010S\"\u0004\ba\u0010UR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010I\u001a\u0004\bQ\u0010C\"\u0004\bb\u0010LR\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010`\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010\u0013\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010Q\u001a\u0004\bg\u0010S\"\u0004\bh\u0010UR\"\u0010\u0014\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010Q\u001a\u0004\bi\u0010S\"\u0004\bj\u0010UR\"\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010V\u001a\u0004\b\u0015\u0010X\"\u0004\bk\u0010ZR\"\u0010\u0016\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010I\u001a\u0004\bl\u0010C\"\u0004\bm\u0010LR\"\u0010\u0017\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010I\u001a\u0004\bn\u0010C\"\u0004\bo\u0010LR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010Q\u001a\u0004\bu\u0010S\"\u0004\bv\u0010UR\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010V\u001a\u0004\bw\u0010X\"\u0004\bx\u0010ZR\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010I\u001a\u0004\by\u0010C\"\u0004\bz\u0010LR\u0017\u0010\u001d\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010Q\u001a\u0004\b{\u0010SR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010|\u001a\u0004\b}\u0010~R#\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u001f\u0010Q\u001a\u0004\b\u007f\u0010S\"\u0005\b\u0080\u0001\u0010UR'\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b \u0010|\u001a\u0005\b\u0081\u0001\u0010~\"\u0006\b\u0082\u0001\u0010\u0083\u0001R'\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b!\u0010|\u001a\u0005\b\u0084\u0001\u0010~\"\u0006\b\u0085\u0001\u0010\u0083\u0001R'\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b#\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R&\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010I\u001a\u0005\b\u008b\u0001\u0010C\"\u0005\b\u008c\u0001\u0010LR$\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b%\u0010I\u001a\u0005\b\u008d\u0001\u0010C\"\u0005\b\u008e\u0001\u0010LR;\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b(\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b)\u0010I\u001a\u0005\b\u0094\u0001\u0010C\"\u0005\b\u0095\u0001\u0010LR&\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b*\u0010I\u001a\u0005\b\u0096\u0001\u0010C\"\u0005\b\u0097\u0001\u0010LR&\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b+\u0010I\u001a\u0005\b\u0098\u0001\u0010C\"\u0005\b\u0099\u0001\u0010LR)\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b-\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R&\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b.\u0010I\u001a\u0005\b\u009f\u0001\u0010C\"\u0005\b \u0001\u0010LR)\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b0\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R&\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b1\u0010I\u001a\u0005\b¦\u0001\u0010C\"\u0005\b§\u0001\u0010LR&\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b2\u0010I\u001a\u0005\b¨\u0001\u0010C\"\u0005\b©\u0001\u0010LR&\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b3\u0010I\u001a\u0005\bª\u0001\u0010C\"\u0005\b«\u0001\u0010LR)\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b5\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R&\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b6\u0010I\u001a\u0005\b±\u0001\u0010C\"\u0005\b²\u0001\u0010LR)\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b8\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R,\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010D\u001a\u0005\b¸\u0001\u0010F\"\u0005\b¹\u0001\u0010HR,\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010D\u001a\u0005\bº\u0001\u0010F\"\u0005\b»\u0001\u0010HR&\u0010<\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b<\u0010I\u001a\u0005\b¼\u0001\u0010C\"\u0005\b½\u0001\u0010LR&\u0010=\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b=\u0010I\u001a\u0005\b¾\u0001\u0010C\"\u0005\b¿\u0001\u0010LR)\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b?\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006Å\u0001"}, d2 = {"LK6/m;", "LK6/k;", "", "LK6/i;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", BundleContentBridge.KEY_ROLE, "conversationId", "contentType", "", "transferState", "", "stream", "", "extra", StepOSRecipientEmailHistory._ID, "uid", "", "time", "chatState", "contentId", "isClearContext", "agentId", "secretkey", "LK6/i$b;", "audio", "platform", "isFinish", "type", "seqId", "requestId", "index", "failCode", "event", "Lcom/stepos/common/LikeState;", "likeState", "serverId", "chatType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "suggest", "failMessage", "messageId", "originMessageId", "Lcom/stepos/common/FunctionCall;", "functionCall", "answerType", "Lcom/stepos/common/RequiredAction;", "required_action", "chatId", "serverItemId", "reasoning_content", "Lcom/stepos/common/MetaData;", "metaData", DidiCardProvider.KEY_TRACE_ID, "LK6/c;", "agentTaskStateInfo", "LK6/A;", "references", "uiActions", "cardName", "cardResultJson", "LK6/d;", "askUserConversation", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Map;ILjava/lang/String;JIIZLjava/lang/String;Ljava/lang/String;LK6/i$b;IZLjava/lang/String;ILjava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/stepos/common/LikeState;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/common/FunctionCall;Ljava/lang/String;Lcom/stepos/common/RequiredAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/common/MetaData;Ljava/lang/String;LK6/c;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;LK6/d;)V", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "n", "()Ljava/util/List;", "N", "(Ljava/util/List;)V", "Ljava/lang/String;", "z", "setRole", "(Ljava/lang/String;)V", "q", "setConversationId", "p", "setContentType", "I", "G", "()I", "setTransferState", "(I)V", "Z", "C", "()Z", "setStream", "(Z)V", "Ljava/util/Map;", "s", "()Ljava/util/Map;", "P", "(Ljava/util/Map;)V", "J", "set_id", "setUid", ExifInterface.LONGITUDE_EAST, "()J", "setTime", "(J)V", "m", "setChatState", "o", "setContentId", "setClearContext", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "c", "f", "LK6/i$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LK6/i$b;", "setAudio", "(LK6/i$b;)V", "getPlatform", "setPlatform", "K", "Q", "getType", "setType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Integer;", "getRequestId", "()Ljava/lang/Integer;", "u", "setIndex", "getFailCode", "setFailCode", "(Ljava/lang/Integer;)V", "r", "O", "Lcom/stepos/common/LikeState;", "getLikeState", "()Lcom/stepos/common/LikeState;", "setLikeState", "(Lcom/stepos/common/LikeState;)V", "getServerId", "setServerId", "getChatType", "setChatType", "Ljava/util/ArrayList;", "D", "()Ljava/util/ArrayList;", "U", "(Ljava/util/ArrayList;)V", "getFailMessage", "setFailMessage", "v", ExifInterface.LATITUDE_SOUTH, "getOriginMessageId", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/common/FunctionCall;", "t", "()Lcom/stepos/common/FunctionCall;", "R", "(Lcom/stepos/common/FunctionCall;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "L", "Lcom/stepos/common/RequiredAction;", "y", "()Lcom/stepos/common/RequiredAction;", "setRequired_action", "(Lcom/stepos/common/RequiredAction;)V", "l", "setChatId", "B", "setServerItemId", "w", "setReasoning_content", "Lcom/stepos/common/MetaData;", "getMetaData", "()Lcom/stepos/common/MetaData;", "setMetaData", "(Lcom/stepos/common/MetaData;)V", "F", "setTraceId", "LK6/c;", "getAgentTaskStateInfo", "()LK6/c;", "setAgentTaskStateInfo", "(LK6/c;)V", "x", "setReferences", "H", "setUiActions", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setCardName", "k", "setCardResultJson", "LK6/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LK6/d;", "M", "(LK6/d;)V", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0917m extends C0915k {
    private int _id;
    private String agentId;
    private AgentTaskStateInfo agentTaskStateInfo;
    private String answerType;
    private transient AskUserConversation askUserConversation;
    private AbstractC0913i.AudioStream audio;
    private String cardName;
    private String cardResultJson;
    private String chatId;
    private int chatState;
    private String chatType;
    private List<? extends AbstractC0913i> content;
    private int contentId;
    private String contentType;
    private String conversationId;
    private Integer event;
    private Map<String, String> extra;
    private Integer failCode;
    private String failMessage;
    private FunctionCall functionCall;
    private int index;
    private boolean isClearContext;
    private boolean isFinish;
    private LikeState likeState;
    private String messageId;
    private MetaData metaData;
    private String originMessageId;
    private int platform;
    private String reasoning_content;
    private List<ReferenceSource> references;
    private final Integer requestId;
    private RequiredAction required_action;
    private String role;
    private String secretkey;
    private final int seqId;
    private String serverId;
    private String serverItemId;
    private boolean stream;
    private ArrayList<String> suggest;
    private long time;
    private String traceId;
    private int transferState;
    private String type;
    private List<String> uiActions;
    private String uid;

    public C0917m(List<? extends AbstractC0913i> list, String role, String str, String str2, int i10, boolean z10, Map<String, String> map, int i11, String str3, long j10, int i12, int i13, boolean z11, String agentId, String secretkey, AbstractC0913i.AudioStream audioStream, int i14, boolean z12, String type, int i15, Integer num, int i16, Integer num2, Integer num3, LikeState likeState, String str4, String chatType, ArrayList<String> arrayList, String str5, String str6, String str7, FunctionCall functionCall, String str8, RequiredAction requiredAction, String str9, String str10, String str11, MetaData metaData, String str12, AgentTaskStateInfo agentTaskStateInfo, List<ReferenceSource> list2, List<String> list3, String str13, String str14, AskUserConversation askUserConversation) {
        p.i(role, "role");
        p.i(agentId, "agentId");
        p.i(secretkey, "secretkey");
        p.i(type, "type");
        p.i(likeState, "likeState");
        p.i(chatType, "chatType");
        this.content = list;
        this.role = role;
        this.conversationId = str;
        this.contentType = str2;
        this.transferState = i10;
        this.stream = z10;
        this.extra = map;
        this._id = i11;
        this.uid = str3;
        this.time = j10;
        this.chatState = i12;
        this.contentId = i13;
        this.isClearContext = z11;
        this.agentId = agentId;
        this.secretkey = secretkey;
        this.audio = audioStream;
        this.platform = i14;
        this.isFinish = z12;
        this.type = type;
        this.seqId = i15;
        this.requestId = num;
        this.index = i16;
        this.failCode = num2;
        this.event = num3;
        this.likeState = likeState;
        this.serverId = str4;
        this.chatType = chatType;
        this.suggest = arrayList;
        this.failMessage = str5;
        this.messageId = str6;
        this.originMessageId = str7;
        this.functionCall = functionCall;
        this.answerType = str8;
        this.required_action = requiredAction;
        this.chatId = str9;
        this.serverItemId = str10;
        this.reasoning_content = str11;
        this.metaData = metaData;
        this.traceId = str12;
        this.agentTaskStateInfo = agentTaskStateInfo;
        this.references = list2;
        this.uiActions = list3;
        this.cardName = str13;
        this.cardResultJson = str14;
        this.askUserConversation = askUserConversation;
    }

    /* renamed from: A, reason: from getter */
    public final int getSeqId() {
        return this.seqId;
    }

    /* renamed from: B, reason: from getter */
    public final String getServerItemId() {
        return this.serverItemId;
    }

    /* renamed from: C, reason: from getter */
    public boolean getStream() {
        return this.stream;
    }

    public final ArrayList<String> D() {
        return this.suggest;
    }

    /* renamed from: E, reason: from getter */
    public long getTime() {
        return this.time;
    }

    /* renamed from: F, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: G, reason: from getter */
    public int getTransferState() {
        return this.transferState;
    }

    public final List<String> H() {
        return this.uiActions;
    }

    /* renamed from: I, reason: from getter */
    public String getUid() {
        return this.uid;
    }

    /* renamed from: J, reason: from getter */
    public int get_id() {
        return this._id;
    }

    /* renamed from: K, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public final void L(String str) {
        this.answerType = str;
    }

    public final void M(AskUserConversation askUserConversation) {
        this.askUserConversation = askUserConversation;
    }

    public void N(List<? extends AbstractC0913i> list) {
        this.content = list;
    }

    public final void O(Integer num) {
        this.event = num;
    }

    public void P(Map<String, String> map) {
        this.extra = map;
    }

    public final void Q(boolean z10) {
        this.isFinish = z10;
    }

    public final void R(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public final void S(String str) {
        this.messageId = str;
    }

    public final void T(String str) {
        this.originMessageId = str;
    }

    public final void U(ArrayList<String> arrayList) {
        this.suggest = arrayList;
    }

    @Override // kotlin.C0915k
    /* renamed from: a, reason: from getter */
    public String getAgentId() {
        return this.agentId;
    }

    @Override // kotlin.C0915k
    /* renamed from: c, reason: from getter */
    public String getSecretkey() {
        return this.secretkey;
    }

    @Override // kotlin.C0915k
    public void d(String str) {
        p.i(str, "<set-?>");
        this.agentId = str;
    }

    @Override // kotlin.C0915k
    public void f(String str) {
        p.i(str, "<set-?>");
        this.secretkey = str;
    }

    /* renamed from: g, reason: from getter */
    public final String getAnswerType() {
        return this.answerType;
    }

    /* renamed from: h, reason: from getter */
    public final AskUserConversation getAskUserConversation() {
        return this.askUserConversation;
    }

    /* renamed from: i, reason: from getter */
    public AbstractC0913i.AudioStream getAudio() {
        return this.audio;
    }

    /* renamed from: j, reason: from getter */
    public final String getCardName() {
        return this.cardName;
    }

    /* renamed from: k, reason: from getter */
    public final String getCardResultJson() {
        return this.cardResultJson;
    }

    /* renamed from: l, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    /* renamed from: m, reason: from getter */
    public int getChatState() {
        return this.chatState;
    }

    public List<AbstractC0913i> n() {
        return this.content;
    }

    /* renamed from: o, reason: from getter */
    public int getContentId() {
        return this.contentId;
    }

    /* renamed from: p, reason: from getter */
    public String getContentType() {
        return this.contentType;
    }

    /* renamed from: q, reason: from getter */
    public String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: r, reason: from getter */
    public final Integer getEvent() {
        return this.event;
    }

    public Map<String, String> s() {
        return this.extra;
    }

    /* renamed from: t, reason: from getter */
    public final FunctionCall getFunctionCall() {
        return this.functionCall;
    }

    public String toString() {
        List<AbstractC0913i> listN = n();
        return "ChatReplyInfo(contentParts=" + (listN != null ? listN.size() : 0) + ", role='" + getRole() + "', messageId=" + this.messageId + ", originMessageId=" + this.originMessageId + ", conversationId=" + getConversationId() + ", contentType=" + getContentType() + ", transferState=" + getTransferState() + ", stream=" + getStream() + ", extra=" + s() + ",  _id=" + get_id() + ", uid=" + getUid() + ", time=" + getTime() + ", chatState=" + getChatState() + ", contentId=" + getContentId() + ", agentId='" + getAgentId() + "', platform=" + this.platform + ", isFinish=" + this.isFinish + ", type='" + this.type + "', seqId=" + this.seqId + ", requestId=" + this.requestId + ", index=" + this.index + ", failCode=" + this.failCode + ", event=" + this.event + ", likeState=" + this.likeState + ", serverId=" + this.serverId + ", chatType=" + this.chatType + ")";
    }

    /* renamed from: u, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: v, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: w, reason: from getter */
    public final String getReasoning_content() {
        return this.reasoning_content;
    }

    public final List<ReferenceSource> x() {
        return this.references;
    }

    /* renamed from: y, reason: from getter */
    public final RequiredAction getRequired_action() {
        return this.required_action;
    }

    /* renamed from: z, reason: from getter */
    public String getRole() {
        return this.role;
    }

    public /* synthetic */ C0917m(List list, String str, String str2, String str3, int i10, boolean z10, Map map, int i11, String str4, long j10, int i12, int i13, boolean z11, String str5, String str6, AbstractC0913i.AudioStream audioStream, int i14, boolean z12, String str7, int i15, Integer num, int i16, Integer num2, Integer num3, LikeState likeState, String str8, String str9, ArrayList arrayList, String str10, String str11, String str12, FunctionCall functionCall, String str13, RequiredAction requiredAction, String str14, String str15, String str16, MetaData metaData, String str17, AgentTaskStateInfo agentTaskStateInfo, List list2, List list3, String str18, String str19, AskUserConversation askUserConversation, int i17, int i18, i iVar) {
        this((i17 & 1) != 0 ? null : list, (i17 & 2) != 0 ? "assistant" : str, (i17 & 4) != 0 ? null : str2, (i17 & 8) != 0 ? "text" : str3, (i17 & 16) != 0 ? 0 : i10, (i17 & 32) != 0 ? true : z10, (i17 & 64) != 0 ? null : map, (i17 & 128) != 0 ? 0 : i11, (i17 & 256) != 0 ? null : str4, (i17 & 512) != 0 ? System.currentTimeMillis() : j10, (i17 & 1024) != 0 ? 1 : i12, (i17 & 2048) != 0 ? 0 : i13, (i17 & 4096) != 0 ? false : z11, (i17 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? "" : str5, (i17 & 16384) != 0 ? "" : str6, (32768 & i17) != 0 ? null : audioStream, i14, (131072 & i17) != 0 ? false : z12, (262144 & i17) != 0 ? "" : str7, (524288 & i17) != 0 ? 0 : i15, (1048576 & i17) != 0 ? null : num, (2097152 & i17) != 0 ? 0 : i16, (4194304 & i17) != 0 ? null : num2, (8388608 & i17) != 0 ? null : num3, (16777216 & i17) != 0 ? LikeState.Normal : likeState, (33554432 & i17) != 0 ? null : str8, (67108864 & i17) != 0 ? "normal" : str9, (134217728 & i17) != 0 ? null : arrayList, (268435456 & i17) != 0 ? null : str10, (536870912 & i17) != 0 ? null : str11, (1073741824 & i17) != 0 ? null : str12, (i17 & Integer.MIN_VALUE) != 0 ? null : functionCall, (i18 & 1) != 0 ? null : str13, (i18 & 2) != 0 ? null : requiredAction, (i18 & 4) != 0 ? null : str14, (i18 & 8) != 0 ? null : str15, (i18 & 16) != 0 ? null : str16, (i18 & 32) != 0 ? null : metaData, (i18 & 64) != 0 ? null : str17, (i18 & 128) != 0 ? null : agentTaskStateInfo, (i18 & 256) != 0 ? null : list2, (i18 & 512) != 0 ? null : list3, (i18 & 1024) != 0 ? null : str18, (i18 & 2048) != 0 ? null : str19, (i18 & 4096) != 0 ? null : askUserConversation);
    }
}
