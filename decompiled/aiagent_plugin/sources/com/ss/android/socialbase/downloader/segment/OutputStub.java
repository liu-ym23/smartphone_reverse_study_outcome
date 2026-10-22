package com.ss.android.socialbase.downloader.segment;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class OutputStub implements IOutput {
    private final IOutput output;
    private final IOutput target;

    OutputStub(IOutput r3, IOutput r4) {
        IOutput r5 = (IOutput) ZeusTransformUtils.wrapperContextForParams(r3, IOutput.class, "com.obric.aiagent.plugin");
        IOutput r6 = (IOutput) ZeusTransformUtils.wrapperContextForParams(r4, IOutput.class, "com.obric.aiagent.plugin");
        this.output = r5;
        this.target = r6;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer r2) {
        r2.output = this.target;
        this.output.write(r2);
    }
}
