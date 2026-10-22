package com.byted.mgl.merge.service.api.collect;

/* JADX INFO: loaded from: classes43.dex */
public class BdpGameCollectShowInfo {
    private String mCollectFailText;
    private String mCollectSuccessText;
    private String mCollectText;
    private boolean mIsEntranceVisible;
    private String mLoginHintText;
    private String mRemoveCollectText;
    private String mRemoveFailText;
    private String mRemoveSuccessText;

    /* JADX INFO: renamed from: com.byted.mgl.merge.service.api.collect.BdpGameCollectShowInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String collectFailText;
        private String collectSuccessText;
        private String collectText;
        private boolean isEntranceVisible;
        private String loginHintText;
        private String removeCollectText;
        private String removeFailText;
        private String removeSuccessText;

        public Builder() {
        }

        public BdpGameCollectShowInfo build() {
            return new BdpGameCollectShowInfo(this, null);
        }

        public String getCollectFailText() {
            return this.collectFailText;
        }

        public String getCollectSuccessText() {
            return this.collectSuccessText;
        }

        public String getCollectText() {
            return this.collectText;
        }

        public String getLoginHintText() {
            return this.loginHintText;
        }

        public String getRemoveCollectText() {
            return this.removeCollectText;
        }

        public String getRemoveFailText() {
            return this.removeFailText;
        }

        public String getRemoveSuccessText() {
            return this.removeSuccessText;
        }

        public boolean isEntranceVisible() {
            return this.isEntranceVisible;
        }

        public Builder setCollectFailText(String r100) {
            this.collectFailText = r100;
            return this;
        }

        public Builder setCollectSuccessText(String r100) {
            this.collectSuccessText = r100;
            return this;
        }

        public Builder setCollectText(String r100) {
            this.collectText = r100;
            return this;
        }

        public Builder setEntranceVisible(boolean r100) {
            this.isEntranceVisible = r100;
            return this;
        }

        public Builder setLoginHintText(String r100) {
            this.loginHintText = r100;
            return this;
        }

        public Builder setRemoveCollectText(String r100) {
            this.removeCollectText = r100;
            return this;
        }

        public Builder setRemoveFailText(String r100) {
            this.removeFailText = r100;
            return this;
        }

        public Builder setRemoveSuccessText(String r100) {
            this.removeSuccessText = r100;
            return this;
        }
    }

    private BdpGameCollectShowInfo() {
    }

    public String getCollectFailText() {
        return this.mCollectFailText;
    }

    public String getCollectSuccessText() {
        return this.mCollectSuccessText;
    }

    public String getCollectText() {
        return this.mCollectText;
    }

    public String getLoginHintText() {
        return this.mLoginHintText;
    }

    public String getRemoveCollectText() {
        return this.mRemoveCollectText;
    }

    public String getRemoveFailText() {
        return this.mRemoveFailText;
    }

    public String getRemoveSuccessText() {
        return this.mRemoveSuccessText;
    }

    public boolean isEntranceVisible() {
        return this.mIsEntranceVisible;
    }

    private BdpGameCollectShowInfo(Builder r100) {
        this.mCollectText = r100.getCollectText();
        this.mRemoveCollectText = r100.getRemoveCollectText();
        this.mLoginHintText = r100.getLoginHintText();
        this.mCollectSuccessText = r100.getCollectSuccessText();
        this.mCollectFailText = r100.getCollectFailText();
        this.mRemoveSuccessText = r100.getRemoveSuccessText();
        this.mRemoveFailText = r100.getRemoveFailText();
        this.mIsEntranceVisible = r100.isEntranceVisible();
    }

    public /* synthetic */ BdpGameCollectShowInfo(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
