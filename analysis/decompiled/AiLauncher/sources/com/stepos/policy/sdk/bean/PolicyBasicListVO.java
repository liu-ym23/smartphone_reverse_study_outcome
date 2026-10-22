package com.stepos.policy.sdk.bean;

/* loaded from: classes.dex */
public class PolicyBasicListVO {
    public static final int TYPE_ID_HEAD_LIST = 30;
    public static final int TYPE_ID_HEAD_TITLE = 100;
    public static final int TYPE_ID_LIST_AVATAR = 25;
    public static final int TYPE_ID_LIST_AVATAR_WITH_DESC = 27;
    public static final int TYPE_ID_LIST_AVATAR_WITH_SUBTITLE = 26;
    public static final int TYPE_ID_LIST_BASCI_DOUBLE_LINE = 16;
    public static final int TYPE_ID_LIST_BASCI_DOUBLE_LINE_FOR_SETTING = 17;
    public static final int TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE = 37;
    public static final int TYPE_ID_LIST_BASCI_MULTI_LINE = 18;
    public static final int TYPE_ID_LIST_BASCI_MULTI_LINE_LONG = 19;
    public static final int TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE = 38;
    public static final int TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE = 39;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE = 0;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF = 34;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON = 35;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT = 33;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER = 31;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_TEXT = 32;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE = 36;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER = 12;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW = 14;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT = 11;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW = 13;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_ARROW = 1;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON = 9;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_CHECKBOX_OFF = 4;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_CHECKBOX_ON = 5;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_CHECK_TEXT = 3;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_ERROR = 6;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK = 10;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LOADING = 8;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_SWITCH = 7;
    public static final int TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_TRIANGLE = 2;
    public static final int TYPE_ID_LIST_ICON_LARGE = 23;
    public static final int TYPE_ID_LIST_ICON_MIDDLE = 22;
    public static final int TYPE_ID_LIST_ICON_SMALL = 20;
    public static final int TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE = 21;
    public static final int TYPE_ID_LIST_SEARCH_NORMAL = 40;
    public static final int TYPE_ID_LIST_SEARCH_WITH_OPERATION = 41;
    public static final int TYPE_ID_LIST_SEARCH_WITH_SUMMARY = 42;
    private boolean isHeader;
    private String mDesc;
    private int mHeaderType;
    private Object mIcon;
    private String mSubTitle;
    private String mTitle;
    private int mTypeId;

    public static class Builder {
        private String mDesc;
        private Object mIcon;
        private String mSubTitle;
        private String mTitle;
        private int mTypeId;
        private boolean isHeader = false;
        private int mHeaderType = 30;

        public Builder(String str) {
            this.mTitle = str;
        }

        public PolicyBasicListVO build() {
            return new PolicyBasicListVO(this);
        }

        public Builder isHeader(boolean z10) {
            this.isHeader = z10;
            return this;
        }

        public Builder setDesc(String str) {
            this.mDesc = str;
            return this;
        }

        public Builder setHeaderType(int i10) {
            this.mHeaderType = i10;
            return this;
        }

        public Builder setIcon(Object obj) {
            this.mIcon = obj;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.mSubTitle = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder setTypeId(int i10) {
            this.mTypeId = i10;
            return this;
        }
    }

    public PolicyBasicListVO(Builder builder) {
        this.isHeader = false;
        this.isHeader = builder.isHeader;
        this.mHeaderType = builder.mHeaderType;
        this.mTitle = builder.mTitle;
        this.mSubTitle = builder.mSubTitle;
        this.mDesc = builder.mDesc;
        this.mIcon = builder.mIcon;
        this.mTypeId = builder.mTypeId;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public int getHeaderType() {
        return this.mHeaderType;
    }

    public Object getIcon() {
        return this.mIcon;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTypeId() {
        return this.mTypeId;
    }

    public boolean isHeader() {
        return this.isHeader;
    }
}
