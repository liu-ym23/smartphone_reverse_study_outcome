package com.uxsense.base.metadata;

import com.uxsense.parse.ApexParserManager;
import com.uxsense.parse.ContextExtractor;
import com.uxsense.parse.DeduplicateStrategy;
import com.uxsense.parse.IdSource;
import com.uxsense.parse.MetadataConfig;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4195a;

    public /* synthetic */ a(int i) {
        this.f4195a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        long comments$lambda$7;
        switch (this.f4195a) {
            case 0:
                return Creation._childSerializers$_anonymous_$15();
            case 1:
                return CreationType._init_$_anonymous_();
            case 2:
                return FollowersPage._childSerializers$_anonymous_();
            case 3:
                return InteractionStats._childSerializers$_anonymous_();
            case 4:
                return MessagePage._childSerializers$_anonymous_();
            case 5:
                return MessageStatus._init_$_anonymous_();
            case 6:
                return MessageType._init_$_anonymous_();
            case 7:
                return User._childSerializers$_anonymous_();
            case 8:
                return UserStats._childSerializers$_anonymous_();
            case 9:
                return UserStats._childSerializers$_anonymous_$4();
            case 10:
                return UserStats._childSerializers$_anonymous_$5();
            case 11:
                return Visibility._init_$_anonymous_();
            case 12:
                comments$lambda$7 = ApexParserManager.parseComments$lambda$7();
                break;
            case 13:
                comments$lambda$7 = ApexParserManager.parseCreations$lambda$5();
                break;
            case 14:
                return ContextExtractor._childSerializers$_anonymous_();
            case 15:
                return ContextExtractor._childSerializers$_anonymous_$0();
            case 16:
                return ContextExtractor._childSerializers$_anonymous_$1();
            case 17:
                return ContextExtractor._childSerializers$_anonymous_$2();
            case 18:
                return ContextExtractor._childSerializers$_anonymous_$3();
            case 19:
                return ContextExtractor._childSerializers$_anonymous_$4();
            case 20:
                return ContextExtractor._childSerializers$_anonymous_$5();
            case 21:
                return DeduplicateStrategy._init_$_anonymous_();
            case 22:
                return IdSource._init_$_anonymous_();
            case 23:
                return IdSource.AutoGenerate._init_$_anonymous_();
            case 24:
                return IdSource.FromContext._init_$_anonymous_();
            case 25:
                return IdSource.FromNickname._init_$_anonymous_();
            case 26:
                return IdSource.FromSearch._childSerializers$_anonymous_();
            case 27:
                return MetadataConfig._childSerializers$_anonymous_();
            case 28:
                return MetadataConfig._childSerializers$_anonymous_$0();
            default:
                return MetadataConfig._childSerializers$_anonymous_$1();
        }
        return Long.valueOf(comments$lambda$7);
    }
}
