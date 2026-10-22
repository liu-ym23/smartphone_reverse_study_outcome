package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class RepSdaEntity extends BaseEntity {
    private Body body;

    public class Body {
        private boolean iffaker_download;
        final /* synthetic */ RepSdaEntity this$0;

        public Body(RepSdaEntity r10) {
            this.this$0 = r10;
            this.iffaker_download = false;
        }

        public boolean isIffaker_download() {
            return this.iffaker_download;
        }

        public void setIffaker_download(boolean r10) {
            this.iffaker_download = r10;
        }
    }

    public RepSdaEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
