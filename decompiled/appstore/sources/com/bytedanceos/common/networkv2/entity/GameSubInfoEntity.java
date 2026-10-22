package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubInfoEntity extends BaseEntity {
    private Body body;

    public static class Body extends SubVideoEntity {
        private String brief;
        private List<SubGiftEntity> gifts;
        private List<String> screen;

        public Body() {
            this.brief = "";
        }

        public String getBrief() {
            return this.brief;
        }

        public List<SubGiftEntity> getGifts() {
            return this.gifts;
        }

        public List<String> getScreens() {
            return this.screen;
        }

        public void setBrief(String r10) {
            this.brief = r10;
        }

        public void setGifts(List<SubGiftEntity> r10) {
            this.gifts = r10;
        }

        public void setScreens(List<String> r10) {
            this.screen = r10;
        }
    }

    public GameSubInfoEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
