package com.obric.callsummary.model.intf;

import android.content.Context;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICallSummaryGenerateModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/obric/callsummary/model/intf/ICallSummaryGenerateModel;", "", "generateCallSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "context", "Landroid/content/Context;", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "isSimplify", "", ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "isRetry", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICallSummaryGenerateModel {

    /* JADX INFO: compiled from: ICallSummaryGenerateModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ CallSummaryResult generateCallSummary$default(ICallSummaryGenerateModel r6, Context r7, List r8, boolean r9, ABSAIKernelCallSummaryModel.PowerMode r10, boolean r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 8) == 0) goto L6;
            r10 = ABSAIKernelCallSummaryModel.PowerMode.BALANCED;
        L6:
            ABSAIKernelCallSummaryModel.PowerMode r4 = r10;
            if ((r12 & 16) == 0) goto L10;
            r11 = false;
        L10:
            return r6.generateCallSummary(r7, r8, r9, r4, r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateCallSummary");
        }
    }

    CallSummaryResult generateCallSummary(Context r1, List<CallSummaryASRMessageBean> r2, boolean r3, ABSAIKernelCallSummaryModel.PowerMode r4, boolean r5);
}
