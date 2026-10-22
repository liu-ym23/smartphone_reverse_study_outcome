package com.bytedanceos.appstore.buss.network;

import com.bytedanceos.appstore.buss.cms.beta.CmsDataWrap;
import com.bytedanceos.appstore.buss.entity.AllRecommendWrap;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.AppPermissionEntity;
import com.bytedanceos.appstore.buss.entity.AppRankEntityWrap;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.appstore.buss.entity.AssistantSearchResultEntityWrap;
import com.bytedanceos.appstore.buss.entity.CategoryEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.GiftAllEntity;
import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import com.bytedanceos.appstore.buss.entity.MyAppNumEntity;
import com.bytedanceos.appstore.buss.entity.SearchAssociateEntityWrap;
import com.bytedanceos.appstore.buss.entity.SearchBannerEntity;
import com.bytedanceos.appstore.buss.entity.SearchResultEntityWrap;
import com.bytedanceos.appstore.buss.entity.TopicWrap;
import com.bytedanceos.appstore.buss.entity.TvSearchRecommendEntityWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCommentsWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppFeedBackEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppGameSubWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.FirstRecommendWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.MyAppsDeleteEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.PushDevAppsEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.SubDetailWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppCheckCommentWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.UpdateEntity;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0086\u0001J\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u0007\u0010\rJ+\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00100\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0014\u0010\u0012J;\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0015\u001a\u00020\tH'¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u001a\u0010\rJ1\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u001d\u0010\rJ'\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000b0\u00030\u00020\u0006H'¢\u0006\u0004\b\u001f\u0010\bJ;\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\tH'¢\u0006\u0004\b#\u0010\u0018J;\u0010%\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\tH'¢\u0006\u0004\b%\u0010\u0018JS\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00030\u00020\u00062\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010&\u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010'\u001a\u00020\u000eH'¢\u0006\u0004\b)\u0010*J1\u0010-\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\tH'¢\u0006\u0004\b-\u0010\rJ5\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00030\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u000e2\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b0\u00101J5\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00030\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u000e2\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b2\u00101J+\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00030\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b4\u0010\rJ5\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00030\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u000e2\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b7\u00101J+\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:0\u00020\u00062\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0004\b<\u0010=JI\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00030\u00020\u00062\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u00105\u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\t2\b\b\u0001\u0010>\u001a\u00020\tH'¢\u0006\u0004\b@\u0010AJ1\u0010B\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\u00030\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\bB\u0010\rJ7\u0010F\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u000bH'¢\u0006\u0004\bF\u0010GJI\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u00030\u00020\u00062\b\b\u0001\u0010H\u001a\u00020\u000e2\b\b\u0001\u0010I\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\tH'¢\u0006\u0004\bK\u0010LJ1\u0010N\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\bN\u0010\rJ?\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\b\b\u0001\u0010H\u001a\u00020\u000e2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010O\u001a\u00020\tH'¢\u0006\u0004\bP\u0010QJ'\u0010R\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u0006H'¢\u0006\u0004\bR\u0010\bJ'\u0010S\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u0006H'¢\u0006\u0004\bS\u0010\bJ1\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020T0\u000bH'¢\u0006\u0004\bU\u0010GJ1\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020T0\u000bH'¢\u0006\u0004\bV\u0010GJ1\u0010W\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\bW\u0010\rJ1\u0010X\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\u00030\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\bX\u0010\rJ1\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\u000e\b\u0001\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u000bH'¢\u0006\u0004\b[\u0010GJE\u0010\\\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH'¢\u0006\u0004\b\\\u0010]J'\u0010^\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\u00030\u00020\u0006H'¢\u0006\u0004\b^\u0010\bJ+\u0010`\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\u00030\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b`\u0010\rJ?\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u00030\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH'¢\u0006\u0004\bb\u0010QJ+\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0004\bc\u0010=J+\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0004\bd\u0010=J+\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\u00030\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u000eH'¢\u0006\u0004\bf\u0010\u0012J+\u0010g\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0004\bg\u0010=J1\u0010i\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\u000b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\bi\u0010\rJ5\u0010k\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010H\u001a\u00020\u000eH'¢\u0006\u0004\bk\u0010lJO\u0010n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010m\u001a\u00020\t2\b\b\u0001\u0010'\u001a\u00020\u000e2\b\b\u0001\u0010+\u001a\u00020\tH'¢\u0006\u0004\bn\u0010oJO\u0010q\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\b\b\u0001\u0010p\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\t2\b\b\u0001\u0010'\u001a\u00020\u000eH'¢\u0006\u0004\bq\u0010rJ1\u0010t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001b0\u00030\u00020\u00062\b\b\u0001\u00109\u001a\u00020sH'¢\u0006\u0004\bt\u0010uJ+\u0010x\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00020\u00062\b\b\u0001\u0010w\u001a\u00020vH'¢\u0006\u0004\bx\u0010yJ+\u0010|\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{0\u00030\u00020\u00062\b\b\u0001\u0010z\u001a\u00020\u000eH'¢\u0006\u0004\b|\u0010\u0012J@\u0010\u007f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~0\u00030\u00020\u00062\b\b\u0001\u0010z\u001a\u00020\u000e2\b\b\u0001\u0010}\u001a\u00020\u000e2\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0005\b\u007f\u0010\u0080\u0001J:\u0010\u0083\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010:0\u00020\u00062\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u000e2\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/StoreService;", "", "Lretrofit2/Response;", "Lcom/bytedanceos/appstore/buss/network/HttpResult;", "getData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "getAllRecommend", "()Lkotlinx/coroutines/Deferred;", "", "source", "", "Lcom/bytedanceos/appstore/buss/entity/AllRecommendWrap;", "(I)Lkotlinx/coroutines/Deferred;", "", "pageId", "Lcom/bytedanceos/appstore/buss/network/CmsHttpResult;", "getCmsPage", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/bytedanceos/appstore/buss/cms/beta/CmsDataWrap;", "getCMSPage", "page_id", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "getPageApps", "(II)Lkotlinx/coroutines/Deferred;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppGameSubWrap;", "getGameSubscribe", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppsWrap;", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", "getMySub", "Lcom/bytedanceos/appstore/buss/entity/AppSubWrap;", "getMySubNotSub", "size", "page", "Lcom/bytedanceos/appstore/buss/entity/GiftAllEntity;", "getAllGift", "Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;", "getMyGift", ServerElements.LAST_APP_ID, "type", "Lcom/bytedanceos/appstore/buss/entity/AppRankEntityWrap;", "getAppRank", "(IIIILjava/lang/String;)Lkotlinx/coroutines/Deferred;", "cid", "Lcom/bytedanceos/appstore/buss/entity/CategoryEntityWrap;", "getAppCategoryList", "packageName", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailWrap;", "getAppDetailInfo", "(Ljava/lang/String;I)Lkotlinx/coroutines/Deferred;", "getAppDetailPInfo", "Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap;", "getSearchRecommend", "kwd", "Lcom/bytedanceos/appstore/buss/entity/SearchAssociateEntityWrap;", "getSearchTip", "Lokhttp3/RequestBody;", "json", "Lcom/bytedanceos/appstore/buss/network/AssistantHttpResult;", "Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntityWrap;", "getSearchAppsForAssistant", "(Lokhttp3/RequestBody;)Lkotlinx/coroutines/Deferred;", "version", "Lcom/bytedanceos/appstore/buss/entity/SearchResultEntityWrap;", "getSearchResult", "(ILjava/lang/String;II)Lkotlinx/coroutines/Deferred;", "getUpdateRecommendAppList", "Lcom/bytedanceos/appstore/buss/entity/netwrap/UpdateEntity;", ServerElements.LIST, "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "getUpdateAppList", "(Ljava/util/List;)Lkotlinx/coroutines/Deferred;", "id", "referer", "Lcom/bytedanceos/appstore/buss/entity/TopicWrap;", "getTopicApps", "(Ljava/lang/String;III)Lkotlinx/coroutines/Deferred;", "Lcom/bytedanceos/appstore/buss/entity/SearchBannerEntity;", "getSearchBanner", "status", "gameSub", "(Ljava/lang/String;II)Lkotlinx/coroutines/Deferred;", "getMyApps", "getMyGames", "Lcom/bytedanceos/appstore/buss/entity/netwrap/MyAppsDeleteEntity;", "deleteMyApps", "deleteMyGames", "getWishCollectAppList", "getWishRecommendAppList", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppCollectEntity;", "wishAppList", "postWishApp", "getSystemUninstalledAppList", "(III)Lkotlinx/coroutines/Deferred;", "getSystemRecommendAppList", "Lcom/bytedanceos/appstore/buss/entity/MyAppNumEntity;", "getMyAppsNum", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppCommentsWrap;", "getAppComments", ServerElements.LIKE, "cancelLike", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentWrap;", "checkComment", "addComment", "Lcom/bytedanceos/appstore/buss/entity/netwrap/FirstRecommendWrap;", "getFirstRecommend", "Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailWrap;", "getSubInfo", "(ILjava/lang/String;)Lkotlinx/coroutines/Deferred;", "pageSource", "getSubInfoRecommend", "(IILjava/lang/String;I)Lkotlinx/coroutines/Deferred;", "categoryId", "getCategorySingleList", "(IIILjava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/PushDevAppsEntity;", "getDevApps", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/PushDevAppsEntity;)Lkotlinx/coroutines/Deferred;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackEntity;", "entity", "postAppFeedBack", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackEntity;)Lkotlinx/coroutines/Deferred;", "appPackageName", "Lcom/bytedanceos/appstore/buss/entity/AppPermissionEntity;", "getAppPermissions", "giftId", "Lcom/bytedanceos/appstore/buss/entity/AppInfoEntity;", "getAppGift", "(Ljava/lang/String;Ljava/lang/String;I)Lkotlinx/coroutines/Deferred;", "url", "Lcom/google/gson/JsonObject;", "post", "(Ljava/lang/String;Lokhttp3/RequestBody;)Lkotlinx/coroutines/Deferred;", "Companion", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface StoreService {

    @NotNull
    public static final String ASSISTANT_URL = "https://platform-api.obriccloud.com";

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String SEARCH_APP_URL = "/api/business/v1/assistant-search/apps";

    @NotNull
    public static final String URL = "";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f8780a = null;

        static {
            f8780a = new a();
        }

        public a() {
        }
    }

    public static final class b {
        public static /* synthetic */ Deferred a(StoreService r10, int r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r11 = 1;
            goto L10
        L8:
            r11 = 2;
        L10:
            return r10.getMyAppsNum(r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyAppsNum");
        }

        public static /* synthetic */ Deferred b(StoreService r10, int r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r11 = 1;
            goto L10
        L8:
            r11 = 2;
        L10:
            return r10.getSearchRecommend(r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSearchRecommend");
        }

        public static /* synthetic */ Deferred c(StoreService r10, String r11, int r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 2) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r12 = 1;
            goto L10
        L8:
            r12 = 2;
        L10:
            return r10.getSearchTip(r11, r12);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSearchTip");
        }

        public static /* synthetic */ Deferred d(StoreService r10, int r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r11 = 1;
            goto L10
        L8:
            r11 = 2;
        L10:
            return r10.getUpdateRecommendAppList(r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUpdateRecommendAppList");
        }

        public static /* synthetic */ Deferred e(StoreService r10, int r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r11 = 1;
            goto L10
        L8:
            r11 = 2;
        L10:
            return r10.getWishCollectAppList(r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWishCollectAppList");
        }

        public static /* synthetic */ Deferred f(StoreService r10, int r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L10;
            if (com.bytedanceos.appstore.utils.d.a() == false) goto L8;
            r11 = 1;
            goto L10
        L8:
            r11 = 2;
        L10:
            return r10.getWishRecommendAppList(r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWishRecommendAppList");
        }
    }

    static {
        Companion = a.f8780a;
    }

    @POST("api/v1_4/app/comment")
    @NotNull
    Deferred<Response<HttpResult<Object>>> addComment(@Body @NotNull RequestBody r10);

    @POST("api/v1_4/like/cancel")
    @NotNull
    Deferred<Response<HttpResult<Object>>> cancelLike(@Body @NotNull RequestBody r10);

    @GET("api/v1_4/app/comment/{packageName}")
    @NotNull
    Deferred<Response<HttpResult<TvAppCheckCommentWrap>>> checkComment(@Path("packageName") @NotNull String r10);

    @POST("api/v1_4/my/app")
    @NotNull
    Deferred<Response<HttpResult<Object>>> deleteMyApps(@Body @NotNull List<MyAppsDeleteEntity> r10);

    @POST("game/my/app")
    @NotNull
    Deferred<Response<HttpResult<Object>>> deleteMyGames(@Body @NotNull List<MyAppsDeleteEntity> r10);

    @GET("appstore/api/v1_5/GameSubcribe/subcribe")
    @NotNull
    Deferred<Response<HttpResult<Object>>> gameSub(@NotNull @Query("id") String r10, @Query("source") int r11, @Query("status") int r12);

    @GET("game/gift/list")
    @NotNull
    Deferred<Response<HttpResult<List<GiftAllEntity>>>> getAllGift(@Query("size") int r10, @Query("page") int r11);

    @POST("appstore/screenapi/recommend/list?page_identity=all_recommend")
    @NotNull
    Deferred<Response<HttpResult<Object>>> getAllRecommend();

    @POST("appstore/api/v1_7/recommend/list")
    @NotNull
    Deferred<Response<HttpResult<List<AllRecommendWrap>>>> getAllRecommend(@Query("source") int r10);

    @GET("appstore/api/v1_5/category/sechome")
    @NotNull
    Deferred<Response<HttpResult<List<CategoryEntityWrap>>>> getAppCategoryList(@Query("cid") int r10);

    @GET("api/v1_4/app/comments/{packageName}")
    @NotNull
    Deferred<Response<HttpResult<AppCommentsWrap>>> getAppComments(@Path("packageName") @NotNull String r10, @Query("page") int r11, @Query("size") int r12);

    @GET("appstore/api/v1_5/app/info")
    @NotNull
    Deferred<Response<HttpResult<TvAppDetailWrap>>> getAppDetailInfo(@NotNull @Query("package") String r10, @Query("source") int r11);

    @GET("appstore/api/v1_5/app/pinfo")
    @NotNull
    Deferred<Response<HttpResult<TvAppDetailWrap>>> getAppDetailPInfo(@NotNull @Query("package") String r10, @Query("source") int r11);

    @FormUrlEncoded
    @POST("game/gift/receive")
    @NotNull
    Deferred<Response<HttpResult<AppInfoEntity>>> getAppGift(@Field("package") @NotNull String r10, @Field("id") @NotNull String r11, @Field("source") int r12);

    @GET("api/v1_4/app/perm/{appPackageName}")
    @NotNull
    Deferred<Response<HttpResult<AppPermissionEntity>>> getAppPermissions(@Path("appPackageName") @NotNull String r10);

    @GET("appstore/api/v1_5/app/topList")
    @NotNull
    Deferred<Response<HttpResult<AppRankEntityWrap>>> getAppRank(@Query("size") int r10, @Query(ServerElements.LAST_APP_ID) int r11, @Query("page") int r12, @Query("source") int r13, @NotNull @Query("type") String r14);

    @POST("appstore/screenapi/page/apps")
    @NotNull
    Deferred<Response<CmsHttpResult<CmsDataWrap>>> getCMSPage(@NotNull @Query("page_id") String r10);

    @GET("api/v1_5/category/apps/{categoryId}")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getCategorySingleList(@Path("categoryId") int r10, @Query("size") int r11, @Query("page") int r12, @NotNull @Query("type") String r13);

    @POST("/appstore/screenapi/recommend/list")
    @NotNull
    Deferred<Response<CmsHttpResult<Object>>> getCmsPage(@NotNull @Query("page_id") String r10);

    @GET("aaaa")
    @Nullable
    Object getData(@NotNull Continuation<? super Response<HttpResult<Object>>> r10);

    @POST("api/v1_4/dev/apps")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getDevApps(@Body @NotNull PushDevAppsEntity r10);

    @GET("appstore/api/v1_6/firstRecommend/list")
    @NotNull
    Deferred<Response<HttpResult<List<FirstRecommendWrap>>>> getFirstRecommend(@Query("source") int r10);

    @GET("appstore/api/v1_6/GameSubcribe/List")
    @NotNull
    Deferred<Response<HttpResult<AppGameSubWrap>>> getGameSubscribe(@Query("source") int r10);

    @GET("api/v1_4/my/bought/apps")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getMyApps();

    @GET("appstore/api/v1_6/app/GetCountForMyapp")
    @NotNull
    Deferred<Response<HttpResult<MyAppNumEntity>>> getMyAppsNum(@Query("source") int r10);

    @GET("/game/my/bought/apps")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getMyGames();

    @GET("game/gift/mygifts")
    @NotNull
    Deferred<Response<HttpResult<List<GiftMyEntity>>>> getMyGift(@Query("size") int r10, @Query("page") int r11);

    @GET("appstore/api/v1_5/GameSubcribe/MySub")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<AppSubEntity>>>> getMySub(@Query("source") int r10);

    @GET("appstore/api/v1_6/AppManager/gamebooking")
    @NotNull
    Deferred<Response<HttpResult<List<AppSubWrap>>>> getMySubNotSub();

    @GET("appstore/api/v1_6/page/apps")
    @NotNull
    Deferred<Response<HttpResult<List<AppEntityWrap>>>> getPageApps(@Query("source") int r10, @Query("page_id") int r11);

    @POST(SEARCH_APP_URL)
    @NotNull
    Deferred<Response<AssistantHttpResult<AssistantSearchResultEntityWrap>>> getSearchAppsForAssistant(@Body @NotNull RequestBody r10);

    @GET("appstore/api/v1_5/search/SuggestWords")
    @NotNull
    Deferred<Response<HttpResult<List<SearchBannerEntity>>>> getSearchBanner(@Query("source") int r10);

    @GET("appstore/api/v1_5/search/SearchRecommendApps")
    @NotNull
    Deferred<Response<HttpResult<TvSearchRecommendEntityWrap>>> getSearchRecommend(@Query("source") int r10);

    @GET("appstore/api/v1_6/search/psearch")
    @NotNull
    Deferred<Response<HttpResult<SearchResultEntityWrap>>> getSearchResult(@Query("size") int r10, @NotNull @Query("kwd") String r11, @Query("page") int r12, @Query("version") int r13);

    @GET("appstore/api/v1_6/search/keyword")
    @NotNull
    Deferred<Response<HttpResult<SearchAssociateEntityWrap>>> getSearchTip(@NotNull @Query("kwd") String r10, @Query("source") int r11);

    @GET("appstore/api/v1_5/GameSubcribe/Info")
    @NotNull
    Deferred<Response<HttpResult<SubDetailWrap>>> getSubInfo(@Query("source") int r10, @NotNull @Query("id") String r11);

    @GET("appstore/api/v1_5/category/apps")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getSubInfoRecommend(@Query("source") int r10, @Query(NetKey.PAGE_SOURCE) int r11, @NotNull @Query("type") String r12, @Query("cid") int r13);

    @GET("appstore/api/v1_6/AppManager/recommend")
    @NotNull
    Deferred<Response<HttpResult<List<AppEntityWrap>>>> getSystemRecommendAppList();

    @GET("api/v1_4/category/apps/122")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getSystemUninstalledAppList(@Query("source") int r10, @Query("page") int r11, @Query("size") int r12);

    @GET("api/v1_4/topic/apps/{id}")
    @NotNull
    Deferred<Response<HttpResult<TopicWrap>>> getTopicApps(@Path("id") @NotNull String r10, @Query("referer") int r11, @Query("size") int r12, @Query("page") int r13);

    @POST("/api/v1_5/update/apps")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getUpdateAppList(@Body @NotNull List<UpdateEntity> r10);

    @GET("appstore/api/v1_6/AppManager/Updatable")
    @NotNull
    Deferred<Response<HttpResult<List<AppEntityWrap>>>> getUpdateRecommendAppList(@Query("source") int r10);

    @GET("appstore/api/v1_7/collect/list")
    @NotNull
    Deferred<Response<HttpResult<AppsWrap<CommonAppEntity>>>> getWishCollectAppList(@Query("source") int r10);

    @GET("appstore/api/v1_6/AppManager/wish")
    @NotNull
    Deferred<Response<HttpResult<List<AppEntityWrap>>>> getWishRecommendAppList(@Query("source") int r10);

    @POST("api/v1_4/app/like")
    @NotNull
    Deferred<Response<HttpResult<Object>>> like(@Body @NotNull RequestBody r10);

    @POST
    @NotNull
    Deferred<Response<AssistantHttpResult<JsonObject>>> post(@Url @NotNull String r10, @Body @NotNull RequestBody r11);

    @POST("api/v1_4/feedback/add")
    @NotNull
    Deferred<Response<HttpResult<Object>>> postAppFeedBack(@Body @NotNull AppFeedBackEntity r10);

    @POST("api/v1_4/my/collect")
    @NotNull
    Deferred<Response<HttpResult<Object>>> postWishApp(@Body @NotNull List<AppCollectEntity> r10);
}
