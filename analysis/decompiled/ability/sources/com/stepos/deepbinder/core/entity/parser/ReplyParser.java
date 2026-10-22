package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.utils.SerializeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/ReplyParser;", "", AppAgent.CONSTRUCT, "()V", "Landroid/os/Parcel;", "parcel", "", "version", "Lcom/stepos/deepbinder/core/entity/Reply;", "parserReplyFromParcel", "(Landroid/os/Parcel;I)Lcom/stepos/deepbinder/core/entity/Reply;", Constants.PARAM_REPLY, "flags", "LC7/r;", "writeReplyIntoParcel", "(Lcom/stepos/deepbinder/core/entity/Reply;Landroid/os/Parcel;II)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReplyParser {
    public static final ReplyParser INSTANCE = new ReplyParser();

    private ReplyParser() {
    }

    public static /* synthetic */ Reply parserReplyFromParcel$default(ReplyParser replyParser, Parcel parcel, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return replyParser.parserReplyFromParcel(parcel, i);
    }

    public static /* synthetic */ void writeReplyIntoParcel$default(ReplyParser replyParser, Reply reply, Parcel parcel, int i, int i6, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i = 0;
        }
        replyParser.writeReplyIntoParcel(reply, parcel, i, i6);
    }

    public final Reply parserReplyFromParcel(Parcel parcel, int version) {
        k.f(parcel, "parcel");
        Reply replyObtain = Reply.INSTANCE.obtain();
        replyObtain.setProtocolVersion(version);
        if (parcel.readByte() == 0) {
            Parcelable parcelable = parcel.readParcelable(IPCException.class.getClassLoader());
            replyObtain.setIpcException(parcelable instanceof IPCException ? (IPCException) parcelable : null);
        }
        if (parcel.readByte() == 0) {
            replyObtain.setFlowParameterWrappers(SerializeUtils.INSTANCE.readParameterWrapperArray(parcel, version));
        }
        replyObtain.setInvokeTime(parcel.readInt());
        replyObtain.setResult(SerializeUtils.INSTANCE.readFromParcel(ReplyParser.class.getClassLoader(), parcel, version));
        replyObtain.setExtraInfoMap(parcel.readHashMap(ReplyParser.class.getClassLoader()));
        return replyObtain;
    }

    public final void writeReplyIntoParcel(Reply reply, Parcel parcel, int version, int flags) {
        k.f(reply, "reply");
        k.f(parcel, "parcel");
        if (reply.getIpcException() != null) {
            parcel.writeByte((byte) 0);
            parcel.writeParcelable(reply.getIpcException(), flags);
        } else {
            parcel.writeByte((byte) 1);
        }
        if (reply.getFlowParameterWrappers() != null) {
            parcel.writeByte((byte) 0);
            SerializeUtils.INSTANCE.writeParameterWrapperArray(parcel, reply.getFlowParameterWrappers(), version, flags);
        } else {
            parcel.writeByte((byte) 1);
        }
        parcel.writeInt((int) reply.getInvokeTime());
        SerializeUtils.INSTANCE.writeToParcel(parcel, reply.getResult(), version, flags, true);
        parcel.writeMap(reply.getExtraInfoMap());
    }
}
